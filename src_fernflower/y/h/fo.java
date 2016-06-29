package y.h;

import java.awt.geom.Rectangle2D.Double;
import java.util.Map;
import java.util.WeakHashMap;
import y.h.aB;
import y.h.aC;
import y.h.bu;
import y.h.ch;
import y.h.eU;
import y.h.fj;
import y.h.fp;
import y.h.fq;
import y.h.fr;
import y.h.fs;
import y.h.ic;

public class fo implements fs {
   private boolean a = true;
   private WeakHashMap b = new WeakHashMap();

   public boolean a() {
      return this.a;
   }

   public void a(y.c.q var1) {
      fr var2 = this.b();
      this.b.put(var1, var2);
      this.d(var1);
   }

   public void b(y.c.q var1) {
      fr var2 = (fr)this.b.get(var1);
      if(var2 != null) {
         y.c.f var3 = new y.c.f(fr.a(var2).keySet().iterator());
         this.a(var3, var1);
         fr.a(var2).clear();
         this.b.remove(var1);
      }
   }

   protected y.c.f c(y.c.q var1) {
      y.h.a.v var2 = y.h.a.v.a(var1.e());
      if(var2 != null && !var2.l(var1)) {
         boolean var3 = var2.k(var1);
         return var3?this.a(var1, var1.e()):this.e(var1);
      } else {
         return new y.c.f();
      }
   }

   protected void a(y.c.d var1, y.c.q var2) {
      this.c(var1, var2);
   }

   protected void b(y.c.d var1, y.c.q var2) {
      if(var1.a() != null) {
         this.d(var1, var2);
      }

   }

