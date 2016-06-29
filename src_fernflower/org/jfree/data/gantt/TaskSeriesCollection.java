package org.jfree.data.gantt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.time.TimePeriod;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class TaskSeriesCollection extends AbstractSeriesDataset implements Serializable, Cloneable, GanttCategoryDataset, PublicCloneable {
   private static final long serialVersionUID = -2065799050738449903L;
   private List keys = new ArrayList();
   private List data = new ArrayList();

   public TaskSeries getSeries(Comparable var1) {
      if(var1 == null) {
         throw new NullPointerException("Null \'key\' argument.");
      } else {
         TaskSeries var2 = null;
         int var3 = this.getRowIndex(var1);
         if(var3 >= 0) {
            var2 = this.getSeries(var3);
         }

         return var2;
      }
   }

   public TaskSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (TaskSeries)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("Series index out of bounds");
      }
   }

   public int getSeriesCount() {
      return this.getRowCount();
   }

   public Comparable getSeriesKey(int var1) {
      TaskSeries var2 = (TaskSeries)this.data.get(var1);
      return var2.getKey();
   }

   public int getRowCount() {
      return this.data.size();
   }

   public List getRowKeys() {
      return this.data;
   }

   public int getColumnCount() {
      return this.keys.size();
   }

   public List getColumnKeys() {
      return this.keys;
   }

   public Comparable getColumnKey(int var1) {
      return (Comparable)this.keys.get(var1);
   }

   public int getColumnIndex(Comparable var1) {
      return this.keys.indexOf(var1);
   }

   public int getRowIndex(Comparable var1) {
      int var2 = -1;
      int var3 = this.data.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         TaskSeries var5 = (TaskSeries)this.data.get(var4);
         if(var5.getKey().equals(var1)) {
            var2 = var4;
            break;
         }
      }

      return var2;
   }

   public Comparable getRowKey(int var1) {
      TaskSeries var2 = (TaskSeries)this.data.get(var1);
      return var2.getKey();
   }

   public void add(TaskSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.add(var1);
         var1.addChangeListener(this);
         Iterator var2 = var1.getTasks().iterator();

         while(var2.hasNext()) {
            Task var3 = (Task)var2.next();
            String var4 = var3.getDescription();
            int var5 = this.keys.indexOf(var4);
            if(var5 < 0) {
               this.keys.add(var4);
            }
         }

         this.fireDatasetChanged();
      }
   }

   public void remove(TaskSeries var1) {
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

   public void remove(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         TaskSeries var2 = (TaskSeries)this.data.get(var1);
         var2.removeChangeListener(this);
         this.data.remove(var1);
         this.fireDatasetChanged();
      } else {
         throw new IllegalArgumentException("TaskSeriesCollection.remove(): index outside valid range.");
      }
   }

   public void removeAll() {
      Iterator var1 = this.data.iterator();

      while(var1.hasNext()) {
         TaskSeries var2 = (TaskSeries)var1.next();
         var2.removeChangeListener(this);
      }

      this.data.clear();
      this.fireDatasetChanged();
   }

   public Number getValue(Comparable var1, Comparable var2) {
      return this.getStartValue(var1, var2);
   }

   public Number getValue(int var1, int var2) {
      return this.getStartValue(var1, var2);
   }

   public Number getStartValue(Comparable var1, Comparable var2) {
      Long var3 = null;
      int var4 = this.getRowIndex(var1);
      TaskSeries var5 = (TaskSeries)this.data.get(var4);
      Task var6 = var5.get(var2.toString());
      if(var6 != null) {
         TimePeriod var7 = var6.getDuration();
         if(var7 != null) {
            var3 = new Long(var7.getStart().getTime());
         }
      }

      return var3;
   }

   public Number getStartValue(int var1, int var2) {
      Comparable var3 = this.getRowKey(var1);
      Comparable var4 = this.getColumnKey(var2);
      return this.getStartValue(var3, var4);
   }

   public Number getEndValue(Comparable var1, Comparable var2) {
      Long var3 = null;
      int var4 = this.getRowIndex(var1);
      TaskSeries var5 = (TaskSeries)this.data.get(var4);
      Task var6 = var5.get(var2.toString());
      if(var6 != null) {
         TimePeriod var7 = var6.getDuration();
         if(var7 != null) {
            var3 = new Long(var7.getEnd().getTime());
         }
      }

      return var3;
   }

   public Number getEndValue(int var1, int var2) {
      Comparable var3 = this.getRowKey(var1);
      Comparable var4 = this.getColumnKey(var2);
      return this.getEndValue(var3, var4);
   }

   public Number getPercentComplete(int var1, int var2) {
      Comparable var3 = this.getRowKey(var1);
      Comparable var4 = this.getColumnKey(var2);
      return this.getPercentComplete(var3, var4);
   }

   public Number getPercentComplete(Comparable var1, Comparable var2) {
      Double var3 = null;
      int var4 = this.getRowIndex(var1);
      TaskSeries var5 = (TaskSeries)this.data.get(var4);
      Task var6 = var5.get(var2.toString());
      if(var6 != null) {
         var3 = var6.getPercentComplete();
      }

      return var3;
   }

   public int getSubIntervalCount(int var1, int var2) {
      Comparable var3 = this.getRowKey(var1);
      Comparable var4 = this.getColumnKey(var2);
      return this.getSubIntervalCount(var3, var4);
   }

   public int getSubIntervalCount(Comparable var1, Comparable var2) {
      int var3 = 0;
      int var4 = this.getRowIndex(var1);
      TaskSeries var5 = (TaskSeries)this.data.get(var4);
      Task var6 = var5.get(var2.toString());
      if(var6 != null) {
         var3 = var6.getSubtaskCount();
      }

      return var3;
   }

   public Number getStartValue(int var1, int var2, int var3) {
      Comparable var4 = this.getRowKey(var1);
      Comparable var5 = this.getColumnKey(var2);
      return this.getStartValue(var4, var5, var3);
   }

   public Number getStartValue(Comparable var1, Comparable var2, int var3) {
      Long var4 = null;
      int var5 = this.getRowIndex(var1);
      TaskSeries var6 = (TaskSeries)this.data.get(var5);
      Task var7 = var6.get(var2.toString());
      if(var7 != null) {
         Task var8 = var7.getSubtask(var3);
         if(var8 != null) {
            TimePeriod var9 = var8.getDuration();
            var4 = new Long(var9.getStart().getTime());
         }
      }

      return var4;
   }

   public Number getEndValue(int var1, int var2, int var3) {
      Comparable var4 = this.getRowKey(var1);
      Comparable var5 = this.getColumnKey(var2);
      return this.getEndValue(var4, var5, var3);
   }

   public Number getEndValue(Comparable var1, Comparable var2, int var3) {
      Long var4 = null;
      int var5 = this.getRowIndex(var1);
      TaskSeries var6 = (TaskSeries)this.data.get(var5);
      Task var7 = var6.get(var2.toString());
      if(var7 != null) {
         Task var8 = var7.getSubtask(var3);
         if(var8 != null) {
            TimePeriod var9 = var8.getDuration();
            var4 = new Long(var9.getEnd().getTime());
         }
      }

      return var4;
   }

   public Number getPercentComplete(int var1, int var2, int var3) {
      Comparable var4 = this.getRowKey(var1);
      Comparable var5 = this.getColumnKey(var2);
      return this.getPercentComplete(var4, var5, var3);
   }

   public Number getPercentComplete(Comparable var1, Comparable var2, int var3) {
      Double var4 = null;
      int var5 = this.getRowIndex(var1);
      TaskSeries var6 = (TaskSeries)this.data.get(var5);
      Task var7 = var6.get(var2.toString());
      if(var7 != null) {
         Task var8 = var7.getSubtask(var3);
         if(var8 != null) {
            var4 = var8.getPercentComplete();
         }
      }

      return var4;
   }

   public void seriesChanged(SeriesChangeEvent var1) {
      this.refreshKeys();
      this.fireDatasetChanged();
   }

   private void refreshKeys() {
      this.keys.clear();

      for(int var1 = 0; var1 < this.getSeriesCount(); ++var1) {
         TaskSeries var2 = (TaskSeries)this.data.get(var1);
         Iterator var3 = var2.getTasks().iterator();

         while(var3.hasNext()) {
            Task var4 = (Task)var3.next();
            String var5 = var4.getDescription();
            int var6 = this.keys.indexOf(var5);
            if(var6 < 0) {
               this.keys.add(var5);
            }
         }
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TaskSeriesCollection)) {
         return false;
      } else {
         TaskSeriesCollection var2 = (TaskSeriesCollection)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      }
   }
}
