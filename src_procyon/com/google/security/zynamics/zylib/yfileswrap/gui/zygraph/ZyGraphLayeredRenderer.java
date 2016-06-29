package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import y.h.*;
import y.h.a.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public class ZyGraphLayeredRenderer extends ZyGraphFineGrainedRenderer
{
    private q m_node;
    
    public ZyGraphLayeredRenderer(final IFineGrainedSloppyGraph2DView fineGrainedSloppyGraph2DView) {
        super(fineGrainedSloppyGraph2DView);
        this.m_node = null;
        this.setLayeredPainting(true);
    }
    
    private boolean isAnyParentNodeSelected(final q q) {
        final bu bu = (bu)q.e();
        final v c = bu.C();
        if (c == null) {
            return false;
        }
        boolean b = false;
        for (q q2 = c.n(q); q2 != null; q2 = c.n(q2)) {
            if (bu.v(q2)) {
                b = true;
                break;
            }
        }
        return b;
    }
    
    @Override
    protected int getLayer(final bu bu, final d d) {
        return 2;
    }
    
    @Override
    protected int getLayer(final bu bu, final q q) {
        final boolean b = bu.t(q) instanceof ZyGroupNodeRealizer;
        if ((bu.v(q) || this.isAnyParentNodeSelected(q)) && !b) {
            return 3;
        }
        if (this.m_node == q && !b) {
            return 4;
        }
        if (b) {
            return 1;
        }
        return 2;
    }
    
    public void bringNodeToFront(final q node) {
        this.m_node = node;
    }
}
