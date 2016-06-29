package y.f.c;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import y.f.c.F;
import y.f.c.G;
import y.f.c.H;
import y.f.c.I;
import y.f.c.J;
import y.f.c.K;
import y.f.c.Q;
import y.f.c.R;
import y.f.c.Y;
import y.f.c.a;
import y.f.c.aD;
import y.f.c.aJ;
import y.f.c.at;
import y.f.c.v;

public class E extends K {
   private y.f.b.c u;
   private J v;
   private y.g.I w;
   private y.f.X x;
   private y.c.h y;
   private y.c.A z;
   private y.c.A A;
   y.c.A n;
   private y.c.h B;
   private y.c.h C;
   private y.c.h D;
   private y.c.h E;
   private y.c.c F;
   private y.c.c G;
   private y.c.c H;
   private y.c.c I;
   private y.c.A J;
   private y.c.A K;
   private y.c.h L;
   private y.c.c M;
   private y.c.c N;
   private y.c.h O;
   private static final y.f.aE P = y.f.aE.a((byte)1, true);
   private static final y.f.aE Q = y.f.aE.a((byte)2, true);
   private y.f.b.a R;
   private y.f.ah S = new H(this);
   private boolean T = true;
   private boolean U;

   public E() {
      this.d(false);
      this.U = true;
      this.v = new J(this);
      this.R = new y.f.b.h();
      this.v.c = super.a();
      this.v.d = super.n();
      this.v.e = super.o();
      super.a((R)this.v);
      super.a((Q)this.v);
      super.a((v)this.v);
   }

   public boolean b(y.f.X var1) {
      return true;
   }

