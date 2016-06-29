package org.ibex.nestedvm;

public class UnixRuntime$Pipe$Writer extends Runtime$FD
{
    private final UnixRuntime$Pipe this$0;
    
    public UnixRuntime$Pipe$Writer(final UnixRuntime$Pipe this$0) {
        this.this$0 = this$0;
    }
    
    protected Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }
    
    public int write(final byte[] array, final int n, int min) {
        if (min == 0) {
            return 0;
        }
        synchronized (this.this$0) {
            if (UnixRuntime$Pipe.access$200(this.this$0) == -1) {
                throw new Runtime$ErrnoException(32);
            }
            if (UnixRuntime$Pipe.access$300(this.this$0).length - UnixRuntime$Pipe.access$100(this.this$0) < Math.min(min, 512)) {
                while (UnixRuntime$Pipe.access$200(this.this$0) != -1 && UnixRuntime$Pipe.access$200(this.this$0) != UnixRuntime$Pipe.access$100(this.this$0)) {
                    try {
                        this.this$0.wait();
                    }
                    catch (InterruptedException ex) {}
                }
                if (UnixRuntime$Pipe.access$200(this.this$0) == -1) {
                    throw new Runtime$ErrnoException(32);
                }
                UnixRuntime$Pipe.access$202(this.this$0, UnixRuntime$Pipe.access$102(this.this$0, 0));
            }
            min = Math.min(min, UnixRuntime$Pipe.access$300(this.this$0).length - UnixRuntime$Pipe.access$100(this.this$0));
            System.arraycopy(array, n, UnixRuntime$Pipe.access$300(this.this$0), UnixRuntime$Pipe.access$100(this.this$0), min);
            if (UnixRuntime$Pipe.access$200(this.this$0) == UnixRuntime$Pipe.access$100(this.this$0)) {
                this.this$0.notify();
            }
            UnixRuntime$Pipe.access$112(this.this$0, min);
            return min;
        }
    }
    
    public int flags() {
        return 1;
    }
    
    public void _close() {
        synchronized (this.this$0) {
            UnixRuntime$Pipe.access$102(this.this$0, -1);
            this.this$0.notify();
        }
    }
}
