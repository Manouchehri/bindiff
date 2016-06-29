package com.google.security.zynamics.zylib.gui.JStackView;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.JHexPanel.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import com.google.common.base.*;
import java.awt.*;

public final class JStackPanel extends JPanel
{
    private static final long serialVersionUID = -7850318708757157383L;
    private static final int PADDING_OFFSETVIEW = 20;
    private static final int PADDING_LEFT = 10;
    private static final int SIZEOF_DWORD = 4;
    private static final int SIZEOF_QWORD = 8;
    private final IStackModel m_model;
    private final Font m_font;
    private int m_rowHeight;
    private int m_charHeight;
    private int m_charWidth;
    private int m_offsetViewWidth;
    private boolean m_firstDraw;
    private static final int m_hexElementWidth = 10;
    private final JStackPanel$InternalListener m_listener;
    private int m_firstRow;
    private static final int m_paddingTop = 16;
    private final Color m_fontColorOffsets;
    private final Color m_fontColorValues;
    private final Color m_disabledColor;
    private final Color m_bgColorOffset;
    private Timer m_updateTimer;
    private JHexView$DefinitionStatus m_status;
    private final AddressMode m_addressMode;
    private int m_firstColumn;
    
    public JStackPanel(final IStackModel model) {
        super(new BorderLayout());
        this.m_font = new Font(GuiHelper.getMonospaceFont(), 0, 12);
        this.m_firstDraw = true;
        this.m_listener = new JStackPanel$InternalListener(this, null);
        this.m_firstRow = 0;
        this.m_fontColorOffsets = Color.WHITE;
        this.m_fontColorValues = Color.BLACK;
        this.m_disabledColor = Color.GRAY;
        this.m_bgColorOffset = Color.GRAY;
        this.m_status = JHexView$DefinitionStatus.UNDEFINED;
        this.m_addressMode = AddressMode.BIT32;
        this.m_firstColumn = 0;
        Preconditions.checkNotNull(model, (Object)"Error: Model argument can not be null");
        (this.m_model = model).addListener(this.m_listener);
        this.setFocusable(true);
        this.setFont(this.m_font);
        this.setPreferredSize(new Dimension(400, 400));
    }
    
    private static int getCharacterWidth(final Graphics graphics) {
        return (int)graphics.getFontMetrics().getStringBounds("0", graphics).getWidth();
    }
    
    private static int getCharHeight(final Graphics graphics) {
        return graphics.getFontMetrics().getAscent();
    }
    
    private static int getRowHeight(final Graphics graphics) {
        return graphics.getFontMetrics().getHeight();
    }
    
    private void calculateSizes(final Graphics graphics) {
        this.m_rowHeight = getRowHeight(graphics);
        this.m_charHeight = getCharHeight(graphics);
        this.m_charWidth = getCharacterWidth(graphics);
    }
    
    private void drawBackground(final Graphics graphics) {
        graphics.setColor(this.m_bgColorOffset);
        graphics.fillRect(-this.m_firstColumn * this.m_charWidth, 0, this.m_offsetViewWidth, this.getHeight());
    }
    
