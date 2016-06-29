package org.jfree.chart.title;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.title.Title;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.text.G2TextMeasurer;
import org.jfree.text.TextBlock;
import org.jfree.text.TextBlockAnchor;
import org.jfree.text.TextUtilities;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class TextTitle extends Title implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 8372008692127477443L;
   public static final Font DEFAULT_FONT = new Font("SansSerif", 1, 12);
   public static final Paint DEFAULT_TEXT_PAINT;
   private String text;
   private Font font;
   private HorizontalAlignment textAlignment;
   private transient Paint paint;
   private transient Paint backgroundPaint;
   private String toolTipText;
   private String urlText;
   private TextBlock content;
   private boolean expandToFitSpace;

   public TextTitle() {
      this("");
   }

   public TextTitle(String var1) {
      this(var1, DEFAULT_FONT, DEFAULT_TEXT_PAINT, Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
   }

   public TextTitle(String var1, Font var2) {
      this(var1, var2, DEFAULT_TEXT_PAINT, Title.DEFAULT_POSITION, Title.DEFAULT_HORIZONTAL_ALIGNMENT, Title.DEFAULT_VERTICAL_ALIGNMENT, Title.DEFAULT_PADDING);
   }

   public TextTitle(String var1, Font var2, Paint var3, RectangleEdge var4, HorizontalAlignment var5, VerticalAlignment var6, RectangleInsets var7) {
      super(var4, var5, var6, var7);
      this.expandToFitSpace = false;
      if(var1 == null) {
         throw new NullPointerException("Null \'text\' argument.");
      } else if(var2 == null) {
         throw new NullPointerException("Null \'font\' argument.");
      } else if(var3 == null) {
         throw new NullPointerException("Null \'paint\' argument.");
      } else {
         this.text = var1;
         this.font = var2;
         this.paint = var3;
         this.textAlignment = var5;
         this.backgroundPaint = null;
         this.content = null;
         this.toolTipText = null;
         this.urlText = null;
      }
   }

   public String getText() {
      return this.text;
   }

   public void setText(String var1) {
      if(var1 == null) {
         throw new NullPointerException("Null \'text\' argument.");
      } else {
         if(!this.text.equals(var1)) {
            this.text = var1;
            this.notifyListeners(new TitleChangeEvent(this));
         }

      }
   }

   public HorizontalAlignment getTextAlignment() {
      return this.textAlignment;
   }

   public void setTextAlignment(HorizontalAlignment var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'alignment\' argument.");
      } else {
         this.textAlignment = var1;
         this.notifyListeners(new TitleChangeEvent(this));
      }
   }

   public Font getFont() {
      return this.font;
   }

   public void setFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         if(!this.font.equals(var1)) {
            this.font = var1;
            this.notifyListeners(new TitleChangeEvent(this));
         }

      }
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void setPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         if(!this.paint.equals(var1)) {
            this.paint = var1;
            this.notifyListeners(new TitleChangeEvent(this));
         }

      }
   }

   public Paint getBackgroundPaint() {
      return this.backgroundPaint;
   }

   public void setBackgroundPaint(Paint var1) {
      this.backgroundPaint = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public String getToolTipText() {
      return this.toolTipText;
   }

   public void setToolTipText(String var1) {
      this.toolTipText = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public String getURLText() {
      return this.urlText;
   }

   public void setURLText(String var1) {
      this.urlText = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public boolean getExpandToFitSpace() {
      return this.expandToFitSpace;
   }

   public void setExpandToFitSpace(boolean var1) {
      this.expandToFitSpace = var1;
      this.notifyListeners(new TitleChangeEvent(this));
   }

   public Size2D arrange(Graphics2D var1, RectangleConstraint var2) {
      RectangleConstraint var3 = this.toContentConstraint(var2);
      LengthConstraintType var4 = var3.getWidthConstraintType();
      LengthConstraintType var5 = var3.getHeightConstraintType();
      Size2D var6 = null;
      if(var4 == LengthConstraintType.NONE) {
         if(var5 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
         }
      } else if(var4 == LengthConstraintType.RANGE) {
         if(var5 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            var6 = this.arrangeRR(var1, var3.getWidthRange(), var3.getHeightRange());
         } else if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
         }
      } else if(var4 == LengthConstraintType.FIXED) {
         if(var5 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
         }
      }

      return new Size2D(this.calculateTotalWidth(var6.getWidth()), this.calculateTotalHeight(var6.getHeight()));
   }

   protected Size2D arrangeRR(Graphics2D var1, Range var2, Range var3) {
      RectangleEdge var4 = this.getPosition();
      float var5;
      Size2D var6;
      if(var4 != RectangleEdge.TOP && var4 != RectangleEdge.BOTTOM) {
         if(var4 != RectangleEdge.LEFT && var4 != RectangleEdge.RIGHT) {
            throw new RuntimeException("Unrecognised exception.");
         } else {
            var5 = (float)var3.getUpperBound();
            var1.setFont(this.font);
            this.content = TextUtilities.createTextBlock(this.text, this.font, this.paint, var5, new G2TextMeasurer(var1));
            this.content.setLineAlignment(this.textAlignment);
            var6 = this.content.calculateDimensions(var1);
            return this.expandToFitSpace?new Size2D(var6.getHeight(), (double)var5):new Size2D(var6.height, var6.width);
         }
      } else {
         var5 = (float)var2.getUpperBound();
         var1.setFont(this.font);
         this.content = TextUtilities.createTextBlock(this.text, this.font, this.paint, var5, new G2TextMeasurer(var1));
         this.content.setLineAlignment(this.textAlignment);
         var6 = this.content.calculateDimensions(var1);
         return this.expandToFitSpace?new Size2D((double)var5, var6.getHeight()):var6;
      }
   }

   public void draw(Graphics2D var1, Rectangle2D var2) {
      this.draw(var1, var2, (Object)null);
   }

   public Object draw(Graphics2D var1, Rectangle2D var2, Object var3) {
      if(this.content == null) {
         return null;
      } else {
         var2 = this.trimMargin(var2);
         this.drawBorder(var1, var2);
         if(this.text.equals("")) {
            return null;
         } else {
            ChartEntity var4 = null;
            if(var3 instanceof EntityBlockParams) {
               EntityBlockParams var5 = (EntityBlockParams)var3;
               if(var5.getGenerateEntities()) {
                  var4 = new ChartEntity(var2, this.toolTipText, this.urlText);
               }
            }

            var2 = this.trimBorder(var2);
            if(this.backgroundPaint != null) {
               var1.setPaint(this.backgroundPaint);
               var1.fill(var2);
            }

            var2 = this.trimPadding(var2);
            RectangleEdge var8 = this.getPosition();
            if(var8 != RectangleEdge.TOP && var8 != RectangleEdge.BOTTOM) {
               if(var8 == RectangleEdge.LEFT || var8 == RectangleEdge.RIGHT) {
                  this.drawVertical(var1, var2);
               }
            } else {
               this.drawHorizontal(var1, var2);
            }

            BlockResult var6 = new BlockResult();
            if(var4 != null) {
               StandardEntityCollection var7 = new StandardEntityCollection();
               var7.add(var4);
               var6.setEntityCollection(var7);
            }

            return var6;
         }
      }
   }

   protected void drawHorizontal(Graphics2D var1, Rectangle2D var2) {
      Rectangle2D var3 = (Rectangle2D)var2.clone();
      var1.setFont(this.font);
      var1.setPaint(this.paint);
      TextBlockAnchor var4 = null;
      float var5 = 0.0F;
      HorizontalAlignment var6 = this.getHorizontalAlignment();
      if(var6 == HorizontalAlignment.LEFT) {
         var5 = (float)var3.getX();
         var4 = TextBlockAnchor.TOP_LEFT;
      } else if(var6 == HorizontalAlignment.RIGHT) {
         var5 = (float)var3.getMaxX();
         var4 = TextBlockAnchor.TOP_RIGHT;
      } else if(var6 == HorizontalAlignment.CENTER) {
         var5 = (float)var3.getCenterX();
         var4 = TextBlockAnchor.TOP_CENTER;
      }

      float var7 = 0.0F;
      RectangleEdge var8 = this.getPosition();
      if(var8 == RectangleEdge.TOP) {
         var7 = (float)var3.getY();
      } else if(var8 == RectangleEdge.BOTTOM) {
         var7 = (float)var3.getMaxY();
         if(var6 == HorizontalAlignment.LEFT) {
            var4 = TextBlockAnchor.BOTTOM_LEFT;
         } else if(var6 == HorizontalAlignment.CENTER) {
            var4 = TextBlockAnchor.BOTTOM_CENTER;
         } else if(var6 == HorizontalAlignment.RIGHT) {
            var4 = TextBlockAnchor.BOTTOM_RIGHT;
         }
      }

      this.content.draw(var1, var5, var7, var4);
   }

   protected void drawVertical(Graphics2D var1, Rectangle2D var2) {
      Rectangle2D var3 = (Rectangle2D)var2.clone();
      var1.setFont(this.font);
      var1.setPaint(this.paint);
      TextBlockAnchor var4 = null;
      float var5 = 0.0F;
      VerticalAlignment var6 = this.getVerticalAlignment();
      if(var6 == VerticalAlignment.TOP) {
         var5 = (float)var3.getY();
         var4 = TextBlockAnchor.TOP_RIGHT;
      } else if(var6 == VerticalAlignment.BOTTOM) {
         var5 = (float)var3.getMaxY();
         var4 = TextBlockAnchor.TOP_LEFT;
      } else if(var6 == VerticalAlignment.CENTER) {
         var5 = (float)var3.getCenterY();
         var4 = TextBlockAnchor.TOP_CENTER;
      }

      float var7 = 0.0F;
      RectangleEdge var8 = this.getPosition();
      if(var8 == RectangleEdge.LEFT) {
         var7 = (float)var3.getX();
      } else if(var8 == RectangleEdge.RIGHT) {
         var7 = (float)var3.getMaxX();
         if(var6 == VerticalAlignment.TOP) {
            var4 = TextBlockAnchor.BOTTOM_RIGHT;
         } else if(var6 == VerticalAlignment.CENTER) {
            var4 = TextBlockAnchor.BOTTOM_CENTER;
         } else if(var6 == VerticalAlignment.BOTTOM) {
            var4 = TextBlockAnchor.BOTTOM_LEFT;
         }
      }

      this.content.draw(var1, var7, var5, var4, var7, var5, -1.5707963267948966D);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TextTitle)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         TextTitle var2 = (TextTitle)var1;
         return !ObjectUtilities.equal(this.text, var2.text)?false:(!ObjectUtilities.equal(this.font, var2.font)?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:(this.textAlignment != var2.textAlignment?false:PaintUtilities.equal(this.backgroundPaint, var2.backgroundPaint))));
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 29 * var1 + (this.text != null?this.text.hashCode():0);
      var1 = 29 * var1 + (this.font != null?this.font.hashCode():0);
      var1 = 29 * var1 + (this.paint != null?this.paint.hashCode():0);
      var1 = 29 * var1 + (this.backgroundPaint != null?this.backgroundPaint.hashCode():0);
      return var1;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
      SerialUtilities.writePaint(this.backgroundPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
      this.backgroundPaint = SerialUtilities.readPaint(var1);
   }

   static {
      DEFAULT_TEXT_PAINT = Color.black;
   }
}
