package com.google.security.zynamics.bindiff.io.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import com.google.security.zynamics.bindiff.project.diff.Diff;

public class FunctionDiffSocketXmlData implements IReadXmlHandlerData {
   private String matchesDBPath = "";
   private String priFlowgraphsPath = "";
   private String secFlowgraphsPath = "";
   private int priFlowgraphOffset = -1;
   private int secFlowgraphOffset = -1;
   private final Diff diff;

   public FunctionDiffSocketXmlData() {
      this.diff = null;
   }

   public FunctionDiffSocketXmlData(Diff var1) {
      this.diff = var1;
   }

   public Diff getDiff() {
      return this.diff;
   }

   public int getFlowgraphOffset(ESide var1) {
      return ESide.PRIMARY == var1?this.priFlowgraphOffset:this.secFlowgraphOffset;
   }

   public String getFlowgraphsPath(ESide var1) {
      return var1 == ESide.PRIMARY?this.priFlowgraphsPath:this.secFlowgraphsPath;
   }

   public String getMatchesDBPath() {
      return this.matchesDBPath;
   }

   public void setFlowgraphOffset(int var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priFlowgraphOffset = var1;
      } else {
         this.secFlowgraphOffset = var1;
      }

   }

   public void setFlowgraphsPath(String var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priFlowgraphsPath = var1;
      } else {
         this.secFlowgraphsPath = var1;
      }

   }

   public void setMatchesDBPath(String var1) {
      this.matchesDBPath = var1;
   }
}
