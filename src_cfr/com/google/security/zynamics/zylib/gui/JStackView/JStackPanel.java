/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JStackView.AddressMode;
import com.google.security.zynamics.zylib.gui.JStackView.IStackModel;
import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$1;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$InternalListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$WaitingForDataAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public final class JStackPanel
extends JPanel {
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

    public JStackPanel(IStackModel iStackModel) {
        super(new BorderLayout());
        this.m_listener = new JStackPanel$InternalListener(this, null);
        this.m_firstRow = 0;
        this.m_fontColorOffsets = Color.WHITE;
        this.m_fontColorValues = Color.BLACK;
        this.m_disabledColor = Color.GRAY;
        this.m_bgColorOffset = Color.GRAY;
        this.m_status = JHexView$DefinitionStatus.UNDEFINED;
        this.m_addressMode = AddressMode.BIT32;
        this.m_firstColumn = 0;
        Preconditions.checkNotNull(iStackModel, "Error: Model argument can not be null");
        this.m_model = iStackModel;
        this.m_model.addListener(this.m_listener);
        this.setFocusable(true);
        this.setFont(this.m_font);
        this.setPreferredSize(new Dimension(400, 400));
    }

    private static int getCharacterWidth(Graphics graphics) {
        return (int)graphics.getFontMetrics().getStringBounds("0", graphics).getWidth();
    }

    private static int getCharHeight(Graphics graphics) {
        return graphics.getFontMetrics().getAscent();
    }

    private static int getRowHeight(Graphics graphics) {
        return graphics.getFontMetrics().getHeight();
    }

    private void calculateSizes(Graphics graphics) {
        this.m_rowHeight = JStackPanel.getRowHeight(graphics);
        this.m_charHeight = JStackPanel.getCharHeight(graphics);
        this.m_charWidth = JStackPanel.getCharacterWidth(graphics);
    }

    private void drawBackground(Graphics graphics) {
        graphics.setColor(this.m_bgColorOffset);
        graphics.fillRect((- this.m_firstColumn) * this.m_charWidth, 0, this.m_offsetViewWidth, this.getHeight());
    }

    private void drawElements(Graphics graphics) {
        if (this.isEnabled()) {
            graphics.setColor(this.m_fontColorValues);
        } else {
            graphics.setColor(this.m_disabledColor != this.m_bgColorOffset ? this.m_disabledColor : Color.WHITE);
        }
        int n2 = 10 + this.m_offsetViewWidth - this.m_charWidth * this.m_firstColumn;
        int n3 = this.getNumberOfVisibleRows();
        if (this.m_firstRow + n3 >= this.m_model.getNumberOfEntries() && (n3 = this.m_model.getNumberOfEntries() - this.m_firstRow) < 0) {
            return;
        }
        if (this.m_model.getStartAddress() == -1) {
            return;
        }
        long l2 = this.getElementSize();
        if (this.m_status == JHexView$DefinitionStatus.DEFINED) {
            long l3;
            long l4 = this.m_model.getStartAddress() + (long)this.m_firstRow * l2;
            if (!this.m_model.hasData(l4, l3 = (long)n3 * l2)) {
                this.setDefinitionStatus(JHexView$DefinitionStatus.UNDEFINED);
                this.setEnabled(false);
                if (this.m_updateTimer != null) {
                    this.m_updateTimer.setRepeats(false);
                    this.m_updateTimer.stop();
                }
                this.m_updateTimer = new Timer(1000, new JStackPanel$WaitingForDataAction(this, l4, l3, null));
                this.m_updateTimer.setRepeats(true);
                this.m_updateTimer.start();
                return;
            }
            int n4 = 0;
            while (n4 < n3) {
                long l5 = l4 + (long)n4 * l2;
                graphics.drawString(this.m_model.getElement(l5), n2, 16 + n4 * this.m_rowHeight);
                ++n4;
            }
            return;
        }
        int n5 = 0;
        while (n5 < n3) {
            graphics.drawString(Strings.repeat("?", 2 * this.getElementSize()), n2, 16 + n5 * this.m_rowHeight);
            ++n5;
        }
    }

    private void drawOffsets(Graphics graphics) {
        int n2 = this.getNumberOfVisibleRows();
        String string = this.m_addressMode == AddressMode.BIT32 ? "%08X" : "%016X";
        long l2 = this.getElementSize();
        long l3 = this.m_model.getStartAddress() == -1 ? 0 : this.m_model.getStartAddress();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = this.m_firstRow + n3;
            long l4 = l3 + (long)n4 * l2;
            String string2 = String.format(string, l4);
            if (l4 == this.m_model.getStackPointer()) {
                this.highlightStackPointer(graphics, n3);
            }
            if (this.isEnabled()) {
                graphics.setColor(this.m_fontColorOffsets);
            } else {
                graphics.setColor(this.m_disabledColor != this.m_bgColorOffset ? this.m_disabledColor : Color.WHITE);
            }
            graphics.drawString(string2, 10 - this.m_charWidth * this.m_firstColumn, 16 + n3 * this.m_rowHeight);
            ++n3;
        }
    }

    private int getElementSize() {
        if (this.m_addressMode != AddressMode.BIT32) return 8;
        return 4;
    }

    private void highlightStackPointer(Graphics graphics, int n2) {
        graphics.setColor(Color.RED);
        double d2 = graphics.getFontMetrics().getStringBounds(Strings.repeat("0", 2 * this.getElementSize()), graphics).getWidth();
        graphics.fillRect(8 - this.m_charWidth * this.m_firstColumn, 16 + n2 * this.m_rowHeight - this.m_charHeight, (int)d2 + 4, this.m_charHeight + 2);
    }

    private void updateOffsetViewWidth() {
        int n2 = this.m_addressMode == AddressMode.BIT32 ? 8 : 16;
        this.m_offsetViewWidth = 20 + this.m_charWidth * n2;
    }

    private void updatePreferredSize() {
        int n2 = this.m_offsetViewWidth + 10 + 18 * this.m_charWidth;
        this.setPreferredSize(new Dimension(n2, this.getHeight()));
        this.revalidate();
    }

    protected int getNumberOfVisibleRows() {
        int n2;
        if (this.m_rowHeight == 0) {
            return 0;
        }
        int n3 = this.getHeight() - 16;
        if (n3 % this.m_rowHeight == 0) {
            n2 = 0;
            return n3 / this.m_rowHeight + n2;
        }
        n2 = 1;
        return n3 / this.m_rowHeight + n2;
    }

    protected void setFirstRow(int n2) {
        this.m_firstRow = n2;
        this.repaint();
    }

    public int getCharWidth() {
        return this.m_charWidth;
    }

    public int getOffsetViewWidth() {
        return this.m_offsetViewWidth;
    }

    public String getValueAt(Point point) {
        int n2 = (point.y - 16 + this.m_rowHeight) / this.m_rowHeight;
        long l2 = this.getElementSize();
        long l3 = this.m_model.getStartAddress() + (long)this.m_firstRow * l2;
        long l4 = l3 + (long)n2 * l2;
        if (!this.m_model.hasData(l4, l2)) return null;
        String string = this.m_model.getElement(l4);
        return string;
    }

    public void gotoOffset(long l2) {
    }

    @Override
    public void paint(Graphics graphics) {
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

    public void setDefinitionStatus(JHexView$DefinitionStatus jHexView$DefinitionStatus) {
        Preconditions.checkNotNull((Object)jHexView$DefinitionStatus, "Error: Status argument can not be null");
        this.m_status = jHexView$DefinitionStatus;
        this.repaint();
    }

    public void setFirstColumn(int n2) {
        this.m_firstColumn = n2;
    }

    static /* synthetic */ IStackModel access$200(JStackPanel jStackPanel) {
        return jStackPanel.m_model;
    }
}

