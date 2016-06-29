package y.h;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.h.aB;
import y.h.aC;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dI;
import y.h.dQ;
import y.h.dR;
import y.h.dS;
import y.h.dT;
import y.h.dU;
import y.h.ek;
import y.h.el;
import y.h.fL;
import y.h.fj;
import y.h.fu;
import y.h.gX;
import y.h.gg;
import y.h.gz;
import y.h.ic;
import y.h.x;
import y.h.y;
import y.h.z;

public class dP extends gX {
   private double b;
   private double c;
   private double d;
   private double e;
   private boolean f;
   private y.c.y g;
   private List h;
   private Cursor i;
   private int j;
   private y.c.f k;
   private dU l;
   private boolean m;
   private byte n = 1;
   private boolean o = true;
   private boolean p;
   private boolean q;
   private az r = new dQ(this);
   private y.c.y s;
   private y.c.y t;
   private boolean u;
   private boolean v;
   private Map w;
   private Double[] x;
   private boolean y;
   private y.c.y z;
   private Set A;
   private int B;
   boolean a;

   public void activate(boolean var1) {
      if(!var1) {
         this.c().f();
      }

      super.activate(var1);
      this.c().a((ch)this.view);
   }

   public int a() {
      return this.B;
   }

   protected boolean a(MouseEvent var1) {
      return (var1.getModifiers() & this.a()) != 0;
   }

   public dU c() {
      if(this.l == null) {
         this.l = this.e();
      }

      return this.l;
   }

   protected dU e() {
      return new dU(this.view);
   }

   public boolean f() {
      return this.m;
   }

   public void a(boolean var1) {
      this.m = var1;
   }

   public dP() {
      this.A = Collections.EMPTY_SET;
      this.B = 2;
   }

   public void mouseShiftPressedLeft(double var1, double var3) {
      y.h.a.v var5 = this.i();
      this.u = var5 != null && this.k();
      this.a(var1, var3, this.u);
   }

   public void mousePressedLeft(double var1, double var3) {
      this.u = false;
      this.a(var1, var3, false);
   }

   public void mouseShiftReleasedLeft(double var1, double var3) {
      this.v = this.a = this.k();
      this.d(var1, var3);
      this.v = false;
   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.a = this.u;
      this.d(var1, var3);
   }

   private void d(double var1, double var3) {
      boolean var9;
      label75: {
         var9 = fj.z;
         if(this.f() && !this.a(this.lastReleaseEvent)) {
            y.d.t var5 = this.c().b(new y.d.t(var1, var3));
            var1 = var5.a;
            var3 = var5.b;
            if(!var9) {
               break label75;
            }
         }

         this.c().h();
         var1 = this.getGridX(var1);
         var3 = this.getGridY(var3);
      }

      bu var10;
      boolean var10000;
      label69: {
         var10 = this.getGraph2D();
         this.view.updateWorldRect();
         this.view.setDrawingMode(0);
         if(this.k != null) {
            y.c.p var6 = this.k.k();

            while(var6 != null) {
               y.c.d var7 = (y.c.d)var6.c();
               aB var8 = var10.i(var7);
               var10000 = this.A.contains(var7);
               if(var9) {
                  break label69;
               }

               if(var10000) {
                  fu.a(var8);
               }

               var6 = var6.a();
               if(var9) {
                  break;
               }
            }

            this.k = null;
         }

         var10000 = this.y;
      }

      if(var10000) {
         HashSet var11 = new HashSet();
         y.c.x var12 = this.getGraph2D().J();

         label81: {
            while(var12.f()) {
               var11.addAll(new y.c.f(var12.e().j()));
               var12.g();
               if(var9) {
                  break label81;
               }

               if(var9) {
                  break;
               }
            }

            if(this.h != null) {
               Iterator var13 = this.h.iterator();

               while(var13.hasNext()) {
                  el var14 = (el)var13.next();
                  if(var14 instanceof ek) {
                     var11.add(((ek)var14).a().a());
                     if(var9) {
                        return;
                     }

                     if(var9) {
                        break;
                     }
                  }
               }
            }
         }

         fu.a((bu)var10, (Collection)var11);
      }

      this.q();
      this.c().f();
      this.b(var1 - this.b, var3 - this.c, var1, var3);
      this.view.setViewCursor(this.i);
      this.i = null;
      var10.T();
      this.setEditing(false);
      this.reactivateParent();
      this.g = null;
      this.A = Collections.EMPTY_SET;
      this.h = null;
      this.x = null;
   }

