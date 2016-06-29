package y.f.c.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.cH;
import y.f.c.a.cI;
import y.f.c.a.cJ;
import y.f.c.a.cK;
import y.f.c.a.cL;
import y.f.c.a.cM;
import y.f.c.a.cN;
import y.f.c.a.cO;
import y.f.c.a.cP;
import y.f.c.a.cQ;
import y.f.c.a.cS;
import y.f.c.a.cU;
import y.f.c.a.cV;
import y.f.c.a.cW;
import y.f.c.a.cX;
import y.f.c.a.cZ;

final class cF {
   private final Comparator a;
   private final Comparator b;
   private final Comparator c;
   private final Comparator d;
   private final Comparator e;
   private final Comparator f;
   private final int[] g;

   public static cF a(int[] var0, int[] var1, byte[] var2, int[] var3, byte[] var4, int[] var5, byte var6, byte var7) {
      boolean var12 = N.x;
      Object var8;
      Object var9;
      switch(var6) {
      case 1:
      default:
         var8 = new cL(var2);
         var9 = new cL(var4);
         if(!var12) {
            break;
         }
      case 2:
         var8 = new cN(var2);
         var9 = new cN(var4);
         if(!var12) {
            break;
         }
      case 0:
         var8 = new cX(var2);
         var9 = new cX(var4);
         if(!var12) {
            break;
         }
      case 3:
         var8 = new cM(var2);
         var9 = new cM(var4);
      }

      Object var10;
      Object var11;
      switch(var7) {
      case 1:
         var10 = new cJ(var3);
         var11 = new cJ(var5);
         if(!var12) {
            break;
         }
      case 0:
      case 2:
      default:
         var10 = new cZ(var3);
         var11 = new cZ(var5);
         if(!var12) {
            break;
         }
      case 3:
         var10 = new cW(var3);
         var11 = new cW(var5);
      }

      return new cF(var0, new cO(var0), new cP(var1), (Comparator)var8, (Comparator)var10, (Comparator)var9, (Comparator)var11);
   }

