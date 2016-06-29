package com.google.security.zynamics.bindiff.project.matches;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.ICountsChangeListener;
import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;

public class DiffMetaData {
   private final String version;
   private final String description;
   private final String primaryIdbName;
   private final String secondaryIdbName;
   private final String primaryImageName;
   private final String secondaryImageName;
   private final String primaryHash;
   private final String secondaryHash;
   private String primaryArchitectureName;
   private String secondaryArchitectureName;
   private int primaryMaxMnemonicLen;
   private int secondaryMaxMnemonicLen;
   private final GregorianCalendar date;
   private final double totalSimilarity;
   private final double totalConfidence;
   private final int[] similarityIntervalCounts;
   private int matchedFunctions;
   private int changedFunctions;
   private final int priFunctions;
   private final int secFunctions;
   private int matchedCalls;
   private int changedCalls;
   private final int priCalls;
   private final int secCalls;
   private final int priBasicblocks;
   private final int secBasicblocks;
   private final int priJumps;
   private final int secJumps;
   private final int priInstructions;
   private final int secInstructions;
   private int matchedBasicblocks;
   private int matchedJumps;
   private int matchedInstrutions;
   private int priAddressSpace;
   private int secAddressSpace;
   private final ListenerProvider listeners = new ListenerProvider();

   public DiffMetaData(String var1, String var2, GregorianCalendar var3, double var4, double var6, String var8, String var9, String var10, String var11, String var12, String var13, int[] var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22, int var23, int var24, int var25) {
      this.version = var1;
      this.description = var2;
      this.primaryIdbName = var8;
      this.secondaryIdbName = var9;
      this.primaryImageName = var10;
      this.secondaryImageName = var11;
      this.primaryHash = var12;
      this.secondaryHash = var13;
      this.date = var3;
      this.totalSimilarity = var4;
      this.totalConfidence = var6;
      this.similarityIntervalCounts = var14;
      this.matchedFunctions = var15;
      this.priFunctions = var16;
      this.secFunctions = var17;
      this.priCalls = var18;
      this.secCalls = var19;
      this.priBasicblocks = var20;
      this.secBasicblocks = var21;
      this.priJumps = var22;
      this.secJumps = var23;
      this.priInstructions = var24;
      this.secInstructions = var25;
      this.priAddressSpace = 0;
      this.secAddressSpace = 0;
      this.changedFunctions = 0;
      this.matchedCalls = 0;
      this.changedCalls = 0;
   }

   public static GregorianCalendar dbDateStringToCalendar(String var0) {
      GregorianCalendar var1 = new GregorianCalendar();

      try {
         var1.setTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(var0));
      } catch (ParseException var3) {
         Logger.logException(var3);
      }

