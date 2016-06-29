package y.f.f.e;

import java.util.List;
import y.c.A;
import y.c.C;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.d.v;
import y.f.X;
import y.f.w;
import y.f.f.e.a;
import y.f.f.e.j;
import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.h.r;
import y.g.M;

public class i implements y.f.f.b.d {
   private X a;
   private N b;
   private X c;
   private D d;
   private short e;
   private int f;
   private A g;
   private y.c.h h;
   private y.c.h i;
   private y.c.h j;

   public void a(D var1) {
      this.a = (X)var1.g();
      this.b = var1;
   }

   public void a(short var1) {
      this.e = var1;
   }

   public void a(int var1) {
      this.f = var1;
   }

   public D b() {
      return this.d;
   }

   public void a() {
      int var13 = a.a;
      p var3 = this.b.i();
      y.c.d var4 = var3.a().a();
      this.c = new w();
      this.d = new D(this.c);
      this.g = M.a(new Object[this.a.e()]);
      this.h = M.b(new Object[this.a.g()]);
      x var5 = this.a.o();

      q var7;
      while(true) {
         if(var5.f()) {
            q var6 = var5.e();
            if(var13 != 0) {
               break;
            }

            if(var6.c() < 5) {
               var7 = this.c.d();
               this.g.a(var6, var7);
            }

            var5.g();
            if(var13 == 0) {
               continue;
            }
         }

         this.i = M.b(new Object[this.a.g()]);
         this.j = M.b(new Object[this.a.g()]);
         this.a(this.i, this.j);
         break;
      }

      x var2 = this.a.o();

      y.c.e var1;
      y.c.d var18;
      label136:
      do {
         int var10000 = var2.f();

         label133:
         while(true) {
            if(var10000 == 0) {
               break label136;
            }

            q var15 = var2.e();
            if(var15.c() == 0) {
               break;
            }

            var1 = var15.l();
            var18 = var1.a();
            var7 = (q)this.i.b(var18);
            var1.b();

            while(true) {
               if(!var1.f()) {
                  break label133;
               }

               y.c.d var8 = var1.a();
               q var9 = (q)this.i.b(var8);
               q var10 = (q)this.j.b(var8);
               y.c.d var11 = this.a(var7, var9);
               var10000 = var15.c();
               if(var13 != 0) {
                  break;
               }

               if(var10000 > 4) {
                  this.g.a(var15, var11);
               }

               var7 = (q)this.i.b(var8);
               y.c.d var12 = this.c.a((q)var9, (q)var10);
               this.h.a(var8, var12);
               if(var8 == var18) {
                  break label133;
               }

               var1.b();
               if(var13 != 0) {
                  break label133;
               }
            }
         }

         var2.g();
      } while(var13 == 0);

      var1 = this.a.p();

      i var27;
      while(true) {
         if(var1.f()) {
            y.c.d var16 = var1.a();
            var27 = this;
            if(var13 != 0) {
               break;
            }

            label108: {
               if(this.b.n(var16)) {
                  this.d.m((y.c.d)this.h.b(var16));
                  if(var13 == 0) {
                     break label108;
                  }
               }

               this.d.e((y.c.d)this.h.b(var16));
            }

            var18 = this.b.h(var16);
            this.d.b((y.c.d)this.h.b(var16), (y.c.d)this.h.b(var18));
            var1.g();
            if(var13 == 0) {
               continue;
            }
         }

         var27 = this;
         break;
      }

      r var17 = var27.d.m();
      this.c.a((Object)"y.layout.orthogonal.general.NodeSplitter.NODE_FACES", (y.c.c)var17);

      y.c.d var25;
      try {
         label155: {
            this.d.l();
            var18 = (y.c.d)this.h.b(var4);
            this.d.b((p)this.d.i(var18));
            y.f.h.q var20 = this.d.h();

            while(var20.f()) {
               var17.a(var20.a(), false);
               var20.g();
               if(var13 != 0) {
                  break label155;
               }

               if(var13 != 0) {
                  break;
               }
            }

            x var21 = this.a.o();

            while(var21.f()) {
               q var22 = var21.e();
               if(var13 != 0) {
                  break;
               }

               if(var22.c() > 4) {
                  var25 = (y.c.d)this.g.b(var22);
                  p var26 = this.d.i(var25);
                  this.g.a(var22, var26);
                  var17.a(var26, true);
               }

               var21.g();
               if(var13 != 0) {
                  break;
               }
            }
         }
      } catch (Exception var14) {
         System.err.println("Internal Error in Face calculation !");
         var14.printStackTrace(System.err);
      }

      y.f.h.q var19 = this.d.h();

      while(var19.f()) {
         label74: {
            p var23 = (p)var19.d();
            if(var17.d(var23)) {
               y.c.e var24 = var23.a();

               while(var24.f()) {
                  var25 = var24.a();
                  this.d.m(this.d.h(var25));
                  this.d.e(var25);
                  var24.g();
                  if(var13 != 0) {
                     break label74;
                  }

                  if(var13 != 0) {
                     break;
                  }
               }
            }

            var19.g();
         }

         if(var13 != 0) {
            break;
         }
      }

   }

