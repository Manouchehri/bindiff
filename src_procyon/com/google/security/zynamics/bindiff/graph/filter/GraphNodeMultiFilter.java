package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;

public class GraphNodeMultiFilter
{
    private final ListenerProvider listeners;
    private final Diff diff;
    private EMatchStateFilter matchStateFilter;
    private ESelectionFilter selectionFilter;
    private EVisibilityFilter visibilityFilter;
    private ESideFilter sideFilter;
    private IAddress startRangeAddr;
    private IAddress endRangeAddr;
    private ESideFilter addrRangeSide;
    private boolean notify;
    final RawFlowGraph priFlowgraph;
    final RawFlowGraph secFlowgraph;
    
    public GraphNodeMultiFilter(final Diff diff, final RawFlowGraph priFlowgraph, final RawFlowGraph secFlowgraph, final IAddress address, final IAddress address2, final EMatchStateFilter eMatchStateFilter, final ESelectionFilter eSelectionFilter, final EVisibilityFilter eVisibilityFilter, final ESideFilter eSideFilter) {
        this.listeners = new ListenerProvider();
        this.notify = false;
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.startRangeAddr = (IAddress)Preconditions.checkNotNull(address);
        this.endRangeAddr = (IAddress)Preconditions.checkNotNull(address2);
        this.matchStateFilter = (EMatchStateFilter)Preconditions.checkNotNull(eMatchStateFilter);
        this.selectionFilter = (ESelectionFilter)Preconditions.checkNotNull(eSelectionFilter);
        this.visibilityFilter = (EVisibilityFilter)Preconditions.checkNotNull(eVisibilityFilter);
        this.sideFilter = (ESideFilter)Preconditions.checkNotNull(eSideFilter);
        this.priFlowgraph = priFlowgraph;
        this.secFlowgraph = secFlowgraph;
    }
    
    private boolean filterAddressRange(final CombinedViewNode combinedViewNode) {
        final IAddress address = combinedViewNode.getAddress(ESide.PRIMARY);
        final IAddress address2 = combinedViewNode.getAddress(ESide.SECONDARY);
        boolean b = false;
        final String hexString = this.startRangeAddr.toHexString();
        final String hexString2 = this.endRangeAddr.toHexString();
        if (address != null) {
            final String hexString3 = address.toHexString();
            b = (hexString3.compareTo(hexString) >= 0 && hexString3.compareTo(hexString2) <= 0);
        }
        if (address2 != null && !b) {
            final String hexString4 = address2.toHexString();
            b = (hexString4.compareTo(hexString) >= 0 && hexString4.compareTo(hexString2) <= 0);
        }
        return b;
    }
    
    private boolean filterAddressRange(final SingleViewNode singleViewNode) {
        final String hexString = singleViewNode.getAddress().toHexString();
        final String hexString2 = this.startRangeAddr.toHexString();
        final String hexString3 = this.endRangeAddr.toHexString();
        return hexString.compareTo(hexString2) >= 0 && hexString.compareTo(hexString3) <= 0;
    }
    
