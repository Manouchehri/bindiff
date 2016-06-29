package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$DefinitionStatus;
import com.google.security.zynamics.zylib.gui.JStackView.IStackModel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$1;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$InternalListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$InternalMouseListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public final class JStackView extends JPanel {
   private static final long serialVersionUID = -7850318708757157383L;
   private final JScrollBar m_scrollbar = new JScrollBar(1, 0, 1, 0, 1);
   private final JStackView$InternalListener m_listener = new JStackView$InternalListener(this, (JStackView$1)null);
   private final IStackModel m_model;
   private final JStackPanel m_panel;
   private final JScrollBar m_bottomScrollbar = new JScrollBar(0, 0, 1, 0, 1);

   public JStackView(IStackModel var1) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1, "Error: Model argument can not be null");
      this.m_model = var1;
      this.m_panel = new JStackPanel(var1);
      this.add(this.m_panel);
      this.setFocusable(true);
      this.initScrollbar();
      this.setPreferredSize(new Dimension(400, 400));
      this.m_model.addListener(this.m_listener);
      this.addComponentListener(this.m_listener);
      this.addMouseWheelListener(new JStackView$InternalMouseListener(this, (JStackView$1)null));
   }

   private void initScrollbar() {
      this.m_scrollbar.addAdjustmentListener(this.m_listener);
      this.m_bottomScrollbar.addAdjustmentListener(this.m_listener);
      this.add(this.m_scrollbar, "East");
      this.add(this.m_bottomScrollbar, "South");
   }

   private void setCurrentPosition(long var1) {
      int var3 = (int)((var1 - this.m_model.getStartAddress()) / 4L);
      this.m_scrollbar.setValue(var3);
      this.m_panel.repaint();
   }

   private void setHorizontalScrollBarMaximum() {
      int var1 = this.m_panel.getOffsetViewWidth() + 10 + 80;
      int var2 = this.getWidth();
      if(var2 < var1 && this.m_panel.getCharWidth() != 0) {
         this.m_bottomScrollbar.setMaximum((var1 - var2) / this.m_panel.getCharWidth() + 1);
         this.m_bottomScrollbar.setEnabled(true);
      } else {
         this.m_bottomScrollbar.setValue(0);
         this.m_bottomScrollbar.setEnabled(false);
      }

   }

   private void setScrollBarMaximum() {
      int var1 = this.m_panel.getNumberOfVisibleRows();
      int var2 = this.m_model.getNumberOfEntries();
      int var3 = 2 + var2 - var1;
      if(var3 < 0) {
         var3 = 0;
         this.m_scrollbar.setValue(0);
         this.m_scrollbar.setEnabled(false);
      } else {
         this.m_scrollbar.setEnabled(true);
      }

      this.m_scrollbar.setMaximum(var3);
   }

   public String getValueAt(Point var1) {
      return this.m_panel.getValueAt(var1);
   }

   public void gotoOffset(long var1) {
      this.setCurrentPosition(var1);
   }

   public void setDefinitionStatus(JHexView$DefinitionStatus var1) {
      this.m_panel.setDefinitionStatus(var1);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.m_panel.repaint();
   }

   // $FF: synthetic method
   static JScrollBar access$200(JStackView var0) {
      return var0.m_scrollbar;
   }

   // $FF: synthetic method
   static JStackPanel access$300(JStackView var0) {
      return var0.m_panel;
   }

   // $FF: synthetic method
   static void access$400(JStackView var0) {
      var0.setScrollBarMaximum();
   }

   // $FF: synthetic method
   static void access$500(JStackView var0) {
      var0.setHorizontalScrollBarMaximum();
   }
}
