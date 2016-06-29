/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder$1;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;

class BasicBlockMatchAdder$InternalStruct {
    SuperViewNode superTarget = null;
    RawBasicBlock priSource = null;
    RawBasicBlock priTarget = null;
    RawBasicBlock secTarget = null;
    RawBasicBlock secSource = null;
    RawCombinedBasicBlock combinedSource = null;
    RawCombinedBasicBlock combinedTarget = null;
    EJumpType priJumpType = null;
    EJumpType secJumpType = null;

    private BasicBlockMatchAdder$InternalStruct() {
    }

    /* synthetic */ BasicBlockMatchAdder$InternalStruct(BasicBlockMatchAdder$1 basicBlockMatchAdder$1) {
        this();
    }
}

