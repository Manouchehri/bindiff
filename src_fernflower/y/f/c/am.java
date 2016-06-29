package y.f.c;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import y.f.c.a;
import y.f.c.an;
import y.f.c.x;
import y.f.c.y;
import y.f.c.z;

class am {
   private y.f.X a;
   private y.c.f b;
   private Map c;
   private x d;
   private double e;
   private Comparator f;
   private static final double[] g = new double[]{0.0D, 1.0D, 0.0D, -1.0D};
   private static final double[] h = new double[]{-1.0D, 0.0D, 1.0D, 0.0D};
   private double i;

   public am(y.f.X var1, x var2) {
      boolean var4 = a.i;
      super();
      this.e = 20.0D;
      this.f = new an(this);
      this.d = var2;
      this.a = var1;
      this.b = new y.c.f();
      this.c = new HashMap();
      y.c.e var3 = var1.p();

      while(var3.f()) {
         if(var3.a().e()) {
            this.b.c(var3.a());
         }

         var3.g();
         if(var4) {
            break;
         }
      }

   }

   public void a(double var1) {
      this.e = var1;
   }

   public void a() {
      boolean var2 = a.i;
      y.c.p var1 = this.b.k();

      while(var1 != null) {
         this.a.d((y.c.d)var1.c());
         var1 = var1.a();
         if(var2) {
            break;
         }
      }

   }

   public void b() {
      boolean var2 = a.i;
      y.c.p var1 = this.b.k();

      while(var1 != null) {
         this.a.e((y.c.d)var1.c());
         this.a.b(var1.c()).clearPoints();
         var1 = var1.a();
         if(var2) {
            break;
         }
      }

   }

   public void c() {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
   }

   public y a(y.c.q var1) {
      y var2 = (y)this.c.get(var1);
      if(var2 == null) {
         var2 = new y(this.a.a((Object)var1));
         this.c.put(var1, var2);
      }

      return var2;
   }

   public boolean b(y.c.q var1) {
      return this.c.containsKey(var1);
   }

   public void d() {
      boolean var11 = a.i;
      y.c.p var1 = this.b.k();

      while(var1 != null) {
         y.c.d var2 = (y.c.d)var1.c();
         y var3 = this.a(var2.c());
         var3.b.add(var2);
         y.f.aE var4 = this.a(var2);
         y.f.aE var5 = this.b(var2);
         boolean var6 = !var4.a();
         boolean var7 = !var5.a();
         int var8 = x.a(var4.b(), 2);
         int var9 = x.a(var5.b(), 0);
         int var10 = 4 + var9 - var8 & 3;
         if(var6 || var7) {
            if(var6) {
               switch(var10) {
               case 0:
                  var3.c(var8).l.add(var2);
                  if(!var11) {
                     break;
                  }
               case 3:
                  var3.a(var8).l.add(var2);
                  if(!var11) {
                     break;
                  }
               case 1:
               case 2:
                  var3.b(var8).l.add(var2);
               }
            }

            if(var7) {
               switch(var10) {
               case 0:
                  var3.c(var9).l.add(var2);
                  if(!var11) {
                     break;
                  }
               case 1:
               case 2:
                  var3.a(var9).l.add(var2);
                  if(!var11) {
                     break;
                  }
               case 3:
                  var3.b(var9).l.add(var2);
               }
            }
         }

         var3.b.sort(this.f);
         var1 = var1.a();
         if(var11) {
            break;
         }
      }

   }

   public void c(y.c.q var1) {
      boolean var10 = a.i;
      y var2 = this.a(var1);
      y.c.p var3 = var2.b.k();

      while(var3 != null) {
         y.c.d var4 = (y.c.d)var3.c();
         y.f.aE var5 = this.a(var4);
         y.f.aE var6 = this.b(var4);
         int var7 = x.a(var5.b(), 2);
         int var8 = x.a(var6.b(), 0);
         int var9 = 4 + var8 - var7 & 3;
         switch(var9) {
         case 0:
            var2.c(var7).b();
            if(!var10) {
               break;
            }
         case 1:
            var2.b(var7).b();
            var2.a(var8).b();
            if(!var10) {
               break;
            }
         case 2:
            var2.b(var7).b();
            var2.g(var7 + 1 & 3);
            var2.a(var8).b();
            if(!var10) {
               break;
            }
         case 3:
            var2.a(var7).b();
            var2.b(var8).b();
         }

         var3 = var3.a();
         if(var10) {
            break;
         }
      }

   }

