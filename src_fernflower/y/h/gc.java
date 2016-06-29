package y.h;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import y.h.fQ;
import y.h.fW;
import y.h.fj;
import y.h.gb;

final class gc extends AbstractAction {
   private final fQ a;

   public gc(fQ var1) {
      super("Print ...");
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      gb var2;
      fQ var3;
      JRootPane var4;
      boolean var5;
      label20: {
         fQ.access$400(this.a).setPrintable(fQ.access$800(this.a), fQ.access$300(this.a));
         var2 = fQ.access$100(this.a);
         var3 = this.a;
         var4 = SwingUtilities.getRootPane(fQ.access$100(this.a));
         if(var4 != null) {
            var4.getGlassPane().setVisible(true);
            var5 = var4.getGlassPane() != null && var4.getGlassPane().isVisible();
            if(!fj.z) {
               break label20;
            }
         }

         var5 = false;
      }

      (new fW(this, var2, var3, var5, var4)).start();
   }

   static fQ a(gc var0) {
      return var0.a;
   }
}
