package y.a;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import y.a.h;

class Z {
   public static void a(y.c.i var0, List var1, List var2, y.c.h var3, boolean var4) {
      boolean var20 = h.a;
      if(var0.h() != 0) {
         int var5 = var0.e();
         y.c.A var6 = y.g.M.a(new double[var5]);
         y.c.A var7 = y.g.M.a(new int[var5]);
         y.c.A var8 = y.g.M.a((Object[])(new ArrayList[var5]));
         y.c.h var9 = y.g.M.b(new double[var0.h()]);
         y.c.A var10 = y.g.M.a(new double[var5]);
         ListIterator var11 = var1.listIterator();

         label150:
         while(true) {
            if(var11.hasNext()) {
               Object var10000 = var11.next();

               ArrayList var13;
               y.c.q var15;
               label145:
               while(true) {
                  y.c.q var22 = (y.c.q)var10000;

                  y.c.q var12;
                  label111:
                  while(true) {
                     var12 = var22;
                     var13 = new ArrayList();
                     ListIterator var14 = var2.listIterator();

                     label97: {
                        while(var14.hasNext()) {
                           var9.a(var14.next(), 0.0D);
                           if(var20) {
                              break label97;
                           }

                           if(var20) {
                              break;
                           }
                        }

                        var14 = var1.listIterator();
                     }

                     while(true) {
                        do {
                           if(!var14.hasNext()) {
                              break label111;
                           }

                           var15 = (y.c.q)var14.next();
                           var8.a(var15, new ArrayList());
                           var10.a(var15, 0.0D);
                           var22 = var15;
                           if(var20) {
                              continue label111;
                           }

                           if(var15 == var12) {
                              break;
                           }

                           var6.a(var15, 0.0D);
                           var7.a(var15, -1);
                        } while(!var20);

                        var6.a(var15, 1.0D);
                        var7.a(var15, 0);
                        if(var20) {
                           break label111;
                        }
                     }
                  }

                  y.g.c var21 = new y.g.c(var5);
                  var21.a(var12);

                  label143:
                  while(true) {
                     int var24 = var21.e();

                     while(true) {
                        if(var24 != 0) {
                           break label145;
                        }

                        var15 = (y.c.q)var21.b();
                        var13.add(var15);
                        y.c.d var16 = var15.f();

                        y.c.q var17;
                        ArrayList var18;
                        label132: {
                           while(var16 != null) {
                              var17 = var16.d();
                              var24 = var7.a(var17);
                              if(var20) {
                                 break label132;
                              }

                              if(var24 < 0) {
                                 var21.a(var17);
                                 var7.a(var17, var7.a(var15) + 1);
                              }

                              if(var7.a(var17) == var7.a(var15) + 1) {
                                 if(var6.c(var17) + var6.c(var15) > Double.MAX_VALUE) {
                                    throw new ArithmeticException("Number of Paths between " + var12 + " and " + var17 + " overflows double");
                                 }

                                 var6.a(var17, var6.c(var17) + var6.c(var15));
                                 var18 = (ArrayList)var8.b(var17);
                                 var18.add(var16);
                                 var8.a(var17, var18);
                              }

                              var16 = var16.g();
                              if(var20) {
                                 break;
                              }
                           }

                           var24 = var4;
                        }

                        if(var24 != 0) {
                           break;
                        }

                        var10000 = var15.g();
                        if(var20) {
                           continue label145;
                        }

                        Object var23 = var10000;

                        while(true) {
                           if(var23 == null) {
                              continue label143;
                           }

                           var17 = ((y.c.d)var23).c();
                           var24 = var7.a(var17);
                           if(var20) {
                              break;
                           }

                           if(var24 < 0) {
                              var21.a(var17);
                              var7.a(var17, var7.a(var15) + 1);
                           }

                           if(var7.a(var17) == var7.a(var15) + 1) {
                              if(var6.c(var17) + var6.c(var15) > Double.MAX_VALUE) {
                                 throw new ArithmeticException("Number of Paths between " + var12 + " and " + var17 + " overflows double");
                              }

                              var6.a(var17, var6.c(var17) + var6.c(var15));
                              var18 = (ArrayList)var8.b(var17);
                              var18.add(var23);
                              var8.a(var17, var18);
                           }

                           var23 = ((y.c.d)var23).h();
                           if(var20) {
                              break label145;
                           }
                        }
                     }
                  }
               }

               label78:
               while(true) {
                  if(var13.isEmpty()) {
                     continue label150;
                  }

                  var15 = (y.c.q)var13.remove(var13.size() - 1);
                  ArrayList var25 = (ArrayList)var8.b(var15);
                  if(var20) {
                     return;
                  }

                  int var26 = var25.size() - 1;

                  while(var26 >= 0) {
                     y.c.d var27 = (y.c.d)var25.get(var26);
                     y.c.q var19 = var27.a(var15);
                     var10.a(var19, var10.c(var19) + var6.c(var19) * (var10.c(var15) + 1.0D) / var6.c(var15));
                     var9.a(var27, var6.c(var19) * (var10.c(var15) + 1.0D) / var6.c(var15));
                     var3.a(var27, var3.c(var27) + var9.c(var27));
                     --var26;
                     if(var20) {
                        return;
                     }

                     if(var20) {
                        continue label150;
                     }

                     if(var20) {
                        break label78;
                     }
                  }
               }
            }

            var0.a(var6);
            var0.a(var8);
            var0.a(var7);
            var0.a(var9);
            var0.a(var10);
            return;
         }
      }
   }

