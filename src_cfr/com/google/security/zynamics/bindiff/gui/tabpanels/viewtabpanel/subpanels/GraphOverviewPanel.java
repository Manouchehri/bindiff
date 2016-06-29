/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyOverview;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import y.h.cd;
import y.h.ch;

public class GraphOverviewPanel
extends JPanel {
    private static final float DEFAULT_FOG_COLOR = 0.9f;
    private static final int DEFAULT_SIZE = 200;

    public GraphOverviewPanel(ch ch2) {
        super(new BorderLayout());
        Preconditions.checkNotNull(ch2, "View argument can not be null");
        this.setBorder(new TitledBorder(""));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        ZyOverview zyOverview = new ZyOverview(ch2);
        zyOverview.setGraph2DRenderer(new ZyGraphLayeredRenderer(zyOverview));
        zyOverview.setDrawingMode(0);
        zyOverview.putClientProperty("Overview.AnimateScrollTo", Boolean.TRUE);
        zyOverview.putClientProperty("Overview.AllowZooming", Boolean.TRUE);
        zyOverview.putClientProperty("Overview.AllowKeyboardNavigation", Boolean.TRUE);
        zyOverview.putClientProperty("Overview.Inverse", Boolean.TRUE);
        zyOverview.putClientProperty("Overview.BorderColor", Color.BLACK);
        zyOverview.putClientProperty("Overview.funkyTheta", new Double(0.92));
        zyOverview.putClientProperty("Overview.FogColor", new Color(0.9f, 0.9f, 0.9f, 0.3f));
        zyOverview.setAntialiasedPainting(true);
        zyOverview.setDoubleBuffered(true);
        zyOverview.setPreferredSize(new Dimension(200, 200));
        zyOverview.setMinimumSize(new Dimension(0, 0));
        jPanel.add((Component)zyOverview, "Center");
        this.add((Component)jPanel, "Center");
    }
}

