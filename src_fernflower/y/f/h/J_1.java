package y.f.h;

import java.util.Arrays;
import y.f.h.D;
import y.f.h.K;
import y.f.h.L;
import y.f.h.M;
import y.f.h.N;
import y.f.h.i;
import y.f.h.k;

public class J {
   private D c;
   private k d;
   L a;
   M[] b;
   private int[] e;
   private int[] f;
   private y.c.d[] g;
   private y.c.h h = null;

   public J(D var1) {
      this.c = var1;
      int var2 = 2 * this.c.g().e();
      this.d = new k(var1);
      this.e = new int[2 * this.c.g().g()];
      this.f = new int[var2];
      this.g = new y.c.d[var2];
      this.a = new L(var2);
      this.b = new M[var2];
   }

   public void a(y.c.f var1) {
      boolean var6 = N.d;
      i var2 = new i(this.c, var1);
      var2.a();
      y.c.e var3 = var1.a();

      while(true) {
         if(var3.f()) {
            y.c.d var4 = var3.a();
            y.c.f var5 = this.a(var4, (short)1, var2, (y.c.d[])null);
            this.d.a(var5, var4);
            if(var6) {
               break;
            }

            if(y.g.o.b(this) && !this.c.n()) {
               throw new RuntimeException("Combinatorial Embedder failed !");
            }

            var3.g();
            if(!var6) {
               continue;
            }
         }

         var2.b();
         var2.e();
         break;
      }

   }

   public int b(y.c.f var1) {
      boolean var7 = N.d;
      int var2 = 0;
      i var3 = new i(this.c, var1);
      var3.a();
      y.c.e var4 = var1.a();

      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            y.c.f var6 = this.a(var5, (short)0, var3, (y.c.d[])null);
            if(var7) {
               break;
            }

            if(var6 != null) {
               var2 += var6.size();
            }

            var4.g();
            if(!var7) {
               continue;
            }
         }

