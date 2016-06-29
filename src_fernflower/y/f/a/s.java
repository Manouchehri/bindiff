package y.f.a;

import java.util.HashMap;
import java.util.Map;
import y.f.a.f;
import y.g.I;
import y.g.J;
import y.g.M;

class s extends y.f.w {
   static final Object k = "y.layout.circular.CircularLayouter.CIRCULAR_CUSTOM_GROUPS_DPKEY";
   private y.c.A m;
   private y.c.A n;
   private y.c.A o;
   private y.c.A p;
   private y.c.A q;
   private y.c.h r;
   private y.c.i s;
   private Map t;
   byte l;
   private y.c.q u;
   private I v;
   private J w;
   private y.c.f x;

   public s(y.c.i var1) {
      this.s = var1;
      this.m = this.t();
      this.r = this.u();
   }

   y.c.y t(y.c.q var1) {
      y.c.y var2 = (y.c.y)this.m.b(var1);
      return var2;
   }

   y.c.y u(y.c.q var1) {
      return (y.c.y)this.p.b(var1);
   }

   public void F() {
      int var13 = f.u;
      if(this.n == null) {
         this.n = this.t();
      }

      int[] var1 = new int[this.s.f() + 1];
      int var2 = 1;
      y.c.x var3 = this.o();

      label65:
      while(var3.f()) {
         y.c.y var4 = this.t(var3.e());
         y.c.x var5 = var4.a();

         while(var5.f()) {
            y.c.q var6 = var5.e();
            var1[var6.d()] = var2;
            var5.g();
            if(var13 != 0) {
               continue label65;
            }

            if(var13 != 0) {
               break;
            }
         }

         y.c.f var14 = new y.c.f();
         y.c.x var15 = var4.a();

         label54:
         while(true) {
            int var10000 = var15.f();

            label51:
            while(var10000 != 0) {
               y.c.q var7 = var15.e();
               int var8 = var1[var7.d()];
               if(var13 != 0) {
                  break label54;
               }

               y.c.e var9 = var7.l();

               while(var9.f()) {
                  y.c.d var10 = var9.a();
                  y.c.q var11 = var10.d();
                  int var12 = var1[var11.d()];
                  var10000 = var12;
                  if(var13 != 0) {
                     continue label51;
                  }

                  if(var12 == var8) {
                     var14.c(var10);
                  }

                  var9.g();
                  if(var13 != 0) {
                     break;
                  }
               }

               var15.g();
               if(var13 == 0) {
                  continue label54;
               }
               break;
            }

            this.n.a(var3.e(), var14);
            var3.g();
            ++var2;
            break;
         }

         if(var13 != 0) {
            break;
         }
      }

   }