   public static cF a(y.f.X var0, aU var1, aV var2, int[] var3, int[] var4, byte[] var5, int[] var6, byte[] var7, int[] var8, byte var9, byte var10) {
      boolean var33 = N.x;
      y.c.d[] var11 = new y.c.d[var0.g()];
      ArrayList var12 = new ArrayList(31);
      ArrayList var13 = new ArrayList(31);
      ArrayList var14 = new ArrayList(31);
      cV var15 = new cV(var0, true, true);
      cV var16 = new cV(var0, true, false);
      cV var17 = new cV(var0, false, true);
      cV var18 = new cV(var0, false, false);
      if(var5 == null) {
         var5 = new byte[var0.h()];
      }

      Arrays.fill(var5, (byte)-2);
      if(var8 == null) {
         var6 = new int[var0.h()];
      }

      if(var7 == null) {
         var7 = new byte[var0.h()];
      }

      Arrays.fill(var7, (byte)-2);
      if(var8 == null) {
         var8 = new int[var0.h()];
      }

      int var19 = 0;

      label286:
      do {
         int var10000 = var19;

         label283:
         while(var10000 < var1.b()) {
            aQ var20 = var1.a(var19);
            int var21 = 0;
            y.c.p var22 = var20.d().k();

            while(var22 != null) {
               Object var34 = var22.c();

               int var25;
               int var29;
               y.c.d var30;
               double var31;
               int var35;
               double var36;
               label277:
               while(true) {
                  y.c.q var23;
                  y.c.d var26;
                  int var27;
                  y.f.aE var28;
                  label201:
                  while(true) {
                     var23 = (y.c.q)var34;
                     int var24 = var23.d();
                     var3[var24] = var19;
                     var4[var24] = var21;
                     var12.clear();
                     var13.clear();
                     var14.clear();
                     var25 = var23.a() + 1;
                     if(var33) {
                        continue label286;
                     }

                     var26 = var23.f();

                     while(true) {
                        if(var26 == null) {
                           break label201;
                        }

                        var27 = var26.b();
                        var28 = var2.a(var26).c();
                        var34 = var28;
                        if(var33) {
                           break;
                        }

                        label308: {
                           if(var28 == null || var28.g()) {
                              var5[var27] = -2;
                              if(!var33) {
                                 break label308;
                              }
                           }

                           if(var28 != null) {
                              label307: {
                                 if(!var28.a()) {
                                    if(var28.e()) {
                                       var5[var27] = 1;
                                       if(!var33) {
                                          break label307;
                                       }
                                    }

                                    if(var28.f()) {
                                       var5[var27] = -1;
                                       if(!var33) {
                                          break label307;
                                       }
                                    }

                                    var5[var27] = 0;
                                    if(!var33) {
                                       break label307;
                                    }
                                 }

                                 if(var28.e()) {
                                    var5[var27] = 1;
                                    var12.add(var26);
                                    if(!var33) {
                                       break label307;
                                    }
                                 }

                                 if(var28.f()) {
                                    var5[var27] = -1;
                                    var13.add(var26);
                                    if(!var33) {
                                       break label307;
                                    }
                                 }

                                 var5[var27] = 0;
                                 var14.add(var26);
                              }
                           }
                        }

                        var26 = var26.g();
                        if(var33) {
                           break label201;
                        }
                     }
                  }

                  label213: {
                     if(var12.size() > 0) {
                        var12.toArray(var11);
                        y.g.e.a(var11, 0, var12.size(), var16);
                        var35 = 0;
                        var36 = -1.7976931348623157E308D;
                        var29 = 0;

                        while(var29 < var12.size()) {
                           var30 = var11[var29];
                           var31 = var0.n(var30).b;
                           double var37;
                           var10000 = (var37 = var31 - var36) == 0.0D?0:(var37 < 0.0D?-1:1);
                           if(var33) {
                              break label213;
                           }

                           if(var10000 != 0) {
                              var36 = var31;
                              var35 += var25;
                           }

                           var6[var30.b()] = var35;
                           ++var29;
                           if(var33) {
                              break;
                           }
                        }
                     }

                     var10000 = var13.size();
                  }

                  label226: {
                     if(var10000 > 0) {
                        var13.toArray(var11);
                        y.g.e.a(var11, 0, var13.size(), var16);
                        var35 = 0;
                        var36 = -1.7976931348623157E308D;
                        var29 = var13.size() - 1;

                        while(var29 >= 0) {
                           var30 = var11[var29];
                           var31 = var0.n(var30).b;
                           double var38;
                           var10000 = (var38 = var31 - var36) == 0.0D?0:(var38 < 0.0D?-1:1);
                           if(var33) {
                              break label226;
                           }

                           if(var10000 != 0) {
                              var36 = var31;
                              var35 += var25;
                           }

                           var6[var30.b()] = var35;
                           --var29;
                           if(var33) {
                              break;
                           }
                        }
                     }

                     var10000 = var14.size();
                  }

                  if(var10000 > 0) {
                     var14.toArray(var11);
                     y.g.e.a(var11, 0, var14.size(), var15);
                     var35 = 0;
                     var36 = -1.7976931348623157E308D;
                     var29 = var14.size() - 1;

                     while(var29 >= 0) {
                        var30 = var11[var29];
                        var31 = var0.n(var30).a;
                        double var39;
                        var10000 = (var39 = var31 - var36) == 0.0D?0:(var39 < 0.0D?-1:1);
                        if(var33) {
                           break label277;
                        }

                        if(var10000 != 0) {
                           var36 = var31;
                           var35 += var25;
                        }

                        var6[var30.b()] = var35;
                        --var29;
                        if(var33) {
                           break;
                        }
                     }
                  }

                  var12.clear();
                  var13.clear();
                  var14.clear();
                  var26 = var23.g();

                  while(var26 != null) {
                     var27 = var26.b();
                     var28 = var2.a(var26).e();
                     var34 = var28;
                     if(var33) {
                        continue label277;
                     }

                     label309: {
                        if(var28 == null || var28.g()) {
                           var7[var27] = -2;
                           if(!var33) {
                              break label309;
                           }
                        }

                        if(var28 != null) {
                           label302: {
                              if(!var28.a()) {
                                 if(var28.e()) {
                                    var7[var27] = 1;
                                    if(!var33) {
                                       break label302;
                                    }
                                 }

                                 if(var28.f()) {
                                    var7[var27] = -1;
                                    if(!var33) {
                                       break label302;
                                    }
                                 }

                                 var7[var27] = 0;
                                 if(!var33) {
                                    break label302;
                                 }
                              }

                              if(var28.e()) {
                                 var7[var27] = 1;
                                 var12.add(var26);
                                 if(!var33) {
                                    break label302;
                                 }
                              }

                              if(var28.f()) {
                                 var7[var27] = -1;
                                 var13.add(var26);
                                 if(!var33) {
                                    break label302;
                                 }
                              }

                              var7[var27] = 0;
                              var14.add(var26);
                           }
                        }
                     }

                     var26 = var26.h();
                     if(var33) {
                        break;
                     }
                  }

                  if(var12.size() > 0) {
                     var12.toArray(var11);
                     y.g.e.a(var11, 0, var12.size(), var18);
                     var35 = 0;
                     var36 = -1.7976931348623157E308D;
                     var29 = var12.size() - 1;

                     while(var29 >= 0) {
                        var30 = var11[var29];
                        var31 = var0.o(var30).b;
                        double var40;
                        var10000 = (var40 = var31 - var36) == 0.0D?0:(var40 < 0.0D?-1:1);
                        if(var33) {
                           break label277;
                        }

                        if(var10000 != 0) {
                           var36 = var31;
                           var35 += var25;
                        }

                        var8[var30.b()] = var35;
                        --var29;
                        if(var33) {
                           break;
                        }
                     }
                  }

                  var10000 = var13.size();
                  break;
               }

               label154: {
                  if(var10000 > 0) {
                     var13.toArray(var11);
                     y.g.e.a(var11, 0, var13.size(), var18);
                     var35 = 0;
                     var36 = -1.7976931348623157E308D;
                     var29 = 0;

                     while(var29 < var13.size()) {
                        var30 = var11[var29];
                        var31 = var0.o(var30).b;
                        double var41;
                        var10000 = (var41 = var31 - var36) == 0.0D?0:(var41 < 0.0D?-1:1);
                        if(var33) {
                           break label154;
                        }

                        if(var10000 != 0) {
                           var36 = var31;
                           var35 += var25;
                        }

                        var8[var30.b()] = var35;
                        ++var29;
                        if(var33) {
                           break;
                        }
                     }
                  }

                  var10000 = var14.size();
               }

               if(var10000 > 0) {
                  var14.toArray(var11);
                  y.g.e.a(var11, 0, var14.size(), var17);
                  var35 = 0;
                  var36 = -1.7976931348623157E308D;
                  var29 = var14.size() - 1;

                  while(var29 >= 0) {
                     var30 = var11[var29];
                     var31 = var0.o(var30).a;
                     double var42;
                     var10000 = (var42 = var31 - var36) == 0.0D?0:(var42 < 0.0D?-1:1);
                     if(var33) {
                        continue label283;
                     }

                     if(var10000 != 0) {
                        var36 = var31;
                        var35 += var25;
                     }

                     var8[var30.b()] = var35;
                     --var29;
                     if(var33) {
                        break;
                     }
                  }
               }

               var22 = var22.a();
               ++var21;
               if(var33) {
                  break;
               }
            }

            ++var19;
            continue label286;
         }

         return a(var3, var4, var5, var6, var7, var8, var9, var10);
      } while(!var33);

      return a(var3, var4, var5, var6, var7, var8, var9, var10);
   }

   private cF(int[] var1, Comparator var2, Comparator var3, Comparator var4, Comparator var5, Comparator var6, Comparator var7) {
      this.a = var2;
      this.g = var1;
      this.b = var3;
      this.c = var4;
      this.d = var6;
      this.e = var5;
      this.f = var7;
   }

   public Comparator a(boolean var1) {
      return (Comparator)(var1?new cK(this.g, this.b, this.c, this.e):new cQ(this.g, this.b, this.d, this.f));
   }

   public Comparator b(boolean var1) {
      return (Comparator)(var1?new cI(this.g, this.a, this.b, this.c, this.e, this.d, this.f):new cU(this.g, this.a, this.b, this.d, this.f, this.c, this.e));
   }

   public Comparator c(boolean var1) {
      return (Comparator)(var1?new cH(this.g, this.a, this.b, this.c, this.e, this.d, this.f):new cS(this.g, this.a, this.b, this.d, this.f, this.c, this.e));
   }
}
