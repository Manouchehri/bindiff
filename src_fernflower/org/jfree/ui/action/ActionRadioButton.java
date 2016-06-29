package org.jfree.ui.action;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionRadioButton$1;
import org.jfree.ui.action.ActionRadioButton$ActionEnablePropertyChangeHandler;

public class ActionRadioButton extends JRadioButton {
   private Action action;
   private ActionRadioButton$ActionEnablePropertyChangeHandler propertyChangeHandler;

   public ActionRadioButton() {
   }

   public ActionRadioButton(String var1) {
      super(var1);
   }

   public ActionRadioButton(String var1, Icon var2) {
      super(var1, var2);
   }

   public ActionRadioButton(Icon var1) {
      super(var1);
   }

   public ActionRadioButton(Action var1) {
      this.setAction(var1);
   }

   public Action getAction() {
      return this.action;
   }

   private ActionRadioButton$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
      if(this.propertyChangeHandler == null) {
         this.propertyChangeHandler = new ActionRadioButton$ActionEnablePropertyChangeHandler(this, (ActionRadioButton$1)null);
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
      Object var3;
      KeyStroke var4;
      if(var2 != null) {
         this.removeActionListener(var2);
         var2.removePropertyChangeListener(this.getPropertyChangeHandler());
         var3 = var2.getValue("AcceleratorKey");
         if(var3 instanceof KeyStroke && var3 != null) {
            var4 = (KeyStroke)var3;
            this.unregisterKeyboardAction(var4);
         }
      }

      this.action = var1;
      if(this.action != null) {
         this.addActionListener(var1);
         var1.addPropertyChangeListener(this.getPropertyChangeHandler());
         this.setText((String)((String)var1.getValue("Name")));
         this.setToolTipText((String)((String)var1.getValue("ShortDescription")));
         this.setIcon((Icon)var1.getValue("SmallIcon"));
         this.setEnabled(this.action.isEnabled());
         var3 = var1.getValue("MnemonicKey");
         if(var3 != null) {
            if(var3 instanceof Character) {
               Character var5 = (Character)var3;
               this.setMnemonic(var5.charValue());
            } else if(var3 instanceof Integer) {
               Integer var6 = (Integer)var3;
               this.setMnemonic(var6.intValue());
            }
         }

         var3 = var1.getValue("AcceleratorKey");
         if(var3 instanceof KeyStroke && var3 != null) {
            var4 = (KeyStroke)var3;
            this.registerKeyboardAction(var1, var4, 2);
         }
      }

   }
}
