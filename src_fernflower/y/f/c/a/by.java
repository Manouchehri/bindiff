package y.f.c.a;

import java.util.HashSet;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.aY;
import y.f.c.a.aZ;
import y.f.c.a.as;
import y.f.c.a.bC;
import y.f.c.a.bD;
import y.f.c.a.bE;
import y.f.c.a.bF;
import y.f.c.a.bH;
import y.f.c.a.bJ;
import y.f.c.a.bz;
import y.f.c.a.z;

public class by implements aZ {
   private z a;
   private int b = 800;
   private int c = 16000;
   private int d = 32000;
   private int e = 40;
   private int f = 16000;
   private aV g;
   private double h = 0.5D;
   private boolean i;
   private double j = 0.0D;
   private double k = 0.0D;
   private boolean l = true;
   private boolean m = true;
   private boolean n = true;
   private long o = Long.MAX_VALUE;
   private int p = 0;
   private boolean q = true;
   private boolean r = false;
   private boolean s = false;
   private boolean t = false;

   public boolean a() {
      return this.q;
   }

   public boolean b() {
      return this.r;
   }

   public boolean c() {
      return this.t;
   }

   public long d() {
      return this.o;
   }

   public void a(long var1) {
      this.o = var1;
   }

   public boolean e() {
      return this.i;
   }

   private static boolean a(aV var0, y.c.q var1) {
      return ((y.f.X)var1.e()).p(var1) == 0.0D && var0.a(var1).b() == 1;
   }

   private static boolean b(aV var0, y.c.q var1) {
      byte var2 = var0.a(var1).b();
      return var2 == 12 || var2 == 13;
   }

