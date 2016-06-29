package y.f.k;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import y.f.aE;
import y.f.am;
import y.f.k.A;
import y.f.k.c;
import y.f.k.d;
import y.f.k.u;
import y.f.k.w;

public class t extends c implements Cloneable, w {
   private double b;
   private double c;
   private double d;
   private double e;
   private double f;
   private double g;
   private byte h;
   private byte i;
   private byte j;
   private static final Comparator k = new u(true);
   private static final Comparator l = new u(false);

   public t() {
      this((byte)0, (byte)2, (byte)1, 40.0D, 40.0D);
   }

   public t(byte var1, byte var2, byte var3, double var4, double var6) {
      this(var1, var2, var3, var4, var6, 0.0D, 0.0D, 0.0D, 0.0D);
   }

   public t(byte var1, byte var2, byte var3, double var4, double var6, double var8, double var10, double var12, double var14) {
      this.h = 0;
      this.i = 1;
      this.j = 1;
      this.h = var1;
      this.i = var2;
      this.j = var3;
      this.b = var4;
      this.c = var6;
      this.d = var8;
      this.e = var10;
      this.f = var12;
      this.g = var14;
   }

   protected A a(y.c.q var1, byte var2) {
      A var3;
      am var4;
      label342: {
         int var44 = d.g;
         var4 = this.a.a((Object)var1);
         if(var1.c() == 0) {
            var3 = this.c(var1);
            if(var44 == 0) {
               break label342;
            }
         }

         A var5 = null;
         var3 = this.c(var1);
         Rectangle2D var6 = var3.a();
         double var7 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var10000;
         y.d.c var17;
         double var18;
         int var20;
         int var21;
         boolean var22;
         double var23;
         double var25;
         double[] var27;
         y.c.d var28;
         A var29;
         y.d.t var30;
         double var32;
         y.c.d var34;
         double var35;
         double var36;
         double var37;
         double var38;
         double var40;
         double var42;
         double var50;
         double var51;
         double var52;
         if(this.a()) {
            y.d.c var46;
            boolean var48;
            label232: {
               var46 = new y.d.c(-1.7976931348623157E308D, Double.MAX_VALUE, 0.0D);
               var48 = this.h == 0;
               var17 = null;
               var18 = 0.0D;
               var20 = 0;
               var21 = var1.c() % 2 == 1?(var1.c() - 1) / 2:var1.c() / 2 - 1;
               var22 = var1.c() % 2 == 0;
               if(var48) {
                  var3.b(0.0D, var3.a(2).c(var46) - this.b);
                  if(var44 == 0) {
                     break label232;
                  }
               }

               var3.b(0.0D, -var46.c(var3.a(0)) + this.b);
            }

            var23 = this.a.k(var1);
            var25 = var23;
            var27 = new double[var1.c()];
            var28 = var1.f();

            while(true) {
               if(var28 != null) {
                  var29 = this.b(var28.d());
                  var30 = this.a.p(var28);
                  var10000 = var23;
                  if(var44 != 0) {
                     break;
                  }

                  if(var23 > var30.b()) {
                     var23 = var30.b();
                  }

                  if(var25 < var30.b()) {
                     var25 = var30.b();
                  }

                  label218: {
                     if(var48) {
                        var29.b(0.0D, -var46.c(var29.a(0)));
                        if(var44 == 0) {
                           break label218;
                        }
                     }

                     var29.b(0.0D, var29.a(2).c(var46));
                  }

                  label213: {
                     var29.a(var29.b(), var29.c(), var29.b(), 0.0D);
                     if(var17 == null) {
                        var17 = var29.a(1);
                        if(var44 == 0) {
                           break label213;
                        }
                     }

                     var29.b(-var17.c(var29.a(3)) + this.c, 0.0D);
                     var17.a(var29.a(1));
                  }

                  label208: {
                     var27[var20] = var29.b();
                     if(var5 == null) {
                        var5 = var29;
                        if(var44 == 0) {
                           break label208;
                        }
                     }

                     var5.a(var29);
                  }

                  label203: {
                     if(var22) {
                        if(var20 == var21) {
                           var18 = var29.b();
                           if(var44 == 0) {
                              break label203;
                           }
                        }

                        if(var20 != var21 + 1) {
                           break label203;
                        }

                        var18 += var29.b();
                        var18 *= 0.5D;
                        if(var44 == 0) {
                           break label203;
                        }
                     }

                     if(var20 == var21) {
                        var18 = var29.b();
                     }
                  }

                  this.a((am)null, var29, var28);
                  var28 = var28.g();
                  ++var20;
                  if(var44 == 0) {
                     continue;
                  }
               }

               var10000 = 0.0D;
               break;
            }

            var51 = var10000;
            switch(this.i) {
            case 0:
               var50 = var5.e() - var6.getMaxX() - this.c;
               break;
            case 1:
               var50 = var5.e() - var6.getX();
               break;
            case 2:
            default:
               var50 = (var5.g() + var5.e()) * 0.5D - var6.getCenterX();
               break;
            case 3:
               var50 = var18 - var6.getCenterX();
               break;
            case 4:
               var50 = var5.g() - var6.getMaxX();
               break;
            case 5:
               var50 = var5.g() - var6.getMinX() + this.c;
               break;
            case 6:
               var50 = var5.g() - var6.getMinX() + this.c;
               if(var48) {
                  var51 = this.a(this.a.k(var1), var23, var25) - this.b * 0.5D;
                  if(var44 == 0) {
                     break;
                  }
               }

               var51 = this.a(this.a.k(var1), var23, var25) + this.b * 0.5D;
               break;
            case 7:
               label185: {
                  var50 = var5.e() - var6.getMaxX() - this.c;
                  if(var48) {
                     var51 = this.a(this.a.k(var1), var23, var25) - this.b * 0.5D;
                     if(var44 == 0) {
                        break label185;
                     }
                  }

                  var51 = this.a(this.a.k(var1), var23, var25) + this.b * 0.5D;
               }
            }

            var3.b(var50, var51);
            if(this.j == 1) {
               label328: {
                  var20 = 0;
                  var32 = 0.0D;
                  var34 = var3.k().f();

                  label177: {
                     while(true) {
                        if(var34 != null) {
                           var35 = this.a.p(var34).a;
                           var37 = var27[var20];
                           var32 = Math.max(var32, Math.abs(var35 - var37));
                           var34 = var34.g();
                           ++var20;
                           if(var44 != 0) {
                              break;
                           }

                           if(var44 == 0) {
                              continue;
                           }
                        }

                        if(var32 > 0.0D) {
                           var7 = Math.max(var32 * this.f, this.g);
                           if(var44 == 0) {
                              break label177;
                           }
                        }
                        break;
                     }

                     var7 = 0.0D;
                  }

                  var52 = var7 + this.d + this.e;
                  var36 = Math.max(this.b, var52);
                  if(var48) {
                     var3.b(0.0D, -var36 + this.b);
                     var38 = -var36 + Math.min(var36 - this.e - var7, Math.max((var36 - var7) * 0.5D, this.d));
                     var40 = -Math.min(var36 - this.d - var7, Math.max((var36 - var7) * 0.5D, this.e));
                     var42 = (var38 + var40) * 0.5D;
                     var13 = var42 - var7 * 0.5D;
                     var11 = var42 + var7 * 0.5D;
                     if(var44 == 0) {
                        break label328;
                     }
                  }

                  var3.b(0.0D, var36 - this.b);
                  var38 = var36 - Math.min(var36 - this.e - var7, Math.max((var36 - var7) * 0.5D, this.d));
                  var40 = Math.min(var36 - this.d - var7, Math.max((var36 - var7) * 0.5D, this.e));
                  var42 = (var40 + var38) * 0.5D;
                  var13 = var42 + var7 * 0.5D;
                  var11 = var42 - var7 * 0.5D;
               }
            }

            var3.a(var5);
         } else {
            boolean var15;
            y.d.c var16;
            label311: {
               var15 = this.h == 1;
               var16 = new y.d.c(-1.7976931348623157E308D, Double.MAX_VALUE, 0.0D);
               var17 = null;
               var18 = 0.0D;
               var20 = 0;
               var21 = var1.c() % 2 == 1?(var1.c() - 1) / 2:var1.c() / 2 - 1;
               var22 = var1.c() % 2 == 0;
               if(var15) {
                  var3.b(-var16.c(var3.a(3)) + this.c, 0.0D);
                  if(var44 == 0) {
                     break label311;
                  }
               }

               var3.b(var3.a(1).c(var16) - this.c, 0.0D);
            }

            var23 = this.a.j(var1);
            var25 = var23;
            var27 = new double[var1.c()];
            var28 = var1.f();

            while(true) {
               if(var28 != null) {
                  var29 = this.b(var28.d());
                  var30 = this.a.p(var28);
                  var10000 = var23;
                  if(var44 != 0) {
                     break;
                  }

                  if(var23 > var30.a()) {
                     var23 = var30.a();
                  }

                  if(var25 < var30.a()) {
                     var25 = var30.a();
                  }

                  label297: {
                     if(var15) {
                        var29.b(var29.a(1).c(var16), 0.0D);
                        if(var44 == 0) {
                           break label297;
                        }
                     }

                     var29.b(-var16.c(var29.a(3)), 0.0D);
                  }

                  label292: {
                     var29.a(var29.b(), var29.c(), 0.0D, var29.c());
                     if(var17 == null) {
                        var17 = var29.a(2);
                        if(var44 == 0) {
                           break label292;
                        }
                     }

                     double var31 = var17.c(var29.a(0));
                     var29.b(0.0D, -var31 + this.b);
                     var17.a(var29.a(2));
                  }

                  label287: {
                     var27[var20] = var29.c();
                     if(var5 == null) {
                        var5 = var29;
                        if(var44 == 0) {
                           break label287;
                        }
                     }

                     var5.a(var29);
                  }

                  label282: {
                     if(var22) {
                        if(var20 == var21) {
                           var18 = var29.c();
                           if(var44 == 0) {
                              break label282;
                           }
                        }

                        if(var20 != var21 + 1) {
                           break label282;
                        }

                        var18 += var29.c();
                        var18 *= 0.5D;
                        if(var44 == 0) {
                           break label282;
                        }
                     }

                     if(var20 == var21) {
                        var18 = var29.c();
                     }
                  }

                  this.a((am)null, var29, var28);
                  var28 = var28.g();
                  ++var20;
                  if(var44 == 0) {
                     continue;
                  }
               }

               var10000 = 0.0D;
               break;
            }

            var50 = var10000;
            switch(this.i) {
            case 2:
            default:
               var51 = (var5.h() + var5.f()) * 0.5D - var6.getCenterY();
               if(var44 == 0) {
                  break;
               }
            case 3:
               var51 = var18 - var6.getCenterY();
               if(var44 == 0) {
                  break;
               }
            case 1:
               var51 = var5.f() - var6.getY();
               if(var44 == 0) {
                  break;
               }
            case 4:
               var51 = var5.h() - var6.getMaxY();
               if(var44 == 0) {
                  break;
               }
            case 5:
               var51 = var5.h() - var6.getMinY() + this.b;
               if(var44 == 0) {
                  break;
               }
            case 0:
               var51 = var5.f() - var6.getMaxY() - this.b;
               if(var44 == 0) {
                  break;
               }
            case 6:
               var51 = var5.h() - var6.getMinY() + this.b;
               if(!var15) {
                  var50 = this.b(this.a.j(var1), var23, var25) - this.c * 0.5D;
                  if(var44 == 0) {
                     break;
                  }
               }

               var50 = this.b(this.a.j(var1), var23, var25) + this.c * 0.5D;
               if(var44 == 0) {
                  break;
               }
            case 7:
               label257: {
                  var51 = var5.f() - var6.getMaxY() - this.b;
                  if(!var15) {
                     var50 = this.b(this.a.j(var1), var23, var25) - this.c * 0.5D;
                     if(var44 == 0) {
                        break label257;
                     }
                  }

                  var50 = this.b(this.a.j(var1), var23, var25) + this.c * 0.5D;
               }
            }

            var3.b(var50, var51);
            if(this.j == 1) {
               label331: {
                  var20 = 0;
                  var32 = 0.0D;
                  var34 = var3.k().f();

                  label249: {
                     while(true) {
                        if(var34 != null) {
                           var35 = this.a.p(var34).b;
                           var37 = var27[var20];
                           var32 = Math.max(var32, Math.abs(var35 - var37));
                           var34 = var34.g();
                           ++var20;
                           if(var44 != 0) {
                              break;
                           }

                           if(var44 == 0) {
                              continue;
                           }
                        }

                        if(var32 > 0.0D) {
                           var7 = Math.max(var32 * this.f, this.g);
                           if(var44 == 0) {
                              break label249;
                           }
                        }
                        break;
                     }

                     var7 = 0.0D;
                  }

                  var52 = var7 + this.d + this.e;
                  var36 = Math.max(this.c, var52);
                  if(!var15) {
                     var3.b(-var36 + this.c, 0.0D);
                     var38 = -var36 + Math.min(var36 - this.e - var7, Math.max((var36 - var7) * 0.5D, this.d));
                     var40 = -Math.min(var36 - this.d - var7, Math.max((var36 - var7) * 0.5D, this.e));
                     var42 = (var38 + var40) * 0.5D;
                     var13 = var42 - var7 * 0.5D;
                     var11 = var42 + var7 * 0.5D;
                     if(var44 == 0) {
                        break label331;
                     }
                  }

                  var3.b(var36 - this.c, 0.0D);
                  var38 = var36 - Math.min(var36 - this.e - var7, Math.max((var36 - var7) * 0.5D, this.d));
                  var40 = Math.min(var36 - this.d - var7, Math.max((var36 - var7) * 0.5D, this.e));
                  var42 = (var40 + var38) * 0.5D;
                  var13 = var42 + var7 * 0.5D;
                  var11 = var42 - var7 * 0.5D;
               }
            }

            var3.a(var5);
         }

         y.c.d var47 = var1.f();

         while(var47 != null) {
            A var49 = this.b(var47.d());
            this.a(var4, var49, var47, var11, var13);
            var3.a(this.a, var47);
            var47 = var47.g();
            if(var44 != 0) {
               return var3;
            }

            if(var44 != 0) {
               break;
            }
         }
      }

      if(var1.g() != null) {
         y.f.I var45 = this.a.b(var1.g());
         this.a(this.a, var1, var4, var3, var1.g(), var45, var2);
      }

      return var3;
   }

