package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;
import y.h.a;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

final class hj extends a {
   static final hj d = new hj();

   public void b(gZ var1, Graphics2D var2, double var3, double var5, double var7, double var9) {
      Color var14;
      Shape var16;
      label413: {
         label460: {
            label434: {
               boolean var29 = fj.z;
               if(var1.o.length() > 0 && var1.bb != null) {
                  Insets var11 = var1.getInsets();
                  if(var11 == null) {
                     var11 = gZ.defaultInsets;
                  }

                  var3 += (double)var11.left;
                  var5 += (double)var11.top;
                  float var12 = (float)var3;
                  float var13 = (float)var5;
                  var7 -= (double)(var11.left + var11.right);
                  var9 -= (double)(var11.top + var11.bottom);
                  if(var7 <= 0.0D || var9 <= 0.0D) {
                     return;
                  }

                  var14 = var2.getColor();
                  var2.setColor(var1.bb);
                  HashMap var15 = new HashMap();
                  var15.put(TextAttribute.FONT, var1.fb);
                  if(var1.cb) {
                     var15.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                  }

                  var16 = var2.getClip();
                  var2.clip(new Double(var3, var5, var7, var9));
                  LineBreakMeasurer var17 = new LineBreakMeasurer((new AttributedString(var1.o, var15)).getIterator(), var2.getFontRenderContext());
                  int var18 = var2.getFontMetrics(var1.fb).getHeight() - 1;
                  boolean var19 = var1.j == 2;
                  boolean var20 = var1.j == 1;
                  boolean var31 = false;

                  label404: {
                     label403: {
                        label402: {
                           try {
                              var31 = true;
                              int var21 = var1.o.indexOf(10);
                              if(var21 == -1) {
                                 var21 = var1.o.length();
                              }

                              TextLayout var22;
                              while(var21 <= var17.getPosition() && var17.getPosition() < var1.o.length()) {
                                 var22 = var17.nextLayout(100.0F, var21 + 1, false);
                                 var13 += var22.getAscent() + var22.getLeading() + var22.getDescent();
                                 var21 = var1.o.indexOf(10, var21 + 1);
                                 if(var21 == -1) {
                                    var21 = var1.o.length();
                                    if(var29) {
                                       var31 = false;
                                       return;
                                    }

                                    if(var29) {
                                       break;
                                    }
                                 }
                              }

                              while(true) {
                                 if(var17.getPosition() >= var1.o.length()) {
                                    var31 = false;
                                    break label404;
                                 }

                                 float var23;
                                 float var24;
                                 if(var5 + var9 < (double)(var13 + (float)(2 * var18))) {
                                    var22 = new TextLayout("…", var15, var2.getFontRenderContext());
                                    var23 = var22.getAdvance();
                                    float var25;
                                    TextLayout var33;
                                    if(var17.nextOffset((float)var7, var21, false) < var1.o.length()) {
                                       if(var7 > (double)var23) {
                                          var33 = var17.nextLayout((float)var7 - var23, var21, false);
                                          if(var17.getPosition() == var21) {
                                             var21 = var1.o.indexOf(10, var21 + 1);
                                             if(var21 == -1) {
                                                var21 = var1.o.length();
                                             }
                                          }

                                          if(var33 != null) {
                                             var13 += var33.getAscent();
                                             if(var17.getPosition() < var1.o.length()) {
                                                var25 = var33.getAdvance() + var22.getAdvance();
                                                float var26 = var20?((float)var7 - var25) * 0.5F:(var33.isLeftToRight() && !var19?0.0F:(float)var7 - var25);
                                                var33.draw(var2, var12 + var26, var13);
                                                float var27 = var26 + var33.getAdvance();
                                                var22.draw(var2, var12 + var27, var13);
                                                if(!var29) {
                                                   var31 = false;
                                                   break label403;
                                                }
                                             }

                                             var25 = var20?((float)var7 - var33.getAdvance()) * 0.5F:(var33.isLeftToRight() && !var19?0.0F:(float)var7 - var33.getAdvance());
                                             var33.draw(var2, var12 + var25, var13);
                                             var31 = false;
                                             break label403;
                                          }

                                          var31 = false;
                                          break label402;
                                       }

                                       var13 += var22.getAscent();
                                       var24 = var20?((float)var7 - var22.getAdvance()) * 0.5F:(var22.isLeftToRight() && !var19?0.0F:(float)var7 - var22.getAdvance());
                                       var22.draw(var2, var12 + var24, var13);
                                       var31 = false;
                                       break label413;
                                    }

                                    var33 = var17.nextLayout((float)var7);
                                    if(var33 != null) {
                                       var13 += var33.getAscent();
                                       var25 = var20?((float)var7 - var33.getAdvance()) * 0.5F:(var33.isLeftToRight() && !var19?0.0F:(float)var7 - var33.getAdvance());
                                       var33.draw(var2, var12 + var25, var13);
                                       var31 = false;
                                       break label460;
                                    }

                                    var31 = false;
                                    break;
                                 }

                                 var22 = var17.nextLayout((float)var7, var21, false);
                                 if(var22 == null) {
                                    var31 = false;
                                    break label434;
                                 }

                                 if(var17.getPosition() == var21) {
                                    var21 = var1.o.indexOf(10, var21 + 1);
                                    if(var21 == -1) {
                                       var21 = var1.o.length();
                                    }
                                 }

                                 var13 += var22.getAscent();
                                 var23 = var20?((float)var7 - var22.getAdvance()) * 0.5F:(var22.isLeftToRight() && !var19?0.0F:(float)var7 - var22.getAdvance());
                                 var24 = var22.getDescent() + var22.getLeading();
                                 var22.draw(var2, var12 + var23, var13);
                                 var13 += var24;
                                 if(var29) {
                                    var31 = false;
                                    break label404;
                                 }
                              }
                           } finally {
                              if(var31) {
                                 var2.setClip(var16);
                                 var2.setColor(var14);
                              }
                           }

                           var2.setClip(var16);
                           var2.setColor(var14);
                           return;
                        }

                        var2.setClip(var16);
                        var2.setColor(var14);
                        return;
                     }

                     var2.setClip(var16);
                     var2.setColor(var14);
                     return;
                  }

                  var2.setClip(var16);
                  var2.setColor(var14);
               }

               return;
            }

            var2.setClip(var16);
            var2.setColor(var14);
            return;
         }

         var2.setClip(var16);
         var2.setColor(var14);
         return;
      }

      var2.setClip(var16);
      var2.setColor(var14);
   }

