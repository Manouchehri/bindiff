package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class RawJump extends SingleViewEdge
{
    final EJumpType jumpType;
    
    public RawJump(final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2, final EJumpType jumpType) {
        super(rawBasicBlock, rawBasicBlock2);
        this.jumpType = jumpType;
    }
    
    public EJumpType getJumpType() {
        return this.jumpType;
    }
    
    @Override
    public RawBasicBlock getSource() {
        return (RawBasicBlock)super.getSource();
    }
    
    public IAddress getSourceBasicblockAddress() {
        return this.getSource().getAddress();
    }
    
    @Override
    public RawBasicBlock getTarget() {
        return (RawBasicBlock)super.getTarget();
    }
    
    public IAddress getTargetBasicblockAddress() {
        return this.getTarget().getAddress();
    }
}
