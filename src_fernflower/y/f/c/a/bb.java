package y.f.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.a;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bc;
import y.f.c.a.bd;
import y.f.c.a.be;
import y.f.c.a.bf;
import y.f.c.a.bg;

public class bb extends a {
   private static final y.f.aE a = new y.f.aE((byte)2, false);
   private static final y.f.aE b = new y.f.aE((byte)1, false);
   private static final y.f.aE c = new y.f.aE((byte)8, false);
   private static final y.f.aE d = new y.f.aE((byte)4, false);
   private static final y.f.aE e = new y.f.aE((byte)2, true);
   private static final y.f.aE f = new y.f.aE((byte)1, true);
   private static final y.f.aE g = new y.f.aE((byte)8, true);
   private static final y.f.aE h = new y.f.aE((byte)4, true);
   private double i = 10.0D;
   private double j = 1.0D;
   private double k = 100.0D;
   private y.c.A l;
   private boolean m = true;

   public double c() {
      return this.j;
   }

   private static boolean a(y.c.d var0, aV var1) {
      return var1.a(var0).i();
   }

   private static boolean b(y.c.d var0, aV var1) {
      return var1.a(var0.c()).j() == var1.a(var0.d()).j();
   }

   private boolean a(y.f.ax var1) {
      byte var2 = this.b();
      return (var2 == 2 || var2 == 0) && (var1.a((int)1) || var1.a((int)2)) || (var2 == 1 || var2 == 3) && (var1.a((int)8) || var1.a((int)4));
   }

   private boolean a(boolean var1, y.f.ax var2) {
      return !var2.a(this.a(!var1));
   }

   private static int a(byte var0, boolean var1) {
      if(!var1) {
         switch(var0) {
         case 0:
         default:
            return 1;
         case 1:
            return 8;
         case 2:
            return 2;
         case 3:
            return 4;
         }
      } else {
         switch(var0) {
         case 0:
         default:
            return 2;
         case 1:
            return 4;
         case 2:
            return 1;
         case 3:
            return 8;
         }
      }
   }

   private boolean b(boolean var1, y.f.ax var2) {
      return var2.a(a(this.b(), var1));
   }

