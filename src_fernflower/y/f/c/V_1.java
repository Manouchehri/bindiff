package y.f.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import y.f.c.W;
import y.f.c.X;
import y.f.c.a;
import y.f.c.aH;
import y.f.c.ad;

public class V extends a {
   private int[] o;
   private int[] p;
   private int[] q;
   private boolean[] r;
   private int[] s;
   private int[] t;
   private double[][] u;
   private double[] v;
   private int[] w;
   private boolean[] x;
   private double[] y;
   private double[] z;
   private double[] A;
   private double[] B;

   protected void a(y.c.y[] var1, y.c.c var2) {
      y.f.X var3 = this.g;
      this.a((y.f.X)var3, (y.c.y[])var1);
      this.a((y.c.i)var3, (y.c.y[])var1);
      a(var1, y.g.M.b(this.r), this.e, this.o);
      this.a((y.c.i)var3, (double[])this.u[0]);
      this.b(var3, var1);
      this.a(var3, this.u[0], var1);
      this.b(var1);
      this.a((y.c.i)var3, (double[])this.u[1]);
      this.b(var3, var1);
      this.a(var3, this.u[1], var1);
      this.b(var1);
      this.a(this.u[1]);
      this.c(var1);
      this.a((y.c.i)var3, (double[])this.u[2]);
      this.b(var3, var1);
      this.a(var3, this.u[2], var1);
      this.b(var1);
      this.a((y.c.i)var3, (double[])this.u[3]);
      this.b(var3, var1);
      this.a(var3, this.u[3], var1);
      this.b(var1);
      this.a(this.u[3]);
      this.c(var1);
      this.a(var3);
   }

   void a(double[] var1) {
      boolean var3 = a.i;
      int var2 = 0;

      while(var2 < var1.length) {
         var1[var2] = -var1[var2];
         ++var2;
         if(var3) {
            break;
         }
      }

   }

