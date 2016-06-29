package y.f.h.a;

import java.util.ArrayList;
import java.util.Iterator;
import y.c.x;
import y.f.h.D;
import y.f.h.a.a;
import y.f.h.a.f;
import y.f.h.a.i;
import y.f.h.a.j;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.r;
import y.f.h.a.s;

public class b {
   D a;
   y.c.i b;
   n[] c;
   protected f[] d;
   protected f e;
   private f h;
   s f;
   public static boolean g;

   public b() {
      this(new j());
   }

   b(s var1) {
      this.d = new f[2];
      this.e = new f();
      this.h = new f();
      this.d[0] = new f();
      this.d[1] = new f();
      this.f = var1;
   }

   public String toString() {
      String var10000;
      String var1;
      label23: {
         boolean var3 = g;
         var1 = "";
         if(this.c != null) {
            int var2 = 0;

            do {
               if(var2 >= this.c.length) {
                  break label23;
               }

               var10000 = var1 + this.c[var2].toString() + "\n";
               if(var3) {
                  return var10000;
               }

               var1 = var10000;
               ++var2;
            } while(!var3);
         }

         var1 = "nodes not initialized yet";
      }

      var10000 = var1;
      return var10000;
   }

   protected void a() {
      boolean var2 = g;
      int var1 = 0;

      while(true) {
         if(var1 < 2) {
            this.d[var1].b();
            ++var1;
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.h.b();
         this.e.b();
         break;
      }

   }

   boolean b() {
      boolean var4 = g;
      this.c = new n[this.b.f()];
      x var1 = this.b.o();

      while(true) {
         if(var1.f()) {
            int var2 = var1.e().d();
            this.c[var2] = new n(var1.e(), -1, (m)null);
            if(var4) {
               break;
            }

            y.c.q var10000 = var1.e();

            label34:
            while(true) {
               y.c.e var3 = var10000.l();

               while(true) {
                  if(!var3.f()) {
                     break label34;
                  }

                  var10000 = var3.a().d();
                  if(var4) {
                     break;
                  }

                  if(var10000 == var3.a().c() && !this.b(var3.a())) {
                     this.c[var2].a(var3.a());
                     this.b.d(var3.a());
                  }

                  var3.g();
                  if(var4) {
                     break label34;
                  }
               }
            }

            var1.g();
            if(!var4) {
               continue;
            }
         }

         this.f.a(this.b);
         this.a(this.f);
         this.e();
         break;
      }

      return true;
   }

   private void e() {
      boolean var3 = g;
      int var1 = 0;

      while(var1 < this.c.length) {
         label27: {
            if(this.c[var1].q() != null) {
               Iterator var2 = this.c[var1].q().iterator();

               while(var2.hasNext()) {
                  this.b.e((y.c.d)var2.next());
                  if(var3) {
                     break label27;
                  }

                  if(var3) {
                     break;
                  }
               }
            }

            ++var1;
         }

         if(var3) {
            break;
         }
      }

   }

   private y.c.d a(y.c.d var1) {
      if(this.a != null) {
         y.c.d var2 = this.a.h(var1);
         return var2 != null?var2:this.a.g(var1);
      } else {
         return null;
      }
   }

   private boolean b(y.c.d var1) {
      return this.a == null?false:this.a.n(this.a.d(var1));
   }

   private boolean a(s param1) {
      // $FF: Couldn't be decompiled
   }

   protected static m a(r var0, r var1, int var2, int var3, int var4) {
      return var1.u()?b(var0, var1, var2, var3, var4):var1.s();
   }

   protected static m b(r var0, r var1, int var2, int var3, int var4) {
      boolean var6 = g;
      if(var0.f(var2) != var1.f(var3)) {
         a var5;
         label25: {
            var5 = var0.f() < var1.f()?new a(var0, var1, 1):new a(var1, var0, 1);
            if(var2 == 0) {
               var0.e(var5);
               if(!var6) {
                  break label25;
               }
            }

            var0.d(var5);
         }

         if(var3 == 0) {
            var1.e(var5);
            if(!var6) {
               return var5;
            }
         }

         var1.d(var5);
         return var5;
      } else {
         return var0.f(var2);
      }
   }

   protected void a(n var1, int var2, int var3) {
      boolean var4 = g;

      while(var1.d(var3)) {
         var1.a(var1.c().c(), var2 ^ 1, var2);
         if(var4) {
            break;
         }
      }

   }

   protected boolean a(n var1, n var2, m var3) {
      boolean var24 = g;
      int var4 = var1.f();
      boolean var5 = false;
      int var6 = 0;
      boolean[] var7 = new boolean[2];
      n var8 = var2;
      i var9 = null;
      int var10 = 0;
      boolean var12 = false;
      this.d[0].b();
      this.d[1].b();
      this.e.b();
      this.e.a(var3);
      int var13 = 0;
      boolean var14 = false;
      boolean var15 = false;

      boolean var26;
      while(true) {
         if(!var5 && var6 < 2) {
            var14 = var14 || var15 || var8.c(var4);
            var7[0] = !var8.u();
            var7[1] = false;
            Object var16 = null;
            m var17 = null;
            i var18 = null;
            int var19 = 0;
            if(!var14 && var8.d(var4)) {
               this.a(var8, 1, var4);
            }

            int var20 = 0;

            int var10000;
            label222: {
               label221:
               do {
                  var10000 = var20;

                  label218:
                  while(true) {
                     if(var10000 >= 2) {
                        break label221;
                     }

                     var10000 = var7[var20];
                     if(var24) {
                        break label222;
                     }

                     if(var10000 != 0) {
                        break;
                     }

                     n var11;
                     int var25;
                     label215: {
                        var11 = var8;
                        var25 = var20;
                        if(var20 == 1 && !var14 && var9 != null) {
                           var16 = var8;
                           var13 = var20;
                           var17 = var8.f(var20 ^ 1);
                           if(!var24) {
                              break label215;
                           }
                        }

                        var17 = var8.f(var20);
                        var16 = var17.a((r)var8);
                     }

                     boolean var21 = false;

                     while(true) {
                        n var28;
                        do {
                           do {
                              do {
                                 if(var21 || var7[var20]) {
                                    break label218;
                                 }

                                 if(!(var16 instanceof i)) {
                                    break;
                                 }

                                 i var22;
                                 label244: {
                                    var22 = (i)var16;
                                    var21 = true;
                                    if(var14) {
                                       if(var20 != 1 || var7[0]) {
                                          break label244;
                                       }

                                       a(var8, var18, 0, var19, 1);
                                       var7[0] = true;
                                       if(!var24) {
                                          break label244;
                                       }
                                    }

                                    if(var20 == 1) {
                                       var7[0] = true;
                                       if(!var24) {
                                          break label244;
                                       }
                                    }

                                    var17 = a(var11, var22, var25, var22.a(var17, var20 ^ 1), 1);
                                 }

                                 var18 = var22;
                                 var19 = var22.a(var17, var20 ^ 1);
                              } while(!var24);
                           } while(!(var16 instanceof n));

                           var28 = (n)var16;
                           var10000 = var28.c(var4);
                           if(var24) {
                              continue label218;
                           }

                           if(var10000 == 0) {
                              break;
                           }

                           ++var6;
                           var7[var20] = true;
                           a(var11, (r)var16, var25, var28.a(var17, 1 ^ var13), 1);
                           var15 = true;
                           var21 = !var7[0];
                        } while(!var24);

                        if(var28.e(var4)) {
                           var13 = var28.a(var17, var13 ^ 1) ^ 1;
                           if(var28.d(var4)) {
                              this.a(var28, var13, var4);
                           }

                           if(!var28.m().isEmpty()) {
                              m var23;
                              label204: {
                                 var23 = var28.o();
                                 var25 = var13;
                                 var11 = var28;
                                 if(var13 == 1) {
                                    var28.e(var23);
                                    if(!var24) {
                                       break label204;
                                    }
                                 }

                                 var28.d(var23);
                              }

                              var17 = var23;
                              this.d[var20].a(var23);
                              if(var14) {
                                 if(var20 == 1 && !var7[0]) {
                                    a(var8, var18, 0, var19, 1);
                                 }

                                 if(!var7[var20 ^ 1]) {
                                    ++var6;
                                 }

                                 var7[var20 ^ 1] = true;
                              }
                           }
                        }

                        var17 = ((r)var16).c(var17);
                        var16 = var17.a((r)var16);
                        if(var24) {
                           break label218;
                        }
                     }
                  }

                  ++var20;
               } while(!var24);

               var10000 = var6;
            }

            if(var10000 >= 2) {
               continue;
            }

            var26 = var7[0];
            if(var24) {
               break;
            }

            label247: {
               var20 = !var26?0:1;
               if(var9 != null) {
                  if(var10 == var20) {
                     var9.d();
                  }

                  if(var20 == 0) {
                     var8.r().b(var9.r());
                     if(!var24) {
                        break label247;
                     }
                  }

                  var8.r().a(var9.r());
                  if(!var24) {
                     break label247;
                  }
               }

               label145: {
                  if(var20 == 0) {
                     var8.e(var3);
                     if(!var24) {
                        break label145;
                     }
                  }

                  var8.d(var3);
               }

               var8.o();
            }

            this.e.a(this.d[var20]);
            if(!var14) {
               this.e.d(this.d[var20 ^ 1]);
            }

            label132: {
               if(var18.f() == var4) {
                  var5 = true;
                  Iterator var27 = this.e.d();

                  label128: {
                     while(true) {
                        if(var27.hasNext()) {
                           m var29 = (m)var27.next();
                           var29.b(var18);
                           var29.j();
                           if(var24) {
                              break;
                           }

                           if(!var24) {
                              continue;
                           }
                        }

                        if(var19 == 0) {
                           var18.r().b(this.e);
                           if(!var24) {
                              break label128;
                           }
                        }
                        break;
                     }

                     var18.r().c(this.e);
                  }

                  this.e.b();
                  if(!var24) {
                     break label132;
                  }
               }

               var18.e();
               var9 = var18;
               var10 = var19;
               var8 = var18.b();
               var6 = 0;
            }

            this.d[0].b();
            this.d[1].b();
            if(!var24) {
               continue;
            }
         }

         var26 = var5;
         break;
      }

      return var26;
   }

   protected void c() {
      boolean var2 = g;
      int var1 = 0;

      while(var1 < this.c.length) {
         this.c[var1].e();
         ++var1;
         if(var2) {
            break;
         }
      }

   }

   private void f() {
      boolean var9 = g;
      ArrayList var1 = new ArrayList();
      int[] var2 = new int[this.c.length];
      int var3 = 0;

      while(var3 < this.c.length) {
         if(var2[this.c[var3].f()] == 0) {
            var2[this.c[var3].f()] = 1;
            var1.add(this.c[var3]);

            label50:
            while(true) {
               boolean var10000 = var1.isEmpty();

               label48:
               while(true) {
                  if(var10000) {
                     break label50;
                  }

                  Object var10 = var1.remove(var1.size() - 1);

                  while(true) {
                     n var4 = (n)var10;
                     int var5 = var2[var4.f()];
                     if(var5 < 0) {
                        var4.r().c();
                     }

                     Iterator var6 = var4.r().d();

                     while(true) {
                        if(!var6.hasNext()) {
                           continue label50;
                        }

                        m var7 = (m)var6.next();
                        var10 = var7.d();
                        if(var9) {
                           break;
                        }

                        if(var10 != null) {
                           var10000 = var7.k();
                           if(var9) {
                              continue label48;
                           }

                           if(var10000) {
                              n var8 = var7.a((r)var4).b();
                              if(var8.j() == var7) {
                                 var1.add(var8);
                                 var2[var8.f()] = var5 * var7.h();
                                 if(var9) {
                                    break label50;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         ++var3;
         if(var9) {
            break;
         }
      }

   }

   private void g() {
      boolean var7 = g;
      y.c.e var1 = this.b.p();

      while(var1.f()) {
         this.b.d(var1.a());
         var1.g();
         if(var7) {
            break;
         }
      }

      int var8 = 0;

      label71:
      do {
         int var10000 = var8;

         n var2;
         Iterator var3;
         label68:
         while(true) {
            if(var10000 >= this.c.length) {
               return;
            }

            var2 = this.c[var8];
            var3 = var2.r().d();

            while(true) {
               m var4;
               do {
                  do {
                     if(!var3.hasNext()) {
                        break label68;
                     }

                     var4 = (m)var3.next();
                  } while(var4.d() == null);

                  var10000 = var4.k();
                  if(var7) {
                     continue label68;
                  }
               } while(var10000 == 0);

               Iterator var5 = var4.d().iterator();

               while(var5.hasNext()) {
                  y.c.d var6 = (y.c.d)var5.next();
                  if(var6.c() == var2.i()) {
                     this.b.e(var6);
                     if(var7 || var7) {
                        break label68;
                     }
                  }
               }
            }
         }

         if(var2.q() != null) {
            var3 = var2.q().iterator();

            while(var3.hasNext()) {
               this.b.e((y.c.d)var3.next());
               if(var7) {
                  continue label71;
               }

               if(var7) {
                  break;
               }
            }
         }

         ++var8;
      } while(!var7);

   }

   private void h() {
      boolean var6 = g;
      y.c.D var1 = new y.c.D();
      int var2 = 0;

      label90:
      do {
         int var10000 = var2;
         int var10001 = this.c.length;

         label87:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            Iterator var3 = this.c[var2].r().d();

            while(true) {
               m var4;
               Iterator var5;
               do {
                  do {
                     do {
                        if(!var3.hasNext()) {
                           break label87;
                        }

                        var4 = (m)var3.next();
                     } while(var4.d() == null);

                     var10000 = var4.a((r)this.c[var2]).f();
                     var10001 = var2;
                     if(var6) {
                        continue label87;
                     }
                  } while(var10000 <= var2);

                  if(!var4.k()) {
                     break;
                  }

                  var1.clear();
                  var5 = var4.d().iterator();

                  while(true) {
                     if(var5.hasNext()) {
                        var1.a((Object)this.a((y.c.d)var5.next()));
                        if(var6) {
                           break;
                        }

                        if(!var6) {
                           continue;
                        }
                     }

                     var4.d().addAll(var1);
                     break;
                  }
               } while(!var6);

               var5 = var4.d().iterator();

               while(var5.hasNext()) {
                  this.b.d((y.c.d)var5.next());
                  if(var6 || var6) {
                     break label87;
                  }
               }
            }
         }

         if(this.c[var2].q() != null) {
            y.c.D var7 = new y.c.D();
            Iterator var8 = this.c[var2].q().iterator();

            while(var8.hasNext()) {
               y.c.d var9 = (y.c.d)var8.next();
               var7.b((Object)var9);
               var7.b((Object)this.a(var9));
               if(var6) {
                  continue label90;
               }

               if(var6) {
                  break;
               }
            }

            this.c[var2].a(var7);
         }

         ++var2;
      } while(!var6);

   }

   private boolean b(D var1) {
      if(var1 == null) {
         return false;
      } else {
         this.a = var1;
         return this.a(var1.g());
      }
   }

   public boolean a(y.c.i var1) {
      boolean var5 = g;
      this.b = var1;
      this.a();
      this.b();
      int var2 = this.c.length - 1;

      label30:
      while(true) {
         int var10000 = var2;

         label28:
         while(var10000 >= 0) {
            Iterator var3 = this.c[var2].d().iterator();

            while(var3.hasNext()) {
               m var4 = (m)var3.next();
               if(!var4.k()) {
                  var10000 = this.a(this.c[var2], var4.a((r)this.c[var2]).b(), var4);
                  if(var5) {
                     continue label28;
                  }

                  if(var10000 == 0) {
                     return false;
                  }
               }
            }

            --var2;
            if(var5) {
               return true;
            }
            continue label30;
         }

         return true;
      }
   }

   private void i() {
      this.f();
      this.c();
      this.h();
      this.g();
   }

   public boolean a(D var1) {
      boolean var7 = g;
      if(!this.b(var1)) {
         return false;
      } else {
         this.i();
         var1.l();
         y.f.h.q var2 = var1.h();
         if(!var2.f()) {
            return true;
         } else {
            y.f.h.p var3 = var2.a();
            var3 = null;
            int var4 = 0;
            y.f.h.q var5 = var1.h();

            int var10000;
            while(true) {
               if(var5.f()) {
                  int var6 = var5.a().a().k();
                  var10000 = var6;
                  if(var7) {
                     break;
                  }

                  if(var6 > var4) {
                     var4 = var6;
                     var3 = var5.a();
                  }

                  var5.g();
                  if(!var7) {
                     continue;
                  }
               }

               var1.b((y.f.h.p)var3);
               var10000 = var1.n();
               break;
            }

            if(var10000 != 0) {
               return true;
            } else {
               throw new RuntimeException("Constructed planar embedding was corrupt!");
            }
         }
      }
   }

   public y.c.f d() {
      boolean var3 = g;
      y.c.f var1 = new y.c.f();
      Iterator var2 = this.h.d();

      y.c.f var10000;
      while(true) {
         if(var2.hasNext()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1.addAll(((m)var2.next()).d());
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }
}
