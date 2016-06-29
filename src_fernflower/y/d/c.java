package y.d;

import y.c.D;
import y.d.d;
import y.d.t;

public class c {
   private double a;
   private D b;
   private double c;

   public c(double var1) {
      this(-1.7976931348623157E308D, Double.MAX_VALUE, var1);
   }

   public c(double var1, double var3, double var5) {
      if(var1 > var3) {
         throw new IllegalArgumentException("min (" + var1 + ") must not be greater than max(" + var3 + ")");
      } else {
         this.b = new D();
         d var7 = d.a(var1, var5, 0.0D);
         var7.a = this.b.a((Object)var7);
         d var8 = d.a(var3, 0.0D, 0.0D);
         var8.a = this.b.b((Object)var8);
      }
   }

   public c(double var1, double var3, double var5, double var7) {
      if(var1 > var3) {
         throw new IllegalArgumentException("min (" + var1 + ") must not be greater than max(" + var3 + ")");
      } else {
         this.b = new D();
         double var9 = var1 != var3?(var7 - var5) / (var3 - var1):0.0D;
         d var11 = d.a(var1, var5, var9);
         var11.a = this.b.a((Object)var11);
         d var12 = d.a(var3, 0.0D, 0.0D);
         var12.a = this.b.b((Object)var12);
      }
   }

   private c() {
   }

   public c a(boolean var1, boolean var2) {
      D var3;
      label47: {
         boolean var6 = t.d;
         var3 = new D();
         y.c.p var4;
         d var5;
         if(var2) {
            var4 = this.b.l().b();

            while(var4 != null) {
               label38: {
                  if(var1) {
                     var5 = d.a(-this.d(var4), -this.a(var4), this.c(var4));
                     if(!var6) {
                        break label38;
                     }
                  }

                  var5 = d.a(-this.d(var4), this.a(var4), -this.c(var4));
               }

               var5.a = var3.b((Object)var5);
               var4 = var4.b();
               if(var6) {
                  break;
               }
            }

            d var7 = d.a(-this.a(), 0.0D, 0.0D);
            var7.a = var3.b((Object)var7);
            if(!var6) {
               break label47;
            }
         }

         var4 = this.b.k();

         while(var4 != null) {
            label25: {
               if(var1) {
                  var5 = d.a(this.b(var4), -this.a(var4), -this.c(var4));
                  if(!var6) {
                     break label25;
                  }
               }

               var5 = d.a(this.b(var4), this.a(var4), this.c(var4));
            }

            var5.a = var3.b((Object)var5);
            var4 = var4.a();
            if(var6) {
               break;
            }
         }
      }

      c var8 = new c();
      var8.c = 0.0D;
      var8.a = 0.0D;
      var8.b = var3;
      return var8;
   }

   public void a(double var1, double var3, double var5) {
      this.a(new c(var1, var3, var5), false, true);
   }

   public void b(double var1, double var3, double var5) {
      this.a(new c(var1, var3, var5), true, true);
   }

   public void c(double var1, double var3, double var5) {
      this.a(var1, var3, var5, 0.0D);
   }

