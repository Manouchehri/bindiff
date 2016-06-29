package y.h;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicHTML;
import y.h.a;
import y.h.dr;
import y.h.fj;
import y.h.gZ;
import y.h.hC;
import y.h.ha;
import y.h.hc;
import y.h.hi;

class hh extends a implements ha, hc {
   static final hh d = new hh();

   public void a(gZ var1, Rectangle2D var2) {
      y.d.y var3 = var1.getBox();
      if(var2.getWidth() < 0.0D || var2.getHeight() < 0.0D) {
         var2.setRect(var3.c, var3.d, var3.a, var3.b);
         if(!fj.z) {
            return;
         }
      }

      var2.setFrameFromDiagonal(Math.min(var3.c, var2.getX()), Math.min(var3.d, var2.getY()), Math.max(var3.c + var3.a, var2.getX() + var2.getWidth()), Math.max(var3.d + var3.b, var2.getY() + var2.getWidth()));
   }

   public void b(gZ var1, Graphics2D var2, double var3, double var5, double var7, double var9) {
      double var11;
      double var13;
      boolean var27;
      label90: {
         var27 = fj.z;
         if(var1.p != null) {
            double[] var15 = this.b(var1, hC.a().n);
            this.a(var2, var1.p, var3 + var15[0], var5 + var15[1]);
            this.a(var1, var15);
            var11 = var15[0];
            var13 = var15[1];
            if(!var27) {
               break label90;
            }
         }

         Insets var28 = var1.x == null?gZ.defaultInsets:var1.x;
         var11 = var7 - (double)(var28.left + var28.right);
         var13 = var9 - (double)(var28.top + var28.bottom);
      }

      if(var1.o.length() > 0) {
         Color var29 = var2.getColor();
         Font var16 = var2.getFont();
         Stroke var17 = var2.getStroke();
         Color var18 = var1.bb;
         if(var18 != null) {
            var2.setColor(var18);
         }

         label79: {
            label78: {
               var2.setFont(var1.fb);
               var2.setStroke(dr.a);
               double[] var21;
               if(BasicHTML.isHTMLString(var1.o) && gZ.l) {
                  hC var19 = hC.a();
                  JComponent var20 = this.c(var1);
                  var21 = this.c(var1, var19.n);
                  var3 += var21[0];
                  var5 += var21[1];
                  SwingUtilities.paintComponent(var2, var20, var19.f, (int)var3, (int)var5, (int)var11, (int)var13);
                  if(!var27) {
                     break label78;
                  }
               }

               if(var18 != null) {
                  label72: {
                     Object var30 = var1.q;
                     if(var30 instanceof ArrayList) {
                        ArrayList var31 = (ArrayList)var30;
                        var21 = this.c(var1, hC.a().n);
                        double var22 = 0.0D;
                        var3 += var21[0];
                        var5 += var21[1];
                        int var24 = 0;

                        do {
                           if(var24 >= var31.size()) {
                              break label72;
                           }

                           hi var25 = (hi)var31.get(var24);
                           var5 += (double)var25.b;
                           if(var27) {
                              break label79;
                           }

                           switch(var1.j) {
                           case 0:
                              var22 = 0.0D;
                              if(!var27) {
                                 break;
                              }
                           case 1:
                              var22 = (var11 - var25.a) / 2.0D;
                              if(!var27) {
                                 break;
                              }
                           case 2:
                              var22 = var11 - var25.a;
                              if(!var27) {
                                 break;
                              }
                           default:
                              var22 = 0.0D;
                           }

                           var2.drawString(var25.d, (float)(var3 + var22), (float)var5);
                           var5 += (double)var25.c;
                           if(var1.cb) {
                              Double var26 = hC.a().l;
                              var26.x1 = var3;
                              var26.y1 = var26.y2 = var5;
                              var26.x2 = var3 + var11;
                              var2.draw(var26);
                           }

                           ++var24;
                        } while(!var27);
                     }

                     if(var30 instanceof hi) {
                        double[] var32 = this.c(var1, hC.a().n);
                        double var33 = 0.0D;
                        var3 += var32[0];
                        var5 += var32[1];
                        hi var23 = (hi)var30;
                        var5 += (double)var23.b;
                        switch(var1.j) {
                        case 0:
                           var33 = 0.0D;
                           if(!var27) {
                              break;
                           }
                        case 1:
                           var33 = (var11 - var23.a) / 2.0D;
                           if(!var27) {
                              break;
                           }
                        case 2:
                           var33 = var11 - var23.a;
                           if(!var27) {
                              break;
                           }
                        default:
                           var33 = 0.0D;
                        }

                        var2.drawString(var23.d, (float)(var3 + var33), (float)var5);
                        var5 += (double)var23.c;
                        if(var1.cb) {
                           Double var34 = hC.a().l;
                           var34.x1 = var3;
                           var34.y1 = var34.y2 = var5;
                           var34.x2 = var3 + var11;
                           var2.draw(var34);
                        }
                     }
                  }
               }
            }

            var2.setStroke(var17);
            var2.setFont(var16);
         }

         if(var18 != null) {
            var2.setColor(var29);
         }
      }

   }

