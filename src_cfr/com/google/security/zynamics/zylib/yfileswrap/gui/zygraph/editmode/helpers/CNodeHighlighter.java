/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import y.c.i;
import y.c.q;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public final class CNodeHighlighter {
    public static void highlightNode(q q2, boolean bl2) {
        fj fj2 = ((bu)q2.e()).t(q2);
        if (fj2 == null) {
            return;
        }
        if (bl2) {
            if (fj2.getLineType() != dr.b) return;
            fj2.setLineType(dr.e);
            return;
        }
        if (fj2.getLineType() != dr.e) return;
        fj2.setLineType(dr.b);
    }
}

