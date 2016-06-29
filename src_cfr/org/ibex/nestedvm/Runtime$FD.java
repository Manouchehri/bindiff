/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.util.Seekable;

public abstract class Runtime$FD {
    private int refCount = 1;
    private String normalizedPath = null;
    private boolean deleteOnClose = false;
    private Runtime$FStat cachedFStat = null;

    public void setNormalizedPath(String string) {
        this.normalizedPath = string;
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

    public int read(byte[] arrby, int n2, int n3) {
        throw new Runtime$ErrnoException(81);
    }

    public int write(byte[] arrby, int n2, int n3) {
        throw new Runtime$ErrnoException(81);
    }

    public int seek(int n2, int n3) {
        return -1;
    }

    public int getdents(byte[] arrby, int n2, int n3) {
        throw new Runtime$ErrnoException(81);
    }

    Seekable seekable() {
        return null;
    }

    public final Runtime$FStat fstat() {
        if (this.cachedFStat != null) return this.cachedFStat;
        this.cachedFStat = this._fstat();
        return this.cachedFStat;
    }

    protected abstract Runtime$FStat _fstat();

    public abstract int flags();

    public final void close() {
        if (--this.refCount != 0) return;
        this._close();
    }

    protected void _close() {
    }

    Runtime$FD dup() {
        ++this.refCount;
        return this;
    }
}

