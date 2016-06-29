/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.aB;
import y.h.bu;
import y.h.fj;
import y.h.gf;

public class CSelectionMode
extends gf {
    private final AbstractZyGraph m_graph;

    public CSelectionMode(AbstractZyGraph abstractZyGraph) {
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Error: Graph argument can not be null");
    }

    @Override
    protected void selectionBoxAction(Rectangle rectangle, boolean bl2) {
        q q2;
        Object object3;
        this.m_graph.getGraph().r();
        y y2 = new y();
        Object object2 = this.m_graph.getGraph().o();
        while (object2.f()) {
            object3 = this.m_graph.getNode(object2.e());
            if (object3 != null && !(object3 instanceof ZyProximityNode) && this.belongsToSelection(object2.e(), (Rectangle2D)rectangle)) {
                y2.add(object2.e());
            }
            object2.g();
        }
        if ((this.getLastDragEvent().getModifiersEx() & 128) == 0 && (this.getLastDragEvent().getModifiersEx() & 64) == 0) {
            this.m_graph.getGraph().N();
        }
        for (Object object3 : y2) {
            q2 = (q)object3;
            this.m_graph.getGraph().a(q2, true);
        }
        object2 = this.m_graph.getGraph().K();
        do {
            if (!object2.f()) {
                this.m_graph.getGraph().s();
                this.m_graph.getGraph().T();
                return;
            }
            object3 = object2.a();
            q2 = object3.c();
            q q3 = object3.d();
            if (!this.m_graph.getGraph().t(q2).isSelected() && !this.m_graph.getGraph().t(q3).isSelected()) {
                this.m_graph.getGraph().i((d)object3).setSelected(false);
            }
            object2.g();
        } while (true);
    }
}

