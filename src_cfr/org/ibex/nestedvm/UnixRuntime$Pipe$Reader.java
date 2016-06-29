/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;
import org.ibex.nestedvm.UnixRuntime$Pipe;

public class UnixRuntime$Pipe$Reader
extends Runtime$FD {
    private final UnixRuntime$Pipe this$0;

    public UnixRuntime$Pipe$Reader(UnixRuntime$Pipe pipe) {
        this.this$0 = pipe;
    }

    @Override
    protected Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (n3 == 0) {
            return 0;
        }
        UnixRuntime$Pipe unixRuntime$Pipe = this.this$0;
        synchronized (unixRuntime$Pipe) {
            while (UnixRuntime$Pipe.access$100(this.this$0) != -1 && UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                try {
                    this.this$0.wait();
                }
                catch (InterruptedException var5_5) {}
            }
            if (UnixRuntime$Pipe.access$100(this.this$0) == -1) {
                return 0;
            }
            n3 = Math.min(n3, UnixRuntime$Pipe.access$100(this.this$0) - UnixRuntime$Pipe.access$200(this.this$0));
            System.arraycopy(UnixRuntime$Pipe.access$300(this.this$0), UnixRuntime$Pipe.access$200(this.this$0), arrby, n2, n3);
            UnixRuntime$Pipe.access$212(this.this$0, n3);
            if (UnixRuntime$Pipe.access$200(this.this$0) != UnixRuntime$Pipe.access$100(this.this$0)) return n3;
            this.this$0.notify();
            return n3;
        }
    }

    @Override
    public int flags() {
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void _close() {
        UnixRuntime$Pipe unixRuntime$Pipe = this.this$0;
        synchronized (unixRuntime$Pipe) {
            UnixRuntime$Pipe.access$202(this.this$0, -1);
            this.this$0.notify();
            return;
        }
    }
}

