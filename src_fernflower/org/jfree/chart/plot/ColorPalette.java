package org.jfree.chart.plot;

import java.awt.Color;
import java.awt.Paint;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.jfree.chart.axis.ValueTick;

public abstract class ColorPalette implements Serializable, Cloneable {
   private static final long serialVersionUID = -9029901853079622051L;
   protected double minZ = -1.0D;
   protected double maxZ = -1.0D;
   protected int[] r;
   protected int[] g;
   protected int[] b;
   protected double[] tickValues = null;
   protected boolean logscale = false;
   protected boolean inverse = false;
   protected String paletteName = null;
   protected boolean stepped = false;
   protected static final double log10 = Math.log(10.0D);

   public Paint getColor(double var1) {
      int var3 = (int)(253.0D * (var1 - this.minZ) / (this.maxZ - this.minZ)) + 2;
      return new Color(this.r[var3], this.g[var3], this.b[var3]);
   }

   public Color getColor(int var1) {
      return new Color(this.r[var1], this.g[var1], this.b[var1]);
   }

   public Color getColorLinear(double var1) {
      boolean var3 = false;
      if(this.stepped) {
         int var4 = Arrays.binarySearch(this.tickValues, var1);
         if(var4 < 0) {
            var4 = -1 * var4 - 2;
         }

         if(var4 < 0) {
            var1 = this.minZ;
         } else {
            var1 = this.tickValues[var4];
         }
      }

      int var5 = (int)(253.0D * (var1 - this.minZ) / (this.maxZ - this.minZ)) + 2;
      var5 = Math.min(var5, 255);
      var5 = Math.max(var5, 2);
      return this.getColor(var5);
   }

   public Color getColorLog(double var1) {
      boolean var3 = false;
      double var4 = this.minZ;
      double var6 = this.maxZ;
      if(this.minZ <= 0.0D) {
         this.maxZ = var6 - var4 + 1.0D;
         this.minZ = 1.0D;
         var1 = var1 - var4 + 1.0D;
      }

      double var8 = Math.log(this.minZ) / log10;
      double var10 = Math.log(this.maxZ) / log10;
      var1 = Math.log(var1) / log10;
      int var14;
      if(this.stepped) {
         int var12 = this.tickValues.length;
         int var13 = 256 / (var12 - 1);
         var14 = var13 * (int)((double)var12 * (var1 - var8) / (var10 - var8)) + 2;
      } else {
         var14 = (int)(253.0D * (var1 - var8) / (var10 - var8)) + 2;
      }

      var14 = Math.min(var14, 255);
      var14 = Math.max(var14, 2);
      this.minZ = var4;
      this.maxZ = var6;
      return this.getColor(var14);
   }

   public double getMaxZ() {
      return this.maxZ;
   }

   public double getMinZ() {
      return this.minZ;
   }

   public Paint getPaint(double var1) {
      return this.isLogscale()?this.getColorLog(var1):this.getColorLinear(var1);
   }

   public String getPaletteName() {
      return this.paletteName;
   }

   public double[] getTickValues() {
      return this.tickValues;
   }

   public abstract void initialize();

   public void invertPalette() {
      int[] var1 = new int[256];
      int[] var2 = new int[256];
      int[] var3 = new int[256];

      int var4;
      for(var4 = 0; var4 < 256; ++var4) {
         var1[var4] = this.r[var4];
         var2[var4] = this.g[var4];
         var3[var4] = this.b[var4];
      }

      for(var4 = 2; var4 < 256; ++var4) {
         this.r[var4] = var1[257 - var4];
         this.g[var4] = var2[257 - var4];
         this.b[var4] = var3[257 - var4];
      }

   }

   public boolean isInverse() {
      return this.inverse;
   }

   public boolean isLogscale() {
      return this.logscale;
   }

   public boolean isStepped() {
      return this.stepped;
   }

   public void setInverse(boolean var1) {
      this.inverse = var1;
      this.initialize();
      if(var1) {
         this.invertPalette();
      }

   }

   public void setLogscale(boolean var1) {
      this.logscale = var1;
   }

   public void setMaxZ(double var1) {
      this.maxZ = var1;
   }

   public void setMinZ(double var1) {
      this.minZ = var1;
   }

   public void setPaletteName(String var1) {
      this.paletteName = var1;
   }

   public void setStepped(boolean var1) {
      this.stepped = var1;
   }

   public void setTickValues(double[] var1) {
      this.tickValues = var1;
   }

   public void setTickValues(List var1) {
      this.tickValues = new double[var1.size()];

      for(int var2 = 0; var2 < this.tickValues.length; ++var2) {
         this.tickValues[var2] = ((ValueTick)var1.get(var2)).getValue();
      }

   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ColorPalette)) {
         return false;
      } else {
         ColorPalette var2 = (ColorPalette)var1;
         if(this.inverse != var2.inverse) {
            return false;
         } else if(this.logscale != var2.logscale) {
            return false;
         } else if(this.maxZ != var2.maxZ) {
            return false;
         } else if(this.minZ != var2.minZ) {
            return false;
         } else if(this.stepped != var2.stepped) {
            return false;
         } else if(!Arrays.equals(this.b, var2.b)) {
            return false;
         } else if(!Arrays.equals(this.g, var2.g)) {
            return false;
         } else {
            if(this.paletteName != null) {
               if(this.paletteName.equals(var2.paletteName)) {
                  return !Arrays.equals(this.r, var2.r)?false:Arrays.equals(this.tickValues, var2.tickValues);
               }
            } else if(var2.paletteName == null) {
               return !Arrays.equals(this.r, var2.r)?false:Arrays.equals(this.tickValues, var2.tickValues);
            }

            return false;
         }
      }
   }

   public int hashCode() {
      long var2 = Double.doubleToLongBits(this.minZ);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.maxZ);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var1 = 29 * var1 + (this.logscale?1:0);
      var1 = 29 * var1 + (this.inverse?1:0);
      var1 = 29 * var1 + (this.paletteName != null?this.paletteName.hashCode():0);
      var1 = 29 * var1 + (this.stepped?1:0);
      return var1;
   }

   public Object clone() {
      ColorPalette var1 = (ColorPalette)super.clone();
      return var1;
   }
}
