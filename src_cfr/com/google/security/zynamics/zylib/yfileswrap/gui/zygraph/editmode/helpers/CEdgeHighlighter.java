/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.dr;

public final class CEdgeHighlighter {
    public static void highlightEdge(aB aB2, boolean bl2) {
        if (bl2) {
            if (aB2.getLineType() == dr.b) {
                aB2.setLineType(dr.e);
                return;
            }
            if (aB2.getLineType() == dr.n) {
                aB2.setLineType(dr.q);
                return;
            }
            if (aB2.getLineType() == dr.i) {
                aB2.setLineType(dr.l);
                return;
            }
            if (aB2.getLineType() != dr.s) return;
            aB2.setLineType(dr.v);
            return;
        }
        if (aB2 == null) {
            return;
        }
        if (aB2.getLineType() == dr.e) {
            aB2.setLineType(dr.b);
            return;
        }
        if (aB2.getLineType() == dr.q) {
            aB2.setLineType(dr.n);
            return;
        }
        if (aB2.getLineType() == dr.l) {
            aB2.setLineType(dr.i);
            return;
        }
        if (aB2.getLineType() != dr.v) return;
        aB2.setLineType(dr.s);
    }

    public static void highlightEdgesOfNode(q q2, boolean bl2) {
        e e2 = q2.j();
        int n2 = q2.a();
        d d2 = e2.a();
        while (n2 > 0) {
            aB aB2 = ((bu)q2.e()).i(d2);
            CEdgeHighlighter.highlightEdge(aB2, bl2);
            e2.b();
            d2 = e2.a();
            --n2;
        }
    }
}

