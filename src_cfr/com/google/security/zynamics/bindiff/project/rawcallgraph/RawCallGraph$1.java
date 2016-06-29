/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Function;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

class RawCallGraph$1
implements Function {
    final /* synthetic */ RawCallGraph this$0;

    RawCallGraph$1(RawCallGraph rawCallGraph) {
        this.this$0 = rawCallGraph;
    }

    public IAddress apply(RawFunction rawFunction) {
        return rawFunction.getAddress();
    }
}

