package org.jfree.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextLine;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.Size2D;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Log;
import org.jfree.util.LogContext;
import org.jfree.util.ShapeUtilities;

public class TextBlock implements Serializable {
   private static final long serialVersionUID = -4333175719424385526L;
   private List lines = new ArrayList();
   private HorizontalAlignment lineAlignment;
   protected static final LogContext logger;
   static Class class$org$jfree$text$TextBlock;

   public TextBlock() {
      this.lineAlignment = HorizontalAlignment.CENTER;
   }

   public HorizontalAlignment getLineAlignment() {
      return this.lineAlignment;
   }

   public void setLineAlignment(HorizontalAlignment var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'alignment\' argument.");
      } else {
         this.lineAlignment = var1;
      }
   }

   public void addLine(String var1, Font var2, Paint var3) {
      this.addLine(new TextLine(var1, var2, var3));
   }

   public void addLine(TextLine var1) {
      this.lines.add(var1);
   }

   public TextLine getLastLine() {
      TextLine var1 = null;
      int var2 = this.lines.size() - 1;
      if(var2 >= 0) {
         var1 = (TextLine)this.lines.get(var2);
      }

      return var1;
   }

   public List getLines() {
      return Collections.unmodifiableList(this.lines);
   }

   public Size2D calculateDimensions(Graphics2D var1) {
      double var2 = 0.0D;
      double var4 = 0.0D;

      Size2D var8;
      for(Iterator var6 = this.lines.iterator(); var6.hasNext(); var4 += var8.getHeight()) {
         TextLine var7 = (TextLine)var6.next();
         var8 = var7.calculateDimensions(var1);
         var2 = Math.max(var2, var8.getWidth());
      }

      if(logger.isDebugEnabled()) {
         logger.debug("width = " + var2 + ", height = " + var4);
      }

      return new Size2D(var2, var4);
   }

   public Shape calculateBounds(Graphics2D var1, float var2, float var3, TextBlockAnchor var4, float var5, float var6, double var7) {
      Size2D var9 = this.calculateDimensions(var1);
      float[] var10 = this.calculateOffsets(var4, var9.getWidth(), var9.getHeight());
      Double var11 = new Double((double)(var2 + var10[0]), (double)(var3 + var10[1]), var9.getWidth(), var9.getHeight());
      Shape var12 = ShapeUtilities.rotateShape(var11, var7, var5, var6);
      return var12;
   }

   public void draw(Graphics2D var1, float var2, float var3, TextBlockAnchor var4) {
      this.draw(var1, var2, var3, var4, 0.0F, 0.0F, 0.0D);
   }

   public void draw(Graphics2D var1, float var2, float var3, TextBlockAnchor var4, float var5, float var6, double var7) {
      Size2D var9 = this.calculateDimensions(var1);
      float[] var10 = this.calculateOffsets(var4, var9.getWidth(), var9.getHeight());
      Iterator var11 = this.lines.iterator();

      Size2D var14;
      for(float var12 = 0.0F; var11.hasNext(); var12 += (float)var14.getHeight()) {
         TextLine var13 = (TextLine)var11.next();
         var14 = var13.calculateDimensions(var1);
         float var15 = 0.0F;
         if(this.lineAlignment == HorizontalAlignment.CENTER) {
            var15 = (float)(var9.getWidth() - var14.getWidth()) / 2.0F;
         } else if(this.lineAlignment == HorizontalAlignment.RIGHT) {
            var15 = (float)(var9.getWidth() - var14.getWidth());
         }

         var13.draw(var1, var2 + var10[0] + var15, var3 + var10[1] + var12, TextAnchor.TOP_LEFT, var5, var6, var7);
      }

   }

   private float[] calculateOffsets(TextBlockAnchor var1, double var2, double var4) {
      float[] var6 = new float[2];
      float var7 = 0.0F;
      float var8 = 0.0F;
      if(var1 != TextBlockAnchor.TOP_CENTER && var1 != TextBlockAnchor.CENTER && var1 != TextBlockAnchor.BOTTOM_CENTER) {
         if(var1 == TextBlockAnchor.TOP_RIGHT || var1 == TextBlockAnchor.CENTER_RIGHT || var1 == TextBlockAnchor.BOTTOM_RIGHT) {
            var7 = (float)(-var2);
         }
      } else {
         var7 = (float)(-var2) / 2.0F;
      }

      if(var1 != TextBlockAnchor.TOP_LEFT && var1 != TextBlockAnchor.TOP_CENTER && var1 != TextBlockAnchor.TOP_RIGHT) {
         if(var1 != TextBlockAnchor.CENTER_LEFT && var1 != TextBlockAnchor.CENTER && var1 != TextBlockAnchor.CENTER_RIGHT) {
            if(var1 == TextBlockAnchor.BOTTOM_LEFT || var1 == TextBlockAnchor.BOTTOM_CENTER || var1 == TextBlockAnchor.BOTTOM_RIGHT) {
               var8 = (float)(-var4);
            }
         } else {
            var8 = (float)(-var4) / 2.0F;
         }
      } else {
         var8 = 0.0F;
      }

      var6[0] = var7;
      var6[1] = var8;
      return var6;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof TextBlock) {
         TextBlock var2 = (TextBlock)var1;
         return this.lines.equals(var2.lines);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.lines != null?this.lines.hashCode():0;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      logger = Log.createContext(class$org$jfree$text$TextBlock == null?(class$org$jfree$text$TextBlock = class$("org.jfree.text.TextBlock")):class$org$jfree$text$TextBlock);
   }
}
