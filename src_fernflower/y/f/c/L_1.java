package y.f.c;

import java.util.HashMap;
import y.f.c.K;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.Y;
import y.f.c.a;
import y.f.c.aB;
import y.f.c.aI;

final class L implements Q, R, Y {
   aI a = new aI();
   aB b = new aB();
   HashMap c;
   y.c.c d;
   y.c.A e;
   y.c.c f;
   y.c.h g;
   R h;
   Q i;
   y.c.c j;
   y.c.c k;
   y.c.c l;
   y.c.D m;
   Object n;
   boolean[] o = new boolean[5];

   void a(y.c.c var1, y.c.c var2, y.c.c var3, R var4, y.c.D var5, Q var6, y.c.c var7, y.c.A var8, y.c.c var9, y.c.h var10) {
      this.l = var3;
      this.m = var5;
      this.k = var2;
      this.j = var1;
      this.d = var7;
      this.e = var8;
      this.f = var9;
      this.g = var10;
      this.i = var6;
      this.h = var4;
   }

   void a(Object var1) {
      this.n = var1;
   }

   void b(y.f.X var1, y.c.A var2, int var3) {
      boolean var12 = a.i;
      Object[] var4 = this.m.toArray();
      y.c.x var5 = var1.o();

      y.c.q var6;
      Object var8;
      while(true) {
         Object var7;
         if(var5.f()) {
            var6 = var5.e();
            var7 = this.d.b(var6);
            if(var7 == null) {
               var8 = this.j.b(var6);
               if(var8 != K.q) {
                  break;
               }

               y.c.d var9 = (y.c.d)this.l.b(var6);
               if(var9 == null) {
                  throw new IllegalStateException("Could not create id for " + var6);
               }

               Object var10 = this.f.b(var9);
               if(var10 == null) {
                  throw new IllegalStateException("No ID stored for " + var9);
               }

               int var11 = this.k.a(var6);
               this.e.a(var6, y.g.am.a("BendNode", var10, var4[var11]));
               if(var12) {
                  break;
               }
            }

            var5.g();
            if(!var12) {
               continue;
            }
         }

         y.c.e var13 = var1.p();

         while(var13.f()) {
            y.c.d var14 = var13.a();
            var7 = this.f.b(var14);
            if(var7 == null) {
               this.g.a(var14, y.g.am.a("DummyEdge", this.d.b(var14.c()), this.d.b(var14.d())));
            }

            var13.g();
            if(var12) {
               break;
            }
         }

         return;
      }

      throw new IllegalStateException("Could not determine id of node " + var6 + " [" + var8 + "]");
   }

   public Object a() {
      return new HashMap();
   }

   public Object b() {
      return this.c;
   }

   public boolean a(byte var1) {
      return this.o[var1];
   }

   public void b(Object var1) {
      if(var1 == null || var1 instanceof HashMap) {
         this.c = (HashMap)var1;
      }

   }

   public void a(byte var1, boolean var2) {
      this.o[var1] = var2;
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      int var4;
      boolean var9;
      label39: {
         var9 = a.i;
         this.a.a(this.h, this.d, this.f, this.n);
         if(this.a((byte)1)) {
            this.a.a(false);
            this.a.c(this.c);
            var4 = this.a.a(var1, var2, var3);
            this.a.d(this.c);
            if(!var9) {
               break label39;
            }
         }

         this.a.a(true);
         this.a.c(this.c);
         var4 = this.a.a(var1, var2, var3);
         this.a.d(this.c);
      }

      Object[] var5 = new Object[var4];
      y.c.x var6 = var1.o();

      while(true) {
         if(var6.f()) {
            y.c.q var7 = var6.e();
            int var8 = var2.a(var7);
            if(var9) {
               break;
            }

            if(var5[var8] == null) {
               var5[var8] = this.a.a(var7);
            }

            var6.g();
            if(!var9) {
               continue;
            }
         }

         this.m.clear();
         break;
      }

      int var10 = 0;

      while(var10 < var4) {
         this.m.b(var5[var10]);
         ++var10;
         if(var9) {
            break;
         }
      }

      return var4;
   }

   public y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      this.b(var1, var2, var3);
      this.b.a(this.i, this.d);
      y.c.y[] var4;
      if(this.a((byte)2)) {
         this.b.a(false);
         this.b.a(this.c);
         var4 = this.b.a(var1, var2, var3);
         this.b.b(this.c);
         if(!a.i) {
            return var4;
         }
      }

      this.b.a(true);
      this.b.a(this.c);
      var4 = this.b.a(var1, var2, var3);
      this.b.b(this.c);
      return var4;
   }

   public void c() {
      this.f = null;
      this.l = null;
      this.j = null;
      this.g = null;
      this.d = null;
      this.e = null;
      this.h = null;
      this.i = null;
      this.a = null;
      this.b = null;
      this.c = null;
   }
}
