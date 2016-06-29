package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.disassembly.*;

class RawCallGraph$1 implements Function
{
    final /* synthetic */ RawCallGraph this$0;
    
    RawCallGraph$1(final RawCallGraph this$0) {
        this.this$0 = this$0;
    }
    
    public IAddress apply(final RawFunction rawFunction) {
        return rawFunction.getAddress();
    }
}
