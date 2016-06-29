package y.h;

import java.awt.print.PageFormat;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import y.h.fQ;
import y.h.fU;
import y.h.fV;
import y.h.ga;

class fT extends Thread {
   private final fQ a;
   private final boolean b;
   private final JRootPane c;
   private final ga d;

   fT(ga var1, fQ var2, boolean var3, JRootPane var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void run() {
      try {
         PageFormat var1 = fQ.access$400(ga.a(this.d)).pageDialog(fQ.access$300(ga.a(this.d)));
         SwingUtilities.invokeLater(new fU(this, var1));
      } finally {
         SwingUtilities.invokeLater(new fV(this));
      }

   }

   static fQ a(fT var0) {
      return var0.a;
   }

   static boolean b(fT var0) {
      return var0.b;
   }

   static JRootPane c(fT var0) {
      return var0.c;
   }
}
