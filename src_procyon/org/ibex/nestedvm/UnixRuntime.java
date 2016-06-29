package org.ibex.nestedvm;

import java.util.*;
import java.lang.reflect.*;
import org.ibex.nestedvm.util.*;
import java.net.*;
import java.io.*;

public abstract class UnixRuntime extends Runtime implements Cloneable
{
    private int pid;
    private UnixRuntime parent;
    private static final UnixRuntime$GlobalState defaultGS;
    private UnixRuntime$GlobalState gs;
    private String cwd;
    private UnixRuntime execedRuntime;
    private Object children;
    private Vector activeChildren;
    private Vector exitedChildren;
    private static final Method runtimeCompilerCompile;
    static Class class$org$ibex$nestedvm$util$Seekable;
    static Class class$java$lang$String;
    
    public final int getPid() {
        return this.pid;
    }
    
    public void setGlobalState(final UnixRuntime$GlobalState gs) {
        if (this.state != 1) {
            throw new IllegalStateException("can't change GlobalState when running");
        }
        if (gs == null) {
            throw new NullPointerException("gs is null");
        }
        this.gs = gs;
    }
    
    protected UnixRuntime(final int n, final int n2) {
        this(n, n2, false);
    }
    
    protected UnixRuntime(final int n, final int n2, final boolean b) {
        super(n, n2, b);
        if (!b) {
            this.gs = UnixRuntime.defaultGS;
            final String property = Platform.getProperty("user.dir");
            this.cwd = ((property == null) ? null : this.gs.mapHostPath(property));
            if (this.cwd == null) {
                this.cwd = "/";
            }
            this.cwd = this.cwd.substring(1);
        }
    }
    
    private static String posixTZ() {
        final StringBuffer sb = new StringBuffer();
        final TimeZone default1 = TimeZone.getDefault();
        int n = default1.getRawOffset() / 1000;
        sb.append(Platform.timeZoneGetDisplayName(default1, false, false));
        if (n > 0) {
            sb.append("-");
        }
        else {
            n = -n;
        }
        sb.append(n / 3600);
        final int n2 = n % 3600;
        if (n2 > 0) {
            sb.append(":").append(n2 / 60);
        }
        final int n3 = n2 % 60;
        if (n3 > 0) {
            sb.append(":").append(n3);
        }
        if (default1.useDaylightTime()) {
            sb.append(Platform.timeZoneGetDisplayName(default1, true, false));
        }
        return sb.toString();
    }
    
