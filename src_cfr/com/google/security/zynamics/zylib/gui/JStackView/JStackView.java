/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JStackView.IStackModel;
import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$1;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$InternalListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$InternalMouseListener;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public final class JStackView
extends JPanel {
    private static final long serialVersionUID = -7850318708757157383L;
    private final JScrollBar m_scrollbar = new JScrollBar(1, 0, 1, 0, 1);
    private final JStackView$InternalListener m_listener;
    private final IStackModel m_model;
    private final JStackPanel m_panel;
    private final JScrollBar m_bottomScrollbar;

    public JStackView(IStackModel iStackModel) {
        super(new BorderLayout());
        this.m_listener = new JStackView$InternalListener(this, null);
        this.m_bottomScrollbar = new JScrollBar(0, 0, 1, 0, 1);
        Preconditions.checkNotNull(iStackModel, "Error: Model argument can not be null");
        this.m_model = iStackModel;
        this.m_panel = new JStackPanel(iStackModel);
        this.add(this.m_panel);
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
        this.add((Component)this.m_scrollbar, "East");
        this.add((Component)this.m_bottomScrollbar, "South");
    }

    private void setCurrentPosition(long l2) {
        int n2 = (int)((l2 - this.m_model.getStartAddress()) / 4);
        this.m_scrollbar.setValue(n2);
        this.m_panel.repaint();
    }

    private void setHorizontalScrollBarMaximum() {
        int n2 = this.m_panel.getOffsetViewWidth() + 10 + 80;
        int n3 = this.getWidth();
        if (n3 < n2 && this.m_panel.getCharWidth() != 0) {
            this.m_bottomScrollbar.setMaximum((n2 - n3) / this.m_panel.getCharWidth() + 1);
            this.m_bottomScrollbar.setEnabled(true);
            return;
        }
        this.m_bottomScrollbar.setValue(0);
        this.m_bottomScrollbar.setEnabled(false);
    }

    private void setScrollBarMaximum() {
        int n2 = this.m_panel.getNumberOfVisibleRows();
        int n3 = this.m_model.getNumberOfEntries();
        int n4 = 2 + n3 - n2;
        if (n4 < 0) {
            n4 = 0;
            this.m_scrollbar.setValue(0);
            this.m_scrollbar.setEnabled(false);
        } else {
            this.m_scrollbar.setEnabled(true);
        }
        this.m_scrollbar.setMaximum(n4);
    }

    public String getValueAt(Point point) {
        return this.m_panel.getValueAt(point);
    }

    public void gotoOffset(long l2) {
        this.setCurrentPosition(l2);
    }

    public void setDefinitionStatus(JHexView$DefinitionStatus jHexView$DefinitionStatus) {
        this.m_panel.setDefinitionStatus(jHexView$DefinitionStatus);
    }

    @Override
    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.m_panel.repaint();
    }

    static /* synthetic */ JScrollBar access$200(JStackView jStackView) {
        return jStackView.m_scrollbar;
    }

    static /* synthetic */ JStackPanel access$300(JStackView jStackView) {
        return jStackView.m_panel;
    }

    static /* synthetic */ void access$400(JStackView jStackView) {
        jStackView.setScrollBarMaximum();
    }

    static /* synthetic */ void access$500(JStackView jStackView) {
        jStackView.setHorizontalScrollBarMaximum();
    }
}

