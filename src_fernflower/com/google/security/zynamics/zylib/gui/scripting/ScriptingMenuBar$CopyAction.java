package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

class ScriptingMenuBar$CopyAction extends AbstractAction {
   // $FF: synthetic field
   final ScriptingMenuBar this$0;

   public ScriptingMenuBar$CopyAction(ScriptingMenuBar var1) {
      super(Constants.MENU_EDIT_COPY);
      this.this$0 = var1;
      this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(67, ScriptingMenuBar.access$000()));
      this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("page_white_copy.png")));
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.copyMenuClicked();
   }
}
