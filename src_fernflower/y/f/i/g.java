package y.f.i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.f.i.h;
import y.f.i.v;

public class g extends y.f.a {
   public static final Object a = "CollinearBendHider#SELECTED_EDGES";

   public g(y.f.ah var1) {
      super(var1);
   }

   public void c(y.f.X var1) {
      int var14 = v.f;
      ArrayList var2 = new ArrayList();
      y.c.c var3 = var1.c(a);
      y.c.e var4 = var1.p();

      y.c.D var6;
      y.d.t var9;
      y.d.t var13;
      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            if(var14 != 0) {
               break;
            }

            if(var3 == null || var3.d(var5)) {
               var6 = var1.m(var5);
               y.c.p var7 = var6.k();
               y.d.t var8 = (y.d.t)var7.c();
               var7 = var7.a();
               var9 = (y.d.t)var7.c();
               int var10 = 1;
               int var11 = var6.size();
               h var12 = new h(var5, var10);
               var7 = var7.a();

               boolean var10000;
               while(true) {
                  if(var7 != null) {
                     var13 = (y.d.t)var7.c();
                     var10000 = y.d.e.d(var8, var13, var9);
                     if(var14 != 0) {
                        break;
                     }

                     label90: {
                        if(var10000) {
                           var12.c.add(new Double(var8.a(var9)));
                           var6.h(var7.b());
                           var9 = var13;
                           if(var14 == 0) {
                              break label90;
                           }
                        }

                        this.a(var8, var9, var12, var2);
                        var12 = new h(var5, var10 + 1);
                        var8 = var9;
                        var9 = var13;
                     }

                     var7 = var7.a();
                     ++var10;
                     if(var14 == 0) {
                        continue;
                     }
                  }

                  var10000 = var12.c.isEmpty();
                  break;
               }

               if(!var10000) {
                  this.a(var8, var9, var12, var2);
               }

               if(var6.size() < var11) {
                  var1.a(var5, var6);
               }
            }

            var4.g();
            if(var14 == 0) {
               continue;
            }
         }

         this.a().c(var1);
         break;
      }

      Iterator var15 = var2.iterator();

      while(true) {
         int var22 = var15.hasNext();

         h var16;
         y.d.t var17;
         y.c.p var18;
         label71:
         while(true) {
            if(var22 == 0) {
               return;
            }

            var16 = (h)var15.next();
            var6 = var1.m(var16.a);
            var17 = (y.d.t)var6.f();
            var18 = var6.k();
            int var19 = var16.b;

            while(true) {
               if(var18 == null) {
                  break label71;
               }

               var22 = var19;
               if(var14 != 0) {
                  break;
               }

               if(var19 <= 0) {
                  break label71;
               }

               if(var19 == 1) {
                  var17 = (y.d.t)var18.c();
               }

               var18 = var18.a();
               --var19;
               if(var14 != 0) {
                  break label71;
               }
            }
         }

         if(var18 != null) {
            var9 = (y.d.t)var18.c();
            Iterator var20 = var16.c.iterator();

            while(true) {
               if(var20.hasNext()) {
                  double var21 = ((Double)var20.next()).doubleValue();
                  var13 = new y.d.t(var17.a + var21 * (var9.a - var17.a), var17.b + var21 * (var9.b - var17.b));
                  var6.a((Object)var13, (y.c.p)var18);
                  if(var14 != 0) {
                     break;
                  }

                  if(var14 == 0) {
                     continue;
                  }
               }

               var1.a(var16.a, var6);
               break;
            }

            if(var14 != 0) {
               return;
            }
         }
      }
   }

   private void a(y.d.t var1, y.d.t var2, h var3, List var4) {
      if(!var3.a()) {
         var3.a(var1, var2);
         var4.add(var3);
      }
   }
}
