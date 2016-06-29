package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Convert;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JHexPanel.ColoredRange;
import com.google.security.zynamics.zylib.gui.JHexPanel.ColoredRangeManager;
import com.google.security.zynamics.zylib.gui.JHexPanel.IColormap;
import com.google.security.zynamics.zylib.gui.JHexPanel.IDataProvider;
import com.google.security.zynamics.zylib.gui.JHexPanel.IHexPanelListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.IMenuCreator;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$AddressMode;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DownAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$InternalListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$LeftAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$PageDownAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$PageUpAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$RightAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$TabAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$UpAction;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$Views;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$WaitingForDataAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public final class JHexView extends JComponent {
   private static final long serialVersionUID = -2402458562501988128L;
   private static final int CHARACTERS_PER_BYTE = 2;
   private static final String[] HEX_BYTES = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};
   private static final int PADDING_OFFSETVIEW = 20;
   private static final int NIBBLES_PER_BYTE = 2;
   private final ArrayList m_listeners = new ArrayList();
   private IDataProvider m_dataProvider;
   private int m_bytesPerRow = 16;
   private Font m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
   private long m_selectionStart = 0L;
   private long m_selectionLength = 0L;
   private JHexView$Views m_activeView;
   private int m_hexViewWidth;
   private int m_columnSpacing;
   private int m_bytesPerColumn;
   private Color m_bgColorOffset;
   private Color m_bgColorHex;
   private Color m_bgColorAscii;
   private Color m_fontColorOffsets;
   private Color m_fontColorHex1;
   private Color m_fontColorHex2;
   private Color m_fontColorAscii;
   private int m_rowHeight;
   private int m_charWidth;
   private final JScrollBar m_scrollbar;
   private final JScrollBar m_horizontalScrollbar;
   private int m_firstRow;
   private int m_firstColumn;
   private long m_baseAddress;
   private int m_lastMouseX;
   private int m_lastMouseY;
   private boolean m_enabled;
   private final Color m_disabledColor;
   private final JCaret m_caret;
   private static final int m_paddingHexLeft = 10;
   private static final int m_paddingAsciiLeft = 10;
   private static final int m_paddingTop = 16;
   private int m_charHeight;
   private final Color m_colorHighlight;
   private JHexView$DefinitionStatus m_status;
   private IMenuCreator m_menuCreator;
   private JHexView$AddressMode m_addressMode;
   private int m_offsetViewWidth;
   private final ColoredRangeManager[] m_coloredRanges;
   private Graphics bufferGraphics;
   private BufferedImage img;
   private Timer m_updateTimer;
   private boolean m_firstDraw;
   private final JHexView$InternalListener m_listener;
   private final JHexView$LeftAction m_leftAction;
   private final JHexView$RightAction m_rightAction;
   private final JHexView$UpAction m_upAction;
   private final JHexView$DownAction m_downAction;
   private final JHexView$PageUpAction m_pageUpAction;
   private final JHexView$PageDownAction m_pageDownAction;
   private final JHexView$TabAction m_tabAction;
   private int m_lastHighlightedNibble;
   private IColormap m_colormap;
   private Color m_selectionColor;
   private boolean m_flipBytes;

   public JHexView() {
      this.m_activeView = JHexView$Views.HEX_VIEW;
      this.m_hexViewWidth = 270;
      this.m_columnSpacing = 4;
      this.m_bytesPerColumn = 2;
      this.m_bgColorOffset = Color.GRAY;
      this.m_bgColorHex = Color.WHITE;
      this.m_bgColorAscii = Color.WHITE;
      this.m_fontColorOffsets = Color.WHITE;
      this.m_fontColorHex1 = Color.BLUE;
      this.m_fontColorHex2 = new Color(3381759);
      this.m_fontColorAscii = new Color(3381504);
      this.m_rowHeight = 12;
      this.m_charWidth = 8;
      this.m_scrollbar = new JScrollBar(1, 0, 1, 0, 1);
      this.m_horizontalScrollbar = new JScrollBar(0, 0, 1, 0, 1);
      this.m_firstRow = 0;
      this.m_firstColumn = 0;
      this.m_baseAddress = 0L;
      this.m_lastMouseX = 0;
      this.m_lastMouseY = 0;
      this.m_enabled = false;
      this.m_disabledColor = Color.GRAY;
      this.m_caret = new JCaret();
      this.m_charHeight = 8;
      this.m_colorHighlight = Color.LIGHT_GRAY;
      this.m_status = JHexView$DefinitionStatus.UNDEFINED;
      this.m_addressMode = JHexView$AddressMode.BIT32;
      this.m_coloredRanges = new ColoredRangeManager[10];
      this.m_firstDraw = true;
      this.m_listener = new JHexView$InternalListener(this, (JHexView$1)null);
      this.m_leftAction = new JHexView$LeftAction(this, (JHexView$1)null);
      this.m_rightAction = new JHexView$RightAction(this, (JHexView$1)null);
      this.m_upAction = new JHexView$UpAction(this, (JHexView$1)null);
      this.m_downAction = new JHexView$DownAction(this, (JHexView$1)null);
      this.m_pageUpAction = new JHexView$PageUpAction(this, (JHexView$1)null);
      this.m_pageDownAction = new JHexView$PageDownAction(this, (JHexView$1)null);
      this.m_tabAction = new JHexView$TabAction(this, (JHexView$1)null);
      this.m_selectionColor = Color.YELLOW;
      this.m_flipBytes = false;

      for(int var1 = 0; var1 < this.m_coloredRanges.length; ++var1) {
         this.m_coloredRanges[var1] = new ColoredRangeManager();
      }

      this.setFocusable(true);
      this.setLayout(new BorderLayout());
      this.setFont(this.m_font);
      this.initListeners();
      this.initHotkeys();
      this.initScrollbar();
      this.img = new BufferedImage(this.getWidth() + 1 - this.m_scrollbar.getWidth(), this.getHeight() + 1 - this.m_horizontalScrollbar.getHeight(), 1);
      this.bufferGraphics = this.img.getGraphics();
      this.updateOffsetViewWidth();
      this.setEnabled(false);
   }

   private void calculateSizes() {
      this.m_rowHeight = this.getRowHeight(this.bufferGraphics);
      this.m_charHeight = this.getCharHeight(this.bufferGraphics);
      this.m_charWidth = this.getCharacterWidth(this.bufferGraphics);
   }

   private void changeBy(ActionEvent var1, int var2) {
      if(var1.getModifiers() == 1) {
         if(this.getSelectionStart() + this.getSelectionLength() + (long)var2 < 0L) {
            this.setSelectionLength(-this.getSelectionStart());
         } else if(this.getSelectionStart() + this.getSelectionLength() + (long)var2 < (long)(2 * this.m_dataProvider.getDataLength())) {
            this.setSelectionLength(this.getSelectionLength() + (long)var2);
         } else {
            this.setSelectionLength((long)(2 * this.m_dataProvider.getDataLength()) - this.getSelectionStart());
         }
      } else {
         if(this.getSelectionStart() + this.getSelectionLength() + (long)var2 < 0L) {
            this.setSelectionStart(0L);
         } else if(this.getSelectionStart() + this.getSelectionLength() + (long)var2 < (long)(2 * this.m_dataProvider.getDataLength())) {
            this.setSelectionStart(this.getSelectionStart() + this.getSelectionLength() + (long)var2);
         } else {
            this.setSelectionStart((long)(2 * this.m_dataProvider.getDataLength()));
         }

         this.setSelectionLength(0L);
      }

      long var3 = this.getSelectionStart() + this.getSelectionLength();
      if(var3 < (long)(2 * this.getFirstVisibleByte())) {
         this.scrollToPosition(var3);
      } else if(var3 >= (long)(2 * (this.getFirstVisibleByte() + this.getMaximumVisibleBytes()))) {
         long var5 = var3 - (long)(2 * (this.getFirstVisibleByte() + this.getMaximumVisibleBytes()));
         long var7 = (long)(2 * this.getFirstVisibleByte() + 2 * this.m_bytesPerRow) + var5;
         this.scrollToPosition(var7);
      }

      this.m_caret.setVisible(true);
      this.repaint();
   }

   private void drawAsciiPanel(Graphics var1) {
      if(this.isEnabled()) {
         var1.setColor(this.m_fontColorAscii);
      } else {
         var1.setColor(this.m_disabledColor != this.m_bgColorAscii?this.m_disabledColor:Color.WHITE);
      }

      int var2 = this.getCharacterWidth(var1);
      int var3 = this.getAsciiViewLeft() + 10;
      int var4 = var3;
      int var5 = 16;
      byte[] var6 = null;
      int var7;
      if(this.m_status == JHexView$DefinitionStatus.DEFINED) {
         var7 = this.getBytesToDraw();
         var6 = this.m_dataProvider.getData(this.getFirstVisibleOffset(), var7);
      } else {
         var7 = this.getMaximumVisibleBytes();
      }

      long var8 = this.getFirstVisibleOffset();

      for(int var10 = 0; var10 < var7; ++var8) {
         ColoredRange var11 = this.findColoredRange(var8);
         if(var11 != null && var8 + (long)var7 < var11.getStart()) {
            var11 = null;
         }

         if(var10 != 0 && var10 % this.m_bytesPerRow == 0) {
            var4 = var3;
            var5 += this.m_rowHeight;
         }

         if(this.m_status == JHexView$DefinitionStatus.DEFINED) {
            char var12 = (char)var6[var10];
            var12 = Convert.isPrintableCharacter(var12)?var12:46;
            String var13 = String.valueOf(var12);
            if(this.isEnabled()) {
               long var14 = this.m_flipBytes?(var8 & (long)(-this.m_bytesPerColumn)) + (long)this.m_bytesPerColumn - var8 % (long)this.m_bytesPerColumn - 1L:var8;
               if(this.isSelectedOffset(var14)) {
                  var1.setColor(this.m_selectionColor);
                  var1.fillRect(var4, var5 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                  var1.setColor(this.m_fontColorAscii);
               } else {
                  Color var16;
                  if(var11 != null && var11.containsOffset(var8)) {
                     var16 = var11.getBackgroundColor();
                     if(var16 != null) {
                        var1.setColor(var16);
                     } else {
                        System.out.println("FOO");
                     }

                     var1.fillRect(var4, var5 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                     var1.setColor(var11.getColor());
                  } else if(this.m_colormap != null && this.m_colormap.colorize(var6, (long)var10)) {
                     var16 = this.m_colormap.getBackgroundColor(var6, (long)var10);
                     Color var17 = this.m_colormap.getForegroundColor(var6, (long)var10);
                     if(var16 != null) {
                        var1.setColor(var16);
                        var1.fillRect(var4, var5 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                     }

                     if(var17 != null) {
                        var1.setColor(var17);
                     }
                  } else {
                     var1.setColor(this.m_fontColorAscii);
                  }
               }
            } else {
               var1.setColor(this.m_disabledColor != this.m_bgColorAscii?this.m_disabledColor:Color.WHITE);
            }

            var1.drawString(var13, var4, var5);
         } else {
            var1.drawString("?", var4, var5);
         }

         var4 += var2;
         if(var11 != null && var11.getStart() + (long)var11.getSize() <= var8) {
            var11 = this.findColoredRange(var8);
            if(var11 != null && var8 + (long)var7 < var11.getStart()) {
               var11 = null;
            }
         }

         ++var10;
      }

   }

   private void drawBackground(Graphics var1) {
      var1.setColor(this.m_bgColorOffset);
      var1.fillRect(-this.m_firstColumn * this.m_charWidth, 0, this.m_offsetViewWidth, this.getHeight());
      var1.setColor(this.m_bgColorHex);
      var1.fillRect(-this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth, 0, this.m_hexViewWidth, this.getHeight());
      var1.setColor(this.m_bgColorAscii);
      var1.fillRect(-this.m_firstColumn * this.m_charWidth + this.m_hexViewWidth + this.m_offsetViewWidth, 0, this.m_firstColumn * this.m_charWidth + this.getWidth() - (this.m_hexViewWidth + this.m_offsetViewWidth) - this.m_scrollbar.getWidth(), this.getHeight() - this.m_horizontalScrollbar.getHeight());
      var1.setColor(Color.BLACK);
      var1.drawLine(-this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth, 0, -this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth, this.getHeight());
      var1.drawLine(-this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth + this.m_hexViewWidth, 0, -this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth + this.m_hexViewWidth, this.getHeight());
   }

   private void drawCaret(Graphics var1) {
      if(this.isEnabled()) {
         if(this.getCurrentOffset() >= (long)this.getFirstVisibleByte() && this.getCurrentColumn() <= this.getFirstVisibleByte() + this.getMaximumVisibleBytes()) {
            int var2 = this.getCharacterWidth(var1);
            if(this.m_activeView == JHexView$Views.HEX_VIEW) {
               this.drawCaretHexWindow(var1, var2, this.m_rowHeight);
            } else {
               this.drawCaretAsciiWindow(var1, var2, this.m_rowHeight);
            }

         }
      }
   }

   private void drawCaretAsciiWindow(Graphics var1, int var2, int var3) {
      int var4 = this.getCurrentRow() - this.m_firstRow;
      int var5 = this.getCurrentColumn();
      int var6 = var5 / 2;
      int var7 = 9 + this.m_offsetViewWidth + this.m_hexViewWidth;
      int var8 = -this.m_firstColumn * this.m_charWidth + var7 + var6 * var2;
      int var9 = 19 - var3 + var3 * var4;
      this.m_caret.draw(var1, var8, var9, var3);
   }

   private void drawCaretHexWindow(Graphics var1, int var2, int var3) {
      int var4 = this.getCurrentRow() - this.m_firstRow;
      int var5 = this.getCurrentColumn();
      int var6 = 9 + this.m_offsetViewWidth;
      int var7 = var5 / (2 * this.m_bytesPerColumn) * this.m_columnSpacing;
      int var8 = -this.m_firstColumn * this.m_charWidth + var6 + var5 * var2 + var7;
      int var9 = 19 - var3 + var3 * var4;
      this.m_caret.draw(var1, var8, var9, var3);
   }

   private void drawHexView(Graphics var1) {
      int var2 = 2 * this.getCharacterWidth(var1);
      int var3 = -this.m_firstColumn * this.m_charWidth + 10 + this.m_offsetViewWidth;
      int var4 = var3;
      int var5 = 16;
      boolean var6 = true;
      byte[] var7 = null;
      int var8;
      if(this.m_status == JHexView$DefinitionStatus.DEFINED) {
         var8 = this.getBytesToDraw();
         var7 = this.m_dataProvider.getData(this.getFirstVisibleOffset(), var8);
      } else {
         var8 = this.getMaximumVisibleBytes();
      }

      long var9 = this.getFirstVisibleOffset();

      for(int var11 = 0; var11 < var8; ++var9) {
         ColoredRange var12 = this.findColoredRange(var9);
         if(var11 != 0) {
            if(var11 % this.m_bytesPerRow == 0) {
               var4 = var3;
               var5 += this.m_rowHeight;
               var6 = true;
            } else if(var11 % this.m_bytesPerColumn == 0) {
               var4 += this.m_columnSpacing;
               var6 = !var6;
            }
         }

         if(this.isEnabled()) {
            if(this.isSelectedOffset(var9)) {
               var1.setColor(this.m_selectionColor);
               var1.fillRect(var4, var5 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
               var1.setColor(var6?this.m_fontColorHex1:this.m_fontColorHex2);
            } else {
               Color var13;
               if(var12 != null && var12.containsOffset(var9)) {
                  var13 = var12.getBackgroundColor();
                  if(var13 != null) {
                     var1.setColor(var13);
                  }

                  var1.fillRect(var4, var5 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                  if(var12.getColor() != null) {
                     var1.setColor(var12.getColor());
                  } else {
                     var1.setColor(var6?this.m_fontColorHex1:this.m_fontColorHex2);
                  }
               } else if(this.m_colormap != null && this.m_colormap.colorize(var7, (long)var11)) {
                  var13 = this.m_colormap.getBackgroundColor(var7, (long)var11);
                  Color var14 = this.m_colormap.getForegroundColor(var7, (long)var11);
                  if(var13 != null) {
                     var1.setColor(var13);
                     var1.fillRect(var4, var5 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                  }

                  if(var14 != null) {
                     var1.setColor(var14);
                  }
               } else {
                  var1.setColor(var6?this.m_fontColorHex1:this.m_fontColorHex2);
               }
            }
         } else {
            var1.setColor(this.m_disabledColor != this.m_bgColorHex?this.m_disabledColor:Color.WHITE);
         }

         if(this.m_status == JHexView$DefinitionStatus.DEFINED) {
            int var15 = Math.min(this.m_dataProvider.getDataLength() - var11, this.m_bytesPerColumn);
            int var16 = this.m_flipBytes?var11 / this.m_bytesPerColumn * this.m_bytesPerColumn + (var15 - var11 % var15 - 1):var11;
            var1.drawString(HEX_BYTES[var7[var16] & 255], var4, var5);
         } else {
            var1.drawString("??", var4, var5);
         }

         var4 += var2;
         ++var11;
      }

   }

   private void drawMouseOverHighlighting(Graphics var1) {
      var1.setColor(this.m_colorHighlight);
      this.m_lastHighlightedNibble = this.getNibbleAtCoordinate(this.m_lastMouseX, this.m_lastMouseY);
      if(this.m_lastHighlightedNibble != -1) {
         JHexView$Views var2 = this.m_lastMouseX >= this.getAsciiViewLeft()?JHexView$Views.ASCII_VIEW:JHexView$Views.HEX_VIEW;
         Rectangle var3;
         if(var2 == JHexView$Views.HEX_VIEW) {
            var3 = this.getNibbleBoundsHex(this.m_lastHighlightedNibble);
            var1.fillRect((int)var3.getX(), (int)var3.getY(), (int)var3.getWidth(), (int)var3.getHeight());
         } else if(var2 == JHexView$Views.ASCII_VIEW) {
            int var5 = 2 * this.m_lastHighlightedNibble / 2;
            Rectangle var4 = this.getNibbleBoundsHex(var5);
            var1.fillRect((int)var4.getX(), (int)var4.getY(), (int)var4.getWidth(), (int)var4.getHeight());
            var4 = this.getNibbleBoundsHex(var5 + 1);
            var1.fillRect((int)var4.getX(), (int)var4.getY(), (int)var4.getWidth(), (int)var4.getHeight());
         }

         var3 = this.getByteBoundsAscii(this.m_lastHighlightedNibble);
         var1.fillRect((int)var3.getX(), (int)var3.getY(), (int)var3.getWidth(), (int)var3.getHeight());
      }
   }

   private void drawOffsets(Graphics var1) {
      if(this.isEnabled()) {
         var1.setColor(this.m_fontColorOffsets);
      } else {
         var1.setColor(this.m_disabledColor != this.m_bgColorOffset?this.m_disabledColor:Color.WHITE);
      }

      int var2 = -this.m_firstColumn * this.m_charWidth + 10;
      int var3 = this.getMaximumVisibleBytes();
      String var4 = this.m_addressMode == JHexView$AddressMode.BIT32?"%08X":"%016X";

      for(int var5 = 0; var5 < var3; var5 += this.m_bytesPerRow) {
         long var6 = this.m_baseAddress + (long)(this.m_firstRow * this.m_bytesPerRow) + (long)var5;
         String var8 = String.format(var4, new Object[]{Long.valueOf(var6)});
         int var9 = var5 / this.m_bytesPerRow;
         var1.drawString(var8, var2, 16 + var9 * this.m_rowHeight);
      }

   }

   private ColoredRange findColoredRange(long var1) {
      ColoredRangeManager[] var3 = this.m_coloredRanges;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ColoredRangeManager var6 = var3[var5];
         ColoredRange var7 = var6.findRangeWith(var1);
         if(var7 != null) {
            return var7;
         }
      }

      return null;
   }

   private int getAsciiViewLeft() {
      return this.getHexViewLeft() + this.getHexViewWidth();
   }

   private Rectangle getByteBoundsAscii(int var1) {
      if(var1 < 2 * this.getFirstVisibleByte()) {
         return new Rectangle(-1, -1, -1, -1);
      } else if(var1 > 2 * this.getFirstVisibleByte() + 2 * this.getMaximumVisibleBytes()) {
         return new Rectangle(-1, -1, -1, -1);
      } else {
         int var2 = (var1 - 2 * this.getFirstVisibleByte()) / 2;
         int var3 = var2 / this.m_bytesPerRow;
         int var4 = var2 % this.m_bytesPerRow;
         int var5 = this.getAsciiViewLeft() + 10 + var4 * this.m_charWidth;
         int var6 = 16 - this.m_charHeight + var3 * this.m_rowHeight;
         return new Rectangle(var5, var6, this.m_charWidth, this.m_charHeight);
      }
   }

   private int getBytesToDraw() {
      int var1 = this.getFirstVisibleByte();
      int var2 = this.getMaximumVisibleBytes();
      int var3 = this.m_dataProvider.getDataLength() - var1;
      return Math.min(var2, var3);
   }

   private int getCharacterWidth(Graphics var1) {
      return (int)var1.getFontMetrics().getStringBounds("0", var1).getWidth();
   }

   private int getCharHeight(Graphics var1) {
      return var1.getFontMetrics().getAscent();
   }

   private int getColumnSize() {
      return 2 * this.m_bytesPerColumn * this.m_charWidth + this.m_columnSpacing;
   }

   private int getCurrentColumn() {
      return (int)this.getCurrentNibble() % (2 * this.m_bytesPerRow);
   }

   private long getCurrentNibble() {
      return this.getSelectionStart() + this.getSelectionLength();
   }

   private int getCurrentRow() {
      return (int)this.getCurrentNibble() / (2 * this.m_bytesPerRow);
   }

   private int getEarlierBytes() {
      return this.m_firstRow * this.m_bytesPerRow;
   }

   private int getFirstVisibleByte() {
      return this.m_firstRow * this.m_bytesPerRow;
   }

   private int getHexViewLeft() {
      return -this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth;
   }

   private int getMaximumVisibleBytes() {
      return this.getNumberOfVisibleRows() * this.m_bytesPerRow;
   }

   private int getNibbleAtCoordinate(int var1, int var2) {
      if(this.m_dataProvider == null) {
         return -1;
      } else if(var1 < this.getHexViewLeft() + 10) {
         return -1;
      } else {
         if(var2 >= 16 - this.m_font.getSize()) {
            if(var1 >= this.getHexViewLeft() && var1 < this.getHexViewLeft() + this.getHexViewWidth()) {
               return this.getNibbleAtCoordinatesHex(var1, var2);
            }

            if(var1 >= this.getAsciiViewLeft()) {
               return this.getNibbleAtCoordinatesAscii(var1, var2);
            }
         }

         return -1;
      }
   }

   private int getNibbleAtCoordinatesAscii(int var1, int var2) {
      int var3 = var1 - (this.getAsciiViewLeft() + 10);
      if(var3 < 0) {
         return -1;
      } else {
         int var4 = (var2 - (16 - this.m_charHeight)) / this.m_rowHeight;
         int var5 = 2 * this.getEarlierBytes();
         if(var3 / this.m_charWidth >= this.m_bytesPerRow) {
            return -1;
         } else {
            int var6 = 2 * (var3 / this.m_charWidth);
            int var7 = var5 + 2 * var4 * this.m_bytesPerRow + var6;
            return var7 >= 2 * this.m_dataProvider.getDataLength()?-1:var7;
         }
      }
   }

   private int getNibbleAtCoordinatesHex(int var1, int var2) {
      int var3 = var1 - (this.getHexViewLeft() + 10);
      int var4 = this.getColumnSize();
      int var5 = var3 / var4;
      if(var5 >= this.m_bytesPerRow / this.m_bytesPerColumn) {
         return -1;
      } else {
         int var6 = var3 % var4;
         int var7 = var6 / this.m_charWidth;
         if(var7 >= 2 * this.m_bytesPerColumn) {
            return -1;
         } else {
            int var8 = (var2 - (16 - this.m_charHeight)) / this.m_rowHeight;
            int var9 = 2 * this.getEarlierBytes();
            int var10 = var9 + 2 * (var8 * this.m_bytesPerRow + var5 * this.m_bytesPerColumn) + var7;
            return var10 >= 2 * this.m_dataProvider.getDataLength()?-1:var10;
         }
      }
   }

   private Rectangle getNibbleBoundsHex(int var1) {
      if(var1 < 2 * this.getFirstVisibleByte()) {
         return new Rectangle(-1, -1, -1, -1);
      } else if(var1 > 2 * this.getFirstVisibleByte() + 2 * this.getMaximumVisibleBytes()) {
         return new Rectangle(-1, -1, -1, -1);
      } else {
         int var2 = var1 - 2 * this.getFirstVisibleByte();
         int var3 = this.getColumnSize();
         int var4 = var2 / (2 * this.m_bytesPerRow);
         int var5 = var2 % (2 * this.m_bytesPerRow) / (2 * this.m_bytesPerColumn);
         int var6 = var2 % (2 * this.m_bytesPerRow) % (2 * this.m_bytesPerColumn);
         int var7 = this.getHexViewLeft() + 10 + var5 * var3 + var6 * this.m_charWidth;
         int var8 = 16 - this.m_charHeight + var4 * this.m_rowHeight;
         return new Rectangle(var7, var8, this.m_charWidth, this.m_charHeight);
      }
   }

   private int getNumberOfVisibleRows() {
      int var1 = this.getHeight() - 16 - this.m_horizontalScrollbar.getHeight();
      return var1 / this.m_rowHeight + (var1 % this.m_rowHeight == 0?0:1);
   }

   private int getRowHeight(Graphics var1) {
      return var1.getFontMetrics().getHeight();
   }

   private long getSelectionStart() {
      return this.m_selectionStart;
   }

   private void initHotkeys() {
      this.setFocusTraversalKeys(0, new HashSet());
      InputMap var1 = this.getInputMap();
      ActionMap var2 = this.getActionMap();
      var1.put(KeyStroke.getKeyStroke(37, 0), "LEFT");
      var2.put("LEFT", this.m_leftAction);
      var1.put(KeyStroke.getKeyStroke(37, 64), "shift LEFT");
      var2.put("shift LEFT", this.m_leftAction);
      var1.put(KeyStroke.getKeyStroke(39, 0), "RIGHT");
      var2.put("RIGHT", this.m_rightAction);
      var1.put(KeyStroke.getKeyStroke(39, 64), "shift RIGHT");
      var2.put("shift RIGHT", this.m_rightAction);
      var1.put(KeyStroke.getKeyStroke(38, 0), "UP");
      var2.put("UP", this.m_upAction);
      var1.put(KeyStroke.getKeyStroke(38, 64), "shift UP");
      var2.put("shift UP", this.m_upAction);
      var1.put(KeyStroke.getKeyStroke(40, 0), "DOWN");
      var2.put("DOWN", this.m_downAction);
      var1.put(KeyStroke.getKeyStroke(40, 64), "shift DOWN");
      var2.put("shift DOWN", this.m_downAction);
      var1.put(KeyStroke.getKeyStroke(34, 0), "PAGE_DOWN");
      var2.put("PAGE_DOWN", this.m_pageDownAction);
      var1.put(KeyStroke.getKeyStroke(34, 64), "shift PAGE_DOWN");
      var2.put("shift PAGE_DOWN", this.m_pageDownAction);
      var1.put(KeyStroke.getKeyStroke(33, 0), "PAGE_UP");
      var2.put("PAGE_UP", this.m_pageUpAction);
      var1.put(KeyStroke.getKeyStroke(33, 64), "shift PAGE_UP");
      var2.put("shift PAGE_UP", this.m_pageUpAction);
      var1.put(KeyStroke.getKeyStroke(9, 0), "TAB");
      var2.put("TAB", this.m_tabAction);
   }

   private void initListeners() {
      this.addMouseListener(this.m_listener);
      this.addMouseMotionListener(this.m_listener);
      this.addMouseWheelListener(this.m_listener);
      this.addFocusListener(this.m_listener);
      this.addComponentListener(this.m_listener);
      this.addKeyListener(this.m_listener);
      this.m_caret.addCaretListener(this.m_listener);
   }

   private void initScrollbar() {
      this.m_scrollbar.addAdjustmentListener(this.m_listener);
      this.add(this.m_scrollbar, "East");
      this.m_horizontalScrollbar.addAdjustmentListener(this.m_listener);
      this.add(this.m_horizontalScrollbar, "South");
   }

   private boolean isDataAvailable() {
      return this.m_dataProvider != null;
   }

   private boolean isInsideAsciiView(int var1, int var2) {
      return var2 >= 16 - this.m_font.getSize() && var1 >= this.getAsciiViewLeft();
   }

   private boolean isInsideHexView(int var1, int var2) {
      return var2 >= 16 - this.m_font.getSize() && var1 >= this.getHexViewLeft() && var1 < this.getHexViewLeft() + this.getHexViewWidth();
   }

   private boolean isPositionVisible(long var1) {
      int var3 = this.getFirstVisibleByte();
      int var4 = var3 + this.getMaximumVisibleBytes();
      return var1 >= (long)(2 * var3) && var1 <= (long)(2 * var4);
   }

   private boolean isSelectedOffset(long var1) {
      var1 -= this.m_baseAddress;
      return this.getSelectionLength() == 0L?false:(this.getSelectionLength() > 0L?var1 >= this.getSelectionStart() / 2L && 2L * var1 < this.getSelectionStart() + this.getSelectionLength():var1 >= (this.getSelectionStart() + this.getSelectionLength()) / 2L && 2L * var1 < this.getSelectionStart());
   }

   private void resetBufferedGraphic() {
      this.bufferGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());
      this.bufferGraphics.setFont(this.m_font);
   }

   private void scrollToPosition(long var1) {
      this.m_scrollbar.setValue((int)var1 / (2 * this.m_bytesPerRow));
   }

   private void setCurrentPosition(long var1) {
      this.m_selectionStart = var1;
      if(!this.isPositionVisible(this.getSelectionStart())) {
         this.scrollToPosition(this.getSelectionStart());
      }

      Iterator var3 = this.m_listeners.iterator();

      while(var3.hasNext()) {
         IHexPanelListener var4 = (IHexPanelListener)var3.next();
         var4.selectionChanged(this.getSelectionStart(), 1L);
      }

   }

   private void setScrollBarMaximum() {
      if(this.m_dataProvider == null) {
         this.m_scrollbar.setMaximum(1);
         this.m_horizontalScrollbar.setMaximum(1);
      } else {
         int var1 = this.getNumberOfVisibleRows();
         int var2 = this.m_dataProvider.getDataLength() / this.m_bytesPerRow;
         int var3 = 2 + var2 - var1;
         if(var3 < 0) {
            var3 = 0;
            this.m_scrollbar.setValue(0);
            this.m_scrollbar.setEnabled(false);
         } else {
            this.m_scrollbar.setEnabled(true);
         }

         this.m_scrollbar.setMaximum(var3);
         int var4 = this.getAsciiViewLeft() + 10 + this.m_charWidth * this.m_bytesPerRow;
         int var5 = this.getWidth() - this.m_scrollbar.getWidth();
         if(var5 >= var4) {
            this.m_horizontalScrollbar.setValue(0);
            this.m_horizontalScrollbar.setEnabled(false);
         } else {
            this.m_horizontalScrollbar.setMaximum((var4 - var5) / this.m_charWidth + 1);
            this.m_horizontalScrollbar.setEnabled(true);
         }
      }

   }

   private void setSelectionStart(long var1) {
      this.m_selectionStart = var1;
      Iterator var3 = this.m_listeners.iterator();

      while(var3.hasNext()) {
         IHexPanelListener var4 = (IHexPanelListener)var3.next();
         var4.selectionChanged(this.m_selectionStart, this.m_selectionLength);
      }

   }

   private void updateHexViewWidth() {
      this.m_hexViewWidth = 15 + this.getColumnSize() * this.getBytesPerRow() / this.getBytesPerColumn();
   }

   private void updateOffsetViewWidth() {
      int var1 = this.m_addressMode == JHexView$AddressMode.BIT32?8:16;
      this.m_offsetViewWidth = 20 + this.m_charWidth * var1;
   }

   private void updatePreferredSize() {
      int var1 = this.m_offsetViewWidth + this.m_hexViewWidth + 18 * this.m_charWidth + this.m_scrollbar.getWidth();
      this.setPreferredSize(new Dimension(var1, this.getHeight()));
      this.revalidate();
   }

   protected void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      this.resetBufferedGraphic();
      this.calculateSizes();
      this.updateOffsetViewWidth();
      if(this.m_firstDraw) {
         this.m_firstDraw = false;
         this.updateHexViewWidth();
         this.updatePreferredSize();
      }

      this.drawBackground(this.bufferGraphics);
      this.drawOffsets(this.bufferGraphics);
      if(this.isEnabled()) {
         this.drawMouseOverHighlighting(this.bufferGraphics);
      }

      if(this.m_status == JHexView$DefinitionStatus.DEFINED && this.m_dataProvider != null) {
         int var2 = this.getBytesToDraw();
         if(var2 != 0 && !this.m_dataProvider.hasData(this.getFirstVisibleOffset(), var2)) {
            this.setDefinitionStatus(JHexView$DefinitionStatus.UNDEFINED);
            this.setEnabled(false);
            if(this.m_updateTimer != null) {
               this.m_updateTimer.setRepeats(false);
               this.m_updateTimer.stop();
            }

            this.m_updateTimer = new Timer(1000, new JHexView$WaitingForDataAction(this, this.getFirstVisibleOffset(), var2, (JHexView$1)null));
            this.m_updateTimer.setRepeats(true);
            this.m_updateTimer.start();
            return;
         }
      }

      if(this.isDataAvailable() || this.m_status == JHexView$DefinitionStatus.UNDEFINED) {
         this.drawHexView(this.bufferGraphics);
         this.drawAsciiPanel(this.bufferGraphics);
         if(this.m_caret.isVisible() && this.hasFocus()) {
            this.drawCaret(this.bufferGraphics);
         }
      }

      var1.drawImage(this.img, 0, 0, this);
   }

   public void addHexListener(IHexPanelListener var1) {
      Preconditions.checkNotNull(var1, "Error: Listener can\'t be null");
      if(!this.m_listeners.contains(var1)) {
         this.m_listeners.add(var1);
      }

   }

   public void colorize(int var1, long var2, int var4, Color var5, Color var6) {
      Preconditions.checkArgument(var2 >= 0L, "Error: offset argument must be greater or equal to zero");
      Preconditions.checkArgument(var4 >= 0, "Error: size argument must be greater or equal to zero");
      Preconditions.checkArgument(var1 >= 0 && var1 < this.m_coloredRanges.length, "Error: level argument must be greater or equal to zero");
      this.m_coloredRanges[var1].addRange(new ColoredRange(var2, var4, var5, var6));
      this.repaint();
   }

   public void dispose() {
      this.removeMouseListener(this.m_listener);
      this.removeMouseMotionListener(this.m_listener);
      this.removeMouseWheelListener(this.m_listener);
      this.removeFocusListener(this.m_listener);
      this.removeComponentListener(this.m_listener);
      this.removeKeyListener(this.m_listener);
      this.m_caret.removeListener(this.m_listener);
      this.m_caret.stop();
   }

   public boolean doFlipBytes() {
      return this.m_flipBytes;
   }

   public JHexView$AddressMode getAddressMode() {
      return this.m_addressMode;
   }

   public Color getBackgroundColorAsciiView() {
      return this.m_bgColorAscii;
   }

   public Color getBackgroundColorHexView() {
      return this.m_bgColorHex;
   }

   public Color getBackgroundColorOffsetView() {
      return this.m_bgColorOffset;
   }

   public long getBaseAddress() {
      return this.m_baseAddress;
   }

   public int getBytesPerColumn() {
      return this.m_bytesPerColumn;
   }

   public int getBytesPerRow() {
      return this.m_bytesPerRow;
   }

   public int getColumnSpacing() {
      return this.m_columnSpacing;
   }

   public long getCurrentOffset() {
      long var1 = this.m_baseAddress + this.getCurrentNibble() / 2L;
      return this.m_flipBytes?(var1 & (long)(-this.m_bytesPerColumn)) + (long)this.m_bytesPerColumn - var1 % (long)this.m_bytesPerColumn - 1L:var1;
   }

   public IDataProvider getData() {
      return this.m_dataProvider;
   }

   public JHexView$DefinitionStatus getDefinitionStatus() {
      return this.m_status;
   }

   public long getFirstSelectedOffset() {
      return this.m_selectionLength >= 0L?(this.m_baseAddress + this.m_selectionStart) / 2L:(this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) / 2L;
   }

   public long getFirstVisibleOffset() {
      return this.getBaseAddress() + (long)this.getFirstVisibleByte();
   }

   public Color getFontColorAsciiView() {
      return this.m_fontColorAscii;
   }

   public Color getFontColorHexView1() {
      return this.m_fontColorHex1;
   }

   public Color getFontColorHexView2() {
      return this.m_fontColorHex2;
   }

   public Color getFontColorOffsetView() {
      return this.m_fontColorOffsets;
   }

   public int getFontSize() {
      return this.m_font.getSize();
   }

   public int getHexViewWidth() {
      return this.m_hexViewWidth;
   }

   public long getLastOffset() {
      return this.getBaseAddress() + (long)this.m_dataProvider.getDataLength();
   }

   public long getLastSelectedOffset() {
      return this.m_selectionLength >= 0L?(this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) / 2L + (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) % 2L:(this.m_baseAddress + this.m_selectionStart) / 2L + (this.m_baseAddress + this.m_selectionStart) % 2L;
   }

   public long getSelectionLength() {
      return this.m_selectionLength;
   }

   public int getVisibleBytes() {
      int var1 = this.getMaximumVisibleBytes();
      return this.m_dataProvider.getDataLength() - this.getFirstVisibleByte() >= var1?var1:this.m_dataProvider.getDataLength() - this.getFirstVisibleByte();
   }

   public void gotoOffset(long var1) {
      Preconditions.checkNotNull(this.m_dataProvider, "Error: No data provider active");
      if(this.getCurrentOffset() == var1) {
         if(!this.isPositionVisible(this.getSelectionStart())) {
            this.scrollToPosition(this.getSelectionStart());
         }

      } else {
         long var3;
         if(var1 < this.m_baseAddress) {
            var3 = var1;
         } else {
            var3 = var1 - this.m_baseAddress;
         }

         if(var3 >= 0L && var3 < (long)this.m_dataProvider.getDataLength()) {
            this.setCurrentPosition(2L * var3);
         } else {
            throw new IllegalArgumentException("Error: Invalid offset");
         }
      }
   }

   public boolean isEnabled() {
      return this.m_enabled;
   }

   public void removeHexListener(IHexPanelListener var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Listener can\'t be null");
      if(!this.m_listeners.remove(var1)) {
         throw new IllegalArgumentException("Internal Error: Listener was not listening on object");
      }
   }

   public void setAddressMode(JHexView$AddressMode var1) {
      this.m_addressMode = (JHexView$AddressMode)Preconditions.checkNotNull(var1, "Error: Address mode can\'t be null");
      this.updateOffsetViewWidth();
      this.updatePreferredSize();
   }

   public void setBackgroundColorAsciiView(Color var1) {
      this.m_bgColorAscii = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setBackgroundColorHexView(Color var1) {
      this.m_bgColorHex = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setBackgroundColorOffsetView(Color var1) {
      this.m_bgColorOffset = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setBaseAddress(long var1) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Base address can\'t be negative");
      this.m_baseAddress = var1;
      this.repaint();
   }

   public void setBytesPerColumn(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Number of bytes must be positive");
      Preconditions.checkArgument(var1 <= this.m_bytesPerRow, "Error: Number of bytes can\'t be more than the number of bytes per row");
      this.m_bytesPerColumn = var1;
      this.updateHexViewWidth();
      this.updatePreferredSize();
      this.repaint();
   }

   public void setBytesPerRow(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Value must be positive");
      this.m_bytesPerRow = var1;
      this.repaint();
   }

   public void setColormap(IColormap var1) {
      this.m_colormap = (IColormap)Preconditions.checkNotNull(var1, "Error: colormap argument can not be null");
      this.repaint();
   }

   public void setColumnSpacing(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Spacing must be positive");
      this.m_columnSpacing = var1;
      this.repaint();
   }

   public void setCurrentOffset(long var1) {
      if(this.m_dataProvider != null) {
         Preconditions.checkArgument(var1 >= this.getBaseAddress() || var1 <= this.getBaseAddress() + (long)this.m_dataProvider.getDataLength(), "Error: Invalid offset");
         this.setCurrentPosition(2L * (var1 - this.m_baseAddress));
      }
   }

   public void setData(IDataProvider var1) {
      if(this.m_dataProvider != null) {
         this.m_dataProvider.removeListener(this.m_listener);
      }

      this.m_dataProvider = var1;
      if(var1 != null) {
         this.m_dataProvider.addListener(this.m_listener);
      }

      this.setCurrentPosition(0L);
      this.setScrollBarMaximum();
      this.repaint();
   }

   public void setDefinitionStatus(JHexView$DefinitionStatus var1) {
      this.m_status = (JHexView$DefinitionStatus)Preconditions.checkNotNull(var1, "Error: Definition status can\'t be null");
      this.repaint();
   }

   public void setEnabled(boolean var1) {
      if(var1 != this.m_enabled) {
         this.m_enabled = var1;
         this.repaint();
      }
   }

   public void setFlipBytes(boolean var1) {
      if(this.m_flipBytes != var1) {
         this.m_flipBytes = var1;
         this.repaint();
      }
   }

   public void setFontColorAsciiView(Color var1) {
      this.m_fontColorAscii = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setFontColorHexView1(Color var1) {
      this.m_fontColorHex1 = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setFontColorHexView2(Color var1) {
      this.m_fontColorHex2 = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setFontColorOffsetView(Color var1) {
      this.m_fontColorOffsets = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setFontSize(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Font size must be positive");
      this.m_font = new Font(GuiHelper.getMonospaceFont(), 0, var1);
      this.setFont(this.m_font);
      this.m_firstDraw = true;
      this.repaint();
   }

   public void setHexViewWidth(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: Width must be positive");
      this.m_hexViewWidth = var1;
      this.repaint();
   }

   public void setMenuCreator(IMenuCreator var1) {
      this.m_menuCreator = var1;
   }

   public void setSelectionColor(Color var1) {
      this.m_selectionColor = (Color)Preconditions.checkNotNull(var1, "Error: Color can\'t be null");
      this.repaint();
   }

   public void setSelectionLength(long var1) {
      this.m_selectionLength = var1;
      Iterator var3 = this.m_listeners.iterator();

      while(var3.hasNext()) {
         IHexPanelListener var4 = (IHexPanelListener)var3.next();
         var4.selectionChanged(this.m_selectionStart, this.m_selectionLength);
      }

      this.repaint();
   }

   public void uncolorize(int var1, long var2, int var4) {
      Preconditions.checkArgument(var2 >= 0L, "Error: Offset can\'t be negative");
      Preconditions.checkArgument(var4 > 0, "Error: Size must be positive");
      Preconditions.checkArgument(var1 >= 0 && var1 < this.m_coloredRanges.length, "Error: Invalid level");
      this.m_coloredRanges[var1].removeRange(var2, var4);
      this.repaint();
   }

   public void uncolorizeAll() {
      ColoredRangeManager[] var1 = this.m_coloredRanges;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ColoredRangeManager var4 = var1[var3];
         var4.clear();
      }

   }

   public void uncolorizeAll(int var1) {
      this.m_coloredRanges[var1].clear();
      this.repaint();
   }

   // $FF: synthetic method
   static int access$900(JHexView var0) {
      return var0.m_bytesPerRow;
   }

   // $FF: synthetic method
   static void access$1000(JHexView var0, ActionEvent var1, int var2) {
      var0.changeBy(var1, var2);
   }

   // $FF: synthetic method
   static IDataProvider access$1100(JHexView var0) {
      return var0.m_dataProvider;
   }

   // $FF: synthetic method
   static long access$1200(JHexView var0) {
      return var0.getSelectionStart();
   }

   // $FF: synthetic method
   static void access$1300(JHexView var0, long var1) {
      var0.setSelectionStart(var1);
   }

   // $FF: synthetic method
   static long access$1400(JHexView var0) {
      return var0.m_baseAddress;
   }

   // $FF: synthetic method
   static JScrollBar access$1500(JHexView var0) {
      return var0.m_scrollbar;
   }

   // $FF: synthetic method
   static int access$1602(JHexView var0, int var1) {
      return var0.m_firstRow = var1;
   }

   // $FF: synthetic method
   static int access$1702(JHexView var0, int var1) {
      return var0.m_firstColumn = var1;
   }

   // $FF: synthetic method
   static void access$1800(JHexView var0) {
      var0.setScrollBarMaximum();
   }

   // $FF: synthetic method
   static JScrollBar access$1900(JHexView var0) {
      return var0.m_horizontalScrollbar;
   }

   // $FF: synthetic method
   static BufferedImage access$2002(JHexView var0, BufferedImage var1) {
      return var0.img = var1;
   }

   // $FF: synthetic method
   static Graphics access$2102(JHexView var0, Graphics var1) {
      return var0.bufferGraphics = var1;
   }

   // $FF: synthetic method
   static BufferedImage access$2000(JHexView var0) {
      return var0.img;
   }

   // $FF: synthetic method
   static JCaret access$2200(JHexView var0) {
      return var0.m_caret;
   }

   // $FF: synthetic method
   static JHexView$Views access$2300(JHexView var0) {
      return var0.m_activeView;
   }

   // $FF: synthetic method
   static int access$2400(JHexView var0) {
      return var0.m_rowHeight;
   }

   // $FF: synthetic method
   static int access$2500(JHexView var0) {
      return var0.m_charHeight;
   }

   // $FF: synthetic method
   static int access$2600(JHexView var0) {
      return var0.getFirstVisibleByte();
   }

   // $FF: synthetic method
   static void access$2700(JHexView var0, long var1) {
      var0.scrollToPosition(var1);
   }

   // $FF: synthetic method
   static int access$2800(JHexView var0) {
      return var0.getNumberOfVisibleRows();
   }

   // $FF: synthetic method
   static int access$2900(JHexView var0, int var1, int var2) {
      return var0.getNibbleAtCoordinate(var1, var2);
   }

   // $FF: synthetic method
   static int access$3002(JHexView var0, int var1) {
      return var0.m_lastMouseX = var1;
   }

   // $FF: synthetic method
   static int access$3102(JHexView var0, int var1) {
      return var0.m_lastMouseY = var1;
   }

   // $FF: synthetic method
   static long access$3202(JHexView var0, long var1) {
      return var0.m_selectionLength = var1;
   }

   // $FF: synthetic method
   static void access$3300(JHexView var0, long var1) {
      var0.setCurrentPosition(var1);
   }

   // $FF: synthetic method
   static boolean access$3400(JHexView var0, int var1, int var2) {
      return var0.isInsideHexView(var1, var2);
   }

   // $FF: synthetic method
   static JHexView$Views access$2302(JHexView var0, JHexView$Views var1) {
      return var0.m_activeView = var1;
   }

   // $FF: synthetic method
   static boolean access$3500(JHexView var0, int var1, int var2) {
      return var0.isInsideAsciiView(var1, var2);
   }

   // $FF: synthetic method
   static ArrayList access$3600(JHexView var0) {
      return var0.m_listeners;
   }

   // $FF: synthetic method
   static long access$3700(JHexView var0) {
      return var0.m_selectionStart;
   }

   // $FF: synthetic method
   static long access$3200(JHexView var0) {
      return var0.m_selectionLength;
   }

   // $FF: synthetic method
   static IMenuCreator access$3800(JHexView var0) {
      return var0.m_menuCreator;
   }
}