   void b(y.c.y[] var1) {
      boolean var12 = a.i;
      int var2 = 0;

      while(true) {
         if(var2 < var1.length) {
            y.c.y var3 = var1[var2];
            var3.n();
            ++var2;
            if(var12) {
               break;
            }

            if(!var12) {
               continue;
            }
         }

         var2 = 0;
         break;
      }

      V var10000;
      label85:
      while(true) {
         if(var2 < var1.length) {
            int var13 = 0;
            y.c.q var4 = null;
            y.c.x var5 = var1[var2].a();

            while(var5.f()) {
               y.c.q var6 = var5.e();
               int var7 = var6.d();
               this.o[var7] = var13++;
               var10000 = this;
               if(var12) {
                  break label85;
               }

               this.p[var7] = var4 != null?var4.d():-1;
               this.q[var7] = -1;
               if(var4 != null) {
                  this.q[var4.d()] = var7;
                  this.B[var4.d()] = this.B[var7];
               }

               int var8;
               y.c.d var9;
               y.c.d var10;
               y.c.d var11;
               label65: {
                  var4 = var6;
                  var8 = var6.b();
                  if(var8 > 1) {
                     var9 = var6.i();
                     var10 = var6.g();

                     while(var8 > 1) {
                        var11 = var10;
                        var10 = var10.h();
                        this.g.a(var11, var11.g(), var9, 1, 0);
                        --var8;
                        if(var12) {
                           break label65;
                        }

                        if(var12) {
                           break;
                        }
                     }
                  }

                  var8 = var6.c();
               }

               label77: {
                  if(var8 > 1) {
                     var9 = var6.h();
                     var10 = var6.f();

                     while(var8 > 1) {
                        var11 = var10;
                        var10 = var10.g();
                        this.g.a(var11, var9, var11.h(), 0, 1);
                        --var8;
                        if(var12) {
                           break label77;
                        }

                        if(var12) {
                           break;
                        }
                     }
                  }

                  var5.g();
               }

               if(var12) {
                  break;
               }
            }

            ++var2;
            if(!var12) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var14 = var10000.g.p();

      while(var14.f()) {
         y.c.d var15 = var14.a();
         y.d.t var16 = this.g.n(var15);
         this.g.a(var15, new y.d.t(-var16.a(), var16.b()));
         y.d.t var17 = this.g.o(var15);
         this.g.b(var15, new y.d.t(-var17.a(), var17.b()));
         var14.g();
         if(var12) {
            break;
         }
      }

   }

   void c(y.c.y[] var1) {
      boolean var6 = a.i;
      y.c.e var2 = this.g.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         this.g.c(var3);
         y.d.t var4 = this.g.n(var3);
         y.d.t var5 = this.g.o(var3);
         this.g.b(var3, var4);
         this.g.a(var3, var5);
         var2.g();
         if(var6) {
            break;
         }
      }

      y.c.D var7 = new y.c.D(var1);
      int var8 = 0;

      while(var8 < var1.length) {
         var1[var8] = (y.c.y)var7.j();
         ++var8;
         if(var6) {
            break;
         }
      }

      aH var9 = new aH(this.o, (byte)6);
      aH var10 = new aH(this.o, (byte)5);
      this.g.a((Comparator)var9, (Comparator)var10);
   }

   protected void a(y.c.i var1, y.c.y[] var2) {
      boolean var11 = a.i;
      int var3 = var1.f();
      int var4 = var1.h();
      this.o = new int[var3];
      this.p = new int[var3];
      this.q = new int[var3];
      this.s = new int[var3];
      this.t = new int[var3];
      this.w = new int[var3];
      this.A = new double[var3];
      this.B = new double[var3];
      this.u = new double[4][var3];
      this.v = new double[var3];
      this.y = new double[var3];
      this.z = new double[var3];
      this.x = new boolean[var3];
      this.r = new boolean[var4];
      int var5 = 0;

      while(var5 < var2.length) {
         int var6 = 0;
         y.c.q var7 = null;
         y.c.x var8 = var2[var5].a();

         while(true) {
            if(var8.f()) {
               y.c.q var9 = var8.e();
               int var10 = var9.d();
               this.o[var10] = var6++;
               if(var11) {
                  break;
               }

               this.p[var10] = var7 != null?var7.d():-1;
               this.q[var10] = -1;
               if(var7 != null) {
                  this.q[var7.d()] = var10;
                  this.B[var7.d()] = this.g(var7);
               }

               this.A[var10] = this.g.p(var9);
               var7 = var9;
               var8.g();
               if(!var11) {
                  continue;
               }
            }

            ++var5;
            break;
         }

         if(var11) {
            break;
         }
      }

      ad var12 = new ad(this.o, true);
      ad var13 = new ad(this.o, false);
      var1.a((Comparator)var12, (Comparator)var13);
   }

   protected void a(y.c.i var1, double[] var2) {
      boolean var6 = a.i;
      y.c.x var3 = var1.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         int var5 = var4.d();
         this.s[var5] = var5;
         this.t[var5] = var5;
         var2[var5] = Double.MAX_VALUE;
         this.w[var5] = var5;
         this.v[var5] = Double.MAX_VALUE;
         this.x[var5] = false;
         this.z[var5] = this.y[var5] = 0.0D;
         var3.g();
         if(var6) {
            break;
         }
      }

   }

