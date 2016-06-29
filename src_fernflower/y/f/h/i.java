package y.f.h;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import y.f.h.D;
import y.f.h.N;
import y.f.h.Q;
import y.f.h.j;
import y.f.h.p;
import y.f.h.q;

public class i extends N implements Q {
   private y.c.i e;
   private y.c.h f;
   private y.c.h g;
   private Map h;
   private y.c.A i;
   private boolean j;
   private N k;

   public i(N var1) {
      this(var1, (y.c.f)null);
   }

   public i(N var1, y.c.f var2) {
      y.c.e var3;
      boolean var4;
      label39: {
         var4 = N.d;
         super(new y.c.i());
         this.k = var1;
         this.e = this.k.g();
         if(var2 != null) {
            var3 = var2.a();

            while(var3.f()) {
               this.e.e(var3.a());
               var3.g();
               if(var4) {
                  break label39;
               }

               if(var4) {
                  break;
               }
            }
         }

         this.h = new HashMap();
         this.f = super.g().u();
         this.g = y.g.M.b();
         this.i = super.g().t();
      }

      if(var2 != null) {
         var3 = var2.a();

         while(var3.f()) {
            this.e.d(var3.a());
            var3.g();
            if(var4) {
               return;
            }

            if(var4) {
               break;
            }
         }
      }

      this.c();
   }

   public void a() {
      if(this.k instanceof D) {
         ((D)this.k).a((Q)this);
      }

   }

   public void b() {
      if(this.k instanceof D) {
         ((D)this.k).b((Q)this);
      }

   }

   public y.c.q a(p var1) {
      if(!this.j) {
         throw new RuntimeException("Wrong execution order: call computeDualGraph() first!");
      } else {
         return (y.c.q)this.h.get(var1);
      }
   }

   public y.c.d a(y.c.d var1) {
      if(this.j) {
         return (y.c.d)this.f.b(var1);
      } else {
         throw new RuntimeException("Wrong execution order: call computeDualGraph() first!");
      }
   }

   public y.c.d b(y.c.d var1) {
      if(!this.j) {
         throw new RuntimeException("Wrong execution order: call computeDualGraph() first!");
      } else {
         return (y.c.d)this.g.b(var1);
      }
   }

   public void c() {
      boolean var11 = N.d;
      y.c.i var1 = this.g();
      var1.j();
      this.h.clear();
      q var2 = this.k.h();

      p var3;
      y.c.q var4;
      while(true) {
         if(var2.f()) {
            var3 = var2.a();
            var4 = var1.d();
            this.a(var3, var4);
            var2.g();
            if(var11) {
               break;
            }

            if(!var11) {
               continue;
            }
         }

         var2 = this.k.h();
         break;
      }

      boolean var13;
      label56: {
         label55:
         while(true) {
            if(var2.f()) {
               var3 = var2.a();
               Object var10000 = this.h.get(var3);

               label50:
               while(true) {
                  var4 = (y.c.q)var10000;
                  y.c.e var5 = var3.a();
                  if(var11) {
                     break label55;
                  }

                  var5.j();

                  while(true) {
                     if(!var5.f()) {
                        break label50;
                     }

                     y.c.d var6 = null;
                     y.c.d var7 = var5.a();
                     y.c.d var8 = this.k.h(var7);
                     var6 = (y.c.d)this.g.b(var8);
                     y.c.q var9 = (y.c.q)this.h.get(this.k.i(var8));
                     y.c.d var10 = var1.a(var4, var9);
                     var10000 = var6;
                     if(var11) {
                        break;
                     }

                     if(var6 != null) {
                        this.b(var6, var10);
                        if(var6.c() != var10.d() && var6.d() != var10.c()) {
                           throw new RuntimeException(" ***** Error setting reverse edge *****");
                        }
                     }

                     this.a(var7, var10);
                     var5.h();
                     if(var11) {
                        break label50;
                     }
                  }
               }

               var2.g();
               if(!var11) {
                  continue;
               }
            }

            if(var1.h() == this.e.h() && this.k.b.size() == this.h.size()) {
               var13 = true;
               break label56;
            }
            break;
         }

         var13 = false;
      }

      boolean var12 = var13;
      if(!var12) {
         throw new RuntimeException("Error computing dual graph!");
      } else {
         this.j = true;
      }
   }

