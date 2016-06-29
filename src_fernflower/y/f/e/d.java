package y.f.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y.c.D;
import y.f.I;
import y.f.X;
import y.f.aN;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.e.C;
import y.f.e.e;
import y.f.e.f;
import y.f.e.g;
import y.f.e.h;
import y.f.e.i;
import y.g.M;
import y.g.al;
import y.g.ar;

public class d extends y.f.c {
   public static final Object n = "SPHERE_OF_ACTION_NODES";
   public static final Object o = "y.layout.organic.OrganicLayouter.FIXED_GROUP_NODES_DPKEY";
   private byte q = 1;
   public static final Object p = "OrganicLayouter.EDGE_LENGTH_DATA";
   private byte r = 0;
   private double s = 0.65D;
   private double t = Math.max(0.1D, 1.0D);
   private double u;
   private double v = 80.0D;
   private double w;
   private double x;
   private h y;
   private double z;
   private double A = 3.0D;
   private boolean B = true;
   private int C;
   private X D;
   private g[] E;
   private int F;
   private g[] G;
   private ar H;
   private boolean I = true;
   private long J = 30000L;
   private double K = 0.0D;
   private double L;
   private al M;
   private double N;
   private double O;
   private double[] P;
   private double[] Q;
   private boolean R = false;
   private boolean S = false;
   private byte T = 1;
   private byte U = 1;
   private int V = 1000;
   private y.f.b.c W;
   private List X;
   private List Y;
   private Map Z;
   private byte[] aa;
   private double ab;
   private double ac;
   private int ad = 1;
   private int ae = 1;
   private int af = 1;
   private y.f.b.a ag = new y.f.b.h();
   private double ah = 0.2D;
   private int[] ai;
   private byte aj;

   public d() {
      super.a((ad)(new f(this, (e)null)));
      this.d(false);
      ((aN)this.c()).a((byte)1);
   }

   public void a(int var1) {
      if(var1 <= 2 && var1 >= 0) {
         this.U = (byte)var1;
      } else {
         throw new IllegalArgumentException("Repulsion must lie within [0,2]");
      }
   }

   public void b(int var1) {
      if(var1 <= 2 && var1 >= 0) {
         this.T = (byte)var1;
      } else {
         throw new IllegalArgumentException("Attraction must lie within [0,2]");
      }
   }

   public y.f.b.a a() {
      return this.ag;
   }

   public void a(y.f.b.a var1) {
      this.ag = var1;
   }

   public double n() {
      return this.ah;
   }

   public void a(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.ah = var1;
         if(!i.b) {
            return;
         }
      }