   protected void a(Graphics2D var1, Icon var2, double var3, double var5) {
      AffineTransform var7 = var1.getTransform();
      double var8 = var3 - (double)((int)var3);
      double var10 = var5 - (double)((int)var5);
      var1.translate(var8, var10);
      var2.paintIcon((Component)null, var1, (int)var3, (int)var5);
      var1.setTransform(var7);
   }

   private double[] b(gZ var1, double var2, double var4) {
      double[] var6;
      double var7;
      double var9;
      double[] var11;
      boolean var22;
      label72: {
         var22 = fj.z;
         var6 = null;
         if(var1.p != null) {
            var11 = this.b(var1, hC.a().n);
            this.a(var1, var11);
            var7 = var11[0];
            var9 = var11[1];
            if(!var22) {
               break label72;
            }
         }

         Insets var23 = var1.x == null?gZ.defaultInsets:var1.x;
         var7 = var2 - (double)(var23.left + var23.right);
         var9 = var4 - (double)(var23.top + var23.bottom);
      }

      if(var1.o.length() > 0) {
         double var14;
         if(BasicHTML.isHTMLString(var1.o) && gZ.l) {
            var11 = this.c(var1, hC.a().n);
            double var26 = var11[0];
            var14 = var11[1];
            var6 = new double[]{var26, var14, var26 + var7, var14 + var9};
         } else {
            Object var24 = var1.q;
            if(var24 instanceof ArrayList) {
               ArrayList var12 = (ArrayList)var24;
               double[] var13 = this.c(var1, hC.a().n);
               var14 = 0.0D;
               double var16 = var13[0];
               double var18 = var13[1];

               for(int var20 = 0; var20 < var12.size(); ++var20) {
                  hi var21 = (hi)var12.get(var20);
                  switch(var1.j) {
                  case 0:
                     var14 = 0.0D;
                     if(!var22) {
                        break;
                     }
                  case 1:
                     var14 = (var7 - var21.a) / 2.0D;
                     if(!var22) {
                        break;
                     }
                  case 2:
                     var14 = var7 - var21.a;
                     if(!var22) {
                        break;
                     }
                  default:
                     var14 = 0.0D;
                  }

                  label54: {
                     if(var6 != null) {
                        var6[0] = Math.min(var6[0], var16 + var14);
                        var6[1] = Math.min(var6[1], var18);
                        var6[2] = Math.max(var6[2], var16 + var14 + var21.a);
                        var6[3] = Math.max(var6[3], var18 + (double)var21.b + (double)var21.c);
                        if(!var22) {
                           break label54;
                        }
                     }

                     var6 = new double[]{var16 + var14, var18, var16 + var14 + var21.a, var18 + (double)var21.b + (double)var21.c};
                  }

                  var18 += (double)(var21.b + var21.c);
               }
            } else if(var24 instanceof hi) {
               double[] var25 = this.c(var1, hC.a().n);
               double var27 = 0.0D;
               double var15 = var25[0];
               double var17 = var25[1];
               hi var19 = (hi)var24;
               switch(var1.j) {
               case 0:
                  var27 = 0.0D;
                  if(!var22) {
                     break;
                  }
               case 1:
                  var27 = (var7 - var19.a) / 2.0D;
                  if(!var22) {
                     break;
                  }
               case 2:
                  var27 = var7 - var19.a;
                  if(!var22) {
                     break;
                  }
               default:
                  var27 = 0.0D;
               }

               var6 = new double[]{var15 + var27, var17, var15 + var27 + var19.a, var17 + (double)var19.b + (double)var19.c};
            }
         }
      }

      return var6;
   }

   public y.d.n a(gZ var1) {
      return this.a()?this.a((gZ)var1, (y.d.n)this.d(var1)):this.d(var1);
   }

   private y.d.n d(gZ var1) {
      double var4;
      double[] var6;
      label19: {
         double var2 = var1.contentWidth;
         var4 = var1.contentHeight;
         if(!var1.w) {
            var6 = null;
            if(!fj.z) {
               break label19;
            }
         }

         var6 = this.b(var1, var2, var4);
      }

      if(var6 == null) {
         Insets var13 = var1.getInsets();
         if(var13 == null) {
            var13 = gZ.defaultInsets;
         }

         return new y.d.n((double)var13.left, (double)var13.top - var4, 0.0D, 0.0D);
      } else {
         double var7 = var6[0];
         double var9 = var6[1];
         double var11 = var6[3] - var9;
         return new y.d.n(var7, var9 + var11 - var4, var6[2] - var7, var11);
      }
   }

