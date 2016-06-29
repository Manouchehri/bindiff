/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;
import java.util.Iterator;

class SelectionHistory$InternalMatchedChangedListener
implements IMatchesChangeListener {
    final /* synthetic */ SelectionHistory this$0;

    private SelectionHistory$InternalMatchedChangedListener(SelectionHistory selectionHistory) {
        this.this$0 = selectionHistory;
    }

    private BinDiffGraph getGraph() {
        SingleGraph singleGraph /* !! */ ;
        if (SelectionHistory.access$100(this.this$0) != null) {
            singleGraph /* !! */  = SelectionHistory.access$100(this.this$0);
            return singleGraph /* !! */ ;
        }
        singleGraph /* !! */  = SelectionHistory.access$200(this.this$0);
        return singleGraph /* !! */ ;
    }

    private SingleDiffNode getNewDiffNode(IAddress iAddress) {
        SingleDiffNode singleDiffNode;
        Iterator iterator = SelectionHistory.access$100(this.this$0).getNodes().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(singleDiffNode = (SingleDiffNode)iterator.next()).getRawNode().getAddress().equals(iAddress));
        return singleDiffNode;
    }

    private CombinedDiffNode getNewDiffNode(IAddress iAddress, ESide eSide) {
        CombinedDiffNode combinedDiffNode;
        RawCombinedBasicBlock rawCombinedBasicBlock;
        Iterator iterator = SelectionHistory.access$200(this.this$0).getNodes().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!iAddress.equals((rawCombinedBasicBlock = (RawCombinedBasicBlock)(combinedDiffNode = (CombinedDiffNode)iterator.next()).getRawNode()).getAddress(eSide)));
        return combinedDiffNode;
    }

    private void refreshSnapshots(CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        Preconditions.checkNotNull(combinedDiffNode, "Primary unmatched combined diff node can't be null.");
        Preconditions.checkNotNull(combinedDiffNode2, "Secondary unmatched combined diff node can't be null.");
        IAddress iAddress = combinedDiffNode.getRawNode().getAddress(ESide.PRIMARY);
        IAddress iAddress2 = combinedDiffNode2.getRawNode().getAddress(ESide.SECONDARY);
        Iterator iterator = SelectionHistory.access$300(this.this$0).iterator();
        block0 : while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode3;
            SelectionSnapshot selectionSnapshot = (SelectionSnapshot)iterator.next();
            Iterator iterator2 = selectionSnapshot.getCombinedGraphSelection().iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
            } while (!iAddress.equals((combinedDiffNode3 = (CombinedDiffNode)iterator2.next()).getRawNode().getAddress(ESide.PRIMARY)) || !iAddress2.equals(combinedDiffNode3.getRawNode().getAddress(ESide.SECONDARY)));
            selectionSnapshot.remove(combinedDiffNode3);
            selectionSnapshot.add(combinedDiffNode);
            selectionSnapshot.add(combinedDiffNode2);
            selectionSnapshot.modicationFinished();
        }
    }

    private void refreshSnapshots(SingleDiffNode singleDiffNode) {
        Preconditions.checkNotNull(singleDiffNode, "New unmatched diff node cann't be null.");
        IAddress iAddress = singleDiffNode.getRawNode().getAddress();
        Iterator iterator = SelectionHistory.access$300(this.this$0).iterator();
        block0 : while (iterator.hasNext()) {
            SingleDiffNode singleDiffNode2;
            SelectionSnapshot selectionSnapshot = (SelectionSnapshot)iterator.next();
            Iterator iterator2 = selectionSnapshot.getSingleGraphSelection().iterator();
            do {
                if (!iterator2.hasNext()) continue block0;
            } while (!(singleDiffNode2 = (SingleDiffNode)iterator2.next()).getRawNode().getAddress().equals(iAddress));
            selectionSnapshot.remove(singleDiffNode2);
            selectionSnapshot.add(singleDiffNode);
            selectionSnapshot.modicationFinished();
        }
    }

    private void updateSnapshots(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        BinDiffGraph binDiffGraph = this.getGraph();
        if (binDiffGraph.getGraphType() == EGraphType.CALLGRAPH) {
            return;
        }
        if (!iAddress.equals(binDiffGraph.getPrimaryGraph().getFunctionAddress())) return;
        if (!iAddress2.equals(binDiffGraph.getSecondaryGraph().getFunctionAddress())) return;
        if (SelectionHistory.access$100(this.this$0) == null) {
            this.refreshSnapshots(this.getNewDiffNode(iAddress3, ESide.PRIMARY), this.getNewDiffNode(iAddress4, ESide.SECONDARY));
            return;
        }
        this.refreshSnapshots(this.getNewDiffNode(SelectionHistory.access$100(this.this$0).getSide() == ESide.PRIMARY ? iAddress3 : iAddress4));
    }

    @Override
    public void addedBasicblockMatch(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        this.updateSnapshots(iAddress, iAddress2, iAddress3, iAddress4);
    }

    @Override
    public void removedBasicblockMatch(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        this.updateSnapshots(iAddress, iAddress2, iAddress3, iAddress4);
    }

    /* synthetic */ SelectionHistory$InternalMatchedChangedListener(SelectionHistory selectionHistory, SelectionHistory$1 selectionHistory$1) {
        this(selectionHistory);
    }
}

