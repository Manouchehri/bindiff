package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.types.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class BasicBlockMatchData implements IAddressPair
{
    private final IAddressPair addrPair;
    private final int algoId;
    private final Matches instructionMatches;
    
    public BasicBlockMatchData(final long n, final long n2, final int algoId, final Matches instructionMatches) {
        this.addrPair = new AddressPair(n, n2);
        this.algoId = algoId;
        this.instructionMatches = instructionMatches;
    }
    
    @Override
    public long getAddress(final ESide eSide) {
        return this.addrPair.getAddress(eSide);
    }
    
    public int getAlgorithmId() {
        return this.algoId;
    }
    
    @Override
    public IAddress getIAddress(final ESide eSide) {
        return new CAddress(this.getAddress(eSide));
    }
    
    public InstructionMatchData getInstructionMatch(final IAddress address, final ESide eSide) {
        return (InstructionMatchData)this.instructionMatches.get(address, eSide);
    }
    
    public InstructionMatchData[] getInstructionMatches() {
        return this.instructionMatches.getMatches().toArray(new InstructionMatchData[0]);
    }
    
    public IAddress getPrimaryInstructionAddr(final IAddress address) {
        final InstructionMatchData instructionMatchData = (InstructionMatchData)this.instructionMatches.get(address, ESide.SECONDARY);
        return (instructionMatchData != null) ? instructionMatchData.getIAddress(ESide.PRIMARY) : null;
    }
    
    public IAddress getSecondaryInstructionAddr(final IAddress address) {
        final InstructionMatchData instructionMatchData = (InstructionMatchData)this.instructionMatches.get(address, ESide.PRIMARY);
        return (instructionMatchData != null) ? instructionMatchData.getIAddress(ESide.SECONDARY) : null;
    }
    
    public int getSizeOfMatchedInstructions() {
        return this.instructionMatches.size();
    }
    
    public boolean isInstructionMatch(final IAddress address) {
        final IAddress secondaryInstructionAddr = this.getSecondaryInstructionAddr(address);
        return secondaryInstructionAddr != null && secondaryInstructionAddr.equals(address);
    }
}