   public void a(y.f.X var1) {
      boolean var25 = a.i;
      if(!this.u() && y.f.b.c.c((y.c.i)var1)) {
         try {
            super.a(this.v.d);
            super.a(this.v.c);
            super.a(this.v.e);
            super.a(var1);
         } finally {
            super.a((R)this.v);
            super.a((v)this.v);
            super.a((Q)this.v);
         }
      } else {
         this.u = new y.f.b.c(var1);
         this.y = var1.u();
         this.z = var1.t();
         this.A = var1.t();
         this.n = var1.t();
         this.J = var1.t();
         this.x = var1;
         this.w = new y.g.I(var1);
         y.c.x var2 = this.x.o();

         while(true) {
            if(var2.f()) {
               this.J.a(var2.e(), K.p);
               var2.g();
               if(var25) {
                  break;
               }

               if(!var25) {
                  continue;
               }
            }

            var1.a((Object)K.o, (y.c.c)this.J);
            break;
         }

         y.c.c var3 = var1.c(y.f.U.a);
         y.g.ap var32;
         if(var3 != null) {
            this.O = var1.u();
            var32 = new y.g.ap(this.O, var1, y.f.U.a);
         } else {
            var32 = null;
         }

         this.B = var1.u();
         y.g.ap var4 = new y.g.ap(this.B, var1, y.f.aF.a);
         this.F = var4.c();
         this.C = var1.u();
         y.g.ap var5 = new y.g.ap(this.C, var1, y.f.aF.b);
         this.G = var5.c();
         y.g.ap var6;
         y.g.ap var7;
         if((this.H = var1.c(y.f.aF.c)) != null) {
            this.D = var1.u();
            var6 = new y.g.ap(this.D, var1, y.f.aF.c);
            if((this.I = var1.c(y.f.aF.d)) == null) {
               throw new IllegalStateException("No DataProvider " + y.f.aF.d + " bound to graph!");
            }

            this.E = var1.u();
            var7 = new y.g.ap(this.E, var1, y.f.aF.d);
            if(var25) {
               throw new IllegalStateException("No DataProvider " + y.f.aF.d + " bound to graph!");
            }
         } else {
            if(var1.c(y.f.aF.d) != null) {
               throw new IllegalStateException("No DataProvider " + y.f.aF.c + " bound to graph!");
            }

            var7 = null;
            var6 = null;
         }

         boolean var8;
         label776: {
            this.M = var1.c(y.f.ah.f_);
            this.N = var1.c(y.f.ah.k);
            if(this.M == null && this.N == null && this.p()) {
               this.M = var1.t();
               y.c.x var9 = var1.o();

               label770: {
                  while(var9.f()) {
                     ((y.c.A)this.M).a(var9.e(), var9.e());
                     var9.g();
                     if(var25) {
                        break label770;
                     }

                     if(var25) {
                        break;
                     }
                  }

                  this.N = var1.u();
               }

               y.c.e var33 = var1.p();

               label759: {
                  while(var33.f()) {
                     ((y.c.h)this.N).a(var33.a(), var33.a());
                     var33.g();
                     if(var25) {
                        break label759;
                     }

                     if(var25) {
                        break;
                     }
                  }

                  var1.a((Object)y.f.ah.f_, (y.c.c)this.M);
                  var1.a((Object)y.f.ah.k, (y.c.c)this.N);
               }

               var8 = true;
               if(!var25) {
                  break label776;
               }
            }

            var8 = false;
         }

         y.g.ap var34;
         label747: {
            if(this.M != null && (var8 || this.u() || this.p())) {
               var34 = new y.g.ap(this.K = var1.t(), var1, y.f.ah.f_);
               if(!var25) {
                  break label747;
               }
            }

            var34 = null;
         }

         y.g.ap var10;
         label737: {
            if(this.N != null && (var8 || this.u() || this.p())) {
               if(var34 == null) {
                  throw new IllegalStateException("No DataProvider " + y.f.ah.f_ + " bound to graph!");
               }

               var10 = new y.g.ap(this.L = var1.u(), var1, y.f.ah.k);
               if(!var25) {
                  break label737;
               }
            }

            var10 = null;
            if(var34 != null) {
               throw new IllegalStateException("No DataProvider " + y.f.ah.k + " bound to graph!");
            }
         }

         y.c.x var11 = var1.o();

         while(var11.f()) {
            y.c.q var12 = var11.e();
            G var13 = new G();
            this.z.a(var12, var13);
            if(var25) {
               return;
            }

            y.c.d var14 = var12.f();

            while(true) {
               if(var14 != null) {
                  I var15 = new I();
                  this.a(var14, var15);
                  this.y.a(var14, var15);
                  var14 = var14.g();
                  if(var25) {
                     break;
                  }

                  if(!var25) {
                     continue;
                  }
               }

               var11.g();
               break;
            }

            if(var25) {
               break;
            }
         }

         try {
            Y var39 = null;
            boolean var16;
            boolean var35;
            boolean var36;
            boolean var37;
            Object var38;
            if(this.U) {
               var16 = !this.u();
               var39 = this.t();
               var38 = var39.b();
               var36 = var39.a((byte)1);
               var37 = var39.a((byte)2);
               var35 = !var37;
            } else {
               var16 = false;
               var35 = false;
               var38 = null;
               var37 = false;
               var36 = false;
            }

            if(var35) {
               Object var17 = var39.a();
               var39.b(var17);
               var39.a((byte)1, false);
               var39.a((byte)2, false);
               Map var18 = this.x();
               aD var19 = new aD();
               var19.a = var18;
               ((Map)var17).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", var19);
               if(var38 != null) {
                  Map var20;
                  if(!var37) {
                     label817: {
                        var20 = (Map)var38;
                        aD var21 = (aD)var20.get("y.layout.hierarchic.MementoSequencer.SequencerMemento");
                        if(var21 != null) {
                           var21.a.putAll(var19.a);
                           if(!var25) {
                              break label817;
                           }
                        }

                        ((Map)var38).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", var19);
                     }
                  }

                  if(!var36) {
                     label694: {
                        var20 = (Map)var38;
                        aJ var40 = (aJ)var20.get("y.layout.hierarchic.MementoLayerer.LayerMemento");
                        aJ var22 = (aJ)((Map)var17).get("y.layout.hierarchic.MementoLayerer.LayerMemento");
                        if(var40 != null) {
                           var40.a = Math.max(var40.a, var22.a);
                           var40.b.putAll(var22.b);
                           if(!var25) {
                              break label694;
                           }
                        }

                        ((Map)var38).put("y.layout.hierarchic.MementoLayerer.LayerMemento", var22);
                     }
                  }
               }

               var39.a((byte)1, true);
               var39.a((byte)2, true);
            }

            this.a(this.u.b(), this.u.b(this.u.b()), false);
            if(var35) {
               var39.a((byte)1, var36);
               var39.a((byte)2, var37);
               var39.b(var38);
            }

            if(var16) {
               this.v();
            }

            this.a(this.u.b(), 0.0D, 0.0D);
            this.w();
         } finally {
            if(var34 != null) {
               var34.b();
               var1.a((y.c.A)this.K);
               this.K = null;
            }

            if(var10 != null) {
               var10.b();
               var1.a((y.c.h)this.L);
               this.L = null;
            }

            var1.a((y.c.h)this.y);
            var1.a((y.c.A)this.z);
            var1.a((y.c.A)this.A);
            var1.a((y.c.A)this.n);
            if(var8) {
               var1.d_(y.f.ah.f_);
               var1.d_(y.f.ah.k);
               var1.a((y.c.A)this.K);
               var1.a((y.c.h)this.L);
            }

            var1.d_(K.o);
            var1.a((y.c.A)this.J);
            this.J = null;
            if(var32 != null) {
               var32.b();
               var1.a((y.c.h)this.O);
               this.O = null;
            }

            var4.b();
            this.x.a((y.c.h)this.B);
            this.B = null;
            var5.b();
            this.x.a((y.c.h)this.C);
            this.C = null;
            if(var6 != null) {
               var6.b();
               this.x.a((y.c.h)this.D);
               this.D = null;
            }

            if(var7 != null) {
               var7.b();
               this.x.a((y.c.h)this.E);
               this.E = null;
            }

            this.H = null;
            this.I = null;
            this.F = null;
            this.G = null;
            this.A = null;
            this.n = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            if(this.u != null) {
               this.u.c();
            }

            this.u = null;
         }
      }

   }

