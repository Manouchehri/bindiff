package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CHighlighting;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent$ObjectWrapper;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ZyLineContent {
   private static final FontRenderContext m_fontContext = new FontRenderContext((AffineTransform)null, true, true);
   private static final Composite DEFAULT_COMPOSITE = AlphaComposite.getInstance(3, 0.3F);
   private static final Composite NORMAL_COMPOSITE = AlphaComposite.getInstance(3, 1.0F);
   private static final Stroke DEFAULT_BORDER_STROKE = new BasicStroke(1.2F);
   private static final Stroke NORMAL_STROKE = new BasicStroke(1.0F);
   private String m_text;
   private AttributedString m_atext;
   private double m_charWidth;
   private double m_charHeight;
   private TextLayout m_textLayout;
   private final ArrayList m_highlighting;
   private final List m_lineObjects;
   private final IZyEditableObject m_model;
   private Color m_backgroundColor;
   private final List m_objects;

   public ZyLineContent(String var1, Font var2, IZyEditableObject var3) {
      this(var1, var2, new ArrayList(), var3);
   }

   public ZyLineContent(String var1, Font var2, List var3, IZyEditableObject var4) {
      this.m_highlighting = new ArrayList();
      this.m_lineObjects = new ArrayList();
      this.m_backgroundColor = null;
      this.m_objects = new ArrayList();
      Preconditions.checkNotNull(var1, "Error: Text argument can\'t be null");
      Preconditions.checkNotNull(var3, "Error: Text color style run can\'t be null.");
      this.m_model = var4;
      this.regenerateLine(var1, var2, var3);
   }

   public ZyLineContent(String var1, IZyEditableObject var2) {
      this(var1, (Font)null, var2);
   }

   private int calculateRealLength(int var1, int var2) {
      return var2 != -1?var2:this.m_text.length() - var1;
   }

   private void drawHighlighting(Graphics2D var1, double var2, double var4, double var6, double var8, Color var10) {
      var1.setColor(var10);
      int var11 = (int)Math.round(var2);
      int var12 = (int)Math.round(var4);
      int var13 = (int)Math.round(var8);
      int var14 = (int)Math.round(var6);
      var1.setComposite(DEFAULT_COMPOSITE);
      var1.fillRoundRect(var11, var12, var14, var13, 10, 10);
      var1.setColor(var10.darker());
      var1.setStroke(DEFAULT_BORDER_STROKE);
      var1.drawRoundRect(var11, var12, var14, var13, 10, 10);
      var1.setComposite(NORMAL_COMPOSITE);
      var1.setStroke(NORMAL_STROKE);
   }

   private void regenerateLine(String var1, Font var2, List var3) {
      this.m_text = (String)Preconditions.checkNotNull(var1, "Error: text argument can not be null");
      Preconditions.checkNotNull(var3, "Error: textColorStyleRun argument can not be null");
      this.m_atext = new AttributedString(var1);
      if(!this.isEmpty()) {
         if(var2 != null) {
            this.m_atext.addAttribute(TextAttribute.FONT, var2);
         }

         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            CStyleRunData var5 = (CStyleRunData)var4.next();
            int var6 = var5.getStart();
            int var7 = this.calculateRealLength(var6, var5.getLength());
            this.validatePartialLineArguments(var6, var7);
            this.m_atext.addAttribute(TextAttribute.FOREGROUND, var5.getColor(), var6, var6 + var7);
            if(var5.getLineObject() != null) {
               this.m_lineObjects.add(var5.getLineObject());
            }

            if(var5.getObject() != null) {
               this.setObject(var6, var7, var5.getObject());
            }
         }

         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
      }

      if(var2 != null) {
         this.updateCharBounds(var2);
      }

   }

   private void updateCharBounds(Font var1) {
      this.m_charWidth = var1.getStringBounds(this.m_text, m_fontContext).getWidth() / (double)this.getTextLayout().getCharacterCount();
      this.m_charHeight = (double)var1.getLineMetrics(this.m_text, m_fontContext).getHeight();
   }

   private void validatePartialLineArguments(int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0 && var1 < this.m_text.length(), "Error: Position argument is out of bounds (Position: %d, Length: %d/%d)", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(this.m_text.length())});
      Preconditions.checkArgument(var2 > 0 || var1 + var2 <= this.m_text.length(), "Error: Length argument is out of bounds (Position: %d, Length: %d)", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)});
   }

   public synchronized boolean clearHighlighting(int var1) {
      if(this.m_highlighting.isEmpty()) {
         return false;
      } else {
         Iterator var2 = (new ArrayList(this.m_highlighting)).iterator();

         CHighlighting var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = (CHighlighting)var2.next();
         } while(var3.getLevel() != var1);

         this.m_highlighting.remove(var3);
         return true;
      }
   }

   public synchronized void draw(Graphics2D var1, float var2, float var3) {
      if(!this.isEmpty()) {
         this.m_textLayout.draw(var1, var2, var3);
         Iterator var4 = (new ArrayList(this.m_highlighting)).iterator();

         while(var4.hasNext()) {
            CHighlighting var5 = (CHighlighting)var4.next();
            double var6 = (double)var2 + var5.getStart() - 2.0D;
            double var8 = (double)var3 - this.m_charHeight + 4.0D;
            double var10 = var5.getEnd() + 4.0D;
            double var12 = this.m_charHeight - 1.0D;
            this.drawHighlighting(var1, var6, var8, var10, var12, var5.getColor());
         }
      }

   }

   public Color getBackgroundColor() {
      return this.m_backgroundColor;
   }

   public List getBackgroundStyleRunData(int var1, int var2) {
      Preconditions.checkState(var1 >= 0 && var1 <= var2 && var1 < this.m_text.length(), "Illegal start value.");
      Preconditions.checkState(var2 >= 0 && var2 >= var1 && var2 < this.m_text.length(), "Illegal end value.");
      ArrayList var3 = new ArrayList();
      AttributedCharacterIterator var4 = this.m_atext.getIterator();
      var4.setIndex(var1);
      Color var5 = null;
      int var6 = var1;

      for(int var7 = var1; var7 <= var2; ++var7) {
         Color var8 = (Color)var4.getAttribute(TextAttribute.BACKGROUND);
         if(var8 != null && !var8.equals(var5) || var5 != null && !var5.equals(var8)) {
            if(var5 != null) {
               CStyleRunData var9 = new CStyleRunData(var6, var7 - var6 + 1, var5);
               var3.add(var9);
            }

            var5 = var8;
            var6 = var7;
         }

         var4.next();
      }

      CStyleRunData var10 = new CStyleRunData(var6, var2 - var6 + 1, var5);
      var3.add(var10);
      return var3;
   }

   public Rectangle2D getBounds() {
      if(this.isEmpty()) {
         AttributedString var1 = new AttributedString(" ");
         TextLayout var2 = new TextLayout(var1.getIterator(), m_fontContext);
         return var2.getBounds();
      } else {
         return new Double(0.0D, 0.0D, this.m_charWidth * (double)this.m_text.length(), this.m_charHeight);
      }
   }

   public double getCharWidth() {
      return this.m_charWidth;
   }

   public IZyEditableObject getLineFragmentObjectAt(int var1) {
      Iterator var2 = this.m_lineObjects.iterator();

      IZyEditableObject var3;
      do {
         if(!var2.hasNext()) {
            var2 = this.m_lineObjects.iterator();

            do {
               if(!var2.hasNext()) {
                  return null;
               }

               var3 = (IZyEditableObject)var2.next();
            } while(var1 < var3.getStart() || var1 - 1 >= var3.getStart() + var3.getLength());

            return var3;
         }

         var3 = (IZyEditableObject)var2.next();
      } while(var1 < var3.getStart() || var1 >= var3.getStart() + var3.getLength());

      return var3;
   }

   public List getLineFragmentObjectList() {
      return this.m_lineObjects;
   }

   public IZyEditableObject getLineObject() {
      return this.m_model;
   }

   public Object getObject(int var1) {
      ZyLineContent$ObjectWrapper var2 = this.getObjectWrapper(var1);
      return var2 == null?null:var2.getObject();
   }

   public ZyLineContent$ObjectWrapper getObjectWrapper(int var1) {
      Iterator var2 = this.m_objects.iterator();

      ZyLineContent$ObjectWrapper var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (ZyLineContent$ObjectWrapper)var2.next();
      } while(var1 < var3.getStart() || var1 >= var3.getStart() + var3.getLength());

      return var3;
   }

   public String getText() {
      return this.m_text;
   }

   public String getText(IZyEditableObject var1) {
      Preconditions.checkNotNull(var1, "Error: editabeObject argument can not be null");
      int var2 = var1.getStart();
      int var3 = var1.getEnd();
      if(var2 >= this.m_text.length()) {
         return "";
      } else {
         if(var3 >= this.m_text.length()) {
            var3 = this.m_text.length();
         }

         return this.m_text.substring(var2, var3);
      }
   }

   public TextLayout getTextLayout() {
      if(this.isEmpty()) {
         AttributedString var1 = new AttributedString("+");
         return new TextLayout(var1.getIterator(), m_fontContext);
      } else {
         return new TextLayout(this.m_atext.getIterator(), m_fontContext);
      }
   }

   public boolean hasHighlighting(int var1) {
      if(this.isEmpty()) {
         return false;
      } else if(this.m_highlighting.isEmpty()) {
         return false;
      } else {
         Iterator var2 = (new ArrayList(this.m_highlighting)).iterator();

         CHighlighting var3;
         do {
            if(!var2.hasNext()) {
               return false;
            }

            var3 = (CHighlighting)var2.next();
         } while(var3.getLevel() != var1);

         return true;
      }
   }

   public boolean isEditable(int var1) {
      return this.getLineFragmentObjectAt(var1) != null;
   }

   public boolean isEmpty() {
      return "".equals(this.m_text) || this.m_text == null;
   }

   public void setBackgroundColor(Color var1) {
      this.m_backgroundColor = (Color)Preconditions.checkNotNull(var1, "Error: Color argument can\'t be null");
      if(!this.isEmpty()) {
         this.m_atext.addAttribute(TextAttribute.BACKGROUND, var1);
         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
      }

   }

   public void setBackgroundColor(int var1, int var2, Color var3) {
      if(!this.isEmpty()) {
         int var4 = this.calculateRealLength(var1, var2);
         this.validatePartialLineArguments(var1, var4);
         this.m_atext.addAttribute(TextAttribute.BACKGROUND, var3, var1, var1 + var4);
         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
      }

   }

   public void setFont(Font var1) {
      Preconditions.checkNotNull(var1, "Error: Font argument can\'t be null");
      if(!this.isEmpty()) {
         this.m_atext.addAttribute(TextAttribute.FONT, var1);
         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
         this.updateCharBounds(var1);
      }

   }

   public void setFont(int var1, int var2, Font var3) {
      Preconditions.checkNotNull(var3, "Error: Font argument can\'t be null");
      if(!this.isEmpty()) {
         int var4 = this.calculateRealLength(var1, var2);
         this.validatePartialLineArguments(var1, var4);
         Preconditions.checkNotNull(var3, "Error: Font argument can\'t be null");
         this.m_atext.addAttribute(TextAttribute.FONT, var3, var1, var1 + var4);
         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
         this.updateCharBounds(var3);
      }

   }

   public synchronized boolean setHighlighting(int var1, Color var2) {
      Preconditions.checkNotNull(var2, "Error: Color argument can\'t be null");
      if(this.isEmpty()) {
         return false;
      } else {
         Iterator var3 = (new ArrayList(this.m_highlighting)).iterator();

         while(var3.hasNext()) {
            CHighlighting var4 = (CHighlighting)var3.next();
            if(var4.getLevel() == var1) {
               if(var4.getColor().equals(var2)) {
                  return false;
               }

               this.m_highlighting.remove(var4);
               break;
            }
         }

         this.m_highlighting.add(new CHighlighting(var1, 0.0D, (double)this.m_text.length() * this.m_charWidth, var2));
         Collections.sort(this.m_highlighting);
         return true;
      }
   }

   public synchronized void setHighlighting(int var1, int var2, int var3, Color var4) {
      Preconditions.checkNotNull(var4, "Error: color argument can not be null");
      if(!this.isEmpty()) {
         int var5 = this.calculateRealLength(var1, var2);
         this.validatePartialLineArguments(var1, var5);
         if(this.hasHighlighting(var3)) {
            this.clearHighlighting(var3);
         }

         this.m_highlighting.add(new CHighlighting(var3, (double)var1 * this.m_charWidth, (double)var5 * this.m_charWidth, var4));
         Collections.sort(this.m_highlighting);
      }

   }

   public void setObject(int var1, int var2, Object var3) {
      Preconditions.checkNotNull(var3, "Error: object argument can not be null");
      this.m_objects.add(new ZyLineContent$ObjectWrapper(var1, var2, var3));
   }

   public void setTextColor(Color var1) {
      Preconditions.checkNotNull(var1, "Error: Color argument can\'t be null");
      if(!this.isEmpty()) {
         this.m_atext.addAttribute(TextAttribute.FOREGROUND, var1);
         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
      }

   }

   public void setTextColor(int var1, int var2, Color var3) {
      if(!this.isEmpty()) {
         int var4 = this.calculateRealLength(var1, var2);
         this.validatePartialLineArguments(var1, var4);
         this.m_atext.addAttribute(TextAttribute.FOREGROUND, var3, var1, var1 + var4);
         this.m_textLayout = new TextLayout(this.m_atext.getIterator(), m_fontContext);
      }

   }

   public String toString() {
      return this.getText();
   }
}
