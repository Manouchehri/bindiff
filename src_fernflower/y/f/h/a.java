package y.f.h;

import java.util.Comparator;
import y.f.h.D;
import y.f.h.N;
import y.f.h.b;
import y.f.h.x;

public class a implements x {
   private x a = null;
   private D b;
   private y.c.i c;
   private y.c.f d;
   private boolean e;

   public a(x var1) {
      this.a = var1;
      this.d = new y.c.f();
      this.e = false;
   }

   public void a(D var1) {
      boolean var10 = N.d;
      y.c.f var2 = null;
      y.c.f var3 = null;
      y.c.f[] var4 = null;
      y.c.y var5 = new y.c.y();
      this.b = var1;
      this.c = var1.g();
      y.c.A var6 = this.c.t();
      var4 = y.a.h.d(var1.g());
      var2 = this.a(this.c);
      int var7 = 0;

      y.c.e var13;
      label126:
      while(true) {
         int var10000 = var7;

         label123:
         while(var10000 < var4.length) {
            var3 = var4[var7];
            var13 = var3.a();
            if(var10) {
               break label126;
            }

            y.c.e var8 = var13;

            while(true) {
               if(var8.f()) {
                  this.c.e(var8.a());
                  var8.g();
                  if(var10) {
                     break;
                  }

                  if(!var10) {
                     continue;
                  }
               }

               var5.clear();
               break;
            }

            y.c.x var12 = this.c.o();

            label132: {
               while(true) {
                  if(var12.f()) {
                     y.c.q var9 = var12.e();
                     var10000 = var9.a();
                     if(var10) {
                        break;
                     }

                     if(var10000 == 0) {
                        var5.add(var9);
                        this.c.c(var12.e());
                     }

                     var12.g();
                     if(!var10) {
                        continue;
                     }
                  }

                  y.g.o.a(this, 0, "Compute Planar Subgraph for biconnected component...");
                  this.a.a(this.b);
                  y.g.o.a(this, 0, "Save planarization...");
                  this.a(var6);
                  y.g.o.a(this, 0, "Store hidden edges...");
                  var8 = this.a.c_().a();

                  while(var8.f()) {
                     this.d.add(var8.a());
                     var8.g();
                     if(var10) {
                        break label132;
                     }

                     if(var10) {
                        break;
                     }
                  }

                  var12 = var5.a();
                  var10000 = var12.f();
                  break;
               }

               while(var10000 != 0) {
                  this.c.d(var12.e());
                  var12.g();
                  if(var10) {
                     continue label126;
                  }

                  if(var10) {
                     break;
                  }

                  var10000 = var12.f();
               }

               var8 = this.c.p();
            }

            while(var8.f()) {
               var10000 = this.b.n(var8.a());
               if(var10) {
                  continue label123;
               }

               if(var10000 != 0) {
                  var2.add(var8.a());
               }

               this.c.d(var8.a());
               var8.g();
               if(var10) {
                  break;
               }
            }

            ++var7;
            if(!var10) {
               continue label126;
            }
            break;
         }

         var13 = var2.a();
         break;
      }

      y.c.e var11 = var13;

      while(true) {
         if(var11.f()) {
            this.c.e(var11.a());
            var11.g();
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         var11 = this.d.a();
         break;
      }

      while(true) {
         if(var11.f()) {
            this.c.d(var11.a());
            var11.g();
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         this.b(var6);
         this.b.l();
         this.c.a(var6);
         this.e = true;
         this.b();
         break;
      }

   }

   public y.c.f c_() {
      if(this.e) {
         return this.d;
      } else {
         throw new RuntimeException("Invalid Execution Order: call \'createPlanarization\' first!");
      }
   }

   protected void a(y.c.A var1) {
      boolean var6 = N.d;
      y.c.x var2 = this.c.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.c.f var4 = (y.c.f)var1.b(var3);
         if(var4 == null) {
            var4 = new y.c.f();
            var1.a(var3, var4);
         }

         y.c.e var5 = var3.l();

         while(true) {
            if(var5.f()) {
               var4.add(var5.a());
               var5.g();
               if(var6) {
                  break;
               }

               if(!var6) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var6) {
            break;
         }
      }

   }

   private void b(y.c.A var1) {
      boolean var5 = N.d;
      y.c.x var2 = this.c.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.c.f var4 = (y.c.f)var1.b(var3);
         var3.b((Comparator)(new b(this, var4)));
         var2.g();
         if(var5) {
            break;
         }
      }

   }

   private y.c.f a(y.c.i var1) {
      boolean var5 = N.d;
      y.c.f var2 = new y.c.f();
      y.c.e var3 = var1.p();

      y.c.f var10000;
      while(true) {
         if(var3.f()) {
            y.c.d var4 = var3.a();
            var10000 = var2;
            if(var5) {
               break;
            }

            var2.add(var4);
            var1.d(var4);
            var3.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   public void b() {
   }
}
