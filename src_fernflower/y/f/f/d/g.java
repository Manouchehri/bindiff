package y.f.f.d;

import y.f.f.d.K;
import y.f.f.d.b;
import y.f.f.d.h;
import y.f.f.d.i;
import y.f.f.d.j;
import y.f.f.d.k;
import y.f.f.d.m;
import y.f.f.d.o;
import y.f.f.d.p;

class g implements y.f.f.c.f {
   private K a;
   private y.f.f.c.p b;
   private y.f.f.c.p c;
   private y.c.D d;

   public void a(y.c.D var1) {
      this.d = var1;
   }

   public void a(y.f.f.b.h var1, y.f.f.c.p var2, y.f.f.c.p var3) {
      boolean var5 = o.p;
      this.a = (K)var1;
      this.b = var2;
      this.c = var3;
      y.f.h.q var4 = this.a.c();

      while(var4.f()) {
         label19: {
            if(this.d == null) {
               this.a(var4.a());
               if(!var5) {
                  break label19;
               }
            }

            if(!this.d.contains(var4.a())) {
               this.a(var4.a());
            }
         }

         var4.g();
         if(var5) {
            break;
         }
      }

   }

   private void a(y.f.h.p var1) {
      y.c.D var2 = this.b(var1);
      y.c.D var3 = new y.c.D();
      var3.add(new j(this));
      var3.add(new i(this));
      var3.add(new h(this));
      this.a(var2, var3);
      boolean var4 = var2.size() == 4;
      if(!var4) {
         var2 = this.b(var2);
         y.c.D var5 = new y.c.D();
         var5.add(new m(this));
         this.a(var2, var5);
      }

   }

   private y.c.D b(y.f.h.p var1) {
      boolean var15 = o.p;
      y.c.D var2 = new y.c.D();
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(this.a.d(var4) != 2) {
            y.f.f.c.p var5;
            y.f.f.c.p var6;
            label62: {
               if(this.a.h(var4) == y.f.f.b.o.a || this.a.h(var4) == y.f.f.b.o.c) {
                  var5 = this.c;
                  var6 = this.b;
                  if(!var15) {
                     break label62;
                  }
               }

               var5 = this.b;
               var6 = this.c;
            }

            y.f.f.c.g var7 = var6.a(var4);
            y.c.q var8 = var4.c();
            p var9 = new p(var7);
            y.f.f.c.g var10 = var5.a(var8);
            p var11 = new p(var10);
            byte var12 = 2;
            if(this.a.d(var8)) {
               var12 = 1;
            }

            if(this.a.k(var8)) {
               var12 = 0;
            }

            b var13;
            switch(this.a.d(var4)) {
            case 1:
               var13 = new b(var11, var9, 0, this.a.h(var4), var12);
               var2.add(var13);
               if(!var15) {
                  break;
               }
            case 3:
               var13 = new b(var11, var9, 1, this.a.h(var4), var12);
               if(this.a.g(var8)) {
                  if(this.a.r(this.a.a(var4))) {
                     var13.a(true);
                  }

                  if(this.a.r(this.a.a(this.a.b().j(var4)))) {
                     var13.b(true);
                  }
               }

               var2.add(var13);
               if(!var15) {
                  break;
               }
            case 4:
               y.f.f.b.o var14 = this.a.h(var4).b();
               var13 = new b(var9, var11, 1, var14, var12);
               var2.add(var13);
               var13 = new b(var11, var9, 1, this.a.h(var4), var12);
               var2.add(var13);
               if(!var15) {
                  break;
               }
            case 2:
            default:
               System.err.println("Impossible Angle :" + this.a.d(var4));
            }
         }

         var3.g();
         if(var15) {
            break;
         }
      }

