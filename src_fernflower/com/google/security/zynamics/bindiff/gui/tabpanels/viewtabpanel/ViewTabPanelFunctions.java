package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCallGraphBuilder;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchRemover;
import com.google.security.zynamics.bindiff.graph.helpers.GraphColorizer;
import com.google.security.zynamics.bindiff.graph.helpers.GraphSelector;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.graph.listeners.GraphViewsListenerManager;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ProgressDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaFactory;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumExecuter;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ISavableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions$InternalEditableContentListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.io.comments.CommentsWriter;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.FunctionDiffViewSaver;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CColorChooser;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.GraphExporters;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ViewTabPanelFunctions extends TabPanelFunctions {
   private final ListenerProvider listenerProvider = new ListenerProvider();
   private final ViewTabPanelFunctions$InternalEditableContentListener labelEditModeListener = new ViewTabPanelFunctions$InternalEditableContentListener(this, (ViewTabPanelFunctions$1)null);
   private final GraphsContainer graphs;
   private final GraphSettings settings;
   private final GraphViewsListenerManager graphListenerManager;
   private ViewTabPanel viewTabPanel;
   private Color currentColor = null;
   private CriteriaDialog selectByCriteriaDlg = null;
   private GraphSettingsDialog settingsDialog = null;
   private boolean hasChangedMatches = false;
   private boolean hasChangedComments = false;

   public ViewTabPanelFunctions(MainWindow var1, Workspace var2, ViewTabPanel var3, ViewData var4) {
      super(var1, var2);
      this.viewTabPanel = (ViewTabPanel)Preconditions.checkNotNull(var3);
      Preconditions.checkNotNull(var4);
      this.graphs = var4.getGraphs();
      this.settings = this.graphs.getSettings();
      this.graphListenerManager = new GraphViewsListenerManager(this.graphs, this);
      this.graphs.getCombinedGraph().getEditMode().getLabelEventHandler().addEditModeListener(this.labelEditModeListener);
      this.graphs.getPrimaryGraph().getEditMode().getLabelEventHandler().addEditModeListener(this.labelEditModeListener);
      this.graphs.getSecondaryGraph().getEditMode().getLabelEventHandler().addEditModeListener(this.labelEditModeListener);
   }

   public static boolean isNodeSelectionMatchAddable(BinDiffGraph var0, ZyGraphNode var1) {
      return BasicBlockMatchAdder.getAffectedCombinedNodes(var0, var1) != null;
   }

   public static boolean isNodeSelectionMatchDeleteable(BinDiffGraph var0, ZyGraphNode var1) {
      return BasicBlockMatchRemover.getAffectedCombinedNodes(var0, var1) != null;
   }

   private void notifySaveableListener() {
      Iterator var1 = this.listenerProvider.iterator();

      while(var1.hasNext()) {
         ISavableListener var2 = (ISavableListener)var1.next();
         var2.isSavable(this.hasChanged());
      }

   }

   private void setCommentsChanged(boolean var1) {
      this.hasChangedComments = var1;
      this.notifySaveableListener();
   }

   private void setMatchesChanged(boolean var1) {
      this.hasChangedMatches = var1;
      this.notifySaveableListener();
   }

   private boolean showColorChooserDialog() {
      List var1 = GraphColorizer.getRecentColors();
      this.currentColor = CColorChooser.showDialog(this.viewTabPanel, "Color Nodes", Color.WHITE, (Color[])var1.toArray(new Color[0]));
      if(this.currentColor != null) {
         var1.add(this.currentColor);
         GraphColorizer.setRecentColors(var1);
         return true;
      } else {
         return false;
      }
   }

   private void updateFunctionMatchCounts() {
      ViewData var1 = this.viewTabPanel.getView();
      if(var1.isFlowgraphView() || var1.isSingleFunctionDiffView()) {
         Diff var2 = var1.getGraphs().getDiff();
         IAddress var3 = var1.getAddress(ESide.PRIMARY);
         FunctionMatchData var4 = var2.getMatches().getFunctionMatch(var3, ESide.PRIMARY);
         RawFlowGraph var5 = (RawFlowGraph)var1.getRawGraph(ESide.PRIMARY);
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;
         Iterator var9 = var5.getNodes().iterator();

         while(true) {
            RawBasicBlock var10;
            do {
               if(!var9.hasNext()) {
                  var4.setSizeOfMatchedBasicblocks(var6);
                  var4.setSizeOfMatchedJumps(var7);
                  var4.setSizeOfMatchedInstructions(var8);
                  return;
               }

               var10 = (RawBasicBlock)var9.next();
            } while(var10.getMatchState() != EMatchState.MATCHED);

            ++var6;
            Iterator var11 = var10.getOutgoingEdges().iterator();

            while(var11.hasNext()) {
               SingleViewEdge var12 = (SingleViewEdge)var11.next();
               RawJump var13 = (RawJump)var12;
               if(var13.getSource().getMatchState() == EMatchState.MATCHED && var13.getTarget().getMatchState() == EMatchState.MATCHED) {
                  ++var7;
               }
            }

            IAddress var14 = var10.getAddress();
            BasicBlockMatchData var15 = var4.getBasicblockMatch(var14, ESide.PRIMARY);
            var8 += var15.getSizeOfMatchedInstructions();
         }
      }
   }

   public void addListener(ISavableListener var1) {
      this.listenerProvider.addListener(var1);
   }

   public void addNodeMatch(CombinedDiffNode var1, CombinedDiffNode var2) {
      if(var1 != null && var2 != null) {
         if(this.viewTabPanel.getView().isFlowgraphView()) {
            try {
               BasicBlockMatchAdder.addBasicblockMatch(this.graphs, var1, var2);
               this.setMatchesChanged(true);
            } catch (GraphLayoutException var4) {
               Logger.logException(var4, var4.getMessage());
               CMessageBox.showError(this.viewTabPanel, var4.getMessage());
            }
         }

      }
   }

   public boolean closeView(boolean var1) {
      ViewData var2 = this.viewTabPanel.getView();
      if(var1 && this.hasChanged() && !this.saveView()) {
         return false;
      } else {
         Diff var3 = this.viewTabPanel.getDiff();
         var3.getViewManager().removeView(var2);
         this.getMainWindow().getController().getTabPanelManager().removeTab(this.viewTabPanel);
         this.viewTabPanel.dispose();
         this.dispose();
         this.graphs.dispose();
         this.viewTabPanel = null;
         if(var2.isCallgraphView()) {
            var3.getCallgraph(ESide.PRIMARY).resetVisibilityAndSelection();
            var3.getCallgraph(ESide.SECONDARY).resetVisibilityAndSelection();
         }

         Iterator var4 = var3.getListener().iterator();

         while(var4.hasNext()) {
            IDiffListener var5 = (IDiffListener)var4.next();
            var5.closedView(var3);
         }

         return true;
      }
   }

   public void colorInvisibleNodes() {
      if(this.showColorChooserDialog()) {
         Color var1 = this.currentColor;
         if(this.settings.isSync()) {
            GraphColorizer.colorizeInvisibleNodes(this.graphs.getCombinedGraph(), var1);
            GraphColorizer.colorizeInvisibleNodes(this.graphs.getPrimaryGraph(), var1);
            GraphColorizer.colorizeInvisibleNodes(this.graphs.getSecondaryGraph(), var1);
         } else {
            switch(ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1:
               if(this.settings.getFocus() == ESide.PRIMARY) {
                  GraphColorizer.colorizeInvisibleNodes(this.graphs.getPrimaryGraph(), var1);
               } else {
                  GraphColorizer.colorizeInvisibleNodes(this.graphs.getSecondaryGraph(), var1);
               }
               break;
            case 2:
               GraphColorizer.colorizeInvisibleNodes(this.graphs.getCombinedGraph(), var1);
            }
         }
      }

   }

   public void colorSelectedNodes() {
      if(this.showColorChooserDialog()) {
         Color var1 = this.currentColor;
         if(this.settings.isSync()) {
            GraphColorizer.colorizeSelectedNodes(this.graphs.getCombinedGraph(), var1);
            GraphColorizer.colorizeSelectedNodes(this.graphs.getPrimaryGraph(), var1);
            GraphColorizer.colorizeSelectedNodes(this.graphs.getSecondaryGraph(), var1);
         } else {
            switch(ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1:
               if(this.settings.getFocus() == ESide.PRIMARY) {
                  GraphColorizer.colorizeSelectedNodes(this.graphs.getPrimaryGraph(), var1);
               } else {
                  GraphColorizer.colorizeSelectedNodes(this.graphs.getSecondaryGraph(), var1);
               }
               break;
            case 2:
               GraphColorizer.colorizeSelectedNodes(this.graphs.getCombinedGraph(), var1);
            }
         }
      }

   }

   public void colorUnslectedNodes() {
      if(this.showColorChooserDialog()) {
         Color var1 = this.currentColor;
         if(this.settings.isSync()) {
            GraphColorizer.colorizeUnselectedNodes(this.graphs.getCombinedGraph(), var1);
            GraphColorizer.colorizeUnselectedNodes(this.graphs.getPrimaryGraph(), var1);
            GraphColorizer.colorizeUnselectedNodes(this.graphs.getSecondaryGraph(), var1);
         } else {
            switch(ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1:
               if(this.settings.getFocus() == ESide.PRIMARY) {
                  GraphColorizer.colorizeUnselectedNodes(this.graphs.getPrimaryGraph(), var1);
               } else {
                  GraphColorizer.colorizeUnselectedNodes(this.graphs.getSecondaryGraph(), var1);
               }
               break;
            case 2:
               GraphColorizer.colorizeUnselectedNodes(this.graphs.getCombinedGraph(), var1);
            }
         }
      }

   }

   public void deselectLeafs() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.deselectLeafs(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.deselectLeafs(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.deselectLeafs(this.graphs.getCombinedGraph());
      }

   }

   public void deselectPeriphery() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.deselectPeriphery(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.deselectPeriphery(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.deselectPeriphery(this.graphs.getCombinedGraph());
      }

   }

   public void deselectRoots() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.deselectRoots(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.deselectRoots(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.deselectRoots(this.graphs.getCombinedGraph());
      }

   }

   public void dispose() {
      this.graphListenerManager.dispose();
      CDefaultLabelEventHandler var1 = this.graphs.getPrimaryGraph().getEditMode().getLabelEventHandler();
      CDefaultLabelEventHandler var2 = this.graphs.getSecondaryGraph().getEditMode().getLabelEventHandler();
      CDefaultLabelEventHandler var3 = this.graphs.getCombinedGraph().getEditMode().getLabelEventHandler();
      if(var3 != null) {
         var3.removeEditModeListener(this.labelEditModeListener);
      }

      if(var1 != null) {
         var1.removeEditModeListener(this.labelEditModeListener);
      }

      if(var2 != null) {
         var2.removeEditModeListener(this.labelEditModeListener);
      }

      if(this.selectByCriteriaDlg != null) {
         this.selectByCriteriaDlg.dispose();
         this.selectByCriteriaDlg = null;
      }

   }

   public void doLayout(EGraphLayout var1) {
      Object var2 = this.graphs.getCombinedGraph();
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            var2 = this.graphs.getPrimaryGraph();
         } else {
            var2 = this.graphs.getSecondaryGraph();
         }
      }

      if(var2 != null) {
         switch(ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[var1.ordinal()]) {
         case 1:
            ((BinDiffGraph)var2).getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.CIRCULAR);
            break;
         case 2:
            ((BinDiffGraph)var2).getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.HIERARCHICAL);
            break;
         case 3:
            ((BinDiffGraph)var2).getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.ORTHOGONAL);
         }

         this.graphListenerManager.suppressUpdating(true);
         GraphLayoutEventHandler.handleDoLayoutButtonEvent((BinDiffGraph)var2, true);
         this.graphListenerManager.suppressUpdating(false);
      }

   }

   public void exportViewAsImage() {
      MainWindow var1 = this.getMainWindow();
      ExportViewDialog var2 = new ExportViewDialog(var1, "Export View as Image", "", new File(this.graphs.getDiff().getDiffFolder()), this.viewTabPanel.getView().getViewName().toString());
      var2.setVisible(true);
      if(var2.isOkPressed()) {
         try {
            if(var2.isCapturePart()) {
               if(var2.isPNG()) {
                  GraphExporters.exportPartAsPNG(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
                  GraphExporters.exportPartAsPNG(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
                  GraphExporters.exportPartAsPNG(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
               } else if(var2.isJPEG()) {
                  GraphExporters.exportPartAsJPEG(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
                  GraphExporters.exportPartAsJPEG(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
                  GraphExporters.exportPartAsJPEG(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
               } else if(var2.isGIF()) {
                  GraphExporters.exportPartAsGIF(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
                  GraphExporters.exportPartAsGIF(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
                  GraphExporters.exportPartAsGIF(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
               } else if(var2.isSVG()) {
                  GraphExporters.exportPartAsSVG(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
                  GraphExporters.exportPartAsSVG(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
                  GraphExporters.exportPartAsSVG(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
               }
            } else if(var2.isPNG()) {
               GraphExporters.exportAllAsPNG(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
               GraphExporters.exportAllAsPNG(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
               GraphExporters.exportAllAsPNG(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
            } else if(var2.isJPEG()) {
               GraphExporters.exportAllAsJPEG(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
               GraphExporters.exportAllAsJPEG(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
               GraphExporters.exportAllAsJPEG(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
            } else if(var2.isGIF()) {
               GraphExporters.exportAllAsGIF(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
               GraphExporters.exportAllAsGIF(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
               GraphExporters.exportAllAsGIF(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
            } else if(var2.isSVG()) {
               GraphExporters.exportAllAsSVG(this.getGraphs().getPrimaryGraph(), var2.getPrimaryImageFile().getPath());
               GraphExporters.exportAllAsSVG(this.getGraphs().getSecondaryGraph(), var2.getSecondaryImageFile().getPath());
               GraphExporters.exportAllAsSVG(this.getGraphs().getCombinedGraph(), var2.getCombinedImageFile().getPath());
            }
         } catch (Exception var4) {
            Logger.logException(var4, "Couldn\'t save exported view images.");
            CMessageBox.showError(var1, "Couldn\'t save exported view images.");
         }
      }

   }

   public void fitGraphContentToView() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         GraphZoomer.fitContent((BinDiffGraph)this.graphs.getCombinedGraph());
      } else if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         GraphZoomer.fitContent(this.graphs.getSuperGraph());
      }

   }

   public void fitGraphs() {
      Dimension var1 = this.viewTabPanel.getNormalViewPanel().getSize();
      long var2 = Math.round((double)var1.width * (1.0D - GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH - 0.06D));
      long var4 = Math.round(var1.getHeight());
      this.graphs.getCombinedGraph().getView().setSize((int)var2, (int)var4);
      GraphViewFitter.fitSingleViewToSuperViewContent(this.graphs.getSuperGraph());
      this.graphs.getCombinedGraph().getGraph().U();
      this.graphs.getCombinedGraph().getView().setZoom(this.graphs.getCombinedGraph().getView().getZoom() * 0.9D);
      this.graphs.getCombinedGraph().getGraph().T();
      this.graphs.getPrimaryGraph().getGraph().T();
      this.graphs.getSecondaryGraph().getGraph().T();
   }

   public JPanel getCurrentViewPanel() {
      switch(ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
      case 1:
         return this.viewTabPanel.getNormalViewPanel();
      case 2:
         return this.viewTabPanel.getCombinedViewPanel();
      default:
         throw new IllegalStateException("Unknown view mode.");
      }
   }

   public GraphViewsListenerManager getGraphListenerManager() {
      return this.graphListenerManager;
   }

   public GraphsContainer getGraphs() {
      return this.graphs;
   }

   public GraphSettings getGraphSettings() {
      return this.settings;
   }

   public TabPanelManager getTabPanelManager() {
      return this.viewTabPanel.getTabPanelManager();
   }

   public ViewTabPanel getViewTabPanel() {
      return this.viewTabPanel;
   }

   public boolean hasChanged() {
      return this.hasChangedMatches || this.hasChangedComments;
   }

   public void invertSelection() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.invertSelection(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.invertSelection(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.invertSelection(this.graphs.getCombinedGraph());
      }

   }

   public void openFlowgraphsViews(ZyGraphNode var1) {
      WorkspaceTabPanel var2 = this.viewTabPanel.getTabPanelManager().getWorkspaceTabPanel();
      WorkspaceTabPanelFunctions var3 = var2.getController();
      Diff var4 = this.getGraphs().getDiff();
      IAddress var5;
      IAddress var6;
      if(var1 instanceof SingleDiffNode) {
         RawFunction var7 = (RawFunction)var1.getRawNode();
         RawFunction var8;
         if(var7.getSide() == ESide.PRIMARY) {
            var8 = var7.getMatchedFunction();
            var5 = var7.getAddress();
            var6 = var8 == null?null:var8.getAddress();
         } else {
            var8 = var7.getMatchedFunction();
            var5 = var8 == null?null:var8.getAddress();
            var6 = var7.getAddress();
         }
      } else {
         if(!(var1 instanceof CombinedDiffNode)) {
            return;
         }

         RawCombinedFunction var9 = (RawCombinedFunction)var1.getRawNode();
         var5 = var9.getAddress(ESide.PRIMARY);
         var6 = var9.getAddress(ESide.SECONDARY);
      }

      var3.openFlowgraphView(this.getMainWindow(), var4, var5, var6);
   }

   public void printView(BinDiffGraph var1) {
      new PrintGraphPreviewDialog(this.getMainWindow(), var1.getView());
   }

   public void redoSelection() {
      this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(false);
      this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(false);
      this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(false);
      this.graphs.getPrimaryGraph().getSelectionHistory().redo();
      this.graphs.getSecondaryGraph().getSelectionHistory().redo();
      this.graphs.getCombinedGraph().getSelectionHistory().redo();
      this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(true);
      this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(true);
      this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(true);
   }

   public void removeListener(ISavableListener var1) {
      this.listenerProvider.removeListener(var1);
   }

   public void removeNodeMatch(List var1) {
      if(var1 != null) {
         if(this.viewTabPanel.getView().isFlowgraphView()) {
            try {
               Iterator var2 = var1.iterator();

               while(var2.hasNext()) {
                  CombinedDiffNode var3 = (CombinedDiffNode)var2.next();
                  BasicBlockMatchRemover.removeBasicblockMatch(this.graphs, var3);
                  this.setMatchesChanged(true);
               }
            } catch (GraphLayoutException var4) {
               Logger.logException(var4, var4.getMessage());
               CMessageBox.showError(this.viewTabPanel, var4.getMessage());
            } catch (Exception var5) {
               Logger.logException(var5, var5.getMessage());
               CMessageBox.showError(this.viewTabPanel, var5.getMessage());
            }
         }

      }
   }

   public void resetDefaultPerspective() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         this.viewTabPanel.getNormalViewPanel().resetDefaultPerspective();
      } else if(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         this.viewTabPanel.getCombinedViewPanel().resetDefaultPerspective();
      }

   }

   public boolean saveView() {
      Diff var1 = this.graphs.getDiff();
      if(var1.isFunctionDiff()) {
         try {
            SaveFunctionDiffViewDialog var2 = new SaveFunctionDiffViewDialog(this.getMainWindow(), "Save Function Diff View", this.getWorkspace(), var1);
            var2.setVisible(true);
            if(!var2.isOkPressed()) {
               return false;
            }

            this.updateFunctionMatchCounts();
            FunctionDiffViewSaver var3 = new FunctionDiffViewSaver(this, var2.getExportBinaryTargetFile(ESide.PRIMARY), var2.getExportBinaryTargetFile(ESide.SECONDARY), var2.getMatchesDatabaseTargetFile(), var2.isOverrideExportBinary(ESide.PRIMARY), var2.isOverrideExportBinary(ESide.SECONDARY));
            ProgressDialog.show(this.getMainWindow(), "Saving View...", (CEndlessHelperThread)var3);
            TabPanelManager var4 = this.viewTabPanel.getTabPanelManager();
            var4.updateSelectedTabTitel(var2.getFunctionDiffName());
            var4.udpateSelectedTabIcon();
            this.getMainWindow().updateTitle(this.getWorkspace(), this.viewTabPanel);
         } catch (Exception var5) {
            Logger.logException(var5, "Save function diff view failed.");
            CMessageBox.showError(this.getMainWindow(), "Save function diff view failed.");
            return false;
         }
      } else {
         this.updateFunctionMatchCounts();
         this.writeComments();
         this.writeFlowgraphMatches();
      }

      this.setMatchesChanged(false);
      this.setCommentsChanged(false);
      return true;
   }

   public void selectAncestors() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.selectAncestorsOfSelection(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.selectAncestorsOfSelection(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.selectAncestorsOfSelection(this.graphs.getCombinedGraph());
      }

   }

   public void selectByCriteria() {
      if(this.selectByCriteriaDlg == null) {
         CriteriaFactory var1 = new CriteriaFactory(this.graphs);
         this.selectByCriteriaDlg = new CriteriaDialog(SwingUtilities.getWindowAncestor(this.viewTabPanel), var1);
      }

      this.selectByCriteriaDlg.setVisible(true);
      this.selectByCriteriaDlg.setVisible(false);
      HashSet var17 = new HashSet();
      CriteriumTree var2 = this.selectByCriteriaDlg.getCriteriumTree();
      ArrayList var3;
      ArrayList var4;
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         if(this.settings.isSync()) {
            var3 = new ArrayList();
            var4 = new ArrayList();
            ArrayList var5 = new ArrayList();
            ArrayList var6 = new ArrayList();
            ArrayList var7 = new ArrayList();
            ArrayList var8 = new ArrayList();
            ArrayList var9 = new ArrayList();
            ArrayList var10 = new ArrayList();
            if(this.selectByCriteriaDlg.doSelectNodes()) {
               var17.addAll(CriteriumExecuter.execute(var2, this.graphs.getPrimaryGraph()));
               var17.addAll(CriteriumExecuter.execute(var2, this.graphs.getSecondaryGraph()));
               Iterator var11 = this.graphs.getSuperGraph().getNodes().iterator();

               while(var11.hasNext()) {
                  SuperDiffNode var12 = (SuperDiffNode)var11.next();
                  SingleDiffNode var13 = var12.getPrimaryDiffNode();
                  SingleDiffNode var14 = var12.getSecondaryDiffNode();
                  CombinedDiffNode var15 = var12.getCombinedDiffNode();
                  boolean var16 = var13 != null && var17.contains(var13) || var14 != null && var17.contains(var14);
                  if(var16) {
                     if(var13 != null) {
                        var7.add(var13);
                     }

                     if(var14 != null) {
                        var9.add(var14);
                     }

                     var3.add(var15);
                     var5.add(var12);
                  } else {
                     if(var13 != null) {
                        var8.add(var13);
                     }

                     if(var14 != null) {
                        var10.add(var14);
                     }

                     var4.add(var15);
                     var6.add(var12);
                  }
               }

               boolean var21 = this.settings.getLayoutSettings().getAutomaticLayouting();
               this.settings.getLayoutSettings().setAutomaticLayouting(false);
               this.graphs.getPrimaryGraph().selectNodes(var7, var8);
               this.graphs.getSecondaryGraph().selectNodes(var9, var10);
               this.graphs.getCombinedGraph().selectNodes(var3, var4);
               this.graphs.getSuperGraph().selectNodes(var5, var6);
               this.settings.getLayoutSettings().setAutomaticLayouting(var21);
            }
         } else if(this.settings.getFocus() == ESide.PRIMARY) {
            if(this.selectByCriteriaDlg.doSelectNodes()) {
               var17.addAll(CriteriumExecuter.execute(var2, this.graphs.getPrimaryGraph()));
            }
         } else if(this.selectByCriteriaDlg.doSelectNodes()) {
            var17.addAll(CriteriumExecuter.execute(var2, this.graphs.getSecondaryGraph()));
         }
      } else if(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         if(this.selectByCriteriaDlg.doSelectNodes()) {
            var17.addAll(CriteriumExecuter.execute(var2, this.graphs.getCombinedGraph()));
         }

         var3 = new ArrayList();
         var4 = new ArrayList();
         Iterator var18 = this.graphs.getSuperGraph().getNodes().iterator();

         while(var18.hasNext()) {
            SuperDiffNode var19 = (SuperDiffNode)var18.next();
            CombinedDiffNode var20 = var19.getCombinedDiffNode();
            if(var17.contains(var20)) {
               var3.add(var20);
            } else {
               var4.add(var20);
            }
         }

         this.graphs.getCombinedGraph().selectNodes(var3, var4);
      }

   }

   public void selectChildren() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.selectChildrenOfSelection(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.selectChildrenOfSelection(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.selectChildrenOfSelection(this.graphs.getCombinedGraph());
      }

   }

   public void selectNeighbours() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.selectNeighboursOfSelection(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.selectNeighboursOfSelection(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.selectNeighboursOfSelection(this.graphs.getCombinedGraph());
      }

   }

   public void selectParents() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.selectParentsOfSelection(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.selectParentsOfSelection(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.selectParentsOfSelection(this.graphs.getCombinedGraph());
      }

   }

   public void selectSuccessors() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
         if(this.settings.getFocus() == ESide.PRIMARY) {
            GraphSelector.selectSuccessorsOfSelection(this.graphs.getPrimaryGraph());
         } else {
            GraphSelector.selectSuccessorsOfSelection(this.graphs.getSecondaryGraph());
         }
      } else {
         GraphSelector.selectSuccessorsOfSelection(this.graphs.getCombinedGraph());
      }

   }

   public void setCaretIntoJumpToAddressField(ESide var1) {
      this.viewTabPanel.getToolbar().setCaretIntoJumpToAddressField(var1);
   }

   public void setCaretIntoSearchField() {
      this.viewTabPanel.getToolbar().setCaretIntoSearchField();
   }

   public void setDefaultNodeColors() {
      Diff var1 = this.graphs.getDiff();
      CombinedGraph var2 = this.graphs.getCombinedGraph();
      Iterator var3;
      CombinedDiffNode var4;
      if(var2.getGraphType() == EGraphType.CALLGRAPH) {
         var3 = var2.getNodes().iterator();

         while(var3.hasNext()) {
            var4 = (CombinedDiffNode)var3.next();
            ViewCallGraphBuilder.colorizeFunctions((RawCombinedFunction)var4.getRawNode());
         }
      } else {
         var3 = var2.getNodes().iterator();

         while(var3.hasNext()) {
            var4 = (CombinedDiffNode)var3.next();
            FunctionMatchData var5 = null;
            RawCombinedBasicBlock var6 = (RawCombinedBasicBlock)var4.getRawNode();
            IAddress var7 = var6.getPrimaryFunctionAddress();
            var5 = var1.getMatches().getFunctionMatch(var7, ESide.PRIMARY);
            ViewFlowGraphBuilder.colorizeBasicblocks(var5, var6);
         }
      }

   }

   public void setViewFocus(ESide var1) {
      this.settings.setFocusSide(var1);
   }

   public void showGraphSettingDialog() {
      if(this.settingsDialog == null) {
         this.settingsDialog = new GraphSettingsDialog(this.getMainWindow(), this.getGraphSettings());
      }

      this.settingsDialog.setVisible(true);
   }

   public void showSearchResultsDialog() {
      ViewToolbarPanel var1 = this.viewTabPanel.getToolbar();
      var1.getSearchResultsDialog().setVisible(true);
   }

   public void switchViewPanel(EDiffViewMode var1) {
      JPanel var2 = this.getCurrentViewPanel();
      this.viewTabPanel.remove(var2);
      this.settings.setDiffViewMode(var1);
      this.viewTabPanel.add(this.getCurrentViewPanel(), "Center");
      this.viewTabPanel.updateUI();
   }

   public void toggleAutoamticLayout() {
      this.settings.getLayoutSettings().setAutomaticLayouting(!this.settings.getLayoutSettings().getAutomaticLayouting());
   }

   public void toggleGraphsPerspective() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         this.viewTabPanel.getNormalViewPanel().toggleGraphsPerspective();
      } else if(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         this.viewTabPanel.getCombinedViewPanel().toggleGraphsPerspective();
      }

   }

   public void toggleGraphSynchronization() {
      if(EGraphSynchronization.SYNC == this.settings.getGraphSyncMode()) {
         this.settings.setGraphSyncMode(EGraphSynchronization.ASYNC);
      } else {
         this.settings.setGraphSyncMode(EGraphSynchronization.SYNC);
         GraphLayoutEventHandler.handleReactivateViewSynchronization(this.graphs.getCombinedGraph());
      }

   }

   public void togglePrimaryPerspective() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         this.viewTabPanel.getNormalViewPanel().togglePrimaryPerspective();
      }

   }

   public void toggleProximityBrowsing() {
      Object var1 = this.graphs.getCombinedGraph();
      if(this.settings.isAsync() && this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         var1 = this.settings.getFocus() == ESide.PRIMARY?this.graphs.getPrimaryGraph():this.graphs.getSecondaryGraph();
      }

      if(!this.settings.getProximitySettings().getProximityBrowsing()) {
         GraphLayoutEventHandler.handleProximityBrowsingActivatedEvent((BinDiffGraph)var1);
      } else {
         GraphLayoutEventHandler.handleProximityBrowsingDeactivatedEvent((BinDiffGraph)var1);
      }

   }

   public void toggleProximityBrowsingFrozen() {
      GraphProximityBrowsingSettings var1 = this.settings.getProximitySettings();
      var1.setProximityBrowsingFrozen(!var1.getProximityBrowsingFrozen());
      if(var1.getProximityBrowsing() && !var1.getProximityBrowsingFrozen()) {
         Object var2 = this.graphs.getCombinedGraph();
         if(this.settings.isAsync() && this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            var2 = this.settings.getFocus() == ESide.PRIMARY?this.graphs.getPrimaryGraph():this.graphs.getSecondaryGraph();
         }

         GraphLayoutEventHandler.handleSelectionChangedEvent((BinDiffGraph)var2, true);
      }

   }

   public void toggleSecondaryPerspective() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         this.viewTabPanel.getNormalViewPanel().toggleSecondaryPerspective();
      }

   }

   public void undoSelection() {
      this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(false);
      this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(false);
      this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(false);
      this.graphs.getPrimaryGraph().getSelectionHistory().undo();
      this.graphs.getSecondaryGraph().getSelectionHistory().undo();
      this.graphs.getCombinedGraph().getSelectionHistory().undo();
      this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(true);
      this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(true);
      this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(true);
   }

   public void writeComments() {
      // $FF: Couldn't be decompiled
   }

   public void writeFlowgraphMatches() {
      // $FF: Couldn't be decompiled
   }

   public void zoom(boolean var1) {
      Object var2 = this.graphs.getCombinedGraph();
      if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         var2 = this.graphs.getPrimaryGraph();
         if(!this.settings.isSync() && this.settings.getFocus() == ESide.SECONDARY) {
            var2 = this.graphs.getSecondaryGraph();
         }
      }

      if(var1) {
         ((BinDiffGraph)var2).zoomIn();
      } else {
         ((BinDiffGraph)var2).zoomOut();
      }

   }

   public void zoomToSelectedNodes() {
      if(this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
         GraphZoomer.zoomToNodes((CombinedGraph)this.graphs.getCombinedGraph(), this.graphs.getCombinedGraph().getSelectedNodes());
      } else if(this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         GraphZoomer.zoomToNodes((SuperGraph)this.graphs.getSuperGraph(), this.graphs.getSuperGraph().getSelectedNodes());
      }

   }

   // $FF: synthetic method
   static void access$100(ViewTabPanelFunctions var0, boolean var1) {
      var0.setCommentsChanged(var1);
   }
}
