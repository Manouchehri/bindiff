package org.ibex.nestedvm;

import org.ibex.nestedvm.util.*;
import java.io.*;

public abstract class Runtime implements Cloneable, Registers, UsermodeConstants
{
    public static final String VERSION = "1.0";
    static final boolean STDERR_DIAG = true;
    protected final int pageShift;
    private final int stackBottom;
    protected int[][] readPages;
    protected int[][] writePages;
    private int heapEnd;
    private static final int STACK_GUARD_PAGES = 4;
    private long startTime;
    public static final int RUNNING = 0;
    public static final int STOPPED = 1;
    public static final int PAUSED = 2;
    public static final int CALLJAVA = 3;
    public static final int EXITED = 4;
    public static final int EXECED = 5;
    protected int state;
    private int exitStatus;
    public Runtime$ExecutionException exitException;
    Runtime$FD[] fds;
    boolean[] closeOnExec;
    Runtime$SecurityManager sm;
    private Runtime$CallJavaCB callJavaCB;
    private byte[] _byteBuf;
    static final int MAX_CHUNK = 16776192;
    static final boolean win32Hacks;
    public static final int RD_ONLY = 0;
    public static final int WR_ONLY = 1;
    public static final int RDWR = 2;
    public static final int O_CREAT = 512;
    public static final int O_EXCL = 2048;
    public static final int O_APPEND = 8;
    public static final int O_TRUNC = 1024;
    public static final int O_NONBLOCK = 16384;
    public static final int O_NOCTTY = 32768;
    
    protected abstract int heapStart();
    
    protected abstract int entryPoint();
    
    protected int userInfoBase() {
        return 0;
    }
    
    protected int userInfoSize() {
        return 0;
    }
    
    protected abstract int gp();
    
    public final int getState() {
        return this.state;
    }
    
    public void setSecurityManager(final Runtime$SecurityManager sm) {
        this.sm = sm;
    }
    
    public void setCallJavaCB(final Runtime$CallJavaCB callJavaCB) {
        this.callJavaCB = callJavaCB;
    }
    
    protected abstract void _execute();
    
    public int lookupSymbol(final String s) {
        return -1;
    }
    
    protected abstract void getCPUState(final Runtime$CPUState p0);
    
    protected abstract void setCPUState(final Runtime$CPUState p0);
    
    protected Object clone() {
        final Runtime runtime = (Runtime)super.clone();
        runtime._byteBuf = null;
        runtime.startTime = 0L;
        runtime.fds = new Runtime$FD[64];
        for (int i = 0; i < 64; ++i) {
            if (this.fds[i] != null) {
                runtime.fds[i] = this.fds[i].dup();
            }
        }
        final int length = this.writePages.length;
        runtime.readPages = new int[length][];
        runtime.writePages = new int[length][];
        for (int j = 0; j < length; ++j) {
            if (this.readPages[j] != null) {
                if (this.writePages[j] == null) {
                    runtime.readPages[j] = this.readPages[j];
                }
                else {
                    runtime.readPages[j] = (runtime.writePages[j] = this.writePages[j].clone());
                }
            }
        }
        return runtime;
    }
    
    protected Runtime(final int n, final int n2) {
        this(n, n2, false);
    }
    
    protected Runtime(final int n, final int n2, final boolean b) {
        this.state = 1;
        if (n <= 0) {
            throw new IllegalArgumentException("pageSize <= 0");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("totalPages <= 0");
        }
        if ((n & n - 1) != 0x0) {
            throw new IllegalArgumentException("pageSize not a power of two");
        }
        int pageShift;
        for (pageShift = 0; n >>> pageShift != 1; ++pageShift) {}
        this.pageShift = pageShift;
        final int heapStart = this.heapStart();
        final int n3 = n2 * n;
        int max = max(n3 / 512, 131072);
        int heapEnd;
        if (n2 > 1) {
            max = (max(max, n) + n - 1 & ~(n - 1));
            final int n4 = max >>> this.pageShift;
            heapEnd = (heapStart + n - 1 & ~(n - 1));
            if (n4 + 4 + (heapEnd >>> this.pageShift) >= n2) {
                throw new IllegalArgumentException("total pages too small");
            }
        }
        else {
            if (n < heapStart + max) {
                throw new IllegalArgumentException("total memory too small");
            }
            heapEnd = (heapStart + 4095 & 0xFFFFEFFF);
        }
        this.stackBottom = n3 - max;
        this.heapEnd = heapEnd;
        this.readPages = new int[n2][];
        this.writePages = new int[n2][];
        if (n2 == 1) {
            this.readPages[0] = (this.writePages[0] = new int[n >> 2]);
        }
        else {
            for (int i = this.stackBottom >>> this.pageShift; i < this.writePages.length; ++i) {
                this.readPages[i] = (this.writePages[i] = new int[n >> 2]);
            }
        }
        if (!b) {
            this.fds = new Runtime$FD[64];
            this.closeOnExec = new boolean[64];
            this.addFD(new Runtime$TerminalFD(Runtime.win32Hacks ? new Runtime$Win32ConsoleIS(System.in) : System.in));
            this.addFD(new Runtime$TerminalFD(System.out));
            this.addFD(new Runtime$TerminalFD(System.err));
        }
    }
    
    protected final void initPages(final int[] array, int n, final boolean b) {
        final int n2 = 1 << this.pageShift >>> 2;
        final int n3 = (1 << this.pageShift) - 1;
        int min;
        for (int i = 0; i < array.length; i += min, n += min * 4) {
            final int n4 = n >>> this.pageShift;
            final int n5 = (n & n3) >> 2;
            min = min(n2 - n5, array.length - i);
            if (this.readPages[n4] == null) {
                this.initPage(n4, b);
            }
            else if (!b && this.writePages[n4] == null) {
                this.writePages[n4] = this.readPages[n4];
            }
            System.arraycopy(array, i, this.readPages[n4], n5, min);
        }
    }
    
