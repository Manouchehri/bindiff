package y.h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import y.h.fQ;
import y.h.fj;

class fS implements ActionListener {
   private final fQ a;

   fS(fQ var1) {
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      boolean var6 = fj.z;
      if(fQ.access$000(this.a).getSelectedIndex() == 0) {
         this.a.zoomToFit();
         if(!var6) {
            return;
         }
      }

      if(fQ.access$000(this.a).getSelectedIndex() == 1) {
         this.a.zoomToFitWidth();
         if(!var6) {
            return;
         }
      }

      String var2 = fQ.access$000(this.a).getSelectedItem().toString().trim();
      if(var2.indexOf(37) > 0) {
         var2 = var2.substring(0, var2.indexOf(37)).trim();
      }

      try {
         double var3 = Double.parseDouble(var2);
         fQ.access$100(this.a).e((int)(var3 * 10.0D));
      } catch (Exception var7) {
         int var4 = fQ.access$100(this.a).b();
         String var5 = var4 / 10 + "." + var4 % 10 + "%";
         fQ.access$000(this.a).setSelectedItem(var5);
      }

   }
}
