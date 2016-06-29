package y.h;

import java.awt.print.PageFormat;
import y.h.fT;

class fU implements Runnable {
   private final PageFormat a;
   private final fT b;

   fU(fT var1, PageFormat var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      fT.a(this.b).setPageFormat(this.a);
   }
}
