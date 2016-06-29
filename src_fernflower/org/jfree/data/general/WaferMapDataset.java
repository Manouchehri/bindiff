package org.jfree.data.general;

import java.util.Set;
import java.util.TreeSet;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.general.AbstractDataset;

public class WaferMapDataset extends AbstractDataset {
   private DefaultKeyedValues2D data;
   private int maxChipX;
   private int maxChipY;
   private double chipSpace;
   private Double maxValue;
   private Double minValue;
   private static final double DEFAULT_CHIP_SPACE = 1.0D;

   public WaferMapDataset(int var1, int var2) {
      this(var1, var2, (Number)null);
   }

   public WaferMapDataset(int var1, int var2, Number var3) {
      this.maxValue = new Double(Double.NEGATIVE_INFINITY);
      this.minValue = new Double(Double.POSITIVE_INFINITY);
      this.data = new DefaultKeyedValues2D();
      this.maxChipX = var1;
      this.maxChipY = var2;
      if(var3 == null) {
         this.chipSpace = 1.0D;
      } else {
         this.chipSpace = var3.doubleValue();
      }

   }

   public void addValue(Number var1, Comparable var2, Comparable var3) {
      this.setValue(var1, var2, var3);
   }

   public void addValue(int var1, int var2, int var3) {
      this.setValue(new Double((double)var1), new Integer(var2), new Integer(var3));
   }

   public void setValue(Number var1, Comparable var2, Comparable var3) {
      this.data.setValue(var1, var2, var3);
      if(this.isMaxValue(var1)) {
         this.maxValue = (Double)var1;
      }

      if(this.isMinValue(var1)) {
         this.minValue = (Double)var1;
      }

   }

   public int getUniqueValueCount() {
      return this.getUniqueValues().size();
   }

   public Set getUniqueValues() {
      TreeSet var1 = new TreeSet();

      for(int var2 = 0; var2 < this.data.getRowCount(); ++var2) {
         for(int var3 = 0; var3 < this.data.getColumnCount(); ++var3) {
            Number var4 = this.data.getValue(var2, var3);
            if(var4 != null) {
               var1.add(var4);
            }
         }
      }

      return var1;
   }

   public Number getChipValue(int var1, int var2) {
      return this.getChipValue(new Integer(var1), new Integer(var2));
   }

   public Number getChipValue(Comparable var1, Comparable var2) {
      int var3 = this.data.getRowIndex(var1);
      if(var3 < 0) {
         return null;
      } else {
         int var4 = this.data.getColumnIndex(var2);
         return var4 < 0?null:this.data.getValue(var3, var4);
      }
   }

   public boolean isMaxValue(Number var1) {
      return var1.doubleValue() > this.maxValue.doubleValue();
   }

   public boolean isMinValue(Number var1) {
      return var1.doubleValue() < this.minValue.doubleValue();
   }

   public Number getMaxValue() {
      return this.maxValue;
   }

   public Number getMinValue() {
      return this.minValue;
   }

   public int getMaxChipX() {
      return this.maxChipX;
   }

   public void setMaxChipX(int var1) {
      this.maxChipX = var1;
   }

   public int getMaxChipY() {
      return this.maxChipY;
   }

   public void setMaxChipY(int var1) {
      this.maxChipY = var1;
   }

   public double getChipSpace() {
      return this.chipSpace;
   }

   public void setChipSpace(double var1) {
      this.chipSpace = var1;
   }
}
