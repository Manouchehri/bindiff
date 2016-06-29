package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.JCaret.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import com.google.common.base.*;

public final class JHexView extends JComponent
{
    private static final long serialVersionUID = -2402458562501988128L;
    private static final int CHARACTERS_PER_BYTE = 2;
    private static final String[] HEX_BYTES;
    private static final int PADDING_OFFSETVIEW = 20;
    private static final int NIBBLES_PER_BYTE = 2;
    private final ArrayList m_listeners;
    private IDataProvider m_dataProvider;
    private int m_bytesPerRow;
    private Font m_font;
    private long m_selectionStart;
    private long m_selectionLength;
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
        this.m_listeners = new ArrayList();
        this.m_bytesPerRow = 16;
        this.m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
        this.m_selectionStart = 0L;
        this.m_selectionLength = 0L;
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
        for (int i = 0; i < this.m_coloredRanges.length; ++i) {
            this.m_coloredRanges[i] = new ColoredRangeManager();
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
    
    private void changeBy(final ActionEvent actionEvent, final int n) {
        if (actionEvent.getModifiers() == 1) {
            if (this.getSelectionStart() + this.getSelectionLength() + n < 0L) {
                this.setSelectionLength(-this.getSelectionStart());
            }
            else if (this.getSelectionStart() + this.getSelectionLength() + n < 2 * this.m_dataProvider.getDataLength()) {
                this.setSelectionLength(this.getSelectionLength() + n);
            }
            else {
                this.setSelectionLength(2 * this.m_dataProvider.getDataLength() - this.getSelectionStart());
            }
        }
        else {
            if (this.getSelectionStart() + this.getSelectionLength() + n < 0L) {
                this.setSelectionStart(0L);
            }
            else if (this.getSelectionStart() + this.getSelectionLength() + n < 2 * this.m_dataProvider.getDataLength()) {
                this.setSelectionStart(this.getSelectionStart() + this.getSelectionLength() + n);
            }
            else {
                this.setSelectionStart(2 * this.m_dataProvider.getDataLength());
            }
            this.setSelectionLength(0L);
        }
        final long n2 = this.getSelectionStart() + this.getSelectionLength();
        if (n2 < 2 * this.getFirstVisibleByte()) {
            this.scrollToPosition(n2);
        }
        else if (n2 >= 2 * (this.getFirstVisibleByte() + this.getMaximumVisibleBytes())) {
            this.scrollToPosition(2 * this.getFirstVisibleByte() + 2 * this.m_bytesPerRow + (n2 - 2 * (this.getFirstVisibleByte() + this.getMaximumVisibleBytes())));
        }
        this.m_caret.setVisible(true);
        this.repaint();
    }
    
    private void drawAsciiPanel(final Graphics graphics) {
        if (this.isEnabled()) {
            graphics.setColor(this.m_fontColorAscii);
        }
        else {
            graphics.setColor((this.m_disabledColor != this.m_bgColorAscii) ? this.m_disabledColor : Color.WHITE);
        }
        final int characterWidth = this.getCharacterWidth(graphics);
        int n2;
        final int n = n2 = this.getAsciiViewLeft() + 10;
        int n3 = 16;
        byte[] data = null;
        int n4;
        if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
            n4 = this.getBytesToDraw();
            data = this.m_dataProvider.getData(this.getFirstVisibleOffset(), n4);
        }
        else {
            n4 = this.getMaximumVisibleBytes();
        }
        long firstVisibleOffset = this.getFirstVisibleOffset();
        for (int i = 0; i < n4; ++i, ++firstVisibleOffset) {
            ColoredRange coloredRange = this.findColoredRange(firstVisibleOffset);
            if (coloredRange != null && firstVisibleOffset + n4 < coloredRange.getStart()) {
                coloredRange = null;
            }
            if (i != 0 && i % this.m_bytesPerRow == 0) {
                n2 = n;
                n3 += this.m_rowHeight;
            }
            if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
                final char c = (char)data[i];
                final String value = String.valueOf(Convert.isPrintableCharacter(c) ? c : '.');
                if (this.isEnabled()) {
                    if (this.isSelectedOffset(this.m_flipBytes ? ((firstVisibleOffset & -this.m_bytesPerColumn) + this.m_bytesPerColumn - firstVisibleOffset % this.m_bytesPerColumn - 1L) : firstVisibleOffset)) {
                        graphics.setColor(this.m_selectionColor);
                        graphics.fillRect(n2, n3 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                        graphics.setColor(this.m_fontColorAscii);
                    }
                    else if (coloredRange != null && coloredRange.containsOffset(firstVisibleOffset)) {
                        final Color backgroundColor = coloredRange.getBackgroundColor();
                        if (backgroundColor != null) {
                            graphics.setColor(backgroundColor);
                        }
                        else {
                            System.out.println("FOO");
                        }
                        graphics.fillRect(n2, n3 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                        graphics.setColor(coloredRange.getColor());
                    }
                    else if (this.m_colormap != null && this.m_colormap.colorize(data, i)) {
                        final Color backgroundColor2 = this.m_colormap.getBackgroundColor(data, i);
                        final Color foregroundColor = this.m_colormap.getForegroundColor(data, i);
                        if (backgroundColor2 != null) {
                            graphics.setColor(backgroundColor2);
                            graphics.fillRect(n2, n3 - this.m_charHeight, this.m_charWidth, this.m_charHeight + 2);
                        }
                        if (foregroundColor != null) {
                            graphics.setColor(foregroundColor);
                        }
                    }
                    else {
                        graphics.setColor(this.m_fontColorAscii);
                    }
                }
                else {
                    graphics.setColor((this.m_disabledColor != this.m_bgColorAscii) ? this.m_disabledColor : Color.WHITE);
                }
                graphics.drawString(value, n2, n3);
            }
            else {
                graphics.drawString("?", n2, n3);
            }
            n2 += characterWidth;
            if (coloredRange != null && coloredRange.getStart() + coloredRange.getSize() <= firstVisibleOffset) {
                final ColoredRange coloredRange2 = this.findColoredRange(firstVisibleOffset);
                if (coloredRange2 != null && firstVisibleOffset + n4 < coloredRange2.getStart()) {}
            }
        }
    }
    
    private void drawBackground(final Graphics graphics) {
        graphics.setColor(this.m_bgColorOffset);
        graphics.fillRect(-this.m_firstColumn * this.m_charWidth, 0, this.m_offsetViewWidth, this.getHeight());
        graphics.setColor(this.m_bgColorHex);
        graphics.fillRect(-this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth, 0, this.m_hexViewWidth, this.getHeight());
        graphics.setColor(this.m_bgColorAscii);
        graphics.fillRect(-this.m_firstColumn * this.m_charWidth + this.m_hexViewWidth + this.m_offsetViewWidth, 0, this.m_firstColumn * this.m_charWidth + this.getWidth() - (this.m_hexViewWidth + this.m_offsetViewWidth) - this.m_scrollbar.getWidth(), this.getHeight() - this.m_horizontalScrollbar.getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawLine(-this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth, 0, -this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth, this.getHeight());
        graphics.drawLine(-this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth + this.m_hexViewWidth, 0, -this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth + this.m_hexViewWidth, this.getHeight());
    }
    
    private void drawCaret(final Graphics graphics) {
        if (!this.isEnabled()) {
            return;
        }
        if (this.getCurrentOffset() < this.getFirstVisibleByte() || this.getCurrentColumn() > this.getFirstVisibleByte() + this.getMaximumVisibleBytes()) {
            return;
        }
        final int characterWidth = this.getCharacterWidth(graphics);
        if (this.m_activeView == JHexView$Views.HEX_VIEW) {
            this.drawCaretHexWindow(graphics, characterWidth, this.m_rowHeight);
        }
        else {
            this.drawCaretAsciiWindow(graphics, characterWidth, this.m_rowHeight);
        }
    }
    
    private void drawCaretAsciiWindow(final Graphics graphics, final int n, final int n2) {
        this.m_caret.draw(graphics, -this.m_firstColumn * this.m_charWidth + (9 + this.m_offsetViewWidth + this.m_hexViewWidth) + this.getCurrentColumn() / 2 * n, 19 - n2 + n2 * (this.getCurrentRow() - this.m_firstRow), n2);
    }
    
    private void drawCaretHexWindow(final Graphics graphics, final int n, final int n2) {
        final int n3 = this.getCurrentRow() - this.m_firstRow;
        final int currentColumn = this.getCurrentColumn();
        this.m_caret.draw(graphics, -this.m_firstColumn * this.m_charWidth + (9 + this.m_offsetViewWidth) + currentColumn * n + currentColumn / (2 * this.m_bytesPerColumn) * this.m_columnSpacing, 19 - n2 + n2 * n3, n2);
    }
    
    private void drawHexView(final Graphics graphics) {
        final int n = 2 * this.getCharacterWidth(graphics);
        int n3;
        final int n2 = n3 = -this.m_firstColumn * this.m_charWidth + 10 + this.m_offsetViewWidth;
        int n4 = 16;
        boolean b = true;
        byte[] data = null;
        int n5;
        if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
            n5 = this.getBytesToDraw();
            data = this.m_dataProvider.getData(this.getFirstVisibleOffset(), n5);
        }
        else {
            n5 = this.getMaximumVisibleBytes();
        }
        long firstVisibleOffset = this.getFirstVisibleOffset();
        for (int i = 0; i < n5; ++i, ++firstVisibleOffset) {
            final ColoredRange coloredRange = this.findColoredRange(firstVisibleOffset);
            if (i != 0) {
                if (i % this.m_bytesPerRow == 0) {
                    n3 = n2;
                    n4 += this.m_rowHeight;
                    b = true;
                }
                else if (i % this.m_bytesPerColumn == 0) {
                    n3 += this.m_columnSpacing;
                    b = !b;
                }
            }
            if (this.isEnabled()) {
                if (this.isSelectedOffset(firstVisibleOffset)) {
                    graphics.setColor(this.m_selectionColor);
                    graphics.fillRect(n3, n4 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                    graphics.setColor(b ? this.m_fontColorHex1 : this.m_fontColorHex2);
                }
                else if (coloredRange != null && coloredRange.containsOffset(firstVisibleOffset)) {
                    final Color backgroundColor = coloredRange.getBackgroundColor();
                    if (backgroundColor != null) {
                        graphics.setColor(backgroundColor);
                    }
                    graphics.fillRect(n3, n4 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                    if (coloredRange.getColor() != null) {
                        graphics.setColor(coloredRange.getColor());
                    }
                    else {
                        graphics.setColor(b ? this.m_fontColorHex1 : this.m_fontColorHex2);
                    }
                }
                else if (this.m_colormap != null && this.m_colormap.colorize(data, i)) {
                    final Color backgroundColor2 = this.m_colormap.getBackgroundColor(data, i);
                    final Color foregroundColor = this.m_colormap.getForegroundColor(data, i);
                    if (backgroundColor2 != null) {
                        graphics.setColor(backgroundColor2);
                        graphics.fillRect(n3, n4 - this.m_charHeight, 2 * this.m_charWidth, this.m_charHeight + 2);
                    }
                    if (foregroundColor != null) {
                        graphics.setColor(foregroundColor);
                    }
                }
                else {
                    graphics.setColor(b ? this.m_fontColorHex1 : this.m_fontColorHex2);
                }
            }
            else {
                graphics.setColor((this.m_disabledColor != this.m_bgColorHex) ? this.m_disabledColor : Color.WHITE);
            }
            if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
                final int min = Math.min(this.m_dataProvider.getDataLength() - i, this.m_bytesPerColumn);
                graphics.drawString(JHexView.HEX_BYTES[data[this.m_flipBytes ? (i / this.m_bytesPerColumn * this.m_bytesPerColumn + (min - i % min - 1)) : i] & 0xFF], n3, n4);
            }
            else {
                graphics.drawString("??", n3, n4);
            }
            n3 += n;
        }
    }
    
    private void drawMouseOverHighlighting(final Graphics graphics) {
        graphics.setColor(this.m_colorHighlight);
        this.m_lastHighlightedNibble = this.getNibbleAtCoordinate(this.m_lastMouseX, this.m_lastMouseY);
        if (this.m_lastHighlightedNibble == -1) {
            return;
        }
        final JHexView$Views hexView$Views = (this.m_lastMouseX >= this.getAsciiViewLeft()) ? JHexView$Views.ASCII_VIEW : JHexView$Views.HEX_VIEW;
        if (hexView$Views == JHexView$Views.HEX_VIEW) {
            final Rectangle nibbleBoundsHex = this.getNibbleBoundsHex(this.m_lastHighlightedNibble);
            graphics.fillRect((int)nibbleBoundsHex.getX(), (int)nibbleBoundsHex.getY(), (int)nibbleBoundsHex.getWidth(), (int)nibbleBoundsHex.getHeight());
        }
        else if (hexView$Views == JHexView$Views.ASCII_VIEW) {
            final int n = 2 * this.m_lastHighlightedNibble / 2;
            final Rectangle nibbleBoundsHex2 = this.getNibbleBoundsHex(n);
            graphics.fillRect((int)nibbleBoundsHex2.getX(), (int)nibbleBoundsHex2.getY(), (int)nibbleBoundsHex2.getWidth(), (int)nibbleBoundsHex2.getHeight());
            final Rectangle nibbleBoundsHex3 = this.getNibbleBoundsHex(n + 1);
            graphics.fillRect((int)nibbleBoundsHex3.getX(), (int)nibbleBoundsHex3.getY(), (int)nibbleBoundsHex3.getWidth(), (int)nibbleBoundsHex3.getHeight());
        }
        final Rectangle byteBoundsAscii = this.getByteBoundsAscii(this.m_lastHighlightedNibble);
        graphics.fillRect((int)byteBoundsAscii.getX(), (int)byteBoundsAscii.getY(), (int)byteBoundsAscii.getWidth(), (int)byteBoundsAscii.getHeight());
    }
    
    private void drawOffsets(final Graphics graphics) {
        if (this.isEnabled()) {
            graphics.setColor(this.m_fontColorOffsets);
        }
        else {
            graphics.setColor((this.m_disabledColor != this.m_bgColorOffset) ? this.m_disabledColor : Color.WHITE);
        }
        final int n = -this.m_firstColumn * this.m_charWidth + 10;
        final int maximumVisibleBytes = this.getMaximumVisibleBytes();
        final String s = (this.m_addressMode == JHexView$AddressMode.BIT32) ? "%08X" : "%016X";
        for (int i = 0; i < maximumVisibleBytes; i += this.m_bytesPerRow) {
            graphics.drawString(String.format(s, this.m_baseAddress + this.m_firstRow * this.m_bytesPerRow + i), n, 16 + i / this.m_bytesPerRow * this.m_rowHeight);
        }
    }
    
    private ColoredRange findColoredRange(final long n) {
        final ColoredRangeManager[] coloredRanges = this.m_coloredRanges;
        for (int length = coloredRanges.length, i = 0; i < length; ++i) {
            final ColoredRange rangeWith = coloredRanges[i].findRangeWith(n);
            if (rangeWith != null) {
                return rangeWith;
            }
        }
        return null;
    }
    
    private int getAsciiViewLeft() {
        return this.getHexViewLeft() + this.getHexViewWidth();
    }
    
    private Rectangle getByteBoundsAscii(final int n) {
        if (n < 2 * this.getFirstVisibleByte()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        if (n > 2 * this.getFirstVisibleByte() + 2 * this.getMaximumVisibleBytes()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        final int n2 = (n - 2 * this.getFirstVisibleByte()) / 2;
        return new Rectangle(this.getAsciiViewLeft() + 10 + n2 % this.m_bytesPerRow * this.m_charWidth, 16 - this.m_charHeight + n2 / this.m_bytesPerRow * this.m_rowHeight, this.m_charWidth, this.m_charHeight);
    }
    
    private int getBytesToDraw() {
        return Math.min(this.getMaximumVisibleBytes(), this.m_dataProvider.getDataLength() - this.getFirstVisibleByte());
    }
    
    private int getCharacterWidth(final Graphics graphics) {
        return (int)graphics.getFontMetrics().getStringBounds("0", graphics).getWidth();
    }
    
    private int getCharHeight(final Graphics graphics) {
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
        return -this.m_firstColumn * this.m_charWidth + this.m_offsetViewWidth;
    }
    
    private int getMaximumVisibleBytes() {
        return this.getNumberOfVisibleRows() * this.m_bytesPerRow;
    }
    
    private int getNibbleAtCoordinate(final int n, final int n2) {
        if (this.m_dataProvider == null) {
            return -1;
        }
        if (n < this.getHexViewLeft() + 10) {
            return -1;
        }
        if (n2 >= 16 - this.m_font.getSize()) {
            if (n >= this.getHexViewLeft() && n < this.getHexViewLeft() + this.getHexViewWidth()) {
                return this.getNibbleAtCoordinatesHex(n, n2);
            }
            if (n >= this.getAsciiViewLeft()) {
                return this.getNibbleAtCoordinatesAscii(n, n2);
            }
        }
        return -1;
    }
    
    private int getNibbleAtCoordinatesAscii(final int n, final int n2) {
        final int n3 = n - (this.getAsciiViewLeft() + 10);
        if (n3 < 0) {
            return -1;
        }
        final int n4 = (n2 - (16 - this.m_charHeight)) / this.m_rowHeight;
        final int n5 = 2 * this.getEarlierBytes();
        if (n3 / this.m_charWidth >= this.m_bytesPerRow) {
            return -1;
        }
        final int n6 = n5 + 2 * n4 * this.m_bytesPerRow + 2 * (n3 / this.m_charWidth);
        if (n6 >= 2 * this.m_dataProvider.getDataLength()) {
            return -1;
        }
        return n6;
    }
    
    private int getNibbleAtCoordinatesHex(final int n, final int n2) {
        final int n3 = n - (this.getHexViewLeft() + 10);
        final int columnSize = this.getColumnSize();
        final int n4 = n3 / columnSize;
        if (n4 >= this.m_bytesPerRow / this.m_bytesPerColumn) {
            return -1;
        }
        final int n5 = n3 % columnSize / this.m_charWidth;
        if (n5 >= 2 * this.m_bytesPerColumn) {
            return -1;
        }
        final int n6 = 2 * this.getEarlierBytes() + 2 * ((n2 - (16 - this.m_charHeight)) / this.m_rowHeight * this.m_bytesPerRow + n4 * this.m_bytesPerColumn) + n5;
        if (n6 >= 2 * this.m_dataProvider.getDataLength()) {
            return -1;
        }
        return n6;
    }
    
    private Rectangle getNibbleBoundsHex(final int n) {
        if (n < 2 * this.getFirstVisibleByte()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        if (n > 2 * this.getFirstVisibleByte() + 2 * this.getMaximumVisibleBytes()) {
            return new Rectangle(-1, -1, -1, -1);
        }
        final int n2 = n - 2 * this.getFirstVisibleByte();
        return new Rectangle(this.getHexViewLeft() + 10 + n2 % (2 * this.m_bytesPerRow) / (2 * this.m_bytesPerColumn) * this.getColumnSize() + n2 % (2 * this.m_bytesPerRow) % (2 * this.m_bytesPerColumn) * this.m_charWidth, 16 - this.m_charHeight + n2 / (2 * this.m_bytesPerRow) * this.m_rowHeight, this.m_charWidth, this.m_charHeight);
    }
    
    private int getNumberOfVisibleRows() {
        final int n = this.getHeight() - 16 - this.m_horizontalScrollbar.getHeight();
        return n / this.m_rowHeight + ((n % this.m_rowHeight != 0) ? 1 : 0);
    }
    
    private int getRowHeight(final Graphics graphics) {
        return graphics.getFontMetrics().getHeight();
    }
    
    private long getSelectionStart() {
        return this.m_selectionStart;
    }
    
    private void initHotkeys() {
        this.setFocusTraversalKeys(0, new HashSet<AWTKeyStroke>());
        final InputMap inputMap = this.getInputMap();
        final ActionMap actionMap = this.getActionMap();
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
        this.add(this.m_scrollbar, "East");
        this.m_horizontalScrollbar.addAdjustmentListener(this.m_listener);
        this.add(this.m_horizontalScrollbar, "South");
    }
    
    private boolean isDataAvailable() {
        return this.m_dataProvider != null;
    }
    
    private boolean isInsideAsciiView(final int n, final int n2) {
        return n2 >= 16 - this.m_font.getSize() && n >= this.getAsciiViewLeft();
    }
    
    private boolean isInsideHexView(final int n, final int n2) {
        return n2 >= 16 - this.m_font.getSize() && n >= this.getHexViewLeft() && n < this.getHexViewLeft() + this.getHexViewWidth();
    }
    
    private boolean isPositionVisible(final long n) {
        final int firstVisibleByte = this.getFirstVisibleByte();
        final int n2 = firstVisibleByte + this.getMaximumVisibleBytes();
        return n >= 2 * firstVisibleByte && n <= 2 * n2;
    }
    
    private boolean isSelectedOffset(long n) {
        n -= this.m_baseAddress;
        if (this.getSelectionLength() == 0L) {
            return false;
        }
        if (this.getSelectionLength() > 0L) {
            return n >= this.getSelectionStart() / 2L && 2L * n < this.getSelectionStart() + this.getSelectionLength();
        }
        return n >= (this.getSelectionStart() + this.getSelectionLength()) / 2L && 2L * n < this.getSelectionStart();
    }
    
    private void resetBufferedGraphic() {
        this.bufferGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        this.bufferGraphics.setFont(this.m_font);
    }
    
    private void scrollToPosition(final long n) {
        this.m_scrollbar.setValue((int)n / (2 * this.m_bytesPerRow));
    }
    
    private void setCurrentPosition(final long selectionStart) {
        this.m_selectionStart = selectionStart;
        if (!this.isPositionVisible(this.getSelectionStart())) {
            this.scrollToPosition(this.getSelectionStart());
        }
        final Iterator<IHexPanelListener> iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().selectionChanged(this.getSelectionStart(), 1L);
        }
    }
    
    private void setScrollBarMaximum() {
        if (this.m_dataProvider == null) {
            this.m_scrollbar.setMaximum(1);
            this.m_horizontalScrollbar.setMaximum(1);
        }
        else {
            int maximum = 2 + this.m_dataProvider.getDataLength() / this.m_bytesPerRow - this.getNumberOfVisibleRows();
            if (maximum < 0) {
                maximum = 0;
                this.m_scrollbar.setValue(0);
                this.m_scrollbar.setEnabled(false);
            }
            else {
                this.m_scrollbar.setEnabled(true);
            }
            this.m_scrollbar.setMaximum(maximum);
            final int n = this.getAsciiViewLeft() + 10 + this.m_charWidth * this.m_bytesPerRow;
            final int n2 = this.getWidth() - this.m_scrollbar.getWidth();
            if (n2 >= n) {
                this.m_horizontalScrollbar.setValue(0);
                this.m_horizontalScrollbar.setEnabled(false);
            }
            else {
                this.m_horizontalScrollbar.setMaximum((n - n2) / this.m_charWidth + 1);
                this.m_horizontalScrollbar.setEnabled(true);
            }
        }
    }
    
    private void setSelectionStart(final long selectionStart) {
        this.m_selectionStart = selectionStart;
        final Iterator<IHexPanelListener> iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().selectionChanged(this.m_selectionStart, this.m_selectionLength);
        }
    }
    
    private void updateHexViewWidth() {
        this.m_hexViewWidth = 15 + this.getColumnSize() * this.getBytesPerRow() / this.getBytesPerColumn();
    }
    
    private void updateOffsetViewWidth() {
        this.m_offsetViewWidth = 20 + this.m_charWidth * ((this.m_addressMode == JHexView$AddressMode.BIT32) ? 8 : 16);
    }
    
    private void updatePreferredSize() {
        this.setPreferredSize(new Dimension(this.m_offsetViewWidth + this.m_hexViewWidth + 18 * this.m_charWidth + this.m_scrollbar.getWidth(), this.getHeight()));
        this.revalidate();
    }
    
    @Override
    protected void paintComponent(final Graphics graphics) {
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
        if (this.m_status == JHexView$DefinitionStatus.DEFINED && this.m_dataProvider != null) {
            final int bytesToDraw = this.getBytesToDraw();
            if (bytesToDraw != 0 && !this.m_dataProvider.hasData(this.getFirstVisibleOffset(), bytesToDraw)) {
                this.setDefinitionStatus(JHexView$DefinitionStatus.UNDEFINED);
                this.setEnabled(false);
                if (this.m_updateTimer != null) {
                    this.m_updateTimer.setRepeats(false);
                    this.m_updateTimer.stop();
                }
                (this.m_updateTimer = new Timer(1000, new JHexView$WaitingForDataAction(this, this.getFirstVisibleOffset(), bytesToDraw, null))).setRepeats(true);
                this.m_updateTimer.start();
                return;
            }
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
    
    public void addHexListener(final IHexPanelListener hexPanelListener) {
        Preconditions.checkNotNull(hexPanelListener, (Object)"Error: Listener can't be null");
        if (!this.m_listeners.contains(hexPanelListener)) {
            this.m_listeners.add(hexPanelListener);
        }
    }
    
    public void colorize(final int n, final long n2, final int n3, final Color color, final Color color2) {
        Preconditions.checkArgument(n2 >= 0L, (Object)"Error: offset argument must be greater or equal to zero");
        Preconditions.checkArgument(n3 >= 0, (Object)"Error: size argument must be greater or equal to zero");
        Preconditions.checkArgument(n >= 0 && n < this.m_coloredRanges.length, (Object)"Error: level argument must be greater or equal to zero");
        this.m_coloredRanges[n].addRange(new ColoredRange(n2, n3, color, color2));
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
        final long n = this.m_baseAddress + this.getCurrentNibble() / 2L;
        return this.m_flipBytes ? ((n & -this.m_bytesPerColumn) + this.m_bytesPerColumn - n % this.m_bytesPerColumn - 1L) : n;
    }
    
    public IDataProvider getData() {
        return this.m_dataProvider;
    }
    
    public JHexView$DefinitionStatus getDefinitionStatus() {
        return this.m_status;
    }
    
    public long getFirstSelectedOffset() {
        if (this.m_selectionLength >= 0L) {
            return (this.m_baseAddress + this.m_selectionStart) / 2L;
        }
        return (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) / 2L;
    }
    
    public long getFirstVisibleOffset() {
        return this.getBaseAddress() + this.getFirstVisibleByte();
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
        return this.getBaseAddress() + this.m_dataProvider.getDataLength();
    }
    
    public long getLastSelectedOffset() {
        if (this.m_selectionLength >= 0L) {
            return (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) / 2L + (this.m_baseAddress + this.m_selectionStart + this.m_selectionLength) % 2L;
        }
        return (this.m_baseAddress + this.m_selectionStart) / 2L + (this.m_baseAddress + this.m_selectionStart) % 2L;
    }
    
    public long getSelectionLength() {
        return this.m_selectionLength;
    }
    
    public int getVisibleBytes() {
        final int maximumVisibleBytes = this.getMaximumVisibleBytes();
        if (this.m_dataProvider.getDataLength() - this.getFirstVisibleByte() >= maximumVisibleBytes) {
            return maximumVisibleBytes;
        }
        return this.m_dataProvider.getDataLength() - this.getFirstVisibleByte();
    }
    
    public void gotoOffset(final long n) {
        Preconditions.checkNotNull(this.m_dataProvider, (Object)"Error: No data provider active");
        if (this.getCurrentOffset() == n) {
            if (!this.isPositionVisible(this.getSelectionStart())) {
                this.scrollToPosition(this.getSelectionStart());
            }
            return;
        }
        long n2;
        if (n < this.m_baseAddress) {
            n2 = n;
        }
        else {
            n2 = n - this.m_baseAddress;
        }
        if (n2 < 0L || n2 >= this.m_dataProvider.getDataLength()) {
            throw new IllegalArgumentException("Error: Invalid offset");
        }
        this.setCurrentPosition(2L * n2);
    }
    
    @Override
    public boolean isEnabled() {
        return this.m_enabled;
    }
    
    public void removeHexListener(final IHexPanelListener hexPanelListener) {
        Preconditions.checkNotNull(hexPanelListener, (Object)"Internal Error: Listener can't be null");
        if (!this.m_listeners.remove(hexPanelListener)) {
            throw new IllegalArgumentException("Internal Error: Listener was not listening on object");
        }
    }
    
    public void setAddressMode(final JHexView$AddressMode hexView$AddressMode) {
        this.m_addressMode = (JHexView$AddressMode)Preconditions.checkNotNull(hexView$AddressMode, (Object)"Error: Address mode can't be null");
        this.updateOffsetViewWidth();
        this.updatePreferredSize();
    }
    
    public void setBackgroundColorAsciiView(final Color color) {
        this.m_bgColorAscii = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setBackgroundColorHexView(final Color color) {
        this.m_bgColorHex = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setBackgroundColorOffsetView(final Color color) {
        this.m_bgColorOffset = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setBaseAddress(final long baseAddress) {
        Preconditions.checkArgument(baseAddress >= 0L, (Object)"Error: Base address can't be negative");
        this.m_baseAddress = baseAddress;
        this.repaint();
    }
    
    public void setBytesPerColumn(final int bytesPerColumn) {
        Preconditions.checkArgument(bytesPerColumn > 0, (Object)"Error: Number of bytes must be positive");
        Preconditions.checkArgument(bytesPerColumn <= this.m_bytesPerRow, (Object)"Error: Number of bytes can't be more than the number of bytes per row");
        this.m_bytesPerColumn = bytesPerColumn;
        this.updateHexViewWidth();
        this.updatePreferredSize();
        this.repaint();
    }
    
    public void setBytesPerRow(final int bytesPerRow) {
        Preconditions.checkArgument(bytesPerRow > 0, (Object)"Error: Value must be positive");
        this.m_bytesPerRow = bytesPerRow;
        this.repaint();
    }
    
    public void setColormap(final IColormap colormap) {
        this.m_colormap = (IColormap)Preconditions.checkNotNull(colormap, (Object)"Error: colormap argument can not be null");
        this.repaint();
    }
    
    public void setColumnSpacing(final int columnSpacing) {
        Preconditions.checkArgument(columnSpacing > 0, (Object)"Error: Spacing must be positive");
        this.m_columnSpacing = columnSpacing;
        this.repaint();
    }
    
    public void setCurrentOffset(final long n) {
        if (this.m_dataProvider == null) {
            return;
        }
        Preconditions.checkArgument(n >= this.getBaseAddress() || n <= this.getBaseAddress() + this.m_dataProvider.getDataLength(), (Object)"Error: Invalid offset");
        this.setCurrentPosition(2L * (n - this.m_baseAddress));
    }
    
    public void setData(final IDataProvider dataProvider) {
        if (this.m_dataProvider != null) {
            this.m_dataProvider.removeListener(this.m_listener);
        }
        if ((this.m_dataProvider = dataProvider) != null) {
            this.m_dataProvider.addListener(this.m_listener);
        }
        this.setCurrentPosition(0L);
        this.setScrollBarMaximum();
        this.repaint();
    }
    
    public void setDefinitionStatus(final JHexView$DefinitionStatus hexView$DefinitionStatus) {
        this.m_status = (JHexView$DefinitionStatus)Preconditions.checkNotNull(hexView$DefinitionStatus, (Object)"Error: Definition status can't be null");
        this.repaint();
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        if (enabled == this.m_enabled) {
            return;
        }
        this.m_enabled = enabled;
        this.repaint();
    }
    
    public void setFlipBytes(final boolean flipBytes) {
        if (this.m_flipBytes == flipBytes) {
            return;
        }
        this.m_flipBytes = flipBytes;
        this.repaint();
    }
    
    public void setFontColorAsciiView(final Color color) {
        this.m_fontColorAscii = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setFontColorHexView1(final Color color) {
        this.m_fontColorHex1 = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setFontColorHexView2(final Color color) {
        this.m_fontColorHex2 = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setFontColorOffsetView(final Color color) {
        this.m_fontColorOffsets = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setFontSize(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"Error: Font size must be positive");
        this.setFont(this.m_font = new Font(GuiHelper.getMonospaceFont(), 0, n));
        this.m_firstDraw = true;
        this.repaint();
    }
    
    public void setHexViewWidth(final int hexViewWidth) {
        Preconditions.checkArgument(hexViewWidth > 0, (Object)"Error: Width must be positive");
        this.m_hexViewWidth = hexViewWidth;
        this.repaint();
    }
    
    public void setMenuCreator(final IMenuCreator menuCreator) {
        this.m_menuCreator = menuCreator;
    }
    
    public void setSelectionColor(final Color color) {
        this.m_selectionColor = (Color)Preconditions.checkNotNull(color, (Object)"Error: Color can't be null");
        this.repaint();
    }
    
    public void setSelectionLength(final long selectionLength) {
        this.m_selectionLength = selectionLength;
        final Iterator<IHexPanelListener> iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().selectionChanged(this.m_selectionStart, this.m_selectionLength);
        }
        this.repaint();
    }
    
    public void uncolorize(final int n, final long n2, final int n3) {
        Preconditions.checkArgument(n2 >= 0L, (Object)"Error: Offset can't be negative");
        Preconditions.checkArgument(n3 > 0, (Object)"Error: Size must be positive");
        Preconditions.checkArgument(n >= 0 && n < this.m_coloredRanges.length, (Object)"Error: Invalid level");
        this.m_coloredRanges[n].removeRange(n2, n3);
        this.repaint();
    }
    
    public void uncolorizeAll() {
        final ColoredRangeManager[] coloredRanges = this.m_coloredRanges;
        for (int length = coloredRanges.length, i = 0; i < length; ++i) {
            coloredRanges[i].clear();
        }
    }
    
    public void uncolorizeAll(final int n) {
        this.m_coloredRanges[n].clear();
        this.repaint();
    }
    
    static {
        HEX_BYTES = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF" };
    }
}
