package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import java.util.*;
import y.c.*;

public class ZyGraphDefaultRenderer extends O
{
    private final LinkedHashSet m_nodesInDrawingOrder;
    
    public ZyGraphDefaultRenderer() {
        this.m_nodesInDrawingOrder = new LinkedHashSet();
        this.setLayeredPainting(true);
    }
    
    @Override
    protected int getLayer(final bu bu, final q q) {
        if (bu.t(q) instanceof ZyGroupNodeRealizer) {
            return super.getLayer(bu, q);
        }
        int n = 1;
        final Iterator iterator = this.m_nodesInDrawingOrder.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == q) {
                return n;
            }
            ++n;
        }
        return super.getLayer(bu, q);
    }
    
    public void bringNodeToFront(final q q) {
        final bu bu = (bu)q.e();
        if (bu.t(q).isSelected()) {
            final x j = bu.J();
            while (j.f()) {
                this.m_nodesInDrawingOrder.remove(j.e());
                this.m_nodesInDrawingOrder.add(j.e());
                j.g();
            }
        }
        else {
            this.m_nodesInDrawingOrder.remove(q);
            this.m_nodesInDrawingOrder.add(q);
        }
    }
}
