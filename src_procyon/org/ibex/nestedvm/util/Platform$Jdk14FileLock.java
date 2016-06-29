package org.ibex.nestedvm.util;

import java.nio.channels.*;

final class Platform$Jdk14FileLock extends Seekable$Lock
{
    private final Seekable s;
    private final FileLock l;
    
    Platform$Jdk14FileLock(final Seekable s, final FileLock l) {
        this.s = s;
        this.l = l;
    }
    
    public Seekable seekable() {
        return this.s;
    }
    
    public boolean isShared() {
        return this.l.isShared();
    }
    
    public boolean isValid() {
        return this.l.isValid();
    }
    
    public void release() {
        this.l.release();
    }
    
    public long position() {
        return this.l.position();
    }
    
    public long size() {
        return this.l.size();
    }
    
    public String toString() {
        return this.l.toString();
    }
}
