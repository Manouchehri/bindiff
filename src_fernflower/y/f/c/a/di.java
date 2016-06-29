package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.Z;
import y.f.c.a.aQ;
import y.f.c.a.aT;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.c.a.dj;
import y.f.c.a.dl;
import y.f.c.a.dn;

class di implements y.f.c.R {
   private aT a;

   public di(aT var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.a = var1;
      }
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var12 = N.x;
      y.c.A var4 = y.g.M.a();
      y.c.h var5 = y.g.M.b();
      dl var6 = new dl(var4, var5);
      y.c.x var7 = var1.o();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         dj var9 = new dj((aY)null, (bK)null, (Z)null);
         var4.a(var8, var9);
         var7.g();
         if(var12) {
            break;
         }
      }

      dn var13 = new dn(var6);
      this.a.a(var1, var13, var6);
      int var14 = 0;

      while(true) {
         if(var14 < var13.b()) {
            aQ var16 = var13.a(var14);
            if(var12) {
               break;
            }

            y.c.x var10 = var16.d().a();

            label48: {
               while(var10.f()) {
                  y.c.q var11 = var10.e();
                  var2.a(var11, var14);
                  var10.g();
                  if(var12) {
                     break label48;
                  }

                  if(var12) {
                     break;
                  }
               }

               ++var14;
            }

            if(!var12) {
               continue;
            }
         }

         var3.clear();
         break;
      }

      y.c.e var15 = var1.p();

      int var10000;
      while(true) {
         if(var15.f()) {
            y.c.d var17 = var15.a();
            var10000 = var2.a(var17.c());
            if(var12) {
               break;
            }

            if(var10000 > var2.a(var17.d())) {
               var1.c(var17);
               var3.add(var17);
            }

            var15.g();
            if(!var12) {
               continue;
            }
         }

         var10000 = var13.b();
         break;
      }

      return var10000;
   }
}
