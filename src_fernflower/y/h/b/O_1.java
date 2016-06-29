package y.h.b;

import java.awt.Color;
import java.awt.Stroke;
import y.h.dr;
import y.h.fj;
import y.h.b.Y;

class O implements Y {
   private final boolean a;

   O(boolean var1) {
      this.a = var1;
   }

   public Stroke a(fj var1) {
      return null;
   }

   public Color b(fj var1) {
      return null;
   }

   public Color c(fj var1) {
      return null;
   }

   public Stroke d(fj var1) {
      dr var2 = var1.getLineType();
      return this.a?dr.a((int)Math.ceil((double)var2.getLineWidth()) + 2, var2.a()):var2;
   }

   public Color e(fj var1) {
      return var1.getLineColor();
   }

   public Color f(fj var1) {
      return var1.getFillColor2();
   }
}
