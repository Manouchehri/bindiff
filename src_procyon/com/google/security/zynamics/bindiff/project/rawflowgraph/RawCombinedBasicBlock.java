package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class RawCombinedBasicBlock extends CombinedViewNode
{
    private final BasicBlockMatchData basicblockMatch;
    private final RawBasicBlock primaryBasicblock;
    private final RawBasicBlock secondaryBasicblock;
    private final IAddress primaryFunctionAddr;
    private final IAddress secondaryFunctionAddr;
    
    public RawCombinedBasicBlock(final RawBasicBlock primaryBasicblock, final RawBasicBlock secondaryBasicblock, final BasicBlockMatchData basicblockMatch, final IAddress primaryFunctionAddr, final IAddress secondaryFunctionAddr) {
        if (primaryBasicblock == null && secondaryBasicblock == null) {
            throw new IllegalArgumentException("Primary basic block and seconday basic block cannot both be null.");
        }
        if (primaryFunctionAddr == null && secondaryFunctionAddr == null) {
            throw new IllegalArgumentException("Primary and secondary function address cannot both be null.");
        }
        this.primaryBasicblock = primaryBasicblock;
        this.secondaryBasicblock = secondaryBasicblock;
        this.basicblockMatch = basicblockMatch;
        this.primaryFunctionAddr = primaryFunctionAddr;
        this.secondaryFunctionAddr = secondaryFunctionAddr;
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
        if (this.getRawNode(eSide) == null) {
            return null;
        }
        return this.getRawNode(eSide).getAddress();
    }
    
    public BasicBlockMatchData getBasicblockMatch() {
        return this.basicblockMatch;
    }
    
    public IAddress getPrimaryFunctionAddress() {
        return this.primaryFunctionAddr;
    }
    
    @Override
    public RawBasicBlock getRawNode(final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            return this.primaryBasicblock;
        }
        return this.secondaryBasicblock;
    }
    
    public IAddress getSecondaryFunctionAddress() {
        return this.secondaryFunctionAddr;
    }
}
