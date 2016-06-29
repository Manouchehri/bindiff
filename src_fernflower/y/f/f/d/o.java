package y.f.f.d;

import java.util.ArrayList;
import y.f.f.d.a;
import y.f.f.d.q;
import y.f.f.d.v;
import y.g.al;

public class o implements y.f.f.b.b {
   protected y.c.i a;
   protected y.f.f.b.h b;
   protected y.c.h c;
   protected y.c.h d;
   protected y.c.h e;
   protected y.c.h f;
   protected y.c.h g;
   protected y.c.h h;
   protected y.c.h i;
   protected int j = 0;
   protected static final Integer k = new Integer(0);
   protected static final Integer l = new Integer(1);
   protected static final Integer m = new Integer(3);
   protected boolean n = false;
   protected v o = new q();
   private boolean q = false;
   public static boolean p;

   public void a(y.f.f.b.h var1) {
      this.b = var1;
      this.a = var1.a();
   }

   public void a(boolean var1) {
      this.q = var1;
   }

   public int b() {
      return this.j;
   }

   public void a() {
      y.c.h var1 = this.a.u();
      this.a(var1);
      this.b.a(var1, this.a.p().a(), y.f.f.b.o.a);
      this.a.a(var1);
   }

   public void a(y.c.h var1) {
      y.c.i var2 = new y.c.i();
      y.c.h var3 = var2.u();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      y.c.A var6 = var2.t();
      y.c.q[] var7 = new y.c.q[2];
      int var8 = this.a(var2, var3, var4, var7, var6, var5);
      this.a(var2, var8, var3, var7, var4, var5, var1, var6);
      if(this.q) {
         this.a(this.b, var1);
      }

      var2.a(var3);
      var2.a(var6);
   }

