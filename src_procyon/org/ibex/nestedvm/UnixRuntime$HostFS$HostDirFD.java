package org.ibex.nestedvm;

import java.io.*;

public class UnixRuntime$HostFS$HostDirFD extends UnixRuntime$DirFD
{
    private final File f;
    private final File[] children;
    private final UnixRuntime$HostFS this$0;
    
    public UnixRuntime$HostFS$HostDirFD(final UnixRuntime$HostFS this$0, final File f) {
        this.this$0 = this$0;
        this.f = f;
        final String[] list = f.list();
        this.children = new File[list.length];
        for (int i = 0; i < list.length; ++i) {
            this.children[i] = new File(f, list[i]);
        }
    }
    
    public int size() {
        return this.children.length;
    }
    
    public String name(final int n) {
        return this.children[n].getName();
    }
    
    public int inode(final int n) {
        return this.this$0.inodes.get(this.children[n].getAbsolutePath());
    }
    
    public int parentInode() {
        final File access$400 = UnixRuntime$HostFS.access$400(this.f);
        return (access$400 == null) ? this.myInode() : this.this$0.inodes.get(access$400.getAbsolutePath());
    }
    
    public int myInode() {
        return this.this$0.inodes.get(this.f.getAbsolutePath());
    }
    
    public int myDev() {
        return this.this$0.devno;
    }
}
