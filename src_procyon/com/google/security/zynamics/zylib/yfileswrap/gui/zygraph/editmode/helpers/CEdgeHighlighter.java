package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import y.h.*;
import y.c.*;

public final class CEdgeHighlighter
{
    public static void highlightEdge(final aB ab, final boolean b) {
        if (b) {
            if (ab.getLineType() == dr.b) {
                ab.setLineType(dr.e);
            }
            else if (ab.getLineType() == dr.n) {
                ab.setLineType(dr.q);
            }
            else if (ab.getLineType() == dr.i) {
                ab.setLineType(dr.l);
            }
            else if (ab.getLineType() == dr.s) {
                ab.setLineType(dr.v);
            }
        }
        else {
            if (ab == null) {
                return;
            }
            if (ab.getLineType() == dr.e) {
                ab.setLineType(dr.b);
            }
            else if (ab.getLineType() == dr.q) {
                ab.setLineType(dr.n);
            }
            else if (ab.getLineType() == dr.l) {
                ab.setLineType(dr.i);
            }
            else if (ab.getLineType() == dr.v) {
                ab.setLineType(dr.s);
            }
        }
    }
    
    public static void highlightEdgesOfNode(final q q, final boolean b) {
        final e j = q.j();
        int i = q.a();
        d d = j.a();
        while (i > 0) {
            highlightEdge(((bu)q.e()).i(d), b);
            j.b();
            d = j.a();
            --i;
        }
    }
}
