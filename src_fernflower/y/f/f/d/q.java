package y.f.f.d;

import java.util.ArrayList;
import y.f.f.d.I;
import y.f.f.d.N;
import y.f.f.d.a;
import y.f.f.d.o;
import y.f.f.d.r;
import y.f.f.d.u;
import y.f.f.d.v;

public class q implements v {
   protected a[] a;
   private y.c.i h;
   private int[] i;
   private int[] j;
   private int[] k;
   private int[] l;
   private int[] m;
   private int n;
   private int o;
   private I p;
   private ArrayList q;
   private y.c.d[] r;
   private y.c.d[] s;
   private int[] t;
   Object[] b;
   int c;
   y.c.q d;
   y.c.q e;
   y.c.h f;
   u[] g;

   public int a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.h var4, y.c.h var5, int var6, ArrayList var7, ArrayList var8, y.c.h var9, y.c.h var10) {
      try {
         return this.b(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      } catch (r var13) {
         N var12 = new N();
         return var12.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }
   }

   protected int b(y.c.i var1, y.c.q var2, y.c.q var3, y.c.h var4, y.c.h var5, int var6, ArrayList var7, ArrayList var8, y.c.h var9, y.c.h var10) {
      boolean var24 = o.p;
      this.c = var6;
      this.d = var2;
      this.e = var3;
      this.n = var1.h();
      this.o = var1.f();
      this.h = var1;
      this.i = new int[this.n];
      this.j = new int[this.n];
      this.k = new int[this.o];
      this.l = new int[this.o];
      this.m = new int[this.n];
      this.b = new Object[this.o];
      this.t = new int[this.n];
      this.r = new y.c.d[this.n];
      this.s = new y.c.d[this.n];
      this.f = var4;
      this.a = new a[this.n];
      this.q = new ArrayList(var1.f());
      this.p = new I(this.o);
      int var11 = 0;

      y.c.d var14;
      int var15;
      int var10000;
      y.c.e var34;
      label316:
      while(true) {
         var10000 = var11;

         label313:
         while(var10000 < var7.size()) {
            a var12 = (a)var7.get(var11);
            var34 = var12.b();
            if(var24) {
               break label316;
            }

            y.c.e var13 = var34;

            while(var13.f()) {
               var14 = var13.a();
               var15 = var14.b();
               this.a[var14.b()] = var12;
               this.i[var15] = var12.a();
               var10000 = this.i[var15];
               if(var24) {
                  continue label313;
               }

               if(var10000 < 0) {
                  throw new y.c.B("found negative capacity");
               }

               var13.g();
               if(var24) {
                  break;
               }
            }

            ++var11;
            if(!var24) {
               continue label316;
            }
            break;
         }

         var34 = this.h.p();
         break;
      }

      y.c.e var25 = var34;

      while(true) {
         if(var25.f()) {
            y.c.d var27 = var25.a();
            this.r[var27.b()] = (y.c.d)var10.b(var27);
            this.s[var27.b()] = (y.c.d)var9.b(var27);
            var25.g();
            if(var24) {
               break;
            }

            if(!var24) {
               continue;
            }
         }

         this.g = new u[this.o];
         break;
      }

      y.c.x var26 = var1.o();

      while(true) {
         q var35;
         if(var26.f()) {
            y.c.q var28 = var26.e();
            var35 = this;
            if(!var24) {
               this.g[var28.d()] = new u(var28, var28.d());
               var26.g();
               if(!var24) {
                  continue;
               }

               var35 = this;
            }
         } else {
            var35 = this;
         }

         while(true) {
            int var30 = var35.a();
            int var29 = 0;
            int var32 = 0;

            label280:
            while(true) {
               var10000 = var32;
               int var10001 = var8.size();

               label278:
               while(true) {
                  Object var31;
                  Object var36;
                  if(var10000 < var10001) {
                     var36 = var8.get(var32);
                  } else {
                     if(var29 > 0) {
                        break label280;
                     }

                     var36 = this.h.p();
                     if(!var24) {
                        var31 = var36;

                        while(true) {
                           if(((y.c.e)var31).f()) {
                              var14 = ((y.c.e)var31).a();
                              var10000 = var14.b();
                              if(var24) {
                                 break;
                              }

                              var15 = var10000;
                              var5.a(var14, this.m[var15]);
                              ((y.c.e)var31).g();
                              if(!var24) {
                                 continue;
                              }
                           }

                           var10000 = var30;
                           break;
                        }

                        return var10000;
                     }
                  }

                  label276:
                  do {
                     do {
                        ArrayList var33 = (ArrayList)var36;
                        boolean var16 = false;
                        int var17 = 0;
                        int var18 = 0;
                        if(!var24) {
                           int var19 = 0;

                           a var20;
                           while(var19 < var33.size()) {
                              var20 = (a)var33.get(var19);
                              var10000 = this.m[var20.b[0].b()];
                              var10001 = 1;
                              if(var24) {
                                 continue label278;
                              }

                              if(var10000 == 1 && this.m[var20.b[1].b()] == 1) {
                                 ++var29;
                                 y.c.d var21 = this.s[var20.b[0].b()];
                                 int var22 = 0;

                                 int var23;
                                 while(true) {
                                    if(this.m[var21.b()] == 1) {
                                       var22 += var4.a(this.a[var21.b()].b(var21));
                                       var21 = this.s[var21.b()];
                                       if(!var24) {
                                          if(!var24) {
                                             continue;
                                          }

                                          var22 += var4.a(this.a[var21.b()].b(var21));
                                          var23 = 0;
                                          var21 = this.s[var20.b[1].b()];
                                          break;
                                       }

                                       var23 = 0;
                                       var21 = this.s[var20.b[1].b()];
                                       break;
                                    }

                                    var22 += var4.a(this.a[var21.b()].b(var21));
                                    var23 = 0;
                                    var21 = this.s[var20.b[1].b()];
                                    break;
                                 }

                                 while(true) {
                                    if(this.m[var21.b()] == 1) {
                                       var23 += var4.a(this.a[var21.b()].b(var21));
                                       var21 = this.s[var21.b()];
                                       if(var24) {
                                          break;
                                       }

                                       if(!var24) {
                                          continue;
                                       }

                                       var23 += var4.a(this.a[var21.b()].b(var21));
                                       break;
                                    }

                                    var23 += var4.a(this.a[var21.b()].b(var21));
                                    break;
                                 }

                                 if(var23 <= 400) {
                                    if(var22 > 400) {
                                       if(var23 < var22) {
                                          this.a(var20);
                                          if(var24) {
                                             this.b(var20);
                                             var16 = true;
                                          } else {
                                             var16 = true;
                                          }
                                       } else {
                                          this.b(var20);
                                          var16 = true;
                                       }

                                       var18 += var23;
                                       var17 += var22;
                                    } else {
                                       var18 += var23;
                                       var17 += var22;
                                    }
                                 } else {
                                    if(var23 < var22) {
                                       this.a(var20);
                                       if(var24) {
                                          this.b(var20);
                                          var16 = true;
                                       } else {
                                          var16 = true;
                                       }
                                    } else {
                                       this.b(var20);
                                       var16 = true;
                                    }

                                    var18 += var23;
                                    var17 += var22;
                                 }
                              }

                              ++var19;
                              if(var24) {
                                 break;
                              }
                           }

                           if(var16) {
                              ++var32;
                              if(!var24) {
                                 continue label280;
                              }

                              var10000 = var29;
                           } else {
                              label338: {
                                 var19 = 0;

                                 while(var19 < var33.size()) {
                                    var20 = (a)var33.get(var19);
                                    var10000 = this.m[var20.b[0].b()];
                                    var10001 = 1;
                                    if(var24) {
                                       continue label278;
                                    }

                                    if(var10000 == 1 && this.m[var20.b[1].b()] == 1) {
                                       if(var18 < var17) {
                                          this.a(var20);
                                          if(var24) {
                                             this.b(var20);
                                          }
                                       } else {
                                          this.b(var20);
                                       }
                                    }

                                    ++var19;
                                    if(var24) {
                                       ++var32;
                                       if(!var24) {
                                          continue label280;
                                       }

                                       var10000 = var29;
                                       break label338;
                                    }
                                 }

                                 ++var32;
                                 if(!var24) {
                                    continue label280;
                                 }

                                 var10000 = var29;
                              }
                           }

                           if(var10000 > 0) {
                              break label280;
                           }

                           var36 = this.h.p();
                           continue label276;
                        }

                        if(0 > 0) {
                           break label280;
                        }

                        var36 = this.h.p();
                     } while(var24);

                     var31 = var36;

                     while(true) {
                        if(((y.c.e)var31).f()) {
                           var14 = ((y.c.e)var31).a();
                           var10000 = var14.b();
                           if(var24) {
                              break;
                           }

                           var15 = var10000;
                           var5.a(var14, this.m[var15]);
                           ((y.c.e)var31).g();
                           if(!var24) {
                              continue;
                           }
                        }

                        var10000 = var30;
                        break;
                     }

                     return var10000;
                  } while(var24);

                  var31 = var36;

                  while(true) {
                     if(((y.c.e)var31).f()) {
                        var14 = ((y.c.e)var31).a();
                        var10000 = var14.b();
                        if(var24) {
                           break;
                        }

                        var15 = var10000;
                        var5.a(var14, this.m[var15]);
                        ((y.c.e)var31).g();
                        if(!var24) {
                           continue;
                        }
                     }

                     var10000 = var30;
                     break;
                  }

                  return var10000;
               }
            }

            var35 = this;
         }
      }
   }

   protected void a(a var1) {
      boolean var3 = o.p;
      y.c.d var2 = var1.b[0];

      while(true) {
         if(this.m[var2.b()] == 1) {
            this.i[this.a[var2.b()].b(var2).b()] = 0;
            var2 = this.s[var2.b()];
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var2 = this.r[var1.b[0].b()];
         break;
      }

      while(this.m[this.a[var2.b()].b(var2).b()] == 1) {
         this.i[this.a[var2.b()].b(var2).b()] = 0;
         var2 = this.r[var2.b()];
         if(var3) {
            break;
         }
      }

   }

   protected void b(a var1) {
      boolean var3 = o.p;
      y.c.d var2 = var1.b[1];

      while(true) {
         if(this.m[var2.b()] == 1) {
            this.i[this.a[var2.b()].b(var2).b()] = 0;
            var2 = this.s[var2.b()];
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var2 = this.r[var1.b[1].b()];
         break;
      }

      while(this.m[this.a[var2.b()].b(var2).b()] == 1) {
         this.i[this.a[var2.b()].b(var2).b()] = 0;
         var2 = this.r[var2.b()];
         if(var3) {
            break;
         }
      }

   }

   protected int a() {
      boolean var8 = o.p;
      int var1 = this.c;
      y.c.e var2 = this.h.p();

      int var10000;
      while(true) {
         if(var2.f()) {
            y.c.d var3 = var2.a();
            var10000 = var3.b();
            if(var8) {
               break;
            }

            int var4 = var10000;
            this.j[var4] = this.f.a(var3);
            this.t[var4] = this.i[var4];
            this.m[var4] = 0;
            var2.g();
            if(!var8) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var9 = var10000;

      int var13;
      q var15;
      label127: {
         label103:
         while(true) {
            if(var9 < this.o) {
               this.l[var9] = 0;
               ++var9;
               if(var8) {
                  break;
               }

               if(!var8) {
                  continue;
               }
            }

            while(true) {
               if(var1 >= 1) {
                  this.a(this.d, this.e, this.j, this.t, this.m, this.b);
                  int var10 = var1;
                  var15 = this;
                  if(var8) {
                     break label127;
                  }

                  y.c.q var11 = this.e;

                  label96:
                  while(true) {
                     y.c.q var16 = var11;
                     y.c.q var10001 = this.d;

                     label94:
                     while(true) {
                        y.c.d var6;
                        int var7;
                        label81: {
                           if(var16 != var10001) {
                              Object var5 = this.b[var11.d()];
                              if(!(var5 instanceof y.c.d)) {
                                 throw new r();
                              }

                              label77: {
                                 var6 = (y.c.d)var5;
                                 var7 = var6.b();
                                 if(var11 == var6.d()) {
                                    var9 = this.t[var7];
                                    var11 = var6.c();
                                    if(!var8) {
                                       break label77;
                                    }
                                 }

                                 var9 = this.m[var7];
                                 var11 = var6.d();
                                 if(var8) {
                                    throw new r();
                                 }
                              }

                              if(var9 >= var10) {
                                 break;
                              }

                              var10 = var9;
                              if(var8) {
                                 break label81;
                              }

                              if(!var8) {
                                 break;
                              }
                           }

                           var11 = this.e;
                        }

                        while(true) {
                           do {
                              if(var11 == this.d) {
                                 break label96;
                              }

                              var13 = var11.d();
                              var6 = (y.c.d)this.b[var13];
                              var7 = var6.b();
                              var16 = var11;
                              var10001 = var6.d();
                              if(var8) {
                                 continue label94;
                              }

                              if(var11 != var10001) {
                                 break;
                              }

                              this.m[var7] += var10;
                              this.t[var7] -= var10;
                              var11 = var6.c();
                           } while(!var8);

                           this.m[var7] -= var10;
                           this.t[var7] += var10;
                           var11 = var6.d();
                           if(var8) {
                              break label96;
                           }
                        }
                     }
                  }

                  var1 -= var10;
                  if(!var8) {
                     continue;
                  }
               }

               var9 = 0;
               break label103;
            }
         }

         var15 = this;
      }

      y.c.e var12 = var15.h.p();

      while(true) {
         if(var12.f()) {
            y.c.d var14 = var12.a();
            var13 = var14.b();
            var10000 = var9 + this.m[var13] * this.j[var13];
            if(var8) {
               break;
            }

            var9 = var10000;
            var12.g();
            if(!var8) {
               continue;
            }
         }

         var10000 = var9;
         break;
      }

      return var10000;
   }

   private void a(y.c.q var1, y.c.q var2, int[] var3, int[] var4, int[] var5, Object[] var6) {
      boolean var16 = o.p;
      this.p.a();
      int var7 = 0;

      while(true) {
         if(var7 < this.o) {
            this.k[var7] = Integer.MAX_VALUE;
            var6[var7] = null;
            ++var7;
            if(var16) {
               break;
            }

            if(!var16) {
               continue;
            }
         }

         this.q.clear();
         this.k[var1.d()] = 0;
         break;
      }

      this.p.a(0, this.g[var1.d()]);

      int var11;
      int var15;
      int var10000;
      label100:
      while(true) {
         if(!this.p.c()) {
            u var14 = this.p.b();
            this.p.a(var14);
            y.c.q var17 = var14.b;
            int var10 = var14.c;
            this.q.add(var17);
            if(var2 != var17) {
               var10000 = this.k[var10];
               int var10001 = this.l[var10];

               label95:
               while(true) {
                  y.c.q var8;
                  y.c.d var9;
                  int var12;
                  int var13;
                  label76:
                  while(true) {
                     var15 = var10000 + var10001;
                     var9 = var17.f();

                     while(true) {
                        if(var9 == null) {
                           break label76;
                        }

                        var12 = var9.b();
                        var10000 = var4[var12];
                        var10001 = 1;
                        if(var16) {
                           break;
                        }

                        if(var10000 >= 1) {
                           var8 = var9.d();
                           var11 = var8.d();
                           var13 = var15 - this.l[var11] + var3[var12];
                           if(var13 < this.k[var11]) {
                              label70: {
                                 if(this.k[var11] == Integer.MAX_VALUE) {
                                    this.p.a(var13, this.g[var11]);
                                    if(!var16) {
                                       break label70;
                                    }
                                 }

                                 this.p.a(this.g[var11], var13);
                              }

                              this.k[var11] = var13;
                              var6[var11] = var9;
                           }
                        }

                        var9 = var9.g();
                        if(var16) {
                           break label76;
                        }
                     }
                  }

                  var9 = var17.g();

                  while(true) {
                     if(var9 == null) {
                        continue label100;
                     }

                     var12 = var9.b();
                     var10000 = var5[var12];
                     if(var16) {
                        break label100;
                     }

                     var10001 = 1;
                     if(var16) {
                        break;
                     }

                     if(var10000 >= 1) {
                        var8 = var9.c();
                        var11 = var8.d();
                        var13 = var15 - this.l[var11] - var3[var12];
                        if(var13 < this.k[var11]) {
                           label89: {
                              if(this.k[var11] == Integer.MAX_VALUE) {
                                 this.p.a(var13, this.g[var11]);
                                 if(!var16) {
                                    break label89;
                                 }
                              }

                              this.p.a(this.g[var11], var13);
                           }

                           this.k[var11] = var13;
                           var6[var11] = var9;
                        }
                     }

                     var9 = var9.h();
                     if(var16) {
                        break label95;
                     }
                  }
               }
            }
         }

         var10000 = this.k[var2.d()];
         break;
      }

      int var18 = var10000;
      if(var18 != 0) {
         var15 = 0;

         while(var15 < this.q.size()) {
            var11 = ((y.c.q)this.q.get(var15)).d();
            this.l[var11] += this.k[var11] - var18;
            ++var15;
            if(var16) {
               break;
            }
         }

      }
   }
}
