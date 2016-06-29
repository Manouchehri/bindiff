/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MatchData {
    private final DiffMetaData metaData;
    private Matches functionMatches;
    private final ListenerProvider listener = new ListenerProvider();

    public MatchData(List list, DiffMetaData diffMetaData) {
        this.metaData = (DiffMetaData)Preconditions.checkNotNull(diffMetaData);
        this.functionMatches = new Matches((List)Preconditions.checkNotNull(list));
    }

    public void addListener(IMatchesChangeListener iMatchesChangeListener) {
        this.listener.addListener(iMatchesChangeListener);
    }

    public void close() {
        this.functionMatches.clear();
    }

    public FunctionMatchData getFunctionMatch(IAddress iAddress, ESide eSide) {
        return (FunctionMatchData)this.functionMatches.get(iAddress, eSide);
    }

    public FunctionMatchData[] getFunctionMatches() {
        return this.functionMatches.getMatches().toArray(new FunctionMatchData[0]);
    }

    public IAddress getPrimaryFunctionAddr(IAddress iAddress) {
        FunctionMatchData functionMatchData = (FunctionMatchData)this.functionMatches.get(iAddress, ESide.SECONDARY);
        if (functionMatchData == null) return null;
        IAddress iAddress2 = functionMatchData.getIAddress(ESide.PRIMARY);
        return iAddress2;
    }

    public IAddress getSecondaryFunctionAddr(IAddress iAddress) {
        FunctionMatchData functionMatchData = (FunctionMatchData)this.functionMatches.get(iAddress, ESide.PRIMARY);
        if (functionMatchData == null) return null;
        IAddress iAddress2 = functionMatchData.getIAddress(ESide.SECONDARY);
        return iAddress2;
    }

    public int getSizeOfBasicblocks(ESide eSide) {
        return this.metaData.getSizeOfBasicblocks(eSide);
    }

    public int getSizeOfCalls(ESide eSide) {
        return this.metaData.getSizeOfCalls(eSide);
    }

    public int getSizeOfChangedCalls() {
        return this.metaData.getSizeOfChangedCalls();
    }

    public int getSizeOfChangedFunctions() {
        return this.metaData.getSizeOfChangedFunctions();
    }

    public int getSizeOfFunctions(ESide eSide) {
        return this.metaData.getSizeOfFunctions(eSide);
    }

    public int getSizeOfInstructions(ESide eSide) {
        return this.metaData.getSizeOfInstructions(eSide);
    }

    public int getSizeOfJumps(ESide eSide) {
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

    public int getSizeOfUnmatchedBasicblocks(ESide eSide) {
        return this.metaData.getSizeOfUnmatchedBasicblocks(eSide);
    }

    public int getSizeOfUnmatchedCalls(ESide eSide) {
        return this.metaData.getSizeOfUnmatchedCalls(eSide);
    }

    public int getSizeOfUnmatchedFunctions(ESide eSide) {
        return this.metaData.getSizeOfUnmatchedFunctions(eSide);
    }

    public int getSizeOfUnmatchedInstructions(ESide eSide) {
        return this.metaData.getSizeOfUnmatchedInstructions(eSide);
    }

    public int getSizeOfUnmatchedJumps(ESide eSide) {
        return this.metaData.getSizeOfUnmatchedJumps(eSide);
    }

    public boolean isFunctionMatch(IAddress iAddress, IAddress iAddress2) {
        IAddress iAddress3 = this.getSecondaryFunctionAddr(iAddress);
        if (iAddress3 == null) return false;
        if (!iAddress3.equals(iAddress2)) return false;
        return true;
    }

    public void notifyBasicblockMatchAddedListener(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        Iterator iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            IMatchesChangeListener iMatchesChangeListener = (IMatchesChangeListener)iterator.next();
            iMatchesChangeListener.addedBasicblockMatch(iAddress, iAddress2, iAddress3, iAddress4);
        }
    }

    public void notifyBasicblockMatchRemovedListener(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        Iterator iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            IMatchesChangeListener iMatchesChangeListener = (IMatchesChangeListener)iterator.next();
            iMatchesChangeListener.removedBasicblockMatch(iAddress, iAddress2, iAddress3, iAddress4);
        }
    }

    public void removeListener(IMatchesChangeListener iMatchesChangeListener) {
        this.listener.removeListener(iMatchesChangeListener);
    }

    public void setSizeOfChangedCalls(int n2) {
        this.metaData.setSizeOfChangedCalls(n2);
    }

    public void setSizeOfChangedFunctions(int n2) {
        this.metaData.setSizeOfChangedFunctions(n2);
    }

    public void setSizeOfMatchedBasicblocks(int n2) {
        this.metaData.setSizeOfMatchedBasicblocks(n2);
    }

    public void setSizeOfMatchedCalls(int n2) {
        this.metaData.setSizeOfMatchedCalls(n2);
    }

    public void setSizeOfMatchedInstructions(int n2) {
        this.metaData.setSizeOfMatchedInstructions(n2);
    }

    public void setSizeOfMatchedJumps(int n2) {
        this.metaData.setSizeOfMatchedJumps(n2);
    }
}

