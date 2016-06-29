package y.h.a;

import y.h.a.t;
import y.h.a.v;
import y.h.a.z;

class B implements y.c.o {
   private final v a;

   B(v var1) {
      this.a = var1;
   }

   public void onGraphEvent(y.c.l var1) {
      int var13 = v.a;
      y.c.q var2;
      y.c.q var3;
      y.c.q var5;
      y.c.i var15;
      switch(var1.a()) {
      case 1:
      case 4:
      case 5:
      case 7:
      case 8:
      case 9:
      case 10:
      default:
         break;
      case 12:
         this.a.a(new t(this.a, (byte)10, (y.c.i)null, (Object)null));
         if(var13 == 0) {
            break;
         }
      case 13:
         this.a.a(new t(this.a, (byte)11, (y.c.i)null, (Object)null));
         if(var13 == 0) {
            break;
         }
      case 2:
         var2 = (y.c.q)var1.b();
         if(this.a.k(var2)) {
            this.a.b(new y.c.y(this.a.p(var2)));
            this.a.g(var2);
         }

         var3 = this.a.n(var2);
         if(this.a.k(var3)) {
            this.a.c(new y.c.y(var2), this.a.e(var1.c()));
         }

         z var4 = v.a(this.a, var1.c());
         var4.b((y.c.q)var1.b());
         this.a.a(new t(this.a, (byte)1, var1.c(), var1.b()));
         if(var13 == 0) {
            break;
         }
      case 3:
         var2 = (y.c.q)var1.b();
         var3 = (y.c.q)v.b(this.a).get(var2);
         v.c(this.a).a(var3);
         v.b(this.a).remove(var2);
         if(var13 == 0) {
            break;
         }
      case 0:
      case 6:
         var2 = (y.c.q)var1.b();
         var15 = var1.c();
         y.c.q var16 = (y.c.q)v.d(this.a).get(var15);
         var5 = v.c(this.a).d();
         v.b(this.a).put(var2, var5);
         v.e(this.a).a(var5, var2);
         v.c(this.a).a(var5, var16);
         this.a.a(new t(this.a, (byte)0, var1.c(), var1.b()));
         if(var13 == 0) {
            break;
         }
      case 11:
         y.c.y var14 = (y.c.y)var1.b();
         if(var14.size() > 0) {
            var15 = var14.b().e();
            y.c.i var17 = var1.c();
            var5 = this.a.e(var15);
            y.c.q var6 = this.a.e(var17);
            y.c.q var7;
            y.c.y var8;
            y.c.x var9;
            y.c.q var10;
            y.c.q var11;
            y.c.d var12;
            v var10000;
            if(this.a.b(var6, var5)) {
               var7 = v.a(this.a, var5);
               var8 = v.a(this.a, var14);
               var9 = var8.a();

               label71: {
                  while(var9.f()) {
                     var10 = var9.e();
                     var11 = v.a(this.a, var10);
                     var12 = var11.f();
                     var10000 = this.a;
                     if(var13 != 0) {
                        break label71;
                     }

                     label67: {
                        if(var10000.j(var10)) {
                           v.c(this.a).a(var12, var11, (y.c.d)null, 1, var7, var7.g(), 1);
                           if(var13 == 0) {
                              break label67;
                           }
                        }

                        v.c(this.a).a(var12, var11, (y.c.d)null, 1, var7, var7.i(), 0);
                     }

                     var9.g();
                     if(var13 != 0) {
                        break;
                     }
                  }

                  var10000 = this.a;
               }

               var10000.a(new t(this.a, (byte)3, v.c(this.a, v.b(this.a, var7)), var8));
               if(var13 == 0) {
                  return;
               }
            }

            var7 = v.a(this.a, this.a.n(var6));
            var8 = v.a(this.a, var14);
            var9 = var8.a();

            label53: {
               while(var9.f()) {
                  var10 = var9.e();
                  var11 = v.a(this.a, var10);
                  var12 = var11.f();
                  var10000 = this.a;
                  if(var13 != 0) {
                     break label53;
                  }

                  label95: {
                     if(var10000.j(var10) || this.a.k(var10)) {
                        v.c(this.a).a(var12, var11, (y.c.d)null, 1, var7, var7.g(), 1);
                        if(var13 == 0) {
                           break label95;
                        }
                     }

                     v.c(this.a).a(var12, var11, (y.c.d)null, 1, var7, var7.i(), 0);
                  }

                  var9.g();
                  if(var13 != 0) {
                     break;
                  }
               }

               var10000 = this.a;
            }

            var10000.a(new t(this.a, (byte)3, var17, var8));
         }
      }

   }
}
