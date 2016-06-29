package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import java.util.*;

public abstract class ProximityUpdater implements IZyGraphSelectionListener
{
    private Collection m_lastSelectedNodes;
    private final AbstractZyGraph m_graph;
    
    protected ProximityUpdater(final AbstractZyGraph graph) {
        Preconditions.checkNotNull(graph, (Object)"Error: Graph argument can not be null");
        this.m_graph = graph;
        this.m_lastSelectedNodes = this.m_graph.getSelectedNodes();
    }
    
    protected abstract void showNodes(final Collection p0, final Collection p1);
    
    @Override
    public void selectionChanged() {
        if (!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing() || this.m_graph.getSettings().getProximitySettings().getProximityBrowsingFrozen()) {
            return;
        }
        final Collection filter = SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes());
        if (filter.equals(this.m_lastSelectedNodes)) {
            return;
        }
        this.m_lastSelectedNodes = filter;
        if (!filter.isEmpty()) {
            final List nodes = GraphHelpers.getNodes(this.m_graph);
            nodes.removeAll(filter);
            this.showNodes(filter, nodes);
        }
    }
}
