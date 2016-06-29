package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZyLabelContent implements Iterable {
   private static final int FONTSIZE = 11;
   private static final int LINEHEIGHT = 15;
   private int m_leftPadding = 10;
   private int m_rightPadding = 10;
   private int m_topPadding = 10;
   private int m_bottomPadding = 10;
   private final IZyEditableObject m_model;
   private IZyLineEditor m_lineEditor = null;
   private final ZyCaret m_caret = new ZyCaret(this);
   private boolean m_selectable = true;
   private boolean m_editable = false;
   private boolean m_showCaret = false;
   private Color m_selectionColor;
   private final ArrayList m_content;
   private boolean m_sloppy;

   public ZyLabelContent(IZyEditableObject var1) {
      this.m_selectionColor = Color.WHITE;
      this.m_content = new ArrayList();
      this.m_sloppy = false;
      this.m_model = var1;
   }

   public ZyLabelContent(IZyEditableObject var1, boolean var2, boolean var3) {
      this.m_selectionColor = Color.WHITE;
      this.m_content = new ArrayList();
      this.m_sloppy = false;
      this.m_model = (IZyEditableObject)Preconditions.checkNotNull(var1, "Error: Node model can\'t be null.");
      this.m_selectable = var2;
      this.m_editable = var3;
   }

   private AffineTransform calcSelectionTransformationMatrix(AffineTransform var1, double var2, double var4, int var6) {
      double var7 = var1.getScaleX();
      double var9 = var1.getScaleY();
      double var11 = var1.getTranslateX() + var2 * var7;
      double var13 = var1.getTranslateY() + (var4 + (double)var6 * this.getLineHeight()) * var9;
      return new AffineTransform(var7, 0.0D, 0.0D, var9, var11, var13);
   }

   public void addLineContent(ZyLineContent var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Line content can\'t be null");
      this.m_content.add(var1);
   }

   public void draw(Graphics2D var1, double var2, double var4) {
      if(!this.m_sloppy) {
         if(this.m_selectable && this.m_showCaret) {
            AffineTransform var20 = var1.getTransform();
            Color var21 = var1.getColor();
            float var22 = (float)var2 + (float)this.getPaddingLeft();
            float var23 = (float)var4 + (float)this.getPaddingTop() + (float)this.getFontSize();
            double var10 = this.getLineHeight();
            var1.setColor(Color.BLACK);

            int var12;
            for(var12 = 0; var12 < this.getLineCount(); ++var12) {
               TextLayout var13 = this.getLineContent(var12).getTextLayout();
               if(!this.getLineContent(var12).isEmpty()) {
                  var13.draw(var1, var22, (float)((double)var23 + (double)var12 * var10));
               }

               Shape[] var14;
               if(var12 == this.m_caret.getYmousePressed()) {
                  var1.setTransform(this.calcSelectionTransformationMatrix(var20, (double)var22, (double)var23, var12));
                  if(this.getLineContent(var12).isEmpty()) {
                     this.m_caret.setCaretStartPos(0);
                  } else if(this.m_caret.getCaretStartPos() >= var13.getCharacterCount()) {
                     this.m_caret.setCaretStartPos(var13.getCharacterCount());
                  }

                  var14 = var13.getCaretShapes(this.m_caret.getCaretStartPos());
                  var1.setColor(this.m_selectionColor.darker());
                  var1.draw(var14[0]);
                  var1.setTransform(var20);
               }

               if(var12 == this.m_caret.getYmouseReleased()) {
                  var1.setTransform(this.calcSelectionTransformationMatrix(var20, (double)var22, (double)var23, var12));
                  if(this.getLineContent(var12).isEmpty()) {
                     this.m_caret.setCaretEndPos(0);
                  } else if(this.m_caret.getCaretEndPos() >= var13.getCharacterCount()) {
                     this.m_caret.setCaretEndPos(var13.getCharacterCount());
                  }

                  var14 = var13.getCaretShapes(this.m_caret.getCaretEndPos());
                  var1.setColor(this.m_selectionColor.darker().darker());
                  var1.draw(var14[0]);
                  var1.setTransform(var20);
               }
            }

            if(this.m_caret.getXmousePressed() != this.m_caret.getXmouseReleased()) {
               var12 = this.m_caret.getYmousePressed();
               int var24 = this.m_caret.getYmouseReleased();
               if(var12 > var24) {
                  var12 = this.m_caret.getYmouseReleased();
                  var24 = this.m_caret.getYmousePressed();
               }

               int var25 = this.m_caret.getXmousePressed();
               int var15 = this.m_caret.getXmouseReleased();
               if(var25 > var15) {
                  var25 = this.m_caret.getXmouseReleased();
                  var15 = this.m_caret.getXmousePressed();
               }

               var1.setColor(this.m_selectionColor);
               var1.setComposite(AlphaComposite.getInstance(3, 0.5F));

               for(int var16 = var12; var16 <= var24; ++var16) {
                  var1.setTransform(this.calcSelectionTransformationMatrix(var20, (double)var22, (double)var23, var16));
                  TextLayout var17 = this.getLineContent(var16).getTextLayout();
                  int var18 = var15;
                  if(var25 <= var17.getCharacterCount()) {
                     if(this.getLineContent(var16).isEmpty()) {
                        var18 = var25;
                     } else if(var15 > var17.getCharacterCount()) {
                        var18 = var17.getCharacterCount();
                     }

                     Shape var19 = var17.getLogicalHighlightShape(var25, var18);
                     var1.fill(var19);
                  }
               }

               var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
               var1.setTransform(var20);
            }

            var1.setColor(var21);
            var1.setTransform(var20);
         } else {
            float var6 = (float)var2 + (float)this.m_leftPadding;
            float var7 = (float)var4 + (float)this.m_topPadding + 11.0F;

            for(Iterator var8 = this.getContent().iterator(); var8.hasNext(); var7 += 15.0F) {
               ZyLineContent var9 = (ZyLineContent)var8.next();
               var9.draw(var1, var6, var7);
            }

         }
      }
   }

   public Rectangle2D getBounds() {
      double var1 = 0.0D;
      double var3 = (double)(this.m_topPadding + this.m_bottomPadding);

      for(Iterator var5 = this.getContent().iterator(); var5.hasNext(); var3 += 15.0D) {
         ZyLineContent var6 = (ZyLineContent)var5.next();
         if(var6.getBounds().getWidth() > var1) {
            var1 = var6.getBounds().getWidth();
         }
      }

      return new Double(0.0D, 0.0D, var1 + (double)this.m_rightPadding + (double)this.m_leftPadding, var3);
   }

   public ZyCaret getCaret() {
      return this.m_caret;
   }

   public List getContent() {
      return new ArrayList(this.m_content);
   }

   public int getFirstLineIndexOfModelAt(int var1) {
      ZyLineContent var2 = this.getLineContent(var1);
      if(var2 != null) {
         IZyEditableObject var3 = var2.getLineObject();
         int var4 = var1;

         while(true) {
            --var4;
            if(var4 < 0) {
               break;
            }

            if(((ZyLineContent)this.m_content.get(var4)).getLineObject() != var3) {
               return var4 + 1;
            }
         }
      }

      return var1;
   }

   public int getFontSize() {
      return 11;
   }

   public int getLastLineIndexOfModelAt(int var1) {
      ZyLineContent var2 = this.getLineContent(var1);
      if(var2 != null) {
         IZyEditableObject var3 = var2.getLineObject();
         int var4 = var1;

         do {
            ++var4;
            if(var4 >= this.m_content.size()) {
               return this.m_content.size() - 1;
            }
         } while(((ZyLineContent)this.m_content.get(var4)).getLineObject() == var3);

         return var4 - 1;
      } else {
         return var1;
      }
   }

   public ZyLineContent getLineContent(int var1) {
      return (ZyLineContent)this.m_content.get(var1);
   }

   public int getLineCount() {
      return this.m_content.size();
   }

   public IZyLineEditor getLineEditor() {
      return this.m_lineEditor;
   }

   public double getLineHeight() {
      return 15.0D;
   }

   public int getLineIndex(ZyLineContent var1) {
      return this.m_content.indexOf(var1);
   }

   public IZyEditableObject getModel() {
      return this.m_model;
   }

   public int getNonPureCommentLineIndexOfModelAt(int var1) {
      ZyLineContent var2 = this.getLineContent(var1);
      if(var2 != null) {
         int var3 = this.getFirstLineIndexOfModelAt(var1);
         int var4 = this.getLastLineIndexOfModelAt(var1);

         for(int var5 = var3; var5 <= var4; ++var5) {
            ZyLineContent var6 = this.getLineContent(var5);
            List var7 = var6.getLineFragmentObjectList();
            if(var6.getLineObject() == null || !var6.getLineObject().isPlaceholder()) {
               if(var7.size() == 0) {
                  return var5;
               }

               if(((IZyEditableObject)var7.get(0)).isCommentDelimiter() && ((IZyEditableObject)var7.get(0)).getStart() > 0) {
                  return var5;
               }
            }
         }
      }

      return -1;
   }

   public int getPaddingLeft() {
      return this.m_leftPadding;
   }

   public int getPaddingTop() {
      return this.m_topPadding;
   }

   public int getRightPadding() {
      return this.m_rightPadding;
   }

   public String getSelectedText() {
      if(!this.m_caret.isSelection()) {
         return "";
      } else {
         int var1 = this.m_caret.getYmousePressed();
         int var2 = this.m_caret.getYmouseReleased();
         if(var1 > var2) {
            var1 = this.m_caret.getYmouseReleased();
            var2 = this.m_caret.getYmousePressed();
         }

         int var3 = this.m_caret.getXmousePressed();
         int var4 = this.m_caret.getXmouseReleased();
         if(var3 > this.m_caret.getXmouseReleased()) {
            var3 = this.m_caret.getXmouseReleased();
            var4 = this.m_caret.getXmousePressed();
         }

         StringBuilder var5 = new StringBuilder();

         for(int var6 = var1; var6 <= var2; ++var6) {
            String var7 = this.getLineContent(var6).getText();
            if(var7 != null && var7.length() >= 1 && var7.length() >= var3) {
               if(var7.length() < var4) {
                  var5.append(var7.substring(var3));
                  if(!"\n".equals(var7) && var6 < var2) {
                     var5.append("\n");
                  }
               } else {
                  var5.append(var7.substring(var3, var4));
                  if(!"\n".equals(var7) && var6 < var2) {
                     var5.append("\n");
                  }
               }
            } else {
               var5.append("\n");
            }
         }

         return var5.toString();
      }
   }

   public void insertLine(ZyLineContent var1, int var2) {
      ArrayList var3 = new ArrayList();
      if(var2 >= this.m_content.size()) {
         this.m_content.add(var1);
      } else {
         int var4 = 0;

         ZyLineContent var6;
         for(Iterator var5 = this.getContent().iterator(); var5.hasNext(); var3.add(var6)) {
            var6 = (ZyLineContent)var5.next();
            if(var4++ == var2) {
               var3.add(var1);
            }
         }

         this.m_content.clear();
         this.m_content.addAll(var3);
      }

   }

   public boolean isEditable() {
      return this.m_editable;
   }

   public boolean isSelectable() {
      return this.m_selectable;
   }

   public Iterator iterator() {
      return this.m_content.iterator();
   }

   public void removeLine(int var1) {
      this.m_content.remove(var1);
   }

   public void selectAll(IZyNodeRealizer var1) {
      this.m_caret.selectAll();
      var1.repaint();
   }

   public void setEditable(boolean var1) {
      if(this.m_model != null && this.m_lineEditor != null) {
         this.m_editable = var1;
         if(this.m_editable) {
            this.m_selectable = true;
         }

      }
   }

   public void setLineEditor(IZyLineEditor var1) {
      this.m_lineEditor = var1;
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
      this.m_leftPadding = var2;
      this.m_rightPadding = var4;
      this.m_topPadding = var1;
      this.m_bottomPadding = var3;
   }

   public void setPaddingLeft(int var1) {
      this.m_leftPadding = var1;
   }

   public void setRightPadding(int var1) {
      this.m_rightPadding = var1;
   }

   public void setSelectable(boolean var1) {
      if(this.m_model != null) {
         this.m_selectable = var1;
      }
   }

   public void setSelectionColor(Color var1) {
      this.m_selectionColor = var1;
   }

   public void setSloppy(boolean var1) {
      this.m_sloppy = var1;
   }

   public void showCaret(boolean var1) {
      this.m_showCaret = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.m_content.iterator();

      while(var2.hasNext()) {
         ZyLineContent var3 = (ZyLineContent)var2.next();
         var1.append(var3.toString());
         var1.append('\n');
      }

      return var1.toString();
   }

   public void updateContentSelectionColor(Color var1, boolean var2) {
      Color var3 = var1.darker();
      if(var2) {
         this.setSelectionColor(var3.darker());
      } else {
         this.setSelectionColor(var3);
      }

   }
}
