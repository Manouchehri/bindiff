package org.ibex.nestedvm;

public class UnixRuntime$Pipe$Reader extends Runtime$FD
{
    private final UnixRuntime$Pipe this$0;
    
    public UnixRuntime$Pipe$Reader(final UnixRuntime$Pipe this$0) {
        this.this$0 = this$0;
    }
    
    protected Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }
    
    public int read(final byte[] array, final int n, int min) {
        if (min == 0) {
            return 0;
        }
        synchronized (this.this$0) {
            while (UnixRuntime$Pipe.access$100(this.this$0) != -1 && UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                try {
                    this.this$0.wait();
                }
                catch (InterruptedException ex) {}
            }
            if (UnixRuntime$Pipe.access$100(this.this$0) == -1) {
                return 0;
            }
            min = Math.min(min, UnixRuntime$Pipe.access$100(this.this$0) - UnixRuntime$Pipe.access$200(this.this$0));
            System.arraycopy(UnixRuntime$Pipe.access$300(this.this$0), UnixRuntime$Pipe.access$200(this.this$0), array, n, min);
            UnixRuntime$Pipe.access$212(this.this$0, min);
            if (UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                this.this$0.notify();
            }
            return min;
        }
    }
    
    public int flags() {
        return 0;
    }
    
    public void _close() {
        synchronized (this.this$0) {
            UnixRuntime$Pipe.access$202(this.this$0, -1);
            this.this$0.notify();
        }
    }
}