   public void a(double var1, double var3, double var5, double var7) {
      boolean var15 = t.d;
      if(var1 > var3) {
         throw new IllegalArgumentException("min (" + var1 + ") must not be greater than max(" + var3 + ")");
      } else {
         y.c.p var9;
         y.c.p var10;
         d var11;
         d var12;
         label119: {
            label123: {
               if(var1 <= this.a()) {
                  if(var3 >= this.b()) {
                     this.b.clear();
                     var11 = d.a(var1, var5, var7);
                     var11.a = this.b.a((Object)var11);
                     var12 = d.a(var3, 0.0D, 0.0D);
                     var12.a = this.b.b((Object)var12);
                     this.a = this.c = 0.0D;
                     return;
                  }

                  var9 = null;
                  var10 = this.d(var3);
                  var3 -= this.c;
                  var1 -= this.c;
                  if(!var15) {
                     break label123;
                  }
               }

               var1 -= this.c;
               var9 = this.d(var1);
               if(var3 >= this.b()) {
                  var10 = this.b.l();
                  var3 -= this.c;
                  if(!var15) {
                     break label123;
                  }
               }

               var10 = var9.a();
               var3 -= this.c;

               while(((d)var10.c()).c <= var3) {
                  var10 = var10.a();
                  if(var15) {
                     break label119;
                  }

                  if(var15) {
                     break;
                  }
               }

               var10 = var10.b();
            }

            var5 -= this.a;
         }

         d var13;
         if(var9 == var10) {
            var11 = (d)var10.c();
            var12 = d.a(var3, var11.a(var3), var11.d);
            var12.a = this.b.b((Object)var12, var11.a);
            if(var11.c == var1) {
               var11.b = var5;
               var11.d = var7;
               if(!var15) {
                  return;
               }
            }

            var13 = d.a(var1, var5, var7);
            var13.a = this.b.b((Object)var13, var11.a);
         } else {
            label125: {
               if(var9 == null) {
                  var11 = d.a(var1, var5, var7);
                  var9 = var11.a = this.b.a((Object)var11);
                  if(!var15) {
                     break label125;
                  }
               }

               var11 = (d)var9.c();
               if(var11.c == var1) {
                  var11.b = var5;
                  var11.d = var7;
                  if(!var15) {
                     break label125;
                  }
               }

               var12 = d.a(var1, var5, var7);
               var9 = var12.a = this.b.b((Object)var12, var11.a);
            }

            if(var10 != null) {
               var11 = (d)var10.c();
               var11.b = var11.a(var3);
               var11.c = var3;
            }

            var11 = var9.b() != null?(d)var9.b().c():null;
            var12 = (d)var9.c();
            if(var11 != null && var11.d == var12.d && var11.a(var12.c) == var12.b) {
               var9 = var9.b();
            }

            var13 = var10 != null && var10.b() != null?(d)var10.b().c():null;
            d var14 = var10 != null?(d)var10.c():null;
            if(var10 != null && var10 != this.b.l() && var13 != null && var13.d == var14.d && var13.a(var14.c) == var14.b) {
               var10 = var10.a();
            }

            var9 = var9.a();

            while(var9 != var10) {
               this.b.h(var9);
               var9 = var9.a();
               if(var15) {
                  break;
               }
            }

         }
      }
   }

   public void a(double var1) {
      this.a += var1;
   }

   public void b(double var1) {
      this.c += var1;
   }

   public double a() {
      return ((d)this.b.f()).c + this.c;
   }

   public double b() {
      return ((d)this.b.i()).c + this.c;
   }

   public double c() {
      return this.b(this.a(), this.b());
   }

   public double d() {
      return this.a(this.a(), this.b());
   }

   public double a(y.c.p var1, double var2) {
      d var4 = (d)var1.c();
      return this.a(var4, var2);
   }

   public double a(d var1, double var2) {
      var2 -= this.c;
      if(var2 - 0.01D <= var1.a() && var2 + 0.01D >= var1.c) {
         return var1.a(var2) + this.a;
      } else {
         throw new IllegalArgumentException(var2 + " is outside of " + var1);
      }
   }

   public void a(c var1) {
      this.a(var1, true, false);
   }

   public void b(c var1) {
      this.a(var1, false, false);
   }

   private static t a(d var0, d var1) {
      if(var0.d == var1.d) {
         return null;
      } else {
         double var2;
         double var4;
         double var6;
         double var8;
         double var10;
         if(var0.d == 0.0D) {
            var4 = var0.b;
            var6 = var1.c;
            var8 = var1.b;
            var10 = var1.d;
            var2 = var6 + (var4 - var8) / var10;
            return new t(var2, var4);
         } else if(var1.d == 0.0D) {
            var4 = var1.b;
            var6 = var0.c;
            var8 = var0.b;
            var10 = var0.d;
            var2 = var6 + (var4 - var8) / var10;
            return new t(var2, var4);
         } else {
            var4 = Math.max(var0.c, var1.c);
            var6 = var0.a(var4);
            var8 = var1.a(var4);
            var10 = var8 - var6;
            double var12 = var0.d - var1.d;
            if(var10 == 0.0D) {
               return new t(var4, var6);
            } else if(var10 * var12 <= 0.0D) {
               return null;
            } else {
               var2 = var4 + var10 / var12;
               return new t(var2, var0.a(var2));
            }
         }
      }
   }

