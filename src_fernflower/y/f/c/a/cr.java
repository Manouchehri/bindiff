package y.f.c.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.f.c.a.N;
import y.f.c.a.cs;
import y.f.c.a.ct;
import y.f.c.a.cu;
import y.f.c.a.cv;
import y.f.c.a.cw;
import y.f.c.a.cx;
import y.f.c.a.cy;
import y.f.c.a.cz;

class cr {
   private static final double a = Math.sqrt(2.0D);
   private Map b = new HashMap(11);
   private List c = new ArrayList(62);
   private double d;
   private double e = -1.7976931348623157E308D;
   private double f = Double.MAX_VALUE;
   private double g = 10.0D;
   private Map h = new HashMap();
   private List i = new ArrayList();
   private Map j = new HashMap();
   private Set k = new HashSet();
   private y.d.c l;
   private y.d.c m;
   private double n = 0.0D;
   private boolean o = true;
   private double p = 1.0D;
   private double q = 0.5D;
   private double r;
   private double s = 0.0D;
   private ArrayList t = new ArrayList();
   private int u = 20;
   private long v = 100L;
   private int w = 100;
   private int x = 500;
   private final Comparator y = new cz((cs)null);
   private List z;
   private y.c.D A;
   private y.c.D B;
   private double C;
   private double D;

   public void a(double var1) {
      this.e = var1;
   }

   public void a() {
      this.r = 0.0D;
      this.k.clear();
      this.j.clear();
      this.i.clear();
      this.h.clear();
      this.b.clear();
      this.t.clear();
      this.c.clear();
      this.s = 0.0D;
      this.d = -1.0D;
      this.z = null;
   }

   public void b(double var1) {
      this.n = var1;
   }

   public void c(double var1) {
      this.s = var1;
   }

   public void a(y.d.c var1) {
      this.l = var1;
   }

   public void b(y.d.c var1) {
      this.m = var1;
   }

   public y.d.c b() {
      return this.l;
   }

   public y.d.c c() {
      return this.m;
   }

   public void a(Object var1, double var2, boolean var4, double var5, boolean var7, boolean var8, double var9) {
      this.a(var1, 0.0D, this.g, var2, var4, var5, var7, var8, var9);
   }

   public cy a(Object var1) {
      return (cy)this.b.get(var1);
   }

   public cy a(Object var1, double var2, double var4, double var6, double var8, boolean var10, double var11, boolean var13) {
      return this.a(var1, var2, var4, var6, var8, var10, var11, var13, false, 0.0D);
   }

   public cy a(Object var1, double var2, double var4, double var6, boolean var8, double var9, boolean var11, boolean var12, double var13) {
      return this.a(var1, var2, var4, var4, var6, var8, var9, var11, var12, var13);
   }

   public cy a(Object var1, double var2, double var4, double var6, double var8, boolean var10, double var11, boolean var13, boolean var14, double var15) {
      cy var17;
      label11: {
         if(var8 > var11) {
            var17 = cy.a(var1, var2, var11, var13, var8, var10, var4, var6, var14, var15);
            if(!N.x) {
               break label11;
            }
         }

         var17 = cy.a(var1, var2, var8, var10, var11, var13, var4, var6, var14, var15);
      }

      this.b.put(var1, var17);
      this.c.add(var17);
      this.k.add(var1);
      return var17;
   }

   public cy a(Object var1, Object var2, double var3, double var5, double var7, boolean var9, double var10, boolean var12, boolean var13, double var14) {
      y.c.D var16 = (y.c.D)this.h.get(var2);
      if(var16 == null) {
         var16 = new y.c.D();
         this.h.put(var2, var16);
         this.i.add(var16);
      }

      cy var17 = cy.a(var1, var3, var7, var9, var10, var12, var5, var5, var13, var14);
      var16.add(var17);
      this.j.put(var1, var16);
      return var17;
   }

   public void a(Object var1, Object var2, int var3) {
      this.t.add(new Object[]{var1, var2, new Integer(var3)});
   }

   public boolean b(Object var1) {
      return this.k.contains(var1);
   }

   public boolean c(Object var1) {
      Object var2 = this.h.get(var1);
      return var2 != null && this.b.containsKey(var2);
   }

   public void a(long var1) {
      this.v = var1;
   }

   public void a(int var1) {
      this.w = var1;
   }

   public void b(int var1) {
      this.u = var1;
   }

   public void c(int var1) {
      this.x = var1;
   }

