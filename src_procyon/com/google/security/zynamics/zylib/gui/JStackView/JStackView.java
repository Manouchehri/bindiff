package com.google.security.zynamics.zylib.gui.JStackView;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.JHexPanel.*;

public final class JStackView extends JPanel
{
    private static final long serialVersionUID = -7850318708757157383L;
    private final JScrollBar m_scrollbar;
    private final JStackView$InternalListener m_listener;
    private final IStackModel m_model;
    private final JStackPanel m_panel;
    private final JScrollBar m_bottomScrollbar;
    
    public JStackView(final IStackModel model) {
        super(new BorderLayout());
        this.m_scrollbar = new JScrollBar(1, 0, 1, 0, 1);
        this.m_listener = new JStackView$InternalListener(this, null);
        this.m_bottomScrollbar = new JScrollBar(0, 0, 1, 0, 1);
        Preconditions.checkNotNull(model, (Object)"Error: Model argument can not be null");
        this.m_model = model;
        this.add(this.m_panel = new JStackPanel(model));
        this.setFocusable(true);
        this.initScrollbar();
        this.setPreferredSize(new Dimension(400, 400));
        this.m_model.addListener(this.m_listener);
        this.addComponentListener(this.m_listener);
        this.addMouseWheelListener(new JStackView$InternalMouseListener(this, null));
    }
    
    private void initScrollbar() {
        this.m_scrollbar.addAdjustmentListener(this.m_listener);
        this.m_bottomScrollbar.addAdjustmentListener(this.m_listener);
        this.add(this.m_scrollbar, "East");
        this.add(this.m_bottomScrollbar, "South");
    }
    
    private void setCurrentPosition(final long n) {
        this.m_scrollbar.setValue((int)((n - this.m_model.getStartAddress()) / 4L));
        this.m_panel.repaint();
    }
    
    private void setHorizontalScrollBarMaximum() {
        final int n = this.m_panel.getOffsetViewWidth() + 10 + 80;
        final int width = this.getWidth();
        if (width >= n || this.m_panel.getCharWidth() == 0) {
            this.m_bottomScrollbar.setValue(0);
            this.m_bottomScrollbar.setEnabled(false);
        }
        else {
            this.m_bottomScrollbar.setMaximum((n - width) / this.m_panel.getCharWidth() + 1);
            this.m_bottomScrollbar.setEnabled(true);
        }
    }
    
    private void setScrollBarMaximum() {
        int maximum = 2 + this.m_model.getNumberOfEntries() - this.m_panel.getNumberOfVisibleRows();
        if (maximum < 0) {
            maximum = 0;
            this.m_scrollbar.setValue(0);
            this.m_scrollbar.setEnabled(false);
        }
        else {
            this.m_scrollbar.setEnabled(true);
        }
        this.m_scrollbar.setMaximum(maximum);
    }
    
    public String getValueAt(final Point point) {
        return this.m_panel.getValueAt(point);
    }
    
    public void gotoOffset(final long currentPosition) {
        this.setCurrentPosition(currentPosition);
    }
    
    public void setDefinitionStatus(final JHexView$DefinitionStatus definitionStatus) {
        this.m_panel.setDefinitionStatus(definitionStatus);
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        this.m_panel.repaint();
    }
}