   public void d() {
      boolean var7 = N.d;
      y.c.h var1 = y.g.M.b(new int[this.e.g()]);
      this.l();
      q var2 = this.h();

      while(var2.f()) {
         p var3 = var2.a();
         y.c.e var4 = var3.a();
         int var5 = 0;

         while(true) {
            if(var4.f()) {
               y.c.d var6 = (y.c.d)this.f.b(var4.a());
               var1.a(this.k.h(var6), var5++);
               var4.g();
               if(var7) {
                  break;
               }

               if(!var7) {
                  continue;
               }
            }

            var2.g();
            break;
         }

         if(var7) {
            break;
         }
      }

      y.c.x var8 = this.e.o();

      while(var8.f()) {
         var8.e().b((Comparator)(new j(this, var1)));
         var8.g();
         if(var7) {
            break;
         }
      }

   }

   public void a(y.c.d var1, y.c.d[] var2) {
      boolean var17 = N.d;
      y.c.d var3 = this.b(var1);
      if(var3 != null) {
         y.c.d var4 = this.k.h(var1);
         p var5 = this.k.i(var1);
         y.c.q var6 = this.a(var5);
         p var7 = this.k.i(var4);
         y.c.q var8 = this.a(var7);
         y.c.d var9 = this.b(var4);
         y.c.d var10 = var3;
         y.c.d var11 = var9;
         int var12 = 0;

         while(true) {
            if(var12 < var2.length) {
               y.c.d var13 = var2[var12];
               y.c.d var14 = this.k.h(var13);
               y.c.d var15 = this.a.a(var6, var10, var8, (y.c.d)null, 0, 0);
               y.c.d var16 = this.a.a(var8, var11, var6, (y.c.d)null, 1, 1);
               this.b(var15, var16);
               this.a(var13, var15);
               this.a(var14, var16);
               var10 = var15;
               ++var12;
               if(var17) {
                  break;
               }

               if(!var17) {
                  continue;
               }
            }

            this.g.a(var1, (Object)null);
            this.g.a(var4, (Object)null);
            this.a.a(var3);
            this.a.a(var9);
            this.f();
            break;
         }

      }
   }

