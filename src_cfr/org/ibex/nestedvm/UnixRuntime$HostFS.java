/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SecurityManager;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.util.InodeCache;

public class UnixRuntime$HostFS
extends UnixRuntime$FS {
    InodeCache inodes = new InodeCache(4000);
    protected File root;

    public File getRoot() {
        return this.root;
    }

    protected File hostFile(String string) {
        char c2 = File.separatorChar;
        if (c2 == '/') return new File(this.root, string);
        char[] arrc = string.toCharArray();
        int n2 = 0;
        do {
            if (n2 >= arrc.length) {
                string = new String(arrc);
                return new File(this.root, string);
            }
            char c3 = arrc[n2];
            if (c3 == '/') {
                arrc[n2] = c2;
            } else if (c3 == c2) {
                arrc[n2] = 47;
            }
            ++n2;
        } while (true);
    }

    public UnixRuntime$HostFS(String string) {
        this(new File(string));
    }

    public UnixRuntime$HostFS(File file) {
        this.root = file;
    }

    @Override
    public Runtime$FD open(UnixRuntime unixRuntime, String string, int n2, int n3) {
        File file = this.hostFile(string);
        return unixRuntime.hostFSOpen(file, n2, n3, this);
    }

    @Override
    public void unlink(UnixRuntime unixRuntime, String string) {
        File file = this.hostFile(string);
        if (unixRuntime.sm != null && !unixRuntime.sm.allowUnlink(file)) {
            throw new Runtime$ErrnoException(1);
        }
        if (!file.exists()) {
            throw new Runtime$ErrnoException(2);
        }
        if (file.delete()) return;
        boolean bl2 = false;
        int n2 = 0;
        do {
            String string2;
            if (n2 >= 64) {
                if (bl2) return;
                throw new Runtime$ErrnoException(1);
            }
            if (unixRuntime.fds[n2] != null && (string2 = unixRuntime.fds[n2].getNormalizedPath()) != null && string2.equals(string)) {
                unixRuntime.fds[n2].markDeleteOnClose();
                bl2 = true;
            }
            ++n2;
        } while (true);
    }

    @Override
    public Runtime$FStat stat(UnixRuntime unixRuntime, String string) {
        File file = this.hostFile(string);
        if (unixRuntime.sm != null && !unixRuntime.sm.allowStat(file)) {
            throw new Runtime$ErrnoException(13);
        }
        if (file.exists()) return unixRuntime.hostFStat(file, this);
        return null;
    }

    @Override
    public void mkdir(UnixRuntime unixRuntime, String string, int n2) {
        File file = this.hostFile(string);
        if (unixRuntime.sm != null && !unixRuntime.sm.allowWrite(file)) {
            throw new Runtime$ErrnoException(13);
        }
        if (file.exists() && file.isDirectory()) {
            throw new Runtime$ErrnoException(17);
        }
        if (file.exists()) {
            throw new Runtime$ErrnoException(20);
        }
        File file2 = UnixRuntime$HostFS.getParentFile(file);
        if (file2 != null) {
            if (!file2.exists()) throw new Runtime$ErrnoException(20);
            if (!file2.isDirectory()) {
                throw new Runtime$ErrnoException(20);
            }
        }
        if (file.mkdir()) return;
        throw new Runtime$ErrnoException(5);
    }

    private static File getParentFile(File file) {
        String string = file.getParent();
        if (string == null) {
            return null;
        }
        File file2 = new File(string);
        return file2;
    }

    static File access$400(File file) {
        return UnixRuntime$HostFS.getParentFile(file);
    }
}

