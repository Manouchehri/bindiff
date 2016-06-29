package y.f.i.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.bT;
import y.f.i.a.bU;
import y.f.i.a.bV;
import y.f.i.a.bc;
import y.f.i.a.v;
import y.f.i.a.y;

class bS extends K {
   private HashMap a;
   private List b;

   public void a() {
      super.a();
      this.a = null;
      this.b = null;
   }

   public void a(R var1, List var2) {
      int var13 = ab.a;
      List var3 = (List)this.a.get(var1);
      if(var3 != null) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            bU var5 = (bU)var4.next();
            y.c.d var6 = bU.a(var5);
            R var7 = null;
            int var9 = 0;
            int var10 = 0;

            R var10000;
            while(true) {
               if(var10 < bU.b(var5).length) {
                  label60: {
                     y.d.m var8 = bU.b(var5)[var10];
                     var10000 = var7;
                     if(var13 != 0) {
                        break;
                     }

                     label45: {
                        label44: {
                           if(var7 != null && !var7.g().a(var8.d())) {
                              int var11 = var10 - var9 + 1;
                              bU var12 = this.a(var6, var5, var9, var11);
                              this.a(var7, var12);
                              if(var13 == 0) {
                                 break label44;
                              }
                           }

                           if(var7 != null) {
                              break label45;
                           }
                        }

                        var7 = this.a(var2, var8, var7, bU.c(var5) + var10, var6);
                        var9 = var10;
                        if(var7 == null) {
                           break label60;
                        }
                     }

                     ++var10;
                     if(var13 == 0) {
                        continue;
                     }
                  }
               }

               var10000 = var7;
               break;
            }

            if(var10000 != null) {
               this.a(var7, this.a(var6, var5, var9, bU.b(var5).length - var9));
               if(var13 != 0) {
                  return;
               }

               if(var13 != 0) {
                  break;
               }
            }
         }

         this.a.remove(var1);
      }

   }

   private bU a(y.c.d var1, bU var2, int var3, int var4) {
      y.d.m[] var5 = new y.d.m[var4];
      System.arraycopy(bU.b(var2), var3, var5, 0, var4);
      return new bU(var1, var5, bU.c(var2) + var3, (bT)null);
   }

   private R a(List var1, y.d.m var2, R var3, int var4, y.c.d var5) {
      int var10 = ab.a;
      R var6 = null;
      List var7 = this.a(var1, var2);
      Iterator var8 = var7.iterator();

      while(var8.hasNext()) {
         R var9 = (R)var8.next();
         if(var9.g().a(var2.d())) {
            var6 = var9;
            if(var10 == 0) {
               continue;
            }
         }

         if(var9 != var3) {
            this.a(var9, new bU(var5, new y.d.m[]{var2}, var4, (bT)null));
            if(var10 != 0) {
               break;
            }
         }
      }

      return var6;
   }

   private void a(R var1, bU var2) {
      Object var3 = (List)this.a.get(var1);
      if(var3 == null) {
         var3 = new ArrayList();
         this.a.put(var1, var3);
      }

      ((List)var3).add(var2);
   }

   private List a(List var1, y.d.m var2) {
      int var6 = ab.a;
      ArrayList var3 = new ArrayList();
      Iterator var4 = var1.iterator();

      ArrayList var10000;
      while(true) {
         if(var4.hasNext()) {
            R var5 = (R)var4.next();
            if(!var2.a(var5.g())) {
               continue;
            }

            var10000 = var3;
            if(var6 != 0) {
               break;
            }

            var3.add(var5);
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public void b(R var1) {
      int var12 = ab.a;
      List var2 = (List)this.a.get(var1);
      if(var2 != null && var2.size() > 0) {
         bc var3 = var1.b();
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            bU var5 = (bU)var4.next();
            y.d.y var6 = var1.g();
            y.d.t var7 = bU.b(var5)[0].c();
            y.d.t var8 = bU.b(var5)[bU.b(var5).length - 1].d();
            bV var9 = this.a(var6, var7, true);
            bV var10 = this.a(var6, var8, false);
            v var11 = new v(bU.a(var5), var1, var9.a, var10.a, var9.b, var10.b, bU.c(var5));
            var3.a(var11);
            if(var12 != 0) {
               break;
            }
         }
      }

   }

   private bV a(y.d.y var1, y.d.t var2, boolean var3) {
      double var4 = var1.c();
      double var6 = var4 + var1.a();
      double var8 = var1.d();
      double var10 = var8 + var1.b();
      double var12 = var2.a();
      double var14 = var2.b();
      return var12 < var4 + 1.0E-6D?new bV(var3?y.f.y.b:y.f.y.d, new P(var14, var14, var4, true), (bT)null):(var12 > var6 - 1.0E-6D?new bV(var3?y.f.y.d:y.f.y.b, new P(var14, var14, var6, true), (bT)null):(var14 < var8 + 1.0E-6D?new bV(var3?y.f.y.c:y.f.y.a, new P(var12, var12, var8, false), (bT)null):(var14 > var10 - 1.0E-6D?new bV(var3?y.f.y.a:y.f.y.c, new P(var12, var12, var10, false), (bT)null):new bV((y.f.y)null, (P)null, (bT)null))));
   }

   public void a(R var1) {
      if(this.b != null) {
         this.a.put(var1, this.b);
         this.b = null;
      }

   }

   public void a(Z var1, I var2) {
      int var11 = ab.a;
      super.a(var1, var2);
      y.f.X var3 = var1.a();
      this.a = new HashMap();
      y var4 = var1.c();
      y.c.c var5 = var3.c(var4.h());
      if(var4.f() != 0 && var5 != null) {
         this.b = new y.c.D();
         y.c.e var6 = var3.p();

         do {
            boolean var10000 = var6.f();

            label40:
            while(true) {
               if(!var10000) {
                  return;
               }

               y.c.d var7 = var6.a();
               if(var5.d(var7)) {
                  break;
               }

               y.d.s var8 = var3.l(var7).j();
               if(y.b(var7, var3)) {
                  y.d.m[] var9 = y.c(var7, var3);
                  this.b.add(new bU(var7, var9, 0, (bT)null));
                  if(var11 == 0) {
                     break;
                  }
               }

               int var12 = 0;

               while(true) {
                  if(!var8.f()) {
                     break label40;
                  }

                  y.d.m var10 = var8.a();
                  var10000 = this.a(var10);
                  if(var11 != 0) {
                     break;
                  }

                  if(var10000) {
                     this.b.add(new bU(var7, new y.d.m[]{var10}, var12, (bT)null));
                  }

                  var8.g();
                  ++var12;
                  if(var11 != 0) {
                     break label40;
                  }
               }
            }

            var6.g();
         } while(var11 == 0);

      }
   }

   private boolean a(y.d.m var1) {
      return var1.b() || var1.a();
   }
}
