/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.filter;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.IGraphNodeMultiFilterListener;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphNodeMultiFilter {
    private final ListenerProvider listeners = new ListenerProvider();
    private final Diff diff;
    private EMatchStateFilter matchStateFilter;
    private ESelectionFilter selectionFilter;
    private EVisibilityFilter visibilityFilter;
    private ESideFilter sideFilter;
    private IAddress startRangeAddr;
    private IAddress endRangeAddr;
    private ESideFilter addrRangeSide;
    private boolean notify = false;
    final RawFlowGraph priFlowgraph;
    final RawFlowGraph secFlowgraph;

    public GraphNodeMultiFilter(Diff diff, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, IAddress iAddress, IAddress iAddress2, EMatchStateFilter eMatchStateFilter, ESelectionFilter eSelectionFilter, EVisibilityFilter eVisibilityFilter, ESideFilter eSideFilter) {
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.startRangeAddr = (IAddress)Preconditions.checkNotNull(iAddress);
        this.endRangeAddr = (IAddress)Preconditions.checkNotNull(iAddress2);
        this.matchStateFilter = (EMatchStateFilter)((Object)Preconditions.checkNotNull((Object)eMatchStateFilter));
        this.selectionFilter = (ESelectionFilter)((Object)Preconditions.checkNotNull((Object)eSelectionFilter));
        this.visibilityFilter = (EVisibilityFilter)((Object)Preconditions.checkNotNull((Object)eVisibilityFilter));
        this.sideFilter = (ESideFilter)((Object)Preconditions.checkNotNull((Object)eSideFilter));
        this.priFlowgraph = rawFlowGraph;
        this.secFlowgraph = rawFlowGraph2;
    }

    private boolean filterAddressRange(CombinedViewNode combinedViewNode) {
        String string;
        IAddress iAddress = combinedViewNode.getAddress(ESide.PRIMARY);
        IAddress iAddress2 = combinedViewNode.getAddress(ESide.SECONDARY);
        boolean bl2 = false;
        String string2 = this.startRangeAddr.toHexString();
        String string3 = this.endRangeAddr.toHexString();
        if (iAddress != null) {
            string = iAddress.toHexString();
            bl2 = string.compareTo(string2) >= 0 && string.compareTo(string3) <= 0;
        }
        if (iAddress2 == null) return bl2;
        if (bl2) return bl2;
        string = iAddress2.toHexString();
        if (string.compareTo(string2) < 0) return false;
        if (string.compareTo(string3) > 0) return false;
        return true;
    }

    private boolean filterAddressRange(SingleViewNode singleViewNode) {
        String string = singleViewNode.getAddress().toHexString();
        String string2 = this.startRangeAddr.toHexString();
        String string3 = this.endRangeAddr.toHexString();
        if (string.compareTo(string2) < 0) return false;
        if (string.compareTo(string3) > 0) return false;
        return true;
    }

    private boolean filterMatchState(CombinedViewNode combinedViewNode) {
        boolean bl2;
        if (this.matchStateFilter == EMatchStateFilter.NONE) {
            return true;
        }
        if (combinedViewNode.getMatchState() != EMatchState.MATCHED) {
            if (combinedViewNode.getMatchState() == EMatchState.MATCHED) return false;
            if (this.matchStateFilter != EMatchStateFilter.UNMATCHED) return false;
            return true;
        }
        if (this.matchStateFilter == EMatchStateFilter.MATCHED) {
            return true;
        }
        if (combinedViewNode instanceof RawCombinedBasicBlock) {
            boolean bl3 = false;
            RawBasicBlock rawBasicBlock = ((RawCombinedBasicBlock)combinedViewNode).getRawNode(ESide.PRIMARY);
            RawBasicBlock rawBasicBlock2 = ((RawCombinedBasicBlock)combinedViewNode).getRawNode(ESide.SECONDARY);
            bl3 = MatchesGetter.isIdenticalBasicblock(this.diff, rawBasicBlock, rawBasicBlock2);
            if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && bl3) {
                return true;
            }
            if (this.matchStateFilter != EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES) return false;
            if (bl3) return false;
            return true;
        }
        if (!(combinedViewNode instanceof RawCombinedFunction)) return false;
        RawFunction rawFunction = ((RawCombinedFunction)combinedViewNode).getRawNode(ESide.PRIMARY);
        boolean bl4 = rawFunction != null && rawFunction.isIdenticalMatch();
        boolean bl5 = rawFunction != null && rawFunction.isChangedInstructionsOnlyMatch();
        boolean bl6 = bl2 = rawFunction != null && rawFunction.isChangedStructuralMatch();
        if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && bl4) {
            return true;
        }
        if (this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && bl5) {
            return true;
        }
        if (this.matchStateFilter != EMatchStateFilter.MATCHED_STRUTURAL_CHANGES) return false;
        if (!bl2) return false;
        return true;
    }

    private boolean filterMatchState(RawBasicBlock rawBasicBlock, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2) {
        if (this.matchStateFilter == EMatchStateFilter.NONE) {
            return true;
        }
        if (rawBasicBlock.getMatchState() != EMatchState.MATCHED) {
            if (rawBasicBlock.getMatchState() == EMatchState.MATCHED) return false;
            if (this.matchStateFilter != EMatchStateFilter.UNMATCHED) return false;
            return true;
        }
        if (this.matchStateFilter == EMatchStateFilter.MATCHED) {
            return true;
        }
        boolean bl2 = false;
        ESide eSide = rawBasicBlock.getSide();
        RawBasicBlock rawBasicBlock2 = rawBasicBlock;
        RawBasicBlock rawBasicBlock3 = rawBasicBlock;
        if (eSide == ESide.PRIMARY) {
            BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(this.diff, rawBasicBlock);
            rawBasicBlock3 = rawFlowGraph2.getBasicblock(basicBlockMatchData.getIAddress(ESide.SECONDARY));
        } else {
            BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(this.diff, rawBasicBlock);
            rawBasicBlock2 = rawFlowGraph.getBasicblock(basicBlockMatchData.getIAddress(ESide.PRIMARY));
        }
        bl2 = MatchesGetter.isIdenticalBasicblock(this.diff, rawBasicBlock2, rawBasicBlock3);
        if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && bl2) {
            return true;
        }
        if (this.matchStateFilter != EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES) return false;
        if (bl2) return false;
        return true;
    }

    private boolean filterMatchState(RawFunction rawFunction) {
        if (this.matchStateFilter == EMatchStateFilter.NONE) {
            return true;
        }
        if (rawFunction.getMatchState() != EMatchState.MATCHED) {
            if (rawFunction.getMatchState() == EMatchState.MATCHED) return false;
            if (this.matchStateFilter != EMatchStateFilter.UNMATCHED) return false;
            return true;
        }
        if (this.matchStateFilter == EMatchStateFilter.MATCHED) {
            return true;
        }
        boolean bl2 = rawFunction.isIdenticalMatch();
        boolean bl3 = rawFunction.isChangedInstructionsOnlyMatch();
        boolean bl4 = rawFunction.isChangedStructuralMatch();
        if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && bl2) {
            return true;
        }
        if (this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && bl3) {
            return true;
        }
        if (this.matchStateFilter != EMatchStateFilter.MATCHED_STRUTURAL_CHANGES) return false;
        if (!bl4) return false;
        return true;
    }

    private boolean filterSelection(CombinedViewNode combinedViewNode) {
        if (this.selectionFilter == ESelectionFilter.NONE) {
            return true;
        }
        if (combinedViewNode.isSelected() && this.selectionFilter == ESelectionFilter.SELECTED) {
            return true;
        }
        if (combinedViewNode.isSelected()) return false;
        if (this.selectionFilter != ESelectionFilter.UNSELECTED) return false;
        return true;
    }

    private boolean filterSelection(SingleViewNode singleViewNode) {
        if (this.selectionFilter == ESelectionFilter.NONE) {
            return true;
        }
        if (singleViewNode.isSelected() && this.selectionFilter == ESelectionFilter.SELECTED) {
            return true;
        }
        if (singleViewNode.isSelected()) return false;
        if (this.selectionFilter != ESelectionFilter.UNSELECTED) return false;
        return true;
    }

    private boolean filterSide(CombinedViewNode combinedViewNode) {
        IAddress iAddress = combinedViewNode.getAddress(ESide.PRIMARY);
        IAddress iAddress2 = combinedViewNode.getAddress(ESide.SECONDARY);
        if (this.sideFilter == ESideFilter.NONE) {
            return true;
        }
        if (iAddress != null && this.sideFilter == ESideFilter.PRIMARY) {
            return true;
        }
        if (iAddress2 == null) return false;
        if (this.sideFilter != ESideFilter.SECONDARY) return false;
        return true;
    }

    private boolean filterSide(SingleViewNode singleViewNode) {
        if (this.sideFilter == ESideFilter.NONE) {
            return true;
        }
        if (singleViewNode.getSide() == ESide.PRIMARY && this.sideFilter == ESideFilter.PRIMARY) {
            return true;
        }
        if (singleViewNode.getSide() != ESide.SECONDARY) return false;
        if (this.sideFilter != ESideFilter.SECONDARY) return false;
        return true;
    }

    private boolean filterVisibility(CombinedViewNode combinedViewNode) {
        if (this.visibilityFilter == EVisibilityFilter.NONE) {
            return true;
        }
        if (combinedViewNode.isVisible() && this.visibilityFilter == EVisibilityFilter.VISIBLE) {
            return true;
        }
        if (combinedViewNode.isVisible()) return false;
        if (this.visibilityFilter != EVisibilityFilter.INVISIBLE) return false;
        return true;
    }

    private boolean filterVisibility(SingleViewNode singleViewNode) {
        if (this.visibilityFilter == EVisibilityFilter.NONE) {
            return true;
        }
        if (singleViewNode.isVisible() && this.visibilityFilter == EVisibilityFilter.VISIBLE) {
            return true;
        }
        if (singleViewNode.isVisible()) return false;
        if (this.visibilityFilter != EVisibilityFilter.INVISIBLE) return false;
        return true;
    }

    private void setAddressRangeFilter(IAddress iAddress, IAddress iAddress2) {
        if (this.startRangeAddr.equals(iAddress)) {
            if (this.endRangeAddr.equals(iAddress2)) return;
        }
        this.startRangeAddr = iAddress;
        this.endRangeAddr = iAddress2;
        this.notify = true;
    }

    private void setMatchStateFilter(EMatchStateFilter eMatchStateFilter) {
        if (this.matchStateFilter == eMatchStateFilter) return;
        this.matchStateFilter = eMatchStateFilter;
        this.notify = true;
    }

    private void setSelectionFilter(ESelectionFilter eSelectionFilter) {
        if (this.selectionFilter == eSelectionFilter) return;
        this.selectionFilter = eSelectionFilter;
        this.notify = true;
    }

    private void setSideFilter(ESideFilter eSideFilter) {
        if (eSideFilter == this.sideFilter) return;
        this.sideFilter = eSideFilter;
        this.notify = true;
    }

    private void setVisibilityFilter(EVisibilityFilter eVisibilityFilter) {
        if (this.visibilityFilter == eVisibilityFilter) return;
        this.visibilityFilter = eVisibilityFilter;
        this.notify = true;
    }

    public void addListener(IGraphNodeMultiFilterListener iGraphNodeMultiFilterListener) {
        this.listeners.addListener(iGraphNodeMultiFilterListener);
    }

    public void clearSettings(boolean bl2) {
        this.matchStateFilter = EMatchStateFilter.NONE;
        this.selectionFilter = ESelectionFilter.NONE;
        this.visibilityFilter = EVisibilityFilter.NONE;
        this.sideFilter = ESideFilter.NONE;
        this.startRangeAddr = new CAddress(0);
        this.endRangeAddr = new CAddress(-1);
        if (!bl2) return;
        this.notifyListeners();
    }

    public boolean filterRawBasicblock(RawBasicBlock rawBasicBlock) {
        if (rawBasicBlock == null) return false;
        if (!this.filterAddressRange(rawBasicBlock)) return false;
        if (!this.filterMatchState(rawBasicBlock, this.priFlowgraph, this.secFlowgraph)) return false;
        if (!this.filterSelection(rawBasicBlock)) return false;
        if (!this.filterVisibility(rawBasicBlock)) return false;
        if (!this.filterSide(rawBasicBlock)) return false;
        return true;
    }

    public boolean filterRawCombinedBasicblock(RawCombinedBasicBlock rawCombinedBasicBlock) {
        if (rawCombinedBasicBlock == null) return false;
        if (!this.filterAddressRange(rawCombinedBasicBlock)) return false;
        if (!this.filterMatchState(rawCombinedBasicBlock)) return false;
        if (!this.filterSelection(rawCombinedBasicBlock)) return false;
        if (!this.filterVisibility(rawCombinedBasicBlock)) return false;
        if (!this.filterSide(rawCombinedBasicBlock)) return false;
        return true;
    }

    public List filterRawCombinedBasicblocks(List list) {
        Preconditions.checkNotNull((Object)this.addrRangeSide);
        ArrayList<RawCombinedBasicBlock> arrayList = new ArrayList<RawCombinedBasicBlock>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)iterator.next();
            if (!this.filterRawCombinedBasicblock(rawCombinedBasicBlock)) continue;
            arrayList.add(rawCombinedBasicBlock);
        }
        return arrayList;
    }

    public boolean filterRawCombinedFunction(RawCombinedFunction rawCombinedFunction) {
        if (rawCombinedFunction == null) return false;
        if (!this.filterAddressRange(rawCombinedFunction)) return false;
        if (!this.filterMatchState(rawCombinedFunction)) return false;
        if (!this.filterSelection(rawCombinedFunction)) return false;
        if (!this.filterVisibility(rawCombinedFunction)) return false;
        if (!this.filterSide(rawCombinedFunction)) return false;
        return true;
    }

    public List filterRawCombinedFunctions(List list) {
        Preconditions.checkNotNull((Object)this.addrRangeSide);
        ArrayList<RawCombinedFunction> arrayList = new ArrayList<RawCombinedFunction>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)iterator.next();
            if (!this.filterRawCombinedFunction(rawCombinedFunction)) continue;
            arrayList.add(rawCombinedFunction);
        }
        return arrayList;
    }

    public boolean filterRawFunction(RawFunction rawFunction) {
        if (rawFunction == null) return false;
        if (!this.filterAddressRange(rawFunction)) return false;
        if (!this.filterMatchState(rawFunction)) return false;
        if (!this.filterSelection(rawFunction)) return false;
        if (!this.filterVisibility(rawFunction)) return false;
        if (!this.filterSide(rawFunction)) return false;
        return true;
    }

    public List filterRawFunctions(List list) {
        ArrayList<RawFunction> arrayList = new ArrayList<RawFunction>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction = (RawFunction)iterator.next();
            if (!this.filterRawFunction(rawFunction)) continue;
            arrayList.add(rawFunction);
        }
        return arrayList;
    }

    public ESelectionFilter getSelectionFilterValue() {
        return this.selectionFilter;
    }

    public EVisibilityFilter getVisibilityFilterValue() {
        return this.visibilityFilter;
    }

    public void notifyListeners() {
        if (!this.notify) return;
        Iterator iterator = this.listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                this.notify = false;
                return;
            }
            IGraphNodeMultiFilterListener iGraphNodeMultiFilterListener = (IGraphNodeMultiFilterListener)iterator.next();
            iGraphNodeMultiFilterListener.filterChanged(this);
        } while (true);
    }

    public void removeListener(IGraphNodeMultiFilterListener iGraphNodeMultiFilterListener) {
        this.listeners.removeListener(iGraphNodeMultiFilterListener);
    }

    public void setFilter(IAddress iAddress, IAddress iAddress2, EMatchStateFilter eMatchStateFilter, ESelectionFilter eSelectionFilter, EVisibilityFilter eVisibilityFilter, ESideFilter eSideFilter, boolean bl2) {
        this.setAddressRangeFilter(iAddress, iAddress2);
        this.setMatchStateFilter(eMatchStateFilter);
        this.setSelectionFilter(eSelectionFilter);
        this.setVisibilityFilter(eVisibilityFilter);
        this.setSideFilter(eSideFilter);
        if (!bl2) return;
        this.notifyListeners();
    }
}

