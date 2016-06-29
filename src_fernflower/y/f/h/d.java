package y.f.h;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.f.X;
import y.f.ae;
import y.f.h.D;
import y.f.h.N;
import y.f.h.c;
import y.f.h.e;
import y.f.h.f;
import y.f.h.g;
import y.f.h.h;
import y.f.h.n;
import y.f.h.o;
import y.f.h.p;
import y.f.h.q;

public class d implements o {
   private static final ArrayList a = new ArrayList();
   private D b;
   private boolean c = false;
   private y.c.h d;
   private y.c.A e;

   public void a(D var1) {
      this.b = var1;
   }

   public void a(y.c.h var1) {
      this.d = var1;
   }

   public void a(y.c.A var1) {
      this.e = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public void c() {
      boolean var17 = N.d;
      if(this.b != null) {
         X var1 = (X)this.b.g();
         y.c.y var2 = new y.c.y();
         y.c.A var3 = y.g.M.a();
         y.c.x var6;
         y.c.q var7;
         y.c.e var9;
         boolean var10000;
         y.c.q var22;
         y.c.e var26;
         y.c.e var30;
         y.c.d var33;
         if(this.e != null) {
            label347: {
               y.g.a.d var4 = new y.g.a.d(var1);
               int var5 = var1.h();
               var6 = var1.o();

               label340:
               while(true) {
                  var10000 = var6.f();

                  label338:
                  while(true) {
                     if(var10000) {
                        var7 = var6.e();
                        var10000 = this.e.d(var7);
                        if(!var17) {
                           if(var10000) {
                              int var8 = 0;
                              var9 = var7.j();

                              while(var9.f()) {
                                 y.c.q var10 = var9.a().a(var7);
                                 var10000 = this.e.d(var10);
                                 if(var17) {
                                    continue label338;
                                 }

                                 if(!var10000) {
                                    ++var8;
                                 }

                                 var9.g();
                                 if(var17) {
                                    break;
                                 }
                              }

                              var4.a(var7, var5 - var8);
                           }

                           var6.g();
                           if(!var17) {
                              break;
                           }

                           var10000 = var4.a();
                        }
                     } else {
                        var10000 = var4.a();
                     }

                     while(true) {
                        label334:
                        while(true) {
                           if(var10000) {
                              break label340;
                           }

                           var22 = var4.c();
                           var2.add(var22);
                           var26 = var22.j();

                           while(var26.f()) {
                              y.c.q var28 = var26.a().a(var22);
                              if(var17) {
                                 break label347;
                              }

                              var10000 = var4.a(var28);
                              if(var17) {
                                 continue label334;
                              }

                              if(var10000) {
                                 int var31 = var4.b(var28);
                                 var4.b(var28, var31 - 1);
                              }

                              var26.g();
                              if(var17) {
                                 break label340;
                              }
                           }

                           var10000 = var4.a();
                        }
                     }
                  }
               }

               y.c.p var23 = var2.l();

               while(var23 != null) {
                  var7 = (y.c.q)var23.c();
                  var3.a(var7, new y.c.f(var7.j()));
                  var30 = var7.j();

                  label291:
                  do {
                     var10000 = var30.f();

                     do {
                        if(!var10000) {
                           break label291;
                        }

                        var33 = var30.a();
                        var10000 = var1.f(var33);
                     } while(var17);

                     if(var10000) {
                        var1.d(var33);
                        if(this.d != null) {
                           this.d.a(var33, true);
                        }
                     }

                     var30.g();
                  } while(!var17);

                  var1.c(var7);
                  var23 = var23.b();
                  if(var17) {
                     break;
                  }
               }
            }
         }

         y.c.f var18;
         y.c.e var19;
         y.c.d var25;
         int var40;
         label275: {
            var18 = new y.c.f();
            if(this.d != null) {
               var19 = var1.p();

               while(var19.f()) {
                  var25 = var19.a();
                  var40 = this.d.d(var25);
                  if(var17) {
                     break label275;
                  }

                  if(var40 != 0 && var1.f(var25)) {
                     var1.d(var25);
                     var18.add(var25);
                  }

                  var19.g();
                  if(var17) {
                     break;
                  }
               }
            }

            var40 = var1.h();
         }

         if(var40 > 0) {
            this.a(var1, var18);
         }

         y.c.d var36;
         y.c.e var41;
         label356: {
            label357: {
               label259: {
                  label358: {
                     y.c.f var32;
                     if(var1.h() > 0) {
                        y.g.o.a(this, "==================== Route ====================");
                        n var20 = new n(this.b);
                        var6 = var2.a();

                        while(var6.f()) {
                           var7 = var6.e();
                           var1.d(var7);
                           var32 = (y.c.f)var3.b(var7);
                           var10000 = var32.isEmpty();
                           if(var17) {
                              break label259;
                           }

                           if(!var10000) {
                              var33 = null;
                              int var34 = Integer.MAX_VALUE;
                              y.c.D var11 = new y.c.D(this.b.h());
                              y.c.C var12 = var11.m();

                              label250:
                              do {
                                 var10000 = var12.f();

                                 y.c.d var14;
                                 label247:
                                 while(true) {
                                    if(!var10000) {
                                       break label250;
                                    }

                                    p var13 = (p)var12.d();
                                    var14 = null;
                                    var41 = var13.a();
                                    if(var17) {
                                       break label357;
                                    }

                                    y.c.e var15 = var41;

                                    while(true) {
                                       if(!var15.f()) {
                                          break label247;
                                       }

                                       y.c.d var16 = var15.a();
                                       var10000 = this.b.f(var16.d());
                                       if(var17) {
                                          break;
                                       }

                                       if(var10000) {
                                          var14 = var16;
                                          break label247;
                                       }

                                       var15.g();
                                    }
                                 }

                                 if(var14 != null) {
                                    y.c.d var38 = var1.a((y.c.q)var14.d(), (y.c.q)var7);
                                    this.b.a(var38, (y.c.d)var14, (y.c.d)null);
                                    int var39 = var20.b(var32);
                                    if(var39 < var34 || var39 == var34 && this.b.i(var38) == this.b.i()) {
                                       var34 = var39;
                                       var33 = var14;
                                    }

                                    this.b.a(var38);
                                    var1.e(var38);
                                    var1.a((y.c.d)var38);
                                    var1.e(this.b.h(var38));
                                    var1.a((y.c.d)this.b.h(var38));
                                 }

                                 var12.g();
                              } while(!var17);

                              y.c.d var37 = var1.a((y.c.q)var33.d(), (y.c.q)var7);
                              this.b.a(var37, (y.c.d)var33, (y.c.d)null);
                              var20.a(var32);
                              this.b.a(var37);
                              var1.e(var37);
                              var1.a((y.c.d)var37);
                              var1.e(this.b.h(var37));
                              var1.a((y.c.d)this.b.h(var37));
                           }

                           var6.g();
                           if(var17) {
                              break;
                           }
                        }

                        var20.a(var18);
                        if(!var17) {
                           break label358;
                        }
                     }

                     c var21 = new c();
                     y.c.e var27 = var18.a();

                     while(var27.f()) {
                        var1.e(var27.a());
                        var27.g();
                        if(var17) {
                           break label356;
                        }

                        if(var17) {
                           break;
                        }
                     }

                     var6 = var2.a();

                     label204:
                     do {
                        var10000 = var6.f();

                        label201:
                        while(true) {
                           if(!var10000) {
                              break label204;
                           }

                           var7 = var6.e();
                           var1.d(var7);
                           var32 = (y.c.f)var3.b(var7);
                           var41 = var32.a();
                           if(var17) {
                              break label357;
                           }

                           var9 = var41;

                           while(true) {
                              if(!var9.f()) {
                                 break label201;
                              }

                              var36 = var9.a();
                              var10000 = var1.f(var36);
                              if(var17) {
                                 break;
                              }

                              if(!var10000) {
                                 var1.e(var36);
                              }

                              var9.g();
                              if(var17) {
                                 break label201;
                              }
                           }
                        }

                        var6.g();
                     } while(!var17);

                     var21.a(this.b);
                     var21.c();
                  }

                  var10000 = this.b.o();
               }

               if(!var10000) {
                  y.g.o.a((Object)"Outer face");
                  this.b.b((p)this.b.i(var1.p().a()));
                  y.g.o.a((Object)("New Outer face: " + this.b.i()));
               }

               this.b.k();
               if(this.d == null) {
                  break label356;
               }

               var41 = var18.a();
            }

            var19 = var41;

            while(var19.f()) {
               var25 = var19.a();
               var26 = this.b.c(var25);

               label170: {
                  while(var26.f()) {
                     y.c.d var35 = var26.a();
                     this.d.a(var35, true);
                     this.d.a(this.b.h(var35), true);
                     var26.g();
                     if(var17) {
                        break label170;
                     }

                     if(var17) {
                        break;
                     }
                  }

                  var19.g();
               }

               if(var17) {
                  break;
               }
            }
         }

         y.c.x var24 = var2.a();

         while(var24.f()) {
            var22 = var24.e();
            y.c.f var29 = (y.c.f)var3.b(var22);
            var41 = var29.a();

            label152:
            while(true) {
               var30 = var41;

               while(true) {
                  if(!var30.f()) {
                     break label152;
                  }

                  var41 = this.b.c(var30.a());
                  if(var17) {
                     break;
                  }

                  var9 = var41;

                  label147: {
                     while(var9.f()) {
                        var36 = var9.a();
                        this.d.a(var36, true);
                        this.d.a(this.b.h(var36), true);
                        var9.g();
                        if(var17) {
                           break label147;
                        }

                        if(var17) {
                           break;
                        }
                     }

                     var30.g();
                  }

                  if(var17) {
                     break label152;
                  }
               }
            }

            var24.g();
            if(var17) {
               break;
            }
         }

      }
   }

   private void a(X var1, y.c.f var2) {
      boolean var41 = N.d;
      ae.d(var1);
      y.d.b.n var3 = y.d.b.n.f();
      y.g.o.a(this, "==================== Planarize ====================");
      y.c.A var4 = var1.t();
      y.c.A var5 = var1.t();
      y.c.h var6 = var1.u();
      HashMap var7 = new HashMap();
      y.c.x var8 = var1.o();

      double var12;
      double var10000;
      while(true) {
         if(var8.f()) {
            y.c.q var9 = var8.e();
            double var10 = var1.j(var9);
            var12 = var1.k(var9);
            var10000 = var10;
            if(var41) {
               break;
            }

            Object var14 = a(var10, var12, var3);
            var5.a(var9, var14);
            ArrayList var15 = (ArrayList)var7.get(var14);
            if(var15 == null) {
               var15 = new ArrayList();
               var7.put(var14, var15);
            }

            var15.add(var9);
            var8.g();
            if(!var41) {
               continue;
            }
         }

         var10000 = 1.0D;
         break;
      }

      double var42 = var10000;
      y.c.x var43 = var1.o();

      X var123;
      label919:
      while(true) {
         if(var43.f()) {
            y.c.q var11 = var43.e();
            var12 = Math.floor(var1.m(var11));
            double var52 = Math.floor(var1.n(var11));
            double var16 = Math.floor(var1.p(var11));
            var123 = var1;
            if(var41) {
               break;
            }

            double var18 = Math.floor(var1.q(var11));
            y.d.b.b[] var20 = new y.d.b.b[]{(y.d.b.b)var3.a(var12 - var42, var52 - var42), (y.d.b.b)var3.a(var12 + var16 + 2.0D * var42, var52 - var42), (y.d.b.b)var3.a(var12 + var16 + 2.0D * var42, var52 + var18 + 2.0D * var42), (y.d.b.b)var3.a(var12 - var42, var52 + var18 + 2.0D * var42)};
            int var21 = 0;

            while(var21 < var20.length) {
               var20[var21].g();
               ++var21;
               if(var41) {
                  continue label919;
               }

               if(var41) {
                  break;
               }
            }

            Object var68 = var3.a(var20);
            var4.a(var11, var68);
            var43.g();
            if(!var41) {
               continue;
            }
         }

         var123 = var1;
         break;
      }

      y.c.A var44 = var123.t();
      HashMap var45 = new HashMap(var7.size());
      Iterator var46 = var7.keySet().iterator();

      while(true) {
         if(var46.hasNext()) {
            Object var13 = var46.next();
            ArrayList var53 = (ArrayList)var7.get(var13);
            if(var41) {
               break;
            }

            int var56 = 1;

            label896: {
               while(var56 < var53.size()) {
                  y.c.q var57 = (y.c.q)var53.get(var56);
                  var44.a(var57, true);
                  ++var56;
                  if(var41) {
                     break label896;
                  }

                  if(var41) {
                     break;
                  }
               }

               var45.put(var13, var53.get(0));
            }

            if(!var41) {
               continue;
            }
         }

         var7 = var45;
         break;
      }

      y.c.e var47 = var1.p();

      while(var47.f()) {
         y.c.d var49 = var47.a();
         if(var44.d(var49.c()) || var44.d(var49.d())) {
            var2.add(var49);
            var1.d(var49);
         }

         var47.g();
         if(var41) {
            break;
         }
      }

      y.c.y var48 = new y.c.y();
      y.c.x var50 = var1.o();

      while(true) {
         if(var50.f()) {
            y.c.q var54 = var50.e();
            if(var41) {
               break;
            }

            if(var44.d(var54)) {
               var48.add(var54);
               var1.c(var54);
            }

            var50.g();
            if(!var41) {
               continue;
            }
         }

         var1.a((y.c.A)var44);
         a(var1);
         break;
      }

      y.c.D var51 = new y.c.D();
      HashMap var55 = new HashMap();
      y.c.e var58 = var1.p();

      Object var27;
      Object var125;
      boolean var126;
      while(true) {
         if(var58.f()) {
            y.c.d var59 = var58.a();
            ArrayList var17 = new ArrayList();
            Object var63 = var5.b(var59.c());
            Object var19 = var5.b(var59.d());
            var17.add(var63);
            Object var66 = var63;
            var125 = var1;
            if(var41) {
               break;
            }

            y.d.u var69 = var1.l(var59).b();

            label854: {
               while(var69.f()) {
                  y.d.t var22 = var69.a();
                  double var23 = var22.a();
                  double var25 = var22.b();
                  var27 = a(var23, var25, var3);
                  var126 = var27.equals(var66);
                  if(var41) {
                     break label854;
                  }

                  if(!var126) {
                     var17.add(var27);
                  }

                  var66 = var27;
                  var69.g();
                  if(var41) {
                     break;
                  }
               }

               var126 = var19.equals(var66);
            }

            if(!var126) {
               var17.add(var19);
            }

            ArrayList var70 = new ArrayList(var17.size() - 1);
            int var71 = 1;

            label842: {
               while(var71 < var17.size()) {
                  Object var75 = var3.c(var17.get(var71 - 1), var17.get(var71));
                  var51.add(var75);
                  var70.add(var75);
                  var55.put(f.a(var75), var59);
                  ++var71;
                  if(var41) {
                     break label842;
                  }

                  if(var41) {
                     break;
                  }
               }

               var6.a(var59, var70);
               var58.g();
            }

            if(!var41) {
               continue;
            }
         }

         var125 = new y.c.i();
         break;
      }

      Object var60 = var125;
      N var61 = new N((y.c.i)var60);
      y.c.A var62 = ((y.c.i)var60).t();
      y.c.h var64 = ((y.c.i)var60).u();
      y.d.a.a var65 = new y.d.a.a(var3);
      var65.a(var51, var61, var62, var64);
      y.c.h var67 = ((y.c.i)var60).u();
      y.c.A var72 = ((y.c.i)var60).t();
      y.c.e var73 = ((y.c.i)var60).p();

      y.c.h var127;
      while(true) {
         if(var73.f()) {
            y.c.d var76 = var73.a();
            Object var24 = var64.b(var76);
            y.c.d var80 = (y.c.d)var55.get(f.a(var24));
            var67.a(var76, var80);
            var127 = var67;
            if(var41) {
               break;
            }

            var67.a(var61.h(var76), var80);
            var73.g();
            if(!var41) {
               continue;
            }
         }

         var127 = var1.u();
         break;
      }

      y.c.h var74 = var127;
      y.c.h var77 = ((y.c.i)var60).u();
      y.c.x var78 = ((y.c.i)var60).o();

      y.c.e var33;
      y.c.d var93;
      y.c.e var95;
      y.c.d var107;
      Object var117;
      while(true) {
         if(var78.f()) {
            y.c.q var81 = var78.e();
            var126 = false;
            if(var41) {
               break;
            }

            int var26 = 0;
            y.c.q var128 = var81;

            label813: {
               label812:
               while(true) {
                  var27 = var128.l();

                  label739: {
                     while(((y.c.e)var27).f()) {
                        var77.a(((y.c.e)var27).a(), var26++);
                        ((y.c.e)var27).g();
                        if(var41) {
                           break label739;
                        }

                        if(var41) {
                           break;
                        }
                     }

                     var27 = var62.b(var81);
                  }

                  y.c.q var28 = (y.c.q)var7.get(var27);
                  if(var28 == null) {
                     boolean var29 = true;
                     y.c.d[] var30 = new y.c.d[var81.c()];
                     y.c.d[] var31 = new y.c.d[var81.b()];
                     int var32 = 0;
                     var33 = var81.l();

                     while(var33.f()) {
                        var30[var32++] = var33.a();
                        var33.g();
                        if(var41) {
                           break label813;
                        }

                        if(var41) {
                           break;
                        }
                     }

                     int var109 = 0;
                     y.c.e var34 = var81.k();

                     y.c.d var35;
                     label948: {
                        while(true) {
                           if(var34.f()) {
                              var31[var109++] = var34.a();
                              var34.g();
                              if(var41) {
                                 break;
                              }

                              if(!var41) {
                                 continue;
                              }
                           }

                           if(var81.c() == 2 && var81.b() == 2) {
                              if(var67.b(var30[0]) == var67.b(var30[1]) && var67.b(var31[0]) == var67.b(var31[1])) {
                                 break label948;
                              }

                              var29 = false;
                              if(!var41) {
                                 break label948;
                              }
                           }
                           break;
                        }

                        if(var81.c() == 4 && var81.b() == 4) {
                           if(var67.b(var30[0]) == var67.b(var30[2]) && var67.b(var30[1]) == var67.b(var30[3]) && var67.b(var30[0]) != var67.b(var30[1])) {
                              var29 = true;
                              if(!var41) {
                                 break label948;
                              }
                           }

                           var29 = false;
                           if(!var41) {
                              break label948;
                           }
                        }

                        var34 = var81.l();

                        while(var34.f()) {
                           var35 = (y.c.d)var67.b(var34.a());
                           var74.a(var35, true);
                           var34.g();
                           if(var41) {
                              break label813;
                           }

                           if(var41) {
                              break;
                           }
                        }
                     }

                     if(var29) {
                        break;
                     }

                     var34 = var81.l();

                     do {
                        if(!var34.f()) {
                           break label812;
                        }

                        var35 = (y.c.d)var67.b(var34.a());
                        var74.a(var35, true);
                        var34.g();
                        if(var41) {
                           break label813;
                        }
                     } while(!var41);
                  }

                  var95 = var81.l();

                  while(true) {
                     if(!var95.f()) {
                        break label812;
                     }

                     var72.a(var81, var28);
                     var93 = var95.a();
                     Object var100 = var64.b(var93);
                     var107 = (y.c.d)var67.b(var93);
                     ArrayList var112 = (ArrayList)var6.b(var107);
                     Object var115 = var112.get(0);
                     var117 = var112.get(var112.size() - 1);
                     var128 = var107.c();
                     if(var41) {
                        break;
                     }

                     boolean var36 = var128 == var28 && var100 == var115;
                     boolean var37 = var107.d() == var28 && var100 == var117;
                     if(!var36 && !var37) {
                        var74.a(var107, true);
                     }

                     var95.g();
                     if(var41) {
                        break label812;
                     }
                  }
               }

               var78.g();
            }

            if(!var41) {
               continue;
            }
         }

         var126 = true;
         break;
      }

      boolean var79 = var126;

      y.c.e var89;
      y.c.d var99;
      label952: {
         y.c.e var83;
         y.c.d var85;
         label1008: {
            q var86;
            p var87;
            Object[] var94;
            y.c.D var96;
            int var97;
            y.d.b.a var104;
            y.c.e var130;
            label717:
            while(true) {
               y.c.x var82;
               y.c.q var84;
               Object var91;
               y.c.q var92;
               if(var79) {
                  var79 = false;
                  var82 = ((y.c.i)var60).o();
                  if(!var82.f()) {
                     continue;
                  }

                  while(true) {
                     var84 = var82.e();
                     var125 = var72.b(var84);
                     if(var41) {
                        if(var125 == null) {
                           label645: {
                              var92 = var1.d();
                              var1.b(var92, 0.0D, 0.0D);
                              var5.a(var92, var62.b(var84));
                              var91 = var62.b(var84);
                              var1.a(var92, new y.d.t(var3.k(var91).e(), var3.l(var91).e()));
                              var72.a(var84, var92);
                              if(var84.c() == 4) {
                                 this.b.c(var92);
                                 if(!var41) {
                                    break label645;
                                 }
                              }

                              if(var84.c() == 2) {
                                 this.b.d(var92);
                              }
                           }
                        }

                        var82.g();
                        if(var41) {
                           break label717;
                        }
                        break;
                     }

                     if(var41) {
                        if(var125 == null) {
                           label664: {
                              var92 = var1.d();
                              var1.b(var92, 0.0D, 0.0D);
                              var5.a(var92, var62.b(var84));
                              var91 = var62.b(var84);
                              var1.a(var92, new y.d.t(var3.k(var91).e(), var3.l(var91).e()));
                              var72.a(var84, var92);
                              if(var84.c() == 4) {
                                 this.b.c(var92);
                                 if(!var41) {
                                    break label664;
                                 }
                              }

                              if(var84.c() == 2) {
                                 this.b.d(var92);
                              }
                           }
                        }

                        var82.g();
                        if(var41) {
                           break label717;
                        }
                        break;
                     }

                     if(var125 == null) {
                        int var88 = 0;
                        var89 = var84.l();

                        int var129;
                        while(true) {
                           if(var89.f()) {
                              var99 = (y.c.d)var67.b(var89.a());
                              var129 = var74.d(var99);
                              if(var41) {
                                 break;
                              }

                              if(var129 == 0) {
                                 ++var88;
                              }

                              var89.g();
                              if(!var41) {
                                 continue;
                              }

                              var129 = var88;
                              break;
                           }

                           var129 = var88;
                           break;
                        }

                        if(var129 != 4 && var88 != 2) {
                           var89 = var84.l();

                           while(true) {
                              if(!var89.f()) {
                                 ((y.c.i)var60).a(var84);
                                 var79 = true;
                                 break;
                              }

                              var99 = (y.c.d)var67.b(var89.a());
                              var74.a(var99, true);
                              var89.g();
                              if(var41) {
                                 var79 = true;
                                 break;
                              }

                              if(var41) {
                                 ((y.c.i)var60).a(var84);
                                 var79 = true;
                                 break;
                              }
                           }
                        }
                     }

                     var82.g();
                     if(var41) {
                        var83 = ((y.c.i)var60).p();

                        while(var83.f()) {
                           var85 = var83.a();
                           var126 = var74.d(var67.b(var85));
                           if(var41) {
                              break label1008;
                           }

                           if(var126) {
                              ((y.c.i)var60).a(var85);
                           }

                           var83.g();
                           if(var41) {
                              break;
                           }
                        }

                        var82 = ((y.c.i)var60).o();
                        break;
                     }

                     if(!var82.f()) {
                        continue label717;
                     }
                  }
               } else {
                  var83 = ((y.c.i)var60).p();

                  while(var83.f()) {
                     var85 = var83.a();
                     var126 = var74.d(var67.b(var85));
                     if(var41) {
                        break label1008;
                     }

                     if(var126) {
                        ((y.c.i)var60).a(var85);
                     }

                     var83.g();
                     if(var41) {
                        break;
                     }
                  }

                  var82 = ((y.c.i)var60).o();
               }

               while(true) {
                  if(!var82.f()) {
                     break label717;
                  }

                  var84 = var82.e();
                  if(var41) {
                     var86 = var61.h();

                     label965: {
                        label534:
                        while(var86.f()) {
                           var87 = var86.a();
                           var96 = new y.c.D();
                           var130 = var87.a();
                           if(var41) {
                              var83 = var130;
                              break label965;
                           }

                           var89 = var130;

                           while(var89.f()) {
                              var96.add(var62.b(var89.a().c()));
                              var89.g();
                              if(var41) {
                                 continue label534;
                              }

                              if(var41) {
                                 break;
                              }
                           }

                           var94 = var96.toArray();
                           var104 = new y.d.b.a(var94, true, var3);
                           var97 = var104.a();
                           if(var97 == 0) {
                              var61.b(var87);
                              if(!var41) {
                                 break;
                              }
                           }

                           var86.g();
                           if(var41) {
                              break;
                           }
                        }

                        if(var61.i() == null && var61.j() > 0) {
                           var61.b(var61.h().a());
                        }

                        var83 = var1.p();
                     }

                     var126 = var83.f();
                     break label1008;
                  }

                  if(var72.b(var84) == null) {
                     label596: {
                        var92 = var1.d();
                        var1.b(var92, 0.0D, 0.0D);
                        var5.a(var92, var62.b(var84));
                        var91 = var62.b(var84);
                        var1.a(var92, new y.d.t(var3.k(var91).e(), var3.l(var91).e()));
                        var72.a(var84, var92);
                        if(var84.c() == 4) {
                           this.b.c(var92);
                           if(!var41) {
                              break label596;
                           }
                        }

                        if(var84.c() == 2) {
                           this.b.d(var92);
                        }
                     }
                  }

                  var82.g();
                  if(var41) {
                     break label717;
                  }
               }
            }

            var61.l();
            var86 = var61.h();

            label511:
            while(var86.f()) {
               var87 = var86.a();
               var96 = new y.c.D();
               var130 = var87.a();
               if(var41) {
                  var83 = var130;
                  break label1008;
               }

               var89 = var130;

               while(var89.f()) {
                  var96.add(var62.b(var89.a().c()));
                  var89.g();
                  if(var41) {
                     continue label511;
                  }

                  if(var41) {
                     break;
                  }
               }

               var94 = var96.toArray();
               var104 = new y.d.b.a(var94, true, var3);
               var97 = var104.a();
               if(var97 == 0) {
                  var61.b(var87);
                  if(!var41) {
                     break;
                  }
               }

               var86.g();
               if(var41) {
                  break;
               }
            }

            if(var61.i() == null && var61.j() > 0) {
               var61.b(var61.h().a());
            }

            var83 = var1.p();
         }

         for(var126 = var83.f(); var126; var126 = var83.f()) {
            var85 = var83.a();
            var127 = var74;
            if(var41) {
               break label952;
            }

            if(var74.d(var85)) {
               var2.add(var85);
               var1.d(var85);
            }

            var83.g();
            if(var41) {
               break;
            }
         }

         var1.a((y.c.h)var74);
         var127 = var1.u();
      }

      y.c.h var98 = var127;
      y.c.h var90 = var1.u();
      y.c.h var101 = ((y.c.i)var60).u();
      var89 = ((y.c.i)var60).p();

      y.c.q var102;
      y.c.q var103;
      while(true) {
         if(var89.f()) {
            var99 = var89.a();
            var102 = (y.c.q)var72.b(var99.c());
            var103 = (y.c.q)var72.b(var99.d());
            var107 = null;
            var126 = var61.n(var99);
            if(var41) {
               break;
            }

            if(!var126) {
               if(this.b.f(var102) && this.b.f(var103)) {
                  var107 = (y.c.d)var67.b(var99);
               } else {
                  var107 = var1.a((y.c.q)var102, (y.c.q)var103);
               }

               var98.a(var107, var99);
               var101.a(var99, var107);
               var90.a(var107, var77.a(var99));
            }

            var89.g();
            if(!var41) {
               continue;
            }
         }

         var89 = ((y.c.i)var60).p();
         var126 = var89.f();
         break;
      }

      while(var126) {
         var99 = var89.a();
         var102 = (y.c.q)var72.b(var99.c());
         var103 = (y.c.q)var72.b(var99.d());
         var107 = null;
         if(var61.n(var99)) {
            var107 = var1.a((y.c.q)var102, (y.c.q)var103);
            this.b.m(var107);
            this.b.b(var107, (y.c.d)var101.b(var61.h(var99)));
            var98.a(var107, var99);
            var101.a(var99, var107);
            var90.a(var107, var77.a(var99));
         }

         var89.g();
         if(var41) {
            break;
         }

         var126 = var89.f();
      }

      y.c.f var105 = new y.c.f();
      var95 = var1.p();

      while(var95.f()) {
         var93 = var95.a();
         if(var98.b(var93) == null) {
            var105.add(var93);
            var1.d(var93);
         }

         var95.g();
         if(var41) {
            break;
         }
      }

      y.c.x var110 = var1.o();

      y.c.d var116;
      label440:
      do {
         var126 = var110.f();

         label437:
         while(true) {
            if(!var126) {
               break label440;
            }

            var102 = var110.e();
            if(!this.b.f(var102)) {
               break;
            }

            y.c.e var106 = var102.l();

            while(true) {
               if(!var106.f()) {
                  break label437;
               }

               var107 = var106.a();
               var126 = this.b.n(var107);
               if(var41) {
                  break;
               }

               if(!var126 && !this.b.f(var107.d())) {
                  y.c.f var113 = new y.c.f();
                  var125 = var67.b(var98.b(var107));

                  label431:
                  while(true) {
                     var116 = (y.c.d)var125;

                     while(true) {
                        if(this.b.f(var107.d())) {
                           break label431;
                        }

                        y.c.q var118 = var107.d();
                        var113.add(var107);
                        y.c.e var120 = var118.l();

                        while(var120.f()) {
                           var107 = var120.a();
                           var125 = var67.b(var98.b(var107));
                           if(var41 || var41) {
                              continue label431;
                           }

                           if(var125 == var116) {
                              break;
                           }

                           var120.g();
                           if(var41) {
                              break label431;
                           }
                        }
                     }
                  }

                  var113.add(var107);
                  this.b.a(var116, var113.e());
                  this.b.a(var116, var113, 0);
               }

               var106.g();
               if(var41) {
                  break label437;
               }
            }
         }

         var110.g();
      } while(!var41);

      g var111 = new g(var90);
      y.c.x var108 = var1.o();

      while(true) {
         if(var108.f()) {
            var103 = var108.e();
            var103.b((Comparator)var111);
            var108.g();
            if(var41) {
               break;
            }

            if(!var41) {
               continue;
            }
         }

         if(var61.i() != null) {
            this.b.l();
            var93 = var61.i().a().a();
            this.b.b((p)this.b.i((y.c.d)var101.b(var93)));
         }
         break;
      }

      label982: {
         label983: {
            if(this.c) {
               var108 = var1.o();

               label381:
               do {
                  if(!var108.f()) {
                     break label983;
                  }

                  var103 = var108.e();
                  var126 = this.b.f(var103);
                  if(var41) {
                     break label982;
                  }

                  if(var126) {
                     y.c.f var119 = new y.c.f(var103.l());
                     var33 = var119.a();

                     label375:
                     do {
                        var126 = var33.f();

                        y.d.t var121;
                        y.d.t var122;
                        label372:
                        while(true) {
                           if(!var126) {
                              break label375;
                           }

                           var116 = var33.a();
                           var5.b(var103);
                           var121 = null;
                           var122 = null;
                           if(var41) {
                              continue label381;
                           }

                           Object var38 = var4.b(var103);

                           while(true) {
                              if(!this.b.e(var116.d())) {
                                 break label372;
                              }

                              y.c.q var39 = var116.d();
                              var117 = var5.b(var39);
                              var126 = var3.d(var38, var117);
                              if(var41) {
                                 break;
                              }

                              if(!var126) {
                                 break label372;
                              }

                              y.c.d var40 = var116 == var39.g()?var39.i():var39.g();
                              var122 = var1.p(var40);
                              var116 = this.b.h(var39);
                              if(var116.c() != var103) {
                                 var116 = this.b.h(var116);
                              }

                              var121 = new y.d.t(var3.k(var117).e(), var3.l(var117).e());
                              if(var41) {
                                 break label372;
                              }
                           }
                        }

                        if(var121 != null) {
                           var1.c(var116, var121);
                           var1.d(this.b.h(var116), var121);
                        }

                        if(var122 != null) {
                           var1.d(var116, var122);
                           var1.c(this.b.h(var116), var122);
                        }

                        var33.g();
                     } while(!var41);
                  }

                  var108.g();
               } while(!var41);
            }

            var108 = var1.o();

            while(var108.f()) {
               var103 = var108.e();
               var126 = this.b.e(var103);
               if(var41) {
                  break label982;
               }

               if(var126) {
                  this.b.h(var103);
               }

               var108.g();
               if(var41) {
                  break;
               }
            }
         }

         ((y.c.i)var60).a(var62);
         ((y.c.i)var60).a(var72);
         ((y.c.i)var60).a(var64);
         ((y.c.i)var60).a(var67);
         ((y.c.i)var60).a(var77);
         ((y.c.i)var60).a(var101);
         var1.a((y.c.A)var5);
         var1.a((y.c.A)var4);
         var108 = var48.a();
      }

      for(var126 = var108.f(); var126; var126 = var108.f()) {
         var1.d(var108.e());
         var108.g();
         if(var41) {
            break;
         }
      }

      y.c.e var114 = var2.a();

      while(true) {
         if(var114.f()) {
            var1.e(var114.a());
            var114.g();
            if(var41) {
               break;
            }

            if(!var41) {
               continue;
            }
         }

         var1.a((y.c.h)var6);
         var1.a((y.c.h)var90);
         var1.a((y.c.h)var98);
         break;
      }

      var114 = var2.a();

      while(true) {
         if(var114.f()) {
            var1.d(var114.a());
            var114.g();
            if(var41) {
               break;
            }

            if(!var41) {
               continue;
            }
         }

         var61.e();
         break;
      }

   }

   public void a() {
      this.b.b();
      this.b.e();
   }

   public static void a(X var0) {
      boolean var4 = N.d;
      y.d.b.n var1 = y.d.b.n.f();
      y.c.x var2 = var0.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         a(var0, var3, var1);
         var2.g();
         if(var4) {
            break;
         }
      }

   }

