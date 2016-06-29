package org.ibex.nestedvm;

class UnixRuntime$DevFS$1 extends Runtime$FD
{
    private final UnixRuntime$DevFS this$0;
    
    UnixRuntime$DevFS$1(final UnixRuntime$DevFS this$0) {
        this.this$0 = this$0;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        for (int i = n; i < n + n2; ++i) {
            array[i] = 0;
        }
        return n2;
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        return n2;
    }
    
    public int seek(final int n, final int n2) {
        return 0;
    }
    
    public Runtime$FStat _fstat() {
        return new UnixRuntime$DevFS$1$1(this);
    }
    
    public int flags() {
        return 2;
    }
    
    static UnixRuntime$DevFS access$700(final UnixRuntime$DevFS$1 unixRuntime$DevFS$1) {
        return unixRuntime$DevFS$1.this$0;
    }
}
