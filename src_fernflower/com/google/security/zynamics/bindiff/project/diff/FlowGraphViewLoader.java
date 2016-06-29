package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelInitializer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.builders.RawCombinedFlowGraphBuilder;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class FlowGraphViewLoader extends CEndlessHelperThread {
   private final TabPanelManager tabPanelManager;
   private final MainWindow window;
   private final Workspace workspace;
   private final LinkedHashSet viewsAddrs;

   public FlowGraphViewLoader(MainWindow var1, TabPanelManager var2, Workspace var3, LinkedHashSet var4) {
      this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(var2);
      this.window = (MainWindow)Preconditions.checkNotNull(var1);
      this.workspace = (Workspace)Preconditions.checkNotNull(var3);
      this.viewsAddrs = (LinkedHashSet)Preconditions.checkNotNull(var4);
   }

   private void createFlowgraphView(FlowGraphViewData var1) {
      Diff var2 = var1.getGraphs().getDiff();
      Object var3;
      if(var2.isFunctionDiff()) {
         FunctionMatchData var4 = var2.getMatches().getFunctionMatches()[0];
         var3 = new FunctionDiffViewTabPanel(this.window, this.tabPanelManager, this.workspace, var2, var4, var1);
      } else {
         var3 = new ViewTabPanel(this.window, this.tabPanelManager, this.workspace, var2, var1);
      }

      try {
         ViewTabPanelInitializer.initialize(var1.getGraphs(), this);
      } catch (Exception var5) {
         throw new GraphCreationException("An error occurred while initializing the graph.");
      }

      this.tabPanelManager.addTab((TabPanel)var3);
      ViewTabPanelInitializer.centerSingleGraphs(var1.getGraphs().getSuperGraph());
      ViewTabPanelInitializer.centerCombinedGraph(var1.getGraphs(), (ViewTabPanel)var3);
      this.tabPanelManager.selectTab((TabPanel)var3);
   }

   private FlowGraphViewData loadFlowgraphViewData(Diff var1, IAddress var2, IAddress var3) {
      CommentsDatabase var4 = new CommentsDatabase(this.workspace, true);
      Throwable var5 = null;

      FlowGraphViewData var12;
      try {
         RawFlowGraph var6 = null;
         RawFlowGraph var7 = null;
         FunctionMatchData var8 = this.loadFunctionMatchData(var1, var2, var3);
         if(var2 != null) {
            this.setDescription("Loading primary raw function data...");
            var6 = DiffLoader.loadRawFlowgraph(var4, var1, var2, ESide.PRIMARY);
         }

         if(var3 != null) {
            this.setDescription("Loading secondary raw function data...");
            var7 = DiffLoader.loadRawFlowgraph(var4, var1, var3, ESide.SECONDARY);
         }

         this.setDescription("Building combined flow graph...");
         RawCombinedFlowGraph var9 = RawCombinedFlowGraphBuilder.buildRawCombinedFlowgraph(var8, var6, var7);
         this.setDescription("Creating flow graph view...");
         GraphsContainer var10 = ViewFlowGraphBuilder.buildViewFlowgraphs(var1, var8, var9);
         FlowGraphViewData var11 = new FlowGraphViewData(var6, var7, var9, var10, FlowGraphViewData.getViewName(var10), EViewType.FUNCTION_DIFF_VIEW);
         var1.getViewManager().addView(var11);
         var12 = var11;
      } catch (Throwable var21) {
         var5 = var21;
         throw var21;
      } finally {
         if(var4 != null) {
            if(var5 != null) {
               try {
                  var4.close();
               } catch (Throwable var20) {
                  var5.addSuppressed(var20);
               }
            } else {
               var4.close();
            }
         }

      }

      return var12;
   }

   private FunctionMatchData loadFunctionMatchData(Diff var1, IAddress var2, IAddress var3) {
      // $FF: Couldn't be decompiled
   }

   protected void runExpensiveCommand() {
      Iterator var1 = this.viewsAddrs.iterator();

      while(var1.hasNext()) {
         Triple var2 = (Triple)var1.next();
         FlowGraphViewData var3 = this.loadFlowgraphViewData((Diff)var2.first(), (IAddress)var2.second(), (IAddress)var2.third());
         this.createFlowgraphView(var3);
      }

   }
}
