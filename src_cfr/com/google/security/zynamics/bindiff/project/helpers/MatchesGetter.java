/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.helpers;

import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.sorters.AddressPairSorter;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MatchesGetter {
    public static Map createMatchedInstructionsMap(Diff diff, RawFunction rawFunction) {
        HashMap<IAddress, IAddress> hashMap = new HashMap<IAddress, IAddress>();
        FunctionMatchData functionMatchData = MatchesGetter.getFunctionMatch(diff, rawFunction);
        Iterator iterator = functionMatchData.getBasicblockMatches().iterator();
        block0 : while (iterator.hasNext()) {
            BasicBlockMatchData basicBlockMatchData = (BasicBlockMatchData)iterator.next();
            InstructionMatchData[] arrinstructionMatchData = basicBlockMatchData.getInstructionMatches();
            int n2 = arrinstructionMatchData.length;
            int n3 = 0;
            do {
                if (n3 >= n2) continue block0;
                InstructionMatchData instructionMatchData = arrinstructionMatchData[n3];
                if (rawFunction.getSide() == ESide.PRIMARY) {
                    hashMap.put(instructionMatchData.getIAddress(ESide.PRIMARY), instructionMatchData.getIAddress(ESide.SECONDARY));
                } else {
                    hashMap.put(instructionMatchData.getIAddress(ESide.SECONDARY), instructionMatchData.getIAddress(ESide.PRIMARY));
                }
                ++n3;
            } while (true);
            break;
        }
        return hashMap;
    }

    public static List getBasicblockAddressPairs(Diff diff, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2) {
        IAddress iAddress;
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        MatchData matchData = diff.getMatches();
        if (rawFlowGraph == null) {
            Iterator iterator = rawFlowGraph2.iterator();
            while (iterator.hasNext()) {
                RawBasicBlock rawBasicBlock = (RawBasicBlock)iterator.next();
                Pair pair = new Pair(null, rawBasicBlock.getAddress());
                arrayList.add(pair);
            }
            return AddressPairSorter.getSortedList(arrayList, ESide.PRIMARY);
        }
        if (rawFlowGraph2 == null) {
            Iterator iterator = rawFlowGraph.iterator();
            while (iterator.hasNext()) {
                RawBasicBlock rawBasicBlock = (RawBasicBlock)iterator.next();
                Pair pair = new Pair(rawBasicBlock.getAddress(), null);
                arrayList.add(pair);
            }
            return AddressPairSorter.getSortedList(arrayList, ESide.PRIMARY);
        }
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(rawFlowGraph.getAddress(), ESide.PRIMARY);
        for (RawBasicBlock rawBasicBlock2 : rawFlowGraph) {
            iAddress = rawBasicBlock2.getAddress();
            IAddress iAddress2 = functionMatchData.getSecondaryBasicblockAddr(iAddress);
            arrayList.add(new Pair(iAddress, iAddress2));
        }
        Iterator iterator = rawFlowGraph2.iterator();
        while (iterator.hasNext()) {
            RawBasicBlock rawBasicBlock2;
            rawBasicBlock2 = (RawBasicBlock)iterator.next();
            iAddress = rawBasicBlock2.getAddress();
            if (functionMatchData.getPrimaryBasicblockAddr(iAddress) != null) continue;
            arrayList.add(new Pair(null, iAddress));
        }
        return AddressPairSorter.getSortedList(arrayList, ESide.PRIMARY);
    }

    public static BasicBlockMatchData getBasicblockMatch(Diff diff, RawBasicBlock rawBasicBlock) {
        ESide eSide = rawBasicBlock.getSide();
        RawFunction rawFunction = null;
        rawFunction = eSide == ESide.PRIMARY ? diff.getFunction(rawBasicBlock.getFunctionAddr(), ESide.PRIMARY) : diff.getFunction(rawBasicBlock.getFunctionAddr(), ESide.SECONDARY);
        FunctionMatchData functionMatchData = MatchesGetter.getFunctionMatch(diff, rawFunction);
        return MatchesGetter.getBasicblockMatch(functionMatchData, rawBasicBlock);
    }

    public static BasicBlockMatchData getBasicblockMatch(Diff diff, IAddress iAddress, IAddress iAddress2, ESide eSide) {
        RawFunction rawFunction = null;
        rawFunction = diff.getFunction(iAddress, eSide);
        FunctionMatchData functionMatchData = MatchesGetter.getFunctionMatch(diff, rawFunction);
        if (functionMatchData == null) {
            return null;
        }
        IAddress iAddress3 = null;
        IAddress iAddress4 = null;
        if (eSide == ESide.PRIMARY) {
            iAddress3 = iAddress2;
            iAddress4 = functionMatchData.getSecondaryBasicblockAddr(iAddress3);
            return functionMatchData.getBasicblockMatch(iAddress3, ESide.PRIMARY);
        }
        iAddress4 = iAddress2;
        iAddress3 = functionMatchData.getPrimaryBasicblockAddr(iAddress4);
        return functionMatchData.getBasicblockMatch(iAddress3, ESide.PRIMARY);
    }

    public static BasicBlockMatchData getBasicblockMatch(FunctionMatchData functionMatchData, RawBasicBlock rawBasicBlock) {
        if (functionMatchData == null) {
            return null;
        }
        IAddress iAddress = null;
        IAddress iAddress2 = null;
        if (rawBasicBlock.getSide() == ESide.PRIMARY) {
            iAddress = rawBasicBlock.getAddress();
            iAddress2 = functionMatchData.getSecondaryBasicblockAddr(iAddress);
            return functionMatchData.getBasicblockMatch(iAddress, ESide.PRIMARY);
        }
        iAddress2 = rawBasicBlock.getAddress();
        iAddress = functionMatchData.getPrimaryBasicblockAddr(iAddress2);
        return functionMatchData.getBasicblockMatch(iAddress, ESide.PRIMARY);
    }

    public static EMatchType getFlowgraphsMatchType(CombinedGraph combinedGraph, FunctionMatchData functionMatchData) {
        Object object;
        int n2;
        Object object22;
        int n3;
        Object object3;
        int n4 = functionMatchData.getBasicblockMatches().size();
        int n5 = combinedGraph.getPrimaryGraph().getPrimaryGraph().getNodes().size();
        int n6 = combinedGraph.getSecondaryGraph().getSecondaryGraph().getNodes().size();
        if (n5 != n4) return EMatchType.STRUCTURAL_CHANGED;
        if (n6 != n4) return EMatchType.STRUCTURAL_CHANGED;
        boolean bl2 = true;
        for (Object object22 : combinedGraph.getEdges()) {
            object = object22.getPrimaryDiffEdge();
            object3 = object22.getSecondaryDiffEdge();
            if (object == null) return EMatchType.STRUCTURAL_CHANGED;
            if (object3 != null) continue;
            return EMatchType.STRUCTURAL_CHANGED;
        }
        if (!bl2) return EMatchType.STRUCTURAL_CHANGED;
        boolean bl3 = true;
        object22 = combinedGraph.getNodes().iterator();
        do {
            if (!object22.hasNext()) {
                if (!bl3) return EMatchType.INSTRUCTIONS_CHANGED;
                return EMatchType.IDENTICAL;
            }
            object = (CombinedDiffNode)object22.next();
            object3 = (RawBasicBlock)object.getPrimaryRawNode();
            RawBasicBlock rawBasicBlock = (RawBasicBlock)object.getSecondaryRawNode();
            BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(object3.getAddress(), ESide.PRIMARY);
            int n7 = object3.getSizeOfInstructions();
            n2 = rawBasicBlock.getSizeOfInstructions();
            n3 = basicBlockMatchData.getSizeOfMatchedInstructions();
            if (n7 != n3) return EMatchType.INSTRUCTIONS_CHANGED;
        } while (n2 == n3);
        return EMatchType.INSTRUCTIONS_CHANGED;
    }

    public static FunctionMatchData getFunctionMatch(Diff diff, RawFlowGraph rawFlowGraph) {
        ESide eSide = rawFlowGraph.getSide();
        IAddress iAddress = rawFlowGraph.getAddress();
        RawFunction rawFunction = diff.getCallgraph(eSide).getFunction(iAddress);
        return MatchesGetter.getFunctionMatch(diff, rawFunction);
    }

    public static FunctionMatchData getFunctionMatch(Diff diff, RawFunction rawFunction) {
        MatchData matchData = diff.getMatches();
        if (rawFunction.getSide() == ESide.PRIMARY) {
            IAddress iAddress = rawFunction.getAddress();
            IAddress iAddress2 = matchData.getSecondaryFunctionAddr(rawFunction.getAddress());
            if (iAddress2 == null) return null;
            return matchData.getFunctionMatch(iAddress, ESide.PRIMARY);
        }
        IAddress iAddress = matchData.getPrimaryFunctionAddr(rawFunction.getAddress());
        if (iAddress == null) return null;
        return matchData.getFunctionMatch(iAddress, ESide.PRIMARY);
    }

    public static List getInstructionAddressPairs(Diff diff, RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2) {
        IAddress iAddress;
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        MatchData matchData = diff.getMatches();
        if (rawBasicBlock == null) {
            Iterator iterator = rawBasicBlock2.iterator();
            while (iterator.hasNext()) {
                RawInstruction rawInstruction = (RawInstruction)iterator.next();
                Pair pair = new Pair(null, rawInstruction.getAddress());
                arrayList.add(pair);
            }
            return AddressPairSorter.getSortedList(arrayList, ESide.PRIMARY);
        }
        if (rawBasicBlock2 == null) {
            Iterator iterator = rawBasicBlock.iterator();
            while (iterator.hasNext()) {
                RawInstruction rawInstruction = (RawInstruction)iterator.next();
                Pair pair = new Pair(rawInstruction.getAddress(), null);
                arrayList.add(pair);
            }
            return AddressPairSorter.getSortedList(arrayList, ESide.PRIMARY);
        }
        IAddress iAddress2 = rawBasicBlock.getFunctionAddr();
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(iAddress2, ESide.PRIMARY);
        IAddress iAddress3 = rawBasicBlock.getAddress();
        BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress3, ESide.PRIMARY);
        for (RawInstruction rawInstruction2 : rawBasicBlock) {
            iAddress = rawInstruction2.getAddress();
            IAddress iAddress4 = basicBlockMatchData.getSecondaryInstructionAddr(iAddress);
            arrayList.add(new Pair(iAddress, iAddress4));
        }
        Iterator iterator = rawBasicBlock2.iterator();
        while (iterator.hasNext()) {
            RawInstruction rawInstruction2;
            rawInstruction2 = (RawInstruction)iterator.next();
            iAddress = rawInstruction2.getAddress();
            if (basicBlockMatchData.getPrimaryInstructionAddr(iAddress) != null) continue;
            arrayList.add(new Pair(null, iAddress));
        }
        return AddressPairSorter.getSortedList(arrayList, ESide.PRIMARY);
    }

    public static boolean isChangedBasicblock(Diff diff, RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2) {
        if (rawBasicBlock == null) return false;
        if (rawBasicBlock2 == null) {
            return false;
        }
        BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicBlockMatchData == null) return false;
        int n2 = basicBlockMatchData.getSizeOfMatchedInstructions();
        int n3 = rawBasicBlock.getSizeOfInstructions();
        int n4 = rawBasicBlock2.getSizeOfInstructions();
        if (n2 != n3) return true;
        if (n2 != n4) return true;
        return false;
    }

    public static boolean isIdenticalBasicblock(Diff diff, RawBasicBlock rawBasicBlock, RawBasicBlock rawBasicBlock2) {
        if (rawBasicBlock == null) return false;
        if (rawBasicBlock2 == null) {
            return false;
        }
        BasicBlockMatchData basicBlockMatchData = MatchesGetter.getBasicblockMatch(diff, rawBasicBlock);
        if (basicBlockMatchData == null) return false;
        int n2 = basicBlockMatchData.getSizeOfMatchedInstructions();
        int n3 = rawBasicBlock.getSizeOfInstructions();
        int n4 = rawBasicBlock2.getSizeOfInstructions();
        if (n2 != n3) return false;
        if (n2 != n4) return false;
        return true;
    }

    public static boolean isIdenticalFunctionPair(RawFunction rawFunction, RawFunction rawFunction2) {
        if (rawFunction.getMatchedFunction() == rawFunction2) return rawFunction.isIdenticalMatch();
        throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
    }

    public static boolean isInstructionsOnlyChangedFunctionPair(RawFunction rawFunction, RawFunction rawFunction2) {
        if (rawFunction.getMatchedFunction() != rawFunction2) {
            throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
        }
        int n2 = rawFunction.getFunctionMatch().getSizeOfMatchedInstructions();
        if (rawFunction.getSizeOfUnmatchedBasicblocks() != 0) return false;
        if (rawFunction.getSizeOfUnmatchedJumps() != 0) return false;
        if (rawFunction2.getSizeOfUnmatchedBasicblocks() != 0) return false;
        if (rawFunction2.getSizeOfUnmatchedJumps() != 0) return false;
        if (rawFunction.getSizeOfInstructions() != n2) return true;
        if (rawFunction2.getSizeOfInstructions() == n2) return false;
        return true;
    }

    public static boolean isMatchedInstruction(Diff diff, RawBasicBlock rawBasicBlock, RawInstruction rawInstruction) {
        MatchData matchData = diff.getMatches();
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(rawBasicBlock.getFunctionAddr(), rawBasicBlock.getSide());
        return MatchesGetter.isMatchedInstruction(functionMatchData, rawBasicBlock, rawInstruction);
    }

    public static boolean isMatchedInstruction(FunctionMatchData functionMatchData, RawBasicBlock rawBasicBlock, RawInstruction rawInstruction) {
        ESide eSide = rawBasicBlock.getSide();
        if (functionMatchData == null) return false;
        IAddress iAddress = eSide == ESide.PRIMARY ? rawBasicBlock.getAddress() : functionMatchData.getPrimaryBasicblockAddr(rawBasicBlock.getAddress());
        IAddress iAddress2 = eSide == ESide.SECONDARY ? rawBasicBlock.getAddress() : functionMatchData.getSecondaryBasicblockAddr(rawBasicBlock.getAddress());
        if (iAddress == null) return false;
        if (iAddress2 == null) return false;
        BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress, ESide.PRIMARY);
        if (basicBlockMatchData == null) return false;
        IAddress iAddress3 = rawInstruction.getAddress();
        if (eSide == ESide.PRIMARY) {
            if (basicBlockMatchData.getSecondaryInstructionAddr(iAddress3) == null) return false;
            return true;
        }
        if (basicBlockMatchData.getPrimaryInstructionAddr(iAddress3) == null) return false;
        return true;
    }

    public static boolean isStructuralChangedFunctionPair(RawFunction rawFunction, RawFunction rawFunction2) {
        if (rawFunction.getMatchedFunction() != rawFunction2) {
            throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
        }
        if (rawFunction.getSizeOfUnmatchedBasicblocks() != 0) return true;
        if (rawFunction.getSizeOfUnmatchedJumps() != 0) return true;
        if (rawFunction2.getSizeOfUnmatchedBasicblocks() != 0) return true;
        if (rawFunction2.getSizeOfUnmatchedJumps() != 0) return true;
        return false;
    }
}