   public y.d.n b(gZ var1) {
      return this.a()?this.a((gZ)var1, (y.d.n)this.e(var1)):this.e(var1);
   }

   private y.d.n e(gZ var1) {
      Icon var2 = var1.p;
      if(var2 == null) {
         return new y.d.n(0.0D, -var1.contentHeight, 0.0D, 0.0D);
      } else {
         int var3 = var2.getIconHeight();
         double[] var4 = this.b(var1, new double[2]);
         return new y.d.n(var4[0], var4[1] + (double)var3 - var1.contentHeight, (double)var2.getIconWidth(), (double)var3);
      }
   }

   void a(gZ var1, double[] var2) {
      boolean var11 = fj.z;
      if(BasicHTML.isHTMLString(var1.o) && gZ.l) {
         JComponent var3 = this.c(var1);
         var2[0] = (double)var3.getWidth();
         var2[1] = (double)var3.getHeight();
         if(!var11) {
            return;
         }
      }

      double var5;
      label38: {
         double var12;
         label37: {
            var12 = 0.0D;
            var5 = 0.0D;
            Object var7 = var1.q;
            if(var7 instanceof ArrayList) {
               ArrayList var8 = (ArrayList)var7;
               int var9 = var8.size() - 1;

               do {
                  if(var9 < 0) {
                     break label37;
                  }

                  hi var10 = (hi)var8.get(var9);
                  if(var11) {
                     break label38;
                  }

                  if(var10.a > var12) {
                     var12 = var10.a;
                  }

                  var5 += (double)(var10.b + var10.c);
                  --var9;
               } while(!var11);
            }

            if(var7 instanceof hi) {
               hi var13 = (hi)var7;
               if(var13.a > var12) {
                  var12 = var13.a;
               }

               var5 += (double)(var13.b + var13.c);
            }
         }

         var2[0] = var12;
      }

      var2[1] = var5;
   }

   double[] b(gZ var1, double[] var2) {
      boolean var17 = fj.z;
      if(var1.p == null) {
         return null;
      } else {
         boolean var16;
         double var4;
         double var6;
         double var10;
         double var14;
         label71: {
            Insets var3 = var1.x == null?gZ.defaultInsets:var1.x;
            var4 = (double)var3.left;
            var6 = (double)var3.top;
            this.a(var1, var2);
            double var8 = var2[0];
            var10 = var2[1];
            double var12 = (double)var1.p.getIconWidth();
            var14 = (double)var1.p.getIconHeight();
            var16 = var8 == 0.0D && var10 == 0.0D;
            if(var1.z == 2 && var8 > var12) {
               var4 += 0.5D * (var8 - var12);
               if(!var17) {
                  break label71;
               }
            }

            if(var1.z == 8) {
               var4 += var8 + (double)(var16?0:var1.u);
               if(!var17) {
                  break label71;
               }
            }

            if(var1.z == 64) {
               var4 += Math.max(var8, var12) - var12;
            }
         }

         label49: {
            if(var1.t == 2 && var10 > var14) {
               var6 += 0.5D * (var10 - var14);
               if(!var17) {
                  break label49;
               }
            }

            if(var1.t == 1) {
               switch(var1.z) {
               case 2:
               case 32:
               case 64:
                  var6 += var10 + (double)(var16?0:var1.u);
                  if(!var17) {
                     break;
                  }
               default:
                  if(var10 > var14) {
                     var6 += var10 - var14;
                  }
               }
            }
         }

         var2[0] = var4;
         var2[1] = var6;
         return var2;
      }
   }

   double[] c(gZ var1, double[] var2) {
      boolean var17 = fj.z;
      Insets var3 = var1.x == null?gZ.defaultInsets:var1.x;
      double var4 = (double)var3.left;
      double var6 = (double)var3.top;
      if(var1.p != null) {
         label78: {
            boolean var16;
            double var10;
            double var14;
            label69: {
               this.a(var1, var2);
               double var8 = var2[0];
               var10 = var2[1];
               double var12 = (double)var1.p.getIconWidth();
               var14 = (double)var1.p.getIconHeight();
               var16 = var8 == 0.0D && var10 == 0.0D;
               if(var1.z == 2 && var12 > var8) {
                  var4 += 0.5D * (var12 - var8);
                  if(!var17) {
                     break label69;
                  }
               }

               if(var1.z == 16) {
                  var4 += var12 + (double)(var16?0:var1.u);
                  if(!var17) {
                     break label69;
                  }
               }

               if(var1.z == 64) {
                  var4 += Math.max(var8, var12) - var8;
               }
            }

            if(var1.t == 2 && var14 > var10) {
               var6 += 0.5D * (var14 - var10);
               if(!var17) {
                  break label78;
               }
            }

            if(var1.t == 4) {
               switch(var1.z) {
               case 2:
               case 32:
               case 64:
                  var6 += var14 + (double)(var16?0:var1.u);
                  if(!var17) {
                     break;
                  }
               default:
                  if(var14 > var10) {
                     var6 += var14 - var10;
                  }
               }
            }
         }
      }

      var2[0] = var4;
      var2[1] = var6;
      return var2;
   }

