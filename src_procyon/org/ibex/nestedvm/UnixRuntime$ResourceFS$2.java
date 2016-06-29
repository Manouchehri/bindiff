package org.ibex.nestedvm;

import java.net.*;
import org.ibex.nestedvm.util.*;

class UnixRuntime$ResourceFS$2 extends Runtime$SeekableFD
{
    private final URLConnection val$conn;
    private final UnixRuntime$ResourceFS this$0;
    
    UnixRuntime$ResourceFS$2(final UnixRuntime$ResourceFS this$0, final Seekable seekable, final int n, final URLConnection val$conn) {
        super(seekable, n);
        this.this$0 = this$0;
        this.val$conn = val$conn;
    }
    
    protected Runtime$FStat _fstat() {
        return this.this$0.connFStat(this.val$conn);
    }
}
