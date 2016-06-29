/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawCombinedBasicBlock
extends CombinedViewNode {
    private final BasicBlockMatchData basicblockMatch;
    private final RawBasicBlock primaryBasicblock;
    private final RawBasicBlock secondaryBasicblock;
    private final IAddress primaryFunctionAddr;
    private final IAddress secondaryFunctionAddr;

    public RawCombinedBasicBlock(RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2, BasicBlockMatchData basicBlockMatchData, IAddress iAddress, IAddress iAddress2) {
        if (rawBasicBlock == null && rawBasicBlock2 == null) {
            throw new IllegalArgumentException("Primary basic block and seconday basic block cannot both be null.");
        }
        if (iAddress == null && iAddress2 == null) {
            throw new IllegalArgumentException("Primary and secondary function address cannot both be null.");
        }
        this.primaryBasicblock = rawBasicBlock;
        this.secondaryBasicblock = rawBasicBlock2;
        this.basicblockMatch = basicBlockMatchData;
        this.primaryFunctionAddr = iAddress;
        this.secondaryFunctionAddr = iAddress2;
    }

    @Override
    public IAddress getAddress(ESide eSide) {
        if (this.getRawNode(eSide) != null) return this.getRawNode(eSide).getAddress();
        return null;
    }

    public BasicBlockMatchData getBasicblockMatch() {
        return this.basicblockMatch;
    }

    public IAddress getPrimaryFunctionAddress() {
        return this.primaryFunctionAddr;
    }

    @Override
    public RawBasicBlock getRawNode(ESide eSide) {
        if (eSide != ESide.PRIMARY) return this.secondaryBasicblock;
        return this.primaryBasicblock;
    }

    public IAddress getSecondaryFunctionAddress() {
        return this.secondaryFunctionAddr;
    }
}

