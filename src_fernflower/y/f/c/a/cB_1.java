package y.f.c.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.cC;

class cB {
   private static final Object a = "y.layout.hierarchic.incremental.EdgeLabelingSupport.InstanceDPKey";
   private static final Comparator b = new cC(false);
   private boolean c = false;
   private y.f.F d;

   public cB(y.f.F var1) {
      this.d = var1;
      this.c = true;
   }

   static void a(cB var0, y.c.i var1) {
      var1.a(a, y.g.q.a((Object)var0));
   }

   static void a(y.c.i var0) {
      if(var0 != null && var0.c(a) != null) {
         var0.d_(a);
      }

   }

   static cB b(y.c.i var0) {
      y.c.c var1 = var0.c(a);
      return var1 == null?null:(cB)var1.b(var0);
   }

   public List a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var23 = N.x;
      if(!this.b(var1)) {
         return null;
      } else {
         ArrayList var5 = new ArrayList(60);
         y.c.c var6 = this.a(var1);
         int var7 = 0;

         aX var12;
         y.c.d var13;
         y.f.S[] var15;
         int var10000;
         while(true) {
            if(var7 < var2.b()) {
               aQ var8 = var2.a(var7);
               var10000 = this.c;
               if(var23) {
                  break;
               }

               boolean var9 = var10000 == 0;
               y.c.p var10 = var8.d().k();

               boolean var30;
               label181: {
                  while(var10 != null) {
                     var30 = var9;
                     if(var23) {
                        break label181;
                     }

                     if(var9) {
                        break;
                     }

                     y.c.q var11 = (y.c.q)var10.c();
                     var12 = var3.a(var11);
                     if(var12.b() != 1) {
                        var13 = var11.f();

                        while(var13 != null) {
                           var30 = var9;
                           if(var23) {
                              break label181;
                           }

                           if(var9) {
                              break;
                           }

                           label172: {
                              aX var14 = var3.a(var13.d());
                              if(var14.b() == 1) {
                                 var15 = (y.f.S[])var6.b(var14.g());
                                 if(!var23) {
                                    break label172;
                                 }
                              }

                              var15 = (y.f.S[])var6.b(var13);
                           }

                           if(var15 != null && var15.length > 0) {
                              var9 = true;
                              if(!var23) {
                                 break;
                              }
                           }

                           var13 = var13.g();
                           if(var23) {
                              break;
                           }
                        }
                     }

                     var10 = var10.a();
                     if(var23) {
                        break;
                     }
                  }

                  var30 = this.c;
               }

               if((!var30 || var9) && var7 < var2.b() - 1) {
                  ++var7;
                  var5.add(var4.a(true, var7));
               }

               ++var7;
               if(!var23) {
                  continue;
               }
            }

            var10000 = var2.b();
            break;
         }

         y.c.q[] var24 = new y.c.q[var10000];
         y.c.A var25 = var1.t();
         var1.a((Object)(this.getClass().getName() + ".map"), (y.c.c)var25);
         y.c.e var26 = var1.p();

         label138:
         while(true) {
            byte var31 = var26.f();

            label135:
            while(var31 != 0) {
               y.c.d var27 = var26.a();
               aX var28 = var3.a(var27.c());
               var12 = var3.a(var27.d());
               if(var23) {
                  return var5;
               }

               if(var28.b() != 1 && var12.b() == 1) {
                  var13 = var12.g();
                  A var29 = var3.a(var13);
                  var15 = this.a(var1, var13);
                  if(var15 != null && var15.length > 0) {
                     int var16 = 0;
                     y.c.d var17 = var27;
                     aX var18 = var3.a(var27.d());

                     y.c.q var19;
                     while(var18.b() == 1) {
                        var19 = var17.d();
                        byte var20 = var2.a(var18.j()).e();
                        var31 = var20;
                        if(var23) {
                           continue label135;
                        }

                        if(var20 == 0 || var20 == 1) {
                           var24[var16++] = var19;
                        }

                        var17 = var19.f();
                        var18 = var3.a(var17.d());
                        if(var23) {
                           break;
                        }
                     }

                     var19 = null;
                     if(var16 < 1) {
                        throw new IllegalStateException("Did not find edge label position");
                     }

                     boolean var32 = var29.i();
                     int var21 = 0;

                     while(var21 < var15.length) {
                        y.f.aG var22 = var15[var21].f();
                        var31 = var22.i();
                        if(var23) {
                           continue label135;
                        }

                        label198: {
                           if(var31 != 0) {
                              var19 = var24[var32?var16 - 1:0];
                              if(!var23) {
                                 break label198;
                              }
                           }

                           if(var22.j()) {
                              var19 = var24[var16 / 2];
                              if(!var23) {
                                 break label198;
                              }
                           }

                           if(var22.k()) {
                              var19 = var24[var32?0:var16 - 1];
                              if(!var23) {
                                 break label198;
                              }
                           }

                           if(a(var22) == 0) {
                              var19 = var24[var16 / 2];
                              if(!var23) {
                                 break label198;
                              }
                           }

                           var19 = var24[0];
                        }

                        this.a(var19, var15[var21], var25);
                        ++var21;
                        if(var23) {
                           break;
                        }
                     }
                  }
               }

               var26.g();
               if(!var23) {
                  continue label138;
               }
               break;
            }

            this.a(var1, var3, var25);
            return var5;
         }
      }
   }

   protected y.c.c a(y.f.X var1) {
      return var1.c(y.f.U.a);
   }

   private void a(y.c.q var1, y.f.S var2, y.c.A var3) {
      Object var4 = (List)var3.b(var1);
      if(var4 == null) {
         var4 = new ArrayList(6);
         var3.a(var1, var4);
      }

      ((List)var4).add(var2);
   }

   private void a(y.f.X var1, aV var2, y.c.A var3) {
      boolean var30 = N.x;
      ArrayList var4 = new ArrayList(10);
      ArrayList var5 = new ArrayList(10);
      ArrayList var6 = new ArrayList(10);
      y.c.x var7 = var1.o();

      label189:
      do {
         boolean var10000 = var7.f();

         label186:
         while(var10000) {
            y.c.q var8 = var7.e();
            List var9 = (List)var3.b(var8);
            if(var9 != null) {
               y.f.S[] var10 = (y.f.S[])var9.toArray(new y.f.S[var9.size()]);
               y.c.d var11 = var2.a(var8).g();
               if(var11 == null) {
                  throw new IllegalStateException("realEdge == null: Cannot be!!!");
               }

               A var12 = var2.a(var11);
               byte var13 = var12.i();
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               int var20 = 0;

               int var31;
               label180: {
                  while(var20 < var10.length) {
                     y.f.S var21 = var10[var20];
                     var31 = var13;
                     if(var30) {
                        break label180;
                     }

                     label197: {
                        y.f.y var22 = var13 != 0?y.f.y.a:y.f.y.c;
                        this.d.a(var1, (y.f.S)var21, var22);
                        y.f.aG var23 = var21.f();
                        if(var23.m()) {
                           var18 = Math.max(var18, var21.b());
                           if(!var30) {
                              break label197;
                           }
                        }

                        if((var23.l() ^ var13) != 0) {
                           var14 = Math.max(var14, var21.b() + this.a(var21));
                           if(!var30) {
                              break label197;
                           }
                        }

                        var16 = Math.max(var16, var21.b() + this.a(var21));
                     }

                     ++var20;
                     if(var30) {
                        break;
                     }
                  }

                  double var41;
                  var31 = (var41 = var18 - var14 * 2.0D) == 0.0D?0:(var41 < 0.0D?-1:1);
               }

               if(var31 > 0) {
                  var14 = var18 / 2.0D;
               }

               if(var18 > var16 * 2.0D) {
                  var16 = var18 / 2.0D;
               }

               byte[] var32 = new byte[]{(byte)1, (byte)4, (byte)0, (byte)2};
               double var33 = 0.0D;
               int var34 = 0;

               label159:
               do {
                  var31 = var34;

                  label156:
                  while(true) {
                     int var10001 = var32.length;

                     label123:
                     while(true) {
                        if(var31 >= var10001) {
                           break label159;
                        }

                        var4.clear();
                        var5.clear();
                        var6.clear();
                        var10000 = false;
                        if(var30) {
                           continue label186;
                        }

                        int var24 = 0;

                        while(true) {
                           if(var24 >= var10.length) {
                              break label123;
                           }

                           y.f.S var25 = var10[var24];
                           y.f.aG var26 = var25.f();
                           byte var27 = a(var26);
                           var31 = var27;
                           var10001 = var32[var34];
                           if(var30) {
                              break;
                           }

                           if(var27 == var10001) {
                              label209: {
                                 if(var26.m()) {
                                    var6.add(var25);
                                    if(!var30) {
                                       break label209;
                                    }
                                 }

                                 if((var26.l() ^ var13) != 0) {
                                    var4.add(var25);
                                    if(!var30) {
                                       break label209;
                                    }
                                 }

                                 var5.add(var25);
                              }
                           }

                           ++var24;
                           if(var30) {
                              break label123;
                           }
                        }
                     }

                     double var36 = var33;
                     double var39 = var33;
                     int var28 = 0;

                     y.f.S var29;
                     label135: {
                        while(var28 < var4.size()) {
                           double var42;
                           var31 = (var42 = var36 - 0.0D) == 0.0D?0:(var42 < 0.0D?-1:1);
                           if(var30) {
                              break label135;
                           }

                           if(var31 > 0) {
                              var36 += 10.0D;
                           }

                           var29 = (y.f.S)var4.get(var28);
                           var29.a(var16 + this.a(var29), var36);
                           var36 += var29.c();
                           ++var28;
                           if(var30) {
                              break;
                           }
                        }

                        var31 = 0;
                     }

                     var28 = var31;

                     label147: {
                        while(var28 < var5.size()) {
                           double var43;
                           var31 = (var43 = var39 - 0.0D) == 0.0D?0:(var43 < 0.0D?-1:1);
                           if(var30) {
                              break label147;
                           }

                           if(var31 > 0) {
                              var39 += 10.0D;
                           }

                           var29 = (y.f.S)var5.get(var28);
                           var29.a(var16 - var29.b() - this.a(var29), var39);
                           var39 += var29.c();
                           ++var28;
                           if(var30) {
                              break;
                           }
                        }

                        var33 = Math.max(var36, var39);
                        var31 = 0;
                     }

                     var28 = var31;

                     while(true) {
                        if(var28 >= var6.size()) {
                           break label156;
                        }

                        double var44;
                        var31 = (var44 = var33 - 0.0D) == 0.0D?0:(var44 < 0.0D?-1:1);
                        if(var30) {
                           break;
                        }

                        if(var31 > 0) {
                           var33 += 10.0D;
                        }

                        var29 = (y.f.S)var6.get(var28);
                        var29.a(var16 - var29.b() * 0.5D, var33);
                        var33 += var29.c();
                        ++var28;
                        if(var30) {
                           break label156;
                        }
                     }
                  }

                  ++var34;
               } while(!var30);

               var1.b(var8, var14 + var16, var33);
               y.d.t var35 = new y.d.t(var16 - (var14 + var16) * 0.5D, -var33 * 0.5D);
               var1.b(var8.g(), var35);
               y.d.t var38 = new y.d.t(var16 - (var14 + var16) * 0.5D, var33 * 0.5D);
               var1.a(var8.f(), var38);
               if(var13 != 0) {
                  int var37 = 0;

                  while(var37 < var10.length) {
                     y.f.S var40 = var10[var37];
                     var40.a(var40.d(), var33 - var40.c() - var40.e());
                     ++var37;
                     if(var30) {
                        continue label189;
                     }

                     if(var30) {
                        break;
                     }
                  }
               }
            }

            var7.g();
            continue label189;
         }

         return;
      } while(!var30);

   }

   public y.f.S[] a(y.f.X var1, y.c.d var2) {
      y.c.c var3 = this.a(var1);
      return var3 == null?null:(y.f.S[])var3.b(var2);
   }

   private y.f.S[] a(y.c.q var1, y.c.A var2) {
      List var3 = (List)var2.b(var1);
      if(var3 != null) {
         y.f.S[] var4 = (y.f.S[])var3.toArray(new y.f.S[var3.size()]);
         return var4;
      } else {
         return null;
      }
   }

   private boolean b(y.f.X var1) {
      y.c.c var2 = this.a(var1);
      return var2 != null;
   }

   public void a(y.f.X var1, aU var2, aV var3, aP var4, List var5) {
      boolean var21 = N.x;
      if(this.b(var1)) {
         String var6 = this.getClass().getName() + ".map";
         y.c.A var7 = (y.c.A)var1.c(var6);
         var1.d_(var6);
         y.c.x var8 = var1.o();

         while(var8.f()) {
            label53: {
               y.c.q var9 = var8.e();
               y.f.S[] var10 = this.a(var9, var7);
               if(var10 != null && var10.length > 0) {
                  y.c.d var11 = var3.a(var9).g();
                  if(var11 == null) {
                     throw new IllegalStateException("realEdge == null: Cannot be!!!");
                  }

                  y.f.am var12 = var1.h(var9);
                  double var13 = var12.getX();
                  double var15 = var12.getY();
                  int var17 = 0;

                  while(var17 < var10.length) {
                     y.f.S var18 = var10[var17];
                     var18.a(var18.d() + var13, var18.e() + var15);
                     this.d.a((y.c.i)var1, (y.f.S)var18);
                     ++var17;
                     if(var21) {
                        break label53;
                     }

                     if(var21) {
                        break;
                     }
                  }

                  double var24 = var1.q(var9.g()).a;
                  double var19 = var1.k(var9);
                  var12.setSize(0.0D, 0.0D);
                  var1.a(var9.f(), y.d.t.c);
                  var1.b(var9.g(), y.d.t.c);
                  var12.setLocation(var24, var19);
               }

               var8.g();
            }

            if(var21) {
               break;
            }
         }

         int var22 = 0;

         while(true) {
            if(var22 < var5.size()) {
               aQ var23 = (aQ)var5.get(var22);
               var23.a();
               ++var22;
               if(var21) {
                  break;
               }

               if(!var21) {
                  continue;
               }
            }

            var1.a((y.c.A)var7);
            break;
         }

      }
   }

   boolean a(y.c.d var1, y.d.v var2) {
      y.d.m var3 = var2.a(0);
      return !var1.e() || !var3.b() || var2.i() != 3;
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var12 = N.x;
      y.c.e var4 = var1.p();

      while(var4.f()) {
         label94: {
            y.c.d var5 = var4.a();
            if(var5.e()) {
               y.f.S[] var6 = this.a(var1, var5);
               if(var6 != null && var6.length > 0) {
                  int var10;
                  byte var14;
                  label89: {
                     y.d.v var7 = var1.l(var5);
                     int var8 = var7.i();
                     boolean var9 = this.a(var5, var7);
                     if(var8 >= 3) {
                        var10 = 1;

                        y.d.m var11;
                        int var10000;
                        label85: {
                           while(var10 < var8 - 1) {
                              var11 = var7.a(var10);
                              var10000 = var11.b();
                              if(var12) {
                                 break label85;
                              }

                              if(var10000 != 0 && var9) {
                                 this.a(var11, var6, true, true, var1);
                                 if(!var12) {
                                    break;
                                 }
                              }

                              if(var11.a() && !var9) {
                                 this.a(var11, var6, true, var1);
                                 if(!var12) {
                                    break;
                                 }
                              }

                              ++var10;
                              if(var12) {
                                 break;
                              }
                           }

                           var10000 = var8 - 2;
                        }

                        var10 = var10000;

                        while(var10 > 0) {
                           var11 = var7.a(var10);
                           var14 = var11.b();
                           if(var12) {
                              break label89;
                           }

                           if(var14 != 0 && var9) {
                              this.a(var11, var6, false, false, var1);
                              if(!var12) {
                                 break;
                              }
                           }

                           if(var11.a() && !var9) {
                              this.a(var11, var6, false, var1);
                              if(!var12) {
                                 break;
                              }
                           }

                           --var10;
                           if(var12) {
                              break;
                           }
                        }
                     }

                     var14 = 0;
                  }

                  var10 = var14;

                  while(var10 < var6.length) {
                     y.f.S var13 = var6[var10];
                     this.d.a((y.c.i)var1, (y.f.S)var13);
                     ++var10;
                     if(var12) {
                        break label94;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }
            }

            var4.g();
         }

         if(var12) {
            break;
         }
      }

   }

   private boolean a(y.d.v var1, boolean var2) {
      int var3 = var1.h() - 1;
      if(var3 != 3 && (!var2 || var3 != 5)) {
         return false;
      } else {
         y.d.m var4 = var1.a(0);
         y.d.m var5 = var1.a(var3 - 1);
         return var4.b() && var5.b();
      }
   }

   public void b(y.f.X var1, aU var2, aV var3) {
      boolean var16 = N.x;
      int var4 = 0;

      while(var4 < var2.b()) {
         aQ var5 = var2.a(var4);
         y.c.p var6 = var5.f().k();

         while(true) {
            if(var6 != null) {
               y.c.d var7 = (y.c.d)var6.c();
               y.f.S[] var8 = this.a(var1, var7);
               if(var16) {
                  break;
               }

               label97: {
                  if(var8 != null && var8.length > 0) {
                     y.d.v var9;
                     int var14;
                     y.d.m var15;
                     boolean var10000;
                     label92: {
                        boolean var13;
                        label112: {
                           var9 = var1.l(var7);
                           B var10 = var3.a(var7).k();
                           byte var11 = var10.h().d();
                           boolean var12 = var11 != 0;
                           var13 = this.a(var9, var12);
                           if(var13) {
                              this.a(var9.a(0), var8, true, false, var1);
                              if(!var16) {
                                 break label112;
                              }
                           }

                           var14 = 1;

                           while(var14 < var9.i()) {
                              var15 = var9.a(var14);
                              var10000 = var15.b();
                              if(var16) {
                                 break label92;
                              }

                              if(var10000) {
                                 this.a(var15, var8, true, true, var1);
                                 if(!var16) {
                                    break;
                                 }
                              }

                              ++var14;
                              if(var16) {
                                 break;
                              }
                           }
                        }

                        var10000 = var13;
                     }

                     byte var18;
                     label74: {
                        label114: {
                           if(var10000) {
                              this.a(var9.a(var9.i() - 1), var8, false, true, var1);
                              if(!var16) {
                                 break label114;
                              }
                           }

                           var14 = var9.i() - 2;

                           while(var14 >= 0) {
                              var15 = var9.a(var14);
                              var18 = var15.b();
                              if(var16) {
                                 break label74;
                              }

                              if(var18 != 0) {
                                 this.a(var15, var8, false, false, var1);
                                 if(!var16) {
                                    break;
                                 }
                              }

                              --var14;
                              if(var16) {
                                 break;
                              }
                           }
                        }

                        var18 = 0;
                     }

                     var14 = var18;

                     while(var14 < var8.length) {
                        y.f.S var17 = var8[var14];
                        this.d.a((y.c.i)var1, (y.f.S)var17);
                        ++var14;
                        if(var16) {
                           break label97;
                        }

                        if(var16) {
                           break;
                        }
                     }
                  }

                  var6 = var6.a();
               }

               if(!var16) {
                  continue;
               }
            }

            ++var4;
            break;
         }

         if(var16) {
            break;
         }
      }

   }

   private void a(y.d.m var1, y.f.S[] var2, boolean var3, y.f.X var4) {
      boolean var29 = N.x;
      y.d.t var5 = var1.c();
      y.d.t var6 = var1.d();
      y.f.S[] var7 = new y.f.S[var2.length];
      int var8 = 0;

      while(true) {
         if(var8 < var2.length) {
            var7[var8] = var2[var8];
            ++var8;
            if(var29) {
               break;
            }

            if(!var29) {
               continue;
            }
         }

         this.a(var7);
         break;
      }

      y.f.y var30 = var1.k() > 0.0D?y.f.y.c:y.f.y.a;
      boolean var9 = var30 == y.f.y.c && var3 || var30 == y.f.y.a && !var3;
      double var10 = var5.a();
      double var12 = var9?Math.min(var5.b(), var6.b()) + 10.0D:Math.max(var5.b(), var6.b()) - 10.0D;
      double var14 = var12;
      double var16 = var12;
      double var18 = -1.0D;
      int var20 = var3?0:var7.length - 1;

      do {
         label119: {
            int var10000;
            if(var3) {
               var10000 = var20;
               if(!var29) {
                  if(var20 >= var7.length) {
                     break;
                  }
                  break label119;
               }
            } else {
               var10000 = var20;
            }

            if(var10000 < 0) {
               break;
            }
         }

         y.f.S var21 = var7[var20];
         y.f.aG var22 = var21.f();
         if((double)var22.a() != var18) {
            var14 = var16 = var9?Math.max(var14, var16):Math.min(var14, var16);
            var18 = (double)var22.a();
         }

         if((!var3 || !var22.k()) && (var3 || var22.k())) {
            label172: {
               double var23 = var21.b();
               double var25 = var21.c();
               double var27;
               if(var22.l() || var22.n()) {
                  if(this.a(var22, var30)) {
                     var27 = var9?var14:var14 - var25;
                     var21.a(var10 - var23 - this.a(var21), var27);
                     var14 += (var25 + 10.0D) * (double)(var9?1:-1);
                     if(!var29) {
                        break label172;
                     }
                  }

                  var27 = var9?var16:var16 - var25;
                  var21.a(var10 + this.a(var21), var27);
                  var16 += (var25 + 10.0D) * (double)(var9?1:-1);
                  if(!var29) {
                     break label172;
                  }
               }

               var27 = var9?Math.max(var14, var16):Math.min(var14, var16) - var25;
               var21.a(var10 - var23 * 0.5D, var27);
               var27 += var9?var25 + 10.0D:-10.0D;
               var16 = var27;
               var14 = var27;
            }
         }

         var20 += var3?1:-1;
      } while(!var29);

   }

   private void a(y.f.S[] var1) {
      y.g.e.a((Object[])var1, b);
   }

   private void a(List var1) {
      y.g.e.a(var1, b);
   }

   private void a(y.d.m var1, y.f.S[] var2, boolean var3, boolean var4, y.f.X var5) {
      boolean var31 = N.x;
      y.d.t var6 = var1.c();
      y.d.t var7 = var1.d();
      y.f.S[] var8 = new y.f.S[var2.length];
      int var9 = 0;

      while(true) {
         if(var9 < var2.length) {
            var8[var9] = var2[var9];
            ++var9;
            if(var31) {
               break;
            }

            if(!var31) {
               continue;
            }
         }

         this.a(var8);
         break;
      }

      y.f.y var32 = var1.j() > 0.0D?y.f.y.b:y.f.y.d;
      boolean var10 = var32 == y.f.y.b && var4 || var32 == y.f.y.d && !var4;
      double var11 = var6.b();
      double var13 = var10?Math.min(var6.a(), var7.a()) + 10.0D:Math.max(var6.a(), var7.a()) - 10.0D;
      double var15 = var13;
      double var17 = var13;
      boolean var19 = var3 && var4 || !var3 && !var4;
      double var20 = -1.0D;
      int var22 = var19?0:var8.length - 1;

      do {
         label124: {
            int var10000;
            if(var19) {
               var10000 = var22;
               if(!var31) {
                  if(var22 >= var8.length) {
                     break;
                  }
                  break label124;
               }
            } else {
               var10000 = var22;
            }

            if(var10000 < 0) {
               break;
            }
         }

         y.f.S var23 = var8[var22];
         y.f.aG var24 = var23.f();
         if((double)var24.a() != var20) {
            var15 = var17 = var10?Math.max(var15, var17):Math.min(var15, var17);
            var20 = (double)var24.a();
         }

         if((!var3 || !var24.k()) && (var3 || var24.k())) {
            label191: {
               double var25 = var23.b();
               double var27 = var23.c();
               double var29;
               if(var24.l() || var24.n()) {
                  if(this.a(var24, var32)) {
                     var29 = var10?var15:var15 - var25;
                     var23.a(var29, var11 - var27 - this.a(var23));
                     var15 += (var25 + 10.0D) * (double)(var10?1:-1);
                     if(!var31) {
                        break label191;
                     }
                  }

                  var29 = var10?var17:var17 - var25;
                  var23.a(var29, var11 + this.a(var23));
                  var17 += (var25 + 10.0D) * (double)(var10?1:-1);
                  if(!var31) {
                     break label191;
                  }
               }

               var29 = var10?Math.max(var15, var17):Math.min(var15, var17) - var25;
               var23.a(var29, var11 - var27 * 0.5D);
               var29 += var10?var25 + 10.0D:-10.0D;
               var17 = var29;
               var15 = var29;
            }
         }

         var22 += var19?1:-1;
      } while(!var31);

   }

   private boolean a(y.f.aG var1, y.f.y var2) {
      return var1.l() && (var2 == y.f.y.a || var2 == y.f.y.b) || var1.n() && (var2 == y.f.y.c || var2 == y.f.y.d);
   }

   public y.d.q a(y.f.X var1, y.c.d var2, byte var3, double[] var4, boolean var5, boolean var6) {
      return this.a(var1, var2, var3, var4, var5, var6, (byte)0);
   }

   public y.d.q a(y.f.X var1, y.c.d var2, byte var3, double[] var4, boolean var5, boolean var6, byte var7) {
      double[] var11;
      double[] var12;
      byte var10000;
      boolean var25;
      label238: {
         var25 = N.x;
         y.f.y var10 = var5 != 0?(var6?y.f.y.b:y.f.y.d):(var6?y.f.y.c:y.f.y.a);
         var11 = new double[]{0.0D, 0.0D};
         var12 = new double[]{0.0D, 0.0D};
         y.f.S[] var13 = this.a(var1, var2);
         if(var13 != null && var13.length > 0) {
            ArrayList var14 = new ArrayList();
            int var15 = 0;

            label233: {
               while(var15 < var13.length) {
                  y.f.S var16 = var13[var15];
                  y.f.aG var17 = var16.f();
                  var10000 = var7;
                  if(var25) {
                     break label233;
                  }

                  if(var7 == 0 || var7 == 2 && var17.i() || var17.j() || var7 == 1 && !var17.i() && !var17.j()) {
                     var14.add(var16);
                     this.d.a(var1, (y.f.S)var16, var10);
                  }

                  ++var15;
                  if(var25) {
                     break;
                  }
               }

               this.a((List)var14);
               var10000 = -1;
            }

            byte var27 = var10000;
            Iterator var28 = var14.iterator();

            label208:
            do {
               y.f.S var30;
               do {
                  double var31;
                  while(true) {
                     while(true) {
                        if(!var28.hasNext()) {
                           break label208;
                        }

                        var30 = (y.f.S)var28.next();
                        y.f.aG var18 = var30.f();
                        var10000 = var18.a();
                        if(var25) {
                           break label238;
                        }

                        if(var10000 != var27) {
                           label149: {
                              if(var5 != 0) {
                                 var11[0] = var11[1] = Math.max(var11[0], var11[1]);
                                 if(!var25) {
                                    break label149;
                                 }
                              }

                              var12[0] = var12[1] = Math.max(var12[0], var12[1]);
                           }

                           var27 = var18.a();
                        }

                        boolean var19 = !var18.l() && !var18.n();
                        if(var19) {
                           break;
                        }

                        boolean var20 = this.a(var18, var10);
                        int var21 = var20?0:1;
                        int var22 = var20?0:1;
                        double var23;
                        if(var3 == 0) {
                           label173: {
                              if(var11[var21] > 0.0D) {
                                 var11[var21] += 10.0D;
                                 if(!var25) {
                                    break label173;
                                 }
                              }

                              if(var5 == 0) {
                                 var11[var21] += this.a(var30);
                              }
                           }

                           var11[var21] += var30.b();
                           var23 = var30.c();
                           if(var5 != 0) {
                              var23 += this.a(var30);
                           }

                           var12[var22] = Math.max(var12[var22], var23);
                           if(!var25) {
                              continue;
                           }
                        }

                        label168: {
                           if(var12[var22] > 0.0D) {
                              var12[var22] += 10.0D;
                              if(!var25) {
                                 break label168;
                              }
                           }

                           if(var5 != 0) {
                              var12[var22] += this.a(var30);
                           }
                        }

                        var12[var22] += var30.c();
                        var23 = var30.b();
                        if(var5 == 0) {
                           var23 += this.a(var30);
                        }

                        var11[var21] = Math.max(var11[var21], var23);
                        if(var25) {
                           break;
                        }
                     }

                     if(var3 != 0) {
                        break;
                     }

                     if(var5 != 0) {
                        if(var11[0] > 0.0D) {
                           var11[0] += 10.0D;
                        }

                        if(var11[1] > 0.0D) {
                           var11[1] += 10.0D;
                        }

                        var11[0] += var30.b();
                        var11[1] += var30.b();
                        var12[0] = Math.max(var12[0], var30.c() * 0.5D);
                        var12[1] = Math.max(var12[1], var30.c() * 0.5D);
                        if(!var25) {
                           continue;
                        }
                     }

                     var31 = var30.b() * 0.5D;
                     if(var11[0] > 0.0D || var11[1] > 0.0D) {
                        var31 += 5.0D;
                     }

                     var11[0] += var31;
                     var11[1] += var31;
                     var12[0] = Math.max(var12[0], var30.c());
                     var12[1] = Math.max(var12[1], var30.c());
                     if(var25) {
                        break;
                     }
                  }

                  if(var5 == 0) {
                     break;
                  }

                  var11[0] = Math.max(var11[0], var30.b());
                  var11[1] = Math.max(var11[1], var30.b());
                  var31 = var30.c() * 0.5D;
                  if(var12[0] > 0.0D || var12[1] > 0.0D) {
                     var31 += 5.0D;
                  }

                  var12[0] += var31;
                  var12[1] += var31;
               } while(!var25);

               var11[0] = Math.max(var11[0], var30.b() * 0.5D);
               var11[1] = Math.max(var11[1], var30.b() * 0.5D);
               if(var12[0] > 0.0D) {
                  var12[0] += 10.0D;
               }

               if(var12[1] > 0.0D) {
                  var12[1] += 10.0D;
               }

               var12[0] += var30.c();
               var12[1] += var30.c();
            } while(!var25);

            var11[0] += var11[0] != 0.0D?10.0D:0.0D;
            var11[1] += var11[1] != 0.0D?10.0D:0.0D;
            var12[0] += var12[0] != 0.0D?10.0D:0.0D;
            var12[1] += var12[1] != 0.0D?10.0D:0.0D;
         }

         var10000 = var5;
      }

      double var26;
      double var29;
      if(var10000 != 0) {
         var4[0] = var12[0];
         var4[1] = var12[1];
         var26 = Math.max(var11[0], var11[1]);
         var26 += var26 != 0.0D?10.0D:0.0D;
         var29 = var12[0] + var12[1];
         if(!var25) {
            return new y.d.q(var26, var29);
         }
      }

      var4[0] = var11[0];
      var4[1] = var11[1];
      var26 = var11[0] + var11[1];
      var29 = Math.max(var12[0], var12[1]);
      var29 += var29 != 0.0D?10.0D:0.0D;
      return new y.d.q(var26, var29);
   }

   public double a(y.f.X var1, aV var2, y.c.q var3, y.c.q var4) {
      boolean var17 = N.x;
      double var5 = 0.0D;
      if(var3 != null && var4 != null) {
         aX var7 = var2.a(var3);
         if(var7.b() == 3 && var7.k() > var2.a(var7.f()).k()) {
            var7 = var2.a(var7.f());
         }

         y.c.p var8 = var7.d();

         while(var8 != null) {
            label65: {
               y.c.d var9 = (y.c.d)var8.c();
               aX var10 = var2.a(var4);
               boolean var11 = var10.b() == 3 && var10.g() == var9 && var10.k() < var2.a(var10.f()).k();
               double var12;
               y.d.q var14;
               double var15;
               if(var9.d() == var4 || var11 && var9.d() == var10.f()) {
                  var12 = this.a(var2, var9);
                  var14 = this.a(var1, var9, (byte)0, new double[2], true, true);
                  var15 = var14.a() + 2.0D * var12;
                  var5 = Math.max(var5, var15);
                  if(!var17) {
                     break label65;
                  }
               }

               if(var9.c() == var4 || var11 && var9.c() == var10.f()) {
                  var12 = this.a(var2, var9);
                  var14 = this.a(var1, var9, (byte)0, new double[2], true, false);
                  var15 = var14.a() + 2.0D * var12;
                  var5 = Math.max(var5, var15);
               }
            }

            var8 = var8.a();
            if(var17) {
               break;
            }
         }
      }

      return var5;
   }

   private double a(aV var1, y.c.d var2) {
      B var3 = var1.a(var2).k();
      byte var4 = var3.h().d();
      boolean var5 = var4 == 1;
      return var5?var3.i() / Math.sqrt(2.0D):0.0D;
   }

   private double a(y.f.S var1) {
      y.f.aG var2 = var1.f();
      return !var2.l() && !var2.n()?0.0D:Math.max(0.0D, var2.h());
   }

   private static byte a(y.f.aG var0) {
      byte var1 = var0.a();
      return var1 == 7?0:var1;
   }
}
