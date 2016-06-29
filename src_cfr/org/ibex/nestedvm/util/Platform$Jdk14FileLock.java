/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.nio.channels.FileLock;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

final class Platform$Jdk14FileLock
extends Seekable$Lock {
    private final Seekable s;
    private final FileLock l;

    Platform$Jdk14FileLock(Seekable seekable, FileLock fileLock) {
        this.s = seekable;
        this.l = fileLock;
    }

    @Override
    public Seekable seekable() {
        return this.s;
    }

    @Override
    public boolean isShared() {
        return this.l.isShared();
    }

    @Override
    public boolean isValid() {
        return this.l.isValid();
    }

    @Override
    public void release() {
        this.l.release();
    }

    @Override
    public long position() {
        return this.l.position();
    }

    @Override
    public long size() {
        return this.l.size();
    }

    public String toString() {
        return this.l.toString();
    }
}

