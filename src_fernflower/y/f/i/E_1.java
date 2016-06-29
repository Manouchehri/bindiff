package y.f.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.i.F;
import y.f.i.G;
import y.f.i.H;
import y.f.i.I;
import y.f.i.J;
import y.f.i.ac;
import y.f.i.v;

public class E extends y.f.a {
   public static final Object a = "y.layout.router.OrthogonalPatternEdgeRouter.AFFECTED_EDGES";
   private double b = 10.0D;
   private double c = 1.0D;
   private double d = 5.0D;
   private double e = 50.0D;
   private boolean f;
   private y.d.t g = new y.d.t(0.0D, 0.0D);
   private double h = 10.0D;
   private y.d.t i;
   private List n;
   private List o;
   private int p;
   private int q = 50;
   private int r = 20;
   private final ArrayList s;
   private Object t;
   private y.c.c u;
   private double v;
   private byte w;

   public E() {
      this.t = a;
      this.w = 0;
      this.s = new ArrayList();
      this.s.add(y.f.ax.b((int)1));
      this.s.add(y.f.ax.b((int)4));
      this.s.add(y.f.ax.b((int)2));
      this.s.add(y.f.ax.b((int)8));
      this.n = new ArrayList();
      this.o = new ArrayList();
   }

   public void a(byte var1) {
      this.w = var1;
   }

   private boolean e() {
      return this.w == 1 || this.w == 3;
   }

   private boolean f() {
      return this.w == 2 || this.w == 3;
   }

   public void c(y.f.X var1) {
      int var24 = v.f;
      boolean var2 = false;
      if(var1.c("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
         this.b(var1);
         var1.a((Object)"y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY", (y.c.c)y.g.q.a((Object)Boolean.TRUE));
         var2 = true;
      }

      y.f.X var25;
      label107: {
         this.a((y.f.X)var1);
         if(var1.h() > 0) {
            (new ac()).c(var1);
            this.u = var1.c(this.t);
            boolean var3 = false;
            this.d(var1);
            y.c.D var4 = new y.c.D();
            int var5 = 0;

            label99:
            do {
               int var10000 = var5;

               label96:
               while(true) {
                  if(var10000 >= 2) {
                     break label99;
                  }

                  var25 = var1;
                  if(var24 != 0) {
                     break label107;
                  }

                  y.c.e var6 = var1.p();

                  while(true) {
                     if(!var6.f()) {
                        break label96;
                     }

                     double var7 = Double.MAX_VALUE;
                     var4.clear();
                     y.c.d var9 = var6.a();
                     var10000 = var5;
                     if(var24 != 0) {
                        break;
                     }

                     if((var5 != 0 || !var9.e()) && (var5 != 1 || var9.e()) && (this.u == null || this.u.d(var9))) {
                        y.c.q var10 = var9.c();
                        y.c.q var11 = var9.d();
                        Collection var12 = this.a(var1, var9, true);
                        Collection var13 = this.a(var1, var9, false);
                        Iterator var14 = var12.iterator();

                        label90:
                        while(true) {
                           if(var14.hasNext()) {
                              y.f.ax var15 = (y.f.ax)var14.next();
                              Iterator var16 = var13.iterator();

                              while(true) {
                                 if(!var16.hasNext()) {
                                    continue label90;
                                 }

                                 y.f.ax var17 = (y.f.ax)var16.next();
                                 y.c.D var18 = this.a(var1, var10, var11, var15, var17);
                                 double var19 = this.a(var9, var18, var15, var17);
                                 double var26;
                                 var10000 = (var26 = var19 - var7) == 0.0D?0:(var26 < 0.0D?-1:1);
                                 if(var24 != 0) {
                                    break label90;
                                 }

                                 if(var10000 < 0) {
                                    var4 = var18;
                                    var7 = var19;
                                    var3 = false;
                                 }

                                 y.c.D var21 = this.a(var1, var11, var10, var17, var15);
                                 double var22 = this.a(var9, var21, var15, var17);
                                 if(var22 < var7) {
                                    var4 = var21;
                                    var7 = var22;
                                    var3 = true;
                                    if(var24 != 0 || var24 != 0) {
                                       break;
                                    }
                                 }
                              }
                           }

                           var10000 = var4.size();
                           break;
                        }

                        if(var10000 > 1) {
                           if(var3) {
                              var4.n();
                           }

                           var1.a(var9, var4);
                           this.c(var4);
                        }
                     }

                     var6.g();
                     if(var24 != 0) {
                        break label96;
                     }
                  }
               }

               ++var5;
            } while(var24 == 0);
         }

         if(!var2) {
            return;
         }

         var25 = var1;
      }

      var25.d_("y.layout.router.ORTHOGONAL_PATTERN_EDGE_ROUTER_NODE_SIZE_CHECKED_DPKEY");
   }

   private void b(y.f.X var1) {
      this.a((y.c.n)var1, (y.f.O)var1);
   }

   private void a(y.c.n var1, y.f.O var2) {
      int var6 = v.f;
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(var3 == null) {
         var3 = y.g.q.a((Object)Boolean.FALSE);
      }

      Iterator var4 = var1.x();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(!var3.d(var5)) {
            this.a(var2, var5);
            if(var6 == 0) {
               continue;
            }
         }

         this.b(var2, var5);
         if(var6 != 0) {
            break;
         }
      }

   }

