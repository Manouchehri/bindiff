package y.f.c.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import y.f.c.a.N;
import y.f.c.a.aR;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aW;
import y.f.c.a.bL;
import y.f.c.a.bh;
import y.f.c.a.bk;
import y.f.c.a.di;
import y.f.c.a.p;

public class m implements aT {
   private y.c.q a;
   private y.c.q b;
   private y.c.y c;
   private y.c.A d = null;
   private ArrayList e;
   private y.c.q[] f;
   private final aT g;
   private y.c.c h;
   private HashMap i;
   private boolean j;
   private y.f.X k;
   private y.c.h l;
   private y.c.h m;
   private y.c.A n;
   private y.c.A o;
   private y.c.A p;
   private y.c.c q;
   private int r;
   private y.c.f s;
   private y.c.f t;
   private y.c.A u;
   private y.c.f v;
   private boolean w = false;

   public m(aT var1) {
      this.g = var1;
   }

   void a(y.c.A var1) {
      this.d = var1;
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var4;
      Object var5;
      ArrayList var6;
      Object var10000;
      boolean var18;
      label256: {
         label262: {
            var18 = N.x;
            var4 = var2.b() == 0;
            var6 = new ArrayList(64);
            y.c.x var7;
            y.c.q var8;
            if(var4) {
               var5 = y.g.M.a();
               var7 = var1.o();

               do {
                  if(!var7.f()) {
                     break label262;
                  }

                  var8 = var7.e();
                  var10000 = this.d;
                  if(var18) {
                     break label256;
                  }

                  label282: {
                     if(var10000 == null || !this.d.d(var8)) {
                        var6.add(var8);
                        ((y.c.A)var5).a(var8, true);
                        if(!var18) {
                           break label282;
                        }
                     }

                     ((y.c.A)var5).a(var8, false);
                  }

                  var7.g();
               } while(!var18);
            }

            var5 = var1.c(N.t);
            if(var5 == null) {
               return;
            }

            var7 = var1.o();

            while(var7.f()) {
               var8 = var7.e();
               var10000 = var5;
               if(var18) {
                  break label256;
               }

               if(((y.c.c)var5).d(var8)) {
                  var6.add(var8);
               }

               var7.g();
               if(var18) {
                  return;
               }
            }
         }

         var10000 = var1.c(aR.a);
      }

      label221: {
         Object var19 = var10000;
         if(var19 != null) {
            this.h = (y.c.c)((y.c.c)var19).b(var1);
            if(!var18) {
               break label221;
            }
         }

         this.h = null;
      }

      this.j = !this.b(var1);
      this.k = new y.f.w();
      this.q = var1.c("y.layout.hierarchic.incremental.ConstraintIncrementalLayerer.EDGE_WEIGHTS_DPKEY");
      this.p = y.g.M.a();
      this.n = this.k.t();
      this.r = 0;
      this.l = this.k.u();
      this.m = this.k.u();
      y.c.q[] var20 = new y.c.q[var2.b()];
      int var9 = var2.b() + var6.size() + 2;
      int var10 = var9;
      int var11 = 0;

      y.c.q var25;
      y.f.X var34;
      while(true) {
         if(var11 < var20.length) {
            var34 = this.k;
            if(var18) {
               break;
            }

            y.c.q var12 = var34.d();
            var20[var11] = var12;
            int var13 = 0;
            y.c.p var14 = var2.a(var11).d().k();

            label210: {
               while(var14 != null) {
                  y.c.q var15 = (y.c.q)var14.c();
                  var13 += var15.b();
                  this.p.a(var15, var12);
                  var14 = var14.a();
                  if(var18) {
                     break label210;
                  }

                  if(var18) {
                     break;
                  }
               }

               this.n.a(var12, var2.a(var11).d());
            }

            if(var11 > 0) {
               var25 = var20[var11 - 1];
               y.c.d var29 = this.k.a((y.c.q)var25, (y.c.q)var12);
               this.m.a(var29, 2);
               this.l.a(var29, var13);
               var10 = Math.max(var10, var13);
            }

            ++var11;
            if(!var18) {
               continue;
            }
         }

         var34 = var1;
         break;
      }

      label195: {
         label194: {
            y.c.c var35;
            label267: {
               label192: {
                  label268: {
                     y.c.c var21 = var34.c(y.f.ah.f_);
                     this.i = new HashMap();
                     y.c.x var22;
                     y.c.q var24;
                     if(var21 != null) {
                        var22 = var1.o();

                        do {
                           if(!var22.f()) {
                              break label268;
                           }

                           var24 = var22.e();
                           var35 = var21;
                           if(var18) {
                              break label267;
                           }

                           Object var27 = var21.b(var24) != null?var21.b(var24):var24;
                           this.i.put(var27, var24);
                           var22.g();
                        } while(!var18);
                     }

                     var22 = var1.o();

                     while(var22.f()) {
                        var24 = var22.e();
                        this.i.put(var24, var24);
                        var22.g();
                        if(var18) {
                           break label192;
                        }

                        if(var18) {
                           break;
                        }
                     }
                  }

                  this.v = new y.c.f();
               }

               if(!this.j) {
                  break label194;
               }

               var35 = this.q;
            }

            if(var35 == null) {
               break label195;
            }
         }

         this.c(var1);
      }

      y.g.I var23;
      boolean var36;
      label163: {
         var23 = new y.g.I(var1);
         if(this.d != null) {
            y.c.x var26 = var1.o();

            while(var26.f()) {
               var25 = var26.e();
               var36 = this.d.d(var25);
               if(var18) {
                  break label163;
               }

               if(var36) {
                  var23.a(var25);
               }

               var26.g();
               if(var18) {
                  break;
               }
            }
         }

         var36 = this.j;
      }

      if(var36 && this.q == null) {
         label281: {
            if(var6.isEmpty() || var4) {
               this.b(var1, var2, var3);
               if(!var18) {
                  break label281;
               }
            }

            bL var30 = new bL();
            var30.a(var1, var2, var3);
         }

         var23.f();
      } else {
         this.b(var1, (y.c.c)var5);
         this.u = y.g.M.a();
         this.a(var1);
         y.c.A var28 = y.g.M.a();
         this.b(var1, var28, this.d);
         if(this.a(var1, var28, this.d)) {
            this.a(var28, this.v);
            this.b(var1, var28, this.d);
         }

         this.a(var1, var28);
         int var31 = 0;
         int var32 = 0;

         y.c.q var16;
         int var17;
         while(var32 < var20.length) {
            var16 = ((y.c.y)this.n.b(var20[var32])).b();
            var17 = var28.a(var16);

            while(true) {
               if(var17 > var31) {
                  var2.a((byte)0, var31);
                  ++var31;
                  if(var18) {
                     break;
                  }

                  if(!var18) {
                     continue;
                  }
               }

               ++var32;
               ++var31;
               break;
            }

            if(var18) {
               break;
            }
         }

         Iterator var33 = var6.iterator();

         while(true) {
            if(var33.hasNext()) {
               var16 = (y.c.q)var33.next();
               if(var18) {
                  break;
               }

               var17 = var28.a(var16);

               label128: {
                  while(var17 >= var2.b()) {
                     var2.a((byte)0, var2.b());
                     if(var18) {
                        break label128;
                     }

                     if(var18) {
                        break;
                     }
                  }

                  var2.a(var17).a(var16);
               }

               if(!var18) {
                  continue;
               }
            }

            var23.f();
            this.i.clear();
            break;
         }

      }
   }

