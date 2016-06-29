package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.h.bu;
import y.h.ch;
import y.h.dd;
import y.h.de;
import y.h.e;
import y.h.fj;
import y.h.gt;
import y.h.gy;
import y.h.gz;

public class dc extends e {
   private Collection a;
   private y.c.c b;
   private y.g.ai c;
   private List d;
   private y.g.ai e;

   public dc() {
      this((ch)null);
   }

   public dc(ch var1) {
      super(var1);
   }

   public void f() {
      super.f();
      this.a = null;
      this.e = this.c = null;
      this.b = null;
      this.d = null;
   }

   public void a(y.d.t var1, Collection var2, y.c.c var3) {
      boolean var10 = fj.z;
      this.a(var1);
      ch var4 = this.c();
      this.g();
      this.a = var2;
      this.b = var3;
      this.e = new y.g.ai();
      this.c = new y.g.ai();
      HashSet var5 = new HashSet(var2);
      ArrayList var6 = new ArrayList(var4.getGraph2D().e() - var5.size());
      this.a((Collection)var2, var6);
      Iterator var7 = var6.iterator();

      while(true) {
         if(var7.hasNext()) {
            y.c.q var8 = (y.c.q)var7.next();
            fj var9 = var4.getGraph2D().t(var8);
            if(!this.a(var9)) {
               continue;
            }

            this.a(var8, var9.getWidth(), this.c);
            this.a(var8, var9.getHeight(), this.e);
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         this.d = this.a(var6);
         break;
      }

   }

   protected List a(Collection var1) {
      boolean var5 = fj.z;
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         y.c.q var4 = (y.c.q)var3.next();
         this.a((y.c.q)var4, var2);
         if(var5) {
            break;
         }
      }

      return var2;
   }

   protected void a(y.c.q var1, Collection var2) {
      bu var3 = this.c().getGraph2D();
      fj var4 = var3.t(var1);
      if(this.a(var4)) {
         this.a(var4, var2);
      }

   }

   protected void a(fj var1, Collection var2) {
      double var3 = var1.getCenterX();
      double var5 = var1.getY();
      var2.add(new gy((byte)0, (byte)1, new y.d.t(var3, var5), (Object)null, 1.0D));
      double var7 = var1.getHeight();
      double var9 = var5 + var7;
      var2.add(new gy((byte)0, (byte)2, new y.d.t(var3, var9), (Object)null, 1.0D));
      double var11 = var1.getWidth();
      double var13 = var1.getX();
      double var15 = var13 + var11;
      var2.add(new gy((byte)0, (byte)2, new y.d.t(var3, var5), var13, var15, (Object)null, 1.0D));
      var2.add(new gy((byte)0, (byte)1, new y.d.t(var3, var9), var13, var15, (Object)null, 1.0D));
      double var17 = var1.getCenterY();
      var2.add(new gy((byte)1, (byte)4, new y.d.t(var13, var17), (Object)null, 1.0D));
      var2.add(new gy((byte)1, (byte)8, new y.d.t(var15, var17), (Object)null, 1.0D));
      var2.add(new gy((byte)1, (byte)8, new y.d.t(var13, var17), var5, var9, (Object)null, 1.0D));
      var2.add(new gy((byte)1, (byte)4, new y.d.t(var15, var17), var5, var9, (Object)null, 1.0D));
   }

   private void a(y.c.q var1, double var2, y.g.ai var4) {
      de var5;
      label31: {
         boolean var8 = fj.z;
         var5 = new de(var2);
         y.g.aj var6 = var4.b((Object)var5);
         if(var6 == null) {
            if(var4.a() == 0) {
               var4.a((Object)var5);
               if(!var8) {
                  break label31;
               }
            }

            de var7 = (de)var4.b().c();
            if(var7.a == var2) {
               var5 = var7;
               if(!var8) {
                  break label31;
               }
            }

            var4.b(var4.b(), var5);
            if(!var8) {
               break label31;
            }
         }

         if(var6.a() != null && ((de)var6.a().c()).a == var2) {
            var5 = (de)var6.a().c();
            if(!var8) {
               break label31;
            }
         }

         var4.a((y.g.aj)var6, (Object)var5);
      }

      var5.b.add(var1);
   }

