/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import java.util.Hashtable;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$CygdriveFS;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.UnixRuntime$GlobalState$MP;
import org.ibex.nestedvm.UnixRuntime$HostFS;
import org.ibex.nestedvm.UnixRuntime$ResourceFS;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;
import org.ibex.nestedvm.util.Sort;
import org.ibex.nestedvm.util.Sort$Comparable;

public final class UnixRuntime$GlobalState {
    Hashtable execCache = new Hashtable();
    final UnixRuntime[] tasks;
    int nextPID = 1;
    Seekable.Lock[] locks = new Seekable.Lock[16];
    private UnixRuntime$GlobalState$MP[] mps = new UnixRuntime$GlobalState$MP[0];
    private UnixRuntime$FS root;

    public UnixRuntime$GlobalState() {
        this(255);
    }

    public UnixRuntime$GlobalState(int n2) {
        this(n2, true);
    }

    public UnixRuntime$GlobalState(int n2, boolean bl2) {
        File[] arrfile;
        this.tasks = new UnixRuntime[n2 + 1];
        if (!bl2) return;
        File file = null;
        if (Platform.getProperty("nestedvm.root") != null) {
            file = new File(Platform.getProperty("nestedvm.root"));
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("nestedvm.root is not a directory");
            }
        } else {
            arrfile = Platform.getProperty("user.dir");
            file = Platform.getRoot(new File((String)(arrfile != null ? arrfile : ".")));
        }
        this.addMount("/", new UnixRuntime$HostFS(file));
        if (Platform.getProperty("nestedvm.root") == null) {
            arrfile = Platform.listRoots();
            for (int i2 = 0; i2 < arrfile.length; ++i2) {
                String string = arrfile[i2].getPath();
                if (string.endsWith(File.separator)) {
                    string = string.substring(0, string.length() - 1);
                }
                if (string.length() == 0 || string.indexOf(47) != -1) continue;
                this.addMount(new StringBuffer().append("/").append(string.toLowerCase()).toString(), new UnixRuntime$HostFS(arrfile[i2]));
            }
        }
        this.addMount("/dev", new UnixRuntime$DevFS());
        this.addMount("/resource", new UnixRuntime$ResourceFS());
        this.addMount("/cygdrive", new UnixRuntime$CygdriveFS());
    }

    public String mapHostPath(String string) {
        return this.mapHostPath(new File(string));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String mapHostPath(File file) {
        char[] arrc;
        char c2;
        String string;
        String string2;
        block10 : {
            UnixRuntime$FS unixRuntime$FS;
            UnixRuntime$GlobalState unixRuntime$GlobalState = this;
            synchronized (unixRuntime$GlobalState) {
                unixRuntime$FS = this.root;
            }
            if (!file.isAbsolute()) {
                file = new File(file.getAbsolutePath());
            }
            int n2 = this.mps.length;
            while (n2 >= 0) {
                UnixRuntime$FS unixRuntime$FS2 = n2 == this.mps.length ? unixRuntime$FS : this.mps[n2].fs;
                String string3 = string = n2 == this.mps.length ? "" : this.mps[n2].path;
                if (unixRuntime$FS2 instanceof UnixRuntime$HostFS) {
                    File file2 = ((UnixRuntime$HostFS)unixRuntime$FS2).getRoot();
                    if (!file2.isAbsolute()) {
                        file2 = new File(file2.getAbsolutePath());
                    }
                    if (file.getPath().startsWith(file2.getPath())) {
                        c2 = File.separatorChar;
                        string2 = file.getPath().substring(file2.getPath().length());
                        if (c2 == '/') return new StringBuffer().append("/").append(string.length() == 0 ? "" : new StringBuffer().append(string).append("/").toString()).append(string2).toString();
                        arrc = string2.toCharArray();
                        break block10;
                    }
                }
                --n2;
            }
            return null;
        }
        for (int i2 = 0; i2 < arrc.length; ++i2) {
            if (arrc[i2] == '/') {
                arrc[i2] = c2;
                continue;
            }
            if (arrc[i2] != c2) continue;
            arrc[i2] = 47;
        }
        string2 = new String(arrc);
        return new StringBuffer().append("/").append(string.length() == 0 ? "" : new StringBuffer().append(string).append("/").toString()).append(string2).toString();
    }

    public synchronized UnixRuntime$FS getMount(String string) {
        if (!string.startsWith("/")) {
            throw new IllegalArgumentException("Mount point doesn't start with a /");
        }
        if (string.equals("/")) {
            return this.root;
        }
        string = string.substring(1);
        int n2 = 0;
        while (n2 < this.mps.length) {
            if (this.mps[n2].path.equals(string)) {
                return this.mps[n2].fs;
            }
            ++n2;
        }
        return null;
    }

    public synchronized void addMount(String string, UnixRuntime$FS unixRuntime$FS) {
        if (this.getMount(string) != null) {
            throw new IllegalArgumentException("mount point already exists");
        }
        if (!string.startsWith("/")) {
            throw new IllegalArgumentException("Mount point doesn't start with a /");
        }
        if (unixRuntime$FS.owner != null) {
            unixRuntime$FS.owner.removeMount(unixRuntime$FS);
        }
        unixRuntime$FS.owner = this;
        if (string.equals("/")) {
            this.root = unixRuntime$FS;
            unixRuntime$FS.devno = 1;
            return;
        }
        string = string.substring(1);
        int n2 = this.mps.length;
        Sort$Comparable[] arrsort$Comparable = new UnixRuntime$GlobalState$MP[n2 + 1];
        if (n2 != 0) {
            System.arraycopy(this.mps, 0, arrsort$Comparable, 0, n2);
        }
        arrsort$Comparable[n2] = new UnixRuntime$GlobalState$MP(string, unixRuntime$FS);
        Sort.sort(arrsort$Comparable);
        this.mps = arrsort$Comparable;
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= this.mps.length) {
                unixRuntime$FS.devno = n3 + 2;
                return;
            }
            n3 = Runtime.max(n3, this.mps[n4].fs.devno);
            ++n4;
        } while (true);
    }

    public synchronized void removeMount(UnixRuntime$FS unixRuntime$FS) {
        int n2 = 0;
        while (n2 < this.mps.length) {
            if (this.mps[n2].fs == unixRuntime$FS) {
                this.removeMount(n2);
                return;
            }
            ++n2;
        }
        throw new IllegalArgumentException("mount point doesn't exist");
    }

    public synchronized void removeMount(String string) {
        int n2;
        if (!string.startsWith("/")) {
            throw new IllegalArgumentException("Mount point doesn't start with a /");
        }
        if (string.equals("/")) {
            this.removeMount(-1);
            return;
        }
        string = string.substring(1);
        for (n2 = 0; n2 < this.mps.length && !this.mps[n2].path.equals(string); ++n2) {
        }
        if (n2 == this.mps.length) {
            throw new IllegalArgumentException("mount point doesn't exist");
        }
        this.removeMount(n2);
    }

    private void removeMount(int n2) {
        if (n2 == -1) {
            this.root.owner = null;
            this.root = null;
            return;
        }
        UnixRuntime$GlobalState$MP[] arrunixRuntime$GlobalState$MP = new UnixRuntime$GlobalState$MP[this.mps.length - 1];
        System.arraycopy(this.mps, 0, arrunixRuntime$GlobalState$MP, 0, n2);
        System.arraycopy(this.mps, 0, arrunixRuntime$GlobalState$MP, n2, this.mps.length - n2 - 1);
        this.mps = arrunixRuntime$GlobalState$MP;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Object fsop(int n2, UnixRuntime unixRuntime, String string, int n3, int n4) {
        String string2;
        int n5;
        block6 : {
            UnixRuntime$GlobalState$MP[] arrunixRuntime$GlobalState$MP;
            int n6 = string.length();
            if (n6 == 0) return this.root.dispatch(n2, unixRuntime, string, n3, n4);
            UnixRuntime$GlobalState unixRuntime$GlobalState = this;
            synchronized (unixRuntime$GlobalState) {
                arrunixRuntime$GlobalState$MP = this.mps;
            }
            int n7 = 0;
            while (n7 < arrunixRuntime$GlobalState$MP.length) {
                UnixRuntime$GlobalState$MP unixRuntime$GlobalState$MP = arrunixRuntime$GlobalState$MP[n7];
                n5 = unixRuntime$GlobalState$MP.path.length();
                if (string.startsWith(unixRuntime$GlobalState$MP.path) && (n6 == n5 || string.charAt(n5) == '/')) {
                    if (n6 == n5) {
                        string2 = "";
                        return unixRuntime$GlobalState$MP.fs.dispatch(n2, unixRuntime, string2, n3, n4);
                    }
                    break block6;
                }
                ++n7;
            }
            return this.root.dispatch(n2, unixRuntime, string, n3, n4);
        }
        string2 = string.substring(n5 + 1);
        return unixRuntime$GlobalState$MP.fs.dispatch(n2, unixRuntime, string2, n3, n4);
    }

    public final Runtime$FD open(UnixRuntime unixRuntime, String string, int n2, int n3) {
        return (Runtime$FD)this.fsop(1, unixRuntime, string, n2, n3);
    }

    public final Runtime$FStat stat(UnixRuntime unixRuntime, String string) {
        return (Runtime$FStat)this.fsop(2, unixRuntime, string, 0, 0);
    }

    public final Runtime$FStat lstat(UnixRuntime unixRuntime, String string) {
        return (Runtime$FStat)this.fsop(3, unixRuntime, string, 0, 0);
    }

    public final void mkdir(UnixRuntime unixRuntime, String string, int n2) {
        this.fsop(4, unixRuntime, string, n2, 0);
    }

    public final void unlink(UnixRuntime unixRuntime, String string) {
        this.fsop(5, unixRuntime, string, 0, 0);
    }
}