   protected int a(y.c.i var1, y.c.h var2, ArrayList var3, y.c.q[] var4, y.c.A var5, ArrayList var6) {
      boolean var33 = p;
      this.f = this.a.u();
      this.g = this.a.u();
      this.c = this.a.u();
      this.d = this.a.u();
      this.e = this.a.u();
      y.c.A var7 = this.a.t();
      y.f.h.r var8 = this.b.g();
      this.i = var1.u();
      this.h = var1.u();
      y.c.q var9 = var1.d();
      var5.a(var9, "S");
      y.c.q var10 = var1.d();
      var5.a(var10, "T");
      var4[0] = var9;
      var4[1] = var10;
      int var11 = 0;
      y.c.x var12 = this.a.o();

      int var10000;
      while(true) {
         if(var12.f()) {
            y.c.q var13 = var12.e();
            y.c.q var14 = var1.d();
            var5.a(var14, "V(" + var13 + ")");
            var7.a(var13, var14);
            var10000 = var13.b();
            if(var33) {
               break;
            }

            y.c.d var15;
            if(var10000 < 4) {
               var15 = var1.a(var9, var14);
               var2.a(var15, k);
               var3.add(new a(var15, 4 - var13.b()));
               var11 += 4 - var13.b();
            }

            if(var13.b() > 4) {
               var15 = var1.a(var14, var10);
               var2.a(var15, k);
               var3.add(new a(var15, var13.b() - 4));
            }

            var12.g();
            if(!var33) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var34 = var10000;
      y.f.h.q var35 = this.b.c();

      y.f.h.p var36;
      y.c.q var39;
      while(true) {
         if(var35.f()) {
            var36 = var35.a();
            var39 = var1.d();
            var5.a(var39, "F(" + var34++ + ")");
            var10000 = var36.a().k();
            if(var33) {
               break;
            }

            y.c.d var16;
            if(var10000 < 4 && this.b.d() != var36) {
               var16 = var1.a(var9, var39);
               var2.a(var16, k);
               var3.add(new a(var16, 4 - var36.a().k()));
               var11 += 4 - var36.a().k();
            }

            if(var36.a().k() > 4 && this.b.d() != var36) {
               var16 = var1.a(var39, var10);
               var2.a(var16, k);
               var3.add(new a(var16, var36.a().k() - 4));
            }

            if(this.b.d() == var36) {
               var16 = var1.a(var39, var10);
               var2.a(var16, k);
               var3.add(new a(var16, var36.a().k() + 4));
            }

            var8.a(var36, var39);
            var35.g();
            if(!var33) {
               continue;
            }
         }

         var35 = this.b.c();
         var10000 = var35.f();
         break;
      }

      y.c.q var18;
      y.c.d var19;
      y.c.d var21;
      label151:
      while(true) {
         label149:
         while(true) {
            if(var10000 == 0) {
               break label151;
            }

            var36 = var35.a();
            var39 = (y.c.q)var8.b(var36);
            y.c.e var40 = var36.a();

            while(true) {
               if(!var40.f()) {
                  break label149;
               }

               y.c.d var17 = var40.a();
               var18 = (y.c.q)var7.b(var17.c());
               var10000 = var17.c().c();
               if(var33) {
                  break;
               }

               if(var10000 <= 4) {
                  label143: {
                     var19 = var1.a(var18, var39);
                     var2.a(var19, k);
                     if(this.b.b(var17.c())) {
                        var3.add(new a(var19, 0));
                        if(!var33) {
                           break label143;
                        }
                     }

                     var3.add(new a(var19, 3));
                  }

                  this.f.a(var17, var19);
               }

               y.f.h.p var45 = this.b.b(this.b.a(var17));
               y.c.q var20 = (y.c.q)var8.b(var45);
               var21 = var1.a(var39, var20);
               var2.a(var21, l);
               this.c.a(var17, var21);
               var3.add(new a(var21, 10000));
               var40.g();
               if(var33) {
                  break label149;
               }
            }
         }

         var35.g();
         if(var33) {
            break;
         }

         var10000 = var35.f();
      }

      y.c.h var37 = this.a.u();
      y.c.x var38 = this.a.o();

      while(true) {
         if(var38.f()) {
            var39 = var38.e();
            var10000 = this.b.b(var39);
            if(var33) {
               break;
            }

            if(var10000 == 0 && (!this.n || var39.b() > 4)) {
               Object var44 = var7.b(var39);

               y.c.d var22;
               y.c.d var23;
               ArrayList var24;
               y.c.d var46;
               label109:
               while(true) {
                  y.c.q var41 = (y.c.q)var44;
                  y.c.e var42 = var39.l();

                  label92: {
                     while(var42.f()) {
                        var18 = var1.d();
                        var5.a(var18, "H(" + var39 + "," + var5.b(var8.b(this.b.b(var42.a()))) + ")");
                        var37.a(var42.a(), var18);
                        var19 = var1.a(var18, var41);
                        var2.a(var19, k);
                        var3.add(new a(var19, 1));
                        this.g.a(var42.a(), var19);
                        var42.g();
                        if(var33) {
                           break label92;
                        }

                        if(var33) {
                           break;
                        }
                     }

                     var42.i();
                  }

                  y.c.d var43 = var42.a();
                  var19 = null;
                  var46 = null;
                  var21 = null;
                  var22 = null;
                  var23 = null;
                  var24 = new ArrayList();
                  int var25 = 0;

                  while(true) {
                     if(var25 >= var39.c()) {
                        break label109;
                     }

                     var42.b();
                     var19 = var43;
                     var43 = var42.a();
                     y.f.h.p var26 = this.b.b(var43);
                     y.f.h.p var27 = this.b.b(var19);
                     y.c.q var28 = var1.d();
                     y.c.q var29 = var1.d();
                     var5.a(var28, "NC-L (" + var19.d() + "," + var39 + ")");
                     var5.a(var29, "NC-R (" + var19.d() + "," + var39 + ")");
                     y.c.d var30 = var1.a((y.c.q)var8.b(var26), (y.c.q)var37.b(var19));
                     var2.a(var30, l);
                     this.e.a(var19, var30);
                     y.c.d var31 = var1.a((y.c.q)var8.b(var27), (y.c.q)var37.b(var43));
                     var2.a(var31, l);
                     this.d.a(var19, var31);
                     var44 = var46;
                     if(var33) {
                        break;
                     }

                     if(var46 != null) {
                        this.h.a(var30, var46);
                        this.i.a(var46, var30);
                     }

                     if(var21 != null) {
                        this.i.a(var31, var21);
                        this.h.a(var21, var31);
                     }

                     var21 = var31;
                     var46 = var30;
                     if(var23 == null) {
                        var23 = var31;
                     }

                     if(var22 == null) {
                        var22 = var30;
                     }

                     a var32 = new a(1);
                     var32.a(var31);
                     var32.a(var30);
                     var3.add(var32);
                     var24.add(var32);
                     ++var25;
                     if(var33) {
                        break label109;
                     }
                  }
               }

               var6.add(var24);
               this.h.a(var22, var46);
               this.i.a(var46, var22);
               this.i.a(var23, var21);
               this.h.a(var21, var23);
            }

            var38.g();
            if(!var33) {
               continue;
            }
         }

         this.a.a(var37);
         this.a.a(var7);
         var10000 = var11;
         break;
      }

      return var10000;
   }

   protected double a(y.c.i var1, int var2, y.c.h var3, y.c.q[] var4, ArrayList var5, ArrayList var6, y.c.h var7, y.c.A var8) {
      boolean var31 = p;
      al var9 = new al();
      y.c.h var10 = var1.u();
      double var11 = -1.0D;
      var11 = (double)this.o.a(var1, var4[0], var4[1], var3, var10, var2, var5, var6, this.h, this.i);
      y.g.o.a(this, "---> Solving Network took " + var9);
      var9.e();
      StringBuffer var13 = new StringBuffer(12);
      y.c.e var14 = this.a.p();

      while(true) {
         if(var14.f()) {
            y.c.d var15 = var14.a();
            y.c.d var16 = this.b.a(var14.a());
            var13.setLength(0);
            Object var17 = this.e.b(var15);
            if(var31) {
               break;
            }

            int var18 = var17 != null?var10.a(var17):0;
            Object var19 = this.d.b(var15);
            int var20 = var19 != null?var10.a(var19):0;
            a(var13, var20, '<');
            a(var13, var18, '>');
            int var21 = var10.a(this.c.b(var15));
            int var22 = var10.a(this.c.b(var16));
            a(var13, var22, '>');
            a(var13, var21, '<');
            Object var23 = this.e.b(var16);
            int var24 = var23 != null?var10.a(var23):0;
            Object var25 = this.d.b(var16);
            int var26 = var25 != null?var10.a(var25):0;
            a(var13, var24, '<');
            a(var13, var26, '>');
            this.j += var13.length();
            var7.a(var15, var13.toString());
            Object var27 = this.f.b(var15);
            int var28 = var27 != null?var10.a(var27):0;
            Object var29 = this.g.b(var15);
            int var30 = var29 != null?var10.a(var29):0;
            this.b.a(var15, var28 - var30 + 1);
            var14.g();
            if(!var31) {
               continue;
            }
         }

         y.g.o.a(this, 1, "Number of bends: " + this.j / 2);
         this.j /= 2;
         y.g.o.a(this, 3, "---> Parsing Network solution took " + var9);
         this.a.a(this.f);
         this.a.a(this.g);
         this.a.a(this.c);
         this.a.a(this.d);
         this.a.a(this.e);
         break;
      }

      return var11;
   }

   protected void a(y.f.f.b.h var1, y.c.h var2) {
      boolean var25 = p;
      y.f.h.q var3 = var1.c();

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
               if(var25) {
                  break;
               }

               label171: {
                  if(var10000 == 4) {
                     ++var7;
                     if(!var25) {
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
                     if(!var25) {
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
               if(!var25) {
                  continue;
               }
            }

            var10000 = var9;
            var10001 = 4;
            break;
         }

         if(var10000 > var10001 && var7 > 0 || var8 > 0) {
            int var12;
            int var13;
            y.f.h.p var14;
            y.c.e var15;
            y.c.d[] var30;
            label178: {
               var30 = new y.c.d[var9];
               var12 = 0;
               var13 = 0;
               var14 = null;
               var15 = var5.a();
               if(var4 != null) {
                  while(var15.a() != var4) {
                     var15.b();
                     if(var25) {
                        break label178;
                     }

                     if(var25) {
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

            label123: {
               while(var17 < var9) {
                  y.c.d var18 = var15.a();
                  int var19 = var18.c().a();
                  y.f.h.p var20 = var1.b(var1.a(var18));
                  Object var21 = var2.b(var18);
                  var10000 = var21 instanceof String;
                  if(var25) {
                     break label123;
                  }

                  boolean var22 = var10000 != 0 && ((String)var21).length() > 0;
                  int var23 = var1.d(var18) - 2;
                  boolean var24 = var23 < -1 || var23 > 1;
                  if(var20 != var14 || var22 || var24) {
                     if(var12 > 0) {
                        this.a(var2, var30, var12, var13, var5, var14);
                     }

                     var12 = 0;
                     var13 = 0;
                     var14 = var20;
                  }

                  label176: {
                     if(!var24 && (var12 == 0 || var19 == 4 || var19 == 6) && !var22) {
                        if(var12 > 0) {
                           var13 += var23;
                        }

                        var30[var12++] = var18;
                        if(!var25) {
                           break label176;
                        }
                     }

                     if(var12 > 0) {
                        this.a(var2, var30, var12, var13, var5, var14);
                     }

                     var12 = 0;
                     var13 = 0;
                     var14 = var20;
                  }

                  var15.b();
                  ++var17;
                  if(var25) {
                     break;
                  }
               }

               var10000 = var12;
            }

            if(var10000 > 0) {
               this.a(var2, var30, var12, var13, var5, var14);
            }
         }

         var3.g();
         if(var25) {
            break;
         }
      }

      y.c.x var26 = this.a.o();

      while(var26.f()) {
         y.c.q var27 = var26.e();
         if(var27.a() == 4) {
            y.c.d var28 = var27.f();
            y.c.d var29 = var27.h();
            if(var1.b(var28) == var1.b(var29)) {
               var1.a((y.c.d)var28, (int)2);
               var1.a((y.c.d)var29, (int)2);
            }
         }

         var26.g();
         if(var25) {
            break;
         }
      }

   }

   private final void a(y.c.h var1, y.c.d[] var2, int var3, int var4, y.f.h.p var5, y.f.h.p var6) {
      boolean var15 = p;
      if(var3 > 1) {
         y.c.d var7 = var2[0];
         y.c.d var8 = var7.i() == null?var7.c().h():var7.i();
         if(this.b.b(var8) != var6 && var7.c().a() == 6) {
            var8 = var8.i() == null?var8.c().h():var8.i();
         }

         int var10000;
         byte var10001;
         if(this.b.b(var8) == var6) {
            label217:
            while(true) {
               if(var4 < 0) {
                  var10000 = this.b.d(var7);
                  var10001 = 1;
                  if(!var15) {
                     if(var10000 > 1 && this.b.d(var8) < 3) {
                        ++var4;
                        this.b.a(var7, this.b.d(var7) - 1);
                        this.b.a(var8, this.b.d(var8) + 1);
                        if(!var15) {
                           continue;
                        }
                     }

                     if(var4 <= 0) {
                        break;
                     }

                     var10000 = this.b.d(var8);
                     var10001 = 1;
                  }
               } else {
                  if(var4 <= 0) {
                     break;
                  }

                  var10000 = this.b.d(var8);
                  var10001 = 1;
               }

               while(true) {
                  if(var10000 <= var10001 || this.b.d(var7) >= 3) {
                     break label217;
                  }

                  --var4;
                  this.b.a(var7, this.b.d(var7) + 1);
                  this.b.a(var8, this.b.d(var8) - 1);
                  if(var15 || var4 <= 0) {
                     break label217;
                  }

                  var10000 = this.b.d(var8);
                  var10001 = 1;
               }
            }
         }

         var7 = var2[var3 - 1];
         y.c.q var17 = var7.d();
         y.c.d var9 = this.b.a(var7);
         y.c.d var10 = var17.f();

         label183: {
            label182:
            while(true) {
               if(this.b.b(var10) != var5) {
                  var10 = var10.g();
                  if(var15) {
                     break;
                  }

                  if(!var15) {
                     continue;
                  }
               }

               if(var10 != var7 && this.b.b(var9) == var6) {
                  while(true) {
                     if(var4 < 0) {
                        var10000 = this.b.d(var10);
                        var10001 = 1;
                        if(!var15) {
                           if(var10000 > 1 && this.b.d(var9) < 3) {
                              ++var4;
                              this.b.a(var10, this.b.d(var10) - 1);
                              this.b.a(var9, this.b.d(var9) + 1);
                              if(!var15) {
                                 continue;
                              }
                           }

                           if(var4 <= 0) {
                              break label182;
                           }

                           var10000 = this.b.d(var9);
                           if(var15) {
                              break label183;
                           }

                           var10001 = 1;
                        }
                     } else {
                        if(var4 <= 0) {
                           break label182;
                        }

                        var10000 = this.b.d(var9);
                        if(var15) {
                           break label183;
                        }

                        var10001 = 1;
                     }

                     while(true) {
                        if(var10000 <= var10001 || this.b.d(var10) >= 3) {
                           break label182;
                        }

                        --var4;
                        this.b.a(var10, this.b.d(var10) + 1);
                        this.b.a(var9, this.b.d(var9) - 1);
                        if(var15 || var4 <= 0) {
                           break label182;
                        }

                        var10000 = this.b.d(var9);
                        if(var15) {
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
               if(var15) {
                  break;
               }

               var10 = var9.i() == null?var17.h():var9.i();
               if(this.b.b(var10) != var6) {
                  throw new IllegalStateException("Wrong face!");
               }

               int var11;
               byte var12;
               label230: {
                  var11 = this.b.d(var9);
                  if(var4 < 0) {
                     ++var4;
                     var12 = 1;
                     if(!var15) {
                        break label230;
                     }
                  }

                  if(var4 > 0) {
                     if(var17.a() == 4) {
                        --var4;
                        var12 = 3;
                        if(!var15) {
                           break label230;
                        }
                     }

                     var12 = 2;
                     if(!var15) {
                        break label230;
                     }
                  }

                  var12 = 2;
               }

               int var13 = var12 - var11;
               if(var13 != 0) {
                  label233: {
                     int var14 = this.b.d(var10);
                     if(var14 - var13 >= 1 && var14 - var13 < 4) {
                        this.b.a(var10, var14 - var13);
                        this.b.a(var9, var11 + var13);
                        if(!var15) {
                           break label233;
                        }
                     }

                     if(var17.a() != 6) {
                        throw new IllegalStateException("Incompatible degree!");
                     }

                     var10 = var10.i() == null?var17.h():var10.i();
                     if(this.b.b(var10) != var6) {
                        throw new IllegalStateException("Wrong face!");
                     }

                     var14 = this.b.d(var10);
                     if(var14 - var13 < 1 || var14 - var13 >= 4) {
                        throw new IllegalStateException("Could not assign new angle!");
                     }

                     this.b.a(var10, var14 - var13);
                     this.b.a(var9, var11 + var13);
                     if(var15) {
                        throw new IllegalStateException("Could not assign new angle!");
                     }
                  }
               }

               ++var16;
               if(!var15) {
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

   protected static void a(StringBuffer var0, int var1, char var2) {
      boolean var4 = p;
      int var3 = 0;

      while(var3 < var1) {
         var0.append(var2);
         ++var3;
         if(var4) {
            break;
         }
      }

   }
}
