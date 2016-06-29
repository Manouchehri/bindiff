package org.ibex.nestedvm;

import java.util.*;
import java.io.*;
import org.ibex.nestedvm.util.*;

public final class UnixRuntime$GlobalState
{
    Hashtable execCache;
    final UnixRuntime[] tasks;
    int nextPID;
    Seekable$Lock[] locks;
    private UnixRuntime$GlobalState$MP[] mps;
    private UnixRuntime$FS root;
    
    public UnixRuntime$GlobalState() {
        this(255);
    }
    
    public UnixRuntime$GlobalState(final int n) {
        this(n, true);
    }
    
    public UnixRuntime$GlobalState(final int n, final boolean b) {
        this.execCache = new Hashtable();
        this.nextPID = 1;
        this.locks = new Seekable$Lock[16];
        this.mps = new UnixRuntime$GlobalState$MP[0];
        this.tasks = new UnixRuntime[n + 1];
        if (b) {
            File root;
            if (Platform.getProperty("nestedvm.root") != null) {
                root = new File(Platform.getProperty("nestedvm.root"));
                if (!root.isDirectory()) {
                    throw new IllegalArgumentException("nestedvm.root is not a directory");
                }
            }
            else {
                final String property = Platform.getProperty("user.dir");
                root = Platform.getRoot(new File((property != null) ? property : "."));
            }
            this.addMount("/", new UnixRuntime$HostFS(root));
            if (Platform.getProperty("nestedvm.root") == null) {
                final File[] listRoots = Platform.listRoots();
                for (int i = 0; i < listRoots.length; ++i) {
                    String s = listRoots[i].getPath();
                    if (s.endsWith(File.separator)) {
                        s = s.substring(0, s.length() - 1);
                    }
                    if (s.length() != 0) {
                        if (s.indexOf(47) == -1) {
                            this.addMount("/" + s.toLowerCase(), new UnixRuntime$HostFS(listRoots[i]));
                        }
                    }
                }
            }
            this.addMount("/dev", new UnixRuntime$DevFS());
            this.addMount("/resource", new UnixRuntime$ResourceFS());
            this.addMount("/cygdrive", new UnixRuntime$CygdriveFS());
        }
    }
    
    public String mapHostPath(final String s) {
        return this.mapHostPath(new File(s));
    }
    
    public String mapHostPath(File file) {
        final UnixRuntime$FS root;
        synchronized (this) {
            this.mps = this.mps;
            root = this.root;
        }
        if (!file.isAbsolute()) {
            file = new File(file.getAbsolutePath());
        }
        for (int i = this.mps.length; i >= 0; --i) {
            final UnixRuntime$FS unixRuntime$FS = (i == this.mps.length) ? root : this.mps[i].fs;
            final String s = (i == this.mps.length) ? "" : this.mps[i].path;
            if (unixRuntime$FS instanceof UnixRuntime$HostFS) {
                File root2 = ((UnixRuntime$HostFS)unixRuntime$FS).getRoot();
                if (!root2.isAbsolute()) {
                    root2 = new File(root2.getAbsolutePath());
                }
                if (file.getPath().startsWith(root2.getPath())) {
                    final char separatorChar = File.separatorChar;
                    String substring = file.getPath().substring(root2.getPath().length());
                    if (separatorChar != '/') {
                        final char[] charArray = substring.toCharArray();
                        for (int j = 0; j < charArray.length; ++j) {
                            if (charArray[j] == '/') {
                                charArray[j] = separatorChar;
                            }
                            else if (charArray[j] == separatorChar) {
                                charArray[j] = '/';
                            }
                        }
                        substring = new String(charArray);
                    }
                    return "/" + ((s.length() == 0) ? "" : (s + "/")) + substring;
                }
            }
        }
        return null;
    }
    
    public synchronized UnixRuntime$FS getMount(String substring) {
        if (!substring.startsWith("/")) {
            throw new IllegalArgumentException("Mount point doesn't start with a /");
        }
        if (substring.equals("/")) {
            return this.root;
        }
        substring = substring.substring(1);
        for (int i = 0; i < this.mps.length; ++i) {
            if (this.mps[i].path.equals(substring)) {
                return this.mps[i].fs;
            }
        }
        return null;
    }
    
