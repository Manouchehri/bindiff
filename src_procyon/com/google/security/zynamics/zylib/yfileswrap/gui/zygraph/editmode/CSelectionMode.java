package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import java.awt.geom.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import y.c.*;

public class CSelectionMode extends gf
{
    private final AbstractZyGraph m_graph;
    
    public CSelectionMode(final AbstractZyGraph abstractZyGraph) {
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Error: Graph argument can not be null");
    }
    
    @Override
    protected void selectionBoxAction(final Rectangle rectangle, final boolean b) {
        this.m_graph.getGraph().r();
        final y y = new y();
        final x o = this.m_graph.getGraph().o();
        while (o.f()) {
            final ZyGraphNode node = this.m_graph.getNode(o.e());
            if (node != null) {
                if (!(node instanceof ZyProximityNode)) {
                    if (this.belongsToSelection(o.e(), rectangle)) {
                        y.add(o.e());
                    }
                }
            }
            o.g();
        }
        if ((this.getLastDragEvent().getModifiersEx() & 0x80) == 0x0 && (this.getLastDragEvent().getModifiersEx() & 0x40) == 0x0) {
            this.m_graph.getGraph().N();
        }
        final Iterator iterator = y.iterator();
        while (iterator.hasNext()) {
            this.m_graph.getGraph().a(iterator.next(), true);
        }
        final e k = this.m_graph.getGraph().K();
        while (k.f()) {
            final y.c.d a = k.a();
            final q c = a.c();
            final q d = a.d();
            if (!this.m_graph.getGraph().t(c).isSelected() && !this.m_graph.getGraph().t(d).isSelected()) {
                this.m_graph.getGraph().i(a).setSelected(false);
            }
            k.g();
        }
        this.m_graph.getGraph().s();
        this.m_graph.getGraph().T();
    }
}
