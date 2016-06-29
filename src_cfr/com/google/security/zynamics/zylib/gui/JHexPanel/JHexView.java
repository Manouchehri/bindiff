/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Convert;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret;
import com.google.security.zynamics.zylib.gui.JHexPanel.ColoredRange;
import com.google.security.zynamics.zylib.gui.JHexPanel.ColoredRangeManager;
import com.google.security.zynamics.zylib.gui.JHexPanel.IColormap;
import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;
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
import java.awt.AWTKeyStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public final class JHexView
extends JComponent {
    private static final long serialVersionUID = -2402458562501988128L;
    private static final int CHARACTERS_PER_BYTE = 2;
    private static final String[] HEX_BYTES = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};
    private static final int PADDING_OFFSETVIEW = 20;
    private static final int NIBBLES_PER_BYTE = 2;
    private final ArrayList m_listeners = new ArrayList();
    private IDataProvider m_dataProvider;
    private int m_bytesPerRow = 16;
    private Font m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
    private long m_selectionStart = 0;
    private long m_selectionLength = 0;
    private JHexView$Views m_activeView = JHexView$Views.HEX_VIEW;
    private int m_hexViewWidth = 270;
    private int m_columnSpacing = 4;
    private int m_bytesPerColumn = 2;
    private Color m_bgColorOffset = Color.GRAY;
    private Color m_bgColorHex = Color.WHITE;
    private Color m_bgColorAscii = Color.WHITE;
    private Color m_fontColorOffsets = Color.WHITE;
    private Color m_fontColorHex1 = Color.BLUE;
    private Color m_fontColorHex2 = new Color(3381759);
    private Color m_fontColorAscii = new Color(3381504);
    private int m_rowHeight = 12;
    private int m_charWidth = 8;
    private final JScrollBar m_scrollbar = new JScrollBar(1, 0, 1, 0, 1);
    private final JScrollBar m_horizontalScrollbar = new JScrollBar(0, 0, 1, 0, 1);
    private int m_firstRow = 0;
    private int m_firstColumn = 0;
    private long m_baseAddress = 0;
    private int m_lastMouseX = 0;
    private int m_lastMouseY = 0;
    private boolean m_enabled = false;
    private final Color m_disabledColor = Color.GRAY;
    private final JCaret m_caret = new JCaret();
    private static final int m_paddingHexLeft = 10;
    private static final int m_paddingAsciiLeft = 10;
    private static final int m_paddingTop = 16;
    private int m_charHeight = 8;
    private final Color m_colorHighlight = Color.LIGHT_GRAY;
    private JHexView$DefinitionStatus m_status = JHexView$DefinitionStatus.UNDEFINED;
    private IMenuCreator m_menuCreator;
    private JHexView$AddressMode m_addressMode = JHexView$AddressMode.BIT32;
    private int m_offsetViewWidth;
    private final ColoredRangeManager[] m_coloredRanges = new ColoredRangeManager[10];
    private Graphics bufferGraphics;
    private BufferedImage img;
    private Timer m_updateTimer;
    private boolean m_firstDraw = true;
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
        this.m_listener = new JHexView$InternalListener(this, null);
        this.m_leftAction = new JHexView$LeftAction(this, null);
        this.m_rightAction = new JHexView$RightAction(this, null);
        this.m_upAction = new JHexView$UpAction(this, null);
        this.m_downAction = new JHexView$DownAction(this, null);
        this.m_pageUpAction = new JHexView$PageUpAction(this, null);
        this.m_pageDownAction = new JHexView$PageDownAction(this, null);
        this.m_tabAction = new JHexView$TabAction(this, null);
        this.m_selectionColor = Color.YELLOW;
        this.m_flipBytes = false;
        int n2 = 0;
        do {
            if (n2 >= this.m_coloredRanges.length) {
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
                return;
            }
            this.m_coloredRanges[n2] = new ColoredRangeManager();
            ++n2;
        } while (true);
    }

    private void calculateSizes() {
        this.m_rowHeight = this.getRowHeight(this.bufferGraphics);
        this.m_charHeight = this.getCharHeight(this.bufferGraphics);
        this.m_charWidth = this.getCharacterWidth(this.bufferGraphics);
    }

    private void changeBy(ActionEvent actionEvent, int n2) {
        if (actionEvent.getModifiers() == 1) {
            if (this.getSelectionStart() + this.getSelectionLength() + (long)n2 < 0) {
                this.setSelectionLength(- this.getSelectionStart());
            } else if (this.getSelectionStart() + this.getSelectionLength() + (long)n2 < (long)(2 * this.m_dataProvider.getDataLength())) {
                this.setSelectionLength(this.getSelectionLength() + (long)n2);
            } else {
                this.setSelectionLength((long)(2 * this.m_dataProvider.getDataLength()) - this.getSelectionStart());
            }
        } else {
            if (this.getSelectionStart() + this.getSelectionLength() + (long)n2 < 0) {
                this.setSelectionStart(0);
            } else if (this.getSelectionStart() + this.getSelectionLength() + (long)n2 < (long)(2 * this.m_dataProvider.getDataLength())) {
                this.setSelectionStart(this.getSelectionStart() + this.getSelectionLength() + (long)n2);
            } else {
                this.setSelectionStart(2 * this.m_dataProvider.getDataLength());
            }
            this.setSelectionLength(0);
        }
        long l2 = this.getSelectionStart() + this.getSelectionLength();
        if (l2 < (long)(2 * this.getFirstVisibleByte())) {
            this.scrollToPosition(l2);
        } else if (l2 >= (long)(2 * (this.getFirstVisibleByte() + this.getMaximumVisibleBytes()))) {
            long l3 = l2 - (long)(2 * (this.getFirstVisibleByte() + this.getMaximumVisibleBytes()));
            long l4 = (long)(2 * this.getFirstVisibleByte() + 2 * this.m_bytesPerRow) + l3;
            this.scrollToPosition(l4);
        }
        this.m_caret.setVisible(true);
        this.repaint();
    }

    private void drawAsciiPanel(Graphics graphics) {
        int n2;
        int n3;
        if (this.isEnabled()) {
            graphics.setColor(this.m_fontColorAscii);
        } else {
            graphics.setColor(this.m_disabledColor != this.m_bgColorAscii ? this.m_disabledColor : Color.WHITE);
        }
        int n4 = this.getCharacterWidth(graphics);
        int n5 = n3 = this.getAsciiViewLeft() + 10;
        int n6 = 16;
        byte[] arrby = null;
        if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
            n2 = this.getBytesToDraw();
            arrby = this.m_dataProvider.getData(this.getFirstVisibleOffset(), n2);
        } else {
            n2 = this.getMaximumVisibleBytes();
        }
        long l2 = this.getFirstVisibleOffset();
        int n7 = 0;
        while (n7 < n2) {
            ColoredRange coloredRange = this.findColoredRange(l2);
            if (coloredRange != null && l2 + (long)n2 < coloredRange.getStart()) {
                coloredRange = null;
            }
            if (n7 != 0 && n7 % this.m_bytesPerRow == 0) {
                n5 = n3;
                n6 += this.m_rowHeight;
            }
            if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
                int n8 = arrby[n7];
                n8 = Convert.isPrintableCharacter((char)n8) ? n8 : 46;
                String string = String.valueOf((char)n8);
                if (this.isEnabled()) {
                    long l3;
                    Color color;
                    long l4 = l3 = this.m_flipBytes ? (l2 & (long)(- this.m_bytesPerColumn)) + (long)this.m_bytesPerColumn - l2 % (long)this.m_bytesPerColumn - 1 : l2;
                    if (this.isSelectedOffset(l3)) {
                        graphics.setColor(this.m_selectionColor);
                        graphics.fillRect(n5, n6 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                        graphics.setColor(this.m_fontColorAscii);
                    } else if (coloredRange != null && coloredRange.containsOffset(l2)) {
                        color = coloredRange.getBackgroundColor();
                        if (color != null) {
                            graphics.setColor(color);
                        } else {
                            System.out.println("FOO");
                        }
                        graphics.fillRect(n5, n6 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                        graphics.setColor(coloredRange.getColor());
                    } else if (this.m_colormap != null && this.m_colormap.colorize(arrby, n7)) {
                        color = this.m_colormap.getBackgroundColor(arrby, n7);
                        Color color2 = this.m_colormap.getForegroundColor(arrby, n7);
                        if (color != null) {
                            graphics.setColor(color);
                            graphics.fillRect(n5, n6 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                        }
                        if (color2 != null) {
                            graphics.setColor(color2);
                        }
                    } else {
                        graphics.setColor(this.m_fontColorAscii);
                    }
                } else {
                    graphics.setColor(this.m_disabledColor != this.m_bgColorAscii ? this.m_disabledColor : Color.WHITE);
                }
                graphics.drawString(string, n5, n6);
            } else {
                graphics.drawString("?", n5, n6);
            }
            n5 += n4;
            if (coloredRange != null && coloredRange.getStart() + (long)coloredRange.getSize() <= l2 && (coloredRange = this.findColoredRange(l2)) != null && l2 + (long)n2 < coloredRange.getStart()) {
                coloredRange = null;
            }
            ++n7;
            ++l2;
        }
    }

    private void drawBackground(Graphics graphics) {
        graphics.setColor(this.m_bgColorOffset);
        graphics.fillRect((- this.m_firstColumn) * this.m_charWidth, 0, this.m_offsetViewWidth, this.getHeight());
        graphics.setColor(this.m_bgColorHex);
        graphics.fillRect((- this.m_firstColumn) * this.m_charWidth + this.m_offsetViewWidth, 0, this.m_hexViewWidth, this.getHeight());
        graphics.setColor(this.m_bgColorAscii);
        graphics.fillRect((- this.m_firstColumn) * this.m_charWidth + this.m_hexViewWidth + this.m_offsetViewWidth, 0, this.m_firstColumn * this.m_charWidth + this.getWidth() - (this.m_hexViewWidth + this.m_offsetViewWidth) - this.m_scrollbar.getWidth(), this.getHeight() - this.m_horizontalScrollbar.getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawLine((- this.m_firstColumn) * this.m_charWidth + this.m_offsetViewWidth, 0, (- this.m_firstColumn) * this.m_charWidth + this.m_offsetViewWidth, this.getHeight());
        graphics.drawLine((- this.m_firstColumn) * this.m_charWidth + this.m_offsetViewWidth + this.m_hexViewWidth, 0, (- this.m_firstColumn) * this.m_charWidth + this.m_offsetViewWidth + this.m_hexViewWidth, this.getHeight());
    }

    private void drawCaret(Graphics graphics) {
        if (!this.isEnabled()) {
            return;
        }
        if (this.getCurrentOffset() < (long)this.getFirstVisibleByte()) return;
        if (this.getCurrentColumn() > this.getFirstVisibleByte() + this.getMaximumVisibleBytes()) {
            return;
        }
        int n2 = this.getCharacterWidth(graphics);
        if (this.m_activeView == JHexView$Views.HEX_VIEW) {
            this.drawCaretHexWindow(graphics, n2, this.m_rowHeight);
            return;
        }
        this.drawCaretAsciiWindow(graphics, n2, this.m_rowHeight);
    }

    private void drawCaretAsciiWindow(Graphics graphics, int n2, int n3) {
        int n4 = this.getCurrentRow() - this.m_firstRow;
        int n5 = this.getCurrentColumn();
        int n6 = n5 / 2;
        int n7 = 9 + this.m_offsetViewWidth + this.m_hexViewWidth;
        int n8 = (- this.m_firstColumn) * this.m_charWidth + n7 + n6 * n2;
        int n9 = 19 - n3 + n3 * n4;
        this.m_caret.draw(graphics, n8, n9, n3);
    }

    private void drawCaretHexWindow(Graphics graphics, int n2, int n3) {
        int n4 = this.getCurrentRow() - this.m_firstRow;
        int n5 = this.getCurrentColumn();
        int n6 = 9 + this.m_offsetViewWidth;
        int n7 = n5 / (2 * this.m_bytesPerColumn) * this.m_columnSpacing;
        int n8 = (- this.m_firstColumn) * this.m_charWidth + n6 + n5 * n2 + n7;
        int n9 = 19 - n3 + n3 * n4;
        this.m_caret.draw(graphics, n8, n9, n3);
    }

    private void drawHexView(Graphics graphics) {
        int n2;
        int n3;
        int n4 = 2 * this.getCharacterWidth(graphics);
        int n5 = n3 = (- this.m_firstColumn) * this.m_charWidth + 10 + this.m_offsetViewWidth;
        int n6 = 16;
        boolean bl2 = true;
        byte[] arrby = null;
        if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
            n2 = this.getBytesToDraw();
            arrby = this.m_dataProvider.getData(this.getFirstVisibleOffset(), n2);
        } else {
            n2 = this.getMaximumVisibleBytes();
        }
        long l2 = this.getFirstVisibleOffset();
        int n7 = 0;
        while (n7 < n2) {
            ColoredRange coloredRange = this.findColoredRange(l2);
            if (n7 != 0) {
                if (n7 % this.m_bytesPerRow == 0) {
                    n5 = n3;
                    n6 += this.m_rowHeight;
                    bl2 = true;
                } else if (n7 % this.m_bytesPerColumn == 0) {
                    n5 += this.m_columnSpacing;
                    boolean bl3 = bl2 = !bl2;
                }
            }
            if (this.isEnabled()) {
                if (this.isSelectedOffset(l2)) {
                    graphics.setColor(this.m_selectionColor);
                    graphics.fillRect(n5, n6 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                    graphics.setColor(bl2 ? this.m_fontColorHex1 : this.m_fontColorHex2);
                } else if (coloredRange != null && coloredRange.containsOffset(l2)) {
                    Color color = coloredRange.getBackgroundColor();
                    if (color != null) {
                        graphics.setColor(color);
                    }
                    graphics.fillRect(n5, n6 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                    if (coloredRange.getColor() != null) {
                        graphics.setColor(coloredRange.getColor());
                    } else {
                        graphics.setColor(bl2 ? this.m_fontColorHex1 : this.m_fontColorHex2);
                    }
                } else if (this.m_colormap != null && this.m_colormap.colorize(arrby, n7)) {
                    Color color = this.m_colormap.getBackgroundColor(arrby, n7);
                    Color color2 = this.m_colormap.getForegroundColor(arrby, n7);
                    if (color != null) {
                        graphics.setColor(color);
                        graphics.fillRect(n5, n6 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                    }
                    if (color2 != null) {
                        graphics.setColor(color2);
                    }
                } else {
                    graphics.setColor(bl2 ? this.m_fontColorHex1 : this.m_fontColorHex2);
                }
            } else {
                graphics.setColor(this.m_disabledColor != this.m_bgColorHex ? this.m_disabledColor : Color.WHITE);
            }
            if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
                int n8 = Math.min(this.m_dataProvider.getDataLength() - n7, this.m_bytesPerColumn);
                int n9 = this.m_flipBytes ? n7 / this.m_bytesPerColumn * this.m_bytesPerColumn + (n8 - n7 % n8 - 1) : n7;
                graphics.drawString(HEX_BYTES[arrby[n9] & 255], n5, n6);
            } else {
                graphics.drawString("??", n5, n6);
            }
            n5 += n4;
            ++n7;
            ++l2;
        }
    }

    private void drawMouseOverHighlighting(Graphics graphics) {
        Rectangle rectangle;
        JHexView$Views jHexView$Views;
        graphics.setColor(this.m_colorHighlight);
        this.m_lastHighlightedNibble = this.getNibbleAtCoordinate(this.m_lastMouseX, this.m_lastMouseY);
        if (this.m_lastHighlightedNibble == -1) {
            return;
        }
        JHexView$Views jHexView$Views2 = jHexView$Views = this.m_lastMouseX >= this.getAsciiViewLeft() ? JHexView$Views.ASCII_VIEW : JHexView$Views.HEX_VIEW;
        if (jHexView$Views == JHexView$Views.HEX_VIEW) {
            rectangle = this.getNibbleBoundsHex(this.m_lastHighlightedNibble);
            graphics.fillRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
        } else if (jHexView$Views == JHexView$Views.ASCII_VIEW) {
            int n2 = 2 * this.m_lastHighlightedNibble / 2;
            Rectangle rectangle2 = this.getNibbleBoundsHex(n2);
            graphics.fillRect((int)rectangle2.getX(), (int)rectangle2.getY(), (int)rectangle2.getWidth(), (int)rectangle2.getHeight());
            rectangle2 = this.getNibbleBoundsHex(n2 + 1);
            graphics.fillRect((int)rectangle2.getX(), (int)rectangle2.getY(), (int)rectangle2.getWidth(), (int)rectangle2.getHeight());
        }
        rectangle = this.getByteBoundsAscii(this.m_lastHighlightedNibble);
        graphics.fillRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
    }

    private void drawOffsets(Graphics graphics) {
        if (this.isEnabled()) {
            graphics.setColor(this.m_fontColorOffsets);
        } else {
            graphics.setColor(this.m_disabledColor != this.m_bgColorOffset ? this.m_disabledColor : Color.WHITE);
        }
        int n2 = (- this.m_firstColumn) * this.m_charWidth + 10;
        int n3 = this.getMaximumVisibleBytes();
        String string = this.m_addressMode == JHexView$AddressMode.BIT32 ? "%08X" : "%016X";
        int n4 = 0;
        while (n4 < n3) {
            long l2 = this.m_baseAddress + (long)(this.m_firstRow * this.m_bytesPerRow) + (long)n4;
            String string2 = String.format(string, l2);
            int n5 = n4 / this.m_bytesPerRow;
            graphics.drawString(string2, n2, 16 + n5 * this.m_rowHeight);
            n4 += this.m_bytesPerRow;
        }
    }

    private ColoredRange findColoredRange(long l2) {
        ColoredRangeManager[] arrcoloredRangeManager = this.m_coloredRanges;
        int n2 = arrcoloredRangeManager.length;
        int n3 = 0;
        while (n3 < n2) {
            ColoredRangeManager coloredRangeManager = arrcoloredRangeManager[n3];
            ColoredRange coloredRange = coloredRangeManager.findRangeWith(l2);
            if (coloredRange != null) {
                return coloredRange;
            }
            ++n3;
        }
        return null;
    }

    private int getAsciiViewLeft() {
        return this.getHexViewLeft() + this.getHexViewWidth();
    }

    private Rectangle getByteBoundsAscii(int n2) {
        if (n2 < 2 * this.getFirstVisibleByte()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        if (n2 > 2 * this.getFirstVisibleByte() + 2 * this.getMaximumVisibleBytes()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        int n3 = (n2 - 2 * this.getFirstVisibleByte()) / 2;
        int n4 = n3 / this.m_bytesPerRow;
        int n5 = n3 % this.m_bytesPerRow;
        int n6 = this.getAsciiViewLeft() + 10 + n5 * this.m_charWidth;
        int n7 = 16 - this.m_charHeight + n4 * this.m_rowHeight;
        return new Rectangle(n6, n7, this.m_charWidth, this.m_charHeight);
    }

    private int getBytesToDraw() {
        int n2 = this.getFirstVisibleByte();
        int n3 = this.getMaximumVisibleBytes();
        int n4 = this.m_dataProvider.getDataLength() - n2;
        return Math.min(n3, n4);
    }

    private int getCharacterWidth(Graphics graphics) {
        return (int)graphics.getFontMetrics().getStringBounds("0", graphics).getWidth();
    }

    private int getCharHeight(Graphics graphics) {
        return graphics.getFontMetrics().getAscent();
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
        return (- this.m_firstColumn) * this.m_charWidth + this.m_offsetViewWidth;
    }

    private int getMaximumVisibleBytes() {
        return this.getNumberOfVisibleRows() * this.m_bytesPerRow;
    }

    private int getNibbleAtCoordinate(int n2, int n3) {
        if (this.m_dataProvider == null) {
            return -1;
        }
        if (n2 < this.getHexViewLeft() + 10) {
            return -1;
        }
        if (n3 < 16 - this.m_font.getSize()) return -1;
        if (n2 >= this.getHexViewLeft() && n2 < this.getHexViewLeft() + this.getHexViewWidth()) {
            return this.getNibbleAtCoordinatesHex(n2, n3);
        }
        if (n2 < this.getAsciiViewLeft()) return -1;
        return this.getNibbleAtCoordinatesAscii(n2, n3);
    }

    private int getNibbleAtCoordinatesAscii(int n2, int n3) {
        int n4 = n2 - (this.getAsciiViewLeft() + 10);
        if (n4 < 0) {
            return -1;
        }
        int n5 = (n3 - (16 - this.m_charHeight)) / this.m_rowHeight;
        int n6 = 2 * this.getEarlierBytes();
        if (n4 / this.m_charWidth >= this.m_bytesPerRow) {
            return -1;
        }
        int n7 = 2 * (n4 / this.m_charWidth);
        int n8 = n6 + 2 * n5 * this.m_bytesPerRow + n7;
        if (n8 < 2 * this.m_dataProvider.getDataLength()) return n8;
        return -1;
    }

    private int getNibbleAtCoordinatesHex(int n2, int n3) {
        int n4;
        int n5 = n2 - (this.getHexViewLeft() + 10);
        int n6 = n5 / (n4 = this.getColumnSize());
        if (n6 >= this.m_bytesPerRow / this.m_bytesPerColumn) {
            return -1;
        }
        int n7 = n5 % n4;
        int n8 = n7 / this.m_charWidth;
        if (n8 >= 2 * this.m_bytesPerColumn) {
            return -1;
        }
        int n9 = (n3 - (16 - this.m_charHeight)) / this.m_rowHeight;
        int n10 = 2 * this.getEarlierBytes();
        int n11 = n10 + 2 * (n9 * this.m_bytesPerRow + n6 * this.m_bytesPerColumn) + n8;
        if (n11 < 2 * this.m_dataProvider.getDataLength()) return n11;
        return -1;
    }

    private Rectangle getNibbleBoundsHex(int n2) {
        if (n2 < 2 * this.getFirstVisibleByte()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        if (n2 > 2 * this.getFirstVisibleByte() + 2 * this.getMaximumVisibleBytes()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        int n3 = n2 - 2 * this.getFirstVisibleByte();
        int n4 = this.getColumnSize();
        int n5 = n3 / (2 * this.m_bytesPerRow);
        int n6 = n3 % (2 * this.m_bytesPerRow) / (2 * this.m_bytesPerColumn);
        int n7 = n3 % (2 * this.m_bytesPerRow) % (2 * this.m_bytesPerColumn);
        int n8 = this.getHexViewLeft() + 10 + n6 * n4 + n7 * this.m_charWidth;
        int n9 = 16 - this.m_charHeight + n5 * this.m_rowHeight;
        return new Rectangle(n8, n9, this.m_charWidth, this.m_charHeight);
    }

    private int getNumberOfVisibleRows() {
        int n2;
        int n3 = this.getHeight() - 16 - this.m_horizontalScrollbar.getHeight();
        if (n3 % this.m_rowHeight == 0) {
            n2 = 0;
            return n3 / this.m_rowHeight + n2;
        }
        n2 = 1;
        return n3 / this.m_rowHeight + n2;
    }

    private int getRowHeight(Graphics graphics) {
        return graphics.getFontMetrics().getHeight();
    }

    private long getSelectionStart() {
        return this.m_selectionStart;
    }

    private void initHotkeys() {
        this.setFocusTraversalKeys(0, new HashSet());
        InputMap inputMap = this.getInputMap();
        ActionMap actionMap = this.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke(37, 0), "LEFT");
        actionMap.put("LEFT", this.m_leftAction);
        inputMap.put(KeyStroke.getKeyStroke(37, 64), "shift LEFT");
        actionMap.put("shift LEFT", this.m_leftAction);
        inputMap.put(KeyStroke.getKeyStroke(39, 0), "RIGHT");
        actionMap.put("RIGHT", this.m_rightAction);
        inputMap.put(KeyStroke.getKeyStroke(39, 64), "shift RIGHT");
        actionMap.put("shift RIGHT", this.m_rightAction);
        inputMap.put(KeyStroke.getKeyStroke(38, 0), "UP");
        actionMap.put("UP", this.m_upAction);
        inputMap.put(KeyStroke.getKeyStroke(38, 64), "shift UP");
        actionMap.put("shift UP", this.m_upAction);
        inputMap.put(KeyStroke.getKeyStroke(40, 0), "DOWN");
        actionMap.put("DOWN", this.m_downAction);
        inputMap.put(KeyStroke.getKeyStroke(40, 64), "shift DOWN");
        actionMap.put("shift DOWN", this.m_downAction);
        inputMap.put(KeyStroke.getKeyStroke(34, 0), "PAGE_DOWN");
        actionMap.put("PAGE_DOWN", this.m_pageDownAction);
        inputMap.put(KeyStroke.getKeyStroke(34, 64), "shift PAGE_DOWN");
        actionMap.put("shift PAGE_DOWN", this.m_pageDownAction);
        inputMap.put(KeyStroke.getKeyStroke(33, 0), "PAGE_UP");
        actionMap.put("PAGE_UP", this.m_pageUpAction);
        inputMap.put(KeyStroke.getKeyStroke(33, 64), "shift PAGE_UP");
        actionMap.put("shift PAGE_UP", this.m_pageUpAction);
        inputMap.put(KeyStroke.getKeyStroke(9, 0), "TAB");
        actionMap.put("TAB", this.m_tabAction);
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
        this.add((Component)this.m_scrollbar, "East");
        this.m_horizontalScrollbar.addAdjustmentListener(this.m_listener);
        this.add((Component)this.m_horizontalScrollbar, "South");
    }

    private boolean isDataAvailable() {
        if (this.m_dataProvider == null) return false;
        return true;
    }

    private boolean isInsideAsciiView(int n2, int n3) {
        if (n3 < 16 - this.m_font.getSize()) return false;
        if (n2 < this.getAsciiViewLeft()) return false;
        return true;
    }

    private boolean isInsideHexView(int n2, int n3) {
        if (n3 < 16 - this.m_font.getSize()) return false;
        if (n2 < this.getHexViewLeft()) return false;
        if (n2 >= this.getHexViewLeft() + this.getHexViewWidth()) return false;
        return true;
    }

    private boolean isPositionVisible(long l2) {
        int n2 = this.getFirstVisibleByte();
        int n3 = n2 + this.getMaximumVisibleBytes();
        if (l2 < (long)(2 * n2)) return false;
        if (l2 > (long)(2 * n3)) return false;
        return true;
    }

    private boolean isSelectedOffset(long l2) {
        l2 -= this.m_baseAddress;
        if (this.getSelectionLength() == 0) {
            return false;
        }
        if (this.getSelectionLength() > 0) {
            if (l2 < this.getSelectionStart() / 2) return false;
            if (2 * l2 >= this.getSelectionStart() + this.getSelectionLength()) return false;
            return true;
        }
        if (l2 < (this.getSelectionStart() + this.getSelectionLength()) / 2) return false;
        if (2 * l2 >= this.getSelectionStart()) return false;
        return true;
    }

    private void resetBufferedGraphic() {
        this.bufferGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        this.bufferGraphics.setFont(this.m_font);
    }

    private void scrollToPosition(long l2) {
        this.m_scrollbar.setValue((int)l2 / (2 * this.m_bytesPerRow));
    }

    private void setCurrentPosition(long l2) {
        this.m_selectionStart = l2;
        if (!this.isPositionVisible(this.getSelectionStart())) {
            this.scrollToPosition(this.getSelectionStart());
        }
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IHexPanelListener iHexPanelListener = (IHexPanelListener)iterator.next();
            iHexPanelListener.selectionChanged(this.getSelectionStart(), 1);
        }
    }

    private void setScrollBarMaximum() {
        if (this.m_dataProvider == null) {
            this.m_scrollbar.setMaximum(1);
            this.m_horizontalScrollbar.setMaximum(1);
            return;
        }
        int n2 = this.getNumberOfVisibleRows();
        int n3 = this.m_dataProvider.getDataLength() / this.m_bytesPerRow;
        int n4 = 2 + n3 - n2;
        if (n4 < 0) {
            n4 = 0;
            this.m_scrollbar.setValue(0);
            this.m_scrollbar.setEnabled(false);
        } else {
            this.m_scrollbar.setEnabled(true);
        }
        this.m_scrollbar.setMaximum(n4);
        int n5 = this.getAsciiViewLeft() + 10 + this.m_charWidth * this.m_bytesPerRow;
        int n6 = this.getWidth() - this.m_scrollbar.getWidth();
        if (n6 >= n5) {
            this.m_horizontalScrollbar.setValue(0);
            this.m_horizontalScrollbar.setEnabled(false);
            return;
        }
        this.m_horizontalScrollbar.setMaximum((n5 - n6) / this.m_charWidth + 1);
        this.m_horizontalScrollbar.setEnabled(true);
    }

    private void setSelectionStart(long l2) {
        this.m_selectionStart = l2;
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IHexPanelListener iHexPanelListener = (IHexPanelListener)iterator.next();
            iHexPanelListener.selectionChanged(this.m_selectionStart, this.m_selectionLength);
        }
    }

    private void updateHexViewWidth() {
        this.m_hexViewWidth = 15 + this.getColumnSize() * this.getBytesPerRow() / this.getBytesPerColumn();
    }

    private void updateOffsetViewWidth() {
        int n2 = this.m_addressMode == JHexView$AddressMode.BIT32 ? 8 : 16;
        this.m_offsetViewWidth = 20 + this.m_charWidth * n2;
    }

    private void updatePreferredSize() {
        int n2 = this.m_offsetViewWidth + this.m_hexViewWidth + 18 * this.m_charWidth + this.m_scrollbar.getWidth();
        this.setPreferredSize(new Dimension(n2, this.getHeight()));
        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        int n2;
        super.paintComponent(graphics);
        this.resetBufferedGraphic();
        this.calculateSizes();
        this.updateOffsetViewWidth();
        if (this.m_firstDraw) {
            this.m_firstDraw = false;
            this.updateHexViewWidth();
            this.updatePreferredSize();
        }
        this.drawBackground(this.bufferGraphics);
        this.drawOffsets(this.bufferGraphics);
        if (this.isEnabled()) {
            this.drawMouseOverHighlighting(this.bufferGraphics);
        }
        if (this.m_status == JHexView$DefinitionStatus.DEFINED && this.m_dataProvider != null && (n2 = this.getBytesToDraw()) != 0 && !this.m_dataProvider.hasData(this.getFirstVisibleOffset(), n2)) {
            this.setDefinitionStatus(JHexView$DefinitionStatus.UNDEFINED);
            this.setEnabled(false);
            if (this.m_updateTimer != null) {
                this.m_updateTimer.setRepeats(false);
                this.m_updateTimer.stop();
            }
            this.m_updateTimer = new Timer(1000, new JHexView$WaitingForDataAction(this, this.getFirstVisibleOffset(), n2, null));
            this.m_updateTimer.setRepeats(true);
            this.m_updateTimer.start();
            return;
        }
        if (this.isDataAvailable() || this.m_status == JHexView$DefinitionStatus.UNDEFINED) {
            this.drawHexView(this.bufferGraphics);
            this.drawAsciiPanel(this.bufferGraphics);
            if (this.m_caret.isVisible() && this.hasFocus()) {
                this.drawCaret(this.bufferGraphics);
            }
        }
        graphics.drawImage(this.img, 0, 0, this);
    }

    public void addHexListener(IHexPanelListener iHexPanelListener) {
        Preconditions.checkNotNull(iHexPanelListener, "Error: Listener can't be null");
        if (this.m_listeners.contains(iHexPanelListener)) return;
        this.m_listeners.add(iHexPanelListener);
    }

    public void colorize(int n2, long l2, int n3, Color color, Color color2) {
        Preconditions.checkArgument(l2 >= 0, "Error: offset argument must be greater or equal to zero");
        Preconditions.checkArgument(n3 >= 0, "Error: size argument must be greater or equal to zero");
        Preconditions.checkArgument(n2 >= 0 && n2 < this.m_coloredRanges.length, "Error: level argument must be greater or equal to zero");
        this.m_coloredRanges[n2].addRange(new ColoredRange(l2, n3, color, color2));
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
        long l2;
        long l3 = this.m_baseAddress + this.getCurrentNibble() / 2;
        if (this.m_flipBytes) {
            l2 = (l3 & (long)(- this.m_bytesPerColumn)) + (long)this.m_bytesPerColumn - l3 % (long)this.m_bytesPerColumn - 1;
            return l2;
        }
        l2 = l3;
        return l2;
    }

    public IDataProvider getData() {
        return this.m_dataProvider;
    }

    public JHexView$DefinitionStatus getDefinitionStatus() {
        return this.m_status;
    }

    public long getFirstSelectedOffset() {
        if (this.m_selectionLength < 0) return (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) / 2;
        return (this.m_baseAddress + this.m_selectionStart) / 2;
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
        if (this.m_selectionLength < 0) return (this.m_baseAddress + this.m_selectionStart) / 2 + (this.m_baseAddress + this.m_selectionStart) % 2;
        return (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) / 2 + (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) % 2;
    }

    public long getSelectionLength() {
        return this.m_selectionLength;
    }

    public int getVisibleBytes() {
        int n2 = this.getMaximumVisibleBytes();
        if (this.m_dataProvider.getDataLength() - this.getFirstVisibleByte() < n2) return this.m_dataProvider.getDataLength() - this.getFirstVisibleByte();
        return n2;
    }

    public void gotoOffset(long l2) {
        Preconditions.checkNotNull(this.m_dataProvider, "Error: No data provider active");
        if (this.getCurrentOffset() == l2) {
            if (this.isPositionVisible(this.getSelectionStart())) return;
            this.scrollToPosition(this.getSelectionStart());
            return;
        }
        long l3 = l2 < this.m_baseAddress ? l2 : l2 - this.m_baseAddress;
        if (l3 < 0) throw new IllegalArgumentException("Error: Invalid offset");
        if (l3 >= (long)this.m_dataProvider.getDataLength()) {
            throw new IllegalArgumentException("Error: Invalid offset");
        }
        this.setCurrentPosition(2 * l3);
    }

    @Override
    public boolean isEnabled() {
        return this.m_enabled;
    }

    public void removeHexListener(IHexPanelListener iHexPanelListener) {
        Preconditions.checkNotNull(iHexPanelListener, "Internal Error: Listener can't be null");
        if (this.m_listeners.remove(iHexPanelListener)) return;
        throw new IllegalArgumentException("Internal Error: Listener was not listening on object");
    }

    public void setAddressMode(JHexView$AddressMode jHexView$AddressMode) {
        this.m_addressMode = (JHexView$AddressMode)((Object)Preconditions.checkNotNull((Object)jHexView$AddressMode, "Error: Address mode can't be null"));
        this.updateOffsetViewWidth();
        this.updatePreferredSize();
    }

    public void setBackgroundColorAsciiView(Color color) {
        this.m_bgColorAscii = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setBackgroundColorHexView(Color color) {
        this.m_bgColorHex = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setBackgroundColorOffsetView(Color color) {
        this.m_bgColorOffset = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setBaseAddress(long l2) {
        Preconditions.checkArgument(l2 >= 0, "Error: Base address can't be negative");
        this.m_baseAddress = l2;
        this.repaint();
    }

    public void setBytesPerColumn(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: Number of bytes must be positive");
        Preconditions.checkArgument(n2 <= this.m_bytesPerRow, "Error: Number of bytes can't be more than the number of bytes per row");
        this.m_bytesPerColumn = n2;
        this.updateHexViewWidth();
        this.updatePreferredSize();
        this.repaint();
    }

    public void setBytesPerRow(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: Value must be positive");
        this.m_bytesPerRow = n2;
        this.repaint();
    }

    public void setColormap(IColormap iColormap) {
        this.m_colormap = (IColormap)Preconditions.checkNotNull(iColormap, "Error: colormap argument can not be null");
        this.repaint();
    }

    public void setColumnSpacing(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: Spacing must be positive");
        this.m_columnSpacing = n2;
        this.repaint();
    }

    public void setCurrentOffset(long l2) {
        if (this.m_dataProvider == null) {
            return;
        }
        Preconditions.checkArgument(l2 >= this.getBaseAddress() || l2 <= this.getBaseAddress() + (long)this.m_dataProvider.getDataLength(), "Error: Invalid offset");
        this.setCurrentPosition(2 * (l2 - this.m_baseAddress));
    }

    public void setData(IDataProvider iDataProvider) {
        if (this.m_dataProvider != null) {
            this.m_dataProvider.removeListener(this.m_listener);
        }
        this.m_dataProvider = iDataProvider;
        if (iDataProvider != null) {
            this.m_dataProvider.addListener(this.m_listener);
        }
        this.setCurrentPosition(0);
        this.setScrollBarMaximum();
        this.repaint();
    }

    public void setDefinitionStatus(JHexView$DefinitionStatus jHexView$DefinitionStatus) {
        this.m_status = (JHexView$DefinitionStatus)((Object)Preconditions.checkNotNull((Object)jHexView$DefinitionStatus, "Error: Definition status can't be null"));
        this.repaint();
    }

    @Override
    public void setEnabled(boolean bl2) {
        if (bl2 == this.m_enabled) {
            return;
        }
        this.m_enabled = bl2;
        this.repaint();
    }

    public void setFlipBytes(boolean bl2) {
        if (this.m_flipBytes == bl2) {
            return;
        }
        this.m_flipBytes = bl2;
        this.repaint();
    }

    public void setFontColorAsciiView(Color color) {
        this.m_fontColorAscii = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setFontColorHexView1(Color color) {
        this.m_fontColorHex1 = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setFontColorHexView2(Color color) {
        this.m_fontColorHex2 = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setFontColorOffsetView(Color color) {
        this.m_fontColorOffsets = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setFontSize(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: Font size must be positive");
        this.m_font = new Font(GuiHelper.getMonospaceFont(), 0, n2);
        this.setFont(this.m_font);
        this.m_firstDraw = true;
        this.repaint();
    }

    public void setHexViewWidth(int n2) {
        Preconditions.checkArgument(n2 > 0, "Error: Width must be positive");
        this.m_hexViewWidth = n2;
        this.repaint();
    }

    public void setMenuCreator(IMenuCreator iMenuCreator) {
        this.m_menuCreator = iMenuCreator;
    }

    public void setSelectionColor(Color color) {
        this.m_selectionColor = (Color)Preconditions.checkNotNull(color, "Error: Color can't be null");
        this.repaint();
    }

    public void setSelectionLength(long l2) {
        this.m_selectionLength = l2;
        Iterator iterator = this.m_listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                this.repaint();
                return;
            }
            IHexPanelListener iHexPanelListener = (IHexPanelListener)iterator.next();
            iHexPanelListener.selectionChanged(this.m_selectionStart, this.m_selectionLength);
        } while (true);
    }

    public void uncolorize(int n2, long l2, int n3) {
        Preconditions.checkArgument(l2 >= 0, "Error: Offset can't be negative");
        Preconditions.checkArgument(n3 > 0, "Error: Size must be positive");
        Preconditions.checkArgument(n2 >= 0 && n2 < this.m_coloredRanges.length, "Error: Invalid level");
        this.m_coloredRanges[n2].removeRange(l2, n3);
        this.repaint();
    }

    public void uncolorizeAll() {
        ColoredRangeManager[] arrcoloredRangeManager = this.m_coloredRanges;
        int n2 = arrcoloredRangeManager.length;
        int n3 = 0;
        while (n3 < n2) {
            ColoredRangeManager coloredRangeManager = arrcoloredRangeManager[n3];
            coloredRangeManager.clear();
            ++n3;
        }
    }

    public void uncolorizeAll(int n2) {
        this.m_coloredRanges[n2].clear();
        this.repaint();
    }

    static /* synthetic */ int access$900(JHexView jHexView) {
        return jHexView.m_bytesPerRow;
    }

    static /* synthetic */ void access$1000(JHexView jHexView, ActionEvent actionEvent, int n2) {
        jHexView.changeBy(actionEvent, n2);
    }

    static /* synthetic */ IDataProvider access$1100(JHexView jHexView) {
        return jHexView.m_dataProvider;
    }

    static /* synthetic */ long access$1200(JHexView jHexView) {
        return jHexView.getSelectionStart();
    }

    static /* synthetic */ void access$1300(JHexView jHexView, long l2) {
        jHexView.setSelectionStart(l2);
    }

    static /* synthetic */ long access$1400(JHexView jHexView) {
        return jHexView.m_baseAddress;
    }

    static /* synthetic */ JScrollBar access$1500(JHexView jHexView) {
        return jHexView.m_scrollbar;
    }

    static /* synthetic */ int access$1602(JHexView jHexView, int n2) {
        jHexView.m_firstRow = n2;
        return jHexView.m_firstRow;
    }

    static /* synthetic */ int access$1702(JHexView jHexView, int n2) {
        jHexView.m_firstColumn = n2;
        return jHexView.m_firstColumn;
    }

    static /* synthetic */ void access$1800(JHexView jHexView) {
        jHexView.setScrollBarMaximum();
    }

    static /* synthetic */ JScrollBar access$1900(JHexView jHexView) {
        return jHexView.m_horizontalScrollbar;
    }

    static /* synthetic */ BufferedImage access$2002(JHexView jHexView, BufferedImage bufferedImage) {
        jHexView.img = bufferedImage;
        return jHexView.img;
    }

    static /* synthetic */ Graphics access$2102(JHexView jHexView, Graphics graphics) {
        jHexView.bufferGraphics = graphics;
        return jHexView.bufferGraphics;
    }

    static /* synthetic */ BufferedImage access$2000(JHexView jHexView) {
        return jHexView.img;
    }

    static /* synthetic */ JCaret access$2200(JHexView jHexView) {
        return jHexView.m_caret;
    }

    static /* synthetic */ JHexView$Views access$2300(JHexView jHexView) {
        return jHexView.m_activeView;
    }

    static /* synthetic */ int access$2400(JHexView jHexView) {
        return jHexView.m_rowHeight;
    }

    static /* synthetic */ int access$2500(JHexView jHexView) {
        return jHexView.m_charHeight;
    }

    static /* synthetic */ int access$2600(JHexView jHexView) {
        return jHexView.getFirstVisibleByte();
    }

    static /* synthetic */ void access$2700(JHexView jHexView, long l2) {
        jHexView.scrollToPosition(l2);
    }

    static /* synthetic */ int access$2800(JHexView jHexView) {
        return jHexView.getNumberOfVisibleRows();
    }

    static /* synthetic */ int access$2900(JHexView jHexView, int n2, int n3) {
        return jHexView.getNibbleAtCoordinate(n2, n3);
    }

    static /* synthetic */ int access$3002(JHexView jHexView, int n2) {
        jHexView.m_lastMouseX = n2;
        return jHexView.m_lastMouseX;
    }

    static /* synthetic */ int access$3102(JHexView jHexView, int n2) {
        jHexView.m_lastMouseY = n2;
        return jHexView.m_lastMouseY;
    }

    static /* synthetic */ long access$3202(JHexView jHexView, long l2) {
        jHexView.m_selectionLength = l2;
        return jHexView.m_selectionLength;
    }

    static /* synthetic */ void access$3300(JHexView jHexView, long l2) {
        jHexView.setCurrentPosition(l2);
    }

    static /* synthetic */ boolean access$3400(JHexView jHexView, int n2, int n3) {
        return jHexView.isInsideHexView(n2, n3);
    }

    static /* synthetic */ JHexView$Views access$2302(JHexView jHexView, JHexView$Views jHexView$Views) {
        jHexView.m_activeView = jHexView$Views;
        return jHexView.m_activeView;
    }

    static /* synthetic */ boolean access$3500(JHexView jHexView, int n2, int n3) {
        return jHexView.isInsideAsciiView(n2, n3);
    }

    static /* synthetic */ ArrayList access$3600(JHexView jHexView) {
        return jHexView.m_listeners;
    }

    static /* synthetic */ long access$3700(JHexView jHexView) {
        return jHexView.m_selectionStart;
    }

    static /* synthetic */ long access$3200(JHexView jHexView) {
        return jHexView.m_selectionLength;
    }

    static /* synthetic */ IMenuCreator access$3800(JHexView jHexView) {
        return jHexView.m_menuCreator;
    }
}

