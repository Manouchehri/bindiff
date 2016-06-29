package org.ibex.nestedvm;

import org.ibex.nestedvm.util.*;

public abstract class Runtime$FD
{
    private int refCount;
    private String normalizedPath;
    private boolean deleteOnClose;
    private Runtime$FStat cachedFStat;
    
    public Runtime$FD() {
        this.refCount = 1;
        this.normalizedPath = null;
        this.deleteOnClose = false;
        this.cachedFStat = null;
    }
    
    public void setNormalizedPath(final String normalizedPath) {
        this.normalizedPath = normalizedPath;
    }
    
    public String getNormalizedPath() {
        return this.normalizedPath;
    }
    
    public void markDeleteOnClose() {
        this.deleteOnClose = true;
    }
    
    public boolean isMarkedForDeleteOnClose() {
        return this.deleteOnClose;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        throw new Runtime$ErrnoException(81);
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        throw new Runtime$ErrnoException(81);
    }
    
    public int seek(final int n, final int n2) {
        return -1;
    }
    
    public int getdents(final byte[] array, final int n, final int n2) {
        throw new Runtime$ErrnoException(81);
    }
    
    Seekable seekable() {
        return null;
    }
    
    public final Runtime$FStat fstat() {
        if (this.cachedFStat == null) {
            this.cachedFStat = this._fstat();
        }
        return this.cachedFStat;
    }
    
    protected abstract Runtime$FStat _fstat();
    
    public abstract int flags();
    
    public final void close() {
        final int refCount = this.refCount - 1;
        this.refCount = refCount;
        if (refCount == 0) {
            this._close();
        }
    }
    
    protected void _close() {
    }
    
    Runtime$FD dup() {
        ++this.refCount;
        return this;
    }
}
