package y.f.e;

import java.util.Arrays;
import y.f.X;
import y.f.ae;
import y.f.e.b;
import y.f.e.c;
import y.f.e.i;
import y.g.ar;

public class a extends y.f.c {
   private int n;
   private double[] o;
   private double[] p;
   private double[] q;
   private double[] r;
   private double[] s;
   private double[] t;
   private double[] u;
   private double[] v;
   private double[] w;
   private double[] x;
   private int y = 40;
   private double z;
   private int A;
   private int B;
   private int C;
   private int D;
   private int E;
   private int[] F;
   private y.c.q[] G;
   private c H;
   private int[] I;
   private y.c.q[] J;
   private int[] K;
   private X L;
   private y.c.q[] M;
   private double N;
   private int[] O;
   private b[][] P;
   private ar Q;
   private double R;
   private double S;
   private double T;
   private int[] U;
   private int[] V;
   private double[][] W;
   private int[] X;
   private double[] Y;
   private double[] Z;
   private y.g.c aa;
   private int ab;
   private boolean ac;
   private boolean ad;
   private boolean ae;

   public a() {
      this.z = (double)(this.y * this.y);
      this.A = 15;
      this.B = 3;
      this.C = 10;
      this.D = 25;
      this.R = 2.0D;
      this.W = new double[6][6];
      this.X = new int[3];
      this.Y = new double[6];
      this.Z = new double[6];
      this.ac = true;
      this.ad = false;
   }

   public boolean b(X var1) {
      return var1 != null;
   }

   public void a(int var1) {
      this.C = var1;
   }

   public void b(int var1) {
      this.D = var1;
   }

   public void c(int var1) {
      this.y = var1;
   }

   public void d(int var1) {
      this.A = var1;
   }