    private static boolean envHas(final String s, final String[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != null && array[i].startsWith(s + "=")) {
                return true;
            }
        }
        return false;
    }
    
    String[] createEnv(String[] array) {
        final String[] array2 = new String[7];
        int n = 0;
        if (array == null) {
            array = new String[0];
        }
        if (!envHas("USER", array) && Platform.getProperty("user.name") != null) {
            array2[n++] = "USER=" + Platform.getProperty("user.name");
        }
        final String property;
        final String mapHostPath;
        if (!envHas("HOME", array) && (property = Platform.getProperty("user.home")) != null && (mapHostPath = this.gs.mapHostPath(property)) != null) {
            array2[n++] = "HOME=" + mapHostPath;
        }
        final String property2;
        final String mapHostPath2;
        if (!envHas("TMPDIR", array) && (property2 = Platform.getProperty("java.io.tmpdir")) != null && (mapHostPath2 = this.gs.mapHostPath(property2)) != null) {
            array2[n++] = "TMPDIR=" + mapHostPath2;
        }
        if (!envHas("SHELL", array)) {
            array2[n++] = "SHELL=/bin/sh";
        }
        if (!envHas("TERM", array) && !UnixRuntime.win32Hacks) {
            array2[n++] = "TERM=vt100";
        }
        if (!envHas("TZ", array)) {
            array2[n++] = "TZ=" + posixTZ();
        }
        if (!envHas("PATH", array)) {
            array2[n++] = "PATH=/usr/local/bin:/usr/bin:/bin:/usr/local/sbin:/usr/sbin:/sbin";
        }
        final String[] array3 = new String[array.length + n];
        for (int i = 0; i < n; ++i) {
            array3[i] = array2[i];
        }
        for (int j = 0; j < array.length; ++j) {
            array3[n++] = array[j];
        }
        return array3;
    }
    
    void _started() {
        final UnixRuntime[] tasks = this.gs.tasks;
        synchronized (this.gs) {
            if (this.pid != 0) {
                final UnixRuntime unixRuntime = tasks[this.pid];
                if (unixRuntime == null || unixRuntime == this || unixRuntime.pid != this.pid || unixRuntime.parent != this.parent) {
                    throw new Error("should never happen");
                }
                synchronized (this.parent.children) {
                    final int index = this.parent.activeChildren.indexOf(unixRuntime);
                    if (index == -1) {
                        throw new Error("should never happen");
                    }
                    this.parent.activeChildren.setElementAt(this, index);
                }
            }
            else {
                int pid = -1;
                int i;
                int n;
                for (n = (i = this.gs.nextPID); i < tasks.length; ++i) {
                    if (tasks[i] == null) {
                        pid = i;
                        break;
                    }
                }
                if (pid == -1) {
                    for (int j = 1; j < n; ++j) {
                        if (tasks[j] == null) {
                            pid = j;
                            break;
                        }
                    }
                }
                if (pid == -1) {
                    throw new UnixRuntime$ProcessTableFullExn((UnixRuntime$1)null);
                }
                this.pid = pid;
                this.gs.nextPID = pid + 1;
            }
            tasks[this.pid] = this;
        }
    }
    
    int _syscall(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        switch (n) {
            case 11: {
                return this.sys_kill(n2, n3);
            }
            case 25: {
                return this.sys_fork();
            }
            case 23: {
                return this.sys_pipe(n2);
            }
            case 24: {
                return this.sys_dup2(n2, n3);
            }
            case 39: {
                return this.sys_dup(n2);
            }
            case 26: {
                return this.sys_waitpid(n2, n3, n4);
            }
            case 14: {
                return this.sys_stat(n2, n3);
            }
            case 33: {
                return this.sys_lstat(n2, n3);
            }
            case 18: {
                return this.sys_mkdir(n2, n3);
            }
            case 27: {
                return this.sys_getcwd(n2, n3);
            }
            case 22: {
                return this.sys_chdir(n2);
            }
            case 28: {
                return this.sys_exec(n2, n3, n4);
            }
            case 36: {
                return this.sys_getdents(n2, n3, n4, n5);
            }
            case 20: {
                return this.sys_unlink(n2);
            }
            case 46: {
                return this.sys_getppid();
            }
            case 56: {
                return this.sys_socket(n2, n3, n4);
            }
            case 57: {
                return this.sys_connect(n2, n3, n4);
            }
            case 58: {
                return this.sys_resolve_hostname(n2, n3, n4);
            }
            case 60: {
                return this.sys_setsockopt(n2, n3, n4, n5, n6);
            }
            case 61: {
                return this.sys_getsockopt(n2, n3, n4, n5, n6);
            }
            case 63: {
                return this.sys_bind(n2, n3, n4);
            }
            case 62: {
                return this.sys_listen(n2, n3);
            }
            case 59: {
                return this.sys_accept(n2, n3, n4);
            }
            case 64: {
                return this.sys_shutdown(n2, n3);
            }
            case 53: {
                return this.sys_sysctl(n2, n3, n4, n5, n6, n7);
            }
            case 65: {
                return this.sys_sendto(n2, n3, n4, n5, n6, n7);
            }
            case 66: {
                return this.sys_recvfrom(n2, n3, n4, n5, n6, n7);
            }
            case 67: {
                return this.sys_select(n2, n3, n4, n5, n6);
            }
            case 78: {
                return this.sys_access(n2, n3);
            }
            case 52: {
                return this.sys_realpath(n2, n3);
            }
            case 76: {
                return this.sys_chown(n2, n3, n4);
            }
            case 43: {
                return this.sys_chown(n2, n3, n4);
            }
            case 77: {
                return this.sys_fchown(n2, n3, n4);
            }
            case 74: {
                return this.sys_chmod(n2, n3, n4);
            }
            case 75: {
                return this.sys_fchmod(n2, n3, n4);
            }
            case 29: {
                return this.sys_fcntl_lock(n2, n3, n4);
            }
            case 73: {
                return this.sys_umask(n2);
            }
            default: {
                return super._syscall(n, n2, n3, n4, n5, n6, n7);
            }
        }
    }
    
    Runtime$FD _open(String normalizePath, final int n, final int n2) {
        normalizePath = this.normalizePath(normalizePath);
        final Runtime$FD open = this.gs.open(this, normalizePath, n, n2);
        if (open != null && normalizePath != null) {
            open.setNormalizedPath(normalizePath);
        }
        return open;
    }
    
    private int sys_getppid() {
        return (this.parent == null) ? 1 : this.parent.pid;
    }
    
    private int sys_chown(final int n, final int n2, final int n3) {
        return 0;
    }
    
    private int sys_lchown(final int n, final int n2, final int n3) {
        return 0;
    }
    
    private int sys_fchown(final int n, final int n2, final int n3) {
        return 0;
    }
    
    private int sys_chmod(final int n, final int n2, final int n3) {
        return 0;
    }
    
    private int sys_fchmod(final int n, final int n2, final int n3) {
        return 0;
    }
    
    private int sys_umask(final int n) {
        return 0;
    }
    
    private int sys_access(final int n, final int n2) {
        return (this.gs.stat(this, this.cstring(n)) == null) ? -2 : 0;
    }
    
    private int sys_realpath(final int n, final int n2) {
        final byte[] nullTerminatedBytes = Runtime.getNullTerminatedBytes(this.normalizePath(this.cstring(n)));
        if (nullTerminatedBytes.length > 1024) {
            return -34;
        }
        this.copyout(nullTerminatedBytes, n2, nullTerminatedBytes.length);
        return 0;
    }
    
    private int sys_kill(final int n, final int n2) {
        if (n != n) {
            return -3;
        }
        if (n2 < 0 || n2 >= 32) {
            return -22;
        }
        switch (n2) {
            case 0: {
                return 0;
            }
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 28: {
                break;
            }
            default: {
                this.exit(128 + n2, true);
                break;
            }
        }
        return 0;
    }
    
    private int sys_waitpid(final int n, final int n2, final int n3) {
        if ((n3 & 0xFFFFFFFE) != 0x0) {
            return -22;
        }
        if (n == 0 || n < -1) {
            System.err.println("WARNING: waitpid called with a pid of " + n);
            return -10;
        }
        final boolean b = (n3 & 0x1) == 0x0;
        if (n != -1 && (n <= 0 || n >= this.gs.tasks.length)) {
            return -10;
        }
        if (this.children == null) {
            return b ? -10 : 0;
        }
        UnixRuntime unixRuntime = null;
        synchronized (this.children) {
            while (true) {
                if (n == -1) {
                    if (this.exitedChildren.size() > 0) {
                        unixRuntime = this.exitedChildren.elementAt(this.exitedChildren.size() - 1);
                        this.exitedChildren.removeElementAt(this.exitedChildren.size() - 1);
                    }
                }
                else {
                    if (n <= 0) {
                        throw new Error("should never happen");
                    }
                    if (n >= this.gs.tasks.length) {
                        return -10;
                    }
                    final UnixRuntime unixRuntime2 = this.gs.tasks[n];
                    if (unixRuntime2.parent != this) {
                        return -10;
                    }
                    if (unixRuntime2.state == 4) {
                        if (!this.exitedChildren.removeElement(unixRuntime2)) {
                            throw new Error("should never happen");
                        }
                        unixRuntime = unixRuntime2;
                    }
                }
                if (unixRuntime != null) {
                    this.gs.tasks[unixRuntime.pid] = null;
                    break;
                }
                if (!b) {
                    return 0;
                }
                try {
                    this.children.wait();
                }
                catch (InterruptedException ex) {}
            }
        }
        if (n2 != 0) {
            this.memWrite(n2, unixRuntime.exitStatus() << 8);
        }
        return unixRuntime.pid;
    }
    
    void _exited() {
        if (this.children != null) {
            synchronized (this.children) {
                final Enumeration<UnixRuntime> elements = this.exitedChildren.elements();
                while (elements.hasMoreElements()) {
                    this.gs.tasks[elements.nextElement().pid] = null;
                }
                this.exitedChildren.removeAllElements();
                final Enumeration<UnixRuntime> elements2 = this.activeChildren.elements();
                while (elements2.hasMoreElements()) {
                    elements2.nextElement().parent = null;
                }
                this.activeChildren.removeAllElements();
            }
        }
        final UnixRuntime parent = this.parent;
        if (parent == null) {
            this.gs.tasks[this.pid] = null;
        }
        else {
            synchronized (parent.children) {
                if (this.parent == null) {
                    this.gs.tasks[this.pid] = null;
                }
                else {
                    if (!this.parent.activeChildren.removeElement(this)) {
                        throw new Error("should never happen _exited: pid: " + this.pid);
                    }
                    this.parent.exitedChildren.addElement(this);
                    this.parent.children.notify();
                }
            }
        }
    }
    
    protected Object clone() {
        final UnixRuntime unixRuntime = (UnixRuntime)super.clone();
        unixRuntime.pid = 0;
        unixRuntime.parent = null;
        unixRuntime.children = null;
        final UnixRuntime unixRuntime2 = unixRuntime;
        final UnixRuntime unixRuntime3 = unixRuntime;
        final Vector vector = null;
        unixRuntime3.exitedChildren = vector;
        unixRuntime2.activeChildren = vector;
        return unixRuntime;
    }
    
    private int sys_fork() {
        UnixRuntime unixRuntime;
        try {
            unixRuntime = (UnixRuntime)this.clone();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -12;
        }
        unixRuntime.parent = this;
        try {
            unixRuntime._started();
        }
        catch (UnixRuntime$ProcessTableFullExn unixRuntime$ProcessTableFullExn) {
            return -12;
        }
        if (this.children == null) {
            this.children = new Object();
            this.activeChildren = new Vector();
            this.exitedChildren = new Vector();
        }
        this.activeChildren.addElement(unixRuntime);
        final Runtime$CPUState cpuState = new Runtime$CPUState();
        this.getCPUState(cpuState);
        cpuState.r[2] = 0;
        final Runtime$CPUState runtime$CPUState = cpuState;
        runtime$CPUState.pc += 4;
        unixRuntime.setCPUState(cpuState);
        unixRuntime.state = 2;
        new UnixRuntime$ForkedProcess(unixRuntime);
        return unixRuntime.pid;
    }
    
    public static int runAndExec(final UnixRuntime unixRuntime, final String s, final String[] array) {
        return runAndExec(unixRuntime, Runtime.concatArgv(s, array));
    }
    
    public static int runAndExec(final UnixRuntime unixRuntime, final String[] array) {
        unixRuntime.start(array);
        return executeAndExec(unixRuntime);
    }
    
    public static int executeAndExec(UnixRuntime execedRuntime) {
        while (true) {
            if (execedRuntime.execute()) {
                if (execedRuntime.state != 5) {
                    break;
                }
                execedRuntime = execedRuntime.execedRuntime;
            }
            else {
                System.err.println("WARNING: Pause requested while executing runAndExec()");
            }
        }
        return execedRuntime.exitStatus();
    }
    
    private String[] readStringArray(final int n) {
        int n2 = 0;
        for (int n3 = n; this.memRead(n3) != 0; n3 += 4) {
            ++n2;
        }
        final String[] array = new String[n2];
        for (int i = 0, n4 = n; i < n2; ++i, n4 += 4) {
            array[i] = this.cstring(this.memRead(n4));
        }
        return array;
    }
    
    private int sys_exec(final int n, final int n2, final int n3) {
        return this.exec(this.normalizePath(this.cstring(n)), this.readStringArray(n2), this.readStringArray(n3));
    }
    
    public Class runtimeCompile(final Seekable seekable, final String s) {
        if (UnixRuntime.runtimeCompilerCompile == null) {
            System.err.println("WARNING: Exec attempted but RuntimeCompiler not found!");
            return null;
        }
        try {
            return (Class)UnixRuntime.runtimeCompilerCompile.invoke(null, seekable, "unixruntime,maxinsnpermethod=256,lessconstants", s);
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
            return null;
        }
        catch (InvocationTargetException ex2) {
            final Throwable targetException = ex2.getTargetException();
            if (targetException instanceof IOException) {
                throw (IOException)targetException;
            }
            if (targetException instanceof RuntimeException) {
                throw (RuntimeException)targetException;
            }
            if (targetException instanceof Error) {
                throw (Error)targetException;
            }
            targetException.printStackTrace();
            return null;
        }
    }
    
    private int exec(final String s, String[] array, final String[] array2) {
        if (array.length == 0) {
            array = new String[] { "" };
        }
        if (s.equals("bin/busybox") && this.getClass().getName().endsWith("BusyBox")) {
            return this.execClass(this.getClass(), array, array2);
        }
        final Runtime$FStat stat = this.gs.stat(this, s);
        if (stat == null) {
            return -2;
        }
        final UnixRuntime$GlobalState$CacheEnt unixRuntime$GlobalState$CacheEnt = this.gs.execCache.get(s);
        final long n = stat.mtime();
        final long n2 = stat.size();
        if (unixRuntime$GlobalState$CacheEnt != null) {
            if (unixRuntime$GlobalState$CacheEnt.time == n && unixRuntime$GlobalState$CacheEnt.size == n2) {
                if (unixRuntime$GlobalState$CacheEnt.o instanceof Class) {
                    return this.execClass((Class)unixRuntime$GlobalState$CacheEnt.o, array, array2);
                }
                if (unixRuntime$GlobalState$CacheEnt.o instanceof String[]) {
                    return this.execScript(s, (String[])unixRuntime$GlobalState$CacheEnt.o, array, array2);
                }
                throw new Error("should never happen");
            }
            else {
                this.gs.execCache.remove(s);
            }
        }
        final Runtime$FD open = this.gs.open(this, s, 0, 0);
        if (open == null) {
            throw new Runtime$ErrnoException(2);
        }
        final Seekable seekable = open.seekable();
        if (seekable == null) {
            throw new Runtime$ErrnoException(13);
        }
        final byte[] array3 = new byte[4096];
        try {
            int n3 = seekable.read(array3, 0, array3.length);
            if (n3 == -1) {
                throw new Runtime$ErrnoException(8);
            }
            switch (array3[0]) {
                case Byte.MAX_VALUE: {
                    if (n3 < 4) {
                        seekable.tryReadFully(array3, n3, 4 - n3);
                    }
                    if (array3[1] != 69 || array3[2] != 76 || array3[3] != 70) {
                        return -8;
                    }
                    seekable.seek(0);
                    System.err.println("Running RuntimeCompiler for " + s);
                    final Class runtimeCompile = this.runtimeCompile(seekable, s);
                    System.err.println("RuntimeCompiler finished for " + s);
                    if (runtimeCompile == null) {
                        throw new Runtime$ErrnoException(8);
                    }
                    this.gs.execCache.put(s, new UnixRuntime$GlobalState$CacheEnt(n, n2, runtimeCompile));
                    return this.execClass(runtimeCompile, array, array2);
                }
                case 35: {
                    if (n3 == 1) {
                        final int read = seekable.read(array3, 1, array3.length - 1);
                        if (read == -1) {
                            return -8;
                        }
                        n3 += read;
                    }
                    if (array3[1] != 33) {
                        return -8;
                    }
                    int n4 = 2;
                    n3 -= 2;
                Label_0656:
                    while (true) {
                        for (int i = n4; i < n4 + n3; ++i) {
                            if (array3[i] == 10) {
                                n4 = i;
                                break Label_0656;
                            }
                        }
                        n4 += n3;
                        if (n4 == array3.length) {
                            break;
                        }
                        n3 = seekable.read(array3, n4, array3.length - n4);
                    }
                    int n5;
                    for (n5 = 2; n5 < n4 && array3[n5] == 32; ++n5) {}
                    if (n5 == n4) {
                        throw new Runtime$ErrnoException(8);
                    }
                    int n6;
                    for (n6 = n5; n6 < n4 && array3[n6] != 32; ++n6) {}
                    final int n7 = n6;
                    while (n6 < n4 && array3[n6] == 32) {
                        ++n6;
                    }
                    final String[] array4 = { new String(array3, n5, n7 - n5), (n6 < n4) ? new String(array3, n6, n4 - n6) : null };
                    this.gs.execCache.put(s, new UnixRuntime$GlobalState$CacheEnt(n, n2, array4));
                    return this.execScript(s, array4, array, array2);
                }
                default: {
                    return -8;
                }
            }
        }
        catch (IOException ex) {
            return -5;
        }
        finally {
            open.close();
        }
    }
    
    public int execScript(final String s, final String[] array, final String[] array2, final String[] array3) {
        final String[] array4 = new String[array2.length - 1 + ((array[1] != null) ? 3 : 2)];
        final int lastIndex = array[0].lastIndexOf(47);
        array4[0] = ((lastIndex == -1) ? array[0] : array[0].substring(lastIndex + 1));
        array4[1] = "/" + s;
        int n = 2;
        if (array[1] != null) {
            array4[n++] = array[1];
        }
        for (int i = 1; i < array2.length; ++i) {
            array4[n++] = array2[i];
        }
        if (n != array4.length) {
            throw new Error("p != newArgv.length");
        }
        System.err.println("Execing: " + array[0]);
        for (int j = 0; j < array4.length; ++j) {
            System.err.println("execing [" + j + "] " + array4[j]);
        }
        return this.exec(array[0], array4, array3);
    }
    
    public int execClass(final Class clazz, final String[] array, final String[] array2) {
        try {
            return this.exec(clazz.getDeclaredConstructor(Boolean.TYPE).newInstance(Boolean.TRUE), array, array2);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -8;
        }
    }
    
    private int exec(final UnixRuntime execedRuntime, final String[] array, final String[] array2) {
        for (int i = 0; i < 64; ++i) {
            if (this.closeOnExec[i]) {
                this.closeFD(i);
            }
        }
        execedRuntime.fds = this.fds;
        execedRuntime.closeOnExec = this.closeOnExec;
        this.fds = null;
        this.closeOnExec = null;
        execedRuntime.gs = this.gs;
        execedRuntime.sm = this.sm;
        execedRuntime.cwd = this.cwd;
        execedRuntime.pid = this.pid;
        execedRuntime.parent = this.parent;
        execedRuntime.start(array, array2);
        this.state = 5;
        this.execedRuntime = execedRuntime;
        return 0;
    }
    
    private int sys_pipe(final int n) {
        final UnixRuntime$Pipe unixRuntime$Pipe = new UnixRuntime$Pipe();
        final int addFD = this.addFD(unixRuntime$Pipe.reader);
        if (addFD < 0) {
            return -23;
        }
        final int addFD2 = this.addFD(unixRuntime$Pipe.writer);
        if (addFD2 < 0) {
            this.closeFD(addFD);
            return -23;
        }
        try {
            this.memWrite(n, addFD);
            this.memWrite(n + 4, addFD2);
        }
        catch (Runtime$FaultException ex) {
            this.closeFD(addFD);
            this.closeFD(addFD2);
            return -14;
        }
        return 0;
    }
    
    private int sys_dup2(final int n, final int n2) {
        if (n == n2) {
            return 0;
        }
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (n2 < 0 || n2 >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        if (this.fds[n2] != null) {
            this.fds[n2].close();
        }
        this.fds[n2] = this.fds[n].dup();
        return 0;
    }
    
    private int sys_dup(final int n) {
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final Runtime$FD dup = this.fds[n].dup();
        final int addFD = this.addFD(dup);
        if (addFD < 0) {
            dup.close();
            return -23;
        }
        return addFD;
    }
    
    private int sys_stat(final int n, final int n2) {
        final Runtime$FStat stat = this.gs.stat(this, this.normalizePath(this.cstring(n)));
        if (stat == null) {
            return -2;
        }
        return this.stat(stat, n2);
    }
    
    private int sys_lstat(final int n, final int n2) {
        final Runtime$FStat lstat = this.gs.lstat(this, this.normalizePath(this.cstring(n)));
        if (lstat == null) {
            return -2;
        }
        return this.stat(lstat, n2);
    }
    
    private int sys_mkdir(final int n, final int n2) {
        this.gs.mkdir(this, this.normalizePath(this.cstring(n)), n2);
        return 0;
    }
    
    private int sys_unlink(final int n) {
        this.gs.unlink(this, this.normalizePath(this.cstring(n)));
        return 0;
    }
    
    private int sys_getcwd(final int n, final int n2) {
        final byte[] bytes = Runtime.getBytes(this.cwd);
        if (n2 == 0) {
            return -22;
        }
        if (n2 < bytes.length + 2) {
            return -34;
        }
        this.memset(n, 47, 1);
        this.copyout(bytes, n + 1, bytes.length);
        this.memset(n + bytes.length + 1, 0, 1);
        return n;
    }
    
    private int sys_chdir(final int n) {
        final String normalizePath = this.normalizePath(this.cstring(n));
        final Runtime$FStat stat = this.gs.stat(this, normalizePath);
        if (stat == null) {
            return -2;
        }
        if (stat.type() != 16384) {
            return -20;
        }
        this.cwd = normalizePath;
        return 0;
    }
    
    private int sys_getdents(final int n, final int n2, int min, final int n3) {
        min = Math.min(min, 16776192);
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final byte[] byteBuf = this.byteBuf(min);
        final int getdents = this.fds[n].getdents(byteBuf, 0, min);
        this.copyout(byteBuf, n2, getdents);
        return getdents;
    }
    
    void _preCloseFD(final Runtime$FD runtime$FD) {
        final Seekable seekable = runtime$FD.seekable();
        if (seekable == null) {
            return;
        }
        try {
            for (int i = 0; i < this.gs.locks.length; ++i) {
                final Seekable$Lock seekable$Lock = this.gs.locks[i];
                if (seekable$Lock != null) {
                    if (seekable.equals(seekable$Lock.seekable()) && seekable$Lock.getOwner() == this) {
                        seekable$Lock.release();
                        this.gs.locks[i] = null;
                    }
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    void _postCloseFD(final Runtime$FD runtime$FD) {
        if (runtime$FD.isMarkedForDeleteOnClose()) {
            try {
                this.gs.unlink(this, runtime$FD.getNormalizedPath());
            }
            catch (Throwable t) {}
        }
    }
    
    private int sys_fcntl_lock(final int n, final int n2, final int n3) {
        if (n2 != 7 && n2 != 8) {
            return this.sys_fcntl(n, n2, n3);
        }
        if (n < 0 || n >= 64) {
            return -81;
        }
        if (this.fds[n] == null) {
            return -81;
        }
        final Runtime$FD runtime$FD = this.fds[n];
        if (n3 == 0) {
            return -22;
        }
        final int memRead = this.memRead(n3);
        int memRead2 = this.memRead(n3 + 4);
        final int memRead3 = this.memRead(n3 + 8);
        final int n4 = memRead >> 16;
        final int n5 = memRead & 0xFF;
        final Seekable$Lock[] locks = this.gs.locks;
        final Seekable seekable = runtime$FD.seekable();
        if (seekable == null) {
            return -22;
        }
        try {
            switch (n5) {
                case 0: {
                    break;
                }
                case 1: {
                    memRead2 += seekable.pos();
                    break;
                }
                case 2: {
                    memRead2 += seekable.length();
                    break;
                }
                default: {
                    return -1;
                }
            }
            if (n2 == 7) {
                for (int i = 0; i < locks.length; ++i) {
                    if (locks[i] != null) {
                        if (seekable.equals(locks[i].seekable())) {
                            if (locks[i].overlaps(memRead2, memRead3)) {
                                if (locks[i].getOwner() != this) {
                                    if (!locks[i].isShared() || n4 != 1) {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
                final Seekable$Lock lock = seekable.lock(memRead2, memRead3, n4 == 1);
                if (lock != null) {
                    this.memWrite(n3, 196608);
                    lock.release();
                }
                return 0;
            }
            if (n2 != 8) {
                return -22;
            }
            if (n4 == 3) {
                for (int j = 0; j < locks.length; ++j) {
                    if (locks[j] != null) {
                        if (seekable.equals(locks[j].seekable())) {
                            if (locks[j].getOwner() == this) {
                                final int n6 = (int)locks[j].position();
                                if (n6 >= memRead2) {
                                    if (memRead2 == 0 || memRead3 == 0 || n6 + locks[j].size() <= memRead2 + memRead3) {
                                        locks[j].release();
                                        locks[j] = null;
                                    }
                                }
                            }
                        }
                    }
                }
                return 0;
            }
            if (n4 != 1 && n4 != 2) {
                return -22;
            }
            for (int k = 0; k < locks.length; ++k) {
                if (locks[k] != null) {
                    if (seekable.equals(locks[k].seekable())) {
                        if (locks[k].getOwner() == this) {
                            if (locks[k].contained(memRead2, memRead3)) {
                                locks[k].release();
                                locks[k] = null;
                            }
                            else if (locks[k].contains(memRead2, memRead3)) {
                                if (locks[k].isShared() == (n4 == 1)) {
                                    this.memWrite(n3 + 4, (int)locks[k].position());
                                    this.memWrite(n3 + 8, (int)locks[k].size());
                                    return 0;
                                }
                                locks[k].release();
                                locks[k] = null;
                            }
                        }
                        else if (locks[k].overlaps(memRead2, memRead3) && (!locks[k].isShared() || n4 == 2)) {
                            return -11;
                        }
                    }
                }
            }
            final Seekable$Lock lock2 = seekable.lock(memRead2, memRead3, n4 == 1);
            if (lock2 == null) {
                return -11;
            }
            lock2.setOwner(this);
            int n7;
            for (n7 = 0; n7 < locks.length && locks[n7] != null; ++n7) {}
            if (n7 == locks.length) {
                return -46;
            }
            locks[n7] = lock2;
            return 0;
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private int sys_socket(final int n, final int n2, final int n3) {
        if (n != 2 || (n2 != 1 && n2 != 2)) {
            return -123;
        }
        return this.addFD(new UnixRuntime$SocketFD((int)((n2 != 1) ? 1 : 0)));
    }
    
    private UnixRuntime$SocketFD getSocketFD(final int n) {
        if (n < 0 || n >= 64) {
            throw new Runtime$ErrnoException(81);
        }
        if (this.fds[n] == null) {
            throw new Runtime$ErrnoException(81);
        }
        if (!(this.fds[n] instanceof UnixRuntime$SocketFD)) {
            throw new Runtime$ErrnoException(108);
        }
        return (UnixRuntime$SocketFD)this.fds[n];
    }
    
    private int sys_connect(final int n, final int n2, final int n3) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (socketFD.type() == 0 && (socketFD.s != null || socketFD.ss != null)) {
            return -127;
        }
        final int memRead = this.memRead(n2);
        if ((memRead >>> 16 & 0xFF) != 0x2) {
            return -106;
        }
        final int connectPort = memRead & 0xFFFF;
        final byte[] array = new byte[4];
        this.copyin(n2 + 4, array, 4);
        InetAddress inetAddressFromBytes;
        try {
            inetAddressFromBytes = Platform.inetAddressFromBytes(array);
        }
        catch (UnknownHostException ex) {
            return -125;
        }
        socketFD.connectAddr = inetAddressFromBytes;
        socketFD.connectPort = connectPort;
        try {
            switch (socketFD.type()) {
                case 0: {
                    final Socket s = new Socket(inetAddressFromBytes, connectPort);
                    socketFD.s = s;
                    socketFD.setOptions();
                    socketFD.is = s.getInputStream();
                    socketFD.os = s.getOutputStream();
                    break;
                }
                case 1: {
                    break;
                }
                default: {
                    throw new Error("should never happen");
                }
            }
        }
        catch (IOException ex2) {
            return -111;
        }
        return 0;
    }
    
    private int sys_resolve_hostname(final int n, int n2, final int n3) {
        final String cstring = this.cstring(n);
        final int memRead = this.memRead(n3);
        InetAddress[] allByName;
        try {
            allByName = InetAddress.getAllByName(cstring);
        }
        catch (UnknownHostException ex) {
            return 1;
        }
        final int min = Runtime.min(memRead / 4, allByName.length);
        for (int i = 0; i < min; ++i, n2 += 4) {
            this.copyout(allByName[i].getAddress(), n2, 4);
        }
        this.memWrite(n3, min * 4);
        return 0;
    }
    
    private int sys_setsockopt(final int n, final int n2, final int n3, final int n4, final int n5) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        switch (n2) {
            case 65535: {
                switch (n3) {
                    case 4:
                    case 8: {
                        if (n5 != 4) {
                            return -22;
                        }
                        if (this.memRead(n4) != 0) {
                            final UnixRuntime$SocketFD unixRuntime$SocketFD = socketFD;
                            unixRuntime$SocketFD.options |= n3;
                        }
                        else {
                            final UnixRuntime$SocketFD unixRuntime$SocketFD2 = socketFD;
                            unixRuntime$SocketFD2.options &= ~n3;
                        }
                        socketFD.setOptions();
                        return 0;
                    }
                    default: {
                        System.err.println("Unknown setsockopt name passed: " + n3);
                        return -109;
                    }
                }
                break;
            }
            default: {
                System.err.println("Unknown setsockopt leve passed: " + n2);
                return -109;
            }
        }
    }
    
    private int sys_getsockopt(final int n, final int n2, final int n3, final int n4, final int n5) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        switch (n2) {
            case 65535: {
                switch (n3) {
                    case 4:
                    case 8: {
                        if (this.memRead(n5) < 4) {
                            return -22;
                        }
                        this.memWrite(n4, ((socketFD.options & n3) != 0x0) ? 1 : 0);
                        this.memWrite(n5, 4);
                        return 0;
                    }
                    default: {
                        System.err.println("Unknown setsockopt name passed: " + n3);
                        return -109;
                    }
                }
                break;
            }
            default: {
                System.err.println("Unknown setsockopt leve passed: " + n2);
                return -109;
            }
        }
    }
    
    private int sys_bind(final int n, final int n2, final int n3) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (socketFD.type() == 0 && (socketFD.s != null || socketFD.ss != null)) {
            return -127;
        }
        final int memRead = this.memRead(n2);
        if ((memRead >>> 16 & 0xFF) != 0x2) {
            return -106;
        }
        final int bindPort = memRead & 0xFFFF;
        InetAddress inetAddressFromBytes = null;
        if (this.memRead(n2 + 4) != 0) {
            final byte[] array = new byte[4];
            this.copyin(n2 + 4, array, 4);
            try {
                inetAddressFromBytes = Platform.inetAddressFromBytes(array);
            }
            catch (UnknownHostException ex) {
                return -125;
            }
        }
        switch (socketFD.type()) {
            case 0: {
                socketFD.bindAddr = inetAddressFromBytes;
                socketFD.bindPort = bindPort;
                return 0;
            }
            case 1: {
                if (socketFD.ds != null) {
                    socketFD.ds.close();
                }
                try {
                    socketFD.ds = ((inetAddressFromBytes != null) ? new DatagramSocket(bindPort, inetAddressFromBytes) : new DatagramSocket(bindPort));
                }
                catch (IOException ex2) {
                    return -112;
                }
                return 0;
            }
            default: {
                throw new Error("should never happen");
            }
        }
    }
    
    private int sys_listen(final int n, final int n2) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (socketFD.type() != 0) {
            return -95;
        }
        if (socketFD.ss != null || socketFD.s != null) {
            return -127;
        }
        if (socketFD.bindPort < 0) {
            return -95;
        }
        try {
            socketFD.ss = new ServerSocket(socketFD.bindPort, n2, socketFD.bindAddr);
            final UnixRuntime$SocketFD unixRuntime$SocketFD = socketFD;
            unixRuntime$SocketFD.flags |= 0x2;
            return 0;
        }
        catch (IOException ex) {
            return -112;
        }
    }
    
    private int sys_accept(final int n, final int n2, final int n3) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (socketFD.type() != 0) {
            return -95;
        }
        if (!socketFD.listen()) {
            return -95;
        }
        final int memRead = this.memRead(n3);
        final ServerSocket ss = socketFD.ss;
        Socket accept;
        try {
            accept = ss.accept();
        }
        catch (IOException ex) {
            return -5;
        }
        if (memRead >= 8) {
            this.memWrite(n2, 0x6020000 | accept.getPort());
            this.copyout(accept.getInetAddress().getAddress(), n2 + 4, 4);
            this.memWrite(n3, 8);
        }
        final UnixRuntime$SocketFD unixRuntime$SocketFD = new UnixRuntime$SocketFD(0);
        unixRuntime$SocketFD.s = accept;
        try {
            unixRuntime$SocketFD.is = accept.getInputStream();
            unixRuntime$SocketFD.os = accept.getOutputStream();
        }
        catch (IOException ex2) {
            return -5;
        }
        final int addFD = this.addFD(unixRuntime$SocketFD);
        if (addFD == -1) {
            unixRuntime$SocketFD.close();
            return -23;
        }
        return addFD;
    }
    
    private int sys_shutdown(final int n, final int n2) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (socketFD.type() != 0 || socketFD.listen()) {
            return -95;
        }
        if (socketFD.s == null) {
            return -128;
        }
        final Socket s = socketFD.s;
        try {
            if (n2 == 0 || n2 == 2) {
                Platform.socketHalfClose(s, false);
            }
            if (n2 == 1 || n2 == 2) {
                Platform.socketHalfClose(s, true);
            }
        }
        catch (IOException ex) {
            return -5;
        }
        return 0;
    }
    
    private int sys_sendto(final int n, final int n2, int min, final int n3, final int n4, final int n5) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (n3 != 0) {
            throw new Runtime$ErrnoException(22);
        }
        final int memRead = this.memRead(n4);
        if ((memRead >>> 16 & 0xFF) != 0x2) {
            return -106;
        }
        final int n6 = memRead & 0xFFFF;
        final byte[] array = new byte[4];
        this.copyin(n4 + 4, array, 4);
        InetAddress inetAddressFromBytes;
        try {
            inetAddressFromBytes = Platform.inetAddressFromBytes(array);
        }
        catch (UnknownHostException ex2) {
            return -125;
        }
        min = Math.min(min, 16776192);
        final byte[] byteBuf = this.byteBuf(min);
        this.copyin(n2, byteBuf, min);
        try {
            return socketFD.sendto(byteBuf, 0, min, inetAddressFromBytes, n6);
        }
        catch (Runtime$ErrnoException ex) {
            if (ex.errno == 32) {
                this.exit(141, true);
            }
            throw ex;
        }
    }
    
    private int sys_recvfrom(final int n, final int n2, int min, final int n3, final int n4, final int n5) {
        final UnixRuntime$SocketFD socketFD = this.getSocketFD(n);
        if (n3 != 0) {
            throw new Runtime$ErrnoException(22);
        }
        final InetAddress[] array = (InetAddress[])((n4 == 0) ? null : new InetAddress[1]);
        final int[] array2 = (int[])((n4 == 0) ? null : new int[1]);
        min = Math.min(min, 16776192);
        final byte[] byteBuf = this.byteBuf(min);
        final int recvfrom = socketFD.recvfrom(byteBuf, 0, min, array, array2);
        this.copyout(byteBuf, n2, recvfrom);
        if (n4 != 0) {
            this.memWrite(n4, 0x20000 | array2[0]);
            this.copyout(array[0].getAddress(), n4 + 4, 4);
        }
        return recvfrom;
    }
    
    private int sys_select(final int n, final int n2, final int n3, final int n4, final int n5) {
        return -88;
    }
    
    private static String hostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException ex) {
            return "darkstar";
        }
    }
    
    private int sys_sysctl(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        if (n5 != 0) {
            return -1;
        }
        if (n2 == 0) {
            return -2;
        }
        if (n3 == 0) {
            return 0;
        }
        Serializable hostName = null;
        Label_0193: {
            switch (this.memRead(n)) {
                case 1: {
                    if (n2 != 2) {
                        break;
                    }
                    switch (this.memRead(n + 4)) {
                        case 1: {
                            hostName = "NestedVM";
                            break;
                        }
                        case 10: {
                            hostName = hostName();
                            break;
                        }
                        case 2: {
                            hostName = "1.0";
                            break;
                        }
                        case 4: {
                            hostName = "NestedVM Kernel Version 1.0";
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    if (n2 != 2) {
                        break;
                    }
                    switch (this.memRead(n + 4)) {
                        case 1: {
                            hostName = "NestedVM Virtual Machine";
                            break Label_0193;
                        }
                    }
                    break;
                }
            }
        }
        if (hostName == null) {
            return -2;
        }
        final int memRead = this.memRead(n4);
        if (hostName instanceof String) {
            final byte[] nullTerminatedBytes = Runtime.getNullTerminatedBytes((String)hostName);
            if (memRead < nullTerminatedBytes.length) {
                return -12;
            }
            final int length = nullTerminatedBytes.length;
            this.copyout(nullTerminatedBytes, n3, length);
            this.memWrite(n4, length);
        }
        else {
            if (!(hostName instanceof Integer)) {
                throw new Error("should never happen");
            }
            if (memRead < 4) {
                return -12;
            }
            this.memWrite(n3, (int)hostName);
        }
        return 0;
    }
    
    private String normalizePath(final String s) {
        final boolean startsWith = s.startsWith("/");
        final int length = this.cwd.length();
        if (!s.startsWith(".") && s.indexOf("./") == -1 && s.indexOf("//") == -1 && !s.endsWith(".")) {
            return startsWith ? s.substring(1) : ((length == 0) ? s : ((s.length() == 0) ? this.cwd : (this.cwd + "/" + s)));
        }
        final char[] array = new char[s.length() + 1];
        final char[] array2 = new char[array.length + (startsWith ? -1 : this.cwd.length())];
        s.getChars(0, s.length(), array, 0);
        int n = 0;
        int n2 = 0;
        if (startsWith) {
            do {
                ++n;
            } while (array[n] == '/');
        }
        else if (length != 0) {
            this.cwd.getChars(0, length, array2, 0);
            n2 = length;
        }
        while (array[n] != '\0') {
            if (n != 0) {
                while (array[n] != '\0' && array[n] != '/') {
                    array2[n2++] = array[n++];
                }
                if (array[n] == '\0') {
                    break;
                }
                while (array[n] == '/') {
                    ++n;
                }
            }
            if (array[n] == '\0') {
                break;
            }
            if (array[n] != '.') {
                array2[n2++] = '/';
                array2[n2++] = array[n++];
            }
            else if (array[n + 1] == '\0' || array[n + 1] == '/') {
                ++n;
            }
            else if (array[n + 1] == '.' && (array[n + 2] == '\0' || array[n + 2] == '/')) {
                n += 2;
                if (n2 > 0) {
                    --n2;
                }
                while (n2 > 0 && array2[n2] != '/') {
                    --n2;
                }
            }
            else {
                ++n;
                array2[n2++] = '/';
                array2[n2++] = '.';
            }
        }
        if (n2 > 0 && array2[n2 - 1] == '/') {
            --n2;
        }
        final int n3 = (array2[0] == '/') ? 1 : 0;
        return new String(array2, n3, n2 - n3);
    }
    
    Runtime$FStat hostFStat(final File file, final Object o) {
        boolean b = false;
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            switch (fileInputStream.read()) {
                case 127: {
                    b = (fileInputStream.read() == 69 && fileInputStream.read() == 76 && fileInputStream.read() == 70);
                    break;
                }
                case 35: {
                    b = (fileInputStream.read() == 33);
                    break;
                }
            }
            fileInputStream.close();
        }
        catch (IOException ex) {}
        final UnixRuntime$HostFS unixRuntime$HostFS = (UnixRuntime$HostFS)o;
        return new UnixRuntime$1(this, file, b, unixRuntime$HostFS.inodes.get(file.getAbsolutePath()), unixRuntime$HostFS.devno);
    }
    
    Runtime$FD hostFSDirFD(final File file, final Object o) {
        final UnixRuntime$HostFS unixRuntime$HostFS = (UnixRuntime$HostFS)o;
        unixRuntime$HostFS.getClass();
        return new UnixRuntime$HostFS$HostDirFD(unixRuntime$HostFS, file);
    }
    
    private static void putInt(final byte[] array, final int n, final int n2) {
        array[n + 0] = (byte)(n2 >>> 24 & 0xFF);
        array[n + 1] = (byte)(n2 >>> 16 & 0xFF);
        array[n + 2] = (byte)(n2 >>> 8 & 0xFF);
        array[n + 3] = (byte)(n2 >>> 0 & 0xFF);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static void access$500(final byte[] array, final int n, final int n2) {
        putInt(array, n, n2);
    }
    
    static {
        defaultGS = new UnixRuntime$GlobalState();
        Method method;
        try {
            method = Class.forName("org.ibex.nestedvm.RuntimeCompiler").getMethod("compile", (UnixRuntime.class$org$ibex$nestedvm$util$Seekable == null) ? (UnixRuntime.class$org$ibex$nestedvm$util$Seekable = class$("org.ibex.nestedvm.util.Seekable")) : UnixRuntime.class$org$ibex$nestedvm$util$Seekable, (UnixRuntime.class$java$lang$String == null) ? (UnixRuntime.class$java$lang$String = class$("java.lang.String")) : UnixRuntime.class$java$lang$String, (UnixRuntime.class$java$lang$String == null) ? (UnixRuntime.class$java$lang$String = class$("java.lang.String")) : UnixRuntime.class$java$lang$String);
        }
        catch (NoSuchMethodException ex) {
            method = null;
        }
        catch (ClassNotFoundException ex2) {
            method = null;
        }
        runtimeCompilerCompile = method;
    }
}
