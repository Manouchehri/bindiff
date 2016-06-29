package y.f.i.a;

import java.util.Iterator;
import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.bc;
import y.f.i.a.bd;
import y.f.i.a.g;
import y.f.i.a.v;

class be {
   private final v a;
   private final y.c.D b;
   private y.c.p c;
   private final bc d;

   be(bc var1, v var2) {
      this.d = var1;
      this.a = var2;
      this.b = new y.c.D(var2.m());
   }

   void a() {
      int var4 = ab.a;
      if(this.c != null) {
         this.b();
      }

      this.c = bc.a(this.d).b((Object)this.a);
      Iterator var1 = this.b.iterator();

      while(var1.hasNext()) {
         g var2;
         label31: {
            var2 = (g)var1.next();
            this.a(var2, var2.g()?bc.b(this.d):bc.c(this.d));
            M var3 = var2.c();
            if(var2.g()) {
               bc.a(this.d, 0, var3.b() + bc.d(this.d), false);
               bc.a(this.d, 2, var3.a() - bc.d(this.d), false);
               if(var4 == 0) {
                  break label31;
               }
            }

            bc.a(this.d, 1, var3.b() + bc.d(this.d), false);
            bc.a(this.d, 3, var3.a() - bc.d(this.d), false);
         }

         if(var2.g()) {
            bc.a((bc)this.d, (y.c.D)null);
            if(var4 == 0) {
               continue;
            }
         }

         bc.b(this.d, (y.c.D)null);
         if(var4 != 0) {
            break;
         }
      }

   }

   private void a(g var1, y.c.D var2) {
      ah var3 = var1.k();
      if(var3 != null && bc.e(this.d).containsKey(var3)) {
         bd var5 = (bd)((y.c.p)bc.e(this.d).get(var3)).c();
         var5.a.add(var1);
      } else {
         y.c.p var4 = bc.a(this.d, new bd(this.d, var1), var2);
         bc.e(this.d).put(var3 != null?var3:var1, var4);
      }
   }

   void b() {
      int var10 = ab.a;
      if(this.c != null) {
         bc.a(this.d).h(this.c);
         this.c = null;
         y.c.C var1 = this.b.m();

         while(var1.f()) {
            g var2 = (g)var1.d();
            ah var3 = var2.k();
            y.c.p var4 = (y.c.p)bc.e(this.d).get(var3 != null?var3:var2);
            bd var5 = (bd)var4.c();
            var5.a.remove(var2);
            if(var5.a.size() == 0) {
               label42: {
                  bc.e(this.d).remove(var3 != null?var3:var2);
                  double var6;
                  double var8;
                  if(var2.g()) {
                     bc.b(this.d).h(var4);
                     bc.a((bc)this.d, (y.c.D)null);
                     var6 = bc.a((bc)this.d, 0) - bc.d(this.d);
                     bc.a(this.d, 2, var6, true);
                     var8 = bc.a((bc)this.d, 2) + bc.d(this.d);
                     bc.a(this.d, 0, var8, true);
                     if(var10 == 0) {
                        break label42;
                     }
                  }

                  bc.c(this.d).h(var4);
                  bc.b(this.d, (y.c.D)null);
                  var6 = bc.a((bc)this.d, 1) - bc.d(this.d);
                  bc.a(this.d, 3, var6, true);
                  var8 = bc.a((bc)this.d, 3) + bc.d(this.d);
                  bc.a(this.d, 1, var8, true);
               }
            }

            var1.g();
            if(var10 != 0) {
               break;
            }
         }
      }

   }
}
