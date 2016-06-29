package y.f.c.a;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.O;
import y.f.c.a.P;
import y.f.c.a.Q;
import y.f.c.a.R;
import y.f.c.a.W;
import y.f.c.a.X;
import y.f.c.a.Y;
import y.f.c.a.aQ;
import y.f.c.a.aR;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bh;
import y.f.c.a.bk;
import y.f.c.a.bt;
import y.f.c.a.co;

class aD {
   private y.c.c b;
   y.c.c a;

   private aD() {
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var31 = N.x;
      y.c.c var4 = var1.c(N.w);
      if(var4 != null) {
         this.a = new W(this);
         E var5 = (E)var4.b(var1);
         var5.c();
         if(var5.k() && !y.f.b.c.c((y.c.i)var1)) {
            this.b = var1.c("y.layout.hierarchic.incremental.LayerCompactor.KEEP_LAYERS_DPKEY");
            y.c.A var6 = var1.t();
            y.c.A var7 = var1.t();
            y.c.A var8 = var1.t();
            y.c.h var9 = var1.u();
            y.c.h var10 = var1.u();
            y.c.y[] var11 = new y.c.y[var2.b()];
            int var12 = 0;

            while(var12 < var2.b()) {
               y.c.y var13 = var2.a(var12).d();
               var11[var12] = var13;
               y.c.x var14 = var13.a();

               while(true) {
                  if(var14.f()) {
                     y.c.q var15 = var14.e();
                     var8.a(var15, var15.d());
                     int var16 = 0;
                     if(var31) {
                        break;
                     }

                     y.c.d var17 = var15.f();

                     label395: {
                        while(var17 != null) {
                           var9.a(var17, var16);
                           ++var16;
                           var17 = var17.g();
                           if(var31) {
                              break label395;
                           }

                           if(var31) {
                              break;
                           }
                        }

                        var16 = 0;
                     }

                     var17 = var15.g();

                     label384: {
                        while(var17 != null) {
                           var10.a(var17, var16);
                           ++var16;
                           var17 = var17.h();
                           if(var31) {
                              break label384;
                           }

                           if(var31) {
                              break;
                           }
                        }

                        var14.g();
                     }

                     if(!var31) {
                        continue;
                     }
                  }

                  ++var12;
                  break;
               }

               if(var31) {
                  break;
               }
            }

            y.f.c.r var34 = new y.f.c.r();
            y.f.c.s var35 = y.f.c.r.a((y.c.i)var1);
            y.c.y var36 = new y.c.y();
            y.c.A var37 = var1.t();
            y.c.c var39 = var1.c(y.f.b.f.b);
            X var40 = new X(this, var39);
            var1.a((Object)y.f.b.f.b, (y.c.c)var40);
            this.a(var1, var35, var3, (y.c.q)null, var6, var7, var36, var37);
            this.a(var1, var35, var3);
            this.a(var1, var6, var7, var3, var35, var37);
            y.c.q[] var18 = this.a(var1, var6, var7, var35);
            this.a(var1, var6, var7, var35, var3, var2.b());
            var1.a((Object)y.f.b.f.b, (y.c.c)var39);
            var5.b();
            y.c.A var19 = var1.t();
            y.c.f var20 = new y.c.f();
            var34.a(true);
            y.c.c var22 = var1.c(y.f.ah.f_);
            var1.a((Object)y.f.ah.f_, (y.c.c)this.a);

            try {
               var34.a(var1, var19, var20);
            } finally {
               var1.d_(y.f.ah.f_);
               if(var22 != null) {
                  var1.a((Object)y.f.ah.f_, (y.c.c)var22);
               }

            }

            y.c.e var23 = var20.a();

            y.f.X var10000;
            label365: {
               label364:
               while(true) {
                  if(var23.f()) {
                     y.c.d var24 = var23.a();
                     var1.c(var24);
                     var23.g();
                     if(var31) {
                        break;
                     }

                     if(!var31) {
                        continue;
                     }
                  }

                  y.c.x var41 = var36.a();

                  while(var41.f()) {
                     y.c.q var44 = var41.e();
                     var1.a((y.c.q)var44);
                     var41.g();
                     if(var31) {
                        break label364;
                     }

                     if(var31) {
                        break;
                     }
                  }

                  if(var18 != null) {
                     int var42 = 0;

                     while(var42 < var18.length) {
                        var10000 = var1;
                        if(var31) {
                           break label365;
                        }

                        var1.a((y.c.q)var18[var42]);
                        ++var42;
                        if(var31) {
                           break label364;
                        }
                     }
                  }
                  break;
               }

               var10000 = var1;
            }

            y.c.A var43 = var10000.t();
            int var21 = (new y.f.c.D()).a((y.c.i)var1, (y.c.c)var19, (y.c.a)var43);
            int var45 = var2.b();
            int var25 = 0;

            while(true) {
               if(var25 < var45) {
                  var2.b(0);
                  ++var25;
                  if(var31) {
                     break;
                  }

                  if(!var31) {
                     continue;
                  }
               }

               var25 = 0;
               break;
            }

            while(true) {
               if(var25 < var21) {
                  var2.a((byte)0, 0);
                  ++var25;
                  if(var31) {
                     break;
                  }

                  if(!var31) {
                     continue;
                  }
               }

               var25 = 0;
               break;
            }

            y.c.x var38;
            while(true) {
               if(var25 < var11.length) {
                  y.c.y var26 = var11[var25];
                  var38 = var26.a();
                  if(var31) {
                     break;
                  }

                  y.c.x var27 = var38;

                  label314: {
                     while(var27.f()) {
                        y.c.q var28 = var27.e();
                        int var29 = var43.a(var28);
                        aQ var30 = var2.a(var29);
                        var30.a(var28);
                        var27.g();
                        if(var31) {
                           break label314;
                        }

                        if(var31) {
                           break;
                        }
                     }

                     ++var25;
                  }

                  if(!var31) {
                     continue;
                  }
               }

               var35.a();
               var1.a((y.c.A)var19);
               var1.a((y.c.A)var43);
               var1.a((y.c.A)var37);
               var1.b(new Y(this, var8));
               var38 = var1.o();
               break;
            }

            y.c.x var47 = var38;

            while(true) {
               if(var47.f()) {
                  y.c.q var46 = var47.e();
                  var46.b((Comparator)(new P(this, var9)));
                  var46.a((Comparator)(new Q(this, var10)));
                  var47.g();
                  if(var31) {
                     break;
                  }

                  if(!var31) {
                     continue;
                  }
               }

               var1.a((y.c.A)var8);
               var1.a((y.c.h)var9);
               var1.a((y.c.h)var10);
               var1.a((y.c.A)var7);
               var1.a((y.c.A)var6);
               break;
            }

         } else {
            var5.b();
         }
      }
   }

