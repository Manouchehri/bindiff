package y.f.f.e;

import y.c.A;
import y.c.q;
import y.c.x;
import y.f.f.e.a;
import y.f.f.e.e;
import y.f.f.e.l;
import y.f.h.N;
import y.f.h.p;
import y.f.h.r;
import y.g.al;
import y.g.o;

public class k implements y.f.f.b.b {
   protected y.c.i a;
   protected y.f.f.b.h b;
   private y.c.h c;
   private y.c.h d;
   private static double e = 0.001D;
   private int f = 0;
   private static final Integer g = new Integer(0);
   private static final Integer h = new Integer(1);
   private static final Integer i = new Integer(3);
   private boolean j = false;

   public int b() {
      return this.f;
   }

   public void a(y.f.f.b.h var1) {
      this.b = var1;
      this.a = this.b.a();
   }

   public void a() {
      o.a(this, 1, "------->>> Entering Layout Phase");
      al var1 = new al();
      al var2 = new al();
      y.c.i var3 = new y.c.i();
      A var4 = var3.t();
      y.c.h var5 = var3.u();
      y.c.h var6 = var3.u();
      this.a(var3, var4, var5, var6);
      o.a(this, 3, "Prof: ---> Constructing network took " + var2);
      y.c.h var7 = this.a.u();
      this.a(var3, var4, var5, var6, var7);
      if(this.j) {
         y.f.f.b.l var8 = new y.f.f.b.l();
         y.c.c var9 = this.a.c((Object)"y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
         N var10 = this.b.b();
         var8.a(this.b, new l(this, var7, var9, var10));
      }

      this.b.a(var7, this.a.p().a(), y.f.f.b.o.a);
      this.a.a(var7);
      var3.a(var4);
      var3.a(var5);
      var3.a(var6);
      o.a(this, 1, "Prof: -> Total running time of layout Phase: " + var1);
      o.a(this, 1, "<<<------- Leaving Layout Phase");
   }

   private void a(y.c.i var1, A var2, y.c.h var3, y.c.h var4) {
      int var21 = a.a;
      Integer var5 = new Integer(4 * this.a.h());
      q var6 = var1.d();
      q var7 = var1.d();
      this.d = this.a.u();
      this.c = this.a.u();
      A var8 = var1.t();
      r var9 = this.b.g();
      y.c.c var10 = this.a.c((Object)"y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
      x var11 = this.a.o();

      q var13;
      y.c.d var14;
      while(var11.f()) {
         q var12 = var11.e();
         if(var12.b() < 4) {
            var13 = var1.d();
            var2.a(var13, g);
            var14 = var1.a(var6, var13);
            var3.a(var14, g);
            var4.a(var14, 4 - var12.b());
            var8.a(var12, var13);
         }

         var11.g();
         if(var21 != 0) {
            break;
         }
      }

      y.f.h.q var22 = this.b.c();

      int var10000;
      p var23;
      while(true) {
         if(var22.f()) {
            var23 = var22.a();
            var13 = var1.d();
            var2.a(var13, g);
            var10000 = var23.a().k();
            if(var21 != 0) {
               break;
            }

            if(var10000 < 4 && this.b.d() != var23) {
               var14 = var1.a(var6, var13);
               var3.a(var14, g);
               var4.a(var14, 4 - var23.a().k());
            }

            if(var23.a().k() > 4 && this.b.d() != var23) {
               var14 = var1.a(var13, var7);
               var3.a(var14, g);
               var4.a(var14, var23.a().k() - 4);
            }

            if(this.b.d() == var23) {
               var14 = var1.a(var13, var7);
               var3.a(var14, g);
               var4.a(var14, var23.a().k() + 4);
            }

            var9.a(var23, var13);
            var22.g();
            if(var21 == 0) {
               continue;
            }
         }

         var22 = this.b.c();
         var10000 = var22.f();
         break;
      }

      label84:
      while(true) {
         label82:
         while(true) {
            if(var10000 == 0) {
               break label84;
            }

            var23 = var22.a();
            var13 = (q)var9.b(var23);
            y.c.e var26 = var23.a();

            while(true) {
               if(!var26.f()) {
                  break label82;
               }

               y.c.d var15 = var26.a();
               p var16 = this.b.b(this.b.a(var15));
               q var17 = (q)var9.b(var16);
               y.c.d var18 = var1.a(var13, var17);
               var3.a(var18, h);
               this.c.a(var15, var18);
               var10000 = var10.d(var16);
               if(var21 != 0) {
                  break;
               }

               label77: {
                  if(var10000 != 0) {
                     var4.a(var18, g);
                     if(var21 == 0) {
                        break label77;
                     }
                  }

                  var4.a(var18, var5);
               }

               q var19 = (q)var8.b(var15.c());
               if(var19 != null) {
                  y.c.d var20 = var1.a(var19, var13);
                  var3.a(var20, g);
                  var4.a(var20, i);
                  this.d.a(var15, var20);
               }

               var26.g();
               if(var21 != 0) {
                  break label82;
               }
            }
         }

         var22.g();
         if(var21 != 0) {
            break;
         }

         var10000 = var22.f();
      }

      int var24 = 0;
      y.c.e var25 = var6.l();

      while(true) {
         if(var25.f()) {
            var24 += var4.a(var25.a());
            var25.g();
            if(var21 != 0) {
               break;
            }

            if(var21 == 0) {
               continue;
            }
         }

         var2.a(var6, var24);
         var2.a(var7, -var24);
         break;
      }

   }

   protected void a(y.c.i var1, A var2, y.c.h var3, y.c.h var4, y.c.h var5) {
      int var15 = a.a;
      al var6 = new al();
      this.f = 0;
      y.c.h var7 = var1.u();
      e var8 = new e();
      var8.a(var1, (y.c.c)null, var4, var3, var2, var7, (A)null);
      o.a(this, 3, "Prof: ---> Solving Network took " + var6);
      var6.e();
      o.a(this, 5, "Bends of edges: ");
      y.c.e var9 = this.a.p();

      while(true) {
         if(var9.f()) {
            y.c.d var10 = var9.a();
            StringBuffer var11 = new StringBuffer();
            int var12 = var7.a(this.c.b(var10));
            int var13 = var7.a(this.c.b(this.b.a(var10)));
            a(var11, (double)var13, '>');
            a(var11, (double)var12, '<');
            this.f += var11.length();
            var5.a(var10, var11.toString());
            if(var15 != 0) {
               break;
            }

            label19: {
               if(var10.c().b() < 4) {
                  int var14 = var7.a(this.d.b(var10));
                  this.b.a(var10, var14 + 1);
                  if(var15 == 0) {
                     break label19;
                  }
               }

               this.b.a((y.c.d)var10, (int)1);
            }

            var9.g();
            if(var15 == 0) {
               continue;
            }
         }

         this.f /= 2;
         o.a(this, 1, "Stat: Number of bends: " + this.f);
         o.a(this, 3, "Prof: ---> Parsing ILP solution took " + var6);
         break;
      }

   }

   private static void a(StringBuffer var0, double var1, char var3) {
      int var6 = a.a;
      int var4 = (int)Math.floor(var1 + e);
      int var5 = 0;

      while(var5 < var4) {
         var0.append(var3);
         ++var5;
         if(var6 != 0) {
            break;
         }
      }

   }

   public void a(boolean var1) {
      this.j = var1;
   }
}
