package org.ibex.nestedvm;

abstract class UnixRuntime$DevFS$DevFStat extends Runtime$FStat
{
    private final UnixRuntime$DevFS this$0;
    
    private UnixRuntime$DevFS$DevFStat(final UnixRuntime$DevFS this$0) {
        this.this$0 = this$0;
    }
    
    public int dev() {
        return this.this$0.devno;
    }
    
    public int mode() {
        return 438;
    }
    
    public int type() {
        return 8192;
    }
    
    public int nlink() {
        return 1;
    }
    
    public abstract int inode();
    
    UnixRuntime$DevFS$DevFStat(final UnixRuntime$DevFS unixRuntime$DevFS, final UnixRuntime$1 unixRuntime$1) {
        this(unixRuntime$DevFS);
    }
}
