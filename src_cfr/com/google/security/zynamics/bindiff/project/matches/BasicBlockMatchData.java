/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;

public class BasicBlockMatchData
implements IAddressPair {
    private final IAddressPair addrPair;
    private final int algoId;
    private final Matches instructionMatches;

    public BasicBlockMatchData(long l2, long l3, int n2, Matches matches) {
        this.addrPair = new AddressPair(l2, l3);
        this.algoId = n2;
        this.instructionMatches = matches;
    }

    @Override
    public long getAddress(ESide eSide) {
        return this.addrPair.getAddress(eSide);
    }

    public int getAlgorithmId() {
        return this.algoId;
    }

    @Override
    public IAddress getIAddress(ESide eSide) {
        return new CAddress(this.getAddress(eSide));
    }

    public InstructionMatchData getInstructionMatch(IAddress iAddress, ESide eSide) {
        return (InstructionMatchData)this.instructionMatches.get(iAddress, eSide);
    }

    public InstructionMatchData[] getInstructionMatches() {
        return this.instructionMatches.getMatches().toArray(new InstructionMatchData[0]);
    }

    public IAddress getPrimaryInstructionAddr(IAddress iAddress) {
        InstructionMatchData instructionMatchData = (InstructionMatchData)this.instructionMatches.get(iAddress, ESide.SECONDARY);
        if (instructionMatchData == null) return null;
        IAddress iAddress2 = instructionMatchData.getIAddress(ESide.PRIMARY);
        return iAddress2;
    }

    public IAddress getSecondaryInstructionAddr(IAddress iAddress) {
        InstructionMatchData instructionMatchData = (InstructionMatchData)this.instructionMatches.get(iAddress, ESide.PRIMARY);
        if (instructionMatchData == null) return null;
        IAddress iAddress2 = instructionMatchData.getIAddress(ESide.SECONDARY);
        return iAddress2;
    }

    public int getSizeOfMatchedInstructions() {
        return this.instructionMatches.size();
    }

    public boolean isInstructionMatch(IAddress iAddress) {
        IAddress iAddress2 = this.getSecondaryInstructionAddr(iAddress);
        if (iAddress2 == null) return false;
        if (!iAddress2.equals(iAddress)) return false;
        return true;
    }
}

