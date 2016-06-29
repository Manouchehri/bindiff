/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.helpers;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GraphGetter {
    public static RawCall getCall(RawCallGraph rawCallGraph, IAddress iAddress, IAddress iAddress2, IAddress iAddress3) {
        SingleViewEdge singleViewEdge;
        RawCall rawCall;
        RawFunction rawFunction = rawCallGraph.getFunction(iAddress);
        if (rawFunction == null) return null;
        Iterator iterator = rawFunction.getOutgoingEdges().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(rawCall = (RawCall)(singleViewEdge = (SingleViewEdge)iterator.next())).getSourceInstructionAddr().equals(iAddress3) || !((RawFunction)rawCall.getTarget()).getAddress().equals(iAddress2));
        return rawCall;
    }

    public static List getCallees(RawFunction rawFunction) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(rawFunction.getCallees());
        return arrayList;
    }

    public static List getCallers(RawFunction rawFunction) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(rawFunction.getCallers());
        return arrayList;
    }

    public static List getCallsAt(RawCallGraph rawCallGraph, IAddress iAddress, IAddress iAddress2) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        RawFunction rawFunction = rawCallGraph.getFunction(iAddress);
        Iterator iterator = rawFunction.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            RawCall rawCall = (RawCall)singleViewEdge;
            if (!rawCall.getSourceInstructionAddr().equals(iAddress2)) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static Set getChangedFunctionPairs(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2) {
        Set set = GraphGetter.getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        HashSet<Pair> hashSet = new HashSet<Pair>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            RawFunction rawFunction = (RawFunction)pair.first();
            RawFunction rawFunction2 = (RawFunction)pair.second();
            int n2 = rawFunction.getFunctionMatch().getSizeOfMatchedInstructions();
            if (rawFunction.getSizeOfUnmatchedBasicblocks() == 0 && rawFunction.getSizeOfUnmatchedJumps() == 0 && rawFunction2.getSizeOfUnmatchedBasicblocks() == 0 && rawFunction2.getSizeOfUnmatchedJumps() == 0 && rawFunction.getSizeOfInstructions() == n2 && rawFunction2.getSizeOfInstructions() == n2) continue;
            Pair pair2 = new Pair(rawFunction, rawFunction2);
            hashSet.add(pair2);
        }
        return hashSet;
    }

    public static SingleDiffNode getDiffNode(GraphsContainer graphsContainer, RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode;
        if (rawBasicBlock.getSide() == ESide.PRIMARY) {
            singleDiffNode = (SingleDiffNode)graphsContainer.getPrimaryGraph().getNode(rawBasicBlock);
            return singleDiffNode;
        }
        singleDiffNode = (SingleDiffNode)graphsContainer.getSecondaryGraph().getNode(rawBasicBlock);
        return singleDiffNode;
    }

    public static RawFunction getFunction(Diff diff, RawBasicBlock rawBasicBlock) {
        IAddress iAddress = rawBasicBlock.getFunctionAddr();
        RawCallGraph rawCallGraph = diff.getCallgraph(rawBasicBlock.getSide());
        return rawCallGraph.getFunction(iAddress);
    }

    public static RawFunction getFunction(Diff diff, RawFlowGraph rawFlowGraph) {
        if (rawFlowGraph == null) {
            return null;
        }
        RawCallGraph rawCallGraph = diff.getCallgraph(rawFlowGraph.getSide());
        return rawCallGraph.getFunction(rawFlowGraph.getAddress());
    }

    public static Set getIdenticalFunctionPairs(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2) {
        Set set = GraphGetter.getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        HashSet<Pair> hashSet = new HashSet<Pair>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction;
            Pair pair = (Pair)iterator.next();
            RawFunction rawFunction2 = (RawFunction)pair.first();
            if (!MatchesGetter.isIdenticalFunctionPair(rawFunction2, rawFunction = (RawFunction)pair.second())) continue;
            Pair pair2 = new Pair(rawFunction2, rawFunction);
            hashSet.add(pair2);
        }
        return hashSet;
    }

    public static Collection getIncomingJumps(RawBasicBlock rawBasicBlock) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        Iterator iterator = rawBasicBlock.getIncomingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            if (!(singleViewEdge instanceof RawJump)) continue;
            arrayList.add((RawJump)singleViewEdge);
        }
        return arrayList;
    }

    public static Set getInstructionOnlyChangedFunctionPairs(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2) {
        Set set = GraphGetter.getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        HashSet<Pair> hashSet = new HashSet<Pair>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction;
            Pair pair = (Pair)iterator.next();
            RawFunction rawFunction2 = (RawFunction)pair.first();
            if (!MatchesGetter.isInstructionsOnlyChangedFunctionPair(rawFunction2, rawFunction = (RawFunction)pair.second())) continue;
            Pair pair2 = new Pair(rawFunction2, rawFunction);
            hashSet.add(pair2);
        }
        return hashSet;
    }

    public static List getMatchedCallees(RawFunction rawFunction) {
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        Object object = rawFunction.getCallees().iterator();
        do {
            if (!object.hasNext()) {
                object = new ArrayList();
                object.addAll(hashSet);
                return object;
            }
            RawFunction rawFunction2 = (RawFunction)object.next();
            if (rawFunction2.getMatchState() != EMatchState.MATCHED) continue;
            hashSet.add(rawFunction2);
        } while (true);
    }

    public static List getMatchedCallers(RawFunction rawFunction) {
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        Object object = rawFunction.getCallers().iterator();
        do {
            if (!object.hasNext()) {
                object = new ArrayList();
                object.addAll(hashSet);
                return object;
            }
            RawFunction rawFunction2 = (RawFunction)object.next();
            if (rawFunction2.getMatchState() != EMatchState.MATCHED) continue;
            hashSet.add(rawFunction2);
        } while (true);
    }

    public static Set getMatchedFunctionPairs(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2) {
        HashSet<Pair> hashSet = new HashSet<Pair>();
        Iterator iterator = rawCallGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction = (RawFunction)iterator.next();
            if (rawFunction.getMatchState() != EMatchState.MATCHED) continue;
            RawFunction rawFunction2 = rawCallGraph2.getFunction(rawFunction.getMatchedFunctionAddress());
            Pair pair = new Pair(rawFunction, rawFunction2);
            hashSet.add(pair);
        }
        return hashSet;
    }

    public static List getMatchedIncomingCalls(RawFunction rawFunction) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        Iterator iterator = rawFunction.getIncomingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            RawCall rawCall = (RawCall)singleViewEdge;
            if (rawCall.getMatchState() != EMatchState.MATCHED && !rawCall.isChanged()) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static Collection getMatchedIncomingJumps(Diff diff, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, RawBasicBlock rawBasicBlock) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicBlockMatchData == null) {
            return arrayList;
        }
        RawFlowGraph rawFlowGraph3 = rawBasicBlock.getSide() == ESide.PRIMARY ? rawFlowGraph2 : rawFlowGraph;
        Collection collection = GraphGetter.getIncomingJumps(rawBasicBlock);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            RawJump rawJump = (RawJump)iterator.next();
            RawBasicBlock rawBasicBlock2 = rawJump.getTarget();
            BasicBlockMatchData basicBlockMatchData2 = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock2);
            if (basicBlockMatchData2 == null) continue;
            IAddress iAddress = null;
            IAddress iAddress2 = null;
            if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                iAddress = basicBlockMatchData.getIAddress(ESide.SECONDARY);
                iAddress2 = basicBlockMatchData2.getIAddress(ESide.SECONDARY);
            } else {
                iAddress = basicBlockMatchData.getIAddress(ESide.PRIMARY);
                iAddress2 = basicBlockMatchData2.getIAddress(ESide.PRIMARY);
            }
            if (rawFlowGraph3.getJump(iAddress, iAddress2) == null) continue;
            arrayList.add(rawJump);
        }
        return arrayList;
    }

    public static List getMatchedOutgoingCalls(Diff diff, RawBasicBlock rawBasicBlock) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        List list = GraphGetter.getOutgoingCalls(diff, rawBasicBlock);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawCall rawCall = (RawCall)iterator.next();
            if (rawCall.getMatchState() != EMatchState.MATCHED && !rawCall.isChanged()) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static List getMatchedOutgoingCalls(RawFunction rawFunction) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        Iterator iterator = rawFunction.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            RawCall rawCall = (RawCall)singleViewEdge;
            if (rawCall.getMatchState() != EMatchState.MATCHED && !rawCall.isChanged()) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static Collection getMatchedOutgoingJumps(Diff diff, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, RawBasicBlock rawBasicBlock) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicBlockMatchData == null) {
            return arrayList;
        }
        RawFlowGraph rawFlowGraph3 = rawBasicBlock.getSide() == ESide.PRIMARY ? rawFlowGraph2 : rawFlowGraph;
        Collection collection = GraphGetter.getOutgoingJumps(rawBasicBlock);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            RawJump rawJump = (RawJump)iterator.next();
            RawBasicBlock rawBasicBlock2 = rawJump.getTarget();
            BasicBlockMatchData basicBlockMatchData2 = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock2);
            if (basicBlockMatchData2 == null) continue;
            IAddress iAddress = null;
            IAddress iAddress2 = null;
            if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                iAddress = basicBlockMatchData.getIAddress(ESide.SECONDARY);
                iAddress2 = basicBlockMatchData2.getIAddress(ESide.SECONDARY);
            } else {
                iAddress = basicBlockMatchData.getIAddress(ESide.PRIMARY);
                iAddress2 = basicBlockMatchData2.getIAddress(ESide.PRIMARY);
            }
            if (rawFlowGraph3.getJump(iAddress, iAddress2) == null) continue;
            arrayList.add(rawJump);
        }
        return arrayList;
    }

    public static IAddress getMaxAddress(List list) {
        if (list == null) return null;
        if (list.size() == 0) {
            return null;
        }
        IAddress iAddress = new CAddress(0);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawBasicBlock rawBasicBlock = (RawBasicBlock)iterator.next();
            IAddress iAddress2 = rawBasicBlock.getAddress();
            if (iAddress2.compareTo(iAddress) <= 0) continue;
            iAddress = iAddress2;
        }
        return iAddress;
    }

    public static IAddress getMinAddress(List list) {
        if (list == null) return null;
        if (list.size() == 0) {
            return null;
        }
        IAddress iAddress = new CAddress(-1);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawBasicBlock rawBasicBlock = (RawBasicBlock)iterator.next();
            IAddress iAddress2 = rawBasicBlock.getAddress();
            if (iAddress2.compareTo(iAddress) >= 0) continue;
            iAddress = iAddress2;
        }
        return iAddress;
    }

    public static SingleGraph getOtherGraph(SingleGraph singleGraph) {
        SingleGraph singleGraph2;
        if (singleGraph.getSide() == ESide.PRIMARY) {
            singleGraph2 = singleGraph.getSecondaryGraph();
            return singleGraph2;
        }
        singleGraph2 = singleGraph.getPrimaryGraph();
        return singleGraph2;
    }

    public static List getOutgoingCalls(Diff diff, RawBasicBlock rawBasicBlock) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        RawFunction rawFunction = GraphGetter.getFunction(diff, rawBasicBlock);
        Iterator iterator = rawFunction.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            RawCall rawCall = (RawCall)singleViewEdge;
            if (rawBasicBlock.getInstruction(rawCall.getSourceInstructionAddr()) == null) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static Collection getOutgoingJumps(RawBasicBlock rawBasicBlock) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        Iterator iterator = rawBasicBlock.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            if (!(singleViewEdge instanceof RawJump)) continue;
            arrayList.add((RawJump)singleViewEdge);
        }
        return arrayList;
    }

    public static SingleDiffNode getPrimaryDiffNode(SingleGraph singleGraph, RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getSecondaryGraph().getNode(rawBasicBlock);
        return singleDiffNode.getOtherSideDiffNode();
    }

    public static RawBasicBlock getPrimaryRawBasicblock(GraphsContainer graphsContainer, RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode = GraphGetter.getDiffNode(graphsContainer, rawBasicBlock);
        SingleDiffNode singleDiffNode2 = singleDiffNode.getOtherSideDiffNode();
        if (singleDiffNode2 == null) return null;
        return (RawBasicBlock)singleDiffNode2.getRawNode();
    }

    public static RawFunction getRawFunction(Diff diff, RawFlowGraph rawFlowGraph) {
        return diff.getCallgraph(rawFlowGraph.getSide()).getFunction(rawFlowGraph.getAddress());
    }

    public static SingleDiffNode getSecondaryDiffNode(SingleGraph singleGraph, RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getPrimaryGraph().getNode(rawBasicBlock);
        return singleDiffNode.getOtherSideDiffNode();
    }

    public static RawBasicBlock getSecondaryRawBasicblock(GraphsContainer graphsContainer, RawBasicBlock rawBasicBlock) {
        SingleDiffNode singleDiffNode = GraphGetter.getDiffNode(graphsContainer, rawBasicBlock);
        SingleDiffNode singleDiffNode2 = singleDiffNode.getOtherSideDiffNode();
        if (singleDiffNode2 == null) return null;
        return (RawBasicBlock)singleDiffNode2.getRawNode();
    }

    public static Set getStructuralChangedFunctionPairs(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2) {
        Set set = GraphGetter.getMatchedFunctionPairs(rawCallGraph, rawCallGraph2);
        HashSet<Pair> hashSet = new HashSet<Pair>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction;
            Pair pair = (Pair)iterator.next();
            RawFunction rawFunction2 = (RawFunction)pair.first();
            if (!MatchesGetter.isStructuralChangedFunctionPair(rawFunction2, rawFunction = (RawFunction)pair.second())) continue;
            Pair pair2 = new Pair(rawFunction2, rawFunction);
            hashSet.add(pair2);
        }
        return hashSet;
    }

    public static List getUnmatchedCallees(RawFunction rawFunction) {
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        Object object = rawFunction.getCallees().iterator();
        do {
            if (!object.hasNext()) {
                object = new ArrayList();
                object.addAll(hashSet);
                return object;
            }
            RawFunction rawFunction2 = (RawFunction)object.next();
            if (rawFunction2.getMatchState() == EMatchState.MATCHED) continue;
            hashSet.add(rawFunction2);
        } while (true);
    }

    public static List getUnmatchedCallers(RawFunction rawFunction) {
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        Object object = rawFunction.getCallees().iterator();
        do {
            if (!object.hasNext()) {
                object = new ArrayList();
                object.addAll(hashSet);
                return object;
            }
            RawFunction rawFunction2 = (RawFunction)object.next();
            if (rawFunction2.getMatchState() == EMatchState.MATCHED) continue;
            hashSet.add(rawFunction2);
        } while (true);
    }

    public static List getUnmatchedFunctions(RawCallGraph rawCallGraph) {
        ArrayList<RawFunction> arrayList = new ArrayList<RawFunction>();
        Iterator iterator = rawCallGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction = (RawFunction)iterator.next();
            if (rawFunction.getMatchState() == EMatchState.MATCHED) continue;
            arrayList.add(rawFunction);
        }
        return arrayList;
    }

    public static List getUnmatchedIncomingCalls(RawFunction rawFunction) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        Iterator iterator = rawFunction.getIncomingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            RawCall rawCall = (RawCall)singleViewEdge;
            if (rawCall.getMatchState() == EMatchState.MATCHED || rawCall.isChanged()) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static Collection getUnmatchedIncomingJumps(Diff diff, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, RawBasicBlock rawBasicBlock) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicBlockMatchData == null) {
            return GraphGetter.getIncomingJumps(rawBasicBlock);
        }
        RawFlowGraph rawFlowGraph3 = rawBasicBlock.getSide() == ESide.PRIMARY ? rawFlowGraph2 : rawFlowGraph;
        Collection collection = GraphGetter.getIncomingJumps(rawBasicBlock);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            RawJump rawJump = (RawJump)iterator.next();
            RawBasicBlock rawBasicBlock2 = rawJump.getSource();
            BasicBlockMatchData basicBlockMatchData2 = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock2);
            if (basicBlockMatchData2 != null) {
                IAddress iAddress = null;
                IAddress iAddress2 = null;
                if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                    iAddress2 = basicBlockMatchData.getIAddress(ESide.SECONDARY);
                    iAddress = basicBlockMatchData2.getIAddress(ESide.SECONDARY);
                } else {
                    iAddress2 = basicBlockMatchData.getIAddress(ESide.PRIMARY);
                    iAddress = basicBlockMatchData2.getIAddress(ESide.PRIMARY);
                }
                if (rawFlowGraph3.getJump(iAddress, iAddress2) != null) continue;
                arrayList.add(rawJump);
                continue;
            }
            arrayList.add(rawJump);
        }
        return arrayList;
    }

    public static List getUnmatchedOutgoingCalls(Diff diff, RawBasicBlock rawBasicBlock) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        List list = GraphGetter.getOutgoingCalls(diff, rawBasicBlock);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawCall rawCall = (RawCall)iterator.next();
            if (rawCall.getMatchState() == EMatchState.MATCHED || rawCall.isChanged()) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static List getUnmatchedOutgoingCalls(RawFunction rawFunction) {
        ArrayList<RawCall> arrayList = new ArrayList<RawCall>();
        Iterator iterator = rawFunction.getOutgoingEdges().iterator();
        while (iterator.hasNext()) {
            SingleViewEdge singleViewEdge = (SingleViewEdge)iterator.next();
            RawCall rawCall = (RawCall)singleViewEdge;
            if (rawCall.getMatchState() == EMatchState.MATCHED || rawCall.isChanged()) continue;
            arrayList.add(rawCall);
        }
        return arrayList;
    }

    public static Collection getUnmatchedOutgoingJumps(Diff diff, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, RawBasicBlock rawBasicBlock) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicBlockMatchData == null) {
            return GraphGetter.getOutgoingJumps(rawBasicBlock);
        }
        RawFlowGraph rawFlowGraph3 = rawBasicBlock.getSide() == ESide.PRIMARY ? rawFlowGraph2 : rawFlowGraph;
        Collection collection = GraphGetter.getOutgoingJumps(rawBasicBlock);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            RawJump rawJump = (RawJump)iterator.next();
            RawBasicBlock rawBasicBlock2 = rawJump.getTarget();
            BasicBlockMatchData basicBlockMatchData2 = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock2);
            if (basicBlockMatchData2 != null) {
                IAddress iAddress = null;
                IAddress iAddress2 = null;
                if (rawBasicBlock.getSide() == ESide.PRIMARY) {
                    iAddress = basicBlockMatchData.getIAddress(ESide.SECONDARY);
                    iAddress2 = basicBlockMatchData2.getIAddress(ESide.SECONDARY);
                } else {
                    iAddress = basicBlockMatchData.getIAddress(ESide.PRIMARY);
                    iAddress2 = basicBlockMatchData2.getIAddress(ESide.PRIMARY);
                }
                if (rawFlowGraph3.getJump(iAddress, iAddress2) != null) continue;
                arrayList.add(rawJump);
                continue;
            }
            arrayList.add(rawJump);
        }
        return arrayList;
    }
}

