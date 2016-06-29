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

   public FunctionMatchCounts(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      this.matchedBasicblocksCount = var1;
      this.priBasicblocksCount = var2;
      this.secBasicblockCount = var3;
      this.matchedJumpsCount = var4;
      this.priJumpsCount = var5;
      this.secJumpsCount = var6;
      this.matchedInstructionsCount = var7;
      this.priInstructionsCount = var8;
      this.secInstructionsCount = var9;
   }

   public int getBasicblocksCount(ESide var1) {
      return var1 == ESide.PRIMARY?this.priBasicblocksCount:this.secBasicblockCount;
   }

   public int getInstructionsCount(ESide var1) {
      return var1 == ESide.PRIMARY?this.priInstructionsCount:this.secInstructionsCount;
   }

   public int getJumpsCount(ESide var1) {
      return var1 == ESide.PRIMARY?this.priJumpsCount:this.secJumpsCount;
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
