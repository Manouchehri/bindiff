/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Function;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.AddressTriple;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

class DiffLoader$2
implements Function {
    final /* synthetic */ DiffLoader this$0;

    DiffLoader$2(DiffLoader diffLoader) {
        this.this$0 = diffLoader;
    }

    public AddressTriple apply(RawCall rawCall) {
        return new AddressTriple(((RawFunction)rawCall.getSource()).getAddress().toLong(), ((RawFunction)rawCall.getTarget()).getAddress().toLong(), rawCall.getSourceInstructionAddr().toLong());
    }
}

