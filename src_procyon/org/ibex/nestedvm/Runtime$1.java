package org.ibex.nestedvm;

import java.io.*;
import org.ibex.nestedvm.util.*;

class Runtime$1 extends Runtime$SeekableFD
{
    private final File val$f;
    private final Seekable$File val$sf;
    private final Object val$data;
    private final Runtime this$0;
    
    Runtime$1(final Runtime this$0, final Seekable seekable, final int n, final File val$f, final Seekable$File val$sf, final Object val$data) {
        super(seekable, n);
        this.this$0 = this$0;
        this.val$f = val$f;
        this.val$sf = val$sf;
        this.val$data = val$data;
    }
    
    protected Runtime$FStat _fstat() {
        return this.this$0.hostFStat(this.val$f, this.val$sf, this.val$data);
    }
}