   private void m() {
      boolean var2 = fj.z;
      bu var1;
      if(this.view != null && (var1 = this.view.getGraph2D()) != null) {
         if(this.j != 1) {
            y.g.o.a((Object)("Unexpected BracketCounter in MoveSelectionMode : " + this.j));
         }

         while(this.j > 0) {
            --this.j;
            var1.s();
            if(var2) {
               break;
            }
         }

      }
   }

   public void reactivateParent() {
      this.m();
      super.reactivateParent();
   }

   public void mouseDraggedLeft(double var1, double var3) {
      boolean var9;
      label31: {
         var9 = fj.z;
         if(this.f() && !this.a(this.lastDragEvent)) {
            y.d.t var5 = this.c().b(new y.d.t(var1, var3));
            var1 = var5.a;
            var3 = var5.b;
            if(!var9) {
               break label31;
            }
         }

         var1 = this.getGridX(var1);
         var3 = this.getGridY(var3);
         this.c().h();
      }

      label34: {
         if(this.f && this.n() && this.isGridMode()) {
            this.f = false;
            this.d = var1;
            this.e = var3;
            if(!var9) {
               break label34;
            }
         }

         double var10 = var1 - this.d;
         double var7 = var3 - this.e;
         if(var10 != 0.0D || var7 != 0.0D) {
            this.d = var1;
            this.e = var3;
            this.e(var1 - this.b, var3 - this.c);
            this.a(var10, var7, var1, var3);
         }
      }

      this.view.updateView();
   }

   private void e(double var1, double var3) {
      boolean var10 = fj.z;
      if(this.g != null) {
         bu var5 = this.getGraph2D();
         y.c.p var6 = this.g.k();

         while(var6 != null) {
            y.c.q var7 = (y.c.q)var6.c();

            try {
               Double var8 = this.x[var7.d()];
               fj var9 = var5.t(var7);
               var9.setLocation(var8.x + var1, var8.y + var3);
            } catch (ArrayIndexOutOfBoundsException var11) {
               ;
            } catch (NullPointerException var12) {
               ;
            }

            var6 = var6.a();
            if(var10) {
               break;
            }
         }

         int var14 = 0;

         while(true) {
            if(var14 < this.h.size()) {
               label36: {
                  try {
                     el var15 = (el)this.h.get(var14);
                     var15.a(var1, var3);
                  } catch (NullPointerException var13) {
                     break label36;
                  }

                  if(var10) {
                     break;
                  }
               }

               ++var14;
               if(!var10) {
                  continue;
               }
            }

            this.o();
            break;
         }

      }
   }

   private void b(fj var1) {
      boolean var5 = fj.z;
      y.c.q var2 = var1.getNode();
      bu var3 = this.getGraph2D();
      y.c.d var4 = var2.f();

      boolean var10000;
      while(true) {
         if(var4 != null) {
            var10000 = this.A.contains(var4);
            if(var5) {
               break;
            }

            if(var10000) {
               ic.a(this.view, var3.i(var4), true);
            }

            var4 = var4.g();
            if(!var5) {
               continue;
            }

            var4 = var2.g();
         } else {
            var4 = var2.g();
         }

         if(var4 == null) {
            return;
         }

         var10000 = this.A.contains(var4);
         break;
      }

      while(true) {
         if(var10000) {
            ic.a(this.view, var3.i(var4), false);
         }

         var4 = var4.h();
         if(var5 || var4 == null) {
            return;
         }

         var10000 = this.A.contains(var4);
      }
   }

   protected void a(double var1, double var3) {
   }

   protected void a(double var1, double var3, double var5, double var7) {
      if(this.s != null) {
         this.a(this.s);
      }

   }

   private void a(y.c.y var1) {
      boolean var17 = fj.z;
      bu var2 = this.getGraph2D();
      if(this.j() == 1) {
         y.c.p var3 = var1.k();

         while(var3 != null) {
            y.c.q var4 = (y.c.q)var3.c();
            fj var5 = var2.t(var4);
            y.h.a.a var6 = var5.getAutoBoundsFeature();
            if(var6 != null) {
               Rectangle2D var7 = (Rectangle2D)this.w.get(var4);
               Rectangle2D var8 = var6.getMinimalAutoBounds();
               double var9 = Math.max(0.0D, var8.getX() - var7.getX());
               double var11 = Math.max(0.0D, var8.getY() - var7.getY());
               double var13 = Math.max(0.0D, var7.getMaxX() - var8.getMaxX());
               double var15 = Math.max(0.0D, var7.getMaxY() - var8.getMaxY());
               var6.setAutoBoundsInsets(new y.d.r(var11, var9, var15, var13));
            }

            var3 = var3.a();
            if(var17) {
               break;
            }
         }
      }

   }