   protected static void a(y.c.i var0, List var1, List var2, y.c.h var3, boolean var4, y.c.c var5) {
      boolean var30 = h.a;
      if(var0.h() != 0) {
         int var6 = var0.f();
         double var7 = 0.01D;
         y.c.A var13 = y.g.M.a(new double[var6]);
         y.c.A var14 = y.g.M.a(new double[var6]);
         y.c.A var15 = y.g.M.a((Object[])(new ArrayList[var6]));
         y.c.A var16 = y.g.M.a(new double[var6]);
         y.c.A var17 = y.g.M.a(new double[var6]);
         y.c.A var18 = y.g.M.a(new boolean[var6]);
         y.c.A var19 = y.g.M.a(new double[var6]);
         y.c.h var20 = y.g.M.b(new double[var0.h()]);
         y.g.a.c var21 = new y.g.a.c(var0);
         ListIterator var22 = var1.listIterator();

         label244:
         while(true) {
            if(var22.hasNext()) {
               Object var10000 = var22.next();

               ArrayList var24;
               ArrayList var36;
               y.c.q var37;
               int var38;
               label239:
               while(true) {
                  y.c.q var23 = (y.c.q)var10000;
                  var24 = new ArrayList();
                  ListIterator var25 = var2.listIterator();

                  label122: {
                     while(var25.hasNext()) {
                        var20.a(var25.next(), 0.0D);
                        if(var30) {
                           break label122;
                        }

                        if(var30) {
                           break;
                        }
                     }

                     var25 = var1.listIterator();
                  }

                  y.c.q var26;
                  y.c.q var31;
                  label135: {
                     while(var25.hasNext()) {
                        var26 = (y.c.q)var25.next();
                        var15.a(var26, new ArrayList());
                        var16.a(var26, 0.0D);
                        var19.a(var26, 0.0D);
                        var31 = var26;
                        if(var30) {
                           break label135;
                        }

                        if(var26 != var23) {
                           var13.a(var26, 0.0D);
                           var18.a(var26, false);
                           var14.a(var26, Double.MAX_VALUE);
                           var17.a(var26, Double.MAX_VALUE);
                           if(!var30) {
                              continue;
                           }
                        }

                        var13.a(var26, 1.0D);
                        var14.a(var26, 0.0D);
                        var18.a(var26, true);
                        if(var30) {
                           break;
                        }
                     }

                     var21.c();
                     var31 = var23;
                  }

                  y.c.d var35 = var31.f();

                  ArrayList var27;
                  int var32;
                  label152: {
                     while(var35 != null) {
                        var26 = var35.d();
                        double var43;
                        var32 = (var43 = var5.c(var35) - Double.POSITIVE_INFINITY) == 0.0D?0:(var43 < 0.0D?-1:1);
                        if(var30) {
                           break label152;
                        }

                        if(var32 == 0) {
                           throw new ArithmeticException("Edge weight between " + var23 + " and " + var26 + " overflows double");
                        }

                        label148: {
                           var17.a(var26, var5.c(var35));
                           if(!var21.a(var26)) {
                              var21.a(var26, var17.c(var26));
                              if(!var30) {
                                 break label148;
                              }
                           }

                           var21.d(var26, var17.c(var26));
                        }

                        var27 = (ArrayList)var15.b(var26);
                        var27.add(var35);
                        var15.a(var26, var27);
                        var35 = var35.g();
                        if(var30) {
                           break;
                        }
                     }

                     var32 = var4;
                  }

                  boolean var33;
                  label169: {
                     if(var32 == 0) {
                        var35 = var23.g();

                        while(var35 != null) {
                           var26 = var35.c();
                           var17.a(var26, var5.c(var35));
                           var33 = var21.a(var26);
                           if(var30) {
                              break label169;
                           }

                           label163: {
                              if(!var33) {
                                 var21.a(var26, var17.c(var26));
                                 if(!var30) {
                                    break label163;
                                 }
                              }

                              var21.d(var26, var17.c(var26));
                           }

                           var27 = (ArrayList)var15.b(var26);
                           var27.add(var35);
                           var15.a(var26, var27);
                           var35 = var35.h();
                           if(var30) {
                              break;
                           }
                        }
                     }

                     var24.add(var23);
                  }

                  label237:
                  while(true) {
                     var33 = var21.b();

                     while(true) {
                        if(var33) {
                           break label239;
                        }

                        var37 = var21.a();
                        var24.add(var37);
                        var14.a(var37, var17.c(var37));
                        var18.a(var37, true);
                        var36 = (ArrayList)var15.b(var37);
                        var38 = var36.size() - 1;

                        label187: {
                           while(var38 >= 0) {
                              var13.a(var37, var13.c(var37) + var13.c(((y.c.d)var36.get(var38)).a(var37)));
                              --var38;
                              if(var30) {
                                 break label187;
                              }

                              if(var30) {
                                 break;
                              }
                           }

                           if(var13.c(var37) == Double.POSITIVE_INFINITY) {
                              throw new ArithmeticException("Number of Paths between " + var23 + " and " + var37 + " overflows double");
                           }
                        }

                        y.c.d var39 = var37.f();

                        double var9;
                        double var11;
                        y.c.q var28;
                        ArrayList var29;
                        byte var34;
                        label211: {
                           while(var39 != null) {
                              var28 = var39.d();
                              var34 = var18.d(var28);
                              if(var30) {
                                 break label211;
                              }

                              if(var34 == 0) {
                                 label257: {
                                    var9 = var14.c(var37) + var5.c(var39);
                                    var11 = var17.c(var28);
                                    if(var9 == Double.POSITIVE_INFINITY) {
                                       throw new ArithmeticException("Distance between " + var23 + " and " + var37 + " overflows double");
                                    }

                                    if(Math.abs(var9 - var11) < var7) {
                                       var29 = (ArrayList)var15.b(var28);
                                       var29.add(var39);
                                       var15.a(var28, var29);
                                       if(!var30) {
                                          break label257;
                                       }
                                    }

                                    if(var9 < var11) {
                                       label199: {
                                          var17.a(var28, var9);
                                          if(!var21.a(var28)) {
                                             var21.a(var28, var17.c(var28));
                                             if(!var30) {
                                                break label199;
                                             }
                                          }

                                          var21.d(var28, var17.c(var28));
                                       }

                                       var29 = (ArrayList)var15.b(var28);
                                       var29.clear();
                                       var29.add(var39);
                                       var15.a(var28, var29);
                                    }
                                 }
                              }

                              var39 = var39.g();
                              if(var30) {
                                 break;
                              }
                           }

                           var34 = var4;
                        }

                        if(var34 != 0) {
                           break;
                        }

                        var10000 = var37.g();
                        if(var30) {
                           continue label239;
                        }

                        Object var41 = var10000;

                        while(true) {
                           if(var41 == null) {
                              continue label237;
                           }

                           var28 = ((y.c.d)var41).c();
                           var33 = var18.d(var28);
                           if(var30) {
                              break;
                           }

                           if(!var33) {
                              label262: {
                                 var9 = var14.c(var37) + var5.c(var41);
                                 var11 = var17.c(var28);
                                 if(var9 == Double.POSITIVE_INFINITY) {
                                    throw new ArithmeticException("Distance between " + var23 + " and " + var37 + " overflows double");
                                 }

                                 if(Math.abs(var9 - var11) < var7) {
                                    var29 = (ArrayList)var15.b(var28);
                                    var29.add(var41);
                                    var15.a(var28, var29);
                                    if(!var30) {
                                       break label262;
                                    }
                                 }

                                 if(var9 < var11) {
                                    label226: {
                                       var17.a(var28, var9);
                                       if(!var21.a(var28)) {
                                          var21.a(var28, var17.c(var28));
                                          if(!var30) {
                                             break label226;
                                          }
                                       }

                                       var21.d(var28, var17.c(var28));
                                    }

                                    var29 = (ArrayList)var15.b(var28);
                                    var29.clear();
                                    var29.add(var41);
                                    var15.a(var28, var29);
                                 }
                              }
                           }

                           var41 = ((y.c.d)var41).h();
                           if(var30) {
                              break label239;
                           }
                        }
                     }
                  }
               }

               label109:
               while(true) {
                  if(var24.isEmpty()) {
                     continue label244;
                  }

                  var37 = (y.c.q)var24.remove(var24.size() - 1);
                  var36 = (ArrayList)var15.b(var37);
                  if(var30) {
                     return;
                  }

                  var38 = var36.size() - 1;

                  while(var38 >= 0) {
                     y.c.d var40 = (y.c.d)var36.get(var38);
                     y.c.q var42 = var40.a(var37);
                     var19.a(var42, var19.c(var42) + var13.c(var42) * (var19.c(var37) + 1.0D) / var13.c(var37));
                     var20.a(var40, var13.c(var42) * (var19.c(var37) + 1.0D) / var13.c(var37));
                     var3.a(var40, var3.c(var40) + var20.c(var40));
                     --var38;
                     if(var30) {
                        return;
                     }

                     if(var30) {
                        continue label244;
                     }

                     if(var30) {
                        break label109;
                     }
                  }
               }
            }

            var0.a(var13);
            var0.a(var16);
            var0.a(var15);
            var0.a(var17);
            var0.a(var14);
            var0.a(var18);
            var0.a(var20);
            var0.a(var19);
            return;
         }
      }
   }
}
