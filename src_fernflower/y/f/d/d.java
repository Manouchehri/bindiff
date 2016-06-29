package y.f.d;

import y.f.Q;
import y.f.X;
import y.f.ai;
import y.f.aj;
import y.f.am;
import y.f.d.a;
import y.f.d.c;

class d implements y.d.g {
   y.f.b.c a;
   X b;

   public d(X var1, y.f.b.c var2) {
      this.a = var2;
      this.b = var1;
   }

   public void a(Object var1, Object var2) {
      int var10 = a.f;
      Q var3 = null;
      y.c.q var4 = null;
      if(var1 instanceof Q) {
         var3 = (Q)var1;
      } else if(var1 instanceof c) {
         var4 = ((c)var1).e;
      }

      label124: {
         if(var2 instanceof Q) {
            var3 = (Q)var2;
            if(var10 == 0) {
               break label124;
            }
         }

         if(var2 instanceof c) {
            var4 = ((c)var2).e;
         }
      }

      if(var3 != null && var4 != null && y.d.n.a(var3.d(), this.b.s(var4), 0.001D)) {
         label115: {
            if(var3 instanceof ai) {
               ai var5 = (ai)var3;
               if(var5.f()) {
                  return;
               }

               if(this.a == null || !this.a.d(var4)) {
                  break label115;
               }

               am var6 = this.b.a((Object)var4);
               y.d.y var7 = var5.h();
               y.c.q var8 = this.b.a((aj)var5.e());

               do {
                  if(var8 == null) {
                     break label115;
                  }

                  if(var8 == var4 && var6.getX() <= var7.c() && var6.getY() <= var7.d() && var6.getX() + var6.getWidth() >= var7.c() + var7.a() && var6.getY() + var6.getHeight() >= var7.d() + var7.b()) {
                     return;
                  }

                  var8 = this.a.a(var8);
               } while(var10 == 0);
            }

            if(var3 instanceof y.f.B && this.a != null && this.a.d(var4)) {
               label130: {
                  y.f.B var11 = (y.f.B)var3;
                  y.c.d var12 = this.b.a((y.f.C)var11.e());
                  am var13 = this.b.a((Object)var4);
                  y.d.y var14 = var11.h();
                  y.c.q var9 = this.a.a(var12.c());

                  y.c.q var10000;
                  y.c.q var10001;
                  while(true) {
                     if(var9 != null) {
                        var10000 = var9;
                        var10001 = var4;
                        if(var10 != 0) {
                           break;
                        }

                        if(var9 == var4 && var13.getX() <= var14.c() && var13.getY() <= var14.d() && var13.getX() + var13.getWidth() >= var14.c() + var14.a() && var13.getY() + var13.getHeight() >= var14.d() + var14.b()) {
                           return;
                        }

                        var9 = this.a.a(var9);
                        if(var10 == 0) {
                           continue;
                        }
                     }

                     var9 = this.a.a(var12.d());
                     if(var9 == null) {
                        break label130;
                     }

                     var10000 = var9;
                     var10001 = var4;
                     break;
                  }

                  while(true) {
                     if(var10000 == var10001 && var13.getX() <= var14.c() && var13.getY() <= var14.d() && var13.getX() + var13.getWidth() >= var14.c() + var14.a() && var13.getY() + var13.getHeight() >= var14.d() + var14.b()) {
                        return;
                     }

                     var9 = this.a.a(var9);
                     if(var10 != 0 || var9 == null) {
                        break;
                     }

                     var10000 = var9;
                     var10001 = var4;
                  }
               }
            }
         }

         var3.b(1.0D);
      }
   }
}