   protected void a(y.f.X var1, y.c.A var2, y.c.A var3, aV var4, y.f.c.s var5, y.c.A var6) {
      boolean var25 = N.x;
      y.f.b.c var7 = new y.f.b.c(var1);
      y.c.h var8 = var1.u();
      y.c.x var9 = var1.o();

      y.f.b.c var26;
      label114:
      while(true) {
         boolean var10000 = var9.f();

         label111:
         while(var10000) {
            y.c.q var10 = var9.e();
            var26 = var7;
            if(var25) {
               break label114;
            }

            if(var7.d(var10)) {
               y.c.q var11 = (y.c.q)var2.b(var10);
               y.c.q var12 = (y.c.q)var3.b(var10);
               if(var11 != null && var12 != null) {
                  int var13 = var6.a(var11);
                  int var14 = var6.a(var12);
                  y.c.f var15 = new y.c.f(var10.j());
                  y.c.e var16 = var15.a();

                  while(var16.f()) {
                     y.c.d var17 = var16.a();
                     var10000 = var8.d(var17);
                     if(var25) {
                        continue label111;
                     }

                     if(!var10000) {
                        label125: {
                           y.c.q var18 = var17.a(var10);
                           y.c.q var19 = var7.b(var10, var18);
                           if(var19 == var10 || var19 == var18 || this.a((y.c.q)var7.a(var10), (y.c.i)var1, (y.f.b.c)var7) && this.a((y.c.q)var7.a(var18), (y.c.i)var1, (y.f.b.c)var7)) {
                              var8.a(var17, true);
                              if(!var25) {
                                 break label125;
                              }
                           }

                           y.c.q var20;
                           y.c.q var21;
                           int var22;
                           int var23;
                           label92: {
                              var20 = var18;
                              var21 = var18;
                              if(var7.d(var18)) {
                                 y.c.q var24;
                                 label89: {
                                    var24 = (y.c.q)var2.b(var18);
                                    if(var24 != null) {
                                       var20 = var24;
                                       var22 = var6.a(var24);
                                       if(!var25) {
                                          break label89;
                                       }
                                    }

                                    var22 = var4.a(var18).j();
                                 }

                                 var24 = (y.c.q)var3.b(var18);
                                 if(var24 != null) {
                                    var21 = var24;
                                    var23 = var6.a(var24);
                                    if(!var25) {
                                       break label92;
                                    }
                                 }

                                 var23 = var4.a(var18).j();
                                 if(!var25) {
                                    break label92;
                                 }
                              }

                              var22 = var4.a(var20).j();
                              var23 = var4.a(var21).j();
                           }

                           label122: {
                              if(var14 < var22) {
                                 var5.a(this.a.b(var12), this.a.b(var20), 1);
                                 if(!var25) {
                                    break label122;
                                 }
                              }

                              if(var23 < var13) {
                                 var5.a(this.a.b(var21), this.a.b(var11), 1);
                                 if(!var25) {
                                    break label122;
                                 }
                              }

                              label70: {
                                 if(var13 < var22) {
                                    var5.a(this.a.b(var11), this.a.b(var20), 0);
                                    if(!var25) {
                                       break label70;
                                    }
                                 }

                                 if(var13 > var22) {
                                    var5.b(this.a.b(var11), this.a.b(var20), 0);
                                 }
                              }

                              if(var14 < var23) {
                                 var5.a(this.a.b(var12), this.a.b(var21), 0);
                                 if(!var25) {
                                    break label122;
                                 }
                              }

                              if(var14 > var23) {
                                 var5.b(this.a.b(var12), this.a.b(var21), 0);
                              }
                           }

                           var8.a(var17, true);
                        }
                     }

                     var16.g();
                     if(var25) {
                        break;
                     }
                  }
               }
            }

            var9.g();
            if(!var25) {
               continue label114;
            }
            break;
         }

         var1.a((y.c.h)var8);
         var26 = var7;
         break;
      }

      var26.c();
   }