    public synchronized void addMount(String substring, final UnixRuntime$FS root) {
        if (this.getMount(substring) != null) {
            throw new IllegalArgumentException("mount point already exists");
        }
        if (!substring.startsWith("/")) {
            throw new IllegalArgumentException("Mount point doesn't start with a /");
        }
        if (root.owner != null) {
            root.owner.removeMount(root);
        }
        root.owner = this;
        if (substring.equals("/")) {
            this.root = root;
            root.devno = 1;
            return;
        }
        substring = substring.substring(1);
        final int length = this.mps.length;
        final UnixRuntime$GlobalState$MP[] mps = new UnixRuntime$GlobalState$MP[length + 1];
        if (length != 0) {
            System.arraycopy(this.mps, 0, mps, 0, length);
        }
        mps[length] = new UnixRuntime$GlobalState$MP(substring, root);
        Sort.sort(mps);
        this.mps = mps;
        int max = 0;
        for (int i = 0; i < this.mps.length; ++i) {
            max = Runtime.max(max, this.mps[i].fs.devno);
        }
        root.devno = max + 2;
    }
    
    public synchronized void removeMount(final UnixRuntime$FS unixRuntime$FS) {
        for (int i = 0; i < this.mps.length; ++i) {
            if (this.mps[i].fs == unixRuntime$FS) {
                this.removeMount(i);
                return;
            }
        }
        throw new IllegalArgumentException("mount point doesn't exist");
    }
    
    public synchronized void removeMount(String substring) {
        if (!substring.startsWith("/")) {
            throw new IllegalArgumentException("Mount point doesn't start with a /");
        }
        if (substring.equals("/")) {
            this.removeMount(-1);
        }
        else {
            int n;
            for (substring = substring.substring(1), n = 0; n < this.mps.length && !this.mps[n].path.equals(substring); ++n) {}
            if (n == this.mps.length) {
                throw new IllegalArgumentException("mount point doesn't exist");
            }
            this.removeMount(n);
        }
    }
    
    private void removeMount(final int n) {
        if (n == -1) {
            this.root.owner = null;
            this.root = null;
            return;
        }
        final UnixRuntime$GlobalState$MP[] mps = new UnixRuntime$GlobalState$MP[this.mps.length - 1];
        System.arraycopy(this.mps, 0, mps, 0, n);
        System.arraycopy(this.mps, 0, mps, n, this.mps.length - n - 1);
        this.mps = mps;
    }
    
    private Object fsop(final int n, final UnixRuntime unixRuntime, final String s, final int n2, final int n3) {
        final int length = s.length();
        if (length != 0) {
            final UnixRuntime$GlobalState$MP[] mps;
            synchronized (this) {
                mps = this.mps;
            }
            for (int i = 0; i < mps.length; ++i) {
                final UnixRuntime$GlobalState$MP unixRuntime$GlobalState$MP = mps[i];
                final int length2 = unixRuntime$GlobalState$MP.path.length();
                if (s.startsWith(unixRuntime$GlobalState$MP.path) && (length == length2 || s.charAt(length2) == '/')) {
                    return unixRuntime$GlobalState$MP.fs.dispatch(n, unixRuntime, (length == length2) ? "" : s.substring(length2 + 1), n2, n3);
                }
            }
        }
        return this.root.dispatch(n, unixRuntime, s, n2, n3);
    }
    
    public final Runtime$FD open(final UnixRuntime unixRuntime, final String s, final int n, final int n2) {
        return (Runtime$FD)this.fsop(1, unixRuntime, s, n, n2);
    }
    
    public final Runtime$FStat stat(final UnixRuntime unixRuntime, final String s) {
        return (Runtime$FStat)this.fsop(2, unixRuntime, s, 0, 0);
    }
    
    public final Runtime$FStat lstat(final UnixRuntime unixRuntime, final String s) {
        return (Runtime$FStat)this.fsop(3, unixRuntime, s, 0, 0);
    }
    
    public final void mkdir(final UnixRuntime unixRuntime, final String s, final int n) {
        this.fsop(4, unixRuntime, s, n, 0);
    }
    
    public final void unlink(final UnixRuntime unixRuntime, final String s) {
        this.fsop(5, unixRuntime, s, 0, 0);
    }
}