    protected final void clearPages(int n, final int n2) {
        final int n3 = 1 << this.pageShift >>> 2;
        final int n4 = (1 << this.pageShift) - 1;
        int min;
        for (int i = 0; i < n2; i += min, n += min * 4) {
            final int n5 = n >>> this.pageShift;
            final int n6 = (n & n4) >> 2;
            min = min(n3 - n6, n2 - i);
            if (this.readPages[n5] == null) {
                this.readPages[n5] = (this.writePages[n5] = new int[n3]);
            }
            else {
                if (this.writePages[n5] == null) {
                    this.writePages[n5] = this.readPages[n5];
                }
                for (int j = n6; j < n6 + min; ++j) {
                    this.writePages[n5][j] = 0;
                }
            }
        }
    }
    
    public final void copyin(int n, final byte[] array, int n2) {
        final int n3 = 1 << this.pageShift >>> 2;
        final int n4 = n3 - 1;
        int n5 = 0;
        if (n2 == 0) {
            return;
        }
        if ((n & 0x3) != 0x0) {
            final int memRead = this.memRead(n & 0xFFFFFFFC);
            switch (n & 0x3) {
                case 1: {
                    array[n5++] = (byte)(memRead >>> 16 & 0xFF);
                    if (--n2 == 0) {
                        break;
                    }
                }
                case 2: {
                    array[n5++] = (byte)(memRead >>> 8 & 0xFF);
                    if (--n2 == 0) {
                        break;
                    }
                }
                case 3: {
                    array[n5++] = (byte)(memRead >>> 0 & 0xFF);
                    if (--n2 == 0) {}
                    break;
                }
            }
            n = (n & 0xFFFFFFFC) + 4;
        }
        if ((n2 & 0xFFFFFFFC) != 0x0) {
            int i = n2 >>> 2;
            int n6 = n >>> 2;
            while (i != 0) {
                final int[] array2 = this.readPages[n6 >>> this.pageShift - 2];
                if (array2 == null) {
                    throw new Runtime$ReadFaultException(n6 << 2);
                }
                final int n7 = n6 & n4;
                final int min = min(i, n3 - n7);
                for (int j = 0; j < min; ++j, n5 += 4) {
                    final int n8 = array2[n7 + j];
                    array[n5 + 0] = (byte)(n8 >>> 24 & 0xFF);
                    array[n5 + 1] = (byte)(n8 >>> 16 & 0xFF);
                    array[n5 + 2] = (byte)(n8 >>> 8 & 0xFF);
                    array[n5 + 3] = (byte)(n8 >>> 0 & 0xFF);
                }
                n6 += min;
                i -= min;
            }
            n = n6 << 2;
            n2 &= 0x3;
        }
        if (n2 != 0) {
            final int memRead2 = this.memRead(n);
            switch (n2) {
                case 3: {
                    array[n5 + 2] = (byte)(memRead2 >>> 8 & 0xFF);
                }
                case 2: {
                    array[n5 + 1] = (byte)(memRead2 >>> 16 & 0xFF);
                }
                case 1: {
                    array[n5 + 0] = (byte)(memRead2 >>> 24 & 0xFF);
                    break;
                }
            }
        }
    }
    
    public final void copyout(final byte[] array, int n, int n2) {
        final int n3 = 1 << this.pageShift >>> 2;
        final int n4 = n3 - 1;
        int n5 = 0;
        if (n2 == 0) {
            return;
        }
        if ((n & 0x3) != 0x0) {
            int memRead = this.memRead(n & 0xFFFFFFFC);
            switch (n & 0x3) {
                case 1: {
                    memRead = ((memRead & 0xFF00FFFF) | (array[n5++] & 0xFF) << 16);
                    if (--n2 == 0) {
                        break;
                    }
                }
                case 2: {
                    memRead = ((memRead & 0xFFFF00FF) | (array[n5++] & 0xFF) << 8);
                    if (--n2 == 0) {
                        break;
                    }
                }
                case 3: {
                    memRead = ((memRead & 0xFFFFFF00) | (array[n5++] & 0xFF) << 0);
                    if (--n2 == 0) {}
                    break;
                }
            }
            this.memWrite(n & 0xFFFFFFFC, memRead);
            n += n5;
        }
        if ((n2 & 0xFFFFFFFC) != 0x0) {
            int i = n2 >>> 2;
            int n6 = n >>> 2;
            while (i != 0) {
                final int[] array2 = this.writePages[n6 >>> this.pageShift - 2];
                if (array2 == null) {
                    throw new Runtime$WriteFaultException(n6 << 2);
                }
                final int n7 = n6 & n4;
                final int min = min(i, n3 - n7);
                for (int j = 0; j < min; ++j, n5 += 4) {
                    array2[n7 + j] = ((array[n5 + 0] & 0xFF) << 24 | (array[n5 + 1] & 0xFF) << 16 | (array[n5 + 2] & 0xFF) << 8 | (array[n5 + 3] & 0xFF) << 0);
                }
                n6 += min;
                i -= min;
            }
            n = n6 << 2;
            n2 &= 0x3;
        }
        if (n2 != 0) {
            int memRead2 = this.memRead(n);
            switch (n2) {
                case 1: {
                    memRead2 = ((memRead2 & 0xFFFFFF) | (array[n5 + 0] & 0xFF) << 24);
                    break;
                }
                case 2: {
                    memRead2 = ((memRead2 & 0xFFFF) | (array[n5 + 0] & 0xFF) << 24 | (array[n5 + 1] & 0xFF) << 16);
                    break;
                }
                case 3: {
                    memRead2 = ((memRead2 & 0xFF) | (array[n5 + 0] & 0xFF) << 24 | (array[n5 + 1] & 0xFF) << 16 | (array[n5 + 2] & 0xFF) << 8);
                    break;
                }
            }
            this.memWrite(n, memRead2);
        }
    }
    
