/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SeekableFD;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

class Runtime$1
extends Runtime$SeekableFD {
    private final File val$f;
    private final Seekable$File val$sf;
    private final Object val$data;
    private final Runtime this$0;

    Runtime$1(Runtime runtime, Seekable seekable, int n2, File file, Seekable$File seekable$File, Object object) {
        super(seekable, n2);
        this.this$0 = runtime;
        this.val$f = file;
        this.val$sf = seekable$File;
        this.val$data = object;
    }

    @Override
    protected Runtime.FStat _fstat() {
        return this.this$0.hostFStat(this.val$f, this.val$sf, this.val$data);
    }
}

