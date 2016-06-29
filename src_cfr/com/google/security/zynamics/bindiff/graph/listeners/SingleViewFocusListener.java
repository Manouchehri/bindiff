/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import y.h.ch;

public class SingleViewFocusListener
extends MouseAdapter {
    private final SingleGraph graph;
    private final ViewTabPanelFunctions controller;

    protected SingleViewFocusListener(ViewTabPanelFunctions viewTabPanelFunctions, SingleGraph singleGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (SingleGraph)Preconditions.checkNotNull(singleGraph);
        this.addListener();
    }

    public void addListener() {
        this.graph.getView().getCanvasComponent().addMouseListener(this);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.controller.setViewFocus(this.graph.getSide());
    }

    public void removeListener() {
        this.graph.getView().getCanvasComponent().removeMouseListener(this);
    }
}