   public void d() {
      boolean var35 = N.x;
      if(this.h.size() > 0) {
         this.l();
      }

      cs var1 = new cs(this);
      this.z = new ArrayList();
      cy[] var2 = new cy[this.c.size()];
      this.C = Double.MAX_VALUE;
      this.D = -1.7976931348623157E308D;
      int var3 = this.c.size() - 1;

      cy[] var10000;
      while(true) {
         if(var3 >= 0) {
            cy var4 = (cy)this.c.get(var3);
            this.D = Math.max(this.D, var4.c);
            this.C = Math.min(this.C, var4.b);
            var10000 = var2;
            if(var35) {
               break;
            }

            var2[var3] = var4;
            --var3;
            if(!var35) {
               continue;
            }
         }

         var10000 = new cy[var2.length];
         break;
      }

      cy[] var36 = var10000;
      System.arraycopy(var2, 0, var36, 0, var2.length);
      cv[] var37 = new cv[var36.length * 2];
      int var5 = 0;

      cv var8;
      while(true) {
         if(var5 < var36.length) {
            cy var6 = var36[var5];
            cv var7 = new cv((cs)null);
            var7.b = var6.b - var6.h - var6.e;
            var7.c = true;
            var7.a = var6;
            var37[var5 * 2] = var7;
            var8 = new cv((cs)null);
            var8.b = var6.c + var6.h + var6.e;
            var8.c = false;
            var8.a = var6;
            var37[var5 * 2 + 1] = var8;
            ++var5;
            if(var35) {
               break;
            }

            if(!var35) {
               continue;
            }
         }

         y.g.e.a((Object[])var37, new ct(this));
         var5 = 0;
         break;
      }

      ArrayList var38 = new ArrayList(var36.length);
      int var39 = 0;

      label405:
      while(true) {
         int var66 = var39;

         label402:
         while(true) {
            int var10001 = var37.length;

            label399:
            while(true) {
               if(var66 >= var10001) {
                  break label402;
               }

               var8 = var37[var39];
               if(var35) {
                  return;
               }

               if(var8.c) {
                  ++var5;
                  var8.a.r = var38.size();
                  var38.add(var8.a);
                  if(!var35) {
                     break;
                  }
               }

               --var5;
               if(var5 != 0) {
                  break;
               }

               int var9 = var38.size();
               if(var9 > 1) {
                  y.c.q[] var10 = new y.c.q[var9];
                  y.c.i var11 = new y.c.i();
                  new y.c.i();
                  y.c.i var67 = new y.c.i();

                  y.c.i var12;
                  y.c.A var13;
                  y.c.q[] var14;
                  y.c.h var15;
                  y.c.h var16;
                  y.c.A var17;
                  label390:
                  while(true) {
                     var12 = var67;
                     if(var9 > this.u) {
                        var12 = null;
                        var13 = null;
                        var14 = null;
                     } else {
                        var13 = var12.t();
                        var14 = new y.c.q[var38.size()];
                     }

                     var15 = var11.u();
                     var16 = var11.u();
                     var17 = y.g.M.a();
                     int var18 = 0;

                     while(true) {
                        if(var18 >= var9) {
                           break label390;
                        }

                        var10[var18] = var11.d();
                        var17.a(var10[var18], var38.get(var18));
                        var67 = var12;
                        if(var35) {
                           break;
                        }

                        if(var12 != null) {
                           var13.a(var14[var18] = var12.d(), var38.get(var18));
                        }

                        ++var18;
                        if(var35) {
                           break label390;
                        }
                     }
                  }

                  int var19 = 0;
                  Iterator var20 = this.t.iterator();

                  cy var23;
                  int var24;
                  y.c.d var25;
                  label377:
                  while(true) {
                     while(true) {
                        if(!var20.hasNext()) {
                           break label377;
                        }

                        Object[] var21 = (Object[])var20.next();
                        cy var22 = this.a(var21[0]);
                        var23 = this.a(var21[1]);
                        cy var68 = var22;

                        while(var68 != null) {
                           var68 = var23;
                           if(!var35) {
                              if(var23 != null && var22.r >= 0 && var22.r < var9 && var38.get(var22.r) == var22 && var23.r >= 0 && var23.r < var9 && var38.get(var23.r) == var23) {
                                 var24 = ((Integer)var21[2]).intValue();
                                 if(var24 > 0) {
                                    var25 = var11.a(var10[var22.r], var10[var23.r]);
                                    ++var19;
                                    var15.a(var25, 3);
                                    var16.a(var25, 1);
                                    if(var12 != null && !var12.b(var14[var22.r], var14[var23.r]) && !var12.b(var14[var23.r], var14[var22.r])) {
                                       var12.a(var14[var22.r], var14[var23.r]);
                                       if(var35) {
                                          break label377;
                                       }
                                    }
                                 }
                              }
                              break;
                           }
                        }
                     }
                  }

                  label466: {
                     if(var12 != null || var19 < this.x) {
                        int var41 = 0;

                        while(var41 < var9) {
                           cy var43 = (cy)var38.get(var41);
                           var66 = var41 + 1;
                           if(var35) {
                              continue label402;
                           }

                           int var45 = var66;

                           while(var45 < var9) {
                              var23 = (cy)var38.get(var45);
                              var67 = var12;
                              if(var35) {
                                 break label466;
                              }

                              if(var12 != null && var43.c + var43.h + var43.e > var23.b - var23.h - var23.e && var43.b - var43.h - var43.e < var23.c + var23.h + var23.e) {
                                 boolean var49;
                                 label330: {
                                    var49 = true;
                                    if(var43.b - var43.e > var23.c + var23.e) {
                                       if(var43.m == 0 || var43.m == 2) {
                                          if(var23.m != 1 && var23.m != 0) {
                                             break label330;
                                          }

                                          var49 = false;
                                          if(!var35) {
                                             break label330;
                                          }
                                       }

                                       if(var23.m != 3 && var23.m != 2) {
                                          break label330;
                                       }

                                       var49 = false;
                                       if(!var35) {
                                          break label330;
                                       }
                                    }

                                    if(var23.b - var23.e > var43.c + var43.e) {
                                       label468: {
                                          if(var43.m == 0 || var43.m == 1) {
                                             if(var23.m != 2 && var23.m != 0) {
                                                break label468;
                                             }

                                             var49 = false;
                                             if(!var35) {
                                                break label468;
                                             }
                                          }

                                          if(var23.m == 3 || var23.m == 1) {
                                             var49 = false;
                                          }
                                       }
                                    }
                                 }

                                 if(var49 && var14[var41].c(var14[var45]) == null) {
                                    var12.a(var14[var41], var14[var45]);
                                    if(var12.g() > this.w) {
                                       var12 = null;
                                    }
                                 }
                              }

                              if(var19 < this.x) {
                                 var24 = this.a(var43, var23);
                                 if(var24 != 0) {
                                    label457: {
                                       ++var19;
                                       if(var24 > 0) {
                                          var25 = var11.a(var10[var41], var10[var45]);
                                          var15.a(var25, var24);
                                          var16.a(var25, 1);
                                          if(!var35) {
                                             break label457;
                                          }
                                       }

                                       var25 = var11.a(var10[var45], var10[var41]);
                                       var15.a(var25, -var24);
                                       var16.a(var25, 1);
                                    }
                                 }
                              }

                              ++var45;
                              if(var35) {
                                 break;
                              }
                           }

                           ++var41;
                           if(var35) {
                              break;
                           }
                        }
                     }

                     var67 = var11;
                  }

                  y.c.q var42 = var67.d();
                  y.c.q var69 = var11.d();

                  label281:
                  while(true) {
                     y.c.q var44 = var69;
                     y.c.d var46 = var11.a(var42, var44);
                     var15.a(var46, 0);
                     y.c.x var70 = var11.o();

                     while(true) {
                        y.c.x var47 = var70;

                        y.c.q var51;
                        while(var47.f()) {
                           var51 = var47.e();
                           var69 = var51;
                           if(var35) {
                              continue label281;
                           }

                           if(var51 != var42 && var51 != var44) {
                              cy var50 = (cy)var17.b(var51);
                              if(var50 != null) {
                                 label460: {
                                    y.c.d var26;
                                    if(var50.a() == 0) {
                                       var26 = var11.a(var51, var42);
                                       var15.a(var26, 0);
                                       if(!var35) {
                                          break label460;
                                       }
                                    }

                                    if(var50.a() == 3) {
                                       var26 = var11.a(var44, var51);
                                       var15.a(var26, 0);
                                       if(!var35) {
                                          break label460;
                                       }
                                    }

                                    var26 = var11.a(var42, var51);
                                    var15.a(var26, 0);
                                    y.c.d var27 = var11.a(var51, var44);
                                    var15.a(var27, 0);
                                 }
                              }
                           }

                           var47.g();
                           if(var35) {
                              break;
                           }
                        }

                        int[] var48 = new int[4];
                        var51 = null;

                        int var52;
                        label226:
                        do {
                           y.c.f var53;
                           y.c.f var71 = var53 = y.a.c.a(var11, true);

                           do {
                              if(var71.isEmpty()) {
                                 break label226;
                              }

                              var25 = var53.b();
                              var52 = var15.a(var25);
                              var71 = var53;
                           } while(var35);

                           y.c.e var55 = var53.a();

                           y.c.d var28;
                           while(var55.f()) {
                              var28 = var55.a();
                              int var29 = var15.a(var28);
                              var66 = var29;
                              var10001 = var52;
                              if(var35) {
                                 continue label399;
                              }

                              if(var29 < var52) {
                                 var52 = var29;
                                 var25 = var28;
                              }

                              var55.g();
                              if(var35) {
                                 break;
                              }
                           }

                           y.c.q var56 = var11.d();
                           var28 = var11.a(var25.d(), var56);
                           var15.a(var28, -var52);
                           ++var48[var52];
                           var11.a(var25, var25.c(), var56);
                        } while(!var35);

                        int[] var54 = new int[4];
                        var54[0] = 1;
                        var52 = 1;

                        while(var52 < 3) {
                           var54[var52] = var48[var52] * var54[var52 - 1] + 1;
                           ++var52;
                           if(var35) {
                              break label281;
                           }

                           if(var35) {
                              break;
                           }
                        }

                        y.c.A var58 = y.g.M.a(new int[var11.f()]);
                        y.c.h var57 = y.g.M.b(new int[var11.h()]);
                        y.c.e var59 = var11.p();

                        label246: {
                           while(var59.f()) {
                              y.c.d var61 = var59.a();
                              int var30 = var15.a(var61);
                              var66 = var30;
                              if(var35) {
                                 break label246;
                              }

                              if(var30 < 0) {
                                 var57.a(var61, var54[-var30]);
                              }

                              var59.g();
                              if(var35) {
                                 break;
                              }
                           }

                           y.a.u.a(var11, var58, var57, var16, this.v);
                           var66 = 0;
                        }

                        int var60 = var66;

                        while(var60 < var10.length) {
                           y.c.q var62 = var10[var60];
                           cy var65 = (cy)var38.get(var60);
                           var65.d = (double)var58.a(var62);
                           var66 = var65.m;
                           if(var35) {
                              continue label402;
                           }

                           label256: {
                              if(var66 == 0) {
                                 var65.d -= 0.25D;
                                 if(!var35) {
                                    break label256;
                                 }
                              }

                              if(var65.m == 3) {
                                 var65.d += 0.25D;
                              }
                           }

                           ++var60;
                           if(var35) {
                              break;
                           }
                        }

                        if(var12 == null || var12.g() >= this.w) {
                           break label281;
                        }

                        y.c.y[] var63 = y.a.k.a(var12);
                        double var64 = 0.2D / (double)var63.length;
                        int var31 = 0;

                        while(true) {
                           if(var31 >= var63.length) {
                              break label281;
                           }

                           var70 = var63[var31].a();
                           if(var35) {
                              break;
                           }

                           y.c.x var32 = var70;

                           label274: {
                              while(var32.f()) {
                                 y.c.q var33 = var32.e();
                                 cy var34 = (cy)var13.b(var33);
                                 var34.d += var64 * (double)var31;
                                 var32.g();
                                 if(var35) {
                                    break label274;
                                 }

                                 if(var35) {
                                    break;
                                 }
                              }

                              ++var31;
                           }

                           if(var35) {
                              break label281;
                           }
                        }
                     }
                  }
               }

               cy[] var40 = (cy[])var38.toArray(new cy[var38.size()]);
               var38.clear();
               y.g.e.a((Object[])var40, this.y);
               y.g.e.a((Object[])var40, var1);
               this.z.add(var40);
               break;
            }

            ++var39;
            if(!var35) {
               continue label405;
            }
            break;
         }

         this.k();
         return;
      }
   }

