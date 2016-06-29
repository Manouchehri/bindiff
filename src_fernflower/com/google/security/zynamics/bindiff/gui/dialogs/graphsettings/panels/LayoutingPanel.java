package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.LayoutingPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public final class LayoutingPanel extends JPanel {
   private static final int LABEL_WIDTH = 275;
   private static final int ROW_HEIGHT = 25;
   private static final int NUMBER_OF_ROWS = 2;
   private final JComboBox initalLayout = new JComboBox();
   private final JComboBox autoLayouting = new JComboBox();
   private final ESettingsDialogType dialogType;
   private final GraphSettings settings;

   public LayoutingPanel(String var1, ESettingsDialogType var2) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      if(var2 != null && var2 != ESettingsDialogType.NON_INITIAL) {
         this.dialogType = var2;
         this.settings = null;
         this.init(var1);
      } else {
         throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
      }
   }

   public LayoutingPanel(String var1, ESettingsDialogType var2, GraphSettings var3) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      if(var2 != null && var2 == ESettingsDialogType.NON_INITIAL) {
         this.dialogType = var2;
         this.settings = var3;
         this.init(var1);
      } else {
         throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
      }
   }

   private boolean getAutoLayouting(BinDiffConfigFile var1) {
      switch(LayoutingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getAutoLayouting();
      case 2:
         return var1.getInitialFlowgraphSettings().getAutoLayouting();
      default:
         return this.settings.getLayoutSettings().getAutomaticLayouting();
      }
   }

   private EGraphLayout getDefaultGraphLayout(BinDiffConfigFile var1) {
      switch(LayoutingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return EGraphLayout.getEnum(var1.getInitialCallgraphSettings().getDefaultGraphLayout());
      case 2:
         return EGraphLayout.getEnum(var1.getInitialFlowgraphSettings().getDefaultGraphLayout());
      default:
         return this.settings.getLayoutSettings().getDefaultGraphLayout();
      }
   }

   private void init(String var1) {
      this.setBorder(new LineBorder(Color.GRAY));
      this.initalLayout.addItem("Hierarchical");
      this.initalLayout.addItem("Orthogonal");
      this.initalLayout.addItem("Circular");
      this.autoLayouting.addItem("On");
      this.autoLayouting.addItem("Off");
      this.setCurrentValues();
      JPanel var2 = new JPanel(new GridLayout(2, 1, 5, 5));
      var2.setBorder(new TitledBorder(var1));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Default layout", 275, this.initalLayout, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic layouting", 275, this.autoLayouting, 25));
      this.add(var2, "North");
   }

   public boolean getAutoLayouting() {
      return this.autoLayouting.getSelectedIndex() == 0;
   }

   public EGraphLayout getDefaultLayout() {
      return EGraphLayout.getEnum(this.initalLayout.getSelectedIndex());
   }

   public void getDefaultLayout(EGraphLayout var1) {
      this.initalLayout.setSelectedIndex(EGraphLayout.getOrdinal(var1));
   }

   public void setAutoLayouting(boolean var1) {
      this.autoLayouting.setSelectedIndex(var1?0:1);
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      this.initalLayout.setSelectedIndex(EGraphLayout.getOrdinal(this.getDefaultGraphLayout(var1)));
      this.autoLayouting.setSelectedIndex(this.getAutoLayouting(var1)?0:1);
   }
}