   protected void a(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   protected void b(y.f.O var1, Object var2) {
      y.f.am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   private Collection a(y.f.am var1) {
      HashSet var4 = new HashSet();
      var4.add(y.f.ax.a(-var1.getWidth() * 0.5D + this.b, -var1.getHeight() * 0.5D, 1, 0.1D));
      var4.add(y.f.ax.a(var1.getWidth() * 0.5D - this.b, -var1.getHeight() * 0.5D, 1, 0.1D));
      var4.add(y.f.ax.a(var1.getWidth() * 0.5D, this.b - var1.getHeight() * 0.5D, 4, 0.1D));
      var4.add(y.f.ax.a(var1.getWidth() * 0.5D, var1.getHeight() * 0.5D - this.b, 4, 0.1D));
      var4.add(y.f.ax.a(var1.getWidth() * 0.5D - this.b, var1.getHeight() * 0.5D, 2, 0.1D));
      var4.add(y.f.ax.a(-var1.getWidth() * 0.5D + this.b, var1.getHeight() * 0.5D, 2, 0.1D));
      var4.add(y.f.ax.a(-var1.getWidth() * 0.5D, var1.getHeight() * 0.5D - this.b, 8, 0.1D));
      var4.add(y.f.ax.a(-var1.getWidth() * 0.5D, -var1.getHeight() * 0.5D + this.b, 8, 0.1D));
      return var4;
   }

   private void d(y.f.X var1) {
      int var14 = v.f;
      this.o.clear();
      this.n.clear();
      y.c.x var2 = var1.o();

      E var10000;
      label73:
      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            y.f.am var4 = ((y.f.X)var3.e()).h(var3);
            I var5 = new I(var3, var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
            F var6 = new F(true, var4.getX(), var4.getY(), var4.getY() + var4.getHeight(), var5);
            F var7 = new F(false, var4.getX() + var4.getWidth(), var4.getY(), var4.getY() + var4.getHeight(), var5);
            this.n.add(var6);
            this.n.add(var7);
            var5 = new I(var3, var4.getY(), var4.getX(), var4.getHeight(), var4.getWidth());
            var6 = new F(true, var4.getY(), var4.getX(), var4.getX() + var4.getWidth(), var5);
            var7 = new F(false, var4.getY() + var4.getHeight(), var4.getX(), var4.getX() + var4.getWidth(), var5);
            this.o.add(var6);
            this.o.add(var7);
            if(var14 != 0) {
               return;
            }

            y.c.e var15 = var3.l();

            while(var15.f()) {
               y.c.d var16 = var15.a();
               var10000 = this;
               if(var14 != 0) {
                  break label73;
               }

               label65: {
                  if(this.u != null && !this.u.d(var16)) {
                     y.d.t var17 = null;
                     Iterator var8 = var1.m(var16).iterator();

                     while(var8.hasNext()) {
                        y.d.t var9 = (y.d.t)var8.next();
                        if(var14 != 0) {
                           break label65;
                        }

                        if(var17 != null) {
                           y.d.t var10;
                           y.d.t var11;
                           label57: {
                              if(var9.a() <= var17.a()) {
                                 var10 = var9;
                                 var11 = var17;
                                 if(var14 == 0) {
                                    break label57;
                                 }
                              }

                              var10 = var17;
                              var11 = var9;
                           }

                           y.d.t var12;
                           y.d.t var13;
                           label52: {
                              if(var9.b() <= var17.b()) {
                                 var12 = var9;
                                 var13 = var17;
                                 if(var14 == 0) {
                                    break label52;
                                 }
                              }

                              var12 = var17;
                              var13 = var9;
                           }

                           this.a(this.n, var10.a(), var10.b(), var11.a(), var11.b());
                           this.a(this.o, var12.b(), var12.a(), var13.b(), var13.a());
                        }

                        var17 = var9;
                        if(var14 != 0) {
                           break;
                        }
                     }
                  }

                  var15.g();
               }

               if(var14 != 0) {
                  break;
               }
            }

            var2.g();
            if(var14 == 0) {
               continue;
            }
         }

         this.a(this.n);
         var10000 = this;
         break;
      }

      var10000.a(this.o);
   }

   private static boolean a(y.f.X var0, y.c.d var1) {
      return var0.n(var1.c()) + var0.q(var1.c()) >= var0.n(var1.d()) && var0.n(var1.d()) + var0.q(var1.d()) >= var0.n(var1.c());
   }

   private static boolean b(y.f.X var0, y.c.d var1) {
      return var0.m(var1.c()) + var0.p(var1.c()) >= var0.m(var1.d()) && var0.m(var1.d()) + var0.p(var1.d()) >= var0.m(var1.c());
   }

   private Collection a(y.f.X var1, y.c.d var2, boolean var3) {
      y.c.c var4;
      int var11;
      label145: {
         var11 = v.f;
         if(var3) {
            var4 = var1.c(y.f.ax.a);
            if(var11 == 0) {
               break label145;
            }
         }

         var4 = var1.c(y.f.ax.b);
      }

      Object var5 = null;
      y.c.c var6;
      if(var4 != null) {
         var5 = (Collection)var4.b(var2);
      } else {
         label138: {
            if(var3) {
               var6 = var1.c(y.f.aF.a);
               if(var11 == 0) {
                  break label138;
               }
            }

            var6 = var1.c(y.f.aF.b);
         }

         if(var6 != null) {
            y.f.aE var7 = (y.f.aE)var6.b(var2);
            if(var7 != null) {
               y.f.ax var8;
               label131: {
                  var5 = new ArrayList();
                  int var9 = this.b(var7.b());
                  if(var7.a()) {
                     y.d.t var10;
                     label128: {
                        if(var3) {
                           var10 = var1.n(var2);
                           if(var11 == 0) {
                              break label128;
                           }
                        }

                        var10 = var1.o(var2);
                     }

                     var8 = y.f.ax.a(var10.a(), var10.b(), var9);
                     if(var11 == 0) {
                        break label131;
                     }
                  }

                  var8 = y.f.ax.b(var9);
               }

               ((Collection)var5).add(var8);
            }
         }
      }

      label121: {
         if(var5 == null) {
            var6 = var1.c(y.f.ay.a);
            if(var6 != null) {
               y.c.q var12 = var3?var2.c():var2.d();
               y.f.ay var15 = (y.f.ay)var6.b(var12);
               if(var15 != null) {
                  var5 = new ArrayList();
                  Iterator var16 = var15.a();

                  while(var16.hasNext()) {
                     y.f.aA var18 = (y.f.aA)var16.next();
                     ((Collection)var5).add(var18.a());
                     if(var11 != 0) {
                        break label121;
                     }

                     if(var11 != 0) {
                        break;
                     }
                  }
               }
            }
         }

         if(var5 == null && (this.w == 2 || this.w == 1)) {
            label160: {
               var5 = new ArrayList();
               y.d.t var13 = var1.l(var2.c());
               y.d.t var14 = var1.l(var2.d());
               boolean var17;
               if(this.w == 1 && !a(var1, var2)) {
                  var17 = var14.b() < var13.b();
                  if(var3 && var17 || !var3 && !var17) {
                     ((Collection)var5).add(y.f.ax.b((int)1));
                     if(var11 == 0) {
                        break label160;
                     }
                  }

                  ((Collection)var5).add(y.f.ax.b((int)2));
                  if(var11 == 0) {
                     break label160;
                  }
               }

               if(this.w == 2 && !b(var1, var2)) {
                  label168: {
                     var17 = var13.a() > var14.a();
                     if(var3 && var17 || !var3 && !var17) {
                        ((Collection)var5).add(y.f.ax.b((int)8));
                        if(var11 == 0) {
                           break label168;
                        }
                     }

                     ((Collection)var5).add(y.f.ax.b((int)4));
                  }
               }
            }
         }
      }

      if(var5 == null) {
         var5 = new ArrayList(this.s);
         if(var2.e()) {
            ((Collection)var5).addAll(this.a(var1.a((Object)(var3?var2.c():var2.d()))));
         }
      }

      return this.a((Collection)var5);
   }

   private int b(byte var1) {
      int var2 = v.f;
      byte var3;
      switch(var1) {
      case 0:
         var3 = 15;
         if(var2 == 0) {
            break;
         }
      case 1:
         var3 = 1;
         if(var2 == 0) {
            break;
         }
      case 4:
         var3 = 4;
         if(var2 == 0) {
            break;
         }
      case 2:
         var3 = 2;
         if(var2 == 0) {
            break;
         }
      case 8:
         var3 = 8;
         if(var2 == 0) {
            break;
         }
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         var3 = 15;
      }

      return var3;
   }

   private Collection a(Collection var1) {
      boolean var10000;
      ArrayList var2;
      label75: {
         label78: {
            int var5 = v.f;
            var2 = new ArrayList();
            if(var1 == null) {
               var2 = this.s;
               if(var5 == 0) {
                  break label78;
               }
            }

            Iterator var3 = var1.iterator();

            label69:
            do {
               y.f.ax var4;
               do {
                  do {
                     if(!var3.hasNext()) {
                        break label69;
                     }

                     var4 = (y.f.ax)var3.next();
                     if((var4.a() & 1) == 1) {
                        label84: {
                           if(var4.b()) {
                              var2.add(y.f.ax.a(var4.c(), var4.d(), 1, var4.f()));
                              if(var5 == 0) {
                                 break label84;
                              }
                           }

                           var2.add(y.f.ax.a(1, var4.f()));
                        }
                     }

                     if((var4.a() & 4) == 4) {
                        label85: {
                           if(var4.b()) {
                              var2.add(y.f.ax.a(var4.c(), var4.d(), 4, var4.f()));
                              if(var5 == 0) {
                                 break label85;
                              }
                           }

                           var2.add(y.f.ax.a(4, var4.f()));
                        }
                     }

                     if((var4.a() & 2) == 2) {
                        if(var4.b()) {
                           var2.add(y.f.ax.a(var4.c(), var4.d(), 2, var4.f()));
                           if(var5 == 0) {
                              continue;
                           }
                        }

                        var2.add(y.f.ax.a(2, var4.f()));
                     }
                  } while((var4.a() & 8) != 8);

                  var10000 = var4.b();
                  if(var5 != 0) {
                     break label75;
                  }

                  if(!var10000) {
                     break;
                  }

                  var2.add(y.f.ax.a(var4.c(), var4.d(), 8, var4.f()));
               } while(var5 == 0);

               var2.add(y.f.ax.a(8, var4.f()));
            } while(var5 == 0);
         }

         var10000 = var2.isEmpty();
      }

      if(var10000) {
         var2 = this.s;
      }

      return var2;
   }

   private y.c.D a(y.f.X var1, y.c.q var2, y.c.q var3, y.f.ax var4, y.f.ax var5) {
      int var57 = v.f;
      y.f.ax var6 = var4;
      y.f.ax var7 = var5;
      y.c.D var8 = new y.c.D();
      Object var9 = var1.a((Object)var2);
      Object var10 = var1.a((Object)var3);
      int var11 = var4.a();
      int var12 = var5.a();
      double[] var13 = new double[]{1.0D, 0.0D, 0.0D, 1.0D};
      switch(var11) {
      case 1:
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         this.i = this.g;
         if(var57 == 0) {
            break;
         }
      case 4:
         var13[0] = 0.0D;
         var13[1] = -1.0D;
         var13[2] = 1.0D;
         var13[3] = 0.0D;
         var9 = new y.f.x(((y.f.am)var9).getY(), -(((y.f.am)var9).getX() + ((y.f.am)var9).getWidth()), ((y.f.am)var9).getHeight(), ((y.f.am)var9).getWidth());
         var10 = new y.f.x(((y.f.am)var10).getY(), -(((y.f.am)var10).getX() + ((y.f.am)var10).getWidth()), ((y.f.am)var10).getHeight(), ((y.f.am)var10).getWidth());
         this.i = new y.d.t(this.g.b(), -this.g.a());
         var12 = this.a(var12, (byte)2);
         if(var57 == 0) {
            break;
         }
      case 2:
         var13[0] = -1.0D;
         var13[1] = 0.0D;
         var13[2] = 0.0D;
         var13[3] = -1.0D;
         var9 = new y.f.x(-(((y.f.am)var9).getX() + ((y.f.am)var9).getWidth()), -(((y.f.am)var9).getY() + ((y.f.am)var9).getHeight()), ((y.f.am)var9).getWidth(), ((y.f.am)var9).getHeight());
         var10 = new y.f.x(-(((y.f.am)var10).getX() + ((y.f.am)var10).getWidth()), -(((y.f.am)var10).getY() + ((y.f.am)var10).getHeight()), ((y.f.am)var10).getWidth(), ((y.f.am)var10).getHeight());
         this.i = new y.d.t(-this.g.a(), -this.g.b());
         var12 = this.a(var12, (byte)1);
         if(var57 == 0) {
            break;
         }
      case 8:
         var13[0] = 0.0D;
         var13[1] = 1.0D;
         var13[2] = -1.0D;
         var13[3] = 0.0D;
         var9 = new y.f.x(-(((y.f.am)var9).getY() + ((y.f.am)var9).getHeight()), ((y.f.am)var9).getX(), ((y.f.am)var9).getHeight(), ((y.f.am)var9).getWidth());
         var10 = new y.f.x(-(((y.f.am)var10).getY() + ((y.f.am)var10).getHeight()), ((y.f.am)var10).getX(), ((y.f.am)var10).getHeight(), ((y.f.am)var10).getWidth());
         this.i = new y.d.t(-this.g.b(), this.g.a());
         var12 = this.a(var12, (byte)0);
      }

      double var14;
      double var16;
      label575: {
         if(!var4.b()) {
            var6 = this.a(var4, (y.f.am)var9, 1);
            if(var57 == 0) {
               break label575;
            }
         }

         var14 = var6.c() * var13[0] + var6.d() * var13[2];
         var16 = var6.c() * var13[1] + var6.d() * var13[3];
         var6 = y.f.ax.a(var14, var16, var6.a(), var6.f());
      }

      label570: {
         if(!var5.b()) {
            var7 = this.a(var5, (y.f.am)var10, var12);
            if(var57 == 0) {
               break label570;
            }
         }

         var14 = var7.c() * var13[0] + var7.d() * var13[2];
         var16 = var7.c() * var13[1] + var7.d() * var13[3];
         var7 = y.f.ax.a(var14, var16, var7.a(), var7.f());
      }

      byte var58;
      label565: {
         if(var2 == var3) {
            var58 = 8;
            if(var57 == 0) {
               break label565;
            }
         }

         var58 = this.a((y.f.am)var9, (y.f.am)var10);
      }

      label584: {
         double var23;
         double var25;
         double var27;
         double var29;
         double var31;
         double var33;
         double var39;
         double var41;
         double var43;
         double var45;
         double var51;
         label585: {
            label586: {
               label587: {
                  label588: {
                     label589: {
                        label590: {
                           double var15 = ((y.f.am)var9).getX() + 0.5D * ((y.f.am)var9).getWidth();
                           double var17 = ((y.f.am)var9).getY() + 0.5D * ((y.f.am)var9).getHeight();
                           double var19 = ((y.f.am)var10).getX() + 0.5D * ((y.f.am)var10).getWidth();
                           double var21 = ((y.f.am)var10).getY() + 0.5D * ((y.f.am)var10).getHeight();
                           var23 = var15 + var6.c();
                           var25 = var17 + var6.d();
                           var27 = var19 + var7.c();
                           var29 = var21 + var7.d();
                           var8.add(new y.d.t(var15 + var6.c(), var17 + var6.d()));
                           double var49;
                           switch(var58) {
                           case 1:
                              break;
                           case 2:
                              break label586;
                           case 3:
                              break label585;
                           case 4:
                              break label590;
                           case 5:
                              break label589;
                           case 6:
                              break label587;
                           case 7:
                              break label588;
                           case 8:
                              label535: {
                                 double var47;
                                 label534: {
                                    var47 = Math.min(((y.f.am)var9).getHeight(), ((y.f.am)var9).getWidth()) / 2.0D;
                                    this.d(var8, var25 - ((y.f.am)var9).getY() + var47, true);
                                    switch(var12) {
                                    case 1:
                                       label525: {
                                          var49 = var23 - var27;
                                          if(var49 != 0.0D) {
                                             this.b(var8, var49, false);
                                             if(var57 == 0) {
                                                break label525;
                                             }
                                          }

                                          this.b(var8, var23 - ((y.f.am)var9).getX(), false);
                                       }

                                       this.a(var8, var29 - this.b(var8), false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    case 4:
                                       this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23 + var47, true);
                                       this.a(var8, var29 - this.b(var8), false);
                                       this.b(var8, this.a(var8) - var27, false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    case 2:
                                       break;
                                    case 3:
                                    case 5:
                                    case 6:
                                    case 7:
                                    default:
                                       break label535;
                                    case 8:
                                       break label534;
                                    }

                                    this.b(var8, var23 - ((y.f.am)var9).getX() + var47, true);
                                    this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + var47 - this.b(var8), true);
                                    this.c(var8, var27 - this.a(var8), false);
                                    this.d(var8, this.b(var8) - var29, false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 }

                                 this.b(var8, var23 - ((y.f.am)var9).getX() + var47, true);
                                 this.a(var8, var29 - this.b(var8), false);
                                 this.c(var8, var27 - this.a(var8), false);
                                 if(var57 == 0) {
                                    break label584;
                                 }
                              }

                              if(var57 == 0) {
                                 break label584;
                              }
                           case 0:
                              double var35;
                              double var37;
                              label516: {
                                 var35 = ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23;
                                 var37 = ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() - var23;
                                 var39 = var27 - var23;
                                 var41 = ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight();
                                 var43 = ((y.f.am)var10).getY();
                                 if(this.f) {
                                    var45 = this.a(((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b, true, true);
                                    if(var57 == 0) {
                                       break label516;
                                    }
                                 }

                                 var45 = ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b;
                              }

                              label592: {
                                 label593: {
                                    switch(var12) {
                                    case 1:
                                       this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                       if(var39 > var35 + this.b) {
                                          this.c(var8, var39, false);
                                          this.a(var8, var29 - this.b(var8), false);
                                          if(var57 == 0) {
                                             break label584;
                                          }
                                       }

                                       label500: {
                                          this.c(var8, var35 + this.b, true);
                                          if(this.a(var41, var43, var45)) {
                                             this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
                                             if(var57 == 0) {
                                                break label500;
                                             }
                                          }

                                          var49 = ((y.f.am)var10).getY() - (((y.f.am)var9).getY() + ((y.f.am)var9).getHeight());
                                          this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + 0.5D * var49 - this.b(var8), false);
                                       }

                                       this.b(var8, this.a(var8) - var27, false);
                                       this.a(var8, var29 - this.b(var8), false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    case 4:
                                       this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                       this.c(var8, Math.max(var37, var35) + this.b, true);
                                       this.a(var8, var29 - this.b(var8), false);
                                       this.b(var8, this.a(var8) - var27, false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    case 2:
                                       break;
                                    case 3:
                                    case 5:
                                    case 6:
                                    case 7:
                                    default:
                                       break label592;
                                    case 8:
                                       break label593;
                                    }

                                    label493: {
                                       this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                       if(var37 > var35) {
                                          this.c(var8, var37 + this.b, true);
                                          if(var57 == 0) {
                                             break label493;
                                          }
                                       }

                                       this.c(var8, var35 + this.b, true);
                                    }

                                    this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
                                    this.b(var8, this.a(var8) - var27, false);
                                    this.d(var8, this.b(var8) - var29, false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 }

                                 label488: {
                                    this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                    if(var37 > var35) {
                                       this.c(var8, var37 + this.b, true);
                                       if(var57 == 0) {
                                          break label488;
                                       }
                                    }

                                    this.c(var8, var35 + this.b, true);
                                 }

                                 this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
                                 this.b(var8, this.a(var8) - ((y.f.am)var10).getX() + this.b, true);
                                 this.d(var8, this.b(var8) - var29, false);
                                 this.c(var8, var27 - this.a(var8), false);
                                 if(var57 == 0) {
                                    break label584;
                                 }
                              }

                              if(var57 != 0) {
                                 break;
                              }
                           default:
                              break label584;
                           }

                           label595: {
                              boolean var60;
                              label596: {
                                 var60 = var23 < ((y.f.am)var10).getX();
                                 boolean var50 = var23 > ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth();
                                 switch(var12) {
                                 case 1:
                                    label597: {
                                       if(var60) {
                                          this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
                                          this.c(var8, var27 - var23, false);
                                          if(var57 == 0) {
                                             break label597;
                                          }
                                       }

                                       if(var50) {
                                          this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
                                          this.b(var8, var23 - var27, false);
                                          if(var57 == 0) {
                                             break label597;
                                          }
                                       }

                                       this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                       this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() - var23 + this.b, true);
                                       this.d(var8, ((y.f.am)var9).getY() - ((y.f.am)var10).getY(), true);
                                       this.b(var8, this.a(var8) - var27, false);
                                    }

                                    this.a(var8, var29 - this.b(var8), false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 case 4:
                                    if(var50) {
                                       this.d(var8, var25 - var29, false);
                                       this.b(var8, var23 - var27, false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    }

                                    this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                    this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() - var23 + this.b, true);
                                    this.d(var8, this.b(var8) - var29, false);
                                    this.b(var8, this.a(var8) - var27, false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 case 2:
                                    break;
                                 case 3:
                                 case 5:
                                 case 6:
                                 case 7:
                                 default:
                                    break label595;
                                 case 8:
                                    break label596;
                                 }

                                 var51 = ((y.f.am)var9).getX();
                                 if(((y.f.am)var10).getX() > ((y.f.am)var9).getX()) {
                                    var51 = ((y.f.am)var10).getX();
                                 }

                                 double var53 = ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth();
                                 if(((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() < ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth()) {
                                    var53 = ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth();
                                 }

                                 double var55 = var51 + 0.5D * (var53 - var51);
                                 if(var4.b() && var5.b()) {
                                    if(Math.abs(var23 - var27) < 0.001D) {
                                       this.d(var8, var25 - var29, false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    }

                                    this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                    this.c(var8, var27 - var23, false);
                                    this.d(var8, this.b(var8) - var29, false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 }

                                 if(var4.b()) {
                                    if(var23 >= var51 && var23 <= var53) {
                                       this.d(var8, var25 - var29, false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    }

                                    this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                    this.c(var8, var55 - var23, false);
                                    this.d(var8, ((y.f.am)var9).getY() - var29 - this.b, false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 }

                                 if(var5.b()) {
                                    if(var27 >= var51 && var27 <= var53) {
                                       var8.clear();
                                       var8.add(new y.d.t(var27, ((y.f.am)var9).getY()));
                                       this.d(var8, var25 - var29, false);
                                       if(var57 == 0) {
                                          break label584;
                                       }
                                    }

                                    this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                                    this.c(var8, var27 - var23, false);
                                    this.d(var8, ((y.f.am)var9).getY() - var29 - this.b, false);
                                    if(var57 == 0) {
                                       break label584;
                                    }
                                 }

                                 var8.clear();
                                 var8.add(new y.d.t(var55, ((y.f.am)var9).getY()));
                                 this.d(var8, ((y.f.am)var9).getY() - (((y.f.am)var10).getY() + ((y.f.am)var10).getHeight()), false);
                                 if(var57 == 0) {
                                    break label584;
                                 }
                              }

                              if(var60) {
                                 this.d(var8, var25 - var29, false);
                                 this.c(var8, var27 - var23, false);
                                 if(var57 == 0) {
                                    break label584;
                                 }
                              }

                              this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                              this.b(var8, var23 - ((y.f.am)var10).getX() + this.b, true);
                              this.d(var8, this.b(var8) - var29, false);
                              this.c(var8, var27 - this.a(var8), false);
                              if(var57 == 0) {
                                 break label584;
                              }
                           }

                           if(var57 == 0) {
                              break label584;
                           }
                        }

                        label458: {
                           var41 = ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth();
                           var43 = ((y.f.am)var10).getX();
                           if(this.f) {
                              var45 = this.a(((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b, true, true);
                              if(var57 == 0) {
                                 break label458;
                              }
                           }

                           var45 = ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b;
                        }

                        switch(var12) {
                        case 1:
                           this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                           this.c(var8, var27 - var23, false);
                           this.a(var8, var29 - this.b(var8), false);
                           if(var57 == 0) {
                              break label584;
                           }
                        case 4:
                           this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                           this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() - var23 + this.b, true);
                           this.a(var8, var29 - this.b(var8), false);
                           this.b(var8, this.a(var8) - var27, false);
                           if(var57 == 0) {
                              break label584;
                           }
                        case 2:
                           label449: {
                              this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                              if(this.a(var41, var43, var45)) {
                                 this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b - var23, true);
                                 this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
                                 this.c(var8, var27 - this.a(var8), false);
                                 if(var57 == 0) {
                                    break label449;
                                 }
                              }

                              this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() + this.b - var23, true);
                              this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
                              this.b(var8, this.a(var8) - var27, false);
                           }

                           this.d(var8, this.b(var8) - var29, false);
                           if(var57 == 0) {
                              break label584;
                           }
                        case 8:
                           label444: {
                              this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                              if(this.a(var41, var43, var45)) {
                                 this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b - var23, true);
                                 if(var57 == 0) {
                                    break label444;
                                 }
                              }

                              this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                           }

                           this.a(var8, var29 - this.b(var8), false);
                           this.c(var8, var27 - this.a(var8), false);
                           if(var57 == 0) {
                              break label584;
                           }
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        }

                        if(var57 == 0) {
                           break label584;
                        }
                     }

                     label437: {
                        var41 = ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth();
                        var43 = ((y.f.am)var9).getX();
                        if(this.f) {
                           var45 = this.a(((y.f.am)var9).getX() - this.b, false, true);
                           if(var57 == 0) {
                              break label437;
                           }
                        }

                        var45 = ((y.f.am)var9).getX() - this.b;
                     }

                     label432: {
                        switch(var12) {
                        case 1:
                           this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                           this.b(var8, var23 - var27, false);
                           this.a(var8, var29 - this.b(var8), false);
                           if(var57 == 0) {
                              break label584;
                           }
                        case 4:
                           label425: {
                              this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                              if(this.a(var41, var43, var45)) {
                                 this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                                 if(var57 == 0) {
                                    break label425;
                                 }
                              }

                              this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23 + this.b, true);
                           }

                           this.a(var8, var29 - this.b(var8), false);
                           this.b(var8, this.a(var8) - var27, false);
                           if(var57 == 0) {
                              break label584;
                           }
                        case 2:
                           this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                           if(this.a(var41, var43, var45)) {
                              this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                              this.a(var8, this.b + ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() - this.b(var8), true);
                              this.b(var8, this.a(var8) - var27, false);
                              this.d(var8, this.b(var8) - var29, false);
                              if(var57 == 0) {
                                 break label584;
                              }
                           }

                           this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23 + this.b, true);
                           this.a(var8, this.b + ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() - this.b(var8), true);
                           this.b(var8, this.a(var8) - var27, false);
                           this.d(var8, this.b(var8) - var29, false);
                           if(var57 == 0) {
                              break label584;
                           }
                           break;
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        default:
                           break label432;
                        case 8:
                        }

                        this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                        this.b(var8, var23 - ((y.f.am)var10).getX() + this.b, true);
                        this.a(var8, var29 - this.b(var8), false);
                        this.c(var8, var27 - this.a(var8), false);
                        if(var57 == 0) {
                           break label584;
                        }
                     }

                     if(var57 == 0) {
                        break label584;
                     }
                  }

                  label417: {
                     var41 = ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight();
                     var43 = ((y.f.am)var9).getY();
                     if(this.f) {
                        var45 = this.a(((y.f.am)var9).getY() - this.b, false, false);
                        if(var57 == 0) {
                           break label417;
                        }
                     }

                     var45 = ((y.f.am)var9).getY() - this.b;
                  }

                  label598: {
                     switch(var12) {
                     case 1:
                        this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
                        this.b(var8, var23 - var27, false);
                        this.a(var8, var29 - this.b(var8), false);
                        if(var57 == 0) {
                           break label584;
                        }
                     case 4:
                        this.d(var8, var25 - var29, false);
                        this.b(var8, var23 - var27, false);
                        if(var57 == 0) {
                           break label584;
                        }
                     case 2:
                        this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                        if(this.a(var41, var43, var45)) {
                           this.b(var8, var23 - var27, false);
                           this.d(var8, this.b(var8) - var29, false);
                           if(var57 == 0) {
                              break label584;
                           }
                        }

                        this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b - this.a(var8), true);
                        this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
                        this.b(var8, this.a(var8) - var27, false);
                        this.d(var8, this.b(var8) - var29, false);
                        if(var57 == 0) {
                           break label584;
                        }
                        break;
                     case 3:
                     case 5:
                     case 6:
                     case 7:
                     default:
                        break label598;
                     case 8:
                     }

                     label410: {
                        this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                        if(this.a(var41, var43, var45)) {
                           this.b(var8, var23 - ((y.f.am)var10).getX() + this.b, true);
                           this.d(var8, this.b(var8) - var29, false);
                           if(var57 == 0) {
                              break label410;
                           }
                        }

                        this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23 + this.b, true);
                        this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
                        this.b(var8, this.a(var8) - ((y.f.am)var10).getX() + this.b, true);
                        this.d(var8, this.b(var8) - var29, false);
                     }

                     this.c(var8, var27 - this.a(var8), false);
                     if(var57 == 0) {
                        break label584;
                     }
                  }

                  if(var57 == 0) {
                     break label584;
                  }
               }

               label398: {
                  var41 = ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight();
                  var43 = ((y.f.am)var9).getY();
                  if(this.f) {
                     var45 = this.a(((y.f.am)var9).getY() - this.b, false, false);
                     if(var57 == 0) {
                        break label398;
                     }
                  }

                  var45 = ((y.f.am)var9).getY() - this.b;
               }

               label393: {
                  switch(var12) {
                  case 1:
                     this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
                     this.c(var8, var27 - var23, false);
                     this.a(var8, var29 - this.b(var8), false);
                     if(var57 == 0) {
                        break label584;
                     }
                  case 4:
                     label386: {
                        this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                        if(this.a(var41, var43, var45)) {
                           this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() - var23 + this.b, true);
                           this.d(var8, this.b(var8) - var29, false);
                           if(var57 == 0) {
                              break label386;
                           }
                        }

                        this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                        this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
                        this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() + this.b - this.a(var8), true);
                        this.d(var8, this.b(var8) - var29, false);
                     }

                     this.b(var8, this.a(var8) - var27, false);
                     if(var57 == 0) {
                        break label584;
                     }
                  case 2:
                     this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                     if(this.a(var41, var43, var45)) {
                        this.c(var8, var27 - var23, false);
                        this.d(var8, this.b(var8) - var29, false);
                        if(var57 == 0) {
                           break label584;
                        }
                     }

                     this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                     this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
                     this.c(var8, var27 - this.a(var8), false);
                     this.d(var8, this.b(var8) - var29, false);
                     if(var57 == 0) {
                        break label584;
                     }
                     break;
                  case 3:
                  case 5:
                  case 6:
                  case 7:
                  default:
                     break label393;
                  case 8:
                  }

                  this.d(var8, var25 - var29, false);
                  this.c(var8, var27 - var23, false);
                  if(var57 == 0) {
                     break label584;
                  }
               }

               if(var57 == 0) {
                  break label584;
               }
            }

            label378: {
               var31 = var25 - ((y.f.am)var9).getY();
               var33 = var25 - ((y.f.am)var10).getY();
               var39 = var25 - var29;
               var41 = ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth();
               var43 = ((y.f.am)var10).getX();
               if(this.f) {
                  var45 = this.a(((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b, true, true);
                  if(var57 == 0) {
                     break label378;
                  }
               }

               var45 = ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b;
            }

            label599: {
               label600: {
                  switch(var12) {
                  case 1:
                     label363: {
                        if(var31 > var33) {
                           this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                           if(var57 == 0) {
                              break label363;
                           }
                        }

                        this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
                     }

                     this.c(var8, var27 - var23, false);
                     this.a(var8, var29 - this.b(var8), false);
                     if(var57 == 0) {
                        break label584;
                     }
                  case 4:
                     label357: {
                        if(var31 > var33) {
                           this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                           if(var57 == 0) {
                              break label357;
                           }
                        }

                        this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
                     }

                     this.c(var8, ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth() - var23 + this.b, true);
                     this.a(var8, var29 - this.b(var8), false);
                     this.b(var8, this.a(var8) - var27, false);
                     if(var57 == 0) {
                        break label584;
                     }
                  case 2:
                     break;
                  case 3:
                  case 5:
                  case 6:
                  case 7:
                  default:
                     break label599;
                  case 8:
                     break label600;
                  }

                  this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                  if(this.a(var41, var43, var45)) {
                     this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23 + this.b, true);
                     this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
                     this.c(var8, var27 - this.a(var8), false);
                     this.d(var8, this.b(var8) - var29, false);
                     if(var57 == 0) {
                        break label584;
                     }
                  }

                  label350: {
                     this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                     if(((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b > ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight()) {
                        this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
                        if(var57 == 0) {
                           break label350;
                        }
                     }

                     this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
                  }

                  this.c(var8, var27 - this.a(var8), false);
                  this.d(var8, this.b(var8) - var29, false);
                  if(var57 == 0) {
                     break label584;
                  }
               }

               if(var39 >= var31 + this.b) {
                  this.d(var8, var39, false);
                  this.c(var8, var27 - var23, false);
                  if(var57 == 0) {
                     break label584;
                  }
               }

               label344: {
                  this.d(var8, var31 + this.b, true);
                  if(this.a(var41, var43, var45)) {
                     this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() + this.b - this.a(var8), true);
                     if(var57 == 0) {
                        break label344;
                     }
                  }

                  var51 = ((y.f.am)var10).getX() - (((y.f.am)var9).getX() + ((y.f.am)var9).getWidth());
                  this.c(var8, ((y.f.am)var10).getX() - 0.5D * var51 - this.a(var8), false);
               }

               this.a(var8, var29 - this.b(var8), false);
               this.c(var8, var27 - this.a(var8), false);
               if(var57 == 0) {
                  break label584;
               }
            }

            if(var57 == 0) {
               break label584;
            }
         }

         label252: {
            var31 = var25 - ((y.f.am)var9).getY();
            var33 = var25 - ((y.f.am)var10).getY();
            var39 = var25 - var29;
            var41 = ((y.f.am)var10).getX() + ((y.f.am)var10).getWidth();
            var43 = ((y.f.am)var9).getX();
            if(this.f) {
               var45 = this.a(((y.f.am)var9).getX() - this.b, false, true);
               if(var57 == 0) {
                  break label252;
               }
            }

            var45 = ((y.f.am)var9).getX() - this.b;
         }

         label601: {
            switch(var12) {
            case 1:
               label238: {
                  if(var31 > var33) {
                     this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
                     if(var57 == 0) {
                        break label238;
                     }
                  }

                  this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
               }

               this.b(var8, var23 - var27, false);
               this.a(var8, var29 - this.b(var8), false);
               if(var57 == 0) {
                  break label584;
               }
            case 4:
               if(var39 >= var31 + this.b) {
                  this.d(var8, var39, false);
                  this.b(var8, var23 - var27, false);
                  if(var57 == 0) {
                     break label584;
                  }
               }

               label231: {
                  this.d(var8, var31 + this.b, true);
                  if(this.a(var41, var43, var45)) {
                     this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
                     if(var57 == 0) {
                        break label231;
                     }
                  }

                  var51 = ((y.f.am)var9).getX() - (((y.f.am)var10).getX() + ((y.f.am)var10).getWidth());
                  this.b(var8, var23 - (((y.f.am)var10).getX() + ((y.f.am)var10).getWidth()) - 0.5D * var51, false);
               }

               this.a(var8, var29 - this.b(var8), false);
               this.b(var8, this.a(var8) - var27, false);
               if(var57 == 0) {
                  break label584;
               }
            case 2:
               break;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break label584;
            case 8:
               break label601;
            }

            this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
            if(this.a(var41, var43, var45)) {
               this.b(var8, var23 - ((y.f.am)var9).getX() + this.b, true);
               this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
               this.b(var8, this.a(var8) - var27, false);
               this.d(var8, this.b(var8) - var29, false);
               if(var57 == 0) {
                  break label584;
               }
            }

            this.c(var8, ((y.f.am)var9).getX() + ((y.f.am)var9).getWidth() - var23 + this.b, true);
            if(((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b > ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight()) {
               this.a(var8, ((y.f.am)var9).getY() + ((y.f.am)var9).getHeight() + this.b - this.b(var8), true);
               this.b(var8, this.a(var8) - var27, false);
               this.d(var8, this.b(var8) - var29, false);
               if(var57 == 0) {
                  break label584;
               }
            }

            this.a(var8, ((y.f.am)var10).getY() + ((y.f.am)var10).getHeight() + this.b - this.b(var8), true);
            this.b(var8, this.a(var8) - var27, false);
            this.d(var8, this.b(var8) - var29, false);
            if(var57 == 0) {
               break label584;
            }
         }

         label213: {
            if(var31 > var33) {
               this.d(var8, var25 - ((y.f.am)var9).getY() + this.b, true);
               if(var57 == 0) {
                  break label213;
               }
            }

            this.d(var8, var25 - ((y.f.am)var10).getY() + this.b, true);
         }

         this.b(var8, var23 - ((y.f.am)var10).getX() + this.b, true);
         this.a(var8, var29 - this.b(var8), false);
         this.c(var8, var27 - this.a(var8), false);
         if(var57 != 0) {
            ;
         }
      }

      y.c.p var59 = var8.k();

      while(var59 != null) {
         y.d.t var48 = (y.d.t)var59.c();
         var59.a(new y.d.t(var48.a * var13[0] + var48.b * var13[1], var48.a * var13[2] + var48.b * var13[3]));
         var59 = var59.a();
         if(var57 != 0) {
            break;
         }
      }

      return var8;
   }

   protected double a(y.c.d var1, y.c.D var2, y.f.ax var3, y.f.ax var4) {
      double var5 = this.e(var1, var2, var3, var4);
      double var7 = this.c(var1, var2, var3, var4);
      double var9 = this.f(var1, var2, var3, var4);
      double var11 = this.d(var1, var2, var3, var4);
      double var13 = this.b(var1, var2, var3, var4);
      if(var1.e()) {
         return var7 + var9 + var11 + var13;
      } else {
         double var15 = 0.0D;
         if(this.w != 0) {
            byte var17 = this.a(var2, var3, var4);
            if(this.e() && var17 != 1 && var17 != 3) {
               var15 = 100000.0D;
               if(v.f == 0) {
                  return var5 + var7 + var9 + var13 + var15;
               }
            }

            if(this.f() && var17 != 2 && var17 != 3) {
               var15 = 100000.0D;
            }
         }

         return var5 + var7 + var9 + var13 + var15;
      }
   }

   private byte a(y.c.D var1, y.f.ax var2, y.f.ax var3) {
      int var11 = v.f;
      int[] var4 = new int[4];
      y.d.t var5 = null;
      H var6 = null;
      H var7 = null;
      y.c.C var8 = var1.m();

      while(var8.f()) {
         y.d.t var9 = (y.d.t)var8.d();
         if(var5 != null) {
            H var10 = new H(var5, var9);
            ++var4[var10.d()];
            if(var6 == null) {
               var6 = var10;
            }

            var7 = var10;
         }

         var5 = var9;
         var8.g();
         if(var11 != 0) {
            break;
         }
      }

      byte var12 = 0;
      if((var4[0] == 0 || var4[1] == 0) && (var2.a() != 255 || H.a(var6)) && (var3.a() != 255 || H.a(var7))) {
         var12 = 1;
         if(var11 == 0) {
            return var12;
         }
      }

      if((var4[2] == 0 || var4[3] == 0) && (var2.a() != 255 || !H.a(var6)) && (var3.a() != 255 || !H.a(var7))) {
         var12 = 2;
         if(var11 == 0) {
            return var12;
         }
      }

      if((var4[2] == 0 || var4[3] == 0) && (var4[0] == 0 || var4[1] == 0)) {
         var12 = 3;
      }

      return var12;
   }

   protected double b(y.c.d var1, y.c.D var2, y.f.ax var3, y.f.ax var4) {
      return var3.f() + var4.f();
   }

   protected double c(y.c.d var1, y.c.D var2, y.f.ax var3, y.f.ax var4) {
      return this.c * (double)(var2.size() - 2);
   }

   protected double d(y.c.d var1, y.c.D var2, y.f.ax var3, y.f.ax var4) {
      return var3.a() == var4.a() && var1.c() == var1.d()?this.c + 1.0D:0.0D;
   }

   protected double e(y.c.d var1, y.c.D var2, y.f.ax var3, y.f.ax var4) {
      int var10 = v.f;
      double var5 = 0.0D;
      y.d.t var7 = null;
      Iterator var8 = var2.iterator();

      double var10000;
      while(true) {
         if(var8.hasNext()) {
            y.d.t var9 = (y.d.t)var8.next();
            if(var10 != 0) {
               break;
            }

            if(var7 != null) {
               var5 += var7.a(var9);
            }

            var7 = var9;
            if(var10 == 0) {
               continue;
            }
         }

         if(var5 > 0.0D) {
            var10000 = 1.0D - 1.0D / var5;
            return var10000;
         }
         break;
      }

      var10000 = 0.0D;
      return var10000;
   }

   protected double f(y.c.d var1, y.c.D var2, y.f.ax var3, y.f.ax var4) {
      int var10 = v.f;
      double var5 = 0.0D;
      if(this.b() == 0.0D && this.d() == 0.0D && this.c() == 0.0D) {
         return var5;
      } else {
         y.d.t var7 = null;
         Iterator var8 = var2.iterator();

         while(var8.hasNext()) {
            y.d.t var9 = (y.d.t)var8.next();
            if(var7 != null) {
               label44: {
                  ++this.p;
                  if(Math.abs(var9.a() - var7.a()) <= 0.001D) {
                     var5 = this.a(var1, var5, this.n, var9.a(), Math.min(var9.b(), var7.b()), Math.max(var9.b(), var7.b()));
                     if(var10 == 0) {
                        break label44;
                     }
                  }

                  if(Math.abs(var9.b() - var7.b()) > 0.001D) {
                     throw new IllegalStateException("Edge is not routed orthogonally!");
                  }

                  var5 = this.a(var1, var5, this.o, var9.b(), Math.min(var9.a(), var7.a()), Math.max(var9.a(), var7.a()));
                  if(var10 != 0) {
                     throw new IllegalStateException("Edge is not routed orthogonally!");
                  }
               }
            }

            var7 = var9;
            if(var10 != 0) {
               break;
            }
         }

         return var5;
      }
   }

   private double a(y.c.d var1, double var2, List var4, double var5, double var7, double var9) {
      int var14 = v.f;
      int var11 = this.a(var5, var4) - 1;
      if(var11 >= 0) {
         F var12 = (F)var4.get(var11);
         int var13 = var12.e;

         while(var13 != 0 && var12 != null) {
            label46: {
               if(!var12.a) {
                  var12.f.a = this.p;
                  if(var14 == 0) {
                     break label46;
                  }
               }

               if(!var12.a) {
                  throw new InternalError("Event Type undefined!");
               }

               if(var12.f.a != this.p) {
                  var2 += var12.f.a(var1, var5, var7, var9, this);
                  --var13;
                  if(var14 != 0) {
                     throw new InternalError("Event Type undefined!");
                  }
               }
            }

            F var10000;
            if(var11 > 0) {
               --var11;
               var10000 = (F)var4.get(var11);
            } else {
               var10000 = null;
            }

            var12 = var10000;
            if(var14 != 0) {
               break;
            }
         }
      }

      return var2;
   }

   private int a(double var1, List var3) {
      int var8 = v.f;
      if(var3.isEmpty()) {
         return 0;
      } else if(((F)var3.get(0)).b > var1) {
         return 0;
      } else {
         int var4 = 0;
         int var5 = var3.size();

         label60:
         while(true) {
            int var6 = (var4 + var5) / 2;
            F var7 = (F)var3.get(var6);
            int var10000;
            if(var7.b < var1) {
               var4 = var6;
               if(var8 != 0) {
                  double var9;
                  var10000 = (var9 = var7.b - var1) == 0.0D?0:(var9 < 0.0D?-1:1);
               } else {
                  if(var5 - var6 > 1) {
                     continue;
                  }

                  var10000 = var5;
                  if(var8 == 0) {
                     return var5;
                  }
               }
            } else {
               double var10;
               var10000 = (var10 = var7.b - var1) == 0.0D?0:(var10 < 0.0D?-1:1);
            }

            do {
               if(var10000 > 0) {
                  var5 = var6;
                  if(var8 != 0) {
                     if(var7.a) {
                        var4 = var6;
                        if(var8 != 0) {
                           var5 = var6;
                        }
                     } else {
                        var5 = var6;
                     }
                  }
               } else if(var7.a) {
                  var4 = var6;
                  if(var8 != 0) {
                     var5 = var6;
                  }
               } else {
                  var5 = var6;
               }

               if(var5 - var4 > 1) {
                  continue label60;
               }

               var10000 = var5;
            } while(var8 != 0);

            return var5;
         }
      }
   }

   private int a(F var1, List var2) {
      int var7 = v.f;
      if(var2.isEmpty()) {
         return 0;
      } else if(((F)var2.get(0)).compareTo(var1) > 0) {
         return 0;
      } else if(((F)var2.get(var2.size() - 1)).compareTo(var1) < 0) {
         return var2.size();
      } else {
         int var3 = 0;
         int var4 = var2.size();

         while(true) {
            int var5 = (var3 + var4) / 2;
            F var6 = (F)var2.get(var5);
            if(var6.compareTo(var1) <= 0) {
               var3 = var5;
               if(var7 == 0) {
                  ;
               }
            }

            for(var4 = var5; var4 - var3 <= 1; var4 = var4) {
               if(var7 == 0) {
                  return var4;
               }
            }
         }
      }
   }

   private boolean a(double var1, double var3, double var5) {
      return var5 - var1 >= this.b && var3 - var5 >= this.b;
   }

   private double a(y.c.D var1) {
      return ((y.d.t)var1.i()).a();
   }

   private double b(y.c.D var1) {
      return ((y.d.t)var1.i()).b();
   }

   private y.f.ax a(y.f.ax var1, y.f.am var2, int var3) {
      double var4;
      double var6;
      int var8;
      label52: {
         var8 = v.f;
         switch(var3) {
         case 1:
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            label41: {
               if(this.f) {
                  var4 = this.a(var2.getX() + 0.5D * var2.getWidth(), true);
                  if(var8 == 0) {
                     break label41;
                  }
               }

               var4 = 0.0D;
            }

            var6 = -var2.getHeight() * 0.5D;
            if(var8 == 0) {
               return y.f.ax.a(var4, var6, var1.a(), var1.f());
            }
         case 4:
            var4 = var2.getWidth() * 0.5D;
            if(this.f) {
               var6 = this.a(var2.getY() + 0.5D * var2.getHeight(), false);
               if(var8 == 0) {
                  return y.f.ax.a(var4, var6, var1.a(), var1.f());
               }
            }

            var6 = 0.0D;
            if(var8 == 0) {
               return y.f.ax.a(var4, var6, var1.a(), var1.f());
            }
         case 2:
            break;
         case 8:
            break label52;
         }

         label34: {
            if(this.f) {
               var4 = this.a(var2.getX() + 0.5D * var2.getWidth(), true);
               if(var8 == 0) {
                  break label34;
               }
            }

            var4 = 0.0D;
         }

         var6 = var2.getHeight() * 0.5D;
         if(var8 == 0) {
            return y.f.ax.a(var4, var6, var1.a(), var1.f());
         }
      }

      var4 = -var2.getWidth() * 0.5D;
      if(this.f) {
         var6 = this.a(var2.getY() + 0.5D * var2.getHeight(), false);
         if(var8 == 0) {
            return y.f.ax.a(var4, var6, var1.a(), var1.f());
         }
      }

      var6 = 0.0D;
      return y.f.ax.a(var4, var6, var1.a(), var1.f());
   }

   private double a(double var1, boolean var3) {
      if(this.f && this.h > 0.0D) {
         double var4 = var3?this.g.a():this.g.b();
         double var6 = Math.floor((var1 - var4) / this.h) * this.h - var1;
         double var8 = Math.ceil((var1 - var4) / this.h) * this.h - var1;
         return Math.abs(var6) < Math.abs(var8)?var6:var8;
      } else {
         return 0.0D;
      }
   }

   private byte a(y.f.am var1, y.f.am var2) {
      int var24 = v.f;
      byte var3 = 0;
      double var4 = var1.getX();
      double var6 = var1.getY();
      double var8 = var1.getWidth();
      double var10 = var1.getHeight();
      double var12 = var2.getX();
      double var14 = var2.getY();
      double var16 = var2.getWidth();
      double var18 = var2.getHeight();
      boolean var20 = var4 < var12 && var4 + var8 < var12;
      boolean var21 = var4 > var12 && var4 > var12 + var16;
      boolean var22 = var6 < var14 && var6 + var10 < var14;
      boolean var23 = var6 > var14 && var6 > var14 + var18;
      if(!var20 && !var21) {
         if(var6 + var10 < var14) {
            var3 = 0;
            if(var24 == 0) {
               return var3;
            }
         }

         if(var6 > var14 + var18) {
            var3 = 1;
            if(var24 == 0) {
               return var3;
            }
         }

         if(var6 < var14) {
            var3 = 0;
            if(var24 == 0) {
               return var3;
            }
         }

         var3 = 1;
         if(var24 == 0) {
            return var3;
         }
      }

      if(!var22 && !var23) {
         if(var4 + var8 < var12) {
            var3 = 2;
            if(var24 == 0) {
               return var3;
            }
         }

         if(var4 > var12 + var16) {
            var3 = 3;
            if(var24 == 0) {
               return var3;
            }
         }

         if(var4 < var12) {
            var3 = 2;
            if(var24 == 0) {
               return var3;
            }
         }

         var3 = 3;
         if(var24 == 0) {
            return var3;
         }
      }

      if(var4 < var12) {
         if(var6 < var14) {
            var3 = 4;
            if(var24 == 0) {
               return var3;
            }
         }

         if(var6 <= var14) {
            return var3;
         }

         var3 = 6;
         if(var24 == 0) {
            return var3;
         }
      }

      if(var4 > var12) {
         if(var6 < var14) {
            var3 = 5;
            if(var24 == 0) {
               return var3;
            }
         }

         if(var6 > var14) {
            var3 = 7;
         }
      }

      return var3;
   }

   private static boolean[] a(int var0) {
      int var2 = v.f;
      boolean[] var1 = new boolean[4];
      if((var0 & 1) != 0) {
         var1[0] = true;
         if(var2 == 0) {
            return var1;
         }
      }

      if((var0 & 4) != 0) {
         var1[1] = true;
         if(var2 == 0) {
            return var1;
         }
      }

      if((var0 & 2) != 0) {
         var1[2] = true;
         if(var2 == 0) {
            return var1;
         }
      }

      if((var0 & 8) != 0) {
         var1[3] = true;
      }

      return var1;
   }

   private static int a(boolean[] var0) {
      int var2 = v.f;
      int var1 = 0;
      if(var0[0]) {
         var1 |= 1;
         if(var2 == 0) {
            return var1;
         }
      }

      if(var0[1]) {
         var1 |= 4;
         if(var2 == 0) {
            return var1;
         }
      }

      if(var0[2]) {
         var1 |= 2;
         if(var2 == 0) {
            return var1;
         }
      }

      if(var0[3]) {
         var1 |= 8;
      }

      return var1;
   }

   private int a(int var1, byte var2) {
      int var7 = v.f;
      boolean[] var3 = a(var1);
      int var4 = 0;

      int var10000;
      while(true) {
         if(var4 < var3.length) {
            label42: {
               byte var5 = var3[var4];
               var10000 = var5;
               if(var7 != 0) {
                  break;
               }

               if(var5 != 0) {
                  boolean var6 = false;
                  int var8;
                  switch(var2) {
                  case 0:
                     var8 = (var4 + 1) % var3.length;
                     if(var7 == 0) {
                        break;
                     }
                  case 1:
                     var8 = (var4 + 2) % var3.length;
                     if(var7 == 0) {
                        break;
                     }
                  case 2:
                     var8 = (var4 + 3) % var3.length;
                     if(var7 != 0) {
                        throw new IllegalArgumentException("Undefined angle given: " + var2);
                     }
                     break;
                  default:
                     throw new IllegalArgumentException("Undefined angle given: " + var2);
                  }

                  var3[var8] = true;
                  var3[var4] = false;
                  if(var7 == 0) {
                     break label42;
                  }
               }

               ++var4;
               if(var7 == 0) {
                  continue;
               }
            }
         }

         var10000 = a(var3);
         break;
      }

      return var10000;
   }

   private double a(double var1, boolean var3, boolean var4) {
      return this.f?(var3?(var4?Math.ceil((var1 - this.i.a()) / this.h) * this.h + this.i.a():Math.ceil((var1 - this.i.b()) / this.h) * this.h + this.i.b()):(var4?Math.floor((var1 - this.i.a()) / this.h) * this.h + this.i.a():Math.floor((var1 - this.i.b()) / this.h) * this.h + this.i.b())):var1;
   }

   private void a(y.c.D var1, double var2, boolean var4) {
      double var5;
      double var9;
      label13: {
         var5 = this.a(var1);
         double var7 = this.b(var1);
         if(var4 && this.f) {
            var9 = this.a(var7 + var2, true, false);
            if(v.f == 0) {
               break label13;
            }
         }

         var9 = var7 + var2;
      }

      var1.add(new y.d.t(var5, var9));
   }

   private void b(y.c.D var1, double var2, boolean var4) {
      double var7;
      double var9;
      label13: {
         double var5 = this.a(var1);
         var7 = this.b(var1);
         if(var4 && this.f) {
            var9 = this.a(var5 - var2, false, true);
            if(v.f == 0) {
               break label13;
            }
         }

         var9 = var5 - var2;
      }

      var1.add(new y.d.t(var9, var7));
   }

   private void c(y.c.D var1, double var2, boolean var4) {
      double var7;
      double var9;
      label13: {
         double var5 = this.a(var1);
         var7 = this.b(var1);
         if(var4 && this.f) {
            var9 = this.a(var5 + var2, true, true);
            if(v.f == 0) {
               break label13;
            }
         }

         var9 = var5 + var2;
      }

      var1.add(new y.d.t(var9, var7));
   }

   private void d(y.c.D var1, double var2, boolean var4) {
      double var5;
      double var9;
      label13: {
         var5 = this.a(var1);
         double var7 = this.b(var1);
         if(var4 && this.f) {
            var9 = this.a(var7 - var2, false, false);
            if(v.f == 0) {
               break label13;
            }
         }

         var9 = var7 - var2;
      }

      var1.add(new y.d.t(var5, var9));
   }

   private void a(List var1, double var2, double var4, double var6, double var8) {
      G var10 = new G(var2, var4, var6, var8);
      F var11 = new F(true, var2, Math.min(var4, var8), Math.max(var4, var8), var10);
      F var12 = new F(false, var6, Math.min(var4, var8), Math.max(var4, var8), var10);
      var1.add(var11);
      var1.add(var12);
   }

   private void a(List var1) {
      int var13 = v.f;
      y.g.e.a((List)var1, (Comparator)null);
      HashSet var2 = new HashSet();
      int var3 = 0;
      int var4 = 0;
      double var5 = -1.7976931348623157E308D;
      int var7 = 0;

      while(var7 < var1.size()) {
         F var8;
         label52: {
            var8 = (F)var1.get(var7);
            if(var8.b > var5 && var4 > this.q) {
               ArrayList var9 = new ArrayList();
               Iterator var10 = var2.iterator();

               J var11;
               F var12;
               while(var10.hasNext()) {
                  var11 = (J)var10.next();
                  if(var7 - var11.a > this.r) {
                     var9.add(var11);
                     var12 = var11.a(false, var8.b);
                     --var3;
                     var12.e = var3;
                     var1.add(var7, var12);
                     var4 -= var7 - var8.f.a;
                     ++var7;
                     if(var13 != 0) {
                        break label52;
                     }

                     if(var13 != 0) {
                        break;
                     }
                  }
               }

               int var14 = var9.size() - 1;

               while(var14 >= 0) {
                  var11 = (J)var9.get(var14);
                  var12 = var11.a(true, var8.b);
                  ++var3;
                  var12.e = var3;
                  var1.add(var7, var12);
                  var11.a = var7++;
                  var4 += var3;
                  --var14;
                  if(var13 != 0) {
                     break label52;
                  }

                  if(var13 != 0) {
                     break;
                  }
               }
            }

            var5 = var8.b;
         }

         label29: {
            if(var8.a) {
               var2.add(var8.f);
               var8.f.a = var7;
               ++var3;
               if(var13 == 0) {
                  break label29;
               }
            }

            var2.remove(var8.f);
            var4 -= var7 - var8.f.a;
            var8.f.a = 0;
            --var3;
         }

         var4 += var3;
         var8.e = var3;
         ++var7;
         if(var13 != 0) {
            break;
         }
      }

   }

   private void c(y.c.D var1) {
      int var5 = v.f;
      y.d.t var2 = null;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         y.d.t var4 = (y.d.t)var3.next();
         if(var2 != null) {
            this.a(new y.d.t(var4.b, var4.a), new y.d.t(var2.b, var2.a), this.o);
            this.a(var4, var2, this.n);
         }

         var2 = var4;
         if(var5 != 0) {
            break;
         }
      }

   }

   private void a(y.d.t var1, y.d.t var2, List var3) {
      y.d.t var8;
      y.d.t var9;
      int var13;
      label41: {
         var13 = v.f;
         if(var1.a() <= var2.a()) {
            var8 = var1;
            var9 = var2;
            if(var13 == 0) {
               break label41;
            }
         }

         var8 = var2;
         var9 = var1;
      }

      G var10 = new G(var8.a(), var8.b(), var9.a(), var9.b());
      F var4 = new F(true, var8.a(), var8.b(), var9.b(), var10);
      F var5 = new F(false, var9.a(), var9.b(), var8.b(), var10);
      int var6 = this.a(var5, var3);
      int var7 = this.a(var4, var3);
      var5.e = var3.size() > var6 - 1 && var6 > 0?((F)var3.get(var6 - 1)).e:0;
      int var11 = var7;

      int var10000;
      label30: {
         while(true) {
            if(var11 < var6) {
               F var12 = (F)var3.get(var11);
               ++var12.e;
               ++var11;
               if(var13 != 0) {
                  break;
               }

               if(var13 == 0) {
                  continue;
               }
            }

            if(var3.size() > var7 - 1 && var7 > 0) {
               var10000 = ((F)var3.get(var7 - 1)).e;
               break label30;
            }
            break;
         }

         var10000 = 0;
      }

      var11 = var10000;
      var4.e = var11 + 1;
      var3.add(var6, var5);
      var3.add(var7, var4);
   }

   public void a(Object var1) {
      this.t = var1;
   }

   public double b() {
      return this.d;
   }

   public double c() {
      return this.e;
   }

   public double d() {
      return this.v;
   }
}
