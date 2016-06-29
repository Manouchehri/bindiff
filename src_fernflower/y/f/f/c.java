package y.f.f;

import y.c.A;
import y.c.h;
import y.c.i;
import y.c.x;
import y.f.U;
import y.f.V;
import y.f.X;
import y.f.aI;
import y.f.ad;
import y.f.an;
import y.f.f.a;
import y.f.f.d;
import y.f.f.b.e;
import y.f.f.b.p;
import y.f.f.c.f;
import y.f.f.c.m;
import y.f.f.d.F;
import y.f.f.d.o;
import y.f.f.d.t;
import y.f.f.d.w;
import y.f.f.e.k;
import y.f.f.e.n;
import y.f.k.L;
import y.g.q;

public class c extends y.f.c {
   private static final Object o = "y.layout.orthogonal.OrthogonalLayouter.INCREMENTAL_NODES_DPKEY";
   private static final Object p = "y.layout.orthogonal.OrthogonalLayouter.INCREMENTAL_EDGES_DPKEY";
   public static final Object n = "y.layout.orthogonal.OrthogonalLayouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY";
   private int q = 0;
   private int r = 25;
   private boolean s = true;
   private boolean t = true;
   private boolean u = true;
   private boolean v = false;
   private boolean w = false;
   private int x = 0;
   private boolean y;
   private boolean z;
   private boolean A = false;
   private boolean B = false;
   private ad C = new V();
   private a D;

   protected a a() {
      return new a();
   }

   public a n() {
      if(this.D == null) {
         this.D = this.a();
      }

      return this.D;
   }

   public c() {
      this.f(false);
      this.b(false);
      ad var1 = this.f();
      if(var1 instanceof y.f.b.b) {
         ((y.f.b.b)var1).a(false);
      }

      an var2 = new an();
      var2.a(false);
      this.e(var2);
   }

   public boolean o() {
      return this.z;
   }

   public void a(int var1) {
      if(var1 < 1) {
         throw new IllegalArgumentException("Illegal value for grid size: " + var1);
      } else {
         this.r = var1;
      }
   }

   public int p() {
      return this.r;
   }

   public void b(int var1) {
      if(var1 >= 0 && var1 <= 6) {
         this.q = var1;
      } else {
         throw new IllegalArgumentException("Illegal value for layout style: " + var1);
      }
   }

   public int q() {
      return this.q;
   }

   public boolean r() {
      return this.v;
   }

   public boolean b(X var1) {
      return true;
   }

