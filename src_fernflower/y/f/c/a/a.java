package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.b;
import y.f.c.a.br;
import y.f.c.a.c;
import y.f.c.a.cF;
import y.f.c.a.cH;
import y.f.c.a.cS;

public abstract class a implements br {
   private byte a = 0;
   private int b = 4;

   protected a() {
      this.a = 0;
      this.b = 4;
   }

   public int a() {
      return this.b;
   }

   public void a(int var1) {
      this.b = var1;
   }

   public void a(byte var1) {
      this.a = var1;
   }

   public byte b() {
      return this.a;
   }

   public void optimizeAfterSequencing(y.f.X var1, aU var2, aV var3, aP var4) {
      b var5 = this.a(var1, var2, var3, var4);
      Comparator[] var6 = this.a(var5, var1, var2, var3);
      this.a(var6[0], var6[1], var1, var2, var3, var4);
      this.a(var5, var1, var3, var4);
   }

   protected void a(Comparator var1, Comparator var2, y.f.X var3, aU var4, aV var5, aP var6) {
      boolean var11 = N.x;
      int var7 = 0;

      do {
         int var10000 = var7;

         label29:
         while(true) {
            if(var10000 >= var4.b()) {
               return;
            }

            aQ var8 = var4.a(var7);
            y.c.p var9 = var8.d().k();

            while(true) {
               if(var9 == null) {
                  break label29;
               }

               y.c.q var10 = (y.c.q)var9.c();
               var10000 = var5.a(var10).b();
               if(var11) {
                  break;
               }

               if(var10000 == 0) {
                  this.a(var10, var1, var2, var3, var5, var6);
               }

               var9 = var9.a();
               if(var11) {
                  break label29;
               }
            }
         }

         ++var7;
      } while(!var11);

   }

   protected abstract void a(y.c.q var1, Comparator var2, Comparator var3, y.f.X var4, aV var5, aP var6);

   protected b a(y.f.X var1, aU var2, aV var3, aP var4) {
      boolean var14 = N.x;
      b var5 = new b();
      int var6 = 0;

      do {
         int var10000 = var6;

         label54:
         while(true) {
            if(var10000 >= var2.b()) {
               return var5;
            }

            aQ var7 = var2.a(var6);
            y.c.p var8 = var7.d().k();

            while(true) {
               if(var8 == null) {
                  break label54;
               }

               y.c.q var9 = (y.c.q)var8.c();
               aX var10 = var3.a(var9);
               var10000 = var10.e();
               if(var14) {
                  break;
               }

               if(var10000 > 0) {
                  y.c.p var11 = var10.d();

                  while(var11 != null) {
                     y.c.d var12 = (y.c.d)var11.c();
                     var10000 = var12.c().equals(var9);
                     if(var14) {
                        continue label54;
                     }

                     if(var10000 != 0) {
                        label67: {
                           y.c.q var13 = var1.d();
                           var5.a(var13, var12);
                           if(var3.a(var12).j()) {
                              var4.b(var13, var9, var12, false, true);
                              var4.a(var13, var12.d(), var12, false, true);
                              if(!var14) {
                                 break label67;
                              }
                           }

                           var4.a(var9, var13, var12, true, false);
                           var4.b(var12.d(), var13, var12, true, false);
                        }
                     }

                     var11 = var11.a();
                     if(var14) {
                        break;
                     }
                  }
               }

               var8 = var8.a();
               if(var14) {
                  break label54;
               }
            }
         }

         ++var6;
      } while(!var14);

      return var5;
   }

   protected void a(b var1, y.f.X var2, aV var3, aP var4) {
      boolean var13 = N.x;
      y.c.x var5 = var1.a().a();

      int var10000;
      while(true) {
         if(var5.f()) {
            y.c.q var6 = var5.e();
            y.c.d var7 = var1.a(var6);
            var2.e(var7);
            A var8 = var3.a(var7);
            var10000 = var6.c();
            if(var13) {
               break;
            }

            label85: {
               y.c.d var9;
               y.c.d var10;
               A var11;
               A var12;
               if(var10000 > 0) {
                  var9 = var6.f();
                  var10 = var6.h();
                  var11 = var3.a(var9);
                  var12 = var3.a(var10);
                  if(var9.d() == var7.c()) {
                     if(var11.e() != var8.c()) {
                        var4.a(var7, true, var11.e());
                     }

                     if(var12.e() != var8.e()) {
                        var4.a(var7, false, var12.e());
                     }

                     var2.a(var7, var2.o(var9));
                     var2.b(var7, var2.o(var10));
                     if(!var13) {
                        break label85;
                     }
                  }

                  if(var12.e() != var8.c()) {
                     var4.a(var7, true, var12.e());
                  }

                  if(var11.e() != var8.e()) {
                     var4.a(var7, false, var11.e());
                  }

                  var2.a(var7, var2.o(var10));
                  var2.b(var7, var2.o(var9));
                  if(!var13) {
                     break label85;
                  }
               }

               var9 = var6.g();
               var10 = var6.i();
               var11 = var3.a(var9);
               var12 = var3.a(var10);
               if(var9.c() == var7.c()) {
                  if(var11.c() != var8.c()) {
                     var4.a(var7, true, var11.c());
                  }

                  if(var12.c() != var8.e()) {
                     var4.a(var7, false, var12.c());
                  }

                  var2.a(var7, var2.n(var9));
                  var2.b(var7, var2.n(var10));
                  if(!var13) {
                     break label85;
                  }
               }

               if(var12.c() != var8.c()) {
                  var4.a(var7, true, var12.c());
               }

               if(var11.c() != var8.e()) {
                  var4.a(var7, false, var11.c());
               }

               var2.a(var7, var2.n(var10));
               var2.b(var7, var2.n(var9));
            }

            var2.d(var7);
            var5.g();
            if(!var13) {
               continue;
            }
         }

         var5 = var1.a().a();
         var10000 = var5.f();
         break;
      }

      while(var10000 != 0) {
         var2.a((y.c.q)var5.e());
         var5.g();
         if(var13) {
            break;
         }

         var10000 = var5.f();
      }

   }

   private Comparator[] a(b var1, y.f.X var2, aU var3, aV var4) {
      boolean var10 = N.x;
      int[] var5 = new int[var2.e()];
      cF var6 = cF.a(var2, var3, var4, var5, new int[var2.e()], new byte[var2.g()], new int[var2.g()], new byte[var2.g()], new int[var2.g()], (byte)1, (byte)0);
      y.c.x var7 = var1.a().a();

      while(var7.f()) {
         int var8 = var7.e().d();
         var5[var8] = -1;
         var7.g();
         if(var10) {
            break;
         }
      }

      Comparator var11 = var6.c(true);
      if(var11 instanceof cH) {
         cH var12 = (cH)var11;
         var12.a(new c(var2.c(y.f.ax.b), var12.a(), this.a, this.b));
      }

      Comparator var13 = var6.c(false);
      if(var13 instanceof cS) {
         cS var9 = (cS)var13;
         var9.a(new c(var2.c(y.f.ax.a), var9.a(), this.a, this.b));
      }

      return new Comparator[]{var13, var11};
   }
}
