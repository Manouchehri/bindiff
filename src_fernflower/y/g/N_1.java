package y.g;

import y.g.O;
import y.g.p;

public final class N implements y.c.A, y.c.h {
   private int a;
   private final y.c.c b;
   private final y.c.a c;
   private double d;
   private Double e;

   public N(y.c.b var1, double var2) {
      this(var1, var1, var2);
   }

   public N(y.c.c var1, y.c.a var2, double var3) {
      this.b = var1;
      this.c = var2;
      this.a(var3);
   }

   public void a(double var1) {
      this.d = var1;
      this.e = new Double(var1);
      ++this.a;
   }

   public Object b(Object var1) {
      O var2 = (O)this.b.b(var1);
      return var2 == null?this.e:(var2.a != this.a?this.e:new Double(var2.b));
   }

   public void a(Object var1, Object var2) {
      this.a(var1, ((Number)var2).doubleValue());
   }

   public boolean d(Object var1) {
      throw new UnsupportedOperationException();
   }

   public double c(Object var1) {
      O var2 = (O)this.b.b(var1);
      return var2 == null?this.d:(var2.a != this.a?this.d:var2.b);
   }

   public int a(Object var1) {
      return (int)Math.rint(this.c(var1));
   }

   public void a(Object var1, boolean var2) {
      throw new UnsupportedOperationException();
   }

   public void a(Object var1, double var2) {
      O var4 = (O)this.b.b(var1);
      if(var4 == null) {
         O var5 = new O();
         var5.b = var2;
         var5.a = this.a;
         this.c.a(var1, var5);
         if(!p.c) {
            return;
         }
      }

      var4.b = var2;
      var4.a = this.a;
   }

   public void a(Object var1, int var2) {
      this.a(var1, (double)var2);
   }
}