   private boolean a() {
      return this.h == 0 || this.h == 2;
   }

   private double a(double var1, double var3, double var5) {
      if(1 == this.j) {
         return -var1;
      } else {
         switch(this.h) {
         case 0:
            return -var5;
         case 2:
            return -var3;
         default:
            return -var1;
         }
      }
   }

   private double b(double var1, double var3, double var5) {
      if(1 == this.j) {
         return -var1;
      } else {
         switch(this.h) {
         case 1:
            return -var3;
         case 3:
            return -var5;
         default:
            return -var1;
         }
      }
   }

   protected void a(y.f.X var1, y.c.q var2, am var3, A var4, y.c.d var5, y.f.I var6, byte var7) {
      int var21 = d.g;
      if(var7 != -2 && var7 != -1) {
         aE var8 = aE.e(var1, var5);
         if(var8 == null) {
            var8 = aE.a((byte)0);
         }

         label256: {
            double var9;
            double var11;
            double var13;
            double var15;
            double var17;
            label263: {
               var9 = var3.getX() + var3.getWidth();
               var11 = var3.getY() + var3.getHeight();
               var13 = this.b * 0.5D;
               var15 = this.c * 0.5D;
               var17 = this.b * 0.25D;
               double var19 = this.c * 0.25D;
               switch(this.h) {
               case 0:
                  break;
               case 1:
                  label268: {
                     switch(var7) {
                     case 0:
                     case 3:
                        label271: {
                           if(var8.e()) {
                              var4.a(var4.g() + var15, var4.c());
                              if(var21 == 0) {
                                 break label271;
                              }
                           }

                           if(var8.d()) {
                              var4.a(var4.b(), var11 + var13);
                              var4.a(var4.g() + var15, var4.c());
                              if(var21 == 0) {
                                 break label271;
                              }
                           }

                           if(var8.f()) {
                              var4.a(var3.getX() - var19, var4.c());
                           }
                        }

                        if(var7 != 3) {
                           break label268;
                        }

                        var4.a(var4.b(), var4.f() - var13);
                        var4.a(var4.e(), var4.f() - var13);
                        if(var21 == 0) {
                           break label268;
                        }
                     case 1:
                        if(var8.c()) {
                           var4.a(var4.b(), var3.getY() - var13);
                           if(var21 == 0) {
                              break label268;
                           }
                        }

                        if(var8.d()) {
                           var4.a(var4.b(), var11 + var13);
                           if(var21 == 0) {
                              break label268;
                           }
                        }

                        if(!var8.f()) {
                           break label268;
                        }

                        var4.a(var3.getX() - var19, var4.c());
                        var4.a(var4.b(), var3.getY() - var13);
                        if(var21 == 0) {
                           break label268;
                        }
                     case 2:
                        break;
                     default:
                        break label268;
                     }

                     if(var8.e()) {
                        var4.a(var4.g() + var15, var4.c());
                        if(var21 == 0) {
                           break label268;
                        }
                     }

                     if(var8.c()) {
                        var4.a(var4.b(), var3.getY() - var13);
                        var4.a(var4.g() + var15, var4.c());
                        if(var21 == 0) {
                           break label268;
                        }
                     }

                     if(var8.f()) {
                        var4.a(var3.getX() - var19, var4.c());
                     }
                  }

                  if(var21 == 0) {
                     break label256;
                  }
               case 3:
                  label264: {
                     switch(var7) {
                     case 0:
                     case 1:
                        label266: {
                           if(var8.e()) {
                              var4.a(var9 + var19, var4.c());
                              if(var21 == 0) {
                                 break label266;
                              }
                           }

                           if(var8.d()) {
                              var4.a(var4.b(), var11 + var13);
                              var4.a(var4.e() - var15, var4.c());
                              if(var21 == 0) {
                                 break label266;
                              }
                           }

                           if(var8.f()) {
                              var4.a(var3.getX() - var15, var4.c());
                           }
                        }

                        if(var7 != 1) {
                           break label264;
                        }

                        var4.a(var4.b(), var4.f() - var13);
                        var4.a(var4.g(), var4.f() - var13);
                        if(var21 == 0) {
                           break label264;
                        }
                     case 3:
                        if(var8.c()) {
                           var4.a(var4.b(), var3.getY() - var13);
                           if(var21 == 0) {
                              break label264;
                           }
                        }

                        if(var8.d()) {
                           var4.a(var4.b(), var11 + var13);
                           if(var21 == 0) {
                              break label264;
                           }
                        }

                        if(!var8.e()) {
                           break label264;
                        }

                        var4.a(var9 + var19, var4.c());
                        var4.a(var4.b(), var3.getY() - var13);
                        if(var21 == 0) {
                           break label264;
                        }
                     case 2:
                        break;
                     default:
                        break label264;
                     }

                     if(var8.e()) {
                        var4.a(var9 + var19, var4.c());
                        if(var21 == 0) {
                           break label264;
                        }
                     }

                     if(var8.c()) {
                        var4.a(var4.b(), var3.getY() - var13);
                        var4.a(var4.e() - var15, var4.c());
                        if(var21 == 0) {
                           break label264;
                        }
                     }

                     if(var8.f()) {
                        var4.a(var4.e() - var19, var4.c());
                     }
                  }

                  if(var21 == 0) {
                     break label256;
                  }
                  break;
               case 2:
                  break label263;
               default:
                  break label256;
               }

               label272: {
                  switch(var7) {
                  case 0:
                     if(var8.e()) {
                        var4.a(var9 + var15, var4.c());
                        if(var21 == 0) {
                           break label272;
                        }
                     }

                     if(var8.d()) {
                        var4.a(var4.b(), var11 + var17);
                        var4.a(var3.getX() - var15, var4.c());
                        if(var21 == 0) {
                           break label272;
                        }
                     }

                     if(!var8.f()) {
                        break label272;
                     }

                     var4.a(var3.getX() - var15, var4.c());
                     if(var21 == 0) {
                        break label272;
                     }
                  case 1:
                     if(var8.c()) {
                        var4.a(var4.b(), var3.getY() - var13);
                        if(var21 == 0) {
                           break label272;
                        }
                     }

                     if(var8.d()) {
                        var4.a(var4.b(), var11 + var17);
                        if(var21 == 0) {
                           break label272;
                        }
                     }

                     if(!var8.f()) {
                        break label272;
                     }

                     var4.a(var3.getX() - var15, var4.c());
                     var4.a(var4.b(), var4.f() - var13);
                     if(var21 == 0) {
                        break label272;
                     }
                  case 2:
                  case 3:
                     break;
                  default:
                     break label272;
                  }

                  label275: {
                     if(var8.e()) {
                        var4.a(var9 + var15, var4.c());
                        var4.a(var4.b(), var4.f() - var13);
                        if(var21 == 0) {
                           break label275;
                        }
                     }

                     if(var8.c()) {
                        var4.a(var4.b(), var3.getY() - var13);
                        if(var21 == 0) {
                           break label275;
                        }
                     }

                     if(var8.d()) {
                        var4.a(var4.b(), var11 + var17);
                     }
                  }

                  if(var7 == 2) {
                     var4.a(var4.e() - var15, var4.c());
                     var4.a(var4.e() - var15, var4.h());
                  }
               }

               if(var21 == 0) {
                  break label256;
               }
            }

            switch(var7) {
            case 2:
               if(var8.e()) {
                  var4.a(var9 + var15, var4.c());
                  if(var21 == 0) {
                     break;
                  }
               }

               if(var8.c()) {
                  var4.a(var4.b(), var3.getY() - var17);
                  var4.a(var3.getX() - var15, var4.c());
                  if(var21 == 0) {
                     break;
                  }
               }

               if(!var8.f()) {
                  break;
               }

               var4.a(var3.getX() - var15, var4.c());
               if(var21 == 0) {
                  break;
               }
            case 1:
               if(var8.c()) {
                  var4.a(var4.b(), var3.getY() - var17);
                  if(var21 == 0) {
                     break;
                  }
               }

               if(var8.d()) {
                  var4.a(var4.b(), var4.h() + var13);
                  if(var21 == 0) {
                     break;
                  }
               }

               if(!var8.f()) {
                  break;
               }

               var4.a(var3.getX() - var15, var4.c());
               var4.a(var4.b(), var4.h() + var13);
               if(var21 == 0) {
                  break;
               }
            case 0:
            case 3:
               label276: {
                  if(var8.e()) {
                     var4.a(var9 + var15, var4.c());
                     var4.a(var4.b(), var4.h() + var13);
                     if(var21 == 0) {
                        break label276;
                     }
                  }

                  if(var8.c()) {
                     var4.a(var4.b(), var3.getY() - var17);
                     if(var21 == 0) {
                        break label276;
                     }
                  }

                  if(var8.d()) {
                     var4.a(var4.b(), var11 + var13);
                  }
               }

               if(var7 == 0) {
                  var4.a(var4.e() - var15, var4.c());
                  var4.a(var4.e() - var15, var4.f());
               }
            }
         }

         var4.d();
      }
   }

