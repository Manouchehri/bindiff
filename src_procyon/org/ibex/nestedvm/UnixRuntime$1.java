package org.ibex.nestedvm;

import java.io.*;

class UnixRuntime$1 extends Runtime$HostFStat
{
    private final int val$inode;
    private final int val$devno;
    private final UnixRuntime this$0;
    
    UnixRuntime$1(final UnixRuntime this$0, final File file, final boolean b, final int val$inode, final int val$devno) {
        super(file, b);
        this.this$0 = this$0;
        this.val$inode = val$inode;
        this.val$devno = val$devno;
    }
    
    public int inode() {
        return this.val$inode;
    }
    
    public int dev() {
        return this.val$devno;
    }
}