   public void a(X var1) {
      boolean var13 = i.b;
      if(var1 != null && var1.e() >= 2) {
         y.c.q var3;
         if(var1.e() == 2) {
            ae.a(var1, true);
            y.c.x var15 = var1.o();
            var3 = var15.e();
            var1.a(var3, 0.0D, 0.0D);
            var15.g();
            if(this.ae) {
               var1.a(var15.e(), 0.0D, (double)this.y + var1.q(var15.e()) / 2.0D + var1.q(var3) / 2.0D);
               if(!var13) {
                  return;
               }
            }

            var1.a(var15.e(), 0.0D, (double)this.y);
         } else {
            this.M = var1.m();
            int var2;
            if(this.ae) {
               this.N = 0.0D;
               var2 = this.M.length - 1;

               label180: {
                  while(var2 >= 0) {
                     var3 = this.M[var2];
                     this.N += (var1.p(var3) + var1.q(var3)) / 4.0D;
                     --var2;
                     if(var13) {
                        break label180;
                     }

                     if(var13) {
                        break;
                     }
                  }

                  this.N /= (double)this.M.length;
               }

               this.y = (int)((double)this.y + 2.0D * this.N);
            }

            this.d(var1);
            var2 = this.E - 1;
            this.n();
            int var14 = this.C - 1;

            while(true) {
               if(var14 > 0) {
                  this.a(var2, false);
                  --var14;
                  if(var13) {
                     break;
                  }

                  if(!var13) {
                     continue;
                  }
               }

               var2 = this.E - 2;
               break;
            }

            int var10000;
            while(true) {
               if(var2 >= 0) {
                  var14 = this.F[var2];
                  var10000 = var2;
                  if(var13) {
                     break;
                  }

                  double var4;
                  label156: {
                     if(var2 > 0) {
                        var4 = (double)(this.A * (1 << (var2 - 1) * 2) * (1 + this.y / 80));
                        if(!var13) {
                           break label156;
                        }
                     }

                     var4 = (double)((float)this.A * 0.5F * (float)(1 + this.y / 80));
                  }

                  int var6 = var14 - 1;

                  label123: {
                     while(var6 >= 0) {
                        this.o[this.G[var6].d()] = var4;
                        --var6;
                        if(var13) {
                           break label123;
                        }

                        if(var13) {
                           break;
                        }
                     }

                     var6 = this.F[var2 + 1];
                  }

                  label150: {
                     label149:
                     do {
                        var10000 = var6;

                        label146:
                        while(true) {
                           if(var10000 >= var14) {
                              break label149;
                           }

                           y.c.q var7 = this.G[var6];
                           int var8 = var7.d();
                           this.b(var7);
                           int var9 = this.J[0].d();
                           int var10 = this.J[1].d();
                           int var11 = this.J[2].d();
                           var10000 = this.ac;
                           if(var13) {
                              break label150;
                           }

                           label134: {
                              if(var10000 != 0) {
                                 this.a(0, 1, 0);
                                 this.a(0, 2, 2);
                                 this.a(1, 2, 4);
                                 this.e(var8);
                                 if(!var13) {
                                    break label134;
                                 }
                              }

                              this.w[var8] = (this.w[var9] + this.w[var10] + this.w[var11]) / 3.0D;
                              this.x[var8] = (this.x[var9] + this.x[var10] + this.x[var11]) / 3.0D;
                           }

                           int var12 = 2;

                           while(true) {
                              if(var12 <= 0) {
                                 break label146;
                              }

                              this.a((y.c.q)var7, 3);
                              this.a(var7);
                              this.t[var8] = this.r[var8];
                              this.u[var8] = this.s[var8];
                              this.p[var8] = this.q[var8];
                              this.r[var8] *= this.o[var8];
                              this.s[var8] *= this.o[var8];
                              double var16;
                              var10000 = (var16 = this.q[var8] - 0.0D) == 0.0D?0:(var16 < 0.0D?-1:1);
                              if(var13) {
                                 break;
                              }

                              if(var10000 != 0) {
                                 this.r[var8] /= this.q[var8];
                                 this.s[var8] /= this.q[var8];
                              }

                              this.w[var8] += this.r[var8];
                              this.x[var8] += this.s[var8];
                              --var12;
                              if(var13) {
                                 break label146;
                              }
                           }
                        }

                        ++var6;
                     } while(!var13);

                     var10000 = var2;
                  }

                  label113: {
                     label198: {
                        if(var10000 < 1) {
                           var6 = this.D - 1;

                           do {
                              if(var6 <= 0) {
                                 break label198;
                              }

                              this.a(var2, true);
                              --var6;
                              if(var13) {
                                 break label113;
                              }
                           } while(!var13);
                        }

                        var6 = (this.C - 1) * (1 + var2 * var2);

                        while(var6 > 0) {
                           this.a(var2, false);
                           --var6;
                           if(var13) {
                              break label113;
                           }

                           if(var13) {
                              break;
                           }
                        }
                     }

                     --var2;
                  }

                  if(!var13) {
                     continue;
                  }
               }

               var10000 = this.ae;
               break;
            }

            if(var10000 != 0) {
               this.y = (int)((double)this.y - 2.0D * this.N);
            }

            var14 = this.n - 1;

            while(true) {
               if(var14 >= 0) {
                  var1.a(this.M[var14], this.w[var14], this.x[var14]);
                  --var14;
                  if(var13) {
                     break;
                  }

                  if(!var13) {
                     continue;
                  }
               }

               this.a();
               break;
            }

         }
      } else {
         if(var1 != null) {
            ae.a(var1, true);
         }

      }
   }

   private void a() {
      this.M = null;
      this.aa = null;
      this.U = null;
      this.V = null;
      this.r = null;
      this.s = null;
      this.o = null;
      this.p = null;
      this.q = null;
      this.t = null;
      this.u = null;
      this.v = null;
      this.w = null;
      this.x = null;
      this.O = null;
      this.P = (b[][])null;
      this.J = null;
      this.K = null;
      this.F = null;
      this.G = null;
      this.I = null;
   }

