/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$2;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevFStat;

class UnixRuntime$DevFS$2$1
extends UnixRuntime$DevFS$DevFStat {
    private final UnixRuntime$DevFS$2 this$1;

    UnixRuntime$DevFS$2$1(UnixRuntime$DevFS$2 unixRuntime$DevFS$2) {
        super(UnixRuntime$DevFS$2.access$800(unixRuntime$DevFS$2), null);
        this.this$1 = unixRuntime$DevFS$2;
    }

    @Override
    public int inode() {
        return 2;
    }
}