    public final void memcpy(int n, int n2, int i) {
        final int n3 = 1 << this.pageShift >>> 2;
        final int n4 = n3 - 1;
        if ((n & 0x3) == 0x0 && (n2 & 0x3) == 0x0) {
            if ((i & 0xFFFFFFFC) != 0x0) {
                int j = i >> 2;
                int n5 = n2 >>> 2;
                int n6 = n >>> 2;
                while (j != 0) {
                    final int[] array = this.readPages[n5 >>> this.pageShift - 2];
                    if (array == null) {
                        throw new Runtime$ReadFaultException(n5 << 2);
                    }
                    final int[] array2 = this.writePages[n6 >>> this.pageShift - 2];
                    if (array2 == null) {
                        throw new Runtime$WriteFaultException(n6 << 2);
                    }
                    final int n7 = n5 & n4;
                    final int n8 = n6 & n4;
                    final int min = min(j, n3 - max(n7, n8));
                    System.arraycopy(array, n7, array2, n8, min);
                    n5 += min;
                    n6 += min;
                    j -= min;
                }
                n2 = n5 << 2;
                n = n6 << 2;
                i &= 0x3;
            }
            if (i != 0) {
                final int memRead = this.memRead(n2);
                final int memRead2 = this.memRead(n);
                switch (i) {
                    case 1: {
                        this.memWrite(n, (memRead & 0xFF000000) | (memRead2 & 0xFFFFFF));
                        break;
                    }
                    case 2: {
                        this.memWrite(n, (memRead & 0xFFFF0000) | (memRead2 & 0xFFFF));
                        break;
                    }
                    case 3: {
                        this.memWrite(n, (memRead & 0xFFFFFF00) | (memRead2 & 0xFF));
                        break;
                    }
                }
            }
        }
        else {
            while (i > 0) {
                final int min2 = min(i, 16776192);
                final byte[] byteBuf = this.byteBuf(min2);
                this.copyin(n2, byteBuf, min2);
                this.copyout(byteBuf, n, min2);
                i -= min2;
                n2 += min2;
                n += min2;
            }
        }
    }
    
    public final void memset(int n, final int n2, int n3) {
        final int n4 = 1 << this.pageShift >>> 2;
        final int n5 = n4 - 1;
        final int n6 = (n2 & 0xFF) << 24 | (n2 & 0xFF) << 16 | (n2 & 0xFF) << 8 | (n2 & 0xFF) << 0;
        if ((n & 0x3) != 0x0) {
            int memRead = this.memRead(n & 0xFFFFFFFC);
            switch (n & 0x3) {
                case 1: {
                    memRead = ((memRead & 0xFF00FFFF) | (n2 & 0xFF) << 16);
                    if (--n3 == 0) {
                        break;
                    }
                }
                case 2: {
                    memRead = ((memRead & 0xFFFF00FF) | (n2 & 0xFF) << 8);
                    if (--n3 == 0) {
                        break;
                    }
                }
                case 3: {
                    memRead = ((memRead & 0xFFFFFF00) | (n2 & 0xFF) << 0);
                    if (--n3 == 0) {}
                    break;
                }
            }
            this.memWrite(n & 0xFFFFFFFC, memRead);
            n = (n & 0xFFFFFFFC) + 4;
        }
        if ((n3 & 0xFFFFFFFC) != 0x0) {
            int i = n3 >> 2;
            int n7 = n >>> 2;
            while (i != 0) {
                final int[] array = this.readPages[n7 >>> this.pageShift - 2];
                if (array == null) {
                    throw new Runtime$WriteFaultException(n7 << 2);
                }
                final int n8 = n7 & n5;
                final int min = min(i, n4 - n8);
                for (int j = n8; j < n8 + min; ++j) {
                    array[j] = n6;
                }
                n7 += min;
                i -= min;
            }
            n = n7 << 2;
            n3 &= 0x3;
        }
        if (n3 != 0) {
            int memRead2 = this.memRead(n);
            switch (n3) {
                case 1: {
                    memRead2 = ((memRead2 & 0xFFFFFF) | (n6 & 0xFF000000));
                    break;
                }
                case 2: {
                    memRead2 = ((memRead2 & 0xFFFF) | (n6 & 0xFFFF0000));
                    break;
                }
                case 3: {
                    memRead2 = ((memRead2 & 0xFF) | (n6 & 0xFFFFFF00));
                    break;
                }
            }
            this.memWrite(n, memRead2);
        }
    }
    
    public final int memRead(final int n) {
        if ((n & 0x3) != 0x0) {
            throw new Runtime$ReadFaultException(n);
        }
        return this.unsafeMemRead(n);
    }
    
    protected final int unsafeMemRead(final int n) {
        final int n2 = n >>> this.pageShift;
        final int n3 = (n & (1 << this.pageShift) - 1) >> 2;
        try {
            return this.readPages[n2][n3];
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            if (n2 < 0 || n2 >= this.readPages.length) {
                throw new Runtime$ReadFaultException(n);
            }
            throw ex;
        }
        catch (NullPointerException ex2) {
            throw new Runtime$ReadFaultException(n);
        }
    }
    
    public final void memWrite(final int n, final int n2) {
        if ((n & 0x3) != 0x0) {
            throw new Runtime$WriteFaultException(n);
        }
        this.unsafeMemWrite(n, n2);
    }
    
    protected final void unsafeMemWrite(final int n, final int n2) {
        final int n3 = n >>> this.pageShift;
        final int n4 = (n & (1 << this.pageShift) - 1) >> 2;
        try {
            this.writePages[n3][n4] = n2;
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            if (n3 < 0 || n3 >= this.writePages.length) {
                throw new Runtime$WriteFaultException(n);
            }
            throw ex;
        }
        catch (NullPointerException ex2) {
            throw new Runtime$WriteFaultException(n);
        }
    }
    
    private final int[] initPage(final int n) {
        return this.initPage(n, false);
    }
    
