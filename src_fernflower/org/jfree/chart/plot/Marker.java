package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import org.jfree.chart.event.MarkerChangeEvent;
import org.jfree.chart.event.MarkerChangeListener;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public abstract class Marker implements Serializable, Cloneable {
   private static final long serialVersionUID = -734389651405327166L;
   private transient Paint paint;
   private transient Stroke stroke;
   private transient Paint outlinePaint;
   private transient Stroke outlineStroke;
   private float alpha;
   private String label;
   private Font labelFont;
   private transient Paint labelPaint;
   private RectangleAnchor labelAnchor;
   private TextAnchor labelTextAnchor;
   private RectangleInsets labelOffset;
   private LengthAdjustmentType labelOffsetType;
   private transient EventListenerList listenerList;
   static Class class$org$jfree$chart$event$MarkerChangeListener;

   protected Marker() {
      this(Color.gray);
   }

   protected Marker(Paint var1) {
      this(var1, new BasicStroke(0.5F), Color.gray, new BasicStroke(0.5F), 0.8F);
   }

   protected Marker(Paint var1, Stroke var2, Paint var3, Stroke var4, float var5) {
      this.label = null;
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else if(var5 >= 0.0F && var5 <= 1.0F) {
         this.paint = var1;
         this.stroke = var2;
         this.outlinePaint = var3;
         this.outlineStroke = var4;
         this.alpha = var5;
         this.labelFont = new Font("SansSerif", 0, 9);
         this.labelPaint = Color.black;
         this.labelAnchor = RectangleAnchor.TOP_LEFT;
         this.labelOffset = new RectangleInsets(3.0D, 3.0D, 3.0D, 3.0D);
         this.labelOffsetType = LengthAdjustmentType.CONTRACT;
         this.labelTextAnchor = TextAnchor.CENTER;
         this.listenerList = new EventListenerList();
      } else {
         throw new IllegalArgumentException("The \'alpha\' value must be in the range 0.0f to 1.0f");
      }
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void setPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.paint = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public Stroke getStroke() {
      return this.stroke;
   }

   public void setStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.stroke = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public void setOutlinePaint(Paint var1) {
      this.outlinePaint = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public Stroke getOutlineStroke() {
      return this.outlineStroke;
   }

   public void setOutlineStroke(Stroke var1) {
      this.outlineStroke = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public float getAlpha() {
      return this.alpha;
   }

   public void setAlpha(float var1) {
      if(var1 >= 0.0F && var1 <= 1.0F) {
         this.alpha = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      } else {
         throw new IllegalArgumentException("The \'alpha\' value must be in the range 0.0f to 1.0f");
      }
   }

   public String getLabel() {
      return this.label;
   }

   public void setLabel(String var1) {
      this.label = var1;
      this.notifyListeners(new MarkerChangeEvent(this));
   }

   public Font getLabelFont() {
      return this.labelFont;
   }

   public void setLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.labelFont = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public Paint getLabelPaint() {
      return this.labelPaint;
   }

   public void setLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.labelPaint = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public RectangleAnchor getLabelAnchor() {
      return this.labelAnchor;
   }

   public void setLabelAnchor(RectangleAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.labelAnchor = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public RectangleInsets getLabelOffset() {
      return this.labelOffset;
   }

   public void setLabelOffset(RectangleInsets var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'offset\' argument.");
      } else {
         this.labelOffset = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public LengthAdjustmentType getLabelOffsetType() {
      return this.labelOffsetType;
   }

   public void setLabelOffsetType(LengthAdjustmentType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'adj\' argument.");
      } else {
         this.labelOffsetType = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public TextAnchor getLabelTextAnchor() {
      return this.labelTextAnchor;
   }

   public void setLabelTextAnchor(TextAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.labelTextAnchor = var1;
         this.notifyListeners(new MarkerChangeEvent(this));
      }
   }

   public void addChangeListener(MarkerChangeListener var1) {
      this.listenerList.add(class$org$jfree$chart$event$MarkerChangeListener == null?(class$org$jfree$chart$event$MarkerChangeListener = class$("org.jfree.chart.event.MarkerChangeListener")):class$org$jfree$chart$event$MarkerChangeListener, var1);
   }

   public void removeChangeListener(MarkerChangeListener var1) {
      this.listenerList.remove(class$org$jfree$chart$event$MarkerChangeListener == null?(class$org$jfree$chart$event$MarkerChangeListener = class$("org.jfree.chart.event.MarkerChangeListener")):class$org$jfree$chart$event$MarkerChangeListener, var1);
   }

   public void notifyListeners(MarkerChangeEvent var1) {
      Object[] var2 = this.listenerList.getListenerList();

      for(int var3 = var2.length - 2; var3 >= 0; var3 -= 2) {
         if(var2[var3] == (class$org$jfree$chart$event$MarkerChangeListener == null?(class$org$jfree$chart$event$MarkerChangeListener = class$("org.jfree.chart.event.MarkerChangeListener")):class$org$jfree$chart$event$MarkerChangeListener)) {
            ((MarkerChangeListener)var2[var3 + 1]).markerChanged(var1);
         }
      }

   }

   public EventListener[] getListeners(Class var1) {
      return this.listenerList.getListeners(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Marker)) {
         return false;
      } else {
         Marker var2 = (Marker)var1;
         return !PaintUtilities.equal(this.paint, var2.paint)?false:(!ObjectUtilities.equal(this.stroke, var2.stroke)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:(!ObjectUtilities.equal(this.outlineStroke, var2.outlineStroke)?false:(this.alpha != var2.alpha?false:(!ObjectUtilities.equal(this.label, var2.label)?false:(!ObjectUtilities.equal(this.labelFont, var2.labelFont)?false:(!PaintUtilities.equal(this.labelPaint, var2.labelPaint)?false:(this.labelAnchor != var2.labelAnchor?false:(this.labelTextAnchor != var2.labelTextAnchor?false:(!ObjectUtilities.equal(this.labelOffset, var2.labelOffset)?false:this.labelOffsetType.equals(var2.labelOffsetType)))))))))));
      }
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
      SerialUtilities.writeStroke(this.stroke, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writeStroke(this.outlineStroke, var1);
      SerialUtilities.writePaint(this.labelPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
      this.stroke = SerialUtilities.readStroke(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.outlineStroke = SerialUtilities.readStroke(var1);
      this.labelPaint = SerialUtilities.readPaint(var1);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