   private void a(y.c.d var1, I var2) {
      boolean var11 = a.i;
      if(!this.u.a(var1)) {
         y.c.c var3 = this.x.c(y.f.U.a);
         if(var3 != null) {
            y.f.S[] var4 = (y.f.S[])var3.b(var1);
            if(var4 == null) {
               return;
            }

            ArrayList var5 = new ArrayList(4);
            ArrayList var6 = new ArrayList(4);
            ArrayList var7 = new ArrayList(4);
            int var8 = 0;

            int var10000;
            label51: {
               while(var8 < var4.length) {
                  y.f.S var9 = var4[var8];
                  y.f.aG var10 = var9.f();
                  var10000 = var10.i();
                  if(var11) {
                     break label51;
                  }

                  label60: {
                     if(var10000 != 0) {
                        var5.add(var9);
                        if(!var11) {
                           break label60;
                        }
                     }

                     if(var10.k()) {
                        var6.add(var9);
                        if(!var11) {
                           break label60;
                        }
                     }

                     var7.add(var9);
                  }

                  ++var8;
                  if(var11) {
                     break;
                  }
               }

               var10000 = var5.size();
            }

            if(var10000 > 0) {
               var2.g = (y.f.S[])var5.toArray(new y.f.S[var5.size()]);
            }

            if(var6.size() > 0) {
               var2.h = (y.f.S[])var6.toArray(new y.f.S[var6.size()]);
            }

            if(var7.size() > 0) {
               var2.i = (y.f.S[])var7.toArray(new y.f.S[var7.size()]);
            }
         }

      }
   }