    private final int[] initPage(final int n, final boolean b) {
        final int[] array = new int[1 << this.pageShift >>> 2];
        this.writePages[n] = (int[])(b ? null : array);
        return this.readPages[n] = array;
    }
    
    public final int exitStatus() {
        if (this.state != 4) {
            throw new IllegalStateException("exitStatus() called in an inappropriate state");
        }
        return this.exitStatus;
    }
    
    private int addStringArray(final String[] array, final int n) {
        final int length = array.length;
        int n2 = 0;
        for (int i = 0; i < length; ++i) {
            n2 += array[i].length() + 1;
        }
        final int n3 = n - (n2 + (length + 1) * 4) & 0xFFFFFFFC;
        int n4 = n3 + (length + 1) * 4;
        final int[] array2 = new int[length + 1];
        try {
            for (int j = 0; j < length; ++j) {
                final byte[] bytes = getBytes(array[j]);
                this.copyout(bytes, array2[j] = n4, bytes.length);
                this.memset(n4 + bytes.length, 0, 1);
                n4 += bytes.length + 1;
            }
            int n5 = n3;
            for (int k = 0; k < length + 1; ++k) {
                this.memWrite(n5, array2[k]);
                n5 += 4;
            }
        }
        catch (Runtime$FaultException ex) {
            throw new RuntimeException(ex.toString());
        }
        return n3;
    }
    
    String[] createEnv(String[] array) {
        if (array == null) {
            array = new String[0];
        }
        return array;
    }
    
    public void setUserInfo(final int n, final int n2) {
        if (n < 0 || n >= this.userInfoSize() / 4) {
            throw new IndexOutOfBoundsException("setUserInfo called with index >= " + this.userInfoSize() / 4);
        }
        try {
            this.memWrite(this.userInfoBase() + n * 4, n2);
        }
        catch (Runtime$FaultException ex) {
            throw new RuntimeException(ex.toString());
        }
    }
    
    public int getUserInfo(final int n) {
        if (n < 0 || n >= this.userInfoSize() / 4) {
            throw new IndexOutOfBoundsException("setUserInfo called with index >= " + this.userInfoSize() / 4);
        }
        try {
            return this.memRead(this.userInfoBase() + n * 4);
        }
        catch (Runtime$FaultException ex) {
            throw new RuntimeException(ex.toString());
        }
    }
    
    private void __execute() {
        try {
            this._execute();
        }
        catch (Runtime$FaultException exitException) {
            exitException.printStackTrace();
            this.exit(139, true);
            this.exitException = exitException;
        }
        catch (Runtime$ExecutionException exitException2) {
            exitException2.printStackTrace();
            this.exit(132, true);
            this.exitException = exitException2;
        }
    }
    
    public final boolean execute() {
        if (this.state != 2) {
            throw new IllegalStateException("execute() called in inappropriate state");
        }
        if (this.startTime == 0L) {
            this.startTime = System.currentTimeMillis();
        }
        this.state = 0;
        this.__execute();
        if (this.state != 2 && this.state != 4 && this.state != 5) {
            throw new IllegalStateException("execute() ended up in an inappropriate state (" + this.state + ")");
        }
        return this.state != 2;
    }
    
    static String[] concatArgv(final String s, final String[] array) {
        final String[] array2 = new String[array.length + 1];
        System.arraycopy(array, 0, array2, 1, array.length);
        array2[0] = s;
        return array2;
    }
    
    public final int run() {
        return this.run(null);
    }
    
    public final int run(final String s, final String[] array) {
        return this.run(concatArgv(s, array));
    }
    
    public final int run(final String[] array) {
        return this.run(array, null);
    }
    
    public final int run(final String[] array, final String[] array2) {
        this.start(array, array2);
        while (!this.execute()) {
            System.err.println("WARNING: Pause requested while executing run()");
        }
        if (this.state == 5) {
            System.err.println("WARNING: Process exec()ed while being run under run()");
        }
        return (this.state == 4) ? this.exitStatus() : 0;
    }
    
    public final void start() {
        this.start(null);
    }
    
    public final void start(final String[] array) {
        this.start(array, null);
    }
    
    public final void start(String[] array, final String[] array2) {
        if (this.state != 1) {
            throw new IllegalStateException("start() called in inappropriate state");
        }
        if (array == null) {
            array = new String[] { this.getClass().getName() };
        }
        final int n = this.writePages.length * (1 << this.pageShift);
        int addStringArray2;
        int addStringArray;
        try {
            addStringArray = this.addStringArray(this.createEnv(array2), addStringArray2 = this.addStringArray(array, n));
        }
        catch (Runtime$FaultException ex) {
            throw new IllegalArgumentException("args/environ too big");
        }
        final int n2 = addStringArray & 0xFFFFFFF0;
        if (n - n2 > 65536) {
            throw new IllegalArgumentException("args/environ too big");
        }
        if (this.heapEnd == 0) {
            this.heapEnd = this.heapStart();
            if (this.heapEnd == 0) {
                throw new Error("heapEnd == 0");
            }
            final int n3 = (this.writePages.length == 1) ? 4096 : (1 << this.pageShift);
            this.heapEnd = (this.heapEnd + n3 - 1 & ~(n3 - 1));
        }
        final Runtime$CPUState cpuState = new Runtime$CPUState();
        cpuState.r[4] = addStringArray2;
        cpuState.r[5] = addStringArray;
        cpuState.r[29] = n2;
        cpuState.r[31] = -559038737;
        cpuState.r[28] = this.gp();
        cpuState.pc = this.entryPoint();
        this.setCPUState(cpuState);
        this.state = 2;
        this._started();
    }
    
    public final void stop() {
        if (this.state != 0 && this.state != 2) {
            throw new IllegalStateException("stop() called in inappropriate state");
        }
        this.exit(0, false);
    }
    
    void _started() {
    }
    
