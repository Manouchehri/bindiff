package y.h.b;

import java.awt.Color;
import java.awt.Stroke;
import y.h.dr;
import y.h.fj;
import y.h.b.Y;
import y.h.b.a;

class N implements Y {
   private final boolean a;

   N(boolean var1) {
      this.a = var1;
   }

   public Stroke a(fj var1) {
      return this.h(var1)?this.g(var1):null;
   }

   public Color b(fj var1) {
      return this.h(var1)?var1.getLineColor():null;
   }

   public Color c(fj var1) {
      return var1.getFillColor();
   }

   public Stroke d(fj var1) {
      return this.h(var1)?null:this.g(var1);
   }

   public Color e(fj var1) {
      return this.h(var1)?null:var1.getLineColor();
   }

   public Color f(fj var1) {
      return var1.getFillColor();
   }

   private Stroke g(fj var1) {
      dr var2 = var1.getLineType();
      return this.a?dr.a((int)Math.ceil((double)var2.getLineWidth()) + 2, var2.a()):var2;
   }

   private boolean h(fj var1) {
      y.d.r var2 = this.i(var1);
      return var2.a > 0.0D || var2.b > 0.0D || var2.c > 0.0D || var2.d > 0.0D;
   }

   private y.d.r i(fj var1) {
      return var1 instanceof a?((a)var1).l().d():null;
   }
}
