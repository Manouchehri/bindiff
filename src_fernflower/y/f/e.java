package y.f;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.a;
import y.f.ae;
import y.f.am;
import y.f.f;
import y.f.g;
import y.f.h;
import y.f.i;
import y.f.j;
import y.f.k;
import y.f.w;

public class e extends a {
   public static final Object a = "y.layout.ComponentLayouter.LAYOUT_NODE_DPKEY";
   public static final Object b = "y.layout.ComponentLayouter.GIVEN_COMPONENT_ID_DPKEY";
   private double c;
   private double d;
   private double e;
   private double f = 45.0D;
   private boolean g = true;
   private boolean h = true;
   private byte i = 1;
   private boolean n = true;
   private k[] o;

   public e() {
      this.a(400.0D, 400.0D);
   }

   public void a(double var1, double var3) {
      this.c = var1;
      this.d = var3;
   }

   protected int a(X var1, y.c.A var2) {
      boolean var14 = X.j;
      y.c.c var3 = var1.c(b);
      if(var3 == null) {
         return this.b(var1, var2);
      } else {
         ArrayList var4 = new ArrayList();
         HashMap var5 = new HashMap();
         var5.put((Object)null, new ArrayList());
         y.c.x var6 = var1.o();

         Object var10000;
         while(true) {
            if(var6.f()) {
               y.c.q var7 = var6.e();
               Object var8 = var3.b(var7);
               Object var9 = (List)var5.get(var8);
               var10000 = var9;
               if(var14) {
                  break;
               }

               if(var9 == null) {
                  var9 = new ArrayList();
                  var5.put(var8, var9);
                  var4.add(var8);
               }

               ((List)var9).add(var7);
               var6.g();
               if(!var14) {
                  continue;
               }
            }

            var10000 = (List)var5.get((Object)null);
            break;
         }

         Object var15 = var10000;
         var5.remove((Object)null);
         int var16;
         if(((List)var15).size() == 0) {
            if(var5.size() < 2) {
               y.c.x var17 = var1.o();

               while(var17.f()) {
                  y.c.q var20 = var17.e();
                  var2.a(var20, 0);
                  var17.g();
                  if(var14) {
                     break;
                  }
               }

               return 1;
            } else {
               y.g.e.a((List)var4, (Comparator)null);
               var16 = 0;

               while(var16 < var4.size()) {
                  List var19 = (List)var5.get(var4.get(var16));
                  Iterator var27 = var19.iterator();

                  while(true) {
                     if(var27.hasNext()) {
                        y.c.q var28 = (y.c.q)var27.next();
                        var2.a(var28, var16);
                        if(var14) {
                           break;
                        }

                        if(!var14) {
                           continue;
                        }
                     }

                     ++var16;
                     break;
                  }

                  if(var14) {
                     break;
                  }
               }

               return var4.size();
            }
         } else if(var5.isEmpty()) {
            return this.b(var1, var2);
         } else {
            var16 = this.b(var1, var2);
            int[] var18 = new int[var16];
            int var21 = 0;

            while(true) {
               if(var21 < var18.length) {
                  var18[var21] = -1;
                  ++var21;
                  if(var14) {
                     break;
                  }

                  if(!var14) {
                     continue;
                  }
               }

               var21 = 0;
               break;
            }

            while(true) {
               if(var21 < var4.size()) {
                  List var10 = (List)var5.get(var4.get(var21));
                  if(var14) {
                     break;
                  }

                  Iterator var11 = var10.iterator();

                  label146: {
                     while(var11.hasNext()) {
                        y.c.q var12 = (y.c.q)var11.next();
                        var18[var2.a(var12)] = var21;
                        if(var14) {
                           break label146;
                        }

                        if(var14) {
                           break;
                        }
                     }

                     ++var21;
                  }

                  if(!var14) {
                     continue;
                  }
               }

               var21 = var4.size();
               break;
            }

            int var22 = 0;

            int var29;
            while(true) {
               if(var22 < var18.length) {
                  var29 = var18[var22];
                  if(var14) {
                     break;
                  }

                  if(var29 < 0) {
                     var18[var22] = var21++;
                  }

                  ++var22;
                  if(!var14) {
                     continue;
                  }
               }

               Iterator var23 = ((List)var15).iterator();

               while(var23.hasNext()) {
                  y.c.q var24 = (y.c.q)var23.next();
                  var2.a(var24, var18[var2.a(var24)]);
                  if(var14) {
                     break;
                  }
               }

               var22 = 0;
               var29 = var22;
               break;
            }

            while(var29 < var4.size()) {
               List var25 = (List)var5.get(var4.get(var22));
               Iterator var26 = var25.iterator();

               while(true) {
                  if(!var26.hasNext()) {
                     ++var22;
                     break;
                  }

                  y.c.q var13 = (y.c.q)var26.next();
                  var2.a(var13, var22);
                  if(var14) {
                     break;
                  }

                  if(var14) {
                     ++var22;
                     break;
                  }
               }

               if(var14) {
                  break;
               }

               var29 = var22;
            }

            return var21;
         }
      }
   }

