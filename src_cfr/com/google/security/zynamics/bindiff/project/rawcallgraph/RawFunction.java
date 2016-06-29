/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RawFunction
extends SingleViewNode {
    private final String name;
    private final EFunctionType type;
    private final ESide side;
    private FunctionMatchData match = null;
    private RawFunction matchedFunction = null;
    private int basicblocks = -1;
    private int jumps = -1;
    private int instructions = -1;
    private String comment = "";

    public RawFunction(IAddress iAddress, String string, EFunctionType eFunctionType, ESide eSide) {
        super(iAddress, -1, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        this.name = (String)Preconditions.checkNotNull(string);
        this.type = (EFunctionType)((Object)Preconditions.checkNotNull((Object)eFunctionType));
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
    }

    public Set getCallees() {
        List list = this.getChildren();
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SingleViewNode singleViewNode = (SingleViewNode)iterator.next();
            hashSet.add((RawFunction)singleViewNode);
        }
        return hashSet;
    }

    public Set getCallers() {
        List list = this.getParents();
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SingleViewNode singleViewNode = (SingleViewNode)iterator.next();
            hashSet.add((RawFunction)singleViewNode);
        }
        return hashSet;
    }

    public String getComment() {
        return this.comment;
    }

    public FunctionMatchData getFunctionMatch() {
        return this.match;
    }

    public EFunctionType getFunctionType() {
        return this.type;
    }

    public FunctionMatchData getMatch() {
        return this.match;
    }

    public RawFunction getMatchedFunction() {
        return this.matchedFunction;
    }

    public IAddress getMatchedFunctionAddress() {
        ESide eSide;
        if (this.getMatchState() != EMatchState.MATCHED) return null;
        if (this.side == ESide.PRIMARY) {
            eSide = ESide.SECONDARY;
            return this.match.getIAddress(eSide);
        }
        eSide = ESide.PRIMARY;
        return this.match.getIAddress(eSide);
    }

    @Override
    public EMatchState getMatchState() {
        EMatchState eMatchState;
        if (this.match != null) return EMatchState.MATCHED;
        if (this.side == ESide.PRIMARY) {
            eMatchState = EMatchState.PRIMARY_UNMATCHED;
            return eMatchState;
        }
        eMatchState = EMatchState.SECONDRAY_UNMATCHED;
        return eMatchState;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public ESide getSide() {
        return this.side;
    }

    public int getSizeOfBasicblocks() {
        return this.basicblocks;
    }

    public int getSizeOfInstructions() {
        return this.instructions;
    }

    public int getSizeOfJumps() {
        return this.jumps;
    }

    public int getSizeOfMatchedBasicblocks() {
        if (this.match == null) {
            return 0;
        }
        int n2 = this.match.getSizeOfMatchedBasicblocks();
        return n2;
    }

    public int getSizeOfMatchedInstructions() {
        if (this.match == null) {
            return 0;
        }
        int n2 = this.match.getSizeOfMatchedInstructions();
        return n2;
    }

    public int getSizeOfMatchedJumps() {
        if (this.match == null) {
            return 0;
        }
        int n2 = this.match.getSizeOfMatchedJumps();
        return n2;
    }

    public int getSizeOfUnmatchedBasicblocks() {
        return this.basicblocks - this.match.getSizeOfMatchedBasicblocks();
    }

    public int getSizeOfUnmatchedInstructions() {
        return this.instructions - this.match.getSizeOfMatchedInstructions();
    }

    public int getSizeOfUnmatchedJumps() {
        return this.jumps - this.match.getSizeOfMatchedJumps();
    }

    public boolean isChanged() {
        if (this.getMatchState() != EMatchState.MATCHED) return false;
        boolean bl2 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
        boolean bl3 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
        boolean bl4 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
        if (!bl2) return true;
        if (!bl3) return true;
        if (!bl4) return true;
        return false;
    }

    public boolean isChangedInstructionsOnlyMatch() {
        if (this.getMatchState() != EMatchState.MATCHED) return false;
        boolean bl2 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
        boolean bl3 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
        boolean bl4 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
        if (!bl2) return false;
        if (!bl3) return false;
        if (bl4) return false;
        return true;
    }

    public boolean isChangedStructuralMatch() {
        if (this.getMatchState() != EMatchState.MATCHED) return false;
        boolean bl2 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
        boolean bl3 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
        if (!bl2) return true;
        if (!bl3) return true;
        return false;
    }

    public boolean isIdenticalMatch() {
        if (this.getMatchState() != EMatchState.MATCHED) return false;
        boolean bl2 = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
        boolean bl3 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
        boolean bl4 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
        if (!bl2) return false;
        if (!bl3) return false;
        if (!bl4) return false;
        return true;
    }

    public void setComment(String string) {
        this.comment = string;
    }

    public void setMatch(RawFunction rawFunction, FunctionMatchData functionMatchData) {
        this.matchedFunction = rawFunction;
        this.match = functionMatchData;
    }

    public void setSizeOfBasicblocks(int n2) {
        this.basicblocks = n2;
    }

    public void setSizeOfInstructions(int n2) {
        this.instructions = n2;
    }

    public void setSizeOfJumps(int n2) {
        this.jumps = n2;
    }
}

