package y.f.f.e;

import java.awt.Dimension;
import y.c.A;
import y.c.C;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.w;
import y.f.f.e.b;
import y.f.f.e.c;
import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.h.r;
import y.g.M;

public class a implements y.f.f.b.d {
   private X b;
   private N c;
   private X d;
   private D e;
   private short f;
   private int g;
   private A h;
   private y.c.h i;
   private y.c.h j;
   private y.c.h k;
   private int l = 4;
   private A m;
   public static int a;

   public void a(D var1) {
      this.b = (X)var1.g();
      this.c = var1;
   }

   public void a(short var1) {
      this.f = var1;
   }

   public void a(int var1) {
      this.g = var1;
   }

   public D b() {
      return this.e;
   }

   public void a() {
      int var17 = a;
      p var3 = this.c.i();
      y.c.d var4 = var3.a().a();
      this.d = new w();
      this.e = new D(this.d);
      this.h = M.a(new Object[this.b.e()]);
      this.i = M.b(new Object[this.b.g()]);
      x var5 = this.b.o();

      q var7;
      while(true) {
         if(var5.f()) {
            q var6 = var5.e();
            if(var17 != 0) {
               break;
            }

            if(var6.c() <= this.l) {
               var7 = this.d.d();
               this.h.a(var6, var7);
            }

            var5.g();
            if(var17 == 0) {
               continue;
            }
         }

         this.j = M.b(new Object[this.b.g()]);
         this.k = M.b(new Object[this.b.g()]);
         this.a(this.j, this.k);
         break;
      }

      x var2 = this.b.o();

      y.c.e var1;
      q var9;
      y.c.d var22;
      label145:
      do {
         int var10000 = var2.f();

         label142:
         while(true) {
            if(var10000 == 0) {
               break label145;
            }

            q var19 = var2.e();
            if(var19.c() == 0) {
               break;
            }

            var1 = var19.l();
            var22 = var1.a();
            var7 = (q)this.j.b(var22);
            var1.b();

            while(true) {
               if(!var1.f()) {
                  break label142;
               }

               y.c.d var8 = var1.a();
               var9 = (q)this.j.b(var8);
               q var10 = (q)this.k.b(var8);
               y.c.d var11 = this.a(var7, var9);
               var10000 = var19.c();
               if(var17 != 0) {
                  break;
               }

               if(var10000 > this.l) {
                  this.h.a(var19, var11);
               }

               var7 = (q)this.j.b(var8);
               y.c.d var12 = this.d.a((q)var9, (q)var10);
               this.i.a(var8, var12);
               if(var8 == var22) {
                  break label142;
               }

               var1.b();
               if(var17 != 0) {
                  break label142;
               }
            }
         }

         var2.g();
      } while(var17 == 0);

      var1 = this.b.p();

      a var35;
      while(true) {
         if(var1.f()) {
            y.c.d var20 = var1.a();
            var35 = this;
            if(var17 != 0) {
               break;
            }

            label117: {
               if(this.c.n(var20)) {
                  this.e.m((y.c.d)this.i.b(var20));
                  if(var17 == 0) {
                     break label117;
                  }
               }

               this.e.e((y.c.d)this.i.b(var20));
            }

            var22 = this.c.h(var20);
            this.e.b((y.c.d)this.i.b(var20), (y.c.d)this.i.b(var22));
            var1.g();
            if(var17 == 0) {
               continue;
            }
         }

         var35 = this;
         break;
      }

      r var21 = var35.e.m();
      this.d.a((Object)"y.layout.orthogonal.general.NodeSplitter.NODE_FACES", (y.c.c)var21);
      r var23 = this.e.m();
      this.d.a((Object)"y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE", (y.c.c)var23);
      this.m = this.e.g().t();
      this.d.a((Object)"y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE", (y.c.c)(new c(var23, this.m)));

      y.c.d var30;
      try {
         label164: {
            this.e.l();
            y.c.d var24 = (y.c.d)this.i.b(var4);
            this.e.b((p)this.e.i(var24));
            y.f.h.q var25 = this.e.h();

            while(var25.f()) {
               var21.a(var25.a(), false);
               var25.g();
               if(var17 != 0) {
                  break label164;
               }

               if(var17 != 0) {
                  break;
               }
            }

            x var27 = this.b.o();

            while(var27.f()) {
               var9 = var27.e();
               if(var17 != 0) {
                  break;
               }

               label167: {
                  if(var9.c() > this.l) {
                     var30 = (y.c.d)this.h.b(var9);
                     p var32 = this.e.i(var30);
                     this.h.a(var9, var32);
                     var21.a(var32, true);
                     double var34 = this.b.p(var9);
                     double var14 = this.b.q(var9);
                     Dimension var16 = new Dimension((int)var34, (int)var14);
                     var23.a(var32, var16);
                     if(var17 == 0) {
                        break label167;
                     }
                  }

                  y.d.q var31 = this.b.r(var9);
                  if(var31.a > 0.0D || var31.b > 0.0D) {
                     q var33 = (q)this.h.b(var9);
                     this.m.a(var33, this.b.r(var9));
                  }
               }

               var27.g();
               if(var17 != 0) {
                  break;
               }
            }
         }
      } catch (Exception var18) {
         System.err.println("Internal Error in Face calculation !");
         var18.printStackTrace(System.err);
      }

      y.f.h.q var26 = this.e.h();

      while(var26.f()) {
         label76: {
            p var28 = (p)var26.d();
            if(var21.d(var28)) {
               y.c.e var29 = var28.a();

               while(var29.f()) {
                  var30 = var29.a();
                  this.e.m(this.e.h(var30));
                  this.e.e(var30);
                  var29.g();
                  if(var17 != 0) {
                     break label76;
                  }

                  if(var17 != 0) {
                     break;
                  }
               }
            }

            var26.g();
         }

         if(var17 != 0) {
            break;
         }
      }

   }

