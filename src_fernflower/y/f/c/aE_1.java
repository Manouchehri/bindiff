package y.f.c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import y.f.c.K;
import y.f.c.a;
import y.f.c.aF;

class aE {
   private y.f.X a;
   private y.c.A b;
   private boolean c;
   private static Comparator d = new aF(false);
   private static Comparator e = new aF(true);
   private y.c.A f;
   private y.c.A g;
   private y.c.c h;
   private boolean i = false;

   public aE(y.f.X var1, y.c.A var2, y.c.A var3, y.c.c var4) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.i = true;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public boolean a() {
      return this.c;
   }

   public y.c.y[] a(y.c.y[] param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(y.c.q var1, y.f.S var2) {
      y.c.D var3 = (y.c.D)this.b.b(var1);
      if(var3 == null) {
         var3 = new y.c.D();
         this.b.a(var1, var3);
      }

      var3.add(var2);
   }

   private void d() {
      boolean var25 = a.i;
      ArrayList var1 = new ArrayList(5);
      ArrayList var2 = new ArrayList(5);
      ArrayList var3 = new ArrayList(5);
      y.c.x var4 = this.a.o();

      label165:
      do {
         boolean var10000 = var4.f();

         label162:
         while(var10000) {
            y.c.q var5 = var4.e();
            y.c.D var6 = (y.c.D)this.b.b(var5);
            if(var6 != null) {
               y.f.S[] var7 = (y.f.S[])var6.toArray(new y.f.S[var6.size()]);
               y.c.d var8 = (y.c.d)this.g.b(var5);
               if(var8 == null) {
                  throw new IllegalStateException("realEdge == null: Can\'t be!!!");
               }

               double var9 = 0.0D;
               double var11 = 0.0D;
               double var13 = 0.0D;
               int var15 = 0;

               int var10001;
               int var27;
               label156:
               do {
                  var27 = var15;
                  var10001 = var7.length;

                  y.f.S var16;
                  byte var17;
                  do {
                     if(var27 >= var10001) {
                        break label156;
                     }

                     var16 = var7[var15];
                     var17 = var16.f().b();
                     var27 = var17;
                     var10001 = 16;
                  } while(var25);

                  label173: {
                     if(var17 == 16) {
                        var9 = Math.max(var9, var16.b());
                        if(!var25) {
                           break label173;
                        }
                     }

                     if(var17 == 32) {
                        var11 = Math.max(var11, var16.b());
                        if(!var25) {
                           break label173;
                        }
                     }

                     var13 = Math.max(var13, var16.b());
                  }

                  ++var15;
               } while(!var25);

               if(var13 > var9 * 2.0D) {
                  var9 = var13 / 2.0D;
               }

               if(var13 > var11 * 2.0D) {
                  var11 = var13 / 2.0D;
               }

               byte[] var26 = new byte[]{(byte)1, (byte)4, (byte)0, (byte)2};
               double var28 = 0.0D;
               int var18 = 0;

               label136:
               do {
                  var27 = var18;
                  var10001 = var26.length;

                  label101:
                  while(true) {
                     if(var27 >= var10001) {
                        break label136;
                     }

                     var1.clear();
                     var2.clear();
                     var3.clear();
                     var10000 = false;
                     if(var25) {
                        continue label162;
                     }

                     int var19 = 0;

                     while(true) {
                        if(var19 >= var7.length) {
                           break label101;
                        }

                        y.f.S var20 = var7[var19];
                        y.f.aG var21 = var20.f();
                        var27 = a(var21);
                        var10001 = var26[var18];
                        if(var25) {
                           break;
                        }

                        if(var27 == var10001) {
                           byte var22 = var21.b();
                           switch(var22) {
                           case 16:
                              var1.add(var20);
                              if(!var25) {
                                 break;
                              }
                           case 32:
                              var2.add(var20);
                              if(!var25) {
                                 break;
                              }
                           default:
                              var3.add(var20);
                           }
                        }

                        ++var19;
                        if(var25) {
                           break label101;
                        }
                     }
                  }

                  double var30 = var28;
                  double var33 = var28;
                  int var23 = 0;

                  y.f.S var24;
                  label112: {
                     while(var23 < var1.size()) {
                        var24 = (y.f.S)var1.get(var23);
                        var24.a(var11, var30);
                        var30 += var24.c();
                        ++var23;
                        if(var25) {
                           break label112;
                        }

                        if(var25) {
                           break;
                        }
                     }

                     var23 = 0;
                  }

                  label122: {
                     while(var23 < var2.size()) {
                        var24 = (y.f.S)var2.get(var23);
                        var24.a(var11 - var24.b(), var33);
                        var33 += var24.c();
                        ++var23;
                        if(var25) {
                           break label122;
                        }

                        if(var25) {
                           break;
                        }
                     }

                     var28 = Math.max(var30, var33);
                  }

                  var23 = 0;

                  while(var23 < var3.size()) {
                     var24 = (y.f.S)var3.get(var23);
                     var24.a(var11 - var24.b() / 2.0D, var28);
                     var28 += var24.c();
                     ++var23;
                     if(var25) {
                        continue label136;
                     }

                     if(var25) {
                        break;
                     }
                  }

                  ++var18;
               } while(!var25);

               this.a.b(var5, var9 + var11, var28);
               y.d.t var29 = new y.d.t(-(var9 + var11) / 2.0D + var11, -var28 / 2.0D);
               this.a.b(var5.g(), var29);
               y.d.t var32 = new y.d.t(-(var9 + var11) / 2.0D + var11, var28 / 2.0D);
               this.a.a(var5.f(), var32);
               if(this.h.d(var8)) {
                  int var31 = 0;

                  while(var31 < var7.length) {
                     y.f.S var34 = var7[var31];
                     var34.a(var34.d(), var28 - var34.c() - var34.e());
                     ++var31;
                     if(var25) {
                        continue label165;
                     }

                     if(var25) {
                        break;
                     }
                  }
               }
            }

            var4.g();
            continue label165;
         }

         return;
      } while(!var25);

   }

   public y.f.S[] a(y.c.d var1) {
      y.c.c var2 = this.a.c(y.f.U.a);
      return var2 == null?null:(y.f.S[])var2.b(var1);
   }

   private y.f.S[] a(y.c.q var1) {
      y.c.D var2 = (y.c.D)this.b.b(var1);
      if(var2 != null) {
         y.f.S[] var3 = (y.f.S[])var2.toArray(new y.f.S[var2.size()]);
         return var3;
      } else {
         return null;
      }
   }

   private boolean e() {
      if(!this.a()) {
         return false;
      } else {
         y.c.c var1 = this.a.c(y.f.U.a);
         return var1 != null;
      }
   }

   public void a(y.c.f var1) {
      boolean var20 = a.i;
      if(this.e()) {
         y.c.x var2 = this.a.o();

         while(true) {
            if(var2.f()) {
               y.c.q var3 = var2.e();
               y.f.S[] var4 = this.a(var3);
               if(var20) {
                  break;
               }

               label37: {
                  if(var4 != null) {
                     y.c.d var5 = (y.c.d)this.g.b(var3);
                     if(var5 == null) {
                        throw new IllegalStateException("realEdge == null: Can\'t be!!!");
                     }

                     y.f.am var6 = this.a.h(var3);
                     double var7 = var6.getX();
                     double var9 = var6.getY();
                     double var11 = var6.getWidth();
                     double var13 = var6.getHeight();
                     int var15 = 0;

                     while(var15 < var4.length) {
                        double var16 = var4[var15].d();
                        double var18 = var4[var15].e();
                        var4[var15].a(var16 + var7, var18 + var9);
                        ++var15;
                        if(var20) {
                           break label37;
                        }

                        if(var20) {
                           break;
                        }
                     }
                  }

                  var2.g();
               }

               if(!var20) {
                  continue;
               }
            }

            this.b(var1);
            this.b();
            this.a.a((y.c.A)this.b);
            break;
         }

      }
   }

   public void b() {
      boolean var9 = a.i;
      y.c.e var1 = this.a.p();

      while(var1.f()) {
         if(var1.a().e()) {
            y.c.d var2 = var1.a();
            y.f.S[] var3 = this.a(var2);
            if(var3 != null) {
               y.g.e.a((Object[])var3, d);
               y.c.D var4 = this.a.m(var2);
               y.d.t[] var5 = (y.d.t[])var4.toArray(new y.d.t[var4.size()]);
               y.d.t var6 = var5[0];
               int var7 = 1;

               y.d.t var8;
               int var10000;
               label58: {
                  while(var7 < var5.length) {
                     var8 = var5[var7];
                     double var10;
                     var10000 = (var10 = var6.b() - var8.b()) == 0.0D?0:(var10 < 0.0D?-1:1);
                     if(var9) {
                        break label58;
                     }

                     if(var10000 == 0) {
                        this.a(var6, var8, var3, true);
                        if(!var9) {
                           break;
                        }
                     }

                     var6 = var8;
                     ++var7;
                     if(var9) {
                        break;
                     }
                  }

                  var10000 = var7;
               }

               if(var10000 >= var5.length) {
                  ;
               }

               var6 = var5[var5.length - 1];
               var7 = var5.length - 2;

               label44: {
                  while(var7 >= 0) {
                     var8 = var5[var7];
                     double var11;
                     var10000 = (var11 = var6.b() - var8.b()) == 0.0D?0:(var11 < 0.0D?-1:1);
                     if(var9) {
                        break label44;
                     }

                     if(var10000 == 0) {
                        this.a(var6, var8, var3, false);
                        if(!var9) {
                           break;
                        }
                     }

                     var6 = var8;
                     --var7;
                     if(var9) {
                        break;
                     }
                  }

                  var10000 = var7;
               }

               if(var10000 < 0) {
                  ;
               }
            }
         }

         var1.g();
         if(var9) {
            break;
         }
      }

   }

   public void b(y.c.f var1) {
      boolean var10 = a.i;
      y.c.e var2 = var1.a();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         y.f.S[] var4 = this.a(var3);
         if(var4 != null) {
            y.g.e.a((Object[])var4, d);
            y.c.D var5 = this.a.m(var3);
            y.d.t[] var6 = (y.d.t[])var5.toArray(new y.d.t[var5.size()]);
            y.d.t var7 = var6[0];
            int var8 = 1;

            y.d.t var9;
            int var10000;
            label56: {
               while(var8 < var6.length) {
                  var9 = var6[var8];
                  double var11;
                  var10000 = (var11 = var7.b() - var9.b()) == 0.0D?0:(var11 < 0.0D?-1:1);
                  if(var10) {
                     break label56;
                  }

                  if(var10000 == 0) {
                     this.a(var7, var9, var4, true);
                     if(!var10) {
                        break;
                     }
                  }

                  var7 = var9;
                  ++var8;
                  if(var10) {
                     break;
                  }
               }

               var10000 = var8;
            }

            if(var10000 >= var6.length) {
               ;
            }

            var7 = var6[var6.length - 1];
            var8 = var6.length - 2;

            label42: {
               while(var8 >= 0) {
                  var9 = var6[var8];
                  double var12;
                  var10000 = (var12 = var7.b() - var9.b()) == 0.0D?0:(var12 < 0.0D?-1:1);
                  if(var10) {
                     break label42;
                  }

                  if(var10000 == 0) {
                     this.a(var7, var9, var4, false);
                     if(!var10) {
                        break;
                     }
                  }

                  var7 = var9;
                  --var8;
                  if(var10) {
                     break;
                  }
               }

               var10000 = var8;
            }

            if(var10000 < 0) {
               ;
            }
         }

         var2.g();
         if(var10) {
            break;
         }
      }

   }

