package y.f.k;

import java.awt.geom.Rectangle2D.Double;
import java.util.Comparator;
import y.f.ad;
import y.f.ae;
import y.f.k.U;
import y.f.k.b;
import y.f.k.d;

public class a extends y.f.c {
   public static final Object n = "y.layout.tree.ARTreeLayouter.RATIO";
   public static final Object o = "y.layout.tree.ARTreeLayouter.ROOT_PLACEMENT";
   public static final Object p = "y.layout.tree.ARTreeLayouter.PLACEMENT_TOP";
   public static final Object q = "y.layout.tree.ARTreeLayouter.PLACEMENT_CORNER";
   public static final Object r = "y.layout.tree.ARTreeLayouter.PLACEMENT_CORNER_SIDE";
   public static final Object s = "y.layout.tree.ARTreeLayouter.PLACEMENT_CORNER_TOP";
   public static final Object t = "y.layout.tree.ARTreeLayouter.ROUTING_POLICY";
   public static final Object u = "y.layout.tree.ARTreeLayouter.ROUTING_HORIZONTAL";
   public static final Object v = "y.layout.tree.ARTreeLayouter.ROUTING_VERTICAL";
   private y.c.A y;
   private U z;
   protected y.f.X w;
   private double A = 10.0D;
   private double B = 10.0D;
   private double C = 5.0D;
   private double D = 1.41D;
   private Object E;
   private Object F;
   private double G;
   Comparator x;

   public a() {
      this.E = q;
      this.F = u;
      this.G = 20.0D;
      ad var1 = this.f();
      if(var1 instanceof y.f.b.b) {
         ((y.f.b.b)var1).a(false);
      }

   }

   public void a(double var1) {
      this.A = var1;
   }

   public void b(double var1) {
      this.B = var1;
   }

   public void a(y.f.X var1) {
      int var5 = d.g;
      if(!y.a.A.b(var1)) {
         throw new y.c.B("Graph is not a tree");
      } else {
         ae.a(var1);
         this.w = var1;
         y.c.f var2 = y.a.A.e(var1);
         this.z = new U(var1);
         y.c.q var3 = this.z.a();
         this.y = var1.t();
         this.c(var3);
         this.d(var3);
         var1.a((y.c.A)this.y);

         while(true) {
            if(!var2.isEmpty()) {
               y.c.d var4 = var2.d();
               ae.a(var1.g(var4));
               var1.c(var4);
               if(var5 != 0) {
                  break;
               }

               if(var5 == 0) {
                  continue;
               }
            }

            ae.b(var1);
            break;
         }

      }
   }

   public boolean b(y.f.X var1) {
      return y.a.A.b(var1);
   }

   protected double a(y.c.q var1) {
      y.c.c var2 = this.w.c(n);
      if(var2 == null) {
         return this.a();
      } else {
         Object var3 = var2.b(var1);
         return var3 instanceof Number?((Number)var3).doubleValue():this.a();
      }
   }

   private b c(y.c.q var1) {
      int var22 = d.g;
      b var2 = new b();
      this.y.a(var1, var2);
      if(!this.z.a(var1)) {
         double var3 = 0.0D;
         double var5 = 0.0D;
         Object var7 = this.b((Object)var1);
         Object var8 = this.a((Object)var1);
         y.c.x var9 = var1.o();

         while(var9.f()) {
            y.c.q var10 = var9.e();
            this.c(var10);
            var9.g();
            if(var22 != 0) {
               return var2;
            }

            if(var22 != 0) {
               break;
            }
         }

         y.d.q var23;
         label86: {
            var9 = null;
            var23 = this.a(var1, this.a(var1));
            if(p.equals(var7)) {
               var2.b = this.w.q(var1) + 2.0D * this.G + var23.b();
               var2.a = Math.max(this.w.p(var1), var23.a());
               if(var22 == 0) {
                  break label86;
               }
            }

            double var12;
            double var14;
            double var16;
            double var20;
            double var24;
            label88: {
               var24 = this.w.p(var1);
               var12 = this.w.q(var1);
               var14 = Math.max(var24, var23.a() + 2.0D * this.G) * (var12 + var23.b() + 2.0D * this.G);
               var16 = (var24 + 2.0D * this.G + var23.a()) * Math.max(var12, var23.b() + 2.0D * this.G);
               if(var2.f > 1 || u.equals(var8)) {
                  var20 = 2.0D * this.G + var23.b();
                  if(var22 == 0) {
                     break label88;
                  }
               }

               var20 = this.B + var23.b();
            }

            label61: {
               if(this.G < var24) {
                  Math.max(var24, var23.a() + 2.0D * this.G);
                  if(var22 == 0) {
                     break label61;
                  }
               }

               Math.max(var24, var23.a() + this.G + var24);
            }

            double var18;
            label87: {
               if(q.equals(var7)) {
                  if(var14 < var16) {
                     var20 += var12;
                     if(this.G < var24) {
                        var18 = Math.max(var24, var23.a() + 2.0D * this.G);
                        if(var22 == 0) {
                           break label87;
                        }
                     }

                     var18 = Math.max(var24, var23.a() + this.G + var24);
                     if(var22 == 0) {
                        break label87;
                     }
                  }

                  var2.g = true;
                  var20 = Math.max(var20, var12);
                  var18 = var24 + var23.a() + 2.0D * this.G;
                  if(var22 == 0) {
                     break label87;
                  }
               }

               if(r.equals(var7)) {
                  var2.g = true;
                  var20 = Math.max(var20, var12);
                  var18 = var24 + var23.a() + 2.0D * this.G;
                  if(var22 == 0) {
                     break label87;
                  }
               }

               var20 += var12;
               if(this.G < var24) {
                  var18 = Math.max(var24, var23.a() + 2.0D * this.G);
                  if(var22 == 0) {
                     break label87;
                  }
               }

               var18 = Math.max(var24, var23.a() + this.G + var24);
            }

            var2.a = var18;
            var2.b = var20;
         }

         var2.e = var23;
         if(var22 == 0) {
            return var2;
         }
      }

      var2.a = this.w.p(var1);
      var2.b = this.w.q(var1);
      return var2;
   }

