package y.h;

import java.awt.print.PrinterException;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import y.h.fQ;
import y.h.fX;
import y.h.gb;
import y.h.gc;

class fW extends Thread {
   private final gb a;
   private final fQ b;
   private final boolean c;
   private final JRootPane d;
   private final gc e;

   fW(gc var1, gb var2, fQ var3, boolean var4, JRootPane var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public void run() {
      try {
         if(fQ.access$400(gc.a(this.e)).printDialog()) {
            try {
               fQ.access$400(gc.a(this.e)).print();
               SwingUtilities.invokeLater(new fX(this));
            } catch (PrinterException var6) {
               var6.printStackTrace();
            }
         }
      } finally {
         if(this.c && this.d != null && this.d.getGlassPane() != null) {
            this.d.getGlassPane().setVisible(this.c);
         }

      }

   }

   static gb a(fW var0) {
      return var0.a;
   }

   static fQ b(fW var0) {
      return var0.b;
   }
}
