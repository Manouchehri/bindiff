package y.f.h.a;

import java.util.Iterator;
import y.f.h.D;
import y.f.h.a.a;
import y.f.h.a.b;
import y.f.h.a.c;
import y.f.h.a.i;
import y.f.h.a.j;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.r;

public class e extends b {
   int[] h;

   boolean b() {
      boolean var3 = b.g;
      boolean var1 = super.b();
      this.h = new int[this.c.length];
      int var2 = 0;

      while(var2 < this.h.length) {
         this.h[var2] = -1;
         ++var2;
         if(var3) {
            break;
         }
      }

      return var1;
   }

   int a(n var1) {
      boolean var7 = b.g;
      if(this.h[var1.f()] == -1) {
         int var2 = 0;
         if(var1.h() != null) {
            Iterator var3 = var1.h().iterator();

            label29:
            while(var3.hasNext()) {
               i var4 = (i)var3.next();
               m var5 = var4.s();
               r var6 = var5.a((r)var4);
               var2 += var5.a();

               while(var6 != var4) {
                  var2 += this.a((n)var6);
                  var5 = var6.c(var5);
                  var2 += var5.a();
                  var6 = var5.a(var6);
                  if(var7) {
                     break label29;
                  }

                  if(var7) {
                     return this.h[var1.f()];
                  }

                  if(var7) {
                     break label29;
                  }
               }
            }
         }

         this.h[var1.f()] = var2;
      }

      return this.h[var1.f()];
   }

   protected void a(n var1, int var2, int var3) {
      boolean var4 = b.g;

      while(var1.d(var3)) {
         ((a)var1.a(var1.c().c(), var2 ^ 1, var2)).a(2 + this.a(var1));
         if(var4) {
            break;
         }
      }

   }

