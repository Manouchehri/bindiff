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

public class PeriodAxisLabelInfo implements Serializable, Cloneable {
   private static final long serialVersionUID = 5710451740920277357L;
   public static final RectangleInsets DEFAULT_INSETS = new RectangleInsets(2.0D, 2.0D, 2.0D, 2.0D);
   public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 10);
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

   public PeriodAxisLabelInfo(Class var1, DateFormat var2) {
      this(var1, var2, DEFAULT_INSETS, DEFAULT_FONT, DEFAULT_LABEL_PAINT, true, DEFAULT_DIVIDER_STROKE, DEFAULT_DIVIDER_PAINT);
   }

   public PeriodAxisLabelInfo(Class var1, DateFormat var2, RectangleInsets var3, Font var4, Paint var5, boolean var6, Stroke var7, Paint var8) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'periodClass\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'dateFormat\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'padding\' argument.");
      } else if(var4 == null) {
         throw new IllegalArgumentException("Null \'labelFont\' argument.");
      } else if(var5 == null) {
         throw new IllegalArgumentException("Null \'labelPaint\' argument.");
      } else if(var7 == null) {
         throw new IllegalArgumentException("Null \'dividerStroke\' argument.");
      } else if(var8 == null) {
         throw new IllegalArgumentException("Null \'dividerPaint\' argument.");
      } else {
         this.periodClass = var1;
         this.dateFormat = var2;
         this.padding = var3;
         this.labelFont = var4;
         this.labelPaint = var5;
         this.drawDividers = var6;
         this.dividerStroke = var7;
         this.dividerPaint = var8;
      }
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

   public RegularTimePeriod createInstance(Date var1, TimeZone var2) {
      RegularTimePeriod var3 = null;

      try {
         Constructor var4 = this.periodClass.getDeclaredConstructor(new Class[]{class$java$util$Date == null?(class$java$util$Date = class$("java.util.Date")):class$java$util$Date, class$java$util$TimeZone == null?(class$java$util$TimeZone = class$("java.util.TimeZone")):class$java$util$TimeZone});
         var3 = (RegularTimePeriod)var4.newInstance(new Object[]{var1, var2});
      } catch (Exception var5) {
         ;
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof PeriodAxisLabelInfo) {
         PeriodAxisLabelInfo var2 = (PeriodAxisLabelInfo)var1;
         return !var2.periodClass.equals(this.periodClass)?false:(!var2.dateFormat.equals(this.dateFormat)?false:(!var2.padding.equals(this.padding)?false:(!var2.labelFont.equals(this.labelFont)?false:(!var2.labelPaint.equals(this.labelPaint)?false:(var2.drawDividers != this.drawDividers?false:(!var2.dividerStroke.equals(this.dividerStroke)?false:var2.dividerPaint.equals(this.dividerPaint)))))));
      } else {
         return false;
      }
   }

   public int hashCode() {
      boolean var1 = true;
      int var2 = 37 * this.periodClass.hashCode();
      var2 = 37 * this.dateFormat.hashCode();
      return var2;
   }

   public Object clone() {
      PeriodAxisLabelInfo var1 = (PeriodAxisLabelInfo)super.clone();
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.labelPaint, var1);
      SerialUtilities.writeStroke(this.dividerStroke, var1);
      SerialUtilities.writePaint(this.dividerPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.labelPaint = SerialUtilities.readPaint(var1);
      this.dividerStroke = SerialUtilities.readStroke(var1);
      this.dividerPaint = SerialUtilities.readPaint(var1);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      DEFAULT_LABEL_PAINT = Color.black;
      DEFAULT_DIVIDER_STROKE = new BasicStroke(0.5F);
      DEFAULT_DIVIDER_PAINT = Color.gray;
   }
}
