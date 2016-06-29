package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

class ScriptingMenuBar$CloseTabAction extends AbstractAction {
   // $FF: synthetic field
   final ScriptingMenuBar this$0;

   public ScriptingMenuBar$CloseTabAction(ScriptingMenuBar var1) {
      super(Constants.MENU_CLOSE_ACTIVE_TAB);
      this.this$0 = var1;
      this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(81, ScriptingMenuBar.access$000()));
      this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("folder_delete.png")));
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.closeTabMenuClicked();
   }
}
