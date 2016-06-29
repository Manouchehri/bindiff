package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.IntervalXYDelegate;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.util.ObjectUtilities;

public class XYSeriesCollection extends AbstractIntervalXYDataset implements Serializable, DomainInfo, IntervalXYDataset {
   private static final long serialVersionUID = -7590013825931496766L;
   private List data;
   private IntervalXYDelegate intervalDelegate;

   public XYSeriesCollection() {
      this((XYSeries)null);
   }

   public XYSeriesCollection(XYSeries var1) {
      this.data = new ArrayList();
      this.intervalDelegate = new IntervalXYDelegate(this, false);
      this.addChangeListener(this.intervalDelegate);
      if(var1 != null) {
         this.data.add(var1);
         var1.addChangeListener(this);
      }

   }

   public void addSeries(XYSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public void removeSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         XYSeries var2 = (XYSeries)this.data.get(var1);
         var2.removeChangeListener(this);
         this.data.remove(var1);
         this.fireDatasetChanged();
      } else {
         throw new IllegalArgumentException("Series index out of bounds.");
      }
   }

   public void removeSeries(XYSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         if(this.data.contains(var1)) {
            var1.removeChangeListener(this);
            this.data.remove(var1);
            this.fireDatasetChanged();
         }

      }
   }

   public void removeAllSeries() {
      for(int var1 = 0; var1 < this.data.size(); ++var1) {
         XYSeries var2 = (XYSeries)this.data.get(var1);
         var2.removeChangeListener(this);
      }

      this.data.clear();
      this.fireDatasetChanged();
   }

   public int getSeriesCount() {
      return this.data.size();
   }

   public List getSeries() {
      return Collections.unmodifiableList(this.data);
   }

   public XYSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (XYSeries)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("Series index out of bounds");
      }
   }

   public Comparable getSeriesKey(int var1) {
      return this.getSeries(var1).getKey();
   }

   public int getItemCount(int var1) {
      return this.getSeries(var1).getItemCount();
   }

   public Number getX(int var1, int var2) {
      XYSeries var3 = (XYSeries)this.data.get(var1);
      XYDataItem var4 = var3.getDataItem(var2);
      return var4.getX();
   }

   public Number getStartX(int var1, int var2) {
      return this.intervalDelegate.getStartX(var1, var2);
   }

   public Number getEndX(int var1, int var2) {
      return this.intervalDelegate.getEndX(var1, var2);
   }

   public Number getY(int var1, int var2) {
      XYSeries var3 = (XYSeries)this.data.get(var1);
      XYDataItem var4 = var3.getDataItem(var2);
      return var4.getY();
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYSeriesCollection)) {
         return false;
      } else {
         XYSeriesCollection var2 = (XYSeriesCollection)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      }
   }

   public Object clone() {
      XYSeriesCollection var1 = (XYSeriesCollection)super.clone();
      var1.data = (List)ObjectUtilities.deepClone(this.data);
      var1.intervalDelegate = (IntervalXYDelegate)this.intervalDelegate.clone();
      return var1;
   }

   public int hashCode() {
      return this.data != null?this.data.hashCode():0;
   }

   public double getDomainLowerBound(boolean var1) {
      return this.intervalDelegate.getDomainLowerBound(var1);
   }

   public double getDomainUpperBound(boolean var1) {
      return this.intervalDelegate.getDomainUpperBound(var1);
   }

   public Range getDomainBounds(boolean var1) {
      return var1?this.intervalDelegate.getDomainBounds(var1):DatasetUtilities.iterateDomainBounds(this, var1);
   }

   public double getIntervalWidth() {
      return this.intervalDelegate.getIntervalWidth();
   }

   public void setIntervalWidth(double var1) {
      if(var1 < 0.0D) {
         throw new IllegalArgumentException("Negative \'width\' argument.");
      } else {
         this.intervalDelegate.setFixedIntervalWidth(var1);
         this.fireDatasetChanged();
      }
   }

   public double getIntervalPositionFactor() {
      return this.intervalDelegate.getIntervalPositionFactor();
   }

   public void setIntervalPositionFactor(double var1) {
      this.intervalDelegate.setIntervalPositionFactor(var1);
      this.fireDatasetChanged();
   }

   public boolean isAutoWidth() {
      return this.intervalDelegate.isAutoWidth();
   }

   public void setAutoWidth(boolean var1) {
      this.intervalDelegate.setAutoWidth(var1);
      this.fireDatasetChanged();
   }
}
