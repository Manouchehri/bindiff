/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.SelectedVisibleFilter;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ProximityNodeCreator;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$2;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$3;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$4;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$InternalNodeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$InternalSettingsListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$InternalVisibilityListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.c.q;
import y.h.bu;

public class ZyDefaultProximityBrowser {
    private boolean m_internallyDisabled = false;
    private final AbstractZyGraph m_graph;
    private final HashMap m_proximityMap = new HashMap();
    private final IProximitySettings m_settings;
    private Set m_lastShown = new HashSet();
    private final ZyDefaultProximityBrowser$InternalVisibilityListener m_visibilityListener;
    private final ZyDefaultProximityBrowser$InternalSettingsListener m_settingsListener;
    private boolean m_changedProximityBrowsing;
    private boolean m_doLayout;
    private final Map m_nodeListeners;

    public ZyDefaultProximityBrowser(AbstractZyGraph abstractZyGraph, AbstractZyGraphSettings abstractZyGraphSettings) {
        this.m_visibilityListener = new ZyDefaultProximityBrowser$InternalVisibilityListener(this, null);
        this.m_settingsListener = new ZyDefaultProximityBrowser$InternalSettingsListener(this, null);
        this.m_changedProximityBrowsing = false;
        this.m_doLayout = true;
        this.m_nodeListeners = new HashMap();
        this.m_graph = abstractZyGraph;
        this.m_settings = abstractZyGraphSettings.getProximitySettings();
        this.addVisibilityListener();
        this.addSettingsListener();
    }

    private void disableProximityBrowsing() {
        if (!this.hasAnyHiddenNodes()) return;
        this.unhideEverything();
        this.deleteProximityBrowsingNodes();
        this.updateViews();
    }

    private List filterGroupedNodes(List list) {
        return CollectionHelpers.filter(list, new ZyDefaultProximityBrowser$1(this));
    }

    private ZyGraphNode getVisibleNode(ZyGraphNode zyGraphNode) {
        ZyGraphNode zyGraphNode2 = zyGraphNode;
        IGroupNode iGroupNode = zyGraphNode.getRawNode().getParentGroup();
        while (iGroupNode != null) {
            if (!iGroupNode.isCollapsed()) return zyGraphNode2;
            zyGraphNode2 = this.m_graph.getNode(iGroupNode);
            iGroupNode = iGroupNode.getParentGroup();
        }
        return zyGraphNode2;
    }

    private boolean hasAnyHiddenNodes() {
        return GraphHelpers.any(this.m_graph, new ZyDefaultProximityBrowser$2(this));
    }

