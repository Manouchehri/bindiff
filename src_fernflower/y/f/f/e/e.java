package y.f.f.e;

import y.c.A;
import y.c.B;
import y.c.q;
import y.c.x;
import y.f.f.e.a;
import y.f.f.e.f;
import y.f.f.e.g;
import y.f.f.e.h;

class e {
   private y.c.i a;
   private int[] b;
   private int[] c;
   private int[] d;
   private int[] e;
   private int[] f;
   private int[] g;
   private int[] h;
   private int i;
   private int j;
   private int k;
   private g l = new g();
   private boolean m = false;
   private boolean n = true;
   private f o;
   private h[] p;
   private int[] q;
   private int r;

   public int a(y.c.i var1, y.c.c var2, y.c.c var3, y.c.c var4, y.c.c var5, y.c.h var6, A var7) {
      int var37 = a.a;
      this.l.a();
      this.a(var1, var2, var3, var4, var5);
      int var10 = 0;
      int var11 = 0;
      y.c.e var13 = this.a.p();

      y.c.d var8;
      int var9;
      int var10000;
      int var10001;
      while(true) {
         if(var13.f()) {
            var8 = var13.a();
            var9 = var8.b();
            int var12 = Math.abs(this.d[var9]);
            var10000 = var12;
            var10001 = var10;
            if(var37 != 0) {
               break;
            }

            if(var12 > var10) {
               var10 = var12;
            }

            if(this.c[var9] > var11) {
               var11 = this.c[var9];
            }

            var13.g();
            if(var37 == 0) {
               continue;
            }

            y.c.i.g = !y.c.i.g;
         }

         var10000 = Integer.MAX_VALUE / this.j;
         var10001 = var10;
         break;
      }

      if(var10000 < var10001) {
         throw new RuntimeException("Internal error: maxPathCost overflow!");
      } else {
         var10 *= this.j;
         y.c.f var38 = new y.c.f();
         q var14 = this.a.k();
         x var16 = this.a.o();

         q var15;
         while(true) {
            if(var16.f()) {
               var15 = var16.e();
               if(var37 != 0) {
                  break;
               }

               if(var15 != var14) {
                  var38.add(this.a.a(var15, var14));
                  var38.add(this.a.a(var14, var15));
               }

               var16.g();
               if(var37 == 0) {
                  continue;
               }
            }

            this.i = this.a.h();
            this.g = new int[this.j];
            this.h = new int[this.i];
            break;
         }

         int[] var39 = new int[this.j];
         y.c.d[] var17 = new y.c.d[this.j];
         int[] var18 = new int[this.i];
         int[] var19 = new int[this.i];
         int[] var20 = new int[this.i];
         x var24 = this.a.o();

         int var23;
         while(var24.f()) {
            var23 = var24.e().d();
            int var21 = this.e[var23];
            int var22 = Math.abs(var21);
            if(var22 > var11) {
               var11 = var22;
            }

            var39[var23] = var21;
            var24.g();
            if(var37 != 0) {
               break;
            }
         }

         y.c.e var43 = var38.a();

         while(var43.f()) {
            var8 = var43.a();
            var9 = var8.b();
            var18[var9] = Integer.MAX_VALUE;
            var19[var9] = var10;
            var20[var9] = Integer.MAX_VALUE;
            var43.g();
            if(var37 != 0) {
               break;
            }
         }

         y.c.f var44 = new y.c.f();
         y.c.e var28 = this.a.p();

         while(true) {
            if(var28.f()) {
               var8 = var28.a();
               var9 = var8.b();
               int var26 = var8.c().d();
               int var27 = var8.d().d();
               var10000 = var18[var9];
               if(var37 != 0) {
                  break;
               }

               if(var10000 != Integer.MAX_VALUE) {
                  var18[var9] = this.c[var9];
                  var19[var9] = this.d[var9];
                  int var25 = this.b[var9];
                  if(var25 != 0) {
                     var39[var26] -= var25;
                     var39[var27] += var25;
                     var18[var9] -= var25;
                  }

                  var20[var9] = var18[var9];
                  if(var19[var9] < 0) {
                     var44.add(var8);
                     var39[var26] -= var18[var9];
                     var39[var27] += var18[var9];
                     var19[var9] = -var19[var9];
                     this.a.c(var8);
                  }
               }

               var28.g();
               if(var37 == 0) {
                  continue;
               }
            }

            var10000 = 1;
            break;
         }

         int var45 = var10000;
         var11 = var11 * this.i / (this.j * this.j);

         y.c.e var30;
         int var31;
         int var33;
         int var34;
         y.c.e var41;
         label327: {
            label326:
            while(true) {
               if(var11 >= var45) {
                  var45 *= 2;
                  if(var37 != 0) {
                     break;
                  }

                  if(var37 == 0) {
                     continue;
                  }
               }

               while(true) {
                  var10000 = var45;

                  label262:
                  while(true) {
                     if(var10000 <= 0) {
                        break label326;
                     }

                     ++this.l.a;
                     var41 = this.a.p();
                     if(var37 != 0) {
                        break label327;
                     }

                     var30 = var41;

                     while(true) {
                        if(!var30.f()) {
                           break label262;
                        }

                        var8 = var30.a();
                        var9 = var8.b();
                        int var29 = var8.c().d();
                        var23 = var8.d().d();
                        var31 = var19[var9] + this.g[var29] - this.g[var23];
                        var10000 = var20[var9];
                        if(var37 != 0) {
                           break;
                        }

                        label257: {
                           if(var10000 >= var45 && var31 < 0) {
                              var39[var23] += var20[var9];
                              var39[var29] -= var20[var9];
                              this.h[var9] = var18[var9];
                              var20[var9] = 0;
                              if(var37 == 0) {
                                 break label257;
                              }
                           }

                           if(this.h[var9] >= var45 && var31 > 0) {
                              var39[var29] += this.h[var9];
                              var39[var23] -= this.h[var9];
                              this.h[var9] = 0;
                              var20[var9] = var18[var9];
                           }
                        }

                        var30.g();
                        if(var37 != 0) {
                           break label262;
                        }
                     }
                  }

                  x var36 = this.a.o();

                  label321: {
                     while(var36.f()) {
                        q var46 = var36.e();
                        q var42 = var46;

                        label317:
                        while(true) {
                           var10000 = var42.d();
                           if(var37 != 0) {
                              break label321;
                           }

                           var31 = var10000;

                           while(true) {
                              if(var39[var31] < var45) {
                                 break label317;
                              }

                              ++this.l.b;
                              q var32 = this.a(var46, var45, var19, var20, this.h, var39, var17);
                              var42 = var32;
                              if(var37 != 0) {
                                 break;
                              }

                              if(var32 == null) {
                                 break label317;
                              }

                              var33 = var32.d();
                              var34 = var39[var31];
                              var15 = var32;

                              label312:
                              while(true) {
                                 var42 = var15;
                                 q var40 = var46;

                                 label310:
                                 while(true) {
                                    label296: {
                                       if(var42 != var40) {
                                          int var35;
                                          label293: {
                                             var8 = var17[var15.d()];
                                             var9 = var8.b();
                                             if(var15 == var8.d()) {
                                                var35 = var20[var9];
                                                var15 = var8.c();
                                                if(var37 == 0) {
                                                   break label293;
                                                }
                                             }

                                             var35 = this.h[var9];
                                             var15 = var8.d();
                                          }

                                          if(var35 >= var34) {
                                             break;
                                          }

                                          var34 = var35;
                                          if(var37 != 0) {
                                             break label296;
                                          }

                                          if(var37 == 0) {
                                             break;
                                          }
                                       }

                                       if(var34 > -var39[var33]) {
                                          var34 = -var39[var33];
                                       }
                                    }

                                    var15 = var32;

                                    while(true) {
                                       do {
                                          if(var15 == var46) {
                                             break label312;
                                          }

                                          var8 = var17[var15.d()];
                                          var9 = var8.b();
                                          var42 = var15;
                                          var40 = var8.d();
                                          if(var37 != 0) {
                                             continue label310;
                                          }

                                          if(var15 != var40) {
                                             break;
                                          }

                                          this.h[var9] += var34;
                                          var20[var9] -= var34;
                                          var15 = var8.c();
                                       } while(var37 == 0);

                                       this.h[var9] -= var34;
                                       var20[var9] += var34;
                                       var15 = var8.d();
                                       if(var37 != 0) {
                                          break label312;
                                       }
                                    }
                                 }
                              }

                              var39[var31] -= var34;
                              var39[var33] += var34;
                              if(var37 != 0) {
                                 break label317;
                              }
                           }
                        }

                        var36.g();
                        if(var37 != 0) {
                           break;
                        }
                     }

                     var10000 = var45 / 2;
                  }

                  var45 = var10000;
                  if(var37 != 0) {
                     break label326;
                  }
               }
            }

            var41 = var44.a();
         }

         var30 = var41;

         while(true) {
            if(var30.f()) {
               var8 = var30.a();
               var10000 = var8.b();
               if(var37 != 0) {
                  break;
               }

               var9 = var10000;
               this.h[var9] = var18[var9] - this.h[var9];
               this.a.c(var8);
               var30.g();
               if(var37 == 0) {
                  continue;
               }
            }

            var10000 = 1;
            break;
         }

         int var47 = var10000;
         y.c.e var48 = var38.a();

         label392: {
            while(true) {
               if(var48.f()) {
                  var8 = var48.a();
                  var10000 = this.h[var8.b()];
                  if(var37 != 0) {
                     break;
                  }

                  if(var10000 != 0) {
                     var47 = 0;
                  }

                  var48.g();
                  if(var37 == 0) {
                     continue;
                  }
               }

               var48 = var38.a();
               var10000 = var48.f();
               break;
            }

            while(var10000 != 0) {
               var8 = var48.a();
               this.a.a(var8);
               var48.g();
               if(var37 != 0) {
                  break label392;
               }

               if(var37 != 0) {
                  break;
               }

               var10000 = var48.f();
            }

            if(var47 == 0) {
               throw new RuntimeException("Internal error: no feasible flow found!");
            }
         }

         var31 = 0;
         y.c.e var49 = this.a.p();

         while(true) {
            if(var49.f()) {
               var8 = var49.a();
               var9 = var8.b();
               this.h[var9] += this.b[var9];
               var10000 = var31 + this.h[var9] * this.d[var9];
               if(var37 != 0) {
                  break;
               }

               var31 = var10000;
               var6.a(var8, this.h[var9]);
               var49.g();
               if(var37 == 0) {
                  continue;
               }
            }

            var10000 = Integer.MAX_VALUE;
            break;
         }

         int var50 = var10000;
         var33 = 0;

         label408: {
            while(true) {
               if(var33 < this.j) {
                  var10000 = this.g[var33];
                  if(var37 != 0) {
                     break;
                  }

                  if(var10000 < var50) {
                     var50 = this.g[var33];
                  }

                  ++var33;
                  if(var37 == 0) {
                     continue;
                  }
               }

               if(var7 != null) {
                  x var51 = this.a.o();

                  while(var51.f()) {
                     var15 = var51.e();
                     var7.a(var15, this.g[var15.d()] - var50);
                     var51.g();
                     if(var37 != 0) {
                        break label408;
                     }

                     if(var37 != 0) {
                        break;
                     }
                  }
               }

               var10000 = this.m;
               break;
            }

            if(var10000 != 0) {
               int[] var52 = new int[this.j];
               var34 = 0;

               while(var34 < this.j) {
                  var10000 = var52[var34];
                  if(var37 != 0) {
                     return var10000;
                  }

                  if(var10000 == 0 && !this.a(var34, var52)) {
                     throw new RuntimeException("Internal error: negative cost cycle found!");
                  }

                  ++var34;
                  if(var37 != 0) {
                     break;
                  }
               }
            }

            this.l.b();
         }

         var10000 = var31;
         return var10000;
      }
   }

