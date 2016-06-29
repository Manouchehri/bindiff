package org.jfree.chart.axis;

import org.jfree.ui.*;
import java.text.*;
import java.util.*;
import org.jfree.data.time.*;
import org.jfree.io.*;
import java.io.*;
import java.awt.*;

public class PeriodAxisLabelInfo implements Serializable, Cloneable
{
    private static final long serialVersionUID = 5710451740920277357L;
    public static final RectangleInsets DEFAULT_INSETS;
    public static final Font DEFAULT_FONT;
    public static final Paint DEFAULT_LABEL_PAINT;
    public static final Stroke DEFAULT_DIVIDER_STROKE;
    public static final Paint DEFAULT_DIVIDER_PAINT;
    private Class periodClass;
    private RectangleInsets padding;
    private DateFormat dateFormat;
    private Font labelFont;
    private transient Paint labelPaint;
    private boolean drawDividers;
    private transient Stroke dividerStroke;
    private transient Paint dividerPaint;
    static Class class$java$util$Date;
    static Class class$java$util$TimeZone;
    
    public PeriodAxisLabelInfo(final Class clazz, final DateFormat dateFormat) {
        this(clazz, dateFormat, PeriodAxisLabelInfo.DEFAULT_INSETS, PeriodAxisLabelInfo.DEFAULT_FONT, PeriodAxisLabelInfo.DEFAULT_LABEL_PAINT, true, PeriodAxisLabelInfo.DEFAULT_DIVIDER_STROKE, PeriodAxisLabelInfo.DEFAULT_DIVIDER_PAINT);
    }
    
    public PeriodAxisLabelInfo(final Class periodClass, final DateFormat dateFormat, final RectangleInsets padding, final Font labelFont, final Paint labelPaint, final boolean drawDividers, final Stroke dividerStroke, final Paint dividerPaint) {
        if (periodClass == null) {
            throw new IllegalArgumentException("Null 'periodClass' argument.");
        }
        if (dateFormat == null) {
            throw new IllegalArgumentException("Null 'dateFormat' argument.");
        }
        if (padding == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        if (labelFont == null) {
            throw new IllegalArgumentException("Null 'labelFont' argument.");
        }
        if (labelPaint == null) {
            throw new IllegalArgumentException("Null 'labelPaint' argument.");
        }
        if (dividerStroke == null) {
            throw new IllegalArgumentException("Null 'dividerStroke' argument.");
        }
        if (dividerPaint == null) {
            throw new IllegalArgumentException("Null 'dividerPaint' argument.");
        }
        this.periodClass = periodClass;
        this.dateFormat = dateFormat;
        this.padding = padding;
        this.labelFont = labelFont;
        this.labelPaint = labelPaint;
        this.drawDividers = drawDividers;
        this.dividerStroke = dividerStroke;
        this.dividerPaint = dividerPaint;
    }
    
    public Class getPeriodClass() {
        return this.periodClass;
    }
    
    public DateFormat getDateFormat() {
        return this.dateFormat;
    }
    
    public RectangleInsets getPadding() {
        return this.padding;
    }
    
    public Font getLabelFont() {
        return this.labelFont;
    }
    
    public Paint getLabelPaint() {
        return this.labelPaint;
    }
    
    public boolean getDrawDividers() {
        return this.drawDividers;
    }
    
    public Stroke getDividerStroke() {
        return this.dividerStroke;
    }
    
    public Paint getDividerPaint() {
        return this.dividerPaint;
    }
    
    public RegularTimePeriod createInstance(final Date date, final TimeZone timeZone) {
        RegularTimePeriod regularTimePeriod = null;
        try {
            regularTimePeriod = this.periodClass.getDeclaredConstructor((PeriodAxisLabelInfo.class$java$util$Date == null) ? (PeriodAxisLabelInfo.class$java$util$Date = class$("java.util.Date")) : PeriodAxisLabelInfo.class$java$util$Date, (PeriodAxisLabelInfo.class$java$util$TimeZone == null) ? (PeriodAxisLabelInfo.class$java$util$TimeZone = class$("java.util.TimeZone")) : PeriodAxisLabelInfo.class$java$util$TimeZone).newInstance(date, timeZone);
        }
        catch (Exception ex) {}
        return regularTimePeriod;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof PeriodAxisLabelInfo) {
            final PeriodAxisLabelInfo periodAxisLabelInfo = (PeriodAxisLabelInfo)o;
            return periodAxisLabelInfo.periodClass.equals(this.periodClass) && periodAxisLabelInfo.dateFormat.equals(this.dateFormat) && periodAxisLabelInfo.padding.equals(this.padding) && periodAxisLabelInfo.labelFont.equals(this.labelFont) && periodAxisLabelInfo.labelPaint.equals(this.labelPaint) && periodAxisLabelInfo.drawDividers == this.drawDividers && periodAxisLabelInfo.dividerStroke.equals(this.dividerStroke) && periodAxisLabelInfo.dividerPaint.equals(this.dividerPaint);
        }
        return false;
    }
    
    public int hashCode() {
        final int n = 37 * this.periodClass.hashCode();
        return 37 * this.dateFormat.hashCode();
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.dividerStroke, objectOutputStream);
        SerialUtilities.writePaint(this.dividerPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
        this.dividerStroke = SerialUtilities.readStroke(objectInputStream);
        this.dividerPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        DEFAULT_INSETS = new RectangleInsets(2.0, 2.0, 2.0, 2.0);
        DEFAULT_FONT = new Font("SansSerif", 0, 10);
        DEFAULT_LABEL_PAINT = Color.black;
        DEFAULT_DIVIDER_STROKE = new BasicStroke(0.5f);
        DEFAULT_DIVIDER_PAINT = Color.gray;
    }
}
