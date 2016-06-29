package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.InternalEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphMappings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphSelectionObserver;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.LayoutFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping.GroupHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import java.awt.Cursor;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.o;
import y.c.q;
import y.f.aa;
import y.h.bu;
import y.h.cf;
import y.h.ch;
import y.h.a.s;
import y.h.a.u;
import y.h.a.v;

public abstract class AbstractZyGraph implements IEdgeIterableGraph, IIterableGraph {
   private static final double STANDARD_ZOOM_FACTOR = 0.8D;
   private final ListenerProvider m_graphListeners = new ListenerProvider();
   private final ListenerProvider m_visibilityListener = new ListenerProvider();
   private final AbstractZyGraphSettings m_settings;
   private ZyDefaultProximityBrowser m_proximityBrowser;
   private final bu m_graph;
   private final ZyGraph2DView m_view;
   private final ZyEditMode m_editMode;
   private final ZyGraphSelectionObserver m_selectionObserver = new ZyGraphSelectionObserver();
   private final ZyGraphMappings m_mappings;
   private InternalEditModeListener m_editModeListener;
   private final CGraphSettingsSynchronizer m_settingsSynchronizer;

   protected AbstractZyGraph(ZyGraph2DView var1, LinkedHashMap var2, LinkedHashMap var3, AbstractZyGraphSettings var4) {
      this.m_view = (ZyGraph2DView)Preconditions.checkNotNull(var1, "Error: View argument can\'t be null");
      Preconditions.checkNotNull(var2, "Error: Node map argument can\'t be null");
      this.m_graph = this.m_view.getGraph2D();
      this.m_view.setGraph2DRenderer(new ZyGraphLayeredRenderer(this.m_view));
      this.m_settings = var4;
      this.m_mappings = new ZyGraphMappings(this.m_graph, var2, var3);
      this.setProximityBrowser(new ZyDefaultProximityBrowser(this, this.m_settings));
      this.m_editMode = this.createEditMode();
      this.m_settingsSynchronizer = new CGraphSettingsSynchronizer(this.m_editMode, this.m_settings);
      this.initializeListeners();
      this.initializeView();
      this.setupHierarchyManager();
   }

   private void initializeListeners() {
      this.m_graph.a((cf)this.m_selectionObserver);
      this.m_graph.a((o)this.m_selectionObserver);
   }

   private void initializeView() {
      this.getView().addViewMode(this.m_editMode);
      this.m_editModeListener = new InternalEditModeListener(this.m_graphListeners);
      this.m_editMode.addListener(this.m_editModeListener);
      this.getView().setAntialiasedPainting(true);
   }

