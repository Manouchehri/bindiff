/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RawCombinedCallGraph
extends MutableDirectedGraph {
    private final Map addrPairToCombinedFunction = new HashMap();

    public RawCombinedCallGraph(List list, List list2) {
        super(list, list2);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)iterator.next();
            this.addrPairToCombinedFunction.put(new Pair(rawCombinedFunction.getAddress(ESide.PRIMARY), rawCombinedFunction.getAddress(ESide.SECONDARY)), rawCombinedFunction);
        }
    }

    public RawCombinedFunction getCombinedFunction(IAddress iAddress, IAddress iAddress2) {
        return (RawCombinedFunction)this.addrPairToCombinedFunction.get(new Pair(iAddress, iAddress2));
    }
}

