package y.f.k;

import y.f.aE;
import y.f.k.A;
import y.f.k.I;
import y.f.k.K;
import y.f.k.P;
import y.f.k.X;
import y.f.k.d;
import y.f.k.l;
import y.f.k.x;

public class H implements I {
   public K a(x var1, y.f.X var2, y.c.q var3) {
      return null;
   }

   public void a(y.c.q var1, y.c.b var2) {
   }

   public A a(y.c.c var1, y.c.c var2, y.f.X var3, y.c.q var4, byte var5) {
      P var7;
      X var8;
      aE var10;
      int var11;
      label78: {
         var11 = d.g;
         A var6 = (A)var1.b(var4);
         var7 = new P(l.a, var6);
         var8 = new X(var7, var7);
         var7.h();
         y.c.d var9 = var4.g();
         if(var9 == null) {
            var10 = aE.a((byte)0);
            if(var11 == 0) {
               break label78;
            }
         }

         var10 = aE.e(var3, var9);
         if(var10 == null) {
            var10 = aE.a((byte)0);
         }
      }

      label81: {
         label82: {
            switch(var5) {
            case 0:
               switch(var10.b()) {
               case 1:
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  if(var11 == 0) {
                     break;
                  }
               case 4:
                  var8.a(0, true);
                  if(var11 == 0) {
                     break;
                  }
               case 8:
                  var8.b(0, true);
                  if(var11 == 0) {
                     break;
                  }
               case 2:
                  var8.d(0, true);
                  var8.a(0, true);
               }

               var8.d(1);
               if(var11 == 0) {
                  break label81;
               }
            case 1:
               switch(var10.b()) {
               case 1:
                  var8.c(0, true);
                  if(var11 == 0) {
                     break;
                  }
               case 2:
                  var8.d(0, true);
                  if(var11 == 0) {
                     break;
                  }
               case 3:
               case 4:
               case 5:
               case 6:
               case 7:
               default:
                  if(var11 == 0) {
                     break;
                  }
               case 8:
                  var8.b(0, true);
                  var8.c(0, true);
               }

               var8.b(1);
               if(var11 == 0) {
                  break label81;
               }
            case 2:
               break;
            case 3:
               break label82;
            default:
               break label81;
            }

            switch(var10.b()) {
            case 1:
               var8.c(0, true);
               var8.b(1, true);
               if(var11 == 0) {
                  break;
               }
            case 4:
               var8.a(0, true);
               if(var11 == 0) {
                  break;
               }
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               if(var11 == 0) {
                  break;
               }
            case 8:
               var8.b(0, true);
            }

            var8.e(1);
            if(var11 == 0) {
               break label81;
            }
         }

         switch(var10.b()) {
         case 1:
            var8.c(0, true);
            if(var11 == 0) {
               break;
            }
         case 4:
            var8.a(0, true);
            var8.c(0, true);
            if(var11 == 0) {
               break;
            }
         case 2:
            var8.d(0, true);
         case 3:
         case 5:
         case 6:
         case 7:
         case 8:
         }

         var8.c(1);
      }

      var7.h();
      var7.j();
      return var7.i();
   }
}