   private static void a(X var0, y.c.q var1, y.d.b.l var2) {
      boolean var15 = N.d;
      HashMap var3 = new HashMap();
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();
      HashSet var7 = new HashSet();
      ArrayList var8 = new ArrayList();
      y.c.e var9 = var1.l();

      label65:
      while(true) {
         y.c.d var10;
         y.d.t[] var11;
         Object var12;
         if(var9.f()) {
            var10 = var9.a();
            var11 = var0.l(var10).f();
            var12 = a(var11, var2, var3, var4, var7, var8);
            if(!var15) {
               if(var12 != null) {
                  var5.put(var12, var10);
               }

               var9.g();
               if(!var15) {
                  continue;
               }

               var9 = var1.k();
            } else {
               if(var12 != null) {
                  var6.put(var12, var10);
               }

               var9.g();
               if(var15) {
                  break;
               }
            }
         } else {
            var9 = var1.k();
         }

         while(true) {
            if(!var9.f()) {
               break label65;
            }

            var10 = var9.a();
            var11 = var0.l(var10).g().f();
            var12 = a(var11, var2, var3, var4, var7, var8);
            if(var12 != null) {
               var6.put(var12, var10);
            }

            var9.g();
            if(var15) {
               break label65;
            }
         }
      }

      Iterator var16 = var8.iterator();

      while(var16.hasNext()) {
         Object var17 = var16.next();
         ArrayList var18 = (ArrayList)var3.get(var17);
         ArrayList var19 = (ArrayList)var4.get(var17);
         if(var18 == null) {
            var18 = a;
         }

         if(var19 == null) {
            var19 = a;
         }

         if(var18.size() + var19.size() >= 2) {
            y.g.e.a((List)var18, new h(var2, (e)null));
            y.g.e.a((List)var19, new h(var2, (e)null));
            double var13 = 1.0D / (double)var1.a();
            a(var18, var2, -var13, var6, var0, var5);
            a(var19, var2, var13, var6, var0, var5);
            if(var15) {
               break;
            }
         }
      }

   }

