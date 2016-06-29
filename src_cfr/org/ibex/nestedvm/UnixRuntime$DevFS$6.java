/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$DevFS;

class UnixRuntime$DevFS$6
extends Runtime$FStat {
    private final UnixRuntime$DevFS this$0;

    UnixRuntime$DevFS$6(UnixRuntime$DevFS unixRuntime$DevFS) {
        this.this$0 = unixRuntime$DevFS;
    }

    @Override
    public int inode() {
        return 1;
    }

    @Override
    public int dev() {
        return this.this$0.devno;
    }

    @Override
    public int type() {
        return 16384;
    }

    @Override
    public int mode() {
        return 292;
    }
}