   private int a(cy var1, cy var2) {
      if(var1.c + var1.h < var2.b - var2.h) {
         return 0;
      } else if(var1.b - var1.h > var2.c + var2.h) {
         return 0;
      } else {
         boolean var3;
         boolean var4;
         if(var2.a() == var1.a()) {
            switch(var2.a()) {
            case 0:
            default:
               if(var1.b == var2.b) {
                  if(var1.c < var2.c) {
                     return 1;
                  }

                  if(var1.c == var2.c) {
                     return 0;
                  }

                  return -1;
               }

               if(var1.c == var2.c) {
                  if(var1.b > var2.c) {
                     return 1;
                  }

                  return -1;
               }

               if(var1.b < var2.b) {
                  if(var1.c > var2.c) {
                     return -2;
                  }

                  return 0;
               }

               if(var1.c < var2.c) {
                  return 2;
               }

               return 0;
            case 1:
               if(var1.b == var2.b) {
                  if(var1.c > var2.c) {
                     return -1;
                  }

                  if(var1.c < var2.c) {
                     return 1;
                  }

                  return 0;
               }

               if(var1.c == var2.c) {
                  if(var1.b > var2.b) {
                     return -1;
                  }

                  if(var1.b < var2.b) {
                     return 1;
                  }

                  return 0;
               }

               if(var1.b < var2.b && var1.c > var2.c) {
                  var3 = this.a(var1.b, var1.h, var2.b, var2.h);
                  var4 = this.a(var1.c, var1.h, var2.c, var2.h);
                  if(var3 && !var4) {
                     return 1;
                  }

                  if(var4 && !var3) {
                     return -1;
                  }

                  return 0;
               }

               if(var2.b < var1.b && var2.c > var1.c) {
                  var3 = this.a(var1.b, var1.h, var2.b, var2.h);
                  var4 = this.a(var1.c, var1.h, var2.c, var2.h);
                  if(var3 && !var4) {
                     return -1;
                  }

                  if(var4 && !var3) {
                     return 1;
                  }

                  return 0;
               }

               if(var1.b < var2.b && var1.c < var2.c) {
                  return 2;
               }

               if(var2.b < var1.b && var2.c < var1.c) {
                  return -2;
               }
               break;
            case 2:
               if(var1.b == var2.b) {
                  if(var1.c > var2.c) {
                     return 1;
                  }

                  if(var1.c < var2.c) {
                     return -1;
                  }

                  return 0;
               }

               if(var1.c == var2.c) {
                  if(var1.b > var2.b) {
                     return 1;
                  }

                  if(var1.b < var2.b) {
                     return -1;
                  }

                  return 0;
               }

               if(var1.b < var2.b && var1.c > var2.c) {
                  var3 = this.a(var1.b, var1.h, var2.b, var2.h);
                  var4 = this.a(var1.c, var1.h, var2.c, var2.h);
                  if(var3 && !var4) {
                     return -1;
                  }

                  if(var4 && !var3) {
                     return 1;
                  }

                  return 0;
               }

               if(var2.b < var1.b && var2.c > var1.c) {
                  var3 = this.a(var1.b, var1.h, var2.b, var2.h);
                  var4 = this.a(var1.c, var1.h, var2.c, var2.h);
                  if(var3 && !var4) {
                     return 1;
                  }

                  if(var4 && !var3) {
                     return -1;
                  }

                  return 0;
               }

               if(var1.b < var2.b && var1.c < var2.c) {
                  return -2;
               }

               if(var2.b < var1.b && var2.c < var1.c) {
                  return 2;
               }
               break;
            case 3:
               if(var1.b == var2.b) {
                  if(var1.c < var2.c) {
                     return -1;
                  }

                  if(var1.c == var2.c) {
                     return 0;
                  }

                  return 1;
               }

               if(var1.c == var2.c) {
                  if(var1.b > var2.c) {
                     return -1;
                  }

                  return 1;
               }

               if(var1.b < var2.b) {
                  if(var1.c > var2.c) {
                     return 2;
                  }

                  return 0;
               }

               if(var1.c < var2.c) {
                  return -2;
               }

               return 0;
            }
         } else {
            if(var2.a() == 0) {
               return -3;
            }

            if(var1.a() == 0) {
               return 3;
            }

            if(var2.a() == 3) {
               return 3;
            }

            if(var1.a() == 3) {
               return -3;
            }

            var3 = this.a(var1.b, var1.h, var2.b, var2.h);
            var4 = this.a(var1.c, var1.h, var2.c, var2.h);
            double var5;
            double var7;
            if(var1.a() == 2) {
               if(var3) {
                  if(!var4) {
                     return 2;
                  }

                  var5 = Math.abs(var1.b - var2.b);
                  var7 = Math.abs(var1.c - var2.c);
                  if(var5 == var7) {
                     return 0;
                  }

                  return var5 > var7?-1:1;
               }

               if(var4) {
                  return -2;
               }
            } else {
               if(var3) {
                  if(!var4) {
                     return -2;
                  }

                  var5 = Math.abs(var1.b - var2.b);
                  var7 = Math.abs(var1.c - var2.c);
                  if(var5 == var7) {
                     return 0;
                  }

                  return var5 > var7?1:-1;
               }

               if(var4) {
                  return 2;
               }
            }
         }

         return 0;
      }
   }

   private boolean a(double var1, double var3, double var5, double var7) {
      return Math.abs(var1 - var5) < Math.min(var3, var7);
   }

   private void k() {
      y.d.d var1;
      y.d.d var2;
      double var3;
      double var5;
      double var7;
      double var9;
      boolean var11;
      int var10000;
      label75: {
         var11 = N.x;
         this.A = new y.c.D();
         if(this.l != null) {
            var1 = this.l.e();
            if(this.l.b(var1) > this.C) {
               this.A.a((Object)(new cw(this.C, -this.f, 0.0D, this.s, false)));
            }

            var2 = this.l.e();

            label71: {
               while(var2 != null) {
                  var3 = this.l.b(var2);
                  var5 = -this.l.c(var2);
                  var7 = this.l.a(var2);
                  double var12;
                  var10000 = (var12 = var7 - Double.MAX_VALUE) == 0.0D?0:(var12 < 0.0D?-1:1);
                  if(var11) {
                     break label71;
                  }

                  var9 = var10000 == 0?-this.f:-var7;
                  this.A.b((Object)(new cw(var3, var9, var5, 0.0D, this.s, false)));
                  var2 = this.l.e(var2);
                  if(var11) {
                     break;
                  }
               }

               var2 = this.l.f();
               double var13;
               var10000 = (var13 = this.l.b(var2) - this.D) == 0.0D?0:(var13 < 0.0D?-1:1);
            }

            if(var10000 >= 0) {
               break label75;
            }

            this.A.b((Object)(new cw(this.D, -this.f, 0.0D, this.s, false)));
            if(!var11) {
               break label75;
            }
         }

         this.A.a((Object)(new cw(this.C, -this.f, 0.0D, this.s, false)));
         this.A.b((Object)(new cw(this.D, -this.f, 0.0D, this.s, false)));
      }

      this.B = new y.c.D();
      if(this.m != null) {
         var1 = this.m.e();
         if(this.m.b(var1) > this.C) {
            this.B.a((Object)(new cw(this.C, this.e, 0.0D, this.s, true)));
         }

         var2 = this.m.e();

         label52: {
            while(var2 != null) {
               var3 = this.m.b(var2);
               var5 = this.m.c(var2);
               var7 = this.m.a(var2);
               double var14;
               var10000 = (var14 = var7 - -1.7976931348623157E308D) == 0.0D?0:(var14 < 0.0D?-1:1);
               if(var11) {
                  break label52;
               }

               var9 = var10000 == 0?this.e:var7;
               this.B.b((Object)(new cw(var3, var9, var5, 0.0D, this.s, true)));
               var2 = this.m.e(var2);
               if(var11) {
                  break;
               }
            }

            var2 = this.m.f();
            double var15;
            var10000 = (var15 = this.m.b(var2) - this.D) == 0.0D?0:(var15 < 0.0D?-1:1);
         }

         if(var10000 >= 0) {
            return;
         }

         this.B.b((Object)(new cw(this.D, this.e, 0.0D, this.s, true)));
         if(!var11) {
            return;
         }
      }

      this.B.a((Object)(new cw(this.C, this.e, 0.0D, this.s, true)));
      this.B.b((Object)(new cw(this.D, this.e, 0.0D, this.s, true)));
   }

   private static y.c.D a(y.c.D var0, boolean var1) {
      boolean var13 = N.x;
      if(var0 != null && !var0.isEmpty()) {
         ArrayList var2 = new ArrayList();
         cw var3 = null;
         y.c.p var4 = var0.k();

         double var7;
         while(true) {
            if(var4 != null) {
               cw var5 = a((cw)var4.c(), var4.a());
               if(var13) {
                  break;
               }

               label107: {
                  if(var3 == null) {
                     double var6 = var5.b == -1.7976931348623157E308D?var5.b:var5.b - (var5.d + var5.e);
                     cu var8 = new cu(var6, (byte)0, var5);
                     var2.add(var8);
                     if(!var13) {
                        break label107;
                     }
                  }

                  boolean var16 = var5.c < var3.c;
                  var7 = var5.b + (var16?var3.d + var3.e:0.0D);
                  cu var9 = new cu(var7, (byte)1, var3);
                  var2.add(var9);
                  double var10 = var5.b - (var16?0.0D:var5.d + var5.e);
                  cu var12 = new cu(var10, (byte)0, var5);
                  var2.add(var12);
               }

               var3 = var5;
               var4 = var4.a();
               if(!var13) {
                  continue;
               }
            }

            Collections.sort(var2);
            break;
         }

         y.c.D var14 = new y.c.D();
         cx var15 = new cx();
         cw var17 = null;
         var7 = cu.a((cu)var2.get(0));
         Iterator var18 = var2.iterator();

         while(var18.hasNext()) {
            cu var20 = (cu)var18.next();
            if(var7 != cu.a(var20)) {
               cw var11 = var15.a(var7);
               if(var11 != null && (var17 == null || var17.c != var11.c || var17.e != var11.e || var17.d != var11.d || var17.a != var11.a)) {
                  var14.add(var11);
                  var17 = var11;
               }

               var7 = cu.a(var20);
            }

            if(var20.a()) {
               var15.a(cu.b(var20));
               if(!var13) {
                  continue;
               }
            }

            var15.b(cu.b(var20));
            if(var13) {
               break;
            }
         }

         cw var19 = var15.a(var7);
         if(var19 != null && (var17 == null || var17.c != var19.c || var17.e != var19.e || var17.d != var19.d || var17.a != var19.a)) {
            var14.add(var19);
         }

         return var14;
      } else {
         return var0;
      }
   }