      throw new IllegalArgumentException(var1 + " not in [0,1]");
   }

   public byte o() {
      return this.aj;
   }

   public void b(double var1) {
      this.t = var1;
   }

   public void g(boolean var1) {
      this.S = var1;
   }

   public boolean p() {
      return this.S;
   }

   public void h(boolean var1) {
      this.R = var1;
   }

   public boolean q() {
      return this.R;
   }

   public void c(double var1) {
      this.K = var1;
   }

   public void b(byte var1) {
      this.r = var1;
      if(this.r != 0) {
         this.c((byte)2);
      }

   }

   public byte r() {
      return this.r;
   }

   public void c(byte var1) {
      this.q = var1;
   }

   public void a(long var1) {
      this.J = var1;
   }

   public void d(double var1) {
      this.A = var1;
   }

   public void c(int var1) {
      this.v = (double)var1;
   }

   public void i(boolean var1) {
      this.B = var1;
   }

   public boolean b(X var1) {
      return true;
   }

   public void a(X var1) {
      boolean var18 = i.b;
      if(var1 != null) {
         this.D = var1;
         boolean var2 = y.f.b.c.b((y.c.i)var1);
         C var3 = null;
         if(var2) {
            if(!this.d(var1)) {
               return;
            }
         } else {
            var3 = new C(var1);
            if(this.q()) {
               var3.a();
            }

            if(!this.a((X)var1, (int[])null)) {
               return;
            }
         }

         try {
            h var4 = new h();
            long var5 = 0L;
            long var7 = (long)(this.A * (double)e(this.G.length) + (double)(20 * this.G.length));
            var7 = Math.max(var7, 10000L);
            double var9 = this.t * this.t * (double)this.G.length;
            int var11 = this.V;

            try {
               while(this.w > var9 && var5 < var7) {
                  g var12 = this.d((int)(var5 & 2147483647L));
                  if(var11-- == 0) {
                     if(this.M.d() > this.J) {
                        var5 = var7;
                     }

                     y.a.a.a();
                     var11 = this.V;
                  }

                  if(this.r != 1 || var12.m) {
                     this.f(var12, var4);
                     this.e(var12, var4);
                     this.d(var12, var4);
                  }

                  label264: {
                     if(this.I) {
                        this.a(var12, var4);
                        this.b(var12, var4);
                        if(!var18) {
                           break label264;
                        }
                     }

                     this.a(this.T, var12, var4);
                     this.b(this.U, var12, var4);
                  }

                  double var13 = Math.sqrt(var4.a * var4.a + var4.b * var4.b + var4.c * var4.c);
                  this.a(var12, var4, var13);
                  this.b(var12, var4, var13);
                  if(var2) {
                     this.b(var12);
                     this.a(var12);
                  }

                  ++var5;
                  if(var18) {
                     break;
                  }
               }
            } catch (y.a.a var25) {
               ;
            } finally {
               this.u();
            }
         } finally {
            label247: {
               if(var2) {
                  this.s();
                  if(!var18) {
                     break label247;
                  }
               }

               if(this.q()) {
                  var3.b();
               }
            }

         }

      }
   }

   private boolean d(X var1) {
      boolean var17 = i.b;
      this.D = var1;
      if(var1 == null) {
         return false;
      } else {
         this.W = new y.f.b.c(var1);
         this.X = new ArrayList(500);
         y.c.c var2 = var1.c(o);
         int[] var3 = null;
         if(this.r == 1) {
            var3 = new int[var1.e()];
            y.c.A var4 = M.a(var3);
            y.a.b.a(var1, (y.c.c)var1.c(n), var4);
         }

         this.ai = new int[var1.e()];
         y.c.q var18 = this.W.b();
         if(var2 != null) {
            this.Z = new HashMap();
         }

         y.c.x var5 = var1.o();

         boolean var10000;
         y.c.e var19;
         y.c.d var21;
         int var24;
         int var28;
         label261:
         while(true) {
            var10000 = var5.f();

            label258:
            while(true) {
               if(var10000) {
                  y.c.q var6 = var5.e();
                  this.ai[var6.d()] = -1;
                  y.c.q var7 = this.W.a(var6);
                  if(var17) {
                     break;
                  }

                  label253: {
                     if(var7 != var18) {
                        label268: {
                           label292: {
                              boolean var8 = false;
                              if(var2 != null) {
                                 while(var7 != var18) {
                                    var10000 = var2.d(var7);
                                    if(var17) {
                                       break label292;
                                    }

                                    if(var10000) {
                                       var8 = true;
                                       if(!var17) {
                                          break;
                                       }
                                    }

                                    var7 = this.W.a(var7);
                                    if(var17) {
                                       break;
                                    }
                                 }
                              }

                              var10000 = var8;
                           }

                           if(!var10000) {
                              var7 = this.W.a(var6);

                              do {
                                 if(var7 == var18) {
                                    break label268;
                                 }

                                 this.X.add(var1.a((y.c.q)var6, (y.c.q)var7));
                                 var7 = this.W.a(var7);
                                 if(var17) {
                                    break label253;
                                 }
                              } while(!var17);
                           }

                           y.c.q var9 = var7;
                           var7 = this.W.a(var7);

                           while(var7 != var18) {
                              var10000 = var2.d(var7);
                              if(var17) {
                                 continue label258;
                              }

                              if(var10000) {
                                 var9 = var7;
                              }

                              var7 = this.W.a(var7);
                              if(var17) {
                                 break;
                              }
                           }

                           this.ai[var6.d()] = var9.d();
                        }
                     }

                     var5.g();
                  }

                  if(!var17) {
                     continue label261;
                  }
               }

               if(var2 != null) {
                  this.Y = new ArrayList(32);
                  var19 = var1.p();

                  while(var19.f()) {
                     var21 = var19.a();
                     var19.g();
                     var24 = this.ai[var21.c().d()];
                     if(var24 >= 0) {
                        int var23 = this.ai[var21.d().d()];
                        var28 = var23;
                        if(var17) {
                           break label261;
                        }

                        if(var23 == var24) {
                           var1.d(var21);
                           this.Y.add(var21);
                           if(var17) {
                              break;
                           }
                        }
                     }
                  }
               }

               this.aa = new byte[var1.g()];
               break;
            }

            var28 = 0;
            break;
         }

         int var20 = var28;

         while(var20 < this.X.size()) {
            label192: {
               var21 = (y.c.d)this.X.get(var20);
               if(this.W.a(var21.c()) == var21.d()) {
                  this.aa[var21.b()] = 1;
                  if(!var17) {
                     break label192;
                  }
               }

               this.aa[var21.b()] = 2;
            }

            ++var20;
            if(var17) {
               break;
            }
         }

         var19 = var1.p();

         d var29;
         while(true) {
            if(var19.f()) {
               var21 = var19.a();
               var24 = var21.b();
               var29 = this;
               if(var17) {
                  break;
               }

               if(this.aa[var24] == 0) {
                  label287: {
                     if(this.W.a(var21)) {
                        this.aa[var24] = 0;
                        if(!var17) {
                           break label287;
                        }
                     }

                     this.aa[var24] = 3;
                  }
               }

               var19.g();
               if(!var17) {
                  continue;
               }
            }

            var29 = this;
            break;
         }

         double var25;
         label276: {
            double var22 = var29.n();
            var25 = 0.3D;
            if(var22 == 0.0D) {
               this.ae = 0;
               this.ad = 2;
               this.af = 0;
               var25 = 0.001D;
               if(!var17) {
                  break label276;
               }
            }

            if(var22 < 0.1D) {
               this.ae = 1;
               this.ad = 0;
               this.af = 0;
               var25 = 0.001D + 0.01D * var22;
               if(!var17) {
                  break label276;
               }
            }

            this.ae = 1;
            this.ad = 0;
            this.af = 0;
            var25 = 0.011D + var22 * var22 * var22 * 10.0D;
         }

         this.ab = Math.pow(this.v, (double)(-(this.ad + 1)));
         this.ac = var25 * Math.pow(this.v, (double)(-(this.af + 1)));
         if(!this.a(var1, var3)) {
            if(this.W != null) {
               this.W.c();
            }

            if(this.Y != null) {
               int var27 = 0;

               while(var27 < this.Y.size()) {
                  var1.e((y.c.d)this.Y.get(var27));
                  ++var27;
                  if(var17) {
                     return false;
                  }

                  if(var17) {
                     break;
                  }
               }

               this.Y.clear();
            }

            return false;
         } else {
            boolean[] var26 = new boolean[var1.f()];
            y.c.x var10 = this.W.c(this.W.b()).a();

            while(true) {
               if(var10.f()) {
                  y.c.q var11 = var10.e();
                  g var12 = this.E[var11.d()];
                  var10000 = this.W.d(var11);
                  if(var17) {
                     break;
                  }

                  label281: {
                     label152: {
                        if(var10000) {
                           y.c.y var13;
                           if(var2 != null && var2.d(var11)) {
                              this.Z.put(var11, var1.o(var11));
                              var12.o = 3;
                              var13 = this.W.c(var11);
                              var12.s = var13;
                              if(var26[var11.d()]) {
                                 break label152;
                              }

                              y.c.p var14 = var13.k();

                              do {
                                 if(var14 == null) {
                                    break label152;
                                 }

                                 y.c.q var15 = (y.c.q)var14.c();
                                 g var16 = this.E[var15.d()];
                                 var16.p = var12;
                                 var26[var15.d()] = true;
                                 var16.h = var1.j(var15) - var1.j(var11);
                                 var16.i = var1.k(var15) - var1.k(var11);
                                 var16.j = 0.0D;
                                 var14 = var14.a();
                                 if(var17) {
                                    break label281;
                                 }
                              } while(!var17);
                           }

                           var13 = this.W.b(var11);
                           if(var13 == null || var13.size() == 0) {
                              var12.o = 0;
                              if(!var17) {
                                 break label152;
                              }
                           }

                           var12.o = 1;
                           var12.s = var13;
                           if(!var17) {
                              break label152;
                           }
                        }

                        var12.o = 0;
                     }

                     if(var12.p == null && this.W.a(var11) != this.W.b()) {
                        var12.p = this.E[this.W.a(var11).d()];
                     }

                     var10.g();
                  }

                  if(!var17) {
                     continue;
                  }
               }

               this.a(this.W, this.W.b());
               var10000 = true;
               break;
            }

            return var10000;
         }
      }
   }

   private double a(y.f.b.c var1, y.c.q var2) {
      boolean var11 = i.b;
      y.c.y var3 = var1.b(var2);
      double var4 = 0.0D;
      y.c.p var6 = var3.k();

      while(var6 != null) {
         double var8;
         label21: {
            y.c.q var7 = (y.c.q)var6.c();
            g var10 = this.E[var7.d()];
            if(var1.d(var7) && !var1.b(var7).isEmpty() && var10.o != 3) {
               var8 = this.a(var1, var7);
               var10.r = var8;
               var10.k = var8;
               if(!var11) {
                  break label21;
               }
            }

            var8 = this.E[var7.d()].k;
         }

         var4 += var8 * var8 * 3.0D;
         var6 = var6.a();
         if(var11) {
            break;
         }
      }

      double var12 = var4 / (double)(var3.size() + 1);
      var12 = e(Math.sqrt(var12) + this.v * 0.9D);
      return Math.sqrt(var12 * (double)var3.size()) * 0.5D + this.v;
   }

   private void s() {
      label67: {
         label70: {
            int var1;
            y.c.d var2;
            boolean var13;
            byte var10000;
            label71: {
               var13 = i.b;
               if(this.X != null) {
                  var1 = 0;

                  while(var1 < this.X.size()) {
                     var2 = (y.c.d)this.X.get(var1);
                     var10000 = this.D.f(var2);
                     if(var13) {
                        break label71;
                     }

                     if(var10000 != 0) {
                        this.D.a((y.c.d)var2);
                     }

                     ++var1;
                     if(var13) {
                        break;
                     }
                  }
               }

               if(this.Y == null) {
                  break label70;
               }

               var10000 = 0;
            }

            var1 = var10000;

            while(var1 < this.Y.size()) {
               var2 = (y.c.d)this.Y.get(var1);
               this.D.e(var2);
               I var3 = this.D.b(var2);
               if(var13) {
                  break label67;
               }

               label46: {
                  if(var3.pointCount() > 0) {
                     y.c.q var4 = this.E[var2.c().d()].p.a;
                     y.d.t var5 = this.D.o(var4);
                     y.d.t var6 = (y.d.t)this.Z.get(var4);
                     double var7 = var5.a - var6.a;
                     double var9 = var5.b - var6.b;
                     int var11 = 0;

                     while(var11 < var3.pointCount()) {
                        y.d.t var12 = var3.getPoint(var11);
                        var3.setPoint(var11, var12.a + var7, var12.b + var9);
                        ++var11;
                        if(var13) {
                           break label46;
                        }

                        if(var13) {
                           break;
                        }
                     }
                  }

                  ++var1;
               }

               if(var13) {
                  break;
               }
            }
         }

         (new y.f.b.j((ah)null, new e(this))).c(this.D);
         this.X = null;
         this.ai = null;
         this.aa = null;
      }

      if(this.W != null) {
         this.W.c();
         this.W = null;
      }

      this.Y = null;
   }

   private boolean a(X var1, int[] var2) {
      boolean var12 = i.b;
      if(var1 != null && var1.e() >= 1) {
         label305: {
            this.D = var1;
            this.C = 1;
            this.M = new al();
            this.F = var1.f();
            this.u = e(this.v);
            this.E = new g[this.F];
            this.V = 1 + 100000 / this.F;
            this.L = this.K / (this.v * 6.0D);
            this.N = Math.pow(this.v, (double)(-(this.T + 1)));
            this.O = Math.pow(this.v, (double)(this.U + 1));
            this.w = 0.0D;
            this.x = 0.0D;
            this.y = new h();
            this.z = Math.max(20.0D * this.v, 10.0D);
            if(this.p()) {
               this.H = new ar(666L);
               if(!var12) {
                  break label305;
               }
            }

            this.H = new ar();
         }

         double var3;
         label300: {
            if(this.q == 2) {
               var3 = Math.max(0.1D, Math.min(this.s * this.v * 0.75D, this.z));
               if(!var12) {
                  break label300;
               }
            }

            var3 = Math.max(0.1D, Math.min(this.s * this.v, this.z));
         }

         y.c.c var5 = var1.c(n);
         if(this.r() != 0 && var5 == null) {
            throw new IllegalStateException("No DataProvider that specifies which nodes are to be laid out.");
         } else {
            if(var2 == null && this.r == 1) {
               var2 = new int[this.F];
               y.c.A var6 = M.a(var2);
               y.a.b.a(var1, (y.c.c)var5, var6);
            }

            byte var25;
            label291: {
               int var8;
               int var13;
               int var10000;
               label311: {
                  d var24;
                  label289: {
                     label312: {
                        var13 = this.F;
                        int var7 = 0;
                        y.c.x var9;
                        y.c.q var10;
                        y.c.e var16;
                        y.c.d var18;
                        switch(this.r()) {
                        case 0:
                           ae.a(var1);
                           if(this.ai == null) {
                              break label312;
                           }

                           var8 = 0;

                           do {
                              if(var8 >= this.ai.length) {
                                 break label312;
                              }

                              var10000 = this.ai[var8];
                              if(var12) {
                                 break label311;
                              }

                              if(var10000 >= 0) {
                                 --var13;
                              }

                              ++var8;
                           } while(!var12);
                        case 1:
                           boolean[] var14 = new boolean[var1.e()];
                           var13 = 0;
                           var9 = var1.o();

                           while(var9.f()) {
                              var10 = var9.e();
                              var24 = this;
                              if(var12) {
                                 break label289;
                              }

                              if(this.ai == null || this.ai[var10.d()] < 0) {
                                 if(var5.d(var10)) {
                                    ++var7;
                                    var14[var10.d()] = true;
                                 }

                                 if(var5.d(var10) || var2[var10.d()] < 5 && var2[var10.d()] >= 0) {
                                    ++var13;
                                    var14[var10.d()] = true;
                                 }
                              }

                              var9.g();
                              if(var12) {
                                 break;
                              }
                           }

                           if(var7 < 1) {
                              return false;
                           }

                           var16 = var1.p();

                           do {
                              if(!var16.f()) {
                                 break label312;
                              }

                              var18 = var16.a();
                              var25 = var14[var18.c().d()];
                              if(var12) {
                                 break label291;
                              }

                              if(var25 != 0 || var14[var18.d().d()]) {
                                 ae.a(var1, var18);
                              }

                              var16.g();
                           } while(!var12);
                        case 2:
                           break;
                        default:
                           break label312;
                        }

                        var13 = 0;
                        var16 = var1.p();

                        while(var16.f()) {
                           var18 = var16.a();
                           var25 = var5.d(var18.c());
                           if(var12) {
                              break label291;
                           }

                           if(var25 != 0 || var5.d(var18.d())) {
                              ae.a(var1, var18);
                           }

                           var16.g();
                           if(var12) {
                              break;
                           }
                        }

                        var9 = var1.o();

                        while(var9.f()) {
                           var10 = var9.e();
                           var25 = var5.d(var10);
                           if(var12) {
                              break label291;
                           }

                           if(var25 != 0) {
                              if(this.ai != null) {
                                 if(this.ai[var10.d()] < 0) {
                                    ++var13;
                                 }
                              } else {
                                 ++var13;
                              }
                           }

                           var9.g();
                           if(var12) {
                              break;
                           }
                        }
                     }

                     var24 = this;
                  }

                  var24.G = new g[var13];
                  y.c.x var15 = var1.o();

                  label202: {
                     while(var15.f()) {
                        y.c.q var17 = var15.e();
                        var25 = this.r;
                        if(var12) {
                           break label202;
                        }

                        g var22;
                        label322: {
                           switch(var25) {
                           case 0:
                           default:
                              var22 = new g(var17, var3, true, this.v, this.F, this.H, var1, this.q);
                              if(this.ai == null || this.ai[var17.d()] < 0) {
                                 --var13;
                                 this.G[var13] = var22;
                                 if(!var12) {
                                    break label322;
                                 }
                              }

                              var22.g = 0.0D;
                              var22.j = 0.0D;
                              if(!var12) {
                                 break label322;
                              }
                           case 1:
                              if(var5.d(var17)) {
                                 var22 = new g(var17, var3, true, this.v, this.F, this.H, var1, this.q);
                                 if(this.ai == null || this.ai[var17.d()] < 0) {
                                    --var13;
                                    this.G[var13] = var22;
                                    if(!var12) {
                                       break label322;
                                    }
                                 }

                                 var22.g = 0.0D;
                                 if(!var12) {
                                    break label322;
                                 }
                              }

                              var22 = new g(var17, var3 / (double)(var2[var17.d()] + 2), false, this.v, this.F, this.H, var1, this.q);
                              var22.n = var2[var17.d()];
                              if(this.ai == null || this.ai[var17.d()] < 0) {
                                 if(var2[var17.d()] < 5 && var2[var17.d()] >= 0) {
                                    --var13;
                                    this.G[var13] = var22;
                                    if(!var12) {
                                       break label322;
                                    }
                                 }

                                 var22.g = 0.0D;
                                 if(!var12) {
                                    break label322;
                                 }
                              }

                              var22.g = 0.0D;
                              if(!var12) {
                                 break label322;
                              }
                           case 2:
                           }

                           if(var5.d(var17)) {
                              var22 = new g(var17, var3, true, this.v, this.F, this.H, var1, this.q);
                              if(this.ai == null || this.ai[var17.d()] < 0) {
                                 --var13;
                                 this.G[var13] = var22;
                                 if(!var12) {
                                    break label322;
                                 }
                              }

                              var22.g = 0.0D;
                              if(!var12) {
                                 break label322;
                              }
                           }

                           var22 = new g(var17, 0.0D, false, this.v, this.F, this.H, var1, this.q);
                        }

                        this.E[var17.d()] = var22;
                        var15.g();
                        if(var12) {
                           break;
                        }
                     }

                     var25 = 0;
                  }

                  var8 = var25;
                  var10000 = var8;
               }

               while(true) {
                  label146: {
                     if(var10000 < this.G.length) {
                        g var20 = this.G[var8];
                        this.w += var20.g;
                        this.x += e(var20.g);
                        this.y.a += var20.h;
                        this.y.b += var20.i;
                        this.y.c += var20.j;
                        ++var8;
                        if(var12) {
                           break label146;
                        }

                        if(!var12) {
                           var10000 = var8;
                           continue;
                        }
                     }

                     if(var13 > 0) {
                        throw new RuntimeException("Unexpected number of nodes allocated!");
                     }
                  }

                  if(var1.c(p) == null && this.r != 1) {
                     this.I = false;
                  } else {
                     this.I = true;
                     this.P = new double[var1.g()];
                     this.Q = new double[var1.g()];
                     y.c.e var19 = var1.p();

                     while(var19.f()) {
                        y.c.d var21 = var19.a();
                        double var23 = this.a(var21);
                        this.P[var21.b()] = Math.pow(var23, (double)(-(this.T + 1)));
                        this.Q[var21.b()] = Math.pow(var23, (double)(this.U + 1));
                        var19.g();
                        if(var12) {
                           return this.G.length > 0;
                        }
                     }
                  }

                  var25 = this.r();
                  break;
               }
            }

            if(var25 != 0) {
               this.t();
            }

            return this.G.length > 0;
         }
      } else {
         return false;
      }
   }

   private void t() {
      boolean var12 = i.b;
      D var1 = new D();
      y.c.A var2 = this.D.t();
      Object var3 = new Object();
      Object var4 = new Object();
      y.c.c var5 = this.D.c(n);
      y.c.x var6 = this.D.o();

      label112:
      while(true) {
         boolean var10000 = var6.f();

         label109:
         while(true) {
            Object var17;
            if(var10000) {
               y.c.q var7 = var6.e();
               var10000 = var5.d(var7);
               if(!var12) {
                  if(var10000) {
                     y.c.x var8 = var7.m();

                     while(var8.f()) {
                        y.c.q var9 = var8.e();
                        var10000 = var5.d(var9);
                        if(var12) {
                           continue label109;
                        }

                        if(var10000 && var2.b(var9) == null) {
                           var2.a(var9, var3);
                           var1.b((Object)var9);
                        }

                        var8.g();
                        if(var12) {
                           break;
                        }
                     }
                  }

                  var6.g();
                  if(!var12) {
                     continue label112;
                  }

                  if(var1.isEmpty()) {
                     break;
                  }

                  var17 = var1.g();
               } else {
                  if(var10000) {
                     break;
                  }

                  var17 = var1.g();
               }
            } else {
               if(var1.isEmpty()) {
                  break;
               }

               var17 = var1.g();
            }

            while(true) {
               y.c.q var13;
               int var14;
               int var15;
               int var16;
               label105:
               while(true) {
                  var13 = (y.c.q)var17;
                  var14 = 0;
                  var15 = 0;
                  var16 = 0;
                  if(var12) {
                     return;
                  }

                  y.c.x var10 = var13.m();

                  while(true) {
                     if(!var10.f()) {
                        break label105;
                     }

                     y.c.q var11 = var10.e();
                     var17 = var2.b(var11);
                     if(var12) {
                        break;
                     }

                     if(var17 == null && var5.d(var11)) {
                        var2.a(var11, var3);
                        var1.b((Object)var11);
                     }

                     if(var5.d(var11) || var2.b(var11) == var4) {
                        var15 = (int)((double)var15 + this.E[var11.d()].h);
                        var16 = (int)((double)var16 + this.E[var11.d()].i);
                        ++var14;
                     }

                     var10.g();
                     if(var12) {
                        break label105;
                     }
                  }
               }

               if(var14 > 0) {
                  this.E[var13.d()].h = (double)(var15 / var14);
                  this.E[var13.d()].i = (double)(var16 / var14);
               }

               var2.a(var13, var4);
               if(var12 || var1.isEmpty()) {
                  break label109;
               }

               var17 = var1.g();
            }
         }

         this.D.a((y.c.A)var2);
         return;
      }
   }

   private g d(int var1) {
      int var2 = this.G.length;
      int var3 = var2 - var1 % var2 - 1;
      int var4 = this.H.nextInt(var3 + 1);
      g var5 = this.G[var4];
      this.G[var4] = this.G[var3];
      this.G[var3] = var5;
      return var5;
   }

   private void a(g var1, h var2) {
      double var4;
      double var6;
      double var8;
      double var10;
      boolean var33;
      label275: {
         var33 = i.b;
         int var3 = var1.a.d();
         var8 = 0.0D;
         var6 = 0.0D;
         var4 = 0.0D;
         ++this.C;
         var1.f = this.C;
         if(var1.s != null && var1.r > 0.0D) {
            var10 = Math.pow(var1.q / var1.r, 3.0D) * this.ac;
            if(!var33) {
               break label275;
            }
         }

         var10 = 0.0D;
      }

      boolean var12;
      g var10000;
      double var17;
      double var19;
      label268: {
         var12 = this.aa == null;
         if(var1.o == 3) {
            y.c.p var13 = this.W.f(var1.a).k();

            y.c.d var14;
            g var15;
            g var16;
            double var21;
            double var23;
            double var25;
            double var27;
            double var29;
            while(var13 != null) {
               var14 = (y.c.d)var13.c();
               var15 = this.E[var14.c().d()];
               var16 = this.E[var14.d().d()];
               var16.f = this.C;
               var10000 = var15.p;
               if(var33) {
                  break label268;
               }

               label252: {
                  if(var10000 != null && var15.p.o == 3) {
                     var17 = var15.p.h + var15.h - (var1.h + var16.h);
                     var19 = var15.p.i + var15.i - (var1.i + var16.i);
                     var21 = var15.p.j + var15.j - (var1.j + var16.j);
                     if(!var33) {
                        break label252;
                     }
                  }

                  var17 = var15.h - (var1.h + var16.h);
                  var19 = var15.i - (var1.i + var16.i);
                  var21 = var15.j - (var1.j + var16.j);
               }

               label261: {
                  label260: {
                     var23 = var17 * var17 + var19 * var19 + var21 * var21;
                     var25 = 1.0D;
                     if(this.B) {
                        var27 = Math.sqrt(var23);
                        var29 = var27 - (var15.k + var16.k);
                        if(var29 <= 0.0D) {
                           break label261;
                        }

                        var25 = this.ab * Math.pow(var29, (double)(this.ad + 1)) / var27;
                        if(!var33) {
                           break label260;
                        }
                     }

                     var25 = this.ab * Math.pow(var23, (double)this.ad * 0.5D);
                  }

                  var4 += var17 * var25;
                  var6 += var19 * var25;
                  var8 += var21 * var25;
               }

               var13 = var13.a();
               if(var33) {
                  break;
               }
            }

            var13 = this.W.g(var1.a).k();

            while(var13 != null) {
               var14 = (y.c.d)var13.c();
               var15 = this.E[var14.d().d()];
               var16 = this.E[var14.c().d()];
               var16.f = this.C;
               var10000 = var15.p;
               if(var33) {
                  break label268;
               }

               label230: {
                  if(var10000 != null && var15.p.o == 3) {
                     var17 = var15.p.h + var15.h - (var1.h + var16.h);
                     var19 = var15.p.i + var15.i - (var1.i + var16.i);
                     var21 = var15.p.j + var15.j - (var1.j + var16.j);
                     if(!var33) {
                        break label230;
                     }
                  }

                  var17 = var15.h - (var1.h + var16.h);
                  var19 = var15.i - (var1.i + var16.i);
                  var21 = var15.j - (var1.j + var16.j);
               }

               label239: {
                  label238: {
                     var23 = var17 * var17 + var19 * var19 + var21 * var21;
                     var25 = 1.0D;
                     if(this.B) {
                        var27 = Math.sqrt(var23);
                        var29 = var27 - (var15.k + var16.k);
                        if(var29 <= 0.0D) {
                           break label239;
                        }

                        var25 = this.ab * Math.pow(var29, (double)(this.ad + 1)) / var27;
                        if(!var33) {
                           break label238;
                        }
                     }

                     var25 = this.ab * Math.pow(var23, (double)this.ad * 0.5D);
                  }

                  var4 += var17 * var25;
                  var6 += var19 * var25;
                  var8 += var21 * var25;
               }

               var13 = var13.a();
               if(var33) {
                  break;
               }
            }
         }

         var10000 = var1;
      }

      y.c.d var34 = var10000.a.g();

      double var22;
      double var24;
      double var26;
      double var28;
      g var35;
      double var36;
      g var37;
      while(true) {
         if(var34 != null) {
            var35 = this.E[var34.c().d()];
            var35.f = this.C;
            var37 = var35.p;
            var10000 = var37;
            if(var33) {
               break;
            }

            label211: {
               if(var37 != null && var37.o == 3) {
                  var36 = var37.h + var35.h - var1.h;
                  var17 = var37.i + var35.i - var1.i;
                  var19 = var37.j + var35.j - var1.j;
                  if(!var33) {
                     break label211;
                  }
               }

               var36 = var35.h - var1.h;
               var17 = var35.i - var1.i;
               var19 = var35.j - var1.j;
            }

            var22 = var36 * var36 + var17 * var17 + var19 * var19;
            var24 = 1.0D;
            var26 = Math.sqrt(var22);
            if(var26 != 0.0D) {
               label289: {
                  label203: {
                     if(this.B) {
                        var28 = Math.max(1.0E-6D, var26 - (var1.k + var35.k));
                        if(!var33) {
                           break label203;
                        }
                     }

                     var28 = var26;
                  }

                  label295: {
                     if(var12 || this.aa[var34.b()] == 0) {
                        switch(this.T) {
                        case 0:
                           var24 = var28 * this.P[var34.b()];
                           if(!var33) {
                              break;
                           }
                        case 1:
                           var24 = var28 * var28 * this.P[var34.b()];
                           if(!var33) {
                              break;
                           }
                        case 2:
                           var24 = var28 * var28 * var28 * this.P[var34.b()];
                           if(!var33) {
                              break;
                           }
                        default:
                           var24 = Math.pow(var28, (double)(this.T + 1)) * this.P[var34.b()];
                        }

                        switch(this.U) {
                        case 0:
                           var24 -= this.Q[var34.b()] / var28;
                           if(!var33) {
                              break label295;
                           }
                        case 1:
                           var24 -= this.Q[var34.b()] / (var28 * var28);
                           if(!var33) {
                              break label295;
                           }
                        case 2:
                           var24 -= this.Q[var34.b()] / (var28 * var28 * var28);
                           if(!var33) {
                              break label295;
                           }
                        default:
                           var24 -= this.Q[var34.b()] / Math.pow(var28, (double)(this.U + 1));
                           if(!var33) {
                              break label295;
                           }
                        }
                     }

                     label181:
                     switch(this.aa[var34.b()]) {
                     default:
                        var24 = 0.0D;
                        if(!var33) {
                           break;
                        }
                     case 3:
                        var24 = this.ab * Math.pow(var26, (double)(this.ad + 1));
                        switch(this.U) {
                        case 0:
                           var24 -= this.Q[var34.b()] / var28;
                           if(!var33) {
                              break label181;
                           }
                        case 1:
                           var24 -= this.Q[var34.b()] / (var28 * var28);
                           if(!var33) {
                              break label181;
                           }
                        case 2:
                           var24 -= this.Q[var34.b()] / (var28 * var28 * var28);
                           if(!var33) {
                              break label181;
                           }
                        default:
                           var24 -= this.Q[var34.b()] / Math.pow(var28, (double)(this.U + 1));
                           if(!var33) {
                              break label181;
                           }
                        }
                     case 1:
                        var24 = var10 * Math.pow(var26, (double)(this.af + 1));
                        if(!var33) {
                           break;
                        }
                     case 2:
                        if(!var33) {
                           break label289;
                        }
                     }
                  }

                  var24 /= var26;
                  var4 += var36 * var24;
                  var6 += var17 * var24;
                  var8 += var19 * var24;
               }
            }

            var34 = var34.h();
            if(!var33) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      var34 = var10000.a.f();

      while(true) {
         if(var34 != null) {
            var35 = this.E[var34.d().d()];
            var35.f = this.C;
            var37 = var35.p;
            if(var33) {
               break;
            }

            label159: {
               if(var37 != null && var37.o == 3) {
                  var36 = var37.h + var35.h - var1.h;
                  var17 = var37.i + var35.i - var1.i;
                  var19 = var37.j + var35.j - var1.j;
                  if(!var33) {
                     break label159;
                  }
               }

               var36 = var35.h - var1.h;
               var17 = var35.i - var1.i;
               var19 = var35.j - var1.j;
            }

            var22 = var36 * var36 + var17 * var17 + var19 * var19;
            var24 = 1.0D;
            var26 = Math.sqrt(var22);
            if(var26 != 0.0D) {
               label290: {
                  label151: {
                     if(this.B) {
                        var28 = Math.max(1.0E-6D, var26 - (var1.k + var35.k));
                        if(!var33) {
                           break label151;
                        }
                     }

                     var28 = var26;
                  }

                  label296: {
                     if(var12 || this.aa[var34.b()] == 0) {
                        switch(this.T) {
                        case 0:
                           var24 = var28 * this.P[var34.b()];
                           if(!var33) {
                              break;
                           }
                        case 1:
                           var24 = var28 * var28 * this.P[var34.b()];
                           if(!var33) {
                              break;
                           }
                        case 2:
                           var24 = var28 * var28 * var28 * this.P[var34.b()];
                           if(!var33) {
                              break;
                           }
                        default:
                           var24 = Math.pow(var28, (double)(this.T + 1)) * this.P[var34.b()];
                        }

                        switch(this.U) {
                        case 0:
                           var24 -= this.Q[var34.b()] / var28;
                           if(!var33) {
                              break label296;
                           }
                        case 1:
                           var24 -= this.Q[var34.b()] / (var28 * var28);
                           if(!var33) {
                              break label296;
                           }
                        case 2:
                           var24 -= this.Q[var34.b()] / (var28 * var28 * var28);
                           if(!var33) {
                              break label296;
                           }
                        default:
                           var24 -= this.Q[var34.b()] / Math.pow(var28, (double)(this.U + 1));
                           if(!var33) {
                              break label296;
                           }
                        }
                     }

                     label129:
                     switch(this.aa[var34.b()]) {
                     default:
                        var24 = 0.0D;
                        if(!var33) {
                           break;
                        }
                     case 3:
                        var24 = this.ab * Math.pow(var26, (double)(this.ad + 1));
                        switch(this.U) {
                        case 0:
                           var24 -= this.Q[var34.b()] / var28;
                           if(!var33) {
                              break label129;
                           }
                        case 1:
                           var24 -= this.Q[var34.b()] / (var28 * var28);
                           if(!var33) {
                              break label129;
                           }
                        case 2:
                           var24 -= this.Q[var34.b()] / (var28 * var28 * var28);
                           if(!var33) {
                              break label129;
                           }
                        default:
                           var24 -= this.Q[var34.b()] / Math.pow(var28, (double)(this.U + 1));
                           if(!var33) {
                              break label129;
                           }
                        }
                     case 1:
                        int var30 = var35.a.d();
                        double var31 = Math.pow(var35.q / var35.r, 3.0D) * this.ac;
                        var24 = var31 * Math.pow(var26, (double)(this.af + 1));
                        if(!var33) {
                           break;
                        }
                     case 2:
                        if(!var33) {
                           break label290;
                        }
                     }
                  }

                  var24 /= var26;
                  var4 += var36 * var24;
                  var6 += var17 * var24;
                  var8 += var19 * var24;
               }
            }

            var34 = var34.g();
            if(!var33) {
               continue;
            }
         }

         var2.a += var4;
         var2.b += var6;
         var2.c += var8;
         break;
      }

   }

   private void b(g var1, h var2) {
      boolean var12 = i.b;
      g var3 = var1;
      if(var1 != null && var1.o == 3) {
         y.c.p var4 = var1.s.k();

         while(var4 != null) {
            g var5 = this.E[((y.c.q)var4.c()).d()];
            double var6 = var5.h;
            double var8 = var5.i;
            double var10 = var5.j;
            var5.h += var3.h;
            var5.i += var3.i;
            var5.j += var3.j;
            var5.f = var1.f;
            this.c(var5, var2);
            var5.h = var6;
            var5.i = var8;
            var5.j = var10;
            var4 = var4.a();
            if(var12) {
               return;
            }

            if(var12) {
               break;
            }
         }
      }

      this.c(var1, var2);
   }

   private void c(g var1, h var2) {
      boolean var26 = i.b;
      double var7 = 0.0D;
      double var5 = 0.0D;
      double var3 = 0.0D;
      int var9 = this.F - 1;

      while(true) {
         if(var9 >= 0) {
            g var10 = this.E[var9];
            if(var26) {
               break;
            }

            if(var10.f != var1.f) {
               label69: {
                  double var12;
                  double var14;
                  double var16;
                  label55: {
                     g var11 = var10.p;
                     if(var11 != null && var11.o == 3) {
                        if(var11 == var1 || var11 == var1.p) {
                           break label69;
                        }

                        var12 = var1.h - (var11.h + var10.h);
                        var14 = var1.i - (var11.i + var10.i);
                        var16 = var1.j - (var11.j + var10.j);
                        if(!var26) {
                           break label55;
                        }
                     }

                     var12 = var1.h - var10.h;
                     var14 = var1.i - var10.i;
                     var16 = var1.j - var10.j;
                  }

                  double var18 = var12 * var12 + var14 * var14 + var16 * var16;
                  if(var18 != 0.0D) {
                     double var20;
                     double var22;
                     double var24;
                     label47: {
                        var20 = 1.0D;
                        var22 = Math.sqrt(var18);
                        if(this.B) {
                           var24 = Math.max(1.0E-6D, var22 - (var1.k + var10.k));
                           if(!var26) {
                              break label47;
                           }
                        }

                        var24 = var22;
                     }

                     switch(this.U) {
                     case 0:
                        var20 = this.O / (var24 * var22);
                        if(!var26) {
                           break;
                        }
                     case 1:
                        var20 = this.O / (var24 * var24 * var22);
                        if(!var26) {
                           break;
                        }
                     case 2:
                        var20 = this.O / (var24 * var24 * var24 * var22);
                        if(!var26) {
                           break;
                        }
                     default:
                        var20 = this.O / (Math.pow(var24, (double)(this.U + 1)) * var22);
                     }

                     var3 += var12 * var20;
                     var5 += var14 * var20;
                     var7 += var16 * var20;
                  }
               }
            }

            --var9;
            if(!var26) {
               continue;
            }
         }

         var2.a += var3;
         var2.b += var5;
         var2.c += var7;
         break;
      }

   }

   private void a(int var1, g var2, h var3) {
      double var4;
      double var6;
      double var8;
      double var11;
      boolean var32;
      label257: {
         var32 = i.b;
         var8 = 0.0D;
         var6 = 0.0D;
         var4 = 0.0D;
         ++this.C;
         var2.f = this.C;
         int var10 = var2.a.d();
         if(var2.o == 1) {
            var11 = Math.pow(var2.q / var2.r, 3.0D) * this.ac;
            if(!var32) {
               break label257;
            }
         }

         var11 = 0.0D;
      }

      boolean var13;
      g var16;
      g var10000;
      double var24;
      double var26;
      double var28;
      double var30;
      label251: {
         var13 = this.aa != null;
         if(var2.o == 3) {
            y.c.p var14 = this.W.f(var2.a).k();

            y.c.d var15;
            g var17;
            double var18;
            double var20;
            double var22;
            while(var14 != null) {
               var15 = (y.c.d)var14.c();
               var16 = this.E[var15.c().d()];
               var17 = this.E[var15.d().d()];
               var17.f = this.C;
               var10000 = var16.p;
               if(var32) {
                  break label251;
               }

               label235: {
                  if(var10000 != null && var16.p.o == 3) {
                     var18 = var16.p.h + var16.h - (var2.h + var17.h);
                     var20 = var16.p.i + var16.i - (var2.i + var17.i);
                     var22 = var16.p.j + var16.j - (var2.j + var17.j);
                     if(!var32) {
                        break label235;
                     }
                  }

                  var18 = var16.h - (var2.h + var17.h);
                  var20 = var16.i - (var2.i + var17.i);
                  var22 = var16.j - (var2.j + var17.j);
               }

               label244: {
                  label243: {
                     var24 = var18 * var18 + var20 * var20 + var22 * var22;
                     var26 = 1.0D;
                     if(this.B) {
                        var28 = Math.sqrt(var24);
                        var30 = var28 - (var16.k + var17.k);
                        if(var30 <= 0.0D) {
                           break label244;
                        }

                        var26 = this.ab * Math.pow(var30, (double)(this.ad + 1)) / var28;
                        if(!var32) {
                           break label243;
                        }
                     }

                     var26 = this.ab * Math.pow(var24, (double)this.ad * 0.5D);
                  }

                  var4 += var18 * var26;
                  var6 += var20 * var26;
                  var8 += var22 * var26;
               }

               var14 = var14.a();
               if(var32) {
                  break;
               }
            }

            var14 = this.W.g(var2.a).k();

            while(var14 != null) {
               var15 = (y.c.d)var14.c();
               var16 = this.E[var15.d().d()];
               var17 = this.E[var15.c().d()];
               var17.f = this.C;
               var10000 = var16.p;
               if(var32) {
                  break label251;
               }

               label213: {
                  if(var10000 != null && var16.p.o == 3) {
                     var18 = var16.p.h + var16.h - (var2.h + var17.h);
                     var20 = var16.p.i + var16.i - (var2.i + var17.i);
                     var22 = var16.p.j + var16.j - (var2.j + var17.j);
                     if(!var32) {
                        break label213;
                     }
                  }

                  var18 = var16.h - (var2.h + var17.h);
                  var20 = var16.i - (var2.i + var17.i);
                  var22 = var16.j - (var2.j + var17.j);
               }

               label222: {
                  label221: {
                     var24 = var18 * var18 + var20 * var20 + var22 * var22;
                     var26 = 1.0D;
                     if(this.B) {
                        var28 = Math.sqrt(var24);
                        var30 = var28 - (var16.k + var17.k);
                        if(var30 <= 0.0D) {
                           break label222;
                        }

                        var26 = this.ab * Math.pow(var30, (double)(this.ad + 1)) / var28;
                        if(!var32) {
                           break label221;
                        }
                     }

                     var26 = this.ab * Math.pow(var24, (double)this.ad * 0.5D);
                  }

                  var4 += var18 * var26;
                  var6 += var20 * var26;
                  var8 += var22 * var26;
               }

               var14 = var14.a();
               if(var32) {
                  break;
               }
            }
         }

         var10000 = var2;
      }

      y.c.d var33 = var10000.a.g();

      double var19;
      double var21;
      g var23;
      int var34;
      double var35;
      while(true) {
         if(var33 != null) {
            var34 = var33.b();
            var16 = this.E[var33.c().d()];
            var23 = var16.p;
            var10000 = var23;
            if(var32) {
               break;
            }

            label194: {
               if(var23 != null && var23.o == 3) {
                  var35 = var23.h + var16.h - var2.h;
                  var19 = var23.i + var16.i - var2.i;
                  var21 = var23.j + var16.j - var2.j;
                  if(!var32) {
                     break label194;
                  }
               }

               var35 = var16.h - var2.h;
               var19 = var16.i - var2.i;
               var21 = var16.j - var2.j;
            }

            label188: {
               label264: {
                  var24 = var35 * var35 + var19 * var19 + var21 * var21;
                  var26 = 1.0D;
                  if(var13 && this.aa[var34] != 0) {
                     switch(this.aa[var34]) {
                     default:
                        if(!var32) {
                           break label188;
                        }
                     case 1:
                        var16.f = this.C;
                        var26 = var11 * Math.pow(var24, (double)this.af * 0.5D);
                        if(!var32) {
                           break label264;
                        }
                     case 3:
                        if(this.B) {
                           var28 = Math.sqrt(var24);
                           var30 = var28 - (var16.k + var2.k);
                           if(var30 <= 0.0D) {
                              break label188;
                           }

                           var26 = this.ab * Math.pow(var30, (double)(this.ad + 1)) / var28;
                           if(!var32) {
                              break label264;
                           }
                        }

                        var26 = this.ab * Math.pow(var24, (double)this.ad * 0.5D);
                        if(!var32) {
                           break label264;
                        }
                     case 2:
                        var16.f = this.C;
                        if(!var32) {
                           break label188;
                        }
                     }
                  }

                  if(this.B) {
                     var28 = Math.sqrt(var24);
                     var30 = var28 - (var16.k + var2.k);
                     if(var30 <= 0.0D) {
                        break label188;
                     }

                     switch(var1) {
                     case 0:
                        var26 = var30 * this.N / var28;
                        if(!var32) {
                           break label264;
                        }
                     case 1:
                        var26 = var30 * var30 * this.N / var28;
                        if(!var32) {
                           break label264;
                        }
                     case 2:
                        var26 = var30 * var30 * var30 * this.N / var28;
                        if(!var32) {
                           break label264;
                        }
                     default:
                        var26 = this.N * Math.pow(var30, (double)(var1 + 1)) / var28;
                        if(!var32) {
                           break label264;
                        }
                     }
                  }

                  switch(var1) {
                  case 0:
                     var26 = this.N;
                     if(!var32) {
                        break;
                     }
                  case 1:
                     var26 = this.N * Math.sqrt(var24);
                     if(!var32) {
                        break;
                     }
                  case 2:
                     var26 = this.N * var24;
                     if(!var32) {
                        break;
                     }
                  default:
                     var26 = this.N * Math.pow(var24, (double)var1 * 0.5D);
                  }
               }

               var4 += var35 * var26;
               var6 += var19 * var26;
               var8 += var21 * var26;
            }

            var33 = var33.h();
            if(!var32) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      var33 = var10000.a.f();

      while(true) {
         if(var33 != null) {
            var34 = var33.b();
            var16 = this.E[var33.d().d()];
            var23 = var16.p;
            if(var32) {
               break;
            }

            label147: {
               if(var23 != null && var23.o == 3) {
                  var35 = var23.h + var16.h - var2.h;
                  var19 = var23.i + var16.i - var2.i;
                  var21 = var23.j + var16.j - var2.j;
                  if(!var32) {
                     break label147;
                  }
               }

               var35 = var16.h - var2.h;
               var19 = var16.i - var2.i;
               var21 = var16.j - var2.j;
            }

            label141: {
               label266: {
                  var24 = var35 * var35 + var19 * var19 + var21 * var21;
                  var26 = 1.0D;
                  if(var13 && this.aa[var34] != 0) {
                     switch(this.aa[var34]) {
                     default:
                        if(!var32) {
                           break label141;
                        }
                     case 1:
                        var16.f = this.C;
                        var26 = Math.pow(var16.q / var16.r, 3.0D) * this.ac * Math.pow(var24, (double)this.af * 0.5D);
                        if(!var32) {
                           break label266;
                        }
                     case 3:
                        if(this.B) {
                           var28 = Math.sqrt(var24);
                           var30 = var28 - (var16.k + var2.k);
                           if(var30 <= 0.0D) {
                              break label141;
                           }

                           var26 = this.ab * Math.pow(var30, (double)(this.ad + 1)) / var28;
                           if(!var32) {
                              break label266;
                           }
                        }

                        var26 = this.ab * Math.pow(var24, (double)this.ad * 0.5D);
                        if(!var32) {
                           break label266;
                        }
                     case 2:
                        var16.f = this.C;
                        if(!var32) {
                           break label141;
                        }
                     }
                  }

                  if(this.B) {
                     var28 = Math.sqrt(var24);
                     var30 = var28 - (var16.k + var2.k);
                     if(var30 <= 0.0D) {
                        break label141;
                     }

                     switch(var1) {
                     case 0:
                        var26 = var30 * this.N / var28;
                        if(!var32) {
                           break label266;
                        }
                     case 1:
                        var26 = var30 * var30 * this.N / var28;
                        if(!var32) {
                           break label266;
                        }
                     case 2:
                        var26 = var30 * var30 * var30 * this.N / var28;
                        if(!var32) {
                           break label266;
                        }
                     default:
                        var26 = this.N * Math.pow(var30, (double)(var1 + 1)) / var28;
                        if(!var32) {
                           break label266;
                        }
                     }
                  }

                  switch(var1) {
                  case 0:
                     var26 = this.N;
                     if(!var32) {
                        break;
                     }
                  case 1:
                     var26 = this.N * Math.sqrt(var24);
                     if(!var32) {
                        break;
                     }
                  case 2:
                     var26 = this.N * var24;
                     if(!var32) {
                        break;
                     }
                  default:
                     var26 = this.N * Math.pow(var24, (double)var1 * 0.5D);
                  }
               }

               var4 += var35 * var26;
               var6 += var19 * var26;
               var8 += var21 * var26;
            }

            var33 = var33.g();
            if(!var32) {
               continue;
            }
         }

         var3.a += var4;
         var3.b += var6;
         var3.c += var8;
         break;
      }

   }

   private void b(int var1, g var2, h var3) {
      boolean var13 = i.b;
      g var4 = var2;
      if(var2 != null && var2.o == 3) {
         y.c.p var5 = var2.s.k();

         while(var5 != null) {
            g var6 = this.E[((y.c.q)var5.c()).d()];
            double var7 = var6.h;
            double var9 = var6.i;
            double var11 = var6.j;
            var6.h += var4.h;
            var6.i += var4.i;
            var6.j += var4.j;
            var6.f = var2.f;
            this.c(var1, var6, var3);
            var6.h = var7;
            var6.i = var9;
            var6.j = var11;
            var5 = var5.a();
            if(var13) {
               return;
            }

            if(var13) {
               break;
            }
         }
      }

      this.c(var1, var2, var3);
   }

   private void c(int var1, g var2, h var3) {
      boolean var28 = i.b;
      double var8 = 0.0D;
      double var6 = 0.0D;
      double var4 = 0.0D;
      boolean var10 = this.aa != null;
      int var11 = this.F - 1;

      while(true) {
         if(var11 >= 0) {
            g var12 = this.E[var11];
            if(var28) {
               break;
            }

            if(!var10 || var12.f != var2.f) {
               label91: {
                  double var13;
                  double var15;
                  double var17;
                  label74: {
                     g var19 = var12.p;
                     if(var19 != null && var19.o == 3) {
                        if(var19 == var2 || var19 == var2.p) {
                           break label91;
                        }

                        var13 = var2.h - (var19.h + var12.h);
                        var15 = var2.i - (var19.i + var12.i);
                        var17 = var2.j - (var19.j + var12.j);
                        if(!var28) {
                           break label74;
                        }
                     }

                     var13 = var2.h - var12.h;
                     var15 = var2.i - var12.i;
                     var17 = var2.j - var12.j;
                  }

                  double var20 = var13 * var13 + var15 * var15 + var17 * var17;
                  if(var20 != 0.0D) {
                     double var22;
                     label66: {
                        var22 = 1.0D;
                        if(this.B) {
                           double var24 = Math.sqrt(var20);
                           double var26 = var24 - (var2.k + var12.k);
                           if(var26 <= 0.0D) {
                              var22 = this.O / (1.0E-8D * var24);
                              if(!var28) {
                                 break label66;
                              }
                           }

                           switch(var1) {
                           case 0:
                              var22 = this.O / (var26 * var24);
                              if(!var28) {
                                 break label66;
                              }
                           case 1:
                              var22 = this.O / (var26 * var26 * var24);
                              if(!var28) {
                                 break label66;
                              }
                           case 2:
                              var22 = this.O / (var26 * var26 * var26 * var24);
                              if(!var28) {
                                 break label66;
                              }
                           default:
                              var22 = this.O / (Math.pow(var26, (double)(var1 + 1)) * var24);
                              if(!var28) {
                                 break label66;
                              }
                           }
                        }

                        switch(var1) {
                        case 0:
                           var22 = this.O / var20;
                           if(!var28) {
                              break;
                           }
                        case 1:
                           var22 = this.O / (var20 * Math.sqrt(var20));
                           if(!var28) {
                              break;
                           }
                        case 2:
                           var22 = this.O / (var20 * var20);
                           if(!var28) {
                              break;
                           }
                        default:
                           var22 = this.O / Math.pow(var20, (double)(var1 + 2) * 0.5D);
                        }
                     }

                     var4 += var13 * var22;
                     var6 += var15 * var22;
                     var8 += var17 * var22;
                  }
               }
            }

            --var11;
            if(!var28) {
               continue;
            }
         }

         var3.a += var4;
         var3.b += var6;
         var3.c += var8;
         break;
      }

   }

   private void d(g var1, h var2) {
      double var3 = this.y.c / (double)this.G.length - var1.j;
      var2.c += var3 * (double)this.G.length / this.x;
   }

   private void e(g var1, h var2) {
      if(this.L != 0.0D) {
         double var3 = this.y.a / (double)this.G.length - var1.h;
         double var5 = this.y.b / (double)this.G.length - var1.i;
         double var7 = this.y.c / (double)this.G.length - var1.j;
         var2.a += var3 * this.L;
         var2.b += var5 * this.L;
         var2.c += var7 * this.L;
      }

   }

   private void f(g var1, h var2) {
      double var3 = 1.0E-4D * (var1.g + 2.0D);
      if(var3 > 0.0D) {
         var2.a = this.H.a(-var3, var3);
         var2.b = this.H.a(-var3, var3);
         var2.c = this.H.a(-var3, var3);
      }

   }

   private void a(g var1) {
      if(var1.r != 0.0D) {
         double var2 = Math.min(var1.q, var1.r);
         if(var2 > 0.0D) {
            if(var1.k < var2 - 10.0D) {
               var1.k = (9.0D * var1.k + var2) / 10.0D;
               if(!i.b) {
                  return;
               }
            }

            if(var1.k > var2 + 10.0D) {
               var1.k = (3.0D * var1.k + var2) / 4.0D;
            }
         }

      }
   }

   private void b(g var1) {
      boolean var16 = i.b;
      g var2 = var1.p;
      if(var2 != null && var2.o == 1) {
         D var3 = var2.s;
         double var4 = this.v + 1.0D;
         y.c.p var6 = var3.k();

         while(var6 != null) {
            g var7 = this.E[((y.c.q)var6.c()).d()];
            double var8 = var2.h - var7.h;
            double var10 = var2.i - var7.i;
            double var12 = var2.j - var7.j;
            double var14 = Math.sqrt(var8 * var8 + var10 * var10 + var12 * var12) + var7.k;
            if(var16) {
               return;
            }

            if(var14 > var4) {
               var4 = var14;
            }

            var6 = var6.a();
            if(var16) {
               break;
            }
         }

         var2.q = var4;
      }

   }

   void a(g var1, h var2, double var3) {
      boolean var7 = i.b;
      if(var3 != 0.0D && var1.e != 0.0D) {
         double var5;
         label30: {
            var5 = (var2.a * var1.b + var2.b * var1.c + var2.c * var1.d) / (var3 * var1.e);
            this.x -= var1.g * var1.g;
            this.w -= var1.g;
            if(var1.l * var5 > 0.0D) {
               var1.g += var5 * 0.45D;
               if(!var7) {
                  break label30;
               }
            }

            var1.g += var5 * 0.15D;
         }

         label25: {
            if(var1.g > this.z) {
               var1.g = this.z;
               if(!var7) {
                  break label25;
               }
            }

            if(var1.g < 0.1D) {
               var1.g = 0.1D;
            }
         }

         if(this.r == 1 && !var1.m) {
            var1.g *= 1.0D - 0.066D * (double)(var1.n + 1);
         }

         this.w += var1.g;
         this.x += var1.g * var1.g;
         var1.l = var5;
      }

   }

   void b(g var1, h var2, double var3) {
      if(var3 > 0.0D) {
         double var5 = var1.g / var3;
         double var7 = var2.a * var5;
         var1.h += var7;
         this.y.a += var7;
         double var9 = var2.b * var5;
         var1.i += var9;
         this.y.b += var9;
         double var11 = var2.c * var5;
         var1.j += var11;
         this.y.c += var11;
         var1.e = var3;
         var1.b = var2.a;
         var1.c = var2.b;
         var1.d = var2.c;
      }

   }

   private void u() {
      g[] var10000;
      g var2;
      boolean var4;
      label37: {
         var4 = i.b;
         if(this.W != null) {
            y.c.p var1 = this.W.c(this.W.b()).k();

            while(var1 != null) {
               var10000 = this.E;
               if(var4) {
                  break label37;
               }

               var2 = var10000[((y.c.q)var1.c()).d()];
               g var3 = var2.p;
               if(var3 != null && var3.o == 3) {
                  var2.h += var3.h;
                  var2.i += var3.i;
                  var2.j += var3.j;
               }

               var1 = var1.a();
               if(var4) {
                  break;
               }
            }
         }

         var10000 = this.E;
      }

      int var5 = var10000.length - 1;

      while(var5 >= 0) {
         var2 = this.E[var5];
         this.D.a(var2.a, var2.h, var2.i);
         --var5;
         if(var4) {
            break;
         }
      }

   }

   private static int e(int var0) {
      return var0 * var0;
   }

   private static double e(double var0) {
      return var0 * var0;
   }

   private double a(y.c.d var1) {
      double var2 = this.v;
      y.c.c var4 = this.D.c(p);
      if(var4 != null && var4.a(var1) > 0) {
         var2 = (double)var4.a(var1);
      }

      if(this.r == 1) {
         y.c.c var5 = this.D.c(n);
         if(!var5.d(var1.c()) && !var5.d(var1.d())) {
            double var6 = this.D.j(var1.c()) - this.D.j(var1.d());
            double var8 = this.D.k(var1.c()) - this.D.k(var1.d());
            var2 = Math.sqrt(var6 * var6 + var8 * var8) * 0.95D + 1.0D;
            if(this.B) {
               var2 -= this.E[var1.c().d()].k + this.E[var1.d().d()].k;
               var2 = Math.max(1.0D, var2);
            }
         }
      }

      return var2;
   }
}
