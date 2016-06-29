package y.f.i.a;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.i.a.M;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.ai;
import y.f.i.a.ak;
import y.f.i.a.al;
import y.f.i.a.am;
import y.f.i.a.an;
import y.f.i.a.ao;
import y.f.i.a.ap;
import y.f.i.a.aq;
import y.f.i.a.h;
import y.f.i.a.w;

class aj implements Comparator {
   private final y.c.D a;
   private final ac b;
   private final Map c;
   private final Z d;
   private int[] e;
   private int[] f;

   public aj(y.c.D var1, ac var2, Z var3) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
      this.c = new HashMap();
      this.a();
   }

   public int compare(Object var1, Object var2) {
      ai var3 = (ai)var1;
      ai var4 = (ai)var2;
      ai var5 = var3.k() != null?var3.k().c():var3;
      ai var6 = var4.k() != null?var4.k().c():var4;
      ap var7 = new ap(this, var5, var6);
      if(this.c.containsKey(var7)) {
         return ((Integer)this.c.get(var7)).intValue();
      } else {
         ap var8 = new ap(this, var6, var5);
         if(this.c.containsKey(var8)) {
            return -((Integer)this.c.get(var8)).intValue();
         } else {
            boolean var9 = var3.g()?y.f.y.a == var3.h():y.f.y.b == var3.h();
            boolean var10 = var4.g()?y.f.y.a == var4.h():y.f.y.b == var4.h();
            int var11 = var9?this.e[var3.i().b()]:this.f[var3.i().b()];
            int var12 = var10?this.e[var4.i().b()]:this.f[var4.i().b()];
            return var11 - var12;
         }
      }
   }

   private void a() {
      int var4 = ab.a;
      am var1 = new am(this.d.a());
      y.c.C var2 = this.a.m();

      while(true) {
         if(var2.f()) {
            h var3 = (h)var2.d();
            this.a(var3, var1);
            var2.g();
            if(var4 != 0) {
               break;
            }

            if(var4 == 0) {
               continue;
            }
         }

         this.a(var1);
         break;
      }

   }

   private void a(h var1, am var2) {
      int var29 = ab.a;
      ai[] var3 = new ai[var1.d().size()];
      an[] var4 = new an[var3.length];
      al[] var5 = this.a(var1);
      Iterator var6 = var1.d().iterator();
      int var7 = 0;

      while(var6.hasNext()) {
         ai var8 = (ai)var6.next();
         var3[var7] = var8;
         var4[var7] = this.a(var8);
         ++var7;
         if(var29 != 0) {
            break;
         }
      }

      y.c.D var30 = new y.c.D();
      int var31 = 0;

      int var32;
      label229:
      while(true) {
         if(var31 < var3.length) {
            ai var9 = var3[var31];
            an var10 = var4[var31];
            y.c.d var11 = var9.i();
            ai var10000 = var9;

            label224:
            while(true) {
               M var12 = var10000.c();
               al var13 = var5[var31];
               var32 = var31 + 1;
               if(var29 != 0) {
                  break label229;
               }

               int var14 = var32;

               while(true) {
                  if(var14 >= var3.length) {
                     break label224;
                  }

                  int var15 = 0;
                  ai var16 = var3[var14];
                  var10000 = var9;
                  if(var29 != 0) {
                     break;
                  }

                  if(var9.k() == null || var9.k() != var16.k()) {
                     y.c.d var18;
                     al var20;
                     boolean var21;
                     int var27;
                     label273: {
                        an var17 = var4[var14];
                        var18 = var16.i();
                        M var19 = var16.c();
                        var20 = var5[var14];
                        var21 = false;
                        if(var12.b() <= var19.a() || var12.a() >= var19.b()) {
                           boolean var22 = var12.a() < var19.b();
                           boolean var23 = var19.a() < var12.b();
                           if(var22) {
                              var15 = -5;
                              var21 = true;
                              if(var29 == 0) {
                                 break label273;
                              }
                           }

                           if(var23) {
                              var15 = 5;
                              var21 = true;
                              if(var29 == 0) {
                                 break label273;
                              }
                           }

                           var15 = 0;
                           if(var29 == 0) {
                              break label273;
                           }
                        }

                        M var33 = this.b(var9);
                        M var35 = this.c(var9);
                        M var24 = this.b(var16);
                        M var25 = this.c(var16);
                        int var26 = 0;
                        var27 = 0;
                        if(this.b(var33, var16)) {
                           label256: {
                              if(this.a(var33, var16)) {
                                 var26 += var10.a();
                                 if(var29 == 0) {
                                    break label256;
                                 }
                              }

                              var27 += var10.a();
                           }
                        }

                        if(this.b(var35, var16)) {
                           label257: {
                              if(this.a(var35, var16)) {
                                 var26 += var10.b();
                                 if(var29 == 0) {
                                    break label257;
                                 }
                              }

                              var27 += var10.b();
                           }
                        }

                        if(this.b(var24, var9)) {
                           label258: {
                              if(this.a(var24, var9)) {
                                 var26 -= var17.a();
                                 if(var29 == 0) {
                                    break label258;
                                 }
                              }

                              var27 -= var17.a();
                           }
                        }

                        if(this.b(var25, var9)) {
                           label259: {
                              if(this.a(var25, var9)) {
                                 var26 -= var17.b();
                                 if(var29 == 0) {
                                    break label259;
                                 }
                              }

                              var27 -= var17.b();
                           }
                        }

                        if(var26 != 0) {
                           var15 += var26;
                           var21 = true;
                           if(var29 == 0) {
                              break label273;
                           }
                        }

                        if(var27 != 0) {
                           var15 += var27;
                           if(var29 == 0) {
                              break label273;
                           }
                        }

                        int var28 = this.a(var12, var19);
                        if(var28 != 0) {
                           var15 += var28;
                           if(var29 == 0) {
                              break label273;
                           }
                        }

                        var15 += var9.d() - var16.d();
                     }

                     if(var15 != 0) {
                        label274: {
                           if(al.a(var13) == 0 && al.a(var20) == 0) {
                              if(var21) {
                                 this.a(var9, var16, var15, var30);
                              }

                              var2.a(var9, var16, var15);
                              if(var29 == 0) {
                                 break label274;
                              }
                           }

                           if(var13.equals(var20)) {
                              if(al.a(var13) == 1) {
                                 this.a(var9, var16, var15, var30);
                                 if(var29 == 0) {
                                    break label274;
                                 }
                              }

                              if(var21) {
                                 this.a(var9, var16, var15, var30);
                                 if(var29 == 0) {
                                    break label274;
                                 }
                              }

                              var15 = -var15;
                              this.a(var9, var16, var15, var30);
                              if(var29 == 0) {
                                 break label274;
                              }
                           }

                           if(al.a(var13) == 2 && al.a(var20) == 2) {
                              if(al.b(var13).h() == al.b(var20).h()) {
                                 var2.a(var9, var16, var15);
                                 if(var29 == 0) {
                                    break label274;
                                 }
                              }

                              this.a(var9, var16, var15, var30);
                              if(var29 == 0) {
                                 break label274;
                              }
                           }

                           if(al.a(var13) == 2 || al.a(var20) == 2) {
                              if(al.a(var13) == 1 || al.a(var20) == 1) {
                                 this.a(var9, var16, var15, var30);
                                 w var34 = this.b.a(var11);
                                 ai var36 = var34.b(al.b(var13));
                                 w var37 = this.b.a(var18);
                                 ai var38 = var37.b(al.b(var20));
                                 y.f.y var39;
                                 if(al.a(var13) == 2) {
                                    var39 = al.b(var13).h();
                                    var27 = var39 != y.f.y.b && var39 != y.f.y.c?Math.abs(var15):-Math.abs(var15);
                                    var2.a(var36, var38, var27);
                                    if(var29 == 0) {
                                       break label274;
                                    }
                                 }

                                 var39 = al.b(var20).h();
                                 var27 = var39 != y.f.y.b && var39 != y.f.y.c?Math.abs(var15):-Math.abs(var15);
                                 var2.a(var38, var36, var27);
                                 if(var29 == 0) {
                                    break label274;
                                 }
                              }

                              this.a(var9, var16, var15, var30);
                              if(var29 == 0) {
                                 break label274;
                              }
                           }

                           if(var21) {
                              this.a(var9, var16, var15, var30);
                           }

                           var2.a(var9, var16, var15);
                        }
                     }
                  }

                  ++var14;
                  if(var29 != 0) {
                     break label224;
                  }
               }
            }

            ++var31;
            if(var29 == 0) {
               continue;
            }
         }

         var32 = var30.size();
         break;
      }

      if(var32 > 0) {
         this.a(var1.d(), var30);
      }

   }

   private boolean a(M var1, ai var2) {
      if(var2.a() == null) {
         return false;
      } else {
         M var3 = new M(var2.a().a() - 1.0D, var2.a().b() + 1.0D);
         return var1.c(var3);
      }
   }

   private boolean b(M var1, ai var2) {
      return var1.b(var2.b()) <= 1.0D;
   }

   private void a(ai var1, ai var2, int var3, y.c.D var4) {
      ai var5 = var1.k() != null?var1.k().c():var1;
      ai var6 = var2.k() != null?var2.k().c():var2;
      if(var5 != var6) {
         this.c.put(new ap(this, var5, var6), new Integer(var3));
         var4.add(var3 < 0?new ap(this, var5, var6):new ap(this, var6, var5));
      }

   }

   private void a(List var1, y.c.D var2) {
      int var17 = ab.a;
      y.c.i var3 = new y.c.i();
      y.c.h var4 = var3.u();
      y.c.D var5 = new y.c.D();
      y.c.D var6 = new y.c.D();
      HashSet var7 = new HashSet(var1.size());
      y.c.A var8 = var3.t();
      HashMap var9 = new HashMap();
      Iterator var10 = var2.iterator();

      y.c.q var14;
      while(var10.hasNext()) {
         ap var11 = (ap)var10.next();
         ai var12 = var11.a;
         if(var7.add(var12)) {
            y.c.q var13 = var3.d();
            var5.add(var13);
            var9.put(var12, var13);
            var8.a(var13, var12);
            var6.add(var12);
         }

         ai var21 = var11.b;
         if(var7.add(var21)) {
            var14 = var3.d();
            var5.add(var14);
            var9.put(var21, var14);
            var8.a(var14, var21);
            var6.add(var21);
         }

         var14 = (y.c.q)var9.get(var12);
         y.c.q var15 = (y.c.q)var9.get(var21);
         y.c.d var16 = var3.a(var14, var15);
         var4.a(var16, 1);
         if(var17 != 0) {
            break;
         }
      }

      y.c.q[] var18 = (y.c.q[])var5.toArray(new y.c.q[var5.size()]);
      int[] var19 = this.a(var3, var18, var4);
      HashMap var20 = new HashMap();
      int var22 = 0;

      while(true) {
         if(var22 < var18.length) {
            var14 = var18[var22];
            var20.put(var8.b(var14), new Integer(var19[var22]));
            ++var22;
            if(var17 != 0) {
               break;
            }

            if(var17 == 0) {
               continue;
            }
         }

         var6.sort(new ak(this, var20));
         break;
      }

      y.c.D var23 = new y.c.D();
      Iterator var24 = var6.iterator();

      while(var24.hasNext()) {
         ai var26 = (ai)var24.next();
         if(var26.k() != null) {
            List var28 = var26.k().b();
            var7.addAll(var28);
            var23.addAll(var28);
            if(var17 == 0) {
               continue;
            }
         }

         var23.add(var26);
         if(var17 != 0) {
            break;
         }
      }

      int var25 = 0;
      Iterator var27 = var1.iterator();

      while(true) {
         if(var27.hasNext()) {
            ai var29 = (ai)var27.next();
            boolean var10000 = var7.add(var29);
            if(var17 != 0) {
               break;
            }

            if(var10000) {
               var23.add(var25, var29);
            }

            ++var25;
            if(var17 == 0) {
               continue;
            }
         }

         var1.clear();
         var1.addAll(var23);
         break;
      }

   }

   private al[] a(h var1) {
      int var10 = ab.a;
      List var2 = var1.d();
      al[] var3 = new al[var2.size()];
      HashMap var4 = new HashMap();
      int var5 = 0;
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         al var9;
         label17: {
            ai var7 = (ai)var6.next();
            y.c.d var8 = var7.i();
            if(var4.containsKey(var8)) {
               var9 = (al)var4.get(var8);
               var9.a(var7);
               if(var10 == 0) {
                  break label17;
               }
            }

            var9 = new al(var7);
            var4.put(var8, var9);
         }

         var3[var5] = var9;
         ++var5;
         if(var10 != 0) {
            break;
         }
      }

      return var3;
   }

   private an a(ai var1) {
      w var2 = this.b.a(var1.i());
      ai var3 = var2.a(var1);
      ai var4 = var2.b(var1);
      return new an(var3, var1, var4);
   }

   private M b(ai var1) {
      return var1.a() == null?var1.b():(var1.g()?new M(var1.a().b(), var1.b().b()):new M(var1.b().a(), var1.a().a()));
   }

   private M c(ai var1) {
      return var1.a() == null?var1.b():(var1.g()?new M(var1.b().a(), var1.a().a()):new M(var1.a().b(), var1.b().b()));
   }

   private int a(M var1, M var2) {
      return (int)a(var1.c() - var2.c());
   }

   private static double a(double var0) {
      return Double.isNaN(var0)?Double.NaN:(var0 > 0.0D?1.0D:(var0 < 0.0D?-1.0D:var0));
   }

   private void a(am var1) {
      int var9 = ab.a;
      y.c.i var2 = new y.c.i();
      int var3 = var1.a();
      y.c.q[] var4 = new y.c.q[var3];
      int var5 = 0;

      while(var5 < var3) {
         var4[var5] = var2.d();
         ++var5;
         if(var9 != 0) {
            break;
         }
      }

      y.c.h var10 = var2.u();
      int var6 = 1;

      label41:
      do {
         int var10000 = var6;

         label38:
         while(true) {
            if(var10000 >= var3) {
               break label41;
            }

            int var7 = 0;

            while(true) {
               if(var7 >= var6) {
                  break label38;
               }

               byte var8 = var1.a(var6, var7);
               var10000 = var8;
               if(var9 != 0) {
                  break;
               }

               label33: {
                  if(var8 > 0) {
                     var10.a(var2.a(var4[var6], var4[var7]), var8);
                     if(var9 == 0) {
                        break label33;
                     }
                  }

                  if(var8 < 0) {
                     var10.a(var2.a(var4[var7], var4[var6]), -var8);
                  }
               }

               ++var7;
               if(var9 != 0) {
                  break label38;
               }
            }
         }

         ++var6;
      } while(var9 == 0);

      int[] var11 = this.a(var2, var4, var10);
      this.e = new int[this.d.a().g()];
      this.f = new int[this.d.a().g()];
      System.arraycopy(var11, 0, this.e, 0, this.e.length);
      System.arraycopy(var11, this.e.length, this.f, 0, this.f.length);
   }

   private int[] a(y.c.i var1, y.c.q[] var2, y.c.h var3) {
      int var15 = ab.a;
      this.a((y.c.i)var1, (y.c.c)var3);
      y.g.a.d var4 = new y.g.a.d(var1);
      int var5 = 1;
      int[] var6 = new int[var1.e()];
      int[] var7 = new int[var1.e()];
      int var8 = var1.e() / 2;
      int var9 = 0;

      y.c.q var10;
      int var10000;
      while(true) {
         if(var9 < var2.length) {
            var10 = var2[var9];
            var10000 = var10.b();
            if(var15 != 0) {
               break;
            }

            label87: {
               if(var10000 == 0) {
                  int var11 = var9 < var8?var9 + var8:var9 - var8;
                  if(var7[var11] != 0) {
                     var7[var9] = -var7[var11];
                     var4.a(var10, var7[var9]);
                     if(var15 == 0) {
                        break label87;
                     }
                  }

                  var7[var9] = var5;
                  var4.a(var10, var5++);
                  if(var15 == 0) {
                     break label87;
                  }
               }

               var6[var9] = var10.b();
            }

            ++var9;
            if(var15 == 0) {
               continue;
            }
         }

         var10000 = 1;
         break;
      }

      var9 = var10000;

      label74:
      while(true) {
         var10000 = var4.a();

         label71:
         while(var10000 == 0) {
            var10 = var4.c();
            var7[var10.d()] = var9++;
            y.c.d var17 = var10.f();

            while(true) {
               if(var17 == null) {
                  continue label74;
               }

               y.c.q var12 = var17.d();
               int var13 = var6[var12.d()]--;
               var10000 = var13;
               if(var15 != 0) {
                  break;
               }

               if(var15 != 0) {
                  break label74;
               }

               if(var13 == 1) {
                  label102: {
                     y.c.q var14 = var12.d() < var8?var2[var12.d() + var8]:var2[var12.d() - var8];
                     if(var7[var14.d()] != 0) {
                        var4.a(var12, -var7[var14.d()]);
                        if(var15 == 0) {
                           break label102;
                        }
                     }

                     var7[var12.d()] = var5;
                     var4.a(var12, var5++);
                  }
               }

               var17 = var17.g();
               if(var15 != 0) {
                  break label71;
               }
            }
         }

         var10000 = 0;
         break;
      }

      int var16 = var10000;

      int[] var18;
      while(true) {
         if(var16 < var7.length) {
            var18 = var7;
            if(var15 != 0) {
               break;
            }

            var7[var16] = -var7[var16];
            ++var16;
            if(var15 == 0) {
               continue;
            }
         }

         var18 = var7;
         break;
      }

      return var18;
   }

   void a(y.c.i var1, y.c.c var2) {
      int var18 = ab.a;
      if(!y.a.g.a(var1)) {
         y.c.h var3 = y.g.M.b();
         y.c.e var4 = var1.p();

         while(var4.f()) {
            y.c.d var5 = var4.a();
            var3.a(var5, var2.a(var5));
            var4.g();
            if(var18 != 0) {
               break;
            }
         }

         y.c.q[] var19 = var1.m();
         int var20 = var1.e() / 2;
         y.c.D var6 = new y.c.D();

         label87:
         while(true) {
            y.c.f var7;
            if(!(var7 = y.a.c.a(var1, true)).isEmpty()) {
               int var10000 = var7.size();
               int var10001 = 1;

               label83:
               while(true) {
                  int var8;
                  y.c.e var9;
                  label75:
                  while(true) {
                     if(var10000 == var10001) {
                        throw new IllegalStateException("Selfloop in Order Graph!");
                     }

                     var8 = Integer.MAX_VALUE;
                     var9 = var7.a();

                     while(true) {
                        if(!var9.f()) {
                           break label75;
                        }

                        int var10 = var3.a(var9.a());
                        var10000 = var10;
                        var10001 = var8;
                        if(var18 != 0) {
                           break;
                        }

                        if(var10 < var8) {
                           var8 = var10;
                        }

                        var9.g();
                        if(var18 != 0) {
                           break label75;
                        }
                     }
                  }

                  var9 = var7.a();

                  while(true) {
                     if(!var9.f()) {
                        continue label87;
                     }

                     y.c.d var23 = var9.a();
                     int var11 = var23.c().d();
                     int var12 = var23.d().d();
                     if(var18 != 0) {
                        break label87;
                     }

                     var10000 = var11;
                     var10001 = var20;
                     if(var18 != 0) {
                        break;
                     }

                     int var13 = var11 >= var20?var11 - var20:var11 + var20;
                     int var14 = var12 >= var20?var12 - var20:var12 + var20;
                     y.c.d var15 = var19[var13].b(var19[var14]);
                     int var16 = var3.a(var23) - var8;
                     var3.a(var23, var16);
                     var3.a(var15, var16);
                     if(var16 == 0) {
                        aq var17 = new aq(var1, var23, var15, (ak)null);
                        var17.b();
                        var6.add(var17);
                     }

                     var9.g();
                     if(var18 != 0) {
                        break label83;
                     }
                  }
               }
            }

            var6.sort(new ao(var2));
            break;
         }

         y.c.C var21 = var6.m();

         while(var21.f()) {
            aq var22 = (aq)var21.d();
            var22.a();
            if(!y.a.g.a(var1)) {
               var22.b();
            }

            var21.g();
            if(var18 != 0) {
               break;
            }
         }

      }
   }
}
