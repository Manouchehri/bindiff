/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$1;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevFStat;

class UnixRuntime$DevFS$1$1
extends UnixRuntime$DevFS$DevFStat {
    private final UnixRuntime$DevFS$1 this$1;

    UnixRuntime$DevFS$1$1(UnixRuntime$DevFS$1 unixRuntime$DevFS$1) {
        super(UnixRuntime$DevFS$1.access$700(unixRuntime$DevFS$1), null);
        this.this$1 = unixRuntime$DevFS$1;
    }

    @Override
    public int inode() {
        return 3;
    }
}

