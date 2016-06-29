package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;
import y.f.c.a.aS;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.x;

public class aW implements aT {
   private aT a;
   private aS b;
   private Comparator c;

   public aW(aT var1) {
      this(var1, new x(), (Comparator)null);
   }

   public aW(aT var1, aS var2, Comparator var3) {
      if(var1 != null && var2 != null) {
         this.c = var3;
         this.b = var2;
         this.a = var1;
      } else {
         throw new NullPointerException();
      }
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var14 = N.x;
      aT var4 = this.a();
      aS var5 = this.b();
      y.c.A var6 = var1.t();
      boolean var16 = false;

      try {
         label136: {
            var16 = true;
            int var7 = y.a.h.a(var1, (y.c.A)var6);
            if(var7 == 1) {
               var4.a(var1, var2, var3);
               if(!var14) {
                  var16 = false;
                  break label136;
               }
            }

            y.c.y[] var8 = new y.c.y[var7];
            int var9 = 0;

            while(var9 < var8.length) {
               var8[var9] = new y.c.y();
               ++var9;
               if(var14) {
                  var16 = false;
                  return;
               }

               if(var14) {
                  break;
               }
            }

            y.c.x var18 = var1.o();

            label116: {
               while(var18.f()) {
                  var8[var6.a(var18.e())].add(var18.e());
                  var18.g();
                  if(var14) {
                     break label116;
                  }

                  if(var14) {
                     break;
                  }
               }

               this.a(var8, var6);
            }

            y.g.J var19 = new y.g.J(var1, var6);
            int var10 = 0;

            while(var10 < var7) {
               Object var11 = var6.b(var8[var10].b());
               var19.c(var11);
               aU var12 = var2.a();
               var4.a(var1, var12, var3);
               var5.a(var1, var3, var12, var2);
               ++var10;
               if(var14) {
                  var16 = false;
                  return;
               }

               if(var14) {
                  break;
               }
            }

            var19.b();
            var16 = false;
         }
      } finally {
         if(var16) {
            var1.a((y.c.A)var6);
         }
      }

      var1.a((y.c.A)var6);
   }

   protected void a(y.c.y[] var1, y.c.c var2) {
      Comparator var3 = this.c();
      if(var3 != null) {
         y.g.e.a((Object[])var1, var3);
      }

   }

   public aT a() {
      return this.a;
   }

   public aS b() {
      return this.b;
   }

   public Comparator c() {
      return this.c;
   }
}
