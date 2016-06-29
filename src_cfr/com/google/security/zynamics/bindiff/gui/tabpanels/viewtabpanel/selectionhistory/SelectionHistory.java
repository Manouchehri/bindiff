/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory$InternalMatchedChangedListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SelectionHistory {
    private final List snapshotList = new ArrayList();
    private final ListenerProvider listeners = new ListenerProvider();
    private final SelectionHistory$InternalMatchedChangedListener matchChangeListener;
    private SingleGraph singleGraph;
    private CombinedGraph combinedGraph;
    private final int maxSnapshots;
    private int undoIndex;
    private boolean freeze;

    public SelectionHistory(AbstractZyGraph abstractZyGraph, int n2) {
        this.matchChangeListener = new SelectionHistory$InternalMatchedChangedListener(this, null);
        this.undoIndex = -1;
        this.freeze = false;
        Preconditions.checkNotNull(abstractZyGraph, "Graph can not be null");
        Preconditions.checkArgument(n2 > 0, "Invalid undo level");
        if (abstractZyGraph instanceof SingleGraph) {
            this.singleGraph = (SingleGraph)abstractZyGraph;
            this.combinedGraph = null;
        } else {
            if (!(abstractZyGraph instanceof CombinedGraph)) throw new IllegalArgumentException("Graph must be an instance of SingleGraph or CombinedGraph.");
            this.combinedGraph = (CombinedGraph)abstractZyGraph;
            this.singleGraph = null;
        }
        this.maxSnapshots = n2;
        this.addSnapshot(new SelectionSnapshot(new ArrayList()));
    }

    public void addHistoryListener(ISelectionHistoryListener iSelectionHistoryListener) {
        this.listeners.addListener(iSelectionHistoryListener);
    }

    public void addSnapshot(SelectionSnapshot selectionSnapshot) {
        if (this.freeze) {
            return;
        }
        this.snapshotList.add(selectionSnapshot);
        if (this.snapshotList.size() > this.maxSnapshots) {
            this.snapshotList.remove(0);
            for (ISelectionHistoryListener iSelectionHistoryListener : this.listeners) {
                iSelectionHistoryListener.snapshotRemoved();
            }
        }
        this.undoIndex = this.getNumberOfSnapshots() - 1;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ISelectionHistoryListener iSelectionHistoryListener;
            iSelectionHistoryListener = (ISelectionHistoryListener)iterator.next();
            iSelectionHistoryListener.snapshotAdded(selectionSnapshot);
        }
    }

    public boolean canRedo() {
        if (this.undoIndex > this.getNumberOfSnapshots() - 1) return false;
        return true;
    }

    public boolean canUndo() {
        if (this.undoIndex < 0) return false;
        return true;
    }

    public void dispose() {
        for (ISelectionHistoryListener iSelectionHistoryListener : this.listeners) {
            this.removeHistoryListener(iSelectionHistoryListener);
        }
        this.snapshotList.clear();
        if (this.singleGraph != null) {
            this.singleGraph.getGraphs().getDiff().getMatches().removeListener(this.matchChangeListener);
        }
        if (this.combinedGraph != null) {
            this.combinedGraph.getGraphs().getDiff().getMatches().removeListener(this.matchChangeListener);
        }
        this.singleGraph = null;
        this.combinedGraph = null;
    }

    public int getNumberOfSnapshots() {
        return this.snapshotList.size();
    }

    public SelectionSnapshot getSnapshot(boolean bl2) {
        if (bl2) {
            if (this.undoIndex == 0) return this.getSnapshot(this.undoIndex);
            --this.undoIndex;
            return this.getSnapshot(this.undoIndex);
        }
        if (this.undoIndex == this.getNumberOfSnapshots() - 1) return this.getSnapshot(this.undoIndex);
        ++this.undoIndex;
        return this.getSnapshot(this.undoIndex);
    }

    public SelectionSnapshot getSnapshot(int n2) {
        return (SelectionSnapshot)this.snapshotList.get(n2);
    }

    public void redo() {
        Object object;
        Object object22;
        for (Object object22 : this.listeners) {
            try {
                object22.startedRedo();
            }
            catch (Exception var3_3) {
                Logger.logException(var3_3, "Selection history listener notification failed.");
            }
        }
        if (!this.snapshotList.isEmpty() && this.canRedo()) {
            if (this.combinedGraph == null) {
                object = GraphNodeFilter.filterNodes(this.singleGraph, GraphNodeFilter$Criterium.SELECTED);
                this.singleGraph.selectNodes((Collection)object, false);
                object22 = this.getSnapshot(false).getSingleGraphSelection();
                this.singleGraph.selectNodes((Collection)object22, true);
            } else {
                object = GraphNodeFilter.filterNodes(this.combinedGraph, GraphNodeFilter$Criterium.SELECTED);
                this.combinedGraph.selectNodes((Collection)object, false);
                object22 = this.getSnapshot(false).getCombinedGraphSelection();
                this.combinedGraph.selectNodes((Collection)object22, true);
            }
        }
        object = this.listeners.iterator();
        while (object.hasNext()) {
            object22 = (ISelectionHistoryListener)object.next();
            try {
                object22.finishedRedo();
            }
            catch (Exception var3_5) {
                Logger.logException(var3_5, "Selection history listener notification failed.");
                continue;
            }
        }
    }

    public void registerMatchListener() {
        if (this.singleGraph != null) {
            this.singleGraph.getGraphs().getDiff().getMatches().addListener(this.matchChangeListener);
            return;
        }
        this.combinedGraph.getGraphs().getDiff().getMatches().addListener(this.matchChangeListener);
    }

    public void removeHistoryListener(ISelectionHistoryListener iSelectionHistoryListener) {
        try {
            this.listeners.removeListener(iSelectionHistoryListener);
            return;
        }
        catch (Exception var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    public void setEnabled(boolean bl2) {
        this.freeze = !bl2;
    }

    public void undo() {
        Object object;
        Object object22;
        for (Object object22 : this.listeners) {
            try {
                object22.startedUndo();
            }
            catch (Exception var3_3) {
                Logger.logException(var3_3, "Selection history listener notification failed.");
            }
        }
        if (!this.snapshotList.isEmpty() && this.canUndo()) {
            if (this.combinedGraph == null) {
                object = GraphNodeFilter.filterNodes(this.singleGraph, GraphNodeFilter$Criterium.SELECTED);
                this.singleGraph.selectNodes((Collection)object, false);
                object22 = this.getSnapshot(true).getSingleGraphSelection();
                this.singleGraph.selectNodes((Collection)object22, true);
            } else {
                object = GraphNodeFilter.filterNodes(this.combinedGraph, GraphNodeFilter$Criterium.SELECTED);
                this.combinedGraph.selectNodes((Collection)object, false);
                object22 = this.getSnapshot(true).getCombinedGraphSelection();
                this.combinedGraph.selectNodes((Collection)object22, true);
            }
        }
        object = this.listeners.iterator();
        while (object.hasNext()) {
            object22 = (ISelectionHistoryListener)object.next();
            try {
                object22.finishedUndo();
            }
            catch (Exception var3_5) {
                Logger.logException(var3_5, "Selection history listener notification failed.");
                continue;
            }
        }
    }

    static /* synthetic */ SingleGraph access$100(SelectionHistory selectionHistory) {
        return selectionHistory.singleGraph;
    }

    static /* synthetic */ CombinedGraph access$200(SelectionHistory selectionHistory) {
        return selectionHistory.combinedGraph;
    }

    static /* synthetic */ List access$300(SelectionHistory selectionHistory) {
        return selectionHistory.snapshotList;
    }
}