   private int b(X var1, y.c.A var2) {
      boolean var11 = X.j;
      if(this.e() && y.f.b.c.b((y.c.i)var1)) {
         y.c.c var3 = var1.c(y.f.b.f.b);
         y.c.c var4 = var1.c(y.f.b.f.c);
         HashMap var5 = new HashMap();
         y.c.x var6 = var1.o();

         while(var6.f()) {
            var5.put(var3.b(var6.e()), var6.e());
            var6.g();
            if(var11) {
               break;
            }
         }

         y.c.f var12 = new y.c.f();
         y.c.x var7 = var1.o();

         while(var7.f()) {
            y.c.q var8 = var7.e();
            Object var9 = var4.b(var8);
            if(var9 != null) {
               y.c.q var10 = (y.c.q)var5.get(var9);
               if(var10 != null) {
                  var12.c(var1.a((y.c.q)var8, (y.c.q)var10));
               }
            }

            var7.g();
            if(var11) {
               break;
            }
         }

         int var13 = y.a.h.a(var1, (y.c.A)var2);

         while(var12.size() > 0) {
            var1.a((y.c.d)var12.d());
            if(var11) {
               break;
            }
         }

         return var13;
      } else {
         return y.a.h.a(var1, (y.c.A)var2);
      }
   }

