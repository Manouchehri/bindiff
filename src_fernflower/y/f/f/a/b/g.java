package y.f.f.a.b;

import y.f.f.a.b.a;
import y.f.f.a.b.h;
import y.f.f.a.b.l;

public class g extends y.f.h.s implements l {
   private y.c.f n = new y.c.f();
   private y.c.i o;

   public y.c.f a() {
      return this.n;
   }

   public void a(a var1) {
      boolean var6 = a.c;
      this.o = var1.d();
      y.f.h.D var2 = new y.f.h.D(this.o);
      this.n.clear();
      this.d();
      this.e();
      this.g = new h(var1.d(), var1.b());
      this.a(var2);
      y.c.e var3 = this.o.p();

      while(true) {
         if(var3.f()) {
            y.c.d var4 = var3.a();
            boolean var10000 = var2.n(var4);
            if(var6) {
               break;
            }

            if(var10000) {
               var1.a(var4, true);
               var2.a(var4, false);
               y.c.d var5 = var2.h(var4);
               var1.a(var4, var5);
            }

            var3.g();
            if(!var6) {
               continue;
            }
         }

         this.n.addAll(this.c_());
         break;
      }

      var2.e();
   }

   private void d() {
      boolean var2 = a.c;
      y.c.e var1 = this.o.p();

      while(var1.f()) {
         if(var1.a().e()) {
            this.n.c(var1.a());
            this.o.d(var1.a());
         }

         var1.g();
         if(var2) {
            break;
         }
      }

   }

   private void e() {
      boolean var8 = a.c;
      y.c.A var1 = this.o.t();
      y.c.x var2 = this.o.o();

      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            if(var8) {
               break;
            }

            y.c.e var4 = var3.j();

            label60: {
               label59:
               while(true) {
                  y.c.d var5;
                  y.c.q var6;
                  if(var4.f()) {
                     var5 = var4.a();
                     var6 = var5.a(var3);
                     y.c.d var7 = (y.c.d)var1.b(var6);
                     if(!var8) {
                        if(var7 != var5) {
                           label73: {
                              if(var7 == null) {
                                 var1.a(var6, var5);
                                 if(!var8) {
                                    break label73;
                                 }
                              }

                              this.n.c(var5);
                              this.o.d(var5);
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
                           break label60;
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
                        break label59;
                     }

                     var5 = var4.a();
                     var6 = var5.a(var3);
                     var1.a(var6, (Object)null);
                     var4.g();
                     if(var8) {
                        break label60;
                     }

                     if(var8) {
                        break label59;
                     }
                  }
               }

               var2.g();
            }

            if(!var8) {
               continue;
            }
         }

         this.o.a(var1);
         break;
      }

   }
}