   private void notifyVisibilityListeners() {
      Iterator var1 = this.m_visibilityListener.iterator();

      while(var1.hasNext()) {
         IZyGraphVisibilityListener var2 = (IZyGraphVisibilityListener)var1.next();

         try {
            var2.visibilityChanged();
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   private void setupHierarchyManager() {
      if(this.m_graph.C() == null) {
         v var1 = new v(this.m_graph);
         this.m_graph.a(var1);
         var1.a((u)(new s()));
      }

   }

   private void showNeighbors(Collection var1) {
      Set var2 = ProximityRangeCalculator.getNeighbors(this, var1, this.getSettings().getProximitySettings().getProximityBrowsingChildren(), this.getSettings().getProximitySettings().getProximityBrowsingParents());
      this.showNodesInternal(var2);
   }

   private void showNodesInternal(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         Preconditions.checkNotNull(var3, "Error: The list of nodes to show contained an invalid node");
         if(!var3.getRawNode().isVisible()) {
            var3.getRawNode().setVisible(true);
         }
      }

   }

   private Collection sortLayers(Collection var1) {
      ArrayList var2 = new ArrayList(var1);
      Collections.sort(var2, new AbstractZyGraph$1(this));
      return var2;
   }

   protected ZyEditMode createEditMode() {
      return new ZyEditMode(this);
   }

   protected void notifyDeletionListeners() {
      Iterator var1 = this.m_visibilityListener.iterator();

      while(var1.hasNext()) {
         IZyGraphVisibilityListener var2 = (IZyGraphVisibilityListener)var1.next();

         try {
            var2.nodeDeleted();
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   protected void removeNode(ZyGraphNode var1) {
      if(var1.getNode().e() == null) {
         this.m_graph.b((q)var1.getNode());
      }

      v var2 = this.m_graph.C();
      q var3 = var1.getNode();
      if(var2.l(var3)) {
         this.m_graph.a((q)var1.getNode());
      } else if(this.getGraph().C().j(var1.getNode())) {
         GroupHelpers.extractFolder(this.m_graph, var1.getNode());
         this.m_graph.a((q)var1.getNode());
      } else if(this.getGraph().C().k(var1.getNode())) {
         GroupHelpers.extractGroup(this.m_graph, var1.getNode());
         this.m_graph.a((q)var1.getNode());
      }

      this.m_mappings.removeNode(var1);
   }

   public void addListener(IZyGraphListener var1) {
      this.m_graphListeners.addListener(var1);
   }

   public void addListener(IZyGraphSelectionListener var1) {
      this.m_selectionObserver.addListener(var1);
   }

   public void addListener(IZyGraphVisibilityListener var1) {
      this.m_visibilityListener.addListener(var1);
   }

   public void dispose() {
      this.m_settingsSynchronizer.dispose();
   }

   public void doLayout() {
      LayoutFunctions.doLayout(this, this.m_settings.getLayoutSettings().getCurrentLayouter());
   }

   public ZyGraphEdge getEdge(d var1) {
      return this.m_mappings.getEdge(var1);
   }

   public ZyGraphEdge getEdge(Object var1) {
      return this.m_mappings.getEdge(var1);
   }

   public Collection getEdges() {
      return this.getMappings().getEdges();
   }

   public ZyEditMode getEditMode() {
      return this.m_editMode;
   }

   public bu getGraph() {
      return this.m_graph;
   }

   public void updateGraphViews() {
      this.m_graph.T();
   }

   public int getEdgeCount() {
      return this.m_graph.h();
   }

   public ZyGraphMappings getMappings() {
      return this.m_mappings;
   }

   public ZyGraphNode getNode(q var1) {
      return this.m_mappings.getNode(var1);
   }

   public ZyGraphNode getNode(Object var1) {
      return this.m_mappings.getNode(var1);
   }

   public Collection getNodes() {
      return this.getMappings().getNodes();
   }

   public ZyDefaultProximityBrowser getProximityBrowser() {
      return this.m_proximityBrowser;
   }

   public abstract Set getSelectedNodes();

   public AbstractZyGraphSettings getSettings() {
      return this.m_settings;
   }

   public ch getView() {
      return this.m_view;
   }

   public Cursor getViewCursor() {
      return this.m_view.getCursor();
   }

   public void removeViewFocusListener(FocusListener var1) {
      this.m_view.removeFocusListener(var1);
   }

   public void addViewFocusListener(FocusListener var1) {
      this.m_view.addFocusListener(var1);
   }

   public void setViewCursor(Cursor var1) {
      this.m_view.setCursor(var1);
   }

   public void addViewCanvasKeyListener(CDefaultLabelEventHandler var1) {
      this.m_view.getCanvasComponent().addKeyListener(var1);
   }

   public void removeViewCanvasKeyListener(CDefaultLabelEventHandler var1) {
      this.m_view.getCanvasComponent().removeKeyListener(var1);
   }

   public d getYEdge(Object var1) {
      return this.m_mappings.getYEdge(var1);
   }

   public q getYNode(Object var1) {
      return this.m_mappings.getYNode(var1);
   }

   public void iterate(INodeCallback var1) {
      Preconditions.checkNotNull(var1, "Callback argument can\'t be null");
      Iterator var2 = this.m_mappings.getNodes().iterator();

      ZyGraphNode var3;
      do {
         if(!var2.hasNext()) {
            return;
         }

         var3 = (ZyGraphNode)var2.next();
      } while(var1.next(var3) != IterationMode.STOP);

   }

   public void iterateEdges(IEdgeCallback var1) {
      Preconditions.checkNotNull(var1, "Callback argument can\'t be null");
      Iterator var2 = this.m_mappings.getEdges().iterator();

      ZyGraphEdge var3;
      do {
         if(!var2.hasNext()) {
            return;
         }

         var3 = (ZyGraphEdge)var2.next();
      } while(var1.nextEdge(var3) != IterationMode.STOP);

   }

   public void removeListener(IZyGraphListener var1) {
      this.m_graphListeners.removeListener(var1);
   }

   public void removeListener(IZyGraphSelectionListener var1) {
      this.m_selectionObserver.removeListener(var1);
   }

   public void removeListener(IZyGraphVisibilityListener var1) {
      this.m_visibilityListener.removeListener(var1);
   }

   public void saveGraphAsGML(File var1) {
      aa var2 = new aa(this.m_graph);
      String var3 = var1.getPath();
      if(var3.toLowerCase().endsWith(".gml")) {
         var3 = String.valueOf(var3).concat(".gml");
      }

      var2.a(var3);
   }

   public void selectNode(ZyGraphNode var1, boolean var2) {
      Preconditions.checkNotNull(var1, "Node argument can\'t be null");
      this.m_graph.r();
      var1.getRawNode().setSelected(var2);
      this.m_graph.s();
   }

   public void selectNodes(Collection var1, boolean var2) {
      Preconditions.checkNotNull(var1, "Nodes argument can\'t be null");
      this.m_graph.r();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ZyGraphNode var4 = (ZyGraphNode)var3.next();
         Preconditions.checkNotNull(var4, "Error: The list of nodes to select contained an invalid node.");
         var4.getRawNode().setSelected(var2);
      }

      this.m_graph.s();
   }

   public void selectNodes(Collection var1, Collection var2) {
      this.m_graph.r();
      Iterator var3 = var1.iterator();

      ZyGraphNode var4;
      while(var3.hasNext()) {
         var4 = (ZyGraphNode)var3.next();
         Preconditions.checkNotNull(var4, "Error: The list of nodes to select contained an invalid node");
         var4.getRawNode().setSelected(true);
      }

      var3 = var2.iterator();

      while(var3.hasNext()) {
         var4 = (ZyGraphNode)var3.next();
         Preconditions.checkNotNull(var4, "Error: The list of nodes to unselect contained an invalid node");
         var4.getRawNode().setSelected(false);
      }

      this.m_graph.s();
   }

   public void setProximityBrowser(ZyDefaultProximityBrowser var1) {
      if(this.m_proximityBrowser != null) {
         this.m_proximityBrowser.dispose();
      }

      this.m_proximityBrowser = var1;
   }

   public void showNode(ZyGraphNode var1, boolean var2) {
      Preconditions.checkNotNull(var1, "Node argument can\'t be null");
      var1.getRawNode().setVisible(var2);
      if(var2) {
         ArrayList var3 = Lists.newArrayList((Object[])(new ZyGraphNode[]{var1}));
         this.showNeighbors(var3);
      }

      this.notifyVisibilityListeners();
   }

   public void showNodes(Collection var1, boolean var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ZyGraphNode var4 = (ZyGraphNode)var3.next();
         Preconditions.checkNotNull(var4, "The list of nodes to show contained an invalid node");
         var4.getRawNode().setVisible(true);
      }

      if(var2) {
         this.showNeighbors(var1);
      }

      this.notifyVisibilityListeners();
   }

   public void showNodes(Collection var1, Collection var2) {
      IProximitySettings var3 = this.getSettings().getProximitySettings();
      Set var4 = ProximityRangeCalculator.getNeighbors(this, var1, var3.getProximityBrowsingChildren(), var3.getProximityBrowsingParents());
      var2.removeAll(var4);
      Iterator var5 = this.sortLayers(var2).iterator();

      while(var5.hasNext()) {
         ZyGraphNode var6 = (ZyGraphNode)var5.next();
         Preconditions.checkNotNull(var6, "Error: The list of nodes to hide contained an invalid node");
         var6.getRawNode().setVisible(false);
      }

      this.showNeighbors(var1);
      this.notifyVisibilityListeners();
   }

   public void showNodes(Collection var1, Collection var2, boolean var3) {
      if(var3) {
         IProximitySettings var4 = this.getSettings().getProximitySettings();
         Set var5 = ProximityRangeCalculator.getNeighbors(this, var1, var4.getProximityBrowsingChildren(), var4.getProximityBrowsingParents());
         var2.removeAll(var5);
      }

      Iterator var6 = this.sortLayers(var2).iterator();

      ZyGraphNode var7;
      while(var6.hasNext()) {
         var7 = (ZyGraphNode)var6.next();
         Preconditions.checkNotNull(var7, "Error: The list of nodes to hide contained an invalid node");
         var7.getRawNode().setVisible(false);
      }

      if(var3) {
         this.showNeighbors(var1);
      } else {
         var6 = var1.iterator();

         while(var6.hasNext()) {
            var7 = (ZyGraphNode)var6.next();
            Preconditions.checkNotNull(var7, "The list of nodes to show contained an invalid node");
            var7.getRawNode().setVisible(true);
         }
      }

      this.notifyVisibilityListeners();
   }

   public void updateViews() {
      this.m_graph.T();
   }

   public void zoom(double var1) {
      double var3 = this.m_view.getZoom() * var1;
      this.m_view.setZoom(var3);
      ZoomHelpers.keepZoomValid(this.m_view);
      this.m_graph.T();
   }

   public void zoomIn() {
      this.m_view.setZoom(this.m_view.getZoom() * 1.0D / 0.8D);
      ZoomHelpers.keepZoomValid(this.m_view);
      this.m_graph.T();
   }

   public void zoomOut() {
      this.m_view.setZoom(this.m_view.getZoom() * 0.8D);
      ZoomHelpers.keepZoomValid(this.m_view);
      this.m_graph.T();
   }
}
