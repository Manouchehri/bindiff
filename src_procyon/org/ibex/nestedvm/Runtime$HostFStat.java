package org.ibex.nestedvm;

import java.io.*;
import org.ibex.nestedvm.util.*;

class Runtime$HostFStat extends Runtime$FStat
{
    private final File f;
    private final Seekable$File sf;
    private final boolean executable;
    
    public Runtime$HostFStat(final File file, final Seekable$File seekable$File) {
        this(file, seekable$File, false);
    }
    
    public Runtime$HostFStat(final File file, final boolean b) {
        this(file, null, b);
    }
    
    public Runtime$HostFStat(final File f, final Seekable$File sf, final boolean executable) {
        this.f = f;
        this.sf = sf;
        this.executable = executable;
    }
    
    public int dev() {
        return 1;
    }
    
    public int inode() {
        return this.f.getAbsolutePath().hashCode() & 0x7FFF;
    }
    
    public int type() {
        return this.f.isDirectory() ? 16384 : 32768;
    }
    
    public int nlink() {
        return 1;
    }
    
    public int mode() {
        int n = 0;
        final boolean canRead = this.f.canRead();
        if (canRead && (this.executable || this.f.isDirectory())) {
            n |= 0x49;
        }
        if (canRead) {
            n |= 0x124;
        }
        if (this.f.canWrite()) {
            n |= 0x92;
        }
        return n;
    }
    
    public int size() {
        try {
            return (this.sf != null) ? this.sf.length() : ((int)this.f.length());
        }
        catch (Exception ex) {
            return (int)this.f.length();
        }
    }
    
    public int mtime() {
        return (int)(this.f.lastModified() / 1000L);
    }
}
