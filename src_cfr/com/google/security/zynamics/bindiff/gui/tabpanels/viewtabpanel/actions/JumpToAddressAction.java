/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class JumpToAddressAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;
    private final ESide side;

    public JumpToAddressAction(ViewTabPanelFunctions viewTabPanelFunctions, ESide eSide) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.setCaretIntoJumpToAddressField(this.side);
    }
}

