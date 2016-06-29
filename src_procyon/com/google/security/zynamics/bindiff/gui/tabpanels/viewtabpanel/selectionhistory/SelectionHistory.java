package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.graph.filter.*;

public class SelectionHistory
{
    private final List snapshotList;
    private final ListenerProvider listeners;
    private final SelectionHistory$InternalMatchedChangedListener matchChangeListener;
    private SingleGraph singleGraph;
    private CombinedGraph combinedGraph;
    private final int maxSnapshots;
    private int undoIndex;
    private boolean freeze;
    
    public SelectionHistory(final AbstractZyGraph abstractZyGraph, final int maxSnapshots) {
        this.snapshotList = new ArrayList();
        this.listeners = new ListenerProvider();
        this.matchChangeListener = new SelectionHistory$InternalMatchedChangedListener(this, null);
        this.undoIndex = -1;
        this.freeze = false;
        Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph can not be null");
        Preconditions.checkArgument(maxSnapshots > 0, (Object)"Invalid undo level");
        if (abstractZyGraph instanceof SingleGraph) {
            this.singleGraph = (SingleGraph)abstractZyGraph;
            this.combinedGraph = null;
        }
        else {
            if (!(abstractZyGraph instanceof CombinedGraph)) {
                throw new IllegalArgumentException("Graph must be an instance of SingleGraph or CombinedGraph.");
            }
            this.combinedGraph = (CombinedGraph)abstractZyGraph;
            this.singleGraph = null;
        }
        this.maxSnapshots = maxSnapshots;
        this.addSnapshot(new SelectionSnapshot(new ArrayList()));
    }
    
    public void addHistoryListener(final ISelectionHistoryListener selectionHistoryListener) {
        this.listeners.addListener(selectionHistoryListener);
    }
    
    public void addSnapshot(final SelectionSnapshot selectionSnapshot) {
        if (this.freeze) {
            return;
        }
        this.snapshotList.add(selectionSnapshot);
        if (this.snapshotList.size() > this.maxSnapshots) {
            this.snapshotList.remove(0);
            final Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().snapshotRemoved();
            }
        }
        this.undoIndex = this.getNumberOfSnapshots() - 1;
        final Iterator iterator2 = this.listeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().snapshotAdded(selectionSnapshot);
        }
    }
    
    public boolean canRedo() {
        return this.undoIndex <= this.getNumberOfSnapshots() - 1;
    }
    
    public boolean canUndo() {
        return this.undoIndex >= 0;
    }
    
    public void dispose() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            this.removeHistoryListener(iterator.next());
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
    
    public SelectionSnapshot getSnapshot(final boolean b) {
        if (b) {
            if (this.undoIndex != 0) {
                --this.undoIndex;
            }
            return this.getSnapshot(this.undoIndex);
        }
        if (this.undoIndex != this.getNumberOfSnapshots() - 1) {
            ++this.undoIndex;
        }
        return this.getSnapshot(this.undoIndex);
    }
    
    public SelectionSnapshot getSnapshot(final int n) {
        return this.snapshotList.get(n);
    }
    
    public void redo() {
        for (final ISelectionHistoryListener selectionHistoryListener : this.listeners) {
            try {
                selectionHistoryListener.startedRedo();
            }
            catch (Exception ex) {
                Logger.logException(ex, "Selection history listener notification failed.");
            }
        }
        if (!this.snapshotList.isEmpty() && this.canRedo()) {
            if (this.combinedGraph == null) {
                this.singleGraph.selectNodes(GraphNodeFilter.filterNodes(this.singleGraph, GraphNodeFilter$Criterium.SELECTED), false);
                this.singleGraph.selectNodes(this.getSnapshot(false).getSingleGraphSelection(), true);
            }
            else {
                this.combinedGraph.selectNodes(GraphNodeFilter.filterNodes(this.combinedGraph, GraphNodeFilter$Criterium.SELECTED), false);
                this.combinedGraph.selectNodes(this.getSnapshot(false).getCombinedGraphSelection(), true);
            }
        }
        for (final ISelectionHistoryListener selectionHistoryListener2 : this.listeners) {
            try {
                selectionHistoryListener2.finishedRedo();
            }
            catch (Exception ex2) {
                Logger.logException(ex2, "Selection history listener notification failed.");
            }
        }
    }
    
    public void registerMatchListener() {
        if (this.singleGraph != null) {
            this.singleGraph.getGraphs().getDiff().getMatches().addListener(this.matchChangeListener);
        }
        else {
            this.combinedGraph.getGraphs().getDiff().getMatches().addListener(this.matchChangeListener);
        }
    }
    
    public void removeHistoryListener(final ISelectionHistoryListener selectionHistoryListener) {
        try {
            this.listeners.removeListener(selectionHistoryListener);
        }
        catch (Exception ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    public void setEnabled(final boolean b) {
        this.freeze = !b;
    }
    
    public void undo() {
        for (final ISelectionHistoryListener selectionHistoryListener : this.listeners) {
            try {
                selectionHistoryListener.startedUndo();
            }
            catch (Exception ex) {
                Logger.logException(ex, "Selection history listener notification failed.");
            }
        }
        if (!this.snapshotList.isEmpty() && this.canUndo()) {
            if (this.combinedGraph == null) {
                this.singleGraph.selectNodes(GraphNodeFilter.filterNodes(this.singleGraph, GraphNodeFilter$Criterium.SELECTED), false);
                this.singleGraph.selectNodes(this.getSnapshot(true).getSingleGraphSelection(), true);
            }
            else {
                this.combinedGraph.selectNodes(GraphNodeFilter.filterNodes(this.combinedGraph, GraphNodeFilter$Criterium.SELECTED), false);
                this.combinedGraph.selectNodes(this.getSnapshot(true).getCombinedGraphSelection(), true);
            }
        }
        for (final ISelectionHistoryListener selectionHistoryListener2 : this.listeners) {
            try {
                selectionHistoryListener2.finishedUndo();
            }
            catch (Exception ex2) {
                Logger.logException(ex2, "Selection history listener notification failed.");
            }
        }
    }
}
