package y.f.f.b;

import y.c.x;
import y.f.f.b.h;
import y.f.h.q;

public class l {
   h a;
   y.c.i b;

   public void a(h var1, y.c.c var2) {
      int var24 = h.a;
      this.a = var1;
      this.b = var1.a();
      q var3 = var1.c();

      while(var3.f()) {
         y.c.d var4 = null;
         y.f.h.p var5 = var3.a();
         y.c.e var6 = var5.a();
         int var7 = 0;
         int var8 = 0;
         int var9 = 0;
         int var10 = 0;

         int var10000;
         byte var10001;
         while(true) {
            if(var6.f()) {
               y.c.d var11 = var6.a();
               var10000 = var11.c().a();
               var10001 = 4;
               if(var24 != 0) {
                  break;
               }

               label171: {
                  if(var10000 == 4) {
                     ++var7;
                     if(var24 == 0) {
                        break label171;
                     }
                  }

                  if(var11.c().a() == 6) {
                     ++var8;
                     if(var4 != null) {
                        break label171;
                     }

                     var4 = var11;
                     var10 = 6;
                     if(var24 == 0) {
                        break label171;
                     }
                  }

                  if(var11.c().a() > var10) {
                     var4 = var11;
                     var10 = var11.c().a();
                  }
               }

               ++var9;
               var6.g();
               if(var24 == 0) {
                  continue;
               }
            }

            var10000 = var9;
            var10001 = 4;
            break;
         }

         label187: {
            if(var10000 > var10001 && var7 > 0 || var8 > 0) {
               int var12;
               int var13;
               y.f.h.p var14;
               y.c.e var15;
               y.c.d[] var29;
               label178: {
                  var29 = new y.c.d[var9];
                  var12 = 0;
                  var13 = 0;
                  var14 = null;
                  var15 = var5.a();
                  if(var4 != null) {
                     while(var15.a() != var4) {
                        var15.b();
                        if(var24 != 0) {
                           break label178;
                        }

                        if(var24 != 0) {
                           break;
                        }
                     }
                  }

                  var15.c();
               }

               y.c.d var16 = var15.a();
               var14 = var1.b(var1.a(var16));
               var15.b();
               int var17 = 0;

               while(var17 < var9) {
                  y.c.d var18 = var15.a();
                  int var19 = var18.c().a();
                  y.f.h.p var20 = var1.b(var1.a(var18));
                  if(var24 != 0) {
                     break label187;
                  }

                  boolean var21 = var2 != null && var2.d(var18);
                  int var22 = var1.d(var18) - 2;
                  boolean var23 = var22 < -1 || var22 > 1;
                  if(var20 != var14 || var21 || var23) {
                     if(var12 > 0) {
                        this.a(var2, var29, var12, var13, var5, var14);
                     }

                     var12 = 0;
                     var13 = 0;
                     var14 = var20;
                  }

                  label176: {
                     if(!var23 && (var12 == 0 || var19 == 4 || var19 == 6) && !var21) {
                        if(var12 > 0) {
                           var13 += var22;
                        }

                        var29[var12++] = var18;
                        if(var24 == 0) {
                           break label176;
                        }
                     }

                     if(var12 > 0) {
                        this.a(var2, var29, var12, var13, var5, var14);
                     }

                     var12 = 0;
                     var13 = 0;
                     var14 = var20;
                  }

                  var15.b();
                  ++var17;
                  if(var24 != 0) {
                     break;
                  }
               }

               if(var12 > 0) {
                  this.a(var2, var29, var12, var13, var5, var14);
               }
            }

            var3.g();
         }

         if(var24 != 0) {
            break;
         }
      }

      x var25 = this.b.o();

      while(var25.f()) {
         y.c.q var26 = var25.e();
         if(var26.a() == 4) {
            y.c.d var27 = var26.f();
            y.c.d var28 = var26.h();
            if(var1.b(var27) == var1.b(var28)) {
               var1.a((y.c.d)var27, (int)2);
               var1.a((y.c.d)var28, (int)2);
            }
         }

         var25.g();
         if(var24 != 0) {
            break;
         }
      }

   }

