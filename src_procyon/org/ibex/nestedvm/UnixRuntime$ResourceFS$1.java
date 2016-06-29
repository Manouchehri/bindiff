package org.ibex.nestedvm;

import java.net.*;

class UnixRuntime$ResourceFS$1 extends Runtime$FStat
{
    private final URLConnection val$conn;
    private final UnixRuntime$ResourceFS this$0;
    
    UnixRuntime$ResourceFS$1(final UnixRuntime$ResourceFS this$0, final URLConnection val$conn) {
        this.this$0 = this$0;
        this.val$conn = val$conn;
    }
    
    public int type() {
        return 32768;
    }
    
    public int nlink() {
        return 1;
    }
    
    public int mode() {
        return 292;
    }
    
    public int size() {
        return this.val$conn.getContentLength();
    }
    
    public int mtime() {
        return (int)(this.val$conn.getDate() / 1000L);
    }
    
    public int inode() {
        return this.this$0.inodes.get(this.val$conn.getURL().toString());
    }
    
    public int dev() {
        return this.this$0.devno;
    }
}
