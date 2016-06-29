/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.ibex.nestedvm.Registers;
import org.ibex.nestedvm.Runtime$1;
import org.ibex.nestedvm.Runtime$CPUState;
import org.ibex.nestedvm.Runtime$CallException;
import org.ibex.nestedvm.Runtime$CallJavaCB;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$ExecutionException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$FaultException;
import org.ibex.nestedvm.Runtime$HostFStat;
import org.ibex.nestedvm.Runtime$ReadFaultException;
import org.ibex.nestedvm.Runtime$SecurityManager;
import org.ibex.nestedvm.Runtime$TerminalFD;
import org.ibex.nestedvm.Runtime$Win32ConsoleIS;
import org.ibex.nestedvm.Runtime$WriteFaultException;
import org.ibex.nestedvm.UsermodeConstants;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public abstract class Runtime
implements Cloneable,
Registers,
UsermodeConstants {
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
    protected int state = 1;
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

    public void setSecurityManager(Runtime$SecurityManager runtime$SecurityManager) {
        this.sm = runtime$SecurityManager;
    }

    public void setCallJavaCB(Runtime$CallJavaCB runtime$CallJavaCB) {
        this.callJavaCB = runtime$CallJavaCB;
    }

    protected abstract void _execute();

    public int lookupSymbol(String string) {
        return -1;
    }

    protected abstract void getCPUState(Runtime$CPUState var1);

    protected abstract void setCPUState(Runtime$CPUState var1);

    protected Object clone() {
        int n2;
        Runtime runtime = (Runtime)super.clone();
        runtime._byteBuf = null;
        runtime.startTime = 0;
        runtime.fds = new Runtime$FD[64];
        for (n2 = 0; n2 < 64; ++n2) {
            if (this.fds[n2] == null) continue;
            runtime.fds[n2] = this.fds[n2].dup();
        }
        n2 = this.writePages.length;
        runtime.readPages = new int[n2][];
        runtime.writePages = new int[n2][];
        int n3 = 0;
        while (n3 < n2) {
            if (this.readPages[n3] != null) {
                runtime.readPages[n3] = this.writePages[n3] == null ? this.readPages[n3] : (runtime.writePages[n3] = (int[])this.writePages[n3].clone());
            }
            ++n3;
        }
        return runtime;
    }

    protected Runtime(int n2, int n3) {
        this(n2, n3, false);
    }

    protected Runtime(int n2, int n3, boolean bl2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("pageSize <= 0");
        }
        if (n3 <= 0) {
            throw new IllegalArgumentException("totalPages <= 0");
        }
        if ((n2 & n2 - 1) != 0) {
            throw new IllegalArgumentException("pageSize not a power of two");
        }
        int n4 = 0;
        while (n2 >>> n4 != 1) {
            ++n4;
        }
        this.pageShift = n4;
        int n5 = this.heapStart();
        int n6 = n3 * n2;
        int n7 = Runtime.max(n6 / 512, 131072);
        int n8 = 0;
        if (n3 > 1) {
            n7 = Runtime.max(n7, n2);
            n8 = (n7 = n7 + n2 - 1 & ~ (n2 - 1)) >>> this.pageShift;
            if (n8 + 4 + ((n5 = n5 + n2 - 1 & ~ (n2 - 1)) >>> this.pageShift) >= n3) {
                throw new IllegalArgumentException("total pages too small");
            }
        } else {
            if (n2 < n5 + n7) {
                throw new IllegalArgumentException("total memory too small");
            }
            n5 = n5 + 4095 & -4097;
        }
        this.stackBottom = n6 - n7;
        this.heapEnd = n5;
        this.readPages = new int[n3][];
        this.writePages = new int[n3][];
        if (n3 == 1) {
            this.readPages[0] = this.writePages[0] = new int[n2 >> 2];
        } else {
            for (int i2 = this.stackBottom >>> this.pageShift; i2 < this.writePages.length; ++i2) {
                this.readPages[i2] = this.writePages[i2] = new int[n2 >> 2];
            }
        }
        if (bl2) return;
        this.fds = new Runtime$FD[64];
        this.closeOnExec = new boolean[64];
        InputStream inputStream = win32Hacks ? new Runtime$Win32ConsoleIS(System.in) : System.in;
        this.addFD(new Runtime$TerminalFD(inputStream));
        this.addFD(new Runtime$TerminalFD(System.out));
        this.addFD(new Runtime$TerminalFD(System.err));
    }

    protected final void initPages(int[] arrn, int n2, boolean bl2) {
        int n3 = 1 << this.pageShift >>> 2;
        int n4 = (1 << this.pageShift) - 1;
        int n5 = 0;
        while (n5 < arrn.length) {
            int n6 = n2 >>> this.pageShift;
            int n7 = (n2 & n4) >> 2;
            int n8 = Runtime.min(n3 - n7, arrn.length - n5);
            if (this.readPages[n6] == null) {
                this.initPage(n6, bl2);
            } else if (!bl2 && this.writePages[n6] == null) {
                this.writePages[n6] = this.readPages[n6];
            }
            System.arraycopy(arrn, n5, this.readPages[n6], n7, n8);
            n5 += n8;
            n2 += n8 * 4;
        }
    }

    protected final void clearPages(int n2, int n3) {
        int n4 = 1 << this.pageShift >>> 2;
        int n5 = (1 << this.pageShift) - 1;
        int n6 = 0;
        while (n6 < n3) {
            int n7 = n2 >>> this.pageShift;
            int n8 = (n2 & n5) >> 2;
            int n9 = Runtime.min(n4 - n8, n3 - n6);
            if (this.readPages[n7] == null) {
                this.readPages[n7] = this.writePages[n7] = new int[n4];
            } else {
                if (this.writePages[n7] == null) {
                    this.writePages[n7] = this.readPages[n7];
                }
                for (int i2 = n8; i2 < n8 + n9; ++i2) {
                    this.writePages[n7][i2] = 0;
                }
            }
            n6 += n9;
            n2 += n9 * 4;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void copyin(int var1_1, byte[] var2_2, int var3_3) {
        var4_4 = 1 << this.pageShift >>> 2;
        var5_5 = var4_4 - 1;
        var6_6 = 0;
        if (var3_3 == 0) {
            return;
        }
        if ((var1_1 & 3) == 0) ** GOTO lbl21
        var7_7 = this.memRead(var1_1 & -4);
        switch (var1_1 & 3) {
            case 1: {
                var2_2[var6_6++] = (byte)(var7_7 >>> 16 & 255);
                ** if (--var3_3 == 0) goto lbl15
            }
lbl-1000: // 2 sources:
            {
                case 2: {
                    var2_2[var6_6++] = (byte)(var7_7 >>> 8 & 255);
                    ** if (--var3_3 == 0) goto lbl20
                }
            }
lbl15: // 1 sources:
            break;
lbl-1000: // 2 sources:
            {
                case 3: {
                    var2_2[var6_6++] = (byte)(var7_7 >>> 0 & 255);
                    if (--var3_3 != 0) break;
                }
            }
            {
            }
        }
lbl20: // 5 sources:
        var1_1 = (var1_1 & -4) + 4;
lbl21: // 2 sources:
        if ((var3_3 & -4) != 0) {
            var8_8 = var1_1 >>> 2;
            for (var7_7 = var3_3 >>> 2; var7_7 != 0; var8_8 += var11_11, var7_7 -= var11_11) {
                var9_9 = this.readPages[var8_8 >>> this.pageShift - 2];
                if (var9_9 == null) {
                    throw new Runtime$ReadFaultException(var8_8 << 2);
                }
                var10_10 = var8_8 & var5_5;
                var11_11 = Runtime.min(var7_7, var4_4 - var10_10);
                for (var12_12 = 0; var12_12 < var11_11; ++var12_12, var6_6 += 4) {
                    var13_13 = var9_9[var10_10 + var12_12];
                    var2_2[var6_6 + 0] = (byte)(var13_13 >>> 24 & 255);
                    var2_2[var6_6 + 1] = (byte)(var13_13 >>> 16 & 255);
                    var2_2[var6_6 + 2] = (byte)(var13_13 >>> 8 & 255);
                    var2_2[var6_6 + 3] = (byte)(var13_13 >>> 0 & 255);
                }
            }
            var1_1 = var8_8 << 2;
            var3_3 &= 3;
        }
        if (var3_3 == 0) return;
        var7_7 = this.memRead(var1_1);
        switch (var3_3) {
            case 3: {
                var2_2[var6_6 + 2] = (byte)(var7_7 >>> 8 & 255);
            }
            case 2: {
                var2_2[var6_6 + 1] = (byte)(var7_7 >>> 16 & 255);
            }
            case 1: {
                var2_2[var6_6 + 0] = (byte)(var7_7 >>> 24 & 255);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void copyout(byte[] var1_1, int var2_2, int var3_3) {
        var4_4 = 1 << this.pageShift >>> 2;
        var5_5 = var4_4 - 1;
        var6_6 = 0;
        if (var3_3 == 0) {
            return;
        }
        if ((var2_2 & 3) == 0) ** GOTO lbl22
        var7_7 = this.memRead(var2_2 & -4);
        switch (var2_2 & 3) {
            case 1: {
                var7_7 = var7_7 & -16711681 | (var1_1[var6_6++] & 255) << 16;
                ** if (--var3_3 == 0) goto lbl15
            }
lbl-1000: // 2 sources:
            {
                case 2: {
                    var7_7 = var7_7 & -65281 | (var1_1[var6_6++] & 255) << 8;
                    ** if (--var3_3 == 0) goto lbl20
                }
            }
lbl15: // 1 sources:
            break;
lbl-1000: // 2 sources:
            {
                case 3: {
                    var7_7 = var7_7 & -256 | (var1_1[var6_6++] & 255) << 0;
                    if (--var3_3 != 0) break;
                }
            }
            {
            }
        }
lbl20: // 5 sources:
        this.memWrite(var2_2 & -4, var7_7);
        var2_2 += var6_6;
lbl22: // 2 sources:
        if ((var3_3 & -4) != 0) {
            var8_8 = var2_2 >>> 2;
            for (var7_7 = var3_3 >>> 2; var7_7 != 0; var8_8 += var11_11, var7_7 -= var11_11) {
                var9_9 = this.writePages[var8_8 >>> this.pageShift - 2];
                if (var9_9 == null) {
                    throw new Runtime$WriteFaultException(var8_8 << 2);
                }
                var10_10 = var8_8 & var5_5;
                var11_11 = Runtime.min(var7_7, var4_4 - var10_10);
                for (var12_12 = 0; var12_12 < var11_11; ++var12_12, var6_6 += 4) {
                    var9_9[var10_10 + var12_12] = (var1_1[var6_6 + 0] & 255) << 24 | (var1_1[var6_6 + 1] & 255) << 16 | (var1_1[var6_6 + 2] & 255) << 8 | (var1_1[var6_6 + 3] & 255) << 0;
                }
            }
            var2_2 = var8_8 << 2;
            var3_3 &= 3;
        }
        if (var3_3 == 0) return;
        var7_7 = this.memRead(var2_2);
        switch (var3_3) {
            case 1: {
                var7_7 = var7_7 & 16777215 | (var1_1[var6_6 + 0] & 255) << 24;
                break;
            }
            case 2: {
                var7_7 = var7_7 & 65535 | (var1_1[var6_6 + 0] & 255) << 24 | (var1_1[var6_6 + 1] & 255) << 16;
                break;
            }
            case 3: {
                var7_7 = var7_7 & 255 | (var1_1[var6_6 + 0] & 255) << 24 | (var1_1[var6_6 + 1] & 255) << 16 | (var1_1[var6_6 + 2] & 255) << 8;
            }
        }
        this.memWrite(var2_2, var7_7);
    }

    /*
     * Unable to fully structure code
     */
    public final void memcpy(int var1_1, int var2_2, int var3_3) {
        var4_4 = 1 << this.pageShift >>> 2;
        var5_5 = var4_4 - 1;
        if ((var1_1 & 3) != 0 || (var2_2 & 3) != 0) ** GOTO lbl8
        if ((var3_3 & -4) == 0) ** GOTO lbl33
        var7_8 = var2_2 >>> 2;
        var8_10 = var1_1 >>> 2;
        ** GOTO lbl18
lbl8: // 2 sources:
        while (var3_3 > 0) {
            var6_7 = Runtime.min(var3_3, 16776192);
            var7_9 = this.byteBuf(var6_7);
            this.copyin(var2_2, var7_9, var6_7);
            this.copyout(var7_9, var1_1, var6_7);
            var3_3 -= var6_7;
            var2_2 += var6_7;
            var1_1 += var6_7;
        }
        return;
lbl18: // 2 sources:
        for (var6_6 = var3_3 >> 2; var6_6 != 0; var7_8 += var13_15, var8_10 += var13_15, var6_6 -= var13_15) {
            var9_11 = this.readPages[var7_8 >>> this.pageShift - 2];
            if (var9_11 == null) {
                throw new Runtime$ReadFaultException(var7_8 << 2);
            }
            var10_12 = this.writePages[var8_10 >>> this.pageShift - 2];
            if (var10_12 == null) {
                throw new Runtime$WriteFaultException(var8_10 << 2);
            }
            var11_13 = var7_8 & var5_5;
            var12_14 = var8_10 & var5_5;
            var13_15 = Runtime.min(var6_6, var4_4 - Runtime.max(var11_13, var12_14));
            System.arraycopy(var9_11, var11_13, var10_12, var12_14, var13_15);
        }
        var2_2 = var7_8 << 2;
        var1_1 = var8_10 << 2;
        var3_3 &= 3;
lbl33: // 2 sources:
        if (var3_3 == 0) return;
        var6_6 = this.memRead(var2_2);
        var7_8 = this.memRead(var1_1);
        switch (var3_3) {
            case 1: {
                this.memWrite(var1_1, var6_6 & -16777216 | var7_8 & 16777215);
                return;
            }
            case 2: {
                this.memWrite(var1_1, var6_6 & -65536 | var7_8 & 65535);
                return;
            }
            case 3: {
                this.memWrite(var1_1, var6_6 & -256 | var7_8 & 255);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void memset(int var1_1, int var2_2, int var3_3) {
        var4_4 = 1 << this.pageShift >>> 2;
        var5_5 = var4_4 - 1;
        var6_6 = (var2_2 & 255) << 24 | (var2_2 & 255) << 16 | (var2_2 & 255) << 8 | (var2_2 & 255) << 0;
        if ((var1_1 & 3) == 0) ** GOTO lbl20
        var7_7 = this.memRead(var1_1 & -4);
        switch (var1_1 & 3) {
            case 1: {
                var7_7 = var7_7 & -16711681 | (var2_2 & 255) << 16;
                ** if (--var3_3 == 0) goto lbl13
            }
lbl-1000: // 2 sources:
            {
                case 2: {
                    var7_7 = var7_7 & -65281 | (var2_2 & 255) << 8;
                    ** if (--var3_3 == 0) goto lbl18
                }
            }
lbl13: // 1 sources:
            break;
lbl-1000: // 2 sources:
            {
                case 3: {
                    var7_7 = var7_7 & -256 | (var2_2 & 255) << 0;
                    if (--var3_3 != 0) break;
                }
            }
            {
            }
        }
lbl18: // 5 sources:
        this.memWrite(var1_1 & -4, var7_7);
        var1_1 = (var1_1 & -4) + 4;
lbl20: // 2 sources:
        if ((var3_3 & -4) != 0) {
            var8_8 = var1_1 >>> 2;
            for (var7_7 = var3_3 >> 2; var7_7 != 0; var8_8 += var11_11, var7_7 -= var11_11) {
                var9_9 = this.readPages[var8_8 >>> this.pageShift - 2];
                if (var9_9 == null) {
                    throw new Runtime$WriteFaultException(var8_8 << 2);
                }
                var10_10 = var8_8 & var5_5;
                var11_11 = Runtime.min(var7_7, var4_4 - var10_10);
                for (var12_12 = var10_10; var12_12 < var10_10 + var11_11; ++var12_12) {
                    var9_9[var12_12] = var6_6;
                }
            }
            var1_1 = var8_8 << 2;
            var3_3 &= 3;
        }
        if (var3_3 == 0) return;
        var7_7 = this.memRead(var1_1);
        switch (var3_3) {
            case 1: {
                var7_7 = var7_7 & 16777215 | var6_6 & -16777216;
                break;
            }
            case 2: {
                var7_7 = var7_7 & 65535 | var6_6 & -65536;
                break;
            }
            case 3: {
                var7_7 = var7_7 & 255 | var6_6 & -256;
            }
        }
        this.memWrite(var1_1, var7_7);
    }

    public final int memRead(int n2) {
        if ((n2 & 3) == 0) return this.unsafeMemRead(n2);
        throw new Runtime$ReadFaultException(n2);
    }

    protected final int unsafeMemRead(int n2) {
        int n3 = n2 >>> this.pageShift;
        int n4 = (n2 & (1 << this.pageShift) - 1) >> 2;
        try {
            return this.readPages[n3][n4];
        }
        catch (ArrayIndexOutOfBoundsException var4_4) {
            if (n3 < 0) throw new Runtime$ReadFaultException(n2);
            if (n3 < this.readPages.length) throw var4_4;
            throw new Runtime$ReadFaultException(n2);
        }
        catch (NullPointerException var4_5) {
            throw new Runtime$ReadFaultException(n2);
        }
    }

    public final void memWrite(int n2, int n3) {
        if ((n2 & 3) != 0) {
            throw new Runtime$WriteFaultException(n2);
        }
        this.unsafeMemWrite(n2, n3);
    }

    protected final void unsafeMemWrite(int n2, int n3) {
        int n4 = n2 >>> this.pageShift;
        int n5 = (n2 & (1 << this.pageShift) - 1) >> 2;
        try {
            this.writePages[n4][n5] = n3;
            return;
        }
        catch (ArrayIndexOutOfBoundsException var5_5) {
            if (n4 < 0) throw new Runtime$WriteFaultException(n2);
            if (n4 < this.writePages.length) throw var5_5;
            throw new Runtime$WriteFaultException(n2);
        }
        catch (NullPointerException var5_6) {
            throw new Runtime$WriteFaultException(n2);
        }
    }

    private final int[] initPage(int n2) {
        return this.initPage(n2, false);
    }

    private final int[] initPage(int n2, boolean bl2) {
        int[] arrn = new int[1 << this.pageShift >>> 2];
        this.writePages[n2] = bl2 ? null : arrn;
        this.readPages[n2] = arrn;
        return arrn;
    }

    public final int exitStatus() {
        if (this.state == 4) return this.exitStatus;
        throw new IllegalStateException("exitStatus() called in an inappropriate state");
    }

    private int addStringArray(String[] arrstring, int n2) {
        int n3;
        int n4 = arrstring.length;
        int n5 = 0;
        for (n3 = 0; n3 < n4; n5 += arrstring[n3].length() + 1, ++n3) {
        }
        n3 = n2 - (n5 += (n4 + 1) * 4) & -4;
        int n6 = n3 + (n4 + 1) * 4;
        int[] arrn = new int[n4 + 1];
        try {
            byte[] arrby;
            int n7;
            for (n7 = 0; n7 < n4; n6 += arrby.length + 1, ++n7) {
                arrby = Runtime.getBytes(arrstring[n7]);
                arrn[n7] = n6;
                this.copyout(arrby, n6, arrby.length);
                this.memset(n6 + arrby.length, 0, 1);
            }
            n6 = n3;
            n7 = 0;
            while (n7 < n4 + 1) {
                this.memWrite(n6, arrn[n7]);
                n6 += 4;
                ++n7;
            }
            return n3;
        }
        catch (Runtime$FaultException var8_9) {
            throw new RuntimeException(var8_9.toString());
        }
    }

    String[] createEnv(String[] arrstring) {
        if (arrstring != null) return arrstring;
        return new String[0];
    }

    public void setUserInfo(int n2, int n3) {
        if (n2 < 0) throw new IndexOutOfBoundsException(new StringBuffer().append("setUserInfo called with index >= ").append(this.userInfoSize() / 4).toString());
        if (n2 >= this.userInfoSize() / 4) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("setUserInfo called with index >= ").append(this.userInfoSize() / 4).toString());
        }
        try {
            this.memWrite(this.userInfoBase() + n2 * 4, n3);
            return;
        }
        catch (Runtime$FaultException var3_3) {
            throw new RuntimeException(var3_3.toString());
        }
    }

    public int getUserInfo(int n2) {
        if (n2 < 0) throw new IndexOutOfBoundsException(new StringBuffer().append("setUserInfo called with index >= ").append(this.userInfoSize() / 4).toString());
        if (n2 >= this.userInfoSize() / 4) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("setUserInfo called with index >= ").append(this.userInfoSize() / 4).toString());
        }
        try {
            return this.memRead(this.userInfoBase() + n2 * 4);
        }
        catch (Runtime$FaultException var2_2) {
            throw new RuntimeException(var2_2.toString());
        }
    }

    private void __execute() {
        try {
            this._execute();
            return;
        }
        catch (Runtime$FaultException var1_1) {
            var1_1.printStackTrace();
            this.exit(139, true);
            this.exitException = var1_1;
            return;
        }
        catch (Runtime$ExecutionException var1_2) {
            var1_2.printStackTrace();
            this.exit(132, true);
            this.exitException = var1_2;
        }
    }

    public final boolean execute() {
        if (this.state != 2) {
            throw new IllegalStateException("execute() called in inappropriate state");
        }
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
        this.state = 0;
        this.__execute();
        if (this.state != 2 && this.state != 4 && this.state != 5) {
            throw new IllegalStateException(new StringBuffer().append("execute() ended up in an inappropriate state (").append(this.state).append(")").toString());
        }
        if (this.state == 2) return false;
        return true;
    }

    static String[] concatArgv(String string, String[] arrstring) {
        String[] arrstring2 = new String[arrstring.length + 1];
        System.arraycopy(arrstring, 0, arrstring2, 1, arrstring.length);
        arrstring2[0] = string;
        return arrstring2;
    }

    public final int run() {
        return this.run(null);
    }

    public final int run(String string, String[] arrstring) {
        return this.run(Runtime.concatArgv(string, arrstring));
    }

    public final int run(String[] arrstring) {
        return this.run(arrstring, null);
    }

    public final int run(String[] arrstring, String[] arrstring2) {
        block3 : {
            this.start(arrstring, arrstring2);
            do {
                if (this.execute()) {
                    if (this.state == 5) {
                        break;
                    }
                    break block3;
                }
                System.err.println("WARNING: Pause requested while executing run()");
            } while (true);
            System.err.println("WARNING: Process exec()ed while being run under run()");
        }
        if (this.state != 4) return 0;
        int n2 = this.exitStatus();
        return n2;
    }

    public final void start() {
        this.start(null);
    }

    public final void start(String[] arrstring) {
        this.start(arrstring, null);
    }

    public final void start(String[] arrstring, String[] arrstring2) {
        int n2;
        int n3;
        int n4;
        if (this.state != 1) {
            throw new IllegalStateException("start() called in inappropriate state");
        }
        if (arrstring == null) {
            arrstring = new String[]{this.getClass().getName()};
        }
        int n5 = n4 = this.writePages.length * (1 << this.pageShift);
        try {
            n5 = n3 = this.addStringArray(arrstring, n5);
            n5 = n2 = this.addStringArray(this.createEnv(arrstring2), n5);
        }
        catch (Runtime$FaultException var7_7) {
            throw new IllegalArgumentException("args/environ too big");
        }
        if (n4 - (n5 &= -16) > 65536) {
            throw new IllegalArgumentException("args/environ too big");
        }
        if (this.heapEnd == 0) {
            this.heapEnd = this.heapStart();
            if (this.heapEnd == 0) {
                throw new Error("heapEnd == 0");
            }
            int n6 = this.writePages.length == 1 ? 4096 : 1 << this.pageShift;
            this.heapEnd = this.heapEnd + n6 - 1 & ~ (n6 - 1);
        }
        Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        runtime$CPUState.r[4] = n3;
        runtime$CPUState.r[5] = n2;
        runtime$CPUState.r[29] = n5;
        runtime$CPUState.r[31] = -559038737;
        runtime$CPUState.r[28] = this.gp();
        runtime$CPUState.pc = this.entryPoint();
        this.setCPUState(runtime$CPUState);
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

    public final int call(String string, Object[] arrobject) {
        int n2;
        if (this.state != 2 && this.state != 3) {
            throw new IllegalStateException("call() called in inappropriate state");
        }
        if (arrobject.length > 7) {
            throw new IllegalArgumentException("args.length > 7");
        }
        Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        this.getCPUState(runtime$CPUState);
        int n3 = runtime$CPUState.r[29];
        int[] arrn = new int[arrobject.length];
        for (n2 = 0; n2 < arrobject.length; ++n2) {
            Object object = arrobject[n2];
            byte[] arrby = null;
            if (object instanceof String) {
                arrby = Runtime.getBytes((String)object);
            } else if (object instanceof byte[]) {
                arrby = (byte[])object;
            } else if (object instanceof Number) {
                arrn[n2] = ((Number)object).intValue();
            }
            if (arrby == null) continue;
            this.copyout(arrby, n3 -= arrby.length, arrby.length);
            arrn[n2] = n3;
        }
        n2 = runtime$CPUState.r[29];
        if (n2 == n3) {
            return this.call(string, arrn);
        }
        runtime$CPUState.r[29] = n3;
        this.setCPUState(runtime$CPUState);
        int n4 = this.call(string, arrn);
        runtime$CPUState.r[29] = n2;
        this.setCPUState(runtime$CPUState);
        return n4;
    }

    public final int call(String string) {
        return this.call(string, new int[0]);
    }

    public final int call(String string, int n2) {
        return this.call(string, new int[]{n2});
    }

    public final int call(String string, int n2, int n3) {
        return this.call(string, new int[]{n2, n3});
    }

    public final int call(String string, int[] arrn) {
        int n2 = this.lookupSymbol(string);
        if (n2 == -1) {
            throw new Runtime$CallException(new StringBuffer().append(string).append(" not found").toString());
        }
        int n3 = this.lookupSymbol("_call_helper");
        if (n3 != -1) return this.call(n3, n2, arrn);
        throw new Runtime$CallException("_call_helper not found");
    }

    public final int call(int n2, int n3, int[] arrn) {
        if (arrn.length > 7) {
            throw new IllegalArgumentException("rest.length > 7");
        }
        if (this.state != 2 && this.state != 3) {
            throw new IllegalStateException("call() called in inappropriate state");
        }
        int n4 = this.state;
        Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        this.getCPUState(runtime$CPUState);
        Runtime$CPUState runtime$CPUState2 = runtime$CPUState.dup();
        runtime$CPUState2.r[29] = runtime$CPUState2.r[29] & -16;
        runtime$CPUState2.r[31] = -559038737;
        runtime$CPUState2.r[4] = n3;
        switch (arrn.length) {
            case 7: {
                runtime$CPUState2.r[19] = arrn[6];
            }
            case 6: {
                runtime$CPUState2.r[18] = arrn[5];
            }
            case 5: {
                runtime$CPUState2.r[17] = arrn[4];
            }
            case 4: {
                runtime$CPUState2.r[16] = arrn[3];
            }
            case 3: {
                runtime$CPUState2.r[7] = arrn[2];
            }
            case 2: {
                runtime$CPUState2.r[6] = arrn[1];
            }
            case 1: {
                runtime$CPUState2.r[5] = arrn[0];
            }
        }
        runtime$CPUState2.pc = n2;
        this.state = 0;
        this.setCPUState(runtime$CPUState2);
        this.__execute();
        this.getCPUState(runtime$CPUState2);
        this.setCPUState(runtime$CPUState);
        if (this.state != 2) {
            throw new Runtime$CallException("Process exit()ed while servicing a call() request");
        }
        this.state = n4;
        return runtime$CPUState2.r[3];
    }

    public final int addFD(Runtime$FD runtime$FD) {
        int n2;
        if (this.state == 4) throw new IllegalStateException("addFD called in inappropriate state");
        if (this.state == 5) {
            throw new IllegalStateException("addFD called in inappropriate state");
        }
        for (n2 = 0; n2 < 64; ++n2) {
            if (this.fds[n2] != null) continue;
            if (n2 != 64) break;
            return -1;
        }
        this.fds[n2] = runtime$FD;
        this.closeOnExec[n2] = false;
        return n2;
    }

    void _preCloseFD(Runtime$FD runtime$FD) {
    }

    void _postCloseFD(Runtime$FD runtime$FD) {
    }

    public final boolean closeFD(int n2) {
        if (this.state == 4) throw new IllegalStateException("closeFD called in inappropriate state");
        if (this.state == 5) {
            throw new IllegalStateException("closeFD called in inappropriate state");
        }
        if (n2 < 0) return false;
        if (n2 >= 64) {
            return false;
        }
        if (this.fds[n2] == null) {
            return false;
        }
        this._preCloseFD(this.fds[n2]);
        this.fds[n2].close();
        this._postCloseFD(this.fds[n2]);
        this.fds[n2] = null;
        return true;
    }

    public final int dupFD(int n2) {
        int n3;
        if (n2 < 0) return -1;
        if (n2 >= 64) {
            return -1;
        }
        if (this.fds[n2] == null) {
            return -1;
        }
        for (n3 = 0; n3 < 64; ++n3) {
            if (this.fds[n3] != null) continue;
            if (n3 != 64) break;
            return -1;
        }
        this.fds[n3] = this.fds[n2].dup();
        return n3;
    }

    Runtime$FD hostFSOpen(File file, int n2, int n3, Object object) {
        boolean bl2;
        block16 : {
            if ((n2 & -3596) != 0) {
                System.err.println(new StringBuffer().append("WARNING: Unsupported flags passed to open(\"").append(file).append("\"): ").append(Runtime.toHex(n2 & -3596)).toString());
                throw new Runtime$ErrnoException(134);
            }
            boolean bl3 = bl2 = (n2 & 3) != 0;
            if (this.sm != null) {
                if (bl2) {
                    if (!this.sm.allowWrite(file)) throw new Runtime$ErrnoException(13);
                } else if (!this.sm.allowRead(file)) {
                    throw new Runtime$ErrnoException(13);
                }
            }
            if ((n2 & 2560) == 2560) {
                try {
                    if (!Platform.atomicCreateFile(file)) {
                        throw new Runtime$ErrnoException(17);
                    }
                    break block16;
                }
                catch (IOException var6_6) {
                    throw new Runtime$ErrnoException(5);
                }
            }
            if (!file.exists()) {
                if ((n2 & 512) == 0) {
                    return null;
                }
            } else if (file.isDirectory()) {
                return this.hostFSDirFD(file, object);
            }
        }
        try {
            Seekable$File seekable$File = new Seekable$File(file, bl2, (n2 & 1024) != 0);
            return new Runtime$1(this, seekable$File, n2, file, seekable$File, object);
        }
        catch (FileNotFoundException var7_8) {
            if (var7_8.getMessage() == null) return null;
            if (var7_8.getMessage().indexOf("Permission denied") < 0) return null;
            throw new Runtime$ErrnoException(13);
        }
        catch (IOException var7_9) {
            throw new Runtime$ErrnoException(5);
        }
    }

    Runtime$FStat hostFStat(File file, Seekable$File seekable$File, Object object) {
        return new Runtime$HostFStat(file, seekable$File);
    }

    Runtime$FD hostFSDirFD(File file, Object object) {
        return null;
    }

    Runtime$FD _open(String string, int n2, int n3) {
        return this.hostFSOpen(new File(string), n2, n3, null);
    }

    private int sys_open(int n2, int n3, int n4) {
        Runtime$FD runtime$FD;
        String string = this.cstring(n2);
        if (string.length() == 1024 && this.getClass().getName().equals("tests.TeX")) {
            string = string.trim();
        }
        if ((runtime$FD = this._open(string, n3 &= -32769, n4)) == null) {
            return -2;
        }
        int n5 = this.addFD(runtime$FD);
        if (n5 != -1) return n5;
        runtime$FD.close();
        return -23;
    }

    private int sys_write(int n2, int n3, int n4) {
        n4 = Math.min(n4, 16776192);
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        byte[] arrby = this.byteBuf(n4);
        this.copyin(n3, arrby, n4);
        try {
            return this.fds[n2].write(arrby, 0, n4);
        }
        catch (Runtime$ErrnoException var5_5) {
            if (var5_5.errno != 32) throw var5_5;
            this.sys_exit(141);
            throw var5_5;
        }
    }

    private int sys_read(int n2, int n3, int n4) {
        n4 = Math.min(n4, 16776192);
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        byte[] arrby = this.byteBuf(n4);
        int n5 = this.fds[n2].read(arrby, 0, n4);
        this.copyout(arrby, n3, n5);
        return n5;
    }

    private int sys_ftruncate(int n2, long l2) {
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        Seekable seekable = this.fds[n2].seekable();
        if (l2 < 0) return -22;
        if (seekable == null) {
            return -22;
        }
        try {
            seekable.resize(l2);
            return 0;
        }
        catch (IOException var5_4) {
            return -5;
        }
    }

    private int sys_close(int n2) {
        if (!this.closeFD(n2)) return -81;
        return 0;
    }

    private int sys_lseek(int n2, int n3, int n4) {
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        if (n4 != 0 && n4 != 1 && n4 != 2) {
            return -22;
        }
        int n5 = this.fds[n2].seek(n3, n4);
        if (n5 < 0) {
            return -29;
        }
        int n6 = n5;
        return n6;
    }

    int stat(Runtime$FStat runtime$FStat, int n2) {
        this.memWrite(n2 + 0, runtime$FStat.dev() << 16 | runtime$FStat.inode() & 65535);
        this.memWrite(n2 + 4, runtime$FStat.type() & 61440 | runtime$FStat.mode() & 4095);
        this.memWrite(n2 + 8, runtime$FStat.nlink() << 16 | runtime$FStat.uid() & 65535);
        this.memWrite(n2 + 12, runtime$FStat.gid() << 16 | 0);
        this.memWrite(n2 + 16, runtime$FStat.size());
        this.memWrite(n2 + 20, runtime$FStat.atime());
        this.memWrite(n2 + 28, runtime$FStat.mtime());
        this.memWrite(n2 + 36, runtime$FStat.ctime());
        this.memWrite(n2 + 44, runtime$FStat.blksize());
        this.memWrite(n2 + 48, runtime$FStat.blocks());
        return 0;
    }

    private int sys_fstat(int n2, int n3) {
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] != null) return this.stat(this.fds[n2].fstat(), n3);
        return -81;
    }

    private int sys_gettimeofday(int n2, int n3) {
        long l2 = System.currentTimeMillis();
        int n4 = (int)(l2 / 1000);
        int n5 = (int)(l2 % 1000 * 1000);
        this.memWrite(n2 + 0, n4);
        this.memWrite(n2 + 4, n5);
        return 0;
    }

    private int sys_sleep(int n2) {
        if (n2 < 0) {
            n2 = Integer.MAX_VALUE;
        }
        try {
            Thread.sleep((long)n2 * 1000);
            return 0;
        }
        catch (InterruptedException var2_2) {
            return -1;
        }
    }

    private int sys_times(int n2) {
        long l2 = System.currentTimeMillis();
        int n3 = (int)((l2 - this.startTime) / 16);
        int n4 = (int)((l2 - this.startTime) / 16);
        try {
            if (n2 == 0) return (int)l2;
            this.memWrite(n2 + 0, n3);
            this.memWrite(n2 + 4, n4);
            this.memWrite(n2 + 8, n3);
            this.memWrite(n2 + 12, n4);
            return (int)l2;
        }
        catch (Runtime$FaultException var6_5) {
            return -14;
        }
    }

    private int sys_sysconf(int n2) {
        switch (n2) {
            case 2: {
                return 1000;
            }
            case 8: {
                if (this.writePages.length == 1) {
                    return 4096;
                }
                int n3 = 1 << this.pageShift;
                return n3;
            }
            case 11: {
                int n4;
                if (this.writePages.length == 1) {
                    n4 = (1 << this.pageShift) / 4096;
                    return n4;
                }
                n4 = this.writePages.length;
                return n4;
            }
        }
        System.err.println(new StringBuffer().append("WARNING: Attempted to use unknown sysconf key: ").append(n2).toString());
        return -22;
    }

    public final int sbrk(int n2) {
        if (n2 < 0) {
            return -12;
        }
        if (n2 == 0) {
            return this.heapEnd;
        }
        int n3 = this.heapEnd;
        int n4 = n3 + (n2 = n2 + 3 & -4);
        if (n4 >= this.stackBottom) {
            return -12;
        }
        if (this.writePages.length > 1) {
            int n5 = (1 << this.pageShift) - 1;
            int n6 = 1 << this.pageShift >>> 2;
            int n7 = n3 + n5 >>> this.pageShift;
            int n8 = n4 + n5 >>> this.pageShift;
            try {
                for (int i2 = n7; i2 < n8; ++i2) {
                    this.readPages[i2] = this.writePages[i2] = new int[n6];
                }
            }
            catch (OutOfMemoryError var8_9) {
                System.err.println(new StringBuffer().append("WARNING: Caught OOM Exception in sbrk: ").append(var8_9).toString());
                return -12;
            }
        }
        this.heapEnd = n4;
        return n3;
    }

    private int sys_getpid() {
        return this.getPid();
    }

    int getPid() {
        return 1;
    }

    private int sys_calljava(int n2, int n3, int n4, int n5) {
        int n6;
        if (this.state != 0) {
            throw new IllegalStateException("wound up calling sys_calljava while not in RUNNING");
        }
        if (this.callJavaCB == null) {
            System.err.println("WARNING: calljava syscall invoked without a calljava callback set");
            return 0;
        }
        this.state = 3;
        try {
            n6 = this.callJavaCB.call(n2, n3, n4, n5);
        }
        catch (RuntimeException var6_6) {
            System.err.println("Error while executing callJavaCB");
            var6_6.printStackTrace();
            n6 = 0;
        }
        this.state = 0;
        return n6;
    }

    private int sys_pause() {
        this.state = 2;
        return 0;
    }

    private int sys_getpagesize() {
        if (this.writePages.length == 1) {
            return 4096;
        }
        int n2 = 1 << this.pageShift;
        return n2;
    }

    void _exited() {
    }

    void exit(int n2, boolean bl2) {
        if (bl2 && this.fds[2] != null) {
            try {
                byte[] arrby = Runtime.getBytes(new StringBuffer().append("Process exited on signal ").append(n2 - 128).append("\n").toString());
                this.fds[2].write(arrby, 0, arrby.length);
            }
            catch (Runtime$ErrnoException var3_4) {
                // empty catch block
            }
        }
        this.exitStatus = n2;
        int n3 = 0;
        do {
            if (n3 >= this.fds.length) {
                this.state = 4;
                this._exited();
                return;
            }
            if (this.fds[n3] != null) {
                this.closeFD(n3);
            }
            ++n3;
        } while (true);
    }

    private int sys_exit(int n2) {
        this.exit(n2, false);
        return 0;
    }

    final int sys_fcntl(int n2, int n3, int n4) {
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        Runtime$FD runtime$FD = this.fds[n2];
        switch (n3) {
            case 0: {
                int n5;
                if (n4 < 0) return -22;
                if (n4 >= 64) {
                    return -22;
                }
                for (n5 = n4; n5 < 64 && this.fds[n5] != null; ++n5) {
                }
                if (n5 == 64) {
                    return -24;
                }
                this.fds[n5] = runtime$FD.dup();
                return n5;
            }
            case 3: {
                return runtime$FD.flags();
            }
            case 2: {
                this.closeOnExec[n2] = n4 != 0;
                return 0;
            }
            case 1: {
                if (!this.closeOnExec[n2]) return 0;
                return 1;
            }
            case 7: 
            case 8: {
                System.err.println("WARNING: file locking requires UnixRuntime");
                return -88;
            }
        }
        System.err.println(new StringBuffer().append("WARNING: Unknown fcntl command: ").append(n3).toString());
        return -88;
    }

    final int fsync(int n2) {
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        Runtime$FD runtime$FD = this.fds[n2];
        Seekable seekable = runtime$FD.seekable();
        if (seekable == null) {
            return -22;
        }
        try {
            seekable.sync();
            return 0;
        }
        catch (IOException var4_4) {
            return -5;
        }
    }

    protected final int syscall(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        try {
            return this._syscall(n2, n3, n4, n5, n6, n7, n8);
        }
        catch (Runtime$ErrnoException var8_9) {
            return - var8_9.errno;
        }
        catch (Runtime$FaultException var8_10) {
            return -14;
        }
        catch (RuntimeException var8_11) {
            var8_11.printStackTrace();
            throw new Error("Internal Error in _syscall()");
        }
    }

    int _syscall(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        switch (n2) {
            case 0: {
                return 0;
            }
            case 1: {
                return this.sys_exit(n3);
            }
            case 2: {
                return this.sys_pause();
            }
            case 6: {
                return this.sys_write(n3, n4, n5);
            }
            case 8: {
                return this.sys_fstat(n3, n4);
            }
            case 7: {
                return this.sbrk(n3);
            }
            case 3: {
                return this.sys_open(n3, n4, n5);
            }
            case 4: {
                return this.sys_close(n3);
            }
            case 5: {
                return this.sys_read(n3, n4, n5);
            }
            case 10: {
                return this.sys_lseek(n3, n4, n5);
            }
            case 44: {
                return this.sys_ftruncate(n3, n4);
            }
            case 12: {
                return this.sys_getpid();
            }
            case 13: {
                return this.sys_calljava(n3, n4, n5, n6);
            }
            case 15: {
                return this.sys_gettimeofday(n3, n4);
            }
            case 16: {
                return this.sys_sleep(n3);
            }
            case 17: {
                return this.sys_times(n3);
            }
            case 19: {
                return this.sys_getpagesize();
            }
            case 29: {
                return this.sys_fcntl(n3, n4, n5);
            }
            case 31: {
                return this.sys_sysconf(n3);
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
                return this.fsync(n3);
            }
            case 37: {
                this.memcpy(n3, n4, n5);
                return n3;
            }
            case 38: {
                this.memset(n3, n4, n5);
                return n3;
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
                System.err.println(new StringBuffer().append("Attempted to use a UnixRuntime syscall in Runtime (").append(n2).append(")").toString());
                return -88;
            }
        }
        System.err.println(new StringBuffer().append("Attempted to use unknown syscall: ").append(n2).toString());
        return -88;
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

    public int xmalloc(int n2) {
        int n3 = this.malloc(n2);
        if (n3 != 0) return n3;
        throw new RuntimeException("malloc() failed");
    }

    public int xrealloc(int n2, int n3) {
        int n4 = this.realloc(n2, n3);
        if (n4 != 0) return n4;
        throw new RuntimeException("realloc() failed");
    }

    public int realloc(int n2, int n3) {
        try {
            return this.call("realloc", n2, n3);
        }
        catch (Runtime$CallException var3_3) {
            return 0;
        }
    }

    public int malloc(int n2) {
        try {
            return this.call("malloc", n2);
        }
        catch (Runtime$CallException var2_2) {
            return 0;
        }
    }

    public void free(int n2) {
        try {
            if (n2 == 0) return;
            this.call("free", n2);
            return;
        }
        catch (Runtime$CallException var2_2) {
            // empty catch block
        }
    }

    public int strdup(String string) {
        if (string == null) {
            string = "(null)";
        }
        byte[] arrby = Runtime.getBytes(string);
        byte[] arrby2 = new byte[arrby.length + 1];
        System.arraycopy(arrby, 0, arrby2, 0, arrby.length);
        int n2 = this.malloc(arrby2.length);
        if (n2 == 0) {
            return 0;
        }
        try {
            this.copyout(arrby2, n2, arrby2.length);
            return n2;
        }
        catch (Runtime$FaultException var5_5) {
            this.free(n2);
            return 0;
        }
    }

    public final String utfstring(int n2) {
        if (n2 == 0) {
            return null;
        }
        int n3 = n2;
        int n4 = 1;
        while (n4 != 0) {
            n4 = this.memRead(n3 & -4);
            switch (n3 & 3) {
                case 0: {
                    n4 = n4 >>> 24 & 255;
                    break;
                }
                case 1: {
                    n4 = n4 >>> 16 & 255;
                    break;
                }
                case 2: {
                    n4 = n4 >>> 8 & 255;
                    break;
                }
                case 3: {
                    n4 = n4 >>> 0 & 255;
                }
            }
            ++n3;
        }
        if (n3 > n2) {
            --n3;
        }
        byte[] arrby = new byte[n3 - n2];
        this.copyin(n2, arrby, arrby.length);
        try {
            return new String(arrby, "UTF-8");
        }
        catch (UnsupportedEncodingException var4_5) {
            throw new RuntimeException(var4_5);
        }
    }

    public final String cstring(int n2) {
        if (n2 == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        do {
            int n3 = this.memRead(n2 & -4);
            switch (n2 & 3) {
                case 0: {
                    if ((n3 >>> 24 & 255) == 0) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char)(n3 >>> 24 & 255));
                    ++n2;
                }
                case 1: {
                    if ((n3 >>> 16 & 255) == 0) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char)(n3 >>> 16 & 255));
                    ++n2;
                }
                case 2: {
                    if ((n3 >>> 8 & 255) == 0) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char)(n3 >>> 8 & 255));
                    ++n2;
                }
                case 3: {
                    if ((n3 >>> 0 & 255) == 0) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char)(n3 >>> 0 & 255));
                    ++n2;
                }
            }
        } while (true);
    }

    protected final void nullPointerCheck(int n2) {
        if (n2 >= 65536) return;
        throw new Runtime$ExecutionException(new StringBuffer().append("Attempted to dereference a null pointer ").append(Runtime.toHex(n2)).toString());
    }

    byte[] byteBuf(int n2) {
        if (this._byteBuf == null) {
            this._byteBuf = new byte[n2];
            return this._byteBuf;
        }
        if (this._byteBuf.length >= n2) return this._byteBuf;
        this._byteBuf = new byte[Runtime.min(Runtime.max(this._byteBuf.length * 2, n2), 16776192)];
        return this._byteBuf;
    }

    protected static final int[] decodeData(String string, int n2) {
        if (string.length() % 8 != 0) {
            throw new IllegalArgumentException("string length must be a multiple of 8");
        }
        if (string.length() / 8 * 7 < n2 * 4) {
            throw new IllegalArgumentException("string isn't big enough");
        }
        int[] arrn = new int[n2];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        while (n6 < n2) {
            long l2 = 0;
            for (int i2 = 0; i2 < 8; l2 |= (long)(string.charAt((int)(n5 + i2)) & 127), ++i2) {
                l2 <<= 7;
            }
            if (n4 > 0) {
                arrn[n6++] = n3 | (int)(l2 >>> 56 - n4);
            }
            if (n6 < n2) {
                arrn[n6++] = (int)(l2 >>> 24 - n4);
            }
            n4 = n4 + 8 & 31;
            n3 = (int)(l2 << n4);
            n5 += 8;
        }
        return arrn;
    }

    static byte[] getBytes(String string) {
        try {
            return string.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException var1_1) {
            return null;
        }
    }

    static byte[] getNullTerminatedBytes(String string) {
        byte[] arrby = Runtime.getBytes(string);
        byte[] arrby2 = new byte[arrby.length + 1];
        System.arraycopy(arrby, 0, arrby2, 0, arrby.length);
        return arrby2;
    }

    static final String toHex(int n2) {
        return new StringBuffer().append("0x").append(Long.toString((long)n2 & 0xFFFFFFFFL, 16)).toString();
    }

    static final int min(int n2, int n3) {
        int n4;
        if (n2 < n3) {
            n4 = n2;
            return n4;
        }
        n4 = n3;
        return n4;
    }

    static final int max(int n2, int n3) {
        int n4;
        if (n2 > n3) {
            n4 = n2;
            return n4;
        }
        n4 = n3;
        return n4;
    }

    static {
        String string = Platform.getProperty("os.name");
        String string2 = Platform.getProperty("nestedvm.win32hacks");
        if (string2 != null) {
            win32Hacks = Boolean.valueOf(string2);
            return;
        }
        win32Hacks = string != null && string.toLowerCase().indexOf("windows") != -1;
    }
}

