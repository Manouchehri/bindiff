/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;

public class FunctionMatchCounts {
    private final int matchedBasicblocksCount;
    private final int priBasicblocksCount;
    private final int secBasicblockCount;
    private final int matchedJumpsCount;
    private final int priJumpsCount;
    private final int secJumpsCount;
    private final int matchedInstructionsCount;
    private final int priInstructionsCount;
    private final int secInstructionsCount;

    public FunctionMatchCounts(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.matchedBasicblocksCount = n2;
        this.priBasicblocksCount = n3;
        this.secBasicblockCount = n4;
        this.matchedJumpsCount = n5;
        this.priJumpsCount = n6;
        this.secJumpsCount = n7;
        this.matchedInstructionsCount = n8;
        this.priInstructionsCount = n9;
        this.secInstructionsCount = n10;
    }

    public int getBasicblocksCount(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priBasicblocksCount;
            return n2;
        }
        n2 = this.secBasicblockCount;
        return n2;
    }

    public int getInstructionsCount(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priInstructionsCount;
            return n2;
        }
        n2 = this.secInstructionsCount;
        return n2;
    }

    public int getJumpsCount(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priJumpsCount;
            return n2;
        }
        n2 = this.secJumpsCount;
        return n2;
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

