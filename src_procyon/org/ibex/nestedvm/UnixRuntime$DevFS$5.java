package org.ibex.nestedvm;

class UnixRuntime$DevFS$5 extends Runtime$FStat
{
    private final UnixRuntime$DevFS this$0;
    
    UnixRuntime$DevFS$5(final UnixRuntime$DevFS this$0) {
        this.this$0 = this$0;
    }
    
    public int inode() {
        return 4;
    }
    
    public int dev() {
        return this.this$0.devno;
    }
    
    public int type() {
        return 16384;
    }
    
    public int mode() {
        return 292;
    }
}