   private void a(c var1, boolean var2, boolean var3) {
      boolean var53 = t.d;
      boolean var4 = var3 && this.b.size() <= var1.b.size();
      double var5 = var4?var1.c:this.c;
      double var7 = var4?var1.a:this.a;
      double var9 = var2?-1.7976931348623157E308D:Double.MAX_VALUE;
      double var11 = this.a();
      double var13 = var1.a();
      double var15 = this.b();
      double var17 = var1.b();
      D var19 = this.b;
      D var20 = var1.b;
      y.c.p var21 = var19.k();
      y.c.p var22 = var20.k();
      D var23 = new D();
      y.c.p var26;
      d var27;
      d var60;
      if(var15 < var13) {
         label445: {
            if(var4) {
               while(var21 != null) {
                  var60 = (d)var21.c();
                  var60.c += this.c - var1.c;
                  var60.b += this.a - var1.a;
                  var21 = var21.a();
                  if(var53) {
                     break label445;
                  }

                  if(var53) {
                     break;
                  }
               }
            }

            ((d)var19.i()).b = var9 - var7;
         }

         while(true) {
            if(var22 != null) {
               var26 = var22;
               var22 = var22.a();
               if(var53) {
                  break;
               }

               if(var3) {
                  var20.h(var26);
                  if(!var4) {
                     var27 = (d)var26.c();
                     var27.b = var1.a(var26) - this.a;
                     var27.c = var1.b(var26) - this.c;
                  }

                  var19.a(var26);
                  if(!var53) {
                     continue;
                  }
               }

               var27 = d.a(var1.b(var26) - var5, var1.a(var26) - var7, var1.c(var26));
               var27.a = var19.b((Object)var27);
               if(!var53) {
                  continue;
               }
            }

            this.c = var5;
            this.a = var7;
            break;
         }

      } else {
         y.c.p var10000;
         if(var17 < var11) {
            ((d)var20.i()).b = var9 - var7;

            label235: {
               while(true) {
                  if(var22 != null) {
                     var26 = var22;
                     var22 = var22.a();
                     var10000 = var22;
                     if(var53) {
                        break;
                     }

                     double var58 = var22 == null?var9:var1.a(var26);
                     d var29;
                     if(var3) {
                        var20.h(var26);
                        if(!var4) {
                           var29 = (d)var26.c();
                           var29.b = var58 - this.a;
                           var29.c = var1.b(var26) - this.c;
                        }

                        var23.a(var26);
                        if(!var53) {
                           continue;
                        }
                     }

                     var29 = d.a(var1.b(var26) - var5, var58 - var7, var1.c(var26));
                     var29.a = var23.b((Object)var29);
                     if(!var53) {
                        continue;
                     }
                  }

                  if(!var4) {
                     break label235;
                  }

                  var10000 = var21;
                  break;
               }

               while(var10000 != null) {
                  var60 = (d)var21.c();
                  var60.c += this.c - var1.c;
                  var60.b += this.a - var1.a;
                  var21 = var21.a();
                  if(var53) {
                     return;
                  }

                  if(var53) {
                     break;
                  }

                  var10000 = var21;
               }
            }

            var23.a(var19);
            this.b = var23;
            this.c = var5;
            this.a = var7;
         } else {
            d var24;
            d var25;
            label423: {
               if(c(var11, var13)) {
                  var24 = d.a(var11, this.a(var21), this.c(var21));
                  var25 = d.a(var11, var1.a(var22), var1.c(var22));
                  if(!var53) {
                     break label423;
                  }
               }

               d var28;
               y.c.p var55;
               if(var11 < var13) {
                  label469: {
                     y.c.p var57;
                     if(var4 || Math.abs(var11 - var13) < Math.abs(var15 - var13)) {
                        var26 = var21;
                        if(var4) {
                           var27 = (d)var21.c();
                           var27.c += this.c - var1.c;
                           var27.b += this.a - var1.a;
                        }

                        var21 = var21.a();
                        var19.h(var26);
                        var23.a(var26);
                        var55 = var19.l();

                        while(var21 != var55 && this.b(var21) < var13) {
                           var26 = var21;
                           if(var4) {
                              var28 = (d)var21.c();
                              var28.c += this.c - var1.c;
                              var28.b += this.a - var1.a;
                           }

                           var21 = var21.a();
                           var19.h(var26);
                           var23.a(var26);
                           if(var53) {
                              break;
                           }
                        }

                        var57 = var23.l();
                        var24 = d.a(var13, var4?var1.a(var57, var13):this.a(var57, var13), this.c(var57));
                        if(!var53) {
                           break label469;
                        }
                     }

                     var23.a(var19);
                     var21 = var23.l();
                     var26 = var21;
                     var21 = var21.b();
                     var23.h(var26);
                     var19.b(var26);
                     var55 = var23.k();

                     while(var21 != var55 && this.b(var21) >= var13) {
                        var26 = var21;
                        var21 = var21.b();
                        var23.h(var26);
                        var19.b(var26);
                        if(var53) {
                           break;
                        }
                     }

                     var21 = var26;
                     var57 = var23.l();
                     var24 = d.a(var13, this.a(var57, var13), this.c(var57));
                  }

                  var25 = d.a(var1.b(var22), var1.a(var22), var1.c(var22));
                  if(!var53) {
                     break label423;
                  }
               }

               var26 = var20.l();

               label369:
               do {
                  do {
                     if(var22 == var26 || var1.b(var22) >= var11) {
                        break label369;
                     }

                     var55 = var22;
                     var22 = var22.a();
                     if(!var3) {
                        break;
                     }

                     var20.h(var55);
                     if(!var4) {
                        var28 = (d)var55.c();
                        var28.b = var1.a(var55) - this.a;
                        var28.c = var1.b(var55) - this.c;
                     }

                     var23.a(var55);
                  } while(!var53);

                  var28 = d.a(var1.b(var55) - var5, var1.a(var55) - var7, var1.c(var55));
                  var28.a = var23.b((Object)var28);
               } while(!var53);

               var55 = var23.l();
               var28 = (d)var55.c();
               var24 = d.a(var11, this.a(var21, var11), this.c(var21));
               var25 = d.a(var11, var28.a(var11 - var5) + var7, this.c(var28));
            }

            double var56 = Math.max(var11, var13);
            double var59 = var24.a(var56);
            double var30 = var25.a(var56);

            while(true) {
               if(var21 != null) {
                  var10000 = var22;
                  if(var53) {
                     break;
                  }

                  if(var22 != null) {
                     double var32 = var56;
                     y.c.p var34 = null;
                     boolean var35 = false;
                     double var36 = this.b(var21);
                     if(var36 != var56) {
                        var56 = var36;
                     } else {
                        label345: {
                           var24.c = var56;
                           var24.b = this.a(var21);
                           var24.d = this.c(var21);
                           var34 = var21;
                           var21 = var21.a();
                           var19.h(var34);
                           var35 = true;
                           if(var21 == null) {
                              var24.b = var9;
                              var56 = Double.MAX_VALUE;
                              if(!var53) {
                                 break label345;
                              }
                           }

                           var56 = this.b(var21);
                        }

                        var59 = var24.a(var32);
                     }

                     label338: {
                        double var38 = var1.b(var22);
                        if(var38 == var32) {
                           label432: {
                              var25.c = var32;
                              var25.b = var1.a(var22);
                              var25.d = var1.c(var22);
                              if(var34 == null) {
                                 var34 = var22;
                                 var22 = var22.a();
                                 if(!var3) {
                                    break label432;
                                 }

                                 var20.h(var34);
                                 var35 = true;
                                 if(!var53) {
                                    break label432;
                                 }
                              }

                              if(var3) {
                                 y.c.p var40 = var22;
                                 var22 = var22.a();
                                 var20.h(var40);
                                 if(!var53) {
                                    break label432;
                                 }
                              }

                              var22 = var22.a();
                           }

                           label325: {
                              if(var22 == null) {
                                 var25.b = var9;
                                 var25.d = 0.0D;
                                 if(!var53) {
                                    break label325;
                                 }
                              }

                              var56 = Math.min(var56, var1.b(var22));
                           }

                           var30 = var25.a(var32);
                           if(!var53) {
                              break label338;
                           }
                        }

                        var56 = Math.min(var56, var38);
                     }

                     if(var56 == Double.MAX_VALUE && var15 != Double.MAX_VALUE) {
                        d var64 = (d)var34.c();
                        if(var35) {
                           var64.c = var32 - var5;
                           var64.b = var9 - var7;
                           var64.d = 0.0D;
                           var23.a(var34);
                           if(!var53) {
                              continue;
                           }
                        }

                        d var41 = d.a(var64.c, var64.b, var64.d);
                        var41.a = var23.b((Object)var41);
                        if(!var53) {
                           continue;
                        }
                     }

                     double var42;
                     boolean var46;
                     double var65;
                     label435: {
                        var65 = var59;
                        var42 = var30;
                        var59 = var24.a(var56);
                        var30 = var25.a(var56);
                        boolean var44 = var2 && var65 >= var42 || !var2 && var65 <= var42;
                        boolean var45 = var2 && var59 >= var30 || !var2 && var59 <= var30;
                        if(var44 == var45) {
                           var46 = var44;
                           if(!var53) {
                              break label435;
                           }
                        }

                        if(c(var65, var42)) {
                           var46 = var45;
                           if(!var53) {
                              break label435;
                           }
                        }

                        if(c(var59, var30)) {
                           var46 = var44;
                           if(!var53) {
                              break label435;
                           }
                        }

                        t var47 = a(var24, var25);
                        var56 = var47.a();
                        var59 = var47.b();
                        var30 = var47.b();
                        var46 = var44;
                     }

                     double var66 = var46?var24.d:var25.d;
                     double var49 = var46?var65:var42;
                     d var51 = !var23.isEmpty()?(d)var23.i():null;
                     if(var51 != null && var51.d == var66 && c(var51.a(var32 - var5) + var7, var49)) {
                        continue;
                     }

                     d var52;
                     if(var34 != null && var35) {
                        var52 = (d)var34.c();
                        var52.c = var32 - var5;
                        var52.b = var49 - var7;
                        var52.d = var66;
                        var23.a(var34);
                        if(!var53) {
                           continue;
                        }
                     }

                     var52 = d.a(var32 - var5, var49 - var7, var66);
                     var52.a = var23.b((Object)var52);
                     if(!var53) {
                        continue;
                     }
                  }
               }

               var10000 = var21;
               break;
            }

            boolean var54;
            label266: {
               label265: {
                  if(var10000 != null) {
                     label263: {
                        if(!var4) {
                           var23.a(var19);
                           if(!var53) {
                              break label263;
                           }
                        }

                        while(var21 != null) {
                           d var61 = (d)var21.c();
                           var61.c += this.c - var1.c;
                           var61.b += this.a - var1.a;
                           y.c.p var33 = var21;
                           var21 = var21.a();
                           var19.h(var33);
                           var23.a(var33);
                           if(var53) {
                              break label265;
                           }

                           if(var53) {
                              break;
                           }
                        }
                     }
                  }

                  while(var22 != null) {
                     y.c.p var62 = var22;
                     var22 = var22.a();
                     var54 = var3;
                     if(var53) {
                        break label266;
                     }

                     d var63;
                     if(var3) {
                        var20.h(var62);
                        if(!var4) {
                           var63 = (d)var62.c();
                           var63.c += var1.c - this.c;
                           var63.b += var1.a - this.a;
                        }

                        var23.a(var62);
                        if(!var53) {
                           continue;
                        }
                     }

                     var63 = d.a(var1.b(var62) - var5, var1.a(var62) - var7, var1.c(var62));
                     var63.a = var23.b((Object)var63);
                     if(var53) {
                        break;
                     }
                  }
               }

               var54 = var4;
            }

            if(var54) {
               this.c = var1.c;
               this.a = var1.a;
            }

            this.b = var23;
         }
      }
   }

