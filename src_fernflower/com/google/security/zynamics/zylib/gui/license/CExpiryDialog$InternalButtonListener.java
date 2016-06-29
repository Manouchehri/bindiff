package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.license.CExpiryDialog;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CExpiryDialog$InternalButtonListener extends AbstractAction {
   private static final long serialVersionUID = -3774947758218736158L;
   // $FF: synthetic field
   final CExpiryDialog this$0;

   public CExpiryDialog$InternalButtonListener(CExpiryDialog var1) {
      super("OK");
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.dispose();
   }
}
