package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.types.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;

public class FunctionMatchData implements IAddressPair
{
    private final int id;
    private final IAddressPair addrPair;
    private final double similarity;
    private final double confidence;
    private final int flags;
    private final int algoId;
    private Matches basicblockMatches;
    private int matchedBasicblocks;
    private int matchedJumps;
    private int matchedInstructions;
    
    public FunctionMatchData(final int id, final long n, final long n2, final double similarity, final double confidence, final int flags, final int algoId, final int matchedBasicblocks, final int matchedJumps, final int matchedInstructions) {
        this.basicblockMatches = null;
        this.id = id;
        this.addrPair = new AddressPair(n, n2);
        this.similarity = similarity;
        this.confidence = confidence;
        this.flags = flags;
        this.algoId = algoId;
        this.matchedBasicblocks = matchedBasicblocks;
        this.matchedJumps = matchedJumps;
        this.matchedInstructions = matchedInstructions;
    }
    
    protected int getId() {
        return this.id;
    }
    
    public void addBasicblockMatch(final Diff diff, final BasicBlockMatchData basicBlockMatchData, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        this.basicblockMatches.put(basicBlockMatchData);
        final HashSet<CombinedViewEdge> set = new HashSet<CombinedViewEdge>();
        set.addAll((Collection<?>)rawCombinedBasicBlock.getIncomingEdges());
        set.addAll((Collection<?>)rawCombinedBasicBlock.getOutgoingEdges());
        int n = 0;
        final Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getMatchState() == EMatchState.MATCHED) {
                ++n;
            }
        }
        final int length = basicBlockMatchData.getInstructionMatches().length;
        this.matchedInstructions += length;
        this.matchedJumps += n;
        ++this.matchedBasicblocks;
        final MatchData matches = diff.getMatches();
        matches.setSizeOfMatchedBasicblocks(matches.getSizeOfMatchedBasicblocks() + 1);
        matches.setSizeOfMatchedJumps(matches.getSizeOfMatchedJumps() + n);
        matches.setSizeOfMatchedInstructions(matches.getSizeOfMatchedInstructions() + length);
    }
    
    @Override
    public long getAddress(final ESide eSide) {
        return this.addrPair.getAddress(eSide);
    }
    
    public int getAlgorithmId() {
        return this.algoId;
    }
    
    public String getAlgorithmName() {
        return "TODO";
    }
    
    public BasicBlockMatchData getBasicblockMatch(final IAddress address, final ESide eSide) {
        return (this.basicblockMatches != null) ? ((BasicBlockMatchData)this.basicblockMatches.get(address, eSide)) : null;
    }
    
    public Collection getBasicblockMatches() {
        return (this.basicblockMatches != null) ? this.basicblockMatches.getMatches() : null;
    }
    
    public double getConfidence() {
        return this.confidence;
    }
    
    public int getFlags() {
        return this.flags;
    }
    
    @Override
    public IAddress getIAddress(final ESide eSide) {
        return new CAddress(this.addrPair.getAddress(eSide));
    }
    
    public Map getInstructionsAddressMap(final ESide eSide) {
        if (this.basicblockMatches != null) {
            final HashMap<IAddress, IAddress> hashMap = new HashMap<IAddress, IAddress>();
            final Iterator<BasicBlockMatchData> iterator = (Iterator<BasicBlockMatchData>)this.basicblockMatches.getMatches().iterator();
            while (iterator.hasNext()) {
                for (final InstructionMatchData instructionMatchData : iterator.next().getInstructionMatches()) {
                    hashMap.put(instructionMatchData.getIAddress(eSide), instructionMatchData.getIAddress((eSide == ESide.PRIMARY) ? ESide.SECONDARY : ESide.PRIMARY));
                }
            }
            return hashMap;
        }
        return null;
    }
    
    public IAddress getPrimaryBasicblockAddr(final IAddress address) {
        if (this.basicblockMatches != null) {
            final BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.get(address, ESide.SECONDARY);
            return (basicBlockMatchData != null) ? basicBlockMatchData.getIAddress(ESide.PRIMARY) : null;
        }
        return null;
    }
    
    public IAddress getSecondaryBasicblockAddr(final IAddress address) {
        if (this.basicblockMatches != null) {
            final BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.get(address, ESide.PRIMARY);
            return (basicBlockMatchData != null) ? basicBlockMatchData.getIAddress(ESide.SECONDARY) : null;
        }
        return null;
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
    
    public boolean isBasicblockMatch(final IAddress address, final IAddress address2) {
        final IAddress secondaryBasicblockAddr = this.getSecondaryBasicblockAddr(address);
        return secondaryBasicblockAddr != null && secondaryBasicblockAddr.equals(address2);
    }
    
    public boolean isLoaded() {
        return this.basicblockMatches != null;
    }
    
    public void loadBasicblockMatches(final List list) {
        this.basicblockMatches = new Matches(list);
    }
    
    public void removeBasicblockMatch(final Diff diff, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        final BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)this.basicblockMatches.remove(rawCombinedBasicBlock.getAddress(ESide.PRIMARY), rawCombinedBasicBlock.getAddress(ESide.SECONDARY));
        if (basicBlockMatchData != null) {
            final int sizeOfMatchedInstructions = basicBlockMatchData.getSizeOfMatchedInstructions();
            final HashSet<CombinedViewEdge> set = new HashSet<CombinedViewEdge>();
            set.addAll((Collection<?>)rawCombinedBasicBlock.getOutgoingEdges());
            set.addAll((Collection<?>)rawCombinedBasicBlock.getIncomingEdges());
            int n = 0;
            final Iterator<Object> iterator = set.iterator();
            while (iterator.hasNext()) {
                if (((RawCombinedJump)iterator.next()).getMatchState() == EMatchState.MATCHED) {
                    ++n;
                }
            }
            this.matchedInstructions -= sizeOfMatchedInstructions;
            this.matchedJumps -= n;
            --this.matchedBasicblocks;
            final MatchData matches = diff.getMatches();
            matches.setSizeOfMatchedBasicblocks(matches.getSizeOfMatchedBasicblocks() - 1);
            matches.setSizeOfMatchedJumps(matches.getSizeOfMatchedJumps() - n);
            matches.setSizeOfMatchedInstructions(matches.getSizeOfMatchedInstructions() - sizeOfMatchedInstructions);
        }
    }
    
    public void setSizeOfMatchedBasicblocks(final int matchedBasicblocks) {
        this.matchedBasicblocks = matchedBasicblocks;
    }
    
    public void setSizeOfMatchedInstructions(final int matchedInstructions) {
        this.matchedInstructions = matchedInstructions;
    }
    
    public void setSizeOfMatchedJumps(final int matchedJumps) {
        this.matchedJumps = matchedJumps;
    }
}
