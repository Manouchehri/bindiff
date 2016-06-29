/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RawFlowGraph
extends MutableDirectedGraph {
    private final IAddress address;
    private final String name;
    private final EFunctionType functionType;
    private final ESide side;
    private final Map addrToBasicblockMap = new HashMap();
    private final Map addrPairToJumpMap = new HashMap();

    public RawFlowGraph(IAddress iAddress, String string, EFunctionType eFunctionType, List list, List list2, ESide eSide) {
        super(list, list2);
        this.address = (IAddress)Preconditions.checkNotNull(iAddress);
        this.name = (String)Preconditions.checkNotNull(string);
        this.functionType = (EFunctionType)((Object)Preconditions.checkNotNull((Object)eFunctionType));
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
        for (Object object2 : list) {
            this.addrToBasicblockMap.put(object2.getAddress(), object2);
        }
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (RawJump)iterator.next();
            long l2 = object2.getSource().getAddress().toLong();
            long l3 = object2.getTarget().getAddress().toLong();
            this.addrPairToJumpMap.put(new AddressPair(l2, l3), object2);
        }
    }

    private void removeFromMap(SingleViewEdge singleViewEdge) {
        IAddress iAddress = ((SingleViewNode)singleViewEdge.getSource()).getAddress();
        IAddress iAddress2 = ((SingleViewNode)singleViewEdge.getTarget()).getAddress();
        AddressPair addressPair = new AddressPair(iAddress.toLong(), iAddress2.toLong());
        this.addrPairToJumpMap.remove(addressPair);
    }

    public void addEdge(RawJump rawJump) {
        AddressPair addressPair = new AddressPair(rawJump.getSource().getAddress().toLong(), rawJump.getTarget().getAddress().toLong());
        this.addrPairToJumpMap.put(addressPair, rawJump);
        super.addEdge(rawJump);
    }

    public void addNode(RawBasicBlock rawBasicBlock) {
        this.addrToBasicblockMap.put(rawBasicBlock.getAddress(), rawBasicBlock);
        super.addNode(rawBasicBlock);
    }

    public IAddress getAddress() {
        return this.address;
    }

    public RawBasicBlock getBasicblock(IAddress iAddress) {
        return (RawBasicBlock)this.addrToBasicblockMap.get(iAddress);
    }

    public EFunctionType getFunctionType() {
        return this.functionType;
    }

    public RawJump getJump(IAddress iAddress, IAddress iAddress2) {
        if (iAddress == null) return null;
        if (iAddress2 != null) return (RawJump)this.addrPairToJumpMap.get(new AddressPair(iAddress.toLong(), iAddress2.toLong()));
        return null;
    }

    public String getName() {
        return this.name;
    }

    public ESide getSide() {
        return this.side;
    }

    public void removeNode(RawBasicBlock rawBasicBlock) {
        this.addrToBasicblockMap.remove(rawBasicBlock.getAddress());
        for (SingleViewEdge singleViewEdge2 : rawBasicBlock.getIncomingEdges()) {
            SingleViewNode.unlink((SingleViewNode)singleViewEdge2.getSource(), (SingleViewNode)singleViewEdge2.getTarget());
            ((SingleViewNode)singleViewEdge2.getSource()).removeOutgoingEdge(singleViewEdge2);
            ((SingleViewNode)singleViewEdge2.getTarget()).removeIncomingEdge(singleViewEdge2);
            this.removeFromMap(singleViewEdge2);
        }
        Iterator iterator = rawBasicBlock.getOutgoingEdges().iterator();
        do {
            SingleViewEdge singleViewEdge2;
            if (!iterator.hasNext()) {
                super.removeNode(rawBasicBlock);
                return;
            }
            singleViewEdge2 = (SingleViewEdge)iterator.next();
            SingleViewNode.unlink((SingleViewNode)singleViewEdge2.getSource(), (SingleViewNode)singleViewEdge2.getTarget());
            ((SingleViewNode)singleViewEdge2.getSource()).removeOutgoingEdge(singleViewEdge2);
            ((SingleViewNode)singleViewEdge2.getTarget()).removeIncomingEdge(singleViewEdge2);
            this.removeFromMap(singleViewEdge2);
        } while (true);
    }
}

