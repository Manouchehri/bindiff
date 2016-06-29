/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.net.URLConnection;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SeekableFD;
import org.ibex.nestedvm.UnixRuntime$ResourceFS;
import org.ibex.nestedvm.util.Seekable;

class UnixRuntime$ResourceFS$2
extends Runtime$SeekableFD {
    private final URLConnection val$conn;
    private final UnixRuntime$ResourceFS this$0;

    UnixRuntime$ResourceFS$2(UnixRuntime$ResourceFS unixRuntime$ResourceFS, Seekable seekable, int n2, URLConnection uRLConnection) {
        super(seekable, n2);
        this.this$0 = unixRuntime$ResourceFS;
        this.val$conn = uRLConnection;
    }

    @Override
    protected Runtime$FStat _fstat() {
        return this.this$0.connFStat(this.val$conn);
    }
}

