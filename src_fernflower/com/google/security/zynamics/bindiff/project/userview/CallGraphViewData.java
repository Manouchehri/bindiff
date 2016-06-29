package com.google.security.zynamics.bindiff.project.userview;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class CallGraphViewData extends ViewData {
   private final RawCallGraph primaryRawGraph;
   private final RawCallGraph secondaryRawGraph;
   private final String priImageName;
   private final String secImageName;

   public CallGraphViewData(RawCallGraph var1, RawCallGraph var2, GraphsContainer var3, String var4, String var5, String var6, EViewType var7) {
      super(var3, var4, var7);
      this.primaryRawGraph = (RawCallGraph)Preconditions.checkNotNull(var1);
      this.secondaryRawGraph = var2;
      this.priImageName = var5;
      this.secImageName = var6;
   }

   public IAddress getAddress(ESide var1) {
      return null;
   }

   public String getImageName(ESide var1) {
      return var1 == ESide.PRIMARY?this.priImageName:this.secImageName;
   }

   public RawCallGraph getRawGraph(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryRawGraph:this.secondaryRawGraph;
   }

   public boolean isCallgraphView() {
      return true;
   }

   public boolean isFlowgraphView() {
      return false;
   }
}
