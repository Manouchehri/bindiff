package y.a;

import y.a.L;
import y.a.R;
import y.a.ac;
import y.a.h;

class K {
   private y.c.q[] a;
   private y.c.d[] b;
   private int[] c;
   private int[] d;
   private int[] e;
   private int[] f;
   private int[] g;
   private int h;
   private int i;
   private y.c.q j;
   private y.c.q k;
   private y.c.i l;
   private int m;
   private int n;
   private int o;
   private R p;
   private boolean q = true;
   private y.c.y r;
   private y.c.y s;
   private L t = new L();
   private boolean u;
   private int v;
   private int w = 5;
   private int x;

   public int a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.c var4, y.c.h var5) {
      boolean var20 = h.a;
      this.t.a();
      if(var3 == var2) {
         throw new y.c.B("source == sink");
      } else if(var2.c() != 0 && var3.b() != 0) {
         this.a(var1, var2, var3, var4);

         int var8;
         label329:
         while(true) {
            y.c.q var6 = this.p.a();
            int var10000;
            int var10001;
            if(var6 == null) {
               var10000 = this.m;
               var10001 = 2;

               label324:
               while(true) {
                  if(var10000 == var10001) {
                     break label329;
                  }

                  var8 = 0;

                  label315: {
                     while(var8 < this.h) {
                        this.c[var8] = this.h;
                        ++var8;
                        if(var20) {
                           break label315;
                        }

                        if(var20) {
                           break;
                        }
                     }

                     this.a();
                  }

                  var8 = 0;

                  while(true) {
                     if(var8 >= this.h) {
                        break label324;
                     }

                     var10000 = this.c[var8];
                     var10001 = this.h;
                     if(var20) {
                        break;
                     }

                     if(var10000 == var10001) {
                        this.r.add(this.a[var8]);
                        this.c[var8] = this.n;
                     }

                     ++var8;
                     if(var20) {
                        break label324;
                     }
                  }
               }

               this.m = 2;
               this.b();
               if(!var20) {
                  continue;
               }
            }

            var10000 = var6.d();

            label300:
            while(true) {
               int var7 = var10000;
               if(var6 == this.k) {
                  continue label329;
               }

               var10000 = this.c[var7];
               var10001 = this.h;

               label297:
               while(true) {
                  label275:
                  while(true) {
                     int var9;
                     y.c.d var10;
                     int var11;
                     y.c.q var12;
                     int var13;
                     int var16;
                     do {
                        if(var10000 == var10001 && this.m == 1) {
                           continue label329;
                        }

                        int var14;
                        y.c.e var17;
                        label210: {
                           var8 = this.d[var7];
                           var9 = this.c[var7];
                           var16 = Integer.MAX_VALUE;
                           if(this.c[var7] < this.h) {
                              var17 = var6.l();

                              while(var17.f()) {
                                 ++this.t.c;
                                 var10 = var17.a();
                                 var11 = var10.b();
                                 int var15 = this.f[var11] - this.e[var11];
                                 var10000 = var15;
                                 if(var20) {
                                    break label210;
                                 }

                                 if(var15 != 0) {
                                    label361: {
                                       var12 = var10.d();
                                       var13 = var12.d();
                                       var14 = this.c[var13];
                                       if(var14 < var9) {
                                          ++this.t.b;
                                          if(this.d[var13] == 0) {
                                             this.p.b(var12, var14);
                                          }

                                          if(var8 <= var15) {
                                             this.d[var13] += var8;
                                             this.e[var11] += var8;
                                             var8 = 0;
                                             if(!var20) {
                                                break;
                                             }
                                          }

                                          this.d[var13] += var15;
                                          this.e[var11] += var15;
                                          var8 -= var15;
                                          if(!var20) {
                                             break label361;
                                          }
                                       }

                                       if(var14 < var16) {
                                          var16 = var14;
                                       }
                                    }
                                 }

                                 var17.g();
                                 if(var20) {
                                    break;
                                 }
                              }
                           }

                           var10000 = var8;
                        }

                        label233: {
                           if(var10000 > 0) {
                              var17 = var6.k();

                              while(var17.f()) {
                                 ++this.t.c;
                                 var10 = var17.a();
                                 var11 = var10.b();
                                 var10000 = this.e[var11];
                                 if(var20) {
                                    break label233;
                                 }

                                 if(var10000 != 0) {
                                    label362: {
                                       var12 = var10.c();
                                       var13 = var12.d();
                                       var14 = this.c[var13];
                                       if(var14 < var9) {
                                          ++this.t.b;
                                          if(this.d[var13] == 0) {
                                             this.p.b(var12, var14);
                                          }

                                          if(var8 <= this.e[var11]) {
                                             this.e[var11] -= var8;
                                             this.d[var13] += var8;
                                             var8 = 0;
                                             if(!var20) {
                                                break;
                                             }
                                          }

                                          this.d[var13] += this.e[var11];
                                          var8 -= this.e[var11];
                                          this.e[var11] = 0;
                                          if(!var20) {
                                             break label362;
                                          }
                                       }

                                       if(var14 < var16) {
                                          var16 = var14;
                                       }
                                    }
                                 }

                                 var17.g();
                                 if(var20) {
                                    break;
                                 }
                              }
                           }

                           this.d[var7] = var8;
                           var10000 = var8;
                        }

                        if(var10000 <= 0) {
                           continue label329;
                        }

                        var10000 = this.t.c;
                        var10001 = this.x;
                     } while(var20);

                     if(var10000 > var10001) {
                        break;
                     }

                     ++this.t.a;
                     if(this.m == 1) {
                        if(--this.g[var9] == 0 || var16 >= this.h - 1) {
                           this.c[var7] = this.h;
                           if(var16 >= this.h) {
                              continue label329;
                           }

                           this.s.add(var6);

                           label269:
                           while(true) {
                              var10000 = this.s.isEmpty();

                              while(true) {
                                 if(var10000 != 0) {
                                    continue label329;
                                 }

                                 var12 = this.s.d();
                                 var13 = var12.d();
                                 ++this.t.e;
                                 y.c.e var19 = var12.l();

                                 int var18;
                                 y.c.q var21;
                                 while(var19.f()) {
                                    var10 = var19.a();
                                    var11 = var10.b();
                                    var21 = var10.d();
                                    var18 = var21.d();
                                    var10000 = this.e[var11];
                                    var10001 = this.f[var11];
                                    if(var20) {
                                       continue label275;
                                    }

                                    if(var10000 < var10001 && this.c[var18] < this.h) {
                                       this.s.add(var21);
                                       --this.g[this.c[var18]];
                                       this.c[var18] = this.h;
                                    }

                                    var19.g();
                                    if(var20) {
                                       break;
                                    }
                                 }

                                 var19 = var12.k();

                                 while(true) {
                                    if(!var19.f()) {
                                       continue label269;
                                    }

                                    var10 = var19.a();
                                    var11 = var10.b();
                                    var21 = var10.c();
                                    var18 = var21.d();
                                    var10000 = this.e[var11];
                                    if(var20) {
                                       break;
                                    }

                                    if(var20) {
                                       continue label300;
                                    }

                                    if(var10000 > 0 && this.c[var18] < this.h) {
                                       this.s.add(var21);
                                       --this.g[this.c[var18]];
                                       this.c[var18] = this.h;
                                    }

                                    var19.g();
                                    if(var20) {
                                       break label269;
                                    }
                                 }
                              }
                           }
                        }

                        ++var16;
                        this.c[var7] = var16;
                        ++this.g[var16];
                        this.p.a(var6, var16);
                        if(!var20) {
                           continue label329;
                        }
                     }

                     ++var16;
                     this.c[var7] = var16;
                     this.p.a(var6, var16);
                     if(!var20) {
                        continue label329;
                     }
                     break;
                  }

                  this.x += this.v;
                  ++this.t.d;
                  this.p.c();
                  if(this.m != 1) {
                     break label300;
                  }

                  int var22 = 0;

                  label285: {
                     while(var22 < this.h) {
                        this.c[var22] = this.h;
                        ++var22;
                        if(var20) {
                           break label285;
                        }

                        if(var20) {
                           break;
                        }
                     }

                     this.a();
                  }

                  if(!this.p.b()) {
                     continue label329;
                  }

                  var22 = 0;

                  while(true) {
                     if(var22 >= this.h) {
                        break label297;
                     }

                     var10000 = this.c[var22];
                     var10001 = this.h;
                     if(var20) {
                        break;
                     }

                     if(var10000 == var10001) {
                        this.r.add(this.a[var22]);
                        this.c[var22] = this.n;
                     }

                     ++var22;
                     if(var20) {
                        break label297;
                     }
                  }
               }

               this.m = 2;
               this.b();
               if(!var20) {
                  continue label329;
               }
               break;
            }

            y.c.x var23 = this.r.a();

            while(true) {
               if(var23.f()) {
                  this.c[var23.e().d()] = this.n;
                  var23.g();
                  if(var20) {
                     break;
                  }

                  if(!var20) {
                     continue;
                  }
               }

               this.b();
               break;
            }

            if(var20) {
               break;
            }
         }

         if(!this.c()) {
            System.err.println("checkMaxFlow failed !");
         }

         var8 = 0;

         boolean var24;
         while(true) {
            if(var8 < this.i) {
               var24 = this.u;
               if(var20) {
                  break;
               }

               label148: {
                  if(var24 && this.e[var8] == this.o) {
                     var5.a(this.b[var8], Integer.MAX_VALUE);
                     if(!var20) {
                        break label148;
                     }
                  }

                  var5.a(this.b[var8], this.e[var8]);
               }

               ++var8;
               if(!var20) {
                  continue;
               }
            }

            this.t.b();
            var8 = this.k.d();
            var24 = this.u;
            break;
         }

         return var24 && this.d[var8] >= this.o?Integer.MAX_VALUE:this.d[var8];
      } else {
         this.t.b();
         return 0;
      }
   }

   private void a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.c var4) {
      boolean var10 = h.a;
      this.l = var1;
      this.j = var2;
      this.k = var3;
      this.h = this.l.f();
      this.i = this.l.h();
      this.n = 2 * this.h - 1;
      this.m = 1;
      this.a = this.l.m();
      this.b = new y.c.d[this.i];
      this.c = new int[this.h];
      this.d = new int[this.h];
      this.e = new int[this.i];
      this.f = new int[this.i];
      if(this.q) {
         this.p = new ac(this.n);
      }

      this.s = new y.c.y();
      this.r = new y.c.y();
      this.v = this.w * this.i;
      this.x = this.v;
      this.o = 0;
      this.u = false;
      y.c.e var8 = this.l.p();

      y.c.d var5;
      int var6;
      int var10000;
      while(true) {
         if(var8.f()) {
            var5 = var8.a();
            var6 = var5.b();
            int var7 = var4.a(var5);
            var10000 = var7;
            if(var10) {
               break;
            }

            if(var7 < 0) {
               throw new y.c.B("found negative capacity");
            }

            label91: {
               if(var7 == Integer.MAX_VALUE) {
                  this.u = true;
                  if(!var10) {
                     break label91;
                  }
               }

               if(var7 > this.o) {
                  this.o = var7;
               }
            }

            this.b[var6] = var5;
            this.f[var6] = var7;
            var8.g();
            if(!var10) {
               continue;
            }
         }

         var10000 = this.u;
         break;
      }

      int var11;
      int var10001;
      label82: {
         if(var10000 != 0) {
            this.o = this.o * this.i + 1;
            if(this.o < 0) {
               throw new RuntimeException("MaxFlow Error:  Integer-Overflow by infinity scaling!");
            }

            var11 = 0;

            while(var11 < this.i) {
               var10000 = this.f[var11];
               var10001 = Integer.MAX_VALUE;
               if(var10) {
                  break label82;
               }

               if(var10000 == Integer.MAX_VALUE) {
                  this.f[var11] = this.o;
               }

               ++var11;
               if(var10) {
                  break;
               }
            }
         }

         var10000 = Integer.MAX_VALUE / this.j.c();
         var10001 = this.o;
      }

      if(var10000 < var10001) {
         System.err.println("Warning: Integer-Overflow possible!");
      }

      y.c.e var9 = this.j.l();

      while(true) {
         if(var9.f()) {
            var5 = var9.a();
            var6 = var5.b();
            var11 = this.f[var6];
            var10000 = var11;
            if(var10) {
               break;
            }

            if(var11 != 0) {
               this.e[var6] = var11;
               int[] var13 = this.d;
               var10001 = var5.d().d();
               var13[var10001] += var11;
               var13 = this.d;
               var10001 = this.j.d();
               var13[var10001] -= var11;
            }

            var9.g();
            if(!var10) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var12 = var10000;

      while(true) {
         if(var12 < this.h) {
            this.c[var12] = this.h;
            ++var12;
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         this.a();
         break;
      }

   }

   private void a() {
      boolean var9 = h.a;
      this.s.add(this.k);
      this.c[this.k.d()] = 0;
      this.g = new int[this.h];
      this.g[0] = 1;

      label59:
      while(!this.s.isEmpty()) {
         y.c.q var1 = this.s.d();
         int var2 = var1.d();
         int var10000 = this.c[var2];
         int var10001 = 1;

         while(true) {
            int var7 = var10000 + var10001;
            y.c.e var8 = var1.l();

            y.c.d var3;
            int var4;
            y.c.q var5;
            int var6;
            while(true) {
               if(var8.f()) {
                  var3 = var8.a();
                  var4 = var3.b();
                  var10000 = this.e[var4];
                  if(var9) {
                     break;
                  }

                  if(var10000 != 0) {
                     var5 = var3.d();
                     var6 = var5.d();
                     if(this.c[var6] >= this.h) {
                        this.c[var6] = var7;
                        this.s.add(var5);
                        ++this.g[var7];
                        if(this.d[var6] > 0) {
                           this.p.a(var5, var7);
                        }
                     }
                  }

                  var8.g();
                  if(!var9) {
                     continue;
                  }
               }

               var8 = var1.k();
               var10000 = var8.f();
               break;
            }

            while(true) {
               if(var10000 == 0) {
                  continue label59;
               }

               var3 = var8.a();
               var4 = var3.b();
               var10000 = this.f[var4];
               var10001 = this.e[var4];
               if(var9) {
                  break;
               }

               if(var10000 != var10001) {
                  var5 = var3.c();
                  var6 = var5.d();
                  if(this.c[var6] >= this.h) {
                     this.c[var6] = var7;
                     this.s.add(var5);
                     ++this.g[var7];
                     if(this.d[var6] > 0) {
                        this.p.a(var5, var7);
                     }
                  }
               }

               var8.g();
               if(var9) {
                  return;
               }

               var10000 = var8.f();
            }
         }
      }

   }

   private void b() {
      boolean var9 = h.a;
      this.s.add(this.j);
      this.c[this.j.d()] = this.h;

      label35:
      while(true) {
         int var10000 = this.s.isEmpty();

         label33:
         while(var10000 == 0) {
            y.c.q var1 = this.s.d();
            int var2 = var1.d();
            int var7 = this.c[var2] + 1;
            y.c.e var8 = var1.l();

            do {
               if(!var8.f()) {
                  continue label35;
               }

               y.c.d var3 = var8.a();
               int var4 = var3.b();
               var10000 = this.e[var4];
               if(var9) {
                  continue label33;
               }

               if(var10000 != 0) {
                  y.c.q var5 = var3.d();
                  int var6 = var5.d();
                  if(this.c[var6] == this.n) {
                     this.c[var6] = var7;
                     if(this.d[var6] > 0) {
                        this.p.a(var5, var7);
                     }

                     this.s.add(var5);
                  }
               }

               var8.g();
            } while(!var9);

            return;
         }

         return;
      }
   }

   private boolean c() {
      boolean var11 = h.a;
      int[] var5 = new int[this.h];
      int var6 = 0;

      int var2;
      int var4;
      int var10000;
      while(true) {
         if(var6 < this.i) {
            var10000 = this.e[var6];
            if(var11) {
               break;
            }

            if(var10000 < 0 || this.e[var6] > this.f[var6]) {
               System.err.println("checkMaxFlow: found wrong flow value!");
               return false;
            }

            var2 = this.b[var6].c().d();
            var4 = this.b[var6].d().d();
            var5[var2] -= this.e[var6];
            var5[var4] += this.e[var6];
            ++var6;
            if(!var11) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      var6 = var10000;

      K var13;
      while(true) {
         if(var6 < this.h) {
            var13 = this;
            if(var11) {
               break;
            }

            if(this.a[var6] != this.j && this.a[var6] != this.k && var5[var6] != 0) {
               System.err.println("checkMaxFlow: found wrong excess!");
               return false;
            }

            ++var6;
            if(!var11) {
               continue;
            }
         }

         var13 = this;
         break;
      }

      boolean[] var12 = new boolean[var13.h];
      y.c.y var7 = new y.c.y();
      var7.add(this.j);
      var12[this.j.d()] = true;

      label84:
      while(true) {
         var10000 = var7.isEmpty();

         label81:
         while(var10000 == 0) {
            y.c.q var1 = var7.d();
            var2 = var1.d();
            y.c.e var10 = var1.l();

            y.c.q var3;
            y.c.d var8;
            int var9;
            while(true) {
               if(var10.f()) {
                  var8 = var10.a();
                  var9 = var8.b();
                  var3 = var8.d();
                  var4 = var3.d();
                  var10000 = this.e[var9];
                  if(var11) {
                     break;
                  }

                  if(var10000 < this.f[var9] && !var12[var4]) {
                     var12[var4] = true;
                     var7.add(var3);
                  }

                  var10.g();
                  if(!var11) {
                     continue;
                  }
               }

               var10 = var1.k();
               var10000 = var10.f();
               break;
            }

            while(true) {
               if(var10000 == 0) {
                  continue label84;
               }

               var8 = var10.a();
               var9 = var8.b();
               var3 = var8.c();
               var4 = var3.d();
               var10000 = this.e[var9];
               if(var11) {
                  break;
               }

               if(var11) {
                  break label84;
               }

               if(var10000 > 0 && !var12[var4]) {
                  var12[var4] = true;
                  var7.add(var3);
               }

               var10.g();
               if(var11) {
                  break label81;
               }

               var10000 = var10.f();
            }
         }

         var10000 = var12[this.k.d()];
         break;
      }

      if(var10000 != 0) {
         System.err.println("checkMaxFlow: t reachable from s!");
         return false;
      } else {
         return true;
      }
   }
}