   private static cw a(cw var0, y.c.p var1) {
      boolean var5 = N.x;
      double var2;
      if(var0.f == 1.0D) {
         if(var1 != null) {
            cw var4 = (cw)var1.c();
            var2 = var0.c + var4.b - var0.b;
            if(!var5) {
               return new cw(var0.b, var2, var0.d, var0.e, var0.a);
            }
         }

         var2 = Double.MAX_VALUE;
         if(!var5) {
            return new cw(var0.b, var2, var0.d, var0.e, var0.a);
         }
      }

      var2 = var0.c;
      return new cw(var0.b, var2, var0.d, var0.e, var0.a);
   }

   private double f(double var1) {
      boolean var16 = N.x;
      y.c.p var3 = a(this.B, true).k();
      y.c.p var4 = a(this.A, false).k();
      double var5 = -1.7976931348623157E308D;

      while(var3 != null && var4 != null) {
         cw var7;
         cw var8;
         double var9;
         label44: {
            var7 = (cw)var3.c();
            var8 = (cw)var4.c();
            double var11;
            cw var13;
            double var14;
            if(var7.b < var8.b) {
               var11 = var7.b + (var8.b - var7.b) * var7.f;
               var13 = (cw)var4.b().c();
               var14 = Math.min(var8.c, var13.c + (var8.b - var13.b) * var13.f);
               var9 = -(var14 + var8.d) - (var11 + var7.d);
               if(!var16) {
                  break label44;
               }
            }

            var11 = var8.b + (var7.b - var8.b) * var8.f;
            var13 = (cw)var3.b().c();
            var14 = Math.max(var7.c, var13.c + (var7.b - var13.b) * var13.f);
            var9 = -(var11 + var8.d) - (var14 + var7.d);
         }

         var5 = Math.max(var5, var1 * (Math.max(var7.e, var8.e) - var9));
         if(var3.a() != null && var4.a() != null) {
            if(((cw)var3.a().c()).b < ((cw)var4.a().c()).b) {
               var3 = var3.a();
               if(!var16) {
                  continue;
               }
            }

            var4 = var4.a();
            if(!var16) {
               continue;
            }
         }

         if(var4.a() != null) {
            var4 = var4.a();
            if(!var16) {
               continue;
            }
         }

         if(var3.a() == null) {
            break;
         }

         var3 = var3.a();
         if(var16) {
            break;
         }
      }

      return var5 == -1.7976931348623157E308D?0.0D:var5;
   }

   private double g(double var1) {
      boolean var11 = N.x;
      y.c.p var3 = a(this.B, true).k();
      y.c.p var4 = a(this.A, false).k();
      double var5 = -1.7976931348623157E308D;

      while(var3 != null && var4 != null) {
         cw var7 = (cw)var3.c();
         cw var8 = (cw)var4.c();
         double var9 = -(var8.c + var8.d) - (var7.c + var7.d);
         var5 = Math.max(var5, Math.max(var1, Math.max(var7.e, var8.e)) - var9);
         if(var3.a() != null && var4.a() != null) {
            if(((cw)var3.a().c()).b < ((cw)var4.a().c()).b) {
               var3 = var3.a();
               if(!var11) {
                  continue;
               }
            }

            var4 = var4.a();
            if(!var11) {
               continue;
            }
         }

         if(var4.a() != null) {
            var4 = var4.a();
            if(!var11) {
               continue;
            }
         }

         if(var3.a() == null) {
            break;
         }

         var3 = var3.a();
         if(var11) {
            break;
         }
      }

      return -var5;
   }

   double e() {
      return this.r;
   }

   public double d(double var1) {
      double var3 = Math.max(this.r, -this.g(var1));
      if(var3 == -1.7976931348623157E308D) {
         var3 = 0.0D;
      }

      return var3;
   }

   public void f() {
      boolean var5 = N.x;
      Iterator var1 = this.z.iterator();

      label28:
      while(true) {
         byte var10000 = var1.hasNext();

         label26:
         while(var10000 != 0) {
            cy[] var2 = (cy[])var1.next();
            int var3 = 0;

            do {
               if(var3 >= var2.length) {
                  continue label28;
               }

               var10000 = var2[var3].m;
               if(var5) {
                  continue label26;
               }

               if(var10000 != 0) {
                  continue label28;
               }

               cy var4 = var2[var3];
               this.a(this.B, var4);
               ++var3;
            } while(!var5);

            return;
         }

         return;
      }
   }

   public void g() {
      boolean var13 = N.x;
      Iterator var1 = this.z.iterator();

      label28:
      while(var1.hasNext()) {
         cy[] var2 = (cy[])var1.next();
         int var10000 = var2.length;
         byte var10001 = 1;

         label26:
         while(true) {
            int var3 = var10000 - var10001;

            do {
               if(var3 < 0) {
                  continue label28;
               }

               var10000 = var2[var3].m;
               var10001 = 3;
               if(var13) {
                  continue label26;
               }

               if(var10000 != 3) {
                  continue label28;
               }

               cy var4 = var2[var3];
               double var5 = var4.k;
               double var7 = var4.l;
               double var9 = var4.f;
               double var11 = var4.g;
               var4.l = -var5;
               var4.k = -var7;
               var4.g = var9;
               var4.f = var11;
               this.a(this.A, var4);
               var4.d = -var4.d;
               var4.k = var5;
               var4.l = var7;
               var4.g = var11;
               var4.f = var9;
               --var3;
            } while(!var13);

            return;
         }
      }

   }

   public void h() {
      boolean var10 = N.x;
      Iterator var1 = this.z.iterator();

      label70:
      while(var1.hasNext()) {
         cy[] var2 = (cy[])var1.next();
         int var3 = this.a(var2);
         boolean var4 = false;
         int var11 = 0;

         int var10000;
         cy var5;
         label67: {
            label66:
            while(true) {
               if(var11 <= var3) {
                  var10000 = var2[var11].m;
                  if(!var10) {
                     if(var10000 == 0) {
                        ++var11;
                        if(!var10) {
                           continue;
                        }
                     }

                     var10000 = var11;
                  }
               } else {
                  var10000 = var11;
               }

               while(true) {
                  if(var10000 > var3) {
                     break label66;
                  }

                  var5 = var2[var11];
                  this.a(this.B, var5);
                  ++var11;
                  if(var10) {
                     break label67;
                  }

                  if(var10) {
                     break label66;
                  }

                  var10000 = var11;
               }
            }

            var11 = var2.length - 1;
         }

         while(true) {
            int var10001;
            if(var11 > var3) {
               var10000 = var2[var11].m;
               var10001 = 3;
               if(!var10) {
                  if(var10000 == 3) {
                     --var11;
                     if(!var10) {
                        continue;
                     }
                  }

                  var10000 = var11;
                  var10001 = var3;
               }
            } else {
               var10000 = var11;
               var10001 = var3;
            }

            while(true) {
               if(var10000 <= var10001) {
                  continue label70;
               }

               var5 = var2[var11];
               double var6 = var5.k;
               double var8 = var5.l;
               var5.l = -var6;
               var5.k = -var8;
               this.a(this.A, var5);
               var5.d = -var5.d;
               var5.k = var6;
               var5.l = var8;
               --var11;
               if(var10 || var10) {
                  return;
               }

               var10000 = var11;
               var10001 = var3;
            }
         }
      }

   }

