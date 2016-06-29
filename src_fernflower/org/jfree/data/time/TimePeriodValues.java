package org.jfree.data.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodValue;
import org.jfree.util.ObjectUtilities;

public class TimePeriodValues extends Series implements Serializable {
   static final long serialVersionUID = -2210593619794989709L;
   protected static final String DEFAULT_DOMAIN_DESCRIPTION = "Time";
   protected static final String DEFAULT_RANGE_DESCRIPTION = "Value";
   private String domain;
   private String range;
   private List data;
   private int minStartIndex;
   private int maxStartIndex;
   private int minMiddleIndex;
   private int maxMiddleIndex;
   private int minEndIndex;
   private int maxEndIndex;

   public TimePeriodValues(String var1) {
      this(var1, "Time", "Value");
   }

   public TimePeriodValues(String var1, String var2, String var3) {
      super(var1);
      this.minStartIndex = -1;
      this.maxStartIndex = -1;
      this.minMiddleIndex = -1;
      this.maxMiddleIndex = -1;
      this.minEndIndex = -1;
      this.maxEndIndex = -1;
      this.domain = var2;
      this.range = var3;
      this.data = new ArrayList();
   }

   public String getDomainDescription() {
      return this.domain;
   }

   public void setDomainDescription(String var1) {
      String var2 = this.domain;
      this.domain = var1;
      this.firePropertyChange("Domain", var2, var1);
   }

   public String getRangeDescription() {
      return this.range;
   }

   public void setRangeDescription(String var1) {
      String var2 = this.range;
      this.range = var1;
      this.firePropertyChange("Range", var2, var1);
   }

   public int getItemCount() {
      return this.data.size();
   }

   public TimePeriodValue getDataItem(int var1) {
      return (TimePeriodValue)this.data.get(var1);
   }

   public TimePeriod getTimePeriod(int var1) {
      return this.getDataItem(var1).getPeriod();
   }

   public Number getValue(int var1) {
      return this.getDataItem(var1).getValue();
   }

