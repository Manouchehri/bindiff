package y.f.c.a;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import y.f.c.a.N;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bR;
import y.f.c.a.cA;
import y.f.c.a.dA;
import y.f.c.a.dB;
import y.f.c.a.du;
import y.f.c.a.dv;
import y.f.c.a.dw;
import y.f.c.a.dy;
import y.f.c.a.dz;

class dt extends cA implements bR {
   private final boolean c;
   private dA d;
   private dA e;

   dt(boolean var1) {
      this.c = var1;
   }

   public void a() {
      if(this.e != null) {
         throw new IllegalStateException("Internal sequence constraints not disposed.");
      } else {
         this.d = null;
      }
   }

   public boolean a(y.c.i var1, y.c.q var2, y.c.q var3) {
      if(this.d == null) {
         return false;
      } else if(!this.d.a(var2) && !this.d.a(var3)) {
         y.c.q var4 = this.d.c(var2);
         y.c.q var5 = this.d.c(var3);
         dy var6;
         if(var4 != null) {
            var6 = dA.a(this.d, var4);
            if(var5 != null) {
               dy var7 = dA.a(this.d, var5);
               return var6.c > -1?(var7.c > -1?dA.b(this.d)[var6.c][var7.c]:var6.a()):(var7.c > -1?var7.b():var6.b != var7.b);
            } else {
               return var6.a();
            }
         } else if(var5 != null) {
            var6 = dA.a(this.d, var5);
            return var6.b();
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void a(y.c.i var1, int[] var2, int[] var3) {
      boolean var20 = N.x;
      if(this.d == null) {
         throw new IllegalStateException("SequenceConstraintSupport has not been initialized.");
      } else {
         y.c.i var4 = dA.c(this.d);
         y.c.q var5 = dA.d(this.d);
         int[] var6 = new int[var4.f()];
         int[] var7 = new int[var4.f()];
         int var8 = Integer.MIN_VALUE;
         int var9 = Integer.MAX_VALUE;
         int var10 = Integer.MIN_VALUE;
         y.c.A var11 = var4.t();
         int var12 = y.a.h.a(var4, var11);
         y.g.J var13 = new y.g.J(var4, var11);
         y.c.A var14 = var4.t();
         var13.a();
         int var15 = 0;

         while(true) {
            if(var15 < var12) {
               Integer var16 = new Integer(var15);
               var13.b((Object)var16);
               a(var4, var14);
               var13.a((Object)var16);
               ++var15;
               if(var20) {
                  break;
               }

               if(!var20) {
                  continue;
               }
            }

            var13.b();
            break;
         }

         y.c.x var21 = var4.o();

         int var10000;
         int var10001;
         int var19;
         int var22;
         label111:
         while(true) {
            if(var21.f()) {
               var22 = var14.a(var21.e());
               var6[var21.e().d()] = var22;
               var10000 = var10;
               var10001 = var22;
               if(var20) {
                  break;
               }

               if(var10 < var22) {
                  var10 = var22;
               }

               var21.g();
               if(!var20) {
                  continue;
               }
            }

            var4.a(var14);
            var21 = var4.o();

            y.c.q var23;
            while(true) {
               if(var21.f()) {
                  y.c.q var24 = var21.e();
                  int var17 = var10 + 1;
                  var23 = var24;
                  if(var20) {
                     break;
                  }

                  y.c.e var18 = var24.l();

                  while(var18.f()) {
                     var19 = var18.a().d().d();
                     var10000 = var17;
                     var10001 = var6[var19];
                     if(var20) {
                        break label111;
                     }

                     if(var17 > var10001) {
                        var17 = var6[var19];
                     }

                     var18.g();
                     if(var20) {
                        break;
                     }
                  }

                  label89: {
                     var7[var24.d()] = var17 - var6[var24.d()];
                     dy var26 = dA.a(this.d, var24);
                     if(var26.a()) {
                        if(var8 >= var6[var24.d()]) {
                           break label89;
                        }

                        var8 = var6[var24.d()];
                        if(!var20) {
                           break label89;
                        }
                     }

                     if(var26.b() && var9 > var6[var24.d()]) {
                        var9 = var6[var24.d()];
                     }
                  }

                  var21.g();
                  if(!var20) {
                     continue;
                  }
               }

               var23 = var5;
               break;
            }

            if(var23.b() == 0) {
               var8 = -1;
            }

            if(var5.c() == 0) {
               var9 = var10 + 1;
            }

            var10000 = var8;
            var10001 = 1;
            break;
         }

         var15 = var10000 + var10001;
         var22 = var9 - var15;
         y.c.x var25 = var1.o();

         while(var25.f()) {
            label66: {
               y.c.q var27 = this.d.c(var25.e());
               var19 = var27 != null && !this.d.a(var25.e())?var27.d():-1;
               if(var19 > -1) {
                  var2[var25.e().d()] = var6[var19];
                  var3[var25.e().d()] = var7[var19];
                  if(!var20) {
                     break label66;
                  }
               }

               var2[var25.e().d()] = var15;
               var3[var25.e().d()] = var22;
            }

            var25.g();
            if(var20) {
               break;
            }
         }

      }
   }

   private static void a(y.c.i var0, y.c.A var1) {
      boolean var9 = N.x;
      y.c.y var2 = y.a.m.a(var0);
      y.c.x var3 = var2.a();

      do {
         int var10000 = var3.f();

         y.c.q var4;
         int var5;
         label29:
         while(true) {
            if(var10000 == 0) {
               return;
            }

            var4 = var3.e();
            var5 = -1;
            y.c.e var6 = var4.k();

            while(true) {
               if(!var6.f()) {
                  break label29;
               }

               y.c.d var7 = var6.a();
               int var8 = var1.a(var7.c());
               var10000 = var5;
               if(var9) {
                  break;
               }

               if(var5 < var8) {
                  var5 = var8;
               }

               var6.g();
               if(var9) {
                  break label29;
               }
            }
         }

         ++var5;
         var1.a(var4, var5);
         var3.g();
      } while(!var9);

   }

   public void a(y.c.i var1, aU var2, aV var3) {
      boolean var11 = N.x;
      if(this.d != null) {
         if(this.a((Iterator)(new dB(var2)), (int[])null)) {
            du var4 = new du(this);
            y.c.q[] var5 = new y.c.q[0];
            int var6 = 0;
            int var7 = var2.b();

            while(var6 < var7) {
               y.c.y var8 = var2.a(var6).d();
               if(var5.length < var8.size()) {
                  var5 = new y.c.q[var8.size()];
               }

               int var9 = 0;
               y.c.p var10 = var8.k();

               while(true) {
                  if(var10 != null) {
                     var5[var9++] = (y.c.q)var10.c();
                     var10 = var10.a();
                     if(var11) {
                        break;
                     }

                     if(!var11) {
                        continue;
                     }
                  }

                  y.g.e.a(var5, 0, var9, var4);
                  var9 = 0;
                  break;
               }

               var10 = var8.k();

               while(true) {
                  if(var10 != null) {
                     var10.a(var5[var9++]);
                     var10 = var10.a();
                     if(var11) {
                        break;
                     }

                     if(!var11) {
                        continue;
                     }
                  }

                  var2.a(var6).a((y.c.D)var8);
                  ++var6;
                  break;
               }

               if(var11) {
                  break;
               }
            }

         }
      }
   }

   public Comparator a(y.c.i var1, y.c.D[] var2, int[] var3) {
      if(this.d == null) {
         throw new IllegalStateException("SequenceConstraintSupport has not been initialized.");
      } else {
         this.a((Iterator)(new dz(var2)), (int[])var3);
         return new dv(this);
      }
   }

   private boolean a(Iterator var1, int[] var2) {
      boolean var16 = N.x;
      y.c.i var3 = dA.c(this.d);
      boolean var4 = false;
      HashSet var5 = new HashSet();
      y.c.D var6 = new y.c.D();

      label114:
      while(var1.hasNext()) {
         Object var10000 = var1.next();

         label112:
         while(true) {
            y.c.D var7 = (y.c.D)var10000;
            if(var7.size() < 2) {
               break;
            }

            Object var8;
            label91: {
               if(var2 != null) {
                  y.c.q[] var9 = new y.c.q[var7.size()];
                  var7.toArray(var9);
                  y.g.e.a((Object[])var9, new dw(this, var2));
                  var8 = new dz(var9);
                  if(!var16) {
                     break label91;
                  }
               }

               var8 = var7.iterator();
            }

            y.c.y var20 = new y.c.y();
            var20.add(((Iterator)var8).next());

            while(true) {
               if(!((Iterator)var8).hasNext()) {
                  continue label114;
               }

               y.c.q var10 = (y.c.q)((Iterator)var8).next();
               var10000 = var20.a();
               if(var16) {
                  break;
               }

               Object var11 = var10000;

               while(((y.c.x)var11).f()) {
                  y.c.q var12 = ((y.c.x)var11).e();
                  y.c.q var13 = this.d.c(var12);
                  var10000 = var13;
                  if(var16) {
                     continue label112;
                  }

                  if(var13 == null) {
                     var13 = this.d.d(var12);
                  }

                  y.c.q var14 = this.d.c(var10);
                  if(var14 == null) {
                     var14 = this.d.d(var10);
                  }

                  y.c.d var15 = var3.a(var13, var14);
                  var5.add(var15);
                  var6.add(var15);
                  ((y.c.x)var11).g();
                  if(var16) {
                     break;
                  }
               }

               var20.add(var10);
               if(var16) {
                  break label114;
               }
            }
         }
      }

      int[] var17 = dA.e(this.d);
      if(var17.length < var3.f()) {
         var17 = new int[var3.f()];
      }

      label79: {
         if(!y.a.m.a(var3, var17)) {
            var4 = true;
            y.c.h var18 = var3.u();
            y.c.h var21 = var3.u();
            int var23 = 2 * var5.size();
            y.c.e var24 = var3.p();

            while(var24.f()) {
               label72: {
                  if(var5.contains(var24.a())) {
                     var21.a(var24.a(), 1.0D);
                     if(!var16) {
                        break label72;
                     }
                  }

                  var21.a(var24.a(), (double)var23);
               }

               var24.g();
               if(var16) {
                  break;
               }
            }

            y.a.c.a(var3, var18, var21);
            Iterator var25 = var6.iterator();

            while(var25.hasNext()) {
               y.c.d var26 = (y.c.d)var25.next();
               if(var18.d(var26)) {
                  var3.a(var26);
                  var25.remove();
                  if(var16) {
                     break label79;
                  }

                  if(var16) {
                     break;
                  }
               }
            }

            if(!y.a.m.a(var3, var17)) {
               throw new IllegalArgumentException("Cyclic sequence constraints!");
            }
         }

         dA.a(this.d, var17);
      }

      Iterator var19 = var6.iterator();

      while(var19.hasNext()) {
         y.c.d var22 = (y.c.d)var19.next();
         var3.a(var22);
         if(var16) {
            break;
         }
      }

      return var4;
   }

   public void b(y.c.i var1, aV var2, boolean var3) {
      if(this.e != null) {
         this.d = this.e.a(this.d);
         this.e = null;
      }

      this.d.b();
   }

   public void a(y.c.i var1, aV var2, boolean var3) {
      this.e = this.d;
      this.d = new dA(var1, var2, var3, this.c);
      this.d.a();
   }

   static dA a(dt var0) {
      return var0.d;
   }
}
