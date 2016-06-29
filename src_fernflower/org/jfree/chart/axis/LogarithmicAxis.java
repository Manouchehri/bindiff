package org.jfree.chart.axis;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class LogarithmicAxis extends NumberAxis {
   private static final long serialVersionUID = 2502918599004103054L;
   public static final double LOG10_VALUE = Math.log(10.0D);
   public static final double SMALL_LOG_VALUE = 1.0E-100D;
   protected boolean allowNegativesFlag = false;
   protected boolean strictValuesFlag = true;
   protected final NumberFormat numberFormatterObj = NumberFormat.getInstance();
   protected boolean expTickLabelsFlag = false;
   protected boolean log10TickLabelsFlag = false;
   protected boolean autoRangeNextLogFlag = false;
   protected boolean smallLogFlag = false;

   public LogarithmicAxis(String var1) {
      super(var1);
      this.setupNumberFmtObj();
   }

   public void setAllowNegativesFlag(boolean var1) {
      this.allowNegativesFlag = var1;
   }

   public boolean getAllowNegativesFlag() {
      return this.allowNegativesFlag;
   }

   public void setStrictValuesFlag(boolean var1) {
      this.strictValuesFlag = var1;
   }

   public boolean getStrictValuesFlag() {
      return this.strictValuesFlag;
   }

   public void setExpTickLabelsFlag(boolean var1) {
      this.expTickLabelsFlag = var1;
      this.setupNumberFmtObj();
   }

   public boolean getExpTickLabelsFlag() {
      return this.expTickLabelsFlag;
   }

   public void setLog10TickLabelsFlag(boolean var1) {
      this.log10TickLabelsFlag = var1;
   }

   public boolean getLog10TickLabelsFlag() {
      return this.log10TickLabelsFlag;
   }

   public void setAutoRangeNextLogFlag(boolean var1) {
      this.autoRangeNextLogFlag = var1;
   }

   public boolean getAutoRangeNextLogFlag() {
      return this.autoRangeNextLogFlag;
   }

   public void setRange(Range var1) {
      super.setRange(var1);
      this.setupSmallLogFlag();
   }

   protected void setupSmallLogFlag() {
      double var1 = this.getRange().getLowerBound();
      this.smallLogFlag = !this.allowNegativesFlag && var1 < 10.0D && var1 > 0.0D;
   }

   protected void setupNumberFmtObj() {
      if(this.numberFormatterObj instanceof DecimalFormat) {
         ((DecimalFormat)this.numberFormatterObj).applyPattern(this.expTickLabelsFlag?"0E0":"0.###");
      }

   }

   protected double switchedLog10(double var1) {
      return this.smallLogFlag?Math.log(var1) / LOG10_VALUE:this.adjustedLog10(var1);
   }

   public double switchedPow10(double var1) {
      return this.smallLogFlag?Math.pow(10.0D, var1):this.adjustedPow10(var1);
   }

   public double adjustedLog10(double var1) {
      boolean var3 = var1 < 0.0D;
      if(var3) {
         var1 = -var1;
      }

      if(var1 < 10.0D) {
         var1 += (10.0D - var1) / 10.0D;
      }

      double var4 = Math.log(var1) / LOG10_VALUE;
      return var3?-var4:var4;
   }

   public double adjustedPow10(double var1) {
      boolean var3 = var1 < 0.0D;
      if(var3) {
         var1 = -var1;
      }

      double var4;
      if(var1 < 1.0D) {
         var4 = (Math.pow(10.0D, var1 + 1.0D) - 10.0D) / 9.0D;
      } else {
         var4 = Math.pow(10.0D, var1);
      }

      return var3?-var4:var4;
   }

   protected double computeLogFloor(double var1) {
      double var3;
      if(this.allowNegativesFlag) {
         if(var1 > 10.0D) {
            var3 = Math.log(var1) / LOG10_VALUE;
            var3 = Math.floor(var3);
            var3 = Math.pow(10.0D, var3);
         } else if(var1 < -10.0D) {
            var3 = Math.log(-var1) / LOG10_VALUE;
            var3 = Math.floor(-var3);
            var3 = -Math.pow(10.0D, -var3);
         } else {
            var3 = Math.floor(var1);
         }
      } else if(var1 > 0.0D) {
         var3 = Math.log(var1) / LOG10_VALUE;
         var3 = Math.floor(var3);
         var3 = Math.pow(10.0D, var3);
      } else {
         var3 = Math.floor(var1);
      }

      return var3;
   }

   protected double computeLogCeil(double var1) {
      double var3;
      if(this.allowNegativesFlag) {
         if(var1 > 10.0D) {
            var3 = Math.log(var1) / LOG10_VALUE;
            var3 = Math.ceil(var3);
            var3 = Math.pow(10.0D, var3);
         } else if(var1 < -10.0D) {
            var3 = Math.log(-var1) / LOG10_VALUE;
            var3 = Math.ceil(-var3);
            var3 = -Math.pow(10.0D, -var3);
         } else {
            var3 = Math.ceil(var1);
         }
      } else if(var1 > 0.0D) {
         var3 = Math.log(var1) / LOG10_VALUE;
         var3 = Math.ceil(var3);
         var3 = Math.pow(10.0D, var3);
      } else {
         var3 = Math.ceil(var1);
      }

      return var3;
   }

   public void autoAdjustRange() {
      Plot var1 = this.getPlot();
      if(var1 != null) {
         if(var1 instanceof ValueAxisPlot) {
            ValueAxisPlot var2 = (ValueAxisPlot)var1;
            Range var5 = var2.getDataRange(this);
            double var3;
            if(var5 == null) {
               var5 = this.getDefaultAutoRange();
               var3 = var5.getLowerBound();
            } else {
               var3 = var5.getLowerBound();
               if(this.strictValuesFlag && !this.allowNegativesFlag && var3 <= 0.0D) {
                  throw new RuntimeException("Values less than or equal to zero not allowed with logarithmic axis");
               }
            }

            double var6;
            double var8;
            double var10;
            if(var3 > 0.0D && (var6 = this.getLowerMargin()) > 0.0D) {
               var8 = Math.log(var3) / LOG10_VALUE;
               if((var10 = Math.abs(var8)) < 1.0D) {
                  var10 = 1.0D;
               }

               var3 = Math.pow(10.0D, var8 - var10 * var6);
            }

            if(this.autoRangeNextLogFlag) {
               var3 = this.computeLogFloor(var3);
            }

            if(!this.allowNegativesFlag && var3 >= 0.0D && var3 < 1.0E-100D) {
               var3 = var5.getLowerBound();
            }

            var8 = var5.getUpperBound();
            double var12;
            double var14;
            if(var8 > 0.0D && (var10 = this.getUpperMargin()) > 0.0D) {
               var12 = Math.log(var8) / LOG10_VALUE;
               if((var14 = Math.abs(var12)) < 1.0D) {
                  var14 = 1.0D;
               }

               var8 = Math.pow(10.0D, var12 + var14 * var10);
            }

            if(!this.allowNegativesFlag && var8 < 1.0D && var8 > 0.0D && var3 > 0.0D) {
               var12 = Math.log(var8) / LOG10_VALUE;
               var12 = Math.ceil(-var12 + 0.001D);
               var12 = Math.pow(10.0D, var12);
               var8 = var12 > 0.0D?Math.ceil(var8 * var12) / var12:Math.ceil(var8);
            } else {
               var8 = this.autoRangeNextLogFlag?this.computeLogCeil(var8):Math.ceil(var8);
            }

            var12 = this.getAutoRangeMinimumSize();
            if(var8 - var3 < var12) {
               var8 = (var8 + var3 + var12) / 2.0D;
               var3 = (var8 + var3 - var12) / 2.0D;
               if(var8 - var3 < var12) {
                  var14 = Math.abs(var8);
                  double var16 = var14 > 1.0E-100D?var14 / 100.0D:0.01D;
                  var8 = (var8 + var3 + var16) / 2.0D;
                  var3 = (var8 + var3 - var16) / 2.0D;
               }
            }

            this.setRange(new Range(var3, var8), false, false);
            this.setupSmallLogFlag();
         }

      }
   }

   public double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      Range var5 = this.getRange();
      double var6 = this.switchedLog10(var5.getLowerBound());
      double var8 = this.switchedLog10(var5.getUpperBound());
      double var10 = 0.0D;
      double var12 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var10 = var3.getMinX();
         var12 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var10 = var3.getMaxY();
         var12 = var3.getMinY();
      }

      var1 = this.switchedLog10(var1);
      return this.isInverted()?var12 - (var1 - var6) / (var8 - var6) * (var12 - var10):var10 + (var1 - var6) / (var8 - var6) * (var12 - var10);
   }

   public double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4) {
      Range var5 = this.getRange();
      double var6 = this.switchedLog10(var5.getLowerBound());
      double var8 = this.switchedLog10(var5.getUpperBound());
      double var10 = 0.0D;
      double var12 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var10 = var3.getX();
         var12 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var10 = var3.getMaxY();
         var12 = var3.getMinY();
      }

      return this.isInverted()?this.switchedPow10(var8 - (var1 - var10) / (var12 - var10) * (var8 - var6)):this.switchedPow10(var6 + (var1 - var10) / (var12 - var10) * (var8 - var6));
   }

   public void zoomRange(double var1, double var3) {
      double var5 = this.switchedLog10(this.getRange().getLowerBound());
      double var7 = this.switchedLog10(this.getRange().getUpperBound()) - var5;
      Range var9;
      if(this.isInverted()) {
         var9 = new Range(this.switchedPow10(var5 + var7 * (1.0D - var3)), this.switchedPow10(var5 + var7 * (1.0D - var1)));
      } else {
         var9 = new Range(this.switchedPow10(var5 + var7 * var1), this.switchedPow10(var5 + var7 * var3));
      }

      this.setRange(var9);
   }

   protected List refreshTicksHorizontal(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Range var5 = this.getRange();
      double var6 = var5.getLowerBound();
      if(this.smallLogFlag && var6 < 1.0E-100D) {
         var6 = 1.0E-100D;
      }

      double var8 = var5.getUpperBound();
      int var10 = (int)Math.rint(this.switchedLog10(var6));
      int var11 = (int)Math.rint(this.switchedLog10(var8));
      if(var10 == var11 && var10 > 0 && Math.pow(10.0D, (double)var10) > var6) {
         --var10;
      }

      boolean var15 = false;

      for(int var16 = var10; var16 <= var11; ++var16) {
         for(int var17 = 0; var17 < 10; ++var17) {
            double var12;
            String var14;
            if(this.smallLogFlag) {
               var12 = Math.pow(10.0D, (double)var16) + Math.pow(10.0D, (double)var16) * (double)var17;
               if(this.expTickLabelsFlag || var16 < 0 && var12 > 0.0D && var12 < 1.0D) {
                  if(var17 != 0 && (var16 <= -4 || var17 >= 2) && var12 < var8) {
                     var14 = "";
                  } else {
                     this.numberFormatterObj.setMaximumFractionDigits(-var16);
                     var14 = this.makeTickLabel(var12, true);
                  }
               } else {
                  var14 = var17 >= 1 && (var16 >= 1 || var17 >= 5) && var17 >= 4 - var16 && var12 < var8?"":this.makeTickLabel(var12);
               }
            } else {
               if(var15) {
                  --var17;
               }

               var12 = var16 >= 0?Math.pow(10.0D, (double)var16) + Math.pow(10.0D, (double)var16) * (double)var17:-(Math.pow(10.0D, (double)(-var16)) - Math.pow(10.0D, (double)(-var16 - 1)) * (double)var17);
               if(!var15) {
                  if(Math.abs(var12 - 1.0D) < 1.0E-4D && var6 <= 0.0D && var8 >= 0.0D) {
                     var12 = 0.0D;
                     var15 = true;
                  }
               } else {
                  var15 = false;
               }

               var14 = (!this.expTickLabelsFlag || var17 >= 2) && var17 >= 1 && (var16 >= 1 || var17 >= 5) && var17 >= 4 - var16 && var12 < var8?"":this.makeTickLabel(var12);
            }

            if(var12 > var8) {
               return var4;
            }

            if(var12 >= var6 - 1.0E-100D) {
               TextAnchor var18 = null;
               TextAnchor var19 = null;
               double var20 = 0.0D;
               if(this.isVerticalTickLabels()) {
                  var18 = TextAnchor.CENTER_RIGHT;
                  var19 = TextAnchor.CENTER_RIGHT;
                  if(var3 == RectangleEdge.TOP) {
                     var20 = 1.5707963267948966D;
                  } else {
                     var20 = -1.5707963267948966D;
                  }
               } else if(var3 == RectangleEdge.TOP) {
                  var18 = TextAnchor.BOTTOM_CENTER;
                  var19 = TextAnchor.BOTTOM_CENTER;
               } else {
                  var18 = TextAnchor.TOP_CENTER;
                  var19 = TextAnchor.TOP_CENTER;
               }

               NumberTick var22 = new NumberTick(new Double(var12), var14, var18, var19, var20);
               var4.add(var22);
            }
         }
      }

      return var4;
   }

   protected List refreshTicksVertical(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      double var5 = this.getRange().getLowerBound();
      if(this.smallLogFlag && var5 < 1.0E-100D) {
         var5 = 1.0E-100D;
      }

      double var7 = this.getRange().getUpperBound();
      int var9 = (int)Math.rint(this.switchedLog10(var5));
      int var10 = (int)Math.rint(this.switchedLog10(var7));
      if(var9 == var10 && var9 > 0 && Math.pow(10.0D, (double)var9) > var5) {
         --var9;
      }

      boolean var14 = false;

      for(int var15 = var9; var15 <= var10; ++var15) {
         byte var16 = 10;
         if(var15 == var10) {
            var16 = 1;
         }

         for(int var17 = 0; var17 < var16; ++var17) {
            double var11;
            String var13;
            NumberFormat var18;
            if(this.smallLogFlag) {
               var11 = Math.pow(10.0D, (double)var15) + Math.pow(10.0D, (double)var15) * (double)var17;
               if(var17 == 0) {
                  if(this.log10TickLabelsFlag) {
                     var13 = "10^" + var15;
                  } else if(this.expTickLabelsFlag) {
                     var13 = "1e" + var15;
                  } else if(var15 >= 0) {
                     var18 = this.getNumberFormatOverride();
                     if(var18 != null) {
                        var13 = var18.format(var11);
                     } else {
                        var13 = Long.toString((long)Math.rint(var11));
                     }
                  } else {
                     this.numberFormatterObj.setMaximumFractionDigits(-var15);
                     var13 = this.numberFormatterObj.format(var11);
                  }
               } else {
                  var13 = "";
               }
            } else {
               if(var14) {
                  --var17;
               }

               var11 = var15 >= 0?Math.pow(10.0D, (double)var15) + Math.pow(10.0D, (double)var15) * (double)var17:-(Math.pow(10.0D, (double)(-var15)) - Math.pow(10.0D, (double)(-var15 - 1)) * (double)var17);
               if(var17 == 0) {
                  if(!var14) {
                     if(var15 > var9 && var15 < var10 && Math.abs(var11 - 1.0D) < 1.0E-4D) {
                        var11 = 0.0D;
                        var14 = true;
                        var13 = "0";
                     } else if(this.log10TickLabelsFlag) {
                        var13 = (var15 < 0?"-":"") + "10^" + Math.abs(var15);
                     } else if(this.expTickLabelsFlag) {
                        var13 = (var15 < 0?"-":"") + "1e" + Math.abs(var15);
                     } else {
                        var18 = this.getNumberFormatOverride();
                        if(var18 != null) {
                           var13 = var18.format(var11);
                        } else {
                           var13 = Long.toString((long)Math.rint(var11));
                        }
                     }
                  } else {
                     var13 = "";
                     var14 = false;
                  }
               } else {
                  var13 = "";
                  var14 = false;
               }
            }

            if(var11 > var7) {
               return var4;
            }

            if(var11 >= var5 - 1.0E-100D) {
               var18 = null;
               TextAnchor var19 = null;
               double var20 = 0.0D;
               TextAnchor var22;
               if(this.isVerticalTickLabels()) {
                  if(var3 == RectangleEdge.LEFT) {
                     var22 = TextAnchor.BOTTOM_CENTER;
                     var19 = TextAnchor.BOTTOM_CENTER;
                     var20 = -1.5707963267948966D;
                  } else {
                     var22 = TextAnchor.BOTTOM_CENTER;
                     var19 = TextAnchor.BOTTOM_CENTER;
                     var20 = 1.5707963267948966D;
                  }
               } else if(var3 == RectangleEdge.LEFT) {
                  var22 = TextAnchor.CENTER_RIGHT;
                  var19 = TextAnchor.CENTER_RIGHT;
               } else {
                  var22 = TextAnchor.CENTER_LEFT;
                  var19 = TextAnchor.CENTER_LEFT;
               }

               var4.add(new NumberTick(new Double(var11), var13, var22, var19, var20));
            }
         }
      }

      return var4;
   }

   protected String makeTickLabel(double var1, boolean var3) {
      return !this.expTickLabelsFlag && !var3?this.getTickUnit().valueToString(var1):this.numberFormatterObj.format(var1).toLowerCase();
   }

   protected String makeTickLabel(double var1) {
      return this.makeTickLabel(var1, false);
   }
}