    private void drawElements(final Graphics graphics) {
        if (this.isEnabled()) {
            graphics.setColor(this.m_fontColorValues);
        }
        else {
            graphics.setColor((this.m_disabledColor != this.m_bgColorOffset) ? this.m_disabledColor : Color.WHITE);
        }
        final int n = 10 + this.m_offsetViewWidth - this.m_charWidth * this.m_firstColumn;
        int numberOfVisibleRows = this.getNumberOfVisibleRows();
        if (this.m_firstRow + numberOfVisibleRows >= this.m_model.getNumberOfEntries()) {
            numberOfVisibleRows = this.m_model.getNumberOfEntries() - this.m_firstRow;
            if (numberOfVisibleRows < 0) {
                return;
            }
        }
        if (this.m_model.getStartAddress() == -1L) {
            return;
        }
        final long n2 = this.getElementSize();
        if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
            final long n3 = this.m_model.getStartAddress() + this.m_firstRow * n2;
            final long n4 = numberOfVisibleRows * n2;
            if (!this.m_model.hasData(n3, n4)) {
                this.setDefinitionStatus(JHexView$DefinitionStatus.UNDEFINED);
                this.setEnabled(false);
                if (this.m_updateTimer != null) {
                    this.m_updateTimer.setRepeats(false);
                    this.m_updateTimer.stop();
                }
                (this.m_updateTimer = new Timer(1000, new JStackPanel$WaitingForDataAction(this, n3, n4, null))).setRepeats(true);
                this.m_updateTimer.start();
                return;
            }
            for (int i = 0; i < numberOfVisibleRows; ++i) {
                graphics.drawString(this.m_model.getElement(n3 + i * n2), n, 16 + i * this.m_rowHeight);
            }
        }
        else {
            for (int j = 0; j < numberOfVisibleRows; ++j) {
                graphics.drawString(Strings.repeat("?", 2 * this.getElementSize()), n, 16 + j * this.m_rowHeight);
            }
        }
    }
    
    private void drawOffsets(final Graphics graphics) {
        final int numberOfVisibleRows = this.getNumberOfVisibleRows();
        final String s = (this.m_addressMode == AddressMode.BIT32) ? "%08X" : "%016X";
        final long n = this.getElementSize();
        final long n2 = (this.m_model.getStartAddress() == -1L) ? 0L : this.m_model.getStartAddress();
        for (int i = 0; i < numberOfVisibleRows; ++i) {
            final long n3 = n2 + (this.m_firstRow + i) * n;
            final String format = String.format(s, n3);
            if (n3 == this.m_model.getStackPointer()) {
                this.highlightStackPointer(graphics, i);
            }
            if (this.isEnabled()) {
                graphics.setColor(this.m_fontColorOffsets);
            }
            else {
                graphics.setColor((this.m_disabledColor != this.m_bgColorOffset) ? this.m_disabledColor : Color.WHITE);
            }
            graphics.drawString(format, 10 - this.m_charWidth * this.m_firstColumn, 16 + i * this.m_rowHeight);
        }
    }
    
    private int getElementSize() {
        return (this.m_addressMode == AddressMode.BIT32) ? 4 : 8;
    }
    
    private void highlightStackPointer(final Graphics graphics, final int n) {
        graphics.setColor(Color.RED);
        graphics.fillRect(8 - this.m_charWidth * this.m_firstColumn, 16 + n * this.m_rowHeight - this.m_charHeight, (int)graphics.getFontMetrics().getStringBounds(Strings.repeat("0", 2 * this.getElementSize()), graphics).getWidth() + 4, this.m_charHeight + 2);
    }
    
    private void updateOffsetViewWidth() {
        this.m_offsetViewWidth = 20 + this.m_charWidth * ((this.m_addressMode == AddressMode.BIT32) ? 8 : 16);
    }
    
    private void updatePreferredSize() {
        this.setPreferredSize(new Dimension(this.m_offsetViewWidth + 10 + 18 * this.m_charWidth, this.getHeight()));
        this.revalidate();
    }
    
    protected int getNumberOfVisibleRows() {
        if (this.m_rowHeight == 0) {
            return 0;
        }
        final int n = this.getHeight() - 16;
        return n / this.m_rowHeight + ((n % this.m_rowHeight != 0) ? 1 : 0);
    }
    
    protected void setFirstRow(final int firstRow) {
        this.m_firstRow = firstRow;
        this.repaint();
    }
    
    public int getCharWidth() {
        return this.m_charWidth;
    }
    
    public int getOffsetViewWidth() {
        return this.m_offsetViewWidth;
    }
    
    public String getValueAt(final Point point) {
        final int n = (point.y - 16 + this.m_rowHeight) / this.m_rowHeight;
        final long n2 = this.getElementSize();
        final long n3 = this.m_model.getStartAddress() + this.m_firstRow * n2 + n * n2;
        return this.m_model.hasData(n3, n2) ? this.m_model.getElement(n3) : null;
    }
    
    public void gotoOffset(final long n) {
    }
    
    @Override
    public void paint(final Graphics graphics) {
        super.paint(graphics);
        this.calculateSizes(graphics);
        this.updateOffsetViewWidth();
        if (this.m_firstDraw) {
            this.m_firstDraw = false;
            this.updatePreferredSize();
        }
        this.drawBackground(graphics);
        this.drawOffsets(graphics);
        this.drawElements(graphics);
    }
    
    public void setDefinitionStatus(final JHexView$DefinitionStatus status) {
        Preconditions.checkNotNull(status, (Object)"Error: Status argument can not be null");
        this.m_status = status;
        this.repaint();
    }
    
    public void setFirstColumn(final int firstColumn) {
        this.m_firstColumn = firstColumn;
    }
}
