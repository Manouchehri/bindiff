/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawJump
extends SingleViewEdge {
    final EJumpType jumpType;

    public RawJump(RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2, EJumpType eJumpType) {
        super(rawBasicBlock, rawBasicBlock2);
        this.jumpType = eJumpType;
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