   private y.d.q a(y.c.q var1, double var2) {
      double var4;
      double var6;
      Double var10;
      int var11;
      Object var20;
      label67: {
         label69: {
            int var18 = d.g;
            var4 = this.A;
            var6 = this.B;
            Object var8 = this.a((Object)var1);
            Double[] var9 = new Double[var1.c()];
            var10 = new Double();
            int var12 = 0;
            y.c.x var13 = (new y.c.y(this.b(var1))).a();
            y.c.x var14;
            y.c.q var15;
            b var16;
            Double[] var10000;
            Double var17;
            if(u.equals(var8)) {
               var6 += this.G;
               var14 = var13;

               label62: {
                  while(var14.f()) {
                     var15 = var14.e();
                     var16 = (b)this.y.b(var15);
                     var10000 = var9;
                     if(var18 != 0) {
                        break label62;
                     }

                     var9[var12++] = new Double(0.0D, 0.0D, var16.a + var4, var16.b + var6);
                     var14.g();
                     if(var18 != 0) {
                        break;
                     }
                  }

                  var10000 = var9;
               }

               var11 = ae.a(var10000, var10, var2, 1);
               var12 = 0;
               var13.i();
               var14 = var13;

               do {
                  if(!var14.f()) {
                     break label69;
                  }

                  var15 = var14.e();
                  var16 = (b)this.y.b(var15);
                  var17 = var9[var12++];
                  var16.c = var17.x;
                  var16.d = var17.y;
                  var20 = var14;
                  if(var18 != 0) {
                     break label67;
                  }

                  var14.g();
               } while(var18 == 0);
            }

            var4 += this.G;
            var14 = var13;

            label43: {
               while(var14.f()) {
                  var15 = var14.e();
                  var16 = (b)this.y.b(var15);
                  var10000 = var9;
                  if(var18 != 0) {
                     break label43;
                  }

                  var9[var12++] = new Double(0.0D, 0.0D, var16.b + var6, var16.a + var4);
                  var14.g();
                  if(var18 != 0) {
                     break;
                  }
               }

               var10000 = var9;
            }

            var11 = ae.a(var10000, var10, 1.0D / var2, 1);
            var10.setFrame(var10.getY(), var10.getX(), var10.getHeight(), var10.getWidth());
            var12 = 0;
            var13.i();
            var14 = var13;

            while(var14.f()) {
               var15 = var14.e();
               var16 = (b)this.y.b(var15);
               var17 = var9[var12++];
               var16.c = var17.y;
               var16.d = var17.x;
               var20 = var14;
               if(var18 != 0) {
                  break label67;
               }

               var14.g();
               if(var18 != 0) {
                  break;
               }
            }
         }

         var20 = this.y.b(var1);
      }

      b var19 = (b)var20;
      var19.f = var11;
      return new y.d.q(var10.getWidth() - var10.getX() - var4, var10.getHeight() - var10.getY() - var6);
   }

   protected y.c.x b(y.c.q var1) {
      if(this.x != null) {
         var1.b(this.x);
      }

      return var1.o();
   }