    private void restartProximityBrowsing() {
        this.m_lastShown = new HashSet();
        Collection collection = SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes());
        if (collection.isEmpty()) return;
        List list = GraphHelpers.getNodes(this.m_graph);
        list.removeAll(collection);
        this.m_graph.showNodes(collection, list);
        this.updateViews();
    }

    private void setActive() {
        if (!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing()) {
            this.disableProximityBrowsing();
            return;
        }
        this.restartProximityBrowsing();
    }

    private void unhideEverything() {
        this.m_graph.iterate(new ZyDefaultProximityBrowser$3(this));
        this.m_graph.iterateEdges(new ZyDefaultProximityBrowser$4(this));
    }

    private void updateProximityBrowsing(Set set) {
        if (!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing()) return;
        if (this.m_internallyDisabled) {
            return;
        }
        if (this.m_lastShown.equals(set)) {
            return;
        }
        this.m_lastShown = new HashSet(set);
        this.m_internallyDisabled = true;
        this.deleteProximityBrowsingNodes();
        List list = GraphHelpers.getNodes(this.m_graph);
        this.createProximityBrowsingNodes(list);
        this.updateViews();
        this.m_internallyDisabled = false;
    }

    private void updateViews() {
        if (this.m_graph.getSettings().getLayoutSettings().getAutomaticLayouting() && this.m_doLayout) {
            this.m_graph.doLayout();
        }
        this.m_graph.updateViews();
    }

    protected void addSettingsListener() {
        this.m_settings.addListener(this.m_settingsListener);
    }

    protected void addVisibilityListener() {
        this.m_graph.addListener(this.m_visibilityListener);
    }

    protected void createProximityBrowsingNodes(List list) {
        Iterator iterator = this.filterGroupedNodes(list).iterator();
        while (iterator.hasNext()) {
            Object object;
            int n2;
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (!zyGraphNode.isVisible()) continue;
            int n3 = NodeHelpers.countInvisibleIndegreeNeighbours(zyGraphNode.getRawNode());
            if (n3 > 0) {
                ZyProximityNode zyProximityNode = ProximityNodeCreator.createProximityNode(this.m_graph.getGraph(), zyGraphNode, n3, false);
                object = new ZyDefaultProximityBrowser$InternalNodeListener(this, zyGraphNode.getX(), zyGraphNode.getY(), zyProximityNode);
                zyGraphNode.getRawNode().addListener((IViewNodeListener)object);
                this.m_nodeListeners.put(zyProximityNode, object);
                this.m_proximityMap.put(zyProximityNode.getNode(), zyProximityNode);
                ProximityNodeCreator.insertProximityEdge(this.m_graph.getGraph(), zyProximityNode, this.getVisibleNode(zyGraphNode));
            }
            if ((n2 = NodeHelpers.countInvisibleOutdegreeNeighbours(zyGraphNode.getRawNode())) <= 0) continue;
            object = ProximityNodeCreator.createProximityNode(this.m_graph.getGraph(), zyGraphNode, n2, true);
            ZyDefaultProximityBrowser$InternalNodeListener zyDefaultProximityBrowser$InternalNodeListener = new ZyDefaultProximityBrowser$InternalNodeListener(this, zyGraphNode.getX(), zyGraphNode.getY(), (ZyProximityNode)object);
            zyGraphNode.getRawNode().addListener(zyDefaultProximityBrowser$InternalNodeListener);
            this.m_nodeListeners.put(object, zyDefaultProximityBrowser$InternalNodeListener);
            this.m_proximityMap.put(object.getNode(), object);
            ProximityNodeCreator.insertProximityEdge(this.m_graph.getGraph(), this.getVisibleNode(zyGraphNode), (ZyGraphNode)object);
        }
    }

    protected void deleteProximityBrowsingNode(q q2) {
        ZyProximityNode zyProximityNode = (ZyProximityNode)this.m_proximityMap.get(q2);
        this.m_nodeListeners.remove(zyProximityNode);
        this.m_proximityMap.remove(q2);
        this.m_graph.getGraph().a(q2);
    }

    protected void deleteProximityBrowsingNodes() {
        this.m_internallyDisabled = true;
        for (Object object2 : this.m_proximityMap.keySet()) {
            this.m_graph.getGraph().a((q)object2);
        }
        this.m_proximityMap.clear();
        Iterator iterator = this.m_nodeListeners.entrySet().iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) {
                this.m_nodeListeners.clear();
                this.m_internallyDisabled = false;
                return;
            }
            object2 = (Map.Entry)iterator.next();
            ((ZyProximityNode)object2.getKey()).getRawNode().getAttachedNode().removeListener((IViewNodeListener)object2.getValue());
        } while (true);
    }

    protected void removeSettingsListener() {
        this.m_settings.removeListener(this.m_settingsListener);
    }

    protected void removeVisibilityListener() {
        this.m_graph.removeListener(this.m_visibilityListener);
    }

    public void dispose() {
        this.removeVisibilityListener();
        this.removeSettingsListener();
    }

    public void setEnabled(boolean bl2) {
        if (bl2) {
            this.m_graph.getSettings().getProximitySettings().addListener(this.m_settingsListener);
            return;
        }
        this.m_graph.getSettings().getProximitySettings().removeListener(this.m_settingsListener);
    }

    static /* synthetic */ ZyGraphNode access$200(ZyDefaultProximityBrowser zyDefaultProximityBrowser, ZyGraphNode zyGraphNode) {
        return zyDefaultProximityBrowser.getVisibleNode(zyGraphNode);
    }

    static /* synthetic */ boolean access$302(ZyDefaultProximityBrowser zyDefaultProximityBrowser, boolean bl2) {
        zyDefaultProximityBrowser.m_changedProximityBrowsing = bl2;
        return zyDefaultProximityBrowser.m_changedProximityBrowsing;
    }

    static /* synthetic */ void access$400(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        zyDefaultProximityBrowser.setActive();
    }

    static /* synthetic */ AbstractZyGraph access$500(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        return zyDefaultProximityBrowser.m_graph;
    }

    static /* synthetic */ void access$600(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        zyDefaultProximityBrowser.restartProximityBrowsing();
    }

    static /* synthetic */ Set access$700(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        return zyDefaultProximityBrowser.m_lastShown;
    }

    static /* synthetic */ void access$800(ZyDefaultProximityBrowser zyDefaultProximityBrowser, Set set) {
        zyDefaultProximityBrowser.updateProximityBrowsing(set);
    }

    static /* synthetic */ boolean access$300(ZyDefaultProximityBrowser zyDefaultProximityBrowser) {
        return zyDefaultProximityBrowser.m_changedProximityBrowsing;
    }

    static /* synthetic */ boolean access$902(ZyDefaultProximityBrowser zyDefaultProximityBrowser, boolean bl2) {
        zyDefaultProximityBrowser.m_doLayout = bl2;
        return zyDefaultProximityBrowser.m_doLayout;
    }
}

