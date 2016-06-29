package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JStackView.AddressMode;
import com.google.security.zynamics.zylib.gui.JStackView.IStackModel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$1;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$InternalListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$WaitingForDataAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.Timer;

public final class JStackPanel extends JPanel {
   private static final long serialVersionUID = -7850318708757157383L;
   private static final int PADDING_OFFSETVIEW = 20;
   private static final int PADDING_LEFT = 10;
   private static final int SIZEOF_DWORD = 4;
   private static final int SIZEOF_QWORD = 8;
   private final IStackModel m_model;
   private final Font m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
   private int m_rowHeight;
   private int m_charHeight;
   private int m_charWidth;
   private int m_offsetViewWidth;
   private boolean m_firstDraw = true;
   private static final int m_hexElementWidth = 10;
   private final JStackPanel$InternalListener m_listener = new JStackPanel$InternalListener(this, (JStackPanel$1)null);
   private int m_firstRow = 0;
   private static final int m_paddingTop = 16;
   private final Color m_fontColorOffsets;
   private final Color m_fontColorValues;
   private final Color m_disabledColor;
   private final Color m_bgColorOffset;
   private Timer m_updateTimer;
   private JHexView$DefinitionStatus m_status;
   private final AddressMode m_addressMode;
   private int m_firstColumn;

   public JStackPanel(IStackModel var1) {
      super(new BorderLayout());
      this.m_fontColorOffsets = Color.WHITE;
      this.m_fontColorValues = Color.BLACK;
      this.m_disabledColor = Color.GRAY;
      this.m_bgColorOffset = Color.GRAY;
      this.m_status = JHexView$DefinitionStatus.UNDEFINED;
      this.m_addressMode = AddressMode.BIT32;
      this.m_firstColumn = 0;
      Preconditions.checkNotNull(var1, "Error: Model argument can not be null");
      this.m_model = var1;
      this.m_model.addListener(this.m_listener);
      this.setFocusable(true);
      this.setFont(this.m_font);
      this.setPreferredSize(new Dimension(400, 400));
   }

   private static int getCharacterWidth(Graphics var0) {
      return (int)var0.getFontMetrics().getStringBounds("0", var0).getWidth();
   }

   private static int getCharHeight(Graphics var0) {
      return var0.getFontMetrics().getAscent();
   }

   private static int getRowHeight(Graphics var0) {
      return var0.getFontMetrics().getHeight();
   }

   private void calculateSizes(Graphics var1) {
      this.m_rowHeight = getRowHeight(var1);
      this.m_charHeight = getCharHeight(var1);
      this.m_charWidth = getCharacterWidth(var1);
   }

   private void drawBackground(Graphics var1) {
      var1.setColor(this.m_bgColorOffset);
      var1.fillRect(-this.m_firstColumn * this.m_charWidth, 0, this.m_offsetViewWidth, this.getHeight());
   }

   private void drawElements(Graphics var1) {
      if(this.isEnabled()) {
         var1.setColor(this.m_fontColorValues);
      } else {
         var1.setColor(this.m_disabledColor != this.m_bgColorOffset?this.m_disabledColor:Color.WHITE);
      }

      int var2 = 10 + this.m_offsetViewWidth - this.m_charWidth * this.m_firstColumn;
      int var3 = this.getNumberOfVisibleRows();
      if(this.m_firstRow + var3 >= this.m_model.getNumberOfEntries()) {
         var3 = this.m_model.getNumberOfEntries() - this.m_firstRow;
         if(var3 < 0) {
            return;
         }
      }

      if(this.m_model.getStartAddress() != -1L) {
         long var4 = (long)this.getElementSize();
         if(this.m_status == JHexView$DefinitionStatus.DEFINED) {
            long var6 = this.m_model.getStartAddress() + (long)this.m_firstRow * var4;
            long var8 = (long)var3 * var4;
            if(!this.m_model.hasData(var6, var8)) {
               this.setDefinitionStatus(JHexView$DefinitionStatus.UNDEFINED);
               this.setEnabled(false);
               if(this.m_updateTimer != null) {
                  this.m_updateTimer.setRepeats(false);
                  this.m_updateTimer.stop();
               }

               this.m_updateTimer = new Timer(1000, new JStackPanel$WaitingForDataAction(this, var6, var8, (JStackPanel$1)null));
               this.m_updateTimer.setRepeats(true);
               this.m_updateTimer.start();
               return;
            }

            for(int var10 = 0; var10 < var3; ++var10) {
               long var11 = var6 + (long)var10 * var4;
               var1.drawString(this.m_model.getElement(var11), var2, 16 + var10 * this.m_rowHeight);
            }
         } else {
            for(int var13 = 0; var13 < var3; ++var13) {
               var1.drawString(Strings.repeat("?", 2 * this.getElementSize()), var2, 16 + var13 * this.m_rowHeight);
            }
         }

      }
   }

