package y.f.f.d;

import java.util.ArrayList;
import y.f.f.d.O;
import y.f.f.d.a;
import y.f.f.d.o;
import y.f.f.d.v;

public class N implements v {
   private y.c.i a;
   private int[] b;
   private int[] c;
   private int[] d;
   private int[] e;
   private int[] f;
   private a[] g;
   private int h;
   private int i;
   private O j = new O();
   private y.g.a.g k;
   private y.c.A l;
   private ArrayList m;
   private ArrayList n;
   private y.c.d[] o;
   private y.c.d[] p;
   private y.c.d[][] q;
   private y.c.d[][] r;

   public int a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.h var4, y.c.h var5, int var6, ArrayList var7, ArrayList var8, y.c.h var9, y.c.h var10) {
      boolean var20 = o.p;
      this.h = var1.h();
      this.i = var1.f();
      this.a = var1;
      this.b = new int[this.h];
      this.c = new int[this.h];
      this.d = new int[this.i];
      this.g = new a[this.h];
      this.e = new int[this.i];
      this.f = new int[this.h];
      Object[] var11 = new Object[this.i];
      int[] var12 = new int[this.h];
      this.o = new y.c.d[this.h];
      this.p = new y.c.d[this.h];
      this.q = new y.c.d[2][4];
      this.r = new y.c.d[2][4];
      this.n = var8;
      this.m = new ArrayList(var1.f());
      this.j.a();
      this.k = new y.g.a.d(var1);
      int var13 = 0;

      y.c.e var15;
      int var10000;
      y.c.d var16;
      int var17;
      y.c.e var25;
      label138:
      while(true) {
         var10000 = var13;

         label135:
         while(var10000 < var7.size()) {
            a var14 = (a)var7.get(var13);
            var25 = var14.b();
            if(var20) {
               break label138;
            }

            var15 = var25;

            while(var15.f()) {
               var16 = var15.a();
               var17 = var16.b();
               this.g[var17] = var14;
               this.b[var17] = var14.a();
               var10000 = this.b[var17];
               if(var20) {
                  continue label135;
               }

               if(var10000 < 0) {
                  throw new y.c.B("found negative capacity");
               }

               var15.g();
               if(var20) {
                  break;
               }
            }

            ++var13;
            if(!var20) {
               continue label138;
            }
            break;
         }

         var13 = var6;
         var25 = this.a.p();
         break;
      }

      y.c.e var21 = var25;

      int var22;
      label157: {
         label113:
         while(true) {
            if(var21.f()) {
               y.c.d var23 = var21.a();
               int var26 = var23.b();
               this.c[var26] = var4.a(var23);
               var12[var26] = this.b[var26];
               this.o[var23.b()] = (y.c.d)var10.b(var23);
               this.p[var23.b()] = (y.c.d)var9.b(var23);
               var21.g();
               if(var20) {
                  break;
               }

               if(!var20) {
                  continue;
               }
            }

            while(true) {
               if(var13 < 1) {
                  break label113;
               }

               ++this.j.a;
               this.a(var2, var3, this.c, var12, this.f, var11);
               var10000 = var13;
               if(var20) {
                  break label157;
               }

               int var24 = var13;
               y.c.q var27 = var3;

               label109:
               while(true) {
                  y.c.q var29 = var27;
                  y.c.q var10001 = var2;

                  label106:
                  while(true) {
                     y.c.d var18;
                     int var19;
                     label87: {
                        if(var29 != var10001) {
                           Object var28 = var11[var27.d()];
                           if(!(var28 instanceof y.c.d)) {
                              throw new RuntimeException("Unknown predecesor type !");
                           }

                           label83: {
                              var18 = (y.c.d)var28;
                              var19 = var18.b();
                              if(var27 == var18.d()) {
                                 var22 = var12[var19];
                                 var27 = var18.c();
                                 if(!var20) {
                                    break label83;
                                 }
                              }

                              var22 = this.f[var19];
                              var27 = var18.d();
                              if(var20) {
                                 throw new RuntimeException("Unknown predecesor type !");
                              }
                           }

                           if(var22 >= var24) {
                              continue label109;
                           }

                           var24 = var22;
                           if(var20) {
                              break label87;
                           }

                           if(!var20) {
                              continue label109;
                           }
                        }

                        var27 = var3;
                     }

                     while(true) {
                        do {
                           do {
                              if(var27 == var2) {
                                 break label106;
                              }

                              var17 = var27.d();
                           } while(!(var11[var17] instanceof y.c.d));

                           var18 = (y.c.d)var11[var17];
                           var19 = var18.b();
                           var29 = var27;
                           var10001 = var18.d();
                           if(var20) {
                              continue label106;
                           }

                           if(var27 != var10001) {
                              break;
                           }

                           this.f[var19] += var24;
                           this.g[var19].d += var24;
                           var12[var19] -= var24;
                           var27 = var18.c();
                        } while(!var20);

                        this.f[var19] -= var24;
                        var12[var19] += var24;
                        var27 = var18.d();
                        if(var20) {
                           break label106;
                        }
                     }
                  }

                  var13 -= var24;
                  this.a();
                  if(var20) {
                     break label113;
                  }
                  break;
               }
            }
         }

         var10000 = 0;
      }

      var22 = var10000;
      var15 = this.a.p();

      while(true) {
         if(var15.f()) {
            var16 = var15.a();
            var17 = var16.b();
            var22 += this.f[var17] * this.c[var17];
            var5.a(var16, this.f[var17]);
            var15.g();
            if(var20) {
               break;
            }

            if(!var20) {
               continue;
            }
         }

         this.j.b();
         break;
      }

      return var22;
   }

   private void a(y.c.q var1, y.c.q var2, int[] var3, int[] var4, int[] var5, Object[] var6) {
      boolean var16 = o.p;
      this.k.d();
      int var7 = 0;

      while(true) {
         if(var7 < this.i) {
            this.d[var7] = Integer.MAX_VALUE;
            var6[var7] = null;
            ++var7;
            if(var16) {
               break;
            }

            if(!var16) {
               continue;
            }
         }

         this.m.clear();
         this.d[var1.d()] = 0;
         break;
      }

      this.k.a(var1, 0);

      int var11;
      int var14;
      int var10000;
      label123:
      while(true) {
         if(!this.k.a()) {
            ++this.j.b;
            y.c.q var17 = this.k.c();
            int var10 = var17.d();
            this.m.add(var17);
            if(var2 != var17) {
               var10000 = this.d[var10];
               int var10001 = this.e[var10];

               label118:
               while(true) {
                  y.c.q var8;
                  y.c.d var9;
                  int var12;
                  int var13;
                  label96:
                  while(true) {
                     var14 = var10000 + var10001;
                     var9 = var17.f();

                     while(true) {
                        if(var9 == null) {
                           break label96;
                        }

                        var12 = var9.b();
                        var10000 = var4[var12];
                        var10001 = 1;
                        if(var16) {
                           break;
                        }

                        if(var10000 >= 1 && this.g[var12].d != this.g[var12].c) {
                           var8 = var9.d();
                           var11 = var8.d();
                           var13 = var14 - this.e[var11] + var3[var12];
                           if(var13 < this.d[var11]) {
                              label138: {
                                 if(this.d[var11] == Integer.MAX_VALUE) {
                                    if(var13 < 0) {
                                       y.g.o.a((Object)("insert: Out edges smaller 0: " + this.l.b(var17) + " -> " + this.l.b(var8) + " : " + var13));
                                       if(!var16) {
                                          break label138;
                                       }
                                    }

                                    this.k.a(var8, var13);
                                    if(!var16) {
                                       break label138;
                                    }
                                 }

                                 if(var13 < 0) {
                                    y.g.o.a((Object)("decrease: Out edges smaller 0: " + this.l.b(var17) + " -> " + this.l.b(var8) + " : " + var13));
                                    if(!var16) {
                                       break label138;
                                    }
                                 }

                                 this.k.b(var8, var13);
                              }

                              this.d[var11] = var13;
                              var6[var11] = var9;
                           }
                        }

                        var9 = var9.g();
                        if(var16) {
                           break label96;
                        }
                     }
                  }

                  var9 = var17.g();

                  while(true) {
                     if(var9 == null) {
                        continue label123;
                     }

                     var12 = var9.b();
                     var10000 = var5[var12];
                     if(var16) {
                        break label123;
                     }

                     var10001 = 1;
                     if(var16) {
                        break;
                     }

                     if(var10000 >= 1 && this.g[var12].b().k() <= 1) {
                        var8 = var9.c();
                        var11 = var8.d();
                        var13 = var14 - this.e[var11] - var3[var12];
                        if(var13 < 0) {
                           y.g.o.a((Object)("In edges smaller 0: " + var13));
                        }

                        if(var13 < this.d[var11]) {
                           label112: {
                              if(this.d[var11] == Integer.MAX_VALUE) {
                                 this.k.a(var8, var13);
                                 if(!var16) {
                                    break label112;
                                 }
                              }

                              this.k.b(var8, var13);
                           }

                           this.d[var11] = var13;
                           var6[var11] = var9;
                        }
                     }

                     var9 = var9.h();
                     if(var16) {
                        break label118;
                     }
                  }
               }
            }
         }

         var14 = this.d[var2.d()];
         var10000 = var14;
         break;
      }

      if(var10000 != 0) {
         int var15 = 0;

         while(var15 < this.m.size()) {
            var11 = ((y.c.q)this.m.get(var15)).d();
            this.e[var11] += this.d[var11] - var14;
            ++var15;
            if(var16) {
               break;
            }
         }

      }
   }

   public void a() {
      boolean var14 = o.p;
      int var1 = 0;

      while(var1 < this.n.size()) {
         Object var10000 = this.n.get(var1);

         label124:
         while(true) {
            ArrayList var2 = (ArrayList)var10000;
            if(var2.size() == 0) {
               break;
            }

            a var3 = (a)var2.get(0);
            y.c.d var4 = var3.b().a();
            y.c.d var5 = null;
            y.c.d var6 = null;
            int var7 = 0;

            label122:
            while(true) {
               if(this.f[var4.b()] > 0) {
                  var6 = var4;
               }

               y.c.d var15 = var6;

               do {
                  if(var15 != null && this.f[this.a(var4).b()] > 0) {
                     var5 = this.a(var4);
                  }

                  var4 = this.o[var4.b()];
                  ++var7;
                  if(var5 == null && var7 < var2.size() + 3) {
                     continue label122;
                  }

                  var15 = var5;
               } while(var14);

               if(var5 == null) {
                  break label124;
               }

               int var8 = 0;
               this.q[0][0] = var5;
               this.r[0][0] = var5;
               int var11 = 0;
               var4 = this.p[var5.b()];

               int var16;
               while(true) {
                  if(var4 != var5) {
                     var16 = var11;
                     if(var14) {
                        break;
                     }

                     y.c.d var9;
                     y.c.d var10;
                     label106: {
                        if(var11 == 0) {
                           var9 = var4;
                           var10 = this.a(var4);
                           if(!var14) {
                              break label106;
                           }
                        }

                        var10 = var4;
                        var9 = this.a(var4);
                     }

                     if(this.f[var9.b()] > 0) {
                        this.r[var11][var8] = var9;
                     }

                     if(this.f[var10.b()] > 0) {
                        var8 += var11;
                        if(var8 > 3) {
                           throw new RuntimeException("Too many intervals !!!!");
                        }

                        var11 = 1 - var11;
                        this.q[var11][var8] = var10;
                        this.r[var11][var8] = var10;
                     }

                     var4 = this.p[var4.b()];
                     if(!var14) {
                        continue;
                     }
                  }

                  var16 = var8;
                  break;
               }

               if(var16 != 3) {
                  break label124;
               }

               int var12 = 0;

               while(true) {
                  if(var12 >= 4) {
                     break label124;
                  }

                  var10000 = this.q[0][var12];
                  if(var14) {
                     continue label124;
                  }

                  Object var13 = var10000;

                  label82: {
                     while(var13 != this.r[0][var12]) {
                        this.c[this.a((y.c.d)var13).b()] = 10000;
                        var13 = this.p[((y.c.d)var13).b()];
                        if(var14) {
                           break label82;
                        }

                        if(var14) {
                           break;
                        }
                     }

                     var13 = this.r[1][var12];
                  }

                  label92: {
                     while(var13 != this.q[1][var12]) {
                        this.c[this.a((y.c.d)var13).b()] = 10000;
                        var13 = this.o[((y.c.d)var13).b()];
                        if(var14) {
                           break label92;
                        }

                        if(var14) {
                           break;
                        }
                     }

                     ++var12;
                  }

                  if(var14) {
                     break label124;
                  }
               }
            }
         }

         ++var1;
         if(var14) {
            break;
         }
      }

   }

   private y.c.d a(y.c.d var1) {
      y.c.d[] var2 = this.g[var1.b()].c();
      return var2[0] != var1?var2[0]:var2[1];
   }
}
