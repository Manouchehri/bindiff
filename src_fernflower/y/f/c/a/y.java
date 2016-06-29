package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aY;
import y.f.c.a.bP;
import y.f.c.a.bq;
import y.f.c.a.cd;
import y.f.c.a.df;

public class y implements bq {
   private bP a;
   private cd b;
   private double c = 0.5D;

   void a(bP var1) {
      this.a = var1;
   }

   void a(cd var1) {
      this.b = var1;
   }

   public void a(y.f.X param1, aU param2, aV param3, aP param4) {
      // $FF: Couldn't be decompiled
   }

   protected double a(y.f.X var1, aV var2, y.c.q var3, int var4, double var5, int var7) {
      if(var7 <= 1) {
         return var5 * 0.5D;
      } else {
         double var8 = this.b(var1, var2, var3, var4, var5, var7);
         return var8 == Double.POSITIVE_INFINITY?var5 * 0.5D:var8 * (var5 / ((double)(var7 - 1) + 2.0D * var8));
      }
   }

   protected double a(y.f.X var1, aV var2, y.c.q var3, int var4, double var5, int var7, double var8) {
      return var7 <= 1?0.0D:(var5 - 2.0D * var8) / (double)(var7 - 1);
   }

   protected double b(y.f.X var1, aV var2, y.c.q var3, int var4, double var5, int var7) {
      aY var8 = var2.a(var3).i();
      return var8 != null?var8.a(var4):this.c;
   }

   private static final void a(y.f.X var0, df var1, y.c.q var2) {
      boolean var9 = N.x;
      if(var1.d() > 0) {
         y.c.p var3 = var1.e().k();

         while(var3 != null) {
            label18: {
               y.c.d var4 = (y.c.d)var3.c();
               double var5 = var1.c();
               double var7 = 0.0D;
               if(var4.c() == var2) {
                  var0.a(var4, var1.a(var5, var7));
                  if(!var9) {
                     break label18;
                  }
               }

               var0.b(var4, var1.a(var5, var7));
            }

            var3 = var3.a();
            if(var9) {
               break;
            }
         }
      }

   }

   private void a(y.c.D var1, Comparator var2, byte[] var3, int[] var4) {
      boolean var17 = N.x;
      if(var1.size() > 1) {
         y.c.p var5 = var1.k();
         byte var6 = -1;

         while(var6 <= 1) {
            y.c.p var10000 = var5;

            byte var10001;
            byte var18;
            label139: {
               label138:
               while(true) {
                  y.c.p var7 = var10000;

                  while(var7 != null) {
                     var18 = var3[((y.c.d)var7.c()).b()];
                     var10001 = var6;
                     if(var17) {
                        break label139;
                     }

                     if(var18 >= var6) {
                        break;
                     }

                     var7 = var7.a();
                     if(var17) {
                        break;
                     }
                  }

                  if(var7 == null) {
                     return;
                  }

                  var6 = var3[((y.c.d)var7.c()).b()];
                  if(var4[((y.c.d)var7.c()).b()] > 0) {
                     var5 = var7;
                     if(!var17) {
                        break;
                     }
                  }

                  y.c.p var8 = var7;
                  int var9 = 1;
                  y.c.p var10 = var7.a();

                  while(true) {
                     if(var10 != null) {
                        var18 = var3[((y.c.d)var10.c()).b()];
                        var10001 = var6;
                        if(var17) {
                           break;
                        }

                        if(var18 == var6 && var4[((y.c.d)var10.c()).b()] == 0) {
                           ++var9;
                           var10 = var10.a();
                           if(!var17) {
                              continue;
                           }
                        }
                     }

                     if(var10 == null) {
                        return;
                     }

                     var18 = var3[((y.c.d)var10.c()).b()];
                     var10001 = var6;
                     break;
                  }

                  if(var18 != var10001) {
                     var5 = var10;
                     if(!var17) {
                        break;
                     }
                  }

                  var5 = var10.a();

                  while(var5 != null) {
                     var18 = var3[((y.c.d)var5.c()).b()];
                     var10001 = var6;
                     if(var17) {
                        break label139;
                     }

                     if(var18 != var6 || var4[((y.c.d)var5.c()).b()] <= 0) {
                        break;
                     }

                     var5 = var5.a();
                     if(var17) {
                        break;
                     }
                  }

                  while(true) {
                     int var19 = var9;

                     y.c.p var12;
                     y.c.p var15;
                     label104:
                     while(true) {
                        if(var19 <= 0) {
                           break label138;
                        }

                        int var11 = 0;
                        var12 = var10;
                        int var13 = 0;
                        y.c.d var14 = (y.c.d)var8.c();
                        var10000 = var10;
                        if(var17) {
                           continue label138;
                        }

                        var15 = var10;

                        while(true) {
                           if(var15 == var5) {
                              break label104;
                           }

                           int var16 = var2.compare((y.c.d)var15.c(), var14);
                           var19 = var16;
                           if(var17) {
                              break;
                           }

                           label99: {
                              if(var16 < 0) {
                                 --var11;
                                 if(var11 >= var13) {
                                    break label99;
                                 }

                                 var13 = var11;
                                 var12 = var15.a();
                                 if(!var17) {
                                    break label99;
                                 }
                              }

                              if(var16 > 0) {
                                 ++var11;
                              }
                           }

                           var15 = var15.a();
                           if(var17) {
                              break label104;
                           }
                        }
                     }

                     var15 = var8;
                     var8 = var8.a();
                     if(var12 != var8) {
                        label155: {
                           var1.h(var15);
                           if(var12 == null) {
                              var1.a(var15);
                              if(!var17) {
                                 break label155;
                              }
                           }

                           var1.a(var15, var12);
                        }
                     }

                     var10 = var12;
                     --var9;
                     if(var17) {
                        break label138;
                     }
                  }
               }

               var18 = var6;
               var10001 = 1;
            }

            var6 = (byte)(var18 + var10001);
            if(var17) {
               break;
            }
         }
      }

   }

