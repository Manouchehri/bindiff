package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class JumpToAddressAction extends AbstractAction {
   private final ViewTabPanelFunctions controller;
   private final ESide side;

   public JumpToAddressAction(ViewTabPanelFunctions var1, ESide var2) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.side = (ESide)Preconditions.checkNotNull(var2);
   }

   public void actionPerformed(ActionEvent var1) {
      this.controller.setCaretIntoJumpToAddressField(this.side);
   }
}
