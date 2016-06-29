package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class RawCombinedCallGraph extends MutableDirectedGraph
{
    private final Map addrPairToCombinedFunction;
    
    public RawCombinedCallGraph(final List list, final List list2) {
        super(list, list2);
        this.addrPairToCombinedFunction = new HashMap();
        for (final RawCombinedFunction rawCombinedFunction : list) {
            this.addrPairToCombinedFunction.put(new Pair(rawCombinedFunction.getAddress(ESide.PRIMARY), rawCombinedFunction.getAddress(ESide.SECONDARY)), rawCombinedFunction);
        }
    }
    
    public RawCombinedFunction getCombinedFunction(final IAddress address, final IAddress address2) {
        return this.addrPairToCombinedFunction.get(new Pair(address, address2));
    }
}
