package com.google.security.zynamics.bindiff.project.userview;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class FlowGraphViewData extends ViewData {
   private final RawFlowGraph primaryRawGraph;
   private final RawFlowGraph secondaryRawGraph;
   private final RawCombinedFlowGraph combinedRawFlowgraph;

   public FlowGraphViewData(RawFlowGraph var1, RawFlowGraph var2, RawCombinedFlowGraph var3, GraphsContainer var4, String var5, EViewType var6) {
      super(var4, var5, var6);
      Preconditions.checkArgument(var1 != null || var2 != null, "Raw primary and secondary flow graphs cannot both be null");
      this.combinedRawFlowgraph = (RawCombinedFlowGraph)Preconditions.checkNotNull(var3);
      this.primaryRawGraph = var1;
      this.secondaryRawGraph = var2;
   }

   public IAddress getAddress(ESide var1) {
      return var1 == ESide.PRIMARY?(this.primaryRawGraph == null?null:this.primaryRawGraph.getAddress()):(this.secondaryRawGraph == null?null:this.secondaryRawGraph.getAddress());
   }

   public RawCombinedFlowGraph getCombinedRawGraph() {
      return this.combinedRawFlowgraph;
   }

   public String getFunctionName(ESide var1) {
      return var1 == ESide.PRIMARY?(this.primaryRawGraph == null?null:this.primaryRawGraph.getName()):(this.secondaryRawGraph == null?null:this.secondaryRawGraph.getName());
   }

   public RawFlowGraph getRawGraph(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryRawGraph:this.secondaryRawGraph;
   }

   public boolean isCallgraphView() {
      return false;
   }

   public boolean isChangedOnlyInstructions() {
      RawFunction var1 = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
      return var1 != null && var1.isChangedInstructionsOnlyMatch();
   }

   public boolean isChangedStructural() {
      RawFunction var1 = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
      return var1 != null && var1.isChangedStructuralMatch();
   }

   public boolean isFlowgraphView() {
      return true;
   }

   public boolean isMatched() {
      RawFunction var1 = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
      return var1 != null && var1.getMatchedFunction() != null;
   }

   public boolean isMatchedIdentical() {
      RawFunction var1 = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
      return var1 != null && var1.isIdenticalMatch();
   }
}
