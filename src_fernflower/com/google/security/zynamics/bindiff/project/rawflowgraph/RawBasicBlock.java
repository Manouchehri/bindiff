package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

public class RawBasicBlock extends SingleViewNode implements Iterable {
   private final SortedMap instructions;
   private final long primeProduct;
   private final String functionName;
   private final IAddress functionAddr;
   private final ESide side;
   private final EMatchState matchState;
   private String comment = "";
   private boolean commentChanged = false;

   public RawBasicBlock(IAddress var1, String var2, IAddress var3, SortedMap var4, long var5, ESide var7, EMatchState var8) {
      super(var3, -1, 0.0D, 0.0D, Color.WHITE, Color.BLACK, false, true);
      this.functionAddr = (IAddress)Preconditions.checkNotNull(var1);
      this.functionName = (String)Preconditions.checkNotNull(var2);
      this.instructions = (SortedMap)Preconditions.checkNotNull(var4);
      this.side = (ESide)Preconditions.checkNotNull(var7);
      this.matchState = (EMatchState)Preconditions.checkNotNull(var8);
      this.primeProduct = var5;
      this.comment = "";
   }

   public RawBasicBlock clone(EMatchState var1) {
      RawBasicBlock var2 = new RawBasicBlock(this.getFunctionAddr(), this.getFunctionName(), this.getAddress(), this.getInstructions(), this.getPrimeProduct(), this.getSide(), var1);
      var2.comment = this.getComment();
      return var2;
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

   public RawInstruction getInstruction(IAddress var1) {
      return (RawInstruction)this.instructions.get(var1);
   }

   public SortedMap getInstructions() {
      return this.instructions;
   }

   public EMatchState getMatchState() {
      return this.matchState;
   }

   public int getMaxOperandLength() {
      int var1 = 0;

      RawInstruction var3;
      for(Iterator var2 = this.instructions.values().iterator(); var2.hasNext(); var1 = Math.max(var1, var3.getOperandLength())) {
         var3 = (RawInstruction)var2.next();
      }

      return var1;
   }

   public List getOutgoingEdges() {
      return super.getOutgoingEdges();
   }

   public long getPrimeProduct() {
      return this.primeProduct;
   }

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

   public void setComment(String var1) {
      this.comment = var1;
      this.commentChanged = true;
   }
}
