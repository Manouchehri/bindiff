package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.builders.ViewCallGraphBuilder;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelInitializer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.builders.RawCombinedCallGraphBuilder;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCallGraph;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;

public class CallGraphViewLoader extends CEndlessHelperThread {
   private Diff diff;
   private MainWindow window;
   private TabPanelManager tabPanelManager;
   private Workspace workspace;

   public CallGraphViewLoader(Diff var1, MainWindow var2, TabPanelManager var3, Workspace var4) {
      this.diff = (Diff)Preconditions.checkNotNull(var1);
      this.window = (MainWindow)Preconditions.checkNotNull(var2);
      this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(var3);
      this.workspace = (Workspace)Preconditions.checkNotNull(var4);
   }

   private void createCallgraphView(CallGraphViewData var1) {
      Preconditions.checkNotNull(this.tabPanelManager);
      Preconditions.checkNotNull(this.workspace);
      ViewTabPanel var2 = new ViewTabPanel(this.window, this.tabPanelManager, this.workspace, this.diff, var1);
      this.tabPanelManager.addTab(var2);
      this.setDescription("Creating view...");

      try {
         ViewTabPanelInitializer.initialize(var1.getGraphs(), this);
      } catch (Exception var4) {
         throw new GraphCreationException("An error occurred while initializing the graph.");
      }

      this.tabPanelManager.selectTab(var2);
      var1 = null;
   }

   private CallGraphViewData loadCallgraphViewData() {
      RawCallGraph var1 = this.diff.getCallgraph(ESide.PRIMARY);
      RawCallGraph var2 = this.diff.getCallgraph(ESide.SECONDARY);
      this.setDescription("Building raw callgraph...");
      RawCombinedCallGraph var3 = RawCombinedCallGraphBuilder.buildCombinedCallgraph(this.diff.getMatches(), var1, var2);
      this.setDescription("Building view callgraph...");
      GraphsContainer var4 = ViewCallGraphBuilder.buildDiffCallgraphs(this.diff, var3);
      CallGraphViewData var5 = new CallGraphViewData(var1, var2, var4, FlowGraphViewData.getViewName(var4), this.diff.getMetaData().getImageName(ESide.PRIMARY), this.diff.getMetaData().getImageName(ESide.SECONDARY), EViewType.FUNCTION_DIFF_VIEW);
      this.diff.getViewManager().addView(var5);
      return var5;
   }

   protected void runExpensiveCommand() {
      CallGraphViewData var1 = this.loadCallgraphViewData();
      this.createCallgraphView(var1);
      this.diff = null;
      this.tabPanelManager = null;
      this.workspace = null;
   }
}
