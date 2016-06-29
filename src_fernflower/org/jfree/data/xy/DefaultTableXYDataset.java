package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.IntervalXYDelegate;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.util.ObjectUtilities;

public class DefaultTableXYDataset extends AbstractIntervalXYDataset implements DomainInfo, IntervalXYDataset, TableXYDataset {
   private List data;
   private HashSet xPoints;
   private boolean propagateEvents;
   private boolean autoPrune;
   private IntervalXYDelegate intervalDelegate;

   public DefaultTableXYDataset() {
      this(false);
   }

   public DefaultTableXYDataset(boolean var1) {
      this.data = null;
      this.xPoints = null;
      this.propagateEvents = true;
      this.autoPrune = false;
      this.autoPrune = var1;
      this.data = new ArrayList();
      this.xPoints = new HashSet();
      this.intervalDelegate = new IntervalXYDelegate(this, false);
      this.addChangeListener(this.intervalDelegate);
   }

   public boolean isAutoPrune() {
      return this.autoPrune;
   }

   public void addSeries(XYSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else if(var1.getAllowDuplicateXValues()) {
         throw new IllegalArgumentException("Cannot accept XYSeries that allow duplicate values. Use XYSeries(seriesName, <sort>, false) constructor.");
      } else {
         this.updateXPoints(var1);
         this.data.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   private void updateXPoints(XYSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' not permitted.");
      } else {
         HashSet var2 = new HashSet();
         boolean var3 = this.propagateEvents;
         this.propagateEvents = false;

         Number var5;
         for(int var4 = 0; var4 < var1.getItemCount(); ++var4) {
            var5 = var1.getX(var4);
            var2.add(var5);
            if(!this.xPoints.contains(var5)) {
               this.xPoints.add(var5);
               int var6 = this.data.size();

               for(int var7 = 0; var7 < var6; ++var7) {
                  XYSeries var8 = (XYSeries)this.data.get(var7);
                  if(!var8.equals(var1)) {
                     var8.add(var5, (Number)null);
                  }
               }
            }
         }

         Iterator var9 = this.xPoints.iterator();

         while(var9.hasNext()) {
            var5 = (Number)var9.next();
            if(!var2.contains(var5)) {
               var1.add(var5, (Number)null);
            }
         }

         this.propagateEvents = var3;
      }
   }

   public void updateXPoints() {
      this.propagateEvents = false;

      for(int var1 = 0; var1 < this.data.size(); ++var1) {
         this.updateXPoints((XYSeries)this.data.get(var1));
      }

      if(this.autoPrune) {
         this.prune();
      }

      this.propagateEvents = true;
   }

   public int getSeriesCount() {
      return this.data.size();
   }

   public int getItemCount() {
      return this.xPoints == null?0:this.xPoints.size();
   }

   public XYSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (XYSeries)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("Index outside valid range.");
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

   public void removeAllSeries() {
      for(int var1 = 0; var1 < this.data.size(); ++var1) {
         XYSeries var2 = (XYSeries)this.data.get(var1);
         var2.removeChangeListener(this);
      }

      this.data.clear();
      this.xPoints.clear();
      this.fireDatasetChanged();
   }

   public void removeSeries(XYSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         if(this.data.contains(var1)) {
            var1.removeChangeListener(this);
            this.data.remove(var1);
            if(this.data.size() == 0) {
               this.xPoints.clear();
            }

            this.fireDatasetChanged();
         }

      }
   }

   public void removeSeries(int var1) {
      if(var1 >= 0 && var1 <= this.getSeriesCount()) {
         XYSeries var2 = (XYSeries)this.data.get(var1);
         var2.removeChangeListener(this);
         this.data.remove(var1);
         if(this.data.size() == 0) {
            this.xPoints.clear();
         } else if(this.autoPrune) {
            this.prune();
         }

         this.fireDatasetChanged();
      } else {
         throw new IllegalArgumentException("Index outside valid range.");
      }
   }

   public void removeAllValuesForX(Number var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'x\' argument.");
      } else {
         boolean var2 = this.propagateEvents;
         this.propagateEvents = false;

         for(int var3 = 0; var3 < this.data.size(); ++var3) {
            XYSeries var4 = (XYSeries)this.data.get(var3);
            var4.remove(var1);
         }

         this.propagateEvents = var2;
         this.xPoints.remove(var1);
         this.fireDatasetChanged();
      }
   }

   protected boolean canPrune(Number var1) {
      for(int var2 = 0; var2 < this.data.size(); ++var2) {
         XYSeries var3 = (XYSeries)this.data.get(var2);
         if(var3.getY(var3.indexOf(var1)) != null) {
            return false;
         }
      }

      return true;
   }

   public void prune() {
      HashSet var1 = (HashSet)this.xPoints.clone();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Number var3 = (Number)var2.next();
         if(this.canPrune(var3)) {
            this.removeAllValuesForX(var3);
         }
      }

   }

   public void seriesChanged(SeriesChangeEvent var1) {
      if(this.propagateEvents) {
         this.updateXPoints();
         this.fireDatasetChanged();
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultTableXYDataset)) {
         return false;
      } else {
         DefaultTableXYDataset var2 = (DefaultTableXYDataset)var1;
         return this.autoPrune != var2.autoPrune?false:(this.propagateEvents != var2.propagateEvents?false:(!this.intervalDelegate.equals(var2.intervalDelegate)?false:ObjectUtilities.equal(this.data, var2.data)));
      }
   }

   public int hashCode() {
      int var1 = this.data != null?this.data.hashCode():0;
      var1 = 29 * var1 + (this.xPoints != null?this.xPoints.hashCode():0);
      var1 = 29 * var1 + (this.propagateEvents?1:0);
      var1 = 29 * var1 + (this.autoPrune?1:0);
      return var1;
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

   public double getIntervalPositionFactor() {
      return this.intervalDelegate.getIntervalPositionFactor();
   }

   public void setIntervalPositionFactor(double var1) {
      this.intervalDelegate.setIntervalPositionFactor(var1);
      this.fireDatasetChanged();
   }

   public double getIntervalWidth() {
      return this.intervalDelegate.getIntervalWidth();
   }

   public void setIntervalWidth(double var1) {
      this.intervalDelegate.setFixedIntervalWidth(var1);
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