   public void c(X var1) {
      boolean var15 = X.j;
      if(!var1.i()) {
         y.c.A var2 = var1.t();

         try {
            y.g.I var3 = new y.g.I(var1);
            y.c.c var4 = var1.c(b);
            if(var4 != null) {
               this.a(var3, var1, var4);
            }

            int var5 = this.a(var1, var2);
            this.o = new k[var5];
            y.c.c var6 = var1.c(a);
            int var7 = 0;

            y.c.c var32;
            label656: {
               label655: {
                  e var34;
                  label654: {
                     y.c.x var22;
                     label653:
                     while(true) {
                        if(var7 < var5) {
                           this.o[var7] = new k();
                           k var10000 = this.o[var7];
                           if(var15) {
                              var22 = var10000.a.a();
                              break;
                           }

                           var10000.i = var6 == null;
                           ++var7;
                           if(!var15) {
                              continue;
                           }
                        }

                        y.c.e var18 = var1.p();

                        while(var18.f()) {
                           y.c.d var8 = var18.a();
                           this.o[var2.a(var8.c())].b.add(var8);
                           var1.d(var8);
                           var18.g();
                           if(var15) {
                              break label655;
                           }

                           if(var15) {
                              break;
                           }
                        }

                        y.c.x var19 = var1.o();

                        while(var19.f()) {
                           y.c.q var20 = var19.e();
                           var32 = var6;
                           if(var15) {
                              break label656;
                           }

                           if(var6 != null && var6.d(var20)) {
                              this.o[var2.a(var20)].i = true;
                           }

                           this.o[var2.a(var20)].a.add(var20);
                           var1.c(var19.e());
                           var19.g();
                           if(var15) {
                              break;
                           }
                        }

                        var7 = 0;

                        label646:
                        do {
                           k var21;
                           y.c.x var28;
                           label636:
                           while(true) {
                              label626:
                              while(true) {
                                 if(var7 >= var5) {
                                    var7 = 0;
                                    if(var7 >= var5) {
                                       var34 = this;
                                       break label654;
                                    }

                                    var34 = this;
                                    if(var15) {
                                       break label654;
                                    }

                                    var22 = this.o[var7].a.a();
                                    break label653;
                                 }

                                 var21 = this.o[var7];
                                 var21.e.x = 0.0D;
                                 var21.e.y = 0.0D;
                                 y.c.x var33 = var21.a.a();
                                 if(var15) {
                                    var22 = var33;
                                    break label653;
                                 }

                                 y.c.x var9 = var33;

                                 y.c.e var23;
                                 while(true) {
                                    if(!var9.f()) {
                                       var21.e.x /= (double)var21.a.size();
                                       var21.e.y /= (double)var21.a.size();
                                       var23 = var21.b.a();
                                       break;
                                    }

                                    var21.e.x += var1.j(var9.e());
                                    var21.e.y += var1.k(var9.e());
                                    var1.d(var9.e());
                                    var9.g();
                                    if(var15) {
                                       var23 = var21.b.a();
                                       break;
                                    }

                                    if(var15) {
                                       var21.e.x /= (double)var21.a.size();
                                       var21.e.y /= (double)var21.a.size();
                                       var23 = var21.b.a();
                                       break;
                                    }
                                 }

                                 while(true) {
                                    if(!var23.f()) {
                                       break label626;
                                    }

                                    var1.e(var23.a());
                                    var23.g();
                                    if(var15) {
                                       break;
                                    }

                                    if(var15) {
                                       break label626;
                                    }
                                 }
                              }

                              Rectangle2D var26 = this.b(var1);
                              var21.f = new Double(var26.getX(), var26.getY(), var26.getWidth(), var26.getHeight());
                              if(var21.i) {
                                 this.a((X)var1);
                              }

                              var26 = this.b(var1);
                              var21.h = new y.d.y(var26.getX(), var26.getY(), var26.getWidth(), var26.getHeight());
                              var21.d = new Double(var26.getX(), var26.getY(), var26.getWidth(), var26.getHeight());
                              y.c.e var24;
                              if(this.e > 0.0D) {
                                 double var10 = this.f + (Math.ceil((var26.getWidth() + 1.0D) / this.e) + 1.0D) * this.e;
                                 double var12 = this.f + (Math.ceil((var26.getHeight() + 1.0D) / this.e) + 1.0D) * this.e;
                                 var21.g.setFrame(var26.getX(), var26.getY(), var10, var12);
                                 if(var15) {
                                    var21.g.setFrame(var26.getX(), var26.getY(), var26.getWidth() + this.f, var26.getHeight() + this.f);
                                    var24 = var21.b.a();
                                 } else {
                                    var24 = var21.b.a();
                                 }
                              } else {
                                 var21.g.setFrame(var26.getX(), var26.getY(), var26.getWidth() + this.f, var26.getHeight() + this.f);
                                 var24 = var21.b.a();
                              }

                              do {
                                 if(!var24.f()) {
                                    var28 = var21.a.a();
                                    break label636;
                                 }

                                 var1.d(var24.a());
                                 var24.g();
                                 if(var15) {
                                    continue label636;
                                 }
                              } while(!var15);

                              var28 = var21.a.a();
                              break;
                           }

                           do {
                              if(!var28.f()) {
                                 var21.c.x /= (double)var21.a.size();
                                 var21.c.y /= (double)var21.a.size();
                                 ++var7;
                                 continue label646;
                              }

                              var21.c.x += var1.j(var28.e());
                              var21.c.y += var1.k(var28.e());
                              var1.c(var28.e());
                              var28.g();
                              if(var15) {
                                 continue label646;
                              }
                           } while(!var15);

                           var21.c.x /= (double)var21.a.size();
                           var21.c.y /= (double)var21.a.size();
                           ++var7;
                        } while(!var15);

                        var7 = 0;
                        if(var7 >= var5) {
                           var34 = this;
                           break label654;
                        }

                        var34 = this;
                        if(var15) {
                           break label654;
                        }

                        var22 = this.o[var7].a.a();
                        break;
                     }

                     label603:
                     while(true) {
                        while(true) {
                           y.c.e var25;
                           if(var22.f()) {
                              var1.d(var22.e());
                              var22.g();
                              if(var15) {
                                 if(var7 >= var5) {
                                    var34 = this;
                                    break label603;
                                 }

                                 var34 = this;
                                 if(var15) {
                                    break label603;
                                 }

                                 var22 = this.o[var7].a.a();
                                 continue;
                              }

                              if(!var15) {
                                 continue;
                              }

                              var25 = this.o[var7].b.a();
                           } else {
                              var25 = this.o[var7].b.a();
                           }

                           while(true) {
                              if(var25.f()) {
                                 var1.e(var25.a());
                                 var25.g();
                                 if(!var15) {
                                    if(!var15) {
                                       continue;
                                    }

                                    ++var7;
                                    if(var15) {
                                       var34 = this;
                                       break label603;
                                    }
                                    break;
                                 }

                                 if(var15) {
                                    var34 = this;
                                    break label603;
                                 }
                                 break;
                              }

                              ++var7;
                              if(var15) {
                                 var34 = this;
                                 break label603;
                              }
                              break;
                           }

                           if(var7 >= var5) {
                              var34 = this;
                              break label603;
                           }

                           var34 = this;
                           if(var15) {
                              break label603;
                           }

                           var22 = this.o[var7].a.a();
                        }
                     }
                  }

                  if(var34.h) {
                     label684: {
                        y.c.y[] var30 = new y.c.y[var5];
                        y.c.f[] var29 = new y.c.f[var5];
                        y.d.y[] var27 = new y.d.y[var5];
                        Double[] var31 = new Double[var5];
                        int var11 = 0;

                        while(var11 < var5) {
                           var30[var11] = this.o[var11].a;
                           var29[var11] = this.o[var11].b;
                           var27[var11] = this.o[var11].h;
                           var31[var11] = this.o[var11].g;
                           ++var11;
                           if(var15) {
                              break label684;
                           }

                           if(var15) {
                              break;
                           }
                        }

                        this.a(var1, (y.c.y[])var30, (y.c.f[])var29, (y.d.y[])var27, (Rectangle2D[])var31);
                     }
                  }
               }

               var32 = var4;
            }

            if(var32 != null) {
               this.a(var3);
            }

            y.g.o.a(this, "done !");
         } finally {
            this.o = null;
            var1.a((y.c.A)var2);
         }

      }
   }