    private boolean filterMatchState(final CombinedViewNode combinedViewNode) {
        if (this.matchStateFilter == EMatchStateFilter.NONE) {
            return true;
        }
        if (combinedViewNode.getMatchState() == EMatchState.MATCHED) {
            if (this.matchStateFilter == EMatchStateFilter.MATCHED) {
                return true;
            }
            if (combinedViewNode instanceof RawCombinedBasicBlock) {
                final boolean identicalBasicblock = MatchesGetter.isIdenticalBasicblock(this.diff, ((RawCombinedBasicBlock)combinedViewNode).getRawNode(ESide.PRIMARY), ((RawCombinedBasicBlock)combinedViewNode).getRawNode(ESide.SECONDARY));
                if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && identicalBasicblock) {
                    return true;
                }
                if (this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && !identicalBasicblock) {
                    return true;
                }
            }
            else if (combinedViewNode instanceof RawCombinedFunction) {
                final RawFunction rawNode = ((RawCombinedFunction)combinedViewNode).getRawNode(ESide.PRIMARY);
                final boolean b = rawNode != null && rawNode.isIdenticalMatch();
                final boolean b2 = rawNode != null && rawNode.isChangedInstructionsOnlyMatch();
                final boolean b3 = rawNode != null && rawNode.isChangedStructuralMatch();
                if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && b) {
                    return true;
                }
                if (this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && b2) {
                    return true;
                }
                if (this.matchStateFilter == EMatchStateFilter.MATCHED_STRUTURAL_CHANGES && b3) {
                    return true;
                }
            }
        }
        else if (combinedViewNode.getMatchState() != EMatchState.MATCHED && this.matchStateFilter == EMatchStateFilter.UNMATCHED) {
            return true;
        }
        return false;
    }
    
    private boolean filterMatchState(final RawBasicBlock rawBasicBlock, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2) {
        if (this.matchStateFilter == EMatchStateFilter.NONE) {
            return true;
        }
        if (rawBasicBlock.getMatchState() == EMatchState.MATCHED) {
            if (this.matchStateFilter == EMatchStateFilter.MATCHED) {
                return true;
            }
            final ESide side = rawBasicBlock.getSide();
            RawBasicBlock basicblock = rawBasicBlock;
            RawBasicBlock basicblock2 = rawBasicBlock;
            if (side == ESide.PRIMARY) {
                basicblock2 = rawFlowGraph2.getBasicblock(MatchesGetter.getBasicblockMatch(this.diff, rawBasicBlock).getIAddress(ESide.SECONDARY));
            }
            else {
                basicblock = rawFlowGraph.getBasicblock(MatchesGetter.getBasicblockMatch(this.diff, rawBasicBlock).getIAddress(ESide.PRIMARY));
            }
            final boolean identicalBasicblock = MatchesGetter.isIdenticalBasicblock(this.diff, basicblock, basicblock2);
            if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && identicalBasicblock) {
                return true;
            }
            if (this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && !identicalBasicblock) {
                return true;
            }
        }
        else if (rawBasicBlock.getMatchState() != EMatchState.MATCHED && this.matchStateFilter == EMatchStateFilter.UNMATCHED) {
            return true;
        }
        return false;
    }
    
    private boolean filterMatchState(final RawFunction rawFunction) {
        if (this.matchStateFilter == EMatchStateFilter.NONE) {
            return true;
        }
        if (rawFunction.getMatchState() == EMatchState.MATCHED) {
            if (this.matchStateFilter == EMatchStateFilter.MATCHED) {
                return true;
            }
            final boolean identicalMatch = rawFunction.isIdenticalMatch();
            final boolean changedInstructionsOnlyMatch = rawFunction.isChangedInstructionsOnlyMatch();
            final boolean changedStructuralMatch = rawFunction.isChangedStructuralMatch();
            if (this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && identicalMatch) {
                return true;
            }
            if (this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && changedInstructionsOnlyMatch) {
                return true;
            }
            if (this.matchStateFilter == EMatchStateFilter.MATCHED_STRUTURAL_CHANGES && changedStructuralMatch) {
                return true;
            }
        }
        else if (rawFunction.getMatchState() != EMatchState.MATCHED && this.matchStateFilter == EMatchStateFilter.UNMATCHED) {
            return true;
        }
        return false;
    }
    
    private boolean filterSelection(final CombinedViewNode combinedViewNode) {
        return this.selectionFilter == ESelectionFilter.NONE || (combinedViewNode.isSelected() && this.selectionFilter == ESelectionFilter.SELECTED) || (!combinedViewNode.isSelected() && this.selectionFilter == ESelectionFilter.UNSELECTED);
    }
    
    private boolean filterSelection(final SingleViewNode singleViewNode) {
        return this.selectionFilter == ESelectionFilter.NONE || (singleViewNode.isSelected() && this.selectionFilter == ESelectionFilter.SELECTED) || (!singleViewNode.isSelected() && this.selectionFilter == ESelectionFilter.UNSELECTED);
    }
    
    private boolean filterSide(final CombinedViewNode combinedViewNode) {
        final IAddress address = combinedViewNode.getAddress(ESide.PRIMARY);
        final IAddress address2 = combinedViewNode.getAddress(ESide.SECONDARY);
        return this.sideFilter == ESideFilter.NONE || (address != null && this.sideFilter == ESideFilter.PRIMARY) || (address2 != null && this.sideFilter == ESideFilter.SECONDARY);
    }
    
    private boolean filterSide(final SingleViewNode singleViewNode) {
        return this.sideFilter == ESideFilter.NONE || (singleViewNode.getSide() == ESide.PRIMARY && this.sideFilter == ESideFilter.PRIMARY) || (singleViewNode.getSide() == ESide.SECONDARY && this.sideFilter == ESideFilter.SECONDARY);
    }
    
    private boolean filterVisibility(final CombinedViewNode combinedViewNode) {
        return this.visibilityFilter == EVisibilityFilter.NONE || (combinedViewNode.isVisible() && this.visibilityFilter == EVisibilityFilter.VISIBLE) || (!combinedViewNode.isVisible() && this.visibilityFilter == EVisibilityFilter.INVISIBLE);
    }
    
    private boolean filterVisibility(final SingleViewNode singleViewNode) {
        return this.visibilityFilter == EVisibilityFilter.NONE || (singleViewNode.isVisible() && this.visibilityFilter == EVisibilityFilter.VISIBLE) || (!singleViewNode.isVisible() && this.visibilityFilter == EVisibilityFilter.INVISIBLE);
    }
    
    private void setAddressRangeFilter(final IAddress startRangeAddr, final IAddress endRangeAddr) {
        if (!this.startRangeAddr.equals(startRangeAddr) || !this.endRangeAddr.equals(endRangeAddr)) {
            this.startRangeAddr = startRangeAddr;
            this.endRangeAddr = endRangeAddr;
            this.notify = true;
        }
    }
    
    private void setMatchStateFilter(final EMatchStateFilter matchStateFilter) {
        if (this.matchStateFilter != matchStateFilter) {
            this.matchStateFilter = matchStateFilter;
            this.notify = true;
        }
    }
    
    private void setSelectionFilter(final ESelectionFilter selectionFilter) {
        if (this.selectionFilter != selectionFilter) {
            this.selectionFilter = selectionFilter;
            this.notify = true;
        }
    }
    
    private void setSideFilter(final ESideFilter sideFilter) {
        if (sideFilter != this.sideFilter) {
            this.sideFilter = sideFilter;
            this.notify = true;
        }
    }
    
    private void setVisibilityFilter(final EVisibilityFilter visibilityFilter) {
        if (this.visibilityFilter != visibilityFilter) {
            this.visibilityFilter = visibilityFilter;
            this.notify = true;
        }
    }
    
    public void addListener(final IGraphNodeMultiFilterListener graphNodeMultiFilterListener) {
        this.listeners.addListener(graphNodeMultiFilterListener);
    }
    
    public void clearSettings(final boolean b) {
        this.matchStateFilter = EMatchStateFilter.NONE;
        this.selectionFilter = ESelectionFilter.NONE;
        this.visibilityFilter = EVisibilityFilter.NONE;
        this.sideFilter = ESideFilter.NONE;
        this.startRangeAddr = new CAddress(0L);
        this.endRangeAddr = new CAddress(-1L);
        if (b) {
            this.notifyListeners();
        }
    }
    
    public boolean filterRawBasicblock(final RawBasicBlock rawBasicBlock) {
        return rawBasicBlock != null && this.filterAddressRange(rawBasicBlock) && this.filterMatchState(rawBasicBlock, this.priFlowgraph, this.secFlowgraph) && this.filterSelection(rawBasicBlock) && this.filterVisibility(rawBasicBlock) && this.filterSide(rawBasicBlock);
    }
    
    public boolean filterRawCombinedBasicblock(final RawCombinedBasicBlock rawCombinedBasicBlock) {
        return rawCombinedBasicBlock != null && this.filterAddressRange(rawCombinedBasicBlock) && this.filterMatchState(rawCombinedBasicBlock) && this.filterSelection(rawCombinedBasicBlock) && this.filterVisibility(rawCombinedBasicBlock) && this.filterSide(rawCombinedBasicBlock);
    }
    
    public List filterRawCombinedBasicblocks(final List list) {
        Preconditions.checkNotNull(this.addrRangeSide);
        final ArrayList<RawCombinedBasicBlock> list2 = new ArrayList<RawCombinedBasicBlock>();
        for (final RawCombinedBasicBlock rawCombinedBasicBlock : list) {
            if (this.filterRawCombinedBasicblock(rawCombinedBasicBlock)) {
                list2.add(rawCombinedBasicBlock);
            }
        }
        return list2;
    }
    
    public boolean filterRawCombinedFunction(final RawCombinedFunction rawCombinedFunction) {
        return rawCombinedFunction != null && this.filterAddressRange(rawCombinedFunction) && this.filterMatchState(rawCombinedFunction) && this.filterSelection(rawCombinedFunction) && this.filterVisibility(rawCombinedFunction) && this.filterSide(rawCombinedFunction);
    }
    
    public List filterRawCombinedFunctions(final List list) {
        Preconditions.checkNotNull(this.addrRangeSide);
        final ArrayList<RawCombinedFunction> list2 = new ArrayList<RawCombinedFunction>();
        for (final RawCombinedFunction rawCombinedFunction : list) {
            if (this.filterRawCombinedFunction(rawCombinedFunction)) {
                list2.add(rawCombinedFunction);
            }
        }
        return list2;
    }
    
    public boolean filterRawFunction(final RawFunction rawFunction) {
        return rawFunction != null && this.filterAddressRange(rawFunction) && this.filterMatchState(rawFunction) && this.filterSelection(rawFunction) && this.filterVisibility(rawFunction) && this.filterSide(rawFunction);
    }
    
    public List filterRawFunctions(final List list) {
        final ArrayList<RawFunction> list2 = new ArrayList<RawFunction>();
        for (final RawFunction rawFunction : list) {
            if (this.filterRawFunction(rawFunction)) {
                list2.add(rawFunction);
            }
        }
        return list2;
    }
    
    public ESelectionFilter getSelectionFilterValue() {
        return this.selectionFilter;
    }
    
    public EVisibilityFilter getVisibilityFilterValue() {
        return this.visibilityFilter;
    }
    
    public void notifyListeners() {
        if (this.notify) {
            final Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().filterChanged(this);
            }
            this.notify = false;
        }
    }
    
    public void removeListener(final IGraphNodeMultiFilterListener graphNodeMultiFilterListener) {
        this.listeners.removeListener(graphNodeMultiFilterListener);
    }
    
    public void setFilter(final IAddress address, final IAddress address2, final EMatchStateFilter matchStateFilter, final ESelectionFilter selectionFilter, final EVisibilityFilter visibilityFilter, final ESideFilter sideFilter, final boolean b) {
        this.setAddressRangeFilter(address, address2);
        this.setMatchStateFilter(matchStateFilter);
        this.setSelectionFilter(selectionFilter);
        this.setVisibilityFilter(visibilityFilter);
        this.setSideFilter(sideFilter);
        if (b) {
            this.notifyListeners();
        }
    }
}