   protected void a(y.f.X var1, y.f.c.s var2, aV var3, y.c.q var4, y.c.A var5, y.c.A var6, y.c.y var7, y.c.A var8) {
      y.f.b.c var9;
      label11: {
         var9 = new y.f.b.c(var1);
         if(this.a((y.c.q)var4, (y.c.i)var1, (y.f.b.c)var9)) {
            this.a(var1, var2, var9, var3, var4, var5, var6, var7, var8);
            if(!N.x) {
               break label11;
            }
         }

         this.a(var9, var4, var1, var2, var3, var5, var6, var7, var8);
      }

      var9.c();
   }

   private void a(y.f.b.c var1, y.c.q var2, y.f.X var3, y.f.c.s var4, aV var5, y.c.A var6, y.c.A var7, y.c.y var8, y.c.A var9) {
      boolean var18 = N.x;
      y.c.x var10 = var1.b(var2).a();

      while(true) {
         y.c.q var11;
         if(var10.f()) {
            var11 = var10.e();
            if(var18) {
               break;
            }

            if(var1.d(var11)) {
               this.a(var3, var4, var5, var11, var6, var7, var8, var9);
            }

            var10.g();
            if(!var18) {
               continue;
            }
         }

         if(var2 != null) {
            y.c.q var19 = var3.d();
            var3.b(var19, 0.0D, 0.0D);
            var11 = var3.d();
            var3.b(var11, 0.0D, 0.0D);
            var6.a(var2, var19);
            var7.a(var2, var11);
            var8.add(var19);
            var8.add(var11);
            int var12 = Integer.MAX_VALUE;
            int var13 = 0;
            y.c.x var14 = var1.b(var2).a();

            label35: {
               while(var14.f()) {
                  y.c.q var15 = var14.e();
                  if(var18) {
                     break label35;
                  }

                  label31: {
                     if(!var1.d(var15)) {
                        var4.a(this.a.b(var19), this.a.b(var15), 0);
                        var4.b(this.a.b(var11), this.a.b(var15), 0);
                        var12 = Math.min(var12, var5.a(var15).j());
                        var13 = Math.max(var13, var5.a(var15).j());
                        if(!var18) {
                           break label31;
                        }
                     }

                     y.c.q var16 = (y.c.q)var6.b(var15);
                     var4.a(this.a.b(var19), this.a.b(var16), 0);
                     y.c.q var17 = (y.c.q)var7.b(var15);
                     var4.b(this.a.b(var11), this.a.b(var17), 0);
                     var12 = Math.min(var12, var9.a(var16));
                     var13 = Math.max(var13, var9.a(var17));
                  }

                  var14.g();
                  if(var18) {
                     break;
                  }
               }

               var4.a(this.a.b(var19), this.a.b(var11), 0, var3.g() * 1000);
               var9.a(var19, var12);
            }

            var9.a(var11, var13);
         }
         break;
      }

   }