   private int a(cy[] var1) {
      boolean var6 = N.x;
      int var2 = -1;
      int var3 = var1.length;
      int var4 = 0;

      int var10000;
      while(true) {
         if(var4 < var1.length) {
            cy var5 = var1[var4];
            var10000 = var5.m;
            if(var6) {
               break;
            }

            label31: {
               if(var10000 == 0) {
                  var2 = var4;
                  if(!var6) {
                     break label31;
                  }
               }

               if(var5.m == 3 && var3 == var1.length) {
                  var3 = var4;
               }
            }

            ++var4;
            if(!var6) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      if(var10000 == var1.length) {
         return var3 - 1;
      } else if(var2 < 0) {
         return var3 - 1;
      } else {
         var4 = Math.min(var1.length - 1, var2 + (var3 - var2) / 2);
         return var4;
      }
   }

   void i() {
      boolean var13 = N.x;
      double var1 = this.r;
      double[][] var3 = new double[][]{{3.0D, 10.0D, 15.0D}, {3.0D, 2.0D, 5.0D}, {2.0D, 1.0D, 3.0D}, {0.0D, 1.0D, 1.0D}, {0.0D, 0.0D, 0.0D}};
      double var4 = 1.0D;
      double var6 = 1.0D;
      double var8 = 1.0D;
      this.r = this.a(var4, var6, var8, 0.0D, 0.0D, 0.0D);
      int var10 = 0;

      do {
         double var14;
         int var10000 = (var14 = this.r - 0.0D) == 0.0D?0:(var14 < 0.0D?-1:1);

         label31:
         while(true) {
            if(var10000 <= 0 || var10 >= var3.length) {
               return;
            }

            double var11 = Double.MAX_VALUE;

            while(true) {
               if(this.r <= 0.0D) {
                  break label31;
               }

               double var15;
               var10000 = (var15 = var11 - (this.r + 0.001D)) == 0.0D?0:(var15 < 0.0D?-1:1);
               if(var13) {
                  break;
               }

               if(var10000 <= 0) {
                  break label31;
               }

               var8 /= 2.0D;
               var6 /= 2.0D;
               var4 /= 2.0D;
               var11 = this.r;
               this.r = var1;
               this.r = this.a(var4, var6, var8, var3[var10][0], var3[var10][1], var3[var10][2]);
               if(var13) {
                  break label31;
               }
            }
         }

         ++var10;
      } while(!var13);

   }

   private double a(double var1, double var3, double var5, double var7, double var9, double var11) {
      boolean var26 = N.x;
      this.d();
      Iterator var13 = this.z.iterator();

      label110:
      while(true) {
         int var10000 = var13.hasNext();

         cr var27;
         label107:
         while(var10000 != 0) {
            cy[] var14 = (cy[])var13.next();
            var27 = this;
            if(var26) {
               return Math.max(var27.r, this.f(var1));
            }

            int var15 = this.a(var14);
            int var16 = 0;

            cy var17;
            double var18;
            double var20;
            double var22;
            double var24;
            while(true) {
               if(var16 <= var15) {
                  var17 = var14[var16];
                  var18 = var17.f;
                  var20 = var17.g;
                  double var28;
                  var10000 = (var28 = var1 - 1.0D) == 0.0D?0:(var28 < 0.0D?-1:1);
                  if(var26) {
                     break;
                  }

                  if(var10000 != 0) {
                     if(var18 > var7) {
                        var17.f = Math.max(var7, var18 * var1);
                     }

                     if(var20 > var7) {
                        var17.g = Math.max(var7, var20 * var1);
                     }
                  }

                  var22 = var17.l;
                  var24 = var17.k;
                  if(var5 != 1.0D && var22 < var17.j) {
                     var17.l = Math.max(var17.j + var11, var22 * var5);
                  }

                  if(var1 != 1.0D && var24 > var17.i) {
                     var17.k = Math.max(var17.i + var9, var24 * var3);
                  }

                  this.a(this.B, var17);
                  var17.f = var18;
                  var17.g = var20;
                  var17.l = var22;
                  var17.k = var24;
                  ++var16;
                  if(!var26) {
                     continue;
                  }
               }

               var10000 = var14.length - 1;
               break;
            }

            var16 = var10000;

            while(var16 > var15) {
               var17 = var14[var16];
               var18 = var17.k;
               var20 = var17.l;
               double var29;
               var10000 = (var29 = var3 - 1.0D) == 0.0D?0:(var29 < 0.0D?-1:1);
               if(var26) {
                  continue label107;
               }

               label88: {
                  if(var10000 != 0 && var18 > var17.i) {
                     var17.l = -Math.max(var17.i + var9, var18 * var3);
                     if(!var26) {
                        break label88;
                     }
                  }

                  var17.l = -var18;
               }

               label82: {
                  if(var3 != 1.0D && var20 < var17.j) {
                     var17.k = -Math.max(var17.j + var11, var20 * var5);
                     if(!var26) {
                        break label82;
                     }
                  }

                  var17.k = -var20;
               }

               label76: {
                  var22 = var17.f;
                  var24 = var17.g;
                  if(var1 != 1.0D && var22 > var7) {
                     var17.f = var24 * var1;
                     if(!var26) {
                        break label76;
                     }
                  }

                  var17.f = var24;
               }

               label70: {
                  if(var1 != 1.0D && var24 > var7) {
                     var17.g = var22 * var1;
                     if(!var26) {
                        break label70;
                     }
                  }

                  var17.g = var22;
               }

               this.a(this.A, var17);
               var17.d = -var17.d;
               var17.f = var22;
               var17.g = var24;
               var17.k = var18;
               var17.l = var20;
               --var16;
               if(var26) {
                  break;
               }
            }

            this.b(var14);
            if(!var26) {
               continue label110;
            }
            break;
         }

         var27 = this;
         return Math.max(var27.r, this.f(var1));
      }
   }

   public void j() {
      boolean var15 = N.x;
      this.d();
      Iterator var1 = this.z.iterator();

      while(true) {
         if(var1.hasNext()) {
            cy[] var2 = (cy[])var1.next();
            int var3 = this.a(var2);
            if(var15) {
               break;
            }

            int var4 = 0;

            label51:
            while(true) {
               int var10000 = var4;
               int var10001 = var3;

               while(true) {
                  cy var5;
                  label37: {
                     if(var10000 <= var10001) {
                        var5 = var2[var4];
                        this.a(this.B, var5);
                        ++var4;
                        if(var15) {
                           break label37;
                        }

                        if(!var15) {
                           break;
                        }
                     }

                     var4 = var2.length - 1;
                  }

                  while(true) {
                     if(var4 <= var3) {
                        break label51;
                     }

                     var5 = var2[var4];
                     double var6 = var5.k;
                     double var8 = var5.l;
                     double var10 = var5.f;
                     double var12 = var5.g;
                     var5.f = var12;
                     var5.g = var10;
                     var5.l = -var6;
                     var5.k = -var8;
                     byte var14 = var5.m;
                     var10000 = var14;
                     var10001 = 1;
                     if(var15) {
                        break;
                     }

                     label44: {
                        if(var14 == 1) {
                           var5.m = 2;
                           if(!var15) {
                              break label44;
                           }
                        }

                        if(var14 == 2) {
                           var5.m = 1;
                        }
                     }

                     this.a(this.A, var5);
                     var5.d = -var5.d;
                     var5.f = var10;
                     var5.g = var12;
                     var5.k = var6;
                     var5.l = var8;
                     var5.m = var14;
                     --var4;
                     if(var15) {
                        break label51;
                     }
                  }
               }
            }

            this.b(var2);
            if(!var15) {
               continue;
            }
         }

         this.r = Math.max(this.r, this.d(0.0D));
         break;
      }

   }

   private void b(cy[] var1) {
      boolean var9 = N.x;
      cy var2 = null;
      cy var3 = null;
      boolean var4 = false;
      int var5 = 0;

      boolean var10000;
      cy var6;
      while(true) {
         if(var5 < var1.length) {
            var6 = var1[var5];
            double var7 = var6.d;
            var10000 = Double.isNaN(var7);
            if(var9) {
               break;
            }

            if(!var10000) {
               label103: {
                  if(var7 < Double.MAX_VALUE && var6.d > -1.7976931348623157E308D) {
                     label82: {
                        if(var2 == null) {
                           var2 = var6;
                           if(!var9) {
                              break label82;
                           }
                        }

                        if(var2.d > var6.d) {
                           var2 = var6;
                        }
                     }

                     if(var3 == null) {
                        var3 = var6;
                        if(!var9) {
                           break label103;
                        }
                     }

                     if(var3.d >= var6.d) {
                        break label103;
                     }

                     var3 = var6;
                     if(!var9) {
                        break label103;
                     }
                  }

                  var4 = true;
               }
            }

            ++var5;
            if(!var9) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      if(var10000) {
         if(var3 == null) {
            var3 = new cy((Object)null, 0.0D, 0.0D, 0.0D, (byte)3, -1.7976931348623157E308D, Double.MAX_VALUE, 0.0D, 0.0D, false, 0.0D, 0.0D, 0.0D, (cs)null);
            var3.d = this.m.d();
         }

         var5 = 0;

         int var10;
         label100: {
            while(var5 < var1.length) {
               var6 = var1[var5];
               double var11;
               var10 = (var11 = var6.d - Double.MAX_VALUE) == 0.0D?0:(var11 < 0.0D?-1:1);
               if(var9) {
                  break label100;
               }

               if(var10 == 0) {
                  var6.d = Math.max(var6.k, var3.d + Math.max(var3.g, var6.f) + var3.e + var6.e);
                  var3 = var6;
               }

               ++var5;
               if(var9) {
                  break;
               }
            }

            if(var2 == null) {
               var2 = new cy((Object)null, 0.0D, 0.0D, 0.0D, (byte)3, -1.7976931348623157E308D, Double.MAX_VALUE, 0.0D, 0.0D, false, 0.0D, 0.0D, 0.0D, (cs)null);
               var2.d = this.l.c();
            }

            var10 = var1.length - 1;
         }

         var5 = var10;

         while(var5 >= 0) {
            var6 = var1[var5];
            if(var6.d == -1.7976931348623157E308D) {
               var6.d = Math.min(var6.l, var2.d - Math.max(var2.f, var6.g) - (var2.e + var6.e));
               var2 = var6;
            }

            --var5;
            if(var9) {
               break;
            }
         }
      }

   }

   public double a(double var1, double var3, double var5) {
      return this.a(this.B, var1, var3, var5);
   }

   public double b(double var1, double var3, double var5) {
      return -this.a(this.A, var1, var3, var5);
   }

   private double a(y.c.D var1, double var2, double var4, double var6) {
      boolean var14 = N.x;
      cw var8 = (cw)var1.f();
      y.c.p var9 = var1.k().a();

      double var10000;
      while(true) {
         if(var9 != null) {
            cw var10 = (cw)var9.c();
            var10000 = var10.b;
            if(var14) {
               break;
            }

            if(var10000 > var2) {
               double var11 = var8.c + Math.max(var8.e, var6);

               while(true) {
                  if(var9 != null) {
                     cw var13 = (cw)var9.c();
                     var10000 = var13.b;
                     if(var14) {
                        break;
                     }

                     if(var10000 >= var4) {
                        return var11;
                     }

                     var11 = Math.max(var11, var13.c + Math.max(var10.e, var6));
                     var9 = var9.a();
                     if(!var14) {
                        continue;
                     }
                  }

                  var10000 = var11;
                  break;
               }

               return var10000;
            }

            var8 = var10;
            var9 = var9.a();
            if(!var14) {
               continue;
            }
         }

         var10000 = Double.NaN;
         break;
      }

      return var10000;
   }

   public void e(double var1) {
      boolean var8 = N.x;
      if(var1 != 0.0D) {
         if(this.l != null) {
            this.l.a(var1);
         }

         Iterator var3 = this.z.iterator();

         label47:
         while(true) {
            boolean var10000 = var3.hasNext();

            while(true) {
               if(!var10000) {
                  break label47;
               }

               cy[] var4 = (cy[])var3.next();
               int var5 = this.a(var4);
               int var6 = var5 + 1;

               while(true) {
                  if(var6 >= var4.length) {
                     continue label47;
                  }

                  cy var7 = var4[var6];
                  var10000 = Double.isNaN(var7.d);
                  if(var8) {
                     break;
                  }

                  if(!var10000) {
                     var7.d += var1;
                  }

                  ++var6;
                  if(var8) {
                     break label47;
                  }
               }
            }
         }

         y.c.p var9 = this.A.k();

         while(var9 != null) {
            cw var10 = (cw)var9.c();
            var10.c -= var1;
            var9 = var9.a();
            if(var8) {
               break;
            }
         }

      }
   }

   private void l() {
      boolean var23 = N.x;
      int var1 = this.i.size() - 1;

      do {
         int var10000 = var1;

         double var2;
         double var4;
         double var6;
         double var8;
         boolean var10;
         boolean var11;
         y.c.D var12;
         double var13;
         double var15;
         double var17;
         label71:
         while(true) {
            if(var10000 < 0) {
               return;
            }

            var2 = Double.MAX_VALUE;
            var4 = -1.7976931348623157E308D;
            var6 = -1.7976931348623157E308D;
            var8 = Double.MAX_VALUE;
            var10 = true;
            var11 = true;
            var12 = (y.c.D)this.i.get(var1);
            var13 = 0.0D;
            var15 = 0.0D;
            var17 = 0.0D;
            y.c.p var19 = var12.k();

            while(true) {
               if(var19 == null) {
                  break label71;
               }

               cy var20 = (cy)var19.c();
               var17 = Math.max(var17, var20.e);
               var10000 = var20.n;
               if(var23) {
                  break;
               }

               label48: {
                  if(var10000 != 0) {
                     double var21 = var20.o / a;
                     if(var20.k > -1.7976931348623157E308D) {
                        var6 = Math.max(var6, var20.k + var21);
                     }

                     if(var20.l < Double.MAX_VALUE) {
                        var8 = Math.min(var8, var20.l - var21);
                     }

                     var15 = Math.max(var15, var20.g + var21);
                     var13 = Math.max(var13, var20.f + var21);
                     if(!var23) {
                        break label48;
                     }
                  }

                  var6 = Math.max(var6, var20.k);
                  var8 = Math.min(var8, var20.l);
                  var15 = Math.max(var15, var20.g);
                  var13 = Math.max(var13, var20.f);
               }

               byte var24;
               if(var20.b < var2) {
                  var2 = var20.b;
                  var24 = var20.a();
                  var10 = var24 == 2 || var24 == 0;
               }

               if(var20.c > var4) {
                  var4 = var20.c;
                  var24 = var20.a();
                  var11 = var24 == 1 || var24 == 0;
               }

               this.k.add(var20.a);
               var19 = var19.a();
               if(var23) {
                  break label71;
               }
            }
         }

         cy var25 = cy.a(var12, var17 * 2.0D, var2, var10, var4, var11, var13, var15);
         var25.k = var6;
         var25.l = var8;
         this.b.put(var12, var25);
         this.c.add(var25);
         --var1;
      } while(!var23);

   }

   public double d(Object var1) {
      double var2 = this.f(var1).d;
      return Double.isNaN(var2)?this.n:var2;
   }

   public double e(Object var1) {
      return this.d(this.h.get(var1));
   }

   private void a(y.c.D var1, cy var2) {
      if(this.o) {
         double var3 = var2.m != 3 && var2.m != 0?0.0D:var2.e * 2.0D;
         if(Math.abs(var2.c - var2.b) + var3 < this.q) {
            var2.d = Double.NaN;
            return;
         }
      }

      if(var2.n) {
         this.c(var1, var2);
         if(!N.x) {
            return;
         }
      }

      this.b(var1, var2);
   }

   private void b(y.c.D var1, cy var2) {
      boolean var17 = N.x;
      byte var3 = var2.a();
      cw var4 = new cw(var2.b, 0.0D, var2.e, var2.g, var3 == 0 || var3 == 2);
      cw var5 = new cw(var2.c, 0.0D, var2.e, var2.g, var3 == 1 || var3 == 0);
      y.c.p var6 = var1.k();
      cw var7 = (cw)var6.c();
      cw var8 = var7;
      double var9 = Math.max(var2.f, var7.e);
      double var11 = var7.c + var7.d + var9;
      var11 = Math.max(var11, var2.k - var2.e);

      double var10000;
      double var10001;
      while(true) {
         if(var2.b - var2.e - var9 > var7.b + var7.d) {
            var8 = var7;
            var6 = var6.a();
            var7 = (cw)var6.c();
            var9 = Math.max(var2.f, var7.e);
            if(var17) {
               break;
            }

            if(!var17) {
               continue;
            }
         }

         while(true) {
            if(var6 != null) {
               var10000 = var2.b;
               var10001 = var7.b;
               if(var17) {
                  break;
               }

               if(var10000 > var10001) {
                  if(var4.a != var7.a) {
                     if(var6.b() != null) {
                        cw var13 = (cw)var6.b().c();
                        var11 = Math.max(var11, var13.c + var13.d + Math.max(var2.f, var13.e));
                     }

                     var11 = Math.max(var11, var7.c + var7.d + Math.max(var7.e, var2.f));
                  }

                  var8 = var7;
                  var6 = var6.a();
                  var7 = (cw)var6.c();
                  if(!var17) {
                     continue;
                  }
               }
            }

            var10000 = var11;
            var10001 = var8.c + var8.d + Math.max(var8.e, var2.f);
            break;
         }

         var11 = Math.max(var10000, var10001);
         break;
      }

      y.c.p var18 = var1.a((Object)var4, (y.c.p)var6);

      label144: {
         y.c.p var19;
         while(true) {
            if(var2.c >= var7.b) {
               var8 = var7;
               double var14 = var7.c;
               var11 = Math.max(var14 + var7.d + Math.max(var7.e, var2.f), var11);
               var1.h(var6);
               var6 = var6.a();
               var19 = var6;
               if(var17) {
                  break;
               }

               if(var6 != null) {
                  var7 = (cw)var6.c();
                  if(!var17) {
                     continue;
                  }
               }
            }

            var9 = Math.max(var2.f, var7.e);
            var19 = var6;
            break;
         }

         while(var19 != null) {
            var10000 = var2.c + var2.e + var9;
            var10001 = var7.b - var7.d;
            if(var17) {
               break label144;
            }

            if(var10000 <= var10001) {
               break;
            }

            if(var5.a != var7.a) {
               var11 = Math.max(var7.c + var7.d + var9, var11);
            }

            var6 = var6.a();
            if(var6 == null) {
               break;
            }

            var7 = (cw)var6.c();
            var9 = Math.max(var2.f, var7.e);
            if(var17) {
               break;
            }

            var19 = var6;
         }

         cw var16;
         if(var18.b() != null) {
            var16 = (cw)var18.b().c();
            if(var16.b + this.p > var2.b && var16.a != var4.a && var18.b().b() != null) {
               var16 = (cw)var18.b().b().c();
               var11 = Math.max(var11, var16.c + var16.d + Math.max(var16.e, var2.f));
            }
         }

         if(var18.a() != null) {
            var16 = (cw)var18.a().c();
            if(var16.b - this.p < var2.c && var16.a != var5.a) {
               var11 = Math.max(var11, var16.c + var16.d + Math.max(var16.e, var2.f));
            }
         }

         var10000 = var11;
         var10001 = var2.e;
      }

      var11 = var10000 + var10001;
      var18.a(new cw(var2.b, var11, var2.e, var2.g, var2.m == 2 || var2.m == 0));
      var1.b((Object)(new cw(var2.c, var8.c, var8.d, var8.e, var2.m == 0 || var2.m == 1)), var18);
      var2.d = var11;
      this.r = Math.max(this.r, var11 - var2.l);
      this.d = Math.max(this.d, var11);
   }

   private void c(y.c.D var1, cy var2) {
      double var3;
      label19: {
         boolean var6 = N.x;
         byte var5 = var2.a();
         if(var5 == 1) {
            var3 = this.e(var1, var2);
            if(!var6) {
               break label19;
            }
         }

         if(var5 == 2) {
            var3 = this.f(var1, var2);
            if(!var6) {
               break label19;
            }
         }

         var3 = this.d(var1, var2);
      }

      this.r = Math.max(this.r, var3 - var2.l);
      this.d = Math.max(this.d, this.d);
   }

   private static double a(cw var0, double var1, cy var3) {
      return Math.max(var3.k, var0.c + var0.d + Math.max(var0.e, var3.f) + var3.e + (var1 - var0.b) * var0.f);
   }

   private static double a(cw var0, cy var1) {
      return Math.max(var1.k, var0.c + var0.d + Math.max(var0.e, var1.f) + var1.e);
   }

   private double d(y.c.D var1, cy var2) {
      boolean var42 = N.x;
      y.c.p var3 = var1.k();
      cw var4 = (cw)var3.c();
      cw var5 = var4;

      while(var2.b - var2.e - Math.max(var2.f, var4.e) > var4.b + var4.d) {
         var5 = var4;
         var3 = var3.a();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var42) {
               break;
            }
         }
      }

      double var6 = var2.k;

      while(var3 != null && var2.b > var4.b) {
         if(!var4.a) {
            if(var5 != null) {
               var6 = Math.max(var6, a(var5, var2));
            }

            var6 = Math.max(var6, a(var4, var2));
         }

         var5 = var4;
         var3 = var3.a();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var42) {
               break;
            }
         }
      }

      double var8 = var2.o / a;
      double var10 = var2.c - var2.b;
      if(var10 <= var8 * 3.0D) {
         var8 = var10 * 0.35D;
      }

      double var12 = var2.b;
      double var14 = var2.c;
      double var16 = var12 + var8;
      double var18 = var14 - var8;
      double var24 = (var16 - var12) * 1.0D;
      double var26 = Math.max(var6, a(var5, var12, var2));

      double var32;
      double var34;
      double var36;
      double var28;
      double var30;
      while(true) {
         if(var3 != null && var4.b < var16) {
            var28 = var4.b;
            var30 = a(var5, var28, var2);
            var32 = a(var4, var2);
            var34 = Math.max(var30, var32);
            var36 = var26 + (var4.b - var12) * 1.0D;
            if(var34 > var36) {
               var26 = var34 - (var28 - var12) * 1.0D;
            }

            var5 = var4;
            var3 = var3.a();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var42) {
               break;
            }

            if(!var42) {
               continue;
            }
         }

         var28 = var26 + var24;
         var30 = a(var5, var16, var2);
         break;
      }

