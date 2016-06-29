package y.f.f.c;

import java.util.Iterator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.x;
import y.f.f.c.a;
import y.f.f.c.g;
import y.f.f.c.o;

public class p {
   private int a;
   private y.f.f.b.h b;
   private y.c.i c;
   private y.c.h d;
   private y.c.h e;
   private A f;
   private A g;
   private A h;
   private a i;
   private int j;
   private D k;
   private g[] l;
   private boolean m = false;

   public p(int var1, y.f.f.b.h var2) {
      this.a = var1;
      this.b = var2;
      this.a(var1, var2);
      this.a();
   }

   public void a() {
      this.b(this.a, this.b);
      this.c(this.a, this.b);
   }

   public void b() {
      this.b(this.a, this.b);
   }

   public void c() {
      this.b.a().a(this.h);
      this.c = null;
      this.i = null;
      this.k = null;
      this.l = null;
   }

   public Iterator d() {
      return this.k.iterator();
   }

   public C e() {
      return this.k.m();
   }

   public g a(y.c.q var1) {
      return (g)this.h.b(var1);
   }

   public g a(y.c.d var1) {
      return this.a(var1.c());
   }

   public double b(y.c.d var1) {
      return this.m?this.a(var1.c(), var1.d()):this.d.c(var1);
   }

   public double a(y.c.q var1, y.c.q var2) {
      if(this.m) {
         return (double)this.i.a(this.b(var1).b(), this.b(var2).b());
      } else {
         y.c.d var3 = var1.a(var2);
         return var3 == null?2.147483647E9D:this.d.c(var3);
      }
   }

   public g b(y.c.q var1) {
      return (g)this.f.b(var1);
   }

   public y.c.d a(g var1, g var2, int var3) {
      if(var1.c() == this.a && var2.c() == this.a) {
         y.c.q var4 = var1.a();
         y.c.q var5 = var2.a();
         var3 += var1.k() + var2.j();
         y.c.d var6;
         if(this.m) {
            if(this.i.a(var1.b(), var2.b()) == Integer.MAX_VALUE) {
               this.i.a(var1.b(), var2.b(), var3);
               var6 = this.c.a(var4, var5);
               this.a(var6, 0);
               return var6;
            } else {
               if(this.i.a(var1.b(), var2.b()) < var3) {
                  this.i.a(var1.b(), var2.b(), var3);
               }

               return null;
            }
         } else {
            var6 = var4.a(var5);
            if(var6 == null) {
               var6 = this.c.a(var4, var5);
               this.d.a(var6, (double)var3);
               this.a(var6, 0);
               if(g.a == 0) {
                  return var6;
               }
            }

            if(this.d.c(var6) < (double)var3) {
               this.d.a(var6, (double)var3);
            }

            return var6;
         }
      } else {
         throw new RuntimeException("Invalid call to set min-dist !");
      }
   }

   public o a(g var1) {
      y.c.q var2 = var1.a();
      return (o)this.g.b(var2);
   }

   public void a(y.c.d var1, int var2) {
      this.e.a(var1, var2);
   }

   public int c(y.c.d var1) {
      Object var2 = this.e.b(var1);
      return var2 == null?0:this.e.a(var1);
   }

   private void a(int var1, y.f.f.b.h var2) {
      label64: {
         int var12 = g.a;
         y.c.i var3 = var2.a();
         y.f.f.b.o var4;
         y.f.f.b.o var5;
         byte var6;
         switch(var1) {
         case 0:
            var4 = y.f.f.b.o.c;
            var5 = y.f.f.b.o.a;
            var6 = 0;
            if(var12 == 0) {
               break;
            }
         case 1:
            var4 = y.f.f.b.o.b;
            var5 = y.f.f.b.o.d;
            var6 = 1;
            if(var12 != 0) {
               break label64;
            }
            break;
         default:
            break label64;
         }

         this.c = new y.c.i();
         this.f = this.c.t();
         this.h = var3.t();
         this.k = new D();
         this.j = 0;
         x var7 = var3.o();

         while(true) {
            if(var7.f()) {
               y.c.q var8 = var7.e();
               y.c.d var9 = this.a(var8, var5, var2);
               if(var12 != 0) {
                  break;
               }

               label47: {
                  if(var9 == null) {
                     y.c.q var10 = this.c.d();
                     g var11 = new g(var10, this.j, var6);
                     this.k.add(var11);
                     ++this.j;
                     this.f.a(var10, var11);
                     this.h.a(var8, var11);
                     var11.a(var8);
                     var9 = this.a(var8, var4, var2);

                     while(var9 != null) {
                        var8 = var9.d();
                        var11.a(var8);
                        this.h.a(var8, var11);
                        var11.b(Math.max(var2.l(var9), var11.j()));
                        var11.c(Math.max(var2.m(var9), var11.k()));
                        var9 = this.a(var8, var4, var2);
                        if(var12 != 0) {
                           break label47;
                        }

                        if(var12 != 0) {
                           break;
                        }
                     }
                  }

                  var7.g();
               }

               if(var12 == 0) {
                  continue;
               }
            }

            this.l = new g[this.j];
            break;
         }

         Iterator var13 = this.k.iterator();

         while(true) {
            if(var13.hasNext()) {
               g var14 = (g)var13.next();
               this.l[var14.b()] = var14;
               if(var12 != 0) {
                  break;
               }

               if(var12 == 0) {
                  continue;
               }
            }

            this.d = this.c.u();
            this.e = this.c.u();
            break;
         }

         return;
      }

      y.g.o.a((Object)("Constraint Graph Constructor: Unknown type:" + var1));
   }