   private void a(y.f.X var1, y.f.c.s var2, y.f.b.c var3, aV var4, y.c.q var5, y.c.A var6, y.c.A var7, y.c.y var8, y.c.A var9) {
      boolean var16 = N.x;
      this.a(var1, var5, var3, var4, var6, var7, var9);
      y.c.y var10 = var3.c(var5);
      HashMap var11 = new HashMap();
      y.c.x var12 = var10.a();

      y.c.q var15;
      int var10000;
      while(true) {
         if(var12.f()) {
            y.c.q var13 = var12.e();
            var10000 = var3.d(var13);
            if(var16) {
               break;
            }

            if(var10000 == 0) {
               label47: {
                  Integer var14 = new Integer(var4.a(var13).j());
                  var15 = (y.c.q)var11.get(var14);
                  if(var15 != null) {
                     var2.b(this.a.b(var15), this.a.b(var13));
                     if(!var16) {
                        break label47;
                     }
                  }

                  var11.put(var14, var13);
               }
            }

            var12.g();
            if(!var16) {
               continue;
            }
         }

         var10000 = var11.size();
         break;
      }

      if(var10000 > 0) {
         Collection var17 = var11.values();
         y.c.q[] var18 = (y.c.q[])var17.toArray(new y.c.q[var17.size()]);
         y.g.e.a((Object[])var18, new R(this, var4));
         if(var18.length > 1) {
            int var19 = 1;

            while(var19 < var18.length) {
               var15 = var18[var19];
               var2.a(this.a.b(var18[var19 - 1]), this.a.b(var15), 1, Math.min(1000 * var1.g(), 2147483646));
               ++var19;
               if(var16) {
                  break;
               }
            }
         }
      }

   }