   private y.f.S[] a(y.f.S[] var1, y.f.S[] var2) {
      if(var1 != null && var1.length != 0) {
         if(var2 != null && var2.length != 0) {
            y.f.S[] var3 = new y.f.S[var1.length + var2.length];
            System.arraycopy(var1, 0, var3, 0, var1.length);
            System.arraycopy(var2, 0, var3, var1.length, var2.length);
            return var3;
         } else {
            return var1;
         }
      } else {
         return var2;
      }
   }

   private void a(y.c.q var1, double var2, double var4) {
      boolean var14 = a.i;
      y.c.p var6 = this.u.b(var1).k();

      Object var10000;
      label81: {
         y.c.q var22;
         label75:
         while(true) {
            if(var6 != null) {
               y.c.q var7 = (y.c.q)var6.c();
               this.x.d(var7, var2, var4);
               G var8 = (G)this.z.b(var7);
               var10000 = this.u;
               if(var14) {
                  break label81;
               }

               if(((y.f.b.c)var10000).d(var7)) {
                  label86: {
                     y.f.am var9 = this.x.a((Object)var7);
                     if(var8.a != null) {
                        double var10 = var9.getX() - var8.a.getX();
                        double var12 = var9.getY() - var8.a.getY();
                        this.a(var7, var10, var12);
                        if(!var14) {
                           break label86;
                        }
                     }

                     this.a(var7, var2, var4);
                  }
               }

               y.c.d var18 = var7.f();

               while(var18 != null) {
                  y.c.q var20 = var18.d();
                  var22 = this.u.a(var20);
                  if(var14) {
                     break label75;
                  }

                  label59: {
                     if(var22 == var1) {
                        y.f.I var11 = this.x.b(var18);
                        int var21 = var11.pointCount() - 1;

                        while(var21 >= 0) {
                           y.d.t var13 = var11.getPoint(var21);
                           var11.setPoint(var21, var13.a + var2, var13.b + var4);
                           --var21;
                           if(var14) {
                              break label59;
                           }

                           if(var14) {
                              break;
                           }
                        }
                     }

                     var18 = var18.g();
                  }

                  if(var14) {
                     break;
                  }
               }

               var6 = var6.a();
               if(!var14) {
                  continue;
               }
            }

            var22 = var1;
            break;
         }

         if(var22 == null) {
            return;
         }

         var10000 = this.z.b(var1);
      }

      G var15 = (G)var10000;
      List var16 = var15.b;
      if(var16 != null) {
         int var17 = var16.size() - 1;

         while(var17 >= 0) {
            y.f.S var19 = (y.f.S)var16.get(var17);
            var19.a(var19.d() + var2, var19.e() + var4);
            --var17;
            if(var14) {
               break;
            }
         }
      }

   }

