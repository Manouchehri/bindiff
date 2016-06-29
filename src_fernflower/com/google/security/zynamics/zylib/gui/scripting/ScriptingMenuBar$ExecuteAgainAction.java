package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

class ScriptingMenuBar$ExecuteAgainAction extends AbstractAction {
   // $FF: synthetic field
   final ScriptingMenuBar this$0;

   public ScriptingMenuBar$ExecuteAgainAction(ScriptingMenuBar var1) {
      super(String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, new Object[]{"-"}));
      this.this$0 = var1;
      this.putValue("AcceleratorKey", KeyStroke.getKeyStroke(69, ScriptingMenuBar.access$000() | 1));
      this.setFile((File)null);
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.executeAgainMenuClicked();
   }

   public void setFile(File var1) {
      if(var1 != null) {
         this.putValue("Name", String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, new Object[]{var1.getAbsolutePath()}));
      } else {
         this.putValue("Name", String.format(Constants.MENU_EXECUTE_AGAIN_SCRIPT, new Object[]{"-"}));
      }

      this.setEnabled(var1 != null);
   }
}
