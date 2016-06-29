/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.builders;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RawCombinedFlowGraphBuilder {
    private static RawCombinedFlowGraph buildMatchedCombinedFlowgraph(FunctionMatchData functionMatchData, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2) {
        Object object;
        Object object2;
        Object object3;
        Pair pair;
        Object object42;
        Object object5;
        Object object6;
        Object object7222;
        Object object8;
        IAddress iAddress;
        IAddress iAddress2 = rawFlowGraph.getAddress();
        IAddress iAddress3 = rawFlowGraph2.getAddress();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<RawCombinedJump> arrayList2 = new ArrayList<RawCombinedJump>();
        HashMap<Pair, Object> hashMap = new HashMap<Pair, Object>();
        for (Object object7222 : rawFlowGraph) {
            object42 = object7222.getAddress();
            iAddress = functionMatchData.getSecondaryBasicblockAddr((IAddress)object42);
            object = null;
            if (iAddress != null) {
                object = rawFlowGraph2.getBasicblock(iAddress);
            }
            object3 = functionMatchData.getBasicblockMatch((IAddress)object42, ESide.PRIMARY);
            object5 = new RawCombinedBasicBlock((RawBasicBlock)object7222, (RawBasicBlock)object, (BasicBlockMatchData)object3, iAddress2, iAddress3);
            hashMap.put(new Pair(object42, iAddress), (RawCombinedBasicBlock)object5);
            arrayList.add(object5);
        }
        for (Object object7222 : rawFlowGraph2) {
            object42 = object7222.getAddress();
            iAddress = functionMatchData.getPrimaryBasicblockAddr((IAddress)object42);
            if (iAddress != null) continue;
            object = new RawCombinedBasicBlock(null, (RawBasicBlock)object7222, null, iAddress2, iAddress3);
            hashMap.put(new Pair(null, object42), object);
            arrayList.add(object);
        }
        for (Object object7222 : rawFlowGraph.getEdges()) {
            object42 = object7222.getSource().getAddress();
            iAddress = object7222.getTarget().getAddress();
            object = functionMatchData.getSecondaryBasicblockAddr((IAddress)object42);
            object3 = functionMatchData.getSecondaryBasicblockAddr(iAddress);
            object5 = new Pair(object42, object);
            pair = new Pair(iAddress, object3);
            object2 = rawFlowGraph2.getJump((IAddress)object, (IAddress)object3);
            RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)hashMap.get(object5);
            object6 = (RawCombinedBasicBlock)hashMap.get(pair);
            object8 = new RawCombinedJump(rawCombinedBasicBlock, (RawCombinedBasicBlock)object6, (RawJump)object7222, (RawJump)object2);
            arrayList2.add((RawCombinedJump)object8);
        }
        HashSet hashSet = new HashSet();
        for (Object object42 : rawFlowGraph.getEdges()) {
            hashSet.add(object42);
        }
        object7222 = rawFlowGraph2.getEdges().iterator();
        while (object7222.hasNext()) {
            object42 = (RawJump)object7222.next();
            iAddress = object42.getSource().getAddress();
            object = object42.getTarget().getAddress();
            object3 = functionMatchData.getPrimaryBasicblockAddr(iAddress);
            object5 = functionMatchData.getPrimaryBasicblockAddr((IAddress)object);
            pair = new Pair(object3, iAddress);
            object2 = new Pair(object5, object);
            boolean bl2 = false;
            if (rawFlowGraph == null) {
                bl2 = true;
            } else {
                object6 = rawFlowGraph.getJump((IAddress)object3, (IAddress)object5);
                if (!hashSet.contains(object6)) {
                    bl2 = true;
                }
            }
            if (!bl2) continue;
            object6 = (RawCombinedBasicBlock)hashMap.get(pair);
            object8 = (RawCombinedBasicBlock)hashMap.get(object2);
            RawCombinedJump rawCombinedJump = new RawCombinedJump((RawCombinedBasicBlock)object6, (RawCombinedBasicBlock)object8, null, (RawJump)object42);
            arrayList2.add(rawCombinedJump);
        }
        return new RawCombinedFlowGraph(arrayList, arrayList2, rawFlowGraph, rawFlowGraph2);
    }

    private static RawCombinedFlowGraph buildPrimaryUnmatchedCombinedFlowgraph(RawFlowGraph rawFlowGraph) {
        RawCombinedBasicBlock rawCombinedBasicBlock;
        IAddress iAddress = rawFlowGraph.getAddress();
        ArrayList<RawCombinedBasicBlock> arrayList = new ArrayList<RawCombinedBasicBlock>();
        ArrayList<RawCombinedJump> arrayList2 = new ArrayList<RawCombinedJump>();
        HashMap<IAddress, RawCombinedBasicBlock> hashMap = new HashMap<IAddress, RawCombinedBasicBlock>();
        for (Object object2 : rawFlowGraph) {
            rawCombinedBasicBlock = new RawCombinedBasicBlock((RawBasicBlock)object2, null, null, iAddress, null);
            hashMap.put(object2.getAddress(), rawCombinedBasicBlock);
            arrayList.add(rawCombinedBasicBlock);
        }
        Iterator iterator = rawFlowGraph.getEdges().iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (RawJump)iterator.next();
            rawCombinedBasicBlock = (RawCombinedBasicBlock)hashMap.get(object2.getSource().getAddress());
            RawCombinedBasicBlock rawCombinedBasicBlock2 = (RawCombinedBasicBlock)hashMap.get(object2.getTarget().getAddress());
            RawCombinedJump rawCombinedJump = new RawCombinedJump(rawCombinedBasicBlock, rawCombinedBasicBlock2, (RawJump)object2, null);
            arrayList2.add(rawCombinedJump);
        }
        return new RawCombinedFlowGraph(arrayList, arrayList2, rawFlowGraph, null);
    }

    private static RawCombinedFlowGraph buildSecondaryUnmatchedCombinedFlowgraph(RawFlowGraph rawFlowGraph) {
        RawCombinedBasicBlock rawCombinedBasicBlock;
        IAddress iAddress = rawFlowGraph.getAddress();
        ArrayList<RawCombinedBasicBlock> arrayList = new ArrayList<RawCombinedBasicBlock>();
        ArrayList<RawCombinedJump> arrayList2 = new ArrayList<RawCombinedJump>();
        HashMap<IAddress, RawCombinedBasicBlock> hashMap = new HashMap<IAddress, RawCombinedBasicBlock>();
        for (Object object2 : rawFlowGraph) {
            rawCombinedBasicBlock = new RawCombinedBasicBlock(null, (RawBasicBlock)object2, null, null, iAddress);
            hashMap.put(object2.getAddress(), rawCombinedBasicBlock);
            arrayList.add(rawCombinedBasicBlock);
        }
        Iterator iterator = rawFlowGraph.getEdges().iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (RawJump)iterator.next();
            rawCombinedBasicBlock = (RawCombinedBasicBlock)hashMap.get(object2.getSource().getAddress());
            RawCombinedBasicBlock rawCombinedBasicBlock2 = (RawCombinedBasicBlock)hashMap.get(object2.getTarget().getAddress());
            RawCombinedJump rawCombinedJump = new RawCombinedJump(rawCombinedBasicBlock, rawCombinedBasicBlock2, null, (RawJump)object2);
            arrayList2.add(rawCombinedJump);
        }
        return new RawCombinedFlowGraph(arrayList, arrayList2, null, rawFlowGraph);
    }

    public static RawCombinedFlowGraph buildRawCombinedFlowgraph(FunctionMatchData functionMatchData, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2) {
        Logger.logInfo(" - Building combined flow graphs", new Object[0]);
        try {
            if (rawFlowGraph != null && rawFlowGraph2 != null) {
                return RawCombinedFlowGraphBuilder.buildMatchedCombinedFlowgraph(functionMatchData, rawFlowGraph, rawFlowGraph2);
            }
            if (rawFlowGraph != null && rawFlowGraph2 == null) {
                return RawCombinedFlowGraphBuilder.buildPrimaryUnmatchedCombinedFlowgraph(rawFlowGraph);
            }
            if (rawFlowGraph != null) throw new GraphCreationException("Primary and secondary flowgraph cannot both be null. Combined flow graphs creation failed.");
            if (rawFlowGraph2 == null) throw new GraphCreationException("Primary and secondary flowgraph cannot both be null. Combined flow graphs creation failed.");
            return RawCombinedFlowGraphBuilder.buildSecondaryUnmatchedCombinedFlowgraph(rawFlowGraph2);
        }
        catch (GraphCreationException var3_3) {
            throw var3_3;
        }
        catch (Exception var3_4) {
            throw new GraphCreationException("Combined flow graphs creation failed.");
        }
    }
}

