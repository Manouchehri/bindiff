package org.jfree.chart.urls;

import java.io.Serializable;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ObjectUtilities;

public class StandardXYURLGenerator implements Serializable, XYURLGenerator {
   private static final long serialVersionUID = -1771624523496595382L;
   public static final String DEFAULT_PREFIX = "index.html";
   public static final String DEFAULT_SERIES_PARAMETER = "series";
   public static final String DEFAULT_ITEM_PARAMETER = "item";
   private String prefix;
   private String seriesParameterName;
   private String itemParameterName;

   public StandardXYURLGenerator() {
      this("index.html", "series", "item");
   }

   public StandardXYURLGenerator(String var1) {
      this(var1, "series", "item");
   }

   public StandardXYURLGenerator(String var1, String var2, String var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'prefix\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'seriesParameterName\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'itemParameterName\' argument.");
      } else {
         this.prefix = var1;
         this.seriesParameterName = var2;
         this.itemParameterName = var3;
      }
   }

   public String generateURL(XYDataset var1, int var2, int var3) {
      String var4 = this.prefix;
      boolean var5 = var4.indexOf("?") == -1;
      var4 = var4 + (var5?"?":"&amp;");
      var4 = var4 + this.seriesParameterName + "=" + var2 + "&amp;" + this.itemParameterName + "=" + var3;
      return var4;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardXYURLGenerator)) {
         return false;
      } else {
         StandardXYURLGenerator var2 = (StandardXYURLGenerator)var1;
         return !ObjectUtilities.equal(var2.prefix, this.prefix)?false:(!ObjectUtilities.equal(var2.seriesParameterName, this.seriesParameterName)?false:ObjectUtilities.equal(var2.itemParameterName, this.itemParameterName));
      }
   }
}
