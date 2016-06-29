package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;

public class RawCallGraph extends MutableDirectedGraph
{
    private final ImmutableMap addressToFunction;
    private final ESide side;
    
    public RawCallGraph(final List list, final List list2, final ESide eSide) {
        super(list, list2);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
        this.addressToFunction = Maps.uniqueIndex(list, new RawCallGraph$1(this));
    }
    
    public RawFunction getFunction(final IAddress address) {
        return (RawFunction)this.addressToFunction.get(address);
    }
    
    public ESide getSide() {
        return this.side;
    }
    
    public void resetVisibilityAndSelection() {
        for (final RawCall rawCall : this.getEdges()) {
            rawCall.removeAllListeners();
            rawCall.setVisible(true);
            rawCall.setSelected(false);
        }
        for (final RawFunction rawFunction : this.getNodes()) {
            rawFunction.removeAllListeners();
            rawFunction.setVisible(true);
            rawFunction.setSelected(false);
        }
    }
}
