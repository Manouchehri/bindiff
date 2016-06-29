package y.f;

import java.awt.geom.Point2D.Double;
import java.util.HashMap;
import java.util.Map;
import y.f.X;
import y.f.a;
import y.f.ah;
import y.f.am;

public class aN extends a {
   private y.c.f b;
   public static final Object a = "y.layout.SelfLoopLayouter.KEEP_SELF_LOOP_LAYOUT_DPKEY";
   private byte c;
   private boolean d;
   private double e;
   private int f;
   private Map g;
   private int h;
   private int i;
   private int n;
   private int o;
   private boolean p;

   public aN() {
      this.c = 0;
      this.d = true;
      this.e = 5.0D;
      this.f = 2;
      this.h = 0;
      this.i = 1;
      this.n = 2;
      this.o = 3;
      this.b = new y.c.f();
   }

   public aN(ah var1) {
      this();
      this.a(var1);
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public void a(byte var1) {
      this.c = var1;
   }

   public void c(X var1) {
      label31: {
         label36: {
            boolean var4 = X.j;
            y.c.c var2 = var1.c(a);
            if(var2 != null || this.p) {
               this.g = new HashMap();
               y.c.x var3 = var1.o();

               while(var3.f()) {
                  this.g.put(var3.e(), var1.l(var3.e()));
                  var3.g();
                  if(var4) {
                     break label36;
                  }

                  if(var4) {
                     break;
                  }
               }
            }

            if(this.a() != null) {
               this.d(var1);
               this.a(var1);
               this.e(var1);
               this.b(var1);
               if(!var4) {
                  break label31;
               }
            }
         }

         this.b(var1);
      }

      this.g = null;
   }

   private y.c.D a(int var1, y.d.t var2, double var3, boolean var5, int var6) {
      y.c.D var7;
      int var8;
      boolean var16;
      label58: {
         var16 = X.j;
         var7 = new y.c.D();
         if(var1 == this.h) {
            var8 = 3 * (var6 - 1);
            if(!var16) {
               break label58;
            }
         }

         if(var1 == this.i) {
            var8 = 2 * (var6 - 1);
            if(!var16) {
               break label58;
            }
         }

         if(var1 == this.n) {
            var8 = var6 - 1;
            if(!var16) {
               break label58;
            }
         }

         var8 = 0;
      }

      y.c.D var10000;
      label59: {
         double var9 = 3.141592653589793D / (double)(2 * (var6 - 1));
         int var11;
         double var12;
         double var14;
         if(var5) {
            var11 = var8;

            do {
               if(var11 >= var8 + var6) {
                  break label59;
               }

               var12 = Math.cos((double)var11 * var9) * var3 + var2.a();
               var14 = Math.sin((double)var11 * var9) * var3 + var2.b();
               var10000 = var7;
               if(var16) {
                  return var10000;
               }

               var7.add(new y.d.t(var12, var14));
               ++var11;
            } while(!var16);
         }

         var11 = var8 + var6 - 1;

         while(var11 >= var8) {
            var12 = Math.cos((double)var11 * var9) * var3 + var2.a();
            var14 = Math.sin((double)var11 * var9) * var3 + var2.b();
            var10000 = var7;
            if(var16) {
               return var10000;
            }

            var7.add(new y.d.t(var12, var14));
            --var11;
            if(var16) {
               break;
            }
         }
      }

      var10000 = var7;
      return var10000;
   }

   protected void b(X var1) {
      y.c.x var2;
      boolean var10000;
      boolean var46;
      label245: {
         var46 = X.j;
         if(this.g != null || this.p) {
            var2 = var1.o();

            label214:
            do {
               var10000 = var2.f();

               label211:
               while(true) {
                  if(!var10000) {
                     break label214;
                  }

                  y.d.t var3 = var1.l(var2.e());
                  y.d.t var4 = (y.d.t)this.g.get(var2.e());
                  var10000 = var3.equals(var4);
                  if(var46) {
                     break label245;
                  }

                  if(var10000 || var4 == null) {
                     break;
                  }

                  double var5 = var3.a - var4.a;
                  double var7 = var3.b - var4.b;
                  y.c.e var9 = var2.e().k();

                  while(true) {
                     if(!var9.f()) {
                        break label211;
                     }

                     var10000 = var9.a().e();
                     if(var46) {
                        break;
                     }

                     label206: {
                        if(var10000 && !this.a(var1, var9.a())) {
                           y.c.D var10 = var1.k(var9.a());
                           if(var10.size() > 0) {
                              y.c.p var11 = var10.k();

                              while(var11 != null) {
                                 y.d.t var12 = (y.d.t)var11.c();
                                 var12 = new y.d.t(var12.a + var5, var12.b + var7);
                                 var11.a(var12);
                                 var11 = var11.a();
                                 if(var46) {
                                    break label206;
                                 }

                                 if(var46) {
                                    break;
                                 }
                              }

                              var1.b(var9.a(), var10);
                           }
                        }

                        var9.g();
                     }

                     if(var46) {
                        break label211;
                     }
                  }
               }

               var2.g();
            } while(!var46);
         }

         var2 = var1.o();
      }

      for(var10000 = var2.f(); var10000; var10000 = var2.f()) {
         y.c.q var47 = var2.e();
         y.c.f var48 = new y.c.f();
         y.c.e var49 = var47.l();

         while(true) {
            if(!var49.f()) {
               var10000 = var48.isEmpty();
               break;
            }

            y.c.d var6 = var49.a();
            var10000 = var6.e();
            if(var46) {
               break;
            }

            if(var10000 && this.a(var1, var6)) {
               var48.add(var6);
            }

            var49.g();
            if(var46) {
               var10000 = var48.isEmpty();
               break;
            }
         }

         if(!var10000) {
            int var50 = var48.size();
            y.c.d[] var51 = var48.e();
            am var52 = var1.h(var47);
            double var8 = var52.getX();
            double var53 = var52.getY();
            double var54 = var52.getX() + var52.getWidth();
            double var14 = var52.getY() + var52.getHeight();
            double var16 = var52.getWidth() * 0.5D;
            double var18 = var52.getHeight() * 0.5D;
            double var20 = Math.min(var16 / (double)(var50 + 1), this.e);
            double var22 = Math.min(var18 / (double)(var50 + 1), this.e);
            double var24 = Math.min(var22, var20);
            double var26 = (var16 - (double)(var50 - 1) * var24) / 2.0D;
            double var28 = (var18 - (double)(var50 - 1) * var24) / 2.0D;
            byte var55 = this.c;
            byte var10001 = 1;

            label172:
            while(true) {
               double var30;
               double var34;
               double var36;
               int var38;
               int var39;
               y.c.d var40;
               y.d.t[] var41;
               double var42;
               y.c.D var43;
               y.c.D var44;
               y.d.t var45;
               double var56;
               y.d.t var57;
               label159:
               while(true) {
                  label143:
                  while(true) {
                     label127:
                     while(true) {
                        if(var55 == var10001) {
                           var26 = (var16 - (double)(var50 - 1) * var20) / 2.0D;
                           var28 = (var18 - (double)(var50 - 1) * var22) / 2.0D;
                        }

                        var30 = 6.0D;
                        double var32 = 12.0D;
                        var34 = var30 + Math.max(15.0D, var30 + var32 - var28);
                        var36 = var30 + Math.max(15.0D, var30 + var32 - var26);
                        var38 = this.a(var1, var47);
                        if(this.d) {
                           if(var38 != this.i) {
                              break;
                           }

                           var39 = 0;
                        } else {
                           var39 = 0;
                        }

                        while(true) {
                           if(var39 >= var51.length) {
                              break label172;
                           }

                           var40 = var51[var39];
                           var55 = this.c;
                           var10001 = 1;
                           if(var46) {
                              break;
                           }

                           label122: {
                              if(var55 == 1) {
                                 var41 = new y.d.t[5];
                                 var41[0] = new y.d.t(var8 + var26 + (double)var39 * var20, var53);
                                 var41[1] = new y.d.t(var41[0].a(), var53 - var34 - (double)var39 * this.e);
                                 var41[4] = new y.d.t(var8, var53 + var28 + (double)var39 * var22);
                                 var41[3] = new y.d.t(var8 - var36 - (double)var39 * this.e, var41[4].b());
                                 var41[2] = new y.d.t(var41[3].a(), var41[1].b());
                                 var42 = var30 + 0.25D * (double)var39 * (var20 + var22);
                                 var44 = new y.c.D();
                                 var44.add(var41[0]);
                                 var44.a(this.a(var41[1], var42, this.h, false, this.f));
                                 var44.a(this.a(var41[2], var42, this.i, false, this.f));
                                 var44.a(this.a(var41[3], var42, this.n, false, this.f));
                                 var44.add(var41[4]);
                                 var1.a(var40, var44);
                                 if(!var46) {
                                    break label122;
                                 }
                              }

                              var56 = (double)var39 * var24;
                              var43 = new y.c.D();
                              var57 = new y.d.t(var8 + var26 + var56, var53);
                              var43.add(var57);
                              var43.add(new y.d.t(var8 + var26 + var56, var53 - 15.0D - var56));
                              var43.add(new y.d.t(var8 - 15.0D - var56, var53 - 15.0D - var56));
                              var43.add(new y.d.t(var8 - 15.0D - var56, var53 + var28 + var56));
                              var45 = new y.d.t(var8, var53 + var28 + var56);
                              var43.add(var45);
                              var1.a(var40, var43);
                           }

                           ++var39;
                           if(var46) {
                              break label127;
                           }
                        }
                     }

                     if(var38 != this.n) {
                        break;
                     }

                     var39 = 0;

                     while(true) {
                        if(var39 >= var51.length) {
                           break label172;
                        }

                        var40 = var51[var39];
                        var55 = this.c;
                        var10001 = 1;
                        if(var46) {
                           break;
                        }

                        label138: {
                           if(var55 == 1) {
                              var41 = new y.d.t[5];
                              var41[0] = new y.d.t(var8 + var26 + (double)var39 * var20, var14);
                              var41[1] = new y.d.t(var41[0].a(), var14 + var34 + (double)var39 * this.e);
                              var41[4] = new y.d.t(var8, var14 - var28 - (double)var39 * var22);
                              var41[3] = new y.d.t(var8 - var36 - (double)var39 * this.e, var41[4].b());
                              var41[2] = new y.d.t(var41[3].a(), var41[1].b());
                              var42 = var30 + 0.25D * (double)var39 * (var20 + var22);
                              var44 = new y.c.D();
                              var44.add(var41[0]);
                              var44.a(this.a(var41[1], var42, this.o, true, this.f));
                              var44.a(this.a(var41[2], var42, this.n, true, this.f));
                              var44.a(this.a(var41[3], var42, this.i, true, this.f));
                              var44.add(var41[4]);
                              var1.a(var40, var44);
                              if(!var46) {
                                 break label138;
                              }
                           }

                           var56 = (double)var39 * var24;
                           var43 = new y.c.D();
                           var57 = new y.d.t(var8 + var26 + var56, var14);
                           var43.add(var57);
                           var43.add(new y.d.t(var8 + var26 + var56, var14 + 15.0D + var56));
                           var43.add(new y.d.t(var8 - 15.0D - var56, var14 + 15.0D + var56));
                           var43.add(new y.d.t(var8 - 15.0D - var56, var14 - var28 - var56));
                           var45 = new y.d.t(var8, var14 - var28 - var56);
                           var43.add(var45);
                           var1.a(var40, var43);
                        }

                        ++var39;
                        if(var46) {
                           break label143;
                        }
                     }
                  }

                  if(var38 != this.h) {
                     break;
                  }

                  var39 = 0;

                  while(true) {
                     if(var39 >= var51.length) {
                        break label172;
                     }

                     var40 = var51[var39];
                     var55 = this.c;
                     var10001 = 1;
                     if(var46) {
                        break;
                     }

                     label154: {
                        if(var55 == 1) {
                           var41 = new y.d.t[5];
                           var41[0] = new y.d.t(var54 - var26 - (double)var39 * var20, var53);
                           var41[1] = new y.d.t(var41[0].a(), var53 - var34 - (double)var39 * this.e);
                           var41[4] = new y.d.t(var54, var53 + var28 + (double)var39 * var22);
                           var41[3] = new y.d.t(var54 + var36 + (double)var39 * this.e, var41[4].b());
                           var41[2] = new y.d.t(var41[3].a(), var41[1].b());
                           var42 = var30 + 0.25D * (double)var39 * (var20 + var22);
                           var44 = new y.c.D();
                           var44.add(var41[0]);
                           var44.a(this.a(var41[1], var42, this.i, true, this.f));
                           var44.a(this.a(var41[2], var42, this.h, true, this.f));
                           var44.a(this.a(var41[3], var42, this.o, true, this.f));
                           var44.add(var41[4]);
                           var1.a(var40, var44);
                           if(!var46) {
                              break label154;
                           }
                        }

                        var56 = (double)var39 * var24;
                        var43 = new y.c.D();
                        var57 = new y.d.t(var54 - var26 - var56, var53);
                        var43.add(var57);
                        var43.add(new y.d.t(var54 - var26 - var56, var53 - 15.0D - var56));
                        var43.add(new y.d.t(var54 + 15.0D + var56, var53 - 15.0D - var56));
                        var43.add(new y.d.t(var54 + 15.0D + var56, var53 + var28 + var56));
                        var45 = new y.d.t(var54, var53 + var28 + var56);
                        var43.add(var45);
                        var1.a(var40, var43);
                     }

                     ++var39;
                     if(var46) {
                        break label159;
                     }
                  }
               }

               if(var38 != this.o) {
                  break;
               }

               var39 = 0;

               while(true) {
                  if(var39 >= var51.length) {
                     break label172;
                  }

                  var40 = var51[var39];
                  var55 = this.c;
                  var10001 = 1;
                  if(var46) {
                     break;
                  }

                  label167: {
                     if(var55 == 1) {
                        var41 = new y.d.t[5];
                        var41[0] = new y.d.t(var54 - var26 - (double)var39 * var20, var14);
                        var41[1] = new y.d.t(var41[0].a(), var14 + var34 + (double)var39 * this.e);
                        var41[4] = new y.d.t(var54, var14 - var28 - (double)var39 * var22);
                        var41[3] = new y.d.t(var54 + var36 + (double)var39 * this.e, var41[4].b());
                        var41[2] = new y.d.t(var41[3].a(), var41[1].b());
                        var42 = var30 + 0.25D * (double)var39 * (var20 + var22);
                        var44 = new y.c.D();
                        var44.add(var41[0]);
                        var44.a(this.a(var41[1], var42, this.n, false, this.f));
                        var44.a(this.a(var41[2], var42, this.o, false, this.f));
                        var44.a(this.a(var41[3], var42, this.h, false, this.f));
                        var44.add(var41[4]);
                        var1.a(var40, var44);
                        if(!var46) {
                           break label167;
                        }
                     }

                     var56 = (double)var39 * var24;
                     var43 = new y.c.D();
                     var57 = new y.d.t(var54 - var26 - var56, var14);
                     var43.add(var57);
                     var43.add(new y.d.t(var54 - var26 - var56, var14 + 15.0D + var56));
                     var43.add(new y.d.t(var54 + 15.0D + var56, var14 + 15.0D + var56));
                     var43.add(new y.d.t(var54 + 15.0D + var56, var14 - var28 - var56));
                     var45 = new y.d.t(var54, var14 - var28 - var56);
                     var43.add(var45);
                     var1.a(var40, var43);
                  }

                  ++var39;
                  if(var46) {
                     break label172;
                  }
               }
            }
         }

         var2.g();
         if(var46) {
            break;
         }
      }

   }

   private y.c.D a(y.d.t var1, double var2, int var4, boolean var5, int var6) {
      y.c.D var7 = new y.c.D();
      if(var6 < 2) {
         var7.add(var1);
         if(!X.j) {
            return var7;
         }
      }

      if(var4 == this.h) {
         return this.a(this.h, var1.b(-var2, var2), var2, var5, var6);
      } else if(var4 == this.i) {
         return this.a(this.i, var1.b(var2, var2), var2, var5, var6);
      } else if(var4 == this.n) {
         return this.a(this.n, var1.b(var2, -var2), var2, var5, var6);
      } else if(var4 == this.o) {
         return this.a(this.o, var1.b(-var2, -var2), var2, var5, var6);
      } else {
         if(var5) {
            var7.n();
         }

         return var7;
      }
   }

   private int a(X var1, y.c.q var2) {
      boolean var17 = X.j;
      y.d.t var3 = var1.l(var2);
      y.d.y var4 = var1.s(var2);
      int[] var5 = new int[4];
      y.c.e var6 = var2.j();

      int var10000;
      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            var10000 = var7.e();
            if(var17) {
               break;
            }

            if(var10000 == 0 || !this.a(var1, var7)) {
               label82: {
                  y.c.D var8 = var1.m(var7);
                  y.d.t var9 = (y.d.t)(var7.c() == var2?var8.f():var8.i());
                  y.d.t var10 = (y.d.t)(var7.c() == var2?var8.get(1):var8.get(var8.size() - 2));
                  y.d.t var11 = a(var4, var9, var10);
                  y.d.t var12 = var11 != null?var11:var9;
                  double var13 = var12.a() - var3.a();
                  double var15 = var12.b() - var3.b();
                  if(var13 > 0.0D && var15 > 0.0D) {
                     ++var5[this.o];
                     if(!var17) {
                        break label82;
                     }
                  }

                  if(var13 > 0.0D && var15 < 0.0D) {
                     ++var5[this.h];
                     if(!var17) {
                        break label82;
                     }
                  }

                  if(var13 < 0.0D && var15 < 0.0D) {
                     ++var5[this.i];
                     if(!var17) {
                        break label82;
                     }
                  }

                  ++var5[this.n];
               }
            }

            var6.g();
            if(!var17) {
               continue;
            }
         }

         var10000 = this.h;
         break;
      }

