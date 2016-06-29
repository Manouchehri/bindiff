package y.g;

import y.g.Q;
import y.g.p;

public final class P implements y.c.A, y.c.h {
   private int a;
   private final y.c.a b;
   private final y.c.c c;
   private int d;
   private Integer e;

   public P(y.c.b var1, int var2) {
      this(var1, var1, var2);
   }

   public P(y.c.c var1, y.c.a var2, int var3) {
      this.c = var1;
      this.b = var2;
      this.a(var3);
   }

   public void a(int var1) {
      this.d = var1;
      this.e = new Integer(var1);
      ++this.a;
   }

   public Object b(Object var1) {
      Q var2 = (Q)this.c.b(var1);
      return var2 == null?this.e:(var2.a != this.a?this.e:new Integer(var2.b));
   }

   public void a(Object var1, Object var2) {
      this.a(var1, ((Number)var2).intValue());
   }

   public boolean d(Object var1) {
      throw new UnsupportedOperationException();
   }

   public double c(Object var1) {
      return (double)this.a(var1);
   }

   public int a(Object var1) {
      Q var2 = (Q)this.c.b(var1);
      return var2 == null?this.d:(var2.a != this.a?this.d:var2.b);
   }

   public void a(Object var1, boolean var2) {
      throw new UnsupportedOperationException();
   }

   public void a(Object var1, double var2) {
      throw new UnsupportedOperationException();
   }

   public void a(Object var1, int var2) {
      Q var3 = (Q)this.c.b(var1);
      if(var3 == null) {
         Q var4 = new Q();
         var4.b = var2;
         var4.a = this.a;
         this.b.a(var1, var4);
         if(!p.c) {
            return;
         }
      }

      var3.b = var2;
      var3.a = this.a;
   }
}
