package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.annotations.TextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;

public class CategoryTextAnnotation extends TextAnnotation implements Serializable, Cloneable, CategoryAnnotation {
   private static final long serialVersionUID = 3333360090781320147L;
   private Comparable category;
   private CategoryAnchor categoryAnchor;
   private double value;

   public CategoryTextAnnotation(String var1, Comparable var2, double var3) {
      super(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         this.category = var2;
         this.value = var3;
         this.categoryAnchor = CategoryAnchor.MIDDLE;
      }
   }

   public Comparable getCategory() {
      return this.category;
   }

   public void setCategory(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'category\' argument.");
      } else {
         this.category = var1;
      }
   }

   public CategoryAnchor getCategoryAnchor() {
      return this.categoryAnchor;
   }

   public void setCategoryAnchor(CategoryAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.categoryAnchor = var1;
      }
   }

   public double getValue() {
      return this.value;
   }

   public void setValue(double var1) {
      this.value = var1;
   }

   public void draw(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, CategoryAxis var4, ValueAxis var5) {
      CategoryDataset var6 = var2.getDataset();
      int var7 = var6.getColumnIndex(this.category);
      int var8 = var6.getColumnCount();
      float var9 = 0.0F;
      float var10 = 0.0F;
      PlotOrientation var11 = var2.getOrientation();
      RectangleEdge var12 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var11);
      RectangleEdge var13 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var11);
      if(var11 == PlotOrientation.HORIZONTAL) {
         var10 = (float)var4.getCategoryJava2DCoordinate(this.categoryAnchor, var7, var8, var3, var12);
         var9 = (float)var5.valueToJava2D(this.value, var3, var13);
      } else if(var11 == PlotOrientation.VERTICAL) {
         var9 = (float)var4.getCategoryJava2DCoordinate(this.categoryAnchor, var7, var8, var3, var12);
         var10 = (float)var5.valueToJava2D(this.value, var3, var13);
      }

      var1.setFont(this.getFont());
      var1.setPaint(this.getPaint());
      TextUtilities.drawRotatedString(this.getText(), var1, var9, var10, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryTextAnnotation)) {
         return false;
      } else {
         CategoryTextAnnotation var2 = (CategoryTextAnnotation)var1;
         return !super.equals(var1)?false:(!this.category.equals(var2.getCategory())?false:(!this.categoryAnchor.equals(var2.getCategoryAnchor())?false:this.value == var2.getValue()));
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 37 * var1 + this.category.hashCode();
      var1 = 37 * var1 + this.categoryAnchor.hashCode();
      long var2 = Double.doubleToLongBits(this.value);
      var1 = 37 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public Object clone() {
      return super.clone();
   }
}
