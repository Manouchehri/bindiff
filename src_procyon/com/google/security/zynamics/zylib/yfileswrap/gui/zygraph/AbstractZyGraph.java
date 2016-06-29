package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.*;
import com.google.common.base.*;
import y.h.a.*;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import y.c.*;
import java.util.*;
import y.h.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.io.*;
import y.f.*;
import com.google.common.collect.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;

public abstract class AbstractZyGraph implements IEdgeIterableGraph, IIterableGraph
{
    private static final double STANDARD_ZOOM_FACTOR = 0.8;
    private final ListenerProvider m_graphListeners;
    private final ListenerProvider m_visibilityListener;
    private final AbstractZyGraphSettings m_settings;
    private ZyDefaultProximityBrowser m_proximityBrowser;
    private final bu m_graph;
    private final ZyGraph2DView m_view;
    private final ZyEditMode m_editMode;
    private final ZyGraphSelectionObserver m_selectionObserver;
    private final ZyGraphMappings m_mappings;
    private InternalEditModeListener m_editModeListener;
    private final CGraphSettingsSynchronizer m_settingsSynchronizer;
    
    protected AbstractZyGraph(final ZyGraph2DView zyGraph2DView, final LinkedHashMap linkedHashMap, final LinkedHashMap linkedHashMap2, final AbstractZyGraphSettings settings) {
        this.m_graphListeners = new ListenerProvider();
        this.m_visibilityListener = new ListenerProvider();
        this.m_selectionObserver = new ZyGraphSelectionObserver();
        this.m_view = (ZyGraph2DView)Preconditions.checkNotNull(zyGraph2DView, (Object)"Error: View argument can't be null");
        Preconditions.checkNotNull(linkedHashMap, (Object)"Error: Node map argument can't be null");
        this.m_graph = this.m_view.getGraph2D();
        this.m_view.setGraph2DRenderer(new ZyGraphLayeredRenderer(this.m_view));
        this.m_settings = settings;
        this.m_mappings = new ZyGraphMappings(this.m_graph, linkedHashMap, linkedHashMap2);
        this.setProximityBrowser(new ZyDefaultProximityBrowser(this, this.m_settings));
        this.m_editMode = this.createEditMode();
        this.m_settingsSynchronizer = new CGraphSettingsSynchronizer(this.m_editMode, this.m_settings);
        this.initializeListeners();
        this.initializeView();
        this.setupHierarchyManager();
    }
    
    private void initializeListeners() {
        this.m_graph.a((cf)this.m_selectionObserver);
        this.m_graph.a(this.m_selectionObserver);
    }
    
    private void initializeView() {
        this.getView().addViewMode(this.m_editMode);
        this.m_editModeListener = new InternalEditModeListener(this.m_graphListeners);
        this.m_editMode.addListener(this.m_editModeListener);
        this.getView().setAntialiasedPainting(true);
    }
    
