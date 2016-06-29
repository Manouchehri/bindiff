/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$1$1;

class UnixRuntime$DevFS$1
extends Runtime$FD {
    private final UnixRuntime$DevFS this$0;

    UnixRuntime$DevFS$1(UnixRuntime$DevFS unixRuntime$DevFS) {
        this.this$0 = unixRuntime$DevFS;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        int n4 = n2;
        while (n4 < n2 + n3) {
            arrby[n4] = 0;
            ++n4;
        }
        return n3;
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        return n3;
    }

    @Override
    public int seek(int n2, int n3) {
        return 0;
    }

    @Override
    public Runtime$FStat _fstat() {
        return new UnixRuntime$DevFS$1$1(this);
    }

    @Override
    public int flags() {
        return 2;
    }

    static UnixRuntime$DevFS access$700(UnixRuntime$DevFS$1 unixRuntime$DevFS$1) {
        return unixRuntime$DevFS$1.this$0;
    }
}

