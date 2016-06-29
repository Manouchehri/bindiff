package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import y.a.*;
import java.util.*;
import y.c.*;
import com.google.common.collect.*;

public class CGraphSelector
{
    public static void selectNode(final AbstractZyGraph abstractZyGraph, final ZyGraphNode zyGraphNode, final boolean b) {
        final ArrayList<ZyGraphNode> list = new ArrayList<ZyGraphNode>();
        final ArrayList<ZyGraphNode> list2 = new ArrayList<ZyGraphNode>();
        for (final ZyGraphNode zyGraphNode2 : abstractZyGraph.getNodes()) {
            if (zyGraphNode2 == zyGraphNode) {
                if (zyGraphNode.isSelected()) {
                    list2.add(zyGraphNode2);
                }
                else {
                    list.add(zyGraphNode2);
                }
            }
            else if (zyGraphNode2.isSelected() && b) {
                list.add(zyGraphNode2);
            }
            else {
                list2.add(zyGraphNode2);
            }
        }
        abstractZyGraph.selectNodes(list, list2);
    }
    
    public static void selectPath(final AbstractZyGraph abstractZyGraph, final ArrayList list, final ZyGraphNode zyGraphNode) {
        final y y = new y(Collections2.transform(list, new CGraphSelector$1()).iterator());
        final y y2 = new y(zyGraphNode.getNode());
        final HashSet set = new HashSet();
        final y[] a = b.a(abstractZyGraph.getGraph(), y, (byte)2, abstractZyGraph.getGraph().t(), 0);
        for (int length = a.length, i = 0; i < length; ++i) {
            set.addAll(a[i]);
        }
        final HashSet set2 = new HashSet();
        final y[] a2 = b.a(abstractZyGraph.getGraph(), y2, (byte)1, abstractZyGraph.getGraph().t(), 0);
        for (int length2 = a2.length, j = 0; j < length2; ++j) {
            set2.addAll(a2[j]);
        }
        final Sets$SetView intersection = Sets.intersection(set, set2);
        if (!intersection.isEmpty()) {
            final Iterator<q> iterator = intersection.iterator();
            while (iterator.hasNext()) {
                abstractZyGraph.getGraph().a(iterator.next(), true);
            }
        }
        final HashSet set3 = new HashSet();
        final y[] a3 = b.a(abstractZyGraph.getGraph(), y, (byte)1, abstractZyGraph.getGraph().t(), 0);
        for (int length3 = a3.length, k = 0; k < length3; ++k) {
            set3.addAll(a3[k]);
        }
        final HashSet set4 = new HashSet();
        final y[] a4 = b.a(abstractZyGraph.getGraph(), y2, (byte)2, abstractZyGraph.getGraph().t(), 0);
        for (int length4 = a4.length, l = 0; l < length4; ++l) {
            set4.addAll(a4[l]);
        }
        final Sets$SetView intersection2 = Sets.intersection(set3, set4);
        if (!intersection2.isEmpty()) {
            final Iterator<q> iterator2 = intersection2.iterator();
            while (iterator2.hasNext()) {
                abstractZyGraph.getGraph().a(iterator2.next(), true);
            }
        }
    }
}
