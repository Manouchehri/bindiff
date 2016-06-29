package org.jfree.ui.action;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionMenuItem;
import org.jfree.util.Log;

class ActionMenuItem$ActionEnablePropertyChangeHandler implements PropertyChangeListener {
   private final ActionMenuItem this$0;

   public ActionMenuItem$ActionEnablePropertyChangeHandler(ActionMenuItem var1) {
      this.this$0 = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      try {
         if(var1.getPropertyName().equals("enabled")) {
            this.this$0.setEnabled(this.this$0.getAction().isEnabled());
         } else if(var1.getPropertyName().equals("SmallIcon")) {
            this.this$0.setIcon((Icon)this.this$0.getAction().getValue("SmallIcon"));
         } else if(var1.getPropertyName().equals("Name")) {
            this.this$0.setText((String)this.this$0.getAction().getValue("Name"));
         } else if(var1.getPropertyName().equals("ShortDescription")) {
            this.this$0.setToolTipText((String)this.this$0.getAction().getValue("ShortDescription"));
         }

         Action var2 = this.this$0.getAction();
         if(var1.getPropertyName().equals("AcceleratorKey")) {
            this.this$0.setAccelerator((KeyStroke)var2.getValue("AcceleratorKey"));
         } else if(var1.getPropertyName().equals("MnemonicKey")) {
            Object var3 = var2.getValue("MnemonicKey");
            if(var3 != null) {
               if(var3 instanceof Character) {
                  Character var4 = (Character)var3;
                  this.this$0.setMnemonic(var4.charValue());
               } else if(var3 instanceof Integer) {
                  Integer var6 = (Integer)var3;
                  this.this$0.setMnemonic(var6.intValue());
               }
            } else {
               this.this$0.setMnemonic(0);
            }
         }
      } catch (Exception var5) {
         Log.warn("Error on PropertyChange in ActionButton: ", var5);
      }

   }
}
