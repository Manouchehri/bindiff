package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.common.base.*;
import java.util.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;

public class ZyEditMode extends aC
{
    private final IStateActionFactory m_actionFactory;
    private final CStateFactory m_stateFactory;
    private IMouseState m_state;
    private final AbstractZyGraph m_graph;
    private final ds m_magifierViewMode;
    private final List m_listeners;
    private final CDefaultLabelEventHandler m_labelKeyHandler;
    private boolean m_inMouseMoved;
    private boolean m_inMouseDragged;
    private boolean m_inMousePressed;
    private boolean m_inMouseDraggedRight;
    
    public ZyEditMode(final AbstractZyGraph abstractZyGraph) {
        this.m_magifierViewMode = new ds();
        this.m_listeners = new ArrayList();
        this.m_graph = (AbstractZyGraph)Preconditions.checkNotNull(abstractZyGraph, (Object)"Graph argument cannot be null");
        this.m_labelKeyHandler = this.createNodeKeyHandler(abstractZyGraph);
        this.m_actionFactory = this.createStateActionFactory();
        this.m_stateFactory = new CStateFactory(abstractZyGraph, this.m_listeners, this.m_actionFactory);
        this.m_state = this.m_stateFactory.createDefaultState();
        this.setDefaultBehaviour();
    }
    
    private boolean getMagnifyingMode() {
        final Iterator viewModes = this.m_graph.getView().getViewModes();
        while (viewModes.hasNext()) {
            if (viewModes.next() == this.m_magifierViewMode) {
                return true;
            }
        }
        return false;
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
    
    protected CDefaultLabelEventHandler createNodeKeyHandler(final AbstractZyGraph abstractZyGraph) {
        return new CDefaultLabelEventHandler(abstractZyGraph);
    }
    
    protected IStateActionFactory createStateActionFactory() {
        return new CDefaultActionFactory();
    }
    
    @Override
    protected String getEdgeTip(final d d) {
        return CTooltipUpdater.updateEdgeTooltip(this.m_graph, d);
    }
    
    protected AbstractZyGraph getGraph() {
        return this.m_graph;
    }
    
    @Override
    protected String getNodeTip(final q q) {
        return CTooltipUpdater.updateNodeTooltip(this.m_graph, q);
    }
    
    public void addListener(final IZyEditModeListener zyEditModeListener) {
        this.m_listeners.add(zyEditModeListener);
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
    public void mouseDragged(final MouseEvent mouseEvent) {
        Preconditions.checkNotNull(mouseEvent, (Object)"Error: mouse event can not be null");
        final IMouseStateChange mouseDragged = this.m_state.mouseDragged(mouseEvent, this.m_graph);
        this.m_state = mouseDragged.getNextState();
        if (mouseDragged.notifyYFiles()) {
            this.m_inMouseDragged = true;
            try {
                super.mouseDragged(mouseEvent);
            }
            finally {
                this.m_inMouseDragged = false;
            }
        }
    }
    
    @Override
    public void mouseDraggedRight(final double n, final double n2) {
        this.m_inMouseDraggedRight = true;
        try {
            super.mouseDraggedLeft(n, n2);
        }
        finally {
            this.m_inMouseDraggedRight = false;
        }
    }
    
    @Override
    public void mouseMoved(final double n, final double n2) {
        this.m_inMouseMoved = true;
        try {
            super.mouseMoved(n, n2);
        }
        finally {
            this.m_inMouseMoved = false;
        }
    }
    
    @Override
    public void mouseMoved(final MouseEvent mouseEvent) {
        Preconditions.checkNotNull(mouseEvent, (Object)"Error: mouse event can not be null");
        final IMouseStateChange mouseMoved = this.m_state.mouseMoved(mouseEvent, this.m_graph);
        this.m_state = mouseMoved.getNextState();
        if (mouseMoved.notifyYFiles()) {
            this.m_inMouseMoved = true;
            try {
                super.mouseMoved(mouseEvent);
            }
            finally {
                this.m_inMouseMoved = false;
            }
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        final IMouseStateChange mousePressed = this.m_state.mousePressed(mouseEvent, this.m_graph);
        this.m_state = mousePressed.getNextState();
        if (mousePressed.notifyYFiles()) {
            this.m_inMousePressed = true;
            try {
                super.mousePressed(mouseEvent);
            }
            finally {
                this.m_inMousePressed = false;
            }
        }
    }
    
    @Override
    public void mouseReleased(final double n, final double n2) {
        super.mouseReleased(n, n2);
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        final IMouseStateChange mouseReleased = this.m_state.mouseReleased(mouseEvent, this.m_graph);
        this.m_state = mouseReleased.getNextState();
        if (mouseReleased.notifyYFiles()) {
            super.mouseReleased(mouseEvent);
        }
    }
    
    public void setMagnifyingMode(final boolean b) {
        if (this.getMagnifyingMode() == b) {
            return;
        }
        if (b) {
            this.m_graph.getView().addViewMode(this.m_magifierViewMode);
        }
        else {
            this.m_graph.getView().removeViewMode(this.m_magifierViewMode);
        }
    }
    
    public double translateX(final int n) {
        return super.translateX(n);
    }
    
    public double translateY(final int n) {
        return super.translateY(n);
    }
}
