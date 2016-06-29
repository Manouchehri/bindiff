package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class GraphAddressSearcher
{
    public static CombinedDiffNode searchAddress(final CombinedGraph combinedGraph, final ESide eSide, final IAddress address) {
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
            final CombinedViewNode rawNode = combinedDiffNode.getRawNode();
            if (rawNode instanceof RawCombinedBasicBlock) {
                final RawBasicBlock rawNode2 = ((RawCombinedBasicBlock)rawNode).getRawNode(eSide);
                if (rawNode2 == null) {
                    continue;
                }
                if (rawNode2.getInstruction(address) != null) {
                    return combinedDiffNode;
                }
                continue;
            }
            else {
                final RawFunction rawNode3 = ((RawCombinedFunction)rawNode).getRawNode(eSide);
                if (rawNode3 == null) {
                    continue;
                }
                if (rawNode3.getAddress().equals(address)) {
                    return combinedDiffNode;
                }
                continue;
            }
        }
        return null;
    }
    
    public static SingleDiffNode searchAddress(final SingleGraph singleGraph, final IAddress address) {
        for (final SingleDiffNode singleDiffNode : singleGraph.getNodes()) {
            final SingleViewNode rawNode = singleDiffNode.getRawNode();
            if (rawNode instanceof RawBasicBlock) {
                if (((RawBasicBlock)rawNode).getInstruction(address) != null) {
                    return singleDiffNode;
                }
                continue;
            }
            else {
                if (singleDiffNode.getRawNode().getAddress().equals(address)) {
                    return singleDiffNode;
                }
                continue;
            }
        }
        return null;
    }
}