   private void a(aU var1, aV var2, y.c.h var3, int[] var4) {
      boolean var19 = N.x;
      int var5 = var1.b();
      int var6 = 1;

      do {
         int var10000 = var6;
         int var10001 = var5;

         label87:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            int var7 = -1;
            int var8 = 0;
            int var9 = 0;
            y.c.p var10 = var1.a(var6).d().k();
            y.c.p var11 = var10;

            while(true) {
               if(var11 == null) {
                  break label87;
               }

               Object var20 = var11.c();

               label82: {
                  int var15;
                  label81:
                  while(true) {
                     y.c.q var12 = (y.c.q)var20;
                     y.c.q var13 = null;
                     boolean var14 = false;
                     var10000 = var12.b();
                     var10001 = 1;
                     if(var19) {
                        continue label87;
                     }

                     if(var10000 == 1) {
                        var13 = var12.g().c();
                        if(a(var2, var13) && a(var2, var12)) {
                           var14 = true;
                        }
                     }

                     if(var9 != var1.a(var6).d().size() - 1 && !var14) {
                        break label82;
                     }

                     var15 = var14?var4[var13.d()]:var1.a(var6 - 1).d().size();

                     while(true) {
                        var10000 = var8;
                        var10001 = var9;

                        label76:
                        while(true) {
                           if(var10000 > var10001) {
                              break label81;
                           }

                           y.c.q var16 = (y.c.q)var10.c();
                           var20 = var16.g();
                           if(var19) {
                              continue label81;
                           }

                           Object var17 = var20;

                           while(true) {
                              if(var17 == null) {
                                 break label76;
                              }

                              int var18 = var4[((y.c.d)var17).c().d()];
                              var10000 = var18;
                              var10001 = var7;
                              if(var19) {
                                 break;
                              }

                              if(var18 < var7 || var18 > var15) {
                                 var3.a(var17, true);
                              }

                              var17 = ((y.c.d)var17).h();
                              if(var19) {
                                 break label76;
                              }
                           }
                        }

                        var10 = var10.a();
                        ++var8;
                        if(var19) {
                           break label81;
                        }
                     }
                  }

                  var7 = Math.max(var7, var15);
               }

               ++var9;
               var11 = var11.a();
               if(var19) {
                  break label87;
               }
            }
         }

         ++var6;
      } while(!var19);

   }

   private void a(aU var1, aV var2, y.c.h var3) {
      boolean var13 = N.x;
      int var4 = var1.b();
      int var5 = 1;

      label62:
      while(true) {
         int var10000 = var5;

         label59:
         while(true) {
            if(var10000 >= var4) {
               return;
            }

            y.c.f var6 = new y.c.f();
            aQ var7 = var1.a(var5);
            y.c.x var8 = var7.d().a();

            while(var8.f()) {
               y.c.q var9 = var8.e();
               var6.a(var9.k());
               var8.g();
               if(var13) {
                  continue label62;
               }

               if(var13) {
                  break;
               }
            }

            y.c.d[] var14 = var6.e();
            int var15 = 0;

            while(true) {
               var10000 = var15;

               label54:
               while(true) {
                  if(var10000 >= var14.length) {
                     break label59;
                  }

                  y.c.d var10 = var14[var15];
                  var10000 = var15 + 1;
                  if(var13) {
                     continue label59;
                  }

                  int var11 = var10000;

                  while(true) {
                     if(var11 >= var14.length) {
                        break label54;
                     }

                     y.c.d var12 = var14[var11];
                     var10000 = a(var10, var12, var2);
                     if(var13) {
                        break;
                     }

                     if(var10000 != 0) {
                        var3.a(var10, true);
                        var3.a(var12, true);
                     }

                     ++var11;
                     if(var13) {
                        break label54;
                     }
                  }
               }

               ++var15;
               if(var13) {
                  break label59;
               }
            }
         }

         ++var5;
         if(var13) {
            return;
         }
      }
   }

   private void a(aU var1, aV var2, y.c.h var3, y.c.h var4, int[] var5) {
      boolean var21 = N.x;
      int var6 = var1.b();
      int var7 = 1;

      do {
         int var10000 = var7;
         int var10001 = var6;

         label85:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            int var8 = -1;
            int var9 = 0;
            int var10 = 0;
            y.c.p var11 = var1.a(var7).d().k();
            y.c.p var12 = var11;

            while(true) {
               if(var12 == null) {
                  break label85;
               }

               Object var22 = var12.c();

               label80: {
                  int var17;
                  label79:
                  while(true) {
                     y.c.q var13 = (y.c.q)var22;
                     var2.a(var13);
                     y.c.q var15 = null;
                     boolean var16 = false;
                     var10000 = var13.b();
                     var10001 = 1;
                     if(var21) {
                        continue label85;
                     }

                     if(var10000 == 1) {
                        var15 = var13.g().c();
                        if(b(var2, var13)) {
                           var16 = true;
                        }
                     }

                     if(var10 != var1.a(var7).d().size() - 1 && !var16) {
                        break label80;
                     }

                     var17 = var16?var5[var15.d()]:var1.a(var7 - 1).d().size();

                     while(true) {
                        var10000 = var9;
                        var10001 = var10;

                        label74:
                        while(true) {
                           if(var10000 > var10001) {
                              break label79;
                           }

                           y.c.q var18 = (y.c.q)var11.c();
                           var22 = var18.g();
                           if(var21) {
                              continue label79;
                           }

                           Object var19 = var22;

                           while(true) {
                              if(var19 == null) {
                                 break label74;
                              }

                              int var20 = var5[((y.c.d)var19).c().d()];
                              var10000 = var20;
                              var10001 = var8;
                              if(var21) {
                                 break;
                              }

                              if(var20 < var8 || var20 > var17) {
                                 var3.a(var19, true);
                                 var4.a(var19, true);
                              }

                              var19 = ((y.c.d)var19).h();
                              if(var21) {
                                 break label74;
                              }
                           }
                        }

                        var11 = var11.a();
                        ++var9;
                        if(var21) {
                           break label79;
                        }
                     }
                  }

                  var8 = Math.max(var8, var17);
               }

               ++var10;
               var12 = var12.a();
               if(var21) {
                  break label85;
               }
            }
         }

         ++var7;
      } while(!var21);

   }

   public void a(y.f.X var1, aV var2, aU var3) {
      boolean var6 = N.x;
      if(this.m) {
         boolean var4 = false;
         y.c.x var5 = var1.o();

         boolean var10000;
         label33: {
            while(var5.f()) {
               var10000 = this.a(var1, var2, var5.e(), true);
               if(var6) {
                  break label33;
               }

               if(var10000) {
                  var4 = true;
                  if(!var6) {
                     break;
                  }
               }

               var5.g();
               if(var6) {
                  break;
               }
            }

            var10000 = var4;
         }

         if(var10000) {
            this.b(var3, var1, var2);
            if(!var6) {
               return;
            }
         }

         this.a(var3, var1, var2);
         if(!var6) {
            return;
         }
      }

      this.a(var3, var1, var2);
   }

   private void a(aU var1, y.f.X var2, aV var3) {
      boolean var10 = N.x;
      double var4 = 0.0D;
      int var6 = 0;

      while(var6 < var1.b()) {
         aQ var7 = var1.a(var6);
         double var8 = this.a(var2, var3, var7);
         var8 = Math.max(var8, this.a((y.f.X)var2, (y.c.D)var7.d()));
         this.a(var2, var3, var6, var7.d(), var8, var4);
         var4 += var8;
         ++var6;
         if(var10) {
            break;
         }
      }

   }

   private double a(y.f.X var1, y.c.D var2) {
      boolean var8 = N.x;
      double var3 = 0.0D;
      y.c.p var5 = var2.k();

      double var10000;
      while(true) {
         if(var5 != null) {
            double var6 = var1.q((y.c.q)var5.c());
            var10000 = Math.max(var3, var6);
            if(var8) {
               break;
            }

            var3 = var10000;
            var5 = var5.a();
            if(!var8) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private void a(y.f.X var1, aV var2, int var3, y.c.D var4, double var5, double var7) {
      boolean var17 = N.x;
      y.c.p var9 = var4.k();

      while(var9 != null) {
         y.c.q var10 = (y.c.q)var9.c();
         double var11 = var1.q((y.c.q)var9.c());
         double var13 = this.a(var1, var2, var10, var3, var5);
         double var15 = var7 + var13 * (var5 - var11);
         var1.a(var10, var1.j(var10), var15 + var11 * 0.5D);
         var9 = var9.a();
         if(var17) {
            break;
         }
      }

   }

   private void a(y.f.X var1, aV var2, int var3, y.c.q var4, y.c.D var5, double var6, double var8) {
      boolean var22 = N.x;
      double var10 = var1.k(var4);
      y.c.p var12 = var5.k();

      while(var12 != null && !var12.c().equals(var4)) {
         var12 = var12.a();
         if(var22) {
            break;
         }
      }

      Object var13 = null;
      y.c.p var14 = var5.k();

      while(var14 != null) {
         Object var10000;
         label60: {
            if(var14 == var12) {
               label78: {
                  var12 = var12.a();

                  while(var12 != null) {
                     var10000 = this;
                     if(var22) {
                        break label60;
                     }

                     if(this.a(var1, var2, (y.c.q)var12.c(), true)) {
                        break;
                     }

                     var12 = var12.a();
                     if(var22) {
                        break;
                     }
                  }

                  if(var12 == null) {
                     var10 = var1.k((y.c.q)var14.c());
                     if(!var22) {
                        break label78;
                     }
                  }

                  var10 = 0.5D * (var1.k((y.c.q)var12.c()) + var1.k((y.c.q)var14.c()));
               }
            }

            var10000 = var14.c();
         }

         label80: {
            y.c.q var15 = (y.c.q)var10000;
            if(this.a(var1, var2, var15, true)) {
               var1.a(var15, var1.j(var15), var1.k(var15));
               if(!var22) {
                  break label80;
               }
            }

            double var16;
            double var20;
            label36: {
               var16 = var1.q((y.c.q)var14.c());
               double var18 = this.a(var1, var2, var15, var3, var6);
               if(var16 < 1.0D) {
                  var20 = var10;
                  if(!var22) {
                     break label36;
                  }
               }

               var20 = var8 + var18 * (var6 - var16);
            }

            var1.a(var15, var1.j(var15), var20 + var16 * 0.5D);
         }

         var14 = var14.a();
         if(var22) {
            break;
         }
      }

   }

   private void b(aU var1, y.f.X var2, aV var3) {
      boolean var22 = N.x;
      y.c.q[] var4 = new y.c.q[var1.b()];
      double[] var5 = new double[var1.b()];
      double[] var6 = new double[var1.b()];
      int var9 = -1;
      int var10 = 0;

      aQ var11;
      int var10000;
      label123:
      while(true) {
         var10000 = var10;

         label120:
         while(var10000 < var1.b()) {
            var11 = var1.a(var10);
            var6[var10] = Math.max(this.a(var2, var3, var11), this.a((y.f.X)var2, (y.c.D)var11.d()));
            var10000 = var11.e();
            if(var22) {
               break label123;
            }

            label117: {
               if(var10000 == 0) {
                  double var12 = Double.MAX_VALUE;
                  double var14 = -1.7976931348623157E308D;
                  y.c.x var16 = var11.d().a();

                  while(var16.f()) {
                     y.c.q var17 = var16.e();
                     var10000 = this.a(var2, var3, var17, true);
                     if(var22) {
                        continue label120;
                     }

                     if(var10000 != 0) {
                        if(var4[var10] == null) {
                           var4[var10] = var17;
                        }

                        var12 = Math.min(var12, var2.n(var17));
                        var14 = Math.max(var14, var2.n(var17) + var2.q(var17));
                     }

                     var16.g();
                     if(var22) {
                        break;
                     }
                  }

                  if(var4[var10] != null) {
                     double var23;
                     if(var6[var10] > var14 - var12) {
                        var23 = (var6[var10] - (var14 - var12)) * 0.5D;
                        var12 -= var23;
                        var14 += var23;
                        var6[var10] = var14 - var12;
                     } else {
                        var6[var10] = var14 - var12;
                     }

                     var5[var10] = var12;
                     if(var10 > 0) {
                        label137: {
                           var23 = 0.0D;
                           int var18 = var10 - 1;

                           while(var18 > var9) {
                              var23 += var6[var18];
                              --var18;
                              if(var22) {
                                 break label137;
                              }

                              if(var22) {
                                 break;
                              }
                           }

                           double var24 = 20.0D;
                           if(var9 > -1) {
                              double var20 = var5[var10] - (var5[var9] + var6[var9]);
                              var24 = (var20 - var23) / (double)(var10 - var9);
                           }

                           int var25 = var10 - 1;

                           while(var25 > var9) {
                              var5[var25] = var5[var25 + 1] - var6[var25] - var24;
                              --var25;
                              if(var22) {
                                 break label117;
                              }

                              if(var22) {
                                 break;
                              }
                           }
                        }
                     }

                     var9 = var10;
                  }
               }

               ++var10;
            }

            if(!var22) {
               continue label123;
            }
            break;
         }

         var10000 = var9;
         break;
      }

      label75: {
         if(var10000 > -1) {
            var10 = var9 + 1;

            while(var10 < var1.b()) {
               var5[var10] = var5[var10 - 1] + var6[var10 - 1] + 20.0D;
               ++var10;
               if(var22) {
                  break label75;
               }

               if(var22) {
                  break;
               }
            }
         }

         var10 = 0;
      }

      while(var10 < var1.b()) {
         label60: {
            var11 = var1.a(var10);
            if(var4[var10] != null) {
               this.a(var2, var3, var10, var4[var10], var11.d(), var6[var10], var5[var10]);
               if(!var22) {
                  break label60;
               }
            }

            this.a(var2, var3, var10, var11.d(), var6[var10], var5[var10]);
         }

         ++var10;
         if(var22) {
            break;
         }
      }

   }

   protected boolean a(y.f.X var1, aV var2, y.c.q var3, boolean var4) {
      if(var3 == null) {
         return false;
      } else {
         aX var5 = var2.a(var3);
         return var4?var5 != null && var5.b() == 0 && (var5.c().a() == 6 || var5.c().a() == 4):var5 != null && var5.b() == 0 && (var5.c().a() == 5 || var5.c().a() == 4);
      }
   }

   protected double a(y.f.X var1, aV var2, aQ var3) {
      boolean var10 = N.x;
      double var4 = 0.0D;
      boolean var6 = false;
      y.c.p var7 = var3.d().k();

      double var10000;
      while(true) {
         if(var7 != null) {
            y.c.q var8 = (y.c.q)var7.c();
            aY var9 = var2.a(var8).i();
            if(var10) {
               break;
            }

            if(var9 != null) {
               var6 = true;
               var4 = Math.max(var4, var9.c());
            }

            var7 = var7.a();
            if(!var10) {
               continue;
            }
         }

         if(var6) {
            var10000 = var4;
            return var10000;
         }
         break;
      }

      var10000 = this.j;
      return var10000;
   }

   protected double a(y.f.X var1, aV var2, y.c.q var3, int var4, double var5) {
      aY var7 = var2.a(var3).i();
      return var7 != null?var7.a():this.h;
   }

   public void a(y.f.X param1, aV param2, aU param3, z param4) {
      // $FF: Couldn't be decompiled
   }

   void a(aU var1) {
      boolean var9 = N.x;
      int var2 = 0;

      do {
         int var10000 = var2;

         label29:
         while(true) {
            if(var10000 >= var1.b()) {
               return;
            }

            aQ var3 = var1.a(var2);
            int var4 = 0;
            y.c.p var5 = var3.d().k();

            while(true) {
               if(var5 == null) {
                  break label29;
               }

               y.c.q var6 = (y.c.q)var5.c();
               aX var7 = this.g.a(var6);
               var10000 = var7 instanceof as;
               if(var9) {
                  break;
               }

               if(var10000 != 0) {
                  as var8 = (as)var7;
                  var8.b(var4);
               }

               var5 = var5.a();
               ++var4;
               if(var9) {
                  break label29;
               }
            }
         }

         ++var2;
      } while(!var9);

   }

   private y.c.f a(y.c.f var1, y.c.c var2) {
      boolean var18 = N.x;
      y.c.i var3 = new y.c.i();
      HashSet var4 = new HashSet();
      y.c.y var5 = new y.c.y();
      HashSet var6 = new HashSet();
      y.c.y var7 = new y.c.y();
      y.c.h var8 = y.g.M.b();
      y.c.A var9 = y.g.M.a();
      y.c.e var10 = var1.a();

      while(var10.f()) {
         y.c.d var11 = var10.a();
         if(!var2.d(var11)) {
            if(var4.add(var11.c())) {
               var5.add(var11.c());
            }

            if(var6.add(var11.d())) {
               var7.add(var11.d());
            }

            y.c.q var12 = var3.d();
            var8.a(var11, var12);
            var9.a(var12, var11);
         }

         var10.g();
         if(var18) {
            break;
         }
      }

      y.c.x var19 = var5.a();

      int var14;
      int var33;
      label205:
      while(true) {
         boolean var10000 = var19.f();

         y.c.d[] var13;
         y.c.q var15;
         int var16;
         y.c.q var17;
         y.c.q var20;
         aX var23;
         label202:
         while(true) {
            if(var10000) {
               var20 = var19.e();
               var23 = this.g.a(var20);
               byte var32 = var23.b();
               if(var18) {
                  if(var32 == 0) {
                     break label205;
                  }
                  break;
               }

               if(var32 != 0) {
                  var13 = (new y.c.f(var20.l())).e();
                  var14 = 0;
                  var33 = var14;

                  label159:
                  while(true) {
                     label157:
                     while(true) {
                        if(var33 >= var13.length) {
                           break label159;
                        }

                        var10000 = var2.d(var13[var14]);
                        if(var18) {
                           continue label202;
                        }

                        if(var10000) {
                           break;
                        }

                        var15 = (y.c.q)var8.b(var13[var14]);
                        var16 = var14 + 1;

                        while(true) {
                           if(var16 >= var13.length) {
                              break label157;
                           }

                           var33 = var2.d(var13[var16]);
                           if(var18) {
                              break;
                           }

                           if(var33 == 0) {
                              var17 = (y.c.q)var8.b(var13[var16]);
                              if(var15.c(var17) == null) {
                                 var3.a(var15, var17);
                              }
                           }

                           ++var16;
                           if(var18) {
                              break label157;
                           }
                        }
                     }

                     ++var14;
                     if(var18) {
                        break;
                     }

                     var33 = var14;
                  }
               }

               var19.g();
               if(!var18) {
                  continue label205;
               }

               var19 = var7.a();
            } else {
               var19 = var7.a();
            }

            if(!var19.f()) {
               break label205;
            }
            break;
         }

         while(true) {
            label194:
            while(true) {
               var20 = var19.e();
               var23 = this.g.a(var20);
               if(var23.b() != 0) {
                  var13 = (new y.c.f(var20.k())).e();
                  var14 = 0;
                  var33 = var14;

                  label190:
                  while(true) {
                     label188:
                     while(true) {
                        if(var33 >= var13.length) {
                           break label190;
                        }

                        var10000 = var2.d(var13[var14]);
                        if(var18) {
                           if(!var10000) {
                              break label205;
                           }
                           continue label194;
                        }

                        if(var10000) {
                           break;
                        }

                        var15 = (y.c.q)var8.b(var13[var14]);
                        var16 = var14 + 1;

                        while(true) {
                           if(var16 >= var13.length) {
                              break label188;
                           }

                           var33 = var2.d(var13[var16]);
                           if(var18) {
                              break;
                           }

                           if(var33 == 0) {
                              var17 = (y.c.q)var8.b(var13[var16]);
                              if(var15.c(var17) == null) {
                                 var3.a(var15, var17);
                              }
                           }

                           ++var16;
                           if(var18) {
                              break label188;
                           }
                        }
                     }

                     ++var14;
                     if(var18) {
                        break;
                     }

                     var33 = var14;
                  }
               }

               var19.g();
               if(var18 || !var19.f()) {
                  break label205;
               }
            }
         }
      }

      y.c.d[] var21 = var1.e();
      int var22 = 0;

      label113:
      do {
         var33 = var22;

         label110:
         while(true) {
            if(var33 >= var21.length) {
               break label113;
            }

            y.c.d var25 = var21[var22];
            if(var2.d(var25)) {
               break;
            }

            y.c.q var27 = (y.c.q)var8.b(var25);
            var14 = var22 + 1;

            while(true) {
               if(var14 >= var21.length) {
                  break label110;
               }

               y.c.d var29 = var21[var14];
               var33 = var2.d(var29);
               if(var18) {
                  break;
               }

               if(var33 == 0 && a(var25, var29, this.g)) {
                  y.c.q var34 = (y.c.q)var8.b(var29);
                  var3.a(var27, var34);
               }

               ++var14;
               if(var18) {
                  break label110;
               }
            }
         }

         ++var22;
      } while(!var18);

      y.c.f var24 = new y.c.f();
      y.c.y var26 = y.a.k.b(var3);
      y.c.x var28 = var26.a();

      while(var28.f()) {
         y.c.d var30 = (y.c.d)var9.b(var28.e());
         aX var31 = this.g.a(var30.c());
         aX var35 = this.g.a(var30.d());
         if(!this.e() || var31.b() != 6 && var35.b() != 7) {
            var24.add(var30);
         }

         var28.g();
         if(var18) {
            break;
         }
      }

      return var24;
   }

   private static boolean a(y.c.d var0, y.c.d var1, aV var2) {
      aX var3 = var2.a(var0.c());
      aX var4 = var2.a(var1.c());
      aX var5 = var2.a(var0.d());
      aX var6 = var2.a(var1.d());
      if(var3.j() == var4.j() && var5.j() == var6.j()) {
         return var3.k() < var4.k() && var5.k() > var6.k() || var3.k() > var4.k() && var5.k() < var6.k();
      } else {
         throw new RuntimeException("wrong input");
      }
   }

   private void a(y.f.X var1, aU var2, aV var3, int var4, int[] var5, y.c.q[] var6) {
      boolean var22 = N.x;
      if(this.n) {
         int var7 = 0;

         while(var7 < var2.b()) {
            aQ var8 = var2.a(var7);
            y.c.p var9 = null;
            int var10 = 0;
            y.c.p var11 = var8.d().k();

            y.c.q var12;
            int var10000;
            int var10001;
            while(true) {
               if(var11 != null) {
                  var12 = (y.c.q)var11.c();
                  var10000 = this.a(var1, var3, var12, false);
                  if(var22) {
                     break;
                  }

                  if(var10000 != 0) {
                     label135: {
                        int var13 = (int)Math.rint(var1.j(var12) * 2520.0D) - (var4 + var5[var6[var12.d()].d()]);
                        if(var13 != 0 || var10 != 0) {
                           label124: {
                              if(var9 == null) {
                                 if(var13 >= 0) {
                                    break label124;
                                 }

                                 y.c.p var14 = var8.d().k();

                                 do {
                                    if(var14 == var11) {
                                       break label124;
                                    }

                                    y.c.q var15 = (y.c.q)var14.c();
                                    var10001 = var6[var15.d()].d();
                                    var5[var10001] += var13;
                                    var14 = var14.a();
                                    if(var22) {
                                       break label135;
                                    }
                                 } while(!var22);
                              }

                              int var23 = var13 - var10;
                              int var24;
                              if(var23 < 0) {
                                 var24 = 1;
                                 int var16 = var5[var6[((y.c.q)var9.c()).d()].d()] - var10;
                                 int var17 = var5[var6[var12.d()].d()];
                                 y.c.p var18 = var9.a();

                                 do {
                                    if(var18 == var11) {
                                       break label124;
                                    }

                                    y.c.q var19 = (y.c.q)var18.c();
                                    double var20 = (double)(var5[var6[var19.d()].d()] - var16) / (double)(var17 - var16);
                                    var5[var6[var19.d()].d()] = var16 + var10 + (int)Math.rint(var20 * (double)(var17 + var13 - (var16 + var10)));
                                    var18 = var18.a();
                                    ++var24;
                                    if(var22) {
                                       break label135;
                                    }
                                 } while(!var22);
                              }

                              if(var10 > 0) {
                                 var24 = var10 + var23 / 2;
                                 y.c.p var25 = var9.a();

                                 while(var25 != var11) {
                                    y.c.q var26 = (y.c.q)var25.c();
                                    var10001 = var6[var26.d()].d();
                                    var5[var10001] += var24;
                                    var25 = var25.a();
                                    if(var22) {
                                       break label135;
                                    }

                                    if(var22) {
                                       break;
                                    }
                                 }
                              }
                           }

                           var10001 = var6[var12.d()].d();
                           var5[var10001] += var13;
                        }

                        var10 = var13;
                     }

                     var9 = var11;
                  }

                  var11 = var11.a();
                  if(!var22) {
                     continue;
                  }
               }

               var10000 = var10;
               break;
            }

            label61: {
               if(var10000 > 0 && var9 != null) {
                  var11 = var9.a();

                  while(var11 != null) {
                     var12 = (y.c.q)var11.c();
                     var10001 = var6[var12.d()].d();
                     var5[var10001] += var10;
                     var11 = var11.a();
                     if(var22) {
                        break label61;
                     }

                     if(var22) {
                        break;
                     }
                  }
               }

               ++var7;
            }

            if(var22) {
               break;
            }
         }

      }
   }

   private void a(y.c.q var1, y.c.q var2, double var3, double var5, y.c.i var7, y.c.h var8, y.c.h var9) {
      this.a(var1, var2, var3, (int)Math.rint(var5), var7, var8, var9);
   }

   private y.c.d a(y.c.q var1, y.c.q var2, double var3, int var5, y.c.i var6, y.c.h var7, y.c.h var8) {
      y.c.d var9 = var6.a(var1, var2);
      var7.a(var9, var5);
      if(var3 > 0.0D) {
         int var10 = (int)Math.ceil(2520.0D * var3);
         var8.a(var9, var10);
         if(!N.x) {
            return var9;
         }
      }

      var8.a(var9, 0);
      return var9;
   }

   protected double a(y.f.X var1, aQ var2, y.c.q var3, y.c.q var4) {
      if(this.n && var3 != null && var4 != null && this.a(var1, this.g, var3, false) && this.a(var1, this.g, var4, false)) {
         return 0.0D;
      } else {
         if(this.a != null) {
            double var5 = this.a.a(var1, var2, this.g, var3, var4);
            if(var5 >= 0.0D) {
               return var5;
            }
         }

         return 0.0D;
      }
   }

   public boolean f() {
      return this.s;
   }

   private void a(y.c.d var1, y.f.X var2, aV var3, double var4, boolean var6) {
      boolean var22 = N.x;
      A var7 = var3.a(var1);
      if(a(var7, false)) {
         y.c.D var8 = this.a(var1.c(), var3, var2);
         y.c.D var9 = new y.c.D();
         y.c.D var10 = new y.c.D();
         boolean var11 = false;
         Object var12 = null;
         y.c.C var13 = var8.m();

         bF var14;
         while(var13.f()) {
            var14 = (bF)var13.d();
            if(var22) {
               return;
            }

            label139: {
               if(var14.a(var1)) {
                  var11 = true;
                  var14.c(new y.d.t(0.0D, var14.g().b));
                  if(!var22) {
                     break label139;
                  }
               }

               if(!var11) {
                  var9.add(var14);
                  if(!var22) {
                     break label139;
                  }
               }

               var10.add(var14);
            }

            var13.g();
            if(var22) {
               break;
            }
         }

         double var25 = var2.p(var1.c()) / 2.0D;
         int var15 = var6?Math.max(var9.size(), var10.size()):var9.size();
         double var16 = var25 / ((double)var15 + var4);
         double var18 = 0.0D;
         var9.n();
         y.c.C var20 = var9.m();

         int var10000;
         bF var21;
         label113: {
            while(true) {
               if(var20.f()) {
                  var21 = (bF)var20.d();
                  var18 -= var16;
                  var21.c(new y.d.t(var18, var21.g().b));
                  var20.g();
                  if(var22) {
                     break;
                  }

                  if(!var22) {
                     continue;
                  }
               }

               if(var6) {
                  var10000 = Math.max(var9.size(), var10.size());
                  break label113;
               }
               break;
            }

            var10000 = var10.size();
         }

         var15 = var10000;
         var16 = var25 / ((double)var15 + var4);
         var18 = 0.0D;
         var20 = var10.m();

         label101: {
            while(var20.f()) {
               var21 = (bF)var20.d();
               var18 += var16;
               var21.c(new y.d.t(var18, var21.g().b));
               var20.g();
               if(var22) {
                  break label101;
               }

               if(var22) {
                  break;
               }
            }

            var8 = this.b(var1.d(), var3, var2);
         }

         y.c.f var23 = new y.c.f();
         y.c.f var24 = new y.c.f();
         var11 = false;
         var12 = null;
         var13 = var8.m();

         while(var13.f()) {
            var14 = (bF)var13.d();
            if(var22) {
               return;
            }

            label142: {
               if(var14.a(var1)) {
                  var11 = true;
                  var14.d(new y.d.t(0.0D, var14.h().b));
                  if(!var22) {
                     break label142;
                  }
               }

               if(!var11) {
                  var23.add(var14);
                  if(!var22) {
                     break label142;
                  }
               }

               var24.add(var14);
            }

            var13.g();
            if(var22) {
               break;
            }
         }

         var25 = var2.p(var1.d()) / 2.0D;
         var15 = var6?Math.max(var23.size(), var24.size()):var23.size();
         var16 = var25 / ((double)var15 + var4);
         var18 = 0.0D;
         var23.n();
         var20 = var23.m();

         label71: {
            while(true) {
               if(var20.f()) {
                  var21 = (bF)var20.d();
                  var18 -= var16;
                  var21.d(new y.d.t(var18, var21.h().b));
                  var20.g();
                  if(var22) {
                     break;
                  }

                  if(!var22) {
                     continue;
                  }
               }

               if(var6) {
                  var10000 = Math.max(var23.size(), var24.size());
                  break label71;
               }
               break;
            }

            var10000 = var24.size();
         }

         var15 = var10000;
         var16 = var25 / ((double)var15 + var4);
         var18 = 0.0D;
         var20 = var24.m();

         while(var20.f()) {
            var21 = (bF)var20.d();
            var18 += var16;
            var21.d(new y.d.t(var18, var21.h().b));
            var20.g();
            if(var22) {
               break;
            }
         }
      }

   }

   private void a(y.c.q var1, y.f.X var2, aV var3, double var4, boolean var6) {
      boolean var22 = N.x;
      double var7 = var2.m(var1);
      double var9 = var7 + var2.p(var1);
      y.c.D var11;
      y.c.D var12;
      double var13;
      y.c.D var15;
      boolean var10000;
      int var17;
      y.c.C var18;
      bF var19;
      double var20;
      if(var6) {
         var11 = this.a(var1, var3, var2);
         var12 = new y.c.D();
         var13 = var7;
         var15 = new y.c.D();
         y.c.D var16 = new y.c.D();
         var17 = var11.size();
         var18 = var11.m();

         label72: {
            while(var18.f()) {
               var19 = (bF)var18.d();
               --var17;
               var20 = var19.f().a;
               var10000 = a(var19, var2, true);
               if(var22) {
                  break label72;
               }

               label68: {
                  if(var10000 && var20 > var13 && var20 - var13 > 3.0D * (double)(var16.size() + 1) && var9 - var20 > 3.0D * (double)(var17 + 1)) {
                     var13 = var19.f().a;
                     var19.a(new y.d.t(var13, var19.e().b));
                     var12.add(var19);
                     var15.add(var16);
                     var16 = new y.c.D();
                     if(!var22) {
                        break label68;
                     }
                  }

                  var16.add(var19);
               }

               var18.g();
               if(var22) {
                  break;
               }
            }

            var10000 = var12.isEmpty();
         }

         if(var10000) {
            return;
         }

         var15.add(var16);
         this.a((bF[])var12.toArray(new bF[var12.size()]), var15, var2, true, var4, false);
         if(!var22) {
            return;
         }
      }

      var11 = this.b(var1, var3, var2);
      var12 = new y.c.D();
      var13 = var7;
      var15 = new y.c.D();
      Object var23 = new y.c.f();
      var17 = var11.size();
      var18 = var11.m();

      label49: {
         while(var18.f()) {
            var19 = (bF)var18.d();
            --var17;
            var20 = var19.e().a;
            var10000 = a(var19, var2, false);
            if(var22) {
               break label49;
            }

            label45: {
               if(var10000 && var20 > var13 && var20 - var13 > 3.0D * (double)(((y.c.D)var23).size() + 1) && var9 - var20 > 3.0D * (double)(var17 + 1)) {
                  var13 = var19.e().a;
                  var19.b(new y.d.t(var13, var19.f().b));
                  var12.add(var19);
                  var15.add(var23);
                  var23 = new y.c.D();
                  if(!var22) {
                     break label45;
                  }
               }

               ((y.c.D)var23).add(var19);
            }

            var18.g();
            if(var22) {
               break;
            }
         }

         var10000 = var12.isEmpty();
      }

      if(!var10000) {
         var15.add(var23);
         this.a((bF[])var12.toArray(new bF[var12.size()]), var15, var2, false, var4, false);
      }

   }

   private static boolean a(bF var0, y.f.X var1, boolean var2) {
      y.d.y var3;
      double var4;
      if(var2) {
         var3 = var1.s(var0.a());
         var4 = var0.f().a;
         return (var0.c() == null || !var0.c().a() && var0.c().d()) && var4 > var3.c() && var4 < var3.c() + var3.a();
      } else {
         var3 = var1.s(var0.b());
         var4 = var0.e().a;
         return (var0.d() == null || !var0.d().a() && var0.d().c()) && var4 > var3.c() && var4 < var3.c() + var3.a();
      }
   }

   private void a(bF[] var1, y.c.D var2, y.f.X var3, boolean var4, double var5, boolean var7) {
      boolean var26 = N.x;
      if(var1 != null && var1.length != 0) {
         int var8;
         y.c.C var9;
         label116: {
            var8 = 0;
            if(var7) {
               var9 = var2.m();

               while(var9.f()) {
                  y.c.D var10 = (y.c.D)var9.d();
                  var8 = Math.max(var8, var10.size());
                  var9.g();
                  if(var26) {
                     break label116;
                  }

                  if(var26) {
                     break;
                  }
               }
            }

            var9 = var2.m();
         }

         double var27 = var4 != 0?var3.m(var1[0].a()):var3.m(var1[0].b());
         int var12 = 0;

         double var14;
         Object var30;
         label103:
         while(true) {
            int var10000 = var12;

            label100:
            while(var10000 < var1.length) {
               var30 = var1[var12];
               if(var26) {
                  break label103;
               }

               Object var13 = var30;
               var14 = var4 != 0?((bF)var13).e().a:((bF)var13).f().a;
               y.c.D var16 = (y.c.D)var9.d();
               if(!var16.isEmpty()) {
                  int var17 = var7?var8:var16.size();
                  double var18 = var12 == 0?(double)var17 + var5:(double)(var17 + 1);
                  double var20 = (var14 - var27) / var18;
                  var16.n();
                  double var22 = var14;
                  y.c.C var24 = var16.m();

                  while(var24.f()) {
                     bF var25 = (bF)var24.d();
                     var22 -= var20;
                     var10000 = var4;
                     if(var26) {
                        continue label100;
                     }

                     label92: {
                        if(var4 != 0) {
                           var25.a(new y.d.t(var22, var25.e().b));
                           if(!var26) {
                              break label92;
                           }
                        }

                        var25.b(new y.d.t(var22, var25.f().b));
                     }

                     var24.g();
                     if(var26) {
                        break;
                     }
                  }
               }

               var27 = var14;
               var9.g();
               ++var12;
               if(!var26) {
                  continue label103;
               }
               break;
            }

            var30 = var9.d();
            break;
         }

         y.c.D var28 = (y.c.D)var30;
         if(!var28.isEmpty()) {
            bF var29 = var1[var1.length - 1];
            var14 = var4 != 0?var3.m(var29.a()) + var3.p(var29.a()):var3.m(var29.b()) + var3.p(var29.b());
            int var31 = var7?var8:var28.size();
            double var32 = (var14 - var27) / ((double)var31 + var5);
            double var19 = var27;
            y.c.C var21 = var28.m();

            while(var21.f()) {
               label70: {
                  bF var33 = (bF)var21.d();
                  var19 += var32;
                  if(var4 != 0) {
                     var33.a(new y.d.t(var19, var33.e().b));
                     if(!var26) {
                        break label70;
                     }
                  }

                  var33.b(new y.d.t(var19, var33.f().b));
               }

               var21.g();
               if(var26) {
                  break;
               }
            }
         }

      }
   }

   private static boolean a(A var0, boolean var1) {
      return (var0.c() == null || (!var0.c().a() || var1) && var0.c().d()) && (var0.e() == null || (!var0.e().a() || var1) && var0.e().c());
   }

   private y.c.D a(y.c.q var1, aV var2, y.f.X var3) {
      boolean var9 = N.x;
      y.c.D var4 = new y.c.D();
      y.c.e var5 = var1.l();

      aV var10000;
      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            var10000 = var2;
            if(var9) {
               break;
            }

            A var7 = var2.a(var6);
            if(var7.c() == null || !var7.c().a()) {
               var4.add(new bF(var6, var3, var2, false, (bz)null));
            }

            var5.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      aX var10 = var10000.a(var1);
      if(var10.e() > 0) {
         y.c.p var11 = var10.d();

         while(var11 != null) {
            y.c.d var12 = (y.c.d)var11.c();
            A var8 = var2.a(var12);
            if(var9) {
               return var4;
            }

            label45: {
               if(var12.c() == var1 && var8.c() != null && !var8.c().a() && var8.c().b() == 2) {
                  var4.add(new bF(var12, var3, var2, false, (bz)null));
                  if(!var9) {
                     break label45;
                  }
               }

               if(var12.d() == var1 && var8.e() != null && !var8.e().a() && var8.e().b() == 2) {
                  var4.add(new bF(var12, var3, var2, true, (bz)null));
               }
            }

            var11 = var11.a();
            if(var9) {
               break;
            }
         }
      }

      var4.sort(new bC(this));
      return var4;
   }

   private y.c.D b(y.c.q var1, aV var2, y.f.X var3) {
      boolean var9 = N.x;
      y.c.f var4 = new y.c.f();
      y.c.e var5 = var1.k();

      aV var10000;
      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            var10000 = var2;
            if(var9) {
               break;
            }

            A var7 = var2.a(var6);
            if(var7.e() == null || !var7.e().a()) {
               var4.add(new bF(var6, var3, var2, false, (bz)null));
            }

            var5.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      aX var10 = var10000.a(var1);
      if(var10.e() > 0) {
         y.c.p var11 = var10.d();

         while(var11 != null) {
            y.c.d var12 = (y.c.d)var11.c();
            A var8 = var2.a(var12);
            if(var9) {
               return var4;
            }

            label45: {
               if(var12.d() == var1 && var8.e() != null && !var8.e().a() && var8.e().b() == 1) {
                  var4.add(new bF(var12, var3, var2, false, (bz)null));
                  if(!var9) {
                     break label45;
                  }
               }

               if(var12.c() == var1 && var8.c() != null && !var8.c().a() && var8.c().b() == 1) {
                  var4.add(new bF(var12, var3, var2, true, (bz)null));
               }
            }

            var11 = var11.a();
            if(var9) {
               break;
            }
         }
      }

      var4.sort(new bD(this));
      return var4;
   }

   private void a(y.f.X var1, aU var2, aV var3, y.c.h var4, y.c.c var5) {
      boolean var19 = N.x;
      int[] var6 = new int[var1.f()];
      int var7 = var2.b();
      int var8 = 0;
      y.c.x var9 = var2.a(0).d().a();

      while(var9.f()) {
         var6[var9.e().d()] = var8++;
         var9.g();
         if(var19) {
            break;
         }
      }

      int var20 = 1;

      while(var20 < var7) {
         y.c.D var10 = new y.c.D();
         var8 = 0;
         y.c.x var11 = var2.a(var20).d().a();

         label50:
         while(true) {
            int var10000 = var11.f();

            label47:
            while(var10000 != 0) {
               y.c.q var12 = var11.e();
               var6[var12.d()] = var8++;
               if(var19) {
                  break label50;
               }

               y.c.e var13 = var12.k();

               while(var13.f()) {
                  y.c.d var14 = var13.a();
                  A var15 = var3.a(var14);
                  var4.a(var14, false);
                  double var16 = (double)this.a(var1, var14, var3, var5);
                  double var21;
                  var10000 = (var21 = var16 - 0.0D) == 0.0D?0:(var21 < 0.0D?-1:1);
                  if(var19) {
                     continue label47;
                  }

                  if(var10000 > 0 && a(var15, true)) {
                     bJ var18 = new bJ(var6[var14.c().d()], var6[var14.d().d()], var14, var16);
                     var10.add(var18);
                  }

                  var13.g();
                  if(var19) {
                     break;
                  }
               }

               var11.g();
               if(!var19) {
                  continue label50;
               }
               break;
            }

            this.a(var10, var4);
            ++var20;
            break;
         }

         if(var19) {
            break;
         }
      }

   }

   private int a(y.f.X var1, y.c.d var2, aV var3, y.c.c var4) {
      A var5 = var3.a(var2);
      y.c.d var6 = var5.b() != null?var5.b():var2;
      y.c.c var7 = var1.c(y.f.c.M.n);
      boolean var8 = var4 != null && var4.b(var2.d()) == var2.c();
      return var7 != null?var7.a(var6) + (var8?1:0):(var8?1:0);
   }

   private void a(y.c.D var1, y.c.h var2) {
      boolean var10 = N.x;
      y.c.i var3 = new y.c.i();
      y.c.A var4 = y.g.M.a();
      y.c.C var5 = var1.m();

      bJ var6;
      while(var5.f()) {
         var6 = (bJ)var5.d();
         var6.f = var3.d();
         var4.a(var6.f, var6);
         var5.g();
         if(var10) {
            break;
         }
      }

      y.c.D var11 = new y.c.D(var1);
      var11.sort(new bH((bz)null));
      y.c.C var12 = var1.m();

      bJ var9;
      bJ var15;
      label71: {
         y.c.D var10000;
         while(true) {
            if(var12.f()) {
               bJ var7 = (bJ)var12.d();
               var10000 = var11;
               if(var10) {
                  break;
               }

               y.c.C var8 = var11.m();

               while(var8.f()) {
                  var9 = (bJ)var8.d();
                  var15 = var9;
                  if(var10) {
                     break label71;
                  }

                  if(var9 != var7) {
                     if(var9.b > var7.b) {
                        break;
                     }

                     if(a(var7, var9) && !var3.b(var9.f, var7.f)) {
                        var3.a(var7.f, var9.f);
                     }
                  }

                  var8.g();
                  if(var10) {
                     break;
                  }
               }

               var12.g();
               if(!var10) {
                  continue;
               }
            }

            var10000 = var11;
            break;
         }

         var10000.sort(new bE((bz)null));
         var15 = this.a(var11);
      }

      var6 = var15;

      while(var6 != null) {
         var2.a(var6.e, true);
         y.c.x var13 = var6.f.m();

         while(true) {
            if(var13.f()) {
               y.c.q var14 = var13.e();
               var9 = (bJ)var4.b(var14);
               var3.a(var9.f);
               var9.f = null;
               var13.g();
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            var3.a(var6.f);
            var6 = this.a(var11);
            break;
         }

         if(var10) {
            break;
         }
      }

   }

   private bJ a(y.c.D var1) {
      boolean var8 = N.x;
      double var2 = -1.7976931348623157E308D;
      int var4 = Integer.MAX_VALUE;
      y.c.p var5 = null;
      y.c.p var6 = var1.k();

      Object var10000;
      while(true) {
         if(var6 != null) {
            label35: {
               bJ var7 = (bJ)var6.c();
               var10000 = var7.f;
               if(var8) {
                  break;
               }

               if(var10000 != null) {
                  if(var7.c < var2) {
                     break label35;
                  }

                  if(var7.f.a() < var4) {
                     var2 = var7.c;
                     var4 = var7.f.a();
                     var5 = var6;
                  }
               }

               var6 = var6.a();
               if(!var8) {
                  continue;
               }
            }
         }

         if(var5 == null) {
            return null;
         }

         var10000 = var1.h(var5);
         break;
      }

      return (bJ)var10000;
   }

   private static boolean a(bJ var0, bJ var1) {
      boolean var2 = var0.a == var1.a || var0.b == var1.b;
      if(var2) {
         return true;
      } else {
         boolean var3 = var0.a > var1.a && var0.b < var1.b || var0.a < var1.a && var0.b > var1.b;
         return var3;
      }
   }

   static aV a(by var0) {
      return var0.g;
   }
}
