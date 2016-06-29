package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.data.DataUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class AbstractCategoryItemLabelGenerator implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -7108591260223293197L;
   private String labelFormat;
   private String nullValueString;
   private NumberFormat numberFormat;
   private DateFormat dateFormat;
   private NumberFormat percentFormat;

   protected AbstractCategoryItemLabelGenerator(String var1, NumberFormat var2) {
      this(var1, var2, NumberFormat.getPercentInstance());
   }

   protected AbstractCategoryItemLabelGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'labelFormat\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'formatter\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'percentFormatter\' argument.");
      } else {
         this.labelFormat = var1;
         this.numberFormat = var2;
         this.percentFormat = var3;
         this.dateFormat = null;
         this.nullValueString = "-";
      }
   }

   protected AbstractCategoryItemLabelGenerator(String var1, DateFormat var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'labelFormat\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'formatter\' argument.");
      } else {
         this.labelFormat = var1;
         this.numberFormat = null;
         this.percentFormat = NumberFormat.getPercentInstance();
         this.dateFormat = var2;
         this.nullValueString = "-";
      }
   }

   public String generateRowLabel(CategoryDataset var1, int var2) {
      return var1.getRowKey(var2).toString();
   }

   public String generateColumnLabel(CategoryDataset var1, int var2) {
      return var1.getColumnKey(var2).toString();
   }

   public String getLabelFormat() {
      return this.labelFormat;
   }

   public NumberFormat getNumberFormat() {
      return this.numberFormat;
   }

   public DateFormat getDateFormat() {
      return this.dateFormat;
   }

   protected String generateLabelString(CategoryDataset var1, int var2, int var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         String var4 = null;
         Object[] var5 = this.createItemArray(var1, var2, var3);
         var4 = MessageFormat.format(this.labelFormat, var5);
         return var4;
      }
   }

   protected Object[] createItemArray(CategoryDataset var1, int var2, int var3) {
      Object[] var4 = new Object[]{var1.getRowKey(var2).toString(), var1.getColumnKey(var3).toString(), null, null};
      Number var5 = var1.getValue(var2, var3);
      if(var5 != null) {
         if(this.numberFormat != null) {
            var4[2] = this.numberFormat.format(var5);
         } else if(this.dateFormat != null) {
            var4[2] = this.dateFormat.format(var5);
         }
      } else {
         var4[2] = this.nullValueString;
      }

      if(var5 != null) {
         double var6 = DataUtilities.calculateColumnTotal(var1, var3);
         double var8 = var5.doubleValue() / var6;
         var4[3] = this.percentFormat.format(var8);
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractCategoryItemLabelGenerator)) {
         return false;
      } else {
         AbstractCategoryItemLabelGenerator var2 = (AbstractCategoryItemLabelGenerator)var1;
         return !this.labelFormat.equals(var2.labelFormat)?false:(!ObjectUtilities.equal(this.dateFormat, var2.dateFormat)?false:ObjectUtilities.equal(this.numberFormat, var2.numberFormat));
      }
   }

   public Object clone() {
      AbstractCategoryItemLabelGenerator var1 = (AbstractCategoryItemLabelGenerator)super.clone();
      if(this.numberFormat != null) {
         var1.numberFormat = (NumberFormat)this.numberFormat.clone();
      }

      if(this.dateFormat != null) {
         var1.dateFormat = (DateFormat)this.dateFormat.clone();
      }

      return var1;
   }
}
