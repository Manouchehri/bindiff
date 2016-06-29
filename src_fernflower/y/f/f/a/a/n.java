package y.f.f.a.a;

import y.c.C;
import y.c.D;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.m;
import y.f.f.a.a.o;

public class n {
   public static boolean a(e var0, e var1) {
      return !var0.e() && !var1.e()?var0.c() == var1.c():false;
   }

   public static e[] b(e var0, e var1) {
      boolean var5 = f.e;
      if(!var0.e() && !var1.e()) {
         e var2 = var0;
         e var3 = var1;

         label42: {
            label41:
            while(true) {
               if(var2.b() > var3.b()) {
                  var2 = var2.c();
                  if(var5) {
                     break;
                  }

                  if(!var5) {
                     continue;
                  }

                  y.c.i.g = !y.c.i.g;
               }

               while(true) {
                  if(var2.b() >= var3.b()) {
                     break label41;
                  }

                  var3 = var3.c();
                  if(var5) {
                     break label42;
                  }

                  if(var5) {
                     break label41;
                  }
               }
            }

            while(!a(var2, var3)) {
               var2 = var2.c();
               var3 = var3.c();
               if(var5) {
                  break;
               }
            }
         }

         e[] var4 = new e[]{var2, var3};
         return var4;
      } else {
         throw new RuntimeException("Node is Root Node !!");
      }
   }

   public static e c(e var0, e var1) {
      e[] var2 = b(var0, var1);
      return var2[0].c();
   }

   public static e d(e var0, e var1) {
      boolean var4 = f.e;
      if(!var0.e() && !var1.e()) {
         e var2 = var0;
         e var3 = var1;

         while(true) {
            if(var2.b() > var3.b()) {
               var2 = var2.c();
               if(var4) {
                  break;
               }

               if(!var4) {
                  continue;
               }
            }

            if(var2 == var3) {
               return var3;
            }
            break;
         }

         while(true) {
            if(var2.b() < var3.b()) {
               var3 = var3.c();
               if(var4) {
                  break;
               }

               if(!var4) {
                  continue;
               }
            }

            if(var2 == var3) {
               return var2;
            }
            break;
         }

         return null;
      } else {
         throw new RuntimeException("Node is Root Node !!");
      }
   }

   public static e a(e var0) {
      boolean var5 = f.e;
      e var1 = null;
      boolean var2 = false;
      D var3 = new D();
      var3.b((Object)var0);

      while(!var2) {
         var1 = (e)var3.g();
         if(var1.d()) {
            var2 = true;
            if(!var5) {
               continue;
            }
         }

         C var4 = var1.a();

         while(var4.f()) {
            var3.b((Object)((e)var4.d()));
            var4.g();
            if(var5 || var5) {
               return var1;
            }
         }
      }

      return var1;
   }

   public static String b(e var0) {
      o var1 = new o();
      m.a(var1, (e)var0);
      return var1.toString();
   }

   public static String a(g var0) {
      return b(var0.a());
   }
}
