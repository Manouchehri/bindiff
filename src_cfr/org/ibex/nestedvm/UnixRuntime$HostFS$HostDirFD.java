/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.UnixRuntime$DirFD;
import org.ibex.nestedvm.UnixRuntime$HostFS;
import org.ibex.nestedvm.util.InodeCache;

public class UnixRuntime$HostFS$HostDirFD
extends UnixRuntime$DirFD {
    private final File f;
    private final File[] children;
    private final UnixRuntime$HostFS this$0;

    public UnixRuntime$HostFS$HostDirFD(UnixRuntime$HostFS unixRuntime$HostFS, File file) {
        this.this$0 = unixRuntime$HostFS;
        this.f = file;
        String[] arrstring = file.list();
        this.children = new File[arrstring.length];
        int n2 = 0;
        while (n2 < arrstring.length) {
            this.children[n2] = new File(file, arrstring[n2]);
            ++n2;
        }
    }

    @Override
    public int size() {
        return this.children.length;
    }

    @Override
    public String name(int n2) {
        return this.children[n2].getName();
    }

    @Override
    public int inode(int n2) {
        return this.this$0.inodes.get(this.children[n2].getAbsolutePath());
    }

    @Override
    public int parentInode() {
        int n2;
        File file = UnixRuntime$HostFS.access$400(this.f);
        if (file == null) {
            n2 = this.myInode();
            return n2;
        }
        n2 = this.this$0.inodes.get(file.getAbsolutePath());
        return n2;
    }

    @Override
    public int myInode() {
        return this.this$0.inodes.get(this.f.getAbsolutePath());
    }

    @Override
    public int myDev() {
        return this.this$0.devno;
    }
}

