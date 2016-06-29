/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ZoomInAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;

    public ZoomInAction(ViewTabPanelFunctions viewTabPanelFunctions) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.zoom(true);
    }
}