         var3.b();
         var3.e();
         break;
      }

      return var2;
   }

   protected y.c.f a(y.c.d var1, short var2, i var3, y.c.d[] var4) {
      boolean var11 = N.d;
      y.c.i var5 = var3.g();
      y.c.q var6 = var5.d();
      y.c.q var7 = var5.d();
      y.c.e var8 = var1.c().l();

      y.c.d var9;
      y.c.q var10;
      while(true) {
         if(var8.f()) {
            var9 = var8.a();
            var10 = var3.a(this.c.i(var9));
            var5.a(var6, var10);
            var8.g();
            if(var11) {
               break;
            }

            if(!var11) {
               continue;
            }
         }

         var8 = var1.d().l();
         break;
      }

      label124: {
         label111: {
            label110:
            while(true) {
               if(var8.f()) {
                  var9 = var8.a();
                  var10 = var3.a(this.c.i(var9));
                  var5.a(var10, var7);
                  var8.g();
                  if(var11) {
                     break;
                  }

                  if(!var11) {
                     continue;
                  }
               }

               while(true) {
                  if(this.g.length >= var5.e()) {
                     break label110;
                  }

                  this.g = new y.c.d[2 * this.g.length];
                  if(var11) {
                     break label111;
                  }

                  if(var11) {
                     break label110;
                  }
               }
            }

            while(this.e.length < var5.g()) {
               this.e = new int[2 * this.e.length];
               if(var11) {
                  break label124;
               }

               if(var11) {
                  break;
               }
            }
         }

         while(this.f.length < var5.e()) {
            this.f = new int[2 * this.f.length];
            if(var11) {
               break label124;
            }

            if(var11) {
               break;
            }
         }

         Arrays.fill(this.e, 1);
      }

      label128: {
         if(this.h != null) {
            var8 = this.c.g().p();

            while(var8.f()) {
               var9 = var8.a();
               y.c.d var15 = var3.b(var9);
               this.e[var15.b()] = this.a(var9);
               var8.g();
               if(var11) {
                  break label128;
               }

               if(var11) {
                  break;
               }
            }
         }

         if(var4 != null) {
            int var12 = 0;

            while(var12 < var4.length) {
               this.e[var4[var12].b()] = 0;
               ++var12;
               if(var11) {
                  break label128;
               }

               if(var11) {
                  break;
               }
            }
         }

         this.a(var5, var6, var7, true, this.e, this.f, this.g);
      }

      y.c.f var13 = y.a.v.a(var6, var7, this.g);
      if(this.f[var7.d()] == Integer.MAX_VALUE) {
         var13 = null;
      }

      if(var13 == null && y.g.o.b(this)) {
         y.c.A var14 = var5.t();
         y.a.h.a(var5, var14);
         boolean var16 = var14.a(var6) == var14.a(var7);
         var5.a(var14);
         if(var16) {
            throw new RuntimeException("Error computing shortest dual path");
         }
      }

      if(var13 != null) {
         var13.d();
         var13.remove(var13.i());
      }

      var5.a(var6);
      var5.a(var7);
      switch(var2) {
      case 0:
         return var13;
      case 1:
         return this.a(var3, var13);
      default:
         throw new RuntimeException("Unknown return type style in EdgeRouter.routeEdge()");
      }
   }

   private int a(y.c.d var1) {
      return this.c.n(var1)?this.h.a(this.c.h(var1)):this.h.a(var1);
   }

   private y.c.f a(i var1, y.c.f var2) {
      boolean var7 = N.d;
      y.c.f var3 = new y.c.f();
      if(var2 == null) {
         return null;
      } else if(var2.isEmpty()) {
         return var3;
      } else {
         y.c.d var4 = null;
         y.c.d var5 = null;
         y.c.e var6 = var2.a();
         var6.j();

         y.c.f var10000;
         while(true) {
            if(var6.f()) {
               var4 = var6.a();
               var5 = var1.a(var4);
               var10000 = var3;
               if(var7) {
                  break;
               }

               var3.a(var5);
               var6.h();
               if(!var7) {
                  continue;
               }
            }

            var10000 = var3;
            break;
         }

         return var10000;
      }
   }

   public void a(int var1, y.c.f var2) {
      boolean var18 = N.d;
      boolean var3 = false;
      int var4 = 0;
      int var8 = 0;
      i var10 = new i(this.c);
      var10.a();

      label117:
      while(true) {
         if(!var3) {
            label121: {
               y.c.f var11 = new y.c.f(var2.a());
               if(var18) {
                  break;
               }

               y.c.e var10000 = var11.a();

               label112:
               while(true) {
                  y.c.e var12 = var10000;

                  y.c.d var13;
                  byte var10001;
                  int var20;
                  label123: {
                     while(var12.f()) {
                        var13 = var12.a();
                        y.c.e var14 = this.c.c(var13);
                        var20 = var14.k();
                        var10001 = 1;
                        if(var18) {
                           break label123;
                        }

                        if(var20 == 1) {
                           var11.remove(var13);
                        }

                        var12.g();
                        if(var18) {
                           break;
                        }
                     }

                     if(var11.size() == 0) {
                        break label121;
                     }

                     var20 = var1;
                     var10001 = -1;
                  }

                  if(var20 != var10001 && var4 >= var1) {
                     break label121;
                  }

                  ++var4;
                  var11.sort(new K(this));
                  var12 = var11.a();

                  while(true) {
                     y.c.e var16;
                     y.c.d[] var19;
                     label95:
                     while(true) {
                        if(!var12.f()) {
                           break label112;
                        }

                        var13 = var12.a();
                        var19 = new y.c.d[2 * this.c.c(var13).k()];
                        int var15 = 0;
                        var10000 = this.c.c(var13);
                        if(var18) {
                           continue label112;
                        }

                        var16 = var10000;

                        while(true) {
                           if(!var16.f()) {
                              break label95;
                           }

                           y.c.d var17 = var10.b(var16.a());
                           var19[var15++] = var17;
                           var19[var15++] = var10.h(var17);
                           var16.g();
                           if(var18) {
                              break;
                           }

                           if(var18) {
                              break label95;
                           }
                        }
                     }

                     y.c.f var5;
                     int var7;
                     label107: {
                        var5 = this.a(var13, (short)0, var10, var19);
                        var7 = 0;
                        if(var5.size() != 0) {
                           var16 = var5.a();

                           while(var16.f()) {
                              var20 = this.e[var16.a().b()];
                              if(var18) {
                                 break label107;
                              }

                              if(var20 > 0) {
                                 ++var7;
                              }

                              var16.g();
                              if(var18) {
                                 break;
                              }
                           }
                        }

                        var20 = this.c.c(var13).k() - 1;
                     }

                     int var6 = var20;
                     boolean var9 = var6 > var7;
                     if(var9) {
                        var8 += var6 - var7;
                        this.b(var13);
                        var5 = this.a(var13, (short)1, var10, (y.c.d[])null);
                        this.d.a(var5, var13);
                        if(!var18) {
                           continue label117;
                        }
                     }

                     var12.g();
                     if(var18) {
                        break label112;
                     }
                  }
               }

               var3 = true;
               if(!var18) {
                  continue;
               }
            }
         }

         var10.b();
         var10.e();
         break;
      }

      if(var8 == 0) {
         y.g.o.a(this, 0, "  no improvement gained by rerouting edges");
         if(!var18) {
            return;
         }
      }

      y.g.o.a(this, 0, "  improvement: " + var8 + " crossing(s) less");
   }

   private void b(y.c.d var1) {
      boolean var5 = N.d;
      y.c.y var2 = new y.c.y();
      y.c.e var3 = this.c.c(var1);

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var4.d() != var1.d()) {
            var2.add(var4.d());
         }

         this.c.a(var4);
         var3.g();
         if(var5) {
            break;
         }
      }

      y.c.x var6 = var2.a();

      while(var6.f()) {
         this.c.h(var6.e());
         var6.g();
         if(var5) {
            break;
         }
      }

   }

   public void a(y.c.i var1, y.c.q var2, y.c.q var3, boolean var4, int[] var5, int[] var6, y.c.d[] var7) {
      boolean var18 = N.d;
      int var8 = var1.e();

      while(this.b.length < var8) {
         this.b = new M[2 * this.b.length];
         if(var18) {
            break;
         }
      }

      int var9 = 0;

      while(true) {
         if(var9 < var8) {
            var7[var9] = null;
            var6[var9] = Integer.MAX_VALUE;
            ++var9;
            if(var18) {
               break;
            }

            if(!var18) {
               continue;
            }
         }

         var9 = var2.d();
         var6[var9] = 0;
         this.a.a();
         break;
      }

      this.b[var9] = this.a.a(0, var2, this.b[var9], var9);

      label53:
      while(!this.a.c()) {
         M var10 = this.a.b();
         this.a.a(var10);
         y.c.q var11 = var10.b;
         if(var11 == var3) {
            break;
         }

         int var12 = var10.c;
         int var13 = var6[var12];
         y.c.d var10000 = var11.f();

         label51:
         while(true) {
            y.c.d var14 = var10000;

            do {
               if(var14 == null) {
                  continue label53;
               }

               y.c.q var15 = var14.d();
               int var16 = var15.d();
               int var17 = var13 + var5[var14.b()];
               var10000 = var7[var16];
               if(var18) {
                  continue label51;
               }

               label46: {
                  label75: {
                     if(var10000 == null && var15 != var2) {
                        var6[var16] = var17;
                        this.b[var16] = this.a.a(var17, var15, this.b[var16], var16);
                        if(!var18) {
                           break label75;
                        }
                     }

                     if(var17 >= var6[var16]) {
                        break label46;
                     }

                     var6[var16] = var17;
                     this.a.a(this.b[var16], var17);
                  }

                  var7[var16] = var14;
               }

               var14 = var14.g();
            } while(!var18);

            return;
         }
      }

   }

   static D a(J var0) {
      return var0.c;
   }
}