   private void drawOffsets(Graphics var1) {
      int var2 = this.getNumberOfVisibleRows();
      String var3 = this.m_addressMode == AddressMode.BIT32?"%08X":"%016X";
      long var4 = (long)this.getElementSize();
      long var6 = this.m_model.getStartAddress() == -1L?0L:this.m_model.getStartAddress();

      for(int var8 = 0; var8 < var2; ++var8) {
         int var9 = this.m_firstRow + var8;
         long var10 = var6 + (long)var9 * var4;
         String var12 = String.format(var3, new Object[]{Long.valueOf(var10)});
         if(var10 == this.m_model.getStackPointer()) {
            this.highlightStackPointer(var1, var8);
         }

         if(this.isEnabled()) {
            var1.setColor(this.m_fontColorOffsets);
         } else {
            var1.setColor(this.m_disabledColor != this.m_bgColorOffset?this.m_disabledColor:Color.WHITE);
         }

         var1.drawString(var12, 10 - this.m_charWidth * this.m_firstColumn, 16 + var8 * this.m_rowHeight);
      }

   }

   private int getElementSize() {
      return this.m_addressMode == AddressMode.BIT32?4:8;
   }

   private void highlightStackPointer(Graphics var1, int var2) {
      var1.setColor(Color.RED);
      double var3 = var1.getFontMetrics().getStringBounds(Strings.repeat("0", 2 * this.getElementSize()), var1).getWidth();
      var1.fillRect(8 - this.m_charWidth * this.m_firstColumn, 16 + var2 * this.m_rowHeight - this.m_charHeight, (int)var3 + 4, this.m_charHeight + 2);
   }

   private void updateOffsetViewWidth() {
      int var1 = this.m_addressMode == AddressMode.BIT32?8:16;
      this.m_offsetViewWidth = 20 + this.m_charWidth * var1;
   }

   private void updatePreferredSize() {
      int var1 = this.m_offsetViewWidth + 10 + 18 * this.m_charWidth;
      this.setPreferredSize(new Dimension(var1, this.getHeight()));
      this.revalidate();
   }

   protected int getNumberOfVisibleRows() {
      if(this.m_rowHeight == 0) {
         return 0;
      } else {
         int var1 = this.getHeight() - 16;
         return var1 / this.m_rowHeight + (var1 % this.m_rowHeight == 0?0:1);
      }
   }

   protected void setFirstRow(int var1) {
      this.m_firstRow = var1;
      this.repaint();
   }

   public int getCharWidth() {
      return this.m_charWidth;
   }

   public int getOffsetViewWidth() {
      return this.m_offsetViewWidth;
   }

   public String getValueAt(Point var1) {
      int var2 = (var1.y - 16 + this.m_rowHeight) / this.m_rowHeight;
      long var3 = (long)this.getElementSize();
      long var5 = this.m_model.getStartAddress() + (long)this.m_firstRow * var3;
      long var7 = var5 + (long)var2 * var3;
      return this.m_model.hasData(var7, var3)?this.m_model.getElement(var7):null;
   }

   public void gotoOffset(long var1) {
   }

   public void paint(Graphics var1) {
      super.paint(var1);
      this.calculateSizes(var1);
      this.updateOffsetViewWidth();
      if(this.m_firstDraw) {
         this.m_firstDraw = false;
         this.updatePreferredSize();
      }

      this.drawBackground(var1);
      this.drawOffsets(var1);
      this.drawElements(var1);
   }

   public void setDefinitionStatus(JHexView$DefinitionStatus var1) {
      Preconditions.checkNotNull(var1, "Error: Status argument can not be null");
      this.m_status = var1;
      this.repaint();
   }

   public void setFirstColumn(int var1) {
      this.m_firstColumn = var1;
   }

   // $FF: synthetic method
   static IStackModel access$200(JStackPanel var0) {
      return var0.m_model;
   }
}
