package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class FunctionDiffMetaData extends DiffMetaData {
   private IAddress priFunctionAddr;
   private IAddress secFunctionAddr;
   private String priFunctionName;
   private String secFunctionName;
   private EFunctionType priFunctionType;
   private EFunctionType secFunctionType;
   private Integer priFlowgraphOffset;
   private Integer secFlowgraphOffset;

   public FunctionDiffMetaData(DiffMetaData var1, IAddress var2, IAddress var3, String var4, String var5, EFunctionType var6, EFunctionType var7, Integer var8, Integer var9) {
      super(var1.getVersion(), var1.getDiffDescription(), var1.getDate(), var1.getTotalSimilarity(), var1.getTotalConfidence(), var1.getIdbName(ESide.PRIMARY), var1.getIdbName(ESide.SECONDARY), var1.getImageName(ESide.PRIMARY), var1.getImageName(ESide.SECONDARY), var1.getImageHash(ESide.PRIMARY), var1.getImageHash(ESide.SECONDARY), var1.getSimilarityIntervalCounts(), var1.getSizeOfMatchedFunctions(), var1.getSizeOfUnmatchedFunctions(ESide.PRIMARY), var1.getSizeOfUnmatchedFunctions(ESide.SECONDARY), var1.getSizeOfCalls(ESide.PRIMARY), var1.getSizeOfCalls(ESide.SECONDARY), var1.getSizeOfBasicblocks(ESide.PRIMARY), var1.getSizeOfBasicblocks(ESide.SECONDARY), var1.getSizeOfJumps(ESide.PRIMARY), var1.getSizeOfJumps(ESide.SECONDARY), var1.getSizeOfInstructions(ESide.PRIMARY), var1.getSizeOfInstructions(ESide.SECONDARY));
      this.priFunctionAddr = var2;
      this.secFunctionAddr = var3;
      this.priFunctionName = var4;
      this.secFunctionName = var5;
      this.priFunctionType = var6;
      this.secFunctionType = var7;
      this.priFlowgraphOffset = var8;
      this.secFlowgraphOffset = var9;
   }

   public int getFlowgraphOffset(ESide var1) {
      return (var1 == ESide.PRIMARY?this.priFlowgraphOffset:this.secFlowgraphOffset).intValue();
   }

   public IAddress getFunctionAddr(ESide var1) {
      return var1 == ESide.PRIMARY?this.priFunctionAddr:this.secFunctionAddr;
   }

   public String getFunctionName(ESide var1) {
      return var1 == ESide.PRIMARY?this.priFunctionName:this.secFunctionName;
   }

   public EFunctionType getFunctionType(ESide var1) {
      return var1 == ESide.PRIMARY?this.priFunctionType:this.secFunctionType;
   }

   public void setFlowgraphOffset(int var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priFlowgraphOffset = Integer.valueOf(var1);
      } else {
         this.secFlowgraphOffset = Integer.valueOf(var1);
      }

   }

   public void setFunctionAddr(IAddress var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priFunctionAddr = var1;
      } else {
         this.secFunctionAddr = var1;
      }

   }

   public void setFunctionName(String var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priFunctionName = var1;
      } else {
         this.secFunctionName = var1;
      }

   }

   public void setFunctionType(EFunctionType var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priFunctionType = var1;
      } else {
         this.secFunctionType = var1;
      }

   }
}
