package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.CircularLayoutPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.CDecFormatter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;

public class CircularLayoutPanel extends JPanel {
   private static final int LABEL_WIDTH = 275;
   private static final int ROW_HEIGHT = 25;
   private static final int NUMBER_OF_ROWS = 2;
   private final JComboBox layoutStyle = new JComboBox();
   private final JFormattedTextField minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(3)));
   private final ESettingsDialogType dialogType;
   private final GraphSettings settings;

   public CircularLayoutPanel(String var1, ESettingsDialogType var2) {
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

   public CircularLayoutPanel(String var1, ESettingsDialogType var2, GraphSettings var3) {
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

   private ECircularLayoutStyle getCircularLayoutStyle(BinDiffConfigFile var1) {
      switch(CircularLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return ECircularLayoutStyle.getEnum(var1.getInitialCallgraphSettings().getCircularLayoutStyle());
      case 2:
         return ECircularLayoutStyle.getEnum(var1.getInitialFlowgraphSettings().getCircularLayoutStyle());
      default:
         return this.settings.getLayoutSettings().getCircularLayoutStyle();
      }
   }

   private int getMinimumNodeDistance(BinDiffConfigFile var1) {
      switch(CircularLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getCircularMinimumNodeDistance();
      case 2:
         return var1.getInitialFlowgraphSettings().getCircularMinimumNodeDistance();
      default:
         return (int)this.settings.getLayoutSettings().getMinimumCircularNodeDistance();
      }
   }

   private void init(String var1) {
      this.setBorder(new LineBorder(Color.GRAY));
      this.layoutStyle.addItem("Compact");
      this.layoutStyle.addItem("Isolated");
      this.layoutStyle.addItem("Single Cycle");
      this.setCurrentValues();
      JPanel var2 = new JPanel(new GridLayout(2, 1, 5, 5));
      var2.setBorder(new TitledBorder(var1));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Layout style", 275, this.layoutStyle, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Preferred node distance", 275, this.minimumNodeDistance, 25));
      this.add(var2, "North");
   }

   public ECircularLayoutStyle getCircularLayoutStyle() {
      return ECircularLayoutStyle.getEnum(this.layoutStyle.getSelectedIndex());
   }

   public int getMinimumNodeDistance() {
      return Integer.parseInt(this.minimumNodeDistance.getText());
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      this.layoutStyle.setSelectedIndex(ECircularLayoutStyle.getOrdinal(this.getCircularLayoutStyle(var1)));
      this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(var1)));
   }
}
