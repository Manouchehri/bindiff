package org.ibex.nestedvm;

class UnixRuntime$DevFS$2 extends Runtime$FD
{
    private final UnixRuntime$DevFS this$0;
    
    UnixRuntime$DevFS$2(final UnixRuntime$DevFS this$0) {
        this.this$0 = this$0;
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        return 0;
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        return n2;
    }
    
    public int seek(final int n, final int n2) {
        return 0;
    }
    
    public Runtime$FStat _fstat() {
        return new UnixRuntime$DevFS$2$1(this);
    }
    
    public int flags() {
        return 2;
    }
    
    static UnixRuntime$DevFS access$800(final UnixRuntime$DevFS$2 unixRuntime$DevFS$2) {
        return unixRuntime$DevFS$2.this$0;
    }
}
