/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time;

import java.io.PrintStream;
import javax.swing.table.AbstractTableModel;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;

public class TimeSeriesTableModel
extends AbstractTableModel
implements SeriesChangeListener {
    private TimeSeries series;
    private boolean editable;
    private RegularTimePeriod newTimePeriod;
    private Number newValue;
    static Class class$java$lang$String;
    static Class class$java$lang$Double;

    public TimeSeriesTableModel() {
        this(new TimeSeries("Untitled"));
    }

    public TimeSeriesTableModel(TimeSeries timeSeries) {
        this(timeSeries, false);
    }

    public TimeSeriesTableModel(TimeSeries timeSeries, boolean bl2) {
        this.series = timeSeries;
        this.series.addChangeListener(this);
        this.editable = bl2;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    public Class getColumnClass(int n2) {
        Class class_;
        if (n2 == 0) {
            Class class_2;
            if (class$java$lang$String == null) {
                class_2 = TimeSeriesTableModel.class$java$lang$String = TimeSeriesTableModel.class$("java.lang.String");
                return class_2;
            }
            class_2 = class$java$lang$String;
            return class_2;
        }
        if (n2 != 1) return null;
        if (class$java$lang$Double == null) {
            class_ = TimeSeriesTableModel.class$java$lang$Double = TimeSeriesTableModel.class$("java.lang.Double");
            return class_;
        }
        class_ = class$java$lang$Double;
        return class_;
    }

    @Override
    public String getColumnName(int n2) {
        if (n2 == 0) {
            return "Period:";
        }
        if (n2 != 1) return null;
        return "Value:";
    }

    @Override
    public int getRowCount() {
        return this.series.getItemCount();
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        if (n2 < this.series.getItemCount()) {
            if (n3 == 0) {
                return this.series.getTimePeriod(n2);
            }
            if (n3 != 1) return null;
            return this.series.getValue(n2);
        }
        if (n3 == 0) {
            return this.newTimePeriod;
        }
        if (n3 != 1) return null;
        return this.newValue;
    }

    @Override
    public boolean isCellEditable(int n2, int n3) {
        if (!this.editable) return false;
        if (n3 == 0) return true;
        if (n3 != 1) return false;
        return true;
    }

    @Override
    public void setValueAt(Object object, int n2, int n3) {
        if (n2 < this.series.getItemCount()) {
            if (n3 != 1) return;
            try {
                Double d2 = Double.valueOf(object.toString());
                this.series.update(n2, (Number)d2);
                return;
            }
            catch (NumberFormatException var4_5) {
                System.err.println("Number format exception");
                return;
            }
        }
        if (n3 == 0) {
            this.newTimePeriod = null;
            return;
        }
        if (n3 != 1) return;
        this.newValue = Double.valueOf(object.toString());
    }

    @Override
    public void seriesChanged(SeriesChangeEvent seriesChangeEvent) {
        this.fireTableDataChanged();
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