   private static boolean c(double var0, double var2) {
      return Math.abs(var0 - var2) < 0.001D;
   }

   private double a(y.c.p var1) {
      return this.a((d)var1.c());
   }

   private double b(y.c.p var1) {
      return this.b((d)var1.c());
   }

   private double c(y.c.p var1) {
      return this.c((d)var1.c());
   }

   private double d(y.c.p var1) {
      if(var1.a() == null) {
         throw new IllegalArgumentException("Cell is unbound!");
      } else {
         return ((d)var1.a().c()).c + this.c;
      }
   }

   private y.c.p d(double var1) {
      boolean var10 = t.d;
      y.c.p var3 = this.b.k();
      double var4 = ((d)var3.c()).c;
      double var6 = ((d)this.b.i()).c;
      var1 -= this.c;
      if(var1 >= var4 && var1 <= var6) {
         if(var1 == var6) {
            return this.b.l();
         } else {
            double var8 = ((d)var3.a().c()).c;

            y.c.p var10000;
            while(true) {
               if(var1 >= var8) {
                  var3 = var3.a();
                  var10000 = var3.a();
                  if(var10) {
                     break;
                  }

                  var8 = ((d)var10000.c()).c;
                  if(!var10) {
                     continue;
                  }
               }

               var10000 = var3;
               break;
            }

            return var10000;
         }
      } else {
         return null;
      }
   }

