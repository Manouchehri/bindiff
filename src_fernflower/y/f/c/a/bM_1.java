package y.f.c.a;

import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.z;

public class bM implements z {
   private double a = 30.0D;
   private double b = 15.0D;
   private double c = 10.0D;
   private double d = 15.0D;

   public double a(y.f.X var1, aQ var2, aV var3, y.c.q var4, y.c.q var5) {
      boolean var20 = N.x;
      if(var4 != null && var5 != null) {
         aX var6;
         aX var7;
         byte var9;
         byte var10;
         double var11;
         y.c.d var13;
         label314: {
            B var14;
            label283: {
               label282: {
                  var6 = var3.a(var4);
                  var7 = var3.a(var5);
                  byte var8 = var6.b();
                  var9 = var7.b();
                  var11 = 0.0D;
                  var13 = null;
                  switch(var8) {
                  case 0:
                  case 5:
                  case 14:
                  default:
                     var10 = 0;
                     if(!var20) {
                        break label314;
                     }
                  case 12:
                     var10 = 4;
                     if(!var20) {
                        break label314;
                     }
                  case 13:
                     var10 = 5;
                     if(!var20) {
                        break label314;
                     }
                  case 15:
                     var10 = 6;
                     if(!var20) {
                        break label314;
                     }
                  case 2:
                     break label283;
                  case 3:
                     var13 = var6.g();
                     var14 = var3.a(var13).k();
                     if(var14 != null && var6.f() == var5) {
                        label291: {
                           if(var13.c() == var5 ^ var3.a(var13).i()) {
                              var11 = var14.a();
                              if(!var20) {
                                 break label291;
                              }
                           }

                           var11 = var14.b();
                        }
                     }
                  case 1:
                  case 8:
                  case 9:
                  case 10:
                     var13 = var6.g();
                     break label282;
                  case 4:
                     var10 = 2;
                     if(!var20) {
                        break label314;
                     }
                     break;
                  case 6:
                  case 7:
                     break label282;
                  case 11:
                  }

                  var10 = 3;
                  break label314;
               }

               var10 = 1;
               break label314;
            }

            var13 = var6.g();
            if(var6.f() == var5) {
               var14 = var3.a(var13).k();
               if(var14 != null) {
                  label305: {
                     if(var4.b() == 0 ^ var3.a(var13).i()) {
                        var11 = var14.a();
                        if(!var20) {
                           break label305;
                        }
                     }

                     var11 = var14.b();
                  }
               }
            }

            var10 = 1;
         }

         y.c.d var15;
         byte var21;
         label247: {
            label246: {
               label315: {
                  var15 = null;
                  B var16;
                  switch(var9) {
                  case 0:
                  case 5:
                  case 14:
                  default:
                     var21 = 0;
                     if(!var20) {
                        break label247;
                     }
                  case 13:
                     var21 = 4;
                     if(!var20) {
                        break label247;
                     }
                  case 12:
                     var21 = 5;
                     if(!var20) {
                        break label247;
                     }
                  case 15:
                     var21 = 6;
                     if(!var20) {
                        break label247;
                     }
                  case 2:
                     break;
                  case 3:
                     var15 = var7.g();
                     var16 = var3.a(var15).k();
                     if(var16 != null && var7.f() == var4) {
                        label294: {
                           if(var15.c() == var4 ^ var3.a(var15).i()) {
                              var11 = var16.a();
                              if(!var20) {
                                 break label294;
                              }
                           }

                           var11 = var16.b();
                        }
                     }
                  case 1:
                  case 8:
                  case 9:
                  case 10:
                     var15 = var7.g();
                     break label246;
                  case 4:
                     var21 = 2;
                     if(!var20) {
                        break label247;
                     }
                     break label315;
                  case 6:
                  case 7:
                     break label246;
                  case 11:
                     break label315;
                  }

                  var15 = var7.g();
                  if(var7.f() == var4) {
                     var16 = var3.a(var15).k();
                     if(var16 != null) {
                        label311: {
                           if(var5.b() == 0 ^ var3.a(var15).i()) {
                              var11 = var16.a();
                              if(!var20) {
                                 break label311;
                              }
                           }

                           var11 = var16.b();
                        }
                     }
                  }

                  var21 = 1;
                  break label247;
               }

               var21 = 3;
               break label247;
            }

            var21 = 1;
         }

         y.c.c var22;
         if(var10 == 4 && var21 == 4) {
            var22 = var1.c(y.f.b.f.f);
            y.c.c var24 = var1.c(y.f.b.f.e);
            y.d.q var26 = null;
            if(var22 != null) {
               var26 = (y.d.q)var22.b(var6.l());
            }

            y.d.r var27 = null;
            if(var24 != null) {
               var27 = y.d.r.a(var24.b(var6.l()));
            }

            return Math.max(var26 != null?var26.a:0.0D, var27 != null?var27.b + var27.d:this.a);
         } else {
            if(var10 == 4 || var21 == 4) {
               var22 = var1.c(y.f.b.f.e);
               if(var22 != null) {
                  y.d.r var17;
                  if(var10 == 4) {
                     var17 = y.d.r.a(var22.b(var6.l()));
                     if(var17 != null) {
                        return var17.b;
                     }
                  }

                  if(var21 == 4) {
                     var17 = y.d.r.a(var22.b(var7.l()));
                     if(var17 != null) {
                        return var17.d;
                     }
                  }
               }
            }

            double var23;
            if(var10 == 5 || var21 == 5) {
               aY var18;
               label201: {
                  if(var10 == 5) {
                     var18 = var3.a(var6.l()).i();
                     if(!var20) {
                        break label201;
                     }
                  }

                  var18 = var3.a(var7.l()).i();
               }

               var23 = var18 != null?var18.d():0.0D;
               if(var21 == 1 || var10 == 1) {
                  return Math.max(this.b, var23);
               }

               if(var21 == 2 || var21 == 1 || var21 == 0 || var10 == 0) {
                  return Math.max(this.a, var23);
               }
            }

            if(var10 != 6 && var21 != 6) {
               B var19;
               A var25;
               if(var10 == var21) {
                  switch(var10) {
                  case 0:
                  default:
                     return this.a;
                  case 1:
                     var23 = this.c;
                     if(var13 != null) {
                        var25 = var3.a(var13);
                        if(var25 != null) {
                           var19 = var25.k();
                           if(var19 != null) {
                              var23 = Math.max(var23, var19.d());
                           }
                        }
                     }

                     if(var15 != null) {
                        var25 = var3.a(var15);
                        if(var25 != null) {
                           var19 = var25.k();
                           if(var19 != null) {
                              var23 = Math.max(var23, var19.d());
                           }
                        }
                     }

                     return Math.max(var11, var23);
                  case 2:
                  case 3:
                     return 0.0D;
                  }
               } else if(var10 == 3 && var21 == 3) {
                  return this.d;
               } else if(var10 != 2 && var21 != 2) {
                  var23 = this.b;
                  if(var13 != null) {
                     var25 = var3.a(var13);
                     if(var25 != null) {
                        var19 = var25.k();
                        if(var19 != null) {
                           var23 = Math.max(var23, var19.d());
                        }
                     }
                  }

                  if(var15 != null) {
                     var25 = var3.a(var15);
                     if(var25 != null) {
                        var19 = var25.k();
                        if(var19 != null) {
                           var23 = Math.max(var23, var19.d());
                        }
                     }
                  }

                  return Math.max(var11, var23);
               } else {
                  return 0.0D;
               }
            } else if(var10 != 0 && var21 != 0) {
               return this.c;
            } else {
               return this.b;
            }
         }
      } else {
         return 0.0D;
      }
   }

   public void a(double var1) {
      this.a = var1;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public void c(double var1) {
      this.c = var1;
   }

   public void b(y.f.X var1, aU var2, aV var3) {
   }

   public void a(y.f.X var1, aU var2, aV var3) {
   }
}