   protected boolean a(n var1, n var2, m var3) {
      boolean var25 = b.g;
      int var4 = var1.f();
      boolean var5 = false;
      int var6 = 0;
      int[] var7 = new int[2];
      boolean[] var8 = new boolean[2];
      n var9 = var2;
      i var10 = null;
      int var11 = 0;
      boolean var13 = false;
      this.d[0].b();
      this.d[1].b();
      this.e.b();
      this.e.a(var3);
      int var14 = 0;
      boolean var15 = false;
      boolean var16 = false;

      boolean var27;
      while(true) {
         if(!var5 && var6 < 2) {
            var15 = var15 || var16 || var9.c(var4);
            var8[0] = !var9.u();
            var8[1] = false;
            var7[0] = 0;
            var7[1] = 0;
            Object var17 = null;
            m var18 = null;
            i var19 = null;
            int var20 = 0;
            if(!var15 && var9.d(var4)) {
               this.a(var9, 1, var4);
            }

            int var21 = 0;

            int var10000;
            label236: {
               label235:
               do {
                  var10000 = var21;

                  label232:
                  while(true) {
                     if(var10000 >= 2) {
                        break label235;
                     }

                     var10000 = var8[var21];
                     if(var25) {
                        break label236;
                     }

                     if(var10000 != 0) {
                        break;
                     }

                     n var12;
                     int var26;
                     label229: {
                        var12 = var9;
                        var26 = var21;
                        if(var21 == 1 && !var15 && var10 != null) {
                           var17 = var9;
                           var14 = var21;
                           var18 = var9.f(var21 ^ 1);
                           if(!var25) {
                              break label229;
                           }
                        }

                        var18 = var9.f(var21);
                        var17 = var18.a((r)var9);
                        var7[var21] += var18.a();
                        var7[var21] += this.a(var9);
                     }

                     boolean var22 = false;

                     while(true) {
                        n var29;
                        do {
                           do {
                              do {
                                 if(var22 || var8[var21]) {
                                    break label232;
                                 }

                                 if(!(var17 instanceof i)) {
                                    break;
                                 }

                                 i var23;
                                 label258: {
                                    var23 = (i)var17;
                                    var22 = true;
                                    if(var15) {
                                       if(var21 != 1 || var8[0]) {
                                          break label258;
                                       }

                                       if(var7[0] >= var7[1]) {
                                          a(var9, var19, 0, var20, var7[0]);
                                          var8[0] = true;
                                          if(!var25) {
                                             break label258;
                                          }
                                       }

                                       var18 = var19.c(a(var12, var19, var26, var20 ^ 1, var7[1]));
                                       var8[1] = true;
                                       if(!var25) {
                                          break label258;
                                       }
                                    }

                                    if(var21 == 1) {
                                       if(var8[0] || var7[0] >= var7[1]) {
                                          var8[0] = true;
                                          if(!var25) {
                                             break label258;
                                          }
                                       }

                                       var8[1] = true;
                                       var18 = var19.c(a(var12, var19, var26, var20 ^ 1, var7[1]));
                                       if(!var25) {
                                          break label258;
                                       }
                                    }

                                    var18 = a(var12, var23, var26, var23.a(var18, var21 ^ 1), var7[0]);
                                 }

                                 var19 = var23;
                                 var20 = var23.a(var18, var21 ^ 1);
                              } while(!var25);
                           } while(!(var17 instanceof n));

                           var29 = (n)var17;
                           var7[var21] += this.a(var29);
                           var10000 = var29.c(var4);
                           if(var25) {
                              continue label232;
                           }

                           if(var10000 == 0) {
                              break;
                           }

                           ++var6;
                           var8[var21] = true;
                           a(var12, (r)var17, var26, var29.a(var18, 1 ^ var14), var7[var21]);
                           var7[var21] = 0;
                           var16 = true;
                           var22 = !var8[0];
                        } while(!var25);

                        if(var29.e(var4)) {
                           var14 = var29.a(var18, var14 ^ 1) ^ 1;
                           if(var29.d(var4)) {
                              this.a(var29, var14, var4);
                           }

                           if(!var29.m().isEmpty()) {
                              m var24;
                              label218: {
                                 var24 = var29.o();
                                 var26 = var14;
                                 var12 = var29;
                                 var7[var21] = 0;
                                 if(var14 == 1) {
                                    var29.e(var24);
                                    if(!var25) {
                                       break label218;
                                    }
                                 }

                                 var29.d(var24);
                              }

                              var18 = var24;
                              this.d[var21].a(var24);
                              if(var15) {
                                 if(var21 == 1 && !var8[0]) {
                                    a(var9, var19, 0, var20, var7[0]);
                                 }

                                 if(!var8[var21 ^ 1]) {
                                    ++var6;
                                 }

                                 var8[var21 ^ 1] = true;
                              }
                           }
                        }

                        var18 = ((r)var17).c(var18);
                        var17 = var18.a((r)var17);
                        var7[var21] += var18.a();
                        if(var25) {
                           break label232;
                        }
                     }
                  }

                  ++var21;
               } while(!var25);

               var10000 = var6;
            }

            if(var10000 >= 2) {
               continue;
            }

            var27 = var8[0];
            if(var25) {
               break;
            }

            label261: {
               var21 = !var27?0:1;
               if(var10 != null) {
                  if(var11 == var21) {
                     var10.d();
                  }

                  if(var21 == 0) {
                     var9.r().b(var10.r());
                     if(!var25) {
                        break label261;
                     }
                  }

                  var9.r().a(var10.r());
                  if(!var25) {
                     break label261;
                  }
               }

               label150: {
                  if(var21 == 0) {
                     var9.e(var3);
                     if(!var25) {
                        break label150;
                     }
                  }

                  var9.d(var3);
               }

               var9.o();
            }

            this.e.a(this.d[var21]);
            if(!var15) {
               this.e.d(this.d[var21 ^ 1]);
            }

            label137: {
               if(var19.f() == var4) {
                  var5 = true;
                  Iterator var28 = this.e.d();

                  label133: {
                     while(true) {
                        if(var28.hasNext()) {
                           m var30 = (m)var28.next();
                           var30.b(var19);
                           var30.j();
                           if(var25) {
                              break;
                           }

                           if(!var25) {
                              continue;
                           }
                        }

                        if(var20 == 0) {
                           var19.r().b(this.e);
                           if(!var25) {
                              break label133;
                           }
                        }
                        break;
                     }

                     var19.r().c(this.e);
                  }

                  this.e.b();
                  if(!var25) {
                     break label137;
                  }
               }

               var19.e();
               var10 = var19;
               var11 = var20;
               var9 = var19.b();
               var6 = 0;
            }

            this.d[0].b();
            this.d[1].b();
            if(!var25) {
               continue;
            }
         }

         var27 = var5;
         break;
      }

      return var27;
   }

   public boolean a(D var1) {
      this.f = new j();
      if(super.a(var1)) {
         this.f = new c(var1);
         return super.a(var1);
      } else {
         return false;
      }
   }
}