    public final int call(final String s, final Object[] array) {
        if (this.state != 2 && this.state != 3) {
            throw new IllegalStateException("call() called in inappropriate state");
        }
        if (array.length > 7) {
            throw new IllegalArgumentException("args.length > 7");
        }
        final Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        this.getCPUState(runtime$CPUState);
        int n = runtime$CPUState.r[29];
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            final Object o = array[i];
            byte[] bytes = null;
            if (o instanceof String) {
                bytes = getBytes((String)o);
            }
            else if (o instanceof byte[]) {
                bytes = (byte[])o;
            }
            else if (o instanceof Number) {
                array2[i] = ((Number)o).intValue();
            }
            if (bytes != null) {
                n -= bytes.length;
                this.copyout(bytes, n, bytes.length);
                array2[i] = n;
            }
        }
        final int n2 = runtime$CPUState.r[29];
        if (n2 == n) {
            return this.call(s, array2);
        }
        runtime$CPUState.r[29] = n;
        this.setCPUState(runtime$CPUState);
        final int call = this.call(s, array2);
        runtime$CPUState.r[29] = n2;
        this.setCPUState(runtime$CPUState);
        return call;
    }
    
    public final int call(final String s) {
        return this.call(s, new int[0]);
    }
    
    public final int call(final String s, final int n) {
        return this.call(s, new int[] { n });
    }
    
    public final int call(final String s, final int n, final int n2) {
        return this.call(s, new int[] { n, n2 });
    }
    
    public final int call(final String s, final int[] array) {
        final int lookupSymbol = this.lookupSymbol(s);
        if (lookupSymbol == -1) {
            throw new Runtime$CallException(s + " not found");
        }
        final int lookupSymbol2 = this.lookupSymbol("_call_helper");
        if (lookupSymbol2 == -1) {
            throw new Runtime$CallException("_call_helper not found");
        }
        return this.call(lookupSymbol2, lookupSymbol, array);
    }
    
    public final int call(final int pc, final int n, final int[] array) {
        if (array.length > 7) {
            throw new IllegalArgumentException("rest.length > 7");
        }
        if (this.state != 2 && this.state != 3) {
            throw new IllegalStateException("call() called in inappropriate state");
        }
        final int state = this.state;
        final Runtime$CPUState cpuState = new Runtime$CPUState();
        this.getCPUState(cpuState);
        final Runtime$CPUState dup = cpuState.dup();
        dup.r[29] &= 0xFFFFFFF0;
        dup.r[31] = -559038737;
        dup.r[4] = n;
        switch (array.length) {
            case 7: {
                dup.r[19] = array[6];
            }
            case 6: {
                dup.r[18] = array[5];
            }
            case 5: {
                dup.r[17] = array[4];
            }
            case 4: {
                dup.r[16] = array[3];
            }
            case 3: {
                dup.r[7] = array[2];
            }
            case 2: {
                dup.r[6] = array[1];
            }
            case 1: {
                dup.r[5] = array[0];
                break;
            }
        }
        dup.pc = pc;
        this.state = 0;
        this.setCPUState(dup);
        this.__execute();
        this.getCPUState(dup);
        this.setCPUState(cpuState);
        if (this.state != 2) {
            throw new Runtime$CallException("Process exit()ed while servicing a call() request");
        }
        this.state = state;
        return dup.r[3];
    }
    
    public final int addFD(final Runtime$FD runtime$FD) {
        if (this.state == 4 || this.state == 5) {
            throw new IllegalStateException("addFD called in inappropriate state");
        }
        int n;
        for (n = 0; n < 64 && this.fds[n] != null; ++n) {}
        if (n == 64) {
            return -1;
        }
        this.fds[n] = runtime$FD;
        this.closeOnExec[n] = false;
        return n;
    }
    
    void _preCloseFD(final Runtime$FD runtime$FD) {
    }
    
    void _postCloseFD(final Runtime$FD runtime$FD) {
    }
    
    public final boolean closeFD(final int n) {
        if (this.state == 4 || this.state == 5) {
            throw new IllegalStateException("closeFD called in inappropriate state");
        }
        if (n < 0 || n >= 64) {
            return false;
        }
        if (this.fds[n] == null) {
            return false;
        }
        this._preCloseFD(this.fds[n]);
        this.fds[n].close();
        this._postCloseFD(this.fds[n]);
        this.fds[n] = null;
        return true;
    }
    
    public final int dupFD(final int n) {
        if (n < 0 || n >= 64) {
            return -1;
        }
        if (this.fds[n] == null) {
            return -1;
        }
        int n2;
        for (n2 = 0; n2 < 64 && this.fds[n2] != null; ++n2) {}
        if (n2 == 64) {
            return -1;
        }
        this.fds[n2] = this.fds[n].dup();
        return n2;
    }
    
    Runtime$FD hostFSOpen(final File file, final int n, final int n2, final Object o) {
        if ((n & 0xFFFFF1F4) != 0x0) {
            System.err.println("WARNING: Unsupported flags passed to open(\"" + file + "\"): " + toHex(n & 0xFFFFF1F4));
            throw new Runtime$ErrnoException(134);
        }
        final boolean b = (n & 0x3) != 0x0;
        Label_0122: {
            if (this.sm != null) {
                if (b) {
                    if (this.sm.allowWrite(file)) {
                        break Label_0122;
                    }
                }
                else if (this.sm.allowRead(file)) {
                    break Label_0122;
                }
                throw new Runtime$ErrnoException(13);
            }
        }
        Seekable$File seekable$File = null;
        Label_0196: {
            if ((n & 0xA00) == 0xA00) {
                try {
                    if (!Platform.atomicCreateFile(file)) {
                        throw new Runtime$ErrnoException(17);
                    }
                    break Label_0196;
                }
                catch (IOException ex2) {
                    throw new Runtime$ErrnoException(5);
                }
            }
            if (!file.exists()) {
                if ((n & 0x200) == 0x0) {
                    return null;
                }
            }
            else if (file.isDirectory()) {
                return this.hostFSDirFD(file, o);
            }
            try {
                seekable$File = new Seekable$File(file, b, (n & 0x400) != 0x0);
            }
            catch (FileNotFoundException ex) {
                if (ex.getMessage() != null && ex.getMessage().indexOf("Permission denied") >= 0) {
                    throw new Runtime$ErrnoException(13);
                }
                return null;
            }
            catch (IOException ex3) {
                throw new Runtime$ErrnoException(5);
            }
        }
        return new Runtime$1(this, seekable$File, n, file, seekable$File, o);
    }
    
    Runtime$FStat hostFStat(final File file, final Seekable$File seekable$File, final Object o) {
        return new Runtime$HostFStat(file, seekable$File);
    }
    
    Runtime$FD hostFSDirFD(final File file, final Object o) {
        return null;
    }
    
    Runtime$FD _open(final String s, final int n, final int n2) {
        return this.hostFSOpen(new File(s), n, n2, null);
    }
    
    private int sys_open(final int n, int n2, final int n3) {
        String s = this.cstring(n);
        if (s.length() == 1024 && this.getClass().getName().equals("tests.TeX")) {
            s = s.trim();
        }
        n2 &= 0xFFFF7FFF;
        final Runtime$FD open = this._open(s, n2, n3);
        if (open == null) {
            return -2;
        }
        final int addFD = this.addFD(open);
        if (addFD == -1) {
            open.close();
            return -23;
        }
        return addFD;
    }
    
    private int sys_write(final int n, final int n2, int min) {
        min = Math.min(min, 16776192);
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final byte[] byteBuf = this.byteBuf(min);
        this.copyin(n2, byteBuf, min);
        try {
            return this.fds[n].write(byteBuf, 0, min);
        }
        catch (Runtime$ErrnoException ex) {
            if (ex.errno == 32) {
                this.sys_exit(141);
            }
            throw ex;
        }
    }
    
    private int sys_read(final int n, final int n2, int min) {
        min = Math.min(min, 16776192);
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final byte[] byteBuf = this.byteBuf(min);
        final int read = this.fds[n].read(byteBuf, 0, min);
        this.copyout(byteBuf, n2, read);
        return read;
    }
    
    private int sys_ftruncate(final int n, final long n2) {
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final Seekable seekable = this.fds[n].seekable();
        if (n2 < 0L || seekable == null) {
            return -22;
        }
        try {
            seekable.resize(n2);
        }
        catch (IOException ex) {
            return -5;
        }
        return 0;
    }
    
    private int sys_close(final int n) {
        return this.closeFD(n) ? 0 : -81;
    }
    
    private int sys_lseek(final int n, final int n2, final int n3) {
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        if (n3 != 0 && n3 != 1 && n3 != 2) {
            return -22;
        }
        final int seek = this.fds[n].seek(n2, n3);
        return (seek < 0) ? -29 : seek;
    }
    
    int stat(final Runtime$FStat runtime$FStat, final int n) {
        this.memWrite(n + 0, runtime$FStat.dev() << 16 | (runtime$FStat.inode() & 0xFFFF));
        this.memWrite(n + 4, (runtime$FStat.type() & 0xF000) | (runtime$FStat.mode() & 0xFFF));
        this.memWrite(n + 8, runtime$FStat.nlink() << 16 | (runtime$FStat.uid() & 0xFFFF));
        this.memWrite(n + 12, runtime$FStat.gid() << 16 | 0x0);
        this.memWrite(n + 16, runtime$FStat.size());
        this.memWrite(n + 20, runtime$FStat.atime());
        this.memWrite(n + 28, runtime$FStat.mtime());
        this.memWrite(n + 36, runtime$FStat.ctime());
        this.memWrite(n + 44, runtime$FStat.blksize());
        this.memWrite(n + 48, runtime$FStat.blocks());
        return 0;
    }
    
    private int sys_fstat(final int n, final int n2) {
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        return this.stat(this.fds[n].fstat(), n2);
    }
    
    private int sys_gettimeofday(final int n, final int n2) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int n3 = (int)(currentTimeMillis / 1000L);
        final int n4 = (int)(currentTimeMillis % 1000L * 1000L);
        this.memWrite(n + 0, n3);
        this.memWrite(n + 4, n4);
        return 0;
    }
    
    private int sys_sleep(int n) {
        if (n < 0) {
            n = Integer.MAX_VALUE;
        }
        try {
            Thread.sleep(n * 1000L);
            return 0;
        }
        catch (InterruptedException ex) {
            return -1;
        }
    }
    
    private int sys_times(final int n) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int n2 = (int)((currentTimeMillis - this.startTime) / 16L);
        final int n3 = (int)((currentTimeMillis - this.startTime) / 16L);
        try {
            if (n != 0) {
                this.memWrite(n + 0, n2);
                this.memWrite(n + 4, n3);
                this.memWrite(n + 8, n2);
                this.memWrite(n + 12, n3);
            }
        }
        catch (Runtime$FaultException ex) {
            return -14;
        }
        return (int)currentTimeMillis;
    }
    
    private int sys_sysconf(final int n) {
        switch (n) {
            case 2: {
                return 1000;
            }
            case 8: {
                return (this.writePages.length == 1) ? 4096 : (1 << this.pageShift);
            }
            case 11: {
                return (this.writePages.length == 1) ? ((1 << this.pageShift) / 4096) : this.writePages.length;
            }
            default: {
                System.err.println("WARNING: Attempted to use unknown sysconf key: " + n);
                return -22;
            }
        }
    }
    
    public final int sbrk(int n) {
        if (n < 0) {
            return -12;
        }
        if (n == 0) {
            return this.heapEnd;
        }
        n = (n + 3 & 0xFFFFFFFC);
        final int heapEnd = this.heapEnd;
        final int heapEnd2 = heapEnd + n;
        if (heapEnd2 >= this.stackBottom) {
            return -12;
        }
        if (this.writePages.length > 1) {
            final int n2 = (1 << this.pageShift) - 1;
            final int n3 = 1 << this.pageShift >>> 2;
            final int n4 = heapEnd + n2 >>> this.pageShift;
            final int n5 = heapEnd2 + n2 >>> this.pageShift;
            try {
                for (int i = n4; i < n5; ++i) {
                    this.readPages[i] = (this.writePages[i] = new int[n3]);
                }
            }
            catch (OutOfMemoryError outOfMemoryError) {
                System.err.println("WARNING: Caught OOM Exception in sbrk: " + outOfMemoryError);
                return -12;
            }
        }
        this.heapEnd = heapEnd2;
        return heapEnd;
    }
    
    private int sys_getpid() {
        return this.getPid();
    }
    
    int getPid() {
        return 1;
    }
    
    private int sys_calljava(final int n, final int n2, final int n3, final int n4) {
        if (this.state != 0) {
            throw new IllegalStateException("wound up calling sys_calljava while not in RUNNING");
        }
        if (this.callJavaCB != null) {
            this.state = 3;
            int call;
            try {
                call = this.callJavaCB.call(n, n2, n3, n4);
            }
            catch (RuntimeException ex) {
                System.err.println("Error while executing callJavaCB");
                ex.printStackTrace();
                call = 0;
            }
            this.state = 0;
            return call;
        }
        System.err.println("WARNING: calljava syscall invoked without a calljava callback set");
        return 0;
    }
    
    private int sys_pause() {
        this.state = 2;
        return 0;
    }
    
    private int sys_getpagesize() {
        return (this.writePages.length == 1) ? 4096 : (1 << this.pageShift);
    }
    
    void _exited() {
    }
    
    void exit(final int exitStatus, final boolean b) {
        if (b && this.fds[2] != null) {
            try {
                final byte[] bytes = getBytes("Process exited on signal " + (exitStatus - 128) + "\n");
                this.fds[2].write(bytes, 0, bytes.length);
            }
            catch (Runtime$ErrnoException ex) {}
        }
        this.exitStatus = exitStatus;
        for (int i = 0; i < this.fds.length; ++i) {
            if (this.fds[i] != null) {
                this.closeFD(i);
            }
        }
        this.state = 4;
        this._exited();
    }
    
    private int sys_exit(final int n) {
        this.exit(n, false);
        return 0;
    }
    
    final int sys_fcntl(final int n, final int n2, final int n3) {
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final Runtime$FD runtime$FD = this.fds[n];
        switch (n2) {
            case 0: {
                if (n3 < 0 || n3 >= 64) {
                    return -22;
                }
                int n4;
                for (n4 = n3; n4 < 64 && this.fds[n4] != null; ++n4) {}
                if (n4 == 64) {
                    return -24;
                }
                this.fds[n4] = runtime$FD.dup();
                return n4;
            }
            case 3: {
                return runtime$FD.flags();
            }
            case 2: {
                this.closeOnExec[n] = (n3 != 0);
                return 0;
            }
            case 1: {
                return this.closeOnExec[n] ? 1 : 0;
            }
            case 7:
            case 8: {
                System.err.println("WARNING: file locking requires UnixRuntime");
                return -88;
            }
            default: {
                System.err.println("WARNING: Unknown fcntl command: " + n2);
                return -88;
            }
        }
    }
    
    final int fsync(final int n) {
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final Seekable seekable = this.fds[n].seekable();
        if (seekable == null) {
            return -22;
        }
        try {
            seekable.sync();
            return 0;
        }
        catch (IOException ex) {
            return -5;
        }
    }
    
    protected final int syscall(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        try {
            return this._syscall(n, n2, n3, n4, n5, n6, n7);
        }
        catch (Runtime$ErrnoException ex) {
            return -ex.errno;
        }
        catch (Runtime$FaultException ex3) {
            return -14;
        }
        catch (RuntimeException ex2) {
            ex2.printStackTrace();
            throw new Error("Internal Error in _syscall()");
        }
    }
    
    int _syscall(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return this.sys_exit(n2);
            }
            case 2: {
                return this.sys_pause();
            }
            case 6: {
                return this.sys_write(n2, n3, n4);
            }
            case 8: {
                return this.sys_fstat(n2, n3);
            }
            case 7: {
                return this.sbrk(n2);
            }
            case 3: {
                return this.sys_open(n2, n3, n4);
            }
            case 4: {
                return this.sys_close(n2);
            }
            case 5: {
                return this.sys_read(n2, n3, n4);
            }
            case 10: {
                return this.sys_lseek(n2, n3, n4);
            }
            case 44: {
                return this.sys_ftruncate(n2, n3);
            }
            case 12: {
                return this.sys_getpid();
            }
            case 13: {
                return this.sys_calljava(n2, n3, n4, n5);
            }
            case 15: {
                return this.sys_gettimeofday(n2, n3);
            }
            case 16: {
                return this.sys_sleep(n2);
            }
            case 17: {
                return this.sys_times(n2);
            }
            case 19: {
                return this.sys_getpagesize();
            }
            case 29: {
                return this.sys_fcntl(n2, n3, n4);
            }
            case 31: {
                return this.sys_sysconf(n2);
            }
            case 68: {
                return this.sys_getuid();
            }
            case 70: {
                return this.sys_geteuid();
            }
            case 69: {
                return this.sys_getgid();
            }
            case 71: {
                return this.sys_getegid();
            }
            case 91: {
                return this.fsync(n2);
            }
            case 37: {
                this.memcpy(n2, n3, n4);
                return n2;
            }
            case 38: {
                this.memset(n2, n3, n4);
                return n2;
            }
            case 11:
            case 14:
            case 18:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27: {
                System.err.println("Attempted to use a UnixRuntime syscall in Runtime (" + n + ")");
                return -88;
            }
            default: {
                System.err.println("Attempted to use unknown syscall: " + n);
                return -88;
            }
        }
    }
    
    private int sys_getuid() {
        return 0;
    }
    
    private int sys_geteuid() {
        return 0;
    }
    
    private int sys_getgid() {
        return 0;
    }
    
    private int sys_getegid() {
        return 0;
    }
    
    public int xmalloc(final int n) {
        final int malloc = this.malloc(n);
        if (malloc == 0) {
            throw new RuntimeException("malloc() failed");
        }
        return malloc;
    }
    
    public int xrealloc(final int n, final int n2) {
        final int realloc = this.realloc(n, n2);
        if (realloc == 0) {
            throw new RuntimeException("realloc() failed");
        }
        return realloc;
    }
    
    public int realloc(final int n, final int n2) {
        try {
            return this.call("realloc", n, n2);
        }
        catch (Runtime$CallException ex) {
            return 0;
        }
    }
    
    public int malloc(final int n) {
        try {
            return this.call("malloc", n);
        }
        catch (Runtime$CallException ex) {
            return 0;
        }
    }
    
    public void free(final int n) {
        try {
            if (n != 0) {
                this.call("free", n);
            }
        }
        catch (Runtime$CallException ex) {}
    }
    
    public int strdup(String s) {
        if (s == null) {
            s = "(null)";
        }
        final byte[] bytes = getBytes(s);
        final byte[] array = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, array, 0, bytes.length);
        final int malloc = this.malloc(array.length);
        if (malloc == 0) {
            return 0;
        }
        try {
            this.copyout(array, malloc, array.length);
        }
        catch (Runtime$FaultException ex) {
            this.free(malloc);
            return 0;
        }
        return malloc;
    }
    
    public final String utfstring(final int n) {
        if (n == 0) {
            return null;
        }
        int n2 = n;
        int i = 1;
        while (i != 0) {
            i = this.memRead(n2 & 0xFFFFFFFC);
            switch (n2 & 0x3) {
                case 0: {
                    i = (i >>> 24 & 0xFF);
                    break;
                }
                case 1: {
                    i = (i >>> 16 & 0xFF);
                    break;
                }
                case 2: {
                    i = (i >>> 8 & 0xFF);
                    break;
                }
                case 3: {
                    i = (i >>> 0 & 0xFF);
                    break;
                }
            }
            ++n2;
        }
        if (n2 > n) {
            --n2;
        }
        final byte[] array = new byte[n2 - n];
        this.copyin(n, array, array.length);
        try {
            return new String(array, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public final String cstring(int n) {
        if (n == 0) {
            return null;
        }
        final StringBuffer sb = new StringBuffer();
        while (true) {
            final int memRead = this.memRead(n & 0xFFFFFFFC);
            switch (n & 0x3) {
                case 0: {
                    if ((memRead >>> 24 & 0xFF) == 0x0) {
                        return sb.toString();
                    }
                    sb.append((char)(memRead >>> 24 & 0xFF));
                    ++n;
                }
                case 1: {
                    if ((memRead >>> 16 & 0xFF) == 0x0) {
                        return sb.toString();
                    }
                    sb.append((char)(memRead >>> 16 & 0xFF));
                    ++n;
                }
                case 2: {
                    if ((memRead >>> 8 & 0xFF) == 0x0) {
                        return sb.toString();
                    }
                    sb.append((char)(memRead >>> 8 & 0xFF));
                    ++n;
                }
                case 3: {
                    if ((memRead >>> 0 & 0xFF) == 0x0) {
                        return sb.toString();
                    }
                    sb.append((char)(memRead >>> 0 & 0xFF));
                    ++n;
                    continue;
                }
            }
        }
    }
    
    protected final void nullPointerCheck(final int n) {
        if (n < 65536) {
            throw new Runtime$ExecutionException("Attempted to dereference a null pointer " + toHex(n));
        }
    }
    
    byte[] byteBuf(final int n) {
        if (this._byteBuf == null) {
            this._byteBuf = new byte[n];
        }
        else if (this._byteBuf.length < n) {
            this._byteBuf = new byte[min(max(this._byteBuf.length * 2, n), 16776192)];
        }
        return this._byteBuf;
    }
    
    protected static final int[] decodeData(final String s, final int n) {
        if (s.length() % 8 != 0) {
            throw new IllegalArgumentException("string length must be a multiple of 8");
        }
        if (s.length() / 8 * 7 < n * 4) {
            throw new IllegalArgumentException("string isn't big enough");
        }
        final int[] array = new int[n];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int i = 0;
        while (i < n) {
            long n5 = 0L;
            for (int j = 0; j < 8; ++j) {
                n5 = (n5 << 7 | (s.charAt(n4 + j) & '\u007f'));
            }
            if (n3 > 0) {
                array[i++] = (n2 | (int)(n5 >>> 56 - n3));
            }
            if (i < n) {
                array[i++] = (int)(n5 >>> 24 - n3);
            }
            n3 = (n3 + 8 & 0x1F);
            n2 = (int)(n5 << n3);
            n4 += 8;
        }
        return array;
    }
    
    static byte[] getBytes(final String s) {
        try {
            return s.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            return null;
        }
    }
    
    static byte[] getNullTerminatedBytes(final String s) {
        final byte[] bytes = getBytes(s);
        final byte[] array = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, array, 0, bytes.length);
        return array;
    }
    
    static final String toHex(final int n) {
        return "0x" + Long.toString(n & 0xFFFFFFFFL, 16);
    }
    
    static final int min(final int n, final int n2) {
        return (n < n2) ? n : n2;
    }
    
    static final int max(final int n, final int n2) {
        return (n > n2) ? n : n2;
    }
    
    static {
        final String property = Platform.getProperty("os.name");
        final String property2 = Platform.getProperty("nestedvm.win32hacks");
        if (property2 != null) {
            win32Hacks = Boolean.valueOf(property2);
        }
        else {
            win32Hacks = (property != null && property.toLowerCase().indexOf("windows") != -1);
        }
    }
}