   private double[] a(gZ var1, FontRenderContext var2, double var3, double var5) {
      boolean var22 = fj.z;
      double[] var7 = null;
      if(var1.o.length() > 0 && var1.bb != null) {
         Insets var8 = var1.getInsets();
         if(var8 == null) {
            var8 = gZ.defaultInsets;
         }

         float var9 = (float)var8.left;
         float var10 = (float)var8.top;
         var3 -= (double)(var8.left + var8.right);
         var5 -= (double)(var8.top + var8.bottom);
         if(var3 > 0.0D && var5 > 0.0D) {
            HashMap var11 = new HashMap();
            var11.put(TextAttribute.FONT, var1.fb);
            if(var1.cb) {
               var11.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            }

            LineBreakMeasurer var12 = new LineBreakMeasurer((new AttributedString(var1.o, var11)).getIterator(), var2);
            int var13 = (int)Math.rint((double)var1.fb.getLineMetrics(var1.o, var2).getHeight()) - 3;
            boolean var14 = var1.j == 2;
            boolean var15 = var1.j == 1;
            int var16 = var1.o.indexOf(10);
            if(var16 == -1) {
               var16 = var1.o.length();
            }

            TextLayout var17;
            while(var16 <= var12.getPosition() && var12.getPosition() < var1.o.length()) {
               var17 = var12.nextLayout(100.0F, var16 + 1, false);
               var10 += var17.getAscent() + var17.getLeading() + var17.getDescent();
               var16 = var1.o.indexOf(10, var16 + 1);
               if(var16 == -1) {
                  var16 = var1.o.length();
               }
            }

            do {
               if(var12.getPosition() >= var1.o.length()) {
                  return var7;
               }

               float var18;
               float var19;
               if(var5 < (double)(var10 + (float)(2 * var13))) {
                  var17 = new TextLayout("…", var11, var2);
                  var18 = var17.getAdvance();
                  float var20;
                  TextLayout var23;
                  if(var12.nextOffset((float)var3, var16, false) >= var1.o.length()) {
                     var23 = var12.nextLayout((float)var3);
                     if(var23 == null) {
                        return var7;
                     }

                     var20 = var15?((float)var3 - var23.getAdvance()) * 0.5F:(var23.isLeftToRight() && !var14?0.0F:(float)var3 - var23.getAdvance());
                     if(var7 != null) {
                        var7[0] = Math.min(var7[0], (double)(var9 + var20));
                        var7[1] = Math.min(var7[1], (double)var10);
                        var7[2] = Math.max(var7[2], (double)(var9 + var20 + var23.getAdvance()));
                        var7[3] = Math.max(var7[3], (double)(var10 + var23.getAscent() + var23.getDescent()));
                        if(!var22) {
                           return var7;
                        }
                     }

                     var7 = new double[]{(double)(var9 + var20), (double)var10, (double)(var9 + var20 + var23.getAdvance()), (double)(var10 + var23.getAscent() + var23.getDescent())};
                     return var7;
                  }

                  if(var3 > (double)var18) {
                     var23 = var12.nextLayout((float)var3 - var18, var16, false);
                     if(var12.getPosition() == var16) {
                        var16 = var1.o.indexOf(10, var16 + 1);
                        if(var16 == -1) {
                           var16 = var1.o.length();
                        }
                     }

                     if(var23 != null) {
                        if(var12.getPosition() < var1.o.length()) {
                           var20 = var23.getAdvance() + var17.getAdvance();
                           float var21 = var15?((float)var3 - var20) * 0.5F:(var23.isLeftToRight() && !var14?0.0F:(float)var3 - var20);
                           if(var7 != null) {
                              var7[0] = Math.min(var7[0], (double)(var9 + var21));
                              var7[1] = Math.min(var7[1], (double)var10);
                              var7[2] = Math.max(var7[2], (double)(var9 + var21 + var20));
                              var7[3] = Math.max(var7[3], (double)(var10 + var23.getAscent() + var23.getDescent()));
                              if(!var22) {
                                 return var7;
                              }
                           }

                           var7 = new double[]{(double)(var9 + var21), (double)var10, (double)(var9 + var21 + var20), (double)(var10 + var23.getAscent() + var23.getDescent())};
                           if(!var22) {
                              return var7;
                           }
                        }

                        var20 = var15?((float)var3 - var23.getAdvance()) * 0.5F:(var23.isLeftToRight() && !var14?0.0F:(float)var3 - var23.getAdvance());
                        if(var7 != null) {
                           var7[0] = Math.min(var7[0], (double)(var9 + var20));
                           var7[1] = Math.min(var7[1], (double)var10);
                           var7[2] = Math.max(var7[2], (double)(var9 + var20 + var23.getAdvance()));
                           var7[3] = Math.max(var7[3], (double)(var10 + var23.getAscent() + var23.getDescent()));
                           if(!var22) {
                              return var7;
                           }
                        }

                        var7 = new double[]{(double)(var9 + var20), (double)var10, (double)(var9 + var20 + var23.getAdvance()), (double)(var10 + var23.getAscent() + var23.getDescent())};
                        return var7;
                     }

                     var20 = var15?((float)var3 - var17.getAdvance()) * 0.5F:(var17.isLeftToRight() && !var14?0.0F:(float)var3 - var17.getAdvance());
                     if(var7 != null) {
                        var7[0] = Math.min(var7[0], (double)(var9 + var20));
                        var7[1] = Math.min(var7[1], (double)var10);
                        var7[2] = Math.max(var7[2], (double)(var9 + var20 + var17.getAdvance()));
                        var7[3] = Math.max(var7[3], (double)(var10 + var23.getAscent() + var23.getDescent()));
                        if(!var22) {
                           return var7;
                        }
                     }

                     var7 = new double[]{(double)(var9 + var20), (double)var10, (double)(var9 + var20 + var17.getAdvance()), (double)(var10 + var23.getAscent() + var23.getDescent())};
                     return var7;
                  }

                  var19 = var15?((float)var3 - var17.getAdvance()) * 0.5F:(var17.isLeftToRight() && !var14?0.0F:(float)var3 - var17.getAdvance());
                  if(var7 != null) {
                     var7[0] = Math.min(var7[0], (double)(var9 + var19));
                     var7[1] = Math.min(var7[1], (double)var10);
                     var7[2] = Math.max(var7[2], (double)(var9 + var19 + var17.getAdvance()));
                     var7[3] = Math.max(var7[3], (double)(var10 + var17.getAscent() + var17.getDescent()));
                     if(!var22) {
                        return var7;
                     }
                  }

                  var7 = new double[]{(double)(var9 + var19), (double)var10, (double)(var9 + var19 + var17.getAdvance()), (double)(var10 + var17.getAscent() + var17.getDescent())};
                  return var7;
               }

               var17 = var12.nextLayout((float)var3, var16, false);
               if(var17 == null) {
                  return var7;
               }

               if(var12.getPosition() == var16) {
                  var16 = var1.o.indexOf(10, var16 + 1);
                  if(var16 == -1) {
                     var16 = var1.o.length();
                  }
               }

               label198: {
                  var18 = var15?((float)var3 - var17.getAdvance()) * 0.5F:(var17.isLeftToRight() && !var14?0.0F:(float)var3 - var17.getAdvance());
                  var19 = var17.getAscent() + var17.getDescent() + var17.getLeading();
                  if(var7 != null) {
                     var7[0] = Math.min(var7[0], (double)(var9 + var18));
                     var7[1] = Math.min(var7[1], (double)var10);
                     var7[2] = Math.max(var7[2], (double)(var9 + var18 + var17.getAdvance()));
                     var7[3] = Math.max(var7[3], (double)(var10 + var17.getAscent() + var17.getDescent()));
                     if(!var22) {
                        break label198;
                     }
                  }

                  var7 = new double[]{(double)(var9 + var18), (double)var10, (double)(var9 + var18 + var17.getAdvance()), (double)(var10 + var17.getAscent() + var17.getDescent())};
               }

               var10 += var19;
            } while(!var22);

            return var7;
         } else {
            return var7;
         }
      } else {
         return var7;
      }
   }

