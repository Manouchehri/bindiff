package y.f.c.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bK;
import y.f.c.a.bw;
import y.f.c.a.cA;
import y.f.c.a.dx;
import y.f.c.a.dy;
import y.f.c.a.m;

final class dA {
   private final y.c.i a;
   private final y.c.A b;
   private final y.c.h c;
   private final Map d;
   private final y.c.i e;
   private final aV f;
   private final boolean g;
   private final boolean h;
   private int[] i;
   private boolean[][] j;
   private y.c.q k;

   dA(y.c.i var1, aV var2, boolean var3, boolean var4) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.a = new y.c.i();
      this.b = this.a.t();
      this.c = this.a.u();
      this.d = new HashMap();
      this.k = null;
   }

   boolean a(y.c.q var1) {
      aX var2 = this.f.a(var1);
      return var2 != null && 1 == var2.b();
   }

   private boolean a(dy var1) {
      if(var1.a == null) {
         return false;
      } else {
         aX var2 = this.f.a(var1.a);
         return var2 != null && 1 == var2.b();
      }
   }

   boolean a(y.c.d var1) {
      return this.c.d(var1);
   }

   int b(y.c.q var1) {
      return this.i[this.c(var1).d()];
   }

   dA a(dA var1) {
      boolean var11 = N.x;
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      y.c.i var4 = var1.a;
      y.c.x var5 = var4.o();

      y.c.q var7;
      while(var5.f()) {
         dy var6 = var1.e(var5.e());
         if(var6.a != null && this.c(var6.a) == null) {
            label197: {
               var7 = this.a.d();
               this.d.put(var6.a, var7);
               this.b.a(var7, var6);
               if(var6.b == 1) {
                  var2.add(var7);
                  if(!var11) {
                     break label197;
                  }
               }

               if(var6.b == 2) {
                  var3.add(var7);
               }
            }
         }

         var5.g();
         if(var11) {
            break;
         }
      }

      int var12 = 0;
      int var13 = var2.size();

      y.c.q var9;
      y.c.i var19;
      label188:
      while(true) {
         int var10000 = var12;
         int var10001 = var13;

         label185: {
            y.c.x var8;
            label184:
            while(true) {
               if(var10000 < var10001) {
                  var7 = (y.c.q)var2.get(var12);
                  y.c.x var18 = this.a.o();
                  if(var11) {
                     var8 = var18;
                     break;
                  }

                  var8 = var18;

                  label126: {
                     while(var8.f()) {
                        var9 = var8.e();
                        var10000 = this.e(var9).b;
                        var10001 = 1;
                        if(var11) {
                           continue label184;
                        }

                        if(var10000 != 1 && var7.a(var9) == null) {
                           this.c.a(this.a.a(var7, var9), true);
                        }

                        var8.g();
                        if(var11) {
                           ++var12;
                           if(!var11) {
                              continue label188;
                           }
                           break label126;
                        }
                     }

                     ++var12;
                     if(!var11) {
                        continue label188;
                     }
                  }

                  var12 = 0;
                  var13 = var3.size();
                  var10000 = var12;
                  var10001 = var13;
               } else {
                  var12 = 0;
                  var13 = var3.size();
                  var10000 = var12;
                  var10001 = var13;
               }

               if(var10000 >= var10001) {
                  break label185;
               }

               var7 = (y.c.q)var3.get(var12);
               var19 = this.a;
               if(var11) {
                  break label188;
               }

               var8 = var19.o();
               break;
            }

            label178:
            while(true) {
               while(!var8.f()) {
                  ++var12;
                  if(var11 || var12 >= var13) {
                     break label178;
                  }

                  var7 = (y.c.q)var3.get(var12);
                  var19 = this.a;
                  if(var11) {
                     break label188;
                  }

                  var8 = var19.o();
               }

               var9 = var8.e();
               byte var20 = this.e(var9).b;
               if(!var11) {
                  if(var20 != 2 && var9.a(var7) == null) {
                     this.c.a(this.a.a(var9, var7), true);
                  }

                  var8.g();
                  if(var11) {
                     ++var12;
                     if(var11 || var12 >= var13) {
                        break;
                     }

                     var7 = (y.c.q)var3.get(var12);
                     var19 = this.a;
                     if(var11) {
                        break label188;
                     }

                     var8 = var19.o();
                  }
               } else {
                  if(var20 >= 2) {
                     break;
                  }

                  var7 = (y.c.q)var3.get(var12);
                  var19 = this.a;
                  if(var11) {
                     break label188;
                  }

                  var8 = var19.o();
               }
            }
         }

         var19 = var4;
         break;
      }

      y.c.e var15 = var19.p();

      while(true) {
         if(var15.f()) {
            y.c.d var14 = var15.a();
            dy var16 = var1.e(var14.c());
            dy var17 = var1.e(var14.d());
            if(var11) {
               break;
            }

            label80: {
               if(var16.a != null) {
                  var9 = this.c(var16.a);
                  if(var17.a == null) {
                     break label80;
                  }

                  y.c.q var10 = this.c(var17.a);
                  if(var9.a(var10) == null) {
                     this.c.a(this.a.a(var9, var10), var1.a(var14));
                     if(!var11) {
                        break label80;
                     }
                  }

                  if(var9.a(this.k) != null) {
                     break label80;
                  }

                  this.c.a(this.a.a(var9, this.k), var1.a(var14));
                  if(!var11) {
                     break label80;
                  }
               }

               if(var17.a != null) {
                  var9 = this.c(var17.a);
                  if(this.k.a(var9) == null) {
                     this.c.a(this.a.a(this.k, var9), var1.a(var14));
                  }
               }
            }

            var15.g();
            if(!var11) {
               continue;
            }
         }

         if(this.i.length < this.a.f()) {
            this.i = new int[this.a.f()];
         }
         break;
      }

      if(!y.a.m.a(this.a, this.i)) {
         throw new IllegalArgumentException("Cyclic sequence constraints!");
      } else {
         return this;
      }
   }

   void a() {
      boolean var31 = N.x;
      y.c.c var1 = this.e.c(bw.a);
      y.c.i var2 = (y.c.i)var1.b(this.e);
      Map var3 = (Map)var2.c(cA.a).b((Object)null);
      y.c.c var4 = var2.c(cA.b);
      y.c.A var5 = var2.t();
      HashSet var6 = new HashSet();
      y.c.c var7 = this.e.c(y.f.ah.f_);
      int[] var8 = new int[this.e.e()];
      int var9 = -1;
      y.c.x var10 = this.e.o();

      y.c.q var11;
      int var13;
      y.c.q var15;
      while(var10.f()) {
         aX var12 = this.f.a(var10.e());
         if(var12 == null || 12 != var12.b() && 13 != var12.b()) {
            var11 = var10.e();
         } else {
            var11 = var12.l();
            var12 = null;
         }

         label741: {
            if(var12 != null) {
               bK var14 = var12.h();
               var13 = var14 != null?var14.j():-1;
               if(var13 <= var9) {
                  break label741;
               }

               var9 = var13;
               if(!var31) {
                  break label741;
               }
            }

            var13 = -1;
         }

         var8[var10.e().d()] = var13;
         if(!var6.contains(var11)) {
            var6.add(var11);
            Object var42 = var3.get(var7 != null?var7.b(var11):var11);
            if(var42 != null || var13 >= 0) {
               var15 = this.d(var11);
               dy var16 = this.e(var15);
               var16.a = var11;
               if(var42 != null) {
                  label725: {
                     Object var17 = var4.b(var42);
                     if(Boolean.TRUE.equals(var17)) {
                        var16.b = 1;
                        if(!var31) {
                           break label725;
                        }
                     }

                     if(Boolean.FALSE.equals(var17)) {
                        var16.b = 2;
                     }
                  }

                  var5.a(var42, var15);
               }
            }
         }

         var10.g();
         if(var31) {
            break;
         }
      }

      y.c.e var32 = var2.p();

      Object var10000;
      y.c.q var40;
      int var43;
      while(true) {
         if(var32.f()) {
            var11 = (y.c.q)var5.b(var32.a().c());
            y.c.q var36 = (y.c.q)var5.b(var32.a().d());
            var10000 = var11;
            if(var31) {
               break;
            }

            if(var11 != null && var36 != null) {
               var40 = this.e(var11).a;
               var43 = var40.e() == this.e?var8[var40.d()]:-1;
               var15 = this.e(var36).a;
               int var50 = var15.e() == this.e?var8[var15.d()]:-1;
               if(var43 < 0 || var50 < 0 || var43 == var50) {
                  this.c.a(this.a.a(var11, var36), true);
               }
            }

            var32.g();
            if(!var31) {
               continue;
            }
         }

         var2.a(var5);
         this.k = this.a.d();
         this.b.a(this.k, new dy());
         var10000 = this.e.c(N.w).b(this.e);
         break;
      }

      y.c.q var19;
      y.c.q var21;
      y.c.q var22;
      y.c.q var24;
      E var33;
      y.c.q var53;
      label697: {
         var33 = (E)var10000;
         if(!this.h && var33.k()) {
            y.c.e var34 = this.a.p();

            while(var34.f()) {
               y.c.d var38 = var34.a();
               var40 = this.e(var38.c()).a;
               y.c.q var45 = this.e(var38.d()).a;
               var15 = var33.i(var40);
               var53 = var33.i(var45);
               if(var31) {
                  break label697;
               }

               label690: {
                  if(var15 != var53) {
                     label763: {
                        y.c.q var18;
                        y.c.q var55;
                        if(var15 == null) {
                           var55 = var53;

                           while(var53 != null) {
                              var55 = var53;
                              var53 = var33.i(var53);
                              if(var31) {
                                 break label690;
                              }

                              if(var31) {
                                 break;
                              }
                           }

                           var18 = this.c(var55);
                           if(var18 == null) {
                              var18 = this.d(var55);
                              this.e(var18).a = var55;
                           }

                           if(var34.a().c() != var18) {
                              this.a.a(var34.a(), var34.a().c(), var18);
                              if(!var31) {
                                 break label763;
                              }
                           }

                           this.a.a(var34.a());
                           if(!var31) {
                              break label763;
                           }
                        }

                        if(var53 == null) {
                           var55 = var15;

                           while(var15 != null) {
                              var55 = var15;
                              var15 = var33.i(var15);
                              if(var31) {
                                 break label690;
                              }

                              if(var31) {
                                 break;
                              }
                           }

                           var18 = this.c(var55);
                           if(var18 == null) {
                              var18 = this.d(var55);
                              this.e(var18).a = var55;
                           }

                           if(var34.a().d() != var18) {
                              this.a.a(var34.a(), var18, var34.a().d());
                              if(!var31) {
                                 break label763;
                              }
                           }

                           this.a.a(var34.a());
                           if(!var31) {
                              break label763;
                           }
                        }

                        ArrayList var57 = new ArrayList();
                        var57.add(var40);
                        HashSet var60 = new HashSet();
                        var19 = var15;

                        label654: {
                           while(var19 != null) {
                              var57.add(var19);
                              var60.add(var19);
                              var19 = var33.i(var19);
                              if(var31) {
                                 break label654;
                              }

                              if(var31) {
                                 break;
                              }
                           }

                           var57.add(var19);
                           var60.add(var19);
                        }

                        var19 = var45;

                        while(!var60.contains(var33.i(var19))) {
                           var19 = var33.i(var19);
                           if(var31) {
                              break label690;
                           }

                           if(var31) {
                              break;
                           }
                        }

                        var21 = var33.i(var19);
                        var22 = (y.c.q)var57.get(var57.indexOf(var21) - 1);
                        if(var22 != var19) {
                           y.c.q var23 = this.c(var19);
                           if(var23 == null) {
                              var23 = this.d(var19);
                              this.e(var23).a = var19;
                           }

                           var24 = this.c(var22);
                           if(var24 == null) {
                              var24 = this.d(var22);
                              this.e(var24).a = var22;
                           }

                           this.a.a(var34.a(), var24, var23);
                           if(!var31) {
                              break label763;
                           }
                        }

                        this.a.a(var34.a());
                     }
                  }

                  var34.g();
               }

               if(var31) {
                  break;
               }
            }
         }

         if(this.g) {
            y.c.c var35 = this.e.c(N.t);
            if(var35 != null) {
               label771: {
                  ArrayList var39 = new ArrayList(this.a.h());
                  y.c.e var44 = this.a.p();

                  byte var93;
                  label616: {
                     while(var44.f()) {
                        y.c.d var46 = var44.a();
                        var93 = var35.d(this.e(var46.c()).a);
                        if(var31) {
                           break label616;
                        }

                        if(var93 == 0 && !var35.d(this.e(var46.d()).a)) {
                           var39.add(var46);
                        }

                        var44.g();
                        if(var31) {
                           break;
                        }
                     }

                     var93 = 0;
                  }

                  var13 = var93;
                  var43 = var39.size();

                  while(var13 < var43) {
                     this.a.a((y.c.d)var39.get(var13));
                     ++var13;
                     if(var31) {
                        break label771;
                     }

                     if(var31) {
                        break;
                     }
                  }

                  y.c.x var47 = this.a.o();

                  while(var47.f()) {
                     dy var49 = this.e(var47.e());
                     if(var49.b != 0 && !var35.d(var49.a)) {
                        var49.b = 0;
                     }

                     var47.g();
                     if(var31) {
                        break;
                     }
                  }
               }
            }
         }
      }

      HashMap var37 = new HashMap();
      HashMap var41 = new HashMap();
      ArrayList var48 = new ArrayList();
      HashSet var51 = new HashSet();
      y.c.x var52 = this.e.o();

      while(var52.f()) {
         var53 = var52.e();
         aX var58 = this.f.a(var53);
         byte var61 = var58 != null?var58.b():-128;
         boolean var20;
         switch(var61) {
         case 12:
            var19 = var58.l();
            Object var63 = (List)var37.get(var19);
            if(var63 == null) {
               var63 = new ArrayList();
               var37.put(var19, var63);
            }

            ((List)var63).add(var53);
            var20 = true;
            if(!var31) {
               break;
            }
         case 13:
            var19 = var58.l();
            Object var66 = (List)var41.get(var19);
            if(var66 == null) {
               var66 = new ArrayList();
               var41.put(var19, var66);
            }

            ((List)var66).add(var53);
            var20 = true;
            if(!var31) {
               break;
            }
         default:
            var19 = var53;
            var20 = false;
         }

         if(var20 && !var51.contains(var19)) {
            var48.add(var19);
            var51.add(var19);
         }

         var21 = this.c(var19);
         if(var21 == null) {
            var21 = this.d(var19);
         }

         this.e(var21).a = var19;
         var52.g();
         if(var31) {
            break;
         }
      }

      HashMap var54 = new HashMap();
      HashMap var56 = new HashMap();
      int var59 = 0;
      int var62 = var48.size();

      y.c.q var64;
      byte var94;
      label569: {
         label776: {
            label567:
            while(var59 < var62) {
               var19 = (y.c.q)var48.get(var59);
               var64 = this.c(var19);
               dy var71 = this.e(var64);
               var94 = var71.b;
               if(var31) {
                  var62 = var94;
                  break label776;
               }

               if(var94 != 0) {
                  this.a(var33, var33.h(var19), var71.b);
               }

               var24 = this.a.d();
               this.b.a(var24, new dy());
               var54.put(var19, var24);
               y.c.e var25 = var64.k();

               while(true) {
                  y.c.q var27;
                  y.c.d var28;
                  if(var25.f()) {
                     y.c.d var26 = var25.a();
                     var27 = var26.c();
                     y.c.d var95 = var27.a(var24);
                     if(var31) {
                        ++var59;
                        if(var31) {
                           break label569;
                        }
                        break label776;
                     }

                     if(var95 == null) {
                        var28 = this.a.a(var27, var24);
                        this.c.a(var28, this.c.d(var26));
                     }

                     var25.g();
                     if(!var31) {
                        continue;
                     }
                  }

                  int var75 = Integer.MAX_VALUE;
                  List var73 = (List)var37.get(var19);
                  y.c.q[] var80 = (y.c.q[])var73.toArray(new y.c.q[var73.size()]);
                  int var85 = 0;

                  int var91;
                  y.c.q var96;
                  while(true) {
                     if(var85 >= var80.length) {
                        var96 = this.a.d();
                        break;
                     }

                     this.d.put(var80[var85], var24);
                     var27 = this.c(var80[var85]);
                     var96 = var27;
                     if(var31) {
                        break;
                     }

                     if(var27 != null && var24 != var27) {
                        this.a.a(var27);
                     }

                     var91 = this.f.a(var80[var85]).j();
                     if(var75 > var91) {
                        var75 = var91;
                        this.e(var24).a = var80[var85];
                     }

                     ++var85;
                     if(var31) {
                        var96 = this.a.d();
                        break;
                     }
                  }

                  y.c.q var87 = var96;
                  this.b.a(var87, new dy());
                  var56.put(var19, var87);
                  y.c.e var88 = var64.l();

                  y.c.q var29;
                  label540: {
                     while(var88.f()) {
                        var28 = var88.a();
                        var29 = var28.d();
                        var10000 = var29.b(var87);
                        if(var31) {
                           break label540;
                        }

                        if(var10000 == null) {
                           y.c.d var30 = this.a.a(var87, var29);
                           this.c.a(var30, this.c.d(var28));
                        }

                        var88.g();
                        if(var31) {
                           break;
                        }
                     }

                     var75 = Integer.MAX_VALUE;
                     var10000 = var41.get(var19);
                  }

                  var73 = (List)var10000;
                  y.c.q[] var90 = (y.c.q[])var73.toArray(new y.c.q[var73.size()]);
                  var91 = 0;

                  while(true) {
                     if(var91 >= var90.length) {
                        var96 = var24;
                        break;
                     }

                     this.d.put(var90[var91], var87);
                     var29 = this.c(var90[var91]);
                     var96 = var29;
                     if(var31) {
                        break;
                     }

                     if(var29 != null && var87 != var29) {
                        this.a.a(var29);
                     }

                     int var92 = this.f.a(var90[var91]).j();
                     if(var75 > var92) {
                        var75 = var92;
                        this.e(var87).a = var90[var91];
                     }

                     ++var91;
                     if(var31) {
                        var96 = var24;
                        break;
                     }
                  }

                  if(var96 != var87 && var24.a(var87) == null) {
                     this.a.a(var24, var87);
                  }

                  ++var59;
                  if(!var31) {
                     break;
                  }
                  break label567;
               }
            }

            var59 = 0;
            var62 = var48.size();
         }

         while(var59 < var62) {
            var19 = (y.c.q)var48.get(var59);
            var64 = this.c(var19);
            this.a.a(var64);
            this.d.remove(var19);
            ++var59;
            if(var31) {
               break;
            }
         }
      }

      HashMap var65 = new HashMap();
      var62 = 0;
      int var72 = var48.size();

      y.c.x var77;
      int var78;
      int var97;
      while(true) {
         if(var62 < var72) {
            var64 = (y.c.q)var48.get(var62);
            var97 = this.a(var64, var65, var33) & 1;
            if(var31) {
               break;
            }

            if(var97 != 0) {
               this.e((y.c.q)var54.get(var64)).b = 1;
            }

            if((this.a(var64, var65, var33) & 2) != 0) {
               this.e((y.c.q)var56.get(var64)).b = 2;
            }

            ++var62;
            if(!var31) {
               continue;
            }
         }

         y.c.x var68 = this.a.o();

         label483: {
            label482:
            while(true) {
               boolean var98 = var68.f();

               label479:
               while(var98) {
                  var19 = var68.e();
                  if(var31) {
                     break label482;
                  }

                  if(var19 != this.k) {
                     byte var67 = this.e(var19).b;
                     var94 = 1;
                     byte var10001 = var67;

                     label473:
                     while(true) {
                        y.c.x var74;
                        y.c.d var82;
                        dy var83;
                        label465:
                        while(var94 == var10001) {
                           var74 = this.a.o();

                           while(true) {
                              if(!var74.f()) {
                                 break label473;
                              }

                              var22 = var74.e();
                              var83 = this.e(var22);
                              var94 = var83.b;
                              var10001 = 1;
                              if(var31) {
                                 break;
                              }

                              if(var94 != 1 && !this.a(var33, this.f, var19, var22) && !this.a(var83)) {
                                 var82 = var19.a(var22);
                                 if(var82 == null) {
                                    var82 = this.a.a(var19, var22);
                                 }

                                 this.c.a(var82, true);
                              }

                              var74.g();
                              if(var31) {
                                 break label465;
                              }
                           }
                        }

                        if(2 != var67) {
                           break;
                        }

                        var74 = this.a.o();

                        while(true) {
                           if(!var74.f()) {
                              break label473;
                           }

                           var22 = var74.e();
                           var83 = this.e(var22);
                           var94 = var83.b;
                           var10001 = 2;
                           if(var31) {
                              break;
                           }

                           if(var94 != 2 && !this.b(var33, this.f, var19, var22) && !this.a(var83)) {
                              var82 = var19.b(var22);
                              if(var82 == null) {
                                 var82 = this.a.a(var22, var19);
                              }

                              this.c.a(var82, true);
                           }

                           var74.g();
                           if(var31) {
                              break label473;
                           }
                        }
                     }

                     aX var76 = this.f.a(this.e(var19).a);
                     if(var76 != null) {
                        var22 = var76.l();
                        y.c.q var84;
                        y.c.x var86;
                        aX var89;
                        label444:
                        switch(var76.b()) {
                        case 12:
                           var86 = var33.h(var22).a();

                           do {
                              if(!var86.f()) {
                                 break label444;
                              }

                              var98 = var33.d(var86.e());
                              if(var31) {
                                 continue label479;
                              }

                              label797: {
                                 if(var98) {
                                    var24 = (y.c.q)var54.get(var86.e());
                                    if(var19 == var24 || var24 == null || var19.a(var24) != null) {
                                       break label797;
                                    }

                                    this.a.a(var19, var24);
                                    if(!var31) {
                                       break label797;
                                    }
                                 }

                                 var89 = this.f.a(var86.e());
                                 if(var89 == null || 12 != var89.b() && 13 != var89.b()) {
                                    var84 = this.c(var86.e());
                                    if(var19 != var84 && var84 != null && var19.a(var84) == null) {
                                       this.a.a(var19, var84);
                                    }
                                 }
                              }

                              var86.g();
                           } while(!var31);
                        case 13:
                           var86 = var33.h(var22).a();

                           while(var86.f()) {
                              var98 = var33.d(var86.e());
                              if(var31) {
                                 continue label479;
                              }

                              label794: {
                                 if(var98) {
                                    var24 = (y.c.q)var56.get(var86.e());
                                    if(var19 == var24 || var24 == null || var19.b(var24) != null) {
                                       break label794;
                                    }

                                    this.a.a(var24, var19);
                                    if(!var31) {
                                       break label794;
                                    }
                                 }

                                 var89 = this.f.a(var86.e());
                                 if(var89 == null || 12 != var89.b() && 13 != var89.b()) {
                                    var84 = this.c(var86.e());
                                    if(var19 != var84 && var84 != null && var19.b(var84) == null) {
                                       this.a.a(var84, var19);
                                    }
                                 }
                              }

                              var86.g();
                              if(var31) {
                                 break;
                              }
                           }
                        }
                     }
                  }

                  var68.g();
                  if(!var31) {
                     continue label482;
                  }
                  break;
               }

               if(var9 > 0) {
                  y.c.q[] var69 = new y.c.q[var9];
                  var72 = 0;

                  while(var72 < var69.length) {
                     var69[var72] = this.d((y.c.q)null);
                     var97 = var72;
                     if(var31) {
                        break label483;
                     }

                     if(var72 > 0) {
                        this.a.a(var69[var72 - 1], var69[var72]);
                     }

                     ++var72;
                     if(var31) {
                        break;
                     }
                  }

                  var77 = this.e.o();

                  while(var77.f()) {
                     var64 = var77.e();
                     var78 = var8[var64.d()];
                     var97 = var78;
                     if(var31) {
                        break label483;
                     }

                     if(var78 >= 0) {
                        if(var78 > 0) {
                           this.a.a(var69[var78 - 1], this.c(var64));
                        }

                        if(var78 < var69.length) {
                           this.a.a(this.c(var64), var69[var78]);
                        }
                     }

                     var77.g();
                     if(var31) {
                        break label482;
                     }
                  }
               }
               break;
            }

            var97 = this.a.g();
         }

         var62 = var97;
         m.a((y.c.i)this.a, (y.c.c)(new dx(this, var62)));
         this.i = new int[this.a.f()];
         var97 = y.a.m.a(this.a, this.i);
         break;
      }

      if(var97 == 0) {
         throw new IllegalArgumentException("Cyclic sequence constraints!");
      } else {
         var77 = this.a.o();

         dA var99;
         while(true) {
            if(var77.f()) {
               var99 = this;
               if(var31) {
                  break;
               }

               this.e(var77.e()).c = var77.e().d();
               var77.g();
               if(!var31) {
                  continue;
               }
            }

            var99 = this;
            break;
         }

         double[] var81 = new double[var99.a.h()];
         double[][] var70 = new double[this.a.f()][this.a.f()];
         Arrays.fill(var81, 1.0D);
         y.a.v.a(this.a, true, var81, var70);
         this.j = new boolean[var70.length][var70.length];
         var78 = 0;

         while(var78 < this.j.length) {
            int var79 = 0;

            while(var79 < this.j[var78].length) {
               this.j[var78][var79] = !Double.isInfinite(var70[var78][var79]);
               ++var79;
               if(var31) {
                  break;
               }
            }

            ++var78;
            if(var31) {
               break;
            }
         }

      }
   }

   void b() {
      this.j = (boolean[][])null;
   }

   private dy e(y.c.q var1) {
      return (dy)this.b.b(var1);
   }

   y.c.q c(y.c.q var1) {
      return (y.c.q)this.d.get(var1);
   }

   y.c.q d(y.c.q var1) {
      y.c.q var2 = this.a.d();
      this.d.put(var1, var2);
      this.b.a(var2, new dy());
      return var2;
   }

   private boolean a(E var1, aV var2, y.c.q var3, y.c.q var4) {
      y.c.q var5 = this.e(var3).a;
      y.c.q var6 = this.e(var4).a;
      if(var5 != null && var6 != null) {
         aX var7 = var2.a(var6);
         return var7 != null && var7.b() == 12 && var1.a(var5, var7.l());
      } else {
         return false;
      }
   }

   private boolean b(E var1, aV var2, y.c.q var3, y.c.q var4) {
      y.c.q var5 = this.e(var3).a;
      y.c.q var6 = this.e(var4).a;
      if(var5 != null && var6 != null) {
         aX var7 = var2.a(var6);
         return var7 != null && var7.b() == 13 && var1.a(var5, var7.l());
      } else {
         return false;
      }
   }

   private void a(E var1, y.c.y var2, byte var3) {
      boolean var7 = N.x;
      y.c.x var4 = var2.a();

      while(var4.f()) {
         y.c.q var5 = this.c(var4.e());
         if(var5 != null && this.e(var5).b == 0) {
            this.e(var5).b = var3;
         }

         byte var6 = var5 != null?this.e(var5).b:0;
         if(var6 != 0 && var1.d(var4.e())) {
            this.a(var1, var1.h(var4.e()), var6);
         }

         var4.g();
         if(var7) {
            break;
         }
      }

   }

   private int a(y.c.q var1, Map var2, E var3) {
      boolean var8 = N.x;
      Object var4 = var2.get(var1);
      Object var10000;
      if(var4 == null) {
         int var5 = 0;
         y.c.x var6 = var3.g(var1).a();

         while(var6.f()) {
            y.c.q var7 = this.c(var6.e());
            var10000 = var7;
            if(var8) {
               return ((Integer)var10000).intValue();
            }

            if(var7 != null) {
               var5 |= this.e(var7).b;
            }

            var6.g();
            if(var8) {
               break;
            }
         }

         var4 = new Integer(var5);
         var2.put(var1, var4);
      }

      var10000 = var4;
      return ((Integer)var10000).intValue();
   }

   static dy a(dA var0, y.c.q var1) {
      return var0.e(var1);
   }

   static boolean[][] b(dA var0) {
      return var0.j;
   }

   static y.c.i c(dA var0) {
      return var0.a;
   }

   static y.c.q d(dA var0) {
      return var0.k;
   }

   static int[] e(dA var0) {
      return var0.i;
   }

   static int[] a(dA var0, int[] var1) {
      return var0.i = var1;
   }

   static y.c.h f(dA var0) {
      return var0.c;
   }
}