   private static boolean a(y.c.q var0, y.c.c var1) {
      boolean var5 = N.x;
      y.f.ax var2 = null;
      y.c.e var3 = var0.l();

      while(var3.f()) {
         y.f.ax var4 = (y.f.ax)var1.b(var3.a().d());
         if(var4 != null) {
            if(var2 != null && var2.a() != var4.a()) {
               return false;
            }

            var2 = var4;
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return true;
   }

   private boolean a(y.c.q var1, y.c.c var2, int var3) {
      boolean var8 = N.x;
      HashSet var4 = new HashSet(8);
      y.c.e var5 = var1.l();

      while(var5.f()) {
         y.f.ax var6 = (y.f.ax)var2.b(var5.a().d());
         if(var6 != null) {
            int var7 = var6.b(this.b());
            if((var3 & var7) != 0) {
               var4.add(var6);
            }

            if(var4.size() > 1) {
               return true;
            }
         }

         var5.g();
         if(var8) {
            break;
         }
      }

      return false;
   }

   private static boolean b(y.f.ax var0) {
      int var1 = var0.a();
      return var1 == 4 || var1 == 8 || var1 == 1 || var1 == 2;
   }

   private double a(y.f.ax var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      double var6 = var1.b()?0.5D:0.0D;
      return var4?(this.b(!var5, var1)?var6 + 2.0D:(this.b(var5, var1)?var6 + 4.0D:var6)):(this.a(var2, var1)?var6 + (double)(var3?3:5) + 6.0D * this.c():(this.b(var2, var1)?var6:var6 + 1.0D));
   }

   private void a(y.c.q var1, y.f.X var2, aV var3, aP var4) {
      y.c.i var5;
      y.c.q var6;
      y.c.q var7;
      y.c.h var8;
      y.c.h var9;
      y.c.A var10;
      y.c.y var12;
      y.c.h var10000;
      boolean var32;
      label196: {
         var32 = N.x;
         var5 = new y.c.i();
         var6 = var5.d();
         var7 = var5.d();
         var8 = y.g.M.b();
         var9 = y.g.M.b();
         var10 = y.g.M.a();
         y.c.c var11 = var2.c(y.f.ay.a);
         var12 = new y.c.y();
         if(var11 != null && var11.b(var1) != null) {
            y.f.ay var13 = (y.f.ay)var11.b(var1);
            Iterator var14 = var13.a();

            while(var14.hasNext()) {
               y.f.aA var15 = (y.f.aA)var14.next();
               y.c.q var16 = var5.d();
               var10.a(var16, var15.a());
               var12.add(var16);
               y.c.d var17 = var5.a(var16, var7);
               var8.a(var17, var15.b());
               var10000 = var9;
               if(var32) {
                  break label196;
               }

               var9.a(var17, Math.min(1000.0D, 6.0D * (1.0D + var15.a().f())));
               if(var32) {
                  break;
               }
            }
         }

         var10000 = y.g.M.b();
      }

      y.c.h var33 = var10000;
      y.c.e var34 = var1.j();

      boolean var22;
      boolean var41;
      label182:
      do {
         boolean var40 = var34.f();

         label179:
         while(true) {
            if(!var40) {
               break label182;
            }

            y.c.d var36 = var34.a();
            A var38 = var3.a(var36);
            var41 = a(var36, var3);
            y.c.q var42 = var36.c();

            boolean var18;
            boolean var19;
            boolean var20;
            y.c.q var23;
            y.c.d var25;
            HashMap var26;
            label176:
            while(true) {
               var18 = var42.equals(var1);
               var19 = b(var36, var3);
               var20 = var3.a(var36).l();
               Collection var21 = var18?var38.d():var38.f();
               var22 = var21 != null && !var21.isEmpty();
               if(var12.isEmpty() && !var22) {
                  break label179;
               }

               var23 = var5.d();
               var33.a(var36, var23);
               y.c.d var24 = var5.a(var6, var23);
               var8.a(var24, 1);
               var9.a(var24, 0.0D);
               var25 = var5.a(var23, var7);
               var8.a(var25, 1);
               var9.a(var25, 100000.0D);
               var26 = new HashMap();
               if(!var22) {
                  break;
               }

               Iterator var27 = var21.iterator();

               while(true) {
                  if(!var27.hasNext()) {
                     break label176;
                  }

                  y.f.ax var28 = (y.f.ax)var27.next();
                  y.c.q var29 = (y.c.q)var26.get(bg.a(var28));
                  var42 = var29;
                  if(var32) {
                     break;
                  }

                  if(var29 == null) {
                     var29 = var5.d();
                     var26.put(bg.a(var28), var29);
                     var10.a(var29, var28);
                     var25 = var5.a(var29, var7);
                     var8.a(var25, Integer.MAX_VALUE);
                     double var30 = Math.min(1000.0D, 6.0D * (1.0D + var28.f()));
                     var9.a(var25, var30);
                  }

                  var25 = var5.a(var23, var29);
                  var8.a(var25, 1);
                  var9.a(var25, Math.min(1000.0D, this.a(var28, var18, var41, var19, var20)));
                  if(var32) {
                     break label176;
                  }
               }
            }

            if(var12.isEmpty()) {
               break;
            }

            y.c.x var52 = var12.a();

            while(true) {
               if(!var52.f()) {
                  break label179;
               }

               y.c.q var53 = var52.e();
               y.f.ax var55 = (y.f.ax)var10.b(var53);
               y.c.q var56 = (y.c.q)var26.get(bg.a(var55));
               var40 = var22;
               if(var32) {
                  break;
               }

               if(!var22 || var56 != null) {
                  var25 = var5.a(var23, var53);
                  var8.a(var25, 1);
                  var9.a(var25, Math.min(1000.0D, this.a(var55, var18, var41, var19, var20)));
                  if(var56 != null && var5.f(var56)) {
                     var5.a(var56);
                  }
               }

               var52.g();
               if(var32) {
                  break label179;
               }
            }
         }

         var34.g();
      } while(!var32);

      y.c.h var35 = y.g.M.b();
      y.a.l.a(var5, (y.c.q)var6, (y.c.q)var7, var8, var9, var35, (y.c.A)null);
      byte var37 = this.b();
      int var39 = this.a();
      var41 = true;
      ArrayList var43 = new ArrayList();
      y.c.e var45 = var1.j();

      label134:
      while(true) {
         int var44 = var45.f();

         label131:
         while(true) {
            if(var44 != 0) {
               y.c.d var46 = var45.a();
               y.c.q var47 = (y.c.q)var33.b(var46);
               if(var32) {
                  break;
               }

               if(var47 != null) {
                  var22 = var46.c().equals(var1);
                  y.c.e var48 = var47.l();

                  while(var48.f()) {
                     var44 = var35.a(var48.a());
                     if(var32) {
                        continue label131;
                     }

                     if(var44 > 0) {
                        if(var9.c(var48.a()) < 100000.0D) {
                           y.f.ax var49 = (y.f.ax)var10.b(var48.a().d());
                           var43.add(var49);
                           if(!this.a(var22, var49) && (!b(var49) || !a((y.c.q)var47, (y.c.c)var10)) && (!b(var46, var3) || !this.a(var49))) {
                              break;
                           }

                           boolean var50 = var49.b() && !this.a(var47, var10, var49.b(var37));
                           if(var50) {
                              label215: {
                                 double var51 = var49.a(var37, var39);
                                 double var54 = var49.b(var37, var39);
                                 if(var22) {
                                    var2.a(var46, new y.d.t(var51, var54));
                                    if(!var32) {
                                       break label215;
                                    }
                                 }

                                 var2.b(var46, new y.d.t(var51, var54));
                              }
                           }

                           var4.a(var46, var22, this.a(var49, var22, var50));
                           if(!var32) {
                              break;
                           }
                        }

                        var41 = false;
                        if(!var32) {
                           break;
                        }
                     }

                     var48.g();
                     if(var32) {
                        break;
                     }
                  }
               }

               var45.g();
               if(!var32) {
                  continue label134;
               }
            }

            if(!var41) {
               this.l.a(var1, (Object)null);
               if(!var32) {
                  return;
               }
            }
            break;
         }

         this.l.a(var1, var43);
         return;
      }
   }

   public void optimizeAfterLayering(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var6 = N.x;
      this.l = y.g.M.a();
      y.c.x var5 = var1.o();

      while(var5.f()) {
         this.a(var5.e(), var1, var3, var4);
         var5.g();
         if(var6) {
            break;
         }
      }

   }

   private static boolean b(y.f.aE var0) {
      return var0 != null && (var0 == f || var0 == b || var0 == e || var0 == a || var0 == g || var0 == c || var0 == h || var0 == d);
   }

   protected y.c.c a(y.f.X var1) {
      return var1.c(y.f.ay.a);
   }

   private static y.f.az a(y.c.c var0, y.c.q var1) {
      if(var0 == null) {
         return null;
      } else {
         y.f.ay var2 = (y.f.ay)var0.b(var1);
         return var2 == null?null:var2.b();
      }
   }

   protected void a(y.c.q var1, Comparator var2, Comparator var3, y.f.X var4, aV var5, aP var6) {
      boolean var21 = N.x;
      if(var1.a() != 0) {
         int var7 = 0;
         int var8 = 0;
         y.c.e var9 = var1.j();

         int var12;
         while(var9.f()) {
            y.c.d var10 = var9.a();
            Collection var11 = var10.d().equals(var1)?var5.a(var10).f():var5.a(var10).d();
            if(var11 != null) {
               var12 = var11.size();
               var7 += var12;
               if(var12 > 1) {
                  var8 += var12 - 1;
               }
            }

            var9.g();
            if(var21) {
               break;
            }
         }

         y.c.d[] var22 = (new y.c.f(var1.k())).e();
         y.g.e.a((Object[])var22, var2);
         y.c.f var23 = new y.c.f(var1.l());
         var23.sort(var3);
         var23.n();
         y.c.d[] var24 = var23.e();
         if(var7 == 0 && this.l != null && this.l.b(var1) != null) {
            Collection var26 = (Collection)this.l.b(var1);
            if(var26.size() == var1.a()) {
               ArrayList[] var25 = new ArrayList[4];
               int var27 = 0;

               while(var27 < 4) {
                  var25[var27] = new ArrayList();
                  ++var27;
                  if(var21) {
                     break;
                  }
               }

               y.c.D var28 = new y.c.D();
               Iterator var15 = var26.iterator();

               int var10000;
               int var17;
               while(true) {
                  if(var15.hasNext()) {
                     y.f.ax var16 = (y.f.ax)var15.next();
                     var10000 = b(var16);
                     if(var21) {
                        break;
                     }

                     if(var10000 != 0) {
                        var17 = this.a(1, 2, 1, 4, 8, 2, var16);
                        var25[var17].add(var16);
                        if(!var21) {
                           continue;
                        }
                     }

                     var28.add(var16);
                     if(!var21) {
                        continue;
                     }
                  }

                  var10000 = var25[3].size();
                  break;
               }

               int var29 = var10000;
               int var30 = var25[1].size();
               var17 = var22.length - var25[0].size();

               boolean var31;
               while(true) {
                  if(var17 > 0) {
                     var31 = var28.isEmpty();
                     if(var21) {
                        break;
                     }

                     label245: {
                        if(!var31) {
                           var25[0].add(var28.g());
                           if(!var21) {
                              break label245;
                           }
                        }

                        if(var29 > var30) {
                           --var29;
                           if(!var21) {
                              break label245;
                           }
                        }

                        --var30;
                     }

                     --var17;
                     if(!var21) {
                        continue;
                     }
                  }

                  var31 = var28.isEmpty();
                  break;
               }

               if(!var31) {
                  var25[2].addAll(var28);
               }

               var17 = 0;

               while(true) {
                  if(var17 < var25.length) {
                     Collections.sort(var25[var17], new bd(this, var17));
                     ++var17;
                     if(var21) {
                        break;
                     }

                     if(!var21) {
                        continue;
                     }
                  }

                  var17 = 0;
                  break;
               }

               int var18 = var29;

               while(true) {
                  if(var18 < var25[3].size()) {
                     this.a(var4, var22[var17++], (y.f.ax)var25[3].get(var18), false, var6);
                     ++var18;
                     if(var21) {
                        break;
                     }

                     if(!var21) {
                        continue;
                     }
                  }

                  Iterator var32 = var25[0].iterator();

                  while(var32.hasNext()) {
                     this.a(var4, var22[var17++], (y.f.ax)var32.next(), false, var6);
                     if(var21) {
                        break;
                     }
                  }

                  var18 = 0;
                  break;
               }

               while(var17 < var22.length) {
                  this.a(var4, var22[var17++], (y.f.ax)var25[1].get(var18++), false, var6);
                  if(var21) {
                     break;
                  }
               }

               int var19 = 0;
               int var20 = var18;

               while(var20 < var25[1].size()) {
                  this.a(var4, var24[var19++], (y.f.ax)var25[1].get(var20), true, var6);
                  ++var20;
                  if(var21) {
                     break;
                  }
               }

               Iterator var34 = var25[2].iterator();

               while(true) {
                  if(var34.hasNext()) {
                     this.a(var4, var24[var19++], (y.f.ax)var34.next(), true, var6);
                     if(var21) {
                        break;
                     }

                     if(!var21) {
                        continue;
                     }
                  }

                  var34 = var25[3].iterator();
                  break;
               }

               while(var34.hasNext() && var19 < var24.length) {
                  this.a(var4, var24[var19++], (y.f.ax)var34.next(), true, var6);
                  if(var21) {
                     break;
                  }
               }

            }
         } else if(var8 <= 0 && var7 == var1.a()) {
            if(var7 > 0) {
               var12 = 0;

               while(true) {
                  y.c.d var13;
                  ArrayList var14;
                  if(var12 < var22.length) {
                     var13 = var22[var12];
                     var14 = (ArrayList)var5.a(var13).f();
                     if(!var21) {
                        if(var14 != null && var14.size() > 0) {
                           this.a(var4, var13, (y.f.ax)var14.get(0), false, var6);
                        }

                        ++var12;
                        if(!var21) {
                           continue;
                        }

                        var12 = 0;
                     } else {
                        if(var14 != null && var14.size() > 0) {
                           this.a(var4, var13, (y.f.ax)var14.get(0), true, var6);
                        }

                        ++var12;
                        if(var21) {
                           break;
                        }
                     }
                  } else {
                     var12 = 0;
                  }

                  do {
                     if(var12 >= var24.length) {
                        return;
                     }

                     var13 = var24[var12];
                     var14 = (ArrayList)var5.a(var13).d();
                     if(var14 != null && var14.size() > 0) {
                        this.a(var4, var13, (y.f.ax)var14.get(0), true, var6);
                     }

                     ++var12;
                  } while(!var21);

                  return;
               }
            }

         } else {
            this.a(var1, var22, var24, var4, var5, var6);
         }
      }
   }

   private void a(y.c.q var1, y.c.d[] var2, y.c.d[] var3, y.f.X var4, aV var5, aP var6) {
      y.c.i var7;
      y.c.d[] var8;
      int var9;
      int var10;
      y.c.h var11;
      y.c.d[] var12;
      y.c.A var13;
      HashMap var14;
      ArrayList var15;
      ArrayList var16;
      Object var10000;
      y.c.q var10001;
      boolean var42;
      label321: {
         var42 = N.x;
         var7 = new y.c.i();
         var8 = new y.c.d[var2.length + var3.length];
         System.arraycopy(var2, 0, var8, 0, var2.length);
         System.arraycopy(var3, 0, var8, var2.length, var3.length);
         var9 = this.a(true);
         var10 = this.a(false);
         var11 = var7.u();
         var12 = new y.c.d[var8.length];
         var13 = var7.t();
         var14 = new HashMap();
         var15 = new ArrayList();
         var16 = new ArrayList();
         y.c.c var17 = this.a(var4);
         if(var17 != null) {
            y.f.ay var18 = (y.f.ay)var17.b(var1);
            if(var18 != null) {
               Iterator var19 = var18.a();

               while(var19.hasNext()) {
                  y.f.aA var20 = (y.f.aA)var19.next();
                  if(var14.get(bg.a(var20.a())) == null) {
                     y.c.q var21 = var7.d();
                     var14.put(bg.a(var20.a()), var21);
                     var10000 = var13;
                     var10001 = var21;
                     if(var42) {
                        break label321;
                     }

                     var13.a(var21, var20);
                     var16.add(var21);
                     var15.add(var20);
                     if(var42) {
                        break;
                     }
                  }
               }
            }
         }

         var10000 = var17;
         var10001 = var1;
      }

      Collection var24;
      int var25;
      byte var43;
      label307: {
         y.f.az var46 = a((y.c.c)var10000, (y.c.q)var10001);
         if(var46 != null) {
            y.c.f var47 = new y.c.f(var8);
            var47.sort(new bf(var1, var5, (bc)null));
            y.c.e var49 = var47.a();

            while(var49.f()) {
               y.c.d var53 = var49.a();
               byte var22 = var53.d().equals(var1);
               A var23 = var5.a(var53);
               var43 = var22;
               if(var42) {
                  break label307;
               }

               var24 = var22 != 0?var23.f():var23.d();
               if(var24 != null && !var24.isEmpty()) {
                  label325: {
                     if(var22 != 0 && b(var23.e())) {
                        var25 = this.b(var23.e().b());
                        if(!var42) {
                           break label325;
                        }
                     }

                     if(var22 == 0 && b(var23.c())) {
                        var25 = this.b(var23.c().b());
                        if(!var42) {
                           break label325;
                        }
                     }

                     var25 = var22 != 0?var9:var10;
                  }

                  y.f.aA var26 = var46.a(var53, var22 == 0, var25);
                  if(var14.get(bg.a(var26.a())) == null) {
                     y.c.q var27 = var7.d();
                     var14.put(bg.a(var26.a()), var27);
                     var13.a(var27, var26);
                     var16.add(var27);
                     var15.add(var26);
                  }
               }

               var49.g();
               if(var42) {
                  break;
               }
            }
         }

         var43 = 0;
      }

      int var48 = var43;

      int var44;
      while(true) {
         if(var48 < var8.length) {
            y.c.d var51 = var8[var48];
            byte var54 = var51.d().equals(var1);
            A var56 = var5.a(var51);
            var44 = var54;
            if(var42) {
               break;
            }

            int var58;
            label327: {
               if(var54 != 0 && b(var56.e())) {
                  var58 = this.b(var56.e().b());
                  if(!var42) {
                     break label327;
                  }
               }

               if(var54 == 0 && b(var56.c())) {
                  var58 = this.b(var56.c().b());
                  if(!var42) {
                     break label327;
                  }
               }

               var58 = var54 != 0?var9:var10;
            }

            var24 = var54 != 0?var56.f():var56.d();
            var25 = 0;
            y.f.ax var64;
            if(var24 != null && var24.size() > 0) {
               Iterator var60 = var24.iterator();

               label259:
               while(true) {
                  label257:
                  while(true) {
                     if(!var60.hasNext()) {
                        break label259;
                     }

                     var10000 = var60.next();

                     do {
                        var64 = (y.f.ax)var10000;
                        if(!var64.a(var58)) {
                           continue label257;
                        }

                        ++var25;
                        var10000 = var14.get(bg.a(var64));
                     } while(var42);

                     if(var10000 == null) {
                        y.c.q var28 = var7.d();
                        var14.put(bg.a(var64), var28);
                        var13.a(var28, var64);
                        var16.add(var28);
                        if(var42) {
                           break label259;
                        }
                     }
                  }
               }
            }

            if(var25 == 0 && var15.isEmpty()) {
               y.c.q var61 = var7.d();
               var64 = y.f.ax.b(var54 != 0?var9:var10);
               var14.put(bg.a(var64), var61);
               var13.a(var61, var64);
               var16.add(var61);
               y.c.d var68 = var7.a(var61, var61);
               var11.a(var68, 0.0D);
               var12[var48] = var68;
            }

            ++var48;
            if(!var42) {
               continue;
            }
         }

         Collections.sort(var16, new be(this, var13));
         var44 = var16.size();
         break;
      }

      y.c.q[] var50 = new y.c.q[var44];
      var16.toArray(var50);
      y.c.q[] var52 = new y.c.q[var8.length];
      int[] var55 = new int[var7.e()];
      double var57 = 0.0D;
      y.c.d[][] var59 = new y.c.d[var8.length][];
      var25 = 0;

      while(true) {
         if(var25 < var8.length) {
            y.c.d var62 = var8[var25];
            byte var65 = var62.d().equals(var1);
            A var69 = var5.a(var62);
            var44 = var65;
            if(var42) {
               break;
            }

            int var29;
            label331: {
               if(var65 != 0 && b(var69.e())) {
                  var29 = this.b(var69.e().b());
                  if(!var42) {
                     break label331;
                  }
               }

               if(var65 == 0 && b(var69.c())) {
                  var29 = this.b(var69.c().b());
                  if(!var42) {
                     break label331;
                  }
               }

               var29 = var65 != 0?var9:var10;
            }

            y.c.q var30;
            double var31;
            byte var34;
            y.f.ax var36;
            y.c.q var37;
            y.c.d var38;
            double var39;
            y.c.q var41;
            label219: {
               var30 = var7.d();
               var52[var25] = var30;
               var31 = Double.MAX_VALUE;
               Collection var33 = var65 != 0?var69.f():var69.d();
               var34 = 0;
               if(var33 != null && var33.size() > 0) {
                  Iterator var35 = var33.iterator();

                  while(var35.hasNext()) {
                     var36 = (y.f.ax)var35.next();
                     if(var36.a(var29)) {
                        var34 = 1;
                        var37 = (y.c.q)var14.get(bg.a(var36));
                        var38 = var7.a(var37, var30);
                        var39 = var36.f();
                        var11.a(var38, var39);
                        double var82;
                        var44 = (var82 = var39 - var31) == 0.0D?0:(var82 < 0.0D?-1:1);
                        if(var42) {
                           break label219;
                        }

                        if(var44 < 0) {
                           if(var12[var25] != null) {
                              var41 = var12[var25].c();
                              --var55[var41.d()];
                           }

                           var12[var25] = var38;
                           var31 = var39;
                           ++var55[var37.d()];
                           if(var42) {
                              break;
                           }
                        }
                     }
                  }
               }

               var44 = var34;
            }

            if(var44 == 0) {
               int var77 = 0;

               while(true) {
                  if(var77 < var15.size()) {
                     var36 = ((y.f.aA)var15.get(var77)).a();
                     var43 = var36.a(var29);
                     if(var42) {
                        break;
                     }

                     if(var43 != 0) {
                        var34 = 1;
                        var37 = (y.c.q)var14.get(bg.a(var36));
                        var38 = var7.a(var37, var30);
                        var39 = var36.f();
                        var11.a(var38, var39);
                        if(var39 < var31) {
                           if(var12[var25] != null) {
                              var41 = var12[var25].c();
                              --var55[var41.d()];
                           }

                           var12[var25] = var38;
                           var31 = var39;
                           ++var55[var37.d()];
                        }
                     }

                     ++var77;
                     if(!var42) {
                        continue;
                     }
                  }

                  var43 = var34;
                  break;
               }

               if(var43 == 0) {
                  y.c.q var78 = var12[var25].c();
                  y.c.d var80 = var12[var25];
                  var7.a(var80, var78, var30);
                  var11.a(var80, 0.0D);
                  var31 = 0.0D;
                  var55[var78.d()] = 1;
               }
            }

            var59[var25] = new y.c.d[var30.b()];
            y.c.d var79 = var30.g();
            int var81 = 0;

            label188: {
               while(var81 < var59[var25].length) {
                  var59[var25][var81] = var79;
                  ++var81;
                  var79 = var79.h();
                  if(var42) {
                     break label188;
                  }

                  if(var42) {
                     break;
                  }
               }

               var57 += var31;
               ++var25;
            }

            if(!var42) {
               continue;
            }
         }

         var44 = var7.f();
         break;
      }

      y.c.A var66 = y.g.M.a(new Object[var44]);
      y.c.A var63 = y.g.M.a(new int[var7.f()]);
      y.c.A var67 = y.g.M.a(new int[var7.f()]);
      int var70 = 0;

      while(true) {
         if(var70 < var50.length) {
            y.c.q var73 = var50[var70];
            Object var72 = var13.b(var73);
            var44 = var72 instanceof y.f.aA;
            if(var42) {
               break;
            }

            label169: {
               if(var44 != 0) {
                  y.f.aA var76 = (y.f.aA)var72;
                  var66.a(var73, var76.a());
                  var63.a(var73, var76.b());
                  if(!var42) {
                     break label169;
                  }
               }

               var66.a(var73, var72);
               var63.a(var73, Integer.MAX_VALUE);
            }

            var67.a(var50[var70], var70);
            ++var70;
            if(!var42) {
               continue;
            }
         }

         var44 = var7.h();
         break;
      }

      y.c.h var71 = y.g.M.b(new double[var44]);
      y.c.e var75 = var7.p();

      while(true) {
         if(var75.f()) {
            y.c.d var74 = var75.a();
            var71.a(var74, var11.c(var74));
            var75.g();
            if(var42) {
               break;
            }

            if(!var42) {
               continue;
            }
         }

         this.a(var1, var7, var52, var50, var8, var12, var71, var55, var63, var66, var67, var57, var59);
         this.a(var1, var7, var52, var50, var8, var12, var71, var55, var63, var66, var67);
         this.a(var1, (y.c.d[])var8, (y.c.d[])var12, (y.c.c)var13, (y.f.X)var4, var6);
         break;
      }

   }

   private void a(y.c.q var1, y.c.i var2, y.c.q[] var3, y.c.q[] var4, y.c.d[] var5, y.c.d[] var6, y.c.c var7, int[] var8, y.c.c var9, y.c.c var10, y.c.c var11) {
      boolean var23 = N.x;
      double var12 = this.a(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      int var14 = 0;

      while(var14 < var3.length) {
         y.c.q var15 = var3[var14];
         y.c.q var10000 = var6[var14].a(var15);

         label42:
         while(true) {
            y.c.q var16 = var10000;
            int var17 = var14;

            while(true) {
               if(var17 >= var3.length) {
                  break label42;
               }

               y.c.q var18 = var3[var17];
               y.c.q var19 = var6[var17].a(var18);
               var10000 = var16;
               if(var23) {
                  break;
               }

               if(var16 != var19 && var2.b(var16, var18) && var2.b(var19, var15)) {
                  label54: {
                     y.c.d var20 = var6[var14];
                     var6[var14] = var6[var17];
                     var6[var17] = var20;
                     double var21 = this.a(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
                     if(var21 < var12) {
                        var12 = var21;
                        var16 = var19;
                        if(!var23) {
                           break label54;
                        }
                     }

                     var6[var17] = var6[var14];
                     var6[var14] = var20;
                  }
               }

               ++var17;
               if(var23) {
                  break label42;
               }
            }
         }

         ++var14;
         if(var23) {
            break;
         }
      }

   }

   private int b(int var1) {
      byte var2 = this.b();
      return var2 == 0?var1:(var2 == 2?(var1 == 1?2:(var1 == 2?1:(var1 == 8?8:(var1 == 4?4:255)))):(var2 == 1?(var1 == 1?8:(var1 == 2?4:(var1 == 8?2:(var1 == 4?1:255)))):(var1 == 1?4:(var1 == 2?8:(var1 == 8?1:(var1 == 4?2:255))))));
   }

   private int a(boolean var1) {
      if(var1) {
         switch(this.b()) {
         case 0:
         default:
            return 237;
         case 1:
            return 235;
         case 2:
            return 238;
         case 3:
            return 231;
         }
      } else {
         switch(this.b()) {
         case 0:
         default:
            return 222;
         case 1:
            return 215;
         case 2:
            return 221;
         case 3:
            return 219;
         }
      }
   }

   private void a(y.c.q var1, y.c.i var2, y.c.q[] var3, y.c.q[] var4, y.c.d[] var5, y.c.d[] var6, y.c.c var7, int[] var8, y.c.c var9, y.c.c var10, y.c.c var11, double var12, y.c.d[][] var14) {
      boolean var35 = N.x;
      double var15 = this.a(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      double var17 = var15;
      int[] var19 = new int[var8.length];
      System.arraycopy(var8, 0, var19, 0, var8.length);
      y.c.d[] var20 = new y.c.d[var6.length];
      System.arraycopy(var6, 0, var20, 0, var6.length);
      int[] var21 = new int[var8.length];
      y.c.d[] var22 = new y.c.d[var6.length];
      y.g.ar var23 = this.m?new y.g.ar(4242L):new y.g.ar();
      double var24 = (double)var2.g();
      int var26 = 0;

      int var10000;
      label65:
      while(true) {
         var10000 = var26;

         label62:
         while(var10000 < 20) {
            double var36;
            var10000 = (var36 = var15 - var12) == 0.0D?0:(var36 < 0.0D?-1:1);
            if(var35) {
               break label65;
            }

            if(var10000 <= 0) {
               break;
            }

            boolean var27 = true;
            int var28 = 20 * var2.g();

            while(var28 > 0) {
               double var37;
               var10000 = (var37 = var15 - var12) == 0.0D?0:(var37 < 0.0D?-1:1);
               if(var35) {
                  continue label62;
               }

               if(var10000 <= 0) {
                  break;
               }

               double var29 = var15;
               if(var27) {
                  System.arraycopy(var8, 0, var21, 0, var8.length);
                  System.arraycopy(var6, 0, var22, 0, var6.length);
               }

               if(var27 = a(var3, var6, var14, var8, var23)) {
                  var15 = this.a(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11);
                  double var31 = var15 - var29;
                  if(var31 > 0.0D) {
                     double var33 = 1.0D - Math.exp(-var31 / var24);
                     if(var23.nextDouble() < var33) {
                        System.arraycopy(var21, 0, var8, 0, var8.length);
                        System.arraycopy(var22, 0, var6, 0, var6.length);
                        var15 = var29;
                     }
                  }

                  if(var15 < var17) {
                     var17 = var15;
                     System.arraycopy(var8, 0, var19, 0, var8.length);
                     System.arraycopy(var6, 0, var20, 0, var6.length);
                  }
               }

               --var28;
               if(var35) {
                  break;
               }
            }

            var24 *= 0.85D;
            ++var26;
            if(!var35) {
               continue label65;
            }
            break;
         }

         double var38;
         var10000 = (var38 = var15 - var17) == 0.0D?0:(var38 < 0.0D?-1:1);
         break;
      }

      if(var10000 > 0) {
         System.arraycopy(var19, 0, var8, 0, var8.length);
         System.arraycopy(var20, 0, var6, 0, var6.length);
      }

   }

   private void a(y.c.q var1, y.c.d[] var2, y.c.d[] var3, y.c.c var4, y.f.X var5, aP var6) {
      boolean var12 = N.x;
      int var7 = 0;

      while(var7 < var2.length) {
         y.c.d var8;
         y.f.ax var10;
         label17: {
            var8 = var2[var7];
            y.c.d var9 = var3[var7];
            Object var11 = var4.b(var9.c());
            if(var11 instanceof y.f.aA) {
               var10 = ((y.f.aA)var11).a();
               if(!var12) {
                  break label17;
               }
            }

            var10 = (y.f.ax)var11;
         }

         this.a(var5, var8, var10, var8.c().equals(var1), var6);
         ++var7;
         if(var12) {
            break;
         }
      }

   }

   private void a(y.f.X var1, y.c.d var2, y.f.ax var3, boolean var4, aP var5) {
      if(!a(var3, this.a(!var4)) && (var3.b() || var3.a() != 255)) {
         var5.a(var2, var4, this.a(var3, var4));
         if(var3.b()) {
            y.d.t var6 = new y.d.t(var3.a(this.b(), this.a()), var3.b(this.b(), this.a()));
            if(var4) {
               var1.a(var2, var6);
               if(!N.x) {
                  return;
               }
            }

            var1.b(var2, var6);
         }

      }
   }

   private y.f.aE a(y.f.ax var1, boolean var2) {
      int var3 = var2?this.a(1, 2, 1, 8, 4, 2, var1):this.a(1, 1, 2, 8, 4, 1, var1);
      switch(var3) {
      case 0:
      default:
         return y.f.aE.a((byte)1, var1.b());
      case 1:
         return y.f.aE.a((byte)4, var1.b());
      case 2:
         return y.f.aE.a((byte)2, var1.b());
      case 3:
         return y.f.aE.a((byte)8, var1.b());
      }
   }

   private y.f.aE a(y.f.ax var1, boolean var2, boolean var3) {
      int var4 = var2?this.a(1, 2, 1, 8, 4, 2, var1):this.a(1, 1, 2, 8, 4, 1, var1);
      switch(var4) {
      case 0:
      default:
         if(var3) {
            return f;
         }

         return b;
      case 1:
         if(var3) {
            return h;
         }

         return d;
      case 2:
         if(var3) {
            return e;
         }

         return a;
      case 3:
         return var3?g:c;
      }
   }

   private static boolean a(y.c.q[] var0, y.c.d[] var1, y.c.d[][] var2, int[] var3, y.g.ar var4) {
      boolean var11 = N.x;
      byte var5 = 0;
      int var6 = 0;

      int var10000;
      while(true) {
         if(var6 < var0.length) {
            int var7 = var2[var6].length;
            var10000 = var7;
            if(var11) {
               break;
            }

            if(var7 > 1) {
               int var8 = var4.nextInt(var7);
               y.c.d var9 = var2[var6][var8];
               y.c.d var10 = var1[var6];
               if(var10 != var9) {
                  var5 = 1;
                  --var3[var10.c().d()];
                  var1[var6] = var9;
                  ++var3[var9.c().d()];
               }
            }

            ++var6;
            if(!var11) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      return (boolean)var10000;
   }

   private double a(y.c.q var1, y.c.q[] var2, y.c.q[] var3, y.c.d[] var4, y.c.d[] var5, y.c.c var6, int[] var7, y.c.c var8, y.c.c var9, y.c.c var10) {
      boolean var26 = N.x;
      int var11 = this.a(true);
      int var12 = this.a(false);
      double var13 = 0.0D;
      int var15 = 0;

      y.c.q var10000;
      while(true) {
         if(var15 < var2.length) {
            y.c.d var16 = var5[var15];
            var13 += var6.c(var16);
            var10000 = var4[var15].d();
            if(var26) {
               break;
            }

            y.c.q var10001 = var1;

            label100: {
               int var19;
               label99:
               while(true) {
                  boolean var17 = var10000 == var10001;
                  y.f.ax var18 = (y.f.ax)var9.b(var16.c());
                  if(a(var18, var11)) {
                     break label100;
                  }

                  var19 = 0;
                  int var20 = var15 + 1;

                  while(true) {
                     if(var20 >= var2.length) {
                        break label99;
                     }

                     var10000 = var4[var20].d();
                     var10001 = var1;
                     if(var26) {
                        break;
                     }

                     boolean var21 = var10000 == var1;
                     y.f.ax var22 = (y.f.ax)var9.b(var5[var20].c());
                     if(!a(var22, var12)) {
                        label132: {
                           int var23 = y.g.e.a(var10.a(var16.c()), var10.a(var5[var20].c()));
                           if(!var17 && !var21) {
                              if(var23 <= 0) {
                                 break label132;
                              }

                              ++var19;
                              if(!var26) {
                                 break label132;
                              }
                           }

                           if(var17 && !var21) {
                              if(!var18.a((int)8)) {
                                 if(var23 <= 0) {
                                    break label132;
                                 }

                                 ++var19;
                                 if(!var26) {
                                    break label132;
                                 }
                              }

                              if(var23 >= 0) {
                                 break label132;
                              }

                              ++var19;
                              if(!var26) {
                                 break label132;
                              }
                           }

                           boolean var24 = var18.a((int)8);
                           boolean var25 = var22.a((int)8);
                           if(var24 != var25) {
                              if(var23 >= 0) {
                                 break label132;
                              }

                              ++var19;
                              if(!var26) {
                                 break label132;
                              }
                           }

                           if(var23 > 0) {
                              ++var19;
                           }
                        }
                     }

                     ++var20;
                     if(var26) {
                        break label99;
                     }
                  }
               }

               var13 += this.i * (double)var19;
            }

            ++var15;
            if(!var26) {
               continue;
            }

            var15 = 0;
         } else {
            var15 = 0;
         }

         if(var15 >= var3.length) {
            return var13;
         }

         var10000 = var3[var15];
         break;
      }

      while(true) {
         y.c.q var27 = var10000;
         int var28 = var7[var27.d()] - var8.a(var27);
         if(var28 > 0) {
            var13 += (double)var28 * this.k;
         }

         ++var15;
         if(var26 || var15 >= var3.length) {
            return var13;
         }

         var10000 = var3[var15];
      }
   }

   private static boolean a(y.f.ax var0, int var1) {
      return !var0.b() && var0.a() == var1;
   }

   final int a(int var1, int var2, int var3, int var4, int var5, int var6, y.f.ax var7) {
      boolean var11 = N.x;
      int var8 = 0;
      int var9 = var7.b(this.b());
      switch(var9) {
      case 255:
         var9 = var6;
         if(!var11) {
            break;
         }
      case 32:
         var9 = var3;
         if(!var11) {
            break;
         }
      case 16:
         var9 = var2;
         if(!var11) {
            break;
         }
      case 128:
         var9 = var4;
         if(!var11) {
            break;
         }
      case 64:
         var9 = var5;
      }

      switch(var9) {
      case 1:
         var8 = 0;
         if(!var11) {
            break;
         }
      case 4:
         var8 = 1;
         if(!var11) {
            break;
         }
      case 2:
         var8 = 2;
         if(!var11) {
            break;
         }
      case 8:
         var8 = 3;
      case 3:
      case 5:
      case 6:
      case 7:
      }

      byte var12 = 0;
      int var10 = var1;
      switch(var1) {
      case 255:
         var10 = var6;
         if(!var11) {
            break;
         }
      case 32:
         var10 = var3;
         if(!var11) {
            break;
         }
      case 16:
         var10 = var2;
         if(!var11) {
            break;
         }
      case 128:
         var10 = var4;
         if(!var11) {
            break;
         }
      case 64:
         var10 = var5;
      }

      switch(var10) {
      case 1:
         var12 = 0;
         if(!var11) {
            break;
         }
      case 4:
         var12 = 1;
         if(!var11) {
            break;
         }
      case 2:
         var12 = 2;
         if(!var11) {
            break;
         }
      case 8:
         var12 = 3;
      case 3:
      case 5:
      case 6:
      case 7:
      }

      if(var8 < var12) {
         var8 += 4;
      }

      return var8 - var12;
   }

   static boolean a(y.f.aE var0) {
      return b(var0);
   }
}