   private static void a(ArrayList var0, y.d.b.l var1, double var2, Map var4, X var5, Map var6) {
      boolean var14 = N.d;
      int var7 = 0;

      while(var7 < var0.size()) {
         Object var8 = var0.get(var7);
         y.d.z var9 = new y.d.z(var1.k(var1.c(var8)).e(), var1.l(var1.c(var8)).e(), var1.k(var1.d(var8)).e(), var1.l(var1.d(var8)).e());
         var9 = y.d.z.c(var9);
         var9.b((double)(var7 + 1) * var2);
         y.c.d var10;
         y.d.t var11;
         if(var4.get(var8) != null) {
            var10 = (y.c.d)var4.get(var8);
            var11 = var5.q(var10);
            var5.d(var10, y.d.z.a(var11, var9));
            int var12 = var5.b(var10).pointCount() - 1;
            y.d.t var13 = var5.b(var10).getPoint(var12);
            var13 = y.d.z.a(var13, var9);
            var5.b(var10).setPoint(var12, var13.a(), var13.b());
         }

         if(var6.get(var8) != null) {
            var10 = (y.c.d)var6.get(var8);
            var11 = var5.p(var10);
            var5.c(var10, y.d.z.a(var11, var9));
            y.d.t var15 = var5.b(var10).getPoint(0);
            var15 = y.d.z.a(var15, var9);
            var5.b(var10).setPoint(0, var15.a(), var15.b());
         }

         ++var7;
         if(var14) {
            break;
         }
      }

   }

