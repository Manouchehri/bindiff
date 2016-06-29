package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AbstractScriptPanel$InternalLanguageBoxListener implements ActionListener {
   // $FF: synthetic field
   final AbstractScriptPanel this$0;

   private AbstractScriptPanel$InternalLanguageBoxListener(AbstractScriptPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.initConsole();
      this.this$0.updateDocument();
   }

   // $FF: synthetic method
   AbstractScriptPanel$InternalLanguageBoxListener(AbstractScriptPanel var1, AbstractScriptPanel$1 var2) {
      this(var1);
   }
}