   private void a(y.f.X var1, y.c.q var2, y.f.b.c var3, aV var4, y.c.A var5, y.c.A var6, y.c.A var7) {
      boolean var18 = N.x;
      y.c.q var8 = null;
      y.c.q var9 = null;
      int var10 = Integer.MAX_VALUE;
      int var11 = -1;
      y.c.x var12 = var3.b(var2).a();

      while(true) {
         if(var12.f()) {
            y.c.q var13 = var12.e();
            if(var18) {
               break;
            }

            y.c.q var14;
            y.c.q var15;
            int var16;
            int var17;
            label29: {
               if(var3.d(var13)) {
                  this.a(var1, var13, var3, var4, var5, var6, var7);
                  var14 = (y.c.q)var5.b(var13);
                  var15 = (y.c.q)var6.b(var13);
                  var16 = var7.a(var14);
                  var17 = var7.a(var15);
                  if(!var18) {
                     break label29;
                  }
               }

               var15 = var13;
               var14 = var13;
               var16 = var17 = var4.a(var13).j();
            }

            if(var17 > var11) {
               var9 = var15;
               var11 = var17;
            }

            if(var16 < var10) {
               var8 = var14;
               var10 = var16;
            }

            var12.g();
            if(!var18) {
               continue;
            }
         }

         if(var2 != null) {
            var5.a(var2, var8);
            var6.a(var2, var9);
            var7.a(var8, var10);
            var7.a(var9, var11);
         }
         break;
      }

   }

   private int a(y.c.q var1, y.f.b.c var2, aV var3) {
      boolean var8 = N.x;
      y.c.q var4 = var1;
      if(var2 != null && var2.d(var1)) {
         y.c.y var5 = var2.c(var1);
         y.c.x var6 = var5.a();

         while(var6.f()) {
            y.c.q var7 = var6.e();
            if(!var2.d(var7)) {
               var4 = var7;
               if(!var8) {
                  break;
               }
            }

            var6.g();
            if(var8) {
               break;
            }
         }
      }

      aX var9 = var3.a(var4);
      return var9 != null?var9.j():-1;
   }

   private y.c.q[] a(y.f.X var1, y.c.A var2, y.c.A var3, y.f.c.s var4) {
      boolean var15 = N.x;
      bk var5 = bk.c(var1);
      if(var5 == null) {
         return null;
      } else {
         y.f.b.c var6 = new y.f.b.c(var1);
         y.c.q[] var7 = var1.m();
         int var8 = var5.e().size();
         y.c.q[] var9 = new y.c.q[var8 - 1];
         int var10 = 0;

         while(var10 < var9.length) {
            var9[var10] = var1.d();
            if(var10 > 0) {
               var4.a(var9[var10 - 1], var9[var10]);
            }

            ++var10;
            if(var15) {
               break;
            }
         }

         y.c.c var16 = var1.c(bk.b);
         if(var16 != null) {
            int var11 = 0;

            while(var11 < var7.length) {
               y.c.q var12 = var7[var11];
               bh var13 = (bh)var16.b(var12);
               if(var15) {
                  return var9;
               }

               if(var13 != null) {
                  bt var14 = var13.c();
                  if(var14 != null) {
                     label75: {
                        if(var6.d(var12)) {
                           if(var14.a() > 0) {
                              var4.b(var2.b(var12), var9[var14.a() - 1], 1);
                           }

                           if(var14.a() >= var8 - 1) {
                              break label75;
                           }

                           var4.a(var3.b(var12), var9[var14.a()], 1);
                           if(!var15) {
                              break label75;
                           }
                        }

                        if(var14.a() > 0) {
                           var4.b(var12, var9[var14.a() - 1], 1);
                        }

                        if(var14.a() < var8 - 1) {
                           var4.a(var12, var9[var14.a()], 1);
                        }
                     }
                  }
               }

               ++var11;
               if(var15) {
                  break;
               }
            }
         }

         var6.c();
         return var9;
      }
   }