   public void a(y.c.d[] var1, y.c.d var2) {
      boolean var15 = N.d;
      y.c.d var3 = this.k.h(var2);
      p var4 = this.k.i(var2);
      y.c.q var5 = this.a(var4);
      p var6 = this.k.i(var3);
      y.c.q var7 = this.a(var6);
      y.c.d var8 = this.a.a(var5, var7);
      y.c.d var9 = this.a.a(var7, var5);
      this.b(var8, var9);
      this.a(var2, var8);
      this.a(var3, var9);
      int var10 = 0;

      while(true) {
         if(var10 < var1.length) {
            y.c.d var11 = var1[var10];
            y.c.d var12 = this.k.h(var11);
            y.c.d var13 = this.b(var11);
            y.c.d var14 = this.b(var12);
            this.g.a(var11, (Object)null);
            this.g.a(var12, (Object)null);
            this.a.a(var13);
            this.a.a(var14);
            ++var10;
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         this.f();
         break;
      }

   }

   public void a(y.c.d var1, p[] var2, p[] var3) {
      boolean var16 = N.d;
      y.c.d var4 = this.k.h(var1);
      y.c.q[] var5 = new y.c.q[var2.length];
      int var6 = 0;

      y.c.q[] var10000;
      while(true) {
         if(var6 < var2.length) {
            var10000 = var5;
            if(var16) {
               break;
            }

            var5[var6] = (y.c.q)this.h.get(var2[var6]);
            ++var6;
            if(!var16) {
               continue;
            }
         }

         var10000 = new y.c.q[var3.length];
         break;
      }

      y.c.q[] var17 = var10000;
      int var7 = 0;

      while(var7 < var3.length) {
         var17[var7] = this.a.d();
         this.a(var3[var7], var17[var7]);
         ++var7;
         if(var16) {
            break;
         }
      }

      y.c.d var18 = null;
      y.c.d var8 = null;
      int var9 = 0;

      while(true) {
         if(var9 < var3.length) {
            y.c.q var10 = var17[var9];
            if(var16) {
               break;
            }

            y.c.e var11 = var3[var9].a();

            label63: {
               while(var11.f()) {
                  y.c.d var12 = var11.a();
                  if(var16) {
                     break label63;
                  }

                  label90: {
                     if(var12 == var1) {
                        var18 = this.a.a(var10, this.a(this.k.i(var4)));
                        if(!var16) {
                           break label90;
                        }
                     }

                     if(var12 == var4) {
                        var8 = this.a.a(var10, this.a(this.k.i(var1)));
                        if(!var16) {
                           break label90;
                        }
                     }

                     y.c.d var13 = this.k.h(var11.a());
                     y.c.d var14 = this.b(var12);
                     y.c.d var15 = this.b(var13);
                     this.a.a(var14, var10, var14.d());
                     this.a.a(var15, var15.c(), var10);
                  }

                  var11.g();
                  if(var16) {
                     break;
                  }
               }

               ++var9;
            }

            if(!var16) {
               continue;
            }
         }

         this.b(var18, var8);
         this.a(var1, var18);
         this.a(var4, var8);
         break;
      }

      var9 = 0;

      while(true) {
         if(var9 < var5.length) {
            this.a.a(var5[var9]);
            ++var9;
            if(var16) {
               break;
            }

            if(!var16) {
               continue;
            }
         }

         this.f();
         break;
      }

   }

   public void b(y.c.d var1, p[] var2, p[] var3) {
      boolean var13 = N.d;
      y.c.q[] var4 = new y.c.q[var2.length];
      int var5 = 0;

      y.c.q[] var10000;
      while(true) {
         if(var5 < var2.length) {
            var10000 = var4;
            if(var13) {
               break;
            }

            var4[var5] = (y.c.q)this.h.get(var2[var5]);
            ++var5;
            if(!var13) {
               continue;
            }
         }

         var10000 = new y.c.q[var3.length];
         break;
      }

      y.c.q[] var14 = var10000;
      int var6 = 0;

      while(true) {
         if(var6 < var3.length) {
            var14[var6] = this.a.d();
            this.a(var3[var6], var14[var6]);
            ++var6;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var6 = 0;
         break;
      }

      while(true) {
         if(var6 < var3.length) {
            y.c.q var7 = var14[var6];
            if(var13) {
               break;
            }

            y.c.e var8 = var3[var6].a();

            label48: {
               while(var8.f()) {
                  y.c.d var9 = var8.a();
                  y.c.d var10 = this.k.h(var8.a());
                  y.c.d var11 = this.b(var9);
                  y.c.d var12 = this.b(var10);
                  this.a.a(var11, var7, var11.d());
                  this.a.a(var12, var12.c(), var7);
                  var8.g();
                  if(var13) {
                     break label48;
                  }

                  if(var13) {
                     break;
                  }
               }

               ++var6;
            }

            if(!var13) {
               continue;
            }
         }

         var6 = 0;
         break;
      }

      while(true) {
         if(var6 < var4.length) {
            this.a.a(var4[var6]);
            ++var6;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         this.f();
         break;
      }

   }

   public void e() {
      super.e();
      y.c.i var1 = this.g();
      var1.a(this.f);
      var1.a(this.i);
      this.h.clear();
   }

   private void a(p var1, y.c.q var2) {
      this.h.put(var1, var2);
      this.i.a(var2, var1);
   }

   private void a(y.c.d var1, y.c.d var2) {
      this.f.a(var2, var1);
      this.g.a(var1, var2);
   }

   protected void f() {
   }
}
