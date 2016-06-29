/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.SelectedVisibleFilter;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public abstract class ProximityUpdater
implements IZyGraphSelectionListener {
    private Collection m_lastSelectedNodes;
    private final AbstractZyGraph m_graph;

    protected ProximityUpdater(AbstractZyGraph abstractZyGraph) {
        Preconditions.checkNotNull(abstractZyGraph, "Error: Graph argument can not be null");
        this.m_graph = abstractZyGraph;
        this.m_lastSelectedNodes = this.m_graph.getSelectedNodes();
    }

    protected abstract void showNodes(Collection var1, Collection var2);

    @Override
    public void selectionChanged() {
        if (!this.m_graph.getSettings().getProximitySettings().getProximityBrowsing()) return;
        if (this.m_graph.getSettings().getProximitySettings().getProximityBrowsingFrozen()) {
            return;
        }
        Collection collection = SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes());
        if (collection.equals(this.m_lastSelectedNodes)) {
            return;
        }
        this.m_lastSelectedNodes = collection;
        if (collection.isEmpty()) return;
        List list = GraphHelpers.getNodes(this.m_graph);
        list.removeAll(collection);
        this.showNodes(collection, list);
    }
}

