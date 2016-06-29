package org.jfree.data.time;

import javax.swing.table.*;
import org.jfree.data.general.*;

public class TimeSeriesTableModel extends AbstractTableModel implements SeriesChangeListener
{
    private TimeSeries series;
    private boolean editable;
    private RegularTimePeriod newTimePeriod;
    private Number newValue;
    static Class class$java$lang$String;
    static Class class$java$lang$Double;
    
    public TimeSeriesTableModel() {
        this(new TimeSeries("Untitled"));
    }
    
    public TimeSeriesTableModel(final TimeSeries timeSeries) {
        this(timeSeries, false);
    }
    
    public TimeSeriesTableModel(final TimeSeries series, final boolean editable) {
        (this.series = series).addChangeListener(this);
        this.editable = editable;
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    public Class getColumnClass(final int n) {
        if (n == 0) {
            return (TimeSeriesTableModel.class$java$lang$String == null) ? (TimeSeriesTableModel.class$java$lang$String = class$("java.lang.String")) : TimeSeriesTableModel.class$java$lang$String;
        }
        if (n == 1) {
            return (TimeSeriesTableModel.class$java$lang$Double == null) ? (TimeSeriesTableModel.class$java$lang$Double = class$("java.lang.Double")) : TimeSeriesTableModel.class$java$lang$Double;
        }
        return null;
    }
    
    public String getColumnName(final int n) {
        if (n == 0) {
            return "Period:";
        }
        if (n == 1) {
            return "Value:";
        }
        return null;
    }
    
    public int getRowCount() {
        return this.series.getItemCount();
    }
    
    public Object getValueAt(final int n, final int n2) {
        if (n < this.series.getItemCount()) {
            if (n2 == 0) {
                return this.series.getTimePeriod(n);
            }
            if (n2 == 1) {
                return this.series.getValue(n);
            }
            return null;
        }
        else {
            if (n2 == 0) {
                return this.newTimePeriod;
            }
            if (n2 == 1) {
                return this.newValue;
            }
            return null;
        }
    }
    
    public boolean isCellEditable(final int n, final int n2) {
        return this.editable && (n2 == 0 || n2 == 1);
    }
    
    public void setValueAt(final Object o, final int n, final int n2) {
        if (n < this.series.getItemCount()) {
            if (n2 == 1) {
                try {
                    this.series.update(n, Double.valueOf(o.toString()));
                }
                catch (NumberFormatException ex) {
                    System.err.println("Number format exception");
                }
            }
        }
        else if (n2 == 0) {
            this.newTimePeriod = null;
        }
        else if (n2 == 1) {
            this.newValue = Double.valueOf(o.toString());
        }
    }
    
    public void seriesChanged(final SeriesChangeEvent seriesChangeEvent) {
        this.fireTableDataChanged();
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
