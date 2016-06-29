package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyOverview;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import y.h.ch;

public class GraphOverviewPanel extends JPanel {
   private static final float DEFAULT_FOG_COLOR = 0.9F;
   private static final int DEFAULT_SIZE = 200;

   public GraphOverviewPanel(ch var1) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1, "View argument can not be null");
      this.setBorder(new TitledBorder(""));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
      ZyOverview var3 = new ZyOverview(var1);
      var3.setGraph2DRenderer(new ZyGraphLayeredRenderer(var3));
      var3.setDrawingMode(0);
      var3.putClientProperty("Overview.AnimateScrollTo", Boolean.TRUE);
      var3.putClientProperty("Overview.AllowZooming", Boolean.TRUE);
      var3.putClientProperty("Overview.AllowKeyboardNavigation", Boolean.TRUE);
      var3.putClientProperty("Overview.Inverse", Boolean.TRUE);
      var3.putClientProperty("Overview.BorderColor", Color.BLACK);
      var3.putClientProperty("Overview.funkyTheta", new Double(0.92D));
      var3.putClientProperty("Overview.FogColor", new Color(0.9F, 0.9F, 0.9F, 0.3F));
      var3.setAntialiasedPainting(true);
      var3.setDoubleBuffered(true);
      var3.setPreferredSize(new Dimension(200, 200));
      var3.setMinimumSize(new Dimension(0, 0));
      var2.add(var3, "Center");
      this.add(var2, "Center");
   }
}
