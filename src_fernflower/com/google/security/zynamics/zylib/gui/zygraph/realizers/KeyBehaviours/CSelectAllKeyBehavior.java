package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import java.util.Iterator;

public class CSelectAllKeyBehavior extends CAbstractKeyBehavior {
   public CSelectAllKeyBehavior(CUndoManager var1) {
      super(var1);
   }

   protected void initUndoHistory() {
   }

   protected void updateCaret() {
      int var1 = this.getLabelContent().getLineCount() - 1;
      int var2 = 0;

      ZyLineContent var4;
      for(Iterator var3 = this.getLabelContent().iterator(); var3.hasNext(); var2 = Math.max(var4.getText().length(), var2)) {
         var4 = (ZyLineContent)var3.next();
      }

      ZyLineContent var5 = this.getLineContent(var1);
      int var6 = var5.getText().length();
      this.setCaret(0, 0, 0, var6, var2, var1);
   }

   protected void updateClipboard() {
   }

   protected void updateLabelContent() {
   }

   protected void updateSelection() {
   }

   protected void updateUndoHistory() {
   }
}
