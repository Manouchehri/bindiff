package y.a;

import java.util.ArrayList;
import java.util.List;
import y.a.h;

class ab {
   private y.c.y a;
   private y.c.p[] b;
   private List c;
   private int d;
   private int[] e;
   private int[] f;
   private int[] g;
   private int h;
   private y.g.c i;

   public int a(y.c.i var1, int[] var2, int[] var3, long var4) {
      boolean var14 = h.a;
      long var6 = System.currentTimeMillis();
      this.b = new y.c.p[var1.e()];
      this.a = new y.c.y();
      this.e = var2;
      this.f = var3;
      this.g = new int[var1.e()];
      this.h = 0;
      this.i = new y.g.c(this.b.length);
      this.c = new ArrayList(var1.e() * 2);
      this.d = 0;
      y.c.q var8 = var1.k();
      int var9 = var8.d();
      this.i.b(var8);
      this.b[var9] = this.a.a(var8);

      while(!this.i.e() && System.currentTimeMillis() - var6 < var4) {
         this.b();
         if(this.a.size() + this.d < var1.e()) {
            this.a();
            if(var14) {
               break;
            }
         }
      }

      int var10 = 0;
      int var11 = this.c.size() - 1;

      byte var10000;
      while(true) {
         if(var11 >= 0) {
            Object var12 = this.c.get(var11);
            var10000 = var12 instanceof Integer;
            if(var14) {
               break;
            }

            label50: {
               if(var10000 != 0) {
                  var10 += ((Integer)var12).intValue();
                  if(!var14) {
                     break label50;
                  }
               }

               int[] var16 = this.e;
               int var10001 = ((y.c.q)var12).d();
               var16[var10001] += var10;
            }

            --var11;
            if(!var14) {
               continue;
            }
         }

         var11 = Integer.MAX_VALUE;
         var10000 = 0;
         break;
      }

      int var15 = var10000;
      int var13 = this.e.length - 1;

      while(true) {
         if(var13 >= 0) {
            var11 = Math.min(var11, this.e[var13]);
            var15 = Math.max(var15, this.e[var13]);
            --var13;
            if(var14) {
               break;
            }

            if(!var14) {
               continue;
            }
         }

         var13 = var2.length - 1;
         break;
      }

      while(true) {
         if(var13 >= 0) {
            var2[var13] -= var11;
            --var13;
            if(var14) {
               break;
            }

            if(!var14) {
               continue;
            }
         }

         this.b = null;
         this.a = null;
         this.c = null;
         this.f = null;
         this.i = null;
         this.e = null;
         break;
      }

      return var15 - var11 + 1;
   }

