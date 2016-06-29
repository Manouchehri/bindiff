package com.google.security.zynamics.zylib.gui.JCaret;

import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JCaret$InternalListener implements ActionListener {
   // $FF: synthetic field
   final JCaret this$0;

   private JCaret$InternalListener(JCaret var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      JCaret.access$102(this.this$0, !JCaret.access$100(this.this$0));
      JCaret.access$200(this.this$0);
   }

   // $FF: synthetic method
   JCaret$InternalListener(JCaret var1, JCaret$1 var2) {
      this(var1);
   }
}