   public void e() {
      boolean var25 = a.i;
      y.c.x var1 = this.a.o();

      do {
         boolean var10000 = var1.f();

         label109:
         while(true) {
            if(!var10000) {
               return;
            }

            y.c.q var2 = var1.e();
            if(!this.b(var2)) {
               break;
            }

            y var3 = this.a(var2);
            var3.a(this.a.a((Object)var2));
            var3.a();
            y.c.D var4 = new y.c.D();
            y.c.p var5 = var3.b.k();

            while(true) {
               if(var5 == null) {
                  break label109;
               }

               y.c.d var6 = (y.c.d)var5.c();
               var4.clear();
               y.f.aE var7 = this.a(var6);
               y.f.aE var8 = this.b(var6);
               int var9 = x.a(var7.b(), 2);
               int var10 = x.a(var8.b(), 0);
               y.d.t var11 = null;
               y.d.t var12 = null;
               y.d.t var13 = null;
               y.d.t var14 = null;
               int var15 = 4 + var10 - var9 & 3;
               var10000 = var7.a();
               if(var25) {
                  break;
               }

               z var16;
               if(!var10000) {
                  switch(var15) {
                  case 0:
                     var16 = var3.c(var9);
                     var11 = var16.c(var16.a(), 0.0D);
                     break;
                  case 1:
                  case 2:
                     var16 = var3.b(var9);
                     var11 = var16.c(var16.a(), 0.0D);
                     break;
                  case 3:
                     var16 = var3.a(var9);
                     var11 = var16.c(var16.a(), 0.0D);
                  }

                  this.a.c(var6, var11);
               } else {
                  label122: {
                     var11 = this.a.p(var6);
                     if((var9 & 1) == 1) {
                        var11 = new y.d.t(var3.c(var9).d, var11.b);
                        if(!var25) {
                           break label122;
                        }
                     }

                     var11 = new y.d.t(var11.a, var3.c(var9).c);
                  }
               }

               if(!var8.a()) {
                  switch(var15) {
                  case 0:
                     var16 = var3.c(var10);
                     var12 = var16.c(var16.a(), 0.0D);
                     break;
                  case 1:
                  case 2:
                     var16 = var3.a(var10);
                     var12 = var16.c(var16.a(), 0.0D);
                     break;
                  case 3:
                     var16 = var3.b(var10);
                     var12 = var16.c(var16.a(), 0.0D);
                  }

                  this.a.d(var6, var12);
               } else {
                  label123: {
                     var12 = this.a.q(var6);
                     if((var10 & 1) == 1) {
                        var12 = new y.d.t(var3.c(var10).d, var12.b);
                        if(!var25) {
                           break label123;
                        }
                     }

                     var12 = new y.d.t(var12.a, var3.c(var10).c);
                  }
               }

               double var17;
               switch(var15) {
               case 0:
                  var16 = var3.c(var9);
                  var17 = var16.b();
                  var16.b(var17);
                  var13 = new y.d.t(var11.a + g[var9] * var17, var11.b + h[var9] * var17);
                  var14 = new y.d.t(var12.a + g[var10] * var17, var12.b + h[var10] * var17);
                  break;
               case 1:
                  var16 = var3.b(var9);
                  var17 = var16.b();
                  var13 = new y.d.t(var11.a + g[var9] * var17, var11.b + h[var9] * var17);
                  var16 = var3.a(var10);
                  var17 = var16.b();
                  var14 = new y.d.t(var12.a + g[var10] * var17, var12.b + h[var10] * var17);
                  if((var9 & 1) == 0) {
                     var4.add(new y.d.t(var14.a, var13.b));
                     if(!var25) {
                        break;
                     }
                  }

                  var4.add(new y.d.t(var13.a, var14.b));
                  break;
               case 2:
                  int var27 = var9 + 1 & 3;
                  z var26 = var3.b(var9);
                  double var18 = var26.b();
                  var13 = new y.d.t(var11.a + g[var9] * var18, var11.b + h[var9] * var18);
                  var26 = var3.a(var10);
                  var18 = var26.b();
                  var14 = new y.d.t(var12.a + g[var10] * var18, var12.b + h[var10] * var18);
                  z var20 = var3.a(var27);
                  double var21 = var3.g(var27);
                  double var23;
                  if((var27 & 1) == 0) {
                     var23 = var20.e(0.0D, var21);
                     var4.add(new y.d.t(var13.a, var23));
                     var4.add(new y.d.t(var14.a, var23));
                     if(!var25) {
                        break;
                     }
                  }

                  var23 = var20.f(0.0D, var21);
                  var4.add(new y.d.t(var23, var13.b));
                  var4.add(new y.d.t(var23, var14.b));
                  break;
               case 3:
                  label84: {
                     var16 = var3.a(var9);
                     var17 = var16.b();
                     var13 = new y.d.t(var11.a + g[var9] * var17, var11.b + h[var9] * var17);
                     var16 = var3.b(var10);
                     var17 = var16.b();
                     var14 = new y.d.t(var12.a + g[var10] * var17, var12.b + h[var10] * var17);
                     if((var9 & 1) == 0) {
                        var4.add(new y.d.t(var14.a, var13.b));
                        if(!var25) {
                           break label84;
                        }
                     }

                     var4.add(new y.d.t(var13.a, var14.b));
                  }
               }

               var4.a((Object)var13);
               var4.b((Object)var14);
               y.f.I var30 = this.a.b(var6);
               y.c.p var29 = var4.k();

               label104: {
                  while(var29 != null) {
                     y.d.t var28 = (y.d.t)var29.c();
                     var30.addPoint(var28.a, var28.b);
                     var29 = var29.a();
                     if(var25) {
                        break label104;
                     }

                     if(var25) {
                        break;
                     }
                  }

                  var5 = var5.a();
               }

               if(var25) {
                  break label109;
               }
            }
         }

         var1.g();
      } while(!var25);

   }

