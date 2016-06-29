/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyGroupNodeRealizer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import y.c.i;
import y.c.q;
import y.c.x;
import y.h.O;
import y.h.bu;
import y.h.fj;

public class ZyGraphDefaultRenderer
extends O {
    private final LinkedHashSet m_nodesInDrawingOrder = new LinkedHashSet();

    public ZyGraphDefaultRenderer() {
        this.setLayeredPainting(true);
    }

    @Override
    protected int getLayer(bu bu2, q q2) {
        if (bu2.t(q2) instanceof ZyGroupNodeRealizer) {
            return super.getLayer(bu2, q2);
        }
        int n2 = 1;
        Iterator iterator = this.m_nodesInDrawingOrder.iterator();
        while (iterator.hasNext()) {
            q q3 = (q)iterator.next();
            if (q3 == q2) {
                return n2;
            }
            ++n2;
        }
        return super.getLayer(bu2, q2);
    }

    public void bringNodeToFront(q q2) {
        bu bu2 = (bu)q2.e();
        fj fj2 = bu2.t(q2);
        if (!fj2.isSelected()) {
            this.m_nodesInDrawingOrder.remove(q2);
            this.m_nodesInDrawingOrder.add(q2);
            return;
        }
        x x2 = bu2.J();
        while (x2.f()) {
            this.m_nodesInDrawingOrder.remove(x2.e());
            this.m_nodesInDrawingOrder.add(x2.e());
            x2.g();
        }
    }
}

