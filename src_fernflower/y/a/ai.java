package y.a;

import java.util.ArrayList;
import y.a.ag;
import y.a.h;

class ai {
   y.c.i e;
   y.c.h f;
   y.c.A g;
   int h;
   ArrayList i;
   private final y.g.a.f a;
   private final y.c.h b;
   private final ag c;

   ai(ag var1, y.c.i var2) {
      this.c = var1;
      this.e = var2;
      this.f = var2.u();
      this.b = var2.u();
      this.a = new y.g.a.f(var2.g(), this.b, this.b);
      this.g = y.g.M.a(new int[var2.e()]);
      this.h = 0;
      this.i = new ArrayList();
   }

   void a() {
      this.a.d();
      this.e.a(this.f);
      this.e.a(this.b);
      this.e = null;
   }

   void b(y.c.y var1) {
      boolean var4 = h.a;
      y.c.x var2 = var1.a();

      while(true) {
         if(var2.f()) {
            this.g.a(var2.e(), this.h);
            var2.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         this.i.add(var1);
         break;
      }

      if(var1.size() > Math.max(ag.c(this.c), 1)) {
         ag.a(this.c).a(this.e, var1, this.f);
         var2 = var1.a();

         while(var2.f()) {
            y.c.d var3 = var2.e().f();

            label31: {
               while(var3 != null) {
                  this.a.a(var3, -this.f.c(var3));
                  var3 = var3.g();
                  if(var4) {
                     break label31;
                  }

                  if(var4) {
                     break;
                  }
               }

               var2.g();
            }

            if(var4) {
               break;
            }
         }
      }

      ++this.h;
   }

   y.c.y[] a(y.c.y var1, y.c.A var2) {
      boolean var9 = h.a;
      byte var3 = 2;
      y.c.y[] var4 = new y.c.y[var3];
      int var5 = 0;

      while(true) {
         if(var5 < var3) {
            var4[var5] = new y.c.y();
            ++var5;
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var5 = this.g.a(var1.b());
         break;
      }

      int var6 = this.h;
      y.c.x var7 = var1.a();

      int var10000;
      while(true) {
         if(var7.f()) {
            int var8 = var2.a(var7.e());
            var10000 = var8;
            if(var9) {
               break;
            }

            label34: {
               if(var8 > 0) {
                  var4[1].b(var7.e());
                  this.g.a(var7.e(), var6);
                  if(!var9) {
                     break label34;
                  }
               }

               var4[0].b(var7.e());
               this.g.a(var7.e(), var5);
            }

            var7.g();
            if(!var9) {
               continue;
            }
         }

         this.i.add(new y.c.y());
         ++this.h;
         var10000 = 0;
         break;
      }

      int var10 = var10000;

      while(var10 < var3) {
         this.c(var4[var10]);
         ++var10;
         if(var9) {
            break;
         }
      }

      return var4;
   }

   void c(y.c.y var1) {
      this.i.set(this.g.a(var1.b()), var1);
      if(var1.size() > Math.max(ag.c(this.c), 1)) {
         this.a(var1);
         if(!h.a) {
            return;
         }
      }

      this.d(var1);
   }

   void a(y.c.y var1) {
      boolean var4 = h.a;
      ag.a(this.c).a(this.e, var1, this.f);
      y.c.x var2 = var1.a();

      while(var2.f()) {
         y.c.d var3 = var2.e().f();

         while(true) {
            if(var3 != null) {
               this.a(var3);
               var3 = var3.g();
               if(var4) {
                  break;
               }

               if(!var4) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var4) {
            break;
         }
      }

   }

   void a(y.c.d var1) {
      if(ag.d(this.c) && this.c(var1)) {
         this.a.c(var1, Double.MAX_VALUE);
         if(!h.a) {
            return;
         }
      }

      this.a.c(var1, -this.f.c(var1));
   }

   void d(y.c.y var1) {
      boolean var4 = h.a;
      y.c.x var2 = var1.a();

      while(var2.f()) {
         y.c.d var3 = var2.e().f();

         while(true) {
            if(var3 != null) {
               this.a.b(var3);
               var3 = var3.g();
               if(var4) {
                  break;
               }

               if(!var4) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var4) {
            break;
         }
      }

   }

   void b(y.c.d var1) {
      boolean var3 = h.a;
      if(ag.d(this.c)) {
         if(var1.c().a() == 2) {
            y.c.e var2 = var1.c().j();

            int var10000;
            label41: {
               while(var2.f()) {
                  var10000 = var2.a().equals(var1);
                  if(var3) {
                     break label41;
                  }

                  if(var10000 == 0) {
                     this.a.c(var2.a(), Double.MAX_VALUE);
                  }

                  var2.g();
                  if(var3) {
                     break;
                  }
               }

               var10000 = var1.d().a();
            }

            if(var10000 == 2) {
               var2 = var1.d().j();

               while(var2.f()) {
                  if(!var2.a().equals(var1)) {
                     this.a.c(var2.a(), Double.MAX_VALUE);
                  }

                  var2.g();
                  if(var3) {
                     break;
                  }
               }
            }
         }

      }
   }

   y.c.d b() {
      boolean var2 = h.a;
      y.c.d var1 = (y.c.d)this.a.a();

      ai var10000;
      y.c.d var10001;
      while(true) {
         if(ag.d(this.c)) {
            var10000 = this;
            var10001 = var1;
            if(var2) {
               break;
            }

            if(this.c(var1) && this.c()) {
               this.a.a(var1, Double.MAX_VALUE);
               var1 = (y.c.d)this.a.a();
               if(!var2) {
                  continue;
               }
            }
         }

         var10000 = this;
         var10001 = var1;
         break;
      }

      var10000.b(var10001);
      return var1;
   }

   boolean c() {
      return !this.a.c() && this.a.b() < 1.0D;
   }

   boolean c(y.c.d var1) {
      return var1.c().a() < 2 || var1.d().a() < 2;
   }

   y.c.y a(y.c.q var1) {
      return (y.c.y)this.i.get(this.g.a(var1));
   }

   int d() {
      return this.h;
   }

   y.c.A e() {
      return this.g;
   }
}
