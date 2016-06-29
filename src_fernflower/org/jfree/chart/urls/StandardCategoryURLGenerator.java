package org.jfree.chart.urls;

import java.io.Serializable;
import java.net.URLEncoder;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.ObjectUtilities;

public class StandardCategoryURLGenerator implements Serializable, Cloneable, CategoryURLGenerator {
   private static final long serialVersionUID = 2276668053074881909L;
   private String prefix = "index.html";
   private String seriesParameterName = "series";
   private String categoryParameterName = "category";

   public StandardCategoryURLGenerator() {
   }

   public StandardCategoryURLGenerator(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'prefix\' argument.");
      } else {
         this.prefix = var1;
      }
   }

   public StandardCategoryURLGenerator(String var1, String var2, String var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'prefix\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'seriesParameterName\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'categoryParameterName\' argument.");
      } else {
         this.prefix = var1;
         this.seriesParameterName = var2;
         this.categoryParameterName = var3;
      }
   }

   public String generateURL(CategoryDataset var1, int var2, int var3) {
      String var4 = this.prefix;
      Comparable var5 = var1.getRowKey(var2);
      Comparable var6 = var1.getColumnKey(var3);
      boolean var7 = var4.indexOf("?") == -1;
      var4 = var4 + (var7?"?":"&amp;");
      var4 = var4 + this.seriesParameterName + "=" + URLEncoder.encode(var5.toString());
      var4 = var4 + "&amp;" + this.categoryParameterName + "=" + URLEncoder.encode(var6.toString());
      return var4;
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardCategoryURLGenerator)) {
         return false;
      } else {
         StandardCategoryURLGenerator var2 = (StandardCategoryURLGenerator)var1;
         return !ObjectUtilities.equal(this.prefix, var2.prefix)?false:(!ObjectUtilities.equal(this.seriesParameterName, var2.seriesParameterName)?false:ObjectUtilities.equal(this.categoryParameterName, var2.categoryParameterName));
      }
   }

   public int hashCode() {
      int var1 = this.prefix != null?this.prefix.hashCode():0;
      var1 = 29 * var1 + (this.seriesParameterName != null?this.seriesParameterName.hashCode():0);
      var1 = 29 * var1 + (this.categoryParameterName != null?this.categoryParameterName.hashCode():0);
      return var1;
   }
}
