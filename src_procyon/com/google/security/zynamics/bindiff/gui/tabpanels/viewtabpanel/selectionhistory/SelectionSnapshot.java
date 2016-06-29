package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class SelectionSnapshot
{
    private final ListenerProvider listeners;
    private final List selectedNodes;
    
    public SelectionSnapshot(final Collection collection) {
        this.listeners = new ListenerProvider();
        this.selectedNodes = new ArrayList();
        collection.addAll(collection);
    }
    
    public void add(final ZyGraphNode zyGraphNode) {
        this.selectedNodes.add(zyGraphNode);
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().addedNode(zyGraphNode);
        }
    }
    
    public void addListener(final ISnapshotListener snapshotListener) {
        this.listeners.addListener(snapshotListener);
    }
    
    public boolean equals(final SelectionSnapshot selectionSnapshot) {
        return selectionSnapshot != null && selectionSnapshot.selectedNodes.equals(this.selectedNodes);
    }
    
    public Collection getCombinedGraphSelection() {
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        for (final ZyGraphNode zyGraphNode : list) {
            if (zyGraphNode instanceof CombinedDiffNode) {
                list.add((CombinedDiffNode)zyGraphNode);
            }
        }
        return list;
    }
    
    public String getDescription() {
        String format = "No Selection";
        if (this.selectedNodes.size() == 1) {
            String hexString = "";
            final ZyGraphNode zyGraphNode = this.selectedNodes.get(0);
            if (zyGraphNode instanceof SingleDiffNode) {
                hexString = ((SingleDiffNode)zyGraphNode).getRawNode().getAddress().toHexString();
            }
            else if (zyGraphNode instanceof CombinedDiffNode) {
                final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)zyGraphNode;
                final SingleViewNode primaryRawNode = combinedDiffNode.getPrimaryRawNode();
                final SingleViewNode secondaryRawNode = combinedDiffNode.getSecondaryRawNode();
                final String value = String.valueOf(String.valueOf((primaryRawNode == null) ? "missing" : primaryRawNode.getAddress().toHexString()).concat(" - "));
                final String value2 = String.valueOf((secondaryRawNode == null) ? "missing" : secondaryRawNode.getAddress().toHexString());
                hexString = ((value2.length() != 0) ? value.concat(value2) : new String(value));
            }
            format = String.format("Single Selection (%s)", hexString);
        }
        else if (this.selectedNodes.size() > 1) {
            format = "Group Selection";
        }
        return format;
    }
    
    public int getNumberOfSelectedNodes() {
        return this.selectedNodes.size();
    }
    
    public Collection getSelection() {
        return this.selectedNodes;
    }
    
    public Collection getSingleGraphSelection() {
        final ArrayList<SingleDiffNode> list = new ArrayList<SingleDiffNode>();
        for (final ZyGraphNode zyGraphNode : list) {
            if (zyGraphNode instanceof SingleDiffNode) {
                list.add((SingleDiffNode)zyGraphNode);
            }
        }
        return list;
    }
    
    @Override
    public int hashCode() {
        return this.selectedNodes.hashCode();
    }
    
    public void modicationFinished() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().finished();
        }
    }
    
    public void remove(final ZyGraphNode zyGraphNode) {
        this.selectedNodes.remove(zyGraphNode);
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().removedNode(zyGraphNode);
        }
    }
    
    public void removeListener(final ISnapshotListener snapshotListener) {
        this.listeners.removeListener(snapshotListener);
    }
}
