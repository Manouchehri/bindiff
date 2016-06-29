/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$FS;
import org.ibex.nestedvm.util.Sort$Comparable;

class UnixRuntime$GlobalState$MP
implements Sort$Comparable {
    public String path;
    public UnixRuntime$FS fs;

    public UnixRuntime$GlobalState$MP(String string, UnixRuntime$FS unixRuntime$FS) {
        this.path = string;
        this.fs = unixRuntime$FS;
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof UnixRuntime$GlobalState$MP) return - this.path.compareTo(((UnixRuntime$GlobalState$MP)object).path);
        return 1;
    }
}

