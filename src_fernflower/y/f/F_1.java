package y.f;

import java.util.HashMap;
import java.util.Map;
import y.f.G;
import y.f.H;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.an;
import y.f.y;

public class F {
   private final Map a = new HashMap();
   private final Map b = new HashMap();

   private static byte d(y.c.i var0) {
      y.c.c var1 = var0.c((Object)"PARTITION_ORIENTATION_DPKEY");
      if(var1 != null) {
         an var2 = (an)var1.b(var0);
         return var2.b();
      } else {
         return (byte)0;
      }
   }

   static boolean a(y.c.i var0) {
      y.c.c var1 = var0.c((Object)"PARTITION_ORIENTATION_DPKEY");
      if(var1 != null) {
         an var2 = (an)var1.b(var0);
         return var2.b(var2.b());
      } else {
         return false;
      }
   }

   public void b(y.c.i var1) {
      boolean var10 = X.j;
      y.c.c var2 = var1.c(U.a);
      if(var2 != null) {
         y.c.e var3 = var1.p();

         while(var3.f()) {
            label28: {
               y.c.d var4 = var3.a();
               S[] var5 = (S[])var2.b(var4);
               if(var5 != null) {
                  int var6 = 0;

                  while(var6 < var5.length) {
                     S var7 = var5[var6];
                     aG var8 = var7.f();
                     aG var9 = this.a(var8);
                     this.b.put(var9, var8);
                     var7.a(var9);
                     ++var6;
                     if(var10) {
                        break label28;
                     }

                     if(var10) {
                        break;
                     }
                  }
               }

               var3.g();
            }

            if(var10) {
               break;
            }
         }
      }

   }

   public void c(y.c.i var1) {
      boolean var10 = X.j;
      y.c.c var2 = var1.c(U.a);
      if(var2 != null) {
         y.c.e var3 = var1.p();

         while(var3.f()) {
            label28: {
               y.c.d var4 = var3.a();
               S[] var5 = (S[])var2.b(var4);
               if(var5 != null) {
                  int var6 = 0;

                  while(var6 < var5.length) {
                     S var7 = var5[var6];
                     aG var8 = var7.f();
                     aG var9 = (aG)this.b.get(var8);
                     var7.a(var9);
                     ++var6;
                     if(var10) {
                        break label28;
                     }

                     if(var10) {
                        break;
                     }
                  }
               }

               var3.g();
            }

            if(var10) {
               break;
            }
         }
      }

   }

   public void a(y.c.i var1, S var2, y var3) {
      if(!this.a.containsKey(var2)) {
         aG var4 = var2.f();
         y var5 = a(var1, var3);
         H var6 = new H(var4, var5, (G)null);
         this.a.put(var2, var6);
         aG var7 = this.a(var4);
         aG var8 = this.a(var1, var7, var5);
         var2.a(var8);
         a(var2, var3);
      }
   }

   private aG a(aG var1) {
      aG var2;
      boolean var3;
      label72: {
         var3 = X.j;
         var2 = new aG(var1);
         if(var1.i()) {
            var2.a((byte)1);
            if(!var3) {
               break label72;
            }
         }

         if(var1.j()) {
            var2.a((byte)4);
            if(!var3) {
               break label72;
            }
         }

         var2.a((byte)2);
      }

      label73: {
         if(var1.l()) {
            var2.b((byte)16);
            if(!var3) {
               break label73;
            }
         }

         if(var1.m()) {
            var2.b((byte)8);
            if(!var3) {
               break label73;
            }
         }

         var2.b((byte)32);
      }

      label74: {
         if(var1.u()) {
            var2.c((byte)1);
            if(!var3) {
               break label74;
            }
         }

         if(var1.v()) {
            var2.c((byte)2);
            if(!var3) {
               break label74;
            }
         }

         var2.c((byte)4);
      }

      label42: {
         if(var1.p()) {
            var2.d((byte)2);
            if(!var3) {
               break label42;
            }
         }

         var2.d((byte)1);
      }

      label37: {
         if(var1.q()) {
            var2.e((byte)1);
            if(!var3) {
               break label37;
            }
         }

         var2.e((byte)2);
      }

      if(var1.s()) {
         var2.f((byte)1);
         if(!var3) {
            return var2;
         }
      }

      var2.f((byte)2);
      return var2;
   }

   public void a(y.c.i var1, S var2) {
      y.d.t var3 = var2.a().k();
      y.d.t var4 = this.a(var1, var3);
      H var5 = (H)this.a.get(var2);
      if(var5 != null) {
         var2.a(this.a(H.a(var5)));
         a(var2, H.b(var5));
         var2.a(H.a(var5));
         this.a.remove(var2);
      }

      var2.a().b(var4);
   }

