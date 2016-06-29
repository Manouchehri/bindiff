package y.g;

import y.g.M;
import y.g.p;

public class I {
   private y.c.i c;
   protected y.c.f a;
   protected y.c.y b;
   private boolean d = true;

   public I(y.c.i var1) {
      this.c = var1;
      this.a = new y.c.f();
      this.b = new y.c.y();
   }

   public void a() {
      boolean var2 = p.c;
      y.c.x var1 = this.c.o();

      while(var1.f()) {
         this.a(var1.e());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void b() {
      boolean var2 = p.c;
      y.c.e var1 = this.c.p();

      while(var1.f()) {
         this.a(var1.a());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void c() {
      boolean var2 = p.c;
      y.c.e var1 = this.c.p();

      while(var1.f()) {
         if(var1.a().e()) {
            this.a(var1.a());
         }

         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void d() {
      this.c();
      this.e();
   }

   public void e() {
      boolean var8 = p.c;
      y.c.A var1 = this.c.t();
      y.c.x var2 = this.c.o();

      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            if(var8) {
               break;
            }

            y.c.e var4 = var3.j();

            label59: {
               label58:
               while(true) {
                  y.c.d var5;
                  y.c.q var6;
                  if(var4.f()) {
                     var5 = var4.a();
                     var6 = var5.a(var3);
                     y.c.d var7 = (y.c.d)var1.b(var6);
                     if(!var8) {
                        if(var7 != var5) {
                           if(var7 == null) {
                              var1.a(var6, var5);
                              if(var8) {
                                 this.a(var5);
                              }
                           } else {
                              this.a(var5);
                           }
                        }

                        var4.g();
                        if(!var8) {
                           continue;
                        }

                        var4 = var3.j();
                     } else {
                        var6 = var7.a(var3);
                        var1.a(var6, (Object)null);
                        var4.g();
                        if(var8) {
                           break label59;
                        }

                        if(var8) {
                           break;
                        }
                     }
                  } else {
                     var4 = var3.j();
                  }

                  while(true) {
                     if(!var4.f()) {
                        break label58;
                     }

                     var5 = var4.a();
                     var6 = var5.a(var3);
                     var1.a(var6, (Object)null);
                     var4.g();
                     if(var8) {
                        break label59;
                     }

                     if(var8) {
                        break label58;
                     }
                  }
               }

               var2.g();
            }

            if(!var8) {
               continue;
            }
         }

         this.c.a(var1);
         break;
      }

   }

   public void f() {
      this.g();
      this.h();
   }

   public void g() {
      boolean var2 = p.c;

      while(!this.b.isEmpty()) {
         y.c.q var1 = this.b.d();
         if(!this.c.f(var1)) {
            this.b(var1);
            if(var2) {
               break;
            }
         }
      }

   }

   public void h() {
      boolean var2 = p.c;

      while(!this.a.isEmpty()) {
         y.c.d var1 = this.a.d();
         if(!this.c.f(var1)) {
            this.b(var1);
            if(var2) {
               break;
            }
         }
      }

   }

   public void a(y.c.q var1) {
      boolean var4 = p.c;
      y.c.d var2 = var1.g();

      boolean var10000;
      label48:
      while(true) {
         y.c.d var3;
         if(var2 != null) {
            var3 = var2;
            var2 = var2.h();
            this.a.c(var3);
            var10000 = this.d;
            if(var4) {
               break;
            }

            if(var10000) {
               this.c.d(var3);
               if(!var4) {
                  continue;
               }
            }

            this.c.a(var3);
            if(!var4) {
               continue;
            }
         }

         var2 = var1.f();

         while(var2 != null) {
            var3 = var2;
            var2 = var2.g();
            this.a.c(var3);
            var10000 = this.d;
            if(var4) {
               break label48;
            }

            if(var10000) {
               this.c.d(var3);
               if(!var4) {
                  continue;
               }
            }

            this.c.a(var3);
            if(var4) {
               break;
            }
         }

         this.b.c(var1);
         var10000 = this.d;
         break;
      }

      if(var10000) {
         this.c.c(var1);
         if(!var4) {
            return;
         }
      }

      this.c.a(var1);
   }

   public void a(y.c.d var1) {
      this.a.c(var1);
      if(this.d) {
         this.c.d(var1);
         if(!p.c) {
            return;
         }
      }

      this.c.a(var1);
   }

   public void a(y.c.f var1) {
      boolean var3 = p.c;
      y.c.p var2 = var1.k();

      while(var2 != null) {
         this.a((y.c.d)var2.c());
         var2 = var2.a();
         if(var3) {
            break;
         }
      }

   }

   public void a(y.c.y var1) {
      boolean var3 = p.c;
      y.c.p var2 = var1.k();

      while(var2 != null) {
         this.a((y.c.q)var2.c());
         var2 = var2.a();
         if(var3) {
            break;
         }
      }

   }

   public void a(y.c.e var1) {
      boolean var2 = p.c;

      while(var1.f()) {
         this.a(var1.a());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public static void a(y.c.i var0, y.c.e var1) {
      boolean var3 = p.c;
      var1.i();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         if(!var0.f(var2.c())) {
            var0.d(var2.c());
         }

         if(!var0.f(var2.d())) {
            var0.d(var2.d());
         }

         if(!var0.f(var2)) {
            var0.e(var2);
         }

         var1.g();
         if(var3) {
            break;
         }
      }

   }

   public y.c.i i() {
      return this.c;
   }

   protected void b(y.c.d var1) {
      if(this.d) {
         this.c.e(var1);
         if(!p.c) {
            return;
         }
      }

      this.c.b(var1);
   }

   public void c(y.c.d var1) {
      if(var1.a() == null) {
         this.b(var1);
      }

      this.a.remove(var1);
   }

   public void a(y.c.y var1, boolean var2) {
      boolean var7 = p.c;
      y.c.y var3 = new y.c.y();
      y.c.p var4 = var1.k();

      y.c.i var10000;
      while(true) {
         if(var4 != null) {
            y.c.q var5 = (y.c.q)var4.c();
            var10000 = var5.e();
            if(var7) {
               break;
            }

            if(var10000 == null) {
               this.b(var5);
               var3.add(var5);
            }

            var4 = var4.a();
            if(!var7) {
               continue;
            }
         }

         var10000 = this.c;
         break;
      }

      y.c.A var8 = M.a(new boolean[var10000.e()]);
      y.c.p var9 = var3.k();

      while(true) {
         if(var9 != null) {
            var8.a(var9.c(), true);
            var9 = var9.a();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var9 = this.b.k();
         break;
      }

      Object var10;
      while(true) {
         if(var9 != null) {
            var10 = ((y.c.q)var9.c()).e();
            if(var7) {
               break;
            }

            if(var10 == this.c) {
               this.b.h(var9);
            }

            var9 = var9.a();
            if(!var7) {
               continue;
            }
         }

         if(!var2) {
            return;
         }

         var9 = this.a.k();
         if(var9 == null) {
            return;
         }

         var10 = var9.c();
         break;
      }

      while(true) {
         y.c.d var6 = (y.c.d)var10;
         if(var6.c().e() == this.c && var6.d().e() == this.c && (var8.d(var6.d()) || var8.d(var6.c()))) {
            this.a.h(var9);
            this.b(var6);
         }

         var9 = var9.a();
         if(var7 || var9 == null) {
            return;
         }

         var10 = var9.c();
      }
   }

   public void a(y.c.q var1, boolean var2) {
      boolean var5 = p.c;
      if(var1.e() == null) {
         this.b(var1);
      }

      this.b.remove(var1);
      if(var2) {
         y.c.p var3 = this.a.k();

         while(var3 != null) {
            y.c.d var4 = (y.c.d)var3.c();
            if(var4.c() == var1 && var4.d().e() == this.c || var4.d() == var1 && var4.c().e() == this.c) {
               this.a.h(var3);
               this.b(var4);
            }

            var3 = var3.a();
            if(var5) {
               break;
            }
         }
      }

   }

   protected void b(y.c.q var1) {
      if(this.d) {
         this.c.d(var1);
         if(!p.c) {
            return;
         }
      }

      this.c.b(var1);
   }
}
