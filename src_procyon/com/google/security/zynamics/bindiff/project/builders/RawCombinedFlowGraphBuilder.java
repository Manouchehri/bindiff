package com.google.security.zynamics.bindiff.project.builders;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.exceptions.*;

public class RawCombinedFlowGraphBuilder
{
    private static RawCombinedFlowGraph buildMatchedCombinedFlowgraph(final FunctionMatchData functionMatchData, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2) {
        final IAddress address = rawFlowGraph.getAddress();
        final IAddress address2 = rawFlowGraph2.getAddress();
        final ArrayList<RawCombinedBasicBlock> list = new ArrayList<RawCombinedBasicBlock>();
        final ArrayList<RawCombinedJump> list2 = new ArrayList<RawCombinedJump>();
        final HashMap<Object, RawCombinedBasicBlock> hashMap = new HashMap<Object, RawCombinedBasicBlock>();
        for (final RawBasicBlock rawBasicBlock : rawFlowGraph) {
            final IAddress address3 = rawBasicBlock.getAddress();
            final IAddress secondaryBasicblockAddr = functionMatchData.getSecondaryBasicblockAddr(address3);
            RawBasicBlock basicblock = null;
            if (secondaryBasicblockAddr != null) {
                basicblock = rawFlowGraph2.getBasicblock(secondaryBasicblockAddr);
            }
            final RawCombinedBasicBlock rawCombinedBasicBlock = new RawCombinedBasicBlock(rawBasicBlock, basicblock, functionMatchData.getBasicblockMatch(address3, ESide.PRIMARY), address, address2);
            hashMap.put(new Pair(address3, secondaryBasicblockAddr), rawCombinedBasicBlock);
            list.add(rawCombinedBasicBlock);
        }
        for (final RawBasicBlock rawBasicBlock2 : rawFlowGraph2) {
            final IAddress address4 = rawBasicBlock2.getAddress();
            if (functionMatchData.getPrimaryBasicblockAddr(address4) == null) {
                final RawCombinedBasicBlock rawCombinedBasicBlock2 = new RawCombinedBasicBlock(null, rawBasicBlock2, null, address, address2);
                hashMap.put(new Pair(null, address4), rawCombinedBasicBlock2);
                list.add(rawCombinedBasicBlock2);
            }
        }
        for (final RawJump rawJump : rawFlowGraph.getEdges()) {
            final IAddress address5 = rawJump.getSource().getAddress();
            final IAddress address6 = rawJump.getTarget().getAddress();
            final IAddress secondaryBasicblockAddr2 = functionMatchData.getSecondaryBasicblockAddr(address5);
            final IAddress secondaryBasicblockAddr3 = functionMatchData.getSecondaryBasicblockAddr(address6);
            list2.add(new RawCombinedJump(hashMap.get(new Pair(address5, secondaryBasicblockAddr2)), hashMap.get(new Pair(address6, secondaryBasicblockAddr3)), rawJump, rawFlowGraph2.getJump(secondaryBasicblockAddr2, secondaryBasicblockAddr3)));
        }
        final HashSet<IGraphEdge> set = new HashSet<IGraphEdge>();
        final Iterator<IGraphEdge> iterator4 = rawFlowGraph.getEdges().iterator();
        while (iterator4.hasNext()) {
            set.add(iterator4.next());
        }
        for (final RawJump rawJump2 : rawFlowGraph2.getEdges()) {
            final IAddress address7 = rawJump2.getSource().getAddress();
            final IAddress address8 = rawJump2.getTarget().getAddress();
            final IAddress primaryBasicblockAddr = functionMatchData.getPrimaryBasicblockAddr(address7);
            final IAddress primaryBasicblockAddr2 = functionMatchData.getPrimaryBasicblockAddr(address8);
            final Pair pair = new Pair(primaryBasicblockAddr, address7);
            final Pair pair2 = new Pair(primaryBasicblockAddr2, address8);
            boolean b = false;
            if (rawFlowGraph == null) {
                b = true;
            }
            else if (!set.contains(rawFlowGraph.getJump(primaryBasicblockAddr, primaryBasicblockAddr2))) {
                b = true;
            }
            if (b) {
                list2.add(new RawCombinedJump(hashMap.get(pair), hashMap.get(pair2), null, rawJump2));
            }
        }
        return new RawCombinedFlowGraph(list, list2, rawFlowGraph, rawFlowGraph2);
    }
    
