package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler$1;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class CDefaultLabelEventHandler$InternalFocusListener implements FocusListener {
   // $FF: synthetic field
   final CDefaultLabelEventHandler this$0;

   private CDefaultLabelEventHandler$InternalFocusListener(CDefaultLabelEventHandler var1) {
      this.this$0 = var1;
   }

   public void focusGained(FocusEvent var1) {
   }

   public void focusLost(FocusEvent var1) {
      this.this$0.deactivateLabelContent();
   }

   // $FF: synthetic method
   CDefaultLabelEventHandler$InternalFocusListener(CDefaultLabelEventHandler var1, CDefaultLabelEventHandler$1 var2) {
      this(var1);
   }
}
