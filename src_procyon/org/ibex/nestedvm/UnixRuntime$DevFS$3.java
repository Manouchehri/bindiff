package org.ibex.nestedvm;

class UnixRuntime$DevFS$3 extends UnixRuntime$DevFS$DevDirFD
{
    private final int[] val$files;
    private final UnixRuntime$DevFS this$0;
    
    UnixRuntime$DevFS$3(final UnixRuntime$DevFS this$0, final int[] val$files) {
        super(this$0, null);
        this.this$0 = this$0;
        this.val$files = val$files;
    }
    
    public int myInode() {
        return 4;
    }
    
    public int parentInode() {
        return 1;
    }
    
    public int inode(final int n) {
        return 32 + n;
    }
    
    public String name(final int n) {
        return Integer.toString(this.val$files[n]);
    }
    
    public int size() {
        return this.val$files.length;
    }
}
