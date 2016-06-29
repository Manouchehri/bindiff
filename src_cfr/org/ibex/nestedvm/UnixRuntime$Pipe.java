/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.UnixRuntime$Pipe$Reader;
import org.ibex.nestedvm.UnixRuntime$Pipe$Writer;

class UnixRuntime$Pipe {
    private final byte[] pipebuf = new byte[2048];
    private int readPos;
    private int writePos;
    public final Runtime$FD reader;
    public final Runtime$FD writer;

    UnixRuntime$Pipe() {
        this.reader = new UnixRuntime$Pipe$Reader(this);
        this.writer = new UnixRuntime$Pipe$Writer(this);
    }

    static int access$100(UnixRuntime$Pipe unixRuntime$Pipe) {
        return unixRuntime$Pipe.writePos;
    }

    static int access$200(UnixRuntime$Pipe unixRuntime$Pipe) {
        return unixRuntime$Pipe.readPos;
    }

    static byte[] access$300(UnixRuntime$Pipe unixRuntime$Pipe) {
        return unixRuntime$Pipe.pipebuf;
    }

    static int access$212(UnixRuntime$Pipe unixRuntime$Pipe, int n2) {
        return unixRuntime$Pipe.readPos += n2;
    }

    static int access$202(UnixRuntime$Pipe unixRuntime$Pipe, int n2) {
        unixRuntime$Pipe.readPos = n2;
        return unixRuntime$Pipe.readPos;
    }

    static int access$102(UnixRuntime$Pipe unixRuntime$Pipe, int n2) {
        unixRuntime$Pipe.writePos = n2;
        return unixRuntime$Pipe.writePos;
    }

    static int access$112(UnixRuntime$Pipe unixRuntime$Pipe, int n2) {
        return unixRuntime$Pipe.writePos += n2;
    }
}