   private void a(y.f.X var1, y.c.A var2) {
      boolean var19 = N.x;
      y.c.c var3 = var1.c(bk.b);
      if(this.e != null && this.f != null && this.f.length >= 2) {
         Iterator var4 = this.e.iterator();

         while(var4.hasNext()) {
            y.c.d var5 = (y.c.d)var4.next();
            if(this.k.f(var5)) {
               this.k.a((y.c.d)var5);
               if(var19) {
                  break;
               }
            }
         }

         int var20 = 1;

         y.f.X var10000;
         while(true) {
            if(var20 < this.f.length - 1) {
               var10000 = this.k;
               if(var19) {
                  break;
               }

               var10000.a((y.c.q)this.f[var20]);
               ++var20;
               if(!var19) {
                  continue;
               }
            }

            var10000 = this.k;
            break;
         }

         y.c.y[] var21 = y.a.h.a(var10000);
         y.c.y[] var22 = new y.c.y[var21.length];
         int var6 = 0;

         y.c.x var8;
         y.c.q var9;
         while(var6 < var21.length) {
            y.c.y var7 = var21[var6];
            var22[var6] = new y.c.y();
            y.c.y var31 = var7;

            label179:
            while(true) {
               var8 = var31.a();

               while(true) {
                  if(!var8.f()) {
                     break label179;
                  }

                  var9 = var8.e();
                  y.c.y var10 = (y.c.y)this.n.b(var9);
                  var31 = var10;
                  if(var19) {
                     break;
                  }

                  if(var10 != null) {
                     var22[var6].addAll(var10);
                  }

                  var8.g();
                  if(var19) {
                     break label179;
                  }
               }
            }

            ++var6;
            if(var19) {
               break;
            }
         }

         int[] var23 = new int[this.f.length - 1];
         int var24 = 0;

         while(true) {
            if(var24 < var23.length) {
               var23[var24] = Integer.MAX_VALUE;
               ++var24;
               if(var19) {
                  break;
               }

               if(!var19) {
                  continue;
               }
            }

            var24 = 0;
            break;
         }

         var8 = var1.o();

         int var27;
         while(true) {
            if(var8.f()) {
               var9 = var8.e();
               var27 = var2.a(var9);
               var24 = Math.max(var24, var27);
               if(var19) {
                  break;
               }

               bh var11 = var3 != null?(bh)var3.b(var9):null;
               if(var11 != null && var11.c() != null && var11.c().a() >= 0) {
                  var23[var11.c().a()] = Math.min(var23[var11.c().a()], var27);
               }

               var8.g();
               if(!var19) {
                  continue;
               }
            }

            var23[0] = 0;
            break;
         }

         int[] var25 = new int[var24 + 1];
         int var26 = -1;
         var27 = 0;
         int var28 = 0;

         int var10001;
         int var33;
         while(true) {
            if(var28 < var23.length) {
               int var12 = var23[var28];
               var33 = var12;
               var10001 = Integer.MAX_VALUE;
               if(var19) {
                  break;
               }

               if(var12 != Integer.MAX_VALUE) {
                  int var13 = var26 + 1;

                  while(true) {
                     if(var13 < var12) {
                        var25[var13] = var27;
                        ++var13;
                        if(var19) {
                           break;
                        }

                        if(!var19) {
                           continue;
                        }
                     }

                     var27 = var28;
                     break;
                  }

                  var26 = var12 - 1;
               }

               ++var28;
               if(!var19) {
                  continue;
               }
            }

            var33 = var26;
            var10001 = 1;
            break;
         }

         var28 = var33 + var10001;

         while(true) {
            if(var28 < var25.length) {
               var25[var28] = var27;
               ++var28;
               if(var19) {
                  break;
               }

               if(!var19) {
                  continue;
               }
            }

            var28 = 0;
            break;
         }

         while(var28 < var22.length) {
            label111: {
               y.c.y var29 = var22[var28];
               if(var29.size() != 0) {
                  label215: {
                     y.c.x var30 = var29.a();
                     int var14 = var2.a(var30.e());
                     int var15 = var25[var14];

                     int var16;
                     while(true) {
                        if(var30.f()) {
                           var16 = var2.a(var30.e());
                           int var17 = var25[var16];
                           var33 = var17;
                           var10001 = var15;
                           if(var19) {
                              break;
                           }

                           if(var17 != var15) {
                              break label215;
                           }

                           var14 = Math.min(var14, var16);
                           var30.g();
                           if(!var19) {
                              continue;
                           }
                        }

                        var33 = var14;
                        var10001 = var23[var15];
                        break;
                     }

                     var16 = var33 - var10001;
                     if(var16 > 0) {
                        y.c.x var32 = var29.a();

                        while(var32.f()) {
                           y.c.q var18 = var32.e();
                           var2.a(var18, var2.a(var18) - var16);
                           var32.g();
                           if(var19) {
                              break label111;
                           }

                           if(var19) {
                              break;
                           }
                        }
                     }
                  }
               }

               ++var28;
            }

            if(var19) {
               break;
            }
         }

      }
   }

