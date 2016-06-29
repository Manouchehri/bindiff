package org.jfree.data.statistics;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.jfree.util.ObjectUtilities;

public class BoxAndWhiskerItem implements Serializable {
   private static final long serialVersionUID = 7329649623148167423L;
   private Number mean;
   private Number median;
   private Number q1;
   private Number q3;
   private Number minRegularValue;
   private Number maxRegularValue;
   private Number minOutlier;
   private Number maxOutlier;
   private List outliers;

   public BoxAndWhiskerItem(Number var1, Number var2, Number var3, Number var4, Number var5, Number var6, Number var7, Number var8, List var9) {
      this.mean = var1;
      this.median = var2;
      this.q1 = var3;
      this.q3 = var4;
      this.minRegularValue = var5;
      this.maxRegularValue = var6;
      this.minOutlier = var7;
      this.maxOutlier = var8;
      this.outliers = var9;
   }

   public Number getMean() {
      return this.mean;
   }

   public Number getMedian() {
      return this.median;
   }

   public Number getQ1() {
      return this.q1;
   }

   public Number getQ3() {
      return this.q3;
   }

   public Number getMinRegularValue() {
      return this.minRegularValue;
   }

   public Number getMaxRegularValue() {
      return this.maxRegularValue;
   }

   public Number getMinOutlier() {
      return this.minOutlier;
   }

   public Number getMaxOutlier() {
      return this.maxOutlier;
   }

   public List getOutliers() {
      return this.outliers == null?null:Collections.unmodifiableList(this.outliers);
   }

   public String toString() {
      return super.toString() + "[mean=" + this.mean + ",median=" + this.median + ",q1=" + this.q1 + ",q3=" + this.q3 + "]";
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BoxAndWhiskerItem)) {
         return false;
      } else {
         BoxAndWhiskerItem var2 = (BoxAndWhiskerItem)var1;
         return !ObjectUtilities.equal(this.mean, var2.mean)?false:(!ObjectUtilities.equal(this.median, var2.median)?false:(!ObjectUtilities.equal(this.q1, var2.q1)?false:(!ObjectUtilities.equal(this.q3, var2.q3)?false:(!ObjectUtilities.equal(this.minRegularValue, var2.minRegularValue)?false:(!ObjectUtilities.equal(this.maxRegularValue, var2.maxRegularValue)?false:(!ObjectUtilities.equal(this.minOutlier, var2.minOutlier)?false:(!ObjectUtilities.equal(this.maxOutlier, var2.maxOutlier)?false:ObjectUtilities.equal(this.outliers, var2.outliers))))))));
      }
   }
}
