/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;

abstract class UnixRuntime$DevFS$DevFStat
extends Runtime$FStat {
    private final UnixRuntime$DevFS this$0;

    private UnixRuntime$DevFS$DevFStat(UnixRuntime$DevFS unixRuntime$DevFS) {
        this.this$0 = unixRuntime$DevFS;
    }

    @Override
    public int dev() {
        return this.this$0.devno;
    }

    @Override
    public int mode() {
        return 438;
    }

    @Override
    public int type() {
        return 8192;
    }

    @Override
    public int nlink() {
        return 1;
    }

    @Override
    public abstract int inode();

    UnixRuntime$DevFS$DevFStat(UnixRuntime$DevFS unixRuntime$DevFS, UnixRuntime$1 unixRuntime$1) {
        this(unixRuntime$DevFS);
    }
}

