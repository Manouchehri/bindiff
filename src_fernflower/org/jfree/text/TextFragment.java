package org.jfree.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;

public class TextFragment implements Serializable {
   private static final long serialVersionUID = 4465945952903143262L;
   public static final Font DEFAULT_FONT = new Font("Serif", 0, 12);
   public static final Paint DEFAULT_PAINT;
   private String text;
   private Font font;
   private transient Paint paint;
   private float baselineOffset;
   protected static final LogContext logger;
   static Class class$org$jfree$text$TextFragment;

   public TextFragment(String var1) {
      this(var1, DEFAULT_FONT, DEFAULT_PAINT);
   }

   public TextFragment(String var1, Font var2) {
      this(var1, var2, DEFAULT_PAINT);
   }

   public TextFragment(String var1, Font var2, Paint var3) {
      this(var1, var2, var3, 0.0F);
   }

   public TextFragment(String var1, Font var2, Paint var3, float var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'text\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.text = var1;
         this.font = var2;
         this.paint = var3;
         this.baselineOffset = var4;
      }
   }

   public String getText() {
      return this.text;
   }

   public Font getFont() {
      return this.font;
   }

   public Paint getPaint() {
      return this.paint;
   }

   public float getBaselineOffset() {
      return this.baselineOffset;
   }

   public void draw(Graphics2D var1, float var2, float var3, TextAnchor var4, float var5, float var6, double var7) {
      var1.setFont(this.font);
      var1.setPaint(this.paint);
      TextUtilities.drawRotatedString(this.text, var1, var2, var3 + this.baselineOffset, var4, var7, var5, var6);
   }

   public Size2D calculateDimensions(Graphics2D var1) {
      FontMetrics var2 = var1.getFontMetrics(this.font);
      Rectangle2D var3 = TextUtilities.getTextBounds(this.text, var1, var2);
      Size2D var4 = new Size2D(var3.getWidth(), var3.getHeight());
      return var4;
   }

   public float calculateBaselineOffset(Graphics2D var1, TextAnchor var2) {
      float var3 = 0.0F;
      FontMetrics var4 = var1.getFontMetrics(this.font);
      LineMetrics var5 = var4.getLineMetrics("ABCxyz", var1);
      if(var2 != TextAnchor.TOP_LEFT && var2 != TextAnchor.TOP_CENTER && var2 != TextAnchor.TOP_RIGHT) {
         if(var2 == TextAnchor.BOTTOM_LEFT || var2 == TextAnchor.BOTTOM_CENTER || var2 == TextAnchor.BOTTOM_RIGHT) {
            var3 = -var5.getDescent() - var5.getLeading();
         }
      } else {
         var3 = var5.getAscent();
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(var1 instanceof TextFragment) {
         TextFragment var2 = (TextFragment)var1;
         return !this.text.equals(var2.text)?false:(!this.font.equals(var2.font)?false:this.paint.equals(var2.paint));
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.text != null?this.text.hashCode():0;
      var1 = 29 * var1 + (this.font != null?this.font.hashCode():0);
      var1 = 29 * var1 + (this.paint != null?this.paint.hashCode():0);
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      DEFAULT_PAINT = Color.black;
      logger = Log.createContext(class$org$jfree$text$TextFragment == null?(class$org$jfree$text$TextFragment = class$("org.jfree.text.TextFragment")):class$org$jfree$text$TextFragment);
   }
}
