package org.ibex.nestedvm;

class UnixRuntime$DevFS$4 extends UnixRuntime$DevFS$DevDirFD
{
    private final UnixRuntime$DevFS this$0;
    
    UnixRuntime$DevFS$4(final UnixRuntime$DevFS this$0) {
        super(this$0, null);
        this.this$0 = this$0;
    }
    
    public int myInode() {
        return 1;
    }
    
    public int parentInode() {
        return 1;
    }
    
    public int inode(final int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 3;
            }
            case 2: {
                return 4;
            }
            default: {
                return -1;
            }
        }
    }
    
    public String name(final int n) {
        switch (n) {
            case 0: {
                return "null";
            }
            case 1: {
                return "zero";
            }
            case 2: {
                return "fd";
            }
            default: {
                return null;
            }
        }
    }
    
    public int size() {
        return 3;
    }
}
