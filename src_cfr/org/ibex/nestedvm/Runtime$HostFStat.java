/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.util.Seekable$File;

class Runtime$HostFStat
extends Runtime$FStat {
    private final File f;
    private final Seekable$File sf;
    private final boolean executable;

    public Runtime$HostFStat(File file, Seekable$File seekable$File) {
        this(file, seekable$File, false);
    }

    public Runtime$HostFStat(File file, boolean bl2) {
        this(file, null, bl2);
    }

    public Runtime$HostFStat(File file, Seekable$File seekable$File, boolean bl2) {
        this.f = file;
        this.sf = seekable$File;
        this.executable = bl2;
    }

    @Override
    public int dev() {
        return 1;
    }

    @Override
    public int inode() {
        return this.f.getAbsolutePath().hashCode() & 32767;
    }

    @Override
    public int type() {
        if (!this.f.isDirectory()) return 32768;
        return 16384;
    }

    @Override
    public int nlink() {
        return 1;
    }

    @Override
    public int mode() {
        int n2 = 0;
        boolean bl2 = this.f.canRead();
        if (bl2 && (this.executable || this.f.isDirectory())) {
            n2 |= 73;
        }
        if (bl2) {
            n2 |= 292;
        }
        if (!this.f.canWrite()) return n2;
        n2 |= 146;
        return n2;
    }

    @Override
    public int size() {
        try {
            int n2;
            if (this.sf != null) {
                n2 = this.sf.length();
                return n2;
            }
            n2 = (int)this.f.length();
            return n2;
        }
        catch (Exception var1_1) {
            return (int)this.f.length();
        }
    }

    @Override
    public int mtime() {
        return (int)(this.f.lastModified() / 1000);
    }
}

