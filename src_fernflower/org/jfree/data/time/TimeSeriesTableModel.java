package org.jfree.data.time;

import javax.swing.table.AbstractTableModel;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;

public class TimeSeriesTableModel extends AbstractTableModel implements SeriesChangeListener {
   private TimeSeries series;
   private boolean editable;
   private RegularTimePeriod newTimePeriod;
   private Number newValue;
   static Class class$java$lang$String;
   static Class class$java$lang$Double;

   public TimeSeriesTableModel() {
      this(new TimeSeries("Untitled"));
   }

   public TimeSeriesTableModel(TimeSeries var1) {
      this(var1, false);
   }

   public TimeSeriesTableModel(TimeSeries var1, boolean var2) {
      this.series = var1;
      this.series.addChangeListener(this);
      this.editable = var2;
   }

   public int getColumnCount() {
      return 2;
   }

   public Class getColumnClass(int var1) {
      return var1 == 0?(class$java$lang$String == null?(class$java$lang$String = class$("java.lang.String")):class$java$lang$String):(var1 == 1?(class$java$lang$Double == null?(class$java$lang$Double = class$("java.lang.Double")):class$java$lang$Double):null);
   }

   public String getColumnName(int var1) {
      return var1 == 0?"Period:":(var1 == 1?"Value:":null);
   }

   public int getRowCount() {
      return this.series.getItemCount();
   }

   public Object getValueAt(int var1, int var2) {
      return var1 < this.series.getItemCount()?(var2 == 0?this.series.getTimePeriod(var1):(var2 == 1?this.series.getValue(var1):null)):(var2 == 0?this.newTimePeriod:(var2 == 1?this.newValue:null));
   }

   public boolean isCellEditable(int var1, int var2) {
      return this.editable?var2 == 0 || var2 == 1:false;
   }

   public void setValueAt(Object var1, int var2, int var3) {
      if(var2 < this.series.getItemCount()) {
         if(var3 == 1) {
            try {
               Double var4 = Double.valueOf(var1.toString());
               this.series.update(var2, var4);
            } catch (NumberFormatException var5) {
               System.err.println("Number format exception");
            }
         }
      } else if(var3 == 0) {
         this.newTimePeriod = null;
      } else if(var3 == 1) {
         this.newValue = Double.valueOf(var1.toString());
      }

   }

   public void seriesChanged(SeriesChangeEvent var1) {
      this.fireTableDataChanged();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