   protected Rectangle2D b(X var1) {
      return ae.a(var1, var1.o(), var1.p(), this.b());
   }

   public void a(boolean var1) {
      this.n = var1;
   }

   public boolean b() {
      return this.n;
   }

   protected void a(X var1, y.c.y[] var2, y.c.f[] var3, y.d.y[] var4, Rectangle2D[] var5) {
      boolean var16 = X.j;
      int var6 = this.f();
      if((var6 & 31) >= 4) {
         boolean var7 = (var6 & 32) == 32;
         switch(var6 & 31) {
         case 4:
         default:
            this.a(var1, var2, var3, var4, var5, false, true, var7);
            if(!var16) {
               return;
            }
         case 5:
            this.a(var1, var2, var3, var4, var5, false, false, var7);
            if(!var16) {
               return;
            }
         case 6:
            this.a(var1, var2, var3, var4, var5, true, true, var7);
            if(!var16) {
               return;
            }
         case 7:
            this.a(var1, var2, var3, var4, var5, true, false, var7);
            if(!var16) {
               return;
            }
         }
      }

      double var8;
      int var18;
      double var24;
      label148: {
         label161: {
            int var10;
            int var12;
            int var13;
            Integer[] var17;
            switch(var6 & 31) {
            case 0:
               break;
            case 1:
            default:
               ae.a(var5, (Rectangle2D)null, this.c / this.d);
               if(!var16) {
                  break label161;
               }
            case 2:
               var17 = new Integer[var2.length];
               var8 = -1.7976931348623157E308D;
               var10 = 0;

               label141: {
                  while(var10 < var17.length) {
                     var17[var10] = new Integer(var10);
                     var8 = Math.max(var8, this.o[var10].d.getHeight());
                     ++var10;
                     if(var16) {
                        break label141;
                     }

                     if(var16) {
                        break;
                     }
                  }

                  if((var6 & 32) == 32) {
                     y.g.e.a((Object[])var17, new f(this));
                  }
               }

               var24 = 0.0D;
               var12 = 0;

               do {
                  if(var12 >= var17.length) {
                     break label161;
                  }

                  var13 = var17[var12].intValue();
                  var5[var13].setFrame(var24, (var8 - var5[var13].getHeight()) * 0.5D, var5[var13].getWidth(), var5[var13].getHeight());
                  var24 += var5[var13].getWidth();
                  ++var12;
                  if(var16) {
                     break label148;
                  }
               } while(!var16);
            case 3:
               var17 = new Integer[var2.length];
               var8 = -1.7976931348623157E308D;
               var10 = 0;

               label124: {
                  while(var10 < var17.length) {
                     var17[var10] = new Integer(var10);
                     var8 = Math.max(var8, this.o[var10].d.getWidth());
                     ++var10;
                     if(var16) {
                        break label124;
                     }

                     if(var16) {
                        break;
                     }
                  }

                  if((var6 & 32) == 32) {
                     y.g.e.a((Object[])var17, new g(this));
                  }
               }

               var24 = 0.0D;
               var12 = 0;

               do {
                  if(var12 >= var17.length) {
                     break label161;
                  }

                  var13 = var17[var12].intValue();
                  var5[var13].setFrame((var8 - var5[var13].getWidth()) * 0.5D, var24, var5[var13].getWidth(), var5[var13].getHeight());
                  var24 += var5[var13].getHeight();
                  ++var12;
                  if(var16) {
                     break label148;
                  }
               } while(!var16);
            }

            var18 = 0;

            while(var18 < var5.length) {
               k var21 = this.o[var18];
               double var9 = var21.e.x - var21.c.x;
               double var11 = var21.e.y - var21.c.y;
               var5[var18].setRect(var5[var18].getX() + var9, var5[var18].getY() + var11, var5[var18].getWidth(), var5[var18].getHeight());
               ++var18;
               if(var16) {
                  break label161;
               }

               if(var16) {
                  break;
               }
            }

            if((var6 & 64) == 64) {
               label169: {
                  w var19 = new w();
                  y.c.q[] var23 = new y.c.q[this.o.length];
                  int var20 = 0;

                  while(var20 < this.o.length) {
                     var23[var20] = var19.d();
                     am var26 = var19.a((Object)var23[var20]);
                     var26.setSize(var5[var20].getWidth(), var5[var20].getHeight());
                     var26.setLocation(var5[var20].getX(), var5[var20].getY());
                     ++var20;
                     if(var16) {
                        break label169;
                     }

                     if(var16) {
                        break;
                     }
                  }

                  y.f.e.l var22 = new y.f.e.l();
                  var22.b(true);
                  var22.a(false);
                  var22.a(0.0D);
                  var22.a((byte)2);
                  var22.c(var19);
                  var10 = 0;

                  while(var10 < this.o.length) {
                     am var25 = var19.a((Object)var23[var10]);
                     var5[var10].setFrame(var25.getX(), var25.getY(), var25.getWidth(), var25.getHeight());
                     ++var10;
                     if(var16) {
                        break label148;
                     }

                     if(var16) {
                        break;
                     }
                  }
               }
            }
         }

         if(this.e <= 0.0D) {
            var18 = 0;

            do {
               if(var18 >= var5.length) {
                  return;
               }

               this.a(var1, var2[var18], var3[var18], new y.d.t(var5[var18].getX(), var5[var18].getY()), var4[var18]);
               ++var18;
            } while(!var16);
         }
      }

      var18 = 0;

      while(var18 < var5.length) {
         var8 = Math.floor((var5[var18].getX() - var4[var18].c()) / this.e) * this.e;
         var24 = Math.floor((var5[var18].getY() - var4[var18].d()) / this.e) * this.e;
         double var27 = var4[var18].c() + var8;
         double var14 = var4[var18].d() + var24;
         this.a(var1, var2[var18], var3[var18], new y.d.t(var27, var14), var4[var18]);
         ++var18;
         if(var16) {
            break;
         }
      }

   }

