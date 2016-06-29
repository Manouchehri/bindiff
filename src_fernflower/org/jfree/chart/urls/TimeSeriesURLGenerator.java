package org.jfree.chart.urls;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesURLGenerator implements Serializable, XYURLGenerator {
   private static final long serialVersionUID = -9122773175671182445L;
   private DateFormat dateFormat = DateFormat.getInstance();
   private String prefix = "index.html";
   private String seriesParameterName = "series";
   private String itemParameterName = "item";

   public TimeSeriesURLGenerator() {
   }

   public TimeSeriesURLGenerator(DateFormat var1, String var2, String var3, String var4) {
      this.dateFormat = var1;
      this.prefix = var2;
      this.seriesParameterName = var3;
      this.itemParameterName = var4;
   }

   public String generateURL(XYDataset var1, int var2, int var3) {
      String var4 = this.prefix;
      boolean var5 = var4.indexOf("?") == -1;
      Comparable var6 = var1.getSeriesKey(var2);
      if(var6 != null) {
         var4 = var4 + (var5?"?":"&amp;");
         var4 = var4 + this.seriesParameterName + "=" + var6.toString();
         var5 = false;
      }

      long var7 = (long)var1.getXValue(var2, var3);
      String var9 = this.dateFormat.format(new Date(var7));
      var4 = var4 + (var5?"?":"&amp;");
      var4 = var4 + this.itemParameterName + "=" + var9;
      return var4;
   }
}
