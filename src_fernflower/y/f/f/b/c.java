package y.f.f.b;

import y.c.q;
import y.c.x;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.h.D;

public class c {
   private static final int a;
   private static final int b;
   private static final int c;
   private static final int d;
   private static final String[] e;
   private y.c.f f = new y.c.f();
   private D g;
   private h h;
   private y.c.i i;

   public void a(y.c.i var1) {
      int var3 = h.a;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         if(var2.a().e()) {
            this.f.c(var2.a());
            var1.d(var2.a());
         }

         var2.g();
         if(var3 != 0) {
            break;
         }
      }

   }

   public void a(h var1) {
      this.h = var1;
      this.g = (D)this.h.b();
      this.i = this.g.g();
   }

   private o a(q var1) {
      int[][] var2 = this.h.i(var1);
      int[] var3 = this.h.h(var1);
      int var4 = var2[a][0] + var2[b][2];
      int var5 = var3[a] + var3[b];
      int var6 = var2[b][0] + var2[c][2];
      int var7 = var3[b] + var3[c];
      int var8 = var2[c][0] + var2[d][2];
      int var9 = var3[c] + var3[d];
      int var10 = var2[d][0] + var2[a][2];
      int var11 = var3[d] + var3[a];
      int var12 = var4;
      int var13 = var5;
      int var14 = a;
      if(var6 < var4 || var6 == var4 && var7 < var5) {
         var12 = var6;
         var13 = var7;
         var14 = b;
      }

      if(var8 < var12 || var8 == var12 && var9 < var13) {
         var12 = var8;
         var13 = var9;
         var14 = c;
      }

      if(var10 < var12 || var10 == var12 && var11 < var13) {
         var14 = d;
      }

      return o.a(var14);
   }

   private void a(q var1, o var2, y.c.f var3) {
      int var12 = h.a;
      if(var3 != null && var3.size() != 0) {
         y.c.d var4 = null;
         y.c.e var5 = var1.l();

         while(var5.f()) {
            if(this.h.d(var5.a()) > 0) {
               var4 = var5.a();
               break;
            }

            var5.g();
         }

         y.c.d var13 = null;
         y.c.d var6 = null;
         y.c.d var10;
         if(var4 != null) {
            var13 = null;
            o var7 = this.h.h(var4);
            y.c.e var8 = var1.a(var4);
            int var9 = 0;

            label50: {
               while(var9 < var8.k()) {
                  var10 = var8.a();
                  if(var12 != 0) {
                     break label50;
                  }

                  if(this.a(var7, this.h.h(var10), var2)) {
                     break;
                  }

                  var13 = var10;
                  var8.b();
                  ++var9;
                  if(var12 != 0) {
                     break;
                  }
               }

               var8 = var1.a(var13);
               var8.b();
            }

            var6 = var8.a();
         }

         y.c.d var15;
         label38: {
            y.c.d var14 = var3.d();
            this.i.e(var14);
            if(var4 == null) {
               var15 = this.g.g(var14);
               this.h.a(var14, e[var2.f()]);
               this.h.f(var14);
               this.h.a((y.c.d)var14, (int)3);
               this.h.a((y.c.d)var15, (int)1);
               this.g.l();
               this.g.b((y.f.h.p)this.g.h().a());
               if(var12 == 0) {
                  break label38;
               }
            }

            this.g.a(var6, var14);
            var15 = this.h.a(var14);
            this.h.a(var14, e[var2.f()]);
            this.h.f(var14);
            this.h.a(var14, this.a(var13, var14));
            this.h.a((y.c.d)var15, (int)1);
            this.h.a(var6, this.a(var15, var6));
            this.g.k();
         }

         var6 = var15;
         y.c.e var16 = var3.a();

         while(var16.f()) {
            var10 = var16.a();
            this.i.e(var10);
            this.g.a(var6, var10);
            y.c.d var11 = this.h.a(var10);
            this.h.a(var10, e[var2.f()]);
            this.h.f(var10);
            this.h.a((y.c.d)var10, (int)0);
            this.h.a((y.c.d)var11, (int)1);
            this.h.a((y.c.d)var6, (int)0);
            this.g.k();
            var6 = var11;
            var16.g();
            if(var12 != 0) {
               break;
            }
         }

      }
   }

   private boolean a(o var1, o var2, o var3) {
      String var4 = "^>_<^>_<";
      int var5 = var4.indexOf(var1.toString());
      int var6 = var4.indexOf(var2.toString(), var5);
      int var7 = var4.indexOf(var3.toString(), var5);
      return var6 > var7;
   }

   private int a(y.c.d var1, y.c.d var2) {
      String var3 = "^>_<^>_<";
      char var4 = this.h.e(var1).charAt(0);
      char var5 = this.h.e(var2).charAt(0);
      int var6 = var3.indexOf(var4);
      int var7 = var3.indexOf(var5, var6);
      return var7 - var6;
   }

   public void a() {
      int var5 = h.a;
      y.c.f[] var1 = new y.c.f[this.i.f()];
      y.c.e var2 = this.f.a();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         int var4 = var3.c().d();
         if(var1[var4] == null) {
            var1[var4] = new y.c.f();
         }

         var1[var4].add(var3);
         var2.g();
         if(var5 != 0) {
            break;
         }
      }

      x var6 = this.i.o();

      while(var6.f()) {
         q var7 = var6.e();
         if(var1[var7.d()] != null) {
            this.a(var7, this.a(var7), var1[var7.d()]);
         }

         var6.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   static {
      a = o.a.f();
      b = o.b.f();
      c = o.c.f();
      d = o.d.f();
      e = new String[4];
      e[a] = "^>_<";
      e[b] = ">_<^";
      e[c] = "_<^>";
      e[d] = "<^>_";
   }
}