   protected void a(X var1, y.c.y var2, y.c.f var3, y.d.t var4, y.d.y var5) {
      boolean var15 = X.j;
      double var6 = -var5.c() + var4.a();
      double var8 = -var5.d() + var4.b();
      y.c.x var10 = var2.a();

      while(var10.f()) {
         y.d.t var11 = var1.o(var10.e());
         var1.b(var10.e(), new y.d.t(var11.a() + var6, var11.b() + var8));
         var10.g();
         if(var15) {
            break;
         }
      }

      y.c.e var16 = var3.a();

      while(true) {
         if(var16.f()) {
            y.c.d var17 = var16.a();
            ArrayList var12 = new ArrayList();
            if(var15) {
               break;
            }

            y.c.C var13 = var1.j(var17).a();

            label30: {
               while(var13.f()) {
                  y.d.t var14 = (y.d.t)var13.d();
                  var12.add(new y.d.t(var14.a() + var6, var14.b() + var8));
                  var13.g();
                  if(var15) {
                     break label30;
                  }

                  if(var15) {
                     break;
                  }
               }

               var1.b(var17, new y.d.v(var12));
               var16.g();
            }

            if(!var15) {
               continue;
            }
         }

         this.b(var1, var2, var3, var4, var5);
         break;
      }

   }

   private void a(y.g.I var1, X var2, y.c.c var3) {
      boolean var6 = X.j;
      y.c.e var4 = var2.p();

      while(var4.f()) {
         y.c.d var5 = var4.a();
         if(var3.b(var5.c()) != null && var3.b(var5.d()) != null && !var3.b(var5.c()).equals(var3.b(var5.d()))) {
            var1.a(var5);
         }

         var4.g();
         if(var6) {
            break;
         }
      }

   }

   private void a(y.g.I var1) {
      var1.f();
   }

   private void b(X var1, y.c.y var2, y.c.f var3, y.d.t var4, y.d.y var5) {
      boolean var14 = X.j;
      y.c.c var6 = var1.c(U.a);
      if(var6 != null) {
         double var7 = -var5.c() + var4.a();
         double var9 = -var5.d() + var4.b();
         y.c.e var11 = var3.a();

         while(var11.f()) {
            label28: {
               S[] var12 = (S[])var6.b(var11.a());
               if(var12 != null) {
                  int var13 = 0;

                  while(var13 < var12.length) {
                     var12[var13].a(var12[var13].d() + var7, var12[var13].e() + var9);
                     ++var13;
                     if(var14) {
                        break label28;
                     }

                     if(var14) {
                        break;
                     }
                  }
               }

               var11.g();
            }

            if(var14) {
               break;
            }
         }
      }

   }

   public double c() {
      return this.e;
   }

   public void a(double var1) {
      this.e = var1;
   }

   public double d() {
      return this.f;
   }

   public void b(double var1) {
      this.f = var1;
   }

   public boolean e() {
      return this.g;
   }

   public byte f() {
      return this.i;
   }

   public void a(byte var1) {
      this.i = var1;
   }