   public y.d.t a(y.d.t var1, byte var2, boolean var3, boolean var4) {
      boolean var55 = fj.z;
      y.d.t var5 = this.k();
      this.h();
      if(this.c.a() == 0) {
         return var1;
      } else {
         if(var3) {
            switch(var2) {
            case 0:
            case 2:
            case 3:
            case 5:
               return var1;
            case 1:
            case 4:
            }
         }

         double var6 = var1.a - var5.a;
         double var8 = var1.b - var5.b;
         double var10;
         double var12;
         double var14;
         double var16;
         double var18;
         double var20;
         switch(var2) {
         case 7:
            var12 = 0.0D;
            var10 = 1.0D;
            var14 = var4?-1.0D:0.0D;
            var16 = 0.0D;
            var18 = 1.0D;
            var20 = 0.0D;
            if(!var55) {
               break;
            }
         case 2:
            var12 = -1.0D;
            var10 = 1.0D;
            var14 = var4?-1.0D:0.0D;
            var16 = 1.0D;
            var18 = 1.0D;
            var20 = var4?-1.0D:0.0D;
            if(!var55) {
               break;
            }
         case 5:
            var12 = 1.0D;
            var10 = 1.0D;
            var14 = var4?-1.0D:0.0D;
            var16 = var4?-1.0D:0.0D;
            var18 = 1.0D;
            var20 = 1.0D;
            if(!var55) {
               break;
            }
         case 6:
            var12 = 0.0D;
            var10 = -1.0D;
            var14 = 1.0D;
            var16 = 0.0D;
            var18 = var4?-1.0D:0.0D;
            var20 = 0.0D;
            if(!var55) {
               break;
            }
         case 3:
            var12 = 1.0D;
            var10 = -1.0D;
            var14 = 1.0D;
            var16 = var4?-1.0D:0.0D;
            var18 = var4?-1.0D:0.0D;
            var20 = 1.0D;
            if(!var55) {
               break;
            }
         case 0:
            var12 = -1.0D;
            var10 = -1.0D;
            var14 = 1.0D;
            var16 = 1.0D;
            var18 = var4?-1.0D:0.0D;
            var20 = var4?-1.0D:0.0D;
            if(!var55) {
               break;
            }
         case 1:
            var12 = -1.0D;
            var10 = 0.0D;
            var14 = 0.0D;
            var16 = 1.0D;
            var18 = 0.0D;
            var20 = var4?-1.0D:0.0D;
            if(!var55) {
               break;
            }
         case 4:
            var12 = 1.0D;
            var10 = 0.0D;
            var14 = 0.0D;
            var16 = var4?-1.0D:0.0D;
            var18 = 0.0D;
            var20 = 1.0D;
            if(!var55) {
               break;
            }
         default:
            var12 = 0.0D;
            var10 = 0.0D;
            var16 = 0.0D;
            var14 = 0.0D;
            var20 = 0.0D;
            var18 = 0.0D;
         }

         if(var4) {
            var10 *= 2.0D;
            var12 *= 2.0D;
         }

         double var22 = var6 * var10;
         double var24 = var8 * var12;
         double var26 = var14 * var6;
         double var28 = var16 * var8;
         ArrayList var30 = new ArrayList(5);
         double var31 = this.e() / this.c().getZoom();
         Iterator var33 = this.a.iterator();

         label218:
         while(true) {
            int var10000 = var33.hasNext();

            while(var10000 != 0) {
               y.c.q var34 = (y.c.q)var33.next();

               Double var35;
               label165: {
                  try {
                     var35 = (Double)this.b.b(var34);
                     if(var35 != null) {
                        break label165;
                     }
                  } catch (Exception var56) {
                     continue label218;
                  }

                  if(!var55) {
                     continue label218;
                  }
               }

               double var36 = var35.getX() + var26;
               double var38 = var35.width + var22;
               double var40 = var36 + var38;
               double var42 = var35.getY() + var28;
               double var44 = var35.height + var24;
               double var46 = var42 + var44;
               gt var48 = this.c().getGraph2D().t(var34).getSizeConstraintProvider();
               if(var48 != null) {
                  y.d.q var49 = var48.getMinimumSize();
                  if(var49 != null) {
                     if(var38 - var31 < var49.a) {
                        var18 = 0.0D;
                        var14 = 0.0D;
                        var10 = 0.0D;
                     }

                     if(var44 - var31 < var49.b) {
                        var20 = 0.0D;
                        var16 = 0.0D;
                        var12 = 0.0D;
                     }
                  }

                  var49 = var48.getMaximumSize();
                  if(var49 != null) {
                     if(var38 + var31 > var49.a) {
                        var18 = 0.0D;
                        var14 = 0.0D;
                        var10 = 0.0D;
                     }

                     if(var44 + var31 > var49.b) {
                        var20 = 0.0D;
                        var16 = 0.0D;
                        var12 = 0.0D;
                     }
                  }
               }

               gz var57;
               if(var10 != 0.0D) {
                  var57 = this.a(var34, 1.0D / var10, var38, this.c, var1.a, true);
                  if(var57.b() > 0.0D) {
                     var30.add(var57);
                  }
               }

               if(var12 != 0.0D) {
                  var57 = this.a(var34, 1.0D / var12, var44, this.e, var1.b, false);
                  if(var57.b() > 0.0D) {
                     var30.add(var57);
                  }
               }

               Iterator var58 = this.d.iterator();

               while(true) {
                  gy var50;
                  double var51;
                  double var53;
                  while(true) {
                     while(true) {
                        if(!var58.hasNext()) {
                           continue label218;
                        }

                        var50 = (gy)var58.next();
                        if(var50.c() != 1) {
                           break;
                        }

                        if(var50.d() == 4) {
                           if(var14 == 0.0D || var50.e() >= var46 || var50.f() <= var42) {
                              continue;
                           }

                           var51 = var50.b().a - var36;
                           if(Math.abs(var51) >= var31) {
                              continue;
                           }

                           var53 = var31 - Math.abs(var51);
                           var30.add(gz.a(var53, var50, true, var1.a + var51 * var14));
                           if(!var55) {
                              continue;
                           }
                        }

                        if(var50.d() == 8 && var18 != 0.0D && var50.e() < var46 && var50.f() > var42) {
                           var51 = var50.b().a - var40;
                           if(Math.abs(var51) < var31) {
                              var53 = var31 - Math.abs(var51);
                              var30.add(gz.a(var53, var50, true, var1.a + var51 * var18));
                              if(var55) {
                                 break;
                              }
                           }
                        }
                     }

                     if(var50.d() != 1) {
                        break;
                     }

                     if(var16 != 0.0D && var50.e() < var40 && var50.f() > var36) {
                        var51 = var50.b().b - var42;
                        if(Math.abs(var51) < var31) {
                           var53 = var31 - Math.abs(var51);
                           var30.add(gz.a(var53, var50, false, var1.b + var51 * var16));
                           if(var55) {
                              break;
                           }
                        }
                     }
                  }

                  if(var50.d() == 2) {
                     double var59;
                     var10000 = (var59 = var20 - 0.0D) == 0.0D?0:(var59 < 0.0D?-1:1);
                     if(var55) {
                        break;
                     }

                     if(var10000 != 0 && var50.e() < var40 && var50.f() > var36) {
                        var51 = var50.b().b - var46;
                        if(Math.abs(var51) < var31) {
                           var53 = var31 - Math.abs(var51);
                           var30.add(gz.a(var53, var50, false, var1.b + var51 * var20));
                           if(var55) {
                              return this.a((List)var30, (y.d.t)var1);
                           }
                        }
                     }
                  }
               }
            }

            return this.a((List)var30, (y.d.t)var1);
         }
      }
   }

