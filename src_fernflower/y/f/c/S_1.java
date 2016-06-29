package y.f.c;

import y.f.c.a;
import y.f.c.v;

public class S implements v {
   protected v a;
   protected y.c.A b;
   private y.c.y c;
   private y.c.A d;
   private y.c.A e;

   public S(v var1) {
      this.a = var1;
   }

   public void a(y.f.X var1, y.c.y[] var2, y.c.c var3) {
      if(var3 instanceof y.c.A) {
         this.e = (y.c.A)var3;
         if(!a.i) {
            this.d = var1.t();
            this.c = new y.c.y();
            this.a(var1, var2, this.e);
            this.a.a(var1, var2, this.e);
            this.b(var1, var2, this.e);
            if(this.e != var3) {
               throw new IllegalStateException("Expected NodeMap layerID!");
            }

            var1.a((y.c.A)this.d);
            this.d = null;
            this.c = null;
            this.b = null;
            return;
         }
      }

      throw new IllegalStateException("Expected NodeMap layerID!");
   }

   public void a(y.c.A var1) {
      this.b = var1;
      this.a.a(var1);
   }

   public void a(double var1) {
      this.a.a(var1);
   }

   public void d(double var1) {
      this.a.d(var1);
   }

   public void b(double var1) {
      this.a.b(var1);
   }

   public void c(double var1) {
      this.a.c(var1);
   }

   protected void a(y.f.X param1, y.c.y[] param2, y.c.A param3) {
      // $FF: Couldn't be decompiled
   }

   protected void b(y.f.X var1, y.c.y[] var2, y.c.A var3) {
      boolean var8 = a.i;
      y.c.p var4 = this.c.k();

      while(var4 != null) {
         y.g.am var5 = (y.g.am)var4.c();
         y.c.q var6 = (y.c.q)var5.a;
         y.c.y var7 = (y.c.y)var5.b;
         var7.h((y.c.p)this.d.b(var6));
         var1.a((y.c.q)var6);
         var4 = var4.a();
         if(var8) {
            break;
         }
      }

   }
}
