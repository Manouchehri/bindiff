package y.f.c.a;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.F;
import y.f.c.a.G;
import y.f.c.a.H;
import y.f.c.a.I;
import y.f.c.a.J;
import y.f.c.a.L;
import y.f.c.a.M;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.ar;
import y.f.c.a.as;
import y.f.c.a.bK;
import y.f.c.a.cd;
import y.f.c.a.cp;
import y.f.c.a.cr;
import y.f.c.a.cy;
import y.f.c.a.da;
import y.f.c.a.dd;
import y.f.c.a.dg;

public class E {
   final y.c.f a = new y.c.f();
   y.f.X b;
   aV c;
   y.c.c d;
   y.f.b.b e;
   y.c.c f;
   private y.c.D h = new y.c.D();
   private y.g.I i;
   private dd j;
   private double k = 0.0D;
   private final y.c.h l;
   private final y.c.h m;
   private final Map n;
   private Random o = new Random(0L);
   y.c.c g;

   E(y.f.X var1, aV var2, y.c.c var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.j = new dd(this, var1, var2);
      this.n = new HashMap();
      this.l = y.g.M.b();
      this.m = y.g.M.b();
      this.f = var1.c(y.f.b.f.d);
      if(this.f != null) {
         F var4 = new F(this);
         var1.a((Object)y.f.b.f.d, (y.c.c)var4);
      }

   }

   boolean a() {
      return this.d != null;
   }

   public void b() {
      boolean var3 = N.x;
      if(!this.k()) {
         this.e = new y.f.b.b();
         this.e.b(this.b);
         if(!var3) {
            return;
         }
      }

      this.i = new y.g.I(this.b);
      int var1 = 0;

      while(var1 < this.j.d.size()) {
         dg var2 = (dg)this.j.d.get(var1);
         if(var2.f != null && var2.f.e() != null) {
            this.i.a(var2.f);
         }

         ++var1;
         if(var3) {
            break;
         }
      }

   }

   public void c() {
      if(!this.k()) {
         this.e.d(this.b);
         if(!N.x) {
            return;
         }
      }

      if(this.i != null) {
         this.i.f();
         this.i = null;
      }

   }

   void a(aU var1) {
      this.a((aU)var1, (y.c.A)null);
   }

   void a(aU var1, y.c.A var2) {
      if(this.k()) {
         this.j.a(var1, var2);
      }
   }

   void b(aU var1) {
      if(this.k()) {
         this.j.a(this.c);
      }
   }

   void c(aU var1) {
      if(this.k()) {
         this.j.a(var1, this.c, this.j);
      }
   }

   void d(aU var1) {
      if(this.k()) {
         this.j.d(var1, this.c);
      }
   }

   void e(aU var1) {
      boolean var10 = N.x;
      if(this.k()) {
         int var2 = 0;

         label81:
         do {
            int var10000 = var2;
            int var10001 = var1.b();

            label78:
            while(true) {
               if(var10000 >= var10001) {
                  break label81;
               }

               aQ var3 = var1.a(var2);
               if(var3.e() == 2 || var3.e() == 3) {
                  break;
               }

               y.c.p var4 = var3.d().k();

               while(true) {
                  if(var4 == null) {
                     break label78;
                  }

                  y.c.q var5 = (y.c.q)var4.c();
                  aX var6 = this.c.a(var5);
                  var10000 = var6.b();
                  var10001 = 12;
                  if(var10) {
                     break;
                  }

                  if(var10000 == 12 || var6.b() == 13) {
                     double var7 = this.b.m(var5);
                     if(var6.b() == 13) {
                        var7 += this.b.p(var5);
                     }

                     dg var9;
                     label69: {
                        var9 = this.f(var6.l());
                        if(var9.w == null) {
                           var9.w = new Double(var7, this.b.n(var5), 0.0D, 0.0D);
                           if(!var10) {
                              break label69;
                           }
                        }

                        var9.w.add(var7, this.b.n(var5));
                     }

                     if(var6.b() == 12 && var9.A == var3) {
                        var9.w.add(var7, this.b.n(var5) - var9.x);
                     }

                     if(var6.b() == 12 && var9.B == var3) {
                        var9.w.add(var7, this.b.n(var5) + var9.y);
                     }
                  }

                  var4 = var4.a();
                  if(var10) {
                     break label78;
                  }
               }
            }

            ++var2;
         } while(!var10);

         Iterator var11 = this.j.d.iterator();

         while(var11.hasNext()) {
            dg var12 = (dg)var11.next();
            if(var12 != this.j) {
               this.b.b(var12.f, var12.w.getWidth(), var12.w.getHeight());
               this.b.c(var12.f, var12.w.getX(), var12.w.getY());
               if(var10) {
                  break;
               }
            }
         }

      }
   }