   private void w() {
      boolean var27 = a.i;
      new y.c.D();
      new y.c.D();
      y.c.D var3 = new y.c.D();
      y.c.x var4 = this.x.o();

      label151:
      do {
         int var10000 = var4.f();

         label148:
         while(var10000 != 0) {
            y.c.q var5 = var4.e();
            y.f.am var6 = this.x.a((Object)var5);
            y.c.d var7 = var5.f();

            while(var7 != null) {
               I var8 = (I)this.y.b(var7);
               List var9 = var8.a;
               List var10 = var8.b;
               if(var27) {
                  continue label151;
               }

               label178: {
                  if(var9 != null && var9.size() >= 1 || var10 != null && var10.size() >= 1) {
                     y.c.q var11 = var7.d();
                     y.f.am var12 = this.x.a((Object)var11);
                     y.f.I var13 = this.x.b(var7);
                     var13.clearPoints();
                     var3.clear();
                     if(var9 != null && var9.size() > 0) {
                        Double var14 = (Double)var9.get(0);
                        var13.setSourcePoint(new y.d.t(var14.x, var14.y));
                        var14.x += var6.getX() + var6.getWidth() * 0.5D;
                        var14.y += var6.getY() + var6.getHeight() * 0.5D;
                        int var15 = 1;

                        while(var15 < var9.size()) {
                           Double var16 = (Double)var9.get(var15);
                           var16.x = var14.x += var16.x;
                           var16.y = var14.y += var16.y;
                           var3.add(var16);
                           ++var15;
                           if(var27) {
                              break label178;
                           }

                           if(var27) {
                              break;
                           }
                        }
                     }

                     y.c.p var28 = var3.l();
                     if(var10 != null && var10.size() > 0) {
                        Double var29 = (Double)var10.get(0);
                        var13.setTargetPoint(new y.d.t(var29.x, var29.y));
                        var29.x += var12.getX() + var12.getWidth() * 0.5D;
                        var29.y += var12.getY() + var12.getHeight() * 0.5D;
                        int var31 = 1;

                        while(var31 < var10.size()) {
                           Double var17 = (Double)var10.get(var31);
                           var17.x = var29.x += var17.x;
                           var17.y = var29.y += var17.y;
                           var3.b((Object)var17, var28);
                           ++var31;
                           if(var27) {
                              break label178;
                           }

                           if(var27) {
                              break;
                           }
                        }
                     }

                     y.d.t var19 = this.x.p(var7);
                     double var30 = var19.a;
                     double var32 = var19.b;
                     boolean var20 = false;
                     boolean var21 = false;
                     y.d.t var24 = this.x.q(var7);
                     var3.add(new Double(var24.a, var24.b));
                     y.c.p var25 = var3.k();

                     Double var26;
                     while(var25 != null) {
                        label164: {
                           var26 = (Double)var25.c();
                           double var33;
                           var10000 = (var33 = Math.abs(var26.x - var30) - 0.001D) == 0.0D?0:(var33 < 0.0D?-1:1);
                           if(var27) {
                              continue label148;
                           }

                           if(var10000 < 0 && Math.abs(var26.y - var32) < 0.001D) {
                              if(var25.b() != null) {
                                 var3.h(var25.b());
                                 if(!var27) {
                                    break label164;
                                 }
                              }

                              var3.h(var25);
                              if(!var27) {
                                 break label164;
                              }
                           }

                           label102: {
                              if(var20 && Math.abs(var32 - var26.y) < 0.001D) {
                                 var3.h(var25.b());
                                 if(!var27) {
                                    break label102;
                                 }
                              }

                              if(var21 && Math.abs(var30 - var26.x) < 0.001D) {
                                 var3.h(var25.b());
                              }
                           }

                           var20 = Math.abs(var32 - var26.y) < 0.001D;
                           var21 = Math.abs(var30 - var26.x) < 0.001D;
                           var30 = var26.x;
                           var32 = var26.y;
                        }

                        var25 = var25.a();
                        if(var27) {
                           break;
                        }
                     }

                     var3.h(var3.l());
                     var25 = var3.k();

                     while(var25 != null) {
                        var26 = (Double)var25.c();
                        var13.addPoint(var26.x, var26.y);
                        var25 = var25.a();
                        if(var27) {
                           break label178;
                        }

                        if(var27) {
                           break;
                        }
                     }
                  }

                  var7 = var7.g();
               }

               if(var27) {
                  break;
               }
            }

            var4.g();
            continue label151;
         }

         return;
      } while(!var27);

   }

