package org.jfree.chart.annotations;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class TextAnnotation implements Serializable {
   private static final long serialVersionUID = 7008912287533127432L;
   public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 10);
   public static final Paint DEFAULT_PAINT;
   public static final TextAnchor DEFAULT_TEXT_ANCHOR;
   public static final TextAnchor DEFAULT_ROTATION_ANCHOR;
   public static final double DEFAULT_ROTATION_ANGLE = 0.0D;
   private String text;
   private Font font;
   private transient Paint paint;
   private TextAnchor textAnchor;
   private TextAnchor rotationAnchor;
   private double rotationAngle;

   protected TextAnnotation(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else {
         this.text = var1;
         this.font = DEFAULT_FONT;
         this.paint = DEFAULT_PAINT;
         this.textAnchor = DEFAULT_TEXT_ANCHOR;
         this.rotationAnchor = DEFAULT_ROTATION_ANCHOR;
         this.rotationAngle = 0.0D;
      }
   }

   public String getText() {
      return this.text;
   }

   public void setText(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else {
         this.text = var1;
      }
   }

   public Font getFont() {
      return this.font;
   }

   public void setFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.font = var1;
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
      }
   }

   public TextAnchor getTextAnchor() {
      return this.textAnchor;
   }

   public void setTextAnchor(TextAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.textAnchor = var1;
      }
   }

   public TextAnchor getRotationAnchor() {
      return this.rotationAnchor;
   }

   public void setRotationAnchor(TextAnchor var1) {
      this.rotationAnchor = var1;
   }

   public double getRotationAngle() {
      return this.rotationAngle;
   }

   public void setRotationAngle(double var1) {
      this.rotationAngle = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TextAnnotation)) {
         return false;
      } else {
         TextAnnotation var2 = (TextAnnotation)var1;
         return !ObjectUtilities.equal(this.text, var2.getText())?false:(!ObjectUtilities.equal(this.font, var2.getFont())?false:(!PaintUtilities.equal(this.paint, var2.getPaint())?false:(!ObjectUtilities.equal(this.textAnchor, var2.getTextAnchor())?false:(!ObjectUtilities.equal(this.rotationAnchor, var2.getRotationAnchor())?false:this.rotationAngle == var2.getRotationAngle()))));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var4 = 37 * var1 + this.font.hashCode();
      var4 = 37 * var4 + HashUtilities.hashCodeForPaint(this.paint);
      var4 = 37 * var4 + this.rotationAnchor.hashCode();
      long var2 = Double.doubleToLongBits(this.rotationAngle);
      var4 = 37 * var4 + (int)(var2 ^ var2 >>> 32);
      var4 = 37 * var4 + this.text.hashCode();
      var4 = 37 * var4 + this.textAnchor.hashCode();
      return var4;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
   }

   static {
      DEFAULT_PAINT = Color.black;
      DEFAULT_TEXT_ANCHOR = TextAnchor.CENTER;
      DEFAULT_ROTATION_ANCHOR = TextAnchor.CENTER;
   }
}
