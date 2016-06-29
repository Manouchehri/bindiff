package org.jfree.chart.urls;

import java.io.Serializable;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.ObjectUtilities;

public class StandardPieURLGenerator implements Serializable, PieURLGenerator {
   private static final long serialVersionUID = 1626966402065883419L;
   private String prefix;
   private String categoryParameterName;
   private String indexParameterName;

   public StandardPieURLGenerator() {
      this("index.html");
   }

   public StandardPieURLGenerator(String var1) {
      this(var1, "category");
   }

   public StandardPieURLGenerator(String var1, String var2) {
      this(var1, var2, "pieIndex");
   }

   public StandardPieURLGenerator(String var1, String var2, String var3) {
      this.prefix = "index.html";
      this.categoryParameterName = "category";
      this.indexParameterName = "pieIndex";
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'prefix\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'categoryParameterName\' argument.");
      } else {
         this.prefix = var1;
         this.categoryParameterName = var2;
         this.indexParameterName = var3;
      }
   }

   public String generateURL(PieDataset var1, Comparable var2, int var3) {
      String var4 = this.prefix;
      if(var4.indexOf("?") > -1) {
         var4 = var4 + "&amp;" + this.categoryParameterName + "=" + var2.toString();
      } else {
         var4 = var4 + "?" + this.categoryParameterName + "=" + var2.toString();
      }

      if(this.indexParameterName != null) {
         var4 = var4 + "&amp;" + this.indexParameterName + "=" + var3;
      }

      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardPieURLGenerator)) {
         return false;
      } else {
         StandardPieURLGenerator var2 = (StandardPieURLGenerator)var1;
         return !this.prefix.equals(var2.prefix)?false:(!this.categoryParameterName.equals(var2.categoryParameterName)?false:ObjectUtilities.equal(this.indexParameterName, var2.indexParameterName));
      }
   }
}
