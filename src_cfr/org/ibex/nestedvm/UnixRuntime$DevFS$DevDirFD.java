/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DirFD;

abstract class UnixRuntime$DevFS$DevDirFD
extends UnixRuntime$DirFD {
    private final UnixRuntime$DevFS this$0;

    private UnixRuntime$DevFS$DevDirFD(UnixRuntime$DevFS unixRuntime$DevFS) {
        this.this$0 = unixRuntime$DevFS;
    }

    @Override
    public int myDev() {
        return this.this$0.devno;
    }

    UnixRuntime$DevFS$DevDirFD(UnixRuntime$DevFS unixRuntime$DevFS, UnixRuntime$1 unixRuntime$1) {
        this(unixRuntime$DevFS);
    }
}

