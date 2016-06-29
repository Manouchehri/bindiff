package y.f.i.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.ab;
import y.f.i.a.bl;
import y.f.i.a.f;

class aU {
   private y.f.X a;
   private y.c.d b;
   private List[] c;
   private List[] d;
   private bl[] e;
   private HashMap f;
   private HashMap g;

   aU(y.c.d var1) {
      this.a = (y.f.X)var1.a();
      this.b = var1;
      this.c = new List[2];
      this.d = new List[2];
      this.e = new bl[2];
      this.c(true);
      this.c(false);
      this.a();
   }

   private void c(boolean var1) {
      int var11 = ab.a;
      int var2 = var1?0:1;
      y.c.D var3 = new y.c.D();
      Object var4 = var1?y.f.ax.a:y.f.ax.b;
      y.c.c var5 = this.a.c(var4);
      if(var5 != null) {
         List var6 = (List)var5.b(this.b);
         if(var6 != null) {
            var3.addAll(var6);
         }
      }

      y.f.aE var12 = var1?y.f.aE.d(this.a, this.b):y.f.aE.e(this.a, this.b);
      if(var12 != null) {
         y.f.ax var7 = this.a(var12, var1);
         var3.add(var7);
      }

      Object var9;
      label58: {
         y.c.q var13 = var1?this.b.c():this.b.d();
         bl var8 = bl.a(var13);
         this.e[var2] = var8;
         if(var3.isEmpty() && var8 == null) {
            var9 = null;
            if(var11 == 0) {
               break label58;
            }
         }

         if(var3.isEmpty()) {
            var9 = var8.a();
            if(var11 == 0) {
               break label58;
            }
         }

         if(var8 == null) {
            var9 = var3;
            if(var11 == 0) {
               break label58;
            }
         }

         List var10 = var8.b();
         var3.removeAll(var10);
         var9 = var3;
      }

      this.c[var2] = (List)var9;
      this.d[var2] = this.a((List)var9);
   }

   private y.f.ax a(y.f.aE var1, boolean var2) {
      short var3 = var1.g()?255:var1.b();
      if(var1.a()) {
         y.d.t var4 = var2?this.a.n(this.b):this.a.o(this.b);
         return y.f.ax.a(var4.a(), var4.b(), var3);
      } else {
         return y.f.ax.b((int)var3);
      }
   }

   public List a(List var1) {
      int var5 = ab.a;
      y.c.D var2 = new y.c.D();
      y.c.D var10000;
      if(var1 != null) {
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            y.f.ax var4 = (y.f.ax)var3.next();
            if(var4.b()) {
               var10000 = var2;
               if(var5 != 0) {
                  return var10000;
               }

               var2.add(var4);
               if(var5 != 0) {
                  break;
               }
            }
         }
      }

      var10000 = var2;
      return var10000;
   }

   public List a(List var1, R var2, R var3, boolean var4) {
      int var8 = ab.a;
      y.c.D var5 = new y.c.D();
      y.c.D var10000;
      if(var1 != null) {
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            y.f.ax var7 = (y.f.ax)var6.next();
            if(a(var4?var2:var3, var4?var3:var2, var7)) {
               var10000 = var5;
               if(var8 != 0) {
                  return var10000;
               }

               var5.add(var7);
               if(var8 != 0) {
                  break;
               }
            }
         }
      }

      var10000 = var5;
      return var10000;
   }

   public List a(U var1, boolean var2) {
      int var3 = var1.b();
      f var4 = var1.a(var2?0:var3 - 2);
      f var5 = var1.a(var2?1:var3 - 1);
      return this.a(var4.a(), var5.a(), var5.c(), var2);
   }

   public List a(R var1, R var2, P var3, boolean var4) {
      int var14 = ab.a;
      int var5 = var4?0:1;
      if(this.c[var5] == null) {
         return Collections.EMPTY_LIST;
      } else {
         List var6 = this.a(this.c[var5], var1, var2, var4);
         if(var6.size() == 0) {
            return Collections.EMPTY_LIST;
         } else {
            y.c.D var7 = new y.c.D();
            M var8 = var3.e();
            Iterator var9 = var6.iterator();

            while(var9.hasNext()) {
               y.f.ax var10 = (y.f.ax)var9.next();
               if(!var10.b()) {
                  var7.add(var10);
                  if(var14 == 0) {
                     continue;
                  }
               }

               y.d.t var11 = this.a(var10, var4);
               double var12 = var3.a()?var11.b():var11.a();
               if(var8.d() == 0.0D && var8.a() == var12) {
                  var7.add(var10);
                  if(var14 != 0) {
                     break;
                  }
               }
            }

            return var7;
         }
      }
   }

   private void a() {
      int var6 = ab.a;
      List var1 = this.d[0];
      List var2 = this.d[1];
      Iterator var3;
      y.f.ax var4;
      y.d.t var5;
      if(var1 != null) {
         this.f = new HashMap(var1.size());
         var3 = var1.iterator();

         while(var3.hasNext()) {
            var4 = (y.f.ax)var3.next();
            var5 = a(var4, this.b.c());
            this.f.put(var4, var5);
            if(var6 != 0) {
               return;
            }

            if(var6 != 0) {
               break;
            }
         }
      }

      if(var2 != null) {
         this.g = new HashMap(var2.size());
         var3 = var2.iterator();

         while(var3.hasNext()) {
            var4 = (y.f.ax)var3.next();
            var5 = a(var4, this.b.d());
            this.g.put(var4, var5);
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   public List a(boolean var1) {
      return this.c[var1?0:1];
   }

   public List b(boolean var1) {
      return this.d[var1?0:1];
   }

   public y.d.t a(y.f.ax var1, boolean var2) {
      return var2 && this.f != null?(y.d.t)this.f.get(var1):(!var2 && this.g != null?(y.d.t)this.g.get(var1):null);
   }

   public void b(U var1, boolean var2) {
      int var8 = ab.a;
      int var3 = var2?0:1;
      bl var4 = this.e[var3];
      if(var4 != null) {
         List var5 = this.a(var1, var2);
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            y.f.ax var7 = (y.f.ax)var6.next();
            var4.a(var7);
            if(var8 != 0) {
               break;
            }
         }
      }

   }

   private static boolean a(R var0, R var1, y.f.ax var2) {
      return var2.a() == 1?var0.i() == var1.k():(var2.a() == 2?var0.k() == var1.i():(var2.a() == 4?var0.j() == var1.h():(var2.a() == 8?var0.h() == var1.j():true)));
   }

   private static y.d.t a(y.f.ax var0, y.c.q var1) {
      y.f.X var2 = (y.f.X)var1.e();
      y.d.t var3 = var2.l(var1);
      double var4 = var3.a() + var0.c();
      double var6 = var3.b() + var0.d();
      return new y.d.t(var4, var6);
   }
}
