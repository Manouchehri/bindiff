package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.MatrixSeries;
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.ObjectUtilities;

public class MatrixSeriesCollection extends AbstractXYZDataset implements Serializable, XYZDataset {
   private static final long serialVersionUID = -3197705779242543945L;
   private List seriesList;

   public MatrixSeriesCollection() {
      this((MatrixSeries)null);
   }

   public MatrixSeriesCollection(MatrixSeries var1) {
      this.seriesList = new ArrayList();
      if(var1 != null) {
         this.seriesList.add(var1);
         var1.addChangeListener(this);
      }

   }

   public int getItemCount(int var1) {
      return this.getSeries(var1).getItemCount();
   }

   public MatrixSeries getSeries(int var1) {
      if(var1 >= 0 && var1 <= this.getSeriesCount()) {
         MatrixSeries var2 = (MatrixSeries)this.seriesList.get(var1);
         return var2;
      } else {
         throw new IllegalArgumentException("Index outside valid range.");
      }
   }

   public int getSeriesCount() {
      return this.seriesList.size();
   }

   public Comparable getSeriesKey(int var1) {
      return this.getSeries(var1).getKey();
   }

   public Number getX(int var1, int var2) {
      MatrixSeries var3 = (MatrixSeries)this.seriesList.get(var1);
      int var4 = var3.getItemColumn(var2);
      return new Integer(var4);
   }

   public Number getY(int var1, int var2) {
      MatrixSeries var3 = (MatrixSeries)this.seriesList.get(var1);
      int var4 = var3.getItemRow(var2);
      return new Integer(var4);
   }

   public Number getZ(int var1, int var2) {
      MatrixSeries var3 = (MatrixSeries)this.seriesList.get(var1);
      Number var4 = var3.getItem(var2);
      return var4;
   }

   public void addSeries(MatrixSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Cannot add null series.");
      } else {
         this.seriesList.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(var1 instanceof MatrixSeriesCollection) {
         MatrixSeriesCollection var2 = (MatrixSeriesCollection)var1;
         return ObjectUtilities.equal(this.seriesList, var2.seriesList);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.seriesList != null?this.seriesList.hashCode():0;
   }

   public Object clone() {
      MatrixSeriesCollection var1 = (MatrixSeriesCollection)super.clone();
      var1.seriesList = (List)ObjectUtilities.deepClone(this.seriesList);
      return var1;
   }

   public void removeAllSeries() {
      for(int var1 = 0; var1 < this.seriesList.size(); ++var1) {
         MatrixSeries var2 = (MatrixSeries)this.seriesList.get(var1);
         var2.removeChangeListener(this);
      }

      this.seriesList.clear();
      this.fireDatasetChanged();
   }

   public void removeSeries(MatrixSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Cannot remove null series.");
      } else {
         if(this.seriesList.contains(var1)) {
            var1.removeChangeListener(this);
            this.seriesList.remove(var1);
            this.fireDatasetChanged();
         }

      }
   }

   public void removeSeries(int var1) {
      if(var1 >= 0 && var1 <= this.getSeriesCount()) {
         MatrixSeries var2 = (MatrixSeries)this.seriesList.get(var1);
         var2.removeChangeListener(this);
         this.seriesList.remove(var1);
         this.fireDatasetChanged();
      } else {
         throw new IllegalArgumentException("Index outside valid range.");
      }
   }
}
