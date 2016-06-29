package y.f.c.a;

import java.util.ArrayList;
import java.util.Iterator;
import y.f.c.a.N;
import y.f.c.a.aS;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;
import y.f.c.a.x;

public class bL implements aT {
   private aT a = new ba(new y.f.c.aj());
   private aS b = new x();

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var30 = N.x;
      y.c.c var4 = var1.c(N.t);
      if(var4 != null) {
         ArrayList var5 = new ArrayList(64);
         y.c.x var6 = var1.o();

         while(var6.f()) {
            y.c.q var7 = var6.e();
            if(var4.d(var7)) {
               var5.add(var7);
            }

            var6.g();
            if(var30) {
               break;
            }
         }

         y.c.i var31 = new y.c.i();
         y.c.A var32 = var1.t();
         int var8 = y.a.h.a(var1, (y.c.A)var32);
         int[] var9 = new int[var8];
         int var10 = 0;

         while(var10 < var9.length) {
            var9[var10] = var10++;
            if(var30) {
               break;
            }
         }

         y.c.q[] var33 = new y.c.q[var1.e()];
         y.c.h var11 = var31.u();
         y.c.h var12 = var31.u();
         y.c.A var13 = var31.t();
         y.c.A var14 = var31.t();
         y.c.q[] var15 = new y.c.q[var2.b()];
         int var17 = var2.b() + var5.size() + 2;
         int var18 = var2.b() > 0?var32.a(var2.a(0).d().b()):-1;
         int var19 = var17;
         int var20 = 0;

         y.c.q var21;
         int var22;
         y.c.q var24;
         y.c.q var41;
         while(var20 < var15.length) {
            var21 = var31.d();
            var15[var20] = var21;
            var22 = 0;
            y.c.p var23 = var2.a(var20).d().k();

            while(true) {
               if(var23 != null) {
                  var24 = (y.c.q)var23.c();
                  var22 += var24.b();
                  var33[var24.d()] = var21;
                  var9[var32.a(var24)] = var18;
                  var23 = var23.a();
                  if(var30) {
                     break;
                  }

                  if(!var30) {
                     continue;
                  }
               }

               if(var20 > 0) {
                  var41 = var15[var20 - 1];
                  y.c.d var43 = var31.a(var41, var21);
                  var12.a(var43, 1);
                  var11.a(var43, var22);
                  var19 = Math.max(var19, var22);
               }

               ++var20;
               break;
            }

            if(var30) {
               break;
            }
         }

         y.c.x var35 = var1.o();

         while(var35.f()) {
            var21 = var35.e();
            if(var9[var32.a(var21)] == var18) {
               var32.a(var21, var18);
            }

            var35.g();
            if(var30) {
               break;
            }
         }

         ArrayList var36 = new ArrayList(var5.size() + 32);
         Iterator var37 = var5.iterator();

         y.c.d var25;
         byte var34;
         int var45;
         label222:
         while(true) {
            boolean var10000 = var37.hasNext();

            label219:
            while(var10000) {
               y.c.q var39 = (y.c.q)var37.next();
               if(var32.a(var39) != var18) {
                  continue label222;
               }

               var41 = var31.d();
               var33[var39.d()] = var41;
               var34 = 0;
               if(var30) {
                  break label222;
               }

               var45 = 0;
               var25 = var39.g();

               y.c.q var26;
               y.c.q var27;
               y.c.d var28;
               y.c.d var29;
               while(var25 != null) {
                  var10000 = var25.e();
                  if(var30) {
                     continue label219;
                  }

                  if(!var10000) {
                     ++var45;
                     var26 = var25.c();
                     var27 = var33[var26.d()];
                     if(var27 != null) {
                        label211: {
                           var28 = var27.a(var41);
                           if(var28 == null) {
                              var29 = var31.a(var27, var41);
                              var36.add(var29);
                              var11.a(var29, 1);
                              if(!var30) {
                                 break label211;
                              }
                           }

                           var11.a(var28, var11.a(var28) + 1);
                        }
                     }
                  }

                  var25 = var25.h();
                  if(var30) {
                     break;
                  }
               }

               var25 = var39.f();

               while(true) {
                  if(var25 == null) {
                     continue label222;
                  }

                  var10000 = var25.e();
                  if(var30) {
                     break;
                  }

                  if(!var10000) {
                     ++var45;
                     var26 = var25.d();
                     var27 = var33[var26.d()];
                     if(var27 != null) {
                        label282: {
                           var28 = var41.a(var27);
                           if(var28 == null) {
                              var29 = var31.a(var41, var27);
                              var36.add(var29);
                              var11.a(var29, 1);
                              if(!var30) {
                                 break label282;
                              }
                           }

                           var11.a(var28, var11.a(var28) + 1);
                        }
                     }
                  }

                  var25 = var25.g();
                  if(var30) {
                     break label219;
                  }
               }
            }

            var34 = 0;
            break;
         }

         int var38 = var34;

         int var44;
         while(true) {
            if(var38 < var36.size()) {
               y.c.d var40 = (y.c.d)var36.get(var38);
               var44 = var11.a(var40) * var19;
               var24 = var31.d();
               var14.a(var24, true);
               var25 = var31.a(var24, var40.d());
               var12.a(var25, 1);
               var11.a(var25, var44);
               var11.a(var40, var17 * var44);
               var31.a(var40, var24, var40.c());
               ++var38;
               if(var30) {
                  break;
               }

               if(!var30) {
                  continue;
               }
            }

            y.a.u.a(var31, var13, var11, var12);
            var38 = Integer.MAX_VALUE;
            break;
         }

         y.c.x var42 = var31.o();

         while(true) {
            if(var42.f()) {
               var34 = var14.d(var42.e());
               if(var30) {
                  break;
               }

               if(var34 == 0) {
                  var38 = Math.min(var38, var13.a(var42.e()));
               }

               var42.g();
               if(!var30) {
                  continue;
               }
            }

            var34 = 0;
            break;
         }

         var22 = var34;
         var44 = 0;

         int var48;
         while(var44 < var15.length) {
            var24 = var15[var44];
            var48 = var13.a(var24) - var38;

            while(true) {
               if(var48 > var22) {
                  var2.a((byte)0, var22);
                  ++var22;
                  if(var30) {
                     break;
                  }

                  if(!var30) {
                     continue;
                  }
               }

               ++var44;
               ++var22;
               break;
            }

            if(var30) {
               break;
            }
         }

         Iterator var46 = var5.iterator();

         while(var46.hasNext()) {
            var24 = (y.c.q)var46.next();
            if(var32.a(var24) == var18) {
               y.c.q var50 = var33[var24.d()];
               if(var50 != null) {
                  int var49 = var13.a(var50) - var38;

                  label135: {
                     while(var49 >= var2.b()) {
                        var2.a((byte)0, var2.b());
                        if(var30) {
                           break label135;
                        }

                        if(var30) {
                           break;
                        }
                     }

                     var2.a(var49).a(var24);
                  }

                  if(!var30) {
                     continue;
                  }
               }

               if(var2.b() == 0) {
                  var2.a((byte)0, 0);
               }

               var2.a(0).a(var24);
               if(var30) {
                  break;
               }
            }
         }

         y.g.J var47 = new y.g.J(var1, var32);
         var45 = 0;

         while(true) {
            if(var45 < var9.length) {
               var48 = var9[var45];
               if(var30) {
                  break;
               }

               if(var48 != var18) {
                  var47.c(new Integer(var48));
                  aU var51 = var2.a();
                  this.a.a(var1, var51, var3);
                  this.b.a(var1, var3, var51, var2);
               }

               ++var45;
               if(!var30) {
                  continue;
               }
            }

            var47.b();
            var1.a((y.c.A)var32);
            break;
         }

      }
   }
}
