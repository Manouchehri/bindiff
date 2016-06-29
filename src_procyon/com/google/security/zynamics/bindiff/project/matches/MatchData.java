package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.types.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.*;

public class MatchData
{
    private final DiffMetaData metaData;
    private Matches functionMatches;
    private final ListenerProvider listener;
    
    public MatchData(final List list, final DiffMetaData diffMetaData) {
        this.listener = new ListenerProvider();
        this.metaData = (DiffMetaData)Preconditions.checkNotNull(diffMetaData);
        this.functionMatches = new Matches((List)Preconditions.checkNotNull(list));
    }
    
    public void addListener(final IMatchesChangeListener matchesChangeListener) {
        this.listener.addListener(matchesChangeListener);
    }
    
    public void close() {
        this.functionMatches.clear();
    }
    
    public FunctionMatchData getFunctionMatch(final IAddress address, final ESide eSide) {
        return (FunctionMatchData)this.functionMatches.get(address, eSide);
    }
    
    public FunctionMatchData[] getFunctionMatches() {
        return this.functionMatches.getMatches().toArray(new FunctionMatchData[0]);
    }
    
    public IAddress getPrimaryFunctionAddr(final IAddress address) {
        final FunctionMatchData functionMatchData = (FunctionMatchData)this.functionMatches.get(address, ESide.SECONDARY);
        return (functionMatchData != null) ? functionMatchData.getIAddress(ESide.PRIMARY) : null;
    }
    
    public IAddress getSecondaryFunctionAddr(final IAddress address) {
        final FunctionMatchData functionMatchData = (FunctionMatchData)this.functionMatches.get(address, ESide.PRIMARY);
        return (functionMatchData != null) ? functionMatchData.getIAddress(ESide.SECONDARY) : null;
    }
    
    public int getSizeOfBasicblocks(final ESide eSide) {
        return this.metaData.getSizeOfBasicblocks(eSide);
    }
    
    public int getSizeOfCalls(final ESide eSide) {
        return this.metaData.getSizeOfCalls(eSide);
    }
    
    public int getSizeOfChangedCalls() {
        return this.metaData.getSizeOfChangedCalls();
    }
    
    public int getSizeOfChangedFunctions() {
        return this.metaData.getSizeOfChangedFunctions();
    }
    
    public int getSizeOfFunctions(final ESide eSide) {
        return this.metaData.getSizeOfFunctions(eSide);
    }
    
    public int getSizeOfInstructions(final ESide eSide) {
        return this.metaData.getSizeOfInstructions(eSide);
    }
    
    public int getSizeOfJumps(final ESide eSide) {
        return this.metaData.getSizeOfJumps(eSide);
    }
    
    public int getSizeOfMatchedBasicblocks() {
        return this.metaData.getSizeOfMatchedBasicblocks();
    }
    
    public int getSizeOfMatchedCalls() {
        return this.metaData.getSizeOfMatchedCalls();
    }
    
    public int getSizeOfMatchedFunctions() {
        return this.metaData.getSizeOfMatchedFunctions();
    }
    
    public int getSizeOfMatchedInstructions() {
        return this.metaData.getSizeOfMatchedInstructions();
    }
    
    public int getSizeOfMatchedJumps() {
        return this.metaData.getSizeOfMatchedJumps();
    }
    
    public int getSizeOfUnmatchedBasicblocks(final ESide eSide) {
        return this.metaData.getSizeOfUnmatchedBasicblocks(eSide);
    }
    
    public int getSizeOfUnmatchedCalls(final ESide eSide) {
        return this.metaData.getSizeOfUnmatchedCalls(eSide);
    }
    
    public int getSizeOfUnmatchedFunctions(final ESide eSide) {
        return this.metaData.getSizeOfUnmatchedFunctions(eSide);
    }
    
    public int getSizeOfUnmatchedInstructions(final ESide eSide) {
        return this.metaData.getSizeOfUnmatchedInstructions(eSide);
    }
    
    public int getSizeOfUnmatchedJumps(final ESide eSide) {
        return this.metaData.getSizeOfUnmatchedJumps(eSide);
    }
    
    public boolean isFunctionMatch(final IAddress address, final IAddress address2) {
        final IAddress secondaryFunctionAddr = this.getSecondaryFunctionAddr(address);
        return secondaryFunctionAddr != null && secondaryFunctionAddr.equals(address2);
    }
    
    public void notifyBasicblockMatchAddedListener(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        final Iterator iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            iterator.next().addedBasicblockMatch(address, address2, address3, address4);
        }
    }
    
    public void notifyBasicblockMatchRemovedListener(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        final Iterator iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            iterator.next().removedBasicblockMatch(address, address2, address3, address4);
        }
    }
    
    public void removeListener(final IMatchesChangeListener matchesChangeListener) {
        this.listener.removeListener(matchesChangeListener);
    }
    
    public void setSizeOfChangedCalls(final int sizeOfChangedCalls) {
        this.metaData.setSizeOfChangedCalls(sizeOfChangedCalls);
    }
    
    public void setSizeOfChangedFunctions(final int sizeOfChangedFunctions) {
        this.metaData.setSizeOfChangedFunctions(sizeOfChangedFunctions);
    }
    
    public void setSizeOfMatchedBasicblocks(final int sizeOfMatchedBasicblocks) {
        this.metaData.setSizeOfMatchedBasicblocks(sizeOfMatchedBasicblocks);
    }
    
    public void setSizeOfMatchedCalls(final int sizeOfMatchedCalls) {
        this.metaData.setSizeOfMatchedCalls(sizeOfMatchedCalls);
    }
    
    public void setSizeOfMatchedInstructions(final int sizeOfMatchedInstructions) {
        this.metaData.setSizeOfMatchedInstructions(sizeOfMatchedInstructions);
    }
    
    public void setSizeOfMatchedJumps(final int sizeOfMatchedJumps) {
        this.metaData.setSizeOfMatchedJumps(sizeOfMatchedJumps);
    }
}
