package y.f.c.a;

import java.util.HashMap;
import java.util.Map;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bY;
import y.f.c.a.bu;
import y.f.c.a.cB;
import y.f.c.a.cD;
import y.f.c.a.cb;
import y.f.c.a.ce;
import y.f.c.a.cf;
import y.f.c.a.cg;
import y.f.c.a.ch;
import y.f.c.a.ci;
import y.f.c.a.cj;
import y.f.c.a.ck;
import y.f.c.a.cl;
import y.f.c.a.cm;
import y.f.c.a.df;

class cd {
   private y.c.f a = new y.c.f();
   private double b = 15.0D;
   private double c = 10.0D;
   private Map d = new HashMap();

   public void a(y.f.X var1) {
      boolean var4 = N.x;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         if(var3.e()) {
            this.a(var1, var3);
         }

         var2.g();
         if(var4) {
            break;
         }
      }

   }

   public void a(y.f.X var1, y.c.d var2) {
      if(var1.f(var2)) {
         var1.d(var2);
      }

      this.a.add(var2);
   }

   public void b(y.f.X var1, y.c.d var2) {
      if(!var1.f(var2)) {
         var1.e(var2);
      }

   }

   public void b(y.f.X var1) {
      boolean var3 = N.x;
      y.c.p var2 = this.a.k();

      while(var2 != null) {
         this.b(var1, (y.c.d)var2.c());
         var2 = var2.a();
         if(var3) {
            break;
         }
      }

   }

   public cD a(y.f.X var1, y.c.q var2) {
      cD var3 = (cD)this.d.get(var2);
      if(var3 == null) {
         var3 = new cD(new cb(var1.a((Object)var2)));
         this.d.put(var2, var3);
      }

      return var3;
   }

   public boolean a(y.c.q var1) {
      return this.d.containsKey(var1);
   }

   public void a(y.f.X var1, aV var2) {
      boolean var14 = N.x;
      y.c.p var3 = this.a.k();

      while(var3 != null) {
         y.c.d var4 = (y.c.d)var3.c();
         boolean var5 = var1.f(var4);
         if(!var5) {
            var1.e(var4);
         }

         cD var6 = this.a(var1, var4.c());
         var6.a(var4);
         y.f.aE var7 = a(var1, var2, var4);
         y.f.aE var8 = b(var1, var2, var4);
         boolean var9 = !var7.a();
         boolean var10 = !var8.a();
         int var11 = bY.a(var7.b(), 2);
         int var12 = bY.a(var8.b(), 0);
         int var13 = 4 + var12 - var11 & 3;
         if(var9 || var10) {
            if(var9) {
               switch(var13) {
               case 0:
                  var6.b(var11).a(var4);
                  if(!var14) {
                     break;
                  }
               case 3:
                  var6.a(var11).a(var4);
                  if(!var14) {
                     break;
                  }
               case 1:
               case 2:
                  var6.c(var11).a(var4);
               }
            }

            if(var10) {
               switch(var13) {
               case 0:
                  var6.b(var12).a(var4);
                  if(!var14) {
                     break;
                  }
               case 1:
               case 2:
                  var6.a(var12).a(var4);
                  if(!var14) {
                     break;
                  }
               case 3:
                  var6.c(var12).a(var4);
               }
            }
         }

         if(!var5) {
            var1.d(var4);
         }

         var3 = var3.a();
         if(var14) {
            break;
         }
      }

   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var39 = N.x;
      ce var4 = new ce(this, var1, var3);
      cf var5 = new cf(this, var1, var3);
      cg var6 = new cg(this, var3);
      ch var7 = new ch(this, var3);
      ci var8 = new ci(this, var3);
      cj var9 = new cj(this, var3);
      ck var10 = new ck(this, var3);
      cl var11 = new cl(this, var3);
      var1.a((Object)bu.f, (y.c.c)var8);
      var1.a((Object)bu.e, (y.c.c)var7);
      var1.a((Object)bu.a, (y.c.c)var9);
      var1.a((Object)bu.d, (y.c.c)var6);
      var1.a((Object)bu.b, (y.c.c)var10);
      var1.a((Object)bu.c, (y.c.c)var11);

      try {
         y.d.c[] var12 = new y.d.c[4];
         bu var13 = new bu(this.b, this.c);
         cm var14 = new cm(var1, var3);
         int var15 = 0;

         do {
            int var10000 = var15;

            label302:
            while(true) {
               if(var10000 >= var2.b()) {
                  return;
               }

               aQ var16 = var2.a(var15);
               y.c.p var17 = var16.d().k();

               while(true) {
                  if(var17 == null) {
                     break label302;
                  }

                  y.c.q var18 = (y.c.q)var17.c();
                  y.f.am var19 = var1.a((Object)var18);
                  var10000 = this.a(var18);
                  if(var39) {
                     break;
                  }

                  label297: {
                     if(var10000 != 0) {
                        cD var20 = this.a(var1, var18);
                        var20.a().sort(var14);
                        if(var20.a().size() >= 1) {
                           double var21;
                           double var23;
                           label315: {
                              var21 = var19.getX();
                              var23 = var19.getY();
                              var19.setLocation(0.0D, 0.0D);
                              aX var25 = var3.a(var18);
                              int var26;
                              if(var25.b() == 0) {
                                 var26 = 0;

                                 do {
                                    if(var26 >= 4) {
                                       break label315;
                                    }

                                    var12[var26] = var25.a(var26, var19);
                                    ++var26;
                                    if(var39) {
                                       break label297;
                                    }
                                 } while(!var39);
                              }

                              var26 = 0;

                              while(var26 < 4) {
                                 var12[var26] = null;
                                 ++var26;
                                 if(var39) {
                                    break label297;
                                 }

                                 if(var39) {
                                    break;
                                 }
                              }
                           }

                           y.c.p var42 = var20.b();

                           y.c.d var27;
                           while(var42 != null) {
                              var27 = (y.c.d)var42.c();
                              byte var28 = var1.f(var27);
                              var10000 = var28;
                              if(var39) {
                                 continue label302;
                              }

                              if(var28 == 0) {
                                 var1.e(var27);
                              }

                              y.f.aE var29 = a(var1, var3, var27);
                              y.f.aE var30 = b(var1, var3, var27);
                              int var31 = bY.a(var29.b(), 2);
                              int var32 = bY.a(var30.b(), 0);
                              y.d.t var33 = null;
                              y.d.t var34 = null;
                              int var35 = 4 + var32 - var31 & 3;
                              df var36;
                              if(!var29.a()) {
                                 switch(var35) {
                                 case 0:
                                    var36 = var20.b(var31);
                                    var33 = var36.d(var36.c(), 0.0D);
                                    break;
                                 case 1:
                                 case 2:
                                    var36 = var20.c(var31);
                                    var33 = var36.d(var36.c(), 0.0D);
                                    break;
                                 case 3:
                                    var36 = var20.a(var31);
                                    var33 = var36.d(var36.c(), 0.0D);
                                 }

                                 var1.c(var27, var33);
                              }

                              if(!var30.a()) {
                                 switch(var35) {
                                 case 0:
                                    var36 = var20.b(var32);
                                    var34 = var36.d(var36.c(), 0.0D);
                                    break;
                                 case 1:
                                 case 2:
                                    var36 = var20.a(var32);
                                    var34 = var36.d(var36.c(), 0.0D);
                                    break;
                                 case 3:
                                    var36 = var20.c(var32);
                                    var34 = var36.d(var36.c(), 0.0D);
                                 }

                                 var1.d(var27, var34);
                              }

                              if(var28 == 0) {
                                 var1.d(var27);
                              }

                              var42 = var42.a();
                              if(var39) {
                                 break;
                              }
                           }

                           var13.a(var1, var18, var20.b(), var4, var5, var12);
                           var42 = var20.b();

                           while(var42 != null) {
                              var27 = (y.c.d)var42.c();
                              y.f.I var43 = var1.b(var27);
                              y.d.t var44 = var1.p(var27);
                              var10000 = 0;
                              if(var39) {
                                 continue label302;
                              }

                              int var45 = 0;

                              label258: {
                                 while(var45 < var43.pointCount()) {
                                    y.d.t var46 = var43.getPoint(var45);
                                    a(var12, var44, var46);
                                    var44 = var46;
                                    ++var45;
                                    if(var39) {
                                       break label258;
                                    }

                                    if(var39) {
                                       break;
                                    }
                                 }

                                 a(var12, var44, var1.q(var27));
                                 a(var12, var1, var27);
                                 var42 = var42.a();
                              }

                              if(var39) {
                                 break;
                              }
                           }

                           var19.setLocation(var21, var23);
                        }
                     }

                     var17 = var17.a();
                  }

                  if(var39) {
                     break label302;
                  }
               }
            }

            ++var15;
         } while(!var39);
      } finally {
         var1.d_(bu.f);
         var1.d_(bu.e);
         var1.d_(bu.a);
         var1.d_(bu.d);
         var1.d_(bu.b);
         var1.d_(bu.c);
      }

   }

   private static final void a(y.d.c[] var0, y.d.t var1, y.d.t var2) {
      double var3 = Math.min(var1.a, var2.a);
      double var5 = Math.max(var1.a, var2.a);
      double var7 = Math.min(var1.b, var2.b);
      double var9 = Math.max(var1.b, var2.b);
      if(var5 - var3 > var9 - var7) {
         if(var0[0] != null) {
            var0[0].a(var3, var5, var7);
         }

         if(var0[2] == null) {
            return;
         }

         var0[2].b(var3, var5, var9);
         if(!N.x) {
            return;
         }
      }

      if(var0[3] != null) {
         var0[3].a(var7, var9, var3);
      }

      if(var0[1] != null) {
         var0[1].b(var7, var9, var5);
      }

   }

   private static void a(y.d.c[] var0, y.f.X var1, y.c.d var2) {
      boolean var12 = N.x;
      y.d.v var3 = var1.l(var2);
      cB var4 = cB.b((y.c.i)var1);
      y.f.S[] var5 = var4.a(var1, var2);
      if(var5 != null) {
         int var6 = 0;

         do {
            int var10000 = var6;

            label77:
            while(true) {
               while(var10000 < var5.length) {
                  y.f.S var7 = var5[var6];
                  y.f.aG var8 = var7.f();
                  boolean var9 = var4.a(var2, var3);
                  y.d.m var10 = null;
                  int var11;
                  if(!var8.i() && !var8.j()) {
                     var11 = var3.i() - 2;

                     while(true) {
                        if(var11 <= 0) {
                           break label77;
                        }

                        var10 = var3.a(var11);
                        var10000 = var10.b();
                        if(var12) {
                           break;
                        }

                        if(var10000 != 0 && var9 || var10.a() && !var9) {
                           a(var0, var7, var8, var10);
                           if(!var12) {
                              break label77;
                           }
                        }

                        --var11;
                        if(var12) {
                           break label77;
                        }
                     }
                  } else {
                     var11 = 1;

                     while(true) {
                        if(var11 >= var3.i() - 1) {
                           break label77;
                        }

                        var10 = var3.a(var11);
                        var10000 = var10.b();
                        if(var12) {
                           break;
                        }

                        if(var10000 != 0 && var9 || var10.a() && !var9) {
                           a(var0, var7, var8, var10);
                           if(!var12) {
                              break label77;
                           }
                        }

                        ++var11;
                     }
                  }
               }

               return;
            }

            ++var6;
         } while(!var12);
      }

   }

   private static void a(y.d.c[] var0, y.f.S var1, y.f.aG var2, y.d.m var3) {
      boolean var14 = N.x;
      if(var3 != null) {
         y.d.t var4 = var3.c();
         y.d.t var5 = var3.d();
         boolean var6 = var4.a() < var5.a();
         boolean var7 = var4.b() < var5.b();
         double var8;
         double var10;
         if(var2.m()) {
            if(var3.b()) {
               var8 = var1.c();
               var10 = Math.abs(var3.j());
               if(var6) {
                  a(var0, var4.a(), var4.b() - var8 * 0.5D, var10, var8);
                  if(!var14) {
                     return;
                  }
               }

               a(var0, var5.a(), var5.b() - var8 * 0.5D, var10, var10);
               if(!var14) {
                  return;
               }
            }

            var8 = var1.b();
            var10 = Math.abs(var3.k());
            if(var7) {
               a(var0, var4.a() - var8 * 0.5D, var4.b(), var8, var10);
               if(!var14) {
                  return;
               }
            }

            a(var0, var5.a() - var8 * 0.5D, var5.b(), var8, var10);
            if(!var14) {
               return;
            }
         }

         var8 = Math.max(0.0D, var2.h());
         double var12;
         if(var3.b()) {
            var10 = var1.c() + var8;
            var12 = Math.abs(var3.j());
            if(var2.l()) {
               if(var6) {
                  a(var0, var4.a(), var4.b() - var10, var12, var10);
                  if(!var14) {
                     return;
                  }
               }

               a(var0, var5.a(), var5.b(), var12, var10);
               if(!var14) {
                  return;
               }
            }

            if(var6) {
               a(var0, var4.a(), var4.b(), var12, var10);
               if(!var14) {
                  return;
               }
            }

            a(var0, var5.a(), var5.b() - var10, var12, var10);
            if(!var14) {
               return;
            }
         }

         var10 = Math.abs(var3.k());
         var12 = var1.b() + var8;
         if(var2.l()) {
            if(var7) {
               a(var0, var4.a(), var4.b(), var12, var10);
               if(!var14) {
                  return;
               }
            }

            a(var0, var5.a() - var12, var5.b(), var12, var10);
            if(!var14) {
               return;
            }
         }

         if(var2.n()) {
            if(var7) {
               a(var0, var4.a() - var12, var4.b(), var12, var10);
               if(!var14) {
                  return;
               }
            }

            a(var0, var5.a(), var5.b(), var12, var10);
         }

      }
   }

   private static void a(y.d.c[] var0, double var1, double var3, double var5, double var7) {
      if(var0[0] != null) {
         var0[0].a(var1, var1 + var5, var3);
      }

      if(var0[1] != null) {
         var0[1].b(var3, var3 + var7, var1 + var5);
      }

      if(var0[2] != null) {
         var0[2].b(var1, var1 + var5, var3 + var7);
      }

      if(var0[3] != null) {
         var0[3].a(var3, var3 + var7, var1);
      }

   }

   public void b(y.f.X var1, aU var2, aV var3) {
      boolean var14 = N.x;
      y.c.p var4 = this.a.k();

      while(var4 != null) {
         label27: {
            y.c.d var5 = (y.c.d)var4.c();
            if(var1.f(var5)) {
               y.f.I var6 = var1.b(var5);
               y.f.am var7 = var1.a((Object)var5.c());
               double var8 = var7.getX();
               double var10 = var7.getY();
               int var12 = 0;

               while(var12 < var6.pointCount()) {
                  y.d.t var13 = var6.getPoint(var12);
                  var6.setPoint(var12, var13.a + var8, var13.b + var10);
                  ++var12;
                  if(var14) {
                     break label27;
                  }

                  if(var14) {
                     break;
                  }
               }
            }

            var4 = var4.a();
         }

         if(var14) {
            break;
         }
      }

   }

   static final y.f.aE a(y.f.X var0, aV var1, y.c.d var2) {
      y.f.aE var3 = var1.a(var2).c();
      if(var3 == null || var3.g()) {
         y.f.aE var4 = var1.a(var2).e();
         if(var4 == null || var4.g()) {
            return y.f.aE.a((byte)1);
         }

         if(var4.c()) {
            return y.f.aE.a((byte)8);
         }

         if(var4.f()) {
            return y.f.aE.a((byte)1);
         }

         if(var4.d()) {
            return y.f.aE.a((byte)4);
         }

         if(var4.e()) {
            return y.f.aE.a((byte)2);
         }
      }

      return var3;
   }

   static final y.f.aE b(y.f.X var0, aV var1, y.c.d var2) {
      y.f.aE var3 = var1.a(var2).e();
      if(var3 == null || var3.g()) {
         y.f.aE var4 = var1.a(var2).c();
         if(var4 == null || var4.g()) {
            return y.f.aE.a((byte)8);
         }

         if(var4.c()) {
            return y.f.aE.a((byte)8);
         }

         if(var4.f()) {
            return y.f.aE.a((byte)1);
         }

         if(var4.d()) {
            return y.f.aE.a((byte)4);
         }

         if(var4.e()) {
            return y.f.aE.a((byte)2);
         }
      }

      return var3;
   }

   static double a(cd var0) {
      return var0.b;
   }

   static double b(cd var0) {
      return var0.c;
   }
}
