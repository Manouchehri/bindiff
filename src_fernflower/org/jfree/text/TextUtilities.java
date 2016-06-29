package org.jfree.text;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.text.BreakIterator;
import org.jfree.base.BaseBoot;
import org.jfree.text.TextBlock;
import org.jfree.text.TextFragment;
import org.jfree.text.TextLine;
import org.jfree.text.TextMeasurer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;
import org.jfree.util.ObjectUtilities;

public class TextUtilities {
   protected static final LogContext logger;
   private static boolean useDrawRotatedStringWorkaround;
   private static boolean useFontMetricsGetStringBounds;
   static Class class$org$jfree$text$TextUtilities;

   public static TextBlock createTextBlock(String var0, Font var1, Paint var2) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else {
         TextBlock var3 = new TextBlock();
         String var4 = var0;
         boolean var5 = var0.length() > 0;
         boolean var6 = false;

         while(var5) {
            int var7 = var4.indexOf("\n");
            if(var7 > 0) {
               String var8 = var4.substring(0, var7);
               if(var7 < var4.length() - 1) {
                  var3.addLine(var8, var1, var2);
                  var4 = var4.substring(var7 + 1);
               } else {
                  var5 = false;
               }
            } else if(var7 == 0) {
               if(var7 < var4.length() - 1) {
                  var4 = var4.substring(var7 + 1);
               } else {
                  var5 = false;
               }
            } else {
               var3.addLine(var4, var1, var2);
               var5 = false;
            }
         }

         return var3;
      }
   }

   public static TextBlock createTextBlock(String var0, Font var1, Paint var2, float var3, TextMeasurer var4) {
      return createTextBlock(var0, var1, var2, var3, Integer.MAX_VALUE, var4);
   }

   public static TextBlock createTextBlock(String var0, Font var1, Paint var2, float var3, int var4, TextMeasurer var5) {
      TextBlock var6 = new TextBlock();
      BreakIterator var7 = BreakIterator.getLineInstance();
      var7.setText(var0);
      int var8 = 0;
      int var9 = 0;
      int var10 = var0.length();

      while(var8 < var10 && var9 < var4) {
         int var11 = nextLineBreak(var0, var8, var3, var7, var5);
         if(var11 == -1) {
            var6.addLine(var0.substring(var8), var1, var2);
            return var6;
         }

         var6.addLine(var0.substring(var8, var11), var1, var2);
         ++var9;

         for(var8 = var11; var8 < var0.length() && var0.charAt(var8) == 10; ++var8) {
            ;
         }
      }

      if(var8 < var10) {
         TextLine var16 = var6.getLastLine();
         TextFragment var12 = var16.getLastTextFragment();
         String var13 = var12.getText();
         String var14 = "...";
         if(var13.length() > 3) {
            var14 = var13.substring(0, var13.length() - 3) + "...";
         }

         var16.removeFragment(var12);
         TextFragment var15 = new TextFragment(var14, var12.getFont(), var12.getPaint());
         var16.addFragment(var15);
      }

      return var6;
   }

   private static int nextLineBreak(String var0, int var1, float var2, BreakIterator var3, TextMeasurer var4) {
      int var5 = var1;
      float var7 = 0.0F;
      boolean var8 = true;
      int var9 = var0.indexOf(10, var1);
      if(var9 < 0) {
         var9 = Integer.MAX_VALUE;
      }

      int var6;
      while((var6 = var3.next()) != -1) {
         if(var6 > var9) {
            return var9;
         }

         var7 += var4.getStringWidth(var0, var5, var6);
         if(var7 > var2) {
            if(var8) {
               do {
                  if(var4.getStringWidth(var0, var1, var6) <= var2) {
                     return var6;
                  }

                  --var6;
               } while(var6 > var1);

               return var6;
            }

            var6 = var3.previous();
            return var6;
         }

         var8 = false;
         var5 = var6;
      }

      return -1;
   }

   public static Rectangle2D getTextBounds(String var0, Graphics2D var1, FontMetrics var2) {
      Object var3;
      if(useFontMetricsGetStringBounds) {
         var3 = var2.getStringBounds(var0, var1);
         LineMetrics var4 = var2.getFont().getLineMetrics(var0, var1.getFontRenderContext());
         ((Rectangle2D)var3).setRect(((Rectangle2D)var3).getX(), ((Rectangle2D)var3).getY(), ((Rectangle2D)var3).getWidth(), (double)var4.getHeight());
      } else {
         double var8 = (double)var2.stringWidth(var0);
         double var6 = (double)var2.getHeight();
         if(logger.isDebugEnabled()) {
            logger.debug("Height = " + var6);
         }

         var3 = new Double(0.0D, (double)(-var2.getAscent()), var8, var6);
      }

      return (Rectangle2D)var3;
   }

   public static Rectangle2D drawAlignedString(String var0, Graphics2D var1, float var2, float var3, TextAnchor var4) {
      Double var5 = new Double();
      float[] var6 = deriveTextBoundsAnchorOffsets(var1, var0, var4, var5);
      var5.setRect((double)(var2 + var6[0]), (double)(var3 + var6[1] + var6[2]), var5.getWidth(), var5.getHeight());
      var1.drawString(var0, var2 + var6[0], var3 + var6[1]);
      return var5;
   }

   private static float[] deriveTextBoundsAnchorOffsets(Graphics2D var0, String var1, TextAnchor var2, Rectangle2D var3) {
      float[] var4 = new float[3];
      FontRenderContext var5 = var0.getFontRenderContext();
      Font var6 = var0.getFont();
      FontMetrics var7 = var0.getFontMetrics(var6);
      Rectangle2D var8 = getTextBounds(var1, var0, var7);
      LineMetrics var9 = var6.getLineMetrics(var1, var5);
      float var10 = var9.getAscent();
      var4[2] = -var10;
      float var11 = var10 / 2.0F;
      float var12 = var9.getDescent();
      float var13 = var9.getLeading();
      float var14 = 0.0F;
      float var15 = 0.0F;
      if(var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.CENTER && var2 != TextAnchor.BOTTOM_CENTER && var2 != TextAnchor.BASELINE_CENTER && var2 != TextAnchor.HALF_ASCENT_CENTER) {
         if(var2 == TextAnchor.TOP_RIGHT || var2 == TextAnchor.CENTER_RIGHT || var2 == TextAnchor.BOTTOM_RIGHT || var2 == TextAnchor.BASELINE_RIGHT || var2 == TextAnchor.HALF_ASCENT_RIGHT) {
            var14 = (float)(-var8.getWidth());
         }
      } else {
         var14 = (float)(-var8.getWidth()) / 2.0F;
      }

      if(var2 != TextAnchor.TOP_LEFT && var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.TOP_RIGHT) {
         if(var2 != TextAnchor.HALF_ASCENT_LEFT && var2 != TextAnchor.HALF_ASCENT_CENTER && var2 != TextAnchor.HALF_ASCENT_RIGHT) {
            if(var2 != TextAnchor.CENTER_LEFT && var2 != TextAnchor.CENTER && var2 != TextAnchor.CENTER_RIGHT) {
               if(var2 != TextAnchor.BASELINE_LEFT && var2 != TextAnchor.BASELINE_CENTER && var2 != TextAnchor.BASELINE_RIGHT) {
                  if(var2 == TextAnchor.BOTTOM_LEFT || var2 == TextAnchor.BOTTOM_CENTER || var2 == TextAnchor.BOTTOM_RIGHT) {
                     var15 = -var9.getDescent() - var9.getLeading();
                  }
               } else {
                  var15 = 0.0F;
               }
            } else {
               var15 = -var12 - var13 + (float)(var8.getHeight() / 2.0D);
            }
         } else {
            var15 = var11;
         }
      } else {
         var15 = -var12 - var13 + (float)var8.getHeight();
      }

      if(var3 != null) {
         var3.setRect(var8);
      }

      var4[0] = var14;
      var4[1] = var15;
      return var4;
   }

   public static void setUseDrawRotatedStringWorkaround(boolean var0) {
      useDrawRotatedStringWorkaround = var0;
   }

   public static void drawRotatedString(String var0, Graphics2D var1, double var2, float var4, float var5) {
      drawRotatedString(var0, var1, var4, var5, var2, var4, var5);
   }

   public static void drawRotatedString(String var0, Graphics2D var1, float var2, float var3, double var4, float var6, float var7) {
      if(var0 != null && !var0.equals("")) {
         AffineTransform var8 = var1.getTransform();
         AffineTransform var9 = AffineTransform.getRotateInstance(var4, (double)var6, (double)var7);
         var1.transform(var9);
         if(useDrawRotatedStringWorkaround) {
            TextLayout var10 = new TextLayout(var0, var1.getFont(), var1.getFontRenderContext());
            var10.draw(var1, var2, var3);
         } else {
            var1.drawString(var0, var2, var3);
         }

         var1.setTransform(var8);
      }
   }

   public static void drawRotatedString(String var0, Graphics2D var1, float var2, float var3, TextAnchor var4, double var5, float var7, float var8) {
      if(var0 != null && !var0.equals("")) {
         float[] var9 = deriveTextBoundsAnchorOffsets(var1, var0, var4);
         drawRotatedString(var0, var1, var2 + var9[0], var3 + var9[1], var5, var7, var8);
      }
   }

   public static void drawRotatedString(String var0, Graphics2D var1, float var2, float var3, TextAnchor var4, double var5, TextAnchor var7) {
      if(var0 != null && !var0.equals("")) {
         float[] var8 = deriveTextBoundsAnchorOffsets(var1, var0, var4);
         float[] var9 = deriveRotationAnchorOffsets(var1, var0, var7);
         drawRotatedString(var0, var1, var2 + var8[0], var3 + var8[1], var5, var2 + var8[0] + var9[0], var3 + var8[1] + var9[1]);
      }
   }

   public static Shape calculateRotatedStringBounds(String var0, Graphics2D var1, float var2, float var3, TextAnchor var4, double var5, TextAnchor var7) {
      if(var0 != null && !var0.equals("")) {
         float[] var8 = deriveTextBoundsAnchorOffsets(var1, var0, var4);
         if(logger.isDebugEnabled()) {
            logger.debug("TextBoundsAnchorOffsets = " + var8[0] + ", " + var8[1]);
         }

         float[] var9 = deriveRotationAnchorOffsets(var1, var0, var7);
         if(logger.isDebugEnabled()) {
            logger.debug("RotationAnchorOffsets = " + var9[0] + ", " + var9[1]);
         }

         Shape var10 = calculateRotatedStringBounds(var0, var1, var2 + var8[0], var3 + var8[1], var5, var2 + var8[0] + var9[0], var3 + var8[1] + var9[1]);
         return var10;
      } else {
         return null;
      }
   }

   private static float[] deriveTextBoundsAnchorOffsets(Graphics2D var0, String var1, TextAnchor var2) {
      float[] var3 = new float[2];
      FontRenderContext var4 = var0.getFontRenderContext();
      Font var5 = var0.getFont();
      FontMetrics var6 = var0.getFontMetrics(var5);
      Rectangle2D var7 = getTextBounds(var1, var0, var6);
      LineMetrics var8 = var5.getLineMetrics(var1, var4);
      float var9 = var8.getAscent();
      float var10 = var9 / 2.0F;
      float var11 = var8.getDescent();
      float var12 = var8.getLeading();
      float var13 = 0.0F;
      float var14 = 0.0F;
      if(var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.CENTER && var2 != TextAnchor.BOTTOM_CENTER && var2 != TextAnchor.BASELINE_CENTER && var2 != TextAnchor.HALF_ASCENT_CENTER) {
         if(var2 == TextAnchor.TOP_RIGHT || var2 == TextAnchor.CENTER_RIGHT || var2 == TextAnchor.BOTTOM_RIGHT || var2 == TextAnchor.BASELINE_RIGHT || var2 == TextAnchor.HALF_ASCENT_RIGHT) {
            var13 = (float)(-var7.getWidth());
         }
      } else {
         var13 = (float)(-var7.getWidth()) / 2.0F;
      }

      if(var2 != TextAnchor.TOP_LEFT && var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.TOP_RIGHT) {
         if(var2 != TextAnchor.HALF_ASCENT_LEFT && var2 != TextAnchor.HALF_ASCENT_CENTER && var2 != TextAnchor.HALF_ASCENT_RIGHT) {
            if(var2 != TextAnchor.CENTER_LEFT && var2 != TextAnchor.CENTER && var2 != TextAnchor.CENTER_RIGHT) {
               if(var2 != TextAnchor.BASELINE_LEFT && var2 != TextAnchor.BASELINE_CENTER && var2 != TextAnchor.BASELINE_RIGHT) {
                  if(var2 == TextAnchor.BOTTOM_LEFT || var2 == TextAnchor.BOTTOM_CENTER || var2 == TextAnchor.BOTTOM_RIGHT) {
                     var14 = -var8.getDescent() - var8.getLeading();
                  }
               } else {
                  var14 = 0.0F;
               }
            } else {
               var14 = -var11 - var12 + (float)(var7.getHeight() / 2.0D);
            }
         } else {
            var14 = var10;
         }
      } else {
         var14 = -var11 - var12 + (float)var7.getHeight();
      }

      var3[0] = var13;
      var3[1] = var14;
      return var3;
   }

   private static float[] deriveRotationAnchorOffsets(Graphics2D var0, String var1, TextAnchor var2) {
      float[] var3 = new float[2];
      FontRenderContext var4 = var0.getFontRenderContext();
      LineMetrics var5 = var0.getFont().getLineMetrics(var1, var4);
      FontMetrics var6 = var0.getFontMetrics();
      Rectangle2D var7 = getTextBounds(var1, var0, var6);
      float var8 = var5.getAscent();
      float var9 = var8 / 2.0F;
      float var10 = var5.getDescent();
      float var11 = var5.getLeading();
      float var12 = 0.0F;
      float var13 = 0.0F;
      if(var2 != TextAnchor.TOP_LEFT && var2 != TextAnchor.CENTER_LEFT && var2 != TextAnchor.BOTTOM_LEFT && var2 != TextAnchor.BASELINE_LEFT && var2 != TextAnchor.HALF_ASCENT_LEFT) {
         if(var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.CENTER && var2 != TextAnchor.BOTTOM_CENTER && var2 != TextAnchor.BASELINE_CENTER && var2 != TextAnchor.HALF_ASCENT_CENTER) {
            if(var2 == TextAnchor.TOP_RIGHT || var2 == TextAnchor.CENTER_RIGHT || var2 == TextAnchor.BOTTOM_RIGHT || var2 == TextAnchor.BASELINE_RIGHT || var2 == TextAnchor.HALF_ASCENT_RIGHT) {
               var12 = (float)var7.getWidth();
            }
         } else {
            var12 = (float)var7.getWidth() / 2.0F;
         }
      } else {
         var12 = 0.0F;
      }

      if(var2 != TextAnchor.TOP_LEFT && var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.TOP_RIGHT) {
         if(var2 != TextAnchor.CENTER_LEFT && var2 != TextAnchor.CENTER && var2 != TextAnchor.CENTER_RIGHT) {
            if(var2 != TextAnchor.HALF_ASCENT_LEFT && var2 != TextAnchor.HALF_ASCENT_CENTER && var2 != TextAnchor.HALF_ASCENT_RIGHT) {
               if(var2 != TextAnchor.BASELINE_LEFT && var2 != TextAnchor.BASELINE_CENTER && var2 != TextAnchor.BASELINE_RIGHT) {
                  if(var2 == TextAnchor.BOTTOM_LEFT || var2 == TextAnchor.BOTTOM_CENTER || var2 == TextAnchor.BOTTOM_RIGHT) {
                     var13 = var5.getDescent() + var5.getLeading();
                  }
               } else {
                  var13 = 0.0F;
               }
            } else {
               var13 = -var9;
            }
         } else {
            var13 = var10 + var11 - (float)(var7.getHeight() / 2.0D);
         }
      } else {
         var13 = var10 + var11 - (float)var7.getHeight();
      }

      var3[0] = var12;
      var3[1] = var13;
      return var3;
   }

   public static Shape calculateRotatedStringBounds(String var0, Graphics2D var1, float var2, float var3, double var4, float var6, float var7) {
      if(var0 != null && !var0.equals("")) {
         FontMetrics var8 = var1.getFontMetrics();
         Rectangle2D var9 = getTextBounds(var0, var1, var8);
         AffineTransform var10 = AffineTransform.getTranslateInstance((double)var2, (double)var3);
         Shape var11 = var10.createTransformedShape(var9);
         AffineTransform var12 = AffineTransform.getRotateInstance(var4, (double)var6, (double)var7);
         Shape var13 = var12.createTransformedShape(var11);
         return var13;
      } else {
         return null;
      }
   }

   public static boolean getUseFontMetricsGetStringBounds() {
      return useFontMetricsGetStringBounds;
   }

   public static void setUseFontMetricsGetStringBounds(boolean var0) {
      useFontMetricsGetStringBounds = var0;
   }

   public static boolean isUseDrawRotatedStringWorkaround() {
      return useDrawRotatedStringWorkaround;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      logger = Log.createContext(class$org$jfree$text$TextUtilities == null?(class$org$jfree$text$TextUtilities = class$("org.jfree.text.TextUtilities")):class$org$jfree$text$TextUtilities);
      boolean var0 = ObjectUtilities.isJDK14();
      String var1 = BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.text.UseDrawRotatedStringWorkaround", "auto");
      if(var1.equals("auto")) {
         useDrawRotatedStringWorkaround = !var0;
      } else {
         useDrawRotatedStringWorkaround = var1.equals("true");
      }

      String var2 = BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.text.UseFontMetricsGetStringBounds", "auto");
      if(var2.equals("auto")) {
         useFontMetricsGetStringBounds = var0;
      } else {
         useFontMetricsGetStringBounds = var2.equals("true");
      }

   }
}
