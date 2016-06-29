package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import y.h.fQ;
import y.h.fT;
import y.h.fj;
import y.h.gb;

final class ga extends AbstractAction {
   private final fQ a;

   public ga(fQ var1) {
      super("Format ...");
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      fQ var3;
      JRootPane var4;
      boolean var5;
      label20: {
         gb var2 = fQ.access$100(this.a);
         var3 = this.a;
         var4 = SwingUtilities.getRootPane(fQ.access$100(this.a));
         if(var4 != null) {
            var5 = var4.getGlassPane() != null && var4.getGlassPane().isVisible();
            var4.getGlassPane().setVisible(true);
            if(!fj.z) {
               break label20;
            }
         }

         var5 = false;
      }

      (new fT(this, var3, var5, var4)).start();
   }

   static fQ a(ga var0) {
      return var0.a;
   }
}
