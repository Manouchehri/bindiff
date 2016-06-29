/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISnapshotListener;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SelectionSnapshot {
    private final ListenerProvider listeners = new ListenerProvider();
    private final List selectedNodes = new ArrayList();

    public SelectionSnapshot(Collection collection) {
        collection.addAll(collection);
    }

    public void add(ZyGraphNode zyGraphNode) {
        this.selectedNodes.add(zyGraphNode);
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ISnapshotListener iSnapshotListener = (ISnapshotListener)iterator.next();
            iSnapshotListener.addedNode(zyGraphNode);
        }
    }

    public void addListener(ISnapshotListener iSnapshotListener) {
        this.listeners.addListener(iSnapshotListener);
    }

    public boolean equals(SelectionSnapshot selectionSnapshot) {
        if (selectionSnapshot == null) return false;
        if (!selectionSnapshot.selectedNodes.equals(this.selectedNodes)) return false;
        return true;
    }

    public Collection getCombinedGraphSelection() {
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (!(zyGraphNode instanceof CombinedDiffNode)) continue;
            arrayList.add((CombinedDiffNode)zyGraphNode);
        }
        return arrayList;
    }

    public String getDescription() {
        String string = "No Selection";
        if (this.selectedNodes.size() != 1) {
            if (this.selectedNodes.size() <= 1) return string;
            return "Group Selection";
        }
        String string2 = "";
        ZyGraphNode zyGraphNode = (ZyGraphNode)this.selectedNodes.get(0);
        if (zyGraphNode instanceof SingleDiffNode) {
            string2 = ((SingleDiffNode)zyGraphNode).getRawNode().getAddress().toHexString();
            return String.format("Single Selection (%s)", string2);
        } else {
            if (!(zyGraphNode instanceof CombinedDiffNode)) return String.format("Single Selection (%s)", string2);
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)zyGraphNode;
            SingleViewNode singleViewNode = combinedDiffNode.getPrimaryRawNode();
            SingleViewNode singleViewNode2 = combinedDiffNode.getSecondaryRawNode();
            string2 = singleViewNode == null ? "missing" : singleViewNode.getAddress().toHexString();
            string2 = String.valueOf(string2).concat(" - ");
            String string3 = String.valueOf(string2);
            String string4 = String.valueOf(singleViewNode2 == null ? "missing" : singleViewNode2.getAddress().toHexString());
            string2 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
        }
        return String.format("Single Selection (%s)", string2);
    }

    public int getNumberOfSelectedNodes() {
        return this.selectedNodes.size();
    }

    public Collection getSelection() {
        return this.selectedNodes;
    }

    public Collection getSingleGraphSelection() {
        ArrayList<SingleDiffNode> arrayList = new ArrayList<SingleDiffNode>();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (!(zyGraphNode instanceof SingleDiffNode)) continue;
            arrayList.add((SingleDiffNode)zyGraphNode);
        }
        return arrayList;
    }

    public int hashCode() {
        return this.selectedNodes.hashCode();
    }

    public void modicationFinished() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ISnapshotListener iSnapshotListener = (ISnapshotListener)iterator.next();
            iSnapshotListener.finished();
        }
    }

    public void remove(ZyGraphNode zyGraphNode) {
        this.selectedNodes.remove(zyGraphNode);
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ISnapshotListener iSnapshotListener = (ISnapshotListener)iterator.next();
            iSnapshotListener.removedNode(zyGraphNode);
        }
    }

    public void removeListener(ISnapshotListener iSnapshotListener) {
        this.listeners.removeListener(iSnapshotListener);
    }
}

