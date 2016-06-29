package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.awt.*;
import com.google.common.base.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;

public class RawFunction extends SingleViewNode
{
    private final String name;
    private final EFunctionType type;
    private final ESide side;
    private FunctionMatchData match;
    private RawFunction matchedFunction;
    private int basicblocks;
    private int jumps;
    private int instructions;
    private String comment;
    
    public RawFunction(final IAddress address, final String s, final EFunctionType eFunctionType, final ESide eSide) {
        super(address, -1, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        this.match = null;
        this.matchedFunction = null;
        this.basicblocks = -1;
        this.jumps = -1;
        this.instructions = -1;
        this.comment = "";
        this.name = (String)Preconditions.checkNotNull(s);
        this.type = (EFunctionType)Preconditions.checkNotNull(eFunctionType);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
    }
    
    public Set getCallees() {
        final List children = this.getChildren();
        final HashSet<RawFunction> set = new HashSet<RawFunction>();
        final Iterator<SingleViewNode> iterator = children.iterator();
        while (iterator.hasNext()) {
            set.add((RawFunction)iterator.next());
        }
        return set;
    }
    
    public Set getCallers() {
        final List parents = this.getParents();
        final HashSet<RawFunction> set = new HashSet<RawFunction>();
        final Iterator<SingleViewNode> iterator = parents.iterator();
        while (iterator.hasNext()) {
            set.add((RawFunction)iterator.next());
        }
        return set;
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
        if (this.getMatchState() == EMatchState.MATCHED) {
            return this.match.getIAddress((this.side == ESide.PRIMARY) ? ESide.SECONDARY : ESide.PRIMARY);
        }
        return null;
    }
    
    @Override
    public EMatchState getMatchState() {
        if (this.match == null) {
            return (this.side == ESide.PRIMARY) ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED;
        }
        return EMatchState.MATCHED;
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
        return (this.match == null) ? 0 : this.match.getSizeOfMatchedBasicblocks();
    }
    
    public int getSizeOfMatchedInstructions() {
        return (this.match == null) ? 0 : this.match.getSizeOfMatchedInstructions();
    }
    
    public int getSizeOfMatchedJumps() {
        return (this.match == null) ? 0 : this.match.getSizeOfMatchedJumps();
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
        if (this.getMatchState() == EMatchState.MATCHED) {
            final boolean b = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
            final boolean b2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
            final boolean b3 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
            return !b || !b2 || !b3;
        }
        return false;
    }
    
    public boolean isChangedInstructionsOnlyMatch() {
        if (this.getMatchState() == EMatchState.MATCHED) {
            final boolean b = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
            final boolean b2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
            final boolean b3 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
            return b && b2 && !b3;
        }
        return false;
    }
    
    public boolean isChangedStructuralMatch() {
        if (this.getMatchState() == EMatchState.MATCHED) {
            final boolean b = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
            final boolean b2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
            return !b || !b2;
        }
        return false;
    }
    
    public boolean isIdenticalMatch() {
        if (this.getMatchState() == EMatchState.MATCHED) {
            final boolean b = this.basicblocks == this.matchedFunction.getSizeOfBasicblocks() && this.basicblocks == this.getSizeOfMatchedBasicblocks();
            final boolean b2 = this.jumps == this.matchedFunction.getSizeOfJumps() && this.jumps == this.getSizeOfMatchedJumps();
            final boolean b3 = this.instructions == this.matchedFunction.getSizeOfInstructions() && this.instructions == this.getSizeOfMatchedInstructions();
            return b && b2 && b3;
        }
        return false;
    }
    
    public void setComment(final String comment) {
        this.comment = comment;
    }
    
    public void setMatch(final RawFunction matchedFunction, final FunctionMatchData match) {
        this.matchedFunction = matchedFunction;
        this.match = match;
    }
    
    public void setSizeOfBasicblocks(final int basicblocks) {
        this.basicblocks = basicblocks;
    }
    
    public void setSizeOfInstructions(final int instructions) {
        this.instructions = instructions;
    }
    
    public void setSizeOfJumps(final int jumps) {
        this.jumps = jumps;
    }
}
