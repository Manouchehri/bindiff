package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import y.h.*;
import java.awt.*;

public class GraphOverviewPanel extends JPanel
{
    private static final float DEFAULT_FOG_COLOR = 0.9f;
    private static final int DEFAULT_SIZE = 200;
    
    public GraphOverviewPanel(final ch ch) {
        super(new BorderLayout());
        Preconditions.checkNotNull(ch, (Object)"View argument can not be null");
        this.setBorder(new TitledBorder(""));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        final ZyOverview zyOverview = new ZyOverview(ch);
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
        panel.add(zyOverview, "Center");
        this.add(panel, "Center");
    }
}