   private void a(y.f.X var1, y.c.A var2, y.c.A var3, y.f.c.s var4, aV var5, int var6) {
      boolean var27 = N.x;
      y.c.c var7 = var1.c(aR.a);
      if(var7 != null) {
         y.c.c var8 = (y.c.c)var7.b(var1);
         if(var8 != null) {
            y.c.c var9;
            HashMap var10;
            label232: {
               var9 = var1.c(y.f.ah.f_);
               var10 = new HashMap();
               y.c.x var11;
               y.c.q var12;
               if(var9 != null) {
                  var11 = var1.o();

                  do {
                     if(!var11.f()) {
                        break label232;
                     }

                     var12 = var11.e();
                     Object var13 = var9.b(var12) != null?var9.b(var12):var12;
                     var10.put(var13, var12);
                     var11.g();
                  } while(!var27);
               }

               var11 = var1.o();

               while(var11.f()) {
                  var12 = var11.e();
                  var10.put(var12, var12);
                  var11.g();
                  if(var27) {
                     break;
                  }
               }
            }

            y.f.b.c var28 = new y.f.b.c(var1);
            y.c.x var29 = var1.o();

            label208:
            while(true) {
               boolean var10000 = var29.f();

               label205:
               while(var10000) {
                  y.c.q var30 = var29.e();
                  if(var27) {
                     return;
                  }

                  Object var14 = var9 != null && var9.b(var30) != null?var9.b(var30):var30;
                  y.c.D var15 = (y.c.D)var8.b(var14);
                  if(var15 != null) {
                     int var16 = this.a(var30, var28, var5);
                     y.c.C var17 = var15.m();

                     while(var17.f()) {
                        Object var18 = var17.d();
                        var10000 = var18 instanceof co;
                        if(var27) {
                           continue label205;
                        }

                        if(var10000) {
                           label247: {
                              co var19 = (co)var18;
                              Object var20 = var19.d();
                              y.c.q var21 = (y.c.q)var10.get(var20);
                              byte var22 = var19.c();
                              int var23;
                              y.c.q var25;
                              if(var22 == 0) {
                                 var23 = this.a(var21, var28, var5);
                                 if(var16 != var23) {
                                    break label247;
                                 }

                                 y.c.q var24;
                                 if(var28.d(var30) && var28.d(var21)) {
                                    var24 = (y.c.q)var2.b(var30);
                                    var25 = (y.c.q)var2.b(var21);
                                    if(var24 == null || var25 == null) {
                                       break label247;
                                    }

                                    var4.b(var25, var24);
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 if(var28.d(var30)) {
                                    var24 = (y.c.q)var2.b(var30);
                                    if(var24 == null) {
                                       break label247;
                                    }

                                    var4.b(var21, var24);
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 if(var28.d(var21)) {
                                    var24 = (y.c.q)var2.b(var21);
                                    if(var24 == null) {
                                       break label247;
                                    }

                                    var4.b(var24, var30);
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 var4.b(var21, var30);
                                 if(!var27) {
                                    break label247;
                                 }
                              }

                              y.c.q var26;
                              int var32;
                              if(var22 == -1) {
                                 var23 = this.a(var21, var28, var5);
                                 if(var23 < var16) {
                                    break label247;
                                 }

                                 var32 = Math.min(var19.e(), var23 - var16);
                                 if(var28.d(var30) && var28.d(var21)) {
                                    var25 = (y.c.q)var3.b(var30);
                                    var26 = (y.c.q)var2.b(var21);
                                    if(var25 == null || var26 == null) {
                                       break label247;
                                    }

                                    var4.b(var26, var25, var32, var19.a());
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 if(var28.d(var30)) {
                                    var25 = (y.c.q)var3.b(var30);
                                    if(var25 == null) {
                                       break label247;
                                    }

                                    var4.b(var21, var25, var32, var19.a());
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 if(var28.d(var21)) {
                                    var25 = (y.c.q)var2.b(var21);
                                    if(var25 == null) {
                                       break label247;
                                    }

                                    var4.b(var25, var30, var32, var19.a());
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 var4.b(var21, var30, var32, var19.a());
                                 if(!var27) {
                                    break label247;
                                 }
                              }

                              if(var22 == 1) {
                                 var23 = this.a(var21, var28, var5);
                                 if(var23 > var16) {
                                    break label247;
                                 }

                                 var32 = Math.min(var19.e(), var16 - var23);
                                 if(var28.d(var30) && var28.d(var21)) {
                                    var25 = (y.c.q)var2.b(var30);
                                    var26 = (y.c.q)var3.b(var21);
                                    if(var25 == null || var26 == null) {
                                       break label247;
                                    }

                                    var4.a(var26, var25, var32, var19.a());
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 if(var28.d(var30)) {
                                    var25 = (y.c.q)var2.b(var30);
                                    if(var25 == null) {
                                       break label247;
                                    }

                                    var4.a(var21, var25, var32, var19.a());
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 if(var28.d(var21)) {
                                    var25 = (y.c.q)var3.b(var21);
                                    if(var25 == null) {
                                       break label247;
                                    }

                                    var4.a(var25, var30, var32, var19.a());
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 var4.a(var21, var30, var32, var19.a());
                                 if(!var27) {
                                    break label247;
                                 }
                              }

                              y.c.q var31;
                              if(var22 == 2) {
                                 if(var16 != 0 || var28.a(var30) != null) {
                                    break label247;
                                 }

                                 if(var28.d(var30)) {
                                    var31 = (y.c.q)var2.b(var30);
                                    var4.a(var31);
                                    if(!var27) {
                                       break label247;
                                    }
                                 }

                                 var4.a(var30);
                                 if(!var27) {
                                    break label247;
                                 }
                              }

                              if(var22 == -2 && var16 == var6 - 1 && var28.a(var30) == null) {
                                 label250: {
                                    if(var28.d(var30)) {
                                       var31 = (y.c.q)var2.b(var30);
                                       var4.b(var31);
                                       if(!var27) {
                                          break label250;
                                       }
                                    }

                                    var4.b(var30);
                                 }
                              }
                           }
                        }

                        var17.g();
                        if(var27) {
                           break;
                        }
                     }
                  }

                  var29.g();
                  if(!var27) {
                     continue label208;
                  }
                  break;
               }

               var28.c();
               return;
            }
         }
      }
   }

   protected void a(y.f.X var1, y.f.c.s var2, aV var3) {
      boolean var17 = N.x;
      y.f.b.c var4 = new y.f.b.c(var1);
      y.c.e var5 = var1.p();

      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            y.c.q var7 = var6.c();
            y.c.q var8 = var6.d();
            aX var9 = var3.a(var7);
            aX var10 = var3.a(var8);
            if(var17) {
               break;
            }

            if(var9 != null && var10 != null && !var4.d(var7) && !var4.d(var8)) {
               label76: {
                  int var11 = var9.j();
                  int var12 = var10.j();
                  y.c.q var13 = var4.a(var7);
                  y.c.q var14 = var4.a(var8);
                  Object var15 = this.a.b(var7);
                  Object var16 = this.a.b(var8);
                  if(var13 == var14 && !this.a((y.c.q)var13, (y.c.i)var1, (y.f.b.c)var4)) {
                     if(var11 < var12) {
                        var2.a(var15, var16, 1, 100 * var1.g());
                        if(!var17) {
                           break label76;
                        }
                     }

                     if(var12 < var11) {
                        var2.a(var16, var15, 1);
                        if(!var17) {
                           break label76;
                        }
                     }

                     var2.b(var15, var16);
                     if(!var17) {
                        break label76;
                     }
                  }

                  if(var13 != var14 && (!this.a((y.c.q)var13, (y.c.i)var1, (y.f.b.c)var4) || !this.a((y.c.q)var14, (y.c.i)var1, (y.f.b.c)var4))) {
                     label79: {
                        if(var11 < var12) {
                           var2.a(var15, var16, 1);
                           if(!var17) {
                              break label79;
                           }
                        }

                        if(var12 < var11) {
                           var2.a(var16, var15, 1);
                           if(!var17) {
                              break label79;
                           }
                        }

                        var2.b(var15, var16);
                     }
                  }
               }
            }

            var5.g();
            if(!var17) {
               continue;
            }
         }

         var4.c();
         break;
      }

   }

   private boolean a(y.c.q var1, y.c.i var2, y.f.b.c var3) {
      return this.b == null?false:(var1 == null?this.b.d(var2):this.b.d(var1) || this.a(var3.a(var1), var2, var3));
   }

   aD(O var1) {
      this();
   }
}
