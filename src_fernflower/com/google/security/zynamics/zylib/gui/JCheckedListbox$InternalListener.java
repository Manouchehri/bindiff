package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.JCheckedListbox;
import com.google.security.zynamics.zylib.gui.JCheckedListbox$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class JCheckedListbox$InternalListener extends MouseAdapter {
   // $FF: synthetic field
   final JCheckedListbox this$0;

   private JCheckedListbox$InternalListener(JCheckedListbox var1) {
      this.this$0 = var1;
   }

   public void mouseClicked(MouseEvent var1) {
      if(this.this$0.isEnabled()) {
         if(var1.getPoint().x <= 20) {
            int var2 = this.this$0.locationToIndex(var1.getPoint());
            JCheckedListbox.access$200(this.this$0)[var2] = !JCheckedListbox.access$200(this.this$0)[var2];
            this.this$0.updateUI();
            JCheckedListbox.access$300(this.this$0, var2, var2, false);
         }
      }
   }

   // $FF: synthetic method
   JCheckedListbox$InternalListener(JCheckedListbox var1, JCheckedListbox$1 var2) {
      this(var1);
   }
}
