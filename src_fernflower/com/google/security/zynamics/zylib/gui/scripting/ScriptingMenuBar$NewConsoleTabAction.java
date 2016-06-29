package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

class ScriptingMenuBar$NewConsoleTabAction extends AbstractAction {
   // $FF: synthetic field
   final ScriptingMenuBar this$0;

   public ScriptingMenuBar$NewConsoleTabAction(ScriptingMenuBar var1) {
      super(Constants.MENU_SCRIPTING_CONSOLE);
      this.this$0 = var1;
      this.putValue("SmallIcon", new ImageIcon(Constants.class.getResource("application_xp_terminal.png")));
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.newConsoleTabMenuClicked();
   }
}