    private void notifyVisibilityListeners() {
        for (final IZyGraphVisibilityListener zyGraphVisibilityListener : this.m_visibilityListener) {
            try {
                zyGraphVisibilityListener.visibilityChanged();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void setupHierarchyManager() {
        if (this.m_graph.C() == null) {
            final v v = new v(this.m_graph);
            this.m_graph.a(v);
            v.a(new s());
        }
    }
    
    private void showNeighbors(final Collection collection) {
        this.showNodesInternal(ProximityRangeCalculator.getNeighbors(this, collection, this.getSettings().getProximitySettings().getProximityBrowsingChildren(), this.getSettings().getProximitySettings().getProximityBrowsingParents()));
    }
    
    private void showNodesInternal(final Collection collection) {
        for (final ZyGraphNode zyGraphNode : collection) {
            Preconditions.checkNotNull(zyGraphNode, (Object)"Error: The list of nodes to show contained an invalid node");
            if (!zyGraphNode.getRawNode().isVisible()) {
                zyGraphNode.getRawNode().setVisible(true);
            }
        }
    }
    
    private Collection sortLayers(final Collection collection) {
        final ArrayList<Object> list = new ArrayList<Object>(collection);
        Collections.sort(list, new AbstractZyGraph$1(this));
        return list;
    }
    
    protected ZyEditMode createEditMode() {
        return new ZyEditMode(this);
    }
    
    protected void notifyDeletionListeners() {
        for (final IZyGraphVisibilityListener zyGraphVisibilityListener : this.m_visibilityListener) {
            try {
                zyGraphVisibilityListener.nodeDeleted();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    protected void removeNode(final ZyGraphNode zyGraphNode) {
        if (zyGraphNode.getNode().e() == null) {
            this.m_graph.b(zyGraphNode.getNode());
        }
        if (this.m_graph.C().l(zyGraphNode.getNode())) {
            this.m_graph.a(zyGraphNode.getNode());
        }
        else if (this.getGraph().C().j(zyGraphNode.getNode())) {
            GroupHelpers.extractFolder(this.m_graph, zyGraphNode.getNode());
            this.m_graph.a(zyGraphNode.getNode());
        }
        else if (this.getGraph().C().k(zyGraphNode.getNode())) {
            GroupHelpers.extractGroup(this.m_graph, zyGraphNode.getNode());
            this.m_graph.a(zyGraphNode.getNode());
        }
        this.m_mappings.removeNode(zyGraphNode);
    }
    
    public void addListener(final IZyGraphListener zyGraphListener) {
        this.m_graphListeners.addListener(zyGraphListener);
    }
    
    public void addListener(final IZyGraphSelectionListener zyGraphSelectionListener) {
        this.m_selectionObserver.addListener(zyGraphSelectionListener);
    }
    
    public void addListener(final IZyGraphVisibilityListener zyGraphVisibilityListener) {
        this.m_visibilityListener.addListener(zyGraphVisibilityListener);
    }
    
    public void dispose() {
        this.m_settingsSynchronizer.dispose();
    }
    
    public void doLayout() {
        LayoutFunctions.doLayout(this, this.m_settings.getLayoutSettings().getCurrentLayouter());
    }
    
    public ZyGraphEdge getEdge(final d d) {
        return this.m_mappings.getEdge(d);
    }
    
    public ZyGraphEdge getEdge(final Object o) {
        return this.m_mappings.getEdge(o);
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
    
    public ZyGraphNode getNode(final q q) {
        return this.m_mappings.getNode(q);
    }
    
    public ZyGraphNode getNode(final Object o) {
        return this.m_mappings.getNode(o);
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
    
    public void removeViewFocusListener(final FocusListener focusListener) {
        this.m_view.removeFocusListener(focusListener);
    }
    
    public void addViewFocusListener(final FocusListener focusListener) {
        this.m_view.addFocusListener(focusListener);
    }
    
    public void setViewCursor(final Cursor cursor) {
        this.m_view.setCursor(cursor);
    }
    
    public void addViewCanvasKeyListener(final CDefaultLabelEventHandler cDefaultLabelEventHandler) {
        this.m_view.getCanvasComponent().addKeyListener(cDefaultLabelEventHandler);
    }
    
    public void removeViewCanvasKeyListener(final CDefaultLabelEventHandler cDefaultLabelEventHandler) {
        this.m_view.getCanvasComponent().removeKeyListener(cDefaultLabelEventHandler);
    }
    
    public d getYEdge(final Object o) {
        return this.m_mappings.getYEdge(o);
    }
    
    public q getYNode(final Object o) {
        return this.m_mappings.getYNode(o);
    }
    
    public void iterate(final INodeCallback nodeCallback) {
        Preconditions.checkNotNull(nodeCallback, (Object)"Callback argument can't be null");
        final Iterator<ZyGraphNode> iterator = this.m_mappings.getNodes().iterator();
        while (iterator.hasNext()) {
            if (nodeCallback.next(iterator.next()) == IterationMode.STOP) {
                return;
            }
        }
    }
    
    @Override
    public void iterateEdges(final IEdgeCallback edgeCallback) {
        Preconditions.checkNotNull(edgeCallback, (Object)"Callback argument can't be null");
        final Iterator<ZyGraphEdge> iterator = this.m_mappings.getEdges().iterator();
        while (iterator.hasNext()) {
            if (edgeCallback.nextEdge(iterator.next()) == IterationMode.STOP) {
                return;
            }
        }
    }
    
    public void removeListener(final IZyGraphListener zyGraphListener) {
        this.m_graphListeners.removeListener(zyGraphListener);
    }
    
    public void removeListener(final IZyGraphSelectionListener zyGraphSelectionListener) {
        this.m_selectionObserver.removeListener(zyGraphSelectionListener);
    }
    
    public void removeListener(final IZyGraphVisibilityListener zyGraphVisibilityListener) {
        this.m_visibilityListener.removeListener(zyGraphVisibilityListener);
    }
    
    public void saveGraphAsGML(final File file) {
        final aa aa = new aa(this.m_graph);
        String s = file.getPath();
        if (s.toLowerCase().endsWith(".gml")) {
            s = String.valueOf(s).concat(".gml");
        }
        aa.a(s);
    }
    
    public void selectNode(final ZyGraphNode zyGraphNode, final boolean selected) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Node argument can't be null");
        this.m_graph.r();
        zyGraphNode.getRawNode().setSelected(selected);
        this.m_graph.s();
    }
    
    public void selectNodes(final Collection collection, final boolean selected) {
        Preconditions.checkNotNull(collection, (Object)"Nodes argument can't be null");
        this.m_graph.r();
        for (final ZyGraphNode zyGraphNode : collection) {
            Preconditions.checkNotNull(zyGraphNode, (Object)"Error: The list of nodes to select contained an invalid node.");
            zyGraphNode.getRawNode().setSelected(selected);
        }
        this.m_graph.s();
    }
    
    public void selectNodes(final Collection collection, final Collection collection2) {
        this.m_graph.r();
        for (final ZyGraphNode zyGraphNode : collection) {
            Preconditions.checkNotNull(zyGraphNode, (Object)"Error: The list of nodes to select contained an invalid node");
            zyGraphNode.getRawNode().setSelected(true);
        }
        for (final ZyGraphNode zyGraphNode2 : collection2) {
            Preconditions.checkNotNull(zyGraphNode2, (Object)"Error: The list of nodes to unselect contained an invalid node");
            zyGraphNode2.getRawNode().setSelected(false);
        }
        this.m_graph.s();
    }
    
    public void setProximityBrowser(final ZyDefaultProximityBrowser proximityBrowser) {
        if (this.m_proximityBrowser != null) {
            this.m_proximityBrowser.dispose();
        }
        this.m_proximityBrowser = proximityBrowser;
    }
    
    public void showNode(final ZyGraphNode zyGraphNode, final boolean visible) {
        Preconditions.checkNotNull(zyGraphNode, (Object)"Node argument can't be null");
        zyGraphNode.getRawNode().setVisible(visible);
        if (visible) {
            this.showNeighbors(Lists.newArrayList(zyGraphNode));
        }
        this.notifyVisibilityListeners();
    }
    
    public void showNodes(final Collection collection, final boolean b) {
        for (final ZyGraphNode zyGraphNode : collection) {
            Preconditions.checkNotNull(zyGraphNode, (Object)"The list of nodes to show contained an invalid node");
            zyGraphNode.getRawNode().setVisible(true);
        }
        if (b) {
            this.showNeighbors(collection);
        }
        this.notifyVisibilityListeners();
    }
    
    public void showNodes(final Collection collection, final Collection collection2) {
        final IProximitySettings proximitySettings = this.getSettings().getProximitySettings();
        collection2.removeAll(ProximityRangeCalculator.getNeighbors(this, collection, proximitySettings.getProximityBrowsingChildren(), proximitySettings.getProximityBrowsingParents()));
        for (final ZyGraphNode zyGraphNode : this.sortLayers(collection2)) {
            Preconditions.checkNotNull(zyGraphNode, (Object)"Error: The list of nodes to hide contained an invalid node");
            zyGraphNode.getRawNode().setVisible(false);
        }
        this.showNeighbors(collection);
        this.notifyVisibilityListeners();
    }
    
    public void showNodes(final Collection collection, final Collection collection2, final boolean b) {
        if (b) {
            final IProximitySettings proximitySettings = this.getSettings().getProximitySettings();
            collection2.removeAll(ProximityRangeCalculator.getNeighbors(this, collection, proximitySettings.getProximityBrowsingChildren(), proximitySettings.getProximityBrowsingParents()));
        }
        for (final ZyGraphNode zyGraphNode : this.sortLayers(collection2)) {
            Preconditions.checkNotNull(zyGraphNode, (Object)"Error: The list of nodes to hide contained an invalid node");
            zyGraphNode.getRawNode().setVisible(false);
        }
        if (b) {
            this.showNeighbors(collection);
        }
        else {
            for (final ZyGraphNode zyGraphNode2 : collection) {
                Preconditions.checkNotNull(zyGraphNode2, (Object)"The list of nodes to show contained an invalid node");
                zyGraphNode2.getRawNode().setVisible(true);
            }
        }
        this.notifyVisibilityListeners();
    }
    
    public void updateViews() {
        this.m_graph.T();
    }
    
    public void zoom(final double n) {
        this.m_view.setZoom(this.m_view.getZoom() * n);
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