   private j a(X var1, y.c.y var2, y.c.f var3, double var4, double var6, boolean var8) {
      boolean var22 = X.j;
      int var9 = Integer.MAX_VALUE;
      int var10 = Integer.MIN_VALUE;
      int var11 = Integer.MAX_VALUE;
      int var12 = Integer.MIN_VALUE;
      y.c.c var13 = var1.c(U.a);
      Double var14 = new Double();
      double var15 = this.d() * 0.5D;
      y.c.x var17 = var2.a();

      while(var17.f()) {
         am var18 = var1.a((Object)var17.e());
         var14.setFrame(var18.getX() - var15, var18.getY() - var15, var18.getWidth() + var15 * 2.0D, var18.getHeight() + var15 * 2.0D);
         var9 = Math.min((int)Math.floor(var14.x / var4), var9);
         var11 = Math.min((int)Math.floor(var14.y / var6), var11);
         var10 = Math.max((int)Math.floor((var14.x + var14.width) / var4), var10);
         var12 = Math.max((int)Math.floor((var14.y + var14.height) / var6), var12);
         var17.g();
         if(var22) {
            break;
         }
      }

      y.c.e var23 = var3.a();

      Object var10000;
      label181: {
         label180: {
            label179:
            while(true) {
               if(var23.f()) {
                  y.d.v var24 = var1.l(var23.a());
                  var10000 = var24.b();
                  if(var22) {
                     break;
                  }

                  Object var19 = var10000;

                  while(true) {
                     if(!((y.d.u)var19).f()) {
                        var23.g();
                        if(!var22) {
                           continue label179;
                        }
                        break;
                     }

                     var9 = Math.min(var9, (int)Math.floor(((y.d.u)var19).a().a / var4));
                     var10 = Math.max(var10, (int)Math.floor(((y.d.u)var19).a().a / var4));
                     var11 = Math.min(var11, (int)Math.floor(((y.d.u)var19).a().b / var6));
                     var12 = Math.max(var12, (int)Math.floor(((y.d.u)var19).a().b / var6));
                     ((y.d.u)var19).g();
                     if(var22) {
                        if(!var22) {
                           continue label179;
                        }
                        break;
                     }

                     if(var22) {
                        var23.g();
                        if(!var22) {
                           continue label179;
                        }
                        break;
                     }
                  }
               }

               if(var13 == null) {
                  break label180;
               }

               var23 = var3.a();
               if(!var23.f()) {
                  break label180;
               }

               var10000 = var13.b(var23.a());
               break;
            }

            while(true) {
               S[] var25 = (S[])var10000;
               if(var22) {
                  break label181;
               }

               label144: {
                  if(var25 != null) {
                     int var28 = 0;

                     while(var28 < var25.length) {
                        S var20 = var25[var28];
                        var14.setFrame(var20.d() - var15, var20.e() - var15, var20.b() + var15 * 2.0D, var20.c() + var15 * 2.0D);
                        var9 = Math.min((int)Math.floor(var14.x / var4), var9);
                        var11 = Math.min((int)Math.floor(var14.y / var6), var11);
                        var10 = Math.max((int)Math.floor((var14.x + var14.width) / var4), var10);
                        var12 = Math.max((int)Math.floor((var14.y + var14.height) / var6), var12);
                        ++var28;
                        if(var22) {
                           break label144;
                        }

                        if(var22) {
                           break;
                        }
                     }
                  }

                  var23.g();
               }

               if(var22 || !var23.f()) {
                  break;
               }

               var10000 = var13.b(var23.a());
            }
         }

         var9 -= 2;
         var11 -= 2;
         var10 += 2;
         var12 += 2;
      }

      j var26 = new j(var9, var11, var10 - var9, var12 - var11);
      y.c.x var27 = var2.a();

      while(var27.f()) {
         am var30 = var1.a((Object)var27.e());
         var14.setFrame(var30.getX() - var15, var30.getY() - var15, var30.getWidth() + var15 * 2.0D, var30.getHeight() + var15 * 2.0D);
         var26.a((int)Math.floor(var14.x / var4), (int)Math.floor(var14.y / var6), 1 + (int)Math.floor((var14.x + var14.width) / var4), 1 + (int)Math.floor((var14.y + var14.height) / var6));
         var27.g();
         if(var22) {
            break;
         }
      }

      y.c.e var29 = var3.a();

      label113: {
         label112:
         while(true) {
            if(var29.f()) {
               y.d.v var31 = var1.l(var29.a());
               var10000 = var31.j();
               if(var22) {
                  break;
               }

               Object var32 = var10000;

               while(true) {
                  if(!((y.d.s)var32).f()) {
                     var29.g();
                     if(!var22) {
                        continue label112;
                     }
                     break;
                  }

                  y.d.m var21 = ((y.d.s)var32).a();
                  a(var26, var21.c().a, var21.c().b, var21.d().a, var21.d().b, var4, var6);
                  ((y.d.s)var32).g();
                  if(var22) {
                     if(!var22) {
                        continue label112;
                     }
                     break;
                  }

                  if(var22) {
                     var29.g();
                     if(!var22) {
                        continue label112;
                     }
                     break;
                  }
               }
            }

            if(var13 == null) {
               break label113;
            }

            var29 = var3.a();
            if(!var29.f()) {
               break label113;
            }

            var10000 = var13.b(var29.a());
            break;
         }

         while(true) {
            S[] var33 = (S[])var10000;
            if(var22) {
               return var26;
            }

            label77: {
               if(var33 != null) {
                  int var34 = 0;

                  while(var34 < var33.length) {
                     S var35 = var33[var34];
                     var14.setFrame(var35.d() - var15, var35.e() - var15, var35.b() + var15 * 2.0D, var35.c() + var15 * 2.0D);
                     var26.a((int)Math.floor(var14.x / var4), (int)Math.floor(var14.y / var6), 1 + (int)Math.floor((var14.x + var14.width) / var4), 1 + (int)Math.floor((var14.y + var14.height) / var6));
                     ++var34;
                     if(var22) {
                        break label77;
                     }

                     if(var22) {
                        break;
                     }
                  }
               }

               var29.g();
            }

            if(var22 || !var29.f()) {
               break;
            }

            var10000 = var13.b(var29.a());
         }
      }

      if(var8) {
         var26.c();
      }

      return var26;
   }

