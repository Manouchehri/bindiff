/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.Vector;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$CPUState;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$FaultException;
import org.ibex.nestedvm.Runtime$SecurityManager;
import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$ForkedProcess;
import org.ibex.nestedvm.UnixRuntime$GlobalState;
import org.ibex.nestedvm.UnixRuntime$GlobalState$CacheEnt;
import org.ibex.nestedvm.UnixRuntime$HostFS;
import org.ibex.nestedvm.UnixRuntime$HostFS$HostDirFD;
import org.ibex.nestedvm.UnixRuntime$Pipe;
import org.ibex.nestedvm.UnixRuntime$ProcessTableFullExn;
import org.ibex.nestedvm.UnixRuntime$SocketFD;
import org.ibex.nestedvm.util.InodeCache;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

public abstract class UnixRuntime
extends Runtime
implements Cloneable {
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

    @Override
    public final int getPid() {
        return this.pid;
    }

    public void setGlobalState(UnixRuntime$GlobalState unixRuntime$GlobalState) {
        if (this.state != 1) {
            throw new IllegalStateException("can't change GlobalState when running");
        }
        if (unixRuntime$GlobalState == null) {
            throw new NullPointerException("gs is null");
        }
        this.gs = unixRuntime$GlobalState;
    }

    protected UnixRuntime(int n2, int n3) {
        this(n2, n3, false);
    }

    protected UnixRuntime(int n2, int n3, boolean bl2) {
        super(n2, n3, bl2);
        if (bl2) return;
        this.gs = defaultGS;
        String string = Platform.getProperty("user.dir");
        String string2 = this.cwd = string == null ? null : this.gs.mapHostPath(string);
        if (this.cwd == null) {
            this.cwd = "/";
        }
        this.cwd = this.cwd.substring(1);
    }

    private static String posixTZ() {
        StringBuffer stringBuffer = new StringBuffer();
        TimeZone timeZone = TimeZone.getDefault();
        int n2 = timeZone.getRawOffset() / 1000;
        stringBuffer.append(Platform.timeZoneGetDisplayName(timeZone, false, false));
        if (n2 > 0) {
            stringBuffer.append("-");
        } else {
            n2 = - n2;
        }
        stringBuffer.append(n2 / 3600);
        if ((n2 %= 3600) > 0) {
            stringBuffer.append(":").append(n2 / 60);
        }
        if ((n2 %= 60) > 0) {
            stringBuffer.append(":").append(n2);
        }
        if (!timeZone.useDaylightTime()) return stringBuffer.toString();
        stringBuffer.append(Platform.timeZoneGetDisplayName(timeZone, true, false));
        return stringBuffer.toString();
    }

    private static boolean envHas(String string, String[] arrstring) {
        int n2 = 0;
        while (n2 < arrstring.length) {
            if (arrstring[n2] != null && arrstring[n2].startsWith(new StringBuffer().append(string).append("=").toString())) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    String[] createEnv(String[] arrstring) {
        int n2;
        String string;
        String[] arrstring2 = new String[7];
        int n3 = 0;
        if (arrstring == null) {
            arrstring = new String[]{};
        }
        if (!UnixRuntime.envHas("USER", arrstring) && Platform.getProperty("user.name") != null) {
            arrstring2[n3++] = new StringBuffer().append("USER=").append(Platform.getProperty("user.name")).toString();
        }
        if (!UnixRuntime.envHas("HOME", arrstring) && (string = Platform.getProperty("user.home")) != null && (string = this.gs.mapHostPath(string)) != null) {
            arrstring2[n3++] = new StringBuffer().append("HOME=").append(string).toString();
        }
        if (!UnixRuntime.envHas("TMPDIR", arrstring) && (string = Platform.getProperty("java.io.tmpdir")) != null && (string = this.gs.mapHostPath(string)) != null) {
            arrstring2[n3++] = new StringBuffer().append("TMPDIR=").append(string).toString();
        }
        if (!UnixRuntime.envHas("SHELL", arrstring)) {
            arrstring2[n3++] = "SHELL=/bin/sh";
        }
        if (!UnixRuntime.envHas("TERM", arrstring) && !win32Hacks) {
            arrstring2[n3++] = "TERM=vt100";
        }
        if (!UnixRuntime.envHas("TZ", arrstring)) {
            arrstring2[n3++] = new StringBuffer().append("TZ=").append(UnixRuntime.posixTZ()).toString();
        }
        if (!UnixRuntime.envHas("PATH", arrstring)) {
            arrstring2[n3++] = "PATH=/usr/local/bin:/usr/bin:/bin:/usr/local/sbin:/usr/sbin:/sbin";
        }
        String[] arrstring3 = new String[arrstring.length + n3];
        for (n2 = 0; n2 < n3; ++n2) {
            arrstring3[n2] = arrstring2[n2];
        }
        n2 = 0;
        while (n2 < arrstring.length) {
            arrstring3[n3++] = arrstring[n2];
            ++n2;
        }
        return arrstring3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void _started() {
        UnixRuntime[] arrunixRuntime = this.gs.tasks;
        UnixRuntime$GlobalState unixRuntime$GlobalState = this.gs;
        synchronized (unixRuntime$GlobalState) {
            if (this.pid != 0) {
                UnixRuntime unixRuntime = arrunixRuntime[this.pid];
                if (unixRuntime == null) throw new Error("should never happen");
                if (unixRuntime == this) throw new Error("should never happen");
                if (unixRuntime.pid != this.pid) throw new Error("should never happen");
                if (unixRuntime.parent != this.parent) {
                    throw new Error("should never happen");
                }
                Object object = this.parent.children;
                synchronized (object) {
                    int n2 = this.parent.activeChildren.indexOf(unixRuntime);
                    if (n2 == -1) {
                        throw new Error("should never happen");
                    }
                    this.parent.activeChildren.setElementAt(this, n2);
                }
            } else {
                int n3;
                int n4 = -1;
                for (n3 = n5 = this.gs.nextPID; n3 < arrunixRuntime.length; ++n3) {
                    if (arrunixRuntime[n3] != null) continue;
                    n4 = n3;
                    break;
                }
                if (n4 == -1) {
                    int n5;
                    for (n3 = 1; n3 < n5; ++n3) {
                        if (arrunixRuntime[n3] != null) continue;
                        n4 = n3;
                        break;
                    }
                }
                if (n4 == -1) {
                    throw new UnixRuntime$ProcessTableFullExn(null);
                }
                this.pid = n4;
                this.gs.nextPID = n4 + 1;
            }
            arrunixRuntime[this.pid] = this;
            return;
        }
    }

    @Override
    int _syscall(int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        switch (n2) {
            case 11: {
                return this.sys_kill(n3, n4);
            }
            case 25: {
                return this.sys_fork();
            }
            case 23: {
                return this.sys_pipe(n3);
            }
            case 24: {
                return this.sys_dup2(n3, n4);
            }
            case 39: {
                return this.sys_dup(n3);
            }
            case 26: {
                return this.sys_waitpid(n3, n4, n5);
            }
            case 14: {
                return this.sys_stat(n3, n4);
            }
            case 33: {
                return this.sys_lstat(n3, n4);
            }
            case 18: {
                return this.sys_mkdir(n3, n4);
            }
            case 27: {
                return this.sys_getcwd(n3, n4);
            }
            case 22: {
                return this.sys_chdir(n3);
            }
            case 28: {
                return this.sys_exec(n3, n4, n5);
            }
            case 36: {
                return this.sys_getdents(n3, n4, n5, n6);
            }
            case 20: {
                return this.sys_unlink(n3);
            }
            case 46: {
                return this.sys_getppid();
            }
            case 56: {
                return this.sys_socket(n3, n4, n5);
            }
            case 57: {
                return this.sys_connect(n3, n4, n5);
            }
            case 58: {
                return this.sys_resolve_hostname(n3, n4, n5);
            }
            case 60: {
                return this.sys_setsockopt(n3, n4, n5, n6, n7);
            }
            case 61: {
                return this.sys_getsockopt(n3, n4, n5, n6, n7);
            }
            case 63: {
                return this.sys_bind(n3, n4, n5);
            }
            case 62: {
                return this.sys_listen(n3, n4);
            }
            case 59: {
                return this.sys_accept(n3, n4, n5);
            }
            case 64: {
                return this.sys_shutdown(n3, n4);
            }
            case 53: {
                return this.sys_sysctl(n3, n4, n5, n6, n7, n8);
            }
            case 65: {
                return this.sys_sendto(n3, n4, n5, n6, n7, n8);
            }
            case 66: {
                return this.sys_recvfrom(n3, n4, n5, n6, n7, n8);
            }
            case 67: {
                return this.sys_select(n3, n4, n5, n6, n7);
            }
            case 78: {
                return this.sys_access(n3, n4);
            }
            case 52: {
                return this.sys_realpath(n3, n4);
            }
            case 76: {
                return this.sys_chown(n3, n4, n5);
            }
            case 43: {
                return this.sys_chown(n3, n4, n5);
            }
            case 77: {
                return this.sys_fchown(n3, n4, n5);
            }
            case 74: {
                return this.sys_chmod(n3, n4, n5);
            }
            case 75: {
                return this.sys_fchmod(n3, n4, n5);
            }
            case 29: {
                return this.sys_fcntl_lock(n3, n4, n5);
            }
            case 73: {
                return this.sys_umask(n3);
            }
        }
        return super._syscall(n2, n3, n4, n5, n6, n7, n8);
    }

    @Override
    Runtime$FD _open(String string, int n2, int n3) {
        Runtime$FD runtime$FD = this.gs.open(this, string = this.normalizePath(string), n2, n3);
        if (runtime$FD == null) return runtime$FD;
        if (string == null) return runtime$FD;
        runtime$FD.setNormalizedPath(string);
        return runtime$FD;
    }

    private int sys_getppid() {
        if (this.parent == null) {
            return 1;
        }
        int n2 = this.parent.pid;
        return n2;
    }

    private int sys_chown(int n2, int n3, int n4) {
        return 0;
    }

    private int sys_lchown(int n2, int n3, int n4) {
        return 0;
    }

    private int sys_fchown(int n2, int n3, int n4) {
        return 0;
    }

    private int sys_chmod(int n2, int n3, int n4) {
        return 0;
    }

    private int sys_fchmod(int n2, int n3, int n4) {
        return 0;
    }

    private int sys_umask(int n2) {
        return 0;
    }

    private int sys_access(int n2, int n3) {
        if (this.gs.stat(this, this.cstring(n2)) != null) return 0;
        return -2;
    }

    private int sys_realpath(int n2, int n3) {
        String string = this.normalizePath(this.cstring(n2));
        byte[] arrby = UnixRuntime.getNullTerminatedBytes(string);
        if (arrby.length > 1024) {
            return -34;
        }
        this.copyout(arrby, n3, arrby.length);
        return 0;
    }

    private int sys_kill(int n2, int n3) {
        if (n2 != n2) {
            return -3;
        }
        if (n3 < 0) return -22;
        if (n3 >= 32) {
            return -22;
        }
        switch (n3) {
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
                return 0;
            }
        }
        this.exit(128 + n3, true);
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int sys_waitpid(int n2, int n3, int n4) {
        boolean bl2;
        if ((n4 & -2) != 0) {
            return -22;
        }
        if (n2 == 0 || n2 < -1) {
            System.err.println(new StringBuffer().append("WARNING: waitpid called with a pid of ").append(n2).toString());
            return -10;
        }
        boolean bl3 = bl2 = (n4 & 1) == 0;
        if (n2 != -1) {
            if (n2 <= 0) return -10;
            if (n2 >= this.gs.tasks.length) {
                return -10;
            }
        }
        if (this.children == null) {
            if (!bl2) return 0;
            return -10;
        }
        UnixRuntime unixRuntime = null;
        Object object = this.children;
        synchronized (object) {
            do {
                if (n2 == -1) {
                    if (this.exitedChildren.size() > 0) {
                        unixRuntime = (UnixRuntime)this.exitedChildren.elementAt(this.exitedChildren.size() - 1);
                        this.exitedChildren.removeElementAt(this.exitedChildren.size() - 1);
                    }
                } else {
                    if (n2 <= 0) throw new Error("should never happen");
                    if (n2 >= this.gs.tasks.length) {
                        return -10;
                    }
                    UnixRuntime unixRuntime2 = this.gs.tasks[n2];
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
                if (unixRuntime != null) break;
                if (!bl2) {
                    return 0;
                }
                try {
                    this.children.wait();
                }
                catch (InterruptedException var8_8) {}
            } while (true);
            this.gs.tasks[unixRuntime.pid] = null;
        }
        if (n3 == 0) return unixRuntime.pid;
        this.memWrite(n3, unixRuntime.exitStatus() << 8);
        return unixRuntime.pid;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    void _exited() {
        Object object;
        Enumeration enumeration;
        if (this.children != null) {
            object = this.children;
            synchronized (object) {
                UnixRuntime unixRuntime;
                enumeration = this.exitedChildren.elements();
                while (enumeration.hasMoreElements()) {
                    unixRuntime = (UnixRuntime)enumeration.nextElement();
                    this.gs.tasks[unixRuntime.pid] = null;
                }
                this.exitedChildren.removeAllElements();
                enumeration = this.activeChildren.elements();
                while (enumeration.hasMoreElements()) {
                    unixRuntime = (UnixRuntime)enumeration.nextElement();
                    unixRuntime.parent = null;
                }
                this.activeChildren.removeAllElements();
            }
        }
        if ((object = this.parent) == null) {
            this.gs.tasks[this.pid] = null;
            return;
        }
        enumeration = object.children;
        synchronized (enumeration) {
            if (this.parent == null) {
                this.gs.tasks[this.pid] = null;
            } else {
                if (!this.parent.activeChildren.removeElement(this)) {
                    throw new Error(new StringBuffer().append("should never happen _exited: pid: ").append(this.pid).toString());
                }
                this.parent.exitedChildren.addElement(this);
                this.parent.children.notify();
            }
            return;
        }
    }

    @Override
    protected Object clone() {
        UnixRuntime unixRuntime = (UnixRuntime)super.clone();
        unixRuntime.pid = 0;
        unixRuntime.parent = null;
        unixRuntime.children = null;
        unixRuntime.exitedChildren = null;
        unixRuntime.activeChildren = null;
        return unixRuntime;
    }

    private int sys_fork() {
        UnixRuntime unixRuntime;
        try {
            unixRuntime = (UnixRuntime)this.clone();
        }
        catch (Exception var2_2) {
            var2_2.printStackTrace();
            return -12;
        }
        unixRuntime.parent = this;
        try {
            unixRuntime._started();
        }
        catch (UnixRuntime$ProcessTableFullExn var2_3) {
            return -12;
        }
        if (this.children == null) {
            this.children = new Object();
            this.activeChildren = new Vector();
            this.exitedChildren = new Vector();
        }
        this.activeChildren.addElement(unixRuntime);
        Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        this.getCPUState(runtime$CPUState);
        runtime$CPUState.r[2] = 0;
        runtime$CPUState.pc += 4;
        unixRuntime.setCPUState(runtime$CPUState);
        unixRuntime.state = 2;
        new UnixRuntime$ForkedProcess(unixRuntime);
        return unixRuntime.pid;
    }

    public static int runAndExec(UnixRuntime unixRuntime, String string, String[] arrstring) {
        return UnixRuntime.runAndExec(unixRuntime, UnixRuntime.concatArgv(string, arrstring));
    }

    public static int runAndExec(UnixRuntime unixRuntime, String[] arrstring) {
        unixRuntime.start(arrstring);
        return UnixRuntime.executeAndExec(unixRuntime);
    }

    public static int executeAndExec(UnixRuntime unixRuntime) {
        do {
            if (unixRuntime.execute()) {
                if (unixRuntime.state != 5) {
                    return unixRuntime.exitStatus();
                }
            } else {
                System.err.println("WARNING: Pause requested while executing runAndExec()");
                continue;
            }
            unixRuntime = unixRuntime.execedRuntime;
        } while (true);
    }

    private String[] readStringArray(int n2) {
        int n3 = 0;
        int n4 = n2;
        while (this.memRead(n4) != 0) {
            ++n3;
            n4 += 4;
        }
        String[] arrstring = new String[n3];
        int n5 = 0;
        int n6 = n2;
        while (n5 < n3) {
            arrstring[n5] = this.cstring(this.memRead(n6));
            ++n5;
            n6 += 4;
        }
        return arrstring;
    }

    private int sys_exec(int n2, int n3, int n4) {
        return this.exec(this.normalizePath(this.cstring(n2)), this.readStringArray(n3), this.readStringArray(n4));
    }

    public Class runtimeCompile(Seekable seekable, String string) {
        if (runtimeCompilerCompile == null) {
            System.err.println("WARNING: Exec attempted but RuntimeCompiler not found!");
            return null;
        }
        try {
            return (Class)runtimeCompilerCompile.invoke(null, seekable, "unixruntime,maxinsnpermethod=256,lessconstants", string);
        }
        catch (IllegalAccessException var3_3) {
            var3_3.printStackTrace();
            return null;
        }
        catch (InvocationTargetException var3_4) {
            Throwable throwable = var3_4.getTargetException();
            if (throwable instanceof IOException) {
                throw (IOException)throwable;
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throwable.printStackTrace();
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int exec(String string, String[] arrstring, String[] arrstring2) {
        Runtime$FD runtime$FD;
        if (arrstring.length == 0) {
            arrstring = new String[]{""};
        }
        if (string.equals("bin/busybox") && this.getClass().getName().endsWith("BusyBox")) {
            return this.execClass(this.getClass(), arrstring, arrstring2);
        }
        Runtime$FStat runtime$FStat = this.gs.stat(this, string);
        if (runtime$FStat == null) {
            return -2;
        }
        UnixRuntime$GlobalState$CacheEnt unixRuntime$GlobalState$CacheEnt = (UnixRuntime$GlobalState$CacheEnt)this.gs.execCache.get(string);
        long l2 = runtime$FStat.mtime();
        long l3 = runtime$FStat.size();
        if (unixRuntime$GlobalState$CacheEnt != null) {
            if (unixRuntime$GlobalState$CacheEnt.time == l2 && unixRuntime$GlobalState$CacheEnt.size == l3) {
                if (unixRuntime$GlobalState$CacheEnt.o instanceof Class) {
                    return this.execClass((Class)unixRuntime$GlobalState$CacheEnt.o, arrstring, arrstring2);
                }
                if (!(unixRuntime$GlobalState$CacheEnt.o instanceof String[])) throw new Error("should never happen");
                return this.execScript(string, (String[])unixRuntime$GlobalState$CacheEnt.o, arrstring, arrstring2);
            }
            this.gs.execCache.remove(string);
        }
        if ((runtime$FD = this.gs.open(this, string, 0, 0)) == null) {
            throw new Runtime$ErrnoException(2);
        }
        Seekable seekable = runtime$FD.seekable();
        if (seekable == null) {
            throw new Runtime$ErrnoException(13);
        }
        byte[] arrby = new byte[4096];
        try {
            int n2 = seekable.read(arrby, 0, arrby.length);
            if (n2 == -1) {
                throw new Runtime$ErrnoException(8);
            }
            switch (arrby[0]) {
                case 127: {
                    if (n2 < 4) {
                        seekable.tryReadFully(arrby, n2, 4 - n2);
                    }
                    if (arrby[1] != 69 || arrby[2] != 76 || arrby[3] != 70) {
                        int n3 = -8;
                        return n3;
                    }
                    seekable.seek(0);
                    System.err.println(new StringBuffer().append("Running RuntimeCompiler for ").append(string).toString());
                    Class class_ = this.runtimeCompile(seekable, string);
                    System.err.println(new StringBuffer().append("RuntimeCompiler finished for ").append(string).toString());
                    if (class_ == null) {
                        throw new Runtime$ErrnoException(8);
                    }
                    this.gs.execCache.put(string, new UnixRuntime$GlobalState$CacheEnt(l2, l3, class_));
                    int n4 = this.execClass(class_, arrstring, arrstring2);
                    return n4;
                }
                case 35: {
                    int n5;
                    int n6;
                    int n7;
                    if (n2 == 1) {
                        n5 = seekable.read(arrby, 1, arrby.length - 1);
                        if (n5 == -1) {
                            int n8 = -8;
                            return n8;
                        }
                        n2 += n5;
                    }
                    if (arrby[1] != 33) {
                        n5 = -8;
                        return n5;
                    }
                    n5 = 2;
                    n2 -= 2;
                    block14 : do {
                        for (n6 = n5; n6 < n5 + n2; ++n6) {
                            if (arrby[n6] != 10) continue;
                            n5 = n6;
                            break block14;
                        }
                        if ((n5 += n2) == arrby.length) break;
                        n2 = seekable.read(arrby, n5, arrby.length - n5);
                    } while (true);
                    for (n6 = 2; n6 < n5 && arrby[n6] == 32; ++n6) {
                    }
                    if (n6 == n5) {
                        throw new Runtime$ErrnoException(8);
                    }
                    for (n7 = n6; n7 < n5 && arrby[n7] != 32; ++n7) {
                    }
                    int n9 = n7;
                    while (n7 < n5 && arrby[n7] == 32) {
                        ++n7;
                    }
                    String[] arrstring3 = new String[2];
                    arrstring3[0] = new String(arrby, n6, n9 - n6);
                    arrstring3[1] = n7 < n5 ? new String(arrby, n7, n5 - n7) : null;
                    String[] arrstring4 = arrstring3;
                    this.gs.execCache.put(string, new UnixRuntime$GlobalState$CacheEnt(l2, l3, arrstring4));
                    int n10 = this.execScript(string, arrstring4, arrstring, arrstring2);
                    return n10;
                }
            }
            int n11 = -8;
            return n11;
        }
        catch (IOException var13_12) {
            int n12 = -5;
            return n12;
        }
        finally {
            runtime$FD.close();
        }
    }

    public int execScript(String string, String[] arrstring, String[] arrstring2, String[] arrstring3) {
        int n2;
        String[] arrstring4 = new String[arrstring2.length - 1 + (arrstring[1] != null ? 3 : 2)];
        int n3 = arrstring[0].lastIndexOf(47);
        arrstring4[0] = n3 == -1 ? arrstring[0] : arrstring[0].substring(n3 + 1);
        arrstring4[1] = new StringBuffer().append("/").append(string).toString();
        n3 = 2;
        if (arrstring[1] != null) {
            arrstring4[n3++] = arrstring[1];
        }
        for (n2 = 1; n2 < arrstring2.length; ++n2) {
            arrstring4[n3++] = arrstring2[n2];
        }
        if (n3 != arrstring4.length) {
            throw new Error("p != newArgv.length");
        }
        System.err.println(new StringBuffer().append("Execing: ").append(arrstring[0]).toString());
        n2 = 0;
        while (n2 < arrstring4.length) {
            System.err.println(new StringBuffer().append("execing [").append(n2).append("] ").append(arrstring4[n2]).toString());
            ++n2;
        }
        return this.exec(arrstring[0], arrstring4, arrstring3);
    }

    public int execClass(Class class_, String[] arrstring, String[] arrstring2) {
        try {
            UnixRuntime unixRuntime = (UnixRuntime)class_.getDeclaredConstructor(Boolean.TYPE).newInstance(Boolean.TRUE);
            return this.exec(unixRuntime, arrstring, arrstring2);
        }
        catch (Exception var4_5) {
            var4_5.printStackTrace();
            return -8;
        }
    }

    private int exec(UnixRuntime unixRuntime, String[] arrstring, String[] arrstring2) {
        int n2 = 0;
        do {
            if (n2 >= 64) {
                unixRuntime.fds = this.fds;
                unixRuntime.closeOnExec = this.closeOnExec;
                this.fds = null;
                this.closeOnExec = null;
                unixRuntime.gs = this.gs;
                unixRuntime.sm = this.sm;
                unixRuntime.cwd = this.cwd;
                unixRuntime.pid = this.pid;
                unixRuntime.parent = this.parent;
                unixRuntime.start(arrstring, arrstring2);
                this.state = 5;
                this.execedRuntime = unixRuntime;
                return 0;
            }
            if (this.closeOnExec[n2]) {
                this.closeFD(n2);
            }
            ++n2;
        } while (true);
    }

    private int sys_pipe(int n2) {
        UnixRuntime$Pipe unixRuntime$Pipe = new UnixRuntime$Pipe();
        int n3 = this.addFD(unixRuntime$Pipe.reader);
        if (n3 < 0) {
            return -23;
        }
        int n4 = this.addFD(unixRuntime$Pipe.writer);
        if (n4 < 0) {
            this.closeFD(n3);
            return -23;
        }
        try {
            this.memWrite(n2, n3);
            this.memWrite(n2 + 4, n4);
            return 0;
        }
        catch (Runtime$FaultException var5_5) {
            this.closeFD(n3);
            this.closeFD(n4);
            return -14;
        }
    }

    private int sys_dup2(int n2, int n3) {
        if (n2 == n3) {
            return 0;
        }
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (n3 < 0) return -81;
        if (n3 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        if (this.fds[n3] != null) {
            this.fds[n3].close();
        }
        this.fds[n3] = this.fds[n2].dup();
        return 0;
    }

    private int sys_dup(int n2) {
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        Runtime$FD runtime$FD = this.fds[n2].dup();
        int n3 = this.addFD(runtime$FD);
        if (n3 >= 0) return n3;
        runtime$FD.close();
        return -23;
    }

    private int sys_stat(int n2, int n3) {
        Runtime$FStat runtime$FStat = this.gs.stat(this, this.normalizePath(this.cstring(n2)));
        if (runtime$FStat != null) return this.stat(runtime$FStat, n3);
        return -2;
    }

    private int sys_lstat(int n2, int n3) {
        Runtime$FStat runtime$FStat = this.gs.lstat(this, this.normalizePath(this.cstring(n2)));
        if (runtime$FStat != null) return this.stat(runtime$FStat, n3);
        return -2;
    }

    private int sys_mkdir(int n2, int n3) {
        this.gs.mkdir(this, this.normalizePath(this.cstring(n2)), n3);
        return 0;
    }

    private int sys_unlink(int n2) {
        this.gs.unlink(this, this.normalizePath(this.cstring(n2)));
        return 0;
    }

    private int sys_getcwd(int n2, int n3) {
        byte[] arrby = UnixRuntime.getBytes(this.cwd);
        if (n3 == 0) {
            return -22;
        }
        if (n3 < arrby.length + 2) {
            return -34;
        }
        this.memset(n2, 47, 1);
        this.copyout(arrby, n2 + 1, arrby.length);
        this.memset(n2 + arrby.length + 1, 0, 1);
        return n2;
    }

    private int sys_chdir(int n2) {
        String string = this.normalizePath(this.cstring(n2));
        Runtime$FStat runtime$FStat = this.gs.stat(this, string);
        if (runtime$FStat == null) {
            return -2;
        }
        if (runtime$FStat.type() != 16384) {
            return -20;
        }
        this.cwd = string;
        return 0;
    }

    private int sys_getdents(int n2, int n3, int n4, int n5) {
        n4 = Math.min(n4, 16776192);
        if (n2 < 0) return -81;
        if (n2 >= 64) {
            return -81;
        }
        if (this.fds[n2] == null) {
            return -81;
        }
        byte[] arrby = this.byteBuf(n4);
        int n6 = this.fds[n2].getdents(arrby, 0, n4);
        this.copyout(arrby, n3, n6);
        return n6;
    }

    @Override
    void _preCloseFD(Runtime$FD runtime$FD) {
        Seekable seekable = runtime$FD.seekable();
        if (seekable == null) {
            return;
        }
        try {
            int n2 = 0;
            while (n2 < this.gs.locks.length) {
                Seekable$Lock seekable$Lock = this.gs.locks[n2];
                if (seekable$Lock != null && seekable.equals(seekable$Lock.seekable()) && seekable$Lock.getOwner() == this) {
                    seekable$Lock.release();
                    this.gs.locks[n2] = null;
                }
                ++n2;
            }
            return;
        }
        catch (IOException var3_4) {
            throw new RuntimeException(var3_4);
        }
    }

    @Override
    void _postCloseFD(Runtime$FD runtime$FD) {
        if (!runtime$FD.isMarkedForDeleteOnClose()) return;
        try {
            this.gs.unlink(this, runtime$FD.getNormalizedPath());
            return;
        }
        catch (Throwable var2_2) {
            // empty catch block
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private int sys_fcntl_lock(int var1_1, int var2_2, int var3_3) {
        block27 : {
            block26 : {
                if (var2_2 != 7 && var2_2 != 8) {
                    return this.sys_fcntl(var1_1, var2_2, var3_3);
                }
                if (var1_1 < 0) return -81;
                if (var1_1 >= 64) {
                    return -81;
                }
                if (this.fds[var1_1] == null) {
                    return -81;
                }
                var4_4 = this.fds[var1_1];
                if (var3_3 == 0) {
                    return -22;
                }
                var5_5 = this.memRead(var3_3);
                var6_6 = this.memRead(var3_3 + 4);
                var7_7 = this.memRead(var3_3 + 8);
                var8_8 = var5_5 >> 16;
                var9_9 = var5_5 & 255;
                var10_10 = this.gs.locks;
                var11_11 = var4_4.seekable();
                if (var11_11 == null) {
                    return -22;
                }
                try {
                    switch (var9_9) {
                        case 0: {
                            ** break;
                        }
                        case 1: {
                            var6_6 += var11_11.pos();
                            ** break;
                        }
                        case 2: {
                            var6_6 += var11_11.length();
                            ** break;
                        }
                    }
                    return -1;
lbl31: // 3 sources:
                    if (var2_2 == 7) {
                        break block26;
                    }
                    if (var2_2 != 8) {
                        return -22;
                    }
                    if (var8_8 == 3) {
                        var12_14 = 0;
                        break block27;
                    }
                    if (var8_8 != 1) {
                        if (var8_8 != 2) return -22;
                    }
                    for (var12_15 = 0; var12_15 < var10_10.length; ++var12_15) {
                        if (var10_10[var12_15] == null || !var11_11.equals(var10_10[var12_15].seekable())) continue;
                        if (var10_10[var12_15].getOwner() == this) {
                            if (var10_10[var12_15].contained(var6_6, var7_7)) {
                                var10_10[var12_15].release();
                                var10_10[var12_15] = null;
                                continue;
                            }
                            if (!var10_10[var12_15].contains(var6_6, var7_7)) continue;
                            if (var10_10[var12_15].isShared() == (var8_8 == 1)) {
                                this.memWrite(var3_3 + 4, (int)var10_10[var12_15].position());
                                this.memWrite(var3_3 + 8, (int)var10_10[var12_15].size());
                                return 0;
                            }
                            var10_10[var12_15].release();
                            var10_10[var12_15] = null;
                            continue;
                        }
                        if (!var10_10[var12_15].overlaps(var6_6, var7_7)) continue;
                        if (var10_10[var12_15].isShared() == false) return -11;
                        if (var8_8 != 2) continue;
                        return -11;
                    }
                    var12_16 = var11_11.lock(var6_6, var7_7, var8_8 == 1);
                    if (var12_16 == null) {
                        return -11;
                    }
                    var12_16.setOwner(this);
                    for (var13_19 = 0; var13_19 < var10_10.length && var10_10[var13_19] != null; ++var13_19) {
                    }
                    if (var13_19 == var10_10.length) {
                        return -46;
                    }
                    var10_10[var13_19] = var12_16;
                    return 0;
                }
                catch (IOException var12_17) {
                    throw new RuntimeException(var12_17);
                }
            }
            for (var12_12 = 0; var12_12 < var10_10.length; ++var12_12) {
                if (var10_10[var12_12] == null || !var11_11.equals(var10_10[var12_12].seekable()) || !var10_10[var12_12].overlaps(var6_6, var7_7) || var10_10[var12_12].getOwner() == this) continue;
                if (var10_10[var12_12].isShared() == false) return 0;
                if (var8_8 != 1) return 0;
            }
            var12_13 = var11_11.lock(var6_6, var7_7, var8_8 == 1);
            if (var12_13 == null) return 0;
            this.memWrite(var3_3, 196608);
            var12_13.release();
            return 0;
        }
        while (var12_14 < var10_10.length) {
            if (var10_10[var12_14] != null && var11_11.equals(var10_10[var12_14].seekable()) && var10_10[var12_14].getOwner() == this && (var13_18 = (int)var10_10[var12_14].position()) >= var6_6 && (var6_6 == 0 || var7_7 == 0 || (long)var13_18 + var10_10[var12_14].size() <= (long)(var6_6 + var7_7))) {
                var10_10[var12_14].release();
                var10_10[var12_14] = null;
            }
            ++var12_14;
        }
        return 0;
    }

    private int sys_socket(int n2, int n3, int n4) {
        int n5;
        if (n2 != 2) return -123;
        if (n3 != 1 && n3 != 2) {
            return -123;
        }
        if (n3 == 1) {
            n5 = 0;
            return this.addFD(new UnixRuntime$SocketFD(n5));
        }
        n5 = 1;
        return this.addFD(new UnixRuntime$SocketFD(n5));
    }

    private UnixRuntime$SocketFD getSocketFD(int n2) {
        if (n2 < 0) throw new Runtime$ErrnoException(81);
        if (n2 >= 64) {
            throw new Runtime$ErrnoException(81);
        }
        if (this.fds[n2] == null) {
            throw new Runtime$ErrnoException(81);
        }
        if (this.fds[n2] instanceof UnixRuntime$SocketFD) return (UnixRuntime$SocketFD)this.fds[n2];
        throw new Runtime$ErrnoException(108);
    }

    private int sys_connect(int n2, int n3, int n4) {
        InetAddress inetAddress;
        int n5;
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (unixRuntime$SocketFD.type() == 0) {
            if (unixRuntime$SocketFD.s != null) return -127;
            if (unixRuntime$SocketFD.ss != null) {
                return -127;
            }
        }
        if (((n5 = this.memRead(n3)) >>> 16 & 255) != 2) {
            return -106;
        }
        int n6 = n5 & 65535;
        byte[] arrby = new byte[4];
        this.copyin(n3 + 4, arrby, 4);
        try {
            inetAddress = Platform.inetAddressFromBytes(arrby);
        }
        catch (UnknownHostException var9_9) {
            return -125;
        }
        unixRuntime$SocketFD.connectAddr = inetAddress;
        unixRuntime$SocketFD.connectPort = n6;
        try {
            switch (unixRuntime$SocketFD.type()) {
                case 0: {
                    Socket socket;
                    unixRuntime$SocketFD.s = socket = new Socket(inetAddress, n6);
                    unixRuntime$SocketFD.setOptions();
                    unixRuntime$SocketFD.is = socket.getInputStream();
                    unixRuntime$SocketFD.os = socket.getOutputStream();
                    return 0;
                }
                case 1: {
                    return 0;
                }
            }
            throw new Error("should never happen");
        }
        catch (IOException var9_11) {
            return -111;
        }
    }

    private int sys_resolve_hostname(int n2, int n3, int n4) {
        InetAddress[] arrinetAddress;
        String string = this.cstring(n2);
        int n5 = this.memRead(n4);
        try {
            arrinetAddress = InetAddress.getAllByName(string);
        }
        catch (UnknownHostException var7_7) {
            return 1;
        }
        int n6 = UnixRuntime.min(n5 / 4, arrinetAddress.length);
        int n7 = 0;
        do {
            if (n7 >= n6) {
                this.memWrite(n4, n6 * 4);
                return 0;
            }
            byte[] arrby = arrinetAddress[n7].getAddress();
            this.copyout(arrby, n3, 4);
            ++n7;
            n3 += 4;
        } while (true);
    }

    private int sys_setsockopt(int n2, int n3, int n4, int n5, int n6) {
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        switch (n3) {
            case 65535: {
                switch (n4) {
                    case 4: 
                    case 8: {
                        if (n6 != 4) {
                            return -22;
                        }
                        int n7 = this.memRead(n5);
                        unixRuntime$SocketFD.options = n7 != 0 ? (unixRuntime$SocketFD.options |= n4) : (unixRuntime$SocketFD.options &= ~ n4);
                        unixRuntime$SocketFD.setOptions();
                        return 0;
                    }
                }
                System.err.println(new StringBuffer().append("Unknown setsockopt name passed: ").append(n4).toString());
                return -109;
            }
        }
        System.err.println(new StringBuffer().append("Unknown setsockopt leve passed: ").append(n3).toString());
        return -109;
    }

    private int sys_getsockopt(int n2, int n3, int n4, int n5, int n6) {
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        switch (n3) {
            case 65535: {
                switch (n4) {
                    case 4: 
                    case 8: {
                        int n7 = this.memRead(n6);
                        if (n7 < 4) {
                            return -22;
                        }
                        int n8 = (unixRuntime$SocketFD.options & n4) != 0 ? 1 : 0;
                        this.memWrite(n5, n8);
                        this.memWrite(n6, 4);
                        return 0;
                    }
                }
                System.err.println(new StringBuffer().append("Unknown setsockopt name passed: ").append(n4).toString());
                return -109;
            }
        }
        System.err.println(new StringBuffer().append("Unknown setsockopt leve passed: ").append(n3).toString());
        return -109;
    }

    private int sys_bind(int n2, int n3, int n4) {
        int n5;
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (unixRuntime$SocketFD.type() == 0) {
            if (unixRuntime$SocketFD.s != null) return -127;
            if (unixRuntime$SocketFD.ss != null) {
                return -127;
            }
        }
        if (((n5 = this.memRead(n3)) >>> 16 & 255) != 2) {
            return -106;
        }
        int n6 = n5 & 65535;
        InetAddress inetAddress = null;
        if (this.memRead(n3 + 4) != 0) {
            byte[] arrby = new byte[4];
            this.copyin(n3 + 4, arrby, 4);
            try {
                inetAddress = Platform.inetAddressFromBytes(arrby);
            }
            catch (UnknownHostException var9_10) {
                return -125;
            }
        }
        switch (unixRuntime$SocketFD.type()) {
            case 0: {
                unixRuntime$SocketFD.bindAddr = inetAddress;
                unixRuntime$SocketFD.bindPort = n6;
                return 0;
            }
            case 1: {
                if (unixRuntime$SocketFD.ds != null) {
                    unixRuntime$SocketFD.ds.close();
                }
                try {
                    unixRuntime$SocketFD.ds = inetAddress != null ? new DatagramSocket(n6, inetAddress) : new DatagramSocket(n6);
                    return 0;
                }
                catch (IOException var8_9) {
                    return -112;
                }
            }
        }
        throw new Error("should never happen");
    }

    private int sys_listen(int n2, int n3) {
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (unixRuntime$SocketFD.type() != 0) {
            return -95;
        }
        if (unixRuntime$SocketFD.ss != null) return -127;
        if (unixRuntime$SocketFD.s != null) {
            return -127;
        }
        if (unixRuntime$SocketFD.bindPort < 0) {
            return -95;
        }
        try {
            unixRuntime$SocketFD.ss = new ServerSocket(unixRuntime$SocketFD.bindPort, n3, unixRuntime$SocketFD.bindAddr);
            unixRuntime$SocketFD.flags |= 2;
            return 0;
        }
        catch (IOException var4_4) {
            return -112;
        }
    }

    private int sys_accept(int n2, int n3, int n4) {
        byte[] arrby;
        Socket socket;
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (unixRuntime$SocketFD.type() != 0) {
            return -95;
        }
        if (!unixRuntime$SocketFD.listen()) {
            return -95;
        }
        int n5 = this.memRead(n4);
        ServerSocket serverSocket = unixRuntime$SocketFD.ss;
        try {
            socket = serverSocket.accept();
        }
        catch (IOException var8_8) {
            return -5;
        }
        if (n5 >= 8) {
            this.memWrite(n3, 100794368 | socket.getPort());
            arrby = socket.getInetAddress().getAddress();
            this.copyout(arrby, n3 + 4, 4);
            this.memWrite(n4, 8);
        }
        arrby = new byte[](0);
        arrby.s = socket;
        try {
            arrby.is = socket.getInputStream();
            arrby.os = socket.getOutputStream();
        }
        catch (IOException var9_10) {
            return -5;
        }
        int n6 = this.addFD((Runtime$FD)arrby);
        if (n6 != -1) return n6;
        arrby.close();
        return -23;
    }

    private int sys_shutdown(int n2, int n3) {
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (unixRuntime$SocketFD.type() != 0) return -95;
        if (unixRuntime$SocketFD.listen()) {
            return -95;
        }
        if (unixRuntime$SocketFD.s == null) {
            return -128;
        }
        Socket socket = unixRuntime$SocketFD.s;
        try {
            if (n3 == 0 || n3 == 2) {
                Platform.socketHalfClose(socket, false);
            }
            if (n3 != 1) {
                if (n3 != 2) return 0;
            }
            Platform.socketHalfClose(socket, true);
            return 0;
        }
        catch (IOException var5_5) {
            return -5;
        }
    }

    private int sys_sendto(int n2, int n3, int n4, int n5, int n6, int n7) {
        InetAddress inetAddress;
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (n5 != 0) {
            throw new Runtime$ErrnoException(22);
        }
        int n8 = this.memRead(n6);
        if ((n8 >>> 16 & 255) != 2) {
            return -106;
        }
        int n9 = n8 & 65535;
        byte[] arrby = new byte[4];
        this.copyin(n6 + 4, arrby, 4);
        try {
            inetAddress = Platform.inetAddressFromBytes(arrby);
        }
        catch (UnknownHostException var12_12) {
            return -125;
        }
        n4 = Math.min(n4, 16776192);
        byte[] arrby2 = this.byteBuf(n4);
        this.copyin(n3, arrby2, n4);
        try {
            return unixRuntime$SocketFD.sendto(arrby2, 0, n4, inetAddress, n9);
        }
        catch (Runtime$ErrnoException var13_14) {
            if (var13_14.errno != 32) throw var13_14;
            this.exit(141, true);
            throw var13_14;
        }
    }

    private int sys_recvfrom(int n2, int n3, int n4, int n5, int n6, int n7) {
        UnixRuntime$SocketFD unixRuntime$SocketFD = this.getSocketFD(n2);
        if (n5 != 0) {
            throw new Runtime$ErrnoException(22);
        }
        InetAddress[] arrinetAddress = n6 == 0 ? null : new InetAddress[1];
        int[] arrn = n6 == 0 ? null : new int[1];
        n4 = Math.min(n4, 16776192);
        byte[] arrby = this.byteBuf(n4);
        int n8 = unixRuntime$SocketFD.recvfrom(arrby, 0, n4, arrinetAddress, arrn);
        this.copyout(arrby, n3, n8);
        if (n6 == 0) return n8;
        this.memWrite(n6, 131072 | arrn[0]);
        byte[] arrby2 = arrinetAddress[0].getAddress();
        this.copyout(arrby2, n6 + 4, 4);
        return n8;
    }

    private int sys_select(int n2, int n3, int n4, int n5, int n6) {
        return -88;
    }

    private static String hostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException var0) {
            return "darkstar";
        }
    }

    private int sys_sysctl(int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n6 != 0) {
            return -1;
        }
        if (n3 == 0) {
            return -2;
        }
        if (n4 == 0) {
            return 0;
        }
        String string = null;
        block0 : switch (this.memRead(n2)) {
            case 1: {
                if (n3 != 2) break;
                switch (this.memRead(n2 + 4)) {
                    case 1: {
                        string = "NestedVM";
                        break block0;
                    }
                    case 10: {
                        string = UnixRuntime.hostName();
                        break block0;
                    }
                    case 2: {
                        string = "1.0";
                        break block0;
                    }
                    case 4: {
                        string = "NestedVM Kernel Version 1.0";
                    }
                }
                break;
            }
            case 6: {
                if (n3 != 2) break;
                switch (this.memRead(n2 + 4)) {
                    case 1: {
                        string = "NestedVM Virtual Machine";
                    }
                }
            }
        }
        if (string == null) {
            return -2;
        }
        int n8 = this.memRead(n5);
        if (string instanceof String) {
            byte[] arrby = UnixRuntime.getNullTerminatedBytes(string);
            if (n8 < arrby.length) {
                return -12;
            }
            n8 = arrby.length;
            this.copyout(arrby, n4, n8);
            this.memWrite(n5, n8);
            return 0;
        }
        if (!(string instanceof Integer)) throw new Error("should never happen");
        if (n8 < 4) {
            return -12;
        }
        this.memWrite(n4, (Integer)((Object)string));
        return 0;
    }

    private String normalizePath(String string) {
        boolean bl2 = string.startsWith("/");
        int n2 = this.cwd.length();
        if (!string.startsWith(".") && string.indexOf("./") == -1 && string.indexOf("//") == -1 && !string.endsWith(".")) {
            String string2;
            if (bl2) {
                string2 = string.substring(1);
                return string2;
            }
            if (n2 == 0) {
                string2 = string;
                return string2;
            }
            if (string.length() == 0) {
                string2 = this.cwd;
                return string2;
            }
            string2 = new StringBuffer().append(this.cwd).append("/").append(string).toString();
            return string2;
        }
        char[] arrc = new char[string.length() + 1];
        char[] arrc2 = new char[arrc.length + (bl2 ? -1 : this.cwd.length())];
        string.getChars(0, string.length(), arrc, 0);
        int n3 = 0;
        int n4 = 0;
        if (bl2) {
            while (arrc[++n3] == '/') {
            }
        } else if (n2 != 0) {
            this.cwd.getChars(0, n2, arrc2, 0);
            n4 = n2;
        }
        while (arrc[n3] != '\u0000') {
            if (n3 != 0) {
                while (arrc[n3] != '\u0000' && arrc[n3] != '/') {
                    arrc2[n4++] = arrc[n3++];
                }
                if (arrc[n3] == '\u0000') break;
                while (arrc[n3] == '/') {
                    ++n3;
                }
            }
            if (arrc[n3] == '\u0000') break;
            if (arrc[n3] != '.') {
                arrc2[n4++] = 47;
                arrc2[n4++] = arrc[n3++];
                continue;
            }
            if (arrc[n3 + 1] == '\u0000' || arrc[n3 + 1] == '/') {
                ++n3;
                continue;
            }
            if (arrc[n3 + 1] == '.' && (arrc[n3 + 2] == '\u0000' || arrc[n3 + 2] == '/')) {
                n3 += 2;
                if (n4 > 0) {
                    --n4;
                }
                while (n4 > 0 && arrc2[n4] != '/') {
                    --n4;
                }
                continue;
            }
            ++n3;
            arrc2[n4++] = 47;
            arrc2[n4++] = 46;
        }
        if (n4 > 0 && arrc2[n4 - 1] == '/') {
            --n4;
        }
        int n5 = arrc2[0] == '/' ? 1 : 0;
        return new String(arrc2, n5, n4 - n5);
    }

    Runtime$FStat hostFStat(File file, Object object) {
        Object object2;
        boolean bl2 = false;
        try {
            object2 = new FileInputStream(file);
            switch (object2.read()) {
                case 127: {
                    bl2 = object2.read() == 69 && object2.read() == 76 && object2.read() == 70;
                    break;
                }
                case 35: {
                    bl2 = object2.read() == 33;
                }
            }
            object2.close();
        }
        catch (IOException var4_5) {
            // empty catch block
        }
        object2 = (UnixRuntime$HostFS)object;
        short s2 = object2.inodes.get(file.getAbsolutePath());
        int n2 = object2.devno;
        return new UnixRuntime$1(this, file, bl2, s2, n2);
    }

    @Override
    Runtime$FD hostFSDirFD(File file, Object object) {
        UnixRuntime$HostFS unixRuntime$HostFS;
        UnixRuntime$HostFS unixRuntime$HostFS2 = unixRuntime$HostFS = (UnixRuntime$HostFS)object;
        unixRuntime$HostFS2.getClass();
        return new UnixRuntime$HostFS$HostDirFD(unixRuntime$HostFS2, file);
    }

    private static void putInt(byte[] arrby, int n2, int n3) {
        arrby[n2 + 0] = (byte)(n3 >>> 24 & 255);
        arrby[n2 + 1] = (byte)(n3 >>> 16 & 255);
        arrby[n2 + 2] = (byte)(n3 >>> 8 & 255);
        arrby[n2 + 3] = (byte)(n3 >>> 0 & 255);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static void access$500(byte[] arrby, int n2, int n3) {
        UnixRuntime.putInt(arrby, n2, n3);
    }

    static {
        Method method;
        defaultGS = new UnixRuntime$GlobalState();
        try {
            Class[] arrclass = new Class[3];
            Class class_ = class$org$ibex$nestedvm$util$Seekable == null ? (UnixRuntime.class$org$ibex$nestedvm$util$Seekable = UnixRuntime.class$("org.ibex.nestedvm.util.Seekable")) : class$org$ibex$nestedvm$util$Seekable;
            arrclass[0] = class_;
            Class class_2 = class$java$lang$String == null ? (UnixRuntime.class$java$lang$String = UnixRuntime.class$("java.lang.String")) : class$java$lang$String;
            arrclass[1] = class_2;
            arrclass[2] = class$java$lang$String == null ? (UnixRuntime.class$java$lang$String = UnixRuntime.class$("java.lang.String")) : class$java$lang$String;
            method = Class.forName("org.ibex.nestedvm.RuntimeCompiler").getMethod("compile", arrclass);
        }
        catch (NoSuchMethodException var1_1) {
            method = null;
        }
        catch (ClassNotFoundException var1_2) {
            method = null;
        }
        runtimeCompilerCompile = method;
    }
}

