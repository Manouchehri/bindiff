/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$DirFD;

class UnixRuntime$DirFD$1
extends Runtime$FStat {
    private final UnixRuntime$DirFD this$0;

    UnixRuntime$DirFD$1(UnixRuntime$DirFD unixRuntime$DirFD) {
        this.this$0 = unixRuntime$DirFD;
    }

    @Override
    public int type() {
        return 16384;
    }

    @Override
    public int inode() {
        return this.this$0.myInode();
    }

    @Override
    public int dev() {
        return this.this$0.myDev();
    }
}