   protected void b(double var1, double var3, double var5, double var7) {
      boolean var20 = fj.z;
      y.h.a.v var9 = this.i();
      if(var9 != null) {
         bu var10 = this.getGraph2D();
         if(this.v || this.u) {
            Object var11 = this.b(var5, var7);
            if(var11 != null) {
               y.c.y var12 = new y.c.y();
               y.c.x var13 = this.t.a();

               Object var10000;
               label72: {
                  while(var13.f()) {
                     y.c.q var14 = var13.e();
                     var10000 = var14.e();
                     if(var20) {
                        break label72;
                     }

                     if(var10000 == var10) {
                        var12.add(var14);
                     }

                     var13.g();
                     if(var20) {
                        break;
                     }
                  }

                  var10000 = var11;
               }

               if(!(var10000 instanceof y.c.q)) {
                  if(var11 instanceof bu) {
                     var9.c(var12, var9.e((y.c.i)var11));
                  }
               } else {
                  y.c.q var21 = (y.c.q)var11;
                  var9.c(var12, var21);
                  y.c.y var22 = new y.c.y();
                  var22.add(var11);
                  y.c.q var15 = (y.c.q)var11;

                  label85: {
                     while(true) {
                        if((var15 = var9.n(var15)) != null) {
                           var10000 = var15.e();
                           if(var20) {
                              break;
                           }

                           if(var10000 == var10) {
                              var22.add(var15);
                              if(!var20) {
                                 continue;
                              }
                           }
                        }

                        var10.a(var22.a());
                        if(this.w == null || this.j() != 0) {
                           break label85;
                        }

                        var10000 = this.w.get(var21);
                        break;
                     }

                     Rectangle2D var16 = (Rectangle2D)var10000;
                     Double var17 = var10.t(var21).getBoundingBox();
                     Rectangle2D var23 = var17.createUnion(var16);
                     fj var18 = var10.t(var21);
                     y.h.a.a var19 = var18.getAutoBoundsFeature();
                     if(var19 != null) {
                        if(var19.isAutoBoundsEnabled() && var9.p(var21).f()) {
                           break label85;
                        }

                        var18.setFrame(var23);
                        if(!var20) {
                           break label85;
                        }
                     }

                     var18.setFrame(var23);
                  }

                  this.a(var22);
               }

               var10.T();
            }
         }
      }

      this.d(this.a);
   }

   protected y.c.y g() {
      boolean var4 = fj.z;
      y.c.y var1 = new y.c.y();
      bu var2 = this.getGraph2D();
      y.c.x var3 = var2.o();

      while(var3.f()) {
         if(var2.v(var3.e())) {
            var1.add(var3.e());
         }

         var3.g();
         if(var4) {
            break;
         }
      }

      return var1;
   }