   static void a(j var0, double var1, double var3, double var5, double var7, double var9, double var11) {
      double var13;
      double var15;
      double var17;
      boolean var38;
      label171: {
         var38 = X.j;
         var13 = var5 - var1;
         var15 = var7 - var3;
         var17 = 0.1D;
         if(var9 > 1.0D) {
            int var19 = 1 + (int)Math.rint(var9);

            while(var19 > 0) {
               var17 /= 10.0D;
               var19 /= 10;
               if(var38) {
                  break label171;
               }

               if(var38) {
                  break;
               }
            }
         }

         var17 = Math.min(var17, 1.0E-5D);
      }

      int var21;
      double var39;
      label159: {
         var39 = 0.1D;
         if(var11 > 1.0D) {
            var21 = 1 + (int)Math.rint(var11);

            while(var21 > 0) {
               var39 /= 10.0D;
               var21 /= 10;
               if(var38) {
                  break label159;
               }

               if(var38) {
                  break;
               }
            }
         }

         var39 = Math.min(var39, 1.0E-5D);
         var21 = (int)Math.floor(var1 / var9);
      }

      int var22 = (int)Math.floor(var3 / var11);
      int var23 = (int)Math.floor(var5 / var9);
      int var24 = (int)Math.floor(var7 / var11);
      int var25 = var23 - var21;
      int var26 = var24 - var22;
      if(var25 == 0 || Math.abs(var13) < var17) {
         var0.a(var21, Math.min(var22, var24), var21 + 1, Math.max(var22, var24) + 1);
         if(!var38) {
            return;
         }
      }

      if(var26 == 0 || Math.abs(var15) < var39) {
         var0.a(Math.min(var21, var23), var22, Math.max(var21, var23) + 1, var22 + 1);
         if(!var38) {
            return;
         }
      }

      int var10000;
      int var10001;
      double var27;
      double var29;
      double var31;
      double var33;
      int var35;
      int var36;
      int var37;
      if(Math.abs(var13) > Math.abs(var15)) {
         if(var21 > var23) {
            var27 = var15 / var13;
            var29 = var7;
            var31 = (Math.floor(var5 / var9) + 1.0D - (double)var23) * var27 + var7;
            var33 = var9 * var27;
            var35 = var23;

            while(true) {
               if(var35 < var21) {
                  var36 = (int)Math.floor(var29 / var11);
                  var37 = (int)Math.floor(var31 / var11);
                  var0.a(var35, var36, true);
                  var10000 = var36;
                  var10001 = var37;
                  if(var38) {
                     break;
                  }

                  if(var36 != var37 && var35 < var21) {
                     var0.a(var35, var37, true);
                  }

                  var29 = var31;
                  var31 += var33;
                  ++var35;
                  if(!var38) {
                     continue;
                  }
               }

               var35 = (int)Math.floor(var29 / var11);
               var0.a(var21, var35, true);
               var10000 = var35;
               var10001 = var22;
               break;
            }

            if(var10000 == var10001) {
               return;
            }

            var0.a(var21, var22, true);
            if(!var38) {
               return;
            }
         }

         var27 = var15 / var13;
         var29 = var3;
         var31 = (Math.floor(var1 / var9) + 1.0D - (double)var21) * var27 + var3;
         var33 = var9 * var27;
         var35 = var21;

         label115: {
            while(var35 < var23) {
               var36 = (int)Math.floor(var29 / var11);
               var37 = (int)Math.floor(var31 / var11);
               var0.a(var35, var36, true);
               var10000 = var36;
               var10001 = var37;
               if(var38) {
                  break label115;
               }

               if(var36 != var37) {
                  var0.a(var35, var37, true);
               }

               var29 = var31;
               var31 += var33;
               ++var35;
               if(var38) {
                  break;
               }
            }

            var35 = (int)Math.floor(var29 / var11);
            var0.a(var23, var35, true);
            var10000 = var35;
            var10001 = var24;
         }

         if(var10000 == var10001) {
            return;
         }

         var0.a(var23, var24, true);
         if(!var38) {
            return;
         }
      }

      if(var22 > var24) {
         var27 = var13 / var15;
         var29 = var5;
         var31 = (Math.floor(var7 / var11) + 1.0D - (double)var24) * var27 + var5;
         var33 = var11 * var27;
         var35 = var24;

         label94: {
            while(var35 < var22) {
               var36 = (int)Math.floor(var29 / var9);
               var37 = (int)Math.floor(var31 / var9);
               var0.a(var36, var35, true);
               var10000 = var36;
               var10001 = var37;
               if(var38) {
                  break label94;
               }

               if(var36 != var37) {
                  var0.a(var37, var35, true);
               }

               var29 = var31;
               var31 += var33;
               ++var35;
               if(var38) {
                  break;
               }
            }

            var35 = (int)Math.floor(var29 / var9);
            var0.a(var35, var22, true);
            var10000 = var35;
            var10001 = var21;
         }

         if(var10000 == var10001) {
            return;
         }

         var0.a(var21, var22, true);
         if(!var38) {
            return;
         }
      }

      var27 = var13 / var15;
      var29 = var1;
      var31 = (Math.floor(var3 / var11) + 1.0D - (double)var22) * var27 + var1;
      var33 = var11 * var27;
      var35 = var22;

      label78: {
         while(var35 < var24) {
            var36 = (int)Math.floor(var29 / var9);
            var37 = (int)Math.floor(var31 / var9);
            var0.a(var36, var35, true);
            var10000 = var36;
            var10001 = var37;
            if(var38) {
               break label78;
            }

            if(var36 != var37) {
               var0.a(var37, var35, true);
            }

            var29 = var31;
            var31 += var33;
            ++var35;
            if(var38) {
               break;
            }
         }

         var35 = (int)Math.floor(var29 / var9);
         var0.a(var35, var24, true);
         var10000 = var35;
         var10001 = var23;
      }

      if(var10000 != var10001) {
         var0.a(var23, var24, true);
      }

   }