      int var18 = var10000;
      if(var5[this.i] < var5[var18]) {
         var18 = this.i;
      }

      if(var5[this.n] < var5[var18]) {
         var18 = this.n;
      }

      if(var5[this.o] < var5[var18]) {
         var18 = this.o;
      }

      return var18;
   }

   private static y.d.t a(y.d.y var0, y.d.t var1, y.d.t var2) {
      if(var0.a(var1) && !var0.a(var2)) {
         Double var3 = a(var0.c, var0.d, var0.a(), var0.b(), var1.a, var1.b, var2.a, var2.b, (Double)null);
         return new y.d.t(var3.x, var3.y);
      } else {
         return null;
      }
   }

   private static Double a(double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, Double var16) {
      if(var16 == null) {
         var16 = new Double();
      }

      if(var8 >= var0 && var10 >= var2 && var8 <= var0 + var4 && var10 <= var2 + var6) {
         double var17 = var12 - var8;
         double var19 = var14 - var10;
         if(var17 == 0.0D) {
            if(var19 < 0.0D) {
               var16.x = var8;
               var16.y = var2;
               return var16;
            } else {
               var16.x = var8;
               var16.y = var2 + var6;
               return var16;
            }
         } else if(var19 == 0.0D) {
            if(var17 < 0.0D) {
               var16.x = var0;
               var16.y = var10;
               return var16;
            } else {
               var16.x = var0 + var4;
               var16.y = var10;
               return var16;
            }
         } else {
            double var21 = var19 / var17;
            double var23;
            if(var17 > 0.0D) {
               var23 = var10 + var21 * (var0 + var4 - var8);
               if(var23 < var2) {
                  var16.x = var8 + (var2 - var10) / var21;
                  var16.y = var2;
                  return var16;
               } else if(var23 <= var2 + var6) {
                  var16.x = var0 + var4;
                  var16.y = var23;
                  return var16;
               } else {
                  var16.x = var8 + (var2 + var6 - var10) / var21;
                  var16.y = var2 + var6;
                  return var16;
               }
            } else {
               var23 = var10 + var21 * (var0 - var8);
               if(var23 < var2) {
                  var16.x = var8 + (var2 - var10) / var21;
                  var16.y = var2;
                  return var16;
               } else if(var23 <= var2 + var6) {
                  var16.x = var0;
                  var16.y = var23;
                  return var16;
               } else {
                  var16.x = var8 + (var2 + var6 - var10) / var21;
                  var16.y = var2 + var6;
                  return var16;
               }
            }
         }
      } else {
         var16.x = var8;
         var16.y = var10;
         return var16;
      }
   }

   private boolean a(X var1, y.c.d var2) {
      if(this.p) {
         return false;
      } else if(this.g == null) {
         return true;
      } else {
         y.c.c var3 = var1.c(a);
         return var3 == null || !var3.d(var2);
      }
   }

   private void d(X var1) {
      boolean var3 = X.j;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         if(var2.a().e()) {
            this.b.c(var2.a());
            var1.d(var2.a());
         }

         var2.g();
         if(var3) {
            break;
         }
      }

   }

   private void e(X var1) {
      boolean var2 = X.j;

      while(!this.b.isEmpty()) {
         var1.e(this.b.d());
         if(var2) {
            break;
         }
      }

   }
}
