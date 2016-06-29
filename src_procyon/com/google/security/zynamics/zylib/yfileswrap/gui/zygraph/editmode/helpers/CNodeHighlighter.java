package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import y.c.*;
import y.h.*;

public final class CNodeHighlighter
{
    public static void highlightNode(final q q, final boolean b) {
        final fj t = ((bu)q.e()).t(q);
        if (t == null) {
            return;
        }
        if (b) {
            if (t.getLineType() == dr.b) {
                t.setLineType(dr.e);
            }
        }
        else if (t.getLineType() == dr.e) {
            t.setLineType(dr.b);
        }
    }
}