   void f(aU var1) {
      boolean var6 = N.x;
      if(this.k() && this.a()) {
         y.c.y var2 = new y.c.y();
         this.a((dg)this.j, (J)(new G(this, var2)));
         HashSet var3 = new HashSet();
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            y.c.q var5 = (y.c.q)var4.next();
            if(!var3.contains(var5)) {
               var3.add(var5);
               if(this.d(var5)) {
                  this.a(var5, var1);
                  if(var6) {
                     break;
                  }
               }
            }
         }

         int var7 = var1.b();

         while(var7-- > 0) {
            aQ var8 = var1.a(var7);
            if(var8.d().isEmpty()) {
               var1.b(var7);
               if(var6) {
                  break;
               }
            }
         }

      }
   }

   private void a(y.c.q var1, aU var2) {
      boolean var30 = N.x;
      dg var3 = this.f(var1);
      if(var3 != null) {
         y.c.q var4 = this.i(var1);
         bK var5 = this.a(var1);
         int var6 = var5 != null?var5.j():0;
         var5 = this.b(var1);
         int var7 = var5 != null?var5.j():0;
         int var8 = var3.h.c();
         int var9 = var3.g.c();
         y.c.D[] var10 = new y.c.D[var8 - var9 + 1];
         int var11 = Integer.MAX_VALUE;
         int var12 = Integer.MIN_VALUE;
         y.c.y var13 = new y.c.y();
         HashSet var14 = new HashSet();
         y.c.y var15 = new y.c.y();
         HashSet var16 = new HashSet();
         int var17 = var9;
         int var18 = var8 + 1;

         y.c.x var31;
         label423:
         while(true) {
            int var10000 = var17;

            int var22;
            y.c.q var24;
            label420:
            while(var10000 < var18) {
               var10[var17 - var9] = new y.c.D();
               aQ var19 = var2.a(var17);
               var31 = var19.d().a();
               if(var30) {
                  break label423;
               }

               y.c.x var20 = var31;

               while(var20.f()) {
                  y.c.q var21 = var20.e();
                  var5 = this.c.a(var21).h();
                  var10000 = this.a(var21, var1);
                  if(var30) {
                     continue label420;
                  }

                  label414: {
                     if(var10000 != 0) {
                        var10[var17 - var9].add(var21);
                        if(!var30) {
                           break label414;
                        }
                     }

                     if(var5 != null) {
                        boolean var23;
                        label430: {
                           var22 = var5.j();
                           var23 = false;
                           if(var6 < var22 && var7 > var22) {
                              var23 = true;
                              if(!var30) {
                                 break label430;
                              }
                           }

                           if(var6 != var7) {
                              var24 = this.i(var21);
                              if(var24 != null) {
                                 bK var25;
                                 if(var6 == var22) {
                                    var25 = this.b(var24);
                                    var23 |= var25 != null && var25.j() > var6;
                                 }

                                 if(var7 == var22) {
                                    var25 = this.a(var24);
                                    var23 |= var25 != null && var25.j() < var7;
                                 }
                              }
                           }
                        }

                        if(var23 && !var14.contains(var21)) {
                           var13.add(var21);
                           var14.add(var21);
                           var24 = this.i(var21);
                           if(var24 != null && var24 != var4 && !var16.contains(var24)) {
                              var15.add(var24);
                              var16.add(var24);
                              dg var45 = this.f(var24);
                              if(var45 != null) {
                                 if(var11 > var45.g.c()) {
                                    var11 = var45.g.c();
                                 }

                                 if(var12 < var45.h.c()) {
                                    var12 = var45.h.c();
                                 }
                              }
                           }
                        }
                     }
                  }

                  var20.g();
                  if(var30) {
                     break;
                  }
               }

               ++var17;
               if(!var30) {
                  continue label423;
               }
               break;
            }

            if(!var13.isEmpty()) {
               label454: {
                  boolean var33 = false;
                  boolean var35 = false;
                  int var36 = Integer.MIN_VALUE;
                  int var39 = Integer.MAX_VALUE;
                  HashSet var40 = new HashSet();
                  var22 = 0;

                  int var46;
                  while(true) {
                     if(var22 < var10.length) {
                        var40.addAll(var10[var22]);
                        ++var22;
                        if(var30) {
                           break;
                        }

                        if(!var30) {
                           continue;
                        }
                     }

                     Iterator var41 = var13.iterator();

                     label361:
                     while(true) {
                        while(true) {
                           y.c.q var43;
                           do {
                              if(!var41.hasNext()) {
                                 break label361;
                              }

                              var43 = (y.c.q)var41.next();
                              var24 = this.i(var43);
                           } while(var24 != null && var24 != var4);

                           var46 = this.c.a(var43).j();
                           if(!this.a((Set)var40, (y.c.q)var43)) {
                              break;
                           }

                           var33 = true;
                           if(var36 < var46) {
                              var36 = var46;
                              if(var30) {
                                 break;
                              }
                           }
                        }

                        var35 = true;
                        if(var39 > var46) {
                           var39 = var46;
                           if(var30) {
                              break label454;
                           }

                           if(var30) {
                              break;
                           }
                        }
                     }

                     var22 = var12 - var11 + 1;
                     break;
                  }

                  y.c.D[] var44 = new y.c.D[var22];
                  y.c.D[] var42 = new y.c.D[var22];
                  var46 = 0;

                  int var47;
                  while(true) {
                     if(var46 < var22) {
                        var44[var46] = new y.c.D();
                        var42[var46] = new y.c.D();
                        ++var46;
                        if(var30) {
                           break;
                        }

                        if(!var30) {
                           continue;
                        }
                     }

                     Iterator var48 = var15.iterator();

                     boolean var32;
                     label329: {
                        while(var48.hasNext()) {
                           y.c.q var26 = (y.c.q)var48.next();
                           var32 = this.a((y.c.q)var26, (Set)var16);
                           if(var30) {
                              break label329;
                           }

                           if(!var32) {
                              if(this.a(this.g(var26), var9, var8)) {
                                 this.a(var26, var2, var44, var11);
                                 if(!var30) {
                                    continue;
                                 }
                              }

                              this.a(var26, var2, var42, var11);
                              if(var30) {
                                 break;
                              }
                           }
                        }

                        var32 = var33;
                     }

                     if(var32 && var35) {
                        var47 = var36 + var39;
                        var46 = var47 % 2 == 0?var47 / 2:var47 / 2 + 1;
                        break;
                     }

                     if(var33) {
                        var46 = var36 + 1;
                     } else if(var35) {
                        var46 = var39;
                     } else {
                        var46 = var9;
                     }
                     break;
                  }

                  int var27;
                  aQ var28;
                  y.c.C var29;
                  label462: {
                     if(var33 || var35) {
                        var27 = 0;

                        byte var34;
                        label303: {
                           while(var27 < var10.length) {
                              var34 = var10[var27].isEmpty();
                              if(var30) {
                                 break label303;
                              }

                              label299: {
                                 if(var34 == 0) {
                                    var28 = var2.a(var9 + var27);
                                    var29 = var10[var27].m();

                                    while(var29.f()) {
                                       var28.b((y.c.q)var29.d());
                                       var29.g();
                                       if(var30) {
                                          break label299;
                                       }

                                       if(var30) {
                                          break;
                                       }
                                    }
                                 }

                                 ++var27;
                              }

                              if(var30) {
                                 break;
                              }
                           }

                           var34 = 0;
                        }

                        var47 = var34;
                        var27 = 0;

                        label280: {
                           while(var27 < var10.length) {
                              var10000 = var10[var27].isEmpty();
                              if(var30) {
                                 break label280;
                              }

                              label276: {
                                 if(var10000 == 0) {
                                    var28 = var2.a((byte)0, var46 + var47);
                                    var29 = var10[var27].m();

                                    while(var29.f()) {
                                       var28.a((y.c.q)var29.d());
                                       var29.g();
                                       if(var30) {
                                          break label276;
                                       }

                                       if(var30) {
                                          break;
                                       }
                                    }

                                    ++var47;
                                 }

                                 ++var27;
                              }

                              if(var30) {
                                 break;
                              }
                           }

                           var10000 = var47 + var46;
                        }

                        var47 = var10000;
                        if(!var30) {
                           break label462;
                        }
                     }

                     var47 = var8 + 1;
                  }

                  var27 = 0;

                  label254:
                  while(true) {
                     if(var27 < var22) {
                        var28 = var2.a((byte)0, var47 + var27);
                        y.c.C var38 = var42[var27].m();
                        if(!var30) {
                           var29 = var38;

                           while(true) {
                              if(!var29.f()) {
                                 ++var27;
                                 break;
                              }

                              var28.a((y.c.q)var29.d());
                              var29.g();
                              if(var30) {
                                 break;
                              }

                              if(var30) {
                                 ++var27;
                                 break;
                              }
                           }

                           if(!var30) {
                              continue;
                           }

                           var27 = 0;
                           if(var27 >= var22) {
                              break;
                           }

                           var28 = var2.a((byte)0, var46 + var27);
                           if(var30) {
                              break label454;
                           }

                           var29 = var44[var27].m();
                        } else {
                           var29 = var38;
                        }
                     } else {
                        var27 = 0;
                        if(var27 >= var22) {
                           break;
                        }

                        var28 = var2.a((byte)0, var46 + var27);
                        if(var30) {
                           break label454;
                        }

                        var29 = var44[var27].m();
                     }

                     while(true) {
                        while(true) {
                           if(var29.f()) {
                              var28.a((y.c.q)var29.d());
                              var29.g();
                              if(!var30) {
                                 if(!var30) {
                                    continue;
                                 }

                                 ++var27;
                                 if(var30) {
                                    break label254;
                                 }
                                 break;
                              }

                              if(var30) {
                                 break label254;
                              }
                              break;
                           }

                           ++var27;
                           if(var30) {
                              break label254;
                           }
                           break;
                        }

                        if(var27 >= var22) {
                           break label254;
                        }

                        var28 = var2.a((byte)0, var46 + var27);
                        if(var30) {
                           break label454;
                        }

                        var29 = var44[var27].m();
                     }
                  }

                  this.a(var2);
               }
            }

            var31 = this.h(var1).a();
            break;
         }

         y.c.x var37 = var31;

         while(var37.f()) {
            if(this.d(var37.e())) {
               this.a(var37.e(), var2);
            }

            var37.g();
            if(var30) {
               break;
            }
         }

      }
   }

   private boolean a(Set var1, y.c.q var2) {
      boolean var9 = N.x;
      int var3 = 0;
      int var4 = 0;
      int var5 = this.c.a(var2).j();
      y.c.e var6 = var2.k();

      boolean var10000;
      y.c.q var7;
      int var8;
      while(true) {
         if(var6.f()) {
            var7 = var6.a().c();
            var10000 = var1.contains(var7);
            if(var9) {
               break;
            }

            if(var10000) {
               var8 = this.c.a(var7).j();
               if(var8 <= var5) {
                  ++var3;
               }
            }

            var6.g();
            if(!var9) {
               continue;
            }
         }

         var6 = var2.l();
         var10000 = var6.f();
         break;
      }

      int var10;
      while(var10000) {
         var7 = var6.a().d();
         var10 = var1.contains(var7);
         if(var9) {
            return var10 <= var4;
         }

         if(var10 != 0) {
            var8 = this.c.a(var7).j();
            if(var8 >= var5) {
               ++var4;
            }
         }

         var6.g();
         if(var9) {
            break;
         }

         var10000 = var6.f();
      }

      var10 = var3;
      return var10 <= var4;
   }

   private boolean a(y.c.y var1, int var2, int var3) {
      boolean var12 = N.x;
      int var4 = 0;
      int var5 = 0;
      HashSet var6 = new HashSet(var1);
      y.c.x var7 = var1.a();

      label73:
      while(true) {
         boolean var10000 = var7.f();

         label70:
         while(true) {
            if(var10000) {
               int var8 = this.c.a(var7.e()).j();
               if(var12) {
                  break;
               }

               y.c.e var9 = var7.e().k();

               y.c.q var10;
               int var11;
               while(true) {
                  if(var9.f()) {
                     var10 = var9.a().c();
                     var10000 = var6.contains(var10);
                     if(var12) {
                        break;
                     }

                     if(!var10000) {
                        var11 = this.c.a(var10).j();
                        if(var11 >= var2 && var11 <= var8) {
                           ++var4;
                        }
                     }

                     var9.g();
                     if(!var12) {
                        continue;
                     }
                  }

                  var9 = var7.e().l();
                  var10000 = var9.f();
                  break;
               }

               while(var10000) {
                  var10 = var9.a().d();
                  var10000 = var6.contains(var10);
                  if(var12) {
                     continue label70;
                  }

                  if(!var10000) {
                     var11 = this.c.a(var10).j();
                     if(var11 <= var3 && var11 >= var8) {
                        ++var5;
                     }
                  }

                  var9.g();
                  if(var12) {
                     break;
                  }

                  var10000 = var9.f();
               }

               var7.g();
               if(!var12) {
                  continue label73;
               }
            }

            if(var4 <= var5) {
               var10000 = true;
               return var10000;
            }
            break;
         }

         var10000 = false;
         return var10000;
      }
   }

   private void a(y.c.q var1, aU var2, y.c.D[] var3, int var4) {
      boolean var8 = N.x;
      y.c.x var5 = this.h(var1).a();

      while(var5.f()) {
         label17: {
            y.c.q var6 = var5.e();
            if(this.d(var6)) {
               this.a(var6, var2, var3, var4);
               if(!var8) {
                  break label17;
               }
            }

            int var7 = this.c.a(var6).j();
            var2.a(var7).b(var6);
            var3[var7 - var4].add(var6);
         }

         var5.g();
         if(var8) {
            break;
         }
      }

   }

   private boolean a(y.c.q var1, Set var2) {
      boolean var4 = N.x;
      y.c.q var3 = this.i(var1);

      boolean var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var2.contains(var3);
            if(var4) {
               break;
            }

            if(var10000) {
               return true;
            }

            var3 = this.i(var3);
            if(!var4) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   bK a(y.c.q var1) {
      if(this.a()) {
         this.j(var1);
         return ((bK[])this.n.get(var1))[0];
      } else {
         return null;
      }
   }

   bK b(y.c.q var1) {
      if(this.a()) {
         this.j(var1);
         return ((bK[])this.n.get(var1))[1];
      } else {
         return null;
      }
   }

   private void j(y.c.q var1) {
      boolean var7 = N.x;
      if(!this.n.containsKey(var1)) {
         bK[] var2 = new bK[]{null, null};
         y.c.x var3 = this.h(var1).a();

         while(true) {
            if(var3.f()) {
               if(var7) {
                  break;
               }

               label74: {
                  if(this.d(var3.e())) {
                     this.j(var3.e());
                     bK[] var4 = (bK[])this.n.get(var3.e());
                     if(var4[0] != null && (var2[0] == null || var2[0].j() > var4[0].j())) {
                        var2[0] = var4[0];
                     }

                     if(var4[1] == null || var2[1] != null && var2[1].j() >= var4[1].j()) {
                        break label74;
                     }

                     var2[1] = var4[1];
                     if(!var7) {
                        break label74;
                     }
                  }

                  aX var8 = this.c.a(var3.e());
                  bK var5 = var8.h();
                  if(var5 == null) {
                     Object var6 = this.d.b(var3.e());
                     if(var6 instanceof bK) {
                        var5 = (bK)var6;
                     }
                  }

                  if(var5 != null) {
                     if(var2[0] == null || var2[0].j() > var5.j()) {
                        var2[0] = var5;
                     }

                     if(var2[1] == null || var2[1].j() < var5.j()) {
                        var2[1] = var5;
                     }
                  }
               }

               var3.g();
               if(!var7) {
                  continue;
               }
            }

            this.n.put(var1, var2);
            break;
         }

      }
   }

   void g(aU var1) {
      boolean var10 = N.x;
      if(this.k()) {
         float[] var2 = new float[this.b.e()];
         this.a(0, var1.b());
         if(this.j.g != null && this.j.h != null) {
            int var3 = this.j.g.c();
            int var4 = this.j.h.c();
            int var5 = var3;

            while(true) {
               if(var5 <= var4) {
                  y.c.y var6 = var1.a(var5).d();
                  int var7 = 0;
                  if(var10) {
                     break;
                  }

                  y.c.p var8 = var6.k();

                  label33: {
                     while(var8 != null) {
                        y.c.q var9 = (y.c.q)var8.c();
                        var2[var9.d()] = (float)var7;
                        var8 = var8.a();
                        ++var7;
                        if(var10) {
                           break label33;
                        }

                        if(var10) {
                           break;
                        }
                     }

                     this.j.a(var5, var2, this.d(), this.c, true);
                     this.j.a(var5, true, this.d());
                     this.j.a(var5, var6.k());
                     ++var5;
                  }

                  if(!var10) {
                     continue;
                  }
               }

               this.g();
               break;
            }

         }
      }
   }

   void a(y.c.c var1) {
      this.g = var1;
   }

   y.c.c d() {
      return this.g;
   }

   void a(int var1) {
      if(this.k()) {
         this.j.a(var1);
      }
   }

   void a(y.c.D[] var1, int[] var2, boolean var3) {
      boolean var10 = N.x;
      if(this.k()) {
         y.c.c var4;
         float[] var5;
         int var6;
         label52: {
            label56: {
               var4 = this.d();
               var5 = new float[this.b.e()];
               if(var3) {
                  var6 = 0;

                  do {
                     if(var6 >= var5.length) {
                        break label56;
                     }

                     var5[var6] = (float)var2[var6];
                     ++var6;
                     if(var10) {
                        break label52;
                     }
                  } while(!var10);
               }

               var6 = 0;

               while(var6 < var5.length) {
                  var5[var6] = this.o.nextFloat();
                  ++var6;
                  if(var10) {
                     break label52;
                  }

                  if(var10) {
                     break;
                  }
               }
            }

            this.a(0, var1.length);
            var6 = this.j.g.c();
         }

         int var7 = this.j.h.c();
         int var8 = var6;

         while(true) {
            if(var8 <= var7) {
               y.c.D var9 = var1[var8];
               this.j.a(var8, var5, var4, this.c, true);
               this.j.a(var8, true, var4);
               this.j.a(var8, var9.k());
               this.a(var9, var2);
               ++var8;
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            this.g();
            break;
         }

      }
   }

   void a(int var1, int var2) {
      boolean var6 = N.x;
      if(this.k()) {
         ArrayList var3 = this.j.d;
         int var4 = var3.size() - 1;

         while(var4 >= 0) {
            dg var5 = (dg)var3.get(var4);
            if(var5.g != null && var5.h != null && var5.g.c() >= var1 && var5.h.c() <= var2) {
               var5.r = -1;
            }

            --var4;
            if(var6) {
               break;
            }
         }

      }
   }

   private void a(y.c.D var1, int[] var2) {
      boolean var6 = N.x;
      if(this.k()) {
         int var3 = 0;
         y.c.p var4 = var1.k();

         while(var4 != null) {
            y.c.q var5 = (y.c.q)var4.c();
            var2[var5.d()] = var3;
            var4 = var4.a();
            ++var3;
            if(var6) {
               break;
            }
         }

      }
   }

   void a(y.c.D var1, int var2, float[] var3, int[] var4, boolean var5) {
      if(this.k()) {
         y.c.c var6 = this.d();
         this.j.a(var2, var3, var6, this.c, var5);
         this.j.a(var2, var5, var6);
         this.j.a(var2, var1.k());
         this.a(var1, var4);
      }
   }

   void e() {
      if(this.k()) {
         this.j.c();
      }
   }

   void f() {
      this.j = null;
      if(this.f != null) {
         this.b.a((Object)y.f.b.f.d, (y.c.c)this.f);
      }

   }

   void a(aU var1, aP var2) {
      boolean var14 = N.x;
      if(this.k()) {
         HashMap var3 = new HashMap();
         HashMap var4 = new HashMap();
         int var5 = 0;

         do {
            int var10000 = var5;
            int var10001 = var1.b();

            label49:
            while(true) {
               if(var10000 >= var10001) {
                  return;
               }

               aQ var6 = var1.a(var5);
               y.c.y var7 = var6.d();
               y.c.p var8 = var7.k();

               while(true) {
                  if(var8 == null) {
                     break label49;
                  }

                  y.c.q var9 = (y.c.q)var8.c();
                  aX var10 = this.c.a(var9);
                  byte var11 = var10.b();
                  var10000 = var10.b();
                  var10001 = 12;
                  if(var14) {
                     break;
                  }

                  y.c.q var12;
                  y.c.q var13;
                  if(var10000 == 12) {
                     var12 = var10.f();
                     var13 = (y.c.q)var3.get(var12);
                     if(var13 != null && var13.a(var9) == null) {
                        var2.a(var13, var9);
                     }

                     var3.put(var12, var9);
                  }

                  if(var10.b() == 13) {
                     var12 = var10.f();
                     var13 = (y.c.q)var4.get(var12);
                     if(var13 != null && var13.a(var9) == null) {
                        var2.a(var13, var9);
                     }

                     var4.put(var12, var9);
                  }

                  var8 = var8.a();
                  if(var14) {
                     break label49;
                  }
               }
            }

            ++var5;
         } while(!var14);

      }
   }

   void b(aU var1, aP var2) {
      if(this.k()) {
         this.g();
         this.j.a(var1, var2);
      }
   }

   void g() {
      boolean var3 = N.x;
      this.j.b();
      Iterator var1 = this.j.d.iterator();

      while(var1.hasNext()) {
         dg var2 = (dg)var1.next();
         var2.b();
         if(var3) {
            break;
         }
      }

   }

   void h(aU var1) {
      boolean var8 = N.x;
      if(this.k()) {
         int var2 = 0;

         label64:
         while(true) {
            int var10000 = var2;
            int var10001 = var1.b();

            label61:
            while(var10000 < var10001) {
               aQ var3 = var1.a(var2);
               y.c.y var4 = var3.d();
               if(var8) {
                  break label64;
               }

               y.c.p var5 = var4.k();

               while(var5 != null) {
                  y.c.q var6 = (y.c.q)var5.c();
                  byte var7 = this.c.a(var6).b();
                  var10000 = var7;
                  var10001 = 12;
                  if(var8) {
                     continue label61;
                  }

                  if(var7 == 12 || var7 == 13) {
                     var4.h(var5);
                  }

                  var5 = var5.a();
                  if(var8) {
                     break;
                  }
               }

               var3.a((y.c.D)var4);
               ++var2;
               if(!var8) {
                  continue label64;
               }
               break;
            }

            this.j.b(this.c);
            break;
         }

         y.c.x var9 = this.b.o();

         while(var9.f()) {
            y.c.q var10 = var9.e();
            byte var11 = this.c.a(var10).b();
            if(var11 == 12 || var11 == 13) {
               this.b.a((y.c.q)var10);
            }

            var9.g();
            if(var8) {
               break;
            }
         }

      }
   }

   y.d.r c(y.c.q var1) {
      if(!this.k()) {
         return null;
      } else {
         y.d.r var2 = null;
         y.c.c var3 = this.b.c(y.f.b.f.e);
         if(var3 != null) {
            var2 = y.d.r.a(var3.b(var1));
         }

         if(var2 == null) {
            var2 = new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
         }

         return var2;
      }
   }

   void a(cr var1, aQ var2, boolean var3, double var4) {
      if(this.k()) {
         this.j.a(var1, var2, var3, var4);
      }
   }

   void b(cr var1, aQ var2, boolean var3, double var4) {
      boolean var17 = N.x;
      if(this.k()) {
         y.d.c var6 = var1.c();
         y.c.p var7 = var2.d().k();

         while(var7 != null) {
            y.c.q var8 = (y.c.q)var7.c();
            aX var9 = this.c.a(var8);
            if(var9.b() == 12) {
               dg var10 = this.f(var9.l());
               if(var1.b((Object)var10)) {
                  label34: {
                     double var11 = var1.d(var10);
                     y.d.r var13 = this.c(var10.f);
                     cy var16;
                     if(var3 && var10.A == var2) {
                        var10.x = this.b.n(var8) + var4 - var11;
                        var10.E = var11;
                        if(var6 == null) {
                           break label34;
                        }

                        var16 = var1.a((Object)var10);
                        var6.b(var16.b, var16.c, var11 + var13.a);
                        if(!var17) {
                           break label34;
                        }
                     }

                     if(!var3 && var10.B == var2) {
                        var10.F = var11 + var4;
                        var10.y = var11 - var4 - this.b.n(var8);
                        if(var6 != null) {
                           var16 = var1.a((Object)var10);
                           var6.b(var16.b, var16.c, var11);
                        }
                     }
                  }
               }
            }

            var7 = var7.a();
            if(var17) {
               break;
            }
         }

      }
   }

   public double h() {
      return this.k;
   }

   public void a(double var1) {
      this.k = var1;
   }

   void i(aU var1) {
      if(this.k()) {
         this.j.a(var1, this.c);
      }

   }

   void j(aU var1) {
      if(this.k()) {
         this.j.b(var1, this.c);
      }

   }

   void b(aU var1, y.c.A var2) {
      boolean var7 = N.x;
      if(this.k()) {
         y.c.x var3 = this.b.o();

         while(true) {
            byte var10000;
            byte var10001;
            y.c.q var4;
            aX var5;
            if(var3.f()) {
               var4 = var3.e();
               var5 = this.c.a(var4);
               var10000 = var5.b();
               var10001 = 12;
               if(!var7) {
                  if(var10000 != 12) {
                     if(var5.b() == 13) {
                        var2.a(var4, true);
                     }
                  } else {
                     var2.a(var4, true);
                  }

                  var3.g();
                  if(!var7) {
                     continue;
                  }

                  this.a(var1, var2);
                  this.c(var1);
                  var3 = this.b.o();
                  if(!var3.f()) {
                     break;
                  }

                  var4 = var3.e();
                  var5 = this.c.a(var4);
                  var10000 = var5.b();
                  var10001 = 12;
               }
            } else {
               this.a(var1, var2);
               this.c(var1);
               var3 = this.b.o();
               if(!var3.f()) {
                  break;
               }

               var4 = var3.e();
               var5 = this.c.a(var4);
               var10000 = var5.b();
               var10001 = 12;
            }

            while(true) {
               dg var6;
               if(var10000 != var10001) {
                  if(var5.b() == 13) {
                     var6 = this.f(var5.l());
                     if(var6.g != null && var6.h != null && var6.g.c() <= var5.j() && var6.h.c() >= var5.j()) {
                        var2.a(var4, false);
                     }

                     var3.g();
                     if(var7) {
                        return;
                     }
                  } else {
                     var3.g();
                     if(var7) {
                        return;
                     }
                  }
               } else {
                  var6 = this.f(var5.l());
                  if(var6.g != null && var6.h != null && var6.g.c() <= var5.j() && var6.h.c() >= var5.j()) {
                     var2.a(var4, false);
                  }

                  var3.g();
                  if(var7) {
                     return;
                  }
               }

               if(!var3.f()) {
                  return;
               }

               var4 = var3.e();
               var5 = this.c.a(var4);
               var10000 = var5.b();
               var10001 = 12;
            }
         }

      }
   }

   public void k(aU var1) {
      if(this.k()) {
         this.j.a(var1);
      }
   }

   public boolean d(y.c.q var1) {
      return !this.k()?false:this.j.c.b(var1) != null;
   }

   void c(aU var1, aP var2) {
      boolean var24 = N.x;
      if(this.k()) {
         this.c();
         HashMap var3 = new HashMap();
         y.c.y var4 = new y.c.y();
         y.c.e var5 = this.b.p();

         E var10000;
         while(true) {
            if(var5.f()) {
               y.c.d var6 = var5.a();
               A var7 = this.c.a(var6);
               y.c.q var8 = var6.c();
               y.c.q var9 = var6.d();
               var10000 = this;
               if(var24) {
                  break;
               }

               y.c.q var10;
               L var11;
               y.d.t var12;
               dg var14;
               aQ var15;
               aQ var16;
               aX var17;
               y.f.aE var18;
               y.f.aE var20;
               y.f.aE var21;
               int var22;
               int var23;
               dg var32;
               int var33;
               if(this.d(var8)) {
                  var10 = null;
                  var11 = null;
                  if(var7.g() != null) {
                     var11 = new L(this, var8, var7.g());
                     if(var11 != null) {
                        var10 = (y.c.q)var3.get(var11);
                     }
                  }

                  if(var10 == null) {
                     var14 = this.f(var8);
                     var15 = var14.g;
                     var16 = var14.h;
                     var17 = this.c.a(var9);
                     if(var17 == null) {
                        throw new IllegalStateException("nodeData == null for node " + var9);
                     }

                     var18 = var7.c() != null && !var7.c().g()?var7.c():null;
                     if(var18 != null) {
                        var2.a(var6, true, y.f.aE.a(var18.b()));
                     }

                     aQ var19;
                     label377: {
                        if(var18 != null && var18.c()) {
                           var19 = var15;
                           if(!var24) {
                              break label377;
                           }
                        }

                        if(var18 != null && var18.d()) {
                           var19 = var16;
                           if(!var24) {
                              break label377;
                           }
                        }

                        if(!this.d(var9)) {
                           if(var15.c() > var17.j()) {
                              var19 = var15;
                              if(!var24) {
                                 break label377;
                              }
                           }

                           if(var16.c() < var17.j()) {
                              var19 = var16;
                              if(!var24) {
                                 break label377;
                              }
                           }

                           if(var18 == null && this.a(var9, var8)) {
                              var19 = var16;
                              var2.a(var6, true, y.f.aE.a((byte)2));
                              var20 = var7.e() != null && !var7.e().g()?var7.e():null;
                              if(var20 != null) {
                                 break label377;
                              }

                              var2.a(var6, false, y.f.aE.a((byte)1));
                              if(!var24) {
                                 break label377;
                              }
                           }

                           var19 = var1.a(var17.j());
                           if(!var24) {
                              break label377;
                           }
                        }

                        var32 = this.f(var9);
                        if(this.a(var9, var8) || this.a(var8, var32.f)) {
                           var19 = var16;
                           if(var18 != null) {
                              break label377;
                           }

                           var2.a(var6, true, y.f.aE.a((byte)2));
                           if(!var24) {
                              break label377;
                           }
                        }

                        if(var8 == var32.f) {
                           label277: {
                              var21 = var7.e() != null && !var7.e().g()?var7.e():null;
                              if(var18 != null && var21 != null && var21.d() && (var18.e() || var18.f())) {
                                 var19 = var16;
                                 if(!var24) {
                                    break label277;
                                 }
                              }

                              var19 = var15;
                           }

                           if(var18 != null) {
                              break label377;
                           }

                           var2.a(var6, true, y.f.aE.a((byte)2));
                           if(!var24) {
                              break label377;
                           }
                        }

                        if(var15.c() > var32.h.c()) {
                           var19 = var15;
                           if(!var24) {
                              break label377;
                           }
                        }

                        if(var16.c() < var32.g.c()) {
                           var19 = var16;
                           if(!var24) {
                              break label377;
                           }
                        }

                        var33 = Math.max(var15.c(), var32.g.c());
                        var22 = Math.min(var16.c(), var32.h.c());
                        if(var22 < var33) {
                           throw new IllegalStateException("huh?");
                        }

                        var23 = (var33 + var22) / 2;
                        var19 = var1.a(var23);
                     }

                     var10 = var2.a((y.c.q)var8, (Object)var14, (aQ)var19, (y.c.d)var6);
                     if(var11 != null) {
                        var3.put(var11, var10);
                     }

                     var4.add(var10);
                     this.j.a((Object)var10, (dg)var14);
                     if(var24) {
                        throw new IllegalStateException("nodeData == null for node " + var9);
                     }
                  }

                  var12 = this.b.p(var6);
                  this.b.a(var6, var10, var6.d());
                  this.b.a(var10, var12);
                  this.b.a(var6, y.d.t.c);
               }

               if(this.d(var9)) {
                  var10 = null;
                  var11 = null;
                  if(var7.h() != null) {
                     var11 = new L(this, var9, var7.h());
                     if(var11 != null) {
                        var10 = (y.c.q)var3.get(var11);
                     }
                  }

                  if(var10 == null) {
                     var14 = this.f(var9);
                     var15 = var14.g;
                     var16 = var14.h;
                     var17 = this.c.a(var8);
                     if(var17 == null) {
                        throw new IllegalStateException("nodeData == null for node " + var8);
                     }

                     var18 = null;
                     y.f.aE var34 = var7.e() != null && !var7.e().g()?var7.e():null;
                     if(var34 != null) {
                        var2.a(var6, false, y.f.aE.a(var34.b()));
                     }

                     aQ var31;
                     if(var34 != null && var34.c()) {
                        var31 = var15;
                     } else if(var34 != null && var34.d()) {
                        var31 = var16;
                     } else if(!this.d(var8)) {
                        if(var15.c() > var17.j()) {
                           var31 = var15;
                        } else if(var16.c() < var17.j()) {
                           var31 = var16;
                        } else if(var34 == null && this.a(var8, var9)) {
                           var31 = var15;
                           var20 = var7.c() != null && !var7.c().g()?var7.c():null;
                           if(var20 == null) {
                              var2.a(var6, true, y.f.aE.a((byte)2));
                           }

                           var2.a(var6, false, y.f.aE.a((byte)1));
                        } else {
                           var31 = var1.a(var17.j());
                        }
                     } else {
                        var32 = this.f(var8);
                        if(!this.a(var8, var9) && !this.a(var9, var32.f)) {
                           if(var9 != var32.f) {
                              if(var15.c() > var32.h.c()) {
                                 var31 = var15;
                              } else if(var16.c() < var32.g.c()) {
                                 var31 = var16;
                              } else {
                                 var33 = Math.max(var15.c(), var32.g.c());
                                 var22 = Math.min(var16.c(), var32.h.c());
                                 if(var22 < var33) {
                                    throw new IllegalStateException("huh?");
                                 }

                                 var23 = (var33 + var22) / 2;
                                 var31 = var1.a(var23);
                              }
                           } else {
                              var21 = var7.c() != null && !var7.c().g()?var7.c():null;
                              if(var21 == null || var34 == null || !var21.d() || !var34.e() && !var34.f()) {
                                 var31 = var15;
                              } else {
                                 var31 = var16;
                              }

                              if(var34 == null) {
                                 var2.a(var6, false, y.f.aE.a((byte)1));
                              }
                           }
                        } else {
                           var31 = var15;
                           if(var34 == null) {
                              var2.a(var6, false, y.f.aE.a((byte)1));
                           }
                        }
                     }

                     var10 = var2.a((y.c.q)var9, (Object)var14, (aQ)var31, (y.c.d)var6);
                     if(var11 != null) {
                        var3.put(var11, var10);
                     }

                     var4.add(var10);
                     this.j.a((Object)var10, (dg)var14);
                     if(var24) {
                        throw new IllegalStateException("nodeData == null for node " + var8);
                     }
                  }

                  var12 = this.b.q(var6);
                  this.b.a(var6, var6.c(), var10);
                  this.b.a(var10, var12);
                  this.b.b(var6, y.d.t.c);
               }

               var5.g();
               if(!var24) {
                  continue;
               }
            }

            this.b();
            var10000 = this;
            break;
         }

         y.d.q var25 = var10000.l();
         if(var25 != null) {
            double var26 = var25.a * 0.5D;
            y.c.A var27 = (y.c.A)this.b.c(cp.a);
            y.c.A var28 = (y.c.A)this.b.c(cp.b);
            y.c.x var30 = var4.a();

            while(var30.f()) {
               y.c.q var29 = var30.e();
               var27.a(var29, var26);
               var28.a(var29, var26);
               var30.g();
               if(var24) {
                  break;
               }
            }
         }

      }
   }

   private y.d.q l() {
      y.c.c var1 = this.b.c(N.u);
      return var1 == null?null:(y.d.q)var1.b(this.b);
   }

   private boolean a(y.c.q var1, y.c.d var2, aV var3) {
      return this.a(var1, (y.c.d)var2, (aV)var3, (byte)8);
   }

   private boolean b(y.c.q var1, y.c.d var2, aV var3) {
      return this.a(var1, (y.c.d)var2, (aV)var3, (byte)4);
   }

   private boolean a(y.c.q var1, y.c.d var2, aV var3, byte var4) {
      boolean var5 = var1 == var2.c();
      A var6 = var3.a(var2);
      y.f.aE var7 = var5?var6.c():var6.e();
      return var7 != null && var7.b() == var4;
   }

   private y.c.q a(y.c.q var1, y.c.D var2, aV var3) {
      y.c.q var4 = (y.c.q)var2.f();
      return var3.a(var4).b() == 12?var4:this.a(var1, (y.c.D)var2, (aV)var3, (byte)12);
   }

   private y.c.q b(y.c.q var1, y.c.D var2, aV var3) {
      y.c.q var4 = (y.c.q)var2.i();
      return var3.a(var4).b() == 13?var4:this.a(var1, (y.c.D)var2, (aV)var3, (byte)13);
   }

   private y.c.q a(y.c.q var1, y.c.D var2, aV var3, byte var4) {
      boolean var8 = N.x;
      y.c.p var5 = var2.k();

      while(var5 != null) {
         if(var5.c() instanceof y.c.q) {
            y.c.q var6 = (y.c.q)var5.c();
            aX var7 = var3.a(var6);
            if(var7.l() == var1 && var7.b() == var4) {
               return var6;
            }
         }

         var5 = var5.a();
         if(var8) {
            break;
         }
      }

      return null;
   }

   void i() {
      boolean var3 = N.x;
      if(this.k()) {
         y.c.C var1 = this.h.m();

         while(var1.f()) {
            M var2 = (M)var1.d();
            M.a(var2);
            var1.g();
            if(var3) {
               break;
            }
         }

      }
   }

   void a(y.f.X var1, aV var2) {
      boolean var9 = N.x;
      this.a.clear();
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         A var5 = var2.a(var4);
         aX var6 = var2.a(var4.c());
         aX var7 = var2.a(var4.d());
         y.f.aE var8 = var5.c();
         if(var6.b() == 15 && var7.b() == var6.b() && var6.l() == var7.l() && var8 != null && var8 == var5.e() && (var8.e() || var8.f())) {
            this.a.add(var4);
            var1.d(var4);
         }

         var3.g();
         if(var9) {
            break;
         }
      }

   }

   private double a(y.c.d var1) {
      double var10000;
      double var3;
      double var5;
      label35: {
         label34: {
            boolean var13 = N.x;
            B var2 = this.c.a(var1).k();
            var3 = var2 != null?Math.max(var2.a(), var2.b()):15.0D;
            var5 = 0.0D;
            y.f.C[] var7 = this.b.d(var1);
            if(var7 != null) {
               int var8 = 0;

               while(var8 < var7.length) {
                  var5 = Math.max(var5, var7[var8].getBox().a());
                  ++var8;
                  if(var13) {
                     break label34;
                  }

                  if(var13) {
                     break;
                  }
               }
            }

            if(var2 != null) {
               var10000 = var2.d();
               break label35;
            }
         }

         var10000 = 5.0D;
      }

      double var14 = var10000;
      y.d.q var10 = this.l();
      double var11 = var10 != null?var10.a * 0.5D:0.0D;
      return var11 + var14 + Math.max(var5, var3);
   }

   private double a(y.c.d var1, y.c.q var2) {
      double var3 = 0.0D;
      B var5 = this.c.a(var1).k();
      if(var5 != null) {
         label44: {
            boolean var6 = this.c.a(var1).i();
            if(var1.c() == var2 && !var6 || var1.d() == var2 && var6) {
               var3 = var5.a();
               if(!N.x) {
                  break label44;
               }
            }

            var3 = var5.b();
         }
      }

      double var11 = var5 != null?var5.d():5.0D;
      y.d.q var8 = this.l();
      double var9 = var8 != null?var8.a * 0.5D:0.0D;
      return var9 + var11 + var3;
   }

   void a(aU var1, cd var2) {
      boolean var23 = N.x;
      if(this.k()) {
         this.h.clear();
         y.c.A var3 = (y.c.A)this.b.c(cp.a);
         y.c.A var4 = (y.c.A)this.b.c(cp.b);
         y.c.e var5 = this.a.a();

         y.c.q var9;
         aX var10;
         byte var10000;
         dg var17;
         da var18;
         while(true) {
            if(var5.f()) {
               y.c.d var6 = var5.a();
               this.b.e(var6);
               y.c.q var7 = var6.c();
               aX var8 = this.c.a(var7);
               var9 = var6.d();
               var10 = this.c.a(var9);
               byte var11 = this.a(var7, var6, this.c);
               y.c.q var12 = var8.f();
               dg var13 = this.f(var12);
               da var14 = var13.b(var8.j());
               var10000 = var11;
               if(var23) {
                  break;
               }

               y.c.q var15 = var11 != 0?this.a((y.c.q)var12, (y.c.D)var14, (aV)this.c):this.b(var12, (y.c.D)var14, this.c);
               this.h.add(new M(this, var6, var7, var15));
               this.h.add(new M(this, var6, var9, var15));
               this.b.a(var6, var15, var15);
               aQ var16 = var1.a(var8.j());
               if(var7.a() == 0 && var8.e() == 0) {
                  this.b.c(var7);
                  var16.d().remove(var7);
                  var17 = this.f(var8.l());
                  var18 = var17.b(var8.j());
                  var18.remove(var7);
               }

               var16.a((y.c.D)var16.d());
               aQ var36 = var1.a(var10.j());
               if(var9.a() == 0 && var10.e() == 0) {
                  this.b.c(var9);
                  var36.d().remove(var9);
                  dg var38 = this.f(var10.l());
                  da var19 = var38.b(var10.j());
                  var19.remove(var9);
               }

               label167: {
                  var36.a((y.c.D)var36.d());
                  double var39;
                  if(var11 != 0) {
                     var39 = var3.c(var15);
                     var3.a(var15, Math.max(var39, this.a(var6)));
                     if(!var23) {
                        break label167;
                     }
                  }

                  var39 = var4.c(var15);
                  var4.a(var15, Math.max(var39, this.a(var6)));
               }

               var2.a(this.b, var6);
               var5.g();
               if(!var23) {
                  continue;
               }
            }

            var10000 = 0;
            break;
         }

         int var24 = var10000;

         do {
            int var35 = var24;
            int var10001 = var1.b();

            aQ var25;
            boolean var37;
            label154:
            while(true) {
               if(var35 >= var10001) {
                  return;
               }

               var25 = var1.a(var24);
               boolean var26 = false;
               y.c.p var27 = var25.d().k();

               while(var27 != null) {
                  var9 = (y.c.q)var27.c();
                  var10 = this.c.a(var9);
                  var35 = var10.b();
                  var10001 = 15;
                  if(var23) {
                     continue label154;
                  }

                  if(var35 == 15) {
                     as var28 = (as)var10;
                     y.c.e var29 = var9.j();

                     double var21;
                     da var22;
                     y.c.d var31;
                     boolean var32;
                     boolean var33;
                     y.c.q var34;
                     y.c.q var40;
                     dg var42;
                     while(var29.f()) {
                        var31 = var29.a();
                        var32 = this.a(var9, var31, this.c);
                        var33 = this.b(var9, var31, this.c);
                        var37 = var32;
                        if(var23) {
                           break label154;
                        }

                        if(var32 || var33) {
                           label138: {
                              var34 = var28.f();
                              var17 = this.f(var34);
                              var18 = var17.b(var28.j());
                              var40 = var32?this.a((y.c.q)var34, (y.c.D)var18, (aV)this.c):this.b(var34, (y.c.D)var18, this.c);
                              this.h.add(new M(this, var31, var9, var40));
                              if(var31.c() == var9) {
                                 this.b.a(var31, var40, var31.d());
                                 if(!var23) {
                                    break label138;
                                 }
                              }

                              this.b.a(var31, var31.c(), var40);
                           }

                           label133: {
                              B var20 = this.c.a(var31).k();
                              if(var32) {
                                 var21 = var3.c(var40);
                                 var3.a(var40, Math.max(var21, this.a(var31, var9)));
                                 if(!var23) {
                                    break label133;
                                 }
                              }

                              var21 = var4.c(var40);
                              var4.a(var40, Math.max(var21, this.a(var31, var9)));
                           }

                           if(var9.a() == 0 && var10.e() == 0) {
                              this.b.c(var9);
                              var25.d().h(var27);
                              var26 = true;
                              var42 = this.f(var28.l());
                              var22 = var42.b(var28.j());
                              var22.remove(var9);
                           }
                        }

                        var29.g();
                        if(var23) {
                           break;
                        }
                     }

                     y.c.p var30 = var10.d();

                     while(var30 != null) {
                        var31 = (y.c.d)var30.c();
                        var32 = this.a(var9, var31, this.c);
                        var33 = this.b(var9, var31, this.c);
                        var37 = var32;
                        if(var23) {
                           break label154;
                        }

                        if(var32 || var33) {
                           label115: {
                              var34 = var28.f();
                              var17 = this.f(var34);
                              var18 = var17.b(var28.j());
                              var40 = var32?this.a((y.c.q)var34, (y.c.D)var18, (aV)this.c):this.b(var34, (y.c.D)var18, this.c);
                              as var41 = (as)this.c.a(var40);
                              var41.a(var31);
                              var28.a(var30);
                              this.h.add(new M(this, var31, var9, var40));
                              if(var31.c() == var9) {
                                 this.b.a(var31, var40, var31.d());
                                 if(!var23) {
                                    break label115;
                                 }
                              }

                              this.b.a(var31, var31.c(), var40);
                           }

                           label110: {
                              if(var32) {
                                 var21 = var3.c(var40);
                                 var3.a(var40, Math.max(var21, this.a(var31, var9)));
                                 if(!var23) {
                                    break label110;
                                 }
                              }

                              var21 = var4.c(var40);
                              var4.a(var40, Math.max(var21, this.a(var31, var9)));
                           }

                           if(var9.a() == 0 && var10.e() == 0) {
                              this.b.c(var9);
                              var25.d().h(var27);
                              var26 = true;
                              var42 = this.f(var28.l());
                              var22 = var42.b(var28.j());
                              var22.remove(var9);
                           }
                        }

                        var30 = var30.a();
                        if(var23) {
                           break;
                        }
                     }
                  }

                  var27 = var27.a();
                  if(var23) {
                     break;
                  }
               }

               var37 = var26;
               break;
            }

            if(var37) {
               var25.a((y.c.D)var25.d());
            }

            ++var24;
         } while(!var23);

      }
   }

   void a(y.f.X var1) {
      boolean var7 = N.x;
      if(this.k()) {
         y.c.e var2 = var1.p();

         while(var2.f()) {
            y.c.d var3 = var2.a();
            y.c.q var4 = (y.c.q)this.l.b(var3);
            if(var4 != null) {
               if(!var1.f(var4)) {
                  var1.d(var4);
               }

               y.d.t var5 = var1.p(var3);
               var1.a(var4, var1.l(var3.c()));
               var1.a(var3, var4, var3.d());
               var1.c(var3, var5);
            }

            y.c.q var8 = (y.c.q)this.m.b(var3);
            if(var8 != null) {
               if(!var1.f(var8)) {
                  var1.d(var8);
               }

               y.d.t var6 = var1.q(var3);
               var1.a(var8, var1.l(var3.d()));
               var1.a(var3, var3.c(), var8);
               var1.d(var3, var6);
            }

            var2.g();
            if(var7) {
               break;
            }
         }

      }
   }

   void l(aU var1) {
      boolean var24 = N.x;
      if(this.k()) {
         int var2 = 0;

         label144:
         while(true) {
            int var10000 = var2;

            label141:
            while(true) {
               int var10001 = var1.b();

               aQ var3;
               da var4;
               boolean var5;
               y.c.p var6;
               y.c.q var7;
               label138:
               while(true) {
                  if(var10000 >= var10001) {
                     break label141;
                  }

                  var3 = var1.a(var2);
                  var4 = null;
                  var5 = false;
                  if(var24) {
                     return;
                  }

                  var6 = var3.d().k();

                  while(true) {
                     if(var6 == null) {
                        break label138;
                     }

                     var7 = (y.c.q)var6.c();
                     aX var8 = this.c.a(var7);
                     var10000 = var8.b();
                     var10001 = 15;
                     if(var24) {
                        break;
                     }

                     if(var10000 == 15) {
                        y.c.p var9 = var8.d();
                        if(var9 != null) {
                           ar var10 = (ar)var8;
                           dg var11 = this.f(var10.l());
                           y.c.d var12 = (y.c.d)var9.c();
                           A var13 = this.c.a(var12);
                           y.f.aE var14 = var12.c() == var7?var13.c():var13.e();
                           as var15 = (as)this.c.a(var12.a(var7));
                           if(var15.l() != var11.f && var15.b() != 8 && var15.b() != 9 && (var14 == null || !var14.c() && !var14.d()) && (var13.a() == 4 || (var11.g.c() != var10.j() || !var13.j()) && (var11.h.c() != var10.j() || var13.j()))) {
                              var4 = var11.b(var10.j());
                              y.c.q var16 = (y.c.q)var4.f();
                              y.c.q var17 = (y.c.q)var4.i();
                              as var18 = (as)this.c.a(var16);
                              as var19 = (as)this.c.a(var17);

                              while(var9 != null) {
                                 var12 = (y.c.d)var9.c();
                                 y.c.q var20 = var12.a(var7);
                                 as var21 = (as)this.c.a(var20);
                                 y.c.q var22 = null;
                                 as var23 = null;
                                 var10000 = var21.k();
                                 var10001 = var18.k();
                                 if(var24) {
                                    continue label138;
                                 }

                                 if(var10000 < var10001) {
                                    var22 = var16;
                                    var23 = var18;
                                 } else if(var21.k() > var19.k()) {
                                    var22 = var17;
                                    var23 = var19;
                                 } else if(var10.k() > var21.k()) {
                                    var22 = var17;
                                    var23 = var19;
                                 } else {
                                    var22 = var16;
                                    var23 = var18;
                                 }

                                 label129: {
                                    var23.a(var12);
                                    var10.a(var9);
                                    if(var12.c() == var7) {
                                       this.b.a(var12, var22, var12.d());
                                       this.l.a(var12, var7);
                                       if(!var24) {
                                          break label129;
                                       }
                                    }

                                    this.b.a(var12, var12.c(), var22);
                                    this.m.a(var12, var7);
                                 }

                                 var9 = var9.a();
                                 if(var24) {
                                    break;
                                 }
                              }

                              if(var7.a() == 0 && var10.e() == 0) {
                                 this.b.c(var7);
                                 var3.d().h(var6);
                                 var4.remove(var7);
                                 var5 = true;
                              }
                           }
                        }
                     }

                     var6 = var6.a();
                     if(var24) {
                        break label138;
                     }
                  }
               }

               if(var5) {
                  var3.a((y.c.D)var3.d());
                  var6 = var4.k();

                  while(var6 != null) {
                     var10000 = var6.c() instanceof y.c.q;
                     if(var24) {
                        continue label141;
                     }

                     if(var10000 != 0) {
                        var7 = (y.c.q)var6.c();
                        if(var7.e() == null) {
                           var4.h(var6);
                        }
                     }

                     var6 = var6.a();
                     if(var24) {
                        break;
                     }
                  }
               }

               ++var2;
               if(!var24) {
                  continue label144;
               }
               break;
            }

            this.m(var1);
            return;
         }
      }
   }

   void m(aU var1) {
      boolean var4 = N.x;
      if(this.k()) {
         this.j.c(var1, this.c);
         int var2 = 0;

         while(var2 < var1.b()) {
            y.c.y var3 = var1.a(var2).d();
            this.j.a(var2, var3.k());
            var1.a(var2).a((y.c.D)var3);
            ++var2;
            if(var4) {
               break;
            }
         }

      }
   }

   void j() {
      boolean var14 = N.x;
      if(this.k()) {
         boolean var1 = false;
         y.c.x var2 = this.b.o();

         do {
            boolean var10000 = var2.f();

            label104:
            while(true) {
               if(!var10000) {
                  return;
               }

               y.c.q var3 = var2.e();
               aX var4 = this.c.a(var3);
               byte var20 = var4.b();
               byte var10001 = 15;

               while(true) {
                  y.c.e var5;
                  y.c.d var6;
                  if(var20 == var10001) {
                     var5 = (new y.c.f(var3.k())).a();

                     dg var8;
                     y.c.q var9;
                     while(true) {
                        if(var5.f()) {
                           var6 = var5.a();
                           this.c.a(var6);
                           var8 = this.f(var4.l());
                           var9 = var8.f;
                           Rectangle2D var10 = var8.w;
                           y.c.D var11 = this.b.m(var6);
                           var10000 = var1;
                           if(var14) {
                              break;
                           }

                           if(!var1) {
                              this.a(var11, false, true, new y.d.y(var10.getX(), var10.getY(), var10.getWidth(), var10.getHeight()));
                           }

                           this.b.a(var6, var6.c(), var9);
                           this.b.a(var6, var11);
                           var5.g();
                           if(!var14) {
                              continue;
                           }
                        }

                        var5 = (new y.c.f(var3.l())).a();
                        var10000 = var5.f();
                        break;
                     }

                     while(var10000) {
                        var6 = var5.a();
                        this.c.a(var6);
                        var8 = this.f(var4.l());
                        var9 = var8.f;
                        y.c.D var16 = this.b.m(var6);
                        Rectangle2D var18 = var8.w;
                        this.b.a(var6, var9, var6.d());
                        var10000 = var1;
                        if(var14) {
                           continue label104;
                        }

                        if(!var1) {
                           this.a(var16, true, false, new y.d.y(var18.getX(), var18.getY(), var18.getWidth(), var18.getHeight()));
                        }

                        this.b.a(var6, var16);
                        var5.g();
                        if(var14) {
                           break;
                        }

                        var10000 = var5.f();
                     }

                     this.b.a((y.c.q)var3);
                     if(!var14) {
                        break label104;
                     }
                  }

                  if(var4.b() != 12 && var4.b() != 13) {
                     break label104;
                  }

                  var5 = (new y.c.f(var3.j())).a();

                  while(true) {
                     if(!var5.f()) {
                        break label104;
                     }

                     var6 = var5.a();
                     y.c.q var7 = var6.a(var3);
                     this.c.a(var7);
                     A var15 = this.c.a(var6);
                     var20 = var15.a();
                     var10001 = 6;
                     if(var14) {
                        break;
                     }

                     if(var20 != 6) {
                        label122: {
                           dg var17 = this.f(var4.l());
                           y.c.q var19 = var17.f;
                           y.c.D var12;
                           Rectangle2D var13;
                           if(var6.d() == var3) {
                              var12 = this.b.m(var6);
                              var13 = var17.w;
                              if(!var1) {
                                 this.a(var12, false, true, new y.d.y(var13.getX(), var13.getY(), var13.getWidth(), var13.getHeight()));
                              }

                              this.b.a(var6, var6.c(), var19);
                              this.b.a(var6, var12);
                              if(!var14) {
                                 break label122;
                              }
                           }

                           if(var6.c() == var3) {
                              var12 = this.b.m(var6);
                              var13 = var17.w;
                              this.b.a(var6, var19, var6.d());
                              if(!var1) {
                                 this.a(var12, true, false, new y.d.y(var13.getX(), var13.getY(), var13.getWidth(), var13.getHeight()));
                              }

                              this.b.a(var6, var12);
                           }
                        }
                     }

                     var5.g();
                     if(var14) {
                        break label104;
                     }
                  }
               }
            }

            var2.g();
         } while(!var14);

      }
   }

   void n(aU var1) {
      boolean var10 = N.x;
      if(this.k()) {
         int var2 = 0;

         E var10000;
         while(true) {
            if(var2 < var1.b()) {
               var10000 = this;
               if(var10) {
                  break;
               }

               this.j.a((aQ)var1.a(var2), (y.f.X)this.b);
               ++var2;
               if(!var10) {
                  continue;
               }
            }

            var10000 = this;
            break;
         }

         y.d.q var11 = var10000.l();
         if(var11 != null) {
            y.c.x var3 = this.b.o();

            while(var3.f()) {
               y.c.q var4 = var3.e();
               byte var5 = this.c.a(var4).b();
               byte var13 = var5;
               byte var10001 = 12;

               label47: {
                  int var6;
                  label46:
                  while(true) {
                     if(var13 != var10001 && var5 != 13) {
                        break label47;
                     }

                     var6 = 0;
                     y.c.e var7 = var4.j();

                     while(true) {
                        if(!var7.f()) {
                           break label46;
                        }

                        y.c.d var8 = var7.a();
                        byte var9 = this.c.a(var8).a();
                        var13 = var9;
                        var10001 = 6;
                        if(var10) {
                           break;
                        }

                        if(var9 != 6) {
                           ++var6;
                        }

                        var7.g();
                        if(var10) {
                           break label46;
                        }
                     }
                  }

                  double var12 = Math.max((double)var6 * var11.b, this.b.q(var4));
                  this.b.a(var4, new y.d.q(this.b.p(var4), var12));
               }

               var3.g();
               if(var10) {
                  break;
               }
            }
         }

      }
   }

   void o(aU var1) {
      boolean var9 = N.x;
      if(this.k()) {
         int var2 = 0;

         do {
            int var10000 = var2;

            label33:
            while(true) {
               if(var10000 >= var1.b()) {
                  return;
               }

               aQ var3 = var1.a(var2);
               int var4 = 0;
               y.c.p var5 = var3.d().k();

               while(true) {
                  if(var5 == null) {
                     break label33;
                  }

                  y.c.q var6 = (y.c.q)var5.c();
                  aX var7 = this.c.a(var6);
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
                     break label33;
                  }
               }
            }

            ++var2;
         } while(!var9);

      }
   }

   void a(y.c.D var1, boolean var2, boolean var3, y.d.y var4) {
      boolean var8 = N.x;
      if(var1.size() >= 2) {
         boolean var10000;
         y.c.D var5;
         y.d.t var6;
         y.d.t var7;
         label66: {
            var5 = new y.c.D(var1.m());
            if(var2) {
               var6 = null;
               var7 = null;

               label62: {
                  do {
                     if(var1.isEmpty()) {
                        break label62;
                     }

                     var10000 = var4.a((y.d.t)var1.f());
                     if(var8) {
                        break label66;
                     }

                     if(!var10000) {
                        break;
                     }

                     var6 = (y.d.t)var1.g();
                  } while(!var8);

                  var7 = (y.d.t)var1.f();
               }

               if(var6 != null) {
                  var1.a((Object)this.a(var6, var7, var4));
               }
            }

            var10000 = var3;
         }

         int var9;
         label49: {
            if(var10000) {
               var6 = null;
               var7 = null;

               label45: {
                  do {
                     if(var1.isEmpty()) {
                        break label45;
                     }

                     var9 = var4.a((y.d.t)var1.i());
                     if(var8) {
                        break label49;
                     }

                     if(var9 == 0) {
                        break;
                     }

                     var6 = (y.d.t)var1.j();
                  } while(!var8);

                  var7 = (y.d.t)var1.i();
               }

               if(var6 != null) {
                  var1.b((Object)this.a(var6, var7, var4));
               }
            }

            var9 = var1.size();
         }

         if(var9 < 2) {
            var1.clear();
            var1.a(var5);
         }

      }
   }

   private static boolean a(y.d.t var0, y.d.t var1) {
      double var2 = Math.abs(var0.a - var1.a);
      double var4 = Math.abs(var0.b - var1.b);
      return Math.abs(var2 - var4) < 0.001D;
   }

   private y.d.t a(y.d.t var1, y.d.t var2, y.d.y var3) {
      boolean var8 = N.x;
      if(var1 != null && var2 != null) {
         if(a(var1, var2)) {
            return y.d.n.b(new y.d.n(var3), new y.d.m(var1, var2), 0.001D);
         } else {
            double var4;
            double var6;
            label29: {
               var4 = var1.a();
               var6 = var1.b();
               if(var2.a < var3.c()) {
                  var4 = var3.c();
                  if(!var8) {
                     break label29;
                  }
               }

               if(var2.a > var3.c() + var3.a()) {
                  var4 = var3.c() + var3.a();
               }
            }

            if(var2.b < var3.d()) {
               var6 = var3.d();
               if(!var8) {
                  return new y.d.t(var4, var6);
               }
            }

            if(var2.b > var3.d() + var3.b()) {
               var6 = var3.d() + var3.b();
            }

            return new y.d.t(var4, var6);
         }
      } else {
         return null;
      }
   }

   public void d(aU var1, aP var2) {
      boolean var11 = N.x;
      if(this.k()) {
         byte var3 = 0;
         int var4 = 0;

         byte var12;
         label63:
         while(true) {
            int var10000 = var4;
            int var10001 = var1.b();

            label60:
            while(var10000 < var10001) {
               aQ var5 = var1.a(var4);
               var12 = var5.e();
               if(var11) {
                  break label63;
               }

               if(var12 == 1) {
                  var3 = 1;
                  Object var6 = this.j;
                  y.c.D var7 = new y.c.D();
                  var7.add(var6);
                  y.c.p var8 = var5.d().k();

                  while(var8 != null) {
                     y.c.q var9 = (y.c.q)var8.c();
                     as var10 = (as)this.c.a(var9);
                     var10000 = var10.b();
                     var10001 = 1;
                     if(var11) {
                        continue label60;
                     }

                     label72: {
                        if(var10000 == 1 || var10.b() == 4) {
                           var10.a(((dg)var6).f);
                           ((dg)var6).b((Object)var9);
                           this.j.a(((dg)var6).f, var10);
                           if(!var11) {
                              break label72;
                           }
                        }

                        if(var10.b() == 12) {
                           var6 = this.f(var10.l());
                           var7.c(var6);
                           if(!var11) {
                              break label72;
                           }
                        }

                        if(var10.b() == 13) {
                           var7.g();
                           var6 = (dg)var7.h();
                        }
                     }

                     var8 = var8.a();
                     if(var11) {
                        break;
                     }
                  }
               }

               ++var4;
               if(!var11) {
                  continue label63;
               }
               break;
            }

            var12 = var3;
            break;
         }

         if(var12 != 0) {
            this.d(var1);
            this.o(var1);
         }

      }
   }

   boolean e(y.c.q var1) {
      byte var2 = this.c.a(var1).b();
      return var2 == 12 || var2 == 13;
   }

   double a(cr var1, double var2, double var4) {
      if(this.k()) {
         y.d.c var6 = var1.c().a(false, false);
         y.d.c var7 = var1.b().a(false, false);
         double var8 = var6.c(var7);
         if(var8 < var2) {
            double var10 = var2 - var8;
            var1.e(var10);
            var4 += var10;
         }
      }

      return var4;
   }

   void a(y.c.D[] var1, int[] var2, int[] var3) {
      boolean var10 = N.x;
      int[] var4 = new int[this.j.d.size()];
      int[] var5 = new int[this.j.d.size()];
      H var6 = new H(this, var2, var4, var5);
      int var7 = 0;

      while(true) {
         if(var7 < this.j.d.size()) {
            ArrayList var10000 = this.j.d;
            if(var10) {
               break;
            }

            dg var8 = (dg)var10000.get(var7);
            var8.u = var7++;
            if(!var10) {
               continue;
            }
         }

         new ArrayList();
         break;
      }

      int var11 = 0;

      while(var11 < var1.length) {
         dd var9 = this.j;
         this.a(var9, var2, var11, var4, var5);
         var3[var11] += this.a(var9, var11, var2, var4, var5, var6, 0);
         ++var11;
         if(var10) {
            break;
         }
      }

   }

   private int a(dg var1, int var2, int[] var3, int[] var4, int[] var5, Comparator var6, int var7) {
      boolean var17 = N.x;
      da var8 = var1.b(var2);
      ArrayList var9 = new ArrayList(var8);
      y.g.e.a((List)var9, var6);
      int var10 = 0;

      int var10000;
      while(true) {
         if(var10 < var9.size()) {
            Object var11 = var9.get(var10);
            var10000 = var11 instanceof dg;
            if(var17) {
               break;
            }

            label64: {
               if(var10000 != 0) {
                  dg var12 = (dg)var11;
                  boolean var13 = var4[var12.u] != var5[var12.u];
                  Object var14;
                  y.c.q var15;
                  if(var13 && var10 > 0) {
                     label79: {
                        var14 = var9.get(var10 - 1);
                        if(var14 instanceof y.c.q) {
                           var15 = (y.c.q)var14;
                           int var16 = var3[var15.d()] - var7;
                           if(var16 != -1 && var16 != var4[var12.u]) {
                              break label79;
                           }

                           ++var7;
                           if(!var17) {
                              break label79;
                           }
                        }

                        if(var4[((dg)var14).u] == var5[var12.u]) {
                           ++var7;
                        }
                     }
                  }

                  var7 = this.a(var12, var2, var3, var4, var5, var6, var7);
                  if(!var13 || var10 >= var9.size() - 1) {
                     break label64;
                  }

                  var14 = var9.get(var10 + 1);
                  if(var14 instanceof y.c.q) {
                     var15 = (y.c.q)var14;
                     if(var3[var15.d()] > var5[var12.u]) {
                        break label64;
                     }

                     ++var7;
                     if(!var17) {
                        break label64;
                     }
                  }

                  if(var4[((dg)var14).u] > var5[var12.u]) {
                     break label64;
                  }

                  ++var7;
                  if(!var17) {
                     break label64;
                  }
               }

               y.c.q var18 = (y.c.q)var11;
               int var19 = var3[var18.d()];
               if(var19 >= 0) {
                  var19 += var7;
                  var3[var18.d()] = var19;
               }
            }

            ++var10;
            if(!var17) {
               continue;
            }
         }

         var10000 = var7;
         break;
      }

      return var10000;
   }

   private void a(dg var1, int[] var2, int var3, int[] var4, int[] var5) {
      boolean var10 = N.x;
      var4[var1.u] = Integer.MAX_VALUE;
      var5[var1.u] = -1;
      da var6 = var1.b(var3);
      y.c.p var7 = var6.k();

      while(var7 != null) {
         label26: {
            int var9;
            if(var7.c() instanceof dg) {
               dg var8 = (dg)var7.c();
               this.a(var8, var2, var3, var4, var5);
               var9 = var4[var8.u];
               if(var9 >= 0) {
                  var4[var1.u] = Math.min(var4[var1.u], var9);
               }

               var9 = var5[var8.u];
               if(var9 < 0) {
                  break label26;
               }

               var5[var1.u] = Math.max(var5[var1.u], var9);
               if(!var10) {
                  break label26;
               }
            }

            y.c.q var11 = (y.c.q)var7.c();
            var9 = var2[var11.d()];
            if(var9 >= 0) {
               var4[var1.u] = Math.min(var4[var1.u], var9);
               var5[var1.u] = Math.max(var5[var1.u], var9);
            }
         }

         var7 = var7.a();
         if(var10) {
            break;
         }
      }

   }

   dg f(y.c.q var1) {
      if(!this.k()) {
         return null;
      } else {
         dg var2 = (dg)this.j.c.b(var1);
         return var2;
      }
   }

   public boolean k() {
      return this.j.a();
   }

   public void a(y.c.q var1, J var2) {
      if(this.k()) {
         dg var3 = this.f(var1);
         this.a(var3, var2);
      }
   }

   private void a(dg var1, J var2) {
      boolean var6 = N.x;
      if(this.k()) {
         Iterator var3 = var1.f().iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            if(var4 instanceof y.c.q) {
               var2.a((y.c.q)var4, var1.f);
               if(!var6) {
                  continue;
               }
            }

            if(var4 instanceof dg) {
               dg var5 = (dg)var4;
               this.a(var5, var2);
               if(var6) {
                  break;
               }
            }
         }

      }
   }

   public y.c.y g(y.c.q var1) {
      if(!this.k()) {
         return null;
      } else {
         y.c.y var2 = new y.c.y();
         this.a((dg)this.f(var1), (J)(new I(this, var2)));
         return var2;
      }
   }

   public y.c.y h(y.c.q var1) {
      boolean var7 = N.x;
      if(!this.k()) {
         return null;
      } else {
         dg var2 = this.f(var1);
         y.c.y var3 = new y.c.y();
         Iterator var4 = var2.f().iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            if(var5 instanceof y.c.q) {
               var3.add(var5);
               if(!var7) {
                  continue;
               }
            }

            dg var6 = (dg)var5;
            var3.add(var6.f);
            if(var7) {
               break;
            }
         }

         return var3;
      }
   }

   public y.c.q i(y.c.q var1) {
      return !this.k()?null:this.j.a((Object)var1).f;
   }

   public boolean a(y.c.q var1, y.c.q var2) {
      boolean var4 = N.x;
      y.c.q var3 = this.i(var1);

      y.c.q var10000;
      while(true) {
         if(var2 != var3) {
            var10000 = var3;
            if(var4) {
               break;
            }

            if(var3 != null) {
               var3 = this.i(var3);
               if(!var4) {
                  continue;
               }
            }
         }

         var10000 = var3;
         break;
      }

      return var10000 == var2;
   }
}