      if(var30 > var28) {
         var26 = var30 - var24;
      }

      var28 = var26 + var24;

      while(true) {
         if(var3 != null && var4.b < var18) {
            var30 = var4.b;
            var32 = a(var5, var30, var2);
            var34 = a(var4, var2);
            var36 = Math.max(var32, var34);
            if(var36 > var28) {
               var28 = var36;
               var26 = var36 - var24;
            }

            var5 = var4;
            var3 = var3.a();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var42) {
               break;
            }

            if(!var42) {
               continue;
            }
         }

         var30 = a(var5, var18, var2);
         break;
      }

      if(var30 > var28) {
         var28 = var30;
         var26 = var30 - var24;
      }

      var30 = var28;

      while(true) {
         if(var3 != null && var4.b < var14) {
            var32 = var4.b;
            var34 = a(var5, var32, var2);
            var36 = a(var4, var2);
            double var38 = Math.max(var34, var36);
            double var40 = var30 + (var32 - var18) * -1.0D;
            if(var38 > var40) {
               var30 = var38 - (var32 - var18) * -1.0D;
               var28 = var30;
               var26 = var30 - var24;
            }

            var5 = var4;
            var3 = var3.a();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var42) {
               break;
            }

            if(!var42) {
               continue;
            }
         }

         var32 = var30 + (var14 - var18) * -1.0D;
         var34 = a(var5, var14, var2);
         break;
      }

      if(var34 > var32) {
         var30 = var34 - (var14 - var18) * -1.0D;
         var28 = var30;
         var26 = var30 - var24;
      }

      while(var3 != null && var2.c + var2.e + Math.max(var2.f, var4.e) > var4.b - var4.d) {
         var32 = var4.b;
         if(!var4.a) {
            var34 = a(var4, var2);
            var36 = var30 + (var32 - var18) * -1.0D;
            if(var34 > var36) {
               var30 = var34 - (var32 - var18) * -1.0D;
               var28 = var30;
               var26 = var30 - var24;
            }
         }

         var3 = var3.a();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var42) {
               break;
            }
         }
      }

      y.c.D var43 = new y.c.D();
      var43.add(new cw(var12, var26, 1.0D, var2.e, var2.g, true));
      var43.add(new cw(var16, var28, 0.0D, var2.e, var2.g, true));
      var43.add(new cw(var18, var30, -1.0D, var2.e, var2.g, true));
      var43.add(new cw(var14, -1.7976931348623157E308D, 0.0D, 0.0D, 0.0D, true));
      a(var1, var43);
      this.a(var1);
      var2.p = var16;
      var2.q = var18;
      var2.d = var28;
      return var28 + var2.e;
   }

   private double e(y.c.D var1, cy var2) {
      boolean var37 = N.x;
      y.c.p var3 = var1.k();
      cw var4 = (cw)var3.c();
      cw var5 = var4;

      while(var2.b - var2.e - Math.max(var2.f, var4.e) > var4.b + var4.d) {
         var5 = var4;
         var3 = var3.a();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var37) {
               break;
            }
         }
      }

      double var6 = var2.k;

      while(var3 != null && var2.b > var4.b) {
         if(var4.a) {
            if(var5.a && var5 != var4) {
               var6 = Math.max(var6, a(var5, var2));
            }

            var6 = Math.max(var6, a(var4, var2));
         }

         var5 = var4;
         var3 = var3.a();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var37) {
               break;
            }
         }
      }

      double var8 = var2.o / a;
      double var10 = var2.b;
      double var12 = Math.max(var6, a(var5, var10, var2));
      double var14 = var10 + var8;
      boolean var16 = false;
      double var17 = var10;
      double var19 = var12;
      double var21 = var2.k;

      double var23;
      double var25;
      double var27;
      double var29;
      double var31;
      while(true) {
         if(var3 != null && var2.c >= var4.b) {
            var23 = var4.b;
            var25 = a(var5, var23, var2);
            var27 = a(var4, var2);
            var29 = Math.max(var25, var27);
            if(!var16 && var4.b >= var14) {
               var31 = a(var5, var14, var2);
               var12 = Math.max(var12, var31 + var8);
               var16 = true;
            }

            var31 = var19 - (var23 - var17);
            if(var29 > var31) {
               label156: {
                  var19 = var29 + (var23 - var17);
                  if(!var16) {
                     var12 = var19;
                     if(!var37) {
                        break label156;
                     }
                  }

                  var21 = Math.max(var21, var29);
               }
            }

            var5 = var4;
            var3 = var3.a();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var37) {
               break;
            }

            if(!var37) {
               continue;
            }
         }

         var23 = a(var5, var2.c, var2);
         break;
      }

      while(true) {
         if(var3 != null && var2.c + var2.e + Math.max(var2.f, var4.e) > var4.b - var4.d + 0.001D) {
            var25 = var4.b;
            if(!var16 && var25 >= var14) {
               var27 = a(var5, var14, var2);
               var12 = Math.max(var12, var27 + var8);
               var16 = true;
            }

            if(!var4.a) {
               var27 = a(var4, var2);
               var29 = var19 - (var25 - var17);
               if(var27 > var29) {
                  label158: {
                     var19 = var27 + (var25 - var17);
                     if(!var16) {
                        var12 = var19;
                        if(!var37) {
                           break label158;
                        }
                     }

                     var21 = Math.max(var21, var27);
                  }
               }
            }

            var5 = var4;
            var3 = var3.a();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var37) {
               break;
            }

            if(!var37) {
               continue;
            }
         }

         var25 = var2.c - var2.b;
         break;
      }

      y.c.D var38;
      label155: {
         var27 = Math.max(var19 - var25, var23);
         var38 = new y.c.D();
         boolean var30 = var25 <= var8 * 3.0D;
         if(var30) {
            var38.add(new cw(var2.b, var27 + var25, -1.0D, var2.e, var2.g, false));
            var2.d = var27 + var25 * 0.5D;
            var2.p = var2.b + var25 * 0.5D;
            var2.q = var2.p;
            if(!var37) {
               break label155;
            }
         }

         if(!var16) {
            var31 = a(var5, var14, var2);
            var21 = Math.max(var27 + var8, var31);
         }

         double var33;
         label77: {
            var19 = Math.max(var27 + var8, var21);
            var17 = var2.c - (var19 - var27);
            double var35 = var12 - var19;
            if(var35 >= var8) {
               var33 = var10 + var35;
               if(!var37) {
                  break label77;
               }
            }

            var33 = var10 + var8;
            var12 = var19 + var8;
         }

         if(var17 - var33 < var8) {
            var38.add(new cw(var2.b, var27 + var25, -1.0D, var2.e, var2.g, false));
            var2.d = var27 + var25 * 0.5D;
            var2.p = var2.b + var25 * 0.5D;
            var2.q = var2.p;
            if(!var37) {
               break label155;
            }
         }

         var38.add(new cw(var10, var12, -1.0D, var2.e, var2.g, false));
         var38.add(new cw(var33, var19, 0.0D, var2.e, var2.g, true));
         var38.add(new cw(var17, var19, -1.0D, var2.e, var2.g, true));
         var2.d = var19;
         var2.p = var33;
         var2.q = var17;
      }

      var38.add(new cw(var2.c, -1.7976931348623157E308D, 0.0D, 0.0D, 0.0D, true));
      a(var1, var38);
      this.a(var1);
      return var2.d + var2.p - var2.b + var2.e;
   }

   private double f(y.c.D var1, cy var2) {
      boolean var43 = N.x;
      y.c.p var3 = var1.l();
      cw var4 = (cw)var3.c();
      cw var5 = var4;

      while(var2.c + var2.e + Math.max(var2.f, var4.e) < var4.b + var4.d) {
         var5 = var4;
         var3 = var3.b();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var43) {
               break;
            }
         }
      }

      double var6 = var2.k;

      while(var3 != null && var2.c < var4.b) {
         if(var4.a) {
            if(var5.a && var5 != var4) {
               var6 = Math.max(var6, a(var5, var2));
            }

            var6 = Math.max(var6, a(var4, var2));
         }

         var5 = var4;
         var3 = var3.b();
         if(var3 != null) {
            var4 = (cw)var3.c();
            if(var43) {
               break;
            }
         }
      }

      double var8 = var2.o / a;
      double var10 = var2.c;
      double var12 = Math.max(var6, a(var4, var10, var2));
      double var14 = var10 - var8;
      boolean var16 = false;
      double var17 = var2.b;
      double var19 = var10;
      double var21 = var12;
      double var23 = var2.k;

      double var25;
      double var27;
      double var29;
      double var31;
      double var33;
      double var35;
      while(true) {
         if(var3 != null && var2.b <= var5.b) {
            var25 = var5.b;
            var27 = a(var5, var2);
            var29 = a(var4, var25, var2);
            var31 = Math.max(var27, var29);
            var33 = var21 - (var19 - var25);
            if(var31 > var33) {
               label156: {
                  var21 = var31 + (var19 - var25);
                  if(!var16) {
                     var12 = var21;
                     if(!var43) {
                        break label156;
                     }
                  }

                  var23 = Math.max(var23, var31);
               }
            }

            if(!var16 && var4.b < var14) {
               var35 = a(var4, var14, var2);
               var12 = Math.max(var12, var35 + var8);
               var16 = true;
            }

            var5 = var4;
            var3 = var3.b();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var43) {
               break;
            }

            if(!var43) {
               continue;
            }
         }

         var25 = a(var5, var2.b, var2);
         break;
      }

      while(true) {
         if(var3 != null && var2.c - var2.e - Math.max(var2.f, var4.e) < var5.b + var5.d - 0.001D) {
            var27 = var5.b;
            if(!var4.a) {
               var29 = a(var5, var2);
               var31 = var21 - (var19 - var27);
               if(var29 > var31) {
                  label158: {
                     var21 = var29 + (var19 - var27);
                     if(!var16) {
                        var12 = var21;
                        if(!var43) {
                           break label158;
                        }
                     }

                     var23 = Math.max(var23, var29);
                  }
               }
            }

            if(!var16 && var4.b < var14) {
               var29 = a(var4, var14, var2);
               var12 = Math.max(var12, var29 + var8);
               var16 = true;
            }

            var5 = var4;
            var3 = var3.b();
            if(var3 == null) {
               continue;
            }

            var4 = (cw)var3.c();
            if(var43) {
               break;
            }

            if(!var43) {
               continue;
            }
         }

         var27 = var2.c - var2.b;
         break;
      }

      y.c.D var44;
      label155: {
         var29 = Math.max(var21 - var27, var25);
         var44 = new y.c.D();
         boolean var32 = var27 <= var8 * 3.0D;
         if(var32) {
            var44.add(new cw(var17, var29, 1.0D, var2.e, var2.g, true));
            var2.d = var29 + var27 * 0.5D;
            var2.p = var17 + var27 * 0.5D;
            var2.q = var2.p;
            if(!var43) {
               break label155;
            }
         }

         if(!var16) {
            var33 = a(var5, var14, var2);
            var23 = Math.max(var12 + var8, var33);
         }

         double var39;
         label77: {
            var33 = Math.max(var29 + var8, var23);
            var35 = var17 + (var33 - var29);
            double var41 = var12 - var33;
            if(var41 >= var8) {
               var39 = var10 - var41;
               if(!var43) {
                  break label77;
               }
            }

            var39 = var10 - var8;
            var12 = var33 + var8;
         }

         if(var39 - var35 < var8) {
            var44.add(new cw(var17, var29, 1.0D, var2.e, var2.g, true));
            var2.d = var29 + var27 * 0.5D;
            var2.p = var17 + var27 * 0.5D;
            var2.q = var2.p;
            if(!var43) {
               break label155;
            }
         }

         var44.add(new cw(var17, var29, 1.0D, var2.e, var2.g, true));
         var44.add(new cw(var35, var33, 0.0D, var2.e, var2.g, true));
         var44.add(new cw(var39, var33, 1.0D, var2.e, var2.g, true));
         var2.d = var33;
         var2.p = var35;
         var2.q = var39;
      }

      var44.add(new cw(var2.c, -1.7976931348623157E308D, 0.0D, 0.0D, 0.0D, false));
      a(var1, var44);
      this.a(var1);
      return var2.d + var2.c - var2.q + var2.e;
   }

   private static void a(y.c.D var0, y.c.D var1) {
      boolean var10 = N.x;
      if(var0.isEmpty()) {
         var0.a(var1);
         if(!var10) {
            return;
         }
      }

      if(!var1.isEmpty()) {
         y.c.p var2 = var0.k();
         y.c.p var3 = var1.k();
         cw var4 = null;

         y.c.p var10000;
         label74: {
            while(var2 != null) {
               var10000 = var2;
               if(var10) {
                  break label74;
               }

               if(a(var2) >= a(var3)) {
                  break;
               }

               var4 = (cw)var2.c();
               var2 = var2.a();
               if(var10) {
                  break;
               }
            }

            var10000 = var2;
         }

         if(var10000 == null) {
            var0.a(var1);
            return;
         }

         y.c.p var5 = var1.l();

         while(var3 != null) {
            y.c.p var6 = var3.a();
            var0.a(var3, var2);
            var3 = var6;
            if(var10) {
               return;
            }

            if(var10) {
               break;
            }
         }

         cw var11 = (cw)var5.c();

         int var12;
         while(true) {
            if(var2 != null) {
               double var13;
               var12 = (var13 = a(var2) - var11.b) == 0.0D?0:(var13 < 0.0D?-1:1);
               if(var10) {
                  break;
               }

               if(var12 < 0) {
                  var4 = (cw)var0.h(var2);
                  var2 = var2.a();
                  if(!var10) {
                     continue;
                  }
               }
            }

            if(var4 == null || var2 == null) {
               return;
            }

            double var14;
            var12 = (var14 = a(var2) - var11.b) == 0.0D?0:(var14 < 0.0D?-1:1);
            break;
         }

         if(var12 == 0) {
            var0.h(var5);
            if(!var10) {
               return;
            }
         }

         double var7 = var4.c + (var11.b - var4.b) * var4.f;
         cw var9 = new cw(var11.b, var7, var4.f, var4.d, var4.e, var11.a);
         var5.a(var9);
      }

   }

   private static double a(y.c.p var0) {
      return ((cw)var0.c()).b;
   }

   private void a(y.c.D var1) {
      boolean var6 = N.x;
      double var2 = -1.7976931348623157E308D;
      y.c.p var4 = var1.k();

      while(true) {
         if(var4 != null) {
            if(var4.c() == null) {
               throw new IllegalStateException("Cell.getInfo = null: " + var4);
            }

            cw var5 = (cw)var4.c();
            if(var5.b < var2) {
               throw new IllegalStateException("Wrong sorting of frontier!");
            }

            var2 = var5.b;
            var4 = var4.a();
            if(!var6) {
               continue;
            }
         }

         return;
      }
   }

   private cy f(Object var1) {
      cy var2 = (cy)this.b.get(var1);
      if(var2 == null) {
         Object var3 = this.j.get(var1);
         if(var3 != null) {
            return (cy)this.b.get(var3);
         } else {
            throw new IllegalArgumentException("No such key registered!");
         }
      } else {
         return var2;
      }
   }

   public void a(boolean var1) {
      this.o = var1;
   }
}
