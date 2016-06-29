package y.f.f.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import y.f.S;
import y.f.X;
import y.f.f.a.b.a;
import y.f.h.Q;

public class f extends y.f.f.d.F {
   public f(y.c.h var1) {
      this.e = var1;
   }

   public void a(y.f.h.D var1, y.c.c var2, int var3) {
      boolean var9 = a.c;
      this.c = var1;
      this.j = var3;
      this.d = (X)var1.g();
      this.f = this.d.t();
      this.g = null;
      this.d.a((Object)a, (y.c.c)this.f);
      y.c.e var4 = this.d.p();

      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            ArrayList var6 = (ArrayList)this.e.b(var5);
            if(var9) {
               break;
            }

            if(var6 != null && var6.size() > 0) {
               this.l.addAll(var6);
               if(this.g == null) {
                  y.f.C[] var7 = this.d.d(var5);
                  if(var7 != null && var7.length > 0) {
                     y.f.C var8 = var7[0];
                     this.g = var8.getLabelModel();
                  }
               }
            }

            var4.g();
            if(!var9) {
               continue;
            }
         }

         var1.a((Q)this);
         this.k = new y.f.F();
         break;
      }

   }

   public void a(a var1, y.f.h.D var2, y.c.c var3, y.c.f var4) {
      boolean var10 = a.c;
      this.c = var2;
      this.d = (X)var2.g();
      this.f = this.d.t();
      this.g = null;
      this.d.a((Object)a, (y.c.c)this.f);
      y.c.e var5 = var4.a();

      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            ArrayList var7 = (ArrayList)this.e.b(var6);
            if(var10) {
               break;
            }

            if(var7 != null && !var7.isEmpty()) {
               y.c.f var8 = var1.d(var6);
               if(var8 != null) {
                  if(var1.r(var6)) {
                     this.a(var8, var1);
                  }

                  this.d(var6, var8.e());
               }

               if(this.g == null) {
                  y.f.C[] var9 = this.d.d(var6);
                  if(var9 != null && var9.length > 0) {
                     this.g = var9[0].getLabelModel();
                  }
               }
            }

            var5.g();
            if(!var10) {
               continue;
            }
         }

         var2.a((Q)this);
         break;
      }

   }

   private void a(y.c.f var1, a var2) {
      boolean var5 = a.c;
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var2.p(var4)) {
            var1.b(var3);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private void d(y.c.d var1, y.c.d[] var2) {
      boolean var11 = a.c;
      ArrayList var3 = (ArrayList)this.e.b(var1);
      if(var3 != null && !var3.isEmpty() && var2.length != 0) {
         if(var2.length == 1) {
            this.e.a(var2[0], var3);
            if(!var11) {
               return;
            }
         }

         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();
         ArrayList var6 = new ArrayList();
         Iterator var7 = var3.iterator();

         int var10000;
         byte var10001;
         label41: {
            while(var7.hasNext()) {
               S var8 = (S)var7.next();
               byte var9 = var8.f().a();
               var10000 = var9;
               var10001 = 1;
               if(var11) {
                  break label41;
               }

               if(var9 == 1) {
                  var4.add(var8);
                  if(!var11) {
                     continue;
                  }
               }

               if(var9 == 2) {
                  var6.add(var8);
                  if(!var11) {
                     continue;
                  }
               }

               var5.add(var8);
               if(var11) {
                  break;
               }
            }

            var10000 = var2.length;
            var10001 = 2;
         }

         if(var10000 == var10001) {
            this.e.a(var2[0], var4);
            var5.addAll(var6);
            this.e.a(var2[1], var5);
            if(!var11) {
               return;
            }
         }

         y.c.d var12 = var2[0];
         y.c.d var13 = var2[var2.length - 1];
         int var14 = (var2.length + 1) / 2 - 1;
         y.c.d var10 = var2[var14];
         this.e.a(var12, var4);
         this.e.a(var13, var6);
         this.e.a(var10, var5);
      }
   }
}