   public void add(TimePeriodValue var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null item not allowed.");
      } else {
         this.data.add(var1);
         this.updateBounds(var1.getPeriod(), this.data.size() - 1);
         this.fireSeriesChanged();
      }
   }

   private void updateBounds(TimePeriod var1, int var2) {
      long var3 = var1.getStart().getTime();
      long var5 = var1.getEnd().getTime();
      long var7 = var3 + (var5 - var3) / 2L;
      long var9;
      if(this.minStartIndex >= 0) {
         var9 = this.getDataItem(this.minStartIndex).getPeriod().getStart().getTime();
         if(var3 < var9) {
            this.minStartIndex = var2;
         }
      } else {
         this.minStartIndex = var2;
      }

      if(this.maxStartIndex >= 0) {
         var9 = this.getDataItem(this.maxStartIndex).getPeriod().getStart().getTime();
         if(var3 > var9) {
            this.maxStartIndex = var2;
         }
      } else {
         this.maxStartIndex = var2;
      }

      long var11;
      long var13;
      if(this.minMiddleIndex >= 0) {
         var9 = this.getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime();
         var11 = this.getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime();
         var13 = var9 + (var11 - var9) / 2L;
         if(var7 < var13) {
            this.minMiddleIndex = var2;
         }
      } else {
         this.minMiddleIndex = var2;
      }

      if(this.maxMiddleIndex >= 0) {
         var9 = this.getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime();
         var11 = this.getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime();
         var13 = var9 + (var11 - var9) / 2L;
         if(var7 > var13) {
            this.maxMiddleIndex = var2;
         }
      } else {
         this.maxMiddleIndex = var2;
      }

      if(this.minEndIndex >= 0) {
         var9 = this.getDataItem(this.minEndIndex).getPeriod().getEnd().getTime();
         if(var5 < var9) {
            this.minEndIndex = var2;
         }
      } else {
         this.minEndIndex = var2;
      }

      if(this.maxEndIndex >= 0) {
         var9 = this.getDataItem(this.maxEndIndex).getPeriod().getEnd().getTime();
         if(var5 > var9) {
            this.maxEndIndex = var2;
         }
      } else {
         this.maxEndIndex = var2;
      }

   }

   private void recalculateBounds() {
      this.minStartIndex = -1;
      this.minMiddleIndex = -1;
      this.minEndIndex = -1;
      this.maxStartIndex = -1;
      this.maxMiddleIndex = -1;
      this.maxEndIndex = -1;

      for(int var1 = 0; var1 < this.data.size(); ++var1) {
         TimePeriodValue var2 = (TimePeriodValue)this.data.get(var1);
         this.updateBounds(var2.getPeriod(), var1);
      }

   }

   public void add(TimePeriod var1, double var2) {
      TimePeriodValue var4 = new TimePeriodValue(var1, var2);
      this.add(var4);
   }

   public void add(TimePeriod var1, Number var2) {
      TimePeriodValue var3 = new TimePeriodValue(var1, var2);
      this.add(var3);
   }

   public void update(int var1, Number var2) {
      TimePeriodValue var3 = this.getDataItem(var1);
      var3.setValue(var2);
      this.fireSeriesChanged();
   }

   public void delete(int var1, int var2) {
      for(int var3 = 0; var3 <= var2 - var1; ++var3) {
         this.data.remove(var1);
      }

      this.recalculateBounds();
      this.fireSeriesChanged();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TimePeriodValues)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         TimePeriodValues var2 = (TimePeriodValues)var1;
         if(!ObjectUtilities.equal(this.getDomainDescription(), var2.getDomainDescription())) {
            return false;
         } else if(!ObjectUtilities.equal(this.getRangeDescription(), var2.getRangeDescription())) {
            return false;
         } else {
            int var3 = this.getItemCount();
            if(var3 != var2.getItemCount()) {
               return false;
            } else {
               for(int var4 = 0; var4 < var3; ++var4) {
                  if(!this.getDataItem(var4).equals(var2.getDataItem(var4))) {
                     return false;
                  }
               }

               return true;
            }
         }
      }
   }

   public int hashCode() {
      int var1 = this.domain != null?this.domain.hashCode():0;
      var1 = 29 * var1 + (this.range != null?this.range.hashCode():0);
      var1 = 29 * var1 + this.data.hashCode();
      var1 = 29 * var1 + this.minStartIndex;
      var1 = 29 * var1 + this.maxStartIndex;
      var1 = 29 * var1 + this.minMiddleIndex;
      var1 = 29 * var1 + this.maxMiddleIndex;
      var1 = 29 * var1 + this.minEndIndex;
      var1 = 29 * var1 + this.maxEndIndex;
      return var1;
   }

   public Object clone() {
      TimePeriodValues var1 = this.createCopy(0, this.getItemCount() - 1);
      return var1;
   }

   public TimePeriodValues createCopy(int var1, int var2) {
      TimePeriodValues var3 = (TimePeriodValues)super.clone();
      var3.data = new ArrayList();
      if(this.data.size() > 0) {
         for(int var4 = var1; var4 <= var2; ++var4) {
            TimePeriodValue var5 = (TimePeriodValue)this.data.get(var4);
            TimePeriodValue var6 = (TimePeriodValue)var5.clone();

            try {
               var3.add(var6);
            } catch (SeriesException var8) {
               System.err.println("Failed to add cloned item.");
            }
         }
      }

      return var3;
   }

   public int getMinStartIndex() {
      return this.minStartIndex;
   }

   public int getMaxStartIndex() {
      return this.maxStartIndex;
   }

   public int getMinMiddleIndex() {
      return this.minMiddleIndex;
   }

   public int getMaxMiddleIndex() {
      return this.maxMiddleIndex;
   }

   public int getMinEndIndex() {
      return this.minEndIndex;
   }

   public int getMaxEndIndex() {
      return this.maxEndIndex;
   }
}