   private static Object a(y.d.t[] var0, y.d.b.l var1, Map var2, Map var3, Set var4, ArrayList var5) {
      boolean var12 = N.d;
      if(var0.length == 2) {
         return null;
      } else {
         Object var6 = a(var0[0], var1);
         Object var7 = a(var0[1], var1);
         Object var8 = var1.c(var6, var7);
         boolean var9 = false;
         if(var0.length > 2) {
            Object var10 = a(var0[2], var1);
            var9 = var1.a(var6, var7, var10);
         }

         ArrayList var13 = var9?(ArrayList)var2.get(var6):(ArrayList)var3.get(var6);
         if(var13 == null) {
            label30: {
               var13 = new ArrayList();
               var13.add(var8);
               if(var9) {
                  var2.put(var6, var13);
                  if(!var12) {
                     break label30;
                  }
               }

               var3.put(var6, var13);
            }

            if(!var4.add(var6)) {
               return var8;
            }

            var5.add(var6);
            if(!var12) {
               return var8;
            }
         }

         Object var11 = var13.get(0);
         if(var1.b(var1.d(var11), var6, var7)) {
            var13.add(var8);
         }

         return var8;
      }
   }

   private static Object a(y.d.t var0, y.d.b.l var1) {
      return a(var0.a(), var0.b(), var1);
   }

   private static Object a(double var0, double var2, y.d.b.l var4) {
      double var5 = (double)((int)Math.floor(100.0D * var0 + 0.5D)) / 100.0D;
      double var7 = (double)((int)Math.floor(100.0D * var2 + 0.5D)) / 100.0D;
      y.d.b.b var9 = (y.d.b.b)var4.a(var5, var7);
      var9.g();
      return var9;
   }
}
