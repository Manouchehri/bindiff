package org.jfree.ui.action;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionMenuItem$ActionEnablePropertyChangeHandler;

public class ActionMenuItem extends JMenuItem {
   private Action action;
   private ActionMenuItem$ActionEnablePropertyChangeHandler propertyChangeHandler;

   public ActionMenuItem() {
   }

   public ActionMenuItem(Icon var1) {
      super(var1);
   }

   public ActionMenuItem(String var1) {
      super(var1);
   }

   public ActionMenuItem(String var1, Icon var2) {
      super(var1, var2);
   }

   public ActionMenuItem(String var1, int var2) {
      super(var1, var2);
   }

   public ActionMenuItem(Action var1) {
      this.setAction(var1);
   }

   public Action getAction() {
      return this.action;
   }

   private ActionMenuItem$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
      if(this.propertyChangeHandler == null) {
         this.propertyChangeHandler = new ActionMenuItem$ActionEnablePropertyChangeHandler(this);
      }

      return this.propertyChangeHandler;
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      if(this.getAction() != null) {
         this.getAction().setEnabled(var1);
      }

   }

   public void setAction(Action var1) {
      Action var2 = this.getAction();
      if(var2 != null) {
         this.removeActionListener(var2);
         var2.removePropertyChangeListener(this.getPropertyChangeHandler());
         this.setAccelerator((KeyStroke)null);
      }

      this.action = var1;
      if(this.action != null) {
         this.addActionListener(var1);
         var1.addPropertyChangeListener(this.getPropertyChangeHandler());
         this.setText((String)((String)var1.getValue("Name")));
         this.setToolTipText((String)((String)var1.getValue("ShortDescription")));
         this.setIcon((Icon)var1.getValue("SmallIcon"));
         this.setEnabled(this.action.isEnabled());
         Object var3 = var1.getValue("MnemonicKey");
         if(var3 != null) {
            if(var3 instanceof Character) {
               Character var4 = (Character)var3;
               this.setMnemonic(var4.charValue());
            } else if(var3 instanceof Integer) {
               Integer var5 = (Integer)var3;
               this.setMnemonic(var5.intValue());
            }
         } else {
            this.setMnemonic(0);
         }

         var3 = var1.getValue("AcceleratorKey");
         if(var3 instanceof KeyStroke) {
            this.setAccelerator((KeyStroke)var3);
         }
      }

   }
}