   private y.c.d a(q var1, q var2) {
      if(var1.equals(var2)) {
         return null;
      } else {
         y.c.d var3;
         y.c.d var5;
         label14: {
            var3 = this.d.a((q)var1, (q)var2);
            y.c.e var4 = var2.l();
            if(!var4.f()) {
               var5 = this.d.a((q)var2, (q)var1);
               if(a == 0) {
                  break label14;
               }
            }

            var4.g();
            y.c.d var6 = var4.a();
            var5 = this.d.a(var2, var6, var1, (y.c.d)null, 1, 0);
         }

         this.e.b(var3, var5);
         return var5;
      }
   }

   private void a(y.c.h var1, y.c.h var2) {
      int var8 = a;
      x var3 = this.b.o();

      y.c.e var10000;
      while(true) {
         if(var3.f()) {
            q var4 = var3.e();
            var10000 = var4.l();
            if(var8 != 0) {
               break;
            }

            y.c.e var5 = var10000;

            label37: {
               while(var5.f()) {
                  y.c.d var6 = var5.a();
                  q var7 = this.a(var6);
                  var1.a(var6, var7);
                  var5.g();
                  if(var8 != 0) {
                     break label37;
                  }

                  if(var8 != 0) {
                     break;
                  }
               }

               var3.g();
            }

            if(var8 == 0) {
               continue;
            }
         }

         var10000 = this.b.p();
         break;
      }

      y.c.e var9 = var10000;

      while(var9.f()) {
         y.c.d var10 = var9.a();
         y.c.d var11 = this.c.h(var10);
         var2.a(var10, var1.b(var11));
         var2.a(var11, var1.b(var10));
         var9.g();
         if(var8 != 0) {
            break;
         }
      }

   }

   private q a(y.c.d var1) {
      q var2;
      if(var1.c().c() <= this.l) {
         var2 = (q)this.h.b(var1.c());
         if(a == 0) {
            return var2;
         }
      }

      var2 = this.d.d();
      return var2;
   }

   public void c() {
      // $FF: Couldn't be decompiled
   }

   void a(y.c.d var1, y.c.D var2) {
      this.b.a(var1, var2);
      var1 = this.c.h(var1);
      var2.n();
      this.b.a(var1, var2);
   }

   private int a(y.c.D var1, y.c.D var2, int var3, int var4) {
      y.c.D var5 = new y.c.D();
      var5.addAll(var1);
      var5.addAll(var2);
      if(var5.size() == 0) {
         return (var4 + var3) / 2;
      } else {
         var5.o();
         return this.a(var5);
      }
   }

   private int a(y.c.D var1, y.c.D var2, int var3, int var4, int var5) {
      if(var5 >= var4 - var3) {
         return var3 + var5 / 2;
      } else {
         int var6 = this.a(var1, var2, var3, var4);
         if(var6 - var5 / 2 < var3) {
            var6 = var3 + var5 / 2;
            if(a == 0) {
               return var6;
            }
         }

         if(var6 + var5 / 2 > var4) {
            var6 = var4 - var5 / 2;
         }

         return var6;
      }
   }

   private int a(y.c.D var1) {
      int var4 = a;
      var1.sort(new b(this));
      C var2 = var1.m();
      int var3 = 0;

      Object var10000;
      while(true) {
         if(var3 < var1.size() / 2) {
            var10000 = var2;
            if(var4 != 0) {
               break;
            }

            var2.g();
            ++var3;
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var2.d();
         break;
      }

      return ((Integer)var10000).intValue();
   }

   static X a(a var0) {
      return var0.b;
   }
}
