package com.google.security.zynamics.bindiff.project.helpers;

import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.sorters.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;

public final class MatchesGetter
{
    public static Map createMatchedInstructionsMap(final Diff diff, final RawFunction rawFunction) {
        final HashMap<IAddress, IAddress> hashMap = new HashMap<IAddress, IAddress>();
        final Iterator<BasicBlockMatchData> iterator = (Iterator<BasicBlockMatchData>)getFunctionMatch(diff, rawFunction).getBasicblockMatches().iterator();
        while (iterator.hasNext()) {
            for (final InstructionMatchData instructionMatchData : iterator.next().getInstructionMatches()) {
                if (rawFunction.getSide() == ESide.PRIMARY) {
                    hashMap.put(instructionMatchData.getIAddress(ESide.PRIMARY), instructionMatchData.getIAddress(ESide.SECONDARY));
                }
                else {
                    hashMap.put(instructionMatchData.getIAddress(ESide.SECONDARY), instructionMatchData.getIAddress(ESide.PRIMARY));
                }
            }
        }
        return hashMap;
    }
    
    public static List getBasicblockAddressPairs(final Diff diff, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2) {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        final MatchData matches = diff.getMatches();
        if (rawFlowGraph == null) {
            final Iterator iterator = rawFlowGraph2.iterator();
            while (iterator.hasNext()) {
                list.add(new Pair(null, iterator.next().getAddress()));
            }
        }
        else if (rawFlowGraph2 == null) {
            final Iterator iterator2 = rawFlowGraph.iterator();
            while (iterator2.hasNext()) {
                list.add(new Pair(iterator2.next().getAddress(), null));
            }
        }
        else {
            final FunctionMatchData functionMatch = matches.getFunctionMatch(rawFlowGraph.getAddress(), ESide.PRIMARY);
            final Iterator iterator3 = rawFlowGraph.iterator();
            while (iterator3.hasNext()) {
                final IAddress address = iterator3.next().getAddress();
                list.add(new Pair(address, functionMatch.getSecondaryBasicblockAddr(address)));
            }
            final Iterator iterator4 = rawFlowGraph2.iterator();
            while (iterator4.hasNext()) {
                final IAddress address2 = iterator4.next().getAddress();
                if (functionMatch.getPrimaryBasicblockAddr(address2) == null) {
                    list.add(new Pair(null, address2));
                }
            }
        }
        return AddressPairSorter.getSortedList(list, ESide.PRIMARY);
    }
    
    public static BasicBlockMatchData getBasicblockMatch(final Diff diff, final RawBasicBlock rawBasicBlock) {
        RawFunction rawFunction;
        if (rawBasicBlock.getSide() == ESide.PRIMARY) {
            rawFunction = diff.getFunction(rawBasicBlock.getFunctionAddr(), ESide.PRIMARY);
        }
        else {
            rawFunction = diff.getFunction(rawBasicBlock.getFunctionAddr(), ESide.SECONDARY);
        }
        return getBasicblockMatch(getFunctionMatch(diff, rawFunction), rawBasicBlock);
    }
    
    public static BasicBlockMatchData getBasicblockMatch(final Diff diff, final IAddress address, final IAddress address2, final ESide eSide) {
        final FunctionMatchData functionMatch = getFunctionMatch(diff, diff.getFunction(address, eSide));
        if (functionMatch == null) {
            return null;
        }
        IAddress primaryBasicblockAddr;
        if (eSide == ESide.PRIMARY) {
            primaryBasicblockAddr = address2;
            functionMatch.getSecondaryBasicblockAddr(primaryBasicblockAddr);
        }
        else {
            primaryBasicblockAddr = functionMatch.getPrimaryBasicblockAddr(address2);
        }
        return functionMatch.getBasicblockMatch(primaryBasicblockAddr, ESide.PRIMARY);
    }
    
    public static BasicBlockMatchData getBasicblockMatch(final FunctionMatchData functionMatchData, final RawBasicBlock rawBasicBlock) {
        if (functionMatchData == null) {
            return null;
        }
        IAddress address;
        if (rawBasicBlock.getSide() == ESide.PRIMARY) {
            address = rawBasicBlock.getAddress();
            functionMatchData.getSecondaryBasicblockAddr(address);
        }
        else {
            address = functionMatchData.getPrimaryBasicblockAddr(rawBasicBlock.getAddress());
        }
        return functionMatchData.getBasicblockMatch(address, ESide.PRIMARY);
    }
    
