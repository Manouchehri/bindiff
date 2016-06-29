package org.jfree.ui.action;

import java.util.ArrayList;
import javax.swing.Action;

public class ActionConcentrator {
   private final ArrayList actions = new ArrayList();

   public void addAction(Action var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.actions.add(var1);
      }
   }

   public void removeAction(Action var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.actions.remove(var1);
      }
   }

   public void setEnabled(boolean var1) {
      for(int var2 = 0; var2 < this.actions.size(); ++var2) {
         Action var3 = (Action)this.actions.get(var2);
         var3.setEnabled(var1);
      }

   }

   public boolean isEnabled() {
      for(int var1 = 0; var1 < this.actions.size(); ++var1) {
         Action var2 = (Action)this.actions.get(var1);
         if(var2.isEnabled()) {
            return true;
         }
      }

      return false;
   }
}
