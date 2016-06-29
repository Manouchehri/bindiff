package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.enums.*;

class BasicBlockMatchAdder$InternalStruct
{
    SuperViewNode superTarget;
    RawBasicBlock priSource;
    RawBasicBlock priTarget;
    RawBasicBlock secTarget;
    RawBasicBlock secSource;
    RawCombinedBasicBlock combinedSource;
    RawCombinedBasicBlock combinedTarget;
    EJumpType priJumpType;
    EJumpType secJumpType;
    
    private BasicBlockMatchAdder$InternalStruct() {
        this.superTarget = null;
        this.priSource = null;
        this.priTarget = null;
        this.secTarget = null;
        this.secSource = null;
        this.combinedSource = null;
        this.combinedTarget = null;
        this.priJumpType = null;
        this.secJumpType = null;
    }
}
