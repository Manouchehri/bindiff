package org.ibex.nestedvm;

public abstract class Runtime$FStat
{
    public static final int S_IFIFO = 4096;
    public static final int S_IFCHR = 8192;
    public static final int S_IFDIR = 16384;
    public static final int S_IFREG = 32768;
    public static final int S_IFSOCK = 49152;
    
    public int mode() {
        return 0;
    }
    
    public int nlink() {
        return 0;
    }
    
    public int uid() {
        return 0;
    }
    
    public int gid() {
        return 0;
    }
    
    public int size() {
        return 0;
    }
    
    public int atime() {
        return 0;
    }
    
    public int mtime() {
        return 0;
    }
    
    public int ctime() {
        return 0;
    }
    
    public int blksize() {
        return 512;
    }
    
    public int blocks() {
        return (this.size() + this.blksize() - 1) / this.blksize();
    }
    
    public abstract int dev();
    
    public abstract int type();
    
    public abstract int inode();
}
