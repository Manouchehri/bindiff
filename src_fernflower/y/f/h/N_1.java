package y.f.h;

import y.f.h.O;
import y.f.h.P;
import y.f.h.T;
import y.f.h.U;
import y.f.h.i;
import y.f.h.l;
import y.f.h.m;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;

public class N {
   protected y.c.i a;
   public y.c.D b;
   protected p c;
   private y.c.h e;
   private final l f = new O(this);
   public static boolean d;

   public N(y.c.i var1) {
      this.a = var1;
      this.e = var1.u();
      this.b = new y.c.D();
   }

   public y.c.i g() {
      return this.a;
   }

   public y.c.d g(y.c.d var1) {
      y.c.d var2 = this.a.a(var1.d(), var1.c());
      this.b(var1, var2);
      this.o(var2).c(true);
      return var2;
   }

   public void b(y.c.d var1, y.c.d var2) {
      this.o(var1).a(var2);
      this.o(var2).a(var1);
   }

   public y.c.d h(y.c.d var1) {
      return this.o(var1).g();
   }

   public q h() {
      return new T(this.b);
   }

   public void b(p var1) {
      this.c = var1;
   }

   public p i() {
      return this.c;
   }

   public int j() {
      return this.b.size();
   }

   public p i(y.c.d var1) {
      return this.o(var1).i();
   }

   public void a(y.c.d var1, p var2) {
      this.o(var1).a(var2);
   }

   public void k() {
      i var1 = new i(this);
      var1.d();
      var1.e();
   }

   public void l() {
      this.a(this.f);
   }

   public void a(l var1) {
      boolean var5 = d;
      this.b = new y.c.D();
      if(this.a.h() != 0) {
         boolean[] var2 = new boolean[this.a.h()];
         y.c.e var3 = this.a.p();

         while(true) {
            if(var3.f()) {
               y.c.d var4 = var3.a();
               if(var5) {
                  break;
               }

               if(!var2[var4.b()]) {
                  this.a(var4, var1, var2);
               }

               var3.g();
               if(!var5) {
                  continue;
               }
            }

            this.b((p)null);
            break;
         }

      }
   }

   public p a(y.c.d var1, l var2, boolean[] var3) {
      boolean var8 = d;
      p var4 = new p();
      y.c.d var5 = var1;
      boolean var6 = true;

      while(true) {
         if(var6) {
            var4.a(var1);
            this.o(var1).a(var4);
            var3[var1.b()] = true;
            y.c.d var7 = var2.a(var1);
            boolean var10000 = var3[var7.b()];
            if(var8) {
               break;
            }

            if(var10000) {
               if(var7 != var5) {
                  throw new RuntimeException("Graph is not Planar !");
               }

               var6 = false;
               if(var8) {
                  throw new RuntimeException("Graph is not Planar !");
               }
            }

            var1 = var7;
            if(!var8) {
               continue;
            }
         }

         this.b.add(var4);
         break;
      }

      return var4;
   }

   public r m() {
      return new U();
   }

   public void a(r var1) {
      ((U)var1).a();
   }

   public y.c.d j(y.c.d var1) {
      y.c.d var2 = var1.g();
      return var2 == null?var1.c().f():var2;
   }

   public y.c.d k(y.c.d var1) {
      y.c.d var2 = var1.i();
      return var2 == null?var1.c().h():var2;
   }

   protected y.c.d l(y.c.d var1) {
      return this.j(this.h(var1));
   }

