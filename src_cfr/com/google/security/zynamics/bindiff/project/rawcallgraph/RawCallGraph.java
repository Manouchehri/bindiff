/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph$1;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.Iterator;
import java.util.List;

public class RawCallGraph
extends MutableDirectedGraph {
    private final ImmutableMap addressToFunction;
    private final ESide side;

    public RawCallGraph(List list, List list2, ESide eSide) {
        super(list, list2);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
        this.addressToFunction = Maps.uniqueIndex(list, (Function)new RawCallGraph$1(this));
    }

    public RawFunction getFunction(IAddress iAddress) {
        return (RawFunction)this.addressToFunction.get(iAddress);
    }

    public ESide getSide() {
        return this.side;
    }

    public void resetVisibilityAndSelection() {
        for (Object object2 : this.getEdges()) {
            object2.removeAllListeners();
            object2.setVisible(true);
            object2.setSelected(false);
        }
        Iterator iterator = this.getNodes().iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (RawFunction)iterator.next();
            object2.removeAllListeners();
            object2.setVisible(true);
            object2.setSelected(false);
        }
    }
}