    public static EMatchType getFlowgraphsMatchType(final CombinedGraph combinedGraph, final FunctionMatchData functionMatchData) {
        final int size = functionMatchData.getBasicblockMatches().size();
        final int size2 = combinedGraph.getPrimaryGraph().getPrimaryGraph().getNodes().size();
        final int size3 = combinedGraph.getSecondaryGraph().getSecondaryGraph().getNodes().size();
        if (size2 == size && size3 == size) {
            boolean b = true;
            for (final CombinedDiffEdge combinedDiffEdge : combinedGraph.getEdges()) {
                final SingleDiffEdge primaryDiffEdge = combinedDiffEdge.getPrimaryDiffEdge();
                final SingleDiffEdge secondaryDiffEdge = combinedDiffEdge.getSecondaryDiffEdge();
                if (primaryDiffEdge == null || secondaryDiffEdge == null) {
                    b = false;
                    break;
                }
            }
            if (b) {
                boolean b2 = true;
                for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
                    final RawBasicBlock rawBasicBlock = (RawBasicBlock)combinedDiffNode.getPrimaryRawNode();
                    final RawBasicBlock rawBasicBlock2 = (RawBasicBlock)combinedDiffNode.getSecondaryRawNode();
                    final BasicBlockMatchData basicblockMatch = functionMatchData.getBasicblockMatch(rawBasicBlock.getAddress(), ESide.PRIMARY);
                    final int sizeOfInstructions = rawBasicBlock.getSizeOfInstructions();
                    final int sizeOfInstructions2 = rawBasicBlock2.getSizeOfInstructions();
                    final int sizeOfMatchedInstructions = basicblockMatch.getSizeOfMatchedInstructions();
                    if (sizeOfInstructions != sizeOfMatchedInstructions || sizeOfInstructions2 != sizeOfMatchedInstructions) {
                        b2 = false;
                        break;
                    }
                }
                if (b2) {
                    return EMatchType.IDENTICAL;
                }
                return EMatchType.INSTRUCTIONS_CHANGED;
            }
        }
        return EMatchType.STRUCTURAL_CHANGED;
    }
    
    public static FunctionMatchData getFunctionMatch(final Diff diff, final RawFlowGraph rawFlowGraph) {
        return getFunctionMatch(diff, diff.getCallgraph(rawFlowGraph.getSide()).getFunction(rawFlowGraph.getAddress()));
    }
    
    public static FunctionMatchData getFunctionMatch(final Diff diff, final RawFunction rawFunction) {
        final MatchData matches = diff.getMatches();
        if (rawFunction.getSide() == ESide.PRIMARY) {
            final IAddress address = rawFunction.getAddress();
            if (matches.getSecondaryFunctionAddr(rawFunction.getAddress()) != null) {
                return matches.getFunctionMatch(address, ESide.PRIMARY);
            }
        }
        else {
            final IAddress primaryFunctionAddr = matches.getPrimaryFunctionAddr(rawFunction.getAddress());
            if (primaryFunctionAddr != null) {
                return matches.getFunctionMatch(primaryFunctionAddr, ESide.PRIMARY);
            }
        }
        return null;
    }
    
    public static List getInstructionAddressPairs(final Diff diff, final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2) {
        final ArrayList<Pair> list = new ArrayList<Pair>();
        final MatchData matches = diff.getMatches();
        if (rawBasicBlock == null) {
            final Iterator iterator = rawBasicBlock2.iterator();
            while (iterator.hasNext()) {
                list.add(new Pair(null, iterator.next().getAddress()));
            }
        }
        else if (rawBasicBlock2 == null) {
            final Iterator iterator2 = rawBasicBlock.iterator();
            while (iterator2.hasNext()) {
                list.add(new Pair(iterator2.next().getAddress(), null));
            }
        }
        else {
            final BasicBlockMatchData basicblockMatch = matches.getFunctionMatch(rawBasicBlock.getFunctionAddr(), ESide.PRIMARY).getBasicblockMatch(rawBasicBlock.getAddress(), ESide.PRIMARY);
            final Iterator iterator3 = rawBasicBlock.iterator();
            while (iterator3.hasNext()) {
                final IAddress address = iterator3.next().getAddress();
                list.add(new Pair(address, basicblockMatch.getSecondaryInstructionAddr(address)));
            }
            final Iterator iterator4 = rawBasicBlock2.iterator();
            while (iterator4.hasNext()) {
                final IAddress address2 = iterator4.next().getAddress();
                if (basicblockMatch.getPrimaryInstructionAddr(address2) == null) {
                    list.add(new Pair(null, address2));
                }
            }
        }
        return AddressPairSorter.getSortedList(list, ESide.PRIMARY);
    }
    
    public static boolean isChangedBasicblock(final Diff diff, final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2) {
        if (rawBasicBlock == null || rawBasicBlock2 == null) {
            return false;
        }
        final BasicBlockMatchData basicblockMatch = getBasicblockMatch(diff, rawBasicBlock);
        if (basicblockMatch != null) {
            final int sizeOfMatchedInstructions = basicblockMatch.getSizeOfMatchedInstructions();
            final int sizeOfInstructions = rawBasicBlock.getSizeOfInstructions();
            final int sizeOfInstructions2 = rawBasicBlock2.getSizeOfInstructions();
            return sizeOfMatchedInstructions != sizeOfInstructions || sizeOfMatchedInstructions != sizeOfInstructions2;
        }
        return false;
    }
    
    public static boolean isIdenticalBasicblock(final Diff diff, final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2) {
        if (rawBasicBlock == null || rawBasicBlock2 == null) {
            return false;
        }
        final BasicBlockMatchData basicblockMatch = getBasicblockMatch(diff, rawBasicBlock);
        if (basicblockMatch != null) {
            final int sizeOfMatchedInstructions = basicblockMatch.getSizeOfMatchedInstructions();
            final int sizeOfInstructions = rawBasicBlock.getSizeOfInstructions();
            final int sizeOfInstructions2 = rawBasicBlock2.getSizeOfInstructions();
            return sizeOfMatchedInstructions == sizeOfInstructions && sizeOfMatchedInstructions == sizeOfInstructions2;
        }
        return false;
    }
    
    public static boolean isIdenticalFunctionPair(final RawFunction rawFunction, final RawFunction rawFunction2) {
        if (rawFunction.getMatchedFunction() != rawFunction2) {
            throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
        }
        return rawFunction.isIdenticalMatch();
    }
    
    public static boolean isInstructionsOnlyChangedFunctionPair(final RawFunction rawFunction, final RawFunction rawFunction2) {
        if (rawFunction.getMatchedFunction() != rawFunction2) {
            throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
        }
        final int sizeOfMatchedInstructions = rawFunction.getFunctionMatch().getSizeOfMatchedInstructions();
        return rawFunction.getSizeOfUnmatchedBasicblocks() == 0 && rawFunction.getSizeOfUnmatchedJumps() == 0 && rawFunction2.getSizeOfUnmatchedBasicblocks() == 0 && rawFunction2.getSizeOfUnmatchedJumps() == 0 && (rawFunction.getSizeOfInstructions() != sizeOfMatchedInstructions || rawFunction2.getSizeOfInstructions() != sizeOfMatchedInstructions);
    }
    
    public static boolean isMatchedInstruction(final Diff diff, final RawBasicBlock rawBasicBlock, final RawInstruction rawInstruction) {
        return isMatchedInstruction(diff.getMatches().getFunctionMatch(rawBasicBlock.getFunctionAddr(), rawBasicBlock.getSide()), rawBasicBlock, rawInstruction);
    }
    
    public static boolean isMatchedInstruction(final FunctionMatchData functionMatchData, final RawBasicBlock rawBasicBlock, final RawInstruction rawInstruction) {
        final ESide side = rawBasicBlock.getSide();
        if (functionMatchData != null) {
            final IAddress address = (side == ESide.PRIMARY) ? rawBasicBlock.getAddress() : functionMatchData.getPrimaryBasicblockAddr(rawBasicBlock.getAddress());
            final IAddress address2 = (side == ESide.SECONDARY) ? rawBasicBlock.getAddress() : functionMatchData.getSecondaryBasicblockAddr(rawBasicBlock.getAddress());
            if (address != null && address2 != null) {
                final BasicBlockMatchData basicblockMatch = functionMatchData.getBasicblockMatch(address, ESide.PRIMARY);
                if (basicblockMatch != null) {
                    final IAddress address3 = rawInstruction.getAddress();
                    if (side == ESide.PRIMARY) {
                        return basicblockMatch.getSecondaryInstructionAddr(address3) != null;
                    }
                    return basicblockMatch.getPrimaryInstructionAddr(address3) != null;
                }
            }
        }
        return false;
    }
    
    public static boolean isStructuralChangedFunctionPair(final RawFunction rawFunction, final RawFunction rawFunction2) {
        if (rawFunction.getMatchedFunction() != rawFunction2) {
            throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
        }
        return rawFunction.getSizeOfUnmatchedBasicblocks() != 0 || rawFunction.getSizeOfUnmatchedJumps() != 0 || rawFunction2.getSizeOfUnmatchedBasicblocks() != 0 || rawFunction2.getSizeOfUnmatchedJumps() != 0;
    }
}
