package y.f.c.a;

import java.awt.geom.Rectangle2D;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.cr;
import y.f.c.a.cy;
import y.f.c.a.da;
import y.f.c.a.dd;
import y.f.c.a.dh;

class dg {
   y.c.q f;
   private y.c.D a;
   aQ g;
   aQ h;
   float i;
   float j;
   int k;
   int l;
   float m;
   float n;
   int o;
   int p;
   da[] q;
   private float b;
   int r;
   BitSet s;
   int t;
   int u;
   boolean v;
   Rectangle2D w;
   double x;
   double y;
   public y.d.y z;
   public aQ A;
   public aQ B;
   E C;
   HashSet D;
   double E;
   double F;
   HashMap G = new HashMap();

   dg(E var1, y.c.q var2) {
      this.C = var1;
      if(var2 != null) {
         this.f = var2;
         y.f.X var3 = (y.f.X)var2.e();
         y.f.am var4 = var3.a((Object)var2);
         this.z = new y.d.y(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
      }

      this.a = new y.c.D();
      this.D = new HashSet();
   }

   void b(Object var1) {
      if(!this.D.contains(var1)) {
         this.a.b(var1);
         this.D.add(var1);
      }

   }

   public void a(aU var1, int var2, aV var3) {
      boolean var18 = N.x;
      if(this.g != null && this.h != null && this.g.c() <= var2 && this.h.c() >= var2) {
         boolean var4 = false;
         da var5 = this.b(var2);
         y.c.y var6 = null;
         y.c.y var7 = null;
         int var8 = var3.a((y.c.q)var5.f()).k();
         int var9 = var3.a((y.c.q)var5.i()).k();
         y.c.p var10 = var5.k();

         boolean var10000;
         label86: {
            while(var10 != null) {
               var10000 = var10.c() instanceof y.c.q;
               if(var18) {
                  break label86;
               }

               label82: {
                  label81: {
                     if(var10000) {
                        y.c.q var11 = (y.c.q)var10.c();
                        aX var12 = var3.a(var11);
                        if(var12.b() != 15) {
                           break label81;
                        }

                        if(!var4) {
                           this.G.clear();
                           var6 = new y.c.y();
                           var7 = new y.c.y();
                        }

                        var4 = true;
                        if(var12.e() <= 0) {
                           break label81;
                        }

                        double var13 = 0.0D;
                        y.c.p var15 = var12.d();

                        while(var15 != null) {
                           y.c.d var16 = (y.c.d)var15.c();
                           aX var17 = var3.a(var16.a(var11));
                           var13 += (double)var17.k();
                           var15 = var15.a();
                           if(var18) {
                              break label82;
                           }

                           if(var18) {
                              break;
                           }
                        }

                        label70: {
                           double var21 = var13 / (double)var12.e();
                           if(Math.abs(var21 - (double)var8) < Math.abs((double)var9 - var21)) {
                              var6.add(var11);
                              this.G.put(var11, new Double(var21));
                              if(!var18) {
                                 break label70;
                              }
                           }

                           var7.add(var11);
                           this.G.put(var11, new Double(-var21));
                        }

                        var5.h(var10);
                        if(!var18) {
                           break label81;
                        }
                     }

                     dg var20 = (dg)var10.c();
                     var20.a(var1, var2, var3);
                  }

                  var10 = var10.a();
               }

               if(var18) {
                  break;
               }
            }

            var10000 = var4;
         }

         if(var10000) {
            Comparator var19 = y.g.e.c(y.g.M.a((Map)this.G));
            var6.sort(var19);
            var7.sort(var19);

            while(!var6.isEmpty()) {
               var5.b(var6.g(), var5.k());
               if(var18) {
                  return;
               }

               if(var18) {
                  break;
               }
            }

            while(!var7.isEmpty()) {
               var5.a(var7.g(), var5.l());
               if(var18) {
                  break;
               }
            }
         }
      }

   }

   void a(aQ var1, y.f.X var2) {
      boolean var9 = N.x;
      int var3 = var1.c();
      da var4 = this.b(var3);
      var4.f = 0.0D;
      y.c.p var5 = var4.k();

      while(var5 != null) {
         label17: {
            if(var5.c() instanceof y.c.q) {
               y.f.am var6 = var2.a(var5.c());
               var4.f = Math.max(var4.f, var6.getHeight());
               if(!var9) {
                  break label17;
               }
            }

            dg var10 = (dg)var5.c();
            var10.a(var1, var2);
            da var7 = var10.b(var3);
            y.f.am var8 = var2.a(var7.f());
            var8.setSize(var8.getWidth(), var7.f);
            var8 = var2.a(var7.i());
            var8.setSize(var8.getWidth(), var7.f);
            var4.f = Math.max(var4.f, var7.f);
         }

         var5 = var5.a();
         if(var9) {
            break;
         }
      }

   }

   void a(int var1) {
      boolean var6 = N.x;
      if(this.g.c() <= var1 && this.h.c() >= var1) {
         da var2 = this.b(var1);
         int var3 = 0;
         y.c.p var4 = var2.k();

         do {
            if(var4 == null) {
               return;
            }

            if(var4.c() instanceof dg) {
               dg var5 = (dg)var4.c();
               var5.r = var3++;
               var5.a(var1);
            }

            var4 = var4.a();
         } while(!var6);
      }

      this.r = -1;
   }

   void b() {
      boolean var15 = N.x;
      y.c.i var1 = new y.c.i();
      y.c.A var2 = var1.t();
      if(this.g != null && this.h != null) {
         int var3 = this.g.c();
         int var4 = this.h.c();
         HashMap var5 = new HashMap();
         int var6 = var3;

         label55:
         do {
            int var10000 = var6;

            label52:
            while(true) {
               if(var10000 > var4) {
                  break label55;
               }

               da var7 = this.b(var6);
               y.c.q var8 = null;
               dg var9 = null;
               if(var15) {
                  return;
               }

               y.c.p var10 = var7.k();

               while(true) {
                  if(var10 == null) {
                     break label52;
                  }

                  Object var11 = var10.c();
                  var10000 = var11 instanceof dg;
                  if(var15) {
                     break;
                  }

                  if(var10000 != 0) {
                     dg var12 = (dg)var11;
                     y.c.q var13 = (y.c.q)var5.get(var12);
                     if(var13 == null) {
                        var13 = var1.d();
                        var5.put(var12, var13);
                        var2.a(var13, var12);
                     }

                     if(var8 != null && var8.a(var13) == null) {
                        if(var13.a(var8) != null) {
                           throw new IllegalStateException("grouping inconsistent " + var9 + " <-- " + var12);
                        }

                        var1.a(var8, var13);
                     }

                     var8 = var13;
                     var9 = var12;
                  }

                  var10 = var10.a();
                  if(var15) {
                     break label52;
                  }
               }
            }

            ++var6;
         } while(!var15);

         if(y.a.g.b(var1)) {
            throw new IllegalStateException("grouping inconsistent");
         }
      }

   }

   y.c.p a(int var1, y.c.p var2) {
      boolean var6 = N.x;
      y.c.p var3 = this.b(var1).k();

      y.c.p var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var3;
            if(var6) {
               break;
            }

            label19: {
               Object var4 = var3.c();
               if(var4 instanceof dg) {
                  dg var5 = (dg)var4;
                  var2 = var5.a(var1, var2);
                  if(!var6) {
                     break label19;
                  }
               }

               y.c.q var7 = (y.c.q)var4;
               var2.a(var4);
               var2 = var2.a();
            }

            var3 = var3.a();
            if(!var6) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   void c() {
      boolean var15 = N.x;
      if(this.g != null && this.h != null) {
         y.c.i var1 = new y.c.i();
         y.c.A var2 = var1.t();
         int var3 = this.g.c();
         int var4 = this.h.c();
         int var5 = 0;
         HashMap var6 = new HashMap();
         int var7 = var3;

         dg var12;
         label75:
         while(true) {
            int var10000 = var7;

            label72:
            while(var10000 <= var4) {
               da var8 = this.b(var7);
               y.c.q var9 = null;
               if(var15) {
                  break label75;
               }

               y.c.p var10 = var8.k();

               while(var10 != null) {
                  Object var11 = var10.c();
                  var10000 = var11 instanceof dg;
                  if(var15) {
                     continue label72;
                  }

                  if(var10000 != 0) {
                     var12 = (dg)var11;
                     y.c.q var13 = (y.c.q)var6.get(var12);
                     if(var13 == null) {
                        var13 = var1.d();
                        var6.put(var12, var13);
                        var2.a(var13, var12);
                        var12.t = var5++;
                     }

                     if(var9 != null && var9.a(var13) == null) {
                        var1.a(var9, var13);
                     }

                     var9 = var13;
                  }

                  var10 = var10.a();
                  if(var15) {
                     break;
                  }
               }

               ++var7;
               if(!var15) {
                  continue label75;
               }
               break;
            }

            y.a.z.a(var1);
            break;
         }

         y.c.x var16 = var1.o();

         while(var16.f()) {
            y.c.q var17 = var16.e();
            dg var18 = (dg)var2.b(var17);
            var18.s = new BitSet(var1.e());
            y.c.d var19 = var17.f();

            while(true) {
               if(var19 != null) {
                  y.c.q var20 = var19.d();
                  var12 = (dg)var2.b(var20);
                  var18.s.set(var12.t);
                  var19 = var19.g();
                  if(var15) {
                     break;
                  }

                  if(!var15) {
                     continue;
                  }
               }

               var18.c();
               var16.g();
               break;
            }

            if(var15) {
               break;
            }
         }

      }
   }

   void a(int var1, boolean var2, y.c.c var3) {
      boolean var14 = N.x;
      da var4 = this.b(var1);
      y.c.p var5 = var4.k();

      byte var10000;
      label227:
      while(true) {
         Object var6;
         dg var7;
         if(var5 != null) {
            var6 = var5.c();
            var10000 = var6 instanceof dg;
            if(var14) {
               break;
            }

            if(var10000 != 0) {
               var7 = (dg)var6;
               var7.v = var7.l > 0;
            }

            var5 = var5.a();
            if(!var14) {
               continue;
            }
         }

         var5 = var4.k();

         while(var5 != null) {
            var6 = var5.c();
            var10000 = var6 instanceof dg;
            if(var14) {
               break label227;
            }

            if(var10000 != 0) {
               var7 = (dg)var6;
               boolean var8 = var2 && var7.g.c() < var1 || !var2 && var7.h.c() > var1;
               if(!var7.v) {
                  y.c.p var9 = null;
                  y.c.p var10 = var5.b();

                  dg var11;
                  boolean var12;
                  int var13;
                  label200:
                  do {
                     do {
                        label192:
                        do {
                           while(true) {
                              if(var10 == null) {
                                 break label200;
                              }

                              var10000 = var10.c() instanceof dg;
                              if(var14) {
                                 break label227;
                              }

                              if(var10000 != 0) {
                                 var11 = (dg)var10.c();
                                 var12 = var2 && var11.g.c() < var1 || !var2 && var11.h.c() > var1;
                                 var13 = !var11.v?0:var7.a(var11, var8 && var12);
                                 if(var13 != 0) {
                                    break label192;
                                 }

                                 var10 = var10.b();
                                 break;
                              }

                              var10 = var10.b();
                              if(var14) {
                                 break label200;
                              }
                           }
                        } while(!var14);

                        if(var13 >= 0) {
                           break;
                        }

                        var9 = var10;
                        var10 = var10.b();
                     } while(!var14);
                  } while(var13 <= 0);

                  y.c.p var19;
                  if(var9 != null) {
                     var19 = var5.a();
                     var4.h(var5);
                     var4.a(var5, var9);
                     var5 = var19;
                     var7.v = true;
                     if(!var14) {
                        continue;
                     }
                  }

                  var10 = var5.a();

                  label154:
                  do {
                     do {
                        label146:
                        do {
                           while(true) {
                              if(var10 == null) {
                                 break label154;
                              }

                              var10000 = var10.c() instanceof dg;
                              if(var14) {
                                 break label227;
                              }

                              if(var10000 != 0) {
                                 var11 = (dg)var10.c();
                                 var12 = var2 && var11.g.c() < var1 || !var2 && var11.h.c() > var1;
                                 var13 = !var11.v?0:var7.a(var11, var8 && var12);
                                 if(var13 != 0) {
                                    break label146;
                                 }

                                 var10 = var10.a();
                                 break;
                              }

                              var10 = var10.a();
                              if(var14) {
                                 break label154;
                              }
                           }
                        } while(!var14);

                        if(var13 <= 0) {
                           break;
                        }

                        var9 = var10;
                        var10 = var10.a();
                     } while(!var14);
                  } while(var13 >= 0);

                  if(var9 != null) {
                     var19 = var5.a();
                     var4.h(var5);
                     var4.b(var5, var9);
                     var5 = var19;
                     var7.v = true;
                     if(!var14) {
                        continue;
                     }
                  }

                  var7.v = true;
               }
            }

            var5 = var5.a();
            if(var14) {
               break;
            }
         }

         var10000 = 0;
         break;
      }

      int var16 = var10000;
      y.c.p var15 = var4.k();

      while(var15 != null) {
         Object var17 = var15.c();
         if(var17 instanceof dg) {
            dg var18 = (dg)var17;
            var18.r = var16++;
            var18.a(var1, var2, var3);
         }

         var15 = var15.a();
         if(var14) {
            break;
         }
      }

   }

   int a(dg var1, boolean var2) {
      if(var2 && this.r >= 0 && var1.r >= 0) {
         return this.r - var1.r;
      } else {
         if(this.s != null && var1.s != null) {
            if(this.s.get(var1.t)) {
               return -1;
            }

            if(var1.s.get(this.t)) {
               return 1;
            }
         }

         return 0;
      }
   }

   void d() {
      boolean var4 = N.x;
      Iterator var1 = this.a.iterator();

      while(var1.hasNext()) {
         Object var2 = var1.next();
         if(var2 instanceof dg) {
            dg var3 = (dg)var2;
            var3.d();
            if(var3.g != null && (this.g == null || var3.g.c() < this.g.c())) {
               this.g = var3.g;
            }

            if(var3.A != null && (this.A == null || var3.A.c() < this.A.c())) {
               this.A = var3.A;
            }

            if(var3.h != null && (this.h == null || var3.h.c() > this.h.c())) {
               this.h = var3.h;
            }

            if(var3.B != null && (this.B == null || var3.B.c() > this.B.c())) {
               this.B = var3.B;
               if(var4) {
                  break;
               }
            }
         }
      }

   }

   void e() {
      boolean var4 = N.x;
      int var1 = this.g.c();
      int var2 = this.h.c();
      this.q = new da[var2 - var1 + 1];
      int var3 = var1;

      while(var3 <= var2) {
         this.q[var3 - var1] = new da();
         ++var3;
         if(var4) {
            break;
         }
      }

   }

   void a(aU var1, aV var2, dd var3) {
      boolean var12 = N.x;
      if(this.g != null && this.h != null) {
         int var4 = this.g.c();
         int var5 = this.h.c();
         this.q = new da[var5 - var4 + 1];
         int var6 = var4;

         dg var10000;
         while(true) {
            if(var6 <= var5) {
               var10000 = this;
               if(var12) {
                  break;
               }

               this.q[var6 - var4] = new da();
               ++var6;
               if(!var12) {
                  continue;
               }
            }

            var10000 = this;
            break;
         }

         Iterator var13 = var10000.a.iterator();

         while(var13.hasNext()) {
            Object var7 = var13.next();
            int var9;
            if(var7 instanceof y.c.q) {
               y.c.q var8 = (y.c.q)var7;
               if(var8.e() == null || var3.a((Object)var8) != this) {
                  continue;
               }

               var9 = var2.a(var8).j();
               if(this.g.c() > var9 || this.h.c() < var9) {
                  continue;
               }

               this.b(var9).add(var8);
               if(!var12) {
                  continue;
               }
            }

            dg var14 = (dg)var7;
            if(var14.g != null && var14.h != null) {
               var14.a(var1, var2, var3);
               var9 = var14.g.c();
               int var10 = var14.h.c();
               int var11 = var9;

               while(var11 <= var10) {
                  this.b(var11).add(var14);
                  ++var11;
                  if(var12 || var12) {
                     return;
                  }
               }
            }
         }

      }
   }

   void a(int var1, float[] var2, y.c.c var3, aV var4, boolean var5) {
      this.a(var1, var2, var3, var5);
      dh var6 = new dh(this, var2);
      this.a(var1, var6, var4);
   }

   private void a(int var1, Comparator var2, aV var3) {
      boolean var10 = N.x;
      da var4 = this.b(var1);
      var4.sort(var2);
      y.c.p var5 = null;
      y.c.p var6 = null;
      y.c.p var7 = var4.k();

      while(true) {
         if(var7 != null) {
            Object var10000 = var7.c();
            if(var10) {
               break;
            }

            label52: {
               if(var10000 instanceof dg) {
                  ((dg)var7.c()).a(var1, var2, var3);
                  if(!var10) {
                     break label52;
                  }
               }

               y.c.q var8 = (y.c.q)var7.c();
               byte var9 = var3.a(var8).b();
               if(var9 == 12) {
                  var5 = var7;
                  if(!var10) {
                     break label52;
                  }
               }

               if(var9 == 13) {
                  var6 = var7;
               }
            }

            var7 = var7.a();
            if(!var10) {
               continue;
            }
         }

         if(var5 != null && var5 != var4.k()) {
            var4.h(var5);
            var4.a(var5, var4.k());
         }

         if(var6 == null || var6 == var4.l()) {
            return;
         }

         var4.h(var6);
         break;
      }

      var4.b(var6, var4.l());
   }

   da b(int var1) {
      return this.q[var1 - this.g.c()];
   }

   private void a(int var1, float[] var2, y.c.c var3, boolean var4) {
      boolean var9 = N.x;
      this.i = this.j = this.m = this.n = 0.0F;
      this.k = this.l = this.o = this.p = 0;
      Iterator var5 = this.b(var1).iterator();

      int var10000;
      while(true) {
         if(var5.hasNext()) {
            Object var6 = var5.next();
            var10000 = var6 instanceof dg;
            if(var9) {
               break;
            }

            if(var10000 != 0) {
               dg var7 = (dg)var6;
               var7.a(var1, var2, var3, var4);
               this.i += var7.i;
               this.k += var7.k;
               this.j += var7.j;
               this.l += var7.l;
               this.m += var7.m;
               this.o += var7.o;
               this.n += var7.n;
               this.p += var7.p;
               if(!var9) {
                  continue;
               }
            }

            y.c.q var10 = (y.c.q)var6;
            boolean var8 = var4 && var10.b() > 0 || !var4 && var10.c() > 0;
            if(var3 != null && !var3.d(var10)) {
               if(var8) {
                  ++this.l;
                  this.j += var2[var10.d()];
               }

               ++this.p;
               this.n += var2[var10.d()];
               if(!var9) {
                  continue;
               }
            }

            if(var8) {
               ++this.k;
               this.i += var2[var10.d()];
            }

            ++this.o;
            this.m += var2[var10.d()];
            if(!var9) {
               continue;
            }
         }

         var10000 = this.l;
         break;
      }

      if(var10000 > 0) {
         this.b = this.j / (float)this.l;
         if(!var9) {
            return;
         }
      }

      if(this.k > 0) {
         this.b = this.i / (float)this.k;
         if(!var9) {
            return;
         }
      }

      if(this.p > 0) {
         this.b = this.n / (float)this.p;
         if(!var9) {
            return;
         }
      }

      if(this.o > 0) {
         this.b = this.m / (float)this.o;
         if(!var9) {
            return;
         }
      }

      this.b = 0.0F;
   }

   y.c.p a(aQ var1, y.c.p var2, aP var3, dd var4) {
      boolean var13 = N.x;
      if(this.g != null && this.g.c() <= var1.c() && this.h != null && this.h.c() >= var1.c()) {
         y.c.y var5 = var1.d();
         da var6 = this.b(var1.c());
         boolean var7 = true;
         if(var6.size() > 1 && var6.f() instanceof y.c.q && var6.i() instanceof y.c.q) {
            aX var8 = var4.b.a((y.c.q)var6.f());
            aX var9 = var4.b.a((y.c.q)var6.i());
            if(var8.b() == 12 && var9.b() == 13) {
               var7 = false;
            }
         }

         y.c.p var14 = var6.k();

         y.c.p var10000;
         while(true) {
            if(var14 != null) {
               var10000 = var14;
               if(var13) {
                  break;
               }

               label51: {
                  Object var15 = var14.c();
                  if(var15 instanceof dg) {
                     dg var10 = (dg)var15;
                     if(var7) {
                        y.c.q var11;
                        y.c.q var12;
                        label46: {
                           var11 = var3.a(var10.f, var1, (byte)12);
                           var5.a((Object)var11, (y.c.p)var2);
                           var2 = var10.a(var1, var2, var3, var4);
                           var12 = var3.a(var10.f, var1, (byte)13);
                           if(var2 != null) {
                              var5.a((Object)var12, (y.c.p)var2);
                              if(!var13) {
                                 break label46;
                              }
                           }

                           var5.b((Object)var12);
                        }

                        var10.b(var1.c()).a(var11);
                        var10.b(var1.c()).b(var12);
                        var4.a(var11, var10);
                        var4.a(var12, var10);
                        if(!var13) {
                           break label51;
                        }
                     }

                     var2 = var10.a(var1, var2, var3, var4);
                     if(!var13) {
                        break label51;
                     }
                  }

                  var2 = var2.a();
               }

               var14 = var14.a();
               if(!var13) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      } else {
         return var2;
      }
   }

   public void b(aV var1) {
      boolean var7 = N.x;
      Iterator var2 = this.a.iterator();

      byte var10000;
      while(true) {
         if(var2.hasNext()) {
            Object var3 = var2.next();
            var10000 = var3 instanceof y.c.q;
            if(var7) {
               break;
            }

            if(var10000 != 0) {
               y.c.q var4 = (y.c.q)var3;
               aX var5 = var1.a(var4);
               if(var5.b() != 12 && var5.b() != 13) {
                  continue;
               }

               var2.remove();
               this.D.remove(var3);
               if(!var7) {
                  continue;
               }
            }

            dg var10 = (dg)var3;
            var10.b(var1);
            if(!var7) {
               continue;
            }
         }

         if(this.q == null) {
            return;
         }

         var10000 = 0;
         break;
      }

      int var8 = var10000;

      do {
         int var13 = var8;

         label47:
         while(true) {
            if(var13 >= this.q.length) {
               return;
            }

            da var9 = this.q[var8];
            y.c.p var11 = var9.k();

            while(true) {
               if(var11 == null) {
                  break label47;
               }

               var13 = var11.c() instanceof y.c.q;
               if(var7) {
                  break;
               }

               if(var13 != 0) {
                  y.c.q var12 = (y.c.q)var11.c();
                  aX var6 = var1.a(var12);
                  if(var6.b() == 12 || var6.b() == 13) {
                     var9.h(var11);
                  }
               }

               var11 = var11.a();
               if(var7) {
                  break label47;
               }
            }
         }

         ++var8;
      } while(!var7);

   }

   public void a(cr var1, aQ var2, boolean var3, double var4) {
      boolean var30 = N.x;
      aV var6 = this.C.c;
      y.f.X var7 = this.C.b;
      da var8 = this.b(var2.c());
      y.c.q var9 = null;
      y.c.p var10 = var8.k();

      while(var10 != null) {
         label133: {
            label141: {
               Object var11 = var10.c();
               if(var11 instanceof dg) {
                  dg var12 = (dg)var11;
                  var12.a(var1, var2, var3, var4);
                  if(var3 && this.A == var2) {
                     var1.a(this, var12, 2);
                     if(!var30) {
                        break label141;
                     }
                  }

                  if(var3 || this.B != var2) {
                     break label141;
                  }

                  var1.a(var12, this, 2);
                  if(!var30) {
                     break label141;
                  }
               }

               y.c.q var31 = (y.c.q)var11;
               aX var13 = var6.a(var31);
               double var14;
               y.c.d var15;
               double var16;
               y.c.q var18;
               y.d.r var19;
               aY var20;
               double var21;
               double var23;
               cy var27;
               y.c.p var32;
               if(var3 && this.A == var2) {
                  if(var13.b() == 12) {
                     var9 = var31;
                     if(!var30) {
                        break label141;
                     }
                  }

                  if(var13.b() == 13) {
                     var14 = var7.m(var9) + var7.p(var9);
                     var16 = var7.m(var31);
                     var18 = var13.f();
                     var19 = this.C.c(var18);
                     var20 = var6.a(var18).i();
                     var21 = Math.max(var20 != null?var20.d():0.0D, this.C.h());
                     var23 = var19.a;
                     var27 = var1.a(this, 0.0D, var21, var23, var14, !var3, var16, !var3);
                     var27.l = Math.min(var7.k(var9), var7.k(var31)) + var4;
                     if(!var30) {
                        break label141;
                     }
                  }

                  if(var13.b() != 15) {
                     break label141;
                  }

                  var32 = var13.d();

                  do {
                     if(var32 == null) {
                        break label141;
                     }

                     var15 = (y.c.d)var32.c();
                     var1.a(var15, this, 1);
                     var32 = var32.a();
                     if(var30) {
                        break label133;
                     }
                  } while(!var30);
               }

               if(!var3 && this.B == var2) {
                  label146: {
                     if(var13.b() == 12) {
                        var9 = var31;
                        if(!var30) {
                           break label146;
                        }
                     }

                     if(var13.b() == 13) {
                        var14 = var7.m(var9) + var7.p(var9);
                        var16 = var7.m(var31);
                        var18 = var13.f();
                        var19 = this.C.c(var18);
                        var20 = var6.a(var18).i();
                        var21 = Math.max(var20 != null?var20.d():0.0D, this.C.h());
                        var23 = var19.c;
                        var27 = var1.a(this, 0.0D, var23, var21, var14, !var3, var16, !var3);
                        y.c.c var28 = var7.c(y.f.b.f.f);
                        if(var28 != null) {
                           y.d.q var29 = (y.d.q)var28.b(this.f);
                           if(var29 != null) {
                              var27.k = this.E + var29.b;
                              if(!var30) {
                                 break label146;
                              }
                           }

                           var27.k = this.E;
                           if(!var30) {
                              break label146;
                           }
                        }

                        var27.k = this.E;
                        if(!var30) {
                           break label146;
                        }
                     }

                     if(var13.b() == 15) {
                        var32 = var13.d();

                        while(var32 != null) {
                           var15 = (y.c.d)var32.c();
                           var1.a(this, var15, 1);
                           var32 = var32.a();
                           if(var30) {
                              break label133;
                           }

                           if(var30) {
                              break;
                           }
                        }
                     }
                  }
               }
            }

            var10 = var10.a();
         }

         if(var30) {
            break;
         }
      }

   }

   public Collection f() {
      return this.a;
   }

   static float a(dg var0) {
      return var0.b;
   }
}