   protected void a(am var1, A var2, y.c.d var3) {
      y.f.I var4 = this.a.b(var3);
      var4.clearPoints();
   }

   protected void a(am var1, A var2, y.c.d var3, double var4, double var6) {
      if(this.j != 1) {
         this.b(var1, var2, var3);
      }

      this.a(var2, var3, var4, var6);
   }

   protected void b(am var1, A var2, y.c.d var3) {
      this.a(var2, var3, 0.0D, 0.0D);
   }

   private void a(A var1, y.c.d var2, double var3, double var5) {
      int var9 = d.g;
      if(this.j != 3) {
         y.f.I var7;
         label49: {
            var7 = this.a.b(var2);
            var7.clearPoints();
            y.d.t var8;
            if(this.j == 1) {
               var8 = this.a.p(var2);
               if(this.h == 2) {
                  var7.addPoint(var8.a, var5);
                  var7.addPoint(var1.b(), var3);
                  if(var9 == 0) {
                     break label49;
                  }
               }

               if(this.h == 0) {
                  var7.addPoint(var8.a, var5);
                  var7.addPoint(var1.b(), var3);
                  if(var9 == 0) {
                     break label49;
                  }
               }

               if(this.h == 1) {
                  var7.addPoint(var5, var8.b);
                  var7.addPoint(var3, var1.c());
                  if(var9 == 0) {
                     break label49;
                  }
               }

               var7.addPoint(var5, var8.b);
               var7.addPoint(var3, var1.c());
               if(var9 == 0) {
                  break label49;
               }
            }

            if(this.j == 2) {
               label54: {
                  var8 = this.a.p(var2);
                  if(this.h == 2) {
                     var7.addPoint(var1.b(), var8.b);
                     if(var9 == 0) {
                        break label54;
                     }
                  }

                  if(this.h == 0) {
                     var7.addPoint(var1.b(), var8.b);
                     if(var9 == 0) {
                        break label54;
                     }
                  }

                  if(this.h == 1) {
                     var7.addPoint(var8.a, var1.c());
                     if(var9 == 0) {
                        break label54;
                     }
                  }

                  var7.addPoint(var8.a, var1.c());
               }
            }
         }

         var1.a(var7);
      }
   }

   protected byte a(y.c.q var1) {
      return this.j == 3?-2:this.h;
   }
}
