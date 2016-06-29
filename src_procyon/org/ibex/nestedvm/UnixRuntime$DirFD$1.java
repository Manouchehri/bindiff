package org.ibex.nestedvm;

class UnixRuntime$DirFD$1 extends Runtime$FStat
{
    private final UnixRuntime$DirFD this$0;
    
    UnixRuntime$DirFD$1(final UnixRuntime$DirFD this$0) {
        this.this$0 = this$0;
    }
    
    public int type() {
        return 16384;
    }
    
    public int inode() {
        return this.this$0.myInode();
    }
    
    public int dev() {
        return this.this$0.myDev();
    }
}