   private void a(aP var1, y.c.D var2, Comparator var3, byte[] var4, int[] var5, boolean var6) {
      boolean var21 = N.x;
      if(var2.size() > 1) {
         y.c.p var7 = var2.k();
         int var8 = 0;

         int var10000;
         int var10001;
         while(true) {
            if(var7 != null) {
               var10000 = var4[((y.c.d)var7.c()).b()];
               var10001 = -2;
               if(var21) {
                  break;
               }

               if(var10000 == -2) {
                  ++var8;
                  var7 = var7.a();
                  if(!var21) {
                     continue;
                  }
               }
            }

            if(var8 == 0) {
               return;
            }

            var10000 = var8;
            var10001 = var2.size();
            break;
         }

         if(var10000 != var10001) {
            y.c.p var9 = var2.k();
            y.c.p var10 = var7;
            y.c.p var11 = var9;

            do {
               if(var8 <= 0) {
                  return;
               }

               int var12 = 0;
               y.c.p var13 = var10;
               int var14 = 0;
               y.c.d var15 = (y.c.d)var11.c();
               byte var16 = -1;
               y.c.p var17 = var10;

               byte var19;
               label90: {
                  while(var17 != null) {
                     y.c.d var18 = (y.c.d)var17.c();
                     var19 = var4[var18.b()];
                     int var20 = var3.compare(var18, var15);
                     var10000 = var20;
                     if(var21) {
                        break label90;
                     }

                     label135: {
                        if(var20 < 0) {
                           --var12;
                           if(var12 >= var14) {
                              break label135;
                           }

                           var14 = var12;
                           var13 = var17.a();
                           if(!var21) {
                              break label135;
                           }
                        }

                        if(var20 > 0) {
                           ++var12;
                           if(!var21) {
                              break label135;
                           }
                        }

                        if(var14 == var12 && var16 <= 0 && var19 >= 0) {
                           var13 = var17;
                        }
                     }

                     var16 = var19;
                     var17 = var17.a();
                     if(var21) {
                        break;
                     }
                  }

                  var17 = var11;
                  var11 = var11.a();
                  var10000 = 0;
               }

               int var22;
               label107: {
                  var22 = var10000;
                  if(var13 != var11) {
                     var2.h(var17);
                     if(var13 == null) {
                        var19 = var4[((y.c.d)var2.l().c()).b()];
                        if(var19 > 0) {
                           var22 = var19;
                        }

                        var2.a(var17);
                        if(!var21) {
                           break label107;
                        }
                     }

                     label103: {
                        if(var13.b() != null) {
                           var19 = var4[((y.c.d)var13.b().c()).b()];
                           if(!var21) {
                              break label103;
                           }
                        }

                        var19 = -1;
                     }

                     byte var23 = var4[((y.c.d)var13.c()).b()];
                     var2.a(var17, var13);
                     if(var19 > 0) {
                        var22 = var19;
                     }

                     if(var23 >= 0) {
                        break label107;
                     }

                     var22 = var23;
                     if(!var21) {
                        break label107;
                     }
                  }

                  var19 = var4[((y.c.d)var13.c()).b()];
                  if(var19 < 0) {
                     var22 = var19;
                  }
               }

               var1.a(var15, var6, var22 == 0?y.f.aE.a((byte)(var6?2:1)):y.f.aE.a((byte)(var22 < 0?8:4)));
               var4[var15.b()] = (byte)var22;
               var10 = var13;
               --var8;
            } while(!var21);

         }
      }
   }
}