   public double a(d var1) {
      return this.a + var1.b;
   }

   public double b(d var1) {
      return var1.c + this.c;
   }

   public double c(d var1) {
      return var1.d;
   }

   public d c(double var1) {
      y.c.p var3 = this.d(var1);
      return var3 != null?(d)var3.c():null;
   }

   public double d(d var1) {
      if(var1.a.a() == null) {
         throw new IllegalArgumentException("Segment is unbound!");
      } else {
         return ((d)var1.a.a().c()).c + this.c;
      }
   }

   public d e() {
      y.c.p var1 = this.b.k();
      return var1 != null?(d)var1.c():null;
   }

   public d f() {
      y.c.p var1 = this.b.l().b();
      return (d)var1.c();
   }

   public d e(d var1) {
      return var1.a.a() != this.b.l()?(d)var1.a.a().c():null;
   }

   public double a(double var1, double var3) {
      boolean var22 = t.d;
      double var5 = this.a();
      double var7 = this.b();
      if(var7 > var5 && var3 > var1) {
         double var13 = Math.max(var5, var1);
         double var15 = Math.min(var7, var3);
         if(var13 >= var15) {
            return -1.7976931348623157E308D;
         } else {
            d var19;
            label49: {
               if(var5 == var1) {
                  var19 = this.e();
                  if(!var22) {
                     break label49;
                  }
               }

               if(var5 < var1) {
                  var19 = this.c(var13);
                  if(!var22) {
                     break label49;
                  }
               }

               var19 = this.e();
            }

            double var20 = var19.a(var13 - this.c) + this.a;
            double var17 = this.d(var19);
            if(var17 < var15) {
               var19 = this.e(var19);
            }

            while(var17 < var15 && var19 != this.b.i()) {
               var20 = Math.max(var20, this.a(var19));
               var20 = Math.max(var20, this.a(var19, this.d(var19)));
               var17 = this.d(var19);
               if(var17 >= var15) {
                  break;
               }

               var19 = this.e(var19);
               if(var22) {
                  break;
               }
            }

            var20 = Math.max(var20, var19.a(var15 - this.c) + this.a);
            return var20;
         }
      } else {
         return Double.MAX_VALUE;
      }
   }

