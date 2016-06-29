package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.SwingInvoker$1;
import com.google.security.zynamics.zylib.gui.SwingInvoker$2;
import javax.swing.SwingUtilities;

public abstract class SwingInvoker {
   protected abstract void operation();

   public void invokeAndWait() {
      if(!SwingUtilities.isEventDispatchThread()) {
         try {
            SwingUtilities.invokeAndWait(new SwingInvoker$1(this));
         } catch (Exception var2) {
            ;
         }
      } else {
         this.operation();
      }

   }

   public void invokeLater() {
      if(!SwingUtilities.isEventDispatchThread()) {
         try {
            SwingUtilities.invokeLater(new SwingInvoker$2(this));
         } catch (Exception var2) {
            ;
         }
      } else {
         this.operation();
      }

   }
}