   private void d(y.c.q var1) {
      boolean var5 = fj.z;
      y.c.f var2 = this.c(var1);
      y.c.e var3 = var2.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         this.a(var4, var1);
         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private void a(y.c.f var1, y.c.q var2) {
      boolean var5 = fj.z;
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         this.b(var4, var2);
         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private void a(y.c.q var1, y.h.a.v var2, y.c.y var3, boolean[] var4) {
      boolean var7 = fj.z;
      var3.add(var1);
      if(var2.k(var1)) {
         y.c.x var5 = var2.p(var1);

         while(var5.f()) {
            y.c.q var6 = var5.e();
            var4[var6.d()] = true;
            this.a(var6, var2, var3, var4);
            var5.g();
            if(var7) {
               break;
            }
         }
      }

   }

   protected boolean a(y.c.d var1, bu var2) {
      y.c.c var3 = a(var2);
      return var3 != null && var3.d(var1);
   }

   private y.c.f a(y.c.q var1, y.c.i var2) {
      boolean var11 = fj.z;
      y.h.a.v var3 = y.h.a.v.a(var2);
      y.c.y var4 = new y.c.y();
      boolean[] var5 = new boolean[var2.e()];
      this.a(var1, var3, var4, var5);
      y.c.f var6 = new y.c.f();
      y.c.x var7 = var4.a();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         y.c.q var10000 = var8;

         label33:
         while(true) {
            y.c.e var9 = var10000.j();

            while(true) {
               if(!var9.f()) {
                  break label33;
               }

               y.c.d var10 = var9.a();
               var10000 = var8;
               if(var11) {
                  break;
               }

               if(var8 == var1 || !var5[var10.a(var8).d()]) {
                  var6.add(var10);
               }

               var9.g();
               if(var11) {
                  break label33;
               }
            }
         }

         var7.g();
         if(var11) {
            break;
         }
      }

      return var6;
   }

   private static y.c.c a(bu var0) {
      y.c.c var1 = var0.c(aC.ORTHOGONAL_ROUTING_DPKEY);
      if(var1 == null && var0.C() != null && var0.C().g() != var0) {
         var1 = var0.C().g().c(aC.ORTHOGONAL_ROUTING_DPKEY);
      }

      return var1;
   }

   private y.c.f e(y.c.q var1) {
      return new y.c.f(var1.j());
   }

   private fr b() {
      return new fr((fp)null);
   }

   private fr f(y.c.q var1) {
      if(this.b.containsKey(var1)) {
         return (fr)this.b.get(var1);
      } else {
         fr var2 = this.b();
         this.b.put(var1, var2);
         return var2;
      }
   }

   private void c(y.c.d var1, y.c.q var2) {
      fr var3 = this.f(var2);
      bu var4 = (bu)var1.a();
      y.d.t var5 = var4.p(var1);
      y.d.t var6 = var4.q(var1);
      y.d.t var7 = var4.l(var2);
      double var8 = var4.p(var2) / 2.0D;
      double var10 = var4.q(var2) / 2.0D;
      y.d.t var12 = new y.d.t(var8 == 0.0D?0.0D:(var5.a() - var7.a()) / var8, var10 == 0.0D?0.0D:(var5.b() - var7.b()) / var10);
      y.d.t var13 = new y.d.t(var8 == 0.0D?0.0D:(var6.a() - var7.a()) / var8, var10 == 0.0D?0.0D:(var6.b() - var7.b()) / var10);
      boolean var14 = this.a(var1, var4);
      byte var15 = 3;
      byte var16 = 3;
      if(var14) {
         aB var17 = var4.i(var1);
         if(var1.c() == var2) {
            var15 = ic.a((ch)null, var17, true, (byte)0);
         }

         if(var1.d() == var2) {
            var16 = ic.a((ch)null, var17, false, (byte)0);
         }
      }

      fq var22 = new fq(var14, var15, var16, new y.f.u(var4.g(var1)), var1.c(), var1.d());
      var22.g = var12;
      var22.h = var13;
      if(this.a()) {
         y.h.a.v var18 = var4.C();
         if(var18 != null) {
            label82: {
               if(var18.k(var2)) {
                  boolean var19 = var18.n(var1.c()) == var2;
                  boolean var20 = var18.n(var1.d()) == var2;
                  if(!(var19 ^ var20)) {
                     break label82;
                  }

                  eU var21;
                  if(var19) {
                     var21 = eU.b(var4.i(var1));
                     if(var21 != null && a(var21, var4.t(var1.c()))) {
                        var22.i = var21;
                     }
                  }

                  if(!var20) {
                     break label82;
                  }

                  var21 = eU.d(var4.i(var1));
                  if(var21 == null || !a(var21, var4.t(var1.d()))) {
                     break label82;
                  }

                  var22.j = var21;
                  if(!fj.z) {
                     break label82;
                  }
               }

               if(var18.j(var2) && var18.e(var1)) {
                  if(var1.c() == var2) {
                     var22.i = a(var18, var1, var2, true);
                  }

                  if(var1.d() == var2) {
                     var22.j = a(var18, var1, var2, false);
                  }
               }
            }
         }
      }

      var3.a().put(var1, var22);
   }

   private static boolean a(eU var0, fj var1) {
      return eU.a(var0, var1);
   }

   private static eU a(y.h.a.v var0, y.c.d var1, y.c.q var2, boolean var3) {
      String var4 = var3?"HierarchyManager.InterEdgeData.SOURCE_PORT":"HierarchyManager.InterEdgeData.TARGET_PORT";
      Map var5 = (Map)a(var0, var1, var4);
      if(var5 != null && !var5.isEmpty()) {
         y.c.q var6 = var3?var0.b(var1):var0.c(var1);
         y.c.q var7;
         if(var6 == var2) {
            var7 = var6;
            if(!fj.z) {
               return (eU)var5.get(var7);
            }
         }

         y.c.i var8 = var0.m(var2);
         var7 = var0.a(var6, var8);
         return (eU)var5.get(var7);
      } else {
         return null;
      }
   }

   private void d(y.c.d var1, y.c.q var2) {
      boolean var47 = fj.z;
      fr var3 = (fr)this.b.get(var2);
      fq var4 = (fq)var3.a().get(var1);
      if(var4 != null) {
         y.c.i var5 = var2.e();
         if(var5 instanceof bu) {
            bu var6;
            y.c.q var8;
            y.f.I var9;
            y.d.t var10;
            y.d.t var11;
            double var32;
            double var34;
            y.d.t var36;
            y.f.am var39;
            label105: {
               var6 = (bu)var5;
               y.c.q var7 = var1.c();
               var8 = var1.d();
               var9 = var4.d;
               var10 = var9.getSourcePoint();
               var11 = var9.getTargetPoint();
               double var12 = var4.g.a();
               double var14 = var4.g.b();
               double var16 = var4.h.a();
               double var18 = var4.h.b();
               double var20 = var12 * var6.p(var2) / 2.0D;
               double var22 = var14 * var6.q(var2) / 2.0D;
               double var24 = var16 * var6.p(var2) / 2.0D;
               double var26 = var18 * var6.q(var2) / 2.0D;
               double var28 = var6.j(var2) + var20;
               double var30 = var6.k(var2) + var22;
               var32 = var6.j(var2) + var24;
               var34 = var6.k(var2) + var26;
               y.f.am var38 = var6.a((Object)var7);
               var39 = var6.a((Object)var8);
               if((new Double(var38.getX() - 1.0D, var38.getY() - 1.0D, var38.getWidth() + 2.0D, var38.getHeight() + 2.0D)).contains(var28, var30)) {
                  var36 = new y.d.t(var28, var30);
                  if(!var47) {
                     break label105;
                  }
               }

               var36 = var6.l(var7);
            }

            y.d.t var37;
            label100: {
               if((new Double(var39.getX() - 1.0D, var39.getY() - 1.0D, var39.getWidth() + 2.0D, var39.getHeight() + 2.0D)).contains(var32, var34)) {
                  var37 = new y.d.t(var32, var34);
                  if(!var47) {
                     break label100;
                  }
               }

               var37 = var6.l(var8);
            }

            var6.a((new y.c.f(var1)).a());
            aB var40 = var6.i(var1);
            var40.clearBends();
            int var41 = 0;

            while(true) {
               if(var41 < var9.pointCount()) {
                  y.d.t var42 = var9.getPoint(var41);
                  var40.addPoint(var42.a(), var42.b());
                  ++var41;
                  if(var47) {
                     break;
                  }

                  if(!var47) {
                     continue;
                  }
               }

               var41 = this.a(var1, var2, true);
               break;
            }

            boolean var48;
            label86: {
               var48 = this.a(var1, var2, false);
               if(var41 != 0) {
                  var6.c(var1, var36);
                  if(!var47) {
                     break label86;
                  }
               }

               var40.setSourcePoint(var10);
            }

            label81: {
               if(var48) {
                  var6.d(var1, var37);
                  if(!var47) {
                     break label81;
                  }
               }

               var40.setTargetPoint(var11);
            }

            if(var4.a) {
               if(var41 != 0) {
                  ic.a((ch)null, var40, true, var4.b);
               }

               if(var48) {
                  ic.a((ch)null, var40, false, var4.c);
               }
            }

            if(this.a()) {
               y.h.a.v var43 = var6.C();
               if(var43 != null) {
                  if(var43.j(var2) && var43.e(var1)) {
                     if(var41 != 0) {
                        a(var43, var1, var4, true);
                        var4.i = null;
                     }

                     if(!var48) {
                        return;
                     }

                     a(var43, var1, var4, false);
                     var4.j = null;
                     if(!var47) {
                        return;
                     }
                  }

                  if(var43.k(var2)) {
                     boolean var44 = var43.n(var1.c()) == var2;
                     boolean var45 = var43.n(var1.d()) == var2;
                     if(var44 ^ var45) {
                        aB var46 = var6.i(var1);
                        if(var44) {
                           eU.a(var4.i, var46);
                        }

                        if(var45) {
                           eU.b(var4.j, var46);
                        }
                     }
                  }
               }
            }

         }
      }
   }

   private static void a(y.h.a.v var0, y.c.d var1, fq var2, boolean var3) {
      y.c.q var4 = var3?var2.e:var2.f;
      eU var5 = var3?var2.i:var2.j;
      String var6 = var3?"HierarchyManager.InterEdgeData.SOURCE_PORT":"HierarchyManager.InterEdgeData.TARGET_PORT";
      Object var7 = (Map)a(var0, var1, var6);
      if(var7 == null) {
         var7 = new WeakHashMap();
         a(var0, var1, var6, var7);
      }

      ((Map)var7).put(var4, var5);
   }

   private static Object a(y.h.a.v var0, y.c.d var1, String var2) {
      return var0.d(var1).a(var2);
   }

   private static void a(y.h.a.v var0, y.c.d var1, String var2, Object var3) {
      var0.d(var1).a(var2, var3);
   }

   protected boolean a(y.c.d var1, y.c.q var2, boolean var3) {
      fr var4 = (fr)this.b.get(var2);
      if(var4 == null) {
         return false;
      } else {
         fq var5 = (fq)var4.a().get(var1);
         return var5 == null?false:(var3?var5.e == var2 || var5.e != var1.c():var5.f == var2 || var5.f != var1.d());
      }
   }
}
