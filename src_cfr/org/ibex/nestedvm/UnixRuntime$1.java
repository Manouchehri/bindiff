/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime$HostFStat;
import org.ibex.nestedvm.UnixRuntime;

class UnixRuntime$1
extends Runtime$HostFStat {
    private final int val$inode;
    private final int val$devno;
    private final UnixRuntime this$0;

    UnixRuntime$1(UnixRuntime unixRuntime, File file, boolean bl2, int n2, int n3) {
        super(file, bl2);
        this.this$0 = unixRuntime;
        this.val$inode = n2;
        this.val$devno = n3;
    }

    @Override
    public int inode() {
        return this.val$inode;
    }

    @Override
    public int dev() {
        return this.val$devno;
    }
}

