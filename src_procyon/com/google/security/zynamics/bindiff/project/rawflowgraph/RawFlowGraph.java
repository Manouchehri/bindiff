package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;

public final class RawFlowGraph extends MutableDirectedGraph
{
    private final IAddress address;
    private final String name;
    private final EFunctionType functionType;
    private final ESide side;
    private final Map addrToBasicblockMap;
    private final Map addrPairToJumpMap;
    
    public RawFlowGraph(final IAddress address, final String s, final EFunctionType eFunctionType, final List list, final List list2, final ESide eSide) {
        super(list, list2);
        this.addrToBasicblockMap = new HashMap();
        this.addrPairToJumpMap = new HashMap();
        this.address = (IAddress)Preconditions.checkNotNull(address);
        this.name = (String)Preconditions.checkNotNull(s);
        this.functionType = (EFunctionType)Preconditions.checkNotNull(eFunctionType);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
        for (final RawBasicBlock rawBasicBlock : list) {
            this.addrToBasicblockMap.put(rawBasicBlock.getAddress(), rawBasicBlock);
        }
        for (final RawJump rawJump : list2) {
            this.addrPairToJumpMap.put(new AddressPair(rawJump.getSource().getAddress().toLong(), rawJump.getTarget().getAddress().toLong()), rawJump);
        }
    }
    
    private void removeFromMap(final SingleViewEdge singleViewEdge) {
        this.addrPairToJumpMap.remove(new AddressPair(((SingleViewNode)singleViewEdge.getSource()).getAddress().toLong(), ((SingleViewNode)singleViewEdge.getTarget()).getAddress().toLong()));
    }
    
    public void addEdge(final RawJump rawJump) {
        this.addrPairToJumpMap.put(new AddressPair(rawJump.getSource().getAddress().toLong(), rawJump.getTarget().getAddress().toLong()), rawJump);
        super.addEdge(rawJump);
    }
    
    public void addNode(final RawBasicBlock rawBasicBlock) {
        this.addrToBasicblockMap.put(rawBasicBlock.getAddress(), rawBasicBlock);
        super.addNode(rawBasicBlock);
    }
    
    public IAddress getAddress() {
        return this.address;
    }
    
    public RawBasicBlock getBasicblock(final IAddress address) {
        return this.addrToBasicblockMap.get(address);
    }
    
    public EFunctionType getFunctionType() {
        return this.functionType;
    }
    
    public RawJump getJump(final IAddress address, final IAddress address2) {
        if (address == null || address2 == null) {
            return null;
        }
        return this.addrPairToJumpMap.get(new AddressPair(address.toLong(), address2.toLong()));
    }
    
    public String getName() {
        return this.name;
    }
    
    public ESide getSide() {
        return this.side;
    }
    
    public void removeNode(final RawBasicBlock rawBasicBlock) {
        this.addrToBasicblockMap.remove(rawBasicBlock.getAddress());
        for (final SingleViewEdge singleViewEdge : rawBasicBlock.getIncomingEdges()) {
            SingleViewNode.unlink((SingleViewNode)singleViewEdge.getSource(), (SingleViewNode)singleViewEdge.getTarget());
            ((SingleViewNode)singleViewEdge.getSource()).removeOutgoingEdge(singleViewEdge);
            ((SingleViewNode)singleViewEdge.getTarget()).removeIncomingEdge(singleViewEdge);
            this.removeFromMap(singleViewEdge);
        }
        for (final SingleViewEdge singleViewEdge2 : rawBasicBlock.getOutgoingEdges()) {
            SingleViewNode.unlink((SingleViewNode)singleViewEdge2.getSource(), (SingleViewNode)singleViewEdge2.getTarget());
            ((SingleViewNode)singleViewEdge2.getSource()).removeOutgoingEdge(singleViewEdge2);
            ((SingleViewNode)singleViewEdge2.getTarget()).removeIncomingEdge(singleViewEdge2);
            this.removeFromMap(singleViewEdge2);
        }
        super.removeNode(rawBasicBlock);
    }
}