   private void a(y.c.i var1, y.c.c var2, y.c.c var3, y.c.c var4, y.c.c var5) {
      int var12 = a.a;
      this.a = var1;
      this.i = this.a.h();
      this.j = this.a.f();
      this.b = new int[this.i];
      this.c = new int[this.i];
      this.d = new int[this.i];
      this.e = new int[this.j];
      this.f = new int[this.j];
      this.o = new f(this.j);
      this.p = new h[this.j];
      this.q = new int[this.j];
      int var8 = 0;
      this.k = 1;
      x var9 = this.a.o();

      int var10000;
      while(true) {
         if(var9.f()) {
            q var6 = var9.e();
            int var7 = var6.d();
            this.p[var7] = new h(var6, var7);
            this.e[var7] = var5.a(var6);
            var8 += this.e[var7];
            var10000 = this.e[var7];
            if(var12 != 0) {
               break;
            }

            if(var10000 > 0) {
               this.k += this.e[var7];
            }

            var9.g();
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = var8;
         break;
      }

      if(var10000 != 0) {
         System.err.println("Warning: supply constraint broken!");
      }

      y.c.e var11 = this.a.p();

      while(true) {
         if(var11.f()) {
            y.c.d var13 = var11.a();
            int var10 = var13.b();
            this.d[var10] = var4.a(var13);
            if(var2 != null) {
               this.b[var10] = var2.a(var13);
            }

            this.c[var10] = var3.a(var13);
            if(this.b[var10] < 0 || this.c[var10] < 0) {
               throw new B("found negative capacity");
            }

            if(this.b[var10] > this.c[var10]) {
               throw new B("found lCap > uCap");
            }

            if(this.c[var10] == Integer.MAX_VALUE) {
               this.c[var10] = this.k;
               if(this.b[var10] == Integer.MAX_VALUE) {
                  throw new B("found infinite lCap");
               }
            }

            var11.g();
            if(var12 == 0) {
               continue;
            }
         }

         return;
      }
   }

   private q a(q var1, int var2, int[] var3, int[] var4, int[] var5, int[] var6, y.c.d[] var7) {
      int var19 = a.a;
      int var8 = 0;

      while(var8 < this.j) {
         this.f[var8] = Integer.MAX_VALUE;
         ++var8;
         if(var19 != 0) {
            break;
         }
      }

      q var14 = null;
      int var16 = var1.d();
      this.f[var16] = 0;
      this.o.a();
      this.o.a(0, this.p[var16]);
      this.r = 0;

      int var11;
      int var18;
      label91:
      while(!this.o.c()) {
         ++this.l.c;
         h var17 = this.o.b();
         this.o.a(var17);
         q var20 = var17.b;
         int var9 = var17.c;
         this.q[this.r++] = var9;
         int var10000 = var6[var9];
         int var10001 = -var2;

         while(true) {
            q var10;
            y.c.d var12;
            int var13;
            int var15;
            label70:
            while(true) {
               if(var10000 <= var10001) {
                  var14 = var20;
                  break label91;
               }

               var18 = this.f[var9] + this.g[var9];
               var12 = var20.f();

               while(true) {
                  if(var12 == null) {
                     break label70;
                  }

                  var13 = var12.b();
                  var10000 = var4[var13];
                  var10001 = var2;
                  if(var19 != 0) {
                     break;
                  }

                  if(var10000 >= var2) {
                     var10 = var12.d();
                     var11 = var10.d();
                     var15 = var18 - this.g[var11] + var3[var13];
                     if(var15 < this.f[var11]) {
                        label64: {
                           if(this.f[var11] == Integer.MAX_VALUE) {
                              this.o.a(var15, this.p[var11]);
                              if(var19 == 0) {
                                 break label64;
                              }
                           }

                           this.o.a(this.p[var11], var15);
                        }

                        this.f[var11] = var15;
                        var7[var11] = var12;
                     }
                  }

                  var12 = var12.g();
                  if(var19 != 0) {
                     break label70;
                  }
               }
            }

            var12 = var20.g();

            while(true) {
               if(var12 == null) {
                  continue label91;
               }

               var13 = var12.b();
               var10000 = var5[var13];
               var10001 = var2;
               if(var19 != 0) {
                  break;
               }

               if(var10000 >= var2) {
                  var10 = var12.c();
                  var11 = var10.d();
                  var15 = var18 - this.g[var11] - var3[var13];
                  if(var15 < this.f[var11]) {
                     label83: {
                        if(this.f[var11] == Integer.MAX_VALUE) {
                           this.o.a(var15, this.p[var11]);
                           if(var19 == 0) {
                              break label83;
                           }
                        }

                        this.o.a(this.p[var11], var15);
                     }

                     this.f[var11] = var15;
                     var7[var11] = var12;
                  }
               }

               var12 = var12.h();
            }
         }
      }

      if(var14 != null) {
         int var21 = this.f[var14.d()];
         var18 = this.r - 1;

         while(var18 >= 0) {
            var11 = this.q[var18];
            this.g[var11] += this.f[var11] - var21;
            --var18;
            if(var19 != 0) {
               break;
            }
         }
      }

      return var14;
   }

   private boolean a(int var1, int[] var2) {
      int var10 = a.a;
      int var3 = 0;

      while(true) {
         if(var3 < this.j) {
            this.f[var3] = Integer.MAX_VALUE;
            ++var3;
            if(var10 != 0) {
               break;
            }

            if(var10 == 0) {
               continue;
            }
         }

         this.f[var1] = 0;
         var2[var1] = 1;
         break;
      }

      int var8 = 0;

      y.c.d var4;
      int var5;
      int var6;
      int var7;
      y.c.e var12;
      int var10000;
      label85:
      while(true) {
         var10000 = var8;
         int var10001 = this.a.f() - 1;

         label82:
         while(var10000 <= var10001) {
            var12 = this.a.p();
            if(var10 != 0) {
               break label85;
            }

            y.c.e var9 = var12;

            while(var9.f()) {
               var4 = var9.a();
               var5 = var4.b();
               var6 = var4.c().d();
               var7 = var4.d().d();
               var10000 = this.h[var5];
               var10001 = this.c[var5];
               if(var10 != 0) {
                  continue label82;
               }

               if(var10000 < var10001 && this.f[var6] != Integer.MAX_VALUE) {
                  var3 = this.f[var6] + this.d[var5];
                  if(this.f[var7] > var3) {
                     this.f[var7] = var3;
                     var2[var7] = 1;
                  }
               }

               if(this.h[var5] > 0 && this.f[var7] != Integer.MAX_VALUE) {
                  var3 = this.f[var7] - this.d[var5];
                  if(this.f[var6] > var3) {
                     this.f[var6] = var3;
                     var2[var6] = 1;
                  }
               }

               var9.g();
               if(var10 != 0) {
                  break;
               }
            }

            ++var8;
            if(var10 == 0) {
               continue label85;
            }
            break;
         }

         var12 = this.a.p();
         break;
      }

      y.c.e var11 = var12;

      while(true) {
         if(var11.f()) {
            var4 = var11.a();
            var5 = var4.b();
            var6 = var4.c().d();
            var7 = var4.d().d();
            var10000 = this.f[var6];
            if(var10 != 0) {
               break;
            }

            if(var10000 != Integer.MAX_VALUE && this.h[var5] < this.c[var5] && this.f[var7] > this.f[var6] + this.d[var5]) {
               return false;
            }

            if(this.f[var7] != Integer.MAX_VALUE && this.h[var5] > 0 && this.f[var6] > this.f[var7] - this.d[var5]) {
               return false;
            }

            var11.g();
            if(var10 == 0) {
               continue;
            }
         }

         var10000 = 1;
         break;
      }

      return (boolean)var10000;
   }
}
