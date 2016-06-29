/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FunctionMatchData
implements IAddressPair {
    private final int id;
    private final IAddressPair addrPair;
    private final double similarity;
    private final double confidence;
    private final int flags;
    private final int algoId;
    private Matches basicblockMatches = null;
    private int matchedBasicblocks;
    private int matchedJumps;
    private int matchedInstructions;

    public FunctionMatchData(int n2, long l2, long l3, double d2, double d3, int n3, int n4, int n5, int n6, int n7) {
        this.id = n2;
        this.addrPair = new AddressPair(l2, l3);
        this.similarity = d2;
        this.confidence = d3;
        this.flags = n3;
        this.algoId = n4;
        this.matchedBasicblocks = n5;
        this.matchedJumps = n6;
        this.matchedInstructions = n7;
    }

    protected int getId() {
        return this.id;
    }

    public void addBasicblockMatch(Diff diff, BasicBlockMatchData basicBlockMatchData, RawCombinedBasicBlock rawCombinedBasicBlock) {
        this.basicblockMatches.put(basicBlockMatchData);
        HashSet hashSet = new HashSet();
        hashSet.addAll(rawCombinedBasicBlock.getIncomingEdges());
        hashSet.addAll(rawCombinedBasicBlock.getOutgoingEdges());
        int n2 = 0;
        Iterator iterator = hashSet.iterator();
        do {
            Object object;
            if (!iterator.hasNext()) {
                int n3 = basicBlockMatchData.getInstructionMatches().length;
                this.matchedInstructions += n3;
                this.matchedJumps += n2;
                ++this.matchedBasicblocks;
                object = diff.getMatches();
                object.setSizeOfMatchedBasicblocks(object.getSizeOfMatchedBasicblocks() + 1);
                object.setSizeOfMatchedJumps(object.getSizeOfMatchedJumps() + n2);
                object.setSizeOfMatchedInstructions(object.getSizeOfMatchedInstructions() + n3);
                return;
            }
            object = (CombinedViewEdge)iterator.next();
            if (object.getMatchState() != EMatchState.MATCHED) continue;
            ++n2;
        } while (true);
    }

    @Override
    public long getAddress(ESide eSide) {
        return this.addrPair.getAddress(eSide);
    }

    public int getAlgorithmId() {
        return this.algoId;
    }

    public String getAlgorithmName() {
        return "TODO";
    }

    public BasicBlockMatchData getBasicblockMatch(IAddress iAddress, ESide eSide) {
        if (this.basicblockMatches == null) return null;
        BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.get(iAddress, eSide);
        return basicBlockMatchData;
    }

    public Collection getBasicblockMatches() {
        if (this.basicblockMatches == null) return null;
        Collection collection = this.basicblockMatches.getMatches();
        return collection;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public int getFlags() {
        return this.flags;
    }

    @Override
    public IAddress getIAddress(ESide eSide) {
        return new CAddress(this.addrPair.getAddress(eSide));
    }

    public Map getInstructionsAddressMap(ESide eSide) {
        if (this.basicblockMatches == null) return null;
        HashMap<IAddress, IAddress> hashMap = new HashMap<IAddress, IAddress>();
        Iterator iterator = this.basicblockMatches.getMatches().iterator();
        block0 : while (iterator.hasNext()) {
            InstructionMatchData[] arrinstructionMatchData;
            BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)iterator.next();
            InstructionMatchData[] arrinstructionMatchData2 = arrinstructionMatchData = basicBlockMatchData.getInstructionMatches();
            int n2 = arrinstructionMatchData2.length;
            int n3 = 0;
            do {
                if (n3 >= n2) continue block0;
                InstructionMatchData instructionMatchData = arrinstructionMatchData2[n3];
                ESide eSide2 = eSide == ESide.PRIMARY ? ESide.SECONDARY : ESide.PRIMARY;
                hashMap.put(instructionMatchData.getIAddress(eSide), instructionMatchData.getIAddress(eSide2));
                ++n3;
            } while (true);
            break;
        }
        return hashMap;
    }

    public IAddress getPrimaryBasicblockAddr(IAddress iAddress) {
        if (this.basicblockMatches == null) return null;
        BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.get(iAddress, ESide.SECONDARY);
        if (basicBlockMatchData == null) return null;
        IAddress iAddress2 = basicBlockMatchData.getIAddress(ESide.PRIMARY);
        return iAddress2;
    }

    public IAddress getSecondaryBasicblockAddr(IAddress iAddress) {
        if (this.basicblockMatches == null) return null;
        BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.get(iAddress, ESide.PRIMARY);
        if (basicBlockMatchData == null) return null;
        IAddress iAddress2 = basicBlockMatchData.getIAddress(ESide.SECONDARY);
        return iAddress2;
    }

    public double getSimilarity() {
        return this.similarity;
    }

    public int getSizeOfMatchedBasicblocks() {
        return this.matchedBasicblocks;
    }

    public int getSizeOfMatchedInstructions() {
        return this.matchedInstructions;
    }

    public int getSizeOfMatchedJumps() {
        return this.matchedJumps;
    }

    public boolean isBasicblockMatch(IAddress iAddress, IAddress iAddress2) {
        IAddress iAddress3 = this.getSecondaryBasicblockAddr(iAddress);
        if (iAddress3 == null) return false;
        if (!iAddress3.equals(iAddress2)) return false;
        return true;
    }

    public boolean isLoaded() {
        if (this.basicblockMatches == null) return false;
        return true;
    }

    public void loadBasicblockMatches(List list) {
        this.basicblockMatches = new Matches(list);
    }

    public void removeBasicblockMatch(Diff diff, RawCombinedBasicBlock rawCombinedBasicBlock) {
        IAddress iAddress;
        IAddress iAddress2 = rawCombinedBasicBlock.getAddress(ESide.PRIMARY);
        BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.remove(iAddress2, iAddress = rawCombinedBasicBlock.getAddress(ESide.SECONDARY));
        if (basicBlockMatchData == null) return;
        int n2 = basicBlockMatchData.getSizeOfMatchedInstructions();
        HashSet hashSet = new HashSet();
        hashSet.addAll(rawCombinedBasicBlock.getOutgoingEdges());
        hashSet.addAll(rawCombinedBasicBlock.getIncomingEdges());
        int n3 = 0;
        Object object = hashSet.iterator();
        do {
            if (!object.hasNext()) {
                this.matchedInstructions -= n2;
                this.matchedJumps -= n3;
                --this.matchedBasicblocks;
                object = diff.getMatches();
                object.setSizeOfMatchedBasicblocks(object.getSizeOfMatchedBasicblocks() - 1);
                object.setSizeOfMatchedJumps(object.getSizeOfMatchedJumps() - n3);
                object.setSizeOfMatchedInstructions(object.getSizeOfMatchedInstructions() - n2);
                return;
            }
            CombinedViewEdge combinedViewEdge = (CombinedViewEdge)object.next();
            if (((RawCombinedJump)combinedViewEdge).getMatchState() != EMatchState.MATCHED) continue;
            ++n3;
        } while (true);
    }

    public void setSizeOfMatchedBasicblocks(int n2) {
        this.matchedBasicblocks = n2;
    }

    public void setSizeOfMatchedInstructions(int n2) {
        this.matchedInstructions = n2;
    }

    public void setSizeOfMatchedJumps(int n2) {
        this.matchedJumps = n2;
    }
}

