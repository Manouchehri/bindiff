/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.util;

import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer;
import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer$1;
import java.util.Comparator;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.q;
import y.f.c.a.aV;
import y.f.c.a.aX;

class CustomizedPCListOptimizer$EdgeOrderComparator
implements Comparator {
    private final q node;
    private final c node2IsSameLayerDummy;
    private final int nodePos;
    private final aV ldp;
    final /* synthetic */ CustomizedPCListOptimizer this$0;

    private CustomizedPCListOptimizer$EdgeOrderComparator(CustomizedPCListOptimizer customizedPCListOptimizer, c c2, q q2, aV aV2) {
        this.this$0 = customizedPCListOptimizer;
        this.node2IsSameLayerDummy = c2;
        this.node = q2;
        this.ldp = aV2;
        this.nodePos = aV2.a(q2).k();
    }

    private int getPositionOfOpposite(d d2) {
        q q2 = d2.a(this.node);
        if (!this.node2IsSameLayerDummy.d(q2)) {
            aX aX2 = this.ldp.a(q2);
            return aX2.k();
        }
        d d3 = null;
        Object object = q2.j();
        while (object.f()) {
            if (object.a() != d2) {
                d3 = object.a();
                break;
            }
            object.g();
        }
        object = this.ldp.a(d3.a(q2));
        return object.k();
    }

    private boolean isSameLayerEdge(d d2) {
        return this.node2IsSameLayerDummy.d(d2.a(this.node));
    }

    public int compare(d d2, d d3) {
        d d4 = d2;
        d d5 = d3;
        int n2 = this.getPositionOfOpposite(d4);
        int n3 = this.getPositionOfOpposite(d5);
        if (this.isSameLayerEdge(d4) && this.isSameLayerEdge(d5)) {
            if (this.nodePos > n2) {
                if (this.nodePos > n3) return n3 - n2;
            }
            if (this.nodePos < n2 && this.nodePos < n3) {
                return n3 - n2;
            }
            if (n2 >= n3) return 1;
            return -1;
        }
        if (this.isSameLayerEdge(d4)) {
            if (this.nodePos <= n2) return 1;
            return -1;
        }
        if (!this.isSameLayerEdge(d5)) return n2 - n3;
        if (this.nodePos <= n3) return -1;
        return 1;
    }

    /* synthetic */ CustomizedPCListOptimizer$EdgeOrderComparator(CustomizedPCListOptimizer customizedPCListOptimizer, c c2, q q2, aV aV2, CustomizedPCListOptimizer$1 customizedPCListOptimizer$1) {
        this(customizedPCListOptimizer, c2, q2, aV2);
    }
}

