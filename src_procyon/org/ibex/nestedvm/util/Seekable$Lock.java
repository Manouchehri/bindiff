package org.ibex.nestedvm.util;

public abstract class Seekable$Lock
{
    private Object owner;
    
    public Seekable$Lock() {
        this.owner = null;
    }
    
    public abstract Seekable seekable();
    
    public abstract boolean isShared();
    
    public abstract boolean isValid();
    
    public abstract void release();
    
    public abstract long position();
    
    public abstract long size();
    
    public void setOwner(final Object owner) {
        this.owner = owner;
    }
    
    public Object getOwner() {
        return this.owner;
    }
    
    public final boolean contains(final int n, final int n2) {
        return n >= this.position() && this.position() + this.size() >= n + n2;
    }
    
    public final boolean contained(final int n, final int n2) {
        return n < this.position() && this.position() + this.size() < n + n2;
    }
    
    public final boolean overlaps(final int n, final int n2) {
        return this.contains(n, n2) || this.contained(n, n2);
    }
}