    private static RawCombinedFlowGraph buildPrimaryUnmatchedCombinedFlowgraph(final RawFlowGraph rawFlowGraph) {
        final IAddress address = rawFlowGraph.getAddress();
        final ArrayList<RawCombinedBasicBlock> list = new ArrayList<RawCombinedBasicBlock>();
        final ArrayList<RawCombinedJump> list2 = new ArrayList<RawCombinedJump>();
        final HashMap<Object, RawCombinedBasicBlock> hashMap = new HashMap<Object, RawCombinedBasicBlock>();
        for (final RawBasicBlock rawBasicBlock : rawFlowGraph) {
            final RawCombinedBasicBlock rawCombinedBasicBlock = new RawCombinedBasicBlock(rawBasicBlock, null, null, address, null);
            hashMap.put(rawBasicBlock.getAddress(), rawCombinedBasicBlock);
            list.add(rawCombinedBasicBlock);
        }
        for (final RawJump rawJump : rawFlowGraph.getEdges()) {
            list2.add(new RawCombinedJump(hashMap.get(rawJump.getSource().getAddress()), hashMap.get(rawJump.getTarget().getAddress()), rawJump, null));
        }
        return new RawCombinedFlowGraph(list, list2, rawFlowGraph, null);
    }
    
    private static RawCombinedFlowGraph buildSecondaryUnmatchedCombinedFlowgraph(final RawFlowGraph rawFlowGraph) {
        final IAddress address = rawFlowGraph.getAddress();
        final ArrayList<RawCombinedBasicBlock> list = new ArrayList<RawCombinedBasicBlock>();
        final ArrayList<RawCombinedJump> list2 = new ArrayList<RawCombinedJump>();
        final HashMap<Object, RawCombinedBasicBlock> hashMap = new HashMap<Object, RawCombinedBasicBlock>();
        for (final RawBasicBlock rawBasicBlock : rawFlowGraph) {
            final RawCombinedBasicBlock rawCombinedBasicBlock = new RawCombinedBasicBlock(null, rawBasicBlock, null, null, address);
            hashMap.put(rawBasicBlock.getAddress(), rawCombinedBasicBlock);
            list.add(rawCombinedBasicBlock);
        }
        for (final RawJump rawJump : rawFlowGraph.getEdges()) {
            list2.add(new RawCombinedJump(hashMap.get(rawJump.getSource().getAddress()), hashMap.get(rawJump.getTarget().getAddress()), null, rawJump));
        }
        return new RawCombinedFlowGraph(list, list2, null, rawFlowGraph);
    }
    
    public static RawCombinedFlowGraph buildRawCombinedFlowgraph(final FunctionMatchData functionMatchData, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2) {
        Logger.logInfo(" - Building combined flow graphs", new Object[0]);
        try {
            if (rawFlowGraph != null && rawFlowGraph2 != null) {
                return buildMatchedCombinedFlowgraph(functionMatchData, rawFlowGraph, rawFlowGraph2);
            }
            if (rawFlowGraph != null && rawFlowGraph2 == null) {
                return buildPrimaryUnmatchedCombinedFlowgraph(rawFlowGraph);
            }
            if (rawFlowGraph == null && rawFlowGraph2 != null) {
                return buildSecondaryUnmatchedCombinedFlowgraph(rawFlowGraph2);
            }
            throw new GraphCreationException("Primary and secondary flowgraph cannot both be null. Combined flow graphs creation failed.");
        }
        catch (GraphCreationException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            throw new GraphCreationException("Combined flow graphs creation failed.");
        }
    }
}
