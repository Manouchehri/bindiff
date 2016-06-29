package y.f.c.a;

import java.util.ArrayList;
import java.util.List;
import y.f.c.a.N;
import y.f.c.a.bY;
import y.f.c.a.bv;
import y.f.c.a.cB;
import y.f.c.a.cr;
import y.f.c.a.cy;

public class bu {
   private static final double g = Math.sqrt(2.0D);
   private List h = new ArrayList(60);
   private bv[] i = new bv[60];
   public static final Object a = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_NODE_DISTANCE_DPKEY";
   public static final Object b = "y.layout.hierarchic.incremental.SelfloopCalculator.IS_OCTILINEAR_DPKEY";
   public static final Object c = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_OCTILINEAR_SEGMENT_LENGTH_DPKEY";
   public static final Object d = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_FIRST_SEGMENT_LENGTH_DPKEY";
   public static final Object e = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_LAST_SEGMENT_LENGTH_DPKEY";
   public static final Object f = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_EDGE_DISTANCE_DPKEY";
   private double j;
   private double k;
   private double l;

   public bu(double var1, double var3) {
      this.l = var3;
      this.j = this.k = var1;
   }

   void a(y.f.X var1, y.c.q var2, y.c.p var3, y.c.c var4, y.c.c var5, y.d.c[] var6) {
      boolean var10 = N.x;
      int var7 = 0;

      int var10000;
      while(true) {
         if(var3 != null) {
            y.c.d var8 = (y.c.d)var3.c();
            var10000 = var8.e();
            if(var10) {
               break;
            }

            if(var10000 != 0) {
               bv var9;
               label37: {
                  if(this.h.size() > var7) {
                     var9 = (bv)this.h.get(var7);
                     if(!var10) {
                        break label37;
                     }
                  }

                  var9 = new bv();
                  this.h.add(var9);
               }

               var9.a = var8;
               var9.b = var4 == null?3:bY.a((y.f.aE)((y.f.aE)var4.b(var8)), 3);
               var9.c = var5 == null?3:bY.a((y.f.aE)((y.f.aE)var5.b(var8)), 0);
               ++var7;
            }

            var3 = var3.a();
            if(!var10) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      if(var10000 > 0) {
         this.a(var1, var2, var7, var6);
      }

   }

   private void a(y.f.X var1, y.c.q var2, int var3, y.d.c[] var4) {
      boolean var20 = N.x;
      this.i = (bv[])this.h.toArray(this.i);
      y.f.am var5 = var1.a((Object)var2);
      double var8 = this.a(var1, var2);
      cr[] var10 = new cr[4];
      int var11 = 0;

      while(true) {
         if(var11 < 4) {
            var10[var11] = new cr();
            var10[var11].c(var8);
            y.d.c var12 = new y.d.c(-1.7976931348623157E308D, Double.MAX_VALUE, 0.0D);
            if(var20) {
               break;
            }

            if(var4 != null && var4.length > var11 && var4[var11] != null) {
               y.d.c var14;
               label158: {
                  y.d.c var13;
                  y.d.d var15;
                  label159: {
                     var13 = var4[var11];
                     var14 = new y.d.c(-1.7976931348623157E308D, Double.MAX_VALUE, 0.0D);
                     switch(var11) {
                     case 0:
                        var13.b(-var5.getWidth() * 0.5D);
                        var15 = var13.f();

                        label134: {
                           while(var15 != null) {
                              var14.c(var13.b(var15), var13.d(var15), -var13.a(var15));
                              var15 = var15.b();
                              if(var20) {
                                 break label134;
                              }

                              if(var20) {
                                 break;
                              }
                           }

                           var13.b(var5.getWidth() * 0.5D);
                        }

                        if(!var20) {
                           break label158;
                        }
                     case 1:
                        var13.b(-var5.getHeight() * 0.5D);
                        var13.a(-var5.getWidth());
                        var15 = var13.f();

                        label122: {
                           while(var15 != null) {
                              var14.c(var13.b(var15), var13.d(var15), var13.a(var15));
                              var15 = var15.b();
                              if(var20) {
                                 break label122;
                              }

                              if(var20) {
                                 break;
                              }
                           }

                           var13.a(var5.getWidth());
                           var13.b(var5.getHeight() * 0.5D);
                        }

                        if(!var20) {
                           break label158;
                        }
                     case 2:
                        break;
                     case 3:
                        break label159;
                     default:
                        break label158;
                     }

                     var13.b(-var5.getWidth() * 0.5D);
                     var13.a(-var5.getHeight());
                     var15 = var13.f();

                     label110: {
                        while(var15 != null) {
                           var14.c(-var13.d(var15), -var13.b(var15), var13.a(var15));
                           var15 = var15.b();
                           if(var20) {
                              break label110;
                           }

                           if(var20) {
                              break;
                           }
                        }

                        var13.a(var5.getHeight());
                        var13.b(var5.getWidth() * 0.5D);
                     }

                     if(!var20) {
                        break label158;
                     }
                  }

                  var13.b(-var5.getHeight() * 0.5D);
                  var15 = var13.f();

                  while(var15 != null) {
                     var14.c(-var13.d(var15), -var13.b(var15), -var13.a(var15));
                     var15 = var15.b();
                     if(var20) {
                        break label158;
                     }

                     if(var20) {
                        break;
                     }
                  }

                  var13.b(var5.getHeight() * 0.5D);
               }

               var12.a(var14);
            }

            var10[var11].b(var12);
            ++var11;
            if(!var20) {
               continue;
            }
         }

         this.a(var1, var3, var5, var10, 1.0D);
         break;
      }

      var11 = 0;

      while(true) {
         if(var11 < 4) {
            var10[var11].j();
            ++var11;
            if(var20) {
               break;
            }

            if(!var20) {
               continue;
            }
         }

         var11 = 0;
         break;
      }

      while(var11 < var3) {
         bv var21 = this.i[var11];
         y.f.I var22 = var1.b(var21.a);
         var22.clearPoints();
         int var23 = 4 + var21.c - var21.b & 3;
         y.d.t var24 = var1.n(var21.a);
         y.d.t var16 = var1.o(var21.a);
         y.c.D var17 = this.b(var1, var21.a)?b(var5, var10, var21, var23, var24, var16):a(var5, var10, var21, var23, var24, var16);
         y.c.C var18 = var17.m();

         while(true) {
            if(var18.f()) {
               y.d.t var19 = (y.d.t)var18.d();
               var22.addPoint(var19.a, var19.b);
               var18.g();
               if(var20) {
                  break;
               }

               if(!var20) {
                  continue;
               }
            }

            ++var11;
            break;
         }

         if(var20) {
            break;
         }
      }

   }

   private void a(y.f.X var1, int var2, y.f.am var3, cr[] var4, double var5) {
      boolean var52 = N.x;
      double var7 = (Math.max(var3.getWidth(), var3.getHeight()) + 50.0D) * 4.0D;
      cB var9 = cB.b((y.c.i)var1);
      int var10 = 0;

      while(var10 < var2) {
         bv var11 = this.i[var10];
         int var12 = 4 + var11.c - var11.b & 3;
         y.d.t var13 = var1.n(var11.a);
         y.d.t var14 = var1.o(var11.a);
         boolean var15 = this.b(var1, var11.a);
         double var16 = this.c(var1, var11.a);
         double var18 = var16 / g;
         double var22 = this.e(var1, var11.a);
         double var24 = this.a(var1, var11.a);
         double var26 = this.d(var1, var11.a);
         double[] var28 = new double[2];
         y.d.q var29 = null;
         double var30 = var15?var18:0.0D;
         double var32;
         double var34;
         double var36;
         double var38;
         double var40;
         double var42;
         double var44;
         double var46;
         label206:
         switch(var12) {
         case 0:
            switch(var11.b) {
            case 0:
            default:
               var32 = var13.a;
               var34 = var14.a;
               var9.a(var1, var11.a, (byte)0, var28, true, var13.a < var14.a);
               var4[var11.b].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var32, true, var34, true, var15, var16).k = Math.max(var24, var26);
               if(!var52) {
                  break label206;
               }
            case 1:
               var32 = var13.b;
               var34 = var14.b;
               var9.a(var1, var11.a, (byte)1, var28, false, var13.b < var14.b);
               var4[var11.b].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var32, true, var34, true, var15, var16).k = Math.max(var24, var26);
               if(!var52) {
                  break label206;
               }
            case 2:
               var32 = -var13.a;
               var34 = -var14.a;
               var9.a(var1, var11.a, (byte)0, var28, true, var13.a < var14.a);
               var4[var11.b].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var32, true, var34, true, var15, var16).k = Math.max(var24, var26);
               if(!var52) {
                  break label206;
               }
            case 3:
               var32 = -var13.b;
               var34 = -var14.b;
               var9.a(var1, var11.a, (byte)1, var28, false, var13.b < var14.b);
               var4[var11.b].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var32, true, var34, true, var15, var16).k = Math.max(var24, var26);
               if(!var52) {
                  break label206;
               }
            }
         case 1:
            var40 = 0.0D;
            var42 = 0.0D;
            switch(var11.b) {
            case 0:
            default:
               var32 = var13.a;
               var38 = var14.b;
               var34 = var7 + var14.b;
               var36 = -var7 + var13.a;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, true);
               var42 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D + var32 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getHeight() * 0.5D + var14.b)):var24;
               var4[var11.b].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var32, true, var34, true, var15, var16).k = var44;
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getWidth() * 0.5D - var13.a)):var26;
               var4[var11.c].a(var11, var5, var22, var38, true, var36, true, var15, var16).k = Math.max(var46, var42);
               break label206;
            case 1:
               var32 = var13.b;
               var38 = -var14.a;
               var34 = var7 - var14.a;
               var36 = -var7 + var13.b;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, false);
               var40 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D - var38 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getWidth() * 0.5D - var14.a)):var24;
               var4[var11.b].a(var11, var5, var22, var32, true, var34, true, var15, var16).k = Math.max(var44, var40);
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getHeight() * 0.5D - var13.b)):var26;
               var4[var11.c].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var38, true, var36, true, var15, var16).k = var46;
               break label206;
            case 2:
               var32 = -var13.a;
               var38 = -var14.b;
               var34 = var7 - var14.b;
               var36 = -var7 - var13.a;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, false);
               var42 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D + var32 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getHeight() * 0.5D - var14.b)):var24;
               var4[var11.b].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var32, true, var34, true, var15, var16).k = var44;
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getWidth() * 0.5D + var13.a)):var26;
               var4[var11.c].a(var11, var5, var22, var38, true, var36, true, var15, var16).k = Math.max(var46, var42);
               break label206;
            case 3:
               var32 = -var13.b;
               var38 = var14.a;
               var34 = var7 + var14.a;
               var36 = -var7 - var13.b;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, true);
               var40 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D - var38 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getWidth() * 0.5D + var14.a)):var24;
               var4[var11.b].a(var11, var5, var22, var32, true, var34, true, var15, var16).k = Math.max(var44, var40);
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getHeight() * 0.5D + var13.b)):var26;
               var4[var11.c].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var38, true, var36, true, var15, var16).k = var46;
               break label206;
            }
         case 2:
            var46 = 0.0D;
            double var48 = 0.0D;
            double[] var51 = new double[2];
            y.d.q var50;
            switch(var11.b) {
            case 0:
            default:
               var32 = var13.a;
               var38 = -var14.a;
               var34 = var7 - var14.a;
               var36 = -var7 + var13.a;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, true, (byte)2);
               var50 = var9.a(var1, var11.a, (byte)0, var51, true, false, (byte)1);
               var48 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D + var32 + var30);
               var48 = Math.max(var48, var50.a - var3.getWidth() * 0.5D - var38 + var30);
               var40 = var15?Math.max(var24, (var16 - var3.getHeight()) * 0.5D):var24;
               var4[var11.b].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var32, true, var34 + var7, true, var15, var16).k = var40;
               var42 = var15?Math.max(var26, var18 + var16 - (var3.getWidth() * 0.5D - Math.max(var13.a, var14.a))):var26;
               var4[var11.b + 1 & 3].a(var11, var5, var22, var34, true, var36, true, var15, var16).k = Math.max(var42, var48);
               var44 = var15?Math.max(var26, (var16 - var3.getHeight()) * 0.5D):var26;
               var4[var11.c].a(var11, var5, Math.max(var22, var51[0] * 2.0D), Math.max(var22, var51[1] * 2.0D), var38, true, var36 - var7, true, var15, var16).k = var44;
               break label206;
            case 1:
               var32 = var13.b;
               var38 = -var14.b;
               var34 = var7 - var14.b;
               var36 = -var7 + var13.b;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, false);
               var46 = Math.max(0.0D, var29.a - var3.getWidth());
               var40 = var15?Math.max(var24, (var16 - var3.getWidth()) * 0.5D):var24;
               var4[var11.b].a(var11, var5, var22, var32, true, var34 + var7, true, var15, var16).k = Math.max(var40, var46);
               var42 = var15?Math.max(var26, var18 + var16 - (var3.getHeight() * 0.5D - Math.max(var13.b, var14.b))):var26;
               var4[var11.b + 1 & 3].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var34, true, var36, true, var15, var16).k = var42;
               var44 = var15?Math.max(var26, (var16 - var3.getWidth()) * 0.5D):var26;
               var4[var11.c].a(var11, var5, var22, var38, true, var36 - var7, true, var15, var16).k = var44;
               break label206;
            case 2:
               var32 = -var13.a;
               var38 = var14.a;
               var34 = var7 + var14.a;
               var36 = -var7 - var13.a;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, false, (byte)2);
               var50 = var9.a(var1, var11.a, (byte)0, var51, true, true, (byte)1);
               var48 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D + var32 + var30);
               var48 = Math.max(var48, var50.a - var3.getWidth() * 0.5D - var38 + var30);
               var40 = var15?Math.max(var24, (var16 - var3.getHeight()) * 0.5D):var24;
               var4[var11.b].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var32, true, var34 + var7, true, var15, var16).k = var40;
               var42 = var15?Math.max(var26, var18 + var16 - (var3.getWidth() * 0.5D + Math.min(var13.a, var14.a))):var26;
               var4[var11.b + 1 & 3].a(var11, var5, var22, var34, true, var36, true, var15, var16).k = Math.max(var42, var48);
               var44 = var15?Math.max(var26, (var16 - var3.getHeight()) * 0.5D):var26;
               var4[var11.c].a(var11, var5, Math.max(var22, var51[1] * 2.0D), Math.max(var22, var51[0] * 2.0D), var38, true, var36 - var7, true, var15, var16).k = var44;
               break label206;
            case 3:
               var32 = -var13.b;
               var38 = var14.b;
               var34 = var7 + var14.b;
               var36 = -var7 - var13.b;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, true);
               var46 = Math.max(0.0D, var29.a - var3.getWidth());
               var40 = var15?Math.max(var24, (var16 - var3.getWidth()) * 0.5D):var24;
               var4[var11.b].a(var11, var5, var22, var32, true, var34 + var7, true, var15, var16).k = Math.max(var40, var46);
               var42 = var15?Math.max(var26, var18 + var16 - (var3.getHeight() * 0.5D + Math.min(var13.b, var14.b))):var26;
               var4[var11.b + 1 & 3].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var34, true, var36, true, var15, var16).k = var42;
               var44 = var15?Math.max(var26, (var16 - var3.getWidth()) * 0.5D):var26;
               var4[var11.c].a(var11, var5, var22, var38, true, var36 - var7, true, var15, var16).k = var44;
               break label206;
            }
         case 3:
            var40 = 0.0D;
            var42 = 0.0D;
            switch(var11.b) {
            case 0:
            default:
               var32 = var13.a;
               var38 = -var14.b;
               var34 = -var7 - var14.b;
               var36 = var7 + var13.a;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, false);
               var42 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D - var32 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getHeight() * 0.5D + var14.b)):var24;
               var4[var11.b].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var32, true, var34, true, var15, var16).k = var44;
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getWidth() * 0.5D + var13.a)):var26;
               var4[var11.c].a(var11, var5, var22, var38, true, var36, true, var15, var16).k = Math.max(var46, var42);
               break;
            case 1:
               var32 = var13.b;
               var38 = var14.a;
               var34 = -var7 + var14.a;
               var36 = var7 + var13.b;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, false);
               var40 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D + var38 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getWidth() * 0.5D - var14.a)):var24;
               var4[var11.b].a(var11, var5, var22, var32, true, var34, true, var15, var16).k = Math.max(var44, var40);
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getHeight() * 0.5D + var13.b)):var26;
               var4[var11.c].a(var11, var5, Math.max(var22, var28[1] * 2.0D), Math.max(var22, var28[0] * 2.0D), var38, true, var36, true, var15, var16).k = var46;
               break;
            case 2:
               var32 = -var13.a;
               var38 = var14.b;
               var34 = -var7 + var14.b;
               var36 = var7 - var13.a;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, true);
               var42 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D - var32 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getHeight() * 0.5D - var14.b)):var24;
               var4[var11.b].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var32, true, var34, true, var15, var16).k = var44;
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getWidth() * 0.5D - var13.a)):var26;
               var4[var11.c].a(var11, var5, var22, var38, true, var36, true, var15, var16).k = Math.max(var46, var42);
               break;
            case 3:
               var32 = -var13.b;
               var38 = -var14.a;
               var34 = -var7 - var14.a;
               var36 = var7 - var13.b;
               var29 = var9.a(var1, var11.a, (byte)0, var28, true, true);
               var40 = Math.max(0.0D, var29.a - var3.getWidth() * 0.5D + var38 + var30);
               var44 = var15?Math.max(var24, var18 + var16 - (var3.getWidth() * 0.5D + var14.a)):var24;
               var4[var11.b].a(var11, var5, var22, var32, true, var34, true, var15, var16).k = Math.max(var44, var40);
               var46 = var15?Math.max(var26, var18 + var16 - (var3.getHeight() * 0.5D - var13.b)):var26;
               var4[var11.c].a(var11, var5, Math.max(var22, var28[0] * 2.0D), Math.max(var22, var28[1] * 2.0D), var38, true, var36, true, var15, var16).k = var46;
            }
         }

         ++var10;
         if(var52) {
            break;
         }
      }

   }

   private static y.c.D a(y.f.am var0, cr[] var1, bv var2, int var3, y.d.t var4, y.d.t var5) {
      boolean var14 = N.x;
      y.c.D var6 = new y.c.D();
      int var7 = var2.b;
      int var8 = var2.c;
      boolean var9 = (var2.c & 1) == 0;
      y.d.t var10;
      y.d.t var11;
      switch(var3) {
      case 0:
         var10 = a(var0, var4, var7, var1[var2.b].d(var2));
         var6.add(var10);
         var11 = a(var0, var5, var8, var1[var2.c].d(var2));
         var6.add(var11);
         if(!var14) {
            break;
         }
      case 1:
      case 3:
         label35: {
            var10 = a(var0, var4, var7, var1[var2.b].d(var2));
            var6.add(var10);
            var11 = a(var0, var5, var8, var1[var2.c].d(var2));
            if(var9) {
               var6.add(new y.d.t(var10.a, var11.b));
               if(!var14) {
                  break label35;
               }
            }

            var6.add(new y.d.t(var11.a, var10.b));
         }

         var6.add(var11);
         if(!var14) {
            break;
         }
      case 2:
         var10 = a(var0, var4, var7, var1[var2.b].d(var2));
         var11 = a(var0, var5, var8, var1[var2.c].d(var2));
         double var12 = var1[var2.b + 1 & 3].d(var2);
         var6.add(var10);
         switch(var2.b) {
         case 0:
            var6.add(new y.d.t(var0.getX() + var0.getWidth() + var12, var10.b));
            var6.add(new y.d.t(var0.getX() + var0.getWidth() + var12, var11.b));
            if(!var14) {
               break;
            }
         case 1:
            var6.add(new y.d.t(var10.a, var0.getY() + var0.getHeight() + var12));
            var6.add(new y.d.t(var11.a, var0.getY() + var0.getHeight() + var12));
            if(!var14) {
               break;
            }
         case 2:
            var6.add(new y.d.t(var0.getX() - var12, var10.b));
            var6.add(new y.d.t(var0.getX() - var12, var11.b));
            if(!var14) {
               break;
            }
         case 3:
            var6.add(new y.d.t(var10.a, var0.getY() - var12));
            var6.add(new y.d.t(var11.a, var0.getY() - var12));
         }

         var6.add(var11);
      }

      return var6;
   }

   protected double a(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(d);
      return var3 != null?var3.c(var2):this.j;
   }

   protected boolean b(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(b);
      return var3 != null?var3.d(var2):false;
   }

   protected double c(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(c);
      return var3 != null?var3.c(var2):0.0D;
   }

   protected double d(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(e);
      return var3 != null?var3.c(var2):this.k;
   }

   protected double e(y.f.X var1, y.c.d var2) {
      y.c.c var3 = var1.c(f);
      return var3 != null?var3.c(var2):this.l;
   }

   protected double a(y.f.X var1, y.c.q var2) {
      y.c.c var3 = var1.c(a);
      return var3 != null?var3.c(var2):Math.max(this.l, Math.max(this.j, this.k));
   }

   private static y.c.D b(y.f.am var0, cr[] var1, bv var2, int var3, y.d.t var4, y.d.t var5) {
      boolean var26 = N.x;
      y.c.D var6 = new y.c.D();
      double var7 = var0.getX() + var0.getWidth();
      double var9 = var0.getY() + var0.getHeight();
      cy var11;
      double var13;
      double var14;
      double var15;
      y.d.t var18;
      y.d.t var19;
      y.d.t var21;
      y.d.t var22;
      y.d.t var23;
      cy var27;
      y.d.t var30;
      y.d.t var31;
      switch(var3) {
      case 0:
         var11 = var1[var2.b].a((Object)var2);
         double var12;
         y.d.t var16;
         double var17;
         double var20;
         switch(var2.b) {
         case 0:
         default:
            var12 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var14 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var16 = new y.d.t(var12, var0.getY() - var11.d + (var11.p - var11.b));
            var6.add(var16);
            var17 = var12 < var14?var12 + (var11.p - var11.b):var12 - (var11.p - var11.b);
            var19 = new y.d.t(var17, var0.getY() - var11.d);
            var6.add(var19);
            var20 = var12 < var14?var14 - (var11.p - var11.b):var14 + (var11.p - var11.b);
            var22 = new y.d.t(var20, var19.b);
            var6.add(var22);
            var23 = new y.d.t(var14, var16.b);
            var6.add(var23);
            if(!var26) {
               return var6;
            }
         case 1:
            var12 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var14 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var16 = new y.d.t(var7 + var11.d - (var11.p - var11.b), var12);
            var6.add(var16);
            var17 = var12 < var14?var12 + (var11.p - var11.b):var12 - (var11.p - var11.b);
            var19 = new y.d.t(var7 + var11.d, var17);
            var6.add(var19);
            var20 = var12 < var14?var14 - (var11.p - var11.b):var14 + (var11.p - var11.b);
            var22 = new y.d.t(var19.a, var20);
            var6.add(var22);
            var23 = new y.d.t(var16.a, var14);
            var6.add(var23);
            if(!var26) {
               return var6;
            }
         case 2:
            var12 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var14 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var16 = new y.d.t(var12, var9 + var11.d - (var11.p - var11.b));
            var6.add(var16);
            var17 = var12 < var14?var12 + (var11.p - var11.b):var12 - (var11.p - var11.b);
            var19 = new y.d.t(var17, var9 + var11.d);
            var6.add(var19);
            var20 = var12 < var14?var14 - (var11.p - var11.b):var14 + (var11.p - var11.b);
            var22 = new y.d.t(var20, var19.b);
            var6.add(var22);
            var23 = new y.d.t(var14, var16.b);
            var6.add(var23);
            if(!var26) {
               return var6;
            }
         case 3:
            var12 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var14 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var16 = new y.d.t(var0.getX() - var11.d + (var11.p - var11.b), var12);
            var6.add(var16);
            var17 = var12 < var14?var12 + (var11.p - var11.b):var12 - (var11.p - var11.b);
            var19 = new y.d.t(var0.getX() - var11.d, var17);
            var6.add(var19);
            var20 = var12 < var14?var14 - (var11.p - var11.b):var14 + (var11.p - var11.b);
            var22 = new y.d.t(var19.a, var20);
            var6.add(var22);
            var23 = new y.d.t(var16.a, var14);
            var6.add(var23);
            if(!var26) {
               return var6;
            }
         }
      case 1:
         var11 = var1[var2.b].a((Object)var2);
         var27 = var1[var2.c].a((Object)var2);
         switch(var2.b) {
         case 0:
         default:
            var13 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var15 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var30 = new y.d.t(var13, var0.getY() - var11.d + (var11.p - var11.b));
            var6.add(var30);
            var18 = new y.d.t(var13 + (var11.p - var11.b), var0.getY() - var11.d);
            var6.add(var18);
            var19 = new y.d.t(var7 + var27.d - (var27.c - var27.q), var18.b);
            var6.add(var19);
            var31 = new y.d.t(var7 + var27.d, var19.b + (var27.c - var27.q));
            var6.add(var31);
            var21 = new y.d.t(var31.a, var15 - (var27.c - var27.q));
            var6.add(var21);
            var22 = new y.d.t(var21.a - (var27.c - var27.q), var15);
            var6.add(var22);
            if(!var26) {
               return var6;
            }
         case 1:
            var13 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var15 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var30 = new y.d.t(var7 + var11.d - (var11.p - var11.b), var13);
            var6.add(var30);
            var18 = new y.d.t(var7 + var11.d, var13 + (var11.p - var11.b));
            var6.add(var18);
            var19 = new y.d.t(var18.a, var9 + var27.d - (var27.c - var27.q));
            var6.add(var19);
            var31 = new y.d.t(var19.a - (var27.c - var27.q), var9 + var27.d);
            var6.add(var31);
            var21 = new y.d.t(var15 + (var27.c - var27.q), var31.b);
            var6.add(var21);
            var22 = new y.d.t(var15, var21.b - (var27.c - var27.q));
            var6.add(var22);
            if(!var26) {
               return var6;
            }
         case 2:
            var13 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var15 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var30 = new y.d.t(var13, var9 + var11.d - (var11.p - var11.b));
            var6.add(var30);
            var18 = new y.d.t(var13 - (var11.p - var11.b), var9 + var11.d);
            var6.add(var18);
            var19 = new y.d.t(var0.getX() - var27.d + (var27.c - var27.q), var18.b);
            var6.add(var19);
            var31 = new y.d.t(var0.getX() - var27.d, var19.b - (var27.c - var27.q));
            var6.add(var31);
            var21 = new y.d.t(var31.a, var15 + (var27.c - var27.q));
            var6.add(var21);
            var22 = new y.d.t(var21.a + (var27.c - var27.q), var15);
            var6.add(var22);
            if(!var26) {
               return var6;
            }
         case 3:
            var13 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var15 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var30 = new y.d.t(var0.getX() - var11.d + (var11.p - var11.b), var13);
            var6.add(var30);
            var18 = new y.d.t(var0.getX() - var11.d, var13 - (var11.p - var11.b));
            var6.add(var18);
            var19 = new y.d.t(var18.a, var0.getY() - var27.d + (var27.c - var27.q));
            var6.add(var19);
            var31 = new y.d.t(var19.a + (var27.c - var27.q), var0.getY() - var27.d);
            var6.add(var31);
            var21 = new y.d.t(var15 - (var27.c - var27.q), var31.b);
            var6.add(var21);
            var22 = new y.d.t(var15, var21.b + (var27.c - var27.q));
            var6.add(var22);
            if(!var26) {
               return var6;
            }
         }
      case 2:
         var11 = var1[var2.b].a((Object)var2);
         var27 = var1[var2.b + 1 & 3].a((Object)var2);
         cy var28 = var1[var2.c].a((Object)var2);
         y.d.t var24;
         y.d.t var25;
         double var29;
         switch(var2.b) {
         case 0:
         default:
            var14 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var29 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var18 = new y.d.t(var14, var0.getY() - var11.d + (var11.p - var11.b));
            var6.add(var18);
            var19 = new y.d.t(var14 + (var11.p - var11.b), var0.getY() - var11.d);
            var6.add(var19);
            var31 = new y.d.t(var7 + var27.d - (var11.p - var11.b), var19.b);
            var6.add(var31);
            var21 = new y.d.t(var7 + var27.d, var18.b);
            var6.add(var21);
            var22 = new y.d.t(var21.a, var9 + var28.d - (var28.c - var28.q));
            var6.add(var22);
            var23 = new y.d.t(var22.a - (var28.c - var28.q), var9 + var28.d);
            var6.add(var23);
            var24 = new y.d.t(var29 + (var28.c - var28.q), var23.b);
            var6.add(var24);
            var25 = new y.d.t(var29, var22.b);
            var6.add(var25);
            if(!var26) {
               return var6;
            }
         case 1:
            var14 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var29 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var18 = new y.d.t(var7 + var11.d - (var11.p - var11.b), var14);
            var6.add(var18);
            var19 = new y.d.t(var7 + var11.d, var14 + (var11.p - var11.b));
            var6.add(var19);
            var31 = new y.d.t(var19.a, var9 + var27.d - (var11.p - var11.b));
            var6.add(var31);
            var21 = new y.d.t(var18.a, var9 + var27.d);
            var6.add(var21);
            var22 = new y.d.t(var0.getX() - var28.d + (var28.c - var28.q), var21.b);
            var6.add(var22);
            var23 = new y.d.t(var0.getX() - var28.d, var22.b - (var28.c - var28.q));
            var6.add(var23);
            var24 = new y.d.t(var23.a, var29 + (var28.c - var28.q));
            var6.add(var24);
            var25 = new y.d.t(var22.a, var29);
            var6.add(var25);
            if(!var26) {
               return var6;
            }
         case 2:
            var14 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var29 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var18 = new y.d.t(var14, var9 + var11.d - (var11.p - var11.b));
            var6.add(var18);
            var19 = new y.d.t(var14 - (var11.p - var11.b), var9 + var11.d);
            var6.add(var19);
            var31 = new y.d.t(var0.getX() - var27.d + (var11.p - var11.b), var19.b);
            var6.add(var31);
            var21 = new y.d.t(var0.getX() - var27.d, var18.b);
            var6.add(var21);
            var22 = new y.d.t(var21.a, var0.getY() - var28.d + (var28.c - var28.q));
            var6.add(var22);
            var23 = new y.d.t(var22.a + (var28.c - var28.q), var0.getY() - var28.d);
            var6.add(var23);
            var24 = new y.d.t(var29 - (var28.c - var28.q), var23.b);
            var6.add(var24);
            var25 = new y.d.t(var29, var22.b);
            var6.add(var25);
            if(!var26) {
               return var6;
            }
         case 3:
            var14 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var29 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var18 = new y.d.t(var0.getX() - var11.d + (var11.p - var11.b), var14);
            var6.add(var18);
            var19 = new y.d.t(var0.getX() - var11.d, var14 - (var11.p - var11.b));
            var6.add(var19);
            var31 = new y.d.t(var19.a, var0.getY() - var27.d + (var11.p - var11.b));
            var6.add(var31);
            var21 = new y.d.t(var18.a, var0.getY() - var27.d);
            var6.add(var21);
            var22 = new y.d.t(var7 + var28.d - (var28.c - var28.q), var21.b);
            var6.add(var22);
            var23 = new y.d.t(var7 + var28.d, var22.b + (var28.c - var28.q));
            var6.add(var23);
            var24 = new y.d.t(var23.a, var29 - (var28.c - var28.q));
            var6.add(var24);
            var25 = new y.d.t(var22.a, var29);
            var6.add(var25);
            if(!var26) {
               return var6;
            }
         }
      case 3:
         var11 = var1[var2.b].a((Object)var2);
         var27 = var1[var2.c].a((Object)var2);
         switch(var2.b) {
         case 0:
         default:
            var13 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var15 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var30 = new y.d.t(var13, var0.getY() - var11.d + (var11.p - var11.b));
            var6.add(var30);
            var18 = new y.d.t(var13 - (var11.p - var11.b), var0.getY() - var11.d);
            var6.add(var18);
            var19 = new y.d.t(var0.getX() - var27.d + (var27.c - var27.q), var18.b);
            var6.add(var19);
            var31 = new y.d.t(var0.getX() - var27.d, var19.b + (var27.c - var27.q));
            var6.add(var31);
            var21 = new y.d.t(var31.a, var15 - (var27.c - var27.q));
            var6.add(var21);
            var22 = new y.d.t(var21.a + (var27.c - var27.q), var15);
            var6.add(var22);
            if(!var26) {
               break;
            }
         case 1:
            var13 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var15 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var30 = new y.d.t(var7 + var11.d - (var11.p - var11.b), var13);
            var6.add(var30);
            var18 = new y.d.t(var7 + var11.d, var13 - (var11.p - var11.b));
            var6.add(var18);
            var19 = new y.d.t(var18.a, var0.getY() - var27.d + (var27.c - var27.q));
            var6.add(var19);
            var31 = new y.d.t(var19.a - (var27.c - var27.q), var0.getY() - var27.d);
            var6.add(var31);
            var21 = new y.d.t(var15 + (var27.c - var27.q), var31.b);
            var6.add(var21);
            var22 = new y.d.t(var15, var21.b + (var27.c - var27.q));
            var6.add(var22);
            if(!var26) {
               break;
            }
         case 2:
            var13 = var0.getX() + var0.getWidth() * 0.5D + var4.a;
            var15 = var0.getY() + var0.getHeight() * 0.5D + var5.b;
            var30 = new y.d.t(var13, var9 + var11.d - (var11.p - var11.b));
            var6.add(var30);
            var18 = new y.d.t(var13 + (var11.p - var11.b), var9 + var11.d);
            var6.add(var18);
            var19 = new y.d.t(var7 + var27.d - (var27.c - var27.q), var18.b);
            var6.add(var19);
            var31 = new y.d.t(var7 + var27.d, var19.b - (var27.c - var27.q));
            var6.add(var31);
            var21 = new y.d.t(var31.a, var15 + (var27.c - var27.q));
            var6.add(var21);
            var22 = new y.d.t(var21.a - (var27.c - var27.q), var15);
            var6.add(var22);
            if(!var26) {
               break;
            }
         case 3:
            var13 = var0.getY() + var0.getHeight() * 0.5D + var4.b;
            var15 = var0.getX() + var0.getWidth() * 0.5D + var5.a;
            var30 = new y.d.t(var0.getX() - var11.d + (var11.p - var11.b), var13);
            var6.add(var30);
            var18 = new y.d.t(var0.getX() - var11.d, var13 + (var11.p - var11.b));
            var6.add(var18);
            var19 = new y.d.t(var18.a, var9 + var27.d - (var27.c - var27.q));
            var6.add(var19);
            var31 = new y.d.t(var19.a + (var27.c - var27.q), var9 + var27.d);
            var6.add(var31);
            var21 = new y.d.t(var15 - (var27.c - var27.q), var31.b);
            var6.add(var21);
            var22 = new y.d.t(var15, var21.b - (var27.c - var27.q));
            var6.add(var22);
         }
      }

      return var6;
   }

   static final y.d.t a(y.f.am var0, y.d.t var1, int var2, double var3) {
      switch(var2) {
      case 0:
      default:
         return new y.d.t(var1.a + var0.getX() + var0.getWidth() * 0.5D, var0.getY() - var3);
      case 1:
         return new y.d.t(var0.getX() + var0.getWidth() + var3, var0.getY() + var0.getHeight() * 0.5D + var1.b);
      case 2:
         return new y.d.t(var1.a + var0.getX() + var0.getWidth() * 0.5D, var0.getY() + var0.getHeight() + var3);
      case 3:
         return new y.d.t(var0.getX() - var3, var0.getY() + var0.getHeight() * 0.5D + var1.b);
      }
   }
}
