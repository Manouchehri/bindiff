package y.f.c;

import y.f.c.R;
import y.f.c.a;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;

public class g implements R, aT {
   public static final Object a = new Object();

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var12 = a.i;
      if(var1.i()) {
         return 0;
      } else {
         y.c.y[] var4;
         y.c.y var6;
         boolean var10000;
         label88: {
            var4 = null;
            y.c.c var5 = var1.c(a);
            var6 = new y.c.y();
            if(var5 != null) {
               y.c.x var7 = var1.o();

               while(var7.f()) {
                  var10000 = var5.d(var7.e());
                  if(var12) {
                     break label88;
                  }

                  if(var10000) {
                     var6.add(var7.e());
                  }

                  var7.g();
                  if(var12) {
                     break;
                  }
               }
            }

            var10000 = var6.isEmpty();
         }

         y.c.y[] var16;
         int var17;
         label75: {
            if(var10000) {
               y.c.y[] var13 = y.a.h.a(var1);
               int var8 = 0;

               while(var8 < var13.length) {
                  var16 = var13;
                  if(var12) {
                     break label75;
                  }

                  y.c.y var9 = var13[var8];
                  byte var10 = 0;
                  y.c.x var11 = var9.a();

                  label69: {
                     while(var11.f()) {
                        var17 = var11.e().b();
                        if(var12) {
                           break label69;
                        }

                        if(var17 == 0) {
                           var6.add(var11.e());
                           var10 = 1;
                        }

                        var11.g();
                        if(var12) {
                           break;
                        }
                     }

                     var17 = var10;
                  }

                  if(var17 == 0) {
                     var6.add(var9.b());
                  }

                  ++var8;
                  if(var12) {
                     break;
                  }
               }
            }

            var16 = y.a.b.a(var1, (y.c.y)var6, var2);
         }

         var4 = var16;
         var3.clear();
         y.c.e var14 = var1.p();

         while(true) {
            if(var14.f()) {
               y.c.d var15 = var14.a();
               var17 = var2.a(var15.c());
               if(var12) {
                  break;
               }

               if(var17 > var2.a(var15.d())) {
                  var3.c(var15);
                  var1.c(var15);
               }

               var14.g();
               if(!var12) {
                  continue;
               }
            }

            var17 = var4.length;
            break;
         }

         return var17;
      }
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      (new ba(this)).a(var1, var2, var3);
   }
}
