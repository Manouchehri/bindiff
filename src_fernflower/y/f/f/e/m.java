package y.f.f.e;

import java.awt.Dimension;
import y.c.A;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.f.b.p;
import y.f.f.c.r;
import y.f.f.e.a;
import y.f.h.D;
import y.f.h.q;
import y.g.al;
import y.g.o;

public class m implements p {
   private y.f.f.b.h c;
   private X d;
   D a;
   private short e = 0;
   private int f = 3;
   public int b;
   private boolean g = false;
   private y.f.f.b.m h;

   public void a(y.f.f.b.h var1) {
      this.c = var1;
      this.d = (X)this.c.a();
   }

   public void a(int var1) {
      this.b = var1;
   }

   public void a(y.f.f.b.m var1) {
      this.h = var1;
   }

   public void a(short var1) {
      this.e = var1;
   }

   public void b(int var1) {
      this.f = var1;
   }

   public void a() {
      int var34 = a.a;
      o.a(this, "------->>> Entering Compaction Phase");
      al var1 = new al();
      y.c.d[] var2 = this.d.n();
      int var3 = 0;

      m var10000;
      while(true) {
         if(var3 < var2.length) {
            y.c.d var4 = var2[var3];
            var10000 = this;
            if(var34 != 0) {
               break;
            }

            if(!this.c.c(var4)) {
               this.c.n(var4);
            }

            ++var3;
            if(var34 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.c var35 = var10000.d.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
      this.a = (D)this.c.b();
      y.c.e var36 = this.c.a().p();

      while(true) {
         if(var36.f()) {
            var10000 = this;
            if(var34 != 0) {
               break;
            }

            this.c.b(var36.a(), 1);
            var36.g();
            if(var34 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      int var48;
      Object var81;
      label310: {
         y.c.c var37 = var10000.d.c("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE");
         if(var37 != null) {
            label333: {
               q var5 = this.c.c();

               y.c.d var9;
               y.c.d var53;
               y.c.d var62;
               y.c.d var73;
               int var80;
               label306:
               while(true) {
                  var80 = var5.f();

                  y.f.h.p var6;
                  y.c.e var7;
                  y.c.d var12;
                  y.c.d var14;
                  int var51;
                  label303:
                  while(true) {
                     if(var80 != 0) {
                        var6 = (y.f.h.p)var5.d();
                        var80 = var35.d(var6);
                        if(var34 != 0) {
                           break;
                        }

                        if(var80 != 0) {
                           var7 = var6.a();

                           while(true) {
                              if(var7.f()) {
                                 y.c.d var8 = var7.a();
                                 var80 = this.c.d(var8);
                                 if(var34 != 0) {
                                    break;
                                 }

                                 if(var80 == 1 && var8.c().c() > 2) {
                                    var9 = this.a(var8);
                                    y.f.f.b.o var10 = this.c.h(var9);
                                    this.c.h(var8);
                                    var12 = var8;
                                    if(this.c.h(var8).e() != var10.e()) {
                                       var12 = this.c(this.b(var8));
                                    }

                                    y.c.d var15;
                                    label287: {
                                       this.a.e(var12);
                                       y.c.q var13 = this.a.b(var12);
                                       var14 = var13.b(var12.c());
                                       var15 = var13.a(var12.d());
                                       y.f.f.b.o var16 = this.c.h(var12);
                                       int var17 = this.c.d(var12);
                                       int var18 = this.c.d(this.c(var12));
                                       if(var12 == var8) {
                                          this.c.a(var14, var16.a());
                                          this.c.a(var15, var16);
                                          this.c.f(var14);
                                          this.c.f(var15);
                                          this.c.a((y.c.d)var15, (int)1);
                                          this.c.a((y.c.d)var14, (int)2);
                                          this.c.a((y.c.d)this.c(var14), (int)3);
                                          this.c.a(this.c(var15), var18);
                                          this.c.a((y.c.d)var9, (int)1);
                                          if(var34 == 0) {
                                             break label287;
                                          }
                                       }

                                       this.c.a(var14, var16);
                                       this.c.a(var15, var16.b());
                                       this.c.f(var14);
                                       this.c.f(var15);
                                       this.c.a((y.c.d)var15, (int)1);
                                       this.c.a(var14, var17);
                                       this.c.a((y.c.d)this.c(var14), (int)3);
                                       this.c.a((y.c.d)this.c(var15), (int)1);
                                       this.c.a((y.c.d)var8, (int)2);
                                    }

                                    this.c.b(var14, 1);
                                    this.c.b(var15, 1);
                                    this.c.b(this.c(var14), 1);
                                    this.c.b(this.c(var15), 1);
                                 }

                                 var7.g();
                                 if(var34 == 0) {
                                    continue;
                                 }

                                 var80 = 4;
                                 break;
                              }

                              var80 = 4;
                              break;
                           }

                           y.c.q[] var43 = new y.c.q[var80];
                           y.c.e var46 = var6.a();

                           while(var46.f()) {
                              var9 = var46.a();
                              var80 = this.c.d(var9);
                              if(var34 != 0) {
                                 continue label303;
                              }

                              if(var80 == 1) {
                                 var43[this.c.h(var9).g()] = var9.c();
                              }

                              var46.g();
                              if(var34 != 0) {
                                 break;
                              }
                           }

                           Dimension var47 = (Dimension)var37.b(var6);
                           if(var47 != null) {
                              int var50 = (int)Math.floor((double)((float)var47.width / (float)this.b)) + 1;
                              var51 = (int)Math.floor((double)((float)var47.height / (float)this.b)) + 1;
                              y.f.f.b.n var11 = new y.f.f.b.n(var43[1], var43[0], var50, 1, y.f.f.b.o.b);
                              this.c.a(var11);
                              y.f.f.b.n var61 = new y.f.f.b.n(var43[2], var43[1], var51, 1, y.f.f.b.o.c);
                              this.c.a(var61);
                           }
                        }

                        var5.g();
                        if(var34 == 0) {
                           continue label306;
                        }
                     }

                     var5 = this.c.c();
                     var80 = var5.f();
                     break;
                  }

                  while(true) {
                     label264:
                     while(true) {
                        if(var80 == 0) {
                           break label306;
                        }

                        var6 = (y.f.h.p)var5.d();
                        if(var34 != 0) {
                           break label333;
                        }

                        if(!var35.d(var6)) {
                           break;
                        }

                        var7 = var6.a();
                        var48 = var7.k();

                        while(var7.f()) {
                           var80 = this.c.d(var7.a());
                           if(var34 != 0) {
                              continue label264;
                           }

                           if(var80 == 1) {
                              break;
                           }

                           var7.g();
                           if(var34 != 0) {
                              break;
                           }
                        }

                        var9 = null;
                        var51 = 0;

                        while(true) {
                           if(var51 >= var48) {
                              break label264;
                           }

                           var53 = var7.a();
                           var12 = this.a.h(var53);
                           var62 = this.c(this.b(var12));
                           var14 = this.a(var53);
                           var80 = this.c.h(var62).c().a(this.c.h(var14));
                           if(var34 != 0) {
                              break;
                           }

                           label249: {
                              if(var80 != 0) {
                                 y.f.h.p var70 = this.a.i(var62);
                                 if((var9 != null || var14.d().a() != 2) && var9 != var14 || var62.c().a() != 2) {
                                    break label249;
                                 }

                                 var9 = this.c(var62);
                                 var73 = this.d.a((y.c.q)var14.d(), (y.c.q)var62.c());
                                 this.a.e(var73);
                                 this.a.a(var70, var73);
                                 this.c.a((y.c.d)var73, (int)1);
                                 this.c.a((y.c.d)this.c(var73), (int)3);
                                 this.c.a((y.c.d)var62, (int)1);
                                 this.c.a(this.a(var73), this.c.d(this.a(var73)) - 1);
                                 this.c.a(var73, this.c.h(var53));
                                 this.c.a(this.c(var73), this.c.h(this.c(var53)));
                                 this.c.b(var73, 1);
                                 this.c.b(this.c(var73), 1);
                                 this.c.n();
                                 this.c.o();
                                 this.c.l();
                                 if(var34 == 0) {
                                    break label249;
                                 }
                              }

                              var9 = null;
                           }

                           var7.b();
                           ++var51;
                           if(var34 != 0) {
                              break label264;
                           }
                        }
                     }

                     var5.g();
                     if(var34 != 0) {
                        break label306;
                     }

                     var80 = var5.f();
                  }
               }

               x var38 = this.d.o();

               label211:
               do {
                  var80 = var38.f();

                  label208:
                  while(true) {
                     if(var80 == 0) {
                        break label211;
                     }

                     y.c.q var41 = var38.e();
                     var81 = this.d;
                     if(var34 != 0) {
                        break label310;
                     }

                     var37 = ((X)var81).c("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE");
                     var81 = var37.b(var41);

                     y.d.q var44;
                     y.f.f.b.o var55;
                     int var64;
                     y.c.q var71;
                     label183:
                     while(true) {
                        var44 = (y.d.q)var81;
                        if(var44 == null) {
                           break label208;
                        }

                        y.c.f var49 = new y.c.f(var41.l());
                        y.c.e var52 = var49.a();

                        while(true) {
                           if(!var52.f()) {
                              break label183;
                           }

                           y.c.d var54 = var52.a();
                           var55 = this.c.h(var54);
                           int var63 = this.c.d(var54);
                           var64 = this.c.d(this.c(var54));
                           String var68 = this.c.e(var54);
                           var81 = this.a;
                           if(var34 != 0) {
                              break;
                           }

                           y.c.d var75;
                           double var77;
                           label178: {
                              var71 = ((D)var81).b(this.a.n(var54)?this.a.h(var54):var54);
                              var73 = var71.b(var54.c());
                              var75 = var71.a(var54.d());
                              this.c.a(var73, var55.toString());
                              this.c.f(var73);
                              this.c.a(var75, var68);
                              this.c.f(var75);
                              this.c.a(this.a.h(var75), var64);
                              this.c.a(var73, var63);
                              this.c.a((y.c.d)var75, (int)2);
                              this.c.a((y.c.d)this.a.h(var73), (int)2);
                              this.c.b(var73, 1.0D);
                              this.c.b(this.a.h(var73), 1.0D);
                              this.c.b(var75, 1.0D);
                              this.c.b(this.a.h(var75), 1.0D);
                              var77 = 1.0D;
                              if(var55.d()) {
                                 var77 = Math.floor(0.5D * var44.a / (double)((float)this.b)) + 1.0D;
                                 if(var34 == 0) {
                                    break label178;
                                 }
                              }

                              var77 = Math.floor(0.5D * var44.b / (double)((float)this.b)) + 1.0D;
                           }

                           this.c.b(var73, (int)var77);
                           this.c.b(this.a.h(var73), (int)var77);
                           this.c.b(var75, 1);
                           this.c.b(this.a.h(var75), 1);
                           var52.g();
                           if(var34 != 0) {
                              break label183;
                           }
                        }
                     }

                     if(var41.c() == 1) {
                        label354: {
                           var9 = var41.f();
                           y.f.h.p var56 = this.a.i(var9);
                           var55 = this.c.h(var9);
                           y.c.q var65 = this.d.d();
                           var62 = this.d.a((y.c.q)var41, (y.c.q)var65);
                           this.a.e(var62);
                           this.a.a(var62, var65, var56);
                           this.c.a((y.c.d)var62, (int)2);
                           this.c.a((y.c.d)this.c(var62), (int)4);
                           this.c.a((y.c.d)var9, (int)2);
                           this.c.a(var62, var55.c());
                           this.c.f(var62);
                           int var69 = (int)Math.floor(0.5D * var44.a / (double)((float)this.b)) + 1;
                           int var72 = (int)Math.floor(0.5D * var44.b / (double)((float)this.b)) + 1;
                           if(var55.e()) {
                              this.c.b(var62, var72);
                              this.c.b(this.c(var62), var72);
                              if(var34 == 0) {
                                 break label354;
                              }
                           }

                           this.c.b(var62, var69);
                           this.c.b(this.c(var62), var69);
                        }
                     }

                     var9 = var41.h();
                     y.c.e var57 = (new y.c.f(var41.l())).a();

                     while(true) {
                        if(!var57.f()) {
                           break label208;
                        }

                        var53 = var57.a();
                        y.f.f.b.o var66 = this.c.h(var53);
                        var64 = this.c.d(var53);
                        this.c.e(var53);
                        var71 = var53.d();
                        y.c.q var74 = var9.d();
                        y.f.h.p var76 = this.a.i(var53);
                        this.a.h(var9);
                        y.c.d var19 = this.c(this.b(this.c(var9)));
                        y.c.d var21 = this.a(this.c(var53));
                        int var22 = this.c.d(var21);
                        y.c.d var23 = this.c(var9);
                        int var24 = this.c.d(var23);
                        y.c.d var25 = null;
                        var25 = this.d.a((y.c.q)var74, (y.c.q)var71);
                        this.a.e(var25);
                        this.a.a(var76, var25, var19, var53);
                        var80 = var64;
                        if(var34 != 0) {
                           break;
                        }

                        label352: {
                           y.c.d var27;
                           y.c.d var28;
                           if(var64 == 1) {
                              y.c.q var26 = this.a.b(var25);
                              var27 = var26.b(var25.c());
                              var28 = var26.a(var25.d());
                              this.c.a(var27, var66.toString());
                              this.c.f(var27);
                              this.c.a(var28, var66.a().toString());
                              this.c.f(var28);
                              this.c.a((y.c.d)var21, (int)1);
                              this.c.a((y.c.d)var27, (int)1);
                              this.c.a((y.c.d)this.c(var27), (int)1);
                              this.c.a((y.c.d)var28, (int)3);
                              this.c.a((y.c.d)this.c(var28), (int)1);
                              this.c.a((y.c.d)this.c(var9), (int)1);
                              this.c.b(var27, this.c.i(var9));
                              this.c.b(this.a.h(var27), this.c.i(var27));
                              this.c.b(var28, this.c.i(var53));
                              this.c.b(this.a.h(var28), this.c.i(var28));
                              if(var34 == 0) {
                                 break label352;
                              }
                           }

                           y.c.d var29;
                           int var31;
                           int var32;
                           y.c.f var78;
                           if(var64 == 2) {
                              var78 = this.a.a((y.c.d)var25, 2);
                              var27 = var78.d();
                              var28 = var78.d();
                              var29 = var78.d();
                              this.c.a(var27, var66.b().toString());
                              this.c.f(var27);
                              this.c.a(var28, var66.toString());
                              this.c.f(var28);
                              this.c.a(var29, var66.a().toString());
                              this.c.f(var29);
                              this.c.a(var21, var22 - 1);
                              this.c.a(var27, var24 - 1);
                              this.c.a((y.c.d)this.a.h(var27), (int)1);
                              this.c.a((y.c.d)var28, (int)3);
                              this.c.a((y.c.d)this.a.h(var28), (int)1);
                              this.c.a((y.c.d)var29, (int)3);
                              this.c.a((y.c.d)this.a.h(var29), (int)1);
                              this.c.a((y.c.d)this.a.h(var9), (int)1);
                              int var30 = (int)Math.floor(var44.a / (double)((float)this.b)) + 1;
                              var31 = (int)Math.floor(var44.b / (double)((float)this.b)) + 1;
                              if(var66.d()) {
                                 var32 = var30;
                                 var30 = var31;
                                 var31 = var32;
                              }

                              this.c.b(var27, var30 / 2 + 1);
                              this.c.b(this.a.h(var27), this.c.i(var27));
                              this.c.b(var28, var31);
                              this.c.b(this.a.h(var28), this.c.i(var28));
                              this.c.b(var29, var30 / 2 + 1);
                              this.c.b(this.a.h(var29), this.c.i(var29));
                              if(var34 == 0) {
                                 break label352;
                              }
                           }

                           if(var64 == 3) {
                              var78 = this.a.a((y.c.d)var25, 3);
                              var27 = var78.d();
                              var28 = var78.d();
                              var29 = var78.d();
                              y.c.d var79 = var78.d();
                              this.c.a(var27, var66.c().toString());
                              this.c.f(var27);
                              this.c.a(var28, var66.b().toString());
                              this.c.f(var28);
                              this.c.a(var29, var66.toString());
                              this.c.f(var29);
                              this.c.a(var79, var66.a());
                              this.c.f(var79);
                              this.c.a((y.c.d)var21, (int)1);
                              this.c.a((y.c.d)var27, (int)1);
                              this.c.a((y.c.d)this.a.h(var27), (int)1);
                              this.c.a((y.c.d)var28, (int)3);
                              this.c.a((y.c.d)this.a.h(var28), (int)1);
                              this.c.a((y.c.d)var29, (int)3);
                              this.c.a((y.c.d)this.a.h(var29), (int)1);
                              this.c.a((y.c.d)var79, (int)3);
                              this.c.a((y.c.d)this.a.h(var79), (int)1);
                              this.c.a((y.c.d)this.a.h(var9), (int)1);
                              var31 = (int)Math.floor(var44.a / (double)((float)this.b)) + 1;
                              var32 = (int)Math.floor(var44.b / (double)((float)this.b)) + 1;
                              if(var66.d()) {
                                 int var33 = var31;
                                 var31 = var32;
                                 var32 = var33;
                              }

                              this.c.b(var27, var32 / 2 + 1);
                              this.c.b(this.a.h(var27), this.c.i(var27));
                              this.c.b(var28, var31 + 1);
                              this.c.b(this.a.h(var28), this.c.i(var28));
                              this.c.b(var29, var32 + 1);
                              this.c.b(this.a.h(var29), this.c.i(var29));
                              this.c.b(var79, var31 / 2 + 1);
                              this.c.b(this.a.h(var79), this.c.i(var79));
                           }
                        }

                        var9 = var53;
                        var57.g();
                        if(var34 != 0) {
                           break label208;
                        }
                     }
                  }

                  var38.g();
               } while(var34 == 0);
            }
         }

         var81 = this.c.a();
      }

      y.c.e var39 = ((y.c.i)var81).p();

      while(true) {
         if(var39.f()) {
            this.c.b(var39.a(), 1.0D);
            var39.g();
            if(var34 != 0) {
               break;
            }

            if(var34 == 0) {
               continue;
            }
         }

         this.h.h = (int)var1.d();
         var1.e();
         break;
      }

      r var40 = new r();
      var40.a(this.f);
      switch(this.e) {
      case 0:
         var40.a((y.f.f.c.l)(new y.f.f.c.k()));
         var40.a((y.f.f.c.f)(new y.f.f.c.m()));
         if(var34 == 0) {
            break;
         }
      case 1:
         var40.a((y.f.f.c.l)(new y.f.f.c.h()));
         var40.a((y.f.f.c.f)(new y.f.f.c.m()));
         if(var34 == 0) {
            break;
         }
      case 2:
         var40.a((y.f.f.c.l)(new y.f.f.c.n()));
         var40.a((y.f.f.c.f)(new y.f.f.c.m()));
         if(var34 == 0) {
            break;
         }
      default:
         o.a((Object)"Unknown Compactor !");
      }

      A var42 = this.d.t();
      var40.a(this.c);
      var40.a(this.g);
      var40.a(var42);
      this.h.i = (int)var1.d();
      var1.e();
      int var45 = this.b;
      var48 = this.b;
      x var58 = this.d.o();

      while(true) {
         if(var58.f()) {
            y.c.q var59 = var58.e();
            t var60 = (t)var42.b(var59);
            t var67 = new t(var60.a() * (double)var45, var60.b() * (double)var48);
            var42.a(var59, var67);
            this.d.a(var59, var67.a(), var67.b());
            var58.g();
            if(var34 != 0) {
               break;
            }

            if(var34 == 0) {
               continue;
            }
         }

         this.d.a((A)var42);
         this.h.j = var40.a();
         this.h.k = var40.b();
         this.h.l = var40.c();
         this.h.m = var40.d();
         break;
      }

      if(y.c.i.g) {
         ++var34;
         a.a = var34;
      }

   }

   y.c.d a(y.c.d var1) {
      y.c.d var2 = var1.g();
      return var2 == null?var1.c().f():var2;
   }

   y.c.d b(y.c.d var1) {
      y.c.d var2 = var1.i();
      return var2 == null?var1.c().h():var2;
   }

   y.c.d c(y.c.d var1) {
      return this.a.h(var1);
   }
}