      return var1;
   }

   public void addListener(ICountsChangeListener var1) {
      this.listeners.addListener(var1);
   }

   public int getAddressSpace(ESide var1) {
      return var1 == ESide.PRIMARY?this.priAddressSpace:this.secAddressSpace;
   }

   public String getArchitectureName(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryArchitectureName:this.secondaryArchitectureName;
   }

   public GregorianCalendar getDate() {
      return this.date;
   }

   public String getDateString() {
      return DateHelpers.formatDate(this.date.getTime(), 2, Locale.getDefault());
   }

   public String getDiffDescription() {
      return this.description;
   }

   public String getIdbName(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryIdbName:this.secondaryIdbName;
   }

   public String getImageHash(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryHash:this.secondaryHash;
   }

   public String getImageName(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryImageName:this.secondaryImageName;
   }

   public int getMaxMnemonicLen() {
      int var1 = Math.max(this.primaryMaxMnemonicLen, this.secondaryMaxMnemonicLen);
      if(var1 == 0) {
         var1 = 12;
      }

      return var1;
   }

   public int getMaxMnemonicLen(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryMaxMnemonicLen:this.secondaryMaxMnemonicLen;
   }

   public int getSimilarityIntervalCount(int var1) {
      Preconditions.checkArgument(var1 <= 10, "Confidence interval index cannot be greater than 10.");
      return this.similarityIntervalCounts[var1];
   }

   public int[] getSimilarityIntervalCounts() {
      return this.similarityIntervalCounts;
   }

   public int getSizeOfBasicblocks(ESide var1) {
      return var1 == ESide.PRIMARY?this.priBasicblocks:this.secBasicblocks;
   }

   public int getSizeOfCalls(ESide var1) {
      return var1 == ESide.PRIMARY?this.priCalls:this.secCalls;
   }

   public int getSizeOfChangedCalls() {
      return this.changedCalls;
   }

   public int getSizeOfChangedFunctions() {
      return this.changedFunctions;
   }

   public int getSizeOfFunctions(ESide var1) {
      return var1 == ESide.PRIMARY?this.priFunctions:this.secFunctions;
   }

   public int getSizeOfInstructions(ESide var1) {
      return var1 == ESide.PRIMARY?this.priInstructions:this.secInstructions;
   }

   public int getSizeOfJumps(ESide var1) {
      return var1 == ESide.PRIMARY?this.priJumps:this.secJumps;
   }

   public int getSizeOfMatchedBasicblocks() {
      return this.matchedBasicblocks;
   }

   public int getSizeOfMatchedCalls() {
      return this.matchedCalls;
   }

   public int getSizeOfMatchedFunctions() {
      return this.matchedFunctions;
   }

   public int getSizeOfMatchedInstructions() {
      return this.matchedInstrutions;
   }

   public int getSizeOfMatchedJumps() {
      return this.matchedJumps;
   }

   public int getSizeOfUnmatchedBasicblocks(ESide var1) {
      return var1 == ESide.PRIMARY?this.priBasicblocks - this.matchedBasicblocks:this.secBasicblocks - this.matchedBasicblocks;
   }

   public int getSizeOfUnmatchedCalls(ESide var1) {
      return var1 == ESide.PRIMARY?this.priCalls - this.matchedCalls:this.secCalls - this.matchedCalls;
   }

   public int getSizeOfUnmatchedFunctions(ESide var1) {
      return var1 == ESide.PRIMARY?this.priFunctions - this.matchedFunctions:this.secFunctions - this.matchedFunctions;
   }

   public int getSizeOfUnmatchedInstructions(ESide var1) {
      return var1 == ESide.PRIMARY?this.priInstructions - this.matchedInstrutions:this.secInstructions - this.matchedInstrutions;
   }

   public int getSizeOfUnmatchedJumps(ESide var1) {
      return var1 == ESide.PRIMARY?this.priJumps - this.matchedJumps:this.secJumps - this.matchedJumps;
   }

   public double getTotalConfidence() {
      return this.totalConfidence;
   }

   public double getTotalSimilarity() {
      return this.totalSimilarity;
   }

   public String getVersion() {
      return this.version;
   }

   public void removeListener(ICountsChangeListener var1) {
      this.listeners.removeListener(var1);
   }

   public void setAddressSpace(int var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.priAddressSpace = var1;
      } else if(var2 == ESide.SECONDARY) {
         this.secAddressSpace = var1;
      }

   }

   public void setArchitectureName(String var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.primaryArchitectureName = var1;
      } else {
         this.secondaryArchitectureName = var1;
      }

   }

   public void setMaxMnemonicLen(int var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.primaryMaxMnemonicLen = var1;
      } else {
         this.secondaryMaxMnemonicLen = var1;
      }

   }

   public void setSizeOfChangedCalls(int var1) {
      this.changedCalls = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.callsCountChanged();
      }

   }

   public void setSizeOfChangedFunctions(int var1) {
      this.changedFunctions = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.functionsCountChanged();
      }

   }

   public void setSizeOfMatchedBasicblocks(int var1) {
      this.matchedBasicblocks = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.basicblocksCountChanged();
      }

   }

   public void setSizeOfMatchedCalls(int var1) {
      this.matchedCalls = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.callsCountChanged();
      }

   }

   public void setSizeOfMatchedFunctions(int var1) {
      this.matchedFunctions = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.functionsCountChanged();
      }

   }

   public void setSizeOfMatchedInstructions(int var1) {
      this.matchedInstrutions = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.instructionsCountsChanged();
      }

   }

   public void setSizeOfMatchedJumps(int var1) {
      this.matchedJumps = var1;
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ICountsChangeListener var3 = (ICountsChangeListener)var2.next();
         var3.jumpsCountChanged();
      }

   }
}
