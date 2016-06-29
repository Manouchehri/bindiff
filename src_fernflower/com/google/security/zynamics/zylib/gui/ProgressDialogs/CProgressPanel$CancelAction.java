package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

class CProgressPanel$CancelAction extends AbstractAction {
   private static final long serialVersionUID = 3809222494243730570L;
   // $FF: synthetic field
   final CProgressPanel this$0;

   public CProgressPanel$CancelAction(CProgressPanel var1) {
      super("", new ImageIcon(Constants.class.getResource("cancel.png")));
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(CProgressPanel.access$200(this.this$0) != null) {
         CProgressPanel.access$200(this.this$0).actionPerformed(var1);
      }

      this.this$0.closeRequested();
   }
}
