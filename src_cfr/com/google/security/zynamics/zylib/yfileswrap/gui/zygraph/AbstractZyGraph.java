/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer;
import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.awt.Cursor;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JComponent;
import y.c.d;
import y.c.i;
import y.c.o;
import y.c.q;
import y.f.X;
import y.f.aa;
import y.f.c;
import y.h.a.s;
import y.h.a.u;
import y.h.a.v;
import y.h.bu;
import y.h.cd;
import y.h.cf;
import y.h.ch;
import y.h.gX;

public abstract class AbstractZyGraph
implements IEdgeIterableGraph,
IIterableGraph {
    private static final double STANDARD_ZOOM_FACTOR = 0.8;
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

    protected AbstractZyGraph(ZyGraph2DView zyGraph2DView, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, AbstractZyGraphSettings abstractZyGraphSettings) {
        this.m_view = (ZyGraph2DView)Preconditions.checkNotNull(zyGraph2DView, "Error: View argument can't be null");
        Preconditions.checkNotNull(linkedHashMap, "Error: Node map argument can't be null");
        this.m_graph = this.m_view.getGraph2D();
        this.m_view.setGraph2DRenderer(new ZyGraphLayeredRenderer(this.m_view));
        this.m_settings = abstractZyGraphSettings;
        this.m_mappings = new ZyGraphMappings(this.m_graph, linkedHashMap, linkedHashMap2);
        this.setProximityBrowser(new ZyDefaultProximityBrowser(this, this.m_settings));
        this.m_editMode = this.createEditMode();
        this.m_settingsSynchronizer = new CGraphSettingsSynchronizer(this.m_editMode, this.m_settings);
        this.initializeListeners();
        this.initializeView();
        this.setupHierarchyManager();
    }

    private void initializeListeners() {
        this.m_graph.a(this.m_selectionObserver);
        this.m_graph.a(this.m_selectionObserver);
    }

    private void initializeView() {
        this.getView().addViewMode(this.m_editMode);
        this.m_editModeListener = new InternalEditModeListener(this.m_graphListeners);
        this.m_editMode.addListener(this.m_editModeListener);
        this.getView().setAntialiasedPainting(true);
    }

    private void notifyVisibilityListeners() {
        Iterator iterator = this.m_visibilityListener.iterator();
        while (iterator.hasNext()) {
            IZyGraphVisibilityListener iZyGraphVisibilityListener = (IZyGraphVisibilityListener)iterator.next();
            try {
                iZyGraphVisibilityListener.visibilityChanged();
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
            }
        }
    }

    private void setupHierarchyManager() {
        if (this.m_graph.C() != null) return;
        v v2 = new v(this.m_graph);
        this.m_graph.a(v2);
        v2.a(new s());
    }

    private void showNeighbors(Collection collection) {
        Set set = ProximityRangeCalculator.getNeighbors(this, collection, this.getSettings().getProximitySettings().getProximityBrowsingChildren(), this.getSettings().getProximitySettings().getProximityBrowsingParents());
        this.showNodesInternal(set);
    }

    private void showNodesInternal(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            Preconditions.checkNotNull(zyGraphNode, "Error: The list of nodes to show contained an invalid node");
            if (zyGraphNode.getRawNode().isVisible()) continue;
            zyGraphNode.getRawNode().setVisible(true);
        }
    }

    private Collection sortLayers(Collection collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new AbstractZyGraph$1(this));
        return arrayList;
    }

    protected ZyEditMode createEditMode() {
        return new ZyEditMode(this);
    }

    protected void notifyDeletionListeners() {
        Iterator iterator = this.m_visibilityListener.iterator();
        while (iterator.hasNext()) {
            IZyGraphVisibilityListener iZyGraphVisibilityListener = (IZyGraphVisibilityListener)iterator.next();
            try {
                iZyGraphVisibilityListener.nodeDeleted();
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
            }
        }
    }

    protected void removeNode(ZyGraphNode zyGraphNode) {
        q q2;
        v v2;
        if (zyGraphNode.getNode().e() == null) {
            this.m_graph.b(zyGraphNode.getNode());
        }
        if ((v2 = this.m_graph.C()).l(q2 = zyGraphNode.getNode())) {
            this.m_graph.a(zyGraphNode.getNode());
        } else if (this.getGraph().C().j(zyGraphNode.getNode())) {
            GroupHelpers.extractFolder(this.m_graph, zyGraphNode.getNode());
            this.m_graph.a(zyGraphNode.getNode());
        } else if (this.getGraph().C().k(zyGraphNode.getNode())) {
            GroupHelpers.extractGroup(this.m_graph, zyGraphNode.getNode());
            this.m_graph.a(zyGraphNode.getNode());
        }
        this.m_mappings.removeNode(zyGraphNode);
    }

    public void addListener(IZyGraphListener iZyGraphListener) {
        this.m_graphListeners.addListener(iZyGraphListener);
    }

    public void addListener(IZyGraphSelectionListener iZyGraphSelectionListener) {
        this.m_selectionObserver.addListener(iZyGraphSelectionListener);
    }

    public void addListener(IZyGraphVisibilityListener iZyGraphVisibilityListener) {
        this.m_visibilityListener.addListener(iZyGraphVisibilityListener);
    }

    public void dispose() {
        this.m_settingsSynchronizer.dispose();
    }

    public void doLayout() {
        LayoutFunctions.doLayout(this, this.m_settings.getLayoutSettings().getCurrentLayouter());
    }

    public ZyGraphEdge getEdge(d d2) {
        return this.m_mappings.getEdge(d2);
    }

    public ZyGraphEdge getEdge(Object object) {
        return this.m_mappings.getEdge(object);
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

    public ZyGraphNode getNode(q q2) {
        return this.m_mappings.getNode(q2);
    }

    public ZyGraphNode getNode(Object object) {
        return this.m_mappings.getNode(object);
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

    public void removeViewFocusListener(FocusListener focusListener) {
        this.m_view.removeFocusListener(focusListener);
    }

    public void addViewFocusListener(FocusListener focusListener) {
        this.m_view.addFocusListener(focusListener);
    }

    public void setViewCursor(Cursor cursor) {
        this.m_view.setCursor(cursor);
    }

    public void addViewCanvasKeyListener(CDefaultLabelEventHandler cDefaultLabelEventHandler) {
        this.m_view.getCanvasComponent().addKeyListener(cDefaultLabelEventHandler);
    }

    public void removeViewCanvasKeyListener(CDefaultLabelEventHandler cDefaultLabelEventHandler) {
        this.m_view.getCanvasComponent().removeKeyListener(cDefaultLabelEventHandler);
    }

    public d getYEdge(Object object) {
        return this.m_mappings.getYEdge(object);
    }

    public q getYNode(Object object) {
        return this.m_mappings.getYNode(object);
    }

    public void iterate(INodeCallback iNodeCallback) {
        ZyGraphNode zyGraphNode;
        Preconditions.checkNotNull(iNodeCallback, "Callback argument can't be null");
        Iterator<E> iterator = this.m_mappings.getNodes().iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (iNodeCallback.next(zyGraphNode = (ZyGraphNode)iterator.next()) != IterationMode.STOP);
    }

    @Override
    public void iterateEdges(IEdgeCallback iEdgeCallback) {
        ZyGraphEdge zyGraphEdge;
        Preconditions.checkNotNull(iEdgeCallback, "Callback argument can't be null");
        Iterator<E> iterator = this.m_mappings.getEdges().iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (iEdgeCallback.nextEdge(zyGraphEdge = (ZyGraphEdge)iterator.next()) != IterationMode.STOP);
    }

    public void removeListener(IZyGraphListener iZyGraphListener) {
        this.m_graphListeners.removeListener(iZyGraphListener);
    }

    public void removeListener(IZyGraphSelectionListener iZyGraphSelectionListener) {
        this.m_selectionObserver.removeListener(iZyGraphSelectionListener);
    }

    public void removeListener(IZyGraphVisibilityListener iZyGraphVisibilityListener) {
        this.m_visibilityListener.removeListener(iZyGraphVisibilityListener);
    }

    public void saveGraphAsGML(File file) {
        aa aa2 = new aa(this.m_graph);
        String string = file.getPath();
        if (string.toLowerCase().endsWith(".gml")) {
            string = String.valueOf(string).concat(".gml");
        }
        aa2.a(string);
    }

    public void selectNode(ZyGraphNode zyGraphNode, boolean bl2) {
        Preconditions.checkNotNull(zyGraphNode, "Node argument can't be null");
        this.m_graph.r();
        zyGraphNode.getRawNode().setSelected(bl2);
        this.m_graph.s();
    }

    public void selectNodes(Collection collection, boolean bl2) {
        Preconditions.checkNotNull(collection, "Nodes argument can't be null");
        this.m_graph.r();
        Iterator<E> iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                this.m_graph.s();
                return;
            }
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            Preconditions.checkNotNull(zyGraphNode, "Error: The list of nodes to select contained an invalid node.");
            zyGraphNode.getRawNode().setSelected(bl2);
        } while (true);
    }

    public void selectNodes(Collection collection, Collection collection2) {
        this.m_graph.r();
        for (ZyGraphNode zyGraphNode2 : collection) {
            Preconditions.checkNotNull(zyGraphNode2, "Error: The list of nodes to select contained an invalid node");
            zyGraphNode2.getRawNode().setSelected(true);
        }
        Iterator<E> iterator = collection2.iterator();
        do {
            ZyGraphNode zyGraphNode2;
            if (!iterator.hasNext()) {
                this.m_graph.s();
                return;
            }
            zyGraphNode2 = (ZyGraphNode)iterator.next();
            Preconditions.checkNotNull(zyGraphNode2, "Error: The list of nodes to unselect contained an invalid node");
            zyGraphNode2.getRawNode().setSelected(false);
        } while (true);
    }

    public void setProximityBrowser(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        if (this.m_proximityBrowser != null) {
            this.m_proximityBrowser.dispose();
        }
        this.m_proximityBrowser = zyDefaultProximityBrowser;
    }

    public void showNode(ZyGraphNode zyGraphNode, boolean bl2) {
        Preconditions.checkNotNull(zyGraphNode, "Node argument can't be null");
        zyGraphNode.getRawNode().setVisible(bl2);
        if (bl2) {
            ArrayList arrayList = Lists.newArrayList(zyGraphNode);
            this.showNeighbors(arrayList);
        }
        this.notifyVisibilityListeners();
    }

    public void showNodes(Collection collection, boolean bl2) {
        for (ZyGraphNode zyGraphNode : collection) {
            Preconditions.checkNotNull(zyGraphNode, "The list of nodes to show contained an invalid node");
            zyGraphNode.getRawNode().setVisible(true);
        }
        if (bl2) {
            this.showNeighbors(collection);
        }
        this.notifyVisibilityListeners();
    }

    public void showNodes(Collection collection, Collection collection2) {
        IProximitySettings iProximitySettings = this.getSettings().getProximitySettings();
        Set set = ProximityRangeCalculator.getNeighbors(this, collection, iProximitySettings.getProximityBrowsingChildren(), iProximitySettings.getProximityBrowsingParents());
        collection2.removeAll(set);
        Iterator<E> iterator = this.sortLayers(collection2).iterator();
        do {
            if (!iterator.hasNext()) {
                this.showNeighbors(collection);
                this.notifyVisibilityListeners();
                return;
            }
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            Preconditions.checkNotNull(zyGraphNode, "Error: The list of nodes to hide contained an invalid node");
            zyGraphNode.getRawNode().setVisible(false);
        } while (true);
    }

    public void showNodes(Collection collection, Collection collection2, boolean bl2) {
        if (bl2) {
            Iterator<E> iterator = this.getSettings().getProximitySettings();
            Object object2 = ProximityRangeCalculator.getNeighbors(this, collection, iterator.getProximityBrowsingChildren(), iterator.getProximityBrowsingParents());
            collection2.removeAll(object2);
        }
        for (Object object2 : this.sortLayers(collection2)) {
            Preconditions.checkNotNull(object2, "Error: The list of nodes to hide contained an invalid node");
            object2.getRawNode().setVisible(false);
        }
        if (bl2) {
            this.showNeighbors(collection);
        } else {
            for (Object object2 : collection) {
                Preconditions.checkNotNull(object2, "The list of nodes to show contained an invalid node");
                object2.getRawNode().setVisible(true);
            }
        }
        this.notifyVisibilityListeners();
    }

    public void updateViews() {
        this.m_graph.T();
    }

    public void zoom(double d2) {
        double d3 = this.m_view.getZoom() * d2;
        this.m_view.setZoom(d3);
        ZoomHelpers.keepZoomValid(this.m_view);
        this.m_graph.T();
    }

    public void zoomIn() {
        this.m_view.setZoom(this.m_view.getZoom() * 1.0 / 0.8);
        ZoomHelpers.keepZoomValid(this.m_view);
        this.m_graph.T();
    }

    public void zoomOut() {
        this.m_view.setZoom(this.m_view.getZoom() * 0.8);
        ZoomHelpers.keepZoomValid(this.m_view);
        this.m_graph.T();
    }
}

