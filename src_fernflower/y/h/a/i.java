package y.h.a;

import java.util.HashMap;
import java.util.Iterator;
import y.g.M;
import y.h.bu;
import y.h.fj;
import y.h.a.a;
import y.h.a.j;
import y.h.a.k;
import y.h.a.v;

public class i {
   private bu a;
   private v b;
   private y.c.c c;
   private y.c.c d;
   private y.c.c e;
   private y.c.c f;
   private y.c.c g;
   private HashMap h;
   private boolean i;

   public i(bu var1) {
      this.a = var1;
      this.b = v.a((y.c.i)var1);
   }

   public boolean a() {
      return this.i;
   }

   public void b() {
      if(this.b != null) {
         this.c = this.a.c(y.f.b.f.d);
         this.d = this.a.c(y.f.b.f.b);
         this.e = this.a.c(y.f.b.f.c);
         if(this.c != null) {
            this.a.d_(y.f.b.f.d);
         }

         if(this.d != null) {
            this.a.d_(y.f.b.f.b);
         }

         if(this.e != null) {
            this.a.d_(y.f.b.f.c);
         }

         this.a.a((Object)y.f.b.f.d, (y.c.c)this.a(this.a));
         this.a.a((Object)y.f.b.f.c, (y.c.c)this.b.d());
         this.a.a((Object)y.f.b.f.b, (y.c.c)this.b.c());
      }

   }

   protected y.c.c a(bu var1) {
      int var7 = v.a;
      y.c.c var2 = this.b.e();
      if(this.a() && var2 != null) {
         y.c.A var3 = M.a();
         y.c.x var4 = var1.o();

         while(var4.f()) {
            y.c.q var5 = var4.e();
            boolean var6 = var2.d(var5) && this.b.p(var5).k() > 0;
            var3.a(var5, var6);
            var4.g();
            if(var7 != 0) {
               break;
            }
         }

         return var3;
      } else {
         return var2;
      }
   }

   public void c() {
      if(this.b != null) {
         this.f = this.a.c(y.f.b.f.e);
         this.a.a((Object)y.f.b.f.e, (y.c.c)(new j(this)));
      }

   }

   protected y.d.r a(bu var1, y.c.q var2) {
      fj var3 = var1.t(var2);
      a var4 = var3.getAutoBoundsFeature();
      return var4 == null?null:var4.getAutoBoundsInsets();
   }

   public void d() {
      if(this.b != null) {
         this.g = this.a.c(y.f.b.f.f);
         this.a.a((Object)y.f.b.f.f, (y.c.c)(new k(this.a)));
      }

   }

   public void e() {
      int var6 = v.a;
      y.c.q var2;
      fj var3;
      a var4;
      boolean var5;
      if(this.b != null) {
         Iterator var1 = this.b.b();

         do {
            do {
               do {
                  do {
                     if(!var1.hasNext()) {
                        return;
                     }

                     var2 = (y.c.q)var1.next();
                  } while(!this.a.f(var2));

                  var3 = this.a.t(var2);
                  var4 = var3.getAutoBoundsFeature();
               } while(var4 == null);

               var5 = var4.isAutoBoundsEnabled();
            } while(!var5);

            var4.setAutoBoundsEnabled(false);
            var4.setAutoBoundsEnabled(true);
         } while(var6 == 0);
      }

      y.c.x var7 = this.a.o();

      while(var7.f()) {
         var2 = var7.e();
         var3 = this.a.t(var2);
         var4 = var3.getAutoBoundsFeature();
         if(var4 != null) {
            var5 = var4.isAutoBoundsEnabled();
            if(var5) {
               var4.setAutoBoundsEnabled(false);
               var4.setAutoBoundsEnabled(true);
            }
         }

         var7.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   public void f() {
      int var1 = v.a;
      if(this.b != null) {
         label29: {
            if(this.c == null) {
               this.a.d_(y.f.b.f.d);
               if(var1 == 0) {
                  break label29;
               }
            }

            this.a.a((Object)y.f.b.f.d, (y.c.c)this.c);
         }

         label24: {
            if(this.e == null) {
               this.a.d_(y.f.b.f.c);
               if(var1 == 0) {
                  break label24;
               }
            }

            this.a.a((Object)y.f.b.f.c, (y.c.c)this.e);
         }

         label19: {
            if(this.d == null) {
               this.a.d_(y.f.b.f.b);
               if(var1 == 0) {
                  break label19;
               }
            }

            this.a.a((Object)y.f.b.f.b, (y.c.c)this.d);
         }

         this.c = null;
         this.d = null;
         this.e = null;
      }

   }

   public void g() {
      if(this.b != null) {
         this.a(true);
      }

   }

   public void h() {
      if(this.b != null) {
         if(this.f != null) {
            this.a.a((Object)y.f.b.f.e, (y.c.c)this.f);
            if(v.a == 0) {
               return;
            }
         }

         this.a.d_(y.f.b.f.e);
      }

   }

   public void i() {
      if(this.b != null) {
         if(this.g != null) {
            this.a.a((Object)y.f.b.f.f, (y.c.c)this.g);
            if(v.a == 0) {
               return;
            }
         }

         this.a.d_(y.f.b.f.f);
      }

   }

   public void j() {
      if(this.b != null) {
         this.a(false);
      }

   }

   private void a(boolean var1) {
      int var6;
      label47: {
         var6 = v.a;
         if(var1) {
            this.h = new HashMap();
            if(var6 == 0) {
               break label47;
            }
         }

         if(this.h == null) {
            return;
         }
      }

      y.c.x var2 = this.a.o();

      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            fj var4 = this.a.t(var3);
            a var5 = var4.getAutoBoundsFeature();
            if(var6 != 0) {
               break;
            }

            if(var5 != null) {
               label52: {
                  if(var1) {
                     if(var5.isAutoBoundsEnabled()) {
                        var5.setAutoBoundsEnabled(false);
                        if(var6 == 0) {
                           break label52;
                        }
                     }

                     this.h.put(var3, Boolean.TRUE);
                     if(var6 == 0) {
                        break label52;
                     }
                  }

                  if(this.h.get(var3) != Boolean.TRUE) {
                     var5.setAutoBoundsEnabled(true);
                  }
               }
            }

            var2.g();
            if(var6 == 0) {
               continue;
            }
         }

         if(!var1) {
            this.h = null;
         }
         break;
      }

   }

   public void k() {
      if(this.b != null) {
         this.e();
         this.b();
         this.c();
         this.g();
         this.d();
      }

   }

   public void l() {
      if(this.b != null) {
         this.j();
         this.h();
         this.f();
         this.i();
      }

   }

   static bu a(i var0) {
      return var0.a;
   }
}
