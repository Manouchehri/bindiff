package com.google.security.zynamics.bindiff.project.helpers;

import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.*;

public final class GraphGetter
{
    public static RawCall getCall(final RawCallGraph rawCallGraph, final IAddress address, final IAddress address2, final IAddress address3) {
        final RawFunction function = rawCallGraph.getFunction(address);
        if (function != null) {
            for (final RawCall rawCall : function.getOutgoingEdges()) {
                if (rawCall.getSourceInstructionAddr().equals(address3) && ((RawFunction)rawCall.getTarget()).getAddress().equals(address2)) {
                    return rawCall;
                }
            }
        }
        return null;
    }
    
    public static List getCallees(final RawFunction rawFunction) {
        final ArrayList list = new ArrayList();
        list.addAll(rawFunction.getCallees());
        return list;
    }
    
    public static List getCallers(final RawFunction rawFunction) {
        final ArrayList list = new ArrayList();
        list.addAll(rawFunction.getCallers());
        return list;
    }
    
    public static List getCallsAt(final RawCallGraph rawCallGraph, final IAddress address, final IAddress address2) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : rawCallGraph.getFunction(address).getOutgoingEdges()) {
            if (rawCall.getSourceInstructionAddr().equals(address2)) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static Set getChangedFunctionPairs(final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2) {
        final Set matchedFunctionPairs = getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        final HashSet<Pair> set = new HashSet<Pair>();
        for (final Pair pair : matchedFunctionPairs) {
            final RawFunction rawFunction = (RawFunction)pair.first();
            final RawFunction rawFunction2 = (RawFunction)pair.second();
            final int sizeOfMatchedInstructions = rawFunction.getFunctionMatch().getSizeOfMatchedInstructions();
            if (rawFunction.getSizeOfUnmatchedBasicblocks() != 0 || rawFunction.getSizeOfUnmatchedJumps() != 0 || rawFunction2.getSizeOfUnmatchedBasicblocks() != 0 || rawFunction2.getSizeOfUnmatchedJumps() != 0 || rawFunction.getSizeOfInstructions() != sizeOfMatchedInstructions || rawFunction2.getSizeOfInstructions() != sizeOfMatchedInstructions) {
                set.add(new Pair(rawFunction, rawFunction2));
            }
        }
        return set;
    }
    
    public static SingleDiffNode getDiffNode(final GraphsContainer graphsContainer, final RawBasicBlock rawBasicBlock) {
        return (SingleDiffNode)((rawBasicBlock.getSide() == ESide.PRIMARY) ? graphsContainer.getPrimaryGraph().getNode(rawBasicBlock) : ((SingleDiffNode)graphsContainer.getSecondaryGraph().getNode(rawBasicBlock)));
    }
    
    public static RawFunction getFunction(final Diff diff, final RawBasicBlock rawBasicBlock) {
        return diff.getCallgraph(rawBasicBlock.getSide()).getFunction(rawBasicBlock.getFunctionAddr());
    }
    
    public static RawFunction getFunction(final Diff diff, final RawFlowGraph rawFlowGraph) {
        if (rawFlowGraph == null) {
            return null;
        }
        return diff.getCallgraph(rawFlowGraph.getSide()).getFunction(rawFlowGraph.getAddress());
    }
    
    public static Set getIdenticalFunctionPairs(final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2) {
        final Set matchedFunctionPairs = getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        final HashSet<Pair> set = new HashSet<Pair>();
        for (final Pair pair : matchedFunctionPairs) {
            final RawFunction rawFunction = (RawFunction)pair.first();
            final RawFunction rawFunction2 = (RawFunction)pair.second();
            if (MatchesGetter.isIdenticalFunctionPair(rawFunction, rawFunction2)) {
                set.add(new Pair(rawFunction, rawFunction2));
            }
        }
        return set;
    }
    
    public static Collection getIncomingJumps(final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawJump> list = new ArrayList<RawJump>();
        for (final SingleViewEdge singleViewEdge : rawBasicBlock.getIncomingEdges()) {
            if (singleViewEdge instanceof RawJump) {
                list.add((RawJump)singleViewEdge);
            }
        }
        return list;
    }
    
    public static Set getInstructionOnlyChangedFunctionPairs(final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2) {
        final Set matchedFunctionPairs = getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        final HashSet<Pair> set = new HashSet<Pair>();
        for (final Pair pair : matchedFunctionPairs) {
            final RawFunction rawFunction = (RawFunction)pair.first();
            final RawFunction rawFunction2 = (RawFunction)pair.second();
            if (MatchesGetter.isInstructionsOnlyChangedFunctionPair(rawFunction, rawFunction2)) {
                set.add(new Pair(rawFunction, rawFunction2));
            }
        }
        return set;
    }
    
    public static List getMatchedCallees(final RawFunction rawFunction) {
        final HashSet<RawFunction> set = new HashSet<RawFunction>();
        for (final RawFunction rawFunction2 : rawFunction.getCallees()) {
            if (rawFunction2.getMatchState() == EMatchState.MATCHED) {
                set.add(rawFunction2);
            }
        }
        final ArrayList list = new ArrayList();
        list.addAll(set);
        return list;
    }
    
    public static List getMatchedCallers(final RawFunction rawFunction) {
        final HashSet<RawFunction> set = new HashSet<RawFunction>();
        for (final RawFunction rawFunction2 : rawFunction.getCallers()) {
            if (rawFunction2.getMatchState() == EMatchState.MATCHED) {
                set.add(rawFunction2);
            }
        }
        final ArrayList list = new ArrayList();
        list.addAll(set);
        return list;
    }
    
    public static Set getMatchedFunctionPairs(final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2) {
        final HashSet<Pair> set = new HashSet<Pair>();
        for (final RawFunction rawFunction : rawCallGraph.getNodes()) {
            if (rawFunction.getMatchState() == EMatchState.MATCHED) {
                set.add(new Pair(rawFunction, rawCallGraph2.getFunction(rawFunction.getMatchedFunctionAddress())));
            }
        }
        return set;
    }
    
    public static List getMatchedIncomingCalls(final RawFunction rawFunction) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : rawFunction.getIncomingEdges()) {
            if (rawCall.getMatchState() == EMatchState.MATCHED || rawCall.isChanged()) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static Collection getMatchedIncomingJumps(final Diff diff, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawJump> list = new ArrayList<RawJump>();
        final BasicBlockMatchData basicblockMatch = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicblockMatch == null) {
            return list;
        }
        final RawFlowGraph rawFlowGraph3 = (rawBasicBlock.getSide() == ESide.PRIMARY) ? rawFlowGraph2 : rawFlowGraph;
        for (final RawJump rawJump : getIncomingJumps(rawBasicBlock)) {
            final BasicBlockMatchData basicblockMatch2 = MatchesGetter.getBasicblockMatch(diff, rawJump.getTarget());
            if (basicblockMatch2 != null) {
                IAddress address;
                IAddress address2;
                if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                    address = basicblockMatch.getIAddress(ESide.SECONDARY);
                    address2 = basicblockMatch2.getIAddress(ESide.SECONDARY);
                }
                else {
                    address = basicblockMatch.getIAddress(ESide.PRIMARY);
                    address2 = basicblockMatch2.getIAddress(ESide.PRIMARY);
                }
                if (rawFlowGraph3.getJump(address, address2) == null) {
                    continue;
                }
                list.add(rawJump);
            }
        }
        return list;
    }
    
    public static List getMatchedOutgoingCalls(final Diff diff, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : getOutgoingCalls(diff, rawBasicBlock)) {
            if (rawCall.getMatchState() == EMatchState.MATCHED || rawCall.isChanged()) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static List getMatchedOutgoingCalls(final RawFunction rawFunction) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : rawFunction.getOutgoingEdges()) {
            if (rawCall.getMatchState() == EMatchState.MATCHED || rawCall.isChanged()) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static Collection getMatchedOutgoingJumps(final Diff diff, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawJump> list = new ArrayList<RawJump>();
        final BasicBlockMatchData basicblockMatch = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicblockMatch == null) {
            return list;
        }
        final RawFlowGraph rawFlowGraph3 = (rawBasicBlock.getSide() == ESide.PRIMARY) ? rawFlowGraph2 : rawFlowGraph;
        for (final RawJump rawJump : getOutgoingJumps(rawBasicBlock)) {
            final BasicBlockMatchData basicblockMatch2 = MatchesGetter.getBasicblockMatch(diff, rawJump.getTarget());
            if (basicblockMatch2 != null) {
                IAddress address;
                IAddress address2;
                if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                    address = basicblockMatch.getIAddress(ESide.SECONDARY);
                    address2 = basicblockMatch2.getIAddress(ESide.SECONDARY);
                }
                else {
                    address = basicblockMatch.getIAddress(ESide.PRIMARY);
                    address2 = basicblockMatch2.getIAddress(ESide.PRIMARY);
                }
                if (rawFlowGraph3.getJump(address, address2) == null) {
                    continue;
                }
                list.add(rawJump);
            }
        }
        return list;
    }
    
    public static IAddress getMaxAddress(final List list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Comparable<CAddress> comparable = (Comparable<CAddress>)new CAddress(0L);
        final Iterator<RawBasicBlock> iterator = list.iterator();
        while (iterator.hasNext()) {
            final IAddress address = iterator.next().getAddress();
            if (address.compareTo((CAddress)comparable) > 0) {
                comparable = (Comparable<CAddress>)address;
            }
        }
        return (IAddress)comparable;
    }
    
    public static IAddress getMinAddress(final List list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Comparable<CAddress> comparable = (Comparable<CAddress>)new CAddress(-1L);
        final Iterator<RawBasicBlock> iterator = list.iterator();
        while (iterator.hasNext()) {
            final IAddress address = iterator.next().getAddress();
            if (address.compareTo((CAddress)comparable) < 0) {
                comparable = (Comparable<CAddress>)address;
            }
        }
        return (IAddress)comparable;
    }
    
    public static SingleGraph getOtherGraph(final SingleGraph singleGraph) {
        return (singleGraph.getSide() == ESide.PRIMARY) ? singleGraph.getSecondaryGraph() : singleGraph.getPrimaryGraph();
    }
    
    public static List getOutgoingCalls(final Diff diff, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : getFunction(diff, rawBasicBlock).getOutgoingEdges()) {
            if (rawBasicBlock.getInstruction(rawCall.getSourceInstructionAddr()) != null) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static Collection getOutgoingJumps(final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawJump> list = new ArrayList<RawJump>();
        for (final SingleViewEdge singleViewEdge : rawBasicBlock.getOutgoingEdges()) {
            if (singleViewEdge instanceof RawJump) {
                list.add((RawJump)singleViewEdge);
            }
        }
        return list;
    }
    
    public static SingleDiffNode getPrimaryDiffNode(final SingleGraph singleGraph, final RawBasicBlock rawBasicBlock) {
        return ((SingleDiffNode)singleGraph.getSecondaryGraph().getNode(rawBasicBlock)).getOtherSideDiffNode();
    }
    
    public static RawBasicBlock getPrimaryRawBasicblock(final GraphsContainer graphsContainer, final RawBasicBlock rawBasicBlock) {
        final SingleDiffNode otherSideDiffNode = getDiffNode(graphsContainer, rawBasicBlock).getOtherSideDiffNode();
        if (otherSideDiffNode != null) {
            return (RawBasicBlock)otherSideDiffNode.getRawNode();
        }
        return null;
    }
    
    public static RawFunction getRawFunction(final Diff diff, final RawFlowGraph rawFlowGraph) {
        return diff.getCallgraph(rawFlowGraph.getSide()).getFunction(rawFlowGraph.getAddress());
    }
    
    public static SingleDiffNode getSecondaryDiffNode(final SingleGraph singleGraph, final RawBasicBlock rawBasicBlock) {
        return ((SingleDiffNode)singleGraph.getPrimaryGraph().getNode(rawBasicBlock)).getOtherSideDiffNode();
    }
    
    public static RawBasicBlock getSecondaryRawBasicblock(final GraphsContainer graphsContainer, final RawBasicBlock rawBasicBlock) {
        final SingleDiffNode otherSideDiffNode = getDiffNode(graphsContainer, rawBasicBlock).getOtherSideDiffNode();
        if (otherSideDiffNode != null) {
            return (RawBasicBlock)otherSideDiffNode.getRawNode();
        }
        return null;
    }
    
    public static Set getStructuralChangedFunctionPairs(final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2) {
        final Set matchedFunctionPairs = getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        final HashSet<Pair> set = new HashSet<Pair>();
        for (final Pair pair : matchedFunctionPairs) {
            final RawFunction rawFunction = (RawFunction)pair.first();
            final RawFunction rawFunction2 = (RawFunction)pair.second();
            if (MatchesGetter.isStructuralChangedFunctionPair(rawFunction, rawFunction2)) {
                set.add(new Pair(rawFunction, rawFunction2));
            }
        }
        return set;
    }
    
    public static List getUnmatchedCallees(final RawFunction rawFunction) {
        final HashSet<RawFunction> set = new HashSet<RawFunction>();
        for (final RawFunction rawFunction2 : rawFunction.getCallees()) {
            if (rawFunction2.getMatchState() != EMatchState.MATCHED) {
                set.add(rawFunction2);
            }
        }
        final ArrayList list = new ArrayList();
        list.addAll(set);
        return list;
    }
    
    public static List getUnmatchedCallers(final RawFunction rawFunction) {
        final HashSet<RawFunction> set = new HashSet<RawFunction>();
        for (final RawFunction rawFunction2 : rawFunction.getCallees()) {
            if (rawFunction2.getMatchState() != EMatchState.MATCHED) {
                set.add(rawFunction2);
            }
        }
        final ArrayList list = new ArrayList();
        list.addAll(set);
        return list;
    }
    
    public static List getUnmatchedFunctions(final RawCallGraph rawCallGraph) {
        final ArrayList<RawFunction> list = new ArrayList<RawFunction>();
        for (final RawFunction rawFunction : rawCallGraph.getNodes()) {
            if (rawFunction.getMatchState() != EMatchState.MATCHED) {
                list.add(rawFunction);
            }
        }
        return list;
    }
    
    public static List getUnmatchedIncomingCalls(final RawFunction rawFunction) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : rawFunction.getIncomingEdges()) {
            if (rawCall.getMatchState() != EMatchState.MATCHED && !rawCall.isChanged()) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static Collection getUnmatchedIncomingJumps(final Diff diff, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawJump> list = new ArrayList<RawJump>();
        final BasicBlockMatchData basicblockMatch = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicblockMatch == null) {
            return getIncomingJumps(rawBasicBlock);
        }
        final RawFlowGraph rawFlowGraph3 = (rawBasicBlock.getSide() == ESide.PRIMARY) ? rawFlowGraph2 : rawFlowGraph;
        for (final RawJump rawJump : getIncomingJumps(rawBasicBlock)) {
            final BasicBlockMatchData basicblockMatch2 = MatchesGetter.getBasicblockMatch(diff, rawJump.getSource());
            if (basicblockMatch2 != null) {
                IAddress address;
                IAddress address2;
                if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                    address = basicblockMatch.getIAddress(ESide.SECONDARY);
                    address2 = basicblockMatch2.getIAddress(ESide.SECONDARY);
                }
                else {
                    address = basicblockMatch.getIAddress(ESide.PRIMARY);
                    address2 = basicblockMatch2.getIAddress(ESide.PRIMARY);
                }
                if (rawFlowGraph3.getJump(address2, address) != null) {
                    continue;
                }
                list.add(rawJump);
            }
            else {
                list.add(rawJump);
            }
        }
        return list;
    }
    
    public static List getUnmatchedOutgoingCalls(final Diff diff, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : getOutgoingCalls(diff, rawBasicBlock)) {
            if (rawCall.getMatchState() != EMatchState.MATCHED && !rawCall.isChanged()) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static List getUnmatchedOutgoingCalls(final RawFunction rawFunction) {
        final ArrayList<RawCall> list = new ArrayList<RawCall>();
        for (final RawCall rawCall : rawFunction.getOutgoingEdges()) {
            if (rawCall.getMatchState() != EMatchState.MATCHED && !rawCall.isChanged()) {
                list.add(rawCall);
            }
        }
        return list;
    }
    
    public static Collection getUnmatchedOutgoingJumps(final Diff diff, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2, final RawBasicBlock rawBasicBlock) {
        final ArrayList<RawJump> list = new ArrayList<RawJump>();
        final BasicBlockMatchData basicblockMatch = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicblockMatch == null) {
            return getOutgoingJumps(rawBasicBlock);
        }
        final RawFlowGraph rawFlowGraph3 = (rawBasicBlock.getSide() == ESide.PRIMARY) ? rawFlowGraph2 : rawFlowGraph;
        for (final RawJump rawJump : getOutgoingJumps(rawBasicBlock)) {
            final BasicBlockMatchData basicblockMatch2 = MatchesGetter.getBasicblockMatch(diff, rawJump.getTarget());
            if (basicblockMatch2 != null) {
                IAddress address;
                IAddress address2;
                if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                    address = basicblockMatch.getIAddress(ESide.SECONDARY);
                    address2 = basicblockMatch2.getIAddress(ESide.SECONDARY);
                }
                else {
                    address = basicblockMatch.getIAddress(ESide.PRIMARY);
                    address2 = basicblockMatch2.getIAddress(ESide.PRIMARY);
                }
                if (rawFlowGraph3.getJump(address, address2) != null) {
                    continue;
                }
                list.add(rawJump);
            }
            else {
                list.add(rawJump);
            }
        }
        return list;
    }
}