   protected z h() {
      boolean var5 = fj.z;
      z var1 = new z();
      bu var2 = this.getGraph2D();
      y var3 = var2.D();

      while(var3.f()) {
         x var4 = var3.a();
         if(var2.a(var4)) {
            var1.b(var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var1;
   }

   private void a(y.c.y var1, z var2) {
      y.h.a.v var3 = this.i();
      if(var3 == null) {
         this.s = null;
         this.t = null;
         var1.addAll(this.g());
         var2.addAll(this.h());
         if(!fj.z) {
            return;
         }
      }

      this.s = new y.c.y();
      this.t = this.g();
      var1.addAll(this.t);
      var2.addAll(this.h());
      this.a(var1, this.s, var2);
   }

   protected void a(y.c.y var1, y.c.y var2, z var3) {
      HashSet var4 = new HashSet(var1);
      HashSet var5 = new HashSet(var3);
      gg.a(this.getGraph2D(), new dR(this, var4), new dS(this, var5), var1, var2, var3);
   }

   void a(double var1, double var3, boolean var5) {
      boolean var31 = fj.z;
      bu var6 = this.getGraph2D();
      this.setEditing(true);
      this.f = true;
      var1 = this.getGridX(var1);
      var3 = this.getGridY(var3);
      this.b = this.d = var1;
      this.c = this.e = var3;
      this.view.updateView();
      this.i = this.view.getViewCursor();
      this.view.setViewCursor(Cursor.getPredefinedCursor(13));
      this.g = new y.c.y();
      z var7 = new z();
      this.a(this.g, var7);
      var6.r();
      ++this.j;
      var6.b((byte)1);
      HashSet var8 = new HashSet(this.g);
      this.A = new HashSet();
      ArrayList var9 = new ArrayList();
      ArrayList var10 = new ArrayList();
      int var11 = 0;
      y.c.e var12 = var6.p();

      while(var12.f()) {
         y.c.d var13 = var12.a();
         boolean var14 = this.a(var13);
         if(var14) {
            this.A.add(var13);
         }

         var11 += var6.i(var13).bendCount();
         var12.g();
         if(var31) {
            break;
         }
      }

      y.c.p var32 = var7.k();

      dP var10000;
      while(true) {
         if(var32 != null) {
            x var34 = (x)var32.c();
            y.c.d var36 = var34.a();
            var10000 = this;
            if(var31) {
               break;
            }

            if(this.A.contains(var36)) {
               this.A.add(var36);
               aB var15 = var6.i(var36);
               if(var15.firstBend() == var34 && !var8.contains(var36.c())) {
                  var9.add(var36);
               }

               if(var15.lastBend() == var34 && !var8.contains(var36.d())) {
                  var10.add(var36);
               }
            }

            var32 = var32.a();
            if(!var31) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.k = new y.c.f();
      ArrayList var33 = new ArrayList();
      HashSet var35 = new HashSet(var7);
      Iterator var37 = this.A.iterator();

      int var17;
      boolean var70;
      while(true) {
         if(var37.hasNext()) {
            y.c.d var39 = (y.c.d)var37.next();
            aB var16 = var6.i(var39);
            var17 = var16.bendCount();
            if(var17 != 0) {
               continue;
            }

            var70 = var8.contains(var39.c());
            if(var31) {
               break;
            }

            if(var70 == var8.contains(var39.d())) {
               continue;
            }

            var33.add(var39);
            if(!var31) {
               continue;
            }
         }

         var70 = var33.isEmpty();
         break;
      }

      if(!var70) {
         var6.a((new y.c.f(var33.iterator())).a());
      }

      HashSet var38 = new HashSet(var9);
      var38.addAll(var10);
      if(!var38.isEmpty()) {
         var6.a((new y.c.f(var38.iterator())).a());
      }

      byte[] var40 = new byte[var11];
      int var41 = 0;
      y.c.e var42 = var6.p();

      y var20;
      x var21;
      byte var71;
      label529:
      while(true) {
         var70 = var42.f();

         label526:
         while(var70) {
            y.c.d var44 = var42.a();
            boolean var18 = this.A.contains(var44);
            var71 = 0;
            if(var31) {
               break label529;
            }

            int var19 = 0;
            var20 = var6.i(var44).bends();

            while(var20.f()) {
               var21 = var20.a();
               var20.g();
               var70 = var35.contains(var21);
               if(var31) {
                  continue label526;
               }

               label520: {
                  if(var70) {
                     var40[var41] = (byte)(var40[var41] | 1);
                     if(!var18) {
                        break label520;
                     }

                     if(var19 > 0) {
                        var40[var41 - 1] = (byte)(var40[var41 - 1] | 2);
                     }

                     if(!var20.f()) {
                        break label520;
                     }

                     var40[var41 + 1] = (byte)(var40[var41 + 1] | 4);
                     if(!var31) {
                        break label520;
                     }
                  }

                  if(var18) {
                     if(var19 == 0 && var8.contains(var44.c())) {
                        var40[var41] = (byte)(var40[var41] | 4);
                     }

                     if(!var20.f() && var8.contains(var44.d())) {
                        var40[var41] = (byte)(var40[var41] | 2);
                     }
                  }
               }

               if(var40[var41] != 0) {
                  this.k.add(var44);
               }

               ++var41;
               ++var19;
               if(var31) {
                  break;
               }
            }

            var42.g();
            if(!var31) {
               continue label529;
            }
            break;
         }

         var71 = 0;
         break;
      }

      int var43 = var71;
      var17 = 0;

      byte var72;
      while(true) {
         if(var17 < var40.length) {
            byte var45 = var40[var17];
            var72 = var45;
            if(var31) {
               break;
            }

            if(var45 > 0) {
               ++var43;
            }

            ++var17;
            if(!var31) {
               continue;
            }
         }

         var6.a(this.k.a());
         this.h = new ArrayList(var43 + var33.size() + var9.size() + var10.size());
         var7.clear();
         var72 = 0;
         break;
      }

      var41 = var72;
      y.c.e var46 = var6.p();

      fj var63;
      label486:
      while(true) {
         var72 = var46.f();

         label483: {
            aB var73;
            label482:
            while(true) {
               double var26;
               if(var72 != 0) {
                  label574: {
                     aB var47 = var6.i(var46.a());
                     x var50 = null;
                     var73 = var47;
                     if(var31) {
                        break;
                     }

                     var20 = var47.bends();

                     while(var20.f()) {
                        var21 = var20.a();
                        var20.g();
                        byte var22 = var40[var41];
                        var72 = var22;
                        if(var31) {
                           continue label482;
                        }

                        if(var22 != 0) {
                           byte var23;
                           label576: {
                              var7.add(var21);
                              var23 = 0;
                              if((var22 & 1) != 0) {
                                 var23 = 3;
                                 if(!var31) {
                                    break label576;
                                 }
                              }

                              fL var25;
                              double var28;
                              if((var22 & 2) == 2) {
                                 label577: {
                                    if(var20.f()) {
                                       x var24 = var20.a();
                                       if(var24.b() == var21.b()) {
                                          var23 = (byte)(var23 | 1);
                                          if(!var31) {
                                             break label577;
                                          }
                                       }

                                       if(var24.c() != var21.c()) {
                                          break label577;
                                       }

                                       var23 = (byte)(var23 | 2);
                                       if(!var31) {
                                          break label577;
                                       }
                                    }

                                    var63 = var47.getTargetRealizer();
                                    var25 = var47.getTargetPort();
                                    var26 = var25.a(var63);
                                    var28 = var25.b(var63);
                                    if(var26 == var21.b()) {
                                       var23 = (byte)(var23 | 1);
                                       if(!var31) {
                                          break label577;
                                       }
                                    }

                                    if(var28 == var21.c()) {
                                       var23 = (byte)(var23 | 2);
                                    }
                                 }
                              }

                              if((var22 & 4) == 4) {
                                 label599: {
                                    if(var50 == null) {
                                       var63 = var47.getSourceRealizer();
                                       var25 = var47.getSourcePort();
                                       var26 = var25.a(var63);
                                       var28 = var25.b(var63);
                                       if(var26 == var21.b()) {
                                          var23 = (byte)(var23 | 1);
                                          if(!var31) {
                                             break label599;
                                          }
                                       }

                                       if(var28 != var21.c()) {
                                          break label599;
                                       }

                                       var23 = (byte)(var23 | 2);
                                       if(!var31) {
                                          break label599;
                                       }
                                    }

                                    if(var50.b() == var21.b()) {
                                       var23 = (byte)(var23 | 1);
                                       if(!var31) {
                                          break label599;
                                       }
                                    }

                                    if(var50.c() == var21.c()) {
                                       var23 = (byte)(var23 | 2);
                                    }
                                 }
                              }
                           }

                           if(var23 != 0) {
                              this.h.add(new ek(var21, new y.d.t(var21.b(), var21.c()), var23));
                           }
                        }

                        var50 = var21;
                        ++var41;
                        if(var31) {
                           var46.g();
                           if(!var31) {
                              continue label486;
                           }
                           break label574;
                        }
                     }

                     var46.g();
                     if(!var31) {
                        continue label486;
                     }
                  }
               }

               Iterator var48 = var33.iterator();

               label607: {
                  y.c.d var49;
                  aB var52;
                  x var54;
                  y.d.t var55;
                  double var57;
                  double var65;
                  x var67;
                  label416:
                  while(true) {
                     x var29;
                     int var74;
                     if(var48.hasNext()) {
                        var49 = (y.c.d)var48.next();
                        var52 = var6.i(var49);
                        y.d.t var53 = var6.p(var49);
                        var55 = var6.q(var49);
                        var57 = var53.a - var55.a;
                        var65 = var53.b - var55.b;
                        double var76;
                        var74 = (var76 = Math.abs(var57) - Math.abs(var65)) == 0.0D?0:(var76 < 0.0D?-1:1);
                        if(!var31) {
                           label581: {
                              if(var74 > 0) {
                                 var26 = this.getGridX((var53.a + var55.a) * 0.5D);
                                 var67 = var52.appendBend(var26, var53.b);
                                 var29 = var52.appendBend(var26, var55.b);
                                 if(this.g.contains(var49.c())) {
                                    this.h.add(new ek(var67, var67.e(), (byte)2));
                                    if(!var31) {
                                       break label581;
                                    }
                                 }

                                 this.h.add(new ek(var29, var29.e(), (byte)2));
                                 if(!var31) {
                                    break label581;
                                 }
                              }

                              var26 = this.getGridY((var53.b + var55.b) * 0.5D);
                              var67 = var52.appendBend(var53.a, var26);
                              var29 = var52.appendBend(var55.a, var26);
                              if(this.g.contains(var49.c())) {
                                 this.h.add(new ek(var67, var67.e(), (byte)1));
                                 if(!var31) {
                                    break label581;
                                 }
                              }

                              this.h.add(new ek(var29, var29.e(), (byte)1));
                           }

                           this.k.add(var49);
                           if(!var31) {
                              continue;
                           }

                           var48 = var9.iterator();
                           if(!var48.hasNext()) {
                              var48 = var10.iterator();
                              if(!var48.hasNext()) {
                                 break label607;
                              }
                              break;
                           }
                        } else if(var74 == 0) {
                           var48 = var10.iterator();
                           if(!var48.hasNext()) {
                              break label607;
                           }
                           break;
                        }
                     } else {
                        var48 = var9.iterator();
                        if(!var48.hasNext()) {
                           var48 = var10.iterator();
                           if(!var48.hasNext()) {
                              break label607;
                           }
                           break;
                        }
                     }

                     do {
                        while(true) {
                           var49 = (y.c.d)var48.next();
                           var52 = var6.i(var49);
                           var54 = var52.firstBend();
                           var55 = var6.p(var49);
                           var57 = var55.a - var54.b();
                           var65 = var55.b - var54.c();
                           boolean var66 = true;
                           var74 = var52.bendCount();
                           if(var31) {
                              if(var74 == 0) {
                                 break label607;
                              }
                              break label416;
                           }

                           if(var74 == 1 && var49.e() && var10.contains(var49)) {
                              var66 = false;
                           }

                           double var27;
                           x var30;
                           if(Math.abs(var57) > Math.abs(var65)) {
                              var27 = this.getGridX((var54.b() + var55.a()) * 0.5D);
                              var52.createBend(var27, var55.b, var54, 1);
                              var29 = var52.createBend(var27, var54.c(), var54, 1);
                              if(var66) {
                                 this.h.add(new ek(var29, var29.e(), (byte)2));
                                 if(!var31) {
                                    break;
                                 }
                              }

                              var30 = var52.createBend(var54.b(), var54.c(), var54, 1);
                              this.h.add(new ek(var30, var30.e(), (byte)1));
                              if(!var31) {
                                 if(!var48.hasNext()) {
                                    var48 = var10.iterator();
                                    if(!var48.hasNext()) {
                                       break label607;
                                    }
                                    break label416;
                                 }
                                 continue;
                              }
                           }

                           var27 = this.getGridY((var54.c() + var55.b()) * 0.5D);
                           var52.createBend(var55.a, var27, var54, 1);
                           var29 = var52.createBend(var54.b(), var27, var54, 1);
                           if(var66) {
                              this.h.add(new ek(var29, var29.e(), (byte)1));
                              if(var31) {
                                 var30 = var52.createBend(var54.b(), var54.c(), var54, 1);
                                 this.h.add(new ek(var30, var30.e(), (byte)2));
                                 if(var31) {
                                    var48 = var10.iterator();
                                    if(!var48.hasNext()) {
                                       break label607;
                                    }
                                    break label416;
                                 }
                              }
                           } else {
                              var30 = var52.createBend(var54.b(), var54.c(), var54, 1);
                              this.h.add(new ek(var30, var30.e(), (byte)2));
                              if(var31) {
                                 var48 = var10.iterator();
                                 if(!var48.hasNext()) {
                                    break label607;
                                 }
                                 break label416;
                              }
                           }

                           if(!var48.hasNext()) {
                              var48 = var10.iterator();
                              if(!var48.hasNext()) {
                                 break label607;
                              }
                              break label416;
                           }
                        }
                     } while(var48.hasNext());

                     var48 = var10.iterator();
                     if(!var48.hasNext()) {
                        break label607;
                     }
                     break;
                  }

                  label305:
                  do {
                     while(true) {
                        var49 = (y.c.d)var48.next();
                        var52 = var6.i(var49);
                        var54 = var52.lastBend();
                        var55 = var6.q(var49);
                        var57 = var55.a - var54.b();
                        var65 = var55.b - var54.c();
                        if(Math.abs(var57) > Math.abs(var65)) {
                           var26 = this.getGridX((var54.b() + var55.a()) * 0.5D);
                           var52.createBend(var26, var55.b, var54, 0);
                           var67 = var52.createBend(var26, var54.c(), var54, 0);
                           this.h.add(new ek(var67, var67.e(), (byte)2));
                           if(!var31) {
                              break;
                           }
                        }

                        var26 = this.getGridY((var54.c() + var55.b()) * 0.5D);
                        var52.createBend(var55.a, var26, var54, 0);
                        var67 = var52.createBend(var54.b(), var26, var54, 0);
                        this.h.add(new ek(var67, var67.e(), (byte)1));
                        if(var31 || !var48.hasNext()) {
                           break label305;
                        }
                     }
                  } while(var48.hasNext());
               }

               var46 = this.k.a();
               if(!var46.f()) {
                  break label483;
               }

               var73 = var6.i(var46.a());
               break;
            }

            while(true) {
               var73.setLayer((byte)0);
               var46.g();
               if(var31) {
                  break label486;
               }

               if(var31 || !var46.f()) {
                  break;
               }

               var73 = var6.i(var46.a());
            }
         }

         this.getGraph2D().a(this.g.a());
         break;
      }

      y.c.x var59 = this.g.a();

      while(true) {
         if(var59.f()) {
            var6.t(var59.e()).setLayer((byte)0, true);
            var59.g();
            if(var31) {
               break;
            }

            if(!var31) {
               continue;
            }
         }

         this.view.setDrawingMode(3);
         this.b(var5);
         this.x = new Double[var6.e()];
         break;
      }

      Object var61 = null;
      double var51 = 0.0D;
      double var56 = 0.0D;
      fj var58;
      if(this.g.size() + this.h.size() == 1 && this.isGridMode()) {
         if(this.g.size() == 1) {
            var58 = var6.t(this.g.b());
            var51 = var58.getCenterX();
            var56 = var58.getCenterY();
            var58.setCenter(this.getGridX(var51), this.getGridY(var56));
            this.b(var58);
            var61 = var58;
         } else {
            ek var60 = (ek)this.h.get(0);
            x var68 = var60.a();
            var51 = var68.b();
            var56 = var68.c();
            var68.a(this.getGridX(var51), this.getGridY(var56));
            var61 = var68;
            this.h.set(0, new ek(var68, var68.e(), var60.a));
         }
      }

      y.c.x var62 = this.g.a();

      Object var75;
      while(true) {
         if(var62.f()) {
            y.c.q var69 = var62.e();
            var75 = var69;
            if(var31) {
               break;
            }

            if(var69 != null && var69.e() != null) {
               var63 = var6.t(var69);
               this.x[var69.d()] = new Double(var63.getX(), var63.getY(), var63.getWidth(), var63.getHeight());
            }

            var62.g();
            if(!var31) {
               continue;
            }
         }

         if(this.f()) {
            this.c().a(new y.d.t(var1, var3), this.g, this.h, Collections.EMPTY_SET, y.g.q.a((Object[])this.x));
            if(this.isGridMode()) {
               this.c().a((gz)(new dT(this, java.lang.Double.POSITIVE_INFINITY)));
            }
         }

         this.a(var1, var3);
         var75 = var61;
         break;
      }

      if(var75 != null) {
         if(var61 instanceof fj) {
            var58 = (fj)var61;
            if(var51 != var58.getCenterX() || var56 != var58.getCenterY()) {
               this.a(var58.getCenterX() - var51, var58.getCenterY() - var56, var1, var3);
            }
         }

         if(var61 instanceof x) {
            x var64 = (x)var61;
            if(var51 != var64.b() || var56 != var64.c()) {
               this.a(var64.b() - var51, var64.c() - var56, var1, var3);
            }
         }
      }

      if(y.c.i.g) {
         fj.z = !var31;
      }

   }

   protected boolean a(y.c.d var1) {
      return aC.b(var1, this.getGraph2D());
   }

   private boolean n() {
      return (this.h != null?this.h.size():0) + (this.g != null?this.g.size():0) == 1;
   }

   public void cancelEditing() {
      this.c().f();
      if(this.isEditing()) {
         this.b(this.d - this.b, this.e - this.c, this.d, this.e);
         this.q();
         this.view.setDrawingMode(0);
         if(this.i != null) {
            this.view.setViewCursor(this.i);
            this.i = null;
         }

         this.view.getGraph2D().T();
         this.setEditing(false);
         this.reactivateParent();
         this.g = null;
         this.A = Collections.EMPTY_SET;
         this.h = null;
         this.x = null;
      }

   }

   protected Object b(double var1, double var3) {
      boolean var10 = fj.z;
      bu var5 = this.getGraph2D();
      cW var6 = this.c(var1, var3);
      if(!var6.t()) {
         return var5;
      } else {
         y.h.a.v var7 = this.i();
         y.c.C var8 = var6.e();

         bu var10000;
         while(true) {
            if(var8.f()) {
               y.c.q var9 = (y.c.q)var8.d();
               var10000 = var5;
               if(var10) {
                  break;
               }

               if(!var5.v(var9) && var7.k(var9)) {
                  return var9;
               }

               var8.g();
               if(!var10) {
                  continue;
               }
            }

            var10000 = var5;
            break;
         }

         return var10000;
      }
   }

   protected cW c(double var1, double var3) {
      return new cW(this.view, var1, var3, false, 4);
   }

   protected y.h.a.v i() {
      return y.h.a.v.a((y.c.i)this.getGraph2D());
   }

   public byte j() {
      return this.n;
   }

   public boolean k() {
      return this.o;
   }

   public boolean l() {
      return this.p;
   }

   protected void a(Graphics2D var1, fj var2) {
      dI.b(var1, var2);
   }

   protected Rectangle2D a(fj var1) {
      return new Double(var1.getX() - 10.0D, var1.getY() - 10.0D, var1.getWidth() + 20.0D, var1.getHeight() + 20.0D);
   }

   private void o() {
      boolean var3 = fj.z;
      if(this.k() && this.l()) {
         MouseEvent var1 = this.lastDragEvent != null?this.lastDragEvent:this.lastPressEvent;
         boolean var2 = var1 != null && (var1.getModifiers() & 1) != 0;
         if(var2) {
            this.p();
            if(!var3) {
               return;
            }
         }

         this.q();
         if(!var3) {
            return;
         }
      }

      this.q();
   }

   private void p() {
      if(!this.q) {
         this.q = true;
         this.view.addDrawable(this.r);
      }

   }

   private void q() {
      if(this.q) {
         this.view.removeDrawable(this.r);
         this.q = false;
      }

   }

   private void b(boolean var1) {
      boolean var7 = fj.z;
      y.h.a.v var2 = this.i();
      if(var2 == null) {
         this.s = null;
      } else {
         bu var3;
         label46: {
            var3 = this.getGraph2D();
            if(this.s != null) {
               var3.a(this.s.a());
               y.c.p var4 = this.s.k();

               while(var4 != null) {
                  fj var5 = var3.t((y.c.q)var4.c());
                  var5.setLayer((byte)0, true);
                  var4 = var4.a();
                  if(var7) {
                     break label46;
                  }

                  if(var7) {
                     break;
                  }
               }
            }

            this.w = new HashMap();
         }

         y.c.x var8 = var3.o();

         boolean var10000;
         while(true) {
            if(var8.f()) {
               y.c.q var9 = var8.e();
               var10000 = var2.k(var9);
               if(var7) {
                  break;
               }

               if(var10000) {
                  fj var6 = var3.t(var9);
                  this.w.put(var9, var6.getBoundingBox());
               }

               var8.g();
               if(!var7) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         if(var10000) {
            this.e(false);
         }

      }
   }

   private void d(boolean var1) {
      if(var1) {
         this.e(true);
      }

      this.s = null;
      this.t = null;
      this.w = null;
   }

   private void e(boolean var1) {
      boolean var7 = fj.z;
      bu var2 = this.getGraph2D();
      y.c.p var3;
      if(var1) {
         if(this.z == null) {
            return;
         }

         var3 = this.z.k();

         label50: {
            while(var3 != null) {
               fj var4 = var2.t((y.c.q)var3.c());
               y.h.a.a var5 = var4.getAutoBoundsFeature();
               if(var7) {
                  break label50;
               }

               if(var5 != null) {
                  var5.setAutoBoundsEnabled(true);
               }

               var3 = var3.a();
               if(var7) {
                  break;
               }
            }

            this.z = null;
         }

         if(!var7) {
            return;
         }
      }

      if(this.s != null) {
         if(this.z == null) {
            this.z = new y.c.y();
         }

         var3 = this.s.k();

         while(var3 != null) {
            y.c.q var8 = (y.c.q)var3.c();
            fj var9 = var2.t(var8);
            y.h.a.a var6 = var9.getAutoBoundsFeature();
            if(var6 != null && var6.isAutoBoundsEnabled()) {
               var6.setAutoBoundsEnabled(false);
               this.z.add(var8);
            }

            var3 = var3.a();
            if(var7) {
               break;
            }
         }
      }

   }

   public void mouseReleased(MouseEvent var1) {
      super.mouseReleased(var1);
      this.u = false;
   }

   public void mouseReleasedRight(double var1, double var3) {
      this.mouseReleasedLeft(var1, var3);
   }

   public void mouseDraggedRight(double var1, double var3) {
      this.mouseDraggedLeft(var1, var3);
   }

   static double a(dP var0) {
      return var0.d;
   }

   static double b(dP var0) {
      return var0.e;
   }
}