   private void a() {
      boolean var9 = h.a;
      ++this.h;
      int var1 = Integer.MAX_VALUE;
      boolean var2 = true;
      y.c.p var3 = this.a.k();

      int var14;
      label114: {
         while(true) {
            if(var3 != null) {
               y.c.q var4 = (y.c.q)var3.c();
               boolean var5 = true;
               if(var9) {
                  break;
               }

               y.c.d var6 = var4.g();

               y.c.p var10000;
               label119: {
                  y.c.q var7;
                  int var8;
                  while(var6 != null) {
                     var7 = var6.c();
                     var10000 = this.b[var7.d()];
                     if(var9) {
                        break label119;
                     }

                     if(var10000 == null) {
                        var5 = false;
                        var8 = this.e[var4.d()] - this.e[var7.d()] - this.f[var6.b()];
                        if(var8 > 0) {
                           label102: {
                              if(var8 < var1) {
                                 var1 = var8;
                                 this.i.c();
                                 ++this.h;
                                 this.i.a(var7);
                                 this.g[var7.d()] = this.h;
                                 var2 = true;
                                 if(!var9) {
                                    break label102;
                                 }
                              }

                              if(var2 && var8 == var1 && this.g[var7.d()] < this.h) {
                                 this.i.a(var7);
                                 this.g[var7.d()] = this.h;
                              }
                           }
                        }
                     }

                     var6 = var6.h();
                     if(var9) {
                        break;
                     }
                  }

                  var6 = var4.f();

                  while(var6 != null) {
                     var7 = var6.d();
                     var10000 = this.b[var7.d()];
                     if(var9) {
                        break label119;
                     }

                     if(var10000 == null) {
                        var5 = false;
                        var8 = this.e[var7.d()] - this.e[var4.d()] - this.f[var6.b()];
                        if(var8 > 0) {
                           label87: {
                              if(var8 < var1) {
                                 var1 = var8;
                                 this.i.c();
                                 ++this.h;
                                 this.i.a(var7);
                                 this.g[var7.d()] = this.h;
                                 var2 = false;
                                 if(!var9) {
                                    break label87;
                                 }
                              }

                              if(!var2 && var8 == var1 && this.g[var7.d()] < this.h) {
                                 this.i.a(var7);
                                 this.g[var7.d()] = this.h;
                              }
                           }
                        }
                     }

                     var6 = var6.g();
                     if(var9) {
                        break;
                     }
                  }

                  if(var5) {
                     this.c.add(var4);
                     ++this.d;
                     this.a.h(this.b[var4.d()]);
                  }

                  var10000 = var3.a();
               }

               var3 = var10000;
               if(!var9) {
                  continue;
               }
            }

            if(var2) {
               var14 = -var1;
               break label114;
            }
            break;
         }

         var14 = var1;
      }

      int var10 = var14;
      this.c.add(new Integer(var10));
      y.c.p var11 = this.a.k();

      ab var15;
      while(true) {
         if(var11 != null) {
            var15 = this;
            if(var9) {
               break;
            }

            int[] var16 = this.e;
            int var10001 = ((y.c.q)var11.c()).d();
            var16[var10001] += var10;
            var11 = var11.a();
            if(!var9) {
               continue;
            }
         }

         var15 = this;
         break;
      }

      int var12 = var15.i.d();

      while(var12 > 0) {
         y.c.q var13 = (y.c.q)this.i.a();
         this.b[var13.d()] = this.a.a(var13);
         this.i.a(var13);
         --var12;
         if(var9) {
            break;
         }
      }

   }

   private void b() {
      boolean var7 = h.a;

      while(!this.i.e()) {
         boolean var1 = true;
         Object var10000 = this.i.a();

         y.c.q var2;
         int var3;
         label64:
         while(true) {
            y.c.d var4;
            y.c.q var5;
            int var6;
            label47:
            while(true) {
               var2 = (y.c.q)var10000;
               var3 = var2.d();
               var4 = var2.f();

               while(true) {
                  if(var4 == null) {
                     break label47;
                  }

                  var5 = var4.d();
                  var10000 = this.b[var5.d()];
                  if(var7) {
                     break;
                  }

                  if(var10000 == null) {
                     label77: {
                        var6 = this.e[var5.d()] - this.e[var3] - this.f[var4.b()];
                        if(var6 == 0) {
                           this.i.a(var5);
                           this.b[var5.d()] = this.a.a(var5);
                           if(!var7) {
                              break label77;
                           }
                        }

                        var1 = false;
                     }
                  }

                  var4 = var4.g();
                  if(var7) {
                     break label47;
                  }
               }
            }

            var4 = var2.g();

            while(true) {
               if(var4 == null) {
                  break label64;
               }

               var5 = var4.c();
               var10000 = this.b[var5.d()];
               if(var7) {
                  break;
               }

               if(var10000 == null) {
                  label78: {
                     var6 = this.e[var3] - this.e[var5.d()] - this.f[var4.b()];
                     if(var6 == 0) {
                        this.i.a(var5);
                        this.b[var5.d()] = this.a.a(var5);
                        if(!var7) {
                           break label78;
                        }
                     }

                     var1 = false;
                  }
               }

               var4 = var4.h();
               if(var7) {
                  break label64;
               }
            }
         }

         if(var1) {
            this.c.add(var2);
            ++this.d;
            this.a.h(this.b[var3]);
            if(var7) {
               break;
            }
         }
      }

   }
}