   private void b(int var1, y.f.f.b.h var2) {
      int var12 = g.a;
      this.m = false;
      y.c.i var3 = var2.a();
      y.c.e var4 = this.c.p();

      y.f.f.b.o var5;
      y.f.f.b.o var13;
      label90: {
         label89:
         while(true) {
            if(var4.f()) {
               this.c.a(var4.a());
               var4.g();
               if(var12 != 0) {
                  break;
               }

               if(var12 == 0) {
                  continue;
               }
            }

            switch(var1) {
            case 0:
               break label89;
            case 1:
               var13 = y.f.f.b.o.c;
               var5 = y.f.f.b.o.a;
               break label90;
            default:
               y.g.o.a(this, 1, "Constraint Graph Constructor: Unknown type:" + var1);
               return;
            }
         }

         var13 = y.f.f.b.o.b;
         var5 = y.f.f.b.o.d;
      }

      Object var6 = var3.p();

      g var8;
      g var9;
      boolean var10000;
      while(true) {
         if(((y.c.e)var6).f()) {
            y.c.d var7 = ((y.c.e)var6).a();
            var10000 = var2.j(var7);
            if(var12 != 0) {
               break;
            }

            if(var10000) {
               var8 = null;
               var9 = null;
               if(var2.h(var7).a(var13)) {
                  var8 = this.a(var7.c());
                  var9 = this.a(var7.d());
               }

               if(var2.h(var7).a(var5)) {
                  var8 = this.a(var7.d());
                  var9 = this.a(var7.c());
               }

               if(var8 != null && var9 != null) {
                  y.c.d var10 = this.a(var8, var9, var2.i(var7));
                  int var11 = (int)var2.k(var7);
                  if(this.c(var10) < var11) {
                     this.a(var10, var11);
                  }
               }
            }

            ((y.c.e)var6).g();
            if(var12 == 0) {
               continue;
            }
         }

         var6 = var2.i();
         var10000 = ((C)var6).f();
         break;
      }

      while(var10000) {
         y.f.f.b.n var14 = (y.f.f.b.n)((C)var6).d();
         if(var14.d() != 2) {
            var8 = null;
            var9 = null;
            if(var14.e().a(var13)) {
               var8 = this.a(var14.a());
               var9 = this.a(var14.b());
            }

            if(var14.e().a(var5)) {
               var8 = this.a(var14.b());
               var9 = this.a(var14.a());
            }

            if(var8 != null && var9 != null) {
               this.a(var8, var9, var14.c());
            }
         }

         ((C)var6).g();
         if(var12 != 0) {
            break;
         }

         var10000 = ((C)var6).f();
      }

   }

   private void c(int var1, y.f.f.b.h var2) {
      int var10 = g.a;
      y.g.o.a(this, 5, "Init max-dist graph: ");
      this.g = this.c.t();
      y.f.f.b.o var3;
      y.f.f.b.o var4;
      switch(var1) {
      case 0:
         var3 = y.f.f.b.o.b;
         var4 = y.f.f.b.o.d;
         if(var10 == 0) {
            break;
         }
      case 1:
         var3 = y.f.f.b.o.c;
         var4 = y.f.f.b.o.a;
         if(var10 == 0) {
            break;
         }
      default:
         y.g.o.a(this, 5, "Constraint Graph Constructor: Unknown type:" + var1);
         return;
      }

      C var5 = var2.i();

      while(var5.f()) {
         y.f.f.b.n var6 = (y.f.f.b.n)var5.d();
         if(var6.d() != 1) {
            g var7 = null;
            g var8 = null;
            if(var6.e().a(var3)) {
               var7 = this.a(var6.a());
               var8 = this.a(var6.b());
            }

            if(var6.e().a(var4)) {
               var7 = this.a(var6.b());
               var8 = this.a(var6.a());
            }

            if(var7 != null && var8 != null) {
               o var9 = new o(var7, var8, (double)var6.c());
               this.g.a(var7.a(), var9);
               this.g.a(var8.a(), var9);
            }
         }

         var5.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   private y.c.d a(y.c.q var1, y.f.f.b.o var2, y.f.f.b.h var3) {
      int var6 = g.a;
      y.c.e var4 = var1.l();

      while(var4.f()) {
         y.c.d var5 = var4.a();
         if(var3.h(var5).a(var2)) {
            return var5;
         }

         var4.g();
         if(var6 != 0) {
            break;
         }
      }

      return null;
   }

   public y.c.i f() {
      return this.c;
   }
}
