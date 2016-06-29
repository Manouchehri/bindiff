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
import y.f.i.a.bq;
import y.f.i.a.br;
import y.f.i.a.y;

class bp extends K {
   boolean a;

   public void a(Z var1, I var2) {
      int var11 = ab.a;
      super.a(var1, var2);
      y var3 = var1.c();
      this.a = var3.j();
      if(this.a) {
         y.f.X var4 = var1.a();
         y.c.e var5 = var4.p();

         while(var5.f()) {
            label32: {
               y.c.d var6 = var5.a();
               if(!var3.a((y.c.d)var6, (y.c.i)var4)) {
                  y.f.C[] var7 = var4.d(var6);
                  int var8 = 0;

                  while(var8 < var7.length) {
                     y.f.C var9 = var7[var8];
                     y.d.y var10 = a(var9);
                     var2.a((y.d.y)var10, (Object)(new br(var9, (bq)null)));
                     ++var8;
                     if(var11 != 0) {
                        break label32;
                     }

                     if(var11 != 0) {
                        break;
                     }
                  }
               }

               var5.g();
            }

            if(var11 != 0) {
               break;
            }
         }

      }
   }

   private static y.d.y a(y.f.C var0) {
      y.d.y var1 = var0.getBox();
      return new y.d.y(var1.c() - 3.0D, var1.d() - 3.0D, var1.a() + 6.0D, var1.b() + 6.0D);
   }

   public void b(R var1) {
      int var5 = ab.a;
      if(this.a) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.b().e(var1).iterator();

         while(true) {
            if(var3.hasNext()) {
               N var4 = (N)var3.next();
               if(!(var4.b() instanceof br)) {
                  continue;
               }

               var2.add(br.a((br)var4.b()));
               if(var5 != 0) {
                  break;
               }

               if(var5 == 0) {
                  continue;
               }
            }

            if(var2.size() > 0) {
               var1.a(T.d, var2);
            }
            break;
         }

      }
   }
}
