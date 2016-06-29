/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

public class RawBasicBlock
extends SingleViewNode
implements Iterable {
    private final SortedMap instructions;
    private final long primeProduct;
    private final String functionName;
    private final IAddress functionAddr;
    private final ESide side;
    private final EMatchState matchState;
    private String comment = "";
    private boolean commentChanged = false;

    public RawBasicBlock(IAddress iAddress, String string, IAddress iAddress2, SortedMap sortedMap, long l2, ESide eSide, EMatchState eMatchState) {
        super(iAddress2, -1, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        this.functionAddr = (IAddress)Preconditions.checkNotNull(iAddress);
        this.functionName = (String)Preconditions.checkNotNull(string);
        this.instructions = (SortedMap)Preconditions.checkNotNull(sortedMap);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
        this.matchState = (EMatchState)((Object)Preconditions.checkNotNull((Object)eMatchState));
        this.primeProduct = l2;
        this.comment = "";
    }

    public RawBasicBlock clone(EMatchState eMatchState) {
        RawBasicBlock rawBasicBlock = new RawBasicBlock(this.getFunctionAddr(), this.getFunctionName(), this.getAddress(), this.getInstructions(), this.getPrimeProduct(), this.getSide(), eMatchState);
        rawBasicBlock.comment = this.getComment();
        return rawBasicBlock;
    }

    public String getComment() {
        return this.comment;
    }

    public IAddress getFunctionAddr() {
        return this.functionAddr;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public RawInstruction getInstruction(IAddress iAddress) {
        return (RawInstruction)this.instructions.get(iAddress);
    }

    public SortedMap getInstructions() {
        return this.instructions;
    }

    @Override
    public EMatchState getMatchState() {
        return this.matchState;
    }

    public int getMaxOperandLength() {
        int n2 = 0;
        Iterator iterator = this.instructions.values().iterator();
        while (iterator.hasNext()) {
            RawInstruction rawInstruction = (RawInstruction)iterator.next();
            n2 = Math.max(n2, rawInstruction.getOperandLength());
        }
        return n2;
    }

    @Override
    public List getOutgoingEdges() {
        return super.getOutgoingEdges();
    }

    public long getPrimeProduct() {
        return this.primeProduct;
    }

    @Override
    public ESide getSide() {
        return this.side;
    }

    public int getSizeOfInstructions() {
        return this.instructions.size();
    }

    public boolean isChangedComment() {
        return this.commentChanged;
    }

    public Iterator iterator() {
        return this.instructions.values().iterator();
    }

    public void setComment(String string) {
        this.comment = string;
        this.commentChanged = true;
    }
}

