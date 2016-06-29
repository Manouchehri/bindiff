package y.g.a;

import y.c.A;
import y.c.D;
import y.c.x;
import y.c.y;
import y.g.a.d;
import y.g.a.g;
import y.g.a.i;

public class h implements g {
   A a;
   A b;
   y.c.i c;
   D d;
   int e;

   public h(y.c.i var1) {
      this.c = var1;
      this.a = var1.t();
      this.b = var1.t();
      this.d = new D();
      this.e = 0;
   }

   public h(y.c.i var1, y.c.c var2, int var3, int var4) {
      this(var1, var2, var3, var4, (y.c.c)null);
   }

   public h(y.c.i var1, y.c.c var2, int var3, int var4, y.c.c var5) {
      this(var1);
      this.a(var2, var3, var4, var5);
   }

   void a(y.c.c var1, int var2, int var3, y.c.c var4) {
      boolean var10 = d.a;
      y[] var5 = new y[var3 - var2 + 1];
      int var6 = var2;

      while(true) {
         if(var6 <= var3) {
            var5[var6] = new i(var6);
            ++var6;
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         x var11 = this.c.o();

         while(var11.f()) {
            y.c.q var7 = var11.e();
            if(var4 == null || var4.d(var7)) {
               this.a.a(var7, var5[var1.a(var7) - var2].a(var7));
               ++this.e;
            }

            var11.g();
            if(var10) {
               break;
            }
         }

         var6 = 0;
         break;
      }

      while(var6 < var5.length) {
         y var12 = var5[var6];
         y.c.p var8 = this.d.b((Object)var12);
         x var9 = var12.a();

         while(true) {
            if(var9.f()) {
               this.b.a(var9.e(), var8);
               var9.g();
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            ++var6;
            break;
         }

         if(var10) {
            break;
         }
      }

   }

   public void b() {
      this.c.a(this.b);
      this.c.a(this.a);
   }

   public boolean a() {
      return this.e == 0;
   }

   public boolean a(y.c.q var1) {
      return this.b.b(var1) != null;
   }

   public void a(y.c.q var1, int var2) {
      boolean var5 = d.a;
      ++this.e;
      i var3;
      if(this.d.isEmpty()) {
         var3 = new i(var2);
         this.a(this.d.a((Object)var3), var3.b(var1), var1);
      } else {
         var3 = (i)this.d.f();
         if(var3.p() > var2) {
            while(true) {
               if(var3.p() > var2) {
                  var3 = new i(var3.p() - 1);
                  this.d.a((Object)var3);
                  if(var5) {
                     break;
                  }

                  if(!var5) {
                     continue;
                  }
               }

               this.a(this.d.k(), var3.b(var1), var1);
               break;
            }

         } else {
            var3 = (i)this.d.i();
            if(var3.p() < var2) {
               while(true) {
                  if(var3.p() < var2) {
                     var3 = new i(var3.p() + 1);
                     this.d.b((Object)var3);
                     if(var5) {
                        break;
                     }

                     if(!var5) {
                        continue;
                     }
                  }

                  this.a(this.d.l(), var3.b(var1), var1);
                  break;
               }

            } else {
               y.c.p var4 = this.d.k();

               while(true) {
                  if(var4 != null) {
                     var3 = (i)var4.c();
                     if(var5) {
                        break;
                     }

                     if(var3.p() != var2) {
                        var4 = var4.a();
                        if(!var5) {
                           continue;
                        }
                     }
                  }

                  this.a(var4, var3.b(var1), var1);
                  break;
               }

            }
         }
      }
   }

   private void a(y.c.p var1, y.c.p var2, y.c.q var3) {
      this.b.a(var3, var1);
      this.a.a(var3, var2);
   }

   public void b(y.c.q var1, int var2) {
      boolean var7 = d.a;
      y.c.p var3 = (y.c.p)this.a.b(var1);
      y.c.p var4 = (y.c.p)this.b.b(var1);
      i var5 = (i)var4.c();
      int var6 = var5.p();

      while(var2 < var6) {
         this.d(var1);
         --var6;
         if(var7) {
            break;
         }
      }

   }

   public int b(y.c.q var1) {
      y.c.p var2 = (y.c.p)this.b.b(var1);
      i var3 = (i)var2.c();
      return var3.p();
   }

   public void d() {
      this.d.clear();
      this.e = 0;
   }

   public y.c.q c() {
      return this.e();
   }

   public y.c.q e() {
      boolean var2 = d.a;

      while(true) {
         if(((y)this.d.f()).isEmpty()) {
            this.d.g();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         --this.e;
         break;
      }

      y.c.q var1 = ((y)this.d.f()).d();
      this.b.a(var1, (Object)null);
      this.a.a(var1, (Object)null);
      return var1;
   }

   public y.c.q f() {
      boolean var2 = d.a;

      while(true) {
         if(((y)this.d.i()).isEmpty()) {
            this.d.j();
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         --this.e;
         break;
      }

      y.c.q var1 = ((y)this.d.i()).d();
      this.b.a(var1, (Object)null);
      this.a.a(var1, (Object)null);
      return var1;
   }

   public void c(y.c.q var1) {
      y.c.p var2 = (y.c.p)this.a.b(var1);
      y.c.p var3 = (y.c.p)this.b.b(var1);
      i var4 = (i)var3.c();
      Object var5 = null;
      y.c.p var6 = var3.a();
      if(var6 != null) {
         var5 = (y)var6.c();
         this.b.a(var1, var6);
      } else {
         var5 = new i(var4.p() + 1);
         this.b.a(var1, this.d.b(var5));
      }

      var4.h(var2);
      this.a.a(var1, ((y)var5).a(var1));
   }

   public void d(y.c.q var1) {
      boolean var7 = d.a;
      y.c.p var2 = (y.c.p)this.a.b(var1);
      y.c.p var3 = (y.c.p)this.b.b(var1);
      i var4 = (i)var3.c();
      Object var5 = null;
      y.c.p var6 = var3.b();
      if(var6 != null) {
         var5 = (y)var6.c();
         this.b.a(var1, var6);
      } else {
         var5 = new i(var4.p() - 1);
         this.b.a(var1, this.d.a(var5));
      }

      var4.h(var2);
      this.a.a(var1, ((y)var5).a(var1));
      if(y.c.i.g) {
         d.a = !var7;
      }

   }
}