   protected Rectangle2D a(y.c.q param1, y.c.y param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   private Map x() {
      boolean var12 = a.i;
      at var1 = new at(this.n());
      y.f.ah var2 = this.S;
      J var3 = this.v;
      v var4 = this.o();

      Map var15;
      try {
         F var5 = new F(this, var1);
         var5.e = var3.e;
         var5.d = var3.d;
         var5.c = var3.c;
         this.v = var5;
         super.a((v)this.v);
         super.a((Q)this.v);
         super.a((R)this.v);
         this.S = var5;
         y.c.y var6 = this.u.c(this.u.b());
         y.c.p var7 = var6.l();

         E var10000;
         while(true) {
            if(var7 != null) {
               y.c.q var8 = (y.c.q)var7.c();
               var10000 = this;
               if(var12) {
                  break;
               }

               if(this.u.d(var8)) {
                  y.c.y var9 = this.u.b(var8);
                  if(var9.size() > 0) {
                     var5.b = this.M.b(var8);
                     this.a(var8, var9, true);
                  }
               }

               var7 = var7.b();
               if(!var12) {
                  continue;
               }
            }

            var5.b = null;
            var10000 = this;
            break;
         }

         var10000.a(this.u.b(), this.u.b(this.u.b()), true);
         var1.a((Object)null);
         var15 = var1.a();
      } finally {
         this.S = var2;
         this.v = var3;
         super.a((v)this.v);
         super.a((Q)this.v);
         super.a((R)this.v);
         this.a(var4);
      }

      return var15;
   }

   private static final void a(y.c.h var0, Object var1, Object var2, y.c.c var3, Object var4) {
      if(var0 != null && var3 != null) {
         Object var5 = var3.b(var4);
         if(var5 != null) {
            var0.a(var1, y.g.am.a(var2, var5));
         }
      }

   }

   private static final void a(y.c.h var0, Object var1, y.c.c var2, Object var3) {
      if(var0 != null && var2 != null) {
         Object var4 = var2.b(var3);
         if(var4 != null) {
            var0.a(var1, var4);
         }
      }

   }

   public void c(y.f.X var1) {
      super.c(var1);
   }

   private void a(y.c.d var1, double var2, double var4) {
      I var6 = (I)this.y.b(var1);
      var6.c.x = var2;
      var6.c.y = var4;
   }

   private void b(y.c.d var1, double var2, double var4) {
      I var6 = (I)this.y.b(var1);
      var6.d.x = var2;
      var6.d.y = var4;
   }

   private List a(y.c.d var1) {
      I var2 = (I)this.y.b(var1);
      if(var2.a == null) {
         var2.a = new ArrayList();
      }

      return var2.a;
   }

   private List b(y.c.d var1) {
      I var2 = (I)this.y.b(var1);
      if(var2.b == null) {
         var2.b = new ArrayList();
      }

      return var2.b;
   }

   public void a(Q var1) {
      this.v.d = var1;
      super.a((Q)this.v);
   }

   public void a(R var1) {
      this.v.c = var1;
      super.a((R)this.v);
   }

   public R a() {
      return this.v.c;
   }

   public Q n() {
      return this.v.d;
   }

   public void a(v var1) {
      this.v.e = var1;
      super.a((v)this.v);
   }

   public v o() {
      return this.v.e;
   }

   public void b(byte var1) {
      super.b(var1);
      if(this.v != null) {
         this.a(super.o());
      }

   }

   public void c(byte var1) {
      super.c(var1);
      if(this.v != null) {
         this.a(super.a());
      }

   }

   void d(y.f.X var1) {
      super.a(var1);
   }

   protected y.c.y[] a(y.f.X var1, y.c.A var2, int var3) {
      boolean var8 = a.i;
      E var10000;
      if(this.z != null) {
         y.c.x var4 = var1.o();

         while(var4.f()) {
            y.c.q var5 = var4.e();
            var10000 = this;
            if(var8) {
               return var10000.a(var1, var2, var3);
            }

            G var6 = (G)this.z.b(var5);
            if(var6 != null) {
               Rectangle2D var7 = var6.a;
               if(var7 != null) {
                  this.x.b(var5, var7.getWidth(), var7.getHeight());
               }
            }

            var4.g();
            if(var8) {
               break;
            }
         }
      }

      var10000 = this;
      return var10000.a(var1, var2, var3);
   }

   public boolean p() {
      return this.U;
   }

   static y.f.X a(E var0) {
      return var0.x;
   }
}
