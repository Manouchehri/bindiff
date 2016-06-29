package y.f.k;

import java.util.Iterator;
import y.f.aE;
import y.f.aG;
import y.f.am;
import y.f.k.A;
import y.f.k.R;
import y.f.k.S;
import y.f.k.d;
import y.f.k.x;

class Q {
   private y.c.q a;
   private y.f.X b;

   Q(y.c.q var1, y.f.X var2) {
      this.a = var1;
      this.b = var2;
   }

   void a(A var1, byte var2, double var3, y.f.F var5) {
      int var40 = d.g;
      y.c.d var6 = this.a.g();
      if(var6 != null) {
         y.c.c var7 = this.b.c(y.f.U.a);
         if(var7 != null) {
            y.f.S[] var8 = (y.f.S[])var7.b(var6);
            if(var8 != null) {
               if(var8.length != 0) {
                  if(var8.length != 1 || var8[0].b() != 0.0D) {
                     if(var2 < 0) {
                        aE var9 = aE.e(this.b, var6);
                        if(var9 == null) {
                           var9 = aE.a((byte)0);
                        }

                        byte var10 = var9.b();
                        switch(var10) {
                        case 1:
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        default:
                           var2 = 0;
                           if(var40 == 0) {
                              break;
                           }
                        case 4:
                           var2 = 1;
                           if(var40 == 0) {
                              break;
                           }
                        case 2:
                           var2 = 2;
                           if(var40 == 0) {
                              break;
                           }
                        case 8:
                           var2 = 3;
                        }
                     }

                     double var41 = var1.b();
                     double var11 = var1.c();
                     am var17 = this.b.a((Object)this.a);
                     y.f.y var18 = this.a(var6, var2);
                     y.c.D var19 = new y.c.D();
                     int var20 = 0;

                     while(true) {
                        if(var20 < var8.length) {
                           var5.a(this.b, (y.f.S)var8[var20], var18);
                           var19.add(new S(var8[var20], var20, (R)null));
                           ++var20;
                           if(var40 != 0) {
                              break;
                           }

                           if(var40 == 0) {
                              continue;
                           }
                        }

                        var19.o();
                        break;
                     }

                     Iterator var42 = var19.iterator();

                     while(var42.hasNext()) {
                        y.f.S var22;
                        boolean var23;
                        double var31;
                        double var33;
                        label177: {
                           double var24;
                           double var26;
                           double var28;
                           int var30;
                           label178: {
                              S var21 = (S)var42.next();
                              var22 = var21.a;
                              var23 = !var42.hasNext();
                              var24 = var22.b();
                              var26 = var22.c();
                              var28 = Math.max(0.0D, var22.f().h());
                              var30 = this.a(var22, var18);
                              switch(var2) {
                              case 0:
                                 label179: {
                                    var33 = var1.f() - var26 - var3;
                                    if(var30 == 3) {
                                       var31 = var41 - var24 - var28;
                                       if(var40 == 0) {
                                          break label179;
                                       }
                                    }

                                    if(var30 == 2) {
                                       var31 = var41 + var28;
                                       if(var40 == 0) {
                                          break label179;
                                       }
                                    }

                                    var31 = var41 - var24 * 0.5D;
                                 }

                                 var11 = var1.f() - var26 - var3;
                                 var1.a(var41, var11);
                                 if(var40 == 0) {
                                    break label177;
                                 }
                              case 1:
                                 label180: {
                                    var31 = var1.g() + var3;
                                    if(var30 == 0) {
                                       var33 = var11 - var26 - var28;
                                       if(var40 == 0) {
                                          break label180;
                                       }
                                    }

                                    if(var30 == 1) {
                                       var33 = var11 + var28;
                                       if(var40 == 0) {
                                          break label180;
                                       }
                                    }

                                    var33 = var11 - var26 * 0.5D;
                                 }

                                 var41 = var1.g() + var24 + var3;
                                 var1.a(var41, var11);
                                 if(var40 == 0) {
                                    break label177;
                                 }
                              case 2:
                                 break;
                              case 3:
                                 break label178;
                              default:
                                 throw new IllegalStateException("Should not reach");
                              }

                              label181: {
                                 var33 = var1.h() + var3;
                                 if(var30 == 2) {
                                    var31 = var41 + var28;
                                    if(var40 == 0) {
                                       break label181;
                                    }
                                 }

                                 if(var30 == 3) {
                                    var31 = var41 - var24 - var28;
                                    if(var40 == 0) {
                                       break label181;
                                    }
                                 }

                                 var31 = var41 - var24 * 0.5D;
                              }

                              var11 = var1.h() + var26 + var3;
                              var1.a(var41, var11);
                              if(var40 == 0) {
                                 break label177;
                              }
                           }

                           label182: {
                              var31 = var1.e() - var24 - var3;
                              if(var30 == 1) {
                                 var33 = var11 + var28;
                                 if(var40 == 0) {
                                    break label182;
                                 }
                              }

                              if(var30 == 0) {
                                 var33 = var11 - var26 - var28;
                                 if(var40 == 0) {
                                    break label182;
                                 }
                              }

                              var33 = var11 - var26 * 0.5D;
                           }

                           var41 = var1.e() - var24 - var3;
                           var1.a(var41, var11);
                        }

                        var22.a(var31 - var17.getX(), var33 - var17.getY());
                        y.d.n var35 = new y.d.n(var22.a());
                        var35.d(var17.getX(), var17.getY());
                        var1.a(var35);
                        if(var23) {
                           double var36 = 0.0D;
                           double var38 = 0.0D;
                           if(var40 != 0) {
                              return;
                           }

                           switch(var2) {
                           case 0:
                              var38 = -var3;
                              if(var40 == 0) {
                                 break;
                              }
                           case 1:
                              var36 = var3;
                              if(var40 == 0) {
                                 break;
                              }
                           case 2:
                              var38 = var3;
                              if(var40 == 0) {
                                 break;
                              }
                           case 3:
                              var36 = -var3;
                           }

                           var35.d(var36, var38);
                           var1.a(var35);
                           var41 += var36;
                           var11 += var38;
                           if(var40 != 0) {
                              break;
                           }
                        }
                     }

                     var1.a(var41, var11, var41, var11);
                  }
               }
            }
         }
      }
   }

