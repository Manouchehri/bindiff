package y.f.e;

import java.awt.Rectangle;
import java.util.Comparator;
import y.c.D;
import y.f.X;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.e.i;
import y.f.e.m;
import y.f.e.n;
import y.f.e.o;
import y.f.e.p;

public class l implements ad {
   public static final Object a = "y.layout.organic.ShuffleLayouter.MINIMAL_DISTANCE_DPKEY";
   public static final Object b = "y.layout.organic.ShuffleLayouter.FIXED_NODE_DPKEY";
   private ah c;
   private double d = 5.0D;
   private boolean e = false;
   private byte f = 2;
   private Rectangle[] g;
   private int[] h;
   private int[] i;
   private y.c.q[] n;
   private Comparator o;
   private boolean p;
   private y.c.c q;
   private boolean r = true;

   public void c(X var1) {
      if(this.c != null) {
         this.c.c(var1);
      }

      if(var1.e() > 0) {
         this.a(var1);
      }

   }

   public void a(ah var1) {
      this.c = var1;
   }

   public ah a() {
      return this.c;
   }

   public void a(byte var1) {
      this.f = var1;
   }

   public void a(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException("Minimal distance must be non-negative");
      } else {
         this.d = var1;
      }
   }

   public double b() {
      return this.d;
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public boolean c() {
      return this.e;
   }

   private void a(X var1) {
      double[] var2;
      int var9;
      boolean var15;
      int var16;
      label109: {
         boolean var25;
         label105: {
            label104: {
               y.c.c var10000;
               label110: {
                  label102: {
                     label119: {
                        var15 = i.b;
                        this.n = var1.m();
                        this.g = new Rectangle[var1.e()];
                        var2 = new double[var1.e() * 2];
                        double[] var3 = new double[var1.e() * 2];
                        this.q = var1.c(b);
                        y.c.c var4 = var1.c(a);
                        double var5 = this.b();
                        int var11;
                        int var12;
                        if(var5 != 0.0D || var4 != null) {
                           double var7 = var5 * 0.5D;
                           var9 = this.n.length - 1;

                           do {
                              if(var9 < 0) {
                                 break label119;
                              }

                              var10000 = var4;
                              if(var15) {
                                 break label110;
                              }

                              if(var4 != null) {
                                 label116: {
                                    double var10 = var4.c(this.n[var9]);
                                    if(var10 > 0.0D) {
                                       var7 = var10 * 0.5D;
                                       if(!var15) {
                                          break label116;
                                       }
                                    }

                                    var7 = var5 * 0.5D;
                                 }
                              }

                              am var22 = var1.a((Object)this.n[var9]);
                              var2[var9 << 1] = var22.getWidth();
                              var2[(var9 << 1) + 1] = var22.getHeight();
                              var3[var9 << 1] = var22.getX();
                              var3[(var9 << 1) + 1] = var22.getY();
                              var11 = (int)Math.floor(var22.getX() - var7);
                              var12 = (int)Math.floor(var22.getY() - var7);
                              int var13 = (int)Math.ceil(var22.getX() + var22.getWidth() + var7);
                              int var14 = (int)Math.ceil(var22.getY() + var22.getHeight() + var7);
                              this.g[var9] = new Rectangle(var11, var12, var13 - var11, var14 - var12);
                              --var9;
                           } while(!var15);
                        }

                        var16 = this.n.length - 1;

                        while(var16 >= 0) {
                           am var8 = var1.a((Object)this.n[var16]);
                           var2[var16 << 1] = var8.getWidth();
                           var2[(var16 << 1) + 1] = var8.getHeight();
                           var9 = (int)Math.floor(var8.getX());
                           int var23 = (int)Math.floor(var8.getY());
                           var11 = (int)Math.ceil(var8.getX() + var8.getWidth());
                           var12 = (int)Math.ceil(var8.getY() + var8.getHeight());
                           this.g[var16] = new Rectangle(var9, var23, var11 - var9, var12 - var23);
                           --var16;
                           if(var15) {
                              break label102;
                           }

                           if(var15) {
                              break;
                           }
                        }
                     }

                     this.o = new n(this);
                  }

                  int[] var17;
                  int[] var18;
                  int[] var21;
                  int[] var24;
                  if(this.c()) {
                     if(this.p) {
                        var18 = new int[this.g.length];
                        var17 = new int[this.g.length];
                        var21 = new int[this.g.length];
                        var24 = new int[this.g.length];
                        this.a(this.g, var18, var17);
                        y.g.e.a((Object[])this.n, this.o);
                        this.h();
                        this.a(this.g, var21, var24);
                        this.b(var18, var17, this.g);
                        this.g();
                        this.a((Object[])this.n);
                        this.h();
                        this.g();
                        this.a(var21, var24, this.g);
                        if(!var15) {
                           break label109;
                        }
                     }

                     y.g.e.a((Object[])this.n, this.o);
                     this.h();
                     if(!var15) {
                        break label109;
                     }
                  }

                  if(this.p) {
                     var18 = new int[this.g.length];
                     var17 = new int[this.g.length];
                     var21 = new int[this.g.length];
                     var24 = new int[this.g.length];
                     this.a(this.g);
                     this.e();
                     this.a(this.g, var18, var17);
                     y.g.e.a((Object[])this.n, this.o);
                     this.h();
                     this.a(this.g, var21, var24);
                     this.b(var18, var17, this.g);
                     this.g();
                     this.a((Object[])this.n);
                     this.h();
                     this.g();
                     this.a(var21, var24, this.g);
                     this.d();
                     this.a(this.g);
                     this.f();
                     this.a(this.g, var18, var17);
                     y.g.e.a((Object[])this.n, this.o);
                     this.h();
                     this.a(this.g, var21, var24);
                     this.b(var18, var17, this.g);
                     this.g();
                     this.a((Object[])this.n);
                     this.h();
                     this.g();
                     this.a(var21, var24, this.g);
                     this.f();
                     this.b(this.g);
                     this.b(this.g);
                     if(!var15) {
                        break label109;
                     }
                  }

                  this.e();
                  y.g.e.a((Object[])this.n, this.o);
                  this.h();
                  if(!this.r) {
                     break label104;
                  }

                  var10000 = this.q;
               }

               if(var10000 != null) {
                  var25 = true;
                  break label105;
               }
            }

            var25 = false;
         }

         boolean var20 = var25;
         if(var20) {
            this.g();
            y.g.e.a((Object[])this.n, this.o);
            this.h();
            this.g();
         }

         this.d();
         this.f();
         y.g.e.a((Object[])this.n, this.o);
         this.h();
         if(var20) {
            this.g();
            y.g.e.a((Object[])this.n, this.o);
            this.h();
            this.g();
         }

         this.f();
         if(var20) {
            y.g.e.a((Object[])this.n, this.o);
            this.h();
            this.g();
            y.g.e.a((Object[])this.n, this.o);
            this.h();
            this.g();
         }
      }

      var16 = this.n.length - 1;

      while(true) {
         if(var16 >= 0) {
            y.c.q var19 = this.n[var16];
            var9 = var19.d();
            var1.b(var19, var2[var9 << 1], var2[(var9 << 1) + 1]);
            var1.a(var19, (double)this.g[var9].x + (double)this.g[var9].width * 0.5D, (double)this.g[var9].y + (double)this.g[var9].height * 0.5D);
            --var16;
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         this.n = null;
         this.g = null;
         this.q = null;
         break;
      }

   }

   private void a(Object[] var1) {
      boolean var4 = i.b;
      int var2 = (var1.length - 1) / 2;

      while(var2 >= 0) {
         Object var3 = var1[var2];
         var1[var2] = var1[var1.length - 1 - var2];
         var1[var1.length - 1 - var2] = var3;
         --var2;
         if(var4) {
            break;
         }
      }

   }

   private void d() {
      boolean var2 = i.b;
      int var1 = this.n.length - 1;

      while(true) {
         if(var1 >= 0) {
            this.g[var1].width = this.h[var1];
            this.g[var1].x = this.i[var1];
            --var1;
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.h = null;
         this.i = null;
         break;
      }

   }

   private void a(Rectangle[] var1) {
      boolean var3 = i.b;
      int var2 = var1.length - 1;

      while(var2 >= 0) {
         var1[var2].x <<= 1;
         var1[var2].y <<= 1;
         var1[var2].width <<= 1;
         var1[var2].height <<= 1;
         --var2;
         if(var3) {
            break;
         }
      }

   }

   private void b(Rectangle[] var1) {
      boolean var3 = i.b;
      int var2 = var1.length - 1;

      while(var2 >= 0) {
         var1[var2].x >>= 1;
         var1[var2].y >>= 1;
         var1[var2].width >>= 1;
         var1[var2].height >>= 1;
         --var2;
         if(var3) {
            break;
         }
      }

   }

   private void e() {
      boolean var3 = i.b;
      this.h = new int[this.g.length];
      this.i = new int[this.g.length];
      y.g.e.a((Object[])this.n, this.o);
      D var1 = new D();
      int var2 = this.n.length - 1;

      while(true) {
         if(var2 >= 0) {
            this.h[var2] = this.g[var2].width;
            this.i[var2] = this.g[var2].x;
            var1.add(new o(this.g[var2]));
            --var2;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         y.d.f.a(var1, new m(this));
         break;
      }

   }

   private void f() {
      boolean var7 = i.b;
      int var1 = this.g.length - 1;

      while(var1 >= 0) {
         Rectangle var6 = this.g[var1];
         int var2 = var6.x;
         int var3 = var6.y;
         int var4 = var6.width;
         int var5 = var6.height;
         var6.x = var3;
         var6.y = var2;
         var6.width = var5;
         var6.height = var4;
         --var1;
         if(var7) {
            break;
         }
      }

   }

   private void a(int[] var1, int[] var2, Rectangle[] var3) {
      boolean var5 = i.b;
      int var4 = var3.length - 1;

      while(var4 >= 0) {
         var3[var4].x = var3[var4].x + var1[var4] >> 1;
         var3[var4].y = var3[var4].y + var2[var4] >> 1;
         --var4;
         if(var5) {
            break;
         }
      }

   }

   private void a(Rectangle[] var1, int[] var2, int[] var3) {
      boolean var5 = i.b;
      int var4 = var1.length - 1;

      while(var4 >= 0) {
         var2[var4] = var1[var4].x;
         var3[var4] = var1[var4].y;
         --var4;
         if(var5) {
            break;
         }
      }

   }

   private void b(int[] var1, int[] var2, Rectangle[] var3) {
      boolean var5 = i.b;
      int var4 = var3.length - 1;

      while(var4 >= 0) {
         var3[var4].x = var1[var4];
         var3[var4].y = var2[var4];
         --var4;
         if(var5) {
            break;
         }
      }

   }

   private void g() {
      boolean var3 = i.b;
      int var1 = this.g.length - 1;

      while(var1 >= 0) {
         Rectangle var2 = this.g[var1];
         var2.y = -(var2.y + var2.height);
         --var1;
         if(var3) {
            break;
         }
      }

   }

   private void h() {
      boolean var24 = i.b;
      int var2 = Integer.MAX_VALUE;
      int var1 = Integer.MAX_VALUE;
      int var4 = Integer.MIN_VALUE;
      int var3 = Integer.MIN_VALUE;
      int var5 = this.g.length - 1;

      Rectangle var10000;
      while(true) {
         if(var5 >= 0) {
            Rectangle var6 = this.g[var5];
            var10000 = var6;
            if(var24) {
               break;
            }

            if(var6.x < var1) {
               var1 = var6.x;
            }

            if(var6.y < var2) {
               var2 = var6.y;
            }

            if(var6.x + var6.width > var3) {
               var3 = var6.x + var6.width;
            }

            if(var6.y + var6.height > var4) {
               var4 = var6.y + var6.height;
            }

            --var5;
            if(!var24) {
               continue;
            }
         }

         var10000 = new Rectangle(var1, var2, var3 - var1, var4 - var2);
         break;
      }

      Rectangle var25 = var10000;
      D var26 = new D();
      p var7 = new p(var25.y, var25.x - 10, var25.x + var25.width + 10);
      var26.add(var7);
      int var8 = 0;

      do {
         int var27 = var8;
         int var10001 = this.n.length;

         Rectangle var9;
         int var10;
         int var11;
         int var12;
         y.c.p var13;
         y.c.p var14;
         int var15;
         y.c.p var16;
         label177:
         while(true) {
            label167:
            while(true) {
               if(var27 >= var10001) {
                  return;
               }

               var9 = this.g[this.n[var8].d()];
               var10 = var9.y;
               var11 = var9.x;
               var12 = var9.x + var9.width;
               var13 = null;
               var14 = null;
               var15 = var25.y;
               var16 = var26.k();

               while(true) {
                  if(var16 == null) {
                     break label167;
                  }

                  var7 = (p)var16.c();
                  var27 = var11;
                  var10001 = var7.c;
                  if(var24) {
                     break;
                  }

                  if(var11 < var10001) {
                     var13 = var16;
                     var15 = Math.max(var15, var7.a);
                     break label167;
                  }

                  var16 = var16.a();
               }
            }

            while(true) {
               if(var16 == null) {
                  break label177;
               }

               var7 = (p)var16.c();
               var15 = Math.max(var15, var7.a);
               var27 = var12;
               var10001 = var7.c;
               if(var24) {
                  break;
               }

               if(var12 <= var10001) {
                  var14 = var16;
                  break label177;
               }

               var16 = var16.a();
            }
         }

         label204: {
            int var17;
            p var18;
            p var19;
            p var20;
            if(this.a(this.n[var8]) && var15 > var10) {
               var17 = var10 + var9.height;
               var18 = new p(var17, var11, var12);
               var19 = (p)var13.c();
               var20 = (p)var14.c();
               if(var13 == var14) {
                  if(var19.a >= var18.a) {
                     break label204;
                  }

                  if(var19.b == var11 && var19.c == var12) {
                     var13.a(var18);
                     if(!var24) {
                        break label204;
                     }
                  }

                  var20 = new p(var19.a, var12, var19.c);
                  var19.c = var11;
                  var14 = var26.b((Object)var20, var13);
                  var26.b((Object)var18, var13);
                  if(var19.c == var19.b) {
                     var26.h(var13);
                  }

                  if(var20.c != var20.b) {
                     break label204;
                  }

                  var26.h(var14);
                  if(!var24) {
                     break label204;
                  }
               }

               p var21 = var19;
               y.c.p var22 = var13.a();
               if(var19.a < var18.a) {
                  var26.b((Object)(var21 = new p(var17, var11, var19.c)), var13);
                  var19.c = var11;
               }

               if(var20.a < var18.a) {
                  var26.a((Object)(new p(var17, var20.b, var12)), (y.c.p)var14);
                  var20.b = var12;
               }

               var16 = var22;

               label151: {
                  while(var16 != var14) {
                     p var23 = (p)var16.c();
                     var27 = var23.a;
                     var10001 = var17;
                     if(var24) {
                        break label151;
                     }

                     label208: {
                        if(var27 > var17) {
                           var21 = var23;
                           if(!var24) {
                              break label208;
                           }
                        }

                        var23.a = var17;
                        if(var21.a == var17) {
                           var26.h(var16);
                           var21.c = var23.c;
                           if(!var24) {
                              break label208;
                           }
                        }

                        var21 = var23;
                     }

                     var16 = var16.a();
                     if(var24) {
                        break;
                     }
                  }

                  var27 = var19.c;
                  var10001 = var19.b;
               }

               if(var27 == var10001) {
                  var26.h(var13);
               }

               if(var20.c != var20.b) {
                  break label204;
               }

               var26.h(var14);
               if(!var24) {
                  break label204;
               }
            }

            var4 = Math.max(var10, var15);
            var17 = var4 + var9.height;
            var9.y = var4;
            var18 = new p(var17, var11, var12);
            var19 = (p)var13.c();
            var20 = (p)var14.c();
            if(var13 == var14) {
               if(var19.b == var11 && var19.c == var12) {
                  var13.a(var18);
                  if(!var24) {
                     break label204;
                  }
               }

               var20 = new p(var19.a, var12, var19.c);
               var19.c = var11;
               var14 = var26.b((Object)var20, var13);
               var26.b((Object)var18, var13);
               if(var19.c == var19.b) {
                  var26.h(var13);
               }

               if(var20.c != var20.b) {
                  break label204;
               }

               var26.h(var14);
               if(!var24) {
                  break label204;
               }
            }

            var19.c = var11;
            var20.b = var12;
            var16 = var13.a();

            label103: {
               while(var16 != var14) {
                  var26.h(var16);
                  var16 = var16.a();
                  if(var24) {
                     break label103;
                  }

                  if(var24) {
                     break;
                  }
               }

               var26.b((Object)var18, var13);
            }

            if(var19.c == var19.b) {
               var26.h(var13);
            }

            if(var20.c == var20.b) {
               var26.h(var14);
            }
         }

         ++var8;
      } while(!var24);

   }

   private boolean a(y.c.q var1) {
      return this.q != null?this.q.d(var1):false;
   }

   public void b(boolean var1) {
      this.p = var1;
   }

   static final boolean a(Rectangle var0, Rectangle var1) {
      return var0.width > 0 && var0.height > 0 && var1.width > 0 && var1.height > 0 && var1.x >= var0.x && var1.x + var1.width <= var0.x + var0.width && var1.y >= var0.y && var1.y + var1.height <= var0.y + var0.height;
   }

   static Rectangle[] a(l var0) {
      return var0.g;
   }

   static boolean a(l var0, y.c.q var1) {
      return var0.a(var1);
   }

   static byte b(l var0) {
      return var0.f;
   }
}
