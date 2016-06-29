package org.ibex.nestedvm;

public abstract class UnixRuntime$FS
{
    static final int OPEN = 1;
    static final int STAT = 2;
    static final int LSTAT = 3;
    static final int MKDIR = 4;
    static final int UNLINK = 5;
    UnixRuntime$GlobalState owner;
    int devno;
    
    Object dispatch(final int n, final UnixRuntime unixRuntime, final String s, final int n2, final int n3) {
        switch (n) {
            case 1: {
                return this.open(unixRuntime, s, n2, n3);
            }
            case 2: {
                return this.stat(unixRuntime, s);
            }
            case 3: {
                return this.lstat(unixRuntime, s);
            }
            case 4: {
                this.mkdir(unixRuntime, s, n2);
                return null;
            }
            case 5: {
                this.unlink(unixRuntime, s);
                return null;
            }
            default: {
                throw new Error("should never happen");
            }
        }
    }
    
    public Runtime$FStat lstat(final UnixRuntime unixRuntime, final String s) {
        return this.stat(unixRuntime, s);
    }
    
    public abstract Runtime$FD open(final UnixRuntime p0, final String p1, final int p2, final int p3);
    
    public abstract Runtime$FStat stat(final UnixRuntime p0, final String p1);
    
    public abstract void mkdir(final UnixRuntime p0, final String p1, final int p2);
    
    public abstract void unlink(final UnixRuntime p0, final String p1);
}
