package y.f.i.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.ai;
import y.f.i.a.bF;
import y.f.i.a.bM;
import y.f.i.a.bO;
import y.f.i.a.v;
import y.f.i.a.w;

class bN {
   final List a;
   final int b;
   final HashSet c;
   final boolean d;
   private final bF e;

   bN(bF var1, List var2, int var3) {
      this.e = var1;
      this.c = new HashSet();
      this.a = var2;
      this.b = var3;
      this.d = ((w)var2.get(0)).a(var3).g();
   }

   y.c.D a() {
      int var9 = ab.a;
      y.c.D var1 = new y.c.D();
      y.c.D var2 = this.b();
      HashMap var3 = new HashMap();
      y.c.p var4 = var2.k();

      y.c.D var12;
      label71:
      while(true) {
         bO var5;
         bN var10;
         int var11;
         if(var4 != null) {
            var5 = (bO)var4.c();
            bO.b(var5);
            Iterator var10000 = var5.a.iterator();
            if(var9 == 0) {
               label76: {
                  Iterator var6 = var10000;

                  while(var6.hasNext()) {
                     w var7 = (w)var6.next();
                     var11 = var3.containsKey(var7);
                     if(var9 != 0) {
                        break label76;
                     }

                     Object var8;
                     label47: {
                        if(var11 != 0) {
                           var8 = (List)var3.get(var7);
                           if(var9 == 0) {
                              break label47;
                           }
                        }

                        var8 = new y.c.D();
                        var3.put(var7, var8);
                     }

                     ((List)var8).add(var4);
                     if(var9 != 0) {
                        break;
                     }
                  }

                  var4 = var4.a();
                  if(var9 == 0) {
                     continue;
                  }

                  var11 = var2.size();
               }
            } else {
               var10 = this.a(var5, var2, var3);
               if(var10 != null) {
                  var12 = var1;
                  if(var9 != 0) {
                     return var12;
                  }

                  var1.add(var10);
                  if(var9 != 0) {
                     break;
                  }
               }

               var11 = var2.size();
            }
         } else {
            var11 = var2.size();
         }

         while(true) {
            if(var11 <= 0) {
               break label71;
            }

            var4 = this.b(var2);
            var5 = (bO)var4.c();
            var2.h(var4);
            var10 = this.a(var5, var2, var3);
            if(var10 != null) {
               var12 = var1;
               if(var9 != 0) {
                  return var12;
               }

               var1.add(var10);
               if(var9 != 0) {
                  break label71;
               }
            }

            var11 = var2.size();
         }
      }

      var12 = var1;
      return var12;
   }