   public y.d.n a(gZ var1) {
      return this.a()?this.a(var1, this.c(var1)):this.c(var1);
   }

   private y.d.n c(gZ var1) {
      double var4;
      double[] var6;
      label30: {
         boolean var13 = fj.z;
         double var2 = var1.contentWidth;
         var4 = var1.contentHeight;
         if(!var1.w) {
            var6 = null;
            if(!var13) {
               break label30;
            }
         }

         FontRenderContext var7;
         label22: {
            FontRenderContext var8 = gZ.access$000();
            if(var1.s != 0.0F) {
               AffineTransform var9 = var8.getTransform();
               var9.rotate(Math.toRadians((double)var1.s));
               var7 = new FontRenderContext(var9, var8.isAntiAliased(), var8.usesFractionalMetrics());
               if(!var13) {
                  break label22;
               }
            }

            var7 = var8;
         }

         var6 = this.a(var1, var7, var2, var4);
      }

      if(var6 == null) {
         Insets var15 = var1.getInsets();
         if(var15 == null) {
            var15 = gZ.defaultInsets;
         }

         return new y.d.n((double)var15.left, (double)var15.top - var4, 0.0D, 0.0D);
      } else {
         double var14 = var6[0];
         double var16 = var6[1];
         double var11 = var6[3] - var16;
         return new y.d.n(var14, var16 + var11 - var4, var6[2] - var14, var11);
      }
   }