   private void d(y.c.q var1) {
      Object var3;
      Object var4;
      double var5;
      double var7;
      int var14;
      label64: {
         var14 = d.g;
         b var2 = (b)this.y.b(var1);
         var3 = this.b((Object)var1);
         var4 = this.a((Object)var1);
         if(p.equals(var3)) {
            var7 = this.w.n(var1) + this.w.q(var1) + 2.0D * this.G;
            var5 = this.w.j(var1) - var2.e.a() / 2.0D;
            if(var14 == 0) {
               break label64;
            }
         }

         double var9 = this.w.p(var1);
         if(var2.g) {
            label66: {
               if(var2.f > 1 || u.equals(var4)) {
                  var7 = this.w.n(var1) + 2.0D * this.G;
                  if(var14 == 0) {
                     break label66;
                  }
               }

               var7 = this.w.n(var1) + this.B;
            }

            var5 = this.w.m(var1) + var9 + 2.0D * this.G;
            if(var14 == 0) {
               break label64;
            }
         }

         label67: {
            if(var2.f > 1 || u.equals(var4)) {
               var7 = this.w.n(var1) + this.w.q(var1) + 2.0D * this.G;
               if(var14 == 0) {
                  break label67;
               }
            }

            var7 = this.w.n(var1) + this.w.q(var1) + this.B;
         }

         if(this.G < var9) {
            var5 = this.w.m(var1) + 2.0D * this.G;
            if(var14 == 0) {
               break label64;
            }
         }

         var5 = this.w.m(var1) + this.G + var9;
      }

      y.c.e var15 = var1.l();

      while(var15.f()) {
         y.c.d var10 = var15.a();
         y.c.q var11 = var10.d();
         b var12 = (b)this.y.b(var11);
         this.w.c(var11, var5 + var12.c, var7 + var12.d);
         if(!this.z.a(var11)) {
            this.d(var11);
         }

         y.f.I var13 = this.w.g(var10);
         var13.clearPoints();
         this.a(var13, var1, var11, var3, var4);
         var15.g();
         if(var14 != 0) {
            break;
         }
      }

   }

   protected void a(y.f.I var1, y.c.q var2, y.c.q var3, Object var4, Object var5) {
      int var17 = d.g;
      b var6 = (b)this.y.b(var2);
      double var7 = this.w.p(var2);
      double var9 = this.w.q(var2);
      double var11;
      double var13;
      double var15;
      if(p.equals(var4)) {
         var11 = this.w.j(var2);
         var13 = this.w.n(var2) + var9 + this.G;
         var1.addPoint(var11, var13);
         if(u.equals(var5)) {
            var15 = this.w.n(var3) - this.G;
            var1.addPoint(var11, var15);
            var1.addPoint(this.w.j(var3), var15);
            if(var17 == 0) {
               return;
            }
         }

         label34: {
            if(this.w.j(var3) < var11) {
               var15 = this.w.m(var3) + this.w.p(var3) + this.G;
               if(var17 == 0) {
                  break label34;
               }
            }

            var15 = this.w.m(var3) - this.G;
         }

         var1.addPoint(var15, var13);
         var1.addPoint(var15, this.w.k(var3));
         if(var17 == 0) {
            return;
         }
      }

      label25: {
         if(var6.g) {
            var1.setSourcePoint(new y.d.t(0.0D, -var9 / 2.0D + this.C));
            var11 = this.w.m(var2) + var7 + this.G;
            var13 = this.w.n(var2) + this.C;
            if(var17 == 0) {
               break label25;
            }
         }

         var1.setSourcePoint(new y.d.t(-var7 / 2.0D + this.C, 0.0D));
         var11 = this.w.m(var2) + this.C;
         var13 = this.w.n(var2) + var9 + this.G;
      }

      var1.addPoint(var11, var13);
      if(u.equals(var5)) {
         var15 = this.w.n(var3) - this.G;
         var1.addPoint(var11, var15);
         var1.addPoint(this.w.j(var3), var15);
         if(var17 == 0) {
            return;
         }
      }

      var15 = this.w.m(var3) - this.G;
      var1.addPoint(var15, var13);
      var1.addPoint(var15, this.w.k(var3));
   }

   protected Object a(Object var1) {
      y.c.c var2 = this.w.c(t);
      if(var2 == null) {
         return this.o();
      } else {
         Object var3 = var2.b(var1);
         return var3 != null?var3:this.o();
      }
   }

   protected Object b(Object var1) {
      y.c.c var2 = this.w.c(o);
      if(var2 == null) {
         return this.n();
      } else {
         Object var3 = var2.b(var1);
         return var3 != null?var3:this.n();
      }
   }

   public double a() {
      return this.D;
   }

   public Object n() {
      return this.E;
   }

   public void c(Object var1) {
      this.E = var1;
   }

   public Object o() {
      return this.F;
   }

   public void c(double var1) {
      this.G = var1;
   }
}