   void a(y.d.t var1, y.d.t var2, y.f.S[] var3, boolean var4) {
      boolean var13 = a.i;
      boolean var5 = var1.a() < var2.a();
      double var6;
      double var8;
      int var10;
      y.f.S var11;
      if(var5) {
         if(var4) {
            var6 = var1.a() + 10.0D;
            var8 = var1.b();
            var10 = 0;

            do {
               if(var10 >= var3.length) {
                  return;
               }

               var11 = var3[var10];
               if(var11.f().a() == 2) {
                  return;
               }

               var11.a(var6, var8 - var11.c() / 2.0D);
               var6 += var11.b() + 10.0D;
               ++var10;
            } while(!var13);
         }

         var6 = var1.a() + 10.0D;
         var8 = var1.b();
         var10 = var3.length - 1;

         do {
            if(var10 < 0) {
               return;
            }

            var11 = var3[var10];
            if(var11.f().a() != 2) {
               return;
            }

            y.d.y var12 = var11.a().h();
            var11.a(var6, var8 - var11.c() / 2.0D);
            var6 += var11.b() + 10.0D;
            --var10;
         } while(!var13);
      }

      if(var4) {
         var6 = var1.a() - 10.0D;
         var8 = var1.b();
         var10 = 0;

         do {
            if(var10 >= var3.length) {
               return;
            }

            var11 = var3[var10];
            if(var11.f().a() == 2) {
               return;
            }

            var11.a(var6 - var11.b(), var8 - var11.c() / 2.0D);
            var6 -= var11.b() + 10.0D;
            ++var10;
         } while(!var13);
      }

      var6 = var1.a() - 10.0D;
      var8 = var1.b();
      var10 = var3.length - 1;

      while(var10 >= 0) {
         var11 = var3[var10];
         if(var11.f().a() != 2) {
            return;
         }

         var11.a(var6 - var11.b(), var8 - var11.c() / 2.0D);
         var6 -= var11.b() + 10.0D;
         --var10;
         if(var13) {
            break;
         }
      }

   }