   public double b(double var1, double var3) {
      boolean var22 = t.d;
      double var5 = this.a();
      double var7 = this.b();
      if(var7 > var5 && var3 > var1) {
         double var13 = Math.max(var5, var1);
         double var15 = Math.min(var7, var3);
         if(var13 >= var15) {
            return Double.MAX_VALUE;
         } else {
            d var19;
            label49: {
               if(var5 == var1) {
                  var19 = this.e();
                  if(!var22) {
                     break label49;
                  }
               }

               if(var5 < var1) {
                  var19 = this.c(var13);
                  if(!var22) {
                     break label49;
                  }
               }

               var19 = this.e();
            }

            double var20 = var19.a(var13 - this.c) + this.a;
            double var17 = this.d(var19);
            if(var17 < var15) {
               var19 = this.e(var19);
            }

            while(var17 < var15 && var19 != this.b.i()) {
               var20 = Math.min(var20, this.a(var19));
               var20 = Math.min(var20, this.a(var19, this.d(var19)));
               var17 = this.d(var19);
               if(var17 >= var15) {
                  break;
               }

               var19 = this.e(var19);
               if(var22) {
                  break;
               }
            }

            var20 = Math.min(var20, var19.a(var15 - this.c) + this.a);
            return var20;
         }
      } else {
         return Double.MAX_VALUE;
      }
   }