   public y.d.n b(gZ var1) {
      return this.a()?this.a(var1, this.d(var1)):this.d(var1);
   }

   private y.d.n d(gZ var1) {
      return new y.d.n(0.0D, -var1.contentHeight, 0.0D, 0.0D);
   }

   public void a(gZ var1, FontRenderContext var2, byte var3) {
      boolean var17 = fj.z;
      switch(var3) {
      case 1:
         if(var1.o.length() <= 0) {
            break;
         }

         Insets var4 = var1.getInsets();
         if(var4 == null) {
            var4 = gZ.defaultInsets;
         }

         fj var5 = ((eR)var1).g();
         if(var5 == null) {
            return;
         }

         double var6 = var5.getWidth();
         double var8 = 0.0D;
         double var10 = java.lang.Double.MAX_VALUE;
         float var12 = (float)var8 + (float)var4.top;
         var6 -= (double)(var4.left + var4.right);
         if(var6 <= 0.0D || var10 <= 0.0D) {
            return;
         }

         HashMap var13 = new HashMap();
         var13.put(TextAttribute.FONT, var1.fb);
         if(var1.cb) {
            var13.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         }

         LineBreakMeasurer var14 = new LineBreakMeasurer((new AttributedString(var1.o, var13)).getIterator(), var2);
         int var15 = var1.o.indexOf(10);
         if(var15 == -1) {
            var15 = var1.o.length();
         }

         label96: {
            TextLayout var16;
            while(var15 <= var14.getPosition() && var14.getPosition() < var1.o.length()) {
               var16 = var14.nextLayout(100.0F, var15 + 1, false);
               var12 += var16.getAscent() + var16.getLeading() + var16.getDescent();
               var15 = var1.o.indexOf(10, var15 + 1);
               if(var15 == -1) {
                  var15 = var1.o.length();
                  if(var17) {
                     break label96;
                  }

                  if(var17) {
                     break;
                  }
               }
            }

            while(var14.getPosition() < var1.o.length()) {
               var16 = var14.nextLayout((float)var6, var15, false);
               if(var17) {
                  break label96;
               }

               if(var16 == null) {
                  return;
               }

               if(var14.getPosition() == var15) {
                  var15 = var1.o.indexOf(10, var15 + 1);
                  if(var15 == -1) {
                     var15 = var1.o.length();
                  }
               }

               var12 += var16.getAscent() + var16.getDescent() + var16.getLeading();
               if(var17) {
                  break;
               }
            }

            var1.setContentSize(var6, (double)(var12 + 2.0F + (float)var4.bottom));
         }

         if(!var17) {
            break;
         }
      case 0:
      case 2:
         HashMap var18 = new HashMap();
         var18.put(TextAttribute.FONT, var1.fb);
         if(var1.cb) {
            var18.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         }

         if(var1.o.length() > 0) {
            AttributedCharacterIterator var19 = (new AttributedString(var1.o, var18)).getIterator();
            TextLayout var20 = new TextLayout(var19, var2);
            var20.getAdvance();
            Insets var7 = var1.getInsets();
            if(var7 == null) {
               var7 = gZ.defaultInsets;
            }

            var1.setContentSize((double)(var20.getAdvance() + (float)var7.left + (float)var7.right + 3.0F), (double)((float)(3 + var7.top + var7.bottom) + var20.getAscent() + var20.getDescent() + var20.getLeading()));
         }
      case 3:
      case 4:
      }

   }
}
