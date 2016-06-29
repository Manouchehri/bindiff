package com.google.security.zynamics.bindiff.graph.layout.util;

import java.util.*;
import y.f.c.a.*;
import y.c.*;

class CustomizedPCListOptimizer$EdgeOrderComparator implements Comparator
{
    private final q node;
    private final c node2IsSameLayerDummy;
    private final int nodePos;
    private final aV ldp;
    final /* synthetic */ CustomizedPCListOptimizer this$0;
    
    private CustomizedPCListOptimizer$EdgeOrderComparator(final CustomizedPCListOptimizer this$0, final c node2IsSameLayerDummy, final q node, final aV ldp) {
        this.this$0 = this$0;
        this.node2IsSameLayerDummy = node2IsSameLayerDummy;
        this.node = node;
        this.ldp = ldp;
        this.nodePos = ldp.a(node).k();
    }
    
    private int getPositionOfOpposite(final d d) {
        final q a = d.a(this.node);
        if (this.node2IsSameLayerDummy.d(a)) {
            d a2 = null;
            final e j = a.j();
            while (j.f()) {
                if (j.a() != d) {
                    a2 = j.a();
                    break;
                }
                j.g();
            }
            return this.ldp.a(a2.a(a)).k();
        }
        return this.ldp.a(a).k();
    }
    
    private boolean isSameLayerEdge(final d d) {
        return this.node2IsSameLayerDummy.d(d.a(this.node));
    }
    
    public int compare(final d d, final d d2) {
        final int positionOfOpposite = this.getPositionOfOpposite(d);
        final int positionOfOpposite2 = this.getPositionOfOpposite(d2);
        if (this.isSameLayerEdge(d) && this.isSameLayerEdge(d2)) {
            if ((this.nodePos > positionOfOpposite && this.nodePos > positionOfOpposite2) || (this.nodePos < positionOfOpposite && this.nodePos < positionOfOpposite2)) {
                return positionOfOpposite2 - positionOfOpposite;
            }
            if (positionOfOpposite < positionOfOpposite2) {
                return -1;
            }
            return 1;
        }
        else if (this.isSameLayerEdge(d)) {
            if (this.nodePos > positionOfOpposite) {
                return -1;
            }
            return 1;
        }
        else {
            if (!this.isSameLayerEdge(d2)) {
                return positionOfOpposite - positionOfOpposite2;
            }
            if (this.nodePos > positionOfOpposite2) {
                return 1;
            }
            return -1;
        }
    }
}
