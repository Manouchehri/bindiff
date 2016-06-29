package y.h;

import java.awt.Color;
import java.util.Iterator;
import y.h.aB;
import y.h.aZ;
import y.h.bu;
import y.h.eU;
import y.h.fg;
import y.h.fi;
import y.h.fj;

public class ff {
   public static final Object a = "y.view.NodePortLayoutConfigurator#EDGE2D_DPKEY";
   private boolean b;
   private boolean c = true;
   private boolean d = true;
   private y.c.c e;
   private y.c.c f;
   private y.c.c g;
   private y.c.c h;
   private boolean i;
   private boolean j;
   private static final fj k = f();

   public boolean a() {
      return this.b;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public boolean b() {
      return this.c;
   }

   public boolean c() {
      return this.d;
   }

   public void a(bu var1) {
      if(this.a()) {
         this.c(var1);
      }

      if(this.b()) {
         this.b(var1);
      }

      this.h(var1);
   }

   private void h(bu var1) {
      fg var2 = new fg(this);
      var1.d_(a);
      var1.a((Object)a, (y.c.c)var2);
   }

   protected void b(bu var1) {
      boolean var10 = fj.z;
      y.c.h var2 = var1.u();
      y.c.h var3 = var1.u();
      this.i = false;
      y.c.x var4 = var1.o();

      int var12;
      label85:
      while(true) {
         boolean var10000 = var4.f();

         label82:
         while(var10000) {
            fj var5 = var1.t(var4.e());
            var12 = var5.portCount();
            if(var10) {
               break label85;
            }

            if(var12 > 0) {
               Iterator var6 = var5.ports();

               label77:
               do {
                  eU var7;
                  y.c.e var9;
                  do {
                     if(!var6.hasNext()) {
                        break label77;
                     }

                     var7 = (eU)var6.next();
                     y.c.e var8 = var7.d();
                     if(var8.k() > 1) {
                        label96: {
                           while(var8.f()) {
                              var3.a(var8.a(), var7);
                              var8.g();
                              if(var10) {
                                 break label96;
                              }

                              if(var10) {
                                 break;
                              }
                           }

                           this.i = true;
                        }
                     }

                     var9 = var7.e();
                  } while(var9.k() <= 1);

                  do {
                     var10000 = var9.f();
                     if(var10) {
                        continue label82;
                     }

                     if(!var10000) {
                        break;
                     }

                     var2.a(var9.a(), var7);
                     var9.g();
                     if(var10) {
                        continue label77;
                     }
                  } while(!var10);

                  this.i = true;
               } while(!var10);
            }

            var4.g();
            if(!var10) {
               continue label85;
            }
            break;
         }

         var12 = this.i;
         break;
      }

      if(var12 != 0) {
         Object var11 = y.f.aF.c;
         this.g = var1.c(var11);
         if(this.g != null) {
            var1.d_(var11);
         }

         var1.a((Object)var11, (y.c.c)var2);
         var11 = y.f.aF.d;
         this.h = var1.c(var11);
         if(this.h != null) {
            var1.d_(var11);
         }

         var1.a((Object)var11, (y.c.c)var3);
      } else {
         var1.a((y.c.h)var2);
         var1.a((y.c.h)var3);
      }

   }

   protected void c(bu var1) {
      boolean var12 = fj.z;
      y.c.h var2 = var1.u();
      y.c.h var3 = var1.u();
      boolean var4 = false;
      y.h.a.v var5 = var1.C();
      boolean var6 = var5 != null;
      boolean var7 = !this.c();
      y.c.e var8 = var1.p();

      Object var10000;
      while(true) {
         if(var8.f()) {
            y.c.d var9 = var8.a();
            eU var10 = eU.a(var1, var9, true);
            var10000 = var10;
            if(var12) {
               break;
            }

            if(var10 != null) {
               label69: {
                  if(var7 && var6 && var5.k(var9.c())) {
                     var2.a(var9, y.f.aE.a(this.a(var10)));
                     if(!var12) {
                        break label69;
                     }
                  }

                  var1.i(var9).setSourcePoint(eU.b(var10));
                  var2.a(var9, y.f.aE.a(this.a(var10), true));
               }

               var4 = true;
            }

            eU var11 = eU.a(var1, var9, false);
            if(var11 != null) {
               label58: {
                  if(var7 && var6 && var5.k(var9.d())) {
                     var3.a(var9, y.f.aE.a(this.a(var11)));
                     if(!var12) {
                        break label58;
                     }
                  }

                  var1.i(var9).setTargetPoint(eU.b(var11));
                  var3.a(var9, y.f.aE.a(this.a(var11), true));
               }

               var4 = true;
            }

            var8.g();
            if(!var12) {
               continue;
            }
         }

         this.j = var4;
         if(!var4) {
            var1.a((y.c.h)var2);
            var1.a((y.c.h)var3);
            return;
         }

         var10000 = y.f.aF.a;
         break;
      }

      Object var13 = var10000;
      this.e = var1.c(var13);
      if(this.e != null) {
         var1.d_(var13);
      }

      var1.a((Object)var13, (y.c.c)var2);
      var13 = y.f.aF.b;
      this.f = var1.c(var13);
      if(this.f != null) {
         var1.d_(var13);
      }

      var1.a((Object)var13, (y.c.c)var3);
   }

   protected byte a(eU var1) {
      y.d.t var2 = var1.h();
      fj var3 = var1.b();
      double var4 = var3.getCenterX();
      double var6 = var3.getCenterY();
      double var8 = var3.getWidth();
      double var10 = var3.getHeight();
      double var12 = var8 * 0.25D;
      double var14 = var10 * 0.25D;
      if(var4 - var12 <= var2.a() && var2.a() <= var4 + var12 && var6 - var14 <= var2.b() && var2.b() <= var6 + var14) {
         return (byte)0;
      } else {
         byte var16 = 0;
         double var17 = Double.POSITIVE_INFINITY;
         double var19 = var3.getX();
         double var21 = var3.getY();
         double var23 = Math.abs(var21 - var2.b());
         if(var17 > var23) {
            var17 = var23;
            var16 = 1;
         }

         var23 = Math.abs(var21 + var10 - var2.b());
         if(var17 > var23) {
            var17 = var23;
            var16 = 2;
         }

         var23 = Math.abs(var19 - var2.a());
         if(var17 > var23) {
            var17 = var23;
            var16 = 8;
         }

         var23 = Math.abs(var19 + var8 - var2.a());
         if(var17 > var23) {
            var16 = 4;
         }

         return var16;
      }
   }

   public void d(bu var1) {
      label15: {
         this.i(var1);
         if(this.a()) {
            this.f(var1);
            if(!fj.z) {
               break label15;
            }
         }

         this.g(var1);
      }

      if(this.b()) {
         this.e(var1);
      }

   }

   private void i(bu var1) {
      var1.d_(a);
   }

   protected void e(bu var1) {
      if(this.i) {
         Object var2 = y.f.aF.c;
         y.c.c var3 = var1.c(var2);
         if(var3 != null) {
            var1.d_(var2);
            if(var3 instanceof y.c.h) {
               var1.a((y.c.h)((y.c.h)var3));
            }
         }

         if(this.g != null) {
            var1.a((Object)var2, (y.c.c)this.g);
            this.g = null;
         }

         var2 = y.f.aF.d;
         y.c.c var4 = var1.c(var2);
         if(var4 != null) {
            var1.d_(var2);
            if(var4 instanceof y.c.h) {
               var1.a((y.c.h)((y.c.h)var4));
            }
         }

         if(this.h != null) {
            var1.a((Object)var2, (y.c.c)this.h);
            this.h = null;
         }
      }

   }

   protected void f(bu var1) {
      boolean var11 = fj.z;
      if(this.j) {
         Object var2 = y.f.aF.a;
         y.c.c var3 = var1.c(var2);
         var2 = y.f.aF.b;
         y.c.c var4 = var1.c(var2);
         y.c.e var5 = var1.p();

         Object var10000;
         label58: {
            while(var5.f()) {
               y.c.d var6 = var5.a();
               aB var7 = var1.i(var6);
               eU var8 = eU.a(var1, var6, true);
               var10000 = var8;
               if(var11) {
                  break label58;
               }

               if(var8 != null) {
                  label53: {
                     if(b(var3, var6)) {
                        y.d.t var9 = eU.b(var8);
                        var7.setSourcePoint(var9);
                        if(!var11) {
                           break label53;
                        }
                     }

                     eU.a(var8, var7.getSourcePoint());
                  }
               }

               eU var12 = eU.a(var1, var6, false);
               if(var12 != null) {
                  label47: {
                     if(b(var4, var6)) {
                        y.d.t var10 = eU.b(var12);
                        var7.setTargetPoint(var10);
                        if(!var11) {
                           break label47;
                        }
                     }

                     eU.a(var12, var7.getTargetPoint());
                  }
               }

               var5.g();
               if(var11) {
                  break;
               }
            }

            var10000 = y.f.aF.a;
         }

         var2 = var10000;
         if(var3 != null) {
            var1.d_(var2);
            if(var3 instanceof y.c.h) {
               var1.a((y.c.h)((y.c.h)var3));
            }
         }

         if(this.e != null) {
            var1.a((Object)var2, (y.c.c)this.e);
            this.e = null;
         }

         var2 = y.f.aF.b;
         if(var4 != null) {
            var1.d_(var2);
            if(var4 instanceof y.c.h) {
               var1.a((y.c.h)((y.c.h)var4));
            }

            if(this.f != null) {
               var1.a((Object)var2, (y.c.c)this.f);
               this.f = null;
            }
         }
      }

   }

   protected void g(bu var1) {
      boolean var5 = fj.z;
      y.c.x var2 = var1.o();

      while(var2.f()) {
         label27: {
            fj var3 = var1.t(var2.e());
            if(var3.portCount() > 0) {
               Iterator var4 = var3.ports();

               while(var4.hasNext()) {
                  this.a(var1, (eU)var4.next());
                  if(var5) {
                     break label27;
                  }

                  if(var5) {
                     break;
                  }
               }
            }

            var2.g();
         }

         if(var5) {
            break;
         }
      }

   }

   private void a(bu var1, eU var2) {
      boolean var7 = fj.z;
      y.c.e var3 = var2.c();
      if(var3.f()) {
         y.c.d var4 = null;
         y.c.d var5 = null;

         y.c.d var10000;
         label41: {
            while(var3.f()) {
               y.c.d var6 = var3.a();
               var10000 = var6;
               if(var7) {
                  break label41;
               }

               label37: {
                  if(var6.e()) {
                     var4 = var6;
                     if(!var7) {
                        break label37;
                     }
                  }

                  var5 = var6;
               }

               var3.g();
               if(var7) {
                  break;
               }
            }

            var10000 = var5;
         }

         aB var8 = var10000 == null?var1.i(var4):var1.i(var5);
         if(eU.b(var8) == var2) {
            eU.a(var2, var8.getSourcePoint());
            if(!var7) {
               return;
            }
         }

         if(eU.d(var8) == var2) {
            eU.a(var2, var8.getTargetPoint());
         }
      }

   }

   public y.f.ad d() {
      return new fi(this, (fg)null);
   }

   private static boolean b(y.c.c var0, y.c.d var1) {
      if(var0 == null) {
         return false;
      } else {
         Object var2 = var0.b(var1);
         return var2 == null?false:((y.f.aE)var2).a();
      }
   }

   private static fj f() {
      aZ var0 = new aZ();
      var0.setLocation(0.0D, 0.0D);
      var0.setFillColor((Color)null);
      var0.setFillColor2((Color)null);
      var0.setLineColor((Color)null);

      while(var0.labelCount() > 0) {
         var0.removeLabel(var0.getLabel(0));
      }

      var0.addPort(new eU());
      return var0;
   }

   static fj e() {
      return k;
   }

   static boolean a(y.c.c var0, y.c.d var1) {
      return b(var0, var1);
   }
}
