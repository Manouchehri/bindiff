package y.f.h;

import y.f.h.D;
import y.f.h.N;

public class y {
   private y.c.f a = new y.c.f();
   private y.c.h b;
   private y.c.i c;

   public void a(y.c.i var1) {
      boolean var10 = N.d;
      this.c = var1;
      this.b = this.c.u();
      y.c.A var2 = this.c.t();
      y.c.x var3 = this.c.o();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            if(var10) {
               break;
            }

            y.c.e var5 = var4.j();

            label64: {
               label63:
               while(true) {
                  y.c.d var6;
                  y.c.q var7;
                  if(var5.f()) {
                     var6 = var5.a();
                     var7 = var6.a(var4);
                     y.c.d var8 = (y.c.d)var2.b(var7);
                     if(!var10) {
                        if(var8 != var6) {
                           label77: {
                              if(var8 == null) {
                                 var2.a(var7, var6);
                                 if(!var10) {
                                    break label77;
                                 }
                              }

                              if(this.b.b(var8) == null) {
                                 this.b.a(var8, new y.c.f());
                              }

                              y.c.f var9 = (y.c.f)this.b.b(var8);
                              var9.add(var6);
                              this.a.c(var6);
                              this.c.d(var6);
                           }
                        }

                        var5.g();
                        if(!var10) {
                           continue;
                        }

                        var5 = var4.j();
                     } else {
                        var7 = var8.a(var4);
                        var2.a(var7, (Object)null);
                        var5.g();
                        if(var10) {
                           break label64;
                        }

                        if(var10) {
                           break;
                        }
                     }
                  } else {
                     var5 = var4.j();
                  }

                  while(true) {
                     if(!var5.f()) {
                        break label63;
                     }

                     var6 = var5.a();
                     var7 = var6.a(var4);
                     var2.a(var7, (Object)null);
                     var5.g();
                     if(var10) {
                        break label64;
                     }

                     if(var10) {
                        break label63;
                     }
                  }
               }

               var3.g();
            }

            if(!var10) {
               continue;
            }
         }

         this.c.a(var2);
         break;
      }

   }

   public void a(D var1, y.c.f var2) {
      boolean var4 = N.d;
      y.c.e var3 = this.a.a();

      while(var3.f()) {
         var2.add(var3.a());
         var3.g();
         if(var4) {
            break;
         }
      }

   }

   public void a() {
      this.c.a(this.b);
   }
}