   private void e(int var1) {
      boolean var13 = i.b;
      double var2 = 0.0D;
      double var4 = 0.0D;
      int var6 = 0;

      while(var6 < 6) {
         int var7 = var6 + 1;

         while(true) {
            if(var7 < 6) {
               this.W[var6][var7] = this.W[var7][var6] = Math.sqrt((this.Y[var6] - this.Y[var7]) * (this.Y[var6] - this.Y[var7]) + (this.Z[var6] - this.Z[var7]) * (this.Z[var6] - this.Z[var7]));
               ++var7;
               if(var13) {
                  break;
               }

               if(!var13) {
                  continue;
               }
            }

            ++var6;
            break;
         }

         if(var13) {
            break;
         }
      }

      double var14 = Double.MAX_VALUE;
      int var8 = 0;

      label57:
      do {
         int var10000 = var8;

         label54:
         while(true) {
            if(var10000 >= 6) {
               break label57;
            }

            int var9 = var8 + 1;

            while(true) {
               var10000 = var9;

               label49:
               while(true) {
                  if(var10000 >= 6) {
                     break label54;
                  }

                  var10000 = var9 + 1;
                  if(var13) {
                     continue label54;
                  }

                  int var10 = var10000;

                  while(true) {
                     if(var10 >= 6) {
                        break label49;
                     }

                     double var11 = this.W[var8][var9] + this.W[var8][var10] + this.W[var9][var10];
                     double var15;
                     var10000 = (var15 = var11 - var14) == 0.0D?0:(var15 < 0.0D?-1:1);
                     if(var13) {
                        break;
                     }

                     if(var10000 < 0) {
                        var14 = var11;
                        this.X[0] = var8;
                        this.X[1] = var9;
                        this.X[2] = var10;
                     }

                     ++var10;
                     if(var13) {
                        break label49;
                     }
                  }
               }

               ++var9;
               if(var13) {
                  break label54;
               }
            }
         }

         ++var8;
      } while(!var13);

      this.w[var1] = (this.Y[this.X[0]] + this.Y[this.X[1]] + this.Y[this.X[2]]) / 3.0D;
      this.x[var1] = (this.Z[this.X[0]] + this.Z[this.X[1]] + this.Z[this.X[2]]) / 3.0D;
   }

   private void a(int var1, int var2, int var3) {
      boolean var22 = i.b;
      int var4 = this.J[var1].d();
      int var5 = this.J[var2].d();
      double var6 = this.w[var5] - this.w[var4];
      double var8 = this.x[var5] - this.x[var4];
      double var10 = (double)((float)(this.K[var1] * this.y) * 0.5F);
      double var12 = (double)((float)(this.K[var2] * this.y) * 0.5F);
      double var14 = Math.sqrt(var6 * var6 + var8 * var8);
      if(var14 > 0.0D) {
         double var16 = (var12 * var12 - var10 * var10 - var14 * var14) / (-2.0D * var14);
         double var18 = var10 * var10 - var16 * var16;
         double var20;
         if(var18 > 0.0D) {
            var20 = Math.sqrt(var18);
            this.Y[var3] = this.w[var4] + (var6 * var16 + var8 * var20) / var14;
            this.Z[var3] = this.x[var4] + (var8 * var16 - var6 * var20) / var14;
            ++var3;
            this.Y[var3] = this.w[var4] + (var6 * var16 - var8 * var20) / var14;
            this.Z[var3] = this.x[var4] + (var8 * var16 + var6 * var20) / var14;
            if(!var22) {
               return;
            }
         }

         label32: {
            if(var10 > var12 + var14) {
               var20 = (var10 + var12 + var14) / (2.0D * var14);
               if(!var22) {
                  break label32;
               }
            }

            if(var12 > var10 + var14) {
               var20 = (-var10 + (var14 - var12)) / (2.0D * var14);
               if(!var22) {
                  break label32;
               }
            }

            var20 = (var10 + (var14 - var12)) / (2.0D * var14);
         }

         this.Y[var3] = this.Y[1 + var3] = this.w[var4] + var6 * var20;
         this.Z[var3] = this.Z[1 + var3] = this.x[var4] + var8 * var20;
         if(!var22) {
            return;
         }
      }

      this.Y[var3] = this.Y[1 + var3] = this.w[var4];
      this.Z[var3] = this.Z[1 + var3] = this.x[var4];
   }

