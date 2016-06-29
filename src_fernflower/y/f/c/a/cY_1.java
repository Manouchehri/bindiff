package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;

final class cY implements Comparator {
   private final float[] a;

   public cY(y.f.X var1, aU var2, aV var3) {
      boolean var13 = N.x;
      super();
      this.a = new float[var1.h()];
      int var4 = 0;

      while(var4 < var2.b()) {
         aQ var5 = var2.a(var4);
         int var6 = 0;
         y.c.p var7 = var5.d().k();

         label58:
         while(true) {
            if(var7 != null) {
               Object var10000 = var7.c();

               label53:
               while(true) {
                  y.c.q var8 = (y.c.q)var10000;
                  if(var13) {
                     break label58;
                  }

                  y.c.d var9 = var8.f();

                  while(true) {
                     if(var9 == null) {
                        break label53;
                     }

                     y.f.aE var10 = var3.a(var9).c();
                     y.d.t var12 = var1.n(var9);
                     var10000 = var10;
                     if(var13) {
                        break;
                     }

                     float var11;
                     label69: {
                        if(var10 == null || var10.g()) {
                           var11 = (float)(var12.a / 10000.0D);
                           if(!var13) {
                              break label69;
                           }
                        }

                        switch(var10.b()) {
                        case 4:
                           var11 = 0.3F - (float)(var12.b / 10000.0D);
                           if(!var13) {
                              break;
                           }
                        case 8:
                           var11 = -0.3F + (float)(var12.b / 10000.0D);
                           if(!var13) {
                              break;
                           }
                        case 1:
                        case 2:
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        default:
                           var11 = (float)(var12.a / 10000.0D);
                        }
                     }

                     this.a[var9.b()] = (float)var6 + var11;
                     var9 = var9.g();
                     if(var13) {
                        break label53;
                     }
                  }
               }

               var7 = var7.a();
               ++var6;
               if(!var13) {
                  continue;
               }
            }

            ++var4;
            break;
         }

         if(var13) {
            break;
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a[((y.c.d)var1).b()], this.a[((y.c.d)var2).b()]);
   }
}
