package org.jfree.ui.tabbedui;

import javax.swing.JComponent;

public abstract class DetailEditor extends JComponent {
   private Object object;
   private boolean confirmed;

   public void update() {
      if(this.object == null) {
         throw new IllegalStateException();
      } else {
         this.updateObject(this.object);
         this.setConfirmed(false);
      }
   }

   public Object getObject() {
      return this.object;
   }

   public void setObject(Object var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.object = var1;
         this.setConfirmed(false);
         this.fillObject();
      }
   }

   protected static int parseInt(String var0, int var1) {
      try {
         return Integer.parseInt(var0);
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public abstract void clear();

   protected abstract void fillObject();

   protected abstract void updateObject(Object var1);

   public boolean isConfirmed() {
      return this.confirmed;
   }

   protected void setConfirmed(boolean var1) {
      boolean var2 = this.confirmed;
      this.confirmed = var1;
      this.firePropertyChange("confirmed", var2, var1);
   }
}
