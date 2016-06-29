/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;

public class PeriodAxisLabelInfo
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 5710451740920277357L;
    public static final RectangleInsets DEFAULT_INSETS = new RectangleInsets(2.0, 2.0, 2.0, 2.0);
    public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 10);
    public static final Paint DEFAULT_LABEL_PAINT = Color.black;
    public static final Stroke DEFAULT_DIVIDER_STROKE = new BasicStroke(0.5f);
    public static final Paint DEFAULT_DIVIDER_PAINT = Color.gray;
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

    public PeriodAxisLabelInfo(Class class_, DateFormat dateFormat) {
        this(class_, dateFormat, DEFAULT_INSETS, DEFAULT_FONT, DEFAULT_LABEL_PAINT, true, DEFAULT_DIVIDER_STROKE, DEFAULT_DIVIDER_PAINT);
    }

    public PeriodAxisLabelInfo(Class class_, DateFormat dateFormat, RectangleInsets rectangleInsets, Font font, Paint paint, boolean bl2, Stroke stroke, Paint paint2) {
        if (class_ == null) {
            throw new IllegalArgumentException("Null 'periodClass' argument.");
        }
        if (dateFormat == null) {
            throw new IllegalArgumentException("Null 'dateFormat' argument.");
        }
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'padding' argument.");
        }
        if (font == null) {
            throw new IllegalArgumentException("Null 'labelFont' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'labelPaint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'dividerStroke' argument.");
        }
        if (paint2 == null) {
            throw new IllegalArgumentException("Null 'dividerPaint' argument.");
        }
        this.periodClass = class_;
        this.dateFormat = dateFormat;
        this.padding = rectangleInsets;
        this.labelFont = font;
        this.labelPaint = paint;
        this.drawDividers = bl2;
        this.dividerStroke = stroke;
        this.dividerPaint = paint2;
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

    public RegularTimePeriod createInstance(Date date, TimeZone timeZone) {
        RegularTimePeriod regularTimePeriod = null;
        try {
            Class[] arrclass = new Class[2];
            Class class_ = class$java$util$Date == null ? (PeriodAxisLabelInfo.class$java$util$Date = PeriodAxisLabelInfo.class$("java.util.Date")) : class$java$util$Date;
            arrclass[0] = class_;
            Class class_2 = class$java$util$TimeZone == null ? (PeriodAxisLabelInfo.class$java$util$TimeZone = PeriodAxisLabelInfo.class$("java.util.TimeZone")) : class$java$util$TimeZone;
            arrclass[1] = class_2;
            Constructor constructor = this.periodClass.getDeclaredConstructor(arrclass);
            return (RegularTimePeriod)constructor.newInstance(date, timeZone);
        }
        catch (Exception var4_5) {
            // empty catch block
        }
        return regularTimePeriod;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PeriodAxisLabelInfo)) return false;
        PeriodAxisLabelInfo periodAxisLabelInfo = (PeriodAxisLabelInfo)object;
        if (!periodAxisLabelInfo.periodClass.equals(this.periodClass)) {
            return false;
        }
        if (!periodAxisLabelInfo.dateFormat.equals(this.dateFormat)) {
            return false;
        }
        if (!periodAxisLabelInfo.padding.equals(this.padding)) {
            return false;
        }
        if (!periodAxisLabelInfo.labelFont.equals(this.labelFont)) {
            return false;
        }
        if (!periodAxisLabelInfo.labelPaint.equals(this.labelPaint)) {
            return false;
        }
        if (periodAxisLabelInfo.drawDividers != this.drawDividers) {
            return false;
        }
        if (!periodAxisLabelInfo.dividerStroke.equals(this.dividerStroke)) {
            return false;
        }
        if (periodAxisLabelInfo.dividerPaint.equals(this.dividerPaint)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 41;
        n2 = 37 * this.periodClass.hashCode();
        return 37 * this.dateFormat.hashCode();
    }

    public Object clone() {
        return (PeriodAxisLabelInfo)super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.labelPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.dividerStroke, objectOutputStream);
        SerialUtilities.writePaint(this.dividerPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.labelPaint = SerialUtilities.readPaint(objectInputStream);
        this.dividerStroke = SerialUtilities.readStroke(objectInputStream);
        this.dividerPaint = SerialUtilities.readPaint(objectInputStream);
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