   private y.c.d a(q var1, q var2) {
      if(var1.equals(var2)) {
         return null;
      } else {
         y.c.d var3;
         y.c.d var5;
         label14: {
            var3 = this.c.a((q)var1, (q)var2);
            y.c.e var4 = var2.l();
            if(!var4.f()) {
               var5 = this.c.a((q)var2, (q)var1);
               if(a.a == 0) {
                  break label14;
               }
            }

            var4.g();
            y.c.d var6 = var4.a();
            var5 = this.c.a(var2, var6, var1, (y.c.d)null, 1, 0);
         }

         this.d.b(var3, var5);
         return var5;
      }
   }

   private void a(y.c.h var1, y.c.h var2) {
      int var8 = a.a;
      x var3 = this.a.o();

      y.c.e var10000;
      while(true) {
         if(var3.f()) {
            q var4 = var3.e();
            var10000 = var4.l();
            if(var8 != 0) {
               break;
            }

            y.c.e var5 = var10000;

            label37: {
               while(var5.f()) {
                  y.c.d var6 = var5.a();
                  q var7 = this.a(var6);
                  var1.a(var6, var7);
                  var5.g();
                  if(var8 != 0) {
                     break label37;
                  }

                  if(var8 != 0) {
                     break;
                  }
               }

               var3.g();
            }

            if(var8 == 0) {
               continue;
            }
         }

         var10000 = this.a.p();
         break;
      }

      y.c.e var9 = var10000;

      while(var9.f()) {
         y.c.d var10 = var9.a();
         y.c.d var11 = this.b.h(var10);
         var2.a(var10, var1.b(var11));
         var2.a(var11, var1.b(var10));
         var9.g();
         if(var8 != 0) {
            break;
         }
      }

   }

   private q a(y.c.d var1) {
      q var2;
      if(var1.c().c() < 5) {
         var2 = (q)this.g.b(var1.c());
         if(a.a == 0) {
            return var2;
         }
      }

      var2 = this.c.d();
      return var2;
   }

