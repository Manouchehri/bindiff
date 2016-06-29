package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphOverviewPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel$InternalSettingsChangedListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public abstract class GraphPanel extends JPanel {
   public static double COMBINED_MAIN_DIVIDER_WIDTH = 0.15D;
   public static double PRIMARY_MAIN_DIVIDER_WIDTH = 0.3D;
   public static double SECONDRAY_MAIN_DIVIDER_WIDTH = 0.7D;
   public static double OVERVIEW_DIVIDER_HEIGHT = 0.25D;
   public static double NODETREE_DIVIDER_WIDTH = 0.75D;
   private final EGraph graphType;
   private final JSplitPane mainSplitter = new JSplitPane(1);
   private final JSplitPane overviewSplitter = new JSplitPane(0);
   private final JSplitPane treeSplitter = new JSplitPane(0);
   private final JPanel graphPanel = new JPanel(new BorderLayout());
   private final JPanel overviewPanel = new JPanel(new BorderLayout());
   private final JPanel treePanel = new JPanel(new BorderLayout());
   private final GraphNodeTreePanel graphTreePanel;
   private final SelectionHistoryTreePanel selectionHistoryPanel;
   private final BinDiffGraph graph;
   private final ViewData view;
   private final GraphPanel$InternalSettingsChangedListener settingsListener = new GraphPanel$InternalSettingsChangedListener(this, (GraphPanel$1)null);

   public GraphPanel(ViewTabPanelFunctions var1, Diff var2, ViewData var3, BinDiffGraph var4, EGraph var5) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.view = (ViewData)Preconditions.checkNotNull(var3);
      this.graph = (BinDiffGraph)Preconditions.checkNotNull(var4);
      this.graphType = var5;
      this.graphPanel.add(var4.getView(), "Center");
      this.overviewPanel.add(new GraphOverviewPanel(var4.getView()));
      if(var5 == EGraph.PRIMARY_GRAPH) {
         this.graphTreePanel = new GraphNodeTreePanel(var1, var2, var3, (SingleGraph)var4);
      } else if(var5 == EGraph.SECONDARY_GRAPH) {
         this.graphTreePanel = new GraphNodeTreePanel(var1, var2, var3, (SingleGraph)var4);
      } else if(var5 == EGraph.COMBINED_GRAPH) {
         this.graphTreePanel = new GraphNodeTreePanel(var1, var2, var3, (CombinedGraph)var4);
      } else {
         this.graphTreePanel = null;
      }

      this.treePanel.setBorder(new TitledBorder(""));
      this.treePanel.add((Component)(this.graphTreePanel == null?new JPanel():this.graphTreePanel), "Center");
      SelectionHistory var6;
      if(var4 instanceof SingleGraph) {
         var6 = ((SingleGraph)var4).getSelectionHistory();
         this.selectionHistoryPanel = new SelectionHistoryTreePanel(var1, var4, var6);
         this.selectionHistoryPanel.setBorder(new TitledBorder(""));
      } else if(var4 instanceof CombinedGraph) {
         var6 = ((CombinedGraph)var4).getSelectionHistory();
         this.selectionHistoryPanel = new SelectionHistoryTreePanel(var1, var4, var6);
         this.selectionHistoryPanel.setBorder(new TitledBorder(""));
      } else {
         this.selectionHistoryPanel = null;
      }

      var4.getSettings().addListener(this.settingsListener);
      this.createPanel();
   }

   private void createPanel() {
      if(EGraph.PRIMARY_GRAPH != this.graphType && EGraph.COMBINED_GRAPH != this.graphType) {
         this.mainSplitter.setLeftComponent(this.graphPanel);
         this.mainSplitter.setRightComponent(this.overviewSplitter);
      } else {
         this.mainSplitter.setLeftComponent(this.overviewSplitter);
         this.mainSplitter.setRightComponent(this.graphPanel);
      }

      this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.mainSplitter.setContinuousLayout(true);
      this.setFocusBorder(this.graph.getSettings());
      this.overviewSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.treeSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.overviewSplitter.setTopComponent(this.overviewPanel);
      this.overviewSplitter.setBottomComponent(this.treeSplitter);
      this.treeSplitter.setTopComponent(this.treePanel);
      this.treeSplitter.setBottomComponent(this.selectionHistoryPanel);
      this.overviewSplitter.setMinimumSize(new Dimension(0, 0));
      this.overviewSplitter.setOneTouchExpandable(true);
      this.overviewSplitter.setContinuousLayout(true);
      this.overviewSplitter.setDoubleBuffered(true);
      this.treeSplitter.setMinimumSize(new Dimension(0, 0));
      this.treeSplitter.setOneTouchExpandable(true);
      this.treeSplitter.setContinuousLayout(true);
      this.treeSplitter.setDoubleBuffered(true);
      this.mainSplitter.setMinimumSize(new Dimension(0, 0));
      this.mainSplitter.setOneTouchExpandable(true);
      this.mainSplitter.setDoubleBuffered(true);
      this.resetDefaultPerspective();
      this.add(this.mainSplitter, "Center");
   }

   private void setFocusBorder(GraphSettings var1) {
      if(var1.isAsync()) {
         if((var1.getFocus() != ESide.PRIMARY || this.graphType != EGraph.PRIMARY_GRAPH) && (var1.getFocus() != ESide.SECONDARY || this.graphType != EGraph.SECONDARY_GRAPH)) {
            this.setBorder(BorderFactory.createBevelBorder(0));
            LineBorder var2 = new LineBorder(Colors.GRAY64, 1);
            LineBorder var3 = new LineBorder(Colors.GRAY192, 2);
            this.mainSplitter.setBorder(BorderFactory.createCompoundBorder(var3, var2));
         } else {
            this.setBorder(BorderFactory.createBevelBorder(0));
            this.mainSplitter.setBorder(BorderFactory.createLineBorder(Colors.GRAY64, 3));
         }
      } else {
         this.setBorder(new EmptyBorder(0, 0, 0, 0));
         this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
      }

   }

   protected ViewData getView() {
      return this.view;
   }

   public void dispose() {
      this.graph.getSettings().removeListener(this.settingsListener);
      this.graphTreePanel.dispose();
      this.selectionHistoryPanel.dispose();
   }

   public BinDiffGraph getGraph() {
      return this.graph;
   }

   public Dimension getGraphComponentSize() {
      return this.graphType != EGraph.COMBINED_GRAPH && this.graphType != EGraph.PRIMARY_GRAPH?this.mainSplitter.getLeftComponent().getSize():this.mainSplitter.getRightComponent().getSize();
   }

   public int getMainDividerLoction() {
      return this.mainSplitter.getDividerLocation();
   }

   public JSplitPane getMainSplitter() {
      return this.mainSplitter;
   }

   public AbstractGraphNodeTree getTree() {
      return this.graphTreePanel.getTree();
   }

   public void resetDefaultPerspective() {
      if(this.graphType == EGraph.COMBINED_GRAPH) {
         this.mainSplitter.setResizeWeight(COMBINED_MAIN_DIVIDER_WIDTH);
         this.mainSplitter.setDividerLocation(COMBINED_MAIN_DIVIDER_WIDTH);
         this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
      } else if(this.graphType == EGraph.PRIMARY_GRAPH) {
         this.mainSplitter.setResizeWeight(PRIMARY_MAIN_DIVIDER_WIDTH);
         this.mainSplitter.setDividerLocation(PRIMARY_MAIN_DIVIDER_WIDTH);
         this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
      } else {
         this.mainSplitter.setResizeWeight(SECONDRAY_MAIN_DIVIDER_WIDTH);
         this.mainSplitter.setDividerLocation(SECONDRAY_MAIN_DIVIDER_WIDTH);
         this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
      }

      this.treeSplitter.setResizeWeight(NODETREE_DIVIDER_WIDTH);
      this.treeSplitter.setDividerLocation(NODETREE_DIVIDER_WIDTH);
      this.treeSplitter.setLastDividerLocation(this.treeSplitter.getDividerLocation());
      this.overviewSplitter.setResizeWeight(OVERVIEW_DIVIDER_HEIGHT);
      this.overviewSplitter.setDividerLocation(OVERVIEW_DIVIDER_HEIGHT);
      this.overviewSplitter.setLastDividerLocation(this.overviewSplitter.getDividerLocation());
   }

   public void setLastMainDividerPositionAndDefaulResizeWeights(int var1) {
      this.mainSplitter.setDividerLocation(var1);
      if(this.graphType == EGraph.COMBINED_GRAPH) {
         this.mainSplitter.setResizeWeight(COMBINED_MAIN_DIVIDER_WIDTH);
      } else if(this.graphType == EGraph.PRIMARY_GRAPH) {
         this.mainSplitter.setResizeWeight(PRIMARY_MAIN_DIVIDER_WIDTH);
      } else {
         this.mainSplitter.setResizeWeight(SECONDRAY_MAIN_DIVIDER_WIDTH);
      }

   }

   public void setMainDividerLocationAndResizeWeight(double var1) {
      this.mainSplitter.setResizeWeight(var1);
      this.mainSplitter.setDividerLocation(var1);
   }

   public void toggleGraphsPerspective() {
      if(this.graphType != EGraph.PRIMARY_GRAPH && this.graphType != EGraph.COMBINED_GRAPH) {
         if(this.graphType == EGraph.SECONDARY_GRAPH) {
            if((double)this.mainSplitter.getRightComponent().getSize().width == 0.0D) {
               this.mainSplitter.setDividerLocation(this.mainSplitter.getLastDividerLocation());
            } else {
               this.mainSplitter.setDividerLocation(1.0D);
            }
         }
      } else if((double)this.mainSplitter.getDividerLocation() == 0.0D) {
         this.mainSplitter.setDividerLocation(this.mainSplitter.getLastDividerLocation());
      } else {
         this.mainSplitter.setDividerLocation(0.0D);
      }

   }

   // $FF: synthetic method
   static void access$100(GraphPanel var0, GraphSettings var1) {
      var0.setFocusBorder(var1);
   }

   // $FF: synthetic method
   static BinDiffGraph access$200(GraphPanel var0) {
      return var0.graph;
   }
}
