/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.Seekable;

public abstract class Seekable$Lock {
    private Object owner = null;

    public abstract Seekable seekable();

    public abstract boolean isShared();

    public abstract boolean isValid();

    public abstract void release();

    public abstract long position();

    public abstract long size();

    public void setOwner(Object object) {
        this.owner = object;
    }

    public Object getOwner() {
        return this.owner;
    }

    public final boolean contains(int n2, int n3) {
        if ((long)n2 < this.position()) return false;
        if (this.position() + this.size() < (long)(n2 + n3)) return false;
        return true;
    }

    public final boolean contained(int n2, int n3) {
        if ((long)n2 >= this.position()) return false;
        if (this.position() + this.size() >= (long)(n2 + n3)) return false;
        return true;
    }

    public final boolean overlaps(int n2, int n3) {
        if (this.contains(n2, n3)) return true;
        if (this.contained(n2, n3)) return true;
        return false;
    }
}

