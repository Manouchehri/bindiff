package y.f.c;

import java.util.HashSet;
import y.f.c.R;
import y.f.c.a;
import y.f.c.ak;
import y.f.c.al;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;

public class aj implements R, aT {
   private long c;
   protected y.c.c a;
   protected Object b;
   private boolean d;

   public aj() {
      this((Object)null);
   }

   public aj(Object var1) {
      this.c = Long.MAX_VALUE;
      this.b = var1;
   }

   public boolean a() {
      return this.d;
   }

   public void a(long var1) {
      this.c = var1;
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      return this.b != null?this.a(var1, var2, var3, var1.c(this.b)):this.a(var1, (y.c.A)var2, (y.c.f)var3, (y.c.c)null);
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3, y.c.c var4) {
      boolean var5;
      y.c.A var6;
      y.c.h var7;
      boolean var13;
      label29: {
         var13 = a.i;
         this.a = var4;
         var5 = this.a();
         if(var5) {
            var6 = var1.t();
            var7 = var1.u();
            if(!var13) {
               break label29;
            }
         }

         var6 = null;
         var7 = null;
      }

      y.c.A var8 = var1.t();
      int var9 = y.a.h.a(var1, (y.c.A)var8);
      y.g.J var10 = new y.g.J(var1, var8);
      int var11 = 0;
      int var12 = 0;

      while(true) {
         if(var12 < var9) {
            var10.c(new Integer(var12));
            y.g.o.a(this, "Make acyclic");
            this.a(var1, var3, var6, var7);
            y.g.o.a(this, "Assign layers");
            var11 = Math.max(var11, this.a((y.c.i)var1, (y.c.A)var2));
            y.g.o.a(this, "done");
            ++var12;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var10.b();
         var1.a((y.c.A)var8);
         break;
      }

      if(var5) {
         var1.a((y.c.h)var7);
         var1.a((y.c.A)var6);
      }

      return var11;
   }

   private void a(y.f.X var1, y.c.f var2, y.c.A var3, y.c.h var4) {
      if(this.a()) {
         this.b(var1, var2, var3, var4);
         if(!a.i) {
            return;
         }
      }

      this.a(var1, var2);
   }

   private void b(y.f.X var1, y.c.f var2, y.c.A var3, y.c.h var4) {
      boolean var13 = a.i;
      if(var1.h() >= 2 && var1.f() >= 2) {
         y.g.I var5 = new y.g.I(var1);
         y.c.x var6 = var1.o();

         label72:
         do {
            boolean var10000 = var6.f();

            label69:
            while(true) {
               if(!var10000) {
                  break label72;
               }

               y.c.q var7 = var6.e();
               y.c.e var8 = var7.l();

               while(true) {
                  if(!var8.f()) {
                     break label69;
                  }

                  y.c.d var9 = var8.a();
                  var10000 = var9.e();
                  if(var13) {
                     break;
                  }

                  label82: {
                     if(var10000) {
                        var5.a(var9);
                        if(!var13) {
                           break label82;
                        }
                     }

                     y.c.d var10 = (y.c.d)var3.b(var9.d());
                     if(var10 != null && var10.c() == var7) {
                        double var11 = var4.c(var10);
                        var4.a(var10, var11 + this.a(var9));
                        var4.a(var9, var10);
                        var5.a(var9);
                        if(!var13) {
                           break label82;
                        }
                     }

                     var3.a(var9.d(), var9);
                     var4.a(var9, this.a(var9));
                  }

                  var8.g();
                  if(var13) {
                     break label69;
                  }
               }
            }

            var6.g();
         } while(!var13);

         HashSet var14;
         label46: {
            var14 = new HashSet();
            if(var1.h() > 500) {
               y.a.c.a(var1, new al(var14), var4);
               if(!var13) {
                  break label46;
               }
            }

            a((y.c.i)var1, (y.c.h)(new al(var14)), (y.c.c)var4);
         }

         var5.f();
         y.c.e var15 = var1.p();

         while(var15.f()) {
            y.c.d var16 = var15.a();
            if(var14.contains(var16) || var14.contains(var4.b(var16))) {
               var1.c(var16);
               var2.add(var16);
            }

            var15.g();
            if(var13) {
               break;
            }
         }

      }
   }

   private static void a(y.c.i var0, y.c.h var1, y.c.c var2) {
      boolean var13 = a.i;
      if(!y.a.g.a(var0)) {
         y.g.I var3 = new y.g.I(var0);
         y.c.h var4 = y.g.M.b();
         y.c.e var5 = var0.p();

         while(var5.f()) {
            y.c.d var6 = var5.a();
            var4.a(var6, var2.c(var6));
            var1.a(var6, false);
            if(var6.e()) {
               var3.a(var6);
               var1.a(var6, true);
            }

            var5.g();
            if(var13) {
               break;
            }
         }

         y.c.f var15 = new y.c.f();

         label84:
         while(true) {
            y.c.f var14;
            int var10000 = (var14 = y.a.c.a(var0, true)).isEmpty();

            label81:
            while(var10000 == 0) {
               double var7 = Double.MAX_VALUE;
               y.c.e var9 = var14.a();

               while(true) {
                  if(var9.f()) {
                     double var10 = var4.c(var9.a());
                     double var18;
                     var10000 = (var18 = var10 - var7) == 0.0D?0:(var18 < 0.0D?-1:1);
                     if(var13) {
                        break;
                     }

                     if(var10000 < 0) {
                        var7 = var10;
                     }

                     var9.g();
                     if(!var13) {
                        continue;
                     }
                  }

                  var9 = var14.a();
                  var10000 = var9.f();
                  break;
               }

               while(true) {
                  if(var10000 == 0) {
                     continue label84;
                  }

                  y.c.d var17 = var9.a();
                  double var11 = var4.c(var17) - var7;
                  var4.a(var17, var11);
                  if(var13) {
                     break label84;
                  }

                  double var19;
                  var10000 = (var19 = var11 - 0.001D) == 0.0D?0:(var19 < 0.0D?-1:1);
                  if(var13) {
                     break;
                  }

                  if(var10000 < 0) {
                     var3.a(var17);
                     var15.add(var17);
                  }

                  var9.g();
                  if(var13) {
                     break label81;
                  }

                  var10000 = var9.f();
               }
            }

            var15.sort(new ak(var2));
            break;
         }

         y.c.e var16 = var15.a();

         while(true) {
            if(var16.f()) {
               y.c.d var8 = var16.a();
               var3.c(var8);
               if(var13) {
                  break;
               }

               if(!y.a.g.a(var0)) {
                  var3.a(var8);
                  var1.a(var8, true);
               }

               var16.g();
               if(!var13) {
                  continue;
               }
            }

            var3.f();
            break;
         }

      }
   }

   protected double a(y.c.d var1) {
      return 1.0D;
   }

   public void a(y.f.X var1, y.c.f var2) {
      this.a((y.c.i)var1, (y.c.f)var2);
   }

   public void a(y.c.i var1, y.c.f var2) {
      boolean var6 = a.i;
      y.c.h var3 = y.g.M.b(new boolean[var1.g()]);
      y.a.c.a(var1, var3);
      y.c.e var4 = var1.p();

      while(var4.f()) {
         y.c.d var5 = var4.a();
         if(var3.d(var5)) {
            var1.c(var5);
            var2.add(var5);
         }

         var4.g();
         if(var6) {
            break;
         }
      }

   }

   public int a(y.c.i var1, y.c.A var2) {
      return y.a.u.a(var1, var2, this.a, (y.c.c)null, this.c);
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      (new ba(this)).a(var1, var2, var3);
   }
}
