/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.CDefaultActionFactory;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateActionFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CSelectionMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditModeMouseWheelListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import y.c.d;
import y.c.q;
import y.h.aC;
import y.h.ch;
import y.h.ds;
import y.h.gX;

public class ZyEditMode
extends aC {
    private final IStateActionFactory m_actionFactory;
    private final CStateFactory m_stateFactory;
    private IMouseState m_state;
    private final AbstractZyGraph m_graph;
    private final ds m_magifierViewMode = new ds();
    private final List m_listeners = new ArrayList();
    private final CDefaultLabelEventHandler m_labelKeyHandler;
    private boolean m_inMouseMoved;
    private boolean m_inMouseDragged;
    private boolean m_inMousePressed;
    private boolean m_inMouseDraggedRight;

    public ZyEditMode(AbstractZyGraph abstractZyGraph) {
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, "Graph argument cannot be null");
        this.m_labelKeyHandler = this.createNodeKeyHandler(abstractZyGraph);
        this.m_actionFactory = this.createStateActionFactory();
        this.m_stateFactory = new CStateFactory(abstractZyGraph, this.m_listeners, this.m_actionFactory);
        this.m_state = this.m_stateFactory.createDefaultState();
        this.setDefaultBehaviour();
    }

    private boolean getMagnifyingMode() {
        Iterator iterator = this.m_graph.getView().getViewModes();
        do {
            if (!iterator.hasNext()) return false;
        } while (iterator.next() != this.m_magifierViewMode);
        return true;
    }

    private void setDefaultBehaviour() {
        this.allowBendCreation(false);
        this.allowEdgeCreation(false);
        this.allowNodeCreation(false);
        this.allowMoveLabels(true);
        this.allowMovePorts(true);
        this.allowNodeEditing(true);
        this.allowMoving(true);
        this.allowMoveSelection(true);
        this.showEdgeTips(true);
        this.showNodeTips(true);
        this.setSelectionBoxMode(new CSelectionMode(this.m_graph));
        this.m_graph.getView().getCanvasComponent().addMouseWheelListener(new ZyEditModeMouseWheelListener(this.m_graph));
    }

    protected CDefaultLabelEventHandler createNodeKeyHandler(AbstractZyGraph abstractZyGraph) {
        return new CDefaultLabelEventHandler(abstractZyGraph);
    }

    protected IStateActionFactory createStateActionFactory() {
        return new CDefaultActionFactory();
    }

    @Override
    protected String getEdgeTip(d d2) {
        return CTooltipUpdater.updateEdgeTooltip(this.m_graph, d2);
    }

    protected AbstractZyGraph getGraph() {
        return this.m_graph;
    }

    @Override
    protected String getNodeTip(q q2) {
        return CTooltipUpdater.updateNodeTooltip(this.m_graph, q2);
    }

    public void addListener(IZyEditModeListener iZyEditModeListener) {
        this.m_listeners.add(iZyEditModeListener);
    }

    public CDefaultLabelEventHandler getLabelEventHandler() {
        return this.m_labelKeyHandler;
    }

    public boolean isInMouseDragged() {
        return this.m_inMouseDragged;
    }

    public boolean isInMouseDraggedRight() {
        return this.m_inMouseDraggedRight;
    }

    public boolean isInMouseMoved() {
        return this.m_inMouseMoved;
    }

    public boolean isInMousePressed() {
        return this.m_inMousePressed;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        Preconditions.checkNotNull(mouseEvent, "Error: mouse event can not be null");
        IMouseStateChange iMouseStateChange = this.m_state.mouseDragged(mouseEvent, this.m_graph);
        this.m_state = iMouseStateChange.getNextState();
        if (!iMouseStateChange.notifyYFiles()) return;
        this.m_inMouseDragged = true;
        try {
            super.mouseDragged(mouseEvent);
            return;
        }
        finally {
            this.m_inMouseDragged = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mouseDraggedRight(double d2, double d3) {
        this.m_inMouseDraggedRight = true;
        try {
            super.mouseDraggedLeft(d2, d3);
            return;
        }
        finally {
            this.m_inMouseDraggedRight = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mouseMoved(double d2, double d3) {
        this.m_inMouseMoved = true;
        try {
            super.mouseMoved(d2, d3);
            return;
        }
        finally {
            this.m_inMouseMoved = false;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Preconditions.checkNotNull(mouseEvent, "Error: mouse event can not be null");
        IMouseStateChange iMouseStateChange = this.m_state.mouseMoved(mouseEvent, this.m_graph);
        this.m_state = iMouseStateChange.getNextState();
        if (!iMouseStateChange.notifyYFiles()) return;
        this.m_inMouseMoved = true;
        try {
            super.mouseMoved(mouseEvent);
            return;
        }
        finally {
            this.m_inMouseMoved = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        IMouseStateChange iMouseStateChange = this.m_state.mousePressed(mouseEvent, this.m_graph);
        this.m_state = iMouseStateChange.getNextState();
        if (!iMouseStateChange.notifyYFiles()) return;
        this.m_inMousePressed = true;
        try {
            super.mousePressed(mouseEvent);
            return;
        }
        finally {
            this.m_inMousePressed = false;
        }
    }

    @Override
    public void mouseReleased(double d2, double d3) {
        super.mouseReleased(d2, d3);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        IMouseStateChange iMouseStateChange = this.m_state.mouseReleased(mouseEvent, this.m_graph);
        this.m_state = iMouseStateChange.getNextState();
        if (!iMouseStateChange.notifyYFiles()) return;
        super.mouseReleased(mouseEvent);
    }

    public void setMagnifyingMode(boolean bl2) {
        if (this.getMagnifyingMode() == bl2) {
            return;
        }
        if (bl2) {
            this.m_graph.getView().addViewMode(this.m_magifierViewMode);
            return;
        }
        this.m_graph.getView().removeViewMode(this.m_magifierViewMode);
    }

    @Override
    public double translateX(int n2) {
        return super.translateX(n2);
    }

    @Override
    public double translateY(int n2) {
        return super.translateY(n2);
    }
}