   private aG a(y.c.i var1, aG var2, y var3) {
      aG var4 = new aG(var2);
      byte var5 = this.b(var1, var2, var3);
      var4.b(var5);
      var4.c((byte)1);
      double var6 = this.c(var1, var2, var3);
      if(var2.n()) {
         if(var4.r()) {
            var6 = 3.141592653589793D - var6;
         }

         if(var4.t()) {
            var6 += 3.141592653589793D;
         }
      }

      var4.a(var6);
      var4.d((byte)2);
      var4.e((byte)1);
      var4.f((byte)1);
      return var4;
   }

   private byte b(y.c.i var1, aG var2, y var3) {
      byte var4 = var2.b();
      if(var2.v() && (var3 == y.c || var3 == y.d) || var2.w() && (var3 == y.c || var3 == y.b)) {
         var4 = this.a(var4);
      }

      if(a(var1)) {
         var4 = this.a(var4);
      }

      return var4;
   }

   private double c(y.c.i var1, aG var2, y var3) {
      double var4;
      label38: {
         boolean var6 = X.j;
         var4 = var2.d();
         if(var2.p()) {
            var4 += 0.0D;
            if(!var6) {
               break label38;
            }
         }

         if(var3 == y.b) {
            var4 += 0.0D;
            if(!var6) {
               break label38;
            }
         }

         if(var3 == y.a) {
            ++var4;
            if(!var6) {
               break label38;
            }
         }

         if(var3 == y.d) {
            var4 += 3.141592653589793D;
            if(!var6) {
               break label38;
            }
         }

         if(var3 == y.c) {
            var4 += 4.71238898038469D;
         }
      }

      if(a(var1)) {
         var4 = 3.141592653589793D - var4;
      }

      return var4;
   }

   private y.d.t a(y.c.i var1, y.d.t var2) {
      byte var3 = d(var1);
      if(a(var1)) {
         switch(var3) {
         case 0:
            return new y.d.t(-var2.a(), var2.b());
         case 1:
            return new y.d.t(var2.b(), var2.a());
         case 2:
            return new y.d.t(var2.a(), -var2.b());
         case 3:
            return new y.d.t(-var2.b(), -var2.a());
         default:
            if(!X.j) {
               return var2;
            }
         }
      }

      switch(var3) {
      case 0:
         return var2;
      case 1:
         return new y.d.t(var2.b(), -var2.a());
      case 2:
         return new y.d.t(-var2.a(), -var2.b());
      case 3:
         return new y.d.t(-var2.b(), var2.a());
      default:
         return var2;
      }
   }

   private static y a(y.c.i var0, y var1) {
      boolean var2 = a(var0);
      y var3 = var2 && var1.d()?var1.c():var1;
      switch(d(var0)) {
      case 0:
         return var3;
      case 1:
         return var3.b();
      case 2:
         return var3.c();
      case 3:
         return var3.a();
      default:
         return null;
      }
   }

   private byte a(byte var1) {
      switch(var1) {
      case 16:
         return (byte)32;
      case 32:
         return (byte)16;
      default:
         return (byte)8;
      }
   }

   public static void a(S var0, y var1) {
      y.d.z var2 = a(var0.f(), var1);
      y.d.n var3 = var0.a();
      var3.c(var2.a(), var2.b());
      var0.a(var3);
   }

   public static y.d.z a(aG var0, y var1) {
      double var2;
      label44: {
         boolean var6 = X.j;
         var2 = 0.0D;
         if(var0.o()) {
            var2 = 0.0D;
            if(!var6) {
               break label44;
            }
         }

         if(y.b.equals(var1)) {
            var2 = 0.0D;
            if(!var6) {
               break label44;
            }
         }

         if(y.c.equals(var1)) {
            var2 = 1.5707963267948966D;
            if(!var6) {
               break label44;
            }
         }

         if(y.d.equals(var1)) {
            var2 = 3.141592653589793D;
            if(!var6) {
               break label44;
            }
         }

         if(y.a.equals(var1)) {
            var2 = 4.71238898038469D;
         }
      }

      double var4 = var0.d();
      if(var0.n()) {
         if(var0.r()) {
            var4 = -var4;
         }

         if(var0.t()) {
            var4 -= 3.141592653589793D;
         }
      }

      return a(var2 + var4);
   }

   public static y.d.z a(double var0) {
      return new y.d.z(Math.sin(var0), -Math.cos(var0));
   }
}
