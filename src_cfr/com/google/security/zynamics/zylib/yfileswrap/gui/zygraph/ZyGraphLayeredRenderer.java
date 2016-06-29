/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphFineGrainedRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyGroupNodeRealizer;
import y.c.d;
import y.c.i;
import y.c.q;
import y.h.a.v;
import y.h.bu;
import y.h.fj;

public class ZyGraphLayeredRenderer
extends ZyGraphFineGrainedRenderer {
    private q m_node = null;

    public ZyGraphLayeredRenderer(IFineGrainedSloppyGraph2DView iFineGrainedSloppyGraph2DView) {
        super(iFineGrainedSloppyGraph2DView);
        this.setLayeredPainting(true);
    }

    private boolean isAnyParentNodeSelected(q q2) {
        bu bu2 = (bu)q2.e();
        v v2 = bu2.C();
        if (v2 == null) {
            return false;
        }
        boolean bl2 = false;
        q q3 = v2.n(q2);
        while (q3 != null) {
            if (bu2.v(q3)) {
                return true;
            }
            q3 = v2.n(q3);
        }
        return bl2;
    }

    @Override
    protected int getLayer(bu bu2, d d2) {
        return 2;
    }

    @Override
    protected int getLayer(bu bu2, q q2) {
        boolean bl2 = bu2.t(q2) instanceof ZyGroupNodeRealizer;
        if ((bu2.v(q2) || this.isAnyParentNodeSelected(q2)) && !bl2) {
            return 3;
        }
        if (this.m_node == q2 && !bl2) {
            return 4;
        }
        if (!bl2) return 2;
        return 1;
    }

    public void bringNodeToFront(q q2) {
        this.m_node = q2;
    }
}