   protected void a(X var1, y.c.y[] var2, y.c.f[] var3, y.d.y[] var4, Rectangle2D[] var5, boolean var6, boolean var7, boolean var8) {
      double var9;
      double var11;
      boolean var20;
      label52: {
         var20 = X.j;
         if(this.c() > 0.0D) {
            if(this.c() > 10.0D) {
               var9 = this.c();
               var11 = this.c();
               if(!var20) {
                  break label52;
               }
            }

            int var13 = (int)Math.ceil(10.0D / this.c());
            if(var13 < 1) {
               var13 = 1;
            }

            var9 = var11 = this.c() * (double)var13;
            if(!var20) {
               break label52;
            }
         }

         var9 = var11 = Math.max(this.d(), 25.0D);
      }

      i[] var21 = new i[var2.length];
      int var14 = 0;

      while(true) {
         if(var14 < var2.length) {
            var21[var14] = new i();
            var21[var14].a = var14;
            var21[var14].b = this.a(var1, var2[var14], var3[var14], var9, var11, var7);
            var21[var14].c = j.c(var21[var14].b).cardinality();
            ++var14;
            if(var20) {
               break;
            }

            if(!var20) {
               continue;
            }
         }

         y.g.e.a((Object[])var21, new h(this));
         break;
      }

      j var22 = var21[0].b;
      int var15 = 1;

      while(var15 < var21.length) {
         i var16;
         int var17;
         int var18;
         label30: {
            var16 = var21[var15];
            if(var8) {
               y.d.y var19 = var4[var16.a];
               var17 = (int)Math.round((var19.c() + var19.a() * 0.5D) / var9);
               var18 = (int)Math.round((var19.d() + var19.b() * 0.5D) / var11);
               if(!var20) {
                  break label30;
               }
            }

            var17 = var22.c + var22.a / 2;
            var18 = var22.d + var22.b / 2;
         }

         var16.b.a(var22, var17, var18, this.c / this.d, var6);
         int var23 = var16.a;
         this.a(var1, var2[var23], var3[var23], new y.d.t(var4[var23].c + (double)var16.b.a() * var9, var4[var23].d + (double)var16.b.b() * var11), var4[var23]);
         var16.b = null;
         ++var15;
         if(var20) {
            break;
         }
      }

   }

   static k[] a(e var0) {
      return var0.o;
   }
}