   public void a(X var1) {
      boolean var12 = a.a;
      y.f.f.b.a var2 = new y.f.f.b.a();
      var2.a(this.r);
      var2.a(this.n());
      h var3 = null;
      A var4 = null;
      Object var5 = null;
      Object var6 = null;
      Object var7 = null;
      Object var8 = null;
      boolean var9 = this.q == 0 || this.q == 4 || this.q == 1;
      if(var9) {
         var2.a((e)(new F()));
      }

      label188: {
         if(this.q == 4) {
            d var10 = new d();
            var10.c(y.f.k.a.s);
            var10.b((double)Math.max(this.r, 10));
            var10.a((double)Math.max(this.r, 10));
            var10.c((double)Math.max(this.r, 20));
            var10.m();
            L var11 = new L(var10);
            var11.a(!this.r());
            var2.b(var11);
            var2.g(true);
            if(!var12) {
               break label188;
            }

            i.g = !i.g;
         }

         var2.g(false);
      }

      if(this.v) {
         label180: {
            var3 = var1.u();
            var4 = var1.t();
            this.a(var1, var4, var3);
            y.f.h.d var13 = new y.f.h.d();
            var13.a(var3);
            var13.a(var4);
            var5 = var13;
            if(var9) {
               var13.a(true);
               if(!var12) {
                  break label180;
               }
            }

            var13.a(false);
         }
      } else {
         y.f.h.c var14 = new y.f.h.c();
         var14.a((int)-1);
         var14.b(!this.w);
         var14.d(this.u);
         var14.a(this.t);
         var14.c(this.w);
         var5 = var14;
      }

      if(var9) {
         if(this.v) {
            w var15 = new w();
            var15.a(var3);
            var6 = var15;
         } else {
            o var16 = new o();
            var16.a(this.o());
            var6 = var16;
         }
      } else {
         k var17 = new k();
         var17.a(this.o());
         var6 = var17;
      }

      if(var9) {
         t var18 = new t();
         var18.a(false);
         var1.a((Object)t.a, (y.c.c)q.a((Object)(new Integer(5))));
         switch(this.q) {
         case 0:
         case 4:
            var18.a((short)0);
            if(!var12) {
               break;
            }
         case 1:
            var18.a((short)1);
         case 2:
         case 3:
         }

         if(this.y) {
            var18.a((short)3);
            var18.a((f)(new m()));
            var18.a(true);
         }

         label165: {
            var18.b((short)0);
            if(this.s) {
               var18.b((int)2);
               if(!var12) {
                  break label165;
               }
            }

            var18.b((int)3);
         }

         var7 = var18;
      } else if(this.q() != 2 && this.q() != 3) {
         if(this.q() == 6 || this.q() == 5) {
            y.f.f.e.m var20;
            label147: {
               var20 = new y.f.f.e.m();
               var20.a((short)0);
               if(this.s) {
                  var20.b(2);
                  if(!var12) {
                     break label147;
                  }
               }

               var20.b(3);
            }

            var7 = var20;
         }
      } else {
         n var19;
         label156: {
            var19 = new n();
            var19.b((short)0);
            if(this.s) {
               var19.b((int)2);
               if(!var12) {
                  break label156;
               }
            }

            var19.b((int)3);
         }

         var19.a((short)0);
         var7 = var19;
      }

      if(this.q() != 2 && this.q() != 3) {
         if(this.q == 6 || this.q == 5) {
            y.f.f.e.a var22;
            label128: {
               var22 = new y.f.f.e.a();
               if(this.q() == 5) {
                  var22.a((short)2);
                  if(!var12) {
                     break label128;
                  }
               }

               var22.a((short)3);
            }

            var8 = var22;
         }
      } else {
         y.f.f.e.i var21;
         label137: {
            var21 = new y.f.f.e.i();
            if(this.q() == 3) {
               var21.a((short)1);
               if(!var12) {
                  break label137;
               }
            }

            var21.a((short)0);
         }

         var8 = var21;
      }

      var2.a((y.f.h.o)var5);
      var2.a((y.f.f.b.b)var6);
      var2.a((p)var7);
      var2.a((y.f.f.b.d)var8);
      if(!var9) {
         var2.g(false);
      }

      if(!var9) {
         var2.h(false);
      }

      label120: {
         if(var9) {
            var2.i(var1.c(U.a) != null);
            if(!var12) {
               break label120;
            }
         }

         var2.i(false);
      }

      var2.j(var1.c(U.b) != null && (this.q == 0 || this.q == 4));
      if(this.e() instanceof y.f.e) {
         y.f.e var23 = (y.f.e)this.e();
         var23.a((double)this.p());
         var23.b(0.0D);
      }

      var2.m();
      var2.c(var1);
      if(this.v) {
         var1.a((h)var3);
         var1.a((A)var4);
      }

      if(var9) {
         var1.d_(t.a);
      }

      (new aI()).c(var1);
   }

   private void a(X var1, A var2, h var3) {
      Object var10000;
      boolean var8;
      label33: {
         var8 = a.a;
         y.c.c var4 = var1.c(p);
         if(var4 != null) {
            y.c.e var5 = var1.p();

            while(var5.f()) {
               y.c.d var6 = var5.a();
               var10000 = var3;
               if(var8) {
                  break label33;
               }

               var3.a(var6, var4.d(var6));
               var5.g();
               if(var8) {
                  break;
               }
            }
         }

         var10000 = var1.c(o);
      }

      Object var9 = var10000;
      if(var9 != null) {
         x var10 = var1.o();

         while(var10.f()) {
            y.c.q var7 = var10.e();
            var2.a(var7, ((y.c.c)var9).d(var7));
            var10.g();
            if(var8) {
               break;
            }
         }
      }

   }
}