   private final void a(y.c.c var1, y.c.d[] var2, int var3, int var4, y.f.h.p var5, y.f.h.p var6) {
      int var15 = h.a;
      if(var3 > 1) {
         y.c.d var7 = var2[0];
         y.c.d var8 = var7.i() == null?var7.c().h():var7.i();
         if(this.a.b(var8) != var6 && var7.c().a() == 6) {
            var8 = var8.i() == null?var8.c().h():var8.i();
         }

         int var10000;
         byte var10001;
         if(this.a.b(var8) == var6) {
            label217:
            while(true) {
               if(var4 < 0) {
                  var10000 = this.a.d(var7);
                  var10001 = 1;
                  if(var15 == 0) {
                     if(var10000 > 1 && this.a.d(var8) < 3) {
                        ++var4;
                        this.a.a(var7, this.a.d(var7) - 1);
                        this.a.a(var8, this.a.d(var8) + 1);
                        if(var15 == 0) {
                           continue;
                        }
                     }

                     if(var4 <= 0) {
                        break;
                     }

                     var10000 = this.a.d(var8);
                     var10001 = 1;
                  }
               } else {
                  if(var4 <= 0) {
                     break;
                  }

                  var10000 = this.a.d(var8);
                  var10001 = 1;
               }

               while(true) {
                  if(var10000 <= var10001 || this.a.d(var7) >= 3) {
                     break label217;
                  }

                  --var4;
                  this.a.a(var7, this.a.d(var7) + 1);
                  this.a.a(var8, this.a.d(var8) - 1);
                  if(var15 != 0 || var4 <= 0) {
                     break label217;
                  }

                  var10000 = this.a.d(var8);
                  var10001 = 1;
               }
            }
         }

         var7 = var2[var3 - 1];
         y.c.q var17 = var7.d();
         y.c.d var9 = this.a.a(var7);
         y.c.d var10 = var17.f();

         label183: {
            label182:
            while(true) {
               if(this.a.b(var10) != var5) {
                  var10 = var10.g();
                  if(var15 != 0) {
                     break;
                  }

                  if(var15 == 0) {
                     continue;
                  }
               }

               if(var10 != var7 && this.a.b(var9) == var6) {
                  while(true) {
                     if(var4 < 0) {
                        var10000 = this.a.d(var10);
                        var10001 = 1;
                        if(var15 == 0) {
                           if(var10000 > 1 && this.a.d(var9) < 3) {
                              ++var4;
                              this.a.a(var10, this.a.d(var10) - 1);
                              this.a.a(var9, this.a.d(var9) + 1);
                              if(var15 == 0) {
                                 continue;
                              }
                           }

                           if(var4 <= 0) {
                              break label182;
                           }

                           var10000 = this.a.d(var9);
                           if(var15 != 0) {
                              break label183;
                           }

                           var10001 = 1;
                        }
                     } else {
                        if(var4 <= 0) {
                           break label182;
                        }

                        var10000 = this.a.d(var9);
                        if(var15 != 0) {
                           break label183;
                        }

                        var10001 = 1;
                     }

                     while(true) {
                        if(var10000 <= var10001 || this.a.d(var10) >= 3) {
                           break label182;
                        }

                        --var4;
                        this.a.a(var10, this.a.d(var10) + 1);
                        this.a.a(var9, this.a.d(var9) - 1);
                        if(var15 != 0 || var4 <= 0) {
                           break label182;
                        }

                        var10000 = this.a.d(var9);
                        if(var15 != 0) {
                           break label183;
                        }

                        var10001 = 1;
                     }
                  }
               }
               break;
            }

            var10000 = 1;
         }

         int var16 = var10000;

         while(true) {
            if(var16 < var3) {
               var17 = var2[var16].c();
               var9 = var2[var16];
               if(var15 != 0) {
                  break;
               }

               var10 = var9.i() == null?var17.h():var9.i();
               if(this.a.b(var10) != var6) {
                  throw new IllegalStateException("Wrong face!");
               }

               int var11;
               byte var12;
               label230: {
                  var11 = this.a.d(var9);
                  if(var4 < 0) {
                     ++var4;
                     var12 = 1;
                     if(var15 == 0) {
                        break label230;
                     }
                  }

                  if(var4 > 0) {
                     if(var17.a() == 4) {
                        --var4;
                        var12 = 3;
                        if(var15 == 0) {
                           break label230;
                        }
                     }

                     var12 = 2;
                     if(var15 == 0) {
                        break label230;
                     }
                  }

                  var12 = 2;
               }

               int var13 = var12 - var11;
               if(var13 != 0) {
                  label233: {
                     int var14 = this.a.d(var10);
                     if(var14 - var13 >= 1 && var14 - var13 < 4) {
                        this.a.a(var10, var14 - var13);
                        this.a.a(var9, var11 + var13);
                        if(var15 == 0) {
                           break label233;
                        }
                     }

                     if(var17.a() != 6) {
                        throw new IllegalStateException("Incompatible degree!");
                     }

                     var10 = var10.i() == null?var17.h():var10.i();
                     if(this.a.b(var10) != var6) {
                        throw new IllegalStateException("Wrong face!");
                     }

                     var14 = this.a.d(var10);
                     if(var14 - var13 < 1 || var14 - var13 >= 4) {
                        throw new IllegalStateException("Could not assign new angle!");
                     }

                     this.a.a(var10, var14 - var13);
                     this.a.a(var9, var11 + var13);
                     if(var15 != 0) {
                        throw new IllegalStateException("Could not assign new angle!");
                     }
                  }
               }

               ++var16;
               if(var15 == 0) {
                  continue;
               }
            }

            if(var4 != 0) {
               throw new IllegalStateException("Could not compensate directions changes.");
            }
            break;
         }

      }
   }
}