   public boolean n() {
      boolean var10 = d;
      y.g.o.a(this, 0, "Planarity Check....");
      y.c.i var1 = this.g();
      boolean[] var2 = new boolean[var1.h()];
      int var3 = 0;

      while(true) {
         if(var3 < var1.h()) {
            var2[var3] = false;
            ++var3;
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         q var11 = this.h();

         p var4;
         y.c.e var5;
         y.c.d var6;
         y.c.e var20;
         label241: {
            label240:
            do {
               boolean var10000 = var11.f();

               label237:
               while(true) {
                  if(!var10000) {
                     break label240;
                  }

                  var4 = var11.a();
                  var20 = var4.a();
                  if(var10) {
                     break label241;
                  }

                  var5 = var20;

                  while(true) {
                     if(!var5.f()) {
                        break label237;
                     }

                     var6 = var5.a();
                     var10000 = var2[var6.b()];
                     if(var10) {
                        break;
                     }

                     if(var10000) {
                        y.g.o.a((Object)("Edge " + var6 + " is in two faces !"));
                        return false;
                     }

                     var2[var6.b()] = true;
                     var5.g();
                     if(var10) {
                        break label237;
                     }
                  }
               }

               var11.g();
            } while(!var10);

            var20 = this.a.p();
         }

         y.c.e var12 = var20;

         while(var12.f()) {
            if(!var2[var12.a().b()]) {
               y.g.o.a((Object)("Edge " + var12.a() + " is in no face !"));
               return false;
            }

            var12.g();
            if(var10) {
               break;
            }
         }

         var11 = this.h();

         label210: {
            label209:
            while(true) {
               p var22;
               if(var11.f()) {
                  y.c.d[] var21 = new y.c.d[2];

                  label205:
                  while(true) {
                     y.c.d[] var13 = var21;
                     var22 = var11.a();
                     if(var10) {
                        var4 = var22;
                        var5 = var4.a();
                        break label209;
                     }

                     m var14 = var22.b();

                     do {
                        if(!var14.f()) {
                           var11.g();
                           if(!var10) {
                              continue label209;
                           }

                           var11 = this.h();
                           break label205;
                        }

                        var14.a(var13);
                        var21 = var13;
                        if(var10) {
                           continue label205;
                        }

                        if(var13[0].d() != var13[1].c()) {
                           y.g.o.a((Object)("Face is not a cycle: " + var11.a()));
                           return false;
                        }

                        var14.g();
                     } while(!var10);

                     var11.g();
                     if(!var10) {
                        continue label209;
                     }

                     var11 = this.h();
                     break;
                  }
               } else {
                  var11 = this.h();
               }

               while(var11.f()) {
                  var4 = var11.a();
                  var20 = var4.a();
                  if(var10) {
                     var5 = var20;
                     break label209;
                  }

                  var5 = var20;

                  while(true) {
                     if(var5.f()) {
                        var22 = this.i(var5.a());
                        if(var10) {
                           var5 = var22.a();
                           break label209;
                        }

                        if(var22 != var4) {
                           y.g.o.a((Object)("Edge " + var5.a() + " belongs to wrong face!"));
                           return false;
                        }

                        var5.g();
                        if(!var10) {
                           continue;
                        }
                     }

                     var11.g();
                     if(var10) {
                        var11 = this.h();
                        if(!var11.f()) {
                           break label210;
                        }

                        var4 = var11.a();
                        var5 = var4.a();
                        break label209;
                     }
                     break;
                  }
               }

               var11 = this.h();
               if(!var11.f()) {
                  break label210;
               }

               var4 = var11.a();
               var5 = var4.a();
               break;
            }

            label175:
            while(true) {
               while(true) {
                  if(var5.f()) {
                     var6 = var5.a();
                     var5.c();
                     y.c.d var7 = var5.a();
                     var5.b();
                     y.c.d var8 = this.h(var7);
                     if(!var10) {
                        if(this.j(var8) != var6) {
                           y.g.o.a((Object)("Edge " + var6 + " in wrong order !"));
                           return false;
                        }

                        var5.g();
                        if(!var10) {
                           continue;
                        }

                        var11.g();
                        if(var10) {
                           break label175;
                        }
                        break;
                     }

                     if(var10) {
                        break label175;
                     }
                     break;
                  }

                  var11.g();
                  if(var10) {
                     break label175;
                  }
                  break;
               }

               if(!var11.f()) {
                  break;
               }

               var4 = var11.a();
               var5 = var4.a();
            }
         }

         var3 = var1.f();
         break;
      }

      int var15 = var1.h();
      int var18 = this.h().k();
      int var16 = y.a.h.a(var1).length;
      int var17 = 0;
      y.c.x var19 = var1.o();

      int var23;
      while(true) {
         if(var19.f()) {
            var23 = var19.e().a();
            if(var10) {
               break;
            }

            if(var23 == 0) {
               ++var17;
            }

            var19.g();
            if(!var10) {
               continue;
            }
         }

         var23 = (var15 / 2 + 2 * var16 - var3 - var17 - var18) / 2;
         break;
      }

      int var9 = var23;
      if(var9 == 0) {
         return true;
      } else {
         y.g.o.a((Object)("genus ==  " + var9));
         return false;
      }
   }

   public void e() {
      boolean var3 = d;
      y.c.e var1 = this.a.p();

      N var10000;
      while(true) {
         if(var1.f()) {
            y.c.d var2 = var1.a();
            var10000 = this;
            if(var3) {
               break;
            }

            if(this.n(var2)) {
               this.a.a(var2);
            }

            var1.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.a.a(this.e);
   }

   public boolean o() {
      boolean var5 = d;
      if(this.i() == null) {
         return false;
      } else {
         p var1 = this.i();
         boolean var2 = false;
         q var3 = this.h();

         while(var3.f()) {
            p var4 = var3.a();
            if(var1 == var4) {
               var2 = true;
            }

            var3.g();
            if(var5) {
               break;
            }
         }

         return var2;
      }
   }

   public String toString() {
      boolean var4 = d;
      StringBuffer var1 = new StringBuffer();
      var1.append("Facelist:\n");
      q var2 = this.h();

      StringBuffer var10000;
      while(true) {
         if(var2.f()) {
            p var3 = var2.a();
            var10000 = var1.append("Face :");
            if(var4) {
               break;
            }

            if(var3 == this.c) {
               var1.append("  --> Outer-Face <---");
            }

            var1.append("\n");
            var1.append(var3);
            var1.append("\n");
            var2.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }

   public void m(y.c.d var1) {
      this.a(var1, true);
   }

   public void a(y.c.d var1, boolean var2) {
      this.o(var1).c(var2);
   }

   public boolean n(y.c.d var1) {
      return this.o(var1).h();
   }

   protected P o(y.c.d var1) {
      P var2 = (P)this.e.b(var1);
      if(var2 == null) {
         var2 = this.d_();
         this.e.a(var1, var2);
      }

      return var2;
   }

   protected P d_() {
      return new P();
   }
}
