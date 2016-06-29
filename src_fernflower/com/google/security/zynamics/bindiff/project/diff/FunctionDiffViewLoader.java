package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelInitializer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.builders.RawCombinedFlowGraphBuilder;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.io.File;

public class FunctionDiffViewLoader extends CEndlessHelperThread {
   private final FunctionDiffSocketXmlData data;
   private final MainWindow window;
   private final TabPanelManager tabPanelManager;
   private final Workspace workspace;
   private FlowGraphViewData viewData;

   public FunctionDiffViewLoader(FunctionDiffSocketXmlData var1, MainWindow var2, TabPanelManager var3, Workspace var4) {
      this.data = (FunctionDiffSocketXmlData)Preconditions.checkNotNull(var1);
      this.window = (MainWindow)Preconditions.checkNotNull(var2);
      this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(var3);
      this.workspace = (Workspace)Preconditions.checkNotNull(var4);
      this.viewData = null;
   }

   private void createSingleFunctionDiffFlowgraphView(Diff var1, FunctionMatchData var2, RawFlowGraph var3, RawFlowGraph var4, RawCombinedFlowGraph var5) {
      GraphsContainer var6 = ViewFlowGraphBuilder.buildViewFlowgraphs(var1, var2, var5);
      RawFunction var7 = var1.getFunction(var2.getIAddress(ESide.PRIMARY), ESide.PRIMARY);
      RawFunction var8 = var1.getFunction(var2.getIAddress(ESide.SECONDARY), ESide.SECONDARY);
      String var9 = var1.getMatchesDatabase().getName();
      var9 = CFileUtils.forceFilenameEndsNotWithExtension(var9, "BinDiff");
      if(!this.workspace.isLoaded() || this.workspace.isLoaded() && var1.getMatchesDatabase().getParent().indexOf(this.workspace.getWorkspaceDirPath()) != 0) {
         var9 = String.format("%s vs %s", new Object[]{var7.getName(), var8.getName()});
      }

      this.viewData = new FlowGraphViewData(var3, var4, var5, var6, var9, EViewType.SINGLE_FUNCTION_DIFF_VIEW);
      var1.getViewManager().addView(this.viewData);
      FunctionDiffViewTabPanel var10 = new FunctionDiffViewTabPanel(this.window, this.tabPanelManager, this.workspace, var1, var2, this.viewData);

      try {
         ViewTabPanelInitializer.initialize(this.viewData.getGraphs(), this);
      } catch (Exception var12) {
         throw new GraphCreationException("An error occurred while initializing the graph.");
      }

      this.tabPanelManager.addTab(var10);
      ViewTabPanelInitializer.centerSingleGraphs(this.viewData.getGraphs().getSuperGraph());
      ViewTabPanelInitializer.centerCombinedGraph(this.viewData.getGraphs(), var10);
      this.tabPanelManager.selectTab(var10);
   }

   protected void runExpensiveCommand() {
      File var1 = new File(this.data.getMatchesDBPath());
      MatchesDatabase var2 = new MatchesDatabase(var1);
      Throwable var3 = null;

      try {
         FunctionDiffMetaData var4 = var2.loadFunctionDiffMetaData(true);
         File var5 = new File(this.data.getFlowgraphsPath(ESide.PRIMARY));
         File var6 = new File(this.data.getFlowgraphsPath(ESide.SECONDARY));
         Diff var7 = this.data.getDiff();
         if(var7 == null) {
            var7 = new Diff(var4, var1, var5, var6, true);
         }

         DiffLoader var8 = new DiffLoader();
         var8.loadDiff(var7, this.data);
         if(var7.getCallgraph(ESide.PRIMARY).getNodes().size() != 1) {
            throw new IllegalStateException("Primary callgraph of a single function diff has more than one vertex.");
         }

         if(var7.getCallgraph(ESide.SECONDARY).getNodes().size() != 1) {
            throw new IllegalStateException("Secondary callgraph of a single function diff has more than one vertex.");
         }

         RawFunction var9 = (RawFunction)var7.getCallgraph(ESide.PRIMARY).getNodes().get(0);
         RawFunction var10 = (RawFunction)var7.getCallgraph(ESide.SECONDARY).getNodes().get(0);
         var9.setSizeOfBasicblocks(var4.getSizeOfBasicblocks(ESide.PRIMARY));
         var10.setSizeOfBasicblocks(var4.getSizeOfBasicblocks(ESide.SECONDARY));
         var9.setSizeOfJumps(var4.getSizeOfJumps(ESide.PRIMARY));
         var10.setSizeOfJumps(var4.getSizeOfJumps(ESide.SECONDARY));
         var9.setSizeOfInstructions(var4.getSizeOfInstructions(ESide.PRIMARY));
         var10.setSizeOfInstructions(var4.getSizeOfInstructions(ESide.SECONDARY));
         IAddress var11 = var9.getAddress();
         IAddress var12 = var10.getAddress();
         var4.setFunctionAddr(var11, ESide.PRIMARY);
         var4.setFunctionAddr(var12, ESide.SECONDARY);
         var4.setFunctionName(var9.getName(), ESide.PRIMARY);
         var4.setFunctionName(var10.getName(), ESide.SECONDARY);
         var4.setFunctionType(var9.getFunctionType(), ESide.PRIMARY);
         var4.setFunctionType(var10.getFunctionType(), ESide.SECONDARY);
         var4.setFlowgraphOffset(this.data.getFlowgraphOffset(ESide.PRIMARY), ESide.PRIMARY);
         var4.setFlowgraphOffset(this.data.getFlowgraphOffset(ESide.SECONDARY), ESide.SECONDARY);
         FunctionMatchData var13 = var7.getMatches().getFunctionMatch(var11, ESide.PRIMARY);
         var2.loadBasicblockMatches(var13);
         CommentsDatabase var14 = null;
         if(this.workspace.isLoaded()) {
            var14 = new CommentsDatabase(this.workspace, true);
         }

         RawFlowGraph var15 = DiffLoader.loadRawFlowgraph(var14, var7, var11, ESide.PRIMARY);
         RawFlowGraph var16 = DiffLoader.loadRawFlowgraph(var14, var7, var12, ESide.SECONDARY);
         RawCombinedFlowGraph var17 = RawCombinedFlowGraphBuilder.buildRawCombinedFlowgraph(var13, var15, var16);
         this.createSingleFunctionDiffFlowgraphView(var7, var13, var15, var16, var17);
      } catch (Throwable var25) {
         var3 = var25;
         throw var25;
      } finally {
         if(var2 != null) {
            if(var3 != null) {
               try {
                  var2.close();
               } catch (Throwable var24) {
                  var3.addSuppressed(var24);
               }
            } else {
               var2.close();
            }
         }

      }

   }
}
