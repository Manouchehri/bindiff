package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import java.awt.event.*;

public class JumpToAddressAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    private final ESide side;
    
    public JumpToAddressAction(final ViewTabPanelFunctions viewTabPanelFunctions, final ESide eSide) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.controller.setCaretIntoJumpToAddressField(this.side);
    }
}
