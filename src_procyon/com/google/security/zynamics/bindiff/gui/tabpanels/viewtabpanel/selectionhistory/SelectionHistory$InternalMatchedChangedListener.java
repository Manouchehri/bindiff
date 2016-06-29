package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.graph.filter.*;

class SelectionHistory$InternalMatchedChangedListener implements IMatchesChangeListener
{
    final /* synthetic */ SelectionHistory this$0;
    
    private SelectionHistory$InternalMatchedChangedListener(final SelectionHistory this$0) {
        this.this$0 = this$0;
    }
    
    private BinDiffGraph getGraph() {
        return (this.this$0.singleGraph != null) ? this.this$0.singleGraph : this.this$0.combinedGraph;
    }
    
    private SingleDiffNode getNewDiffNode(final IAddress address) {
        for (final SingleDiffNode singleDiffNode : this.this$0.singleGraph.getNodes()) {
            if (singleDiffNode.getRawNode().getAddress().equals(address)) {
                return singleDiffNode;
            }
        }
        return null;
    }
    
    private CombinedDiffNode getNewDiffNode(final IAddress address, final ESide eSide) {
        for (final CombinedDiffNode combinedDiffNode : this.this$0.combinedGraph.getNodes()) {
            if (address.equals(((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getAddress(eSide))) {
                return combinedDiffNode;
            }
        }
        return null;
    }
    
    private void refreshSnapshots(final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        Preconditions.checkNotNull(combinedDiffNode, (Object)"Primary unmatched combined diff node can't be null.");
        Preconditions.checkNotNull(combinedDiffNode2, (Object)"Secondary unmatched combined diff node can't be null.");
        final IAddress address = combinedDiffNode.getRawNode().getAddress(ESide.PRIMARY);
        final IAddress address2 = combinedDiffNode2.getRawNode().getAddress(ESide.SECONDARY);
        for (final SelectionSnapshot selectionSnapshot : this.this$0.snapshotList) {
            for (final CombinedDiffNode combinedDiffNode3 : selectionSnapshot.getCombinedGraphSelection()) {
                if (address.equals(combinedDiffNode3.getRawNode().getAddress(ESide.PRIMARY)) && address2.equals(combinedDiffNode3.getRawNode().getAddress(ESide.SECONDARY))) {
                    selectionSnapshot.remove(combinedDiffNode3);
                    selectionSnapshot.add(combinedDiffNode);
                    selectionSnapshot.add(combinedDiffNode2);
                    selectionSnapshot.modicationFinished();
                    break;
                }
            }
        }
    }
    
    private void refreshSnapshots(final SingleDiffNode singleDiffNode) {
        Preconditions.checkNotNull(singleDiffNode, (Object)"New unmatched diff node cann't be null.");
        final IAddress address = singleDiffNode.getRawNode().getAddress();
        for (final SelectionSnapshot selectionSnapshot : this.this$0.snapshotList) {
            for (final SingleDiffNode singleDiffNode2 : selectionSnapshot.getSingleGraphSelection()) {
                if (singleDiffNode2.getRawNode().getAddress().equals(address)) {
                    selectionSnapshot.remove(singleDiffNode2);
                    selectionSnapshot.add(singleDiffNode);
                    selectionSnapshot.modicationFinished();
                    break;
                }
            }
        }
    }
    
    private void updateSnapshots(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        final BinDiffGraph graph = this.getGraph();
        if (graph.getGraphType() == EGraphType.CALLGRAPH) {
            return;
        }
        if (address.equals(graph.getPrimaryGraph().getFunctionAddress()) && address2.equals(graph.getSecondaryGraph().getFunctionAddress())) {
            if (this.this$0.singleGraph != null) {
                this.refreshSnapshots(this.getNewDiffNode((this.this$0.singleGraph.getSide() == ESide.PRIMARY) ? address3 : address4));
            }
            else {
                this.refreshSnapshots(this.getNewDiffNode(address3, ESide.PRIMARY), this.getNewDiffNode(address4, ESide.SECONDARY));
            }
        }
    }
    
    @Override
    public void addedBasicblockMatch(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        this.updateSnapshots(address, address2, address3, address4);
    }
    
    @Override
    public void removedBasicblockMatch(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        this.updateSnapshots(address, address2, address3, address4);
    }
}
