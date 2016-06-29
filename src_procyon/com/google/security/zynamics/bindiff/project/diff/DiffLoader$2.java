package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;

class DiffLoader$2 implements Function
{
    final /* synthetic */ DiffLoader this$0;
    
    DiffLoader$2(final DiffLoader this$0) {
        this.this$0 = this$0;
    }
    
    public AddressTriple apply(final RawCall rawCall) {
        return new AddressTriple(((RawFunction)rawCall.getSource()).getAddress().toLong(), ((RawFunction)rawCall.getTarget()).getAddress().toLong(), rawCall.getSourceInstructionAddr().toLong());
    }
}