      return var2;
   }

   y.c.D b(y.c.D var1) {
      boolean var18 = o.p;
      byte var2 = 0;
      b var3 = null;
      b var4 = null;

      b var10000;
      while(true) {
         if(var2 != -4) {
            label176: {
               var4 = var3;
               var3 = (b)var1.a(0);
               var1.g();
               var1.add(var3);
               var10000 = var3;
               if(var18) {
                  break;
               }

               if(var3.a() == 2) {
                  var2 = 0;
                  if(!var18) {
                     break label176;
                  }
               }

               if(var3.b() != 0 || var2 != 2 && var2 != 4 && var2 != 5) {
                  if(var3.b() == 1 && var2 == 4) {
                     var2 = 5;
                     if(!var18) {
                        continue;
                     }
                  }

                  if(var3.b() == 1 && var2 == 3) {
                     var2 = 4;
                     if(!var18) {
                        continue;
                     }
                  }

                  if(var3.b() == 1 && var2 == 2) {
                     var2 = 3;
                     if(!var18) {
                        continue;
                     }
                  }

                  if(var3.b() == 1 && var2 == 1) {
                     var2 = 2;
                     if(!var18) {
                        continue;
                     }
                  }

                  if(var3.b() == 0) {
                     var2 = 1;
                     if(!var18) {
                        continue;
                     }
                  }

                  var2 = 0;
                  if(!var18) {
                     continue;
                  }
               }
            }
         }

         var10000 = var3;
         break;
      }

      b var5 = var10000;
      p var6 = null;
      p var7 = null;
      y.f.f.b.o var8 = null;
      p var9 = new p();
      if(var2 != 0) {
         var9.a(var4.d().b());
      }

      var9.a(var3.e().b());
      y.c.D var10 = new y.c.D();
      int var11 = -1;
      var3 = null;
      p var12 = null;

      while(true) {
         if(var3 != var5) {
            byte var19 = 0;
            boolean var13 = true;
            p var14 = null;

            while(var13) {
               var4 = var3;
               var3 = (b)var1.a(0);
               var1.g();
               if(var14 == null) {
                  var14 = var3.e();
               }

               if(var3.a() == 2) {
                  var19 = -1;
                  if(!var18) {
                     break;
                  }
               }

               byte var15;
               label180: {
                  var15 = var19;
                  if(var19 == 0 && var3.b() == 0) {
                     var19 = 1;
                     if(!var18) {
                        break label180;
                     }
                  }

                  if(var19 == 1 && var3.b() == 1) {
                     var9.a(var3.e().b());
                     var19 = 2;
                     if(!var18) {
                        break label180;
                     }
                  }

                  if(var19 == 2 && var3.b() == 1) {
                     var19 = 3;
                     if(!var18) {
                        break label180;
                     }
                  }

                  if(var19 == 3 && var3.b() == 0) {
                     var9.a(var3.e().b());
                     var19 = 0;
                  }
               }

               if(var15 == var19) {
                  break;
               }
            }

            b var20;
            label102: {
               if(var6 == null) {
                  var6 = var9;
                  var12 = var14;
                  if(!var18) {
                     break label102;
                  }
               }

               var20 = new b(var7, var9, var11, var8, 2);
               var10.add(var20);
               if(var14 != var3.e()) {
                  this.a(var8, var7, var14);
               }
            }

            var7 = var9;
            var9 = new p();
            if(var19 == -1) {
               var9.a(var3.e().b());
               var8 = var3.c();
               var11 = var3.b();
               if(!var18) {
                  continue;
               }
            }

            if(var19 == 0 || var19 == 1) {
               throw new RuntimeException("Consistency error: State == " + var19);
            }

            if(var19 == 2) {
               var9.a(var4.d().b());
               var9.a(var3.e().b());
               var8 = var3.c();
               var11 = 0;
               if(!var18) {
                  continue;
               }
            }

            if(var19 != 3) {
               continue;
            }

            var9.a(var3.d().b());
            var20 = (b)var1.a(0);
            var1.g();
            int var21 = var20.b();
            if(var18) {
               break;
            }

            if(var21 == 0) {
               var9.a(var20.e().b());
               var11 = 1;
               var8 = var20.c();
               var3 = var20;
               if(!var18) {
                  continue;
               }
            }

            var11 = 1;
            var8 = var3.c();
            y.f.f.b.o var16 = var8.b();
            var10.add(new b(var7, var9, 1, var16, 2));
            var7 = var9;
            var9 = new p();
            var9.a(var3.e().b());
            b var17 = (b)var1.a(0);
            var1.g();
            var9.a(var17.e().b());
            var3 = var17;
            if(!var18) {
               continue;
            }
         }

         var10.add(new b(var7, var6, var11, var8, 2));
         break;
      }

      this.a(var8, var7, var12);
      return var10;
   }

   private void a(y.f.f.b.o var1, p var2, p var3) {
      if(var1 == null) {
         y.g.o.a((Object)"Error: Corner separate: direction == null");
      } else {
         y.f.f.b.o var4 = var1.b();
         if(var4.a(y.f.f.b.o.a)) {
            p.a(this.b, var2, var3, 1);
         }

         if(var4.a(y.f.f.b.o.c)) {
            p.a(this.b, var3, var2, 1);
         }

         if(var4.a(y.f.f.b.o.d)) {
            p.a(this.c, var3, var2, 1);
         }

         if(var4.a(y.f.f.b.o.b)) {
            p.a(this.c, var2, var3, 1);
         }

      }
   }

   private void a(y.c.D var1, y.c.D var2) {
      boolean var8 = o.p;
      int var3 = 0;
      int var4 = var1.size();

      y.c.D var10000;
      while(true) {
         if(var3 < var4) {
            boolean var5 = false;
            var10000 = var2;
            if(var8) {
               break;
            }

            y.c.C var6 = var2.m();

            boolean var11;
            label61: {
               while(var6.f()) {
                  var11 = var5;
                  if(var8) {
                     break label61;
                  }

                  if(var5) {
                     break;
                  }

                  k var7 = (k)var6.d();
                  var5 = var7.a(var1);
                  var6.g();
                  if(var8) {
                     break;
                  }
               }

               var11 = var5;
            }

            if(var11) {
               var3 = 0;
               var4 = var1.size();
               if(!var8) {
                  continue;
               }
            }

            var1.add(var1.g());
            ++var3;
            if(!var8) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      if(var10000.size() == 4) {
         b[] var9 = new b[]{(b)var1.a(0), (b)var1.a(1), (b)var1.a(2), (b)var1.a(3)};
         if(var9[0].b() == 0 && var9[1].b() == 0 && var9[2].b() == 0 && var9[3].b() == 0) {
            int var10 = 0;

            while(var10 < 4 && !var9[var10].c().a(y.f.f.b.o.a)) {
               ++var10;
               if(var8) {
                  break;
               }
            }

            p.a(this.c, var9[(var10 + 1) % 4].e(), var9[var10].d(), 1);
            p.a(this.b, var9[(var10 + 3) % 4].d(), var9[var10].e(), 1);
         }
      }

   }

   static y.f.f.c.p a(g var0) {
      return var0.b;
   }

   static y.f.f.c.p b(g var0) {
      return var0.c;
   }
}
