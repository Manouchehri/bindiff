package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$1;
import com.google.security.zynamics.bindiff.log.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.SwingUtilities;

class TabButton$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final TabButton this$0;

   private TabButton$InternalButtonListener(TabButton var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = TabButton.access$300(this.this$0).indexOfTabComponent(TabButton.access$200(this.this$0));
      if(var2 != -1) {
         Iterator var3 = TabButton.access$400(this.this$0).iterator();

         while(var3.hasNext()) {
            ICloseTabButtonListener var4 = (ICloseTabButtonListener)var3.next();

            try {
               if(!var4.closing(TabButton.access$200(this.this$0))) {
                  return;
               }
            } catch (Exception var6) {
               MessageBox.showError(SwingUtilities.getWindowAncestor(this.this$0), "An error occured while closing the tab.");
               Logger.logException(var6, "An error occured while closing the tab.");
            }
         }

      }
   }

   // $FF: synthetic method
   TabButton$InternalButtonListener(TabButton var1, TabButton$1 var2) {
      this(var1);
   }
}