   public static void a(y.c.y[] var0, y.c.h var1, y.c.A var2, int[] var3) {
      boolean var19 = a.i;
      int var4 = var0.length;
      int var5 = 2;

      do {
         int var10000 = var5;
         int var10001 = var4 - 1;

         label108:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            int var6 = -1;
            int var7 = 0;
            int var8 = 0;
            y.c.x var9 = var0[var5].a();
            y.c.x var10 = var0[var5].a();

            while(true) {
               if(!var10.f()) {
                  break label108;
               }

               y.c.q var11 = var10.e();
               y.c.q var12 = null;
               boolean var13 = false;
               var10000 = var11.b();
               var10001 = 1;
               if(var19) {
                  break;
               }

               label118: {
                  if(var10000 == 1) {
                     var12 = var11.g().c();
                     if(var2.b(var12) != null && var2.b(var11) != null) {
                        var13 = true;
                     }
                  }

                  int var14;
                  label101:
                  while(true) {
                     if(var8 != var0[var5].size() - 1 && !var13) {
                        break label118;
                     }

                     var14 = var13?var3[var12.d()]:var0[var5 - 1].size();
                     if(var7 > var8) {
                        break;
                     }

                     while(true) {
                        label96:
                        while(true) {
                           y.c.q var15 = var9.e();
                           y.c.e var20 = var15.k();
                           if(var19) {
                              if(var20 != null && var2.b(var11) != null) {
                                 var13 = true;
                              }
                              continue label101;
                           }

                           y.c.e var16 = var20;

                           while(var16.f()) {
                              y.c.d var17 = var16.a();
                              int var18 = var3[var17.c().d()];
                              if(var19) {
                                 if(var18 > var6) {
                                    break label101;
                                 }
                                 continue label96;
                              }

                              if(var18 >= var6) {
                                 if(var18 > var14) {
                                    var1.a(var16.a(), true);
                                 }
                              } else {
                                 var1.a(var16.a(), true);
                              }

                              var16.g();
                              if(var19) {
                                 break;
                              }
                           }

                           var9.g();
                           ++var7;
                           if(var19 || var7 > var8) {
                              break label101;
                           }
                        }
                     }
                  }

                  var6 = var14;
               }

               ++var8;
               var10.g();
               if(var19) {
                  break label108;
               }
            }
         }

         ++var5;
      } while(!var19);

   }

   public void b(y.f.X var1, y.c.y[] var2) {
      boolean var17 = a.i;
      int var3 = 1;

      do {
         int var10000 = var3;

         label68:
         while(true) {
            if(var10000 >= var2.length) {
               return;
            }

            int var4 = -1;
            y.c.p var5 = var2[var3].k();

            while(true) {
               if(var5 == null) {
                  break label68;
               }

               y.c.q var6 = (y.c.q)var5.c();
               int var7 = var6.d();
               int var8 = var6.b();
               var10000 = var8;
               if(var17) {
                  break;
               }

               label63: {
                  if(var8 != 0) {
                     int var9 = (int)Math.floor(((double)var8 + 1.0D) / 2.0D);
                     int var10 = (int)Math.ceil(((double)var8 + 1.0D) / 2.0D);
                     int var11 = 1;
                     y.c.d var12 = var6.g();

                     while(var11 < var9) {
                        ++var11;
                        var12 = var12.h();
                        if(var17) {
                           break label63;
                        }

                        if(var17) {
                           break;
                        }
                     }

                     byte var13 = 0;

                     while(var11 <= var10) {
                        var10000 = var13;
                        if(var17) {
                           continue label68;
                        }

                        if(var13 != 0) {
                           break;
                        }

                        y.f.I var14 = this.g.g(var12);
                        y.c.q var15 = var12.c();
                        int var16 = var15.d();
                        if(this.t[var7] == var6.d() && !this.r[var12.b()] && var4 < this.o[var16]) {
                           var4 = this.o[var16];
                           this.t[var16] = var6.d();
                           this.s[var7] = this.s[var16];
                           this.t[var7] = this.s[var7];
                           var13 = 1;
                           this.z[var16] = var14.getSourcePoint().a();
                           this.y[var7] = var14.getTargetPoint().a();
                        }

                        var12 = var12.h();
                        ++var11;
                        if(var17) {
                           break;
                        }
                     }
                  }

                  var5 = var5.a();
               }

               if(var17) {
                  break label68;
               }
            }
         }

         ++var3;
      } while(!var17);

   }

   protected void a(y.f.X var1, double[] var2, y.c.y[] var3) {
      boolean var9 = a.i;
      int var4 = var3.length - 1;

      y.c.x var17;
      label100: {
         label99: {
            int var7;
            y.c.y var10000;
            label104: {
               label97:
               while(true) {
                  if(var4 >= 0) {
                     y.c.y var5 = var3[var4];
                     var10000 = var5;
                     if(var9) {
                        break label104;
                     }

                     y.c.p var6 = var5.k();

                     do {
                        if(var6 == null) {
                           --var4;
                           if(!var9) {
                              continue label97;
                           }

                           var4 = 0;
                           break label97;
                        }

                        var7 = ((y.c.q)var6.c()).d();
                        int var16 = this.s[var7];
                        if(var9) {
                           if(var16 >= var7) {
                              break label99;
                           }

                           var10000 = var3[var4];
                           break label104;
                        }

                        if(var16 == var7 && var2[var7] == Double.MAX_VALUE) {
                           this.a(var7, var2);
                        }

                        var6 = var6.a();
                     } while(!var9);

                     --var4;
                     if(!var9) {
                        continue;
                     }

                     var4 = 0;
                     break;
                  }

                  var4 = 0;
                  break;
               }

               if(var4 >= var3.length) {
                  break label99;
               }

               var10000 = var3[var4];
            }

            while(true) {
               y.c.x var10 = var10000.a();
               var17 = var10;
               if(var9) {
                  break label100;
               }

               if(var10.f()) {
                  y.c.q var12 = var3[var4].a().e();
                  var7 = var12.d();
                  if(this.w[this.s[var7]] == var7 && !this.x[var7]) {
                     this.x[var7] = true;
                     this.b(var7, var2);
                  }
               }

               ++var4;
               if(var9 || var4 >= var3.length) {
                  break;
               }

               var10000 = var3[var4];
            }
         }

         var17 = var1.o();
      }

      y.c.x var14 = var17;

      while(var14.f()) {
         y.c.q var11 = var14.e();
         int var13 = var11.d();
         double var15 = this.v[this.w[this.s[var13]]];
         if(var15 < Double.MAX_VALUE) {
            var2[var13] += var15;
         }

         var14.g();
         if(var9) {
            break;
         }
      }

   }

   private void a(int var1, double[] var2) {
      boolean var10 = a.i;
      ArrayList var3 = new ArrayList(50);
      var3.add(new X(var1));

      label85:
      while(!var3.isEmpty()) {
         X var4;
         int var11;
         label90: {
            label96: {
               var4 = (X)var3.get(var3.size() - 1);
               switch(var4.b) {
               case 3:
                  break;
               case 4:
                  break label96;
               case 5:
                  break label90;
               default:
                  var3.remove(var3.size() - 1);
                  if(!var10) {
                     continue;
                  }
               case 0:
                  var2[var4.a] = 0.0D;
                  var4.d = 0.0D;
                  var4.e = true;
                  var4.c = var4.a;
                  var4.b = 1;
               case 1:
                  label92: {
                     if(var4.c != var4.a) {
                        var4.d -= this.y[var4.c];
                     }

                     if(this.o[var4.c] > 0) {
                        var4.b = 2;
                        if(!var10) {
                           break label92;
                        }
                     }

                     var4.b = 4;
                     if(!var10) {
                        continue;
                     }
                  }
               case 2:
                  var4.f = this.p[var4.c];
                  var4.g = this.s[var4.f];
                  if(var2[var4.g] == Double.MAX_VALUE) {
                     X var5 = new X(var4.g);
                     var3.add(var5);
                     var4.b = 3;
                     if(!var10) {
                        continue;
                     }
                  }

                  var4.b = 3;
               }

               var11 = var4.g;
               int var6 = var4.a;
               int var7 = var4.f;
               if(this.w[var6] == var6) {
                  this.w[var6] = this.w[var11];
               }

               if(this.w[var6] == this.w[var11]) {
                  label95: {
                     double var8 = var2[var7] + 0.5D * (this.A[var7] + this.A[var4.c]) + this.B[var7] - var4.d;
                     if(var4.e) {
                        var2[var6] = var8;
                        var4.e = false;
                        if(!var10) {
                           break label95;
                        }
                     }

                     var2[var6] = Math.max(var2[var6], var8);
                  }
               }

               var4.b = 4;
            }

            var4.d += this.z[var4.c];
            var4.c = this.t[var4.c];
            if(var4.c != var4.a) {
               var4.b = 1;
               if(!var10) {
                  continue;
               }
            }

            var4.b = 5;
         }

         var11 = var4.a;
         double var12 = 0.0D;
         int var13 = var11;

         while(true) {
            if(var13 != var11) {
               var12 -= this.y[var13];
            }

            var2[var13] = var2[var11] + var12;
            var12 += this.z[var13];
            var13 = this.t[var13];

            while(var13 == var11) {
               var4.b = -1;
               var3.remove(var3.size() - 1);
               if(!var10) {
                  if(var10) {
                     return;
                  }
                  continue label85;
               }
            }
         }
      }

   }

   private void b(int var1, double[] var2) {
      boolean var11 = a.i;
      ArrayList var3 = new ArrayList();
      var3.add(new W(var1));

      while(var3.size() > 0) {
         W var4 = (W)var3.get(var3.size() - 1);
         int var5 = var4.b;
         int var6 = var4.a;
         var4.b = this.t[var5];
         if(var4.b == var6) {
            var3.remove(var3.size() - 1);
         }

         int var7 = this.q[var5];
         if(var7 >= 0) {
            int var8 = this.w[this.s[var7]];
            if(var8 != this.w[var6]) {
               double var9 = var2[var7] - var2[var6] - this.B[var5] - 0.5D * (this.A[var5] + this.A[var7]);
               if(this.v[var8] != Double.MAX_VALUE) {
                  var9 += this.v[var8];
               }

               this.v[this.w[var6]] = Math.min(this.v[this.w[var6]], var9);
               if(!var11) {
                  continue;
               }
            }

            int var12 = this.s[var7];
            if(!this.x[var12]) {
               this.x[var12] = true;
               W var10 = new W(var12);
               var3.add(var10);
               if(var11) {
                  break;
               }
            }
         }
      }

   }

   protected void a(y.f.X var1) {
      boolean var10 = a.i;
      double[] var2 = new double[4];
      double[] var3 = new double[4];
      y.c.x var4 = var1.o();

      y.c.q var5;
      int var6;
      while(true) {
         if(var4.f()) {
            var5 = var4.e();
            var6 = var5.d();
            var3[0] += this.u[0][var6];
            var3[1] += this.u[1][var6];
            var3[2] += this.u[2][var6];
            var3[3] += this.u[3][var6];
            var4.g();
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         var3[0] /= (double)var1.e();
         var3[1] /= (double)var1.e();
         var3[2] /= (double)var1.e();
         var3[3] /= (double)var1.e();
         break;
      }

      var4 = var1.o();

      while(var4.f()) {
         var5 = var4.e();
         var6 = var5.d();
         y.d.t var7 = var1.l(var5);
         var2[0] = this.u[0][var6] - var3[0];
         var2[1] = this.u[1][var6] - var3[1];
         var2[2] = this.u[2][var6] - var3[2];
         var2[3] = this.u[3][var6] - var3[3];
         Arrays.sort(var2);
         double var8 = (var2[1] + var2[2]) / 2.0D;
         var1.a(var5, new y.d.t(var8, var7.b()));
         var4.g();
         if(var10) {
            break;
         }
      }

   }

   protected void e() {
      super.e();
      this.o = null;
      this.p = null;
      this.A = null;
      this.B = null;
      this.q = null;
      this.r = null;
      this.s = null;
      this.t = null;
      this.u = (double[][])null;
      this.v = null;
      this.w = null;
      this.x = null;
      this.z = null;
      this.y = null;
   }
}
