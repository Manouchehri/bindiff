package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

class ScriptingMenuBar$ExecuteAction extends AbstractAction {
   // $FF: synthetic field
   final ScriptingMenuBar this$0;

   public ScriptingMenuBar$ExecuteAction(ScriptingMenuBar var1) {
      super(Constants.MENU_EXECUTE_SCRIPT);
      this.this$0 = var1;
      this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(69, ScriptingMenuBar.access$000()));
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.executeMenuClicked();
   }
}
