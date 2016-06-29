package org.jfree.ui.action;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionButton;
import org.jfree.util.Log;

class ActionButton$ActionEnablePropertyChangeHandler implements PropertyChangeListener {
   private final ActionButton this$0;

   public ActionButton$ActionEnablePropertyChangeHandler(ActionButton var1) {
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
            KeyStroke var3 = (KeyStroke)var1.getOldValue();
            if(var3 != null) {
               this.this$0.unregisterKeyboardAction(var3);
            }

            Object var4 = var2.getValue("AcceleratorKey");
            if(var4 instanceof KeyStroke) {
               KeyStroke var5 = (KeyStroke)var4;
               this.this$0.registerKeyboardAction(var2, var5, 2);
            }
         } else if(var1.getPropertyName().equals("MnemonicKey")) {
            Object var7 = var2.getValue("MnemonicKey");
            if(var7 != null) {
               if(var7 instanceof Character) {
                  Character var8 = (Character)var7;
                  this.this$0.setMnemonic(var8.charValue());
               } else if(var7 instanceof Integer) {
                  Integer var9 = (Integer)var7;
                  this.this$0.setMnemonic(var9.intValue());
               }
            }
         }
      } catch (Exception var6) {
         Log.warn("Error on PropertyChange in ActionButton: ", var6);
      }

   }
}
