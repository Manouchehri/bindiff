package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.*;
import java.util.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;

public class ZyEditModeMouseWheelListener extends cQ
{
    private static final double ZOOM_SUB_FACTOR = 0.02;
    private static final double SCROLL_SUB_FACTOR = 0.6;
    private final AbstractZyGraph m_zyGraph;
    
    public ZyEditModeMouseWheelListener(final AbstractZyGraph zyGraph) {
        Preconditions.checkNotNull(zyGraph, (Object)"Error: Graph argument can't be null");
        this.m_zyGraph = zyGraph;
        this.setCenterZooming(false);
    }
    
    private void centerZoom(final double n, final boolean b) {
        if (b) {
            final Set selectedNodes = this.m_zyGraph.getSelectedNodes();
            if (selectedNodes.size() != 0) {
                MoveFunctions.centerNodes(this.m_zyGraph, selectedNodes);
            }
        }
        this.m_zyGraph.zoom(n);
    }
    
    private void handleInMoveMode(final MouseWheelEvent mouseWheelEvent) {
        final boolean b = mouseWheelEvent.getUnitsToScroll() > 0;
        if (mouseWheelEvent.isAltDown()) {
            this.moveVertical(b);
        }
        else {
            this.moveHorizontal(b);
        }
    }
    
    private void handleInZoomMode(final MouseWheelEvent mouseWheelEvent) {
        this.zoom(mouseWheelEvent, mouseWheelEvent.getUnitsToScroll() > 0, mouseWheelEvent.isShiftDown());
    }
    
    private boolean hasSelectedNode() {
        return GraphHelpers.any(this.m_zyGraph, new ZyEditModeMouseWheelListener$1(this));
    }
    
    private void moveHorizontal(final boolean b) {
        if (b) {
            MoveFunctions.pan(this.m_zyGraph, 0.0, 0.6 * this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity());
        }
        else {
            MoveFunctions.pan(this.m_zyGraph, 0.0, -0.6 * this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity());
        }
    }
    
    private void moveVertical(final boolean b) {
        if (b) {
            MoveFunctions.pan(this.m_zyGraph, 0.6 * this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity(), 0.0);
        }
        else {
            MoveFunctions.pan(this.m_zyGraph, -0.6 * this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity(), 0.0);
        }
    }
    
    private void zoom(final MouseWheelEvent mouseWheelEvent, final boolean b, final boolean b2) {
        if (!this.hasSelectedNode() || !b2) {
            super.mouseWheelMoved(mouseWheelEvent);
        }
        else if (b) {
            this.centerZoom(1.0 - this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02, b2);
        }
        else {
            this.centerZoom(1.0 + this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02, b2);
        }
    }
    
    @Override
    protected double calcZoom(final double n, final int n2) {
        if (n2 <= 0) {
            final double n3 = 1.0 + this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02;
            this.setMaximumZoom(3.0);
            return this.m_zyGraph.getView().getZoom() * n3;
        }
        final double minimumZoom = ZoomHelpers.getMinimumZoom(this.m_zyGraph.getView());
        this.setMinimumZoom(minimumZoom);
        final double n4 = 1.0 - this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02;
        if (minimumZoom > 0.5) {
            super.setMinimumZoom(0.75);
            return this.m_zyGraph.getView().getZoom() * n4;
        }
        return Math.max(this.m_zyGraph.getView().getZoom() * n4, minimumZoom);
    }
    
    @Override
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        final int abs = Math.abs(mouseWheelEvent.getUnitsToScroll());
        final boolean controlDown = mouseWheelEvent.isControlDown();
        for (int i = 0; i < abs; ++i) {
            if ((this.m_zyGraph.getSettings().getMouseSettings().getMouseWheelAction() == MouseWheelAction.ZOOM && !controlDown) || (this.m_zyGraph.getSettings().getMouseSettings().getMouseWheelAction() == MouseWheelAction.SCROLL && controlDown)) {
                this.handleInZoomMode(mouseWheelEvent);
            }
            else {
                this.handleInMoveMode(mouseWheelEvent);
            }
        }
        this.m_zyGraph.updateViews();
    }
}