   private boolean a(y.c.d var1, List var2) {
      boolean var5 = a.i;
      y.c.d var3 = var1;
      int var4 = this.f.a(var1.c());

      while(true) {
         if(this.g.b(var3.c()) != null) {
            Object var10000 = var2.get(var4);
            Object var10001 = K.p;
            if(var5) {
               if(var10000 == var10001 || var2.get(var4) == K.q) {
                  return true;
               }

               ++var4;
               if(var5) {
                  return false;
               }
               break;
            }

            if(var10000 == var10001 || var2.get(var4) == K.q) {
               return true;
            }

            var3 = var3.c().g();
            --var4;
            if(!var5) {
               continue;
            }
         }

         var3 = var1;
         var4 = this.f.a(var1.c()) + 1;
         break;
      }

      while(this.g.b(var3.d()) != null) {
         var3 = var3.d().f();
         if(var2.get(var4) == K.p || var2.get(var4) == K.q) {
            return true;
         }

         ++var4;
         if(var5) {
            break;
         }
      }

      return false;
   }

   public void c() {
      this.h = null;
      this.g = null;
      this.b = null;
      this.f = null;
      this.a = null;
   }

   private static byte a(y.f.aG var0) {
      byte var1 = var0.a();
      return var1 == 7?0:var1;
   }
}
