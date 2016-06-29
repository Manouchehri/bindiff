package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.util.Iterator;

public final class Diff {
   private final ListenerProvider listenerProvider = new ListenerProvider();
   private File matchesDatabaseFile;
   private File primaryExportFile;
   private File secondaryExportFile;
   private String priExportMD5 = null;
   private String secExportMD5 = null;
   private final ViewManager viewManager = new ViewManager();
   private RawCallGraph primaryCallgraph = null;
   private RawCallGraph secondaryCallgraph = null;
   private final DiffMetaData metaData;
   private final boolean isFunctionDiff;
   private MatchData matches;
   private boolean loaded = false;

   public Diff(DiffMetaData var1, File var2, File var3, File var4, boolean var5) {
      this.metaData = (DiffMetaData)Preconditions.checkNotNull(var1);
      this.matchesDatabaseFile = (File)Preconditions.checkNotNull(var2);
      this.primaryExportFile = (File)Preconditions.checkNotNull(var3);
      this.secondaryExportFile = (File)Preconditions.checkNotNull(var4);
      this.isFunctionDiff = var5;
   }

   private void close() {
      this.primaryCallgraph = null;
      this.secondaryCallgraph = null;
      if(this.matches != null) {
         this.matches.close();
      }

      this.loaded = false;
   }

   protected Diff cloneDiffObjectOnSaveAs(File var1, File var2, File var3, FlowGraphViewData var4) {
      this.viewManager.removeView(var4);
      Diff var5 = new Diff(this.metaData, var1, var2, var3, true);
      var5.primaryExportFile = var2;
      var5.secondaryExportFile = var3;
      var5.priExportMD5 = this.priExportMD5;
      var5.secExportMD5 = this.secExportMD5;
      var5.loaded = this.loaded;
      var5.viewManager.addView(var4);
      var5.primaryCallgraph = this.primaryCallgraph;
      var5.secondaryCallgraph = this.secondaryCallgraph;
      var5.matches = this.matches;
      var4.setViewName(CFileUtils.forceFilenameEndsNotWithExtension(var1.getName(), "BinDiff"));
      var4.getGraphs().setDiff(var5);
      return var5;
   }

   public void addListener(IDiffListener var1) {
      this.listenerProvider.addListener(var1);
   }

   public void closeDiff() {
      String var1 = this.getDiffName();
      Logger.logInfo((new StringBuilder(17 + String.valueOf(var1).length())).append("Unloading Diff \'").append(var1).append("\'").toString(), new Object[0]);
      if(this.matches != null) {
         this.close();
         Iterator var3 = this.listenerProvider.iterator();

         while(var3.hasNext()) {
            IDiffListener var2 = (IDiffListener)var3.next();
            var2.unloadedDiff(this);
         }

      }
   }

   public String getBinExportMD5(ESide var1) {
      if(this.priExportMD5 == null) {
         this.priExportMD5 = FileUtils.calcMD5(this.primaryExportFile);
      }

      if(this.secExportMD5 == null) {
         this.secExportMD5 = FileUtils.calcMD5(this.secondaryExportFile);
      }

      return ESide.PRIMARY == var1?this.priExportMD5:this.secExportMD5;
   }

   public RawCallGraph getCallgraph(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryCallgraph:this.secondaryCallgraph;
   }

   public String getDiffFolder() {
      return this.getMatchesDatabase().getParent();
   }

   public DiffMetaData getDiffMetaData() {
      return this.metaData;
   }

   public String getDiffName() {
      return this.matchesDatabaseFile.getName();
   }

   public File getExportFile(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryExportFile:this.secondaryExportFile;
   }

   public RawFunction getFunction(IAddress var1, ESide var2) {
      return this.getCallgraph(var2).getFunction(var1);
   }

   public ListenerProvider getListener() {
      return this.listenerProvider;
   }

   public MatchData getMatches() {
      return this.matches;
   }

   public File getMatchesDatabase() {
      return this.matchesDatabaseFile;
   }

   public DiffMetaData getMetaData() {
      return this.metaData;
   }

   public ViewManager getViewManager() {
      return this.viewManager;
   }

   public boolean isFunctionDiff() {
      return this.isFunctionDiff;
   }

   public boolean isLoaded() {
      return this.loaded;
   }

   public void removeDiff() {
      String var1 = this.getDiffName();
      Logger.logInfo((new StringBuilder(16 + String.valueOf(var1).length())).append("Removing Diff \'").append(var1).append("\'").toString(), new Object[0]);
      this.close();
      Iterator var3 = this.listenerProvider.iterator();

      IDiffListener var2;
      while(var3.hasNext()) {
         var2 = (IDiffListener)var3.next();
         var2.unloadedDiff(this);
      }

      var3 = this.listenerProvider.iterator();

      while(var3.hasNext()) {
         var2 = (IDiffListener)var3.next();
         var2.removedDiff(this);
      }

   }

   public void removeListener(IDiffListener var1) {
      this.listenerProvider.removeListener(var1);
   }

   public void setCallgraph(RawCallGraph var1, ESide var2) {
      if(var2 == ESide.PRIMARY) {
         this.primaryCallgraph = var1;
      } else {
         this.secondaryCallgraph = var1;
      }

   }

   public void setExportFile(File var1, ESide var2) {
      if(!this.isFunctionDiff()) {
         throw new UnsupportedOperationException("Unsupported operation: Export file names can only be updated if the diff is a function diff.");
      } else {
         if(var2 == ESide.PRIMARY) {
            this.primaryExportFile = var1;
            this.priExportMD5 = null;
         } else {
            this.secondaryExportFile = var1;
            this.secExportMD5 = null;
         }

      }
   }

   public void setLoaded(boolean var1) {
      this.loaded = var1;
   }

   public void setMatches(MatchData var1) {
      this.matches = var1;
   }

   public void setMatchesDatabase(File var1) {
      if(!this.isFunctionDiff()) {
         throw new UnsupportedOperationException("Matches database file can only be updated if the diff is a function diff.");
      } else {
         this.matchesDatabaseFile = var1;
      }
   }

   public void willOverwriteDiff(String var1) {
      Iterator var2 = this.listenerProvider.iterator();

      while(var2.hasNext()) {
         IDiffListener var3 = (IDiffListener)var2.next();
         var3.willOverwriteDiff(var1);
      }

   }
}
