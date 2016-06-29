/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphConverters;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ITextNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityNodeFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewableGraph;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class ProximityNodeFunctions {
    private Collection filterVisibleNodes(Collection collection) {
        return CollectionHelpers.filter(collection, new ProximityNodeFunctions$1(this));
    }

    /*
     * Unable to fully structure code
     */
    private Collection getNeighborhood(AbstractZyGraph var1_1, ZyProximityNode var2_2) {
        var3_3 = var2_2.isIncoming() != false ? ((IGraphNode)var2_2.getRawNode().getAttachedNode()).getChildren() : ((IGraphNode)var2_2.getRawNode().getAttachedNode()).getParents();
        var4_4 = new LinkedHashSet<IViewNode>();
        for (IViewNode var6_6 : var3_3) {
            if (var6_6.isVisible()) continue;
            if (var6_6.getParentGroup() != null) {
                var4_4.add(var6_6.getParentGroup());
                var4_4.add(var6_6);
                continue;
            }
            var4_4.add(var6_6);
        }
        var5_5 = new ArrayList<E>(var4_4).iterator();
        block1 : do lbl-1000: // 3 sources:
        {
            if (var5_5.hasNext() == false) return GraphConverters.convert(var1_1, var4_4);
            var6_6 = (IViewNode)var5_5.next();
            if (!var2_2.isIncoming()) ** GOTO lbl23
            var7_7 = ((IGraphNode)var6_6).getParents().iterator();
            do {
                if (!var7_7.hasNext()) ** GOTO lbl-1000
                var8_8 = (IViewNode)var7_7.next();
                if (!(var8_8 instanceof ITextNode)) continue;
                var4_4.add(var8_8);
            } while (true);
lbl23: // 1 sources:
            var7_7 = ((IGraphNode)var6_6).getChildren().iterator();
            do {
                if (!var7_7.hasNext()) continue block1;
                var8_8 = (IViewNode)var7_7.next();
                if (!(var8_8 instanceof ITextNode)) continue;
                var4_4.add(var8_8);
            } while (true);
            break;
        } while (true);
    }

    protected abstract void showNodes(Window var1, AbstractZyGraph var2, List var3, boolean var4);

    public void showHiddenNodes(Window window, AbstractZyGraph abstractZyGraph, ZyProximityNode zyProximityNode) {
        LinkedHashSet<E> linkedHashSet = new LinkedHashSet<E>();
        Set set = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(abstractZyGraph));
        linkedHashSet.addAll(this.filterVisibleNodes(set));
        linkedHashSet.addAll(this.filterVisibleNodes(this.getNeighborhood(abstractZyGraph, zyProximityNode)));
        this.showNodes(window, abstractZyGraph, new ArrayList<E>(linkedHashSet), false);
    }

    public void unhideAndSelect(AbstractZyGraph abstractZyGraph, ZyProximityNode zyProximityNode) {
        abstractZyGraph.selectNodes(this.getNeighborhood(abstractZyGraph, zyProximityNode), true);
    }

    public void unhideAndSelectOnly(AbstractZyGraph abstractZyGraph, ZyProximityNode zyProximityNode) {
        Collection collection = this.getNeighborhood(abstractZyGraph, zyProximityNode);
        List list = GraphHelpers.getNodes(abstractZyGraph);
        list.removeAll(collection);
        abstractZyGraph.selectNodes(collection, list);
    }

    public void unhideChildren(Window window, AbstractZyGraph abstractZyGraph, ZyProximityNode zyProximityNode) {
        ArrayList<E> arrayList = new ArrayList<E>();
        Set set = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(abstractZyGraph));
        arrayList.addAll(set);
        arrayList.addAll(GraphConverters.convert(abstractZyGraph, GraphAlgorithms.getSuccessors((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode()))));
        this.showNodes(window, abstractZyGraph, arrayList, true);
    }

    public void unhideParents(Window window, AbstractZyGraph abstractZyGraph, ZyProximityNode zyProximityNode) {
        ArrayList<E> arrayList = new ArrayList<E>();
        Set set = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(abstractZyGraph));
        arrayList.addAll(set);
        arrayList.addAll(GraphConverters.convert(abstractZyGraph, GraphAlgorithms.getPredecessors((IGraphNode)((Object)zyProximityNode.getRawNode().getAttachedNode()))));
        this.showNodes(window, abstractZyGraph, arrayList, true);
    }
}