   public double c(c var1) {
      boolean var20 = t.d;
      double var2 = this.a();
      double var4 = var1.a();
      double var6 = this.b();
      double var8 = var1.b();
      if(var6 > var2 && var8 > var4) {
         double var10 = Math.max(var2, var4);
         double var12 = Math.min(var6, var8);
         if(var10 >= var12) {
            return Double.MAX_VALUE;
         } else {
            double var14;
            d var16;
            d var17;
            label55: {
               var14 = var10;
               if(var2 == var4) {
                  var16 = this.e();
                  var17 = var1.e();
                  if(!var20) {
                     break label55;
                  }
               }

               if(var2 < var4) {
                  var16 = this.c(var10);
                  var17 = var1.e();
                  if(!var20) {
                     break label55;
                  }
               }

               var16 = this.e();
               var17 = var1.c(var10);
            }

            double var18 = Double.MAX_VALUE;

            while(true) {
               if(var14 < var12) {
                  var18 = Math.min(var18, var1.a(var17, var14) - this.a(var16, var14));
                  if(var1.d(var17) < this.d(var16)) {
                     var14 = var1.d(var17);
                     var18 = Math.min(var18, var1.a(var17, var14) - this.a(var16, var14));
                     if(var14 >= var12) {
                        continue;
                     }

                     var17 = var1.e(var17);
                     if(!var20) {
                        continue;
                     }
                  }

                  var14 = this.d(var16);
                  var18 = Math.min(var18, var1.a(var17, var14) - this.a(var16, var14));
                  if(var14 >= var12) {
                     continue;
                  }

                  var16 = this.e(var16);
                  if(var20) {
                     break;
                  }

                  if(!var20) {
                     continue;
                  }
               }

               var18 = Math.min(var18, var1.a(var17, var14) - this.a(var16, var14));
               break;
            }

            return var18;
         }
      } else {
         return Double.MAX_VALUE;
      }
   }

   public String toString() {
      boolean var3 = t.d;
      StringBuffer var1 = new StringBuffer(this.b.size() * 20);
      d var2 = (d)this.b.f();

      StringBuffer var10000;
      while(true) {
         if(var2 != null) {
            var10000 = var1.append("Segment [").append(var2.c + this.c).append(" - ").append(var2.a() + this.c).append("], value=").append(var2.b + this.a).append(", slope=").append(var2.d);
            if(var3) {
               break;
            }

            var2 = this.e(var2);
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }
}
