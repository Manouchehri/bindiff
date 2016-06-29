/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.UnixRuntime$Pipe;

public class UnixRuntime$Pipe$Writer
extends Runtime$FD {
    private final UnixRuntime$Pipe this$0;

    public UnixRuntime$Pipe$Writer(UnixRuntime$Pipe unixRuntime$Pipe) {
        this.this$0 = unixRuntime$Pipe;
    }

    @Override
    protected Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int write(byte[] arrby, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        UnixRuntime$Pipe unixRuntime$Pipe = this.this$0;
        synchronized (unixRuntime$Pipe) {
            if (UnixRuntime$Pipe.access$200(this.this$0) == -1) {
                throw new Runtime$ErrnoException(32);
            }
            if (UnixRuntime$Pipe.access$300(this.this$0).length - UnixRuntime$Pipe.access$100(this.this$0) < Math.min(n3, 512)) {
                while (UnixRuntime$Pipe.access$200(this.this$0) != -1 && UnixRuntime$Pipe.access$200(this.this$0) != UnixRuntime$Pipe.access$100(this.this$0)) {
                    try {
                        this.this$0.wait();
                    }
                    catch (InterruptedException var5_5) {}
                }
                if (UnixRuntime$Pipe.access$200(this.this$0) == -1) {
                    throw new Runtime$ErrnoException(32);
                }
                UnixRuntime$Pipe.access$202(this.this$0, UnixRuntime$Pipe.access$102(this.this$0, 0));
            }
            n3 = Math.min(n3, UnixRuntime$Pipe.access$300(this.this$0).length - UnixRuntime$Pipe.access$100(this.this$0));
            System.arraycopy(arrby, n2, UnixRuntime$Pipe.access$300(this.this$0), UnixRuntime$Pipe.access$100(this.this$0), n3);
            if (UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                this.this$0.notify();
            }
            UnixRuntime$Pipe.access$112(this.this$0, n3);
            return n3;
        }
    }

    @Override
    public int flags() {
        return 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void _close() {
        UnixRuntime$Pipe unixRuntime$Pipe = this.this$0;
        synchronized (unixRuntime$Pipe) {
            UnixRuntime$Pipe.access$102(this.this$0, -1);
            this.this$0.notify();
            return;
        }
    }
}