   private gz a(y.c.q var1, double var2, double var4, y.g.ai var6, double var7, boolean var9) {
      de var18;
      double var19;
      label48: {
         boolean var26 = fj.z;
         double var10 = this.e() / this.c().getZoom();
         y.g.aj var12 = var6.b((Object)(new de(var4)));
         y.g.aj var13 = var12 != null?var12.a():var6.b();
         double var14 = var12 != null?((de)var12.c()).a - var4:java.lang.Double.POSITIVE_INFINITY;
         double var16 = var13 != null?((de)var13.c()).a - var4:java.lang.Double.POSITIVE_INFINITY;
         if(Math.abs(var14) < var10) {
            if(Math.abs(var16) < Math.abs(var14)) {
               var19 = var16 * var2;
               var18 = (de)var13.c();
               if(!var26) {
                  break label48;
               }
            }

            var19 = var14 * var2;
            var18 = (de)var12.c();
            if(!var26) {
               break label48;
            }
         }

         if(Math.abs(var16) >= var10) {
            return gz.b;
         }

         var19 = var16 * var2;
         var18 = (de)var13.c();
         if(var26) {
            return gz.b;
         }
      }

      double var21 = var19 != 0.0D?1.0D / (1.0D + Math.abs(var19)):1.0D;
      double var23 = var19 + var7;
      dd var25 = new dd(this, var18, var9, var1);
      return gz.a(var21, var25, var9, var23);
   }

   private Rectangle2D a(bu var1, y.c.q var2, boolean var3) {
      fj var4 = var1.t(var2);
      java.awt.geom.Line2D.Double var5;
      if(var3) {
         var5 = new java.awt.geom.Line2D.Double(var4.getX(), var4.getY() - 15.0D, var4.getX() + var4.getWidth(), var4.getY() + 10.0D);
         if(!fj.z) {
            return var5.getBounds2D();
         }
      }

      var5 = new java.awt.geom.Line2D.Double(var4.getX() - 15.0D, var4.getY(), var4.getX() + 10.0D, var4.getY() + var4.getHeight());
      return var5.getBounds2D();
   }

   private void a(Graphics2D var1, bu var2, y.c.q var3, boolean var4) {
      fj var5 = var2.t(var3);
      if(var4) {
         a(var1, var5.getX(), var5.getY() - 5.0D, var5.getX() + var5.getWidth(), var5.getY() - 5.0D);
         if(!fj.z) {
            return;
         }
      }

      a(var1, var5.getX() - 5.0D, var5.getY(), var5.getX() - 5.0D, var5.getY() + var5.getHeight());
   }

   static void a(dc var0, Graphics2D var1, bu var2, y.c.q var3, boolean var4) {
      var0.a(var1, var2, var3, var4);
   }

   static Rectangle2D a(dc var0, bu var1, y.c.q var2, boolean var3) {
      return var0.a(var1, var2, var3);
   }
}