   private boolean a(y.f.X var1, y.c.A var2, y.c.A var3) {
      boolean var6 = N.x;
      if(this.w) {
         return false;
      } else {
         y.c.e var4 = var1.p();

         while(var4.f()) {
            y.c.d var5 = var4.a();
            if((var3 == null || !var3.d(var5.c()) && !var3.d(var5.d())) && var2.a(var5.c()) == var2.a(var5.d())) {
               return true;
            }

            var4.g();
            if(var6) {
               break;
            }
         }

         return false;
      }
   }

   private void a(y.c.A var1, y.c.f var2) {
      boolean var15 = N.x;
      y.c.y var3 = new y.c.y();
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();
      y.c.x var6 = this.c.a();

      y.c.q var7;
      y.c.x var8;
      y.c.q var9;
      y.c.q var10;
      while(true) {
         if(var6.f()) {
            var7 = var6.e();
            var8 = var7.m();
            var9 = var8.e();
            var8.g();
            var10 = var8.e();
            var4.put(var7, var9);
            var5.put(var7, var10);
            var6.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         var6 = this.c.a();
         break;
      }

      while(var6.f()) {
         var7 = var6.e();
         this.k.a((y.c.q)var7);
         var6.g();
         if(var15) {
            break;
         }
      }

      HashSet var16 = new HashSet(this.e);
      y.c.x var17 = this.c.a();

      int var11;
      y.c.A var10000;
      while(true) {
         if(var17.f()) {
            y.c.q var19 = var17.e();
            var9 = (y.c.q)var4.get(var19);
            var10 = (y.c.q)var5.get(var19);
            var11 = var1.a(((y.c.y)this.n.b(var9)).b());
            var10000 = var1;
            if(var15) {
               break;
            }

            int var12 = var1.a(((y.c.y)this.n.b(var10)).b());
            if(var9 != var10) {
               label123: {
                  if(var11 == var12) {
                     var3.add(var19);
                     if(!var15) {
                        break label123;
                     }
                  }

                  y.c.d var13;
                  if(var11 < var12) {
                     var13 = var9.a(var10);
                     if(var13 == null || var16.contains(var13)) {
                        var13 = this.k.a((y.c.q)var9, (y.c.q)var10);
                        this.m.a(var13, 2 * (var12 - var11));
                        this.l.a(var13, 1);
                        if(!var15) {
                           break label123;
                        }
                     }

                     this.m.a(var13, Math.max(this.m.a(var13), 2 * (var12 - var11)));
                     this.l.a(var13, Math.max(this.l.a(var13), 1));
                     if(!var15) {
                        break label123;
                     }
                  }

                  var13 = var9.b(var10);
                  if(var13 == null || var16.contains(var13)) {
                     var13 = this.k.a((y.c.q)var10, (y.c.q)var9);
                     this.m.a(var13, 2 * (var11 - var12));
                     this.l.a(var13, 1);
                     if(!var15) {
                        break label123;
                     }
                  }

                  this.m.a(var13, Math.max(this.m.a(var13), 2 * (var12 - var11)));
                  this.l.a(var13, Math.max(this.l.a(var13), 1));
               }
            }

            var17.g();
            if(!var15) {
               continue;
            }
         }

         var10000 = this.k.t();
         break;
      }

      y.c.A var18 = var10000;
      y.a.m.a(y.a.m.a(this.k), var18);
      var8 = var3.a();

      while(true) {
         if(var8.f()) {
            var9 = var8.e();
            var10 = (y.c.q)var4.get(var9);
            var11 = var18.a(var10);
            y.c.q var20 = (y.c.q)var5.get(var9);
            int var21 = var18.a(var20);
            if(var15) {
               break;
            }

            label125: {
               y.c.d var14;
               if(var11 <= var21) {
                  var14 = var10.a(var20);
                  if(var14 == null || var16.contains(var14)) {
                     var14 = this.k.a((y.c.q)var10, (y.c.q)var20);
                     this.m.a(var14, 2);
                     this.l.a(var14, 1);
                     if(!var15) {
                        break label125;
                     }
                  }

                  this.m.a(var14, Math.max(this.m.a(var14), 2));
                  if(!var15) {
                     break label125;
                  }
               }

               var14 = var10.b(var20);
               if(var14 == null || var16.contains(var14)) {
                  var14 = this.k.a((y.c.q)var20, (y.c.q)var10);
                  this.m.a(var14, 2);
                  this.l.a(var14, 1);
                  if(!var15) {
                     break label125;
                  }
               }

               this.m.a(var14, Math.max(this.m.a(var14), 2));
            }

            var8.g();
            if(!var15) {
               continue;
            }
         }

         this.k.a((y.c.A)var18);
         break;
      }

   }

   static void a(y.c.i var0, y.c.c var1) {
      boolean var9 = N.x;
      if(!y.a.g.a(var0)) {
         if(var1 == null) {
            var1 = y.g.q.a((Object)(new Integer(1)));
         }

         y.c.h var2 = y.g.M.b();
         y.c.e var3 = var0.p();

         while(var3.f()) {
            y.c.d var4 = var3.a();
            var2.a(var4, var1.a(var4));
            var3.g();
            if(var9) {
               break;
            }
         }

         y.c.f var10 = new y.c.f();

         label84:
         while(true) {
            y.c.f var11;
            int var10000 = (var11 = y.a.c.a(var0, true)).isEmpty();

            label81:
            while(var10000 == 0) {
               var10000 = var11.size();
               int var10001 = 1;

               y.c.e var6;
               int var12;
               label78:
               while(true) {
                  if(var10000 == var10001) {
                     y.c.d var5 = var11.b();
                     var10.add(var5);
                     var0.a(var5);
                     if(!var9) {
                        continue label84;
                     }
                  }

                  var12 = Integer.MAX_VALUE;
                  var6 = var11.a();

                  while(true) {
                     if(!var6.f()) {
                        break label78;
                     }

                     int var7 = var2.a(var6.a());
                     var10000 = var7;
                     var10001 = var12;
                     if(var9) {
                        break;
                     }

                     if(var7 < var12) {
                        var12 = var7;
                     }

                     var6.g();
                     if(var9) {
                        break label78;
                     }
                  }
               }

               var6 = var11.a();

               while(true) {
                  if(!var6.f()) {
                     continue label84;
                  }

                  y.c.d var15 = var6.a();
                  int var8 = var2.a(var15) - var12;
                  var2.a(var15, var8);
                  if(var9) {
                     break label84;
                  }

                  var10000 = var8;
                  if(var9) {
                     break;
                  }

                  if(var8 == 0) {
                     var10.add(var15);
                     var0.a(var15);
                  }

                  var6.g();
                  if(var9) {
                     break label81;
                  }
               }
            }

            var10.sort(new p(var1));
            break;
         }

         y.c.e var13 = var10.a();

         while(var13.f()) {
            y.c.d var14 = var13.a();
            var0.b(var14);
            if(!y.a.g.a(var0)) {
               var0.a(var14);
            }

            var13.g();
            if(var9) {
               break;
            }
         }

      }
   }

   private void a(y.f.X var1) {
      boolean var5 = N.x;
      y.c.c var2 = var1.c(bk.b);
      this.c = new y.c.y();
      this.r += 10;
      y.c.e var3 = this.t.a();

      y.c.d var4;
      while(true) {
         if(var3.f()) {
            var4 = var3.a();
            this.r += this.a(var4);
            var3.g();
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var3 = this.s.a();
         break;
      }

      while(true) {
         if(var3.f()) {
            var4 = var3.a();
            this.r += this.a(var4);
            var3.g();
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var3 = this.t.a();
         break;
      }

      while(true) {
         if(var3.f()) {
            var4 = var3.a();
            this.a(var4, var2);
            var3.g();
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var3 = this.s.a();
         break;
      }

      while(var3.f()) {
         var4 = var3.a();
         this.a(var4, var2);
         var3.g();
         if(var5) {
            break;
         }
      }

   }

   private void a(y.c.d var1, y.c.c var2) {
      boolean var9 = N.x;
      y.c.q var3 = (y.c.q)this.p.b(var1.c());
      y.c.q var4 = (y.c.q)this.p.b(var1.d());
      if(var3 != var4) {
         bh var5 = var2 == null?null:(bh)var2.b(var1.c());
         bh var6 = var2 == null?null:(bh)var2.b(var1.d());
         int var8;
         if(var5 != null && var6 != null && var5.c().a() != var6.c().a()) {
            y.c.d var10;
            label31: {
               if(var5.c().a() > var6.c().a()) {
                  var10 = this.k.a((y.c.q)var4, (y.c.q)var3);
                  if(!var9) {
                     break label31;
                  }
               }

               var10 = this.k.a((y.c.q)var3, (y.c.q)var4);
            }

            var8 = this.a(var1);
            this.l.a(var10, var8);
            this.m.a(var10, 2);
         } else {
            int var7 = this.o.a(var3);
            var8 = this.o.a(var4);
            if(var7 < var8) {
               this.a(var3, var4, var1, false);
               if(!var9) {
                  return;
               }
            }

            if(var7 == var8) {
               this.a(var3, var4, var1, true);
               if(!var9) {
                  return;
               }
            }

            this.a(var4, var3, var1, false);
         }
      }
   }

   private int a(y.c.d var1) {
      return this.q == null?1:Math.max(0, this.q.a(var1));
   }

   private void a(y.c.q var1, y.c.q var2, y.c.d var3, boolean var4) {
      y.c.q var5 = this.k.d();
      this.c.add(var5);
      this.u.a(var5, var3);
      y.c.d var6 = this.k.a((y.c.q)var5, (y.c.q)var1);
      this.l.a(var6, this.r);
      this.m.a(var6, 0);
      y.c.d var7 = this.k.a((y.c.q)var5, (y.c.q)var2);
      int var8 = this.a(var3);
      this.l.a(var7, var4?this.r:var8);
      this.m.a(var7, var4?0:2);
   }

   private void b(y.c.i var1, y.c.c var2) {
      boolean var17 = N.x;
      this.o = this.k.t();
      this.s = new y.c.f();
      this.t = new y.c.f();
      y.c.f var3 = new y.c.f();
      y.c.f var4 = new y.c.f();
      y.g.I var5 = new y.g.I(this.k);
      if(this.a != null) {
         var5.a(this.a.j());
      }

      if(this.b != null) {
         var5.a(this.b.j());
      }

      y.c.A var6 = this.k.t();
      y.a.h.a(this.k, (y.c.A)var6);
      y.c.h var7 = y.g.M.b();
      int var8 = var1.h() + 1;
      y.c.e var9 = this.k.p();

      y.c.h var10000;
      while(true) {
         if(var9.f()) {
            y.c.d var10 = var9.a();
            var10000 = var7;
            if(var17) {
               break;
            }

            var7.a(var10, var8);
            var9.g();
            if(!var17) {
               continue;
            }
         }

         var10000 = y.g.M.b();
         break;
      }

      y.c.h var18 = var10000;
      this.k.a((Object)"y.layout.hierarchic.incremental.ConstraintIncrementalLayerer.ORIG_EDGES", (y.c.c)var18);
      y.c.e var19 = var1.p();

      y.c.q var12;
      while(true) {
         if(var19.f()) {
            y.c.d var11 = var19.a();
            if(var17) {
               break;
            }

            if(var2.d(var11.c()) || var2.d(var11.d())) {
               var12 = (y.c.q)this.p.b(var11.c());
               y.c.q var13 = (y.c.q)this.p.b(var11.d());
               if(var12 != var13) {
                  label115: {
                     int var14 = var6.a(var12);
                     int var15 = var6.a(var13);
                     y.c.d var16 = this.k.a((y.c.q)var12, (y.c.q)var13);
                     var18.a(var16, var11);
                     var7.a(var16, 1);
                     var4.add(var16);
                     if(var14 != var15) {
                        this.s.add(var11);
                        if(!var17) {
                           break label115;
                        }
                     }

                     this.t.add(var11);
                  }
               }
            }

            var19.g();
            if(!var17) {
               continue;
            }
         }

         a((y.c.i)this.k, (y.c.c)var7);
         break;
      }

      y.c.y[] var20 = y.a.h.a(this.k);
      int var21 = 0;

      while(var21 < var20.length) {
         var12 = var20[var21].b();
         if(var12 != this.a) {
            this.k.a((y.c.q)this.a, (y.c.q)var12);
         }

         ++var21;
         if(var17) {
            break;
         }
      }

      di var22 = new di(this.g);
      int var23 = var22.a(this.k, this.o, var3);
      var1.d_("y.layout.hierarchic.incremental.ConstraintIncrementalLayerer.ORIG_EDGES");
      y.c.e var24 = var3.a();

      y.c.d var25;
      while(true) {
         if(var24.f()) {
            var25 = var24.a();
            this.k.c(var25);
            var24.g();
            if(var17) {
               break;
            }

            if(!var17) {
               continue;
            }
         }

         var24 = var4.a();
         break;
      }

      y.f.X var26;
      while(true) {
         if(var24.f()) {
            var25 = var24.a();
            var26 = this.k;
            if(var17) {
               break;
            }

            if(var26.f(var25)) {
               this.k.a((y.c.d)var25);
            }

            var24.g();
            if(!var17) {
               continue;
            }
         }

         var5.f();
         if(this.a != null) {
            this.o.a(this.a, -1);
         }

         if(this.b != null) {
            this.o.a(this.b, var23 + 1);
         }

         var26 = this.k;
         break;
      }

      var26.a((y.c.A)var6);
   }

   private int b(y.f.X var1, y.c.A var2, y.c.A var3) {
      boolean var16 = N.x;
      y.c.A var4 = this.k.t();
      y.c.A var5 = var1.t();
      y.c.A var6 = this.k.t();
      int var7 = y.a.h.a(this.k, (y.c.A)var6);
      y.g.J var8 = new y.g.J(this.k, var6);
      int var9 = 0;

      y.f.X var10000;
      while(true) {
         if(var9 < var7) {
            var8.c(new Integer(var9));
            y.a.u.a(this.k, var4, this.l, this.m);
            var10000 = this.k;
            if(var16) {
               break;
            }

            y.c.x var10 = var10000.o();

            label54: {
               while(var10.f()) {
                  y.c.q var11 = var10.e();
                  int var12 = var4.a(var11);
                  Object var17 = this.n.b(var11);

                  label50:
                  while(true) {
                     y.c.y var13 = (y.c.y)var17;
                     if(var16) {
                        break label54;
                     }

                     if(var13 == null) {
                        break;
                     }

                     y.c.x var14 = var13.a();

                     while(true) {
                        if(!var14.f()) {
                           break label50;
                        }

                        y.c.q var15 = var14.e();
                        var17 = var3;
                        if(var16) {
                           break;
                        }

                        if(var3 == null || !var3.d(var15)) {
                           var5.a(var15, var12);
                        }

                        var14.g();
                        if(var16) {
                           break label50;
                        }
                     }
                  }

                  var10.g();
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

         var9 = (new y.f.c.D()).a((y.c.i)var1, (y.c.c)var5, (y.c.a)var2);
         var1.a((y.c.A)var5);
         this.k.a((y.c.A)var4);
         var10000 = this.k;
         break;
      }

      var10000.a((y.c.A)var6);
      var8.b();
      return var9;
   }

   private int b(y.f.X var1, aU var2, aV var3) {
      if(this.g instanceof aW) {
         this.g.a(var1, var2, var3);
         return var2.b();
      } else {
         (new aW(this.g)).a(var1, var2, var3);
         return var2.b();
      }
   }

   private boolean b(y.f.X var1) {
      boolean var7 = N.x;
      if(bk.c(var1) != null) {
         return true;
      } else if(this.h == null) {
         return false;
      } else {
         y.c.c var2 = var1.c(y.f.ah.f_);
         y.c.x var3 = var1.o();

         while(var3.f()) {
            y.c.q var4 = var3.e();
            Object var5 = var2 != null && var2.b(var4) != null?var2.b(var4):var4;
            y.c.D var6 = (y.c.D)this.h.b(var5);
            if(var6 != null) {
               return true;
            }

            var3.g();
            if(var7) {
               break;
            }
         }

         return false;
      }
   }

   private boolean a(y.c.q var1, y.c.q var2) {
      y.c.f var3 = y.a.q.a(this.k, var1, var2, true);
      if(var3 != null && !var3.isEmpty()) {
         return true;
      } else {
         var3 = y.a.q.a(this.k, var2, var1, true);
         return var3 != null && !var3.isEmpty();
      }
   }

   private void c(y.f.X param1) {
      // $FF: Couldn't be decompiled
   }

   private y.c.q a(y.c.q var1) {
      if(var1 == null) {
         return null;
      } else {
         y.c.q var2 = (y.c.q)this.p.b(var1);
         if(var2 == null) {
            var2 = this.k.d();
            this.p.a(var1, var2);
            y.c.y var3 = new y.c.y();
            var3.add(var1);
            this.n.a(var2, var3);
         }

         return var2;
      }
   }
}
