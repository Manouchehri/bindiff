package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ObjectUtilities;

public class AbstractXYItemLabelGenerator implements Serializable, Cloneable {
   private static final long serialVersionUID = 5869744396278660636L;
   private String formatString;
   private NumberFormat xFormat;
   private DateFormat xDateFormat;
   private NumberFormat yFormat;
   private DateFormat yDateFormat;
   private String nullXString;
   private String nullYString;

   protected AbstractXYItemLabelGenerator() {
      this("{2}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
   }

   protected AbstractXYItemLabelGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      this.nullXString = "null";
      this.nullYString = "null";
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'formatString\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'xFormat\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'yFormat\' argument.");
      } else {
         this.formatString = var1;
         this.xFormat = var2;
         this.yFormat = var3;
      }
   }

   protected AbstractXYItemLabelGenerator(String var1, DateFormat var2, NumberFormat var3) {
      this(var1, NumberFormat.getInstance(), var3);
      this.xDateFormat = var2;
   }

   protected AbstractXYItemLabelGenerator(String var1, NumberFormat var2, DateFormat var3) {
      this(var1, var2, NumberFormat.getInstance());
      this.yDateFormat = var3;
   }

   protected AbstractXYItemLabelGenerator(String var1, DateFormat var2, DateFormat var3) {
      this(var1, NumberFormat.getInstance(), NumberFormat.getInstance());
      this.xDateFormat = var2;
      this.yDateFormat = var3;
   }

   public String getFormatString() {
      return this.formatString;
   }

   public NumberFormat getXFormat() {
      return this.xFormat;
   }

   public DateFormat getXDateFormat() {
      return this.xDateFormat;
   }

   public NumberFormat getYFormat() {
      return this.yFormat;
   }

   public DateFormat getYDateFormat() {
      return this.yDateFormat;
   }

   public String generateLabelString(XYDataset var1, int var2, int var3) {
      String var4 = null;
      Object[] var5 = this.createItemArray(var1, var2, var3);
      var4 = MessageFormat.format(this.formatString, var5);
      return var4;
   }

   protected Object[] createItemArray(XYDataset var1, int var2, int var3) {
      Object[] var4 = new Object[]{var1.getSeriesKey(var2).toString(), null, null};
      double var5 = var1.getXValue(var2, var3);
      if(Double.isNaN(var5) && var1.getX(var2, var3) == null) {
         var4[1] = this.nullXString;
      } else if(this.xDateFormat != null) {
         var4[1] = this.xDateFormat.format(new Date((long)var5));
      } else {
         var4[1] = this.xFormat.format(var5);
      }

      double var7 = var1.getYValue(var2, var3);
      if(Double.isNaN(var7) && var1.getY(var2, var3) == null) {
         var4[2] = this.nullYString;
      } else if(this.yDateFormat != null) {
         var4[2] = this.yDateFormat.format(new Date((long)var7));
      } else {
         var4[2] = this.yFormat.format(var7);
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractXYItemLabelGenerator)) {
         return false;
      } else {
         AbstractXYItemLabelGenerator var2 = (AbstractXYItemLabelGenerator)var1;
         return !this.formatString.equals(var2.formatString)?false:(!ObjectUtilities.equal(this.xFormat, var2.xFormat)?false:(!ObjectUtilities.equal(this.xDateFormat, var2.xDateFormat)?false:(!ObjectUtilities.equal(this.yFormat, var2.yFormat)?false:ObjectUtilities.equal(this.yDateFormat, var2.yDateFormat))));
      }
   }

   public Object clone() {
      AbstractXYItemLabelGenerator var1 = (AbstractXYItemLabelGenerator)super.clone();
      if(this.xFormat != null) {
         var1.xFormat = (NumberFormat)this.xFormat.clone();
      }

      if(this.yFormat != null) {
         var1.yFormat = (NumberFormat)this.yFormat.clone();
      }

      if(this.xDateFormat != null) {
         var1.xDateFormat = (DateFormat)this.xDateFormat.clone();
      }

      if(this.yDateFormat != null) {
         var1.yDateFormat = (DateFormat)this.yDateFormat.clone();
      }

      return var1;
   }
}
