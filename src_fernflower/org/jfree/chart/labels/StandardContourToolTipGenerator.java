package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.labels.ContourToolTipGenerator;
import org.jfree.data.contour.ContourDataset;

public class StandardContourToolTipGenerator implements Serializable, ContourToolTipGenerator {
   private static final long serialVersionUID = -1881659351247502711L;
   private DecimalFormat valueForm = new DecimalFormat("##.###");

   public String generateToolTip(ContourDataset var1, int var2) {
      double var3 = var1.getXValue(0, var2);
      double var5 = var1.getYValue(0, var2);
      double var7 = var1.getZValue(0, var2);
      String var9 = null;
      if(var1.isDateAxis(0)) {
         SimpleDateFormat var10 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
         StringBuffer var11 = new StringBuffer();
         var11 = var10.format(new Date((long)var3), var11, new FieldPosition(0));
         var9 = var11.toString();
      } else {
         var9 = this.valueForm.format(var3);
      }

      return !Double.isNaN(var7)?"X: " + var9 + ", Y: " + this.valueForm.format(var5) + ", Z: " + this.valueForm.format(var7):"X: " + var9 + ", Y: " + this.valueForm.format(var5) + ", Z: no data";
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardContourToolTipGenerator)) {
         return false;
      } else {
         StandardContourToolTipGenerator var2 = (StandardContourToolTipGenerator)var1;
         return this.valueForm != null?this.valueForm.equals(var2.valueForm):false;
      }
   }
}