   JComponent c(gZ var1) {
      JLabel var2 = hC.a().e;
      this.a(var2, var1);
      return var2;
   }

   void a(JLabel var1, gZ var2) {
      var1.setText("");
      var1.setFont(var2.fb);
      var1.setText(var2.o);
      var1.setBackground(var2.k);
      var1.setForeground(var2.bb);
      Dimension var3 = var1.getPreferredSize();
      var1.setSize(var3.width, var3.height);
   }

   public void a(gZ var1, FontRenderContext var2) {
      double var3;
      double var5;
      boolean var12;
      label137: {
         var12 = fj.z;
         var3 = 0.0D;
         var5 = 0.0D;
         if(BasicHTML.isHTMLString(var1.o) && gZ.l) {
            var1.q = null;
            if(var1.getAutoSizePolicy() == 4) {
               break label137;
            }

            JComponent var7 = this.c(var1);
            var3 = (double)var7.getWidth();
            var5 = (double)var7.getHeight();
            if(!var12) {
               break label137;
            }
         }

         ArrayList var13 = new ArrayList(5);
         boolean var8 = false;
         String var9 = var1.o;

         String var10000;
         label125:
         while(true) {
            int var15 = var9.indexOf("\n");
            if(var15 < 0) {
               var10000 = var9;
               if(!var12) {
                  break;
               }
            } else {
               var10000 = var9.substring(0, var15);
            }

            while(true) {
               String var10 = var10000;
               if(var10.length() == 0) {
                  var10 = " ";
               }

               var13.add(new hi(var10, var1.fb, var2));
               var9 = var9.substring(var15 + 1);
               if(var15 >= 0) {
                  break;
               }

               var10000 = var9;
               if(!var12) {
                  break label125;
               }
            }
         }

         if(var10000.length() > 0) {
            var13.add(new hi(var9, var1.fb, var2));
         }

         var5 = 0.0D;
         var3 = 0.0D;
         int var17 = var13.size() - 1;

         int var18;
         label110: {
            while(var17 >= 0) {
               hi var11 = (hi)var13.get(var17);
               double var19;
               var18 = (var19 = var11.a - var3) == 0.0D?0:(var19 < 0.0D?-1:1);
               if(var12) {
                  break label110;
               }

               if(var18 > 0) {
                  var3 = var11.a;
               }

               var5 += (double)(var11.b + var11.c);
               --var17;
               if(var12) {
                  break;
               }
            }

            var18 = var13.size();
         }

         if(var18 == 1) {
            var1.q = var13.get(0);
            if(!var12) {
               break label137;
            }
         }

         var13.trimToSize();
         var1.q = var13;
      }

      boolean var14 = var3 == 0.0D && var5 == 0.0D;
      if(var1.getAutoSizePolicy() != 4 && var1.p != null) {
         switch(var1.z) {
         case 2:
         case 32:
         case 64:
            var3 = Math.max(var3, (double)var1.p.getIconWidth());
            if(var1.t != 2) {
               var5 += (double)(var1.p.getIconHeight() + (var14?0:var1.u));
               if(!var12) {
                  break;
               }
            }

            var5 = Math.max(var5, (double)var1.p.getIconHeight());
            if(!var12) {
               break;
            }
         default:
            label140: {
               if(var1.z == 32) {
                  var3 = Math.max(var3, (double)var1.p.getIconWidth());
                  if(var1.t != 2) {
                     var5 += (double)(var1.p.getIconHeight() + (var14?0:var1.u));
                     if(!var12) {
                        break label140;
                     }
                  }

                  var5 = Math.max(var5, (double)var1.p.getIconHeight());
                  if(!var12) {
                     break label140;
                  }
               }

               var5 = Math.max(var5, (double)var1.p.getIconHeight());
               var3 += (double)(var1.p.getIconWidth() + (var14?0:var1.u));
            }
         }
      }

      label141: {
         if(var1.getAutoSizePolicy() == 4) {
            var3 = var1.contentWidth;
            var5 = var1.contentHeight;
            if(!var12) {
               break label141;
            }
         }

         Insets var16 = var1.x == null?gZ.defaultInsets:var1.x;
         var3 += (double)(var16.left + var16.right);
         var5 += (double)(var16.top + var16.bottom);
      }

      var1.setContentSize(var3, var5);
   }

   public boolean a(gZ var1, double var2, double var4) {
      return var1.getContentBox().a(var2, var4, true);
   }
}