   private bN a(bO var1, y.c.D var2, HashMap var3) {
      int var15 = ab.a;
      HashSet var4 = new HashSet();
      y.c.D var5 = new y.c.D();
      y.c.D var6 = new y.c.D();
      y.c.D var7 = new y.c.D();
      ah var8 = new ah(var1.c, var7);
      Iterator var9 = var1.a.iterator();

      bN var22;
      label113:
      while(true) {
         boolean var10000 = var9.hasNext();

         label110: {
            label109: {
               Object var21;
               label108:
               while(true) {
                  if(var10000) {
                     w var10 = (w)var9.next();
                     ai var11 = var10.a(this.b);
                     if(var1.a.size() > 1) {
                        label125: {
                           var7.add(var11);
                           var11.a(var8);
                           Iterator var12 = var10.d().iterator();

                           while(var12.hasNext()) {
                              v var13 = (v)var12.next();
                              if(var13.i() != null && var13.d() == this.b) {
                                 var13.a(var8);
                              }

                              if(var13.j() != null) {
                                 int var20 = var13.e();
                                 int var10001 = this.b;
                                 if(var15 != 0) {
                                    if(var20 > var10001) {
                                       var6.add(var10);
                                    }
                                    break label125;
                                 }

                                 if(var20 == var10001) {
                                    var13.b(var8);
                                    if(var15 != 0) {
                                       break;
                                    }
                                 }
                              }
                           }

                           if(var10.e() > this.b + 1) {
                              var6.add(var10);
                           }
                        }
                     }

                     List var18 = (List)var3.get(var10);
                     Iterator var19 = var18.iterator();

                     do {
                        y.c.p var14;
                        do {
                           do {
                              if(!var19.hasNext()) {
                                 continue label113;
                              }

                              var14 = (y.c.p)var19.next();
                              var21 = var14.c();
                              if(var15 != 0) {
                                 break label108;
                              }
                           } while(var21 == var1);

                           var10000 = var4.add(var14);
                           if(var15 != 0) {
                              continue label108;
                           }
                        } while(!var10000);

                        var5.add(var14);
                     } while(var15 == 0);
                  }

                  if(var8.b().size() > 0) {
                     var8.d();
                  }

                  var9 = var5.iterator();
                  if(!var9.hasNext()) {
                     break label109;
                  }

                  var21 = var9.next();
                  break;
               }

               while(true) {
                  y.c.p var16 = (y.c.p)var21;
                  bO var17 = (bO)var16.c();
                  if(var17.b(var1.a)) {
                     var2.h(var16);
                     if(var15 != 0) {
                        break label110;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }

                  if(!var9.hasNext()) {
                     break;
                  }

                  var21 = var9.next();
               }
            }

            if(var6.size() > 1) {
               var22 = new bN(this.e, var6, this.b + 1);
               break;
            }
         }

         var22 = null;
         break;
      }

      return var22;
   }

   private y.c.D b() {
      int var8 = ab.a;
      y.f.y var1 = null;
      y.c.D var2 = new y.c.D();
      y.c.D var3 = new y.c.D();
      Iterator var4 = this.a.iterator();

      while(var4.hasNext()) {
         w var5 = (w)var4.next();
         ai var6 = var5.a(this.b);
         y.f.y var7 = var6.h();
         if(var1 == null) {
            var1 = var7;
         }

         if(var1 == var7) {
            var2.add(var5);
            if(var8 == 0) {
               continue;
            }
         }

         var3.add(var5);
         if(var8 != 0) {
            break;
         }
      }

      bM var9 = new bM(this);
      var2.sort(var9);
      var3.sort(var9);
      y.c.D var10 = this.a(var2);
      y.c.D var11 = this.a(var3);
      return this.a(var10, var11);
   }

   private y.c.D a(y.c.D var1) {
      int var12 = ab.a;
      y.c.D var2 = new y.c.D();
      y.c.C var3 = var1.m();

      label61:
      while(true) {
         boolean var10000 = var3.f();

         y.c.D var13;
         label58:
         while(var10000) {
            w var4 = (w)var3.d();
            ai var5 = var4.a(this.b);
            M var6 = var5.c();
            bO var7 = new bO(this, var4);
            var13 = var2;
            if(var12 != 0) {
               return var13;
            }

            y.c.p var8 = var2.k();

            while(var8 != null) {
               bO var9 = (bO)var8.c();
               var10000 = var9.c.d(var6);
               if(var12 != 0) {
                  continue label58;
               }

               label52: {
                  if(var10000) {
                     var7 = null;
                     var9.a(var4);
                  } else if(var6.c(var9.c) && var7 != null) {
                     Iterator var10 = var9.a.iterator();

                     while(var10.hasNext()) {
                        w var11 = (w)var10.next();
                        var7.a(var11);
                        if(var12 != 0) {
                           break label52;
                        }

                        if(var12 != 0) {
                           break;
                        }
                     }
                  }

                  var8 = var8.a();
               }

               if(var12 != 0) {
                  break;
               }
            }

            if(var7 != null) {
               var2.b((Object)var7);
            }

            var3.g();
            if(var12 == 0) {
               continue label61;
            }
            break;
         }

         var13 = var2;
         return var13;
      }
   }

   private y.c.D a(y.c.D var1, y.c.D var2) {
      int var12 = ab.a;
      y.c.D var3 = new y.c.D();
      y.c.p var4 = var2.l();

      y.c.D var10000;
      while(true) {
         if(var4 != null) {
            bO var5 = (bO)var4.c();
            M var6 = var5.c;
            var10000 = var1;
            if(var12 != 0) {
               break;
            }

            y.c.p var7 = var1.l();

            label52: {
               while(var7 != null) {
                  bO var8 = (bO)var7.c();
                  M var9 = var8.c;
                  if(var9.d(var6)) {
                     var8.a(var5);
                     if(var12 == 0) {
                        break;
                     }
                  }

                  if(var6.c(var9)) {
                     var5.a(var8.a);
                     var3.add(var5);
                     if(var12 == 0) {
                        break;
                     }
                  }

                  label45: {
                     if(var9.c(var6)) {
                        var8.a(var5.a);
                        if(var12 == 0) {
                           break label45;
                        }
                     }

                     if(var9.a(var6, 1.0E-6D)) {
                        M var10 = M.a(var9, var6);
                        if(!this.c.contains(var10)) {
                           bO var11 = new bO(this, var8, var5, var10);
                           var3.add(var11);
                        }
                     }
                  }

                  var7 = var7.b();
                  if(var7 == null) {
                     var3.add(var5);
                     if(var12 != 0) {
                        break label52;
                     }

                     if(var12 != 0) {
                        break;
                     }
                  }
               }

               var4 = var4.b();
            }

            if(var12 == 0) {
               continue;
            }
         }

         var3.a(var1);
         var10000 = var3;
         break;
      }

      return var10000;
   }

   private y.c.p b(y.c.D var1) {
      int var9 = ab.a;
      double var2 = Double.MAX_VALUE;
      y.c.p var4 = null;
      y.c.p var5 = var1.k();

      y.c.p var10000;
      while(true) {
         if(var5 != null) {
            var10000 = var5;
            if(var9 != 0) {
               break;
            }

            bO var6 = (bO)var5.c();
            double var7 = var6.a();
            if(var7 < var2) {
               var2 = var7;
               var4 = var5;
            }

            var5 = var5.a();
            if(var9 == 0) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return var10000;
   }

   static bF a(bN var0) {
      return var0.e;
   }
}
