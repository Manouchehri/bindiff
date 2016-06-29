package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.*;

public class FunctionMatchCounts
{
    private final int matchedBasicblocksCount;
    private final int priBasicblocksCount;
    private final int secBasicblockCount;
    private final int matchedJumpsCount;
    private final int priJumpsCount;
    private final int secJumpsCount;
    private final int matchedInstructionsCount;
    private final int priInstructionsCount;
    private final int secInstructionsCount;
    
    public FunctionMatchCounts(final int matchedBasicblocksCount, final int priBasicblocksCount, final int secBasicblockCount, final int matchedJumpsCount, final int priJumpsCount, final int secJumpsCount, final int matchedInstructionsCount, final int priInstructionsCount, final int secInstructionsCount) {
        this.matchedBasicblocksCount = matchedBasicblocksCount;
        this.priBasicblocksCount = priBasicblocksCount;
        this.secBasicblockCount = secBasicblockCount;
        this.matchedJumpsCount = matchedJumpsCount;
        this.priJumpsCount = priJumpsCount;
        this.secJumpsCount = secJumpsCount;
        this.matchedInstructionsCount = matchedInstructionsCount;
        this.priInstructionsCount = priInstructionsCount;
        this.secInstructionsCount = secInstructionsCount;
    }
    
    public int getBasicblocksCount(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priBasicblocksCount : this.secBasicblockCount;
    }
    
    public int getInstructionsCount(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priInstructionsCount : this.secInstructionsCount;
    }
    
    public int getJumpsCount(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priJumpsCount : this.secJumpsCount;
    }
    
    public int getMatchedBasicblocksCount() {
        return this.matchedBasicblocksCount;
    }
    
    public int getMatchedInstructionsCount() {
        return this.matchedInstructionsCount;
    }
    
    public int getMatchedJumpsCount() {
        return this.matchedJumpsCount;
    }
}