   void G() {
      int var9 = f.u;
      this.p = this.t();
      this.q = this.s.t();
      y.c.x var1 = this.o();

      s var10000;
      while(true) {
         if(var1.f()) {
            y.c.q var2 = var1.e();
            var10000 = this;
            if(var9 != 0) {
               break;
            }

            this.p.a(var2, new y.c.y());
            var1.g();
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var10 = var10000.p();

      do {
         boolean var12 = var10.f();

         label38:
         while(true) {
            if(!var12) {
               return;
            }

            y.c.d var11 = var10.a();
            y.c.f var3 = this.i(var11);
            y.c.e var4 = var3.a();

            while(true) {
               if(!var4.f()) {
                  break label38;
               }

               y.c.d var5 = var4.a();
               y.c.q var6 = var5.c();
               y.c.q var7 = var5.d();
               var12 = this.q.d(var6);
               if(var9 != 0) {
                  break;
               }

               y.c.q var8;
               if(!var12) {
                  var8 = (y.c.q)this.o.b(var6);
                  this.u(var8).add(var6);
                  this.q.a(var6, true);
               }

               if(!this.q.d(var7)) {
                  var8 = (y.c.q)this.o.b(var7);
                  this.u(var8).add(var7);
                  this.q.a(var7, true);
               }

               var4.g();
               if(var9 != 0) {
                  break label38;
               }
            }
         }

         var10.g();
      } while(var9 == 0);

   }

   y.c.f i(y.c.d var1) {
      return (y.c.f)this.r.b(var1);
   }

   void a(y.c.d var1, y.c.f var2) {
      this.r.a(var1, var2);
   }

   public void a(byte var1) {
      int var3 = f.u;
      this.l = var1;
      this.o = this.s.t();
      switch(var1) {
      case 2:
         this.a(this.s.c(k));
         if(var3 == 0) {
            break;
         }
      case 0:
         y.c.A var2 = this.s.t();
         y.a.j.a(this.s, var2);
         this.a(var2);
         this.s.a(var2);
         if(var3 == 0) {
            break;
         }
      case 1:
         this.I();
      }

      this.w = new J(this.s, this.o);
      this.G();
      this.J();
      this.F();
      this.O();
   }

   protected void a(y.c.c var1) {
      this.b(var1);
      this.H();
   }

   void b(y.c.c var1) {
      int var10 = f.u;
      HashMap var2 = new HashMap();
      y.c.x var4 = this.s.o();

      y.c.q var7;
      while(var4.f()) {
         label42: {
            y.c.q var5 = var4.e();
            Object var6 = var1.b(var5);
            y.c.y var3;
            if(var6 != null) {
               if(!var2.containsKey(var6)) {
                  var7 = this.d();
                  var2.put(var6, var7);
                  var3 = new y.c.y();
                  this.m.a(var7, var3);
                  var3.add(var5);
                  this.o.a(var5, var7);
                  if(var10 == 0) {
                     break label42;
                  }
               }

               Object var14 = var2.get(var6);
               var3 = (y.c.y)this.m.b(var14);
               var3.add(var5);
               this.o.a(var5, var14);
               if(var10 == 0) {
                  break label42;
               }
            }

            var7 = this.d();
            var3 = new y.c.y();
            this.m.a(var7, var3);
            var3.add(var5);
            this.o.a(var5, var7);
         }

         var4.g();
         if(var10 != 0) {
            break;
         }
      }

      y.c.e var11 = this.s.p();

      while(var11.f()) {
         y.c.d var12 = var11.a();
         y.c.q var13 = (y.c.q)this.o.b(var12.c());
         var7 = (y.c.q)this.o.b(var12.d());
         if(var13 != var7) {
            label26: {
               y.c.d var8 = var13.c(var7);
               if(var8 == null) {
                  var8 = this.a(var13, var7);
                  y.c.f var9 = new y.c.f();
                  var9.add(var12);
                  this.a(var8, var9);
                  if(var10 == 0) {
                     break label26;
                  }
               }

               this.i(var8).add(var12);
            }
         }

         var11.g();
         if(var10 != 0) {
            break;
         }
      }

   }

   protected void H() {
      int var6 = f.u;
      y.c.h var1 = this.u();
      y.c.e var2 = this.p();

      y.c.f var10000;
      while(true) {
         if(var2.f()) {
            y.c.d var3 = var2.a();
            var10000 = this.i(var3);
            if(var6 != 0) {
               break;
            }

            int var4 = var10000.size();
            var1.a(var3, 1.0D / (double)(var4 * var4));
            var2.g();
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = y.a.y.a(this, var1);
         break;
      }

      y.c.f var7 = var10000;
      boolean[] var8 = new boolean[this.g()];
      this.x = new y.c.f();
      y.c.e var9 = var7.a();

      while(true) {
         if(var9.f()) {
            var8[var9.a().b()] = true;
            var9.g();
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         var9 = this.p();
         break;
      }

      while(true) {
         if(var9.f()) {
            y.c.d var5 = var9.a();
            if(var6 != 0) {
               break;
            }

            if(!var8[var5.b()]) {
               this.x.add(var5);
            }

            var9.g();
            if(var6 == 0) {
               continue;
            }
         }

         this.v = new I(this);
         this.v.a(this.x);
         this.a(var1);
         break;
      }

   }

   void I() {
      int var20 = f.u;
      y.c.A var1 = this.s.t();
      y.c.h var2 = M.b(new int[this.s.g()]);
      int var3 = y.a.h.a(this.s, var2, var1);
      y.c.f[] var4 = y.a.h.a(this.s, var2, var3);
      HashMap var5 = new HashMap();
      boolean[] var6 = new boolean[this.s.f()];
      y.c.x var7 = this.s.o();

      y.c.q var9;
      y.c.y var10;
      byte var10000;
      while(true) {
         if(var7.f()) {
            y.c.q var8 = var7.e();
            var10000 = var1.d(var8);
            if(var20 != 0) {
               break;
            }

            if(var10000 != 0) {
               var9 = this.d();
               var10 = new y.c.y();
               var10.add(var8);
               this.m.a(var9, var10);
               var5.put(var8, var9);
               this.o.a(var8, var9);
            }

            var7.g();
            if(var20 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var21 = var10000;

      int var33;
      label163:
      while(true) {
         var33 = var21;

         label160:
         while(var33 < var4.length) {
            y.c.f var23 = var4[var21];
            var33 = var23.size();
            if(var20 != 0) {
               break label163;
            }

            label180: {
               if(var33 == 1) {
                  y.c.d var25 = var23.b();
                  if(var1.d(var25.c()) && var1.d(var25.d())) {
                     y.c.d var27 = this.a((y.c.q)var5.get(var25.c()), (y.c.q)var5.get(var25.d()));
                     y.c.f var11 = new y.c.f();
                     var11.add(var25);
                     this.a(var27, var11);
                     if(var20 == 0) {
                        break label180;
                     }
                  }
               }

               var9 = this.d();
               var10 = new y.c.y();
               y.c.e var29 = var23.a();

               while(var29.f()) {
                  y.c.d var12 = var29.a();
                  y.c.q var13 = var12.c();
                  var33 = var6[var13.d()];
                  if(var20 != 0) {
                     continue label160;
                  }

                  if(var33 == 0 && !var1.d(var13)) {
                     var10.add(var13);
                     var6[var13.d()] = true;
                     this.o.a(var13, var9);
                  }

                  var13 = var12.d();
                  if(!var6[var13.d()] && !var1.d(var13)) {
                     var10.add(var13);
                     var6[var13.d()] = true;
                     this.o.a(var13, var9);
                  }

                  var29.g();
                  if(var20 != 0) {
                     break;
                  }
               }

               this.m.a(var9, var10);
               var5.put(var23, var9);
            }

            ++var21;
            if(var20 == 0) {
               continue label163;
            }
            break;
         }

         var33 = this.s.h();
         break;
      }

      y.c.f[] var22 = new y.c.f[var33];
      y.c.q[] var24 = new y.c.q[2];
      int var26 = 0;

      label131:
      while(true) {
         var33 = var26;

         label128:
         while(var33 < var4.length) {
            y.c.f var28 = var4[var26];
            y.c.q var30 = (y.c.q)var5.get(var28);
            if(var20 != 0) {
               return;
            }

            if(var30 != null) {
               y.c.e var31 = var28.a();

               label87: {
                  while(var31.f()) {
                     var22[var31.a().b()] = var28;
                     var31.g();
                     if(var20 != 0) {
                        break label87;
                     }

                     if(var20 != 0) {
                        break;
                     }
                  }

                  var31 = var28.a();
               }

               label123:
               do {
                  boolean var35 = var31.f();

                  label120:
                  while(true) {
                     if(!var35) {
                        break label123;
                     }

                     var24[0] = var31.a().c();
                     var24[1] = var31.a().d();
                     var33 = 0;
                     if(var20 != 0) {
                        continue label128;
                     }

                     int var32 = 0;

                     while(true) {
                        var33 = var32;

                        label115: {
                           y.c.q var15;
                           y.c.f var16;
                           label114:
                           while(true) {
                              if(var33 >= 2) {
                                 break label120;
                              }

                              y.c.q var14 = var24[var32];
                              var15 = (y.c.q)var5.get(var14);
                              var35 = var1.d(var14);
                              if(var20 != 0) {
                                 continue label120;
                              }

                              if(!var35 || var15.c(var30) != null) {
                                 break label115;
                              }

                              var16 = new y.c.f();
                              y.c.e var17 = var14.j();

                              while(true) {
                                 if(!var17.f()) {
                                    break label114;
                                 }

                                 y.c.d var18 = var17.a();
                                 y.c.q var19 = var18.a(var14);
                                 var33 = var1.d(var19);
                                 if(var20 != 0) {
                                    break;
                                 }

                                 if(var33 == 0 && var22[var18.b()] == var28) {
                                    var16.add(var18);
                                 }

                                 var17.g();
                                 if(var20 != 0) {
                                    break label114;
                                 }
                              }
                           }

                           y.c.d var34 = this.a(var30, var15);
                           this.a(var34, var16);
                        }

                        ++var32;
                        if(var20 != 0) {
                           break label120;
                        }
                     }
                  }

                  var31.g();
               } while(var20 == 0);
            }

            ++var26;
            if(var20 == 0) {
               continue label131;
            }
            break;
         }

         this.s.a(var1);
         return;
      }
   }

   void J() {
      int var9 = f.u;
      this.t = new HashMap();
      if(this.l == 1) {
         y.c.e var1 = this.p();

         while(var1.f()) {
            y.c.d var10000 = var1.a();

            label39:
            while(true) {
               y.c.d var2 = var10000;
               y.c.f var3 = this.i(var2);
               if(var9 != 0) {
                  return;
               }

               if(var3.size() <= 1) {
                  break;
               }

               y.c.e var4 = var3.a();
               y.c.q var5 = this.t(var2.d()).b();
               y.c.q var6 = var4.a().a(var5);
               var4.g();

               while(true) {
                  if(!var4.f()) {
                     break label39;
                  }

                  y.c.q var7 = var4.a().a(var5);
                  var10000 = var6.c(var7);
                  if(var9 != 0) {
                     break;
                  }

                  if(var10000 == null) {
                     y.c.d var8 = this.s.a(var6, var7);
                     this.t.put(var8, Boolean.TRUE);
                  }

                  var6 = var7;
                  var4.g();
                  if(var9 != 0) {
                     break label39;
                  }
               }
            }

            var1.g();
            if(var9 != 0) {
               break;
            }
         }
      }

      this.w.a((y.c.c)this.o);
   }

   void K() {
      int var2 = f.u;
      y.c.e var1 = this.s.p();

      while(var1.f()) {
         if(this.t.containsKey(var1.a())) {
            this.s.a(var1.a());
         }

         var1.g();
         if(var2 != 0) {
            break;
         }
      }

   }

   void L() {
      this.K();
      this.s.a(this.o);
      this.s.a(this.q);
   }

   protected void M() {
      int var5 = f.u;
      int var1 = -1;
      y.c.q var2 = null;
      y.c.x var3 = this.o();

      s var10000;
      y.c.q var10001;
      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            var10000 = this;
            var10001 = var4;
            if(var5 != 0) {
               break;
            }

            if(this.t(var4).size() > var1) {
               var2 = var4;
               var1 = this.t(var4).size();
            }

            var3.g();
            if(var5 == 0) {
               continue;
            }
         }

         var10000 = this;
         var10001 = var2;
         break;
      }

      var10000.u = var10001;
   }

   public y.c.q N() {
      return this.u;
   }

   void O() {
      this.M();
      y.c.f var1 = y.a.A.a((y.c.i)this, (y.c.q)this.u);
   }

   public void P() {
      this.w.a();
   }

   public void Q() {
      this.w.b();
   }

   public void v(y.c.q var1) {
      this.w.b((Object)var1);
   }

   public void w(y.c.q var1) {
      this.w.a((Object)var1);
   }

   public y.c.q x(y.c.q var1) {
      return (y.c.q)this.o.b(var1);
   }
}
