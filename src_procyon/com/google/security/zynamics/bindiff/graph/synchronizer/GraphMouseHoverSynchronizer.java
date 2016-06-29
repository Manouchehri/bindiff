package com.google.security.zynamics.bindiff.graph.synchronizer;

import y.h.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.util.*;
import y.c.*;

public class GraphMouseHoverSynchronizer
{
    private static void highlightEdge(final d d) {
        final aB i = ((bu)d.a()).i(d);
        final dr lineType = i.getLineType();
        if (lineType == dr.b) {
            i.setLineType(dr.e);
        }
        else if (lineType == dr.i) {
            i.setLineType(dr.l);
        }
        else if (lineType == dr.n) {
            i.setLineType(dr.q);
        }
        else if (lineType == dr.e) {
            i.setLineType(dr.b);
        }
        else if (lineType == dr.l) {
            i.setLineType(dr.i);
        }
        else if (lineType == dr.q) {
            i.setLineType(dr.n);
        }
    }
    
    public static void adoptHoveredNodeState(final SingleGraph singleGraph, final SingleDiffNode singleDiffNode) {
        if (singleGraph.getSettings().isSync()) {
            final SingleDiffNode otherSideDiffNode = singleDiffNode.getOtherSideDiffNode();
            if (otherSideDiffNode != null) {
                otherSideDiffNode.getRealizer().getRealizer().setLineType(singleDiffNode.getRealizer().getRealizer().getLineType());
                final HashSet<d> set = new HashSet<d>();
                final e j = otherSideDiffNode.getNode().j();
                while (j.f()) {
                    if (!set.contains(j.a())) {
                        highlightEdge(j.a());
                    }
                    set.add(j.a());
                    j.g();
                }
            }
            singleGraph.getSecondaryGraph().updateViews();
            singleGraph.getPrimaryGraph().updateViews();
        }
    }
}