   private void a(int var1, boolean var2) {
      boolean var6 = i.b;
      int var3 = this.F[var1];
      int var4 = 0;

      byte var10000;
      int var5;
      while(true) {
         if(var4 < var3) {
            var10000 = var2;
            if(var6) {
               break;
            }

            label33: {
               if(var2 != 0) {
                  this.c(this.G[var4], var1);
                  if(!var6) {
                     break label33;
                  }
               }

               this.b(this.G[var4], var1);
            }

            this.a(this.G[var4]);
            var5 = this.G[var4].d();
            this.t[var5] = this.r[var5];
            this.u[var5] = this.s[var5];
            this.p[var5] = this.q[var5];
            this.r[var5] *= this.o[var5];
            this.s[var5] *= this.o[var5];
            if(this.q[var5] != 0.0D) {
               this.r[var5] /= this.q[var5];
               this.s[var5] /= this.q[var5];
            }

            ++var4;
            if(!var6) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var4 = var10000;

      while(var4 < var3) {
         var5 = this.G[var4].d();
         this.w[var5] += this.r[var5];
         this.x[var5] += this.s[var5];
         ++var4;
         if(var6) {
            break;
         }
      }

   }

   private void n() {
      boolean var11 = i.b;
      int var1 = this.E - 1;
      int var2 = this.F[var1];
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = (double)((1 << this.E) * (this.y / 4));
      int var9 = 0;

      while(true) {
         if(var9 < this.B) {
            y.c.q var10 = this.G[var9];
            this.w[var10.d()] = Math.sin((double)var9 * 3.141592653589793D * 2.0D / (double)this.B) * var7;
            this.x[var10.d()] = Math.cos((double)var9 * 3.141592653589793D * 2.0D / (double)this.B) * var7;
            this.b(var10);
            ++var9;
            if(var11) {
               break;
            }

            if(!var11) {
               continue;
            }
         }

         var9 = 0;
         break;
      }

      while(true) {
         if(var9 < var2) {
            var3 += this.w[this.G[var9].d()];
            var5 += this.x[this.G[var9].d()];
            ++var9;
            if(var11) {
               break;
            }

            if(!var11) {
               continue;
            }
         }

         var3 /= (double)var2;
         var5 /= (double)var2;
         break;
      }

      var9 = 0;

      while(var9 < var2) {
         this.w[this.G[var9].d()] -= var3;
         this.x[this.G[var9].d()] -= var5;
         ++var9;
         if(var11) {
            break;
         }
      }

   }

   private void d(X var1) {
      boolean var3;
      label21: {
         var3 = i.b;
         this.L = var1;
         if(this.ad) {
            this.Q = new ar(42L);
            if(!var3) {
               break label21;
            }
         }

         this.Q = new ar();
      }

      ae.a(var1, true);
      this.n = var1.f();
      this.ab = 0;
      this.aa = new y.g.c(this.n + 1);
      this.U = new int[this.n];
      this.V = new int[this.n];
      this.J = new y.c.q[3];
      this.K = new int[3];
      this.z = (double)(this.y * this.y);
      this.S = this.z * (double)this.y / (2.0D * this.R);
      this.T = 1.0D / (2.0D * this.R * (double)this.y);
      this.B = Math.min(this.n, this.B);
      this.H = a(var1, this.B);
      this.E = this.H.a;
      this.F = this.H.b;
      this.G = this.H.c;
      this.I = this.H.d;
      this.o = new double[this.n];
      this.p = new double[this.n];
      this.q = new double[this.n];
      this.r = new double[this.n];
      this.s = new double[this.n];
      this.t = new double[this.n];
      this.u = new double[this.n];
      this.v = new double[this.n];
      this.w = new double[this.n];
      this.x = new double[this.n];
      this.o();
      this.P = new b[this.n][this.E];
      int var2 = 0;

      while(var2 < this.n) {
         this.o[var2] = (double)this.A;
         this.v[var2] = 1.0D;
         this.t[var2] = 0.0D;
         this.u[var2] = 0.0D;
         this.r[var2] = 0.0D;
         this.s[var2] = 0.0D;
         this.w[var2] = var1.j(this.M[var2]);
         this.x[var2] = var1.k(this.M[var2]);
         ++var2;
         if(var3) {
            break;
         }
      }

   }

   private void a(y.c.q var1, int var2) {
      boolean var25 = i.b;
      int var3 = var1.d();
      double var4 = this.w[var3];
      double var6 = this.x[var3];
      double var8 = 0.0D;
      double var10 = 0.0D;
      int var12 = var2 - 1;

      while(true) {
         if(var12 >= 0) {
            int var13;
            double var14 = this.w[var13 = this.J[var12].d()] - var4;
            double var16 = this.x[var13] - var6;
            double var18 = var14 * var14 + var16 * var16;
            if(var25) {
               break;
            }

            if(var18 > 0.0D) {
               int var20 = this.K[var12];
               double var21 = (double)(var20 * var20);
               double var23 = (var18 / (var21 * this.z) - 1.0D) / (Math.sqrt(var18) * (double)var20);
               var8 += var23 * var14;
               var10 += var23 * var16;
            }

            --var12;
            if(!var25) {
               continue;
            }
         }

         this.r[var3] = var8;
         this.s[var3] = var10;
         this.q[var3] = Math.sqrt(var8 * var8 + var10 * var10);
         break;
      }

   }

   private void b(y.c.q var1, int var2) {
      boolean var23 = i.b;
      int var3 = var1.d();
      y.c.q[] var4 = this.P[var3][var2].a;
      int[] var5 = this.P[var3][var2].b;
      double var6 = 0.0D;
      double var8 = 0.0D;
      int var10 = this.O[var2] - 1;

      while(true) {
         if(var10 >= 0) {
            int var11 = var4[var10].d();
            int var12 = var5[var10];
            if(var23) {
               break;
            }

            if(var12 != 0) {
               double var13 = this.w[var11] - this.w[var3];
               double var15 = this.x[var11] - this.x[var3];
               double var17 = var13 * var13 + var15 * var15;
               if(var17 == 0.0D) {
                  var13 = this.Q.a(-0.5D, 0.5D);
                  var15 = this.Q.a(-0.5D, 0.5D);
                  var17 = 0.01D;
               }

               double var19 = (double)(var12 * var12);
               double var21 = (var17 / (var19 * this.z) - 1.0D) / (Math.sqrt(var17) * (double)var12);
               var6 += var13 * var21;
               var8 += var15 * var21;
            }

            --var10;
            if(!var23) {
               continue;
            }
         }

         this.r[var3] = var6;
         this.s[var3] = var8;
         this.q[var3] = Math.sqrt(var6 * var6 + var8 * var8);
         break;
      }

   }

   private void c(y.c.q var1, int var2) {
      boolean var19 = i.b;
      int var3 = var1.d();
      y.c.q[] var4 = this.P[var3][var2].a;
      double var7 = 0.0D;
      double var5 = 0.0D;
      y.c.d var9 = var1.g();

      int var10;
      double var11;
      double var13;
      double var15;
      double var17;
      while(true) {
         if(var9 != null) {
            var11 = this.w[var10 = var9.c().d()] - this.w[var3];
            var13 = this.x[var10] - this.x[var3];
            var15 = var11 * var11 + var13 * var13;
            var17 = Math.sqrt(var15) * this.T;
            var5 += var11 * var17;
            var7 += var13 * var17;
            var9 = var9.h();
            if(var19) {
               break;
            }

            if(!var19) {
               continue;
            }
         }

         var9 = var1.f();
         break;
      }

      a var10000;
      while(true) {
         if(var9 != null) {
            var11 = this.w[var10 = var9.d().d()] - this.w[var3];
            var10000 = this;
            if(var19) {
               break;
            }

            var13 = this.x[var10] - this.x[var3];
            var15 = var11 * var11 + var13 * var13;
            var17 = Math.sqrt(var15) * this.T;
            var5 += var11 * var17;
            var7 += var13 * var17;
            var9 = var9.g();
            if(!var19) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      int var20 = var10000.O[var2] - 1;

      while(true) {
         if(var20 >= 0) {
            var11 = this.w[var3] - this.w[var10 = var4[var20].d()];
            var13 = this.x[var3] - this.x[var10];
            var15 = var11 * var11 + var13 * var13;
            if(var19) {
               break;
            }

            if(var15 == 0.0D) {
               var11 = this.Q.a(-0.5D, 0.5D);
               var13 = this.Q.a(-0.5D, 0.5D);
               var15 = 0.01D;
            }

            var17 = this.S / (var15 * Math.sqrt(var15));
            var5 += var11 * var17;
            var7 += var13 * var17;
            --var20;
            if(!var19) {
               continue;
            }
         }

         this.r[var3] = var5;
         this.s[var3] = var7;
         this.q[var3] = Math.sqrt(var5 * var5 + var7 * var7);
         break;
      }

   }

   private void a(y.c.q var1) {
      int var2 = var1.d();
      double var3 = this.o[var2];
      double var5 = this.p[var2];
      double var7 = this.q[var2];
      if(var7 != 0.0D && var5 != 0.0D) {
         double var11;
         label14: {
            double var9 = this.r[var2] * this.t[var2] + this.s[var2] * this.u[var2];
            var11 = var9 / (var7 * var5);
            if(this.v[var2] * var11 > 0.0D) {
               var3 += var11 * 0.45D;
               if(!i.b) {
                  break label14;
               }
            }

            var3 += var11 * 0.15D;
         }

         this.v[var2] = var11;
         this.o[var2] = var3;
      }

   }

   private void o() {
      boolean var8 = i.b;
      double var1 = 10000.0D;
      int var3 = 0;
      double var5 = (double)(this.L.g() * 2);
      if(var5 < var1) {
         var5 = var1;
      }

      int var7 = 0;

      int var10000;
      while(true) {
         if(var7 < this.E) {
            label48: {
               double var9;
               var10000 = (var9 = (double)this.F[var7] * (double)this.F[var7] - var1 - 0.0D) == 0.0D?0:(var9 < 0.0D?-1:1);
               if(var8) {
                  break;
               }

               if(var10000 <= 0) {
                  var3 = var7;
                  if(!var8) {
                     break label48;
                  }
               }

               ++var7;
               if(!var8) {
                  continue;
               }
            }
         }

         this.O = new int[this.E];
         var10000 = 0;
         break;
      }

      var7 = var10000;

      while(var7 < this.E) {
         label28: {
            if(var7 >= var3) {
               this.O[var7] = Math.max(this.F[var7] - 1, this.B - 1);
               if(!var8) {
                  break label28;
               }
            }

            this.O[var7] = Math.max(this.B - 1, Math.min((int)(a(var7, 0, 2, 10000, 1) * var5 / (double)this.F[var7]), this.F[var7] - 1));
         }

         ++var7;
         if(var8) {
            break;
         }
      }

      this.O[0] = Math.min(2 * this.O[0], this.n - 1);
   }

   private static final double a(int var0, int var1, int var2, int var3, int var4) {
      return var0 <= var1?(double)var2:(var1 <= var0 && var0 <= var3?(double)(var4 - var2) / (double)(var3 - var1) * (double)(var0 - var1) + (double)var2:(double)var4);
   }

   private void b(y.c.q var1) {
      boolean var18 = i.b;
      int var2 = ++this.ab;
      int var3 = var1.d();
      this.aa.c();
      boolean var5 = false;
      int var6 = 0;
      byte var7 = 3;
      int var8 = 0;
      int[] var9 = new int[this.I[var3] + 1];
      int var10 = this.I[var3];

      while(var10 >= 0) {
         this.P[var3][var10] = new b();
         this.P[var3][var10].a = new y.c.q[this.O[var10]];
         this.P[var3][var10].b = new int[this.O[var10]];
         --var10;
         if(var18) {
            break;
         }
      }

      int var11 = 1;
      y.c.q var12 = var1;

      label148:
      while(true) {
         this.U[var12.d()] = var2;
         boolean var13 = true;
         y.c.d var14 = var12.g();
         if(var14 == null) {
            var14 = var12.f();
            var13 = false;
         }

         label146:
         while(true) {
            boolean var10000;
            if(var14 != null) {
               var10000 = var13;
               if(!var18) {
                  y.c.q var15 = var13?var14.c():var14.d();
                  int var16 = var15.d();
                  if(this.U[var16] != var2) {
                     this.U[var16] = var2;
                     this.aa.b(var15);
                     this.V[var16] = var11;
                     int var17 = Math.min(this.I[var16], this.I[var3]);
                     var10 = var8;

                     while(true) {
                        if(var10 <= var17) {
                           int var19 = var9[var10];
                           int var10001 = this.O[var10];
                           if(var18) {
                              var11 = var19 + var10001;
                              if(var5) {
                                 if(var8 <= this.I[var3] && this.aa.d() >= 0) {
                                    continue label148;
                                 }
                              } else if(this.aa.d() >= 0) {
                                 continue label148;
                              }

                              if(!var18) {
                                 return;
                              }

                              var10000 = this.aa.e();
                              break;
                           }

                           if(var19 < var10001) {
                              this.P[var3][var10].a[var9[var10]] = var15;
                              this.P[var3][var10].b[var9[var10]++] = var11;
                              if(var18 && var10 == var8) {
                                 ++var8;
                              }
                           } else if(var10 == var8) {
                              ++var8;
                           }

                           ++var10;
                           if(!var18) {
                              continue;
                           }
                        }

                        if(!var5 && var6 < var7 && this.I[var16] > this.I[var3]) {
                           this.K[var6] = var11;
                           this.J[var6++] = var15;
                           if(var6 == var7) {
                              var5 = true;
                           }
                        }

                        if(var13) {
                           var14 = var14.h();
                           if(var14 != null) {
                              continue label146;
                           }

                           var13 = false;
                           var14 = var12.f();
                           if(!var18) {
                              continue label146;
                           }
                        }

                        var14 = var14.g();
                        if(!var18) {
                           continue label146;
                        }

                        var10000 = this.aa.e();
                        break;
                     }
                  } else {
                     if(var13) {
                        var14 = var14.h();
                        if(var14 != null) {
                           continue;
                        }

                        var13 = false;
                        var14 = var12.f();
                        if(!var18) {
                           continue;
                        }
                     }

                     var14 = var14.g();
                     if(!var18) {
                        continue;
                     }

                     var10000 = this.aa.e();
                  }
               }
            } else {
               var10000 = this.aa.e();
            }

            while(true) {
               while(var10000) {
                  if(!var18) {
                     return;
                  }

                  var10000 = this.aa.e();
               }

               var12 = (y.c.q)this.aa.a();
               var11 = this.V[var12.d()] + 1;
               if(var5) {
                  if(var8 <= this.I[var3] && this.aa.d() >= 0) {
                     continue label148;
                  }
               } else if(this.aa.d() >= 0) {
                  continue label148;
               }

               if(!var18) {
                  return;
               }

               var10000 = this.aa.e();
            }
         }
      }
   }

   public void g(boolean var1) {
      this.ac = var1;
   }

   public void h(boolean var1) {
      this.ad = var1;
   }

   public void i(boolean var1) {
      this.ae = var1;
   }

   static int[] a(X var0, y.c.q[] var1, int var2, int var3) {
      boolean var15 = i.b;
      int var4 = 1 << var3;
      int var6 = 0;
      int[] var7 = new int[var2 + 1];
      boolean var8 = false;
      Arrays.fill(var7, -1);
      y.g.c var10 = new y.g.c(var0.e());
      y.g.c var11 = new y.g.c(var0.e() + var4 + 1);
      int[] var12 = new int[var0.e()];
      int var13 = 0;

      int[] var10000;
      while(true) {
         if(var13 < var1.length) {
            var10000 = var12;
            if(var15) {
               break;
            }

            var12[var1[var13].d()] = var13++;
            if(!var15) {
               continue;
            }
         }

         var10000 = new int[var0.e()];
         break;
      }

      int[] var16 = var10000;
      int var5 = 0;

      int var10001;
      while(true) {
         if(var5 < var2) {
            var10000 = var7;
            var10001 = var5 + 1;
            if(var15) {
               break;
            }

            label36: {
               if(var7[var10001] == -1) {
                  a(var0, var1[var5], var4, var5 + 1, var11, var16, var10);
                  ++var6;
                  var7[var5 + 1] = 1;
                  var10.a();

                  while(!var10.e()) {
                     int var14 = var12[((y.c.q)var10.a()).d()];
                     if(var14 < var2) {
                        var7[var14 + 1] = 0;
                        if(var15) {
                           break label36;
                        }

                        if(var15) {
                           break;
                        }
                     }
                  }
               }

               ++var5;
            }

            if(!var15) {
               continue;
            }
         }

         var10000 = var7;
         var10001 = 0;
         break;
      }

      var10000[var10001] = var6;
      return var7;
   }

   static void a(X var0, y.c.q var1, int var2, int var3, y.g.c var4, int[] var5, y.g.c var6) {
      boolean var10 = i.b;
      var4.c();
      var4.a(var1);
      var4.a((Object)null);

      label128:
      while(!var4.e()) {
         var1 = (y.c.q)var4.a();
         if(var1 == null) {
            --var2;
            if(var2 == 0 || var4.e()) {
               break;
            }

            if(!var4.e()) {
               var4.a((Object)null);
               var1 = (y.c.q)var4.a();
               if(var1 == null) {
                  break;
               }
            }
         }

         var6.a(var1);
         var5[var1.d()] = var3;
         y.c.d var7 = var1.f();

         label126:
         while(true) {
            int var10000;
            y.c.q var8;
            int var9;
            if(var7 != null) {
               var8 = var7.d();
               var9 = var8.d();
               var10000 = var5[var9];
               if(!var10) {
                  if(var10000 != var3 && var5[var9] != -var3) {
                     var4.a(var8);
                     var5[var9] = -var3;
                  }

                  var7 = var7.g();
                  if(!var10) {
                     continue;
                  }

                  var7 = var1.g();
                  if(var7 == null) {
                     break;
                  }
               } else {
                  if(var10000 != var3 && var5[var9] != -var3) {
                     var4.a(var8);
                     var5[var9] = -var3;
                  }

                  var7 = var7.h();
                  if(var10) {
                     return;
                  }

                  if(var7 == null) {
                     break;
                  }
               }
            } else {
               var7 = var1.g();
               if(var7 == null) {
                  break;
               }
            }

            while(true) {
               while(true) {
                  var8 = var7.c();
                  var9 = var8.d();
                  var10000 = var5[var9];
                  if(!var10) {
                     if(var10000 != var3 && var5[var9] != -var3) {
                        var4.a(var8);
                        var5[var9] = -var3;
                     }

                     var7 = var7.h();
                     if(var10) {
                        return;
                     }

                     if(var7 == null) {
                        continue label128;
                     }
                  } else if(!var10) {
                     if(var10000 != var3 && var5[var9] != -var3) {
                        var4.a(var8);
                        var5[var9] = -var3;
                     }

                     var7 = var7.g();
                     if(!var10) {
                        continue label126;
                     }

                     var7 = var1.g();
                     if(var7 == null) {
                        continue label128;
                     }
                  } else {
                     if(var10000 != var3 && var5[var9] != -var3) {
                        var4.a(var8);
                        var5[var9] = -var3;
                     }

                     var7 = var7.h();
                     if(var10) {
                        return;
                     }

                     if(var7 == null) {
                        continue label128;
                     }
                  }
               }
            }
         }
      }

   }

   private static final c a(X var0, int var1) {
      boolean var15 = i.b;
      int var2 = var0.f();
      int var3 = (int)(Math.log((double)var2) / Math.log(10.0D)) + 2;
      int[] var4 = new int[var3];
      int[] var5 = new int[var2];
      c var8 = new c();
      y.c.q[] var9 = y.a.w.a(var0);
      int var6 = 0;

      while(true) {
         if(var6 < var2) {
            var5[var6] = 0;
            ++var6;
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         var4[0] = var2;
         break;
      }

      int var7 = 1;

      int var10;
      int var10000;
      while(true) {
         if(var7 < var3) {
            int var12 = var4[var7 - 1];
            int[] var13 = a(var0, var9, var12, var7);
            var4[var7] = var13[0];
            var10 = 0;
            var10000 = 1;
            if(var15) {
               break;
            }

            int var11 = 1;

            int var10001;
            label76: {
               while(var11 <= var4[var7 - 1]) {
                  var10000 = var13[var11];
                  var10001 = 1;
                  if(var15) {
                     break label76;
                  }

                  if(var10000 == 1) {
                     var5[var9[var11 - 1].d()] = var7;
                     a(var9, var10++, var11 - 1);
                  }

                  ++var11;
                  if(var15) {
                     break;
                  }
               }

               var10000 = var4[var7];
               var10001 = var1 + 1;
            }

            if(var10000 < var10001) {
               int var14 = var4[var7];

               while(true) {
                  if(var14 < var1) {
                     var5[var9[var14].d()] = var7;
                     ++var14;
                     if(var15) {
                        break;
                     }

                     if(!var15) {
                        continue;
                     }
                  }

                  var4[var7] = var1;
                  break;
               }

               var3 = var7 + 1;
            }

            ++var7;
            if(!var15) {
               continue;
            }
         }

         var10000 = var4[var3 - 1];
         break;
      }

      if(var10000 > var1) {
         var10 = var1;

         while(var10 < var4[var3 - 1]) {
            var5[var9[var10].d()] = var3 - 2;
            ++var10;
            if(var15) {
               return var8;
            }

            if(var15) {
               break;
            }
         }

         var4[var3 - 1] = var1;
      }

      var8.a = var3;
      var8.b = var4;
      var8.c = var9;
      var8.d = var5;
      return var8;
   }

   private static void a(y.c.q[] var0, int var1, int var2) {
      y.c.q var3 = var0[var1];
      var0[var1] = var0[var2];
      var0[var2] = var3;
   }
}
