package y.f.f.b;

import y.f.f.b.h;

public class o {
   public static final o a = new o(0);
   public static final o b = new o(1);
   public static final o c = new o(2);
   public static final o d = new o(3);
   public static final o e = new o(1000);
   private static final String[] f = new String[]{"^", ">", "_", "<"};
   private static final char[] g = new char[]{'^', '>', '_', '<'};
   private int h;
   private static double i = 1.0E-4D;

   o(int var1) {
      if(var1 != 1000) {
         label18:
         while(true) {
            if(var1 >= 0) {
               while(true) {
                  if(var1 <= 3) {
                     break label18;
                  }

                  var1 -= 4;
               }
            }

            var1 += 4;
         }
      }

      this.h = var1;
   }

   public static o a(int var0) {
      int var1 = h.a;
      if(var0 != 1000) {
         label36:
         while(true) {
            if(var0 < 0) {
               var0 += 4;
               if(var1 != 0) {
                  break;
               }

               if(var1 == 0) {
                  continue;
               }
            }

            while(true) {
               if(var0 <= 3) {
                  break label36;
               }

               var0 -= 4;
               if(var1 != 0) {
                  return a;
               }

               if(var1 != 0) {
                  break label36;
               }
            }
         }
      }

      switch(var0) {
      case 0:
         return a;
      case 1:
         return b;
      case 2:
         return c;
      case 3:
         return d;
      case 1000:
         return e;
      default:
         throw new RuntimeException("Invalid number in direction construction: " + var0);
      }
   }

   public static o a(char var0) {
      int var2 = h.a;
      boolean var1 = true;
      short var3;
      switch(var0) {
      case '^':
         var3 = 0;
         if(var2 == 0) {
            break;
         }
      case '>':
         var3 = 1;
         if(var2 == 0) {
            break;
         }
      case '_':
         var3 = 2;
         if(var2 == 0) {
            break;
         }
      case '<':
         var3 = 3;
         if(var2 == 0) {
            break;
         }
      case '+':
         var3 = 1000;
         if(var2 != 0) {
            throw new RuntimeException("Direction Constructor: Invalid character: " + var0);
         }
         break;
      default:
         throw new RuntimeException("Direction Constructor: Invalid character: " + var0);
      }

      return a((int)var3);
   }

   public o a() {
      if(this == e) {
         return a(this.h);
      } else {
         int var1 = this.h + 1;
         if(var1 > 3) {
            var1 = 0;
         }

         return a(var1);
      }
   }

   public o b(int var1) {
      int var4 = h.a;
      if(this == e) {
         return a(this.h);
      } else {
         o var2 = this;
         int var3 = 0;

         o var10000;
         while(true) {
            if(var3 < var1) {
               var10000 = var2.a();
               if(var4 != 0) {
                  break;
               }

               var2 = var10000;
               ++var3;
               if(var4 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   public o b() {
      if(this == e) {
         return a(this.h);
      } else {
         int var1 = this.h - 1;
         if(var1 < 0) {
            var1 = 3;
         }

         return a(var1);
      }
   }

   public o c() {
      if(this == e) {
         return e;
      } else {
         int var1 = this.h + 2;
         if(var1 > 3) {
            var1 -= 4;
         }

         return a(var1);
      }
   }

   public boolean d() {
      int var1 = this.f();
      return var1 == 1 || var1 == 3;
   }

   public boolean e() {
      int var1 = this.f();
      return var1 == 0 || var1 == 2;
   }

   public boolean a(o var1) {
      return this != e && var1 != e?this.h == var1.f():false;
   }

   public int f() {
      return this.h;
   }

   public int g() {
      return this.h;
   }

   public String toString() {
      return this == e?"+":f[this.h];
   }
}
