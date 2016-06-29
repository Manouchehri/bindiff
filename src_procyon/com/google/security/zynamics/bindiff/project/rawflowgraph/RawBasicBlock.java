package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import com.google.common.base.*;
import java.util.*;

public class RawBasicBlock extends SingleViewNode implements Iterable
{
    private final SortedMap instructions;
    private final long primeProduct;
    private final String functionName;
    private final IAddress functionAddr;
    private final ESide side;
    private final EMatchState matchState;
    private String comment;
    private boolean commentChanged;
    
    public RawBasicBlock(final IAddress address, final String s, final IAddress address2, final SortedMap sortedMap, final long primeProduct, final ESide eSide, final EMatchState eMatchState) {
        super(address2, -1, 0.0, 0.0, Color.WHITE, Color.BLACK, false, true);
        this.comment = "";
        this.commentChanged = false;
        this.functionAddr = (IAddress)Preconditions.checkNotNull(address);
        this.functionName = (String)Preconditions.checkNotNull(s);
        this.instructions = (SortedMap)Preconditions.checkNotNull(sortedMap);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
        this.matchState = (EMatchState)Preconditions.checkNotNull(eMatchState);
        this.primeProduct = primeProduct;
        this.comment = "";
    }
    
    public RawBasicBlock clone(final EMatchState eMatchState) {
        final RawBasicBlock rawBasicBlock = new RawBasicBlock(this.getFunctionAddr(), this.getFunctionName(), this.getAddress(), this.getInstructions(), this.getPrimeProduct(), this.getSide(), eMatchState);
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
    
    public RawInstruction getInstruction(final IAddress address) {
        return (RawInstruction)this.instructions.get(address);
    }
    
    public SortedMap getInstructions() {
        return this.instructions;
    }
    
    @Override
    public EMatchState getMatchState() {
        return this.matchState;
    }
    
    public int getMaxOperandLength() {
        int max = 0;
        final Iterator<RawInstruction> iterator = this.instructions.values().iterator();
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next().getOperandLength());
        }
        return max;
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
    
    @Override
    public Iterator iterator() {
        return this.instructions.values().iterator();
    }
    
    public void setComment(final String comment) {
        this.comment = comment;
        this.commentChanged = true;
    }
}
