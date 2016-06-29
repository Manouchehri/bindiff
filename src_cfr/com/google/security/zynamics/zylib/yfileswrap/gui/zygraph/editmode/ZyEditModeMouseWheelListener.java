/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IMouseSettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditModeMouseWheelListener$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.MoveFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import java.awt.event.MouseWheelEvent;
import java.util.Set;
import y.h.cQ;
import y.h.ch;

public class ZyEditModeMouseWheelListener
extends cQ {
    private static final double ZOOM_SUB_FACTOR = 0.02;
    private static final double SCROLL_SUB_FACTOR = 0.6;
    private final AbstractZyGraph m_zyGraph;

    public ZyEditModeMouseWheelListener(AbstractZyGraph abstractZyGraph) {
        Preconditions.checkNotNull(abstractZyGraph, "Error: Graph argument can't be null");
        this.m_zyGraph = abstractZyGraph;
        this.setCenterZooming(false);
    }

    private void centerZoom(double d2, boolean bl2) {
        Set set;
        if (bl2 && (set = this.m_zyGraph.getSelectedNodes()).size() != 0) {
            MoveFunctions.centerNodes(this.m_zyGraph, set);
        }
        this.m_zyGraph.zoom(d2);
    }

    private void handleInMoveMode(MouseWheelEvent mouseWheelEvent) {
        boolean bl2;
        boolean bl3 = bl2 = mouseWheelEvent.getUnitsToScroll() > 0;
        if (mouseWheelEvent.isAltDown()) {
            this.moveVertical(bl2);
            return;
        }
        this.moveHorizontal(bl2);
    }

    private void handleInZoomMode(MouseWheelEvent mouseWheelEvent) {
        this.zoom(mouseWheelEvent, mouseWheelEvent.getUnitsToScroll() > 0, mouseWheelEvent.isShiftDown());
    }

    private boolean hasSelectedNode() {
        return GraphHelpers.any(this.m_zyGraph, new ZyEditModeMouseWheelListener$1(this));
    }

    private void moveHorizontal(boolean bl2) {
        if (bl2) {
            MoveFunctions.pan(this.m_zyGraph, 0.0, 0.6 * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity());
            return;
        }
        MoveFunctions.pan(this.m_zyGraph, 0.0, -0.6 * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity());
    }

    private void moveVertical(boolean bl2) {
        if (bl2) {
            MoveFunctions.pan(this.m_zyGraph, 0.6 * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity(), 0.0);
            return;
        }
        MoveFunctions.pan(this.m_zyGraph, -0.6 * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity(), 0.0);
    }

    private void zoom(MouseWheelEvent mouseWheelEvent, boolean bl2, boolean bl3) {
        if (!this.hasSelectedNode() || !bl3) {
            super.mouseWheelMoved(mouseWheelEvent);
            return;
        }
        if (bl2) {
            this.centerZoom(1.0 - (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02, bl3);
            return;
        }
        this.centerZoom(1.0 + (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02, bl3);
    }

    @Override
    protected double calcZoom(double d2, int n2) {
        if (n2 > 0) {
            double d3 = ZoomHelpers.getMinimumZoom(this.m_zyGraph.getView());
            this.setMinimumZoom(d3);
            double d4 = 1.0 - (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02;
            if (d3 <= 0.5) return Math.max(this.m_zyGraph.getView().getZoom() * d4, d3);
            super.setMinimumZoom(0.75);
            return this.m_zyGraph.getView().getZoom() * d4;
        }
        double d5 = 1.0 + (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02;
        this.setMaximumZoom(3.0);
        return this.m_zyGraph.getView().getZoom() * d5;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        int n2 = Math.abs(mouseWheelEvent.getUnitsToScroll());
        boolean bl2 = mouseWheelEvent.isControlDown();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.m_zyGraph.updateViews();
                return;
            }
            if (this.m_zyGraph.getSettings().getMouseSettings().getMouseWheelAction() == MouseWheelAction.ZOOM && !bl2 || this.m_zyGraph.getSettings().getMouseSettings().getMouseWheelAction() == MouseWheelAction.SCROLL && bl2) {
                this.handleInZoomMode(mouseWheelEvent);
            } else {
                this.handleInMoveMode(mouseWheelEvent);
            }
            ++n3;
        } while (true);
    }
}

