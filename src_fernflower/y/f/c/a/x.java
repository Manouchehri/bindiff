package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aS;
import y.f.c.a.aU;
import y.f.c.a.aV;

public class x implements aS {
   private byte a;

   public x() {
      this((byte)18);
   }

   public x(byte var1) {
      this.a = var1;
   }

   public byte a() {
      return this.a;
   }

   public void a(y.f.X var1, aV var2, aU var3, aU var4) {
      boolean var7 = N.x;
      byte var5 = this.a();
      boolean var6 = (var5 & 3) != 3;
      switch(this.a()) {
      case 0:
      default:
         this.a(var3, var4, var4.b(), true);
         if(!var7) {
            break;
         }
      case 1:
         this.a(var3, var4, -var3.b(), true);
         if(!var7) {
            break;
         }
      case 18:
      case 19:
         this.a(var3, var4, 0, var6);
         if(!var7) {
            break;
         }
      case 34:
      case 35:
         this.a(var3, var4, var4.b() - var3.b(), var6);
         if(!var7) {
            break;
         }
      case 66:
      case 67:
         this.a(var3, var4, (var4.b() - var3.b()) / 2, var6);
      }

   }

   private void a(aU var1, aU var2, int var3, boolean var4) {
      boolean var14 = N.x;
      int var5 = 0;

      while(var3 < 0) {
         var2.a(var1.a(var5).e(), 0);
         ++var5;
         ++var3;
         if(var14) {
            break;
         }
      }

      int var6 = 0;

      label60:
      while(var6 < var1.b()) {
         aQ var7 = var1.a(var6);
         int var8 = var6 + var3;

         while(var2.b() <= var8) {
            var2.a(var7.e(), var2.b());
            if(var14) {
               continue label60;
            }

            if(var14) {
               break;
            }
         }

         label50: {
            label73: {
               aQ var9 = var2.a(var8);
               if(var4) {
                  y.c.p var10 = var7.d().k();

                  do {
                     if(var10 == null) {
                        break label73;
                     }

                     y.c.q var11 = (y.c.q)var10.c();
                     var9.a(var11);
                     var10 = var10.a();
                     if(var14) {
                        break label50;
                     }
                  } while(!var14);
               }

               y.c.y var15 = var9.d();
               y.c.p var16 = var7.d().l();

               while(var16 != null) {
                  y.c.q var12 = (y.c.q)var16.c();
                  var9.a(var12);
                  y.c.p var13 = var15.l();
                  var15.h(var13);
                  var15.b(var13);
                  var16 = var16.b();
                  if(var14) {
                     break label50;
                  }

                  if(var14) {
                     break;
                  }
               }
            }

            ++var6;
         }

         if(var14) {
            break;
         }
      }

   }
}