   public void c() {
      int var17 = a.a;
      A var1 = this.a.t();
      x var2 = this.a.o();

      int var10000;
      byte var10001;
      while(true) {
         q var3;
         if(var2.f()) {
            var3 = var2.e();
            y.c.D var4 = new y.c.D();
            var10000 = var3.c();
            var10001 = 4;
            if(var17 != 0) {
               break;
            }

            label176: {
               label175: {
                  if(var10000 > 4) {
                     p var5 = (p)this.g.b(var3);
                     y.c.e var6 = var5.a();

                     do {
                        if(!var6.f()) {
                           break label175;
                        }

                        y.c.d var7 = var6.a();
                        var4.add(this.c.l(var7.c()));
                        var6.g();
                        if(var17 != 0) {
                           break label176;
                        }
                     } while(var17 == 0);
                  }

                  q var21 = (q)this.g.b(var3);
                  var4.add(this.c.l(var21));
               }

               var1.a(var3, var4);
               var2.g();
            }

            if(var17 == 0) {
               continue;
            }
         }

         var2 = this.a.o();

         label158: {
            while(var2.f()) {
               var3 = var2.e();
               int var20 = Integer.MAX_VALUE;
               int var22 = Integer.MIN_VALUE;
               int var23 = Integer.MAX_VALUE;
               int var25 = Integer.MIN_VALUE;
               y.c.D var8 = (y.c.D)var1.b(var3);
               if(var17 != 0) {
                  break label158;
               }

               C var9 = var8.m();

               while(true) {
                  if(var9.f()) {
                     t var10 = (t)var9.d();
                     double var30;
                     var10000 = (var30 = var10.a() - (double)var20) == 0.0D?0:(var30 < 0.0D?-1:1);
                     if(var17 != 0) {
                        break;
                     }

                     if(var10000 < 0) {
                        var20 = (int)var10.a();
                     }

                     if(var10.b() < (double)var23) {
                        var23 = (int)var10.b();
                     }

                     if(var10.a() > (double)var22) {
                        var22 = (int)var10.a();
                     }

                     if(var10.b() > (double)var25) {
                        var25 = (int)var10.b();
                     }

                     var9.g();
                     if(var17 == 0) {
                        continue;
                     }
                  }

                  var10000 = this.e;
                  break;
               }

               if(var10000 == 1) {
                  label139: {
                     this.a.b(var3, (double)this.f * 0.5D, (double)this.f * 0.5D);
                     y var26 = new y();
                     y var27 = new y();
                     y var11 = new y();
                     y var12 = new y();
                     if(var3.c() > 4) {
                        p var13 = (p)this.g.b(var3);
                        y.c.e var14 = var13.a();

                        label135: {
                           while(var14.f()) {
                              y.c.d var15 = var14.a();
                              t var16 = this.c.l(var15.c());
                              double var31;
                              var10000 = (var31 = var16.a() - (double)var20) == 0.0D?0:(var31 < 0.0D?-1:1);
                              if(var17 != 0) {
                                 break label135;
                              }

                              if(var10000 > 0 && var16.a() < (double)var22) {
                                 if(var16.b() == (double)var23) {
                                    var26.add(new Integer((int)var16.a()));
                                 }

                                 if(var16.b() == (double)var25) {
                                    var27.add(new Integer((int)var16.a()));
                                 }
                              }

                              if(var16.b() > (double)var23 && var16.b() < (double)var25) {
                                 if(var16.a() == (double)var20) {
                                    var11.add(new Integer((int)var16.b()));
                                 }

                                 if(var16.a() == (double)var22) {
                                    var12.add(new Integer((int)var16.b()));
                                 }
                              }

                              var14.g();
                              if(var17 != 0) {
                                 break;
                              }
                           }

                           var10000 = this.a(var26, var27, var20, var22);
                        }

                        int var28 = var10000;
                        int var29 = this.a(var11, var12, var23, var25);
                        this.a.a(var3, (double)var28, (double)var29);
                        if(var17 == 0) {
                           break label139;
                        }
                     }

                     this.a.a(var3, (double)var20, (double)var23);
                  }
               }

               if(this.e == 0) {
                  this.a.b(var3, (double)(var22 - var20) + (double)this.f * 0.5D, (double)(var25 - var23) + (double)this.f * 0.5D);
                  this.a.c(var3, (double)var20 - (double)this.f * 0.25D, (double)var23 - (double)this.f * 0.25D);
               }

               var2.g();
               if(var17 != 0) {
                  break;
               }
            }

            this.d.b();
         }

         var10000 = this.e;
         var10001 = 1;
         break;
      }

      y.c.e var18;
      y.c.d var19;
      label112: {
         if(var10000 == var10001) {
            var18 = this.a.p();

            while(var18.f()) {
               var19 = var18.a();
               List var24 = this.c.j((y.c.d)this.h.b(var19)).e();
               var10000 = var19.c().c();
               if(var17 != 0) {
                  break label112;
               }

               if(var10000 > 4) {
                  var24.add(0, this.c.l((q)this.i.b(var19)));
               }

               if(var19.d().c() > 4) {
                  var24.add(this.c.l((q)this.j.b(var19)));
               }

               this.a.b(var19, new v(var24));
               this.a.a(var19, new t(0.0D, 0.0D));
               this.a.b(var19, new t(0.0D, 0.0D));
               var18.g();
               if(var17 != 0) {
                  break;
               }
            }
         }

         var10000 = this.e;
      }

      if(var10000 == 0) {
         var18 = this.a.p();

         while(var18.f()) {
            var19 = var18.a();
            this.a.c(var19, this.c.l((q)this.i.b(var19)));
            this.a.d(var19, this.c.l((q)this.j.b(var19)));
            this.a.b(var19, this.c.j((y.c.d)this.h.b(var19)));
            var18.g();
            if(var17 != 0) {
               return;
            }

            if(var17 != 0) {
               break;
            }
         }
      }

      this.a.a((A)var1);
   }

   private int a(y.c.D var1, y.c.D var2, int var3, int var4) {
      int var8 = a.a;
      y.c.D var5 = new y.c.D();
      if(var1.size() == 0 && var2.size() == 0) {
         return (var4 + var3) / 2;
      } else if(var1.size() > 0 && var2.size() == 0) {
         return this.a(var1);
      } else if(var1.size() == 0 && var2.size() > 0) {
         return this.a(var2);
      } else {
         C var6 = var1.m();

         Integer var7;
         while(true) {
            if(var6.f()) {
               var7 = (Integer)var6.d();
               var5.add(var7);
               var6.g();
               if(var8 != 0) {
                  break;
               }

               if(var8 == 0) {
                  continue;
               }
            }

            var6 = var2.m();
            break;
         }

         int var10000;
         while(true) {
            if(var6.f()) {
               var7 = (Integer)var6.d();
               var10000 = var5.add(var7);
               if(var8 != 0) {
                  break;
               }

               var6.g();
               if(var8 == 0) {
                  continue;
               }
            }

            var10000 = this.a(var5);
            break;
         }

         return var10000;
      }
   }

   private int a(y.c.D var1) {
      int var4 = a.a;
      var1.sort(new j(this));
      C var2 = var1.m();
      int var3 = 0;

      Object var10000;
      while(true) {
         if(var3 < var1.size() / 2) {
            var10000 = var2;
            if(var4 != 0) {
               break;
            }

            var2.g();
            ++var3;
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var2.d();
         break;
      }

      return ((Integer)var10000).intValue();
   }
}
