package y.f.c;

import java.util.Comparator;
import y.f.c.a;
import y.f.c.ap;
import y.f.c.x;

class as implements Comparator, y.g.g {
   private y.c.q a;
   private int b;
   private int c;
   private int d;
   private boolean e;
   private boolean f;
   private y.c.c g;
   private final ap h;

   as(ap var1, y.c.c var2) {
      this.h = var1;
      this.g = var2;
   }

   void a(y.c.q var1, int var2) {
      this.a = var1;
      this.d = this.g.a(this.a);
      this.b = var2 / 3;
      this.f = var2 > 3 && var2 < 11;
      this.c = this.f?2:0;
      switch(var2) {
      case 0:
      case 3:
      case 5:
      case 8:
         this.e = false;
         if(!a.i) {
            break;
         }
      case 2:
      case 6:
      case 9:
      case 11:
         this.e = true;
      case 1:
      case 4:
      case 7:
      case 10:
      }

   }

   public int compare(Object var1, Object var2) {
      boolean var20 = a.i;
      if(this.e) {
         Object var5 = var2;
         var2 = var1;
         var1 = var5;
      }

      y.d.t var3;
      y.c.d var6;
      y.c.q var7;
      boolean var11;
      int var13;
      label122: {
         y.c.d var21 = (y.c.d)var1;
         var6 = (y.c.d)var2;
         y.f.aE var9;
         if(var21.c() == this.a) {
            var7 = var21.d();
            var9 = this.h.b(var21);
            var13 = x.a(var9.b(), this.c);
            var3 = ap.a(this.h).o(var21);
            var11 = false;
            if(!var20) {
               break label122;
            }
         }

         var7 = var21.c();
         var9 = this.h.a(var21);
         var13 = x.a(var9.b(), this.c);
         var3 = ap.a(this.h).n(var21);
         var11 = (this.b ^ var13) == 2 && (this.b | var13) == 2;
      }

      y.d.t var4;
      y.c.q var8;
      boolean var12;
      int var14;
      label123: {
         y.f.aE var10;
         if(var6.c() == this.a) {
            var8 = var6.d();
            var10 = this.h.b(var6);
            var4 = ap.a(this.h).o(var6);
            var14 = x.a(var10.b(), this.c);
            var12 = false;
            if(!var20) {
               break label123;
            }
         }

         var8 = var6.c();
         var10 = this.h.a(var6);
         var14 = x.a(var10.b(), this.c);
         var4 = ap.a(this.h).n(var6);
         var12 = (this.b ^ var14) == 2 && (this.b | var14) == 2;
      }

      int var15 = this.g.a(var7);
      int var16 = this.g.a(var8);
      int var17 = y.g.e.a(var16, var15);
      if(var17 == 0) {
         if(var12 != var11) {
            return var11 ^ this.e?-1:1;
         } else {
            boolean var18 = var15 > this.d;
            byte var19;
            if(var18) {
               if(this.f) {
                  var19 = 1;
                  if(!var20) {
                     return this.a(var19, var13, var14, this.f, var3, var4);
                  }
               }

               var19 = 2;
               if(!var20) {
                  return this.a(var19, var13, var14, this.f, var3, var4);
               }
            }

            if(this.f) {
               var19 = 3;
               if(!var20) {
                  return this.a(var19, var13, var14, this.f, var3, var4);
               }
            }

            var19 = 3;
            return this.a(var19, var13, var14, this.f, var3, var4);
         }
      } else if(var12 != var11) {
         return var11 ^ this.e?-1:1;
      } else {
         label78: {
            if(var15 < this.d) {
               var15 = this.d - var15;
               if(!var20) {
                  break label78;
               }
            }

            var15 = Integer.MAX_VALUE - var15;
         }

         if(var16 < this.d) {
            var16 = this.d - var16;
            if(!var20) {
               return y.g.e.a(var15, var16);
            }
         }

         var16 = Integer.MAX_VALUE - var16;
         return y.g.e.a(var15, var16);
      }
   }

   private int a(int var1, int var2, int var3, boolean var4, y.d.t var5, y.d.t var6) {
      boolean var9 = a.i;
      int var7;
      int var8;
      if(var4) {
         if(var2 > var1) {
            var2 -= 4;
         }

         if(var3 > var1) {
            var3 -= 4;
         }

         var7 = y.g.e.a(var2, var3);
         if(var7 != 0) {
            return var7;
         } else {
            switch(4 + var2 & 3) {
            case 0:
               var8 = y.g.e.a(var6.a, var5.a);
               if(!var9) {
                  break;
               }
            case 1:
               var8 = y.g.e.a(var6.b, var5.b);
               if(!var9) {
                  break;
               }
            case 2:
               var8 = y.g.e.a(var5.a, var6.a);
               if(!var9) {
                  break;
               }
            default:
               var8 = y.g.e.a(var5.b, var6.b);
            }

            return -var8;
         }
      } else {
         if(var2 < var1) {
            var2 += 4;
         }

         if(var3 < var1) {
            var3 += 4;
         }

         var7 = y.g.e.a(var3, var2);
         if(var7 != 0) {
            return var7;
         } else {
            switch(4 + var2 & 3) {
            case 0:
               var8 = y.g.e.a(var6.a, var5.a);
               if(!var9) {
                  break;
               }
            case 1:
               var8 = y.g.e.a(var6.b, var5.b);
               if(!var9) {
                  break;
               }
            case 2:
               var8 = y.g.e.a(var5.a, var6.a);
               if(!var9) {
                  break;
               }
            default:
               var8 = y.g.e.a(var5.b, var6.b);
            }

            return var8;
         }
      }
   }
}
