package y.f.i.a;

import java.util.ArrayList;
import java.util.Iterator;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.N;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.bY;
import y.f.i.a.bZ;

class bX extends K {
   boolean a;

   public void a(Z var1, I var2) {
      int var10 = ab.a;
      super.a(var1, var2);
      this.a = var1.c().i();
      if(this.a) {
         y.f.X var3 = var1.a();
         y.c.x var4 = var3.o();

         while(var4.f()) {
            y.c.q var5 = var4.e();
            y.f.aj[] var6 = var3.a_(var5);
            int var7 = 0;

            while(true) {
               if(var7 < var6.length) {
                  y.f.aj var8 = var6[var7];
                  y.d.y var9 = a(var8);
                  var2.a((y.d.y)var9, (Object)(new bZ(var8, (bY)null)));
                  ++var7;
                  if(var10 != 0) {
                     break;
                  }

                  if(var10 == 0) {
                     continue;
                  }
               }

               var4.g();
               break;
            }

            if(var10 != 0) {
               break;
            }
         }

      }
   }

   private static y.d.y a(y.f.aj var0) {
      y.d.y var1 = var0.getBox();
      return new y.d.y(var1.c() - 3.0D, var1.d() - 3.0D, var1.a() + 6.0D, var1.b() + 6.0D);
   }

   public void b(R var1) {
      int var5 = ab.a;
      if(this.a) {
         Iterator var2 = this.b().e(var1).iterator();
         ArrayList var3 = new ArrayList();

         while(var2.hasNext()) {
            N var4 = (N)var2.next();
            if(var4.b() instanceof bZ) {
               var3.add(bZ.a((bZ)var4.b()));
               if(var5 != 0) {
                  return;
               }

               if(var5 != 0) {
                  break;
               }
            }
         }

         if(var3.size() > 0) {
            var1.a(T.c, var3);
         }
      }

   }
}
