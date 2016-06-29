package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.util.*;
import y.c.*;

public class ZyDefaultProximityBrowser
{
    private boolean m_internallyDisabled;
    private final AbstractZyGraph m_graph;
    private final HashMap m_proximityMap;
    private final IProximitySettings m_settings;
    private Set m_lastShown;
    private final ZyDefaultProximityBrowser$InternalVisibilityListener m_visibilityListener;
    private final ZyDefaultProximityBrowser$InternalSettingsListener m_settingsListener;
    private boolean m_changedProximityBrowsing;
    private boolean m_doLayout;
    private final Map m_nodeListeners;
    
    public ZyDefaultProximityBrowser(final AbstractZyGraph graph, final AbstractZyGraphSettings abstractZyGraphSettings) {
        this.m_internallyDisabled = false;
        this.m_proximityMap = new HashMap();
        this.m_lastShown = new HashSet();
        this.m_visibilityListener = new ZyDefaultProximityBrowser$InternalVisibilityListener(this, null);
        this.m_settingsListener = new ZyDefaultProximityBrowser$InternalSettingsListener(this, null);
        this.m_changedProximityBrowsing = false;
        this.m_doLayout = true;
        this.m_nodeListeners = new HashMap();
        this.m_graph = graph;
        this.m_settings = abstractZyGraphSettings.getProximitySettings();
        this.addVisibilityListener();
        this.addSettingsListener();
    }
    
    private void disableProximityBrowsing() {
        if (this.hasAnyHiddenNodes()) {
            this.unhideEverything();
            this.deleteProximityBrowsingNodes();
            this.updateViews();
        }
    }
    
    private List filterGroupedNodes(final List list) {
        return CollectionHelpers.filter(list, new ZyDefaultProximityBrowser$1(this));
    }
    
    private ZyGraphNode getVisibleNode(final ZyGraphNode zyGraphNode) {
        ZyGraphNode node = zyGraphNode;
        for (IGroupNode groupNode = zyGraphNode.getRawNode().getParentGroup(); groupNode != null && groupNode.isCollapsed(); groupNode = groupNode.getParentGroup()) {
            node = this.m_graph.getNode(groupNode);
        }
        return node;
    }
    
    private boolean hasAnyHiddenNodes() {
        return GraphHelpers.any(this.m_graph, new ZyDefaultProximityBrowser$2(this));
    }
    
    private void restartProximityBrowsing() {
        this.m_lastShown = new HashSet();
        final Collection filter = SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes());
        if (!filter.isEmpty()) {
            final List nodes = GraphHelpers.getNodes(this.m_graph);
            nodes.removeAll(filter);
            this.m_graph.showNodes(filter, nodes);
            this.updateViews();
        }
    }
    
    private void setActive() {
        if (!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing()) {
            this.disableProximityBrowsing();
        }
        else {
            this.restartProximityBrowsing();
        }
    }
    
    private void unhideEverything() {
        this.m_graph.iterate(new ZyDefaultProximityBrowser$3(this));
        this.m_graph.iterateEdges(new ZyDefaultProximityBrowser$4(this));
    }
    
    private void updateProximityBrowsing(final Set set) {
        if (!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing() || this.m_internallyDisabled) {
            return;
        }
        if (this.m_lastShown.equals(set)) {
            return;
        }
        this.m_lastShown = new HashSet(set);
        this.m_internallyDisabled = true;
        this.deleteProximityBrowsingNodes();
        this.createProximityBrowsingNodes(GraphHelpers.getNodes(this.m_graph));
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
    
    protected void createProximityBrowsingNodes(final List list) {
        for (final ZyGraphNode zyGraphNode : this.filterGroupedNodes(list)) {
            if (!zyGraphNode.isVisible()) {
                continue;
            }
            final int countInvisibleIndegreeNeighbours = NodeHelpers.countInvisibleIndegreeNeighbours(zyGraphNode.getRawNode());
            if (countInvisibleIndegreeNeighbours > 0) {
                final ZyProximityNode proximityNode = ProximityNodeCreator.createProximityNode(this.m_graph.getGraph(), zyGraphNode, countInvisibleIndegreeNeighbours, false);
                final ZyDefaultProximityBrowser$InternalNodeListener zyDefaultProximityBrowser$InternalNodeListener = new ZyDefaultProximityBrowser$InternalNodeListener(this, zyGraphNode.getX(), zyGraphNode.getY(), proximityNode);
                zyGraphNode.getRawNode().addListener(zyDefaultProximityBrowser$InternalNodeListener);
                this.m_nodeListeners.put(proximityNode, zyDefaultProximityBrowser$InternalNodeListener);
                this.m_proximityMap.put(proximityNode.getNode(), proximityNode);
                ProximityNodeCreator.insertProximityEdge(this.m_graph.getGraph(), proximityNode, this.getVisibleNode(zyGraphNode));
            }
            final int countInvisibleOutdegreeNeighbours = NodeHelpers.countInvisibleOutdegreeNeighbours(zyGraphNode.getRawNode());
            if (countInvisibleOutdegreeNeighbours <= 0) {
                continue;
            }
            final ZyProximityNode proximityNode2 = ProximityNodeCreator.createProximityNode(this.m_graph.getGraph(), zyGraphNode, countInvisibleOutdegreeNeighbours, true);
            final ZyDefaultProximityBrowser$InternalNodeListener zyDefaultProximityBrowser$InternalNodeListener2 = new ZyDefaultProximityBrowser$InternalNodeListener(this, zyGraphNode.getX(), zyGraphNode.getY(), proximityNode2);
            zyGraphNode.getRawNode().addListener(zyDefaultProximityBrowser$InternalNodeListener2);
            this.m_nodeListeners.put(proximityNode2, zyDefaultProximityBrowser$InternalNodeListener2);
            this.m_proximityMap.put(proximityNode2.getNode(), proximityNode2);
            ProximityNodeCreator.insertProximityEdge(this.m_graph.getGraph(), this.getVisibleNode(zyGraphNode), proximityNode2);
        }
    }
    
    protected void deleteProximityBrowsingNode(final q q) {
        this.m_nodeListeners.remove(this.m_proximityMap.get(q));
        this.m_proximityMap.remove(q);
        this.m_graph.getGraph().a(q);
    }
    
    protected void deleteProximityBrowsingNodes() {
        this.m_internallyDisabled = true;
        final Iterator<q> iterator = this.m_proximityMap.keySet().iterator();
        while (iterator.hasNext()) {
            this.m_graph.getGraph().a(iterator.next());
        }
        this.m_proximityMap.clear();
        for (final Map.Entry<ZyProximityNode, V> entry : this.m_nodeListeners.entrySet()) {
            entry.getKey().getRawNode().getAttachedNode().removeListener((IViewNodeListener)entry.getValue());
        }
        this.m_nodeListeners.clear();
        this.m_internallyDisabled = false;
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
    
    public void setEnabled(final boolean b) {
        if (b) {
            this.m_graph.getSettings().getProximitySettings().addListener(this.m_settingsListener);
        }
        else {
            this.m_graph.getSettings().getProximitySettings().removeListener(this.m_settingsListener);
        }
    }
}
