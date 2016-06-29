package y.h;

import java.awt.Cursor;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import y.h.aB;
import y.h.aC;
import y.h.bu;
import y.h.db;
import y.h.dc;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.fu;
import y.h.gX;
import y.h.gg;
import y.h.gt;
import y.h.ic;
import y.h.z;

public class da extends gX {
   private double a;
   private double b;
   private byte c;
   private boolean d;
   private y.c.q e;
   private y.d.t f;
   private byte g = 3;
   private boolean h;
   private byte i = 1;
   private HashMap j;
   private boolean k;
   private Set l;
   private int m;
   private Double[] n;
   private y.d.t o;
   private int p;
   private KeyListener q;
   private int r;
   private boolean s;
   private dc t;

   public int a() {
      return this.m;
   }

   protected boolean a(MouseEvent var1) {
      return (var1.getModifiers() & this.a()) != 0;
   }

   public dc c() {
      if(this.t == null) {
         this.t = this.f();
      }

      return this.t;
   }

   public boolean e() {
      return this.h;
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   protected dc f() {
      return new dc(this.view);
   }

   public da() {
      this.l = Collections.EMPTY_SET;
      this.m = 2;
      this.p = 2;
      this.r = 27;
   }

   public void mousePressedLeft(double var1, double var3) {
      bu var5;
      y.h.a.v var6;
      y.c.x var7;
      y.c.q var11;
      boolean var15;
      label175: {
         var15 = fj.z;
         var5 = this.getGraph2D();
         this.s = false;
         this.n = new Double[var5.f()];
         this.o = new y.d.t(var1, var3);
         this.l = new HashSet();
         var6 = var5.C();
         if(var6 != null && this.l() == 1) {
            y.c.y var8 = new y.c.y(var5.J());
            HashSet var9 = new HashSet(var8);
            y.c.p var10 = var8.k();

            while(var10 != null) {
               Object var10000 = var10.c();

               label167:
               while(true) {
                  var11 = (y.c.q)var10000;
                  y.c.q var12 = var6.n(var11);

                  while(true) {
                     if(var12 == null) {
                        break label167;
                     }

                     var10000 = var12.e();
                     if(var15) {
                        break;
                     }

                     if(var10000 != var5 || !var9.add(var12)) {
                        break label167;
                     }

                     var12 = var6.n(var11);
                     if(var15) {
                        break label167;
                     }
                  }
               }

               var10 = var10.a();
               if(var15) {
                  break;
               }
            }

            var7 = (new y.c.y(var9.iterator())).a();
            if(!var15) {
               break label175;
            }
         }

         var7 = var5.J();
      }

      byte var16 = 8;
      y.c.x var17 = var5.o();

      fj var22;
      byte var28;
      while(true) {
         if(var17.f()) {
            y.c.q var20 = var17.e();
            var28 = var5.v(var20);
            if(var15) {
               break;
            }

            if(var28 != 0) {
               var22 = var5.t(var20);
               this.n[var20.d()] = var22.getBoundingBox();
               byte var25;
               if(var16 == 8 && (var25 = var22.hotSpotHit(var1, var3)) != 8) {
                  this.e = var17.e();
                  var16 = var25;
               }
            }

            var17.g();
            if(!var15) {
               continue;
            }
         }

         this.c = var16;
         var28 = var16;
         break;
      }

      boolean var29;
      label182: {
         if(var28 != 8) {
            this.a = var1;
            this.b = var3;
            this.d = true;
            this.setEditing(true);
            this.view.setDrawingMode(1);
            this.f = this.a(var1, var3);
            y.c.f var18 = new y.c.f();
            y.c.e var21 = var5.p();

            while(var21.f()) {
               y.c.d var24 = var21.a();
               boolean var26 = var5.v(var24.c());
               boolean var13 = var5.v(var24.d());
               var29 = var26;
               if(var15) {
                  break label182;
               }

               if(var26 || var13) {
                  label188: {
                     boolean var14 = this.a(var24);
                     if(var26 && (var14 || this.k && var5.i(var24).bendCount() > 0 || !var5.n(var24).equals(y.d.t.c))) {
                        var18.add(var24);
                        if(!var14) {
                           break label188;
                        }

                        this.l.add(var24);
                        if(!var15) {
                           break label188;
                        }
                     }

                     if(var13 && (var14 || this.k && var5.i(var24).bendCount() > 0 || !var5.o(var24).equals(y.d.t.c))) {
                        var18.add(var24);
                        if(var14) {
                           this.l.add(var24);
                        }
                     }
                  }
               }

               var21.g();
               if(var15) {
                  break;
               }
            }

            var5.r();
            var5.a(var7);
            var5.a(var18.a());
            var5.s();
         }

         if(this.q == null && this.r >= 0) {
            this.q = new db(this);
            this.view.getCanvasComponent().addKeyListener(this.q);
         }

         var29 = this.e();
      }

      if(var29) {
         this.c().a(this.o, new y.c.y(var5.J()), y.g.q.a((Object[])this.n));
      }

      y.c.y var19 = new y.c.y();
      gg.a(this.getGraph2D(), var19, var19, (z)null);
      y.c.x var23 = var19.a();

      while(true) {
         if(var23.f()) {
            var22 = var5.t(var23.e());
            var22.setLayer((byte)0);
            var23.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         if(var6 != null && this.l() == 1) {
            this.j = new HashMap();
            var23 = var5.o();

            do {
               if(!var23.f()) {
                  return;
               }

               var11 = var23.e();
               if(var6.k(var11)) {
                  fj var27 = var5.t(var11);
                  this.j.put(var11, var27.getBoundingBox());
               }

               var23.g();
            } while(!var15);
         }
         break;
      }

      this.j = null;
   }

   public void mouseReleased(MouseEvent var1) {
      super.mouseReleased(var1);
      this.j = null;
   }

   protected boolean a(y.c.d var1) {
      return aC.b(var1, this.getGraph2D());
   }

   public void mouseDraggedLeft(double var1, double var3) {
      boolean var32 = fj.z;
      if(this.d) {
         label91: {
            if(this.g == 3) {
               this.b(var1, var3);
               if(!var32) {
                  break label91;
               }
            }

            if(this.g == 1) {
               y.d.t var5 = this.c(var1, var3);
               var1 = var5.a;
               var3 = var5.b;
            }

            bu var33 = this.getGraph2D();
            double var6 = var1 - this.a;
            double var8 = var3 - this.b;
            double var10 = var6 > 0.0D?1.0D:-1.0D;
            double var12 = var8 > 0.0D?1.0D:-1.0D;
            switch(this.c) {
            case 0:
               var6 = -var6;
               var8 = -var8;
               if(!var32) {
                  break;
               }
            case 6:
               var6 = -var6;
               var8 = 0.0D;
               var12 = 0.0D;
               if(!var32) {
                  break;
               }
            case 3:
               var6 = -var6;
               if(!var32) {
                  break;
               }
            case 1:
               var6 = 0.0D;
               var10 = 0.0D;
               var8 = -var8;
               if(!var32) {
                  break;
               }
            case 4:
               var6 = 0.0D;
               var10 = 0.0D;
               if(!var32) {
                  break;
               }
            case 2:
               var8 = -var8;
               if(!var32) {
                  break;
               }
            case 7:
               var8 = 0.0D;
               var12 = 0.0D;
            case 5:
            }

            y.c.x var14 = var33.J();

            while(var14.f()) {
               fj var15 = var33.t(var14.e());
               double var16 = var15.getWidth();
               double var18 = var15.getHeight();
               if(var32) {
                  return;
               }

               double var20 = var16 + var6 < 1.0D?1.0D:var16 + var6;
               double var22 = var18 + var8 < 1.0D?1.0D:var18 + var8;
               double var24 = Math.abs(var20 - var15.getWidth()) * var10 / 2.0D;
               double var26 = Math.abs(var22 - var15.getHeight()) * var12 / 2.0D;
               this.a(var15, var15.getX() + var24 + (var16 - var20) / 2.0D, var15.getY() + var26 + (var18 - var22) / 2.0D, var20, var22);
               double var28 = var15.getWidth();
               double var30 = var15.getHeight();
               this.a(var33, var14.e(), var16, var18, var28, var30);
               if(var14.e() == this.e) {
                  this.a = var1;
                  this.b = var3;
                  if(this.g == 2) {
                     if(var16 > 1.0D && var20 <= 1.0D) {
                        this.c = this.h();
                        this.b(this.c);
                     }

                     if(var18 > 1.0D && var22 <= 1.0D) {
                        this.c = this.i();
                        this.b(this.c);
                     }
                  }
               }

               var14.g();
               if(var32) {
                  break;
               }
            }
         }

         this.view.updateView();
      }
   }

   private void b(double var1, double var3) {
      boolean var5;
      boolean var6;
      boolean var45;
      label240: {
         var45 = fj.z;
         var5 = this.isModifierPressed(this.lastDragEvent);
         var6 = this.b(this.lastDragEvent);
         if(this.e() && !this.a(this.lastDragEvent)) {
            y.d.t var7 = this.c().a(new y.d.t(var1, var3), this.c, var5, var6);
            var1 = var7.a;
            var3 = var7.b;
            if(!var45) {
               break label240;
            }
         }

         this.c().h();
      }

      double var46 = var1 - this.o.a;
      double var9 = var3 - this.o.b;
      bu var11 = this.getGraph2D();
      y.c.x var12 = var11.J();

      while(var12.f()) {
         fj var13 = var11.t(var12.e());
         double var14 = var13.getWidth();
         double var16 = var13.getHeight();
         y.d.q var18 = new y.d.q(1.0D, 1.0D);
         y.d.q var19 = new y.d.q(java.lang.Double.MAX_VALUE, java.lang.Double.MAX_VALUE);
         gt var20 = var13.getSizeConstraintProvider();
         if(var20 != null) {
            var18 = var20.getMinimumSize() != null?var20.getMinimumSize():var18;
            var19 = var20.getMaximumSize() != null?var20.getMaximumSize():var19;
         }

         double[] var21 = new double[]{0.0D, 0.0D, 0.0D, 0.0D};
         if(var12.e().d() < this.n.length) {
            Double var22 = this.n[var12.e().d()];
            if(var22 != null) {
               double var23 = var22.getWidth() / var22.getHeight();
               if(var5) {
                  var18 = this.b(var23, var18);
                  var19 = this.a(var23, var19);
               }

               switch(this.c) {
               case 0:
                  if(var5) {
                     if(var23 * var9 < var46) {
                        if(var6) {
                           this.a(var23 * var9, var21, var18, var19, var22, true);
                           this.b(var9, var21, var18, var19, var22, true);
                           if(!var45) {
                              break;
                           }
                        }

                        this.a(var23 * var9, var21, var18, var19, var22, false);
                        this.b(var9, var21, var18, var19, var22, false);
                        if(!var45) {
                           break;
                        }
                     }

                     if(var6) {
                        this.a(var46, var21, var18, var19, var22, true);
                        this.b(var46 / var23, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.a(var46, var21, var18, var19, var22, false);
                     this.b(var46 / var23, var21, var18, var19, var22, false);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.a(var46, var21, var18, var19, var22, true);
                     this.b(var9, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.a(var46, var21, var18, var19, var22, false);
                  this.b(var9, var21, var18, var19, var22, false);
                  if(!var45) {
                     break;
                  }
               case 1:
                  if(var5) {
                     if(var6) {
                        this.a(var23 * var9, var21, var18, var19, var22, true);
                        this.b(var9, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.a(var23 * var9 * 0.5D, var21, var18, var19, var22, true);
                     this.b(var9, var21, var18, var19, var22, false);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.b(var9, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.b(var9, var21, var18, var19, var22, false);
                  if(!var45) {
                     break;
                  }
               case 2:
                  if(var5) {
                     if(-var23 * var9 > var46) {
                        if(var6) {
                           this.a(var23 * var9, var21, var18, var19, var22, true);
                           this.b(var9, var21, var18, var19, var22, true);
                           if(!var45) {
                              break;
                           }
                        }

                        this.b(-var23 * var9, var21, var18, var19, var22);
                        this.b(var9, var21, var18, var19, var22, false);
                        if(!var45) {
                           break;
                        }
                     }

                     if(var6) {
                        this.a(-var46, var21, var18, var19, var22, true);
                        this.b(-var46 / var23, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.b(var46, var21, var18, var19, var22);
                     this.b(-var46 / var23, var21, var18, var19, var22, false);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.a(-var46, var21, var18, var19, var22, true);
                     this.b(var9, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.b(var46, var21, var18, var19, var22);
                  this.b(var9, var21, var18, var19, var22, false);
                  if(!var45) {
                     break;
                  }
               case 6:
                  if(var5) {
                     if(var6) {
                        this.a(var46, var21, var18, var19, var22, true);
                        this.b(var46 / var23, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.a(var46, var21, var18, var19, var22, false);
                     this.b(var46 / var23 * 0.5D, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.a(var46, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.a(var46, var21, var18, var19, var22, false);
                  if(!var45) {
                     break;
                  }
               case 7:
                  if(var5) {
                     if(var6) {
                        this.a(-var46, var21, var18, var19, var22, true);
                        this.b(-var46 / var23, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.b(var46, var21, var18, var19, var22);
                     this.b(-var46 / var23 * 0.5D, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.a(-var46, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.b(var46, var21, var18, var19, var22);
                  if(!var45) {
                     break;
                  }
               case 3:
                  if(var5) {
                     if(-var23 * var9 < var46) {
                        if(var6) {
                           this.a(-var23 * var9, var21, var18, var19, var22, true);
                           this.b(-var9, var21, var18, var19, var22, true);
                           if(!var45) {
                              break;
                           }
                        }

                        this.a(-var23 * var9, var21, var18, var19, var22, false);
                        this.a(var9, var21, var18, var19, var22);
                        if(!var45) {
                           break;
                        }
                     }

                     if(var6) {
                        this.a(var46, var21, var18, var19, var22, true);
                        this.b(var46 / var23, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.a(var46, var21, var18, var19, var22, false);
                     this.a(-var46 / var23, var21, var18, var19, var22);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.a(var46, var21, var18, var19, var22, true);
                     this.b(-var9, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.a(var46, var21, var18, var19, var22, false);
                  this.a(var9, var21, var18, var19, var22);
                  if(!var45) {
                     break;
                  }
               case 4:
                  if(var5) {
                     if(var6) {
                        this.a(-var23 * var9, var21, var18, var19, var22, true);
                        this.b(-var9, var21, var18, var19, var22, true);
                        if(!var45) {
                           break;
                        }
                     }

                     this.a(-var23 * var9 * 0.5D, var21, var18, var19, var22, true);
                     this.a(var9, var21, var18, var19, var22);
                     if(!var45) {
                        break;
                     }
                  }

                  if(var6) {
                     this.b(-var9, var21, var18, var19, var22, true);
                     if(!var45) {
                        break;
                     }
                  }

                  this.a(var9, var21, var18, var19, var22);
                  if(!var45) {
                     break;
                  }
               case 5:
                  label246: {
                     if(var5) {
                        if(var23 * var9 > var46) {
                           if(var6) {
                              this.a(-var23 * var9, var21, var18, var19, var22, true);
                              this.b(-var9, var21, var18, var19, var22, true);
                              if(!var45) {
                                 break label246;
                              }
                           }

                           this.b(var23 * var9, var21, var18, var19, var22);
                           this.a(var9, var21, var18, var19, var22);
                           if(!var45) {
                              break label246;
                           }
                        }

                        if(var6) {
                           this.a(-var46, var21, var18, var19, var22, true);
                           this.b(-var46 / var23, var21, var18, var19, var22, true);
                           if(!var45) {
                              break label246;
                           }
                        }

                        this.b(var46, var21, var18, var19, var22);
                        this.a(var46 / var23, var21, var18, var19, var22);
                        if(!var45) {
                           break label246;
                        }
                     }

                     if(var6) {
                        this.a(-var46, var21, var18, var19, var22, true);
                        this.b(-var9, var21, var18, var19, var22, true);
                        if(!var45) {
                           break label246;
                        }
                     }

                     this.b(var46, var21, var18, var19, var22);
                     this.a(var9, var21, var18, var19, var22);
                  }
               }

               double var25 = var21[0];
               double var27 = var21[1];
               double var29 = var21[2];
               double var31 = var21[3];
               double var33 = var22.getX() + var29;
               double var35 = var22.getY() + var31;
               double var37 = var22.getWidth() + var25;
               double var39 = var22.getHeight() + var27;
               if(var33 != var13.getX() || var37 != var13.getWidth() || var35 != var13.getY() || var39 != var13.getHeight()) {
                  this.a(var13, var33, var35, var37, var39);
                  double var41 = var13.getWidth();
                  double var43 = var13.getHeight();
                  this.a(var11, var12.e(), var14, var16, var41, var43);
               }
            }
         }

         var12.g();
         if(var45) {
            break;
         }
      }

   }

   private y.d.q a(double var1, y.d.q var3) {
      double var4 = var3.a();
      double var6 = var3.b();
      double var8 = var3.a() / var3.b();
      if(var1 > var8) {
         var6 = var3.a() / var1;
         if(!fj.z) {
            return new y.d.q(var4, var6);
         }
      }

      var4 = var3.b() * var1;
      return new y.d.q(var4, var6);
   }

   private y.d.q b(double var1, y.d.q var3) {
      double var4 = var3.a();
      double var6 = var3.b();
      double var8 = var3.a() / var3.b();
      if(var1 < var8) {
         var6 = var3.a() / var1;
         if(!fj.z) {
            return new y.d.q(var4, var6);
         }
      }

      var4 = var3.b() * var1;
      return new y.d.q(var4, var6);
   }

   protected boolean isModifierPressed(MouseEvent var1) {
      return (var1.getModifiers() & this.getModifierMask()) != 0;
   }

   protected boolean b(MouseEvent var1) {
      return (var1.getModifiers() & this.g()) != 0;
   }

   public int g() {
      return this.p;
   }

   private void a(double var1, double[] var3, y.d.q var4, y.d.q var5, Double var6) {
      boolean var9 = fj.z;
      double var7;
      if(var1 < 0.0D) {
         var7 = var4.b();
         if(var7 >= 0.0D && var6.getHeight() + var1 < var7) {
            var3[1] = var7 - var6.getHeight();
            if(!var9) {
               return;
            }
         }

         var3[1] = var1;
         if(!var9) {
            return;
         }
      }

      if(var1 > 0.0D) {
         var7 = var5.b();
         if(var7 < java.lang.Double.MAX_VALUE && var6.getHeight() + var1 > var7) {
            var3[1] = var7 - var6.getHeight();
            if(!var9) {
               return;
            }
         }

         var3[1] = var1;
      }

   }

   private void b(double var1, double[] var3, y.d.q var4, y.d.q var5, Double var6) {
      boolean var9 = fj.z;
      double var7;
      if(var1 < 0.0D) {
         var7 = var4.a();
         if(var7 >= 0.0D && var6.getWidth() + var1 < var7) {
            var3[0] = var7 - var6.getWidth();
            if(!var9) {
               return;
            }
         }

         var3[0] = var1;
         if(!var9) {
            return;
         }
      }

      if(var1 > 0.0D) {
         var7 = var5.a();
         if(var7 < java.lang.Double.MAX_VALUE && var6.getWidth() + var1 > var7) {
            var3[0] = var7 - var6.getWidth();
            if(!var9) {
               return;
            }
         }

         var3[0] = var1;
      }

   }

   private void a(double var1, double[] var3, y.d.q var4, y.d.q var5, Double var6, boolean var7) {
      boolean var12 = fj.z;
      double var8 = var7?2.0D:1.0D;
      double var10;
      if(var1 > 0.0D) {
         var10 = var4.a();
         if(var10 >= 0.0D && var6.getWidth() - var1 * var8 < var10) {
            var3[0] = var10 - var6.getWidth();
            var3[2] = -var3[0] / var8;
            if(!var12) {
               return;
            }
         }

         var3[0] = -var1 * var8;
         var3[2] = var1;
         if(!var12) {
            return;
         }
      }

      if(var1 < 0.0D) {
         var10 = var5.a();
         if(var10 < java.lang.Double.MAX_VALUE && var6.getWidth() - var1 * var8 > var10) {
            var3[0] = var10 - var6.getWidth();
            var3[2] = -var3[0] / var8;
            if(!var12) {
               return;
            }
         }

         var3[2] = var1;
         var3[0] = -var1 * var8;
      }

   }

   private void b(double var1, double[] var3, y.d.q var4, y.d.q var5, Double var6, boolean var7) {
      boolean var12 = fj.z;
      double var8 = var7?2.0D:1.0D;
      double var10;
      if(var1 > 0.0D) {
         var10 = var4.b();
         if(var10 >= 0.0D && var6.getHeight() - var1 * var8 < var10) {
            var3[1] = var10 - var6.getHeight();
            var3[3] = -var3[1] / var8;
            if(!var12) {
               return;
            }
         }

         var3[1] = -var1 * var8;
         var3[3] = var1;
         if(!var12) {
            return;
         }
      }

      if(var1 < 0.0D) {
         var10 = var5.b();
         if(var10 < java.lang.Double.MAX_VALUE && var6.getHeight() - var1 * var8 > var10) {
            var3[1] = var10 - var6.getHeight();
            var3[3] = -var3[1] / var8;
            if(!var12) {
               return;
            }
         }

         var3[3] = var1;
         var3[1] = -var1 * var8;
      }

   }

   protected void a(bu var1, y.c.q var2, double var3, double var5, double var7, double var9) {
      double var11 = var3 > 0.0D?var7 / var3:1.0D;
      double var13 = var5 > 0.0D?var9 / var5:1.0D;
      this.a(var1, var2, var11, var13, false);
   }

   private void a(bu var1, y.c.q var2, double var3, double var5, boolean var7) {
      boolean var16 = fj.z;
      fj var8 = var1.t(var2);
      y.c.d var9 = var2.f();

      aB var10;
      fL var11;
      double var12;
      double var14;
      eU var10000;
      while(true) {
         if(var9 != null) {
            var10 = var1.i(var9);
            var11 = var10.getSourcePort();
            var10000 = var8.b(var10.vb);
            if(var16) {
               break;
            }

            if(var10000 == null) {
               var12 = var11.g() * var3;
               var14 = var11.h() * var5;
               var11.b(var12, var14);
            }

            if(this.l.contains(var9)) {
               ic.a(this.view, var10, var11.a(var8), var11.b(var8), true);
               if(var7) {
                  fu.a(var10);
               }
            }

            var9 = var9.g();
            if(!var16) {
               continue;
            }

            var9 = var2.g();
         } else {
            var9 = var2.g();
         }

         if(var9 == null) {
            return;
         }

         var10 = var1.i(var9);
         var11 = var10.getTargetPort();
         var10000 = var8.b(var10.zb);
         break;
      }

      while(true) {
         if(var10000 == null) {
            var12 = var11.g() * var3;
            var14 = var11.h() * var5;
            var11.b(var12, var14);
         }

         if(this.l.contains(var9)) {
            ic.a(this.view, var10, var11.a(var8), var11.b(var8), false);
            if(var7) {
               fu.a(var10);
            }
         }

         var9 = var9.h();
         if(var16 || var9 == null) {
            return;
         }

         var10 = var1.i(var9);
         var11 = var10.getTargetPort();
         var10000 = var8.b(var10.zb);
      }
   }

   byte h() {
      switch(this.c) {
      case 0:
         return (byte)2;
      case 1:
      case 4:
      default:
         return this.c;
      case 2:
         return (byte)0;
      case 3:
         return (byte)5;
      case 5:
         return (byte)3;
      case 6:
         return (byte)7;
      case 7:
         return (byte)6;
      }
   }

   byte i() {
      switch(this.c) {
      case 0:
         return (byte)3;
      case 1:
         return (byte)4;
      case 2:
         return (byte)5;
      case 3:
         return (byte)0;
      case 4:
         return (byte)1;
      case 5:
         return (byte)2;
      default:
         return this.c;
      }
   }

   protected void a(fj var1, double var2, double var4, double var6, double var8) {
      boolean var25 = fj.z;
      if(var1.getSizeConstraintProvider() != null) {
         gt var10 = var1.getSizeConstraintProvider();
         y.d.q var11 = var10.getMinimumSize();
         if(var6 < var11.a()) {
            var6 = var11.a();
            if(var2 != var1.getX()) {
               var2 = var1.getX() + var1.getWidth() - var6;
            }
         }

         if(var8 < var11.b()) {
            var8 = var11.b();
            if(var4 != var1.getY()) {
               var4 = var1.getY() + var1.getHeight() - var8;
            }
         }

         y.d.q var12 = var10.getMaximumSize();
         if(var6 > var12.a()) {
            var6 = var12.a();
            if(var2 != var1.getX()) {
               var2 = var1.getX() + var1.getWidth() - var6;
            }
         }

         if(var8 > var12.b()) {
            var8 = var12.b();
            if(var4 != var1.getY()) {
               var4 = var1.getY() + var1.getHeight() - var8;
            }
         }
      }

      double var17;
      double var19;
      y.h.a.v var26;
      label68: {
         var26 = y.h.a.v.a((y.c.i)this.view.getGraph2D());
         if(var26 != null && var1.getAutoBoundsFeature() != null) {
            y.h.a.a var27 = var1.getAutoBoundsFeature();
            if(var27.isAutoBoundsEnabled() && var1.getNode() != null && var26.p(var1.getNode()).f()) {
               Rectangle2D var29 = var27.getMinimalAutoBounds();
               double var13 = Math.max(0.0D, var29.getX() - var2);
               double var15 = Math.max(0.0D, var29.getY() - var4);
               var17 = Math.max(0.0D, var2 + var6 - var29.getMaxX());
               var19 = Math.max(0.0D, var4 + var8 - var29.getMaxY());
               var27.setAutoBoundsInsets(new y.d.r(var15, var13, var19, var17));
               if(!var25) {
                  break label68;
               }
            }

            var1.setFrame(var2, var4, var6, var8);
            if(!var25) {
               break label68;
            }
         }

         var1.setFrame(var2, var4, var6, var8);
      }

      if(var26 != null && this.j != null && this.l() == 1) {
         y.c.q var28 = var1.getNode();
         bu var30 = this.getGraph2D();

         while((var28 = var26.n(var28)) != null && var30.f(var28)) {
            fj var31 = var30.t(var28);
            y.h.a.a var14 = var31.getAutoBoundsFeature();
            if(var14 != null) {
               Rectangle2D var32 = (Rectangle2D)this.j.get(var28);
               Rectangle2D var16 = var14.getMinimalAutoBounds();
               var17 = Math.max(0.0D, var16.getX() - var32.getX());
               var19 = Math.max(0.0D, var16.getY() - var32.getY());
               double var21 = Math.max(0.0D, var32.getMaxX() - var16.getMaxX());
               double var23 = Math.max(0.0D, var32.getMaxY() - var16.getMaxY());
               var14.setAutoBoundsInsets(new y.d.r(var19, var17, var23, var21));
               if(var25) {
                  break;
               }
            }
         }
      }

   }

   public void mouseReleasedLeft(double var1, double var3) {
      this.c().f();
      if(this.d) {
         this.d = false;
         this.k();
         this.m();
         this.view.updateWorldRect();
         this.view.setDrawingMode(0);
         this.getGraph2D().T();
         this.setEditing(false);
         this.reactivateParent();
         if(!fj.z) {
            return;
         }
      }

      if(this.s) {
         this.s = false;
         this.reactivateParent();
      }

   }

   private void m() {
      boolean var3 = fj.z;
      if(this.k) {
         HashSet var1 = new HashSet();
         y.c.x var2 = this.getGraph2D().J();

         while(var2.f()) {
            var1.addAll(new y.c.f(var2.e().j()));
            var2.g();
            if(var3) {
               return;
            }

            if(var3) {
               break;
            }
         }

         fu.a((bu)this.getGraph2D(), (Collection)var1);
      }

   }

   public void activate(boolean var1) {
      label11: {
         if(var1) {
            this.s = false;
            this.c().a(this.view);
            if(!fj.z) {
               break label11;
            }
         }

         this.c().f();
      }

      super.activate(var1);
   }

   public void reactivateParent() {
      this.c().f();
      if(this.q != null) {
         this.view.getCanvasComponent().removeKeyListener(this.q);
         this.q = null;
      }

      this.d = false;
      this.n = null;
      this.l = Collections.EMPTY_SET;
      this.o = null;
      this.setEditing(false);
      super.reactivateParent();
   }

   protected void j() {
      boolean var5;
      label29: {
         var5 = fj.z;
         bu var1 = this.view.getGraph2D();
         if(this.n != null) {
            y.c.x var2 = var1.J();

            while(var2.f()) {
               y.c.q var3 = var2.e();
               Double var4 = this.n[var3.d()];
               this.a(var1.t(var3), var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
               var2.g();
               if(var5) {
                  break label29;
               }

               if(var5) {
                  break;
               }
            }
         }

         this.view.setDrawingMode(0);
         this.view.updateView();
      }

      if(this.d) {
         this.d = false;
         this.s = true;
         if(!var5) {
            return;
         }
      }

      this.setEditing(false);
      this.reactivateParent();
   }

   void k() {
      boolean var13 = fj.z;
      bu var1 = this.getGraph2D();
      y.c.x var2 = var1.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         if(var1.v(var3)) {
            fj var4 = var1.t(var3);
            double var5 = var4.getCenterX();
            double var7 = var4.getCenterY();
            double var9 = this.getGridX(var5);
            double var11 = this.getGridY(var7);
            var4.setCenter(var9, var11);
            this.a(var1, var3, 1.0D, 1.0D, true);
         }

         var2.g();
         if(var13) {
            break;
         }
      }

   }

   public static Cursor a(byte var0) {
      switch(var0) {
      case 0:
         return Cursor.getPredefinedCursor(6);
      case 1:
         return Cursor.getPredefinedCursor(8);
      case 2:
         return Cursor.getPredefinedCursor(7);
      case 3:
         return Cursor.getPredefinedCursor(4);
      case 4:
         return Cursor.getPredefinedCursor(9);
      case 5:
         return Cursor.getPredefinedCursor(5);
      case 6:
         return Cursor.getPredefinedCursor(10);
      case 7:
         return Cursor.getPredefinedCursor(11);
      default:
         return Cursor.getPredefinedCursor(0);
      }
   }

   private void b(byte var1) {
      this.view.setViewCursor(a(var1));
   }

   private y.d.t c(double var1, double var3) {
      boolean var22 = fj.z;
      bu var5 = this.view.getGraph2D();
      double var6 = var5.m(this.e);
      double var8 = var5.n(this.e);
      double var10 = var6 + var5.p(this.e);
      double var12 = var8 + var5.q(this.e);
      double var14 = this.f.a;
      double var16 = this.f.b;
      double var18 = var1;
      double var20 = var3;
      switch(this.c) {
      case 2:
      case 5:
      case 7:
         label55: {
            if(var1 < var6 + var14) {
               var18 = var6 + var14;
               if(!var22) {
                  break label55;
               }
            }

            if(var18 < var10 + var14 && this.a <= var1) {
               this.a = var18;
            }
         }
      default:
         switch(this.c) {
         case 0:
         case 3:
         case 6:
            label50: {
               if(var18 > var10 - var14) {
                  var18 = var10 - var14;
                  if(!var22) {
                     break label50;
                  }
               }

               if(var18 > var6 - var14 && this.a >= var1) {
                  this.a = var18;
               }
            }
         default:
            switch(this.c) {
            case 0:
            case 1:
            case 2:
               label45: {
                  if(var3 > var12 - var16) {
                     var20 = var12 - var16;
                     if(!var22) {
                        break label45;
                     }
                  }

                  if(var20 > var8 - var16 && this.b >= var3) {
                     this.b = var20;
                  }
               }
            default:
               switch(this.c) {
               case 3:
               case 4:
               case 5:
                  if(var20 < var8 + var16) {
                     var20 = var8 + var16;
                     if(!var22) {
                        return new y.d.t(var18, var20);
                     }
                  }

                  if(var20 < var12 + var16 && this.b <= var3) {
                     this.b = var20;
                  }
               default:
                  return new y.d.t(var18, var20);
               }
            }
         }
      }
   }

   y.d.t a(double var1, double var3) {
      bu var5 = this.view.getGraph2D();
      double var6 = var5.m(this.e);
      double var8 = var5.n(this.e);
      double var10 = var6 + var5.p(this.e);
      double var12 = var8 + var5.q(this.e);
      double var14 = 0.0D;
      double var16 = 0.0D;
      switch(this.c) {
      case 2:
      case 5:
      case 7:
         var14 = var1 - var10;
      default:
         switch(this.c) {
         case 0:
         case 3:
         case 6:
            var14 = var6 - var1;
         default:
            switch(this.c) {
            case 0:
            case 1:
            case 2:
               var16 = var8 - var3;
            default:
               switch(this.c) {
               case 3:
               case 4:
               case 5:
                  var16 = var3 - var12;
               default:
                  return new y.d.t(var14, var16);
               }
            }
         }
      }
   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.j();
      }

   }

   public byte l() {
      return this.i;
   }

   static int a(da var0) {
      return var0.r;
   }

   static KeyListener a(da var0, KeyListener var1) {
      return var0.q = var1;
   }
}