   y.f.aE a(y.c.d var1) {
      y.c.c var2 = this.a.c(y.f.aF.a);
      y.f.aE var3 = null;
      if(var2 != null) {
         var3 = (y.f.aE)var2.b(var1);
      }

      if(var3 == null || var3.g()) {
         y.c.c var4 = this.a.c(y.f.aF.b);
         if(var4 == null) {
            return y.f.aE.a((byte)1);
         }

         y.f.aE var5 = (y.f.aE)var4.b(var1);
         if(var5 == null || var5.g()) {
            return y.f.aE.a((byte)1);
         }

         if(var5.c()) {
            return y.f.aE.a((byte)8);
         }

         if(var5.f()) {
            return y.f.aE.a((byte)1);
         }

         if(var5.d()) {
            return y.f.aE.a((byte)4);
         }

         if(var5.e()) {
            return y.f.aE.a((byte)2);
         }
      }

      return var3;
   }

   y.f.aE b(y.c.d var1) {
      y.c.c var2 = this.a.c(y.f.aF.b);
      y.f.aE var3 = null;
      if(var2 != null) {
         var3 = (y.f.aE)var2.b(var1);
      }

      if(var3 == null || var3.g()) {
         y.c.c var4 = this.a.c(y.f.aF.a);
         if(var4 == null) {
            return y.f.aE.a((byte)8);
         }

         y.f.aE var5 = (y.f.aE)var4.b(var1);
         if(var5 == null || var5.g()) {
            return y.f.aE.a((byte)8);
         }

         if(var5.c()) {
            return y.f.aE.a((byte)8);
         }

         if(var5.f()) {
            return y.f.aE.a((byte)1);
         }

         if(var5.d()) {
            return y.f.aE.a((byte)4);
         }

         if(var5.e()) {
            return y.f.aE.a((byte)2);
         }
      }

      return var3;
   }

   public void b(double var1) {
      this.i = var1;
   }
}