   private y.f.y a(y.c.d var1, byte var2) {
      y.c.h var3 = (y.c.h)this.b.c(x.q);
      boolean var4 = var3.b(var1) != null;
      switch(var2) {
      case 0:
         return var4?y.f.y.a:y.f.y.c;
      case 1:
         return var4?y.f.y.b:y.f.y.d;
      case 2:
         return var4?y.f.y.c:y.f.y.a;
      case 3:
         return var4?y.f.y.d:y.f.y.b;
      default:
         throw new IllegalStateException("Unknown node placer direction " + var2);
      }
   }

   private int a(y.f.S var1, y.f.y var2) {
      aG var3 = var1.f();
      if(!var3.m()) {
         boolean var4 = var2 == y.f.y.d || var2 == y.f.y.b;
         boolean var5 = var2 == y.f.y.a || var2 == y.f.y.c;
         if(var3.u() && var2 == y.f.y.a && var3.l() || var3.u() && var2 == y.f.y.c && var3.n() || var3.v() && var5 && var3.l() || var3.w() && var5 && var3.l()) {
            return 3;
         }

         if(var3.u() && var2 == y.f.y.a && var3.n() || var3.u() && var2 == y.f.y.c && var3.l() || var3.v() && var5 && var3.n() || var3.w() && var5 && var3.n()) {
            return 2;
         }

         if(var3.u() && var2 == y.f.y.d && var3.n() || var3.u() && var2 == y.f.y.b && var3.l() || var3.v() && var4 && var3.l() || var3.w() && var4 && var3.n()) {
            return 0;
         }

         if(var3.u() && var2 == y.f.y.d && var3.l() || var3.u() && var2 == y.f.y.b && var3.n() || var3.v() && var4 && var3.n() || var3.w() && var4 && var3.l()) {
            return 1;
         }
      }

      return 4;
   }

   void a(A var1) {
      int var12 = d.g;
      am var2 = this.b.a((Object)this.a);
      y.c.c var3 = this.b.c(y.f.U.b);
      if(var3 != null) {
         y.f.S[] var4 = (y.f.S[])var3.b(this.a);
         if(var4 != null) {
            double var5 = var2.getX() + var2.getWidth() / 2.0D;
            double var7 = var2.getY() + var2.getHeight() / 2.0D;
            int var9 = 0;

            while(var9 < var4.length) {
               y.f.S var10 = var4[var9];
               y.d.y var11 = var10.a().h();
               var1.b(var11.c + var5, var11.d + var7, var11.a, var11.b);
               ++var9;
               if(var12 != 0) {
                  break;
               }
            }
         }
      }

   }
}
