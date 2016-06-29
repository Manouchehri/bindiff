package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EOrthogonalLayoutStyle;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.OrthogonalLayoutPanel$1;
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

public class OrthogonalLayoutPanel extends JPanel {
   private static final int LABEL_WIDTH = 275;
   private static final int ROW_HEIGHT = 25;
   private static final int NUMBER_OF_ROWS = 3;
   private final JComboBox orientation = new JComboBox();
   private final JComboBox layoutStyle = new JComboBox();
   private final JFormattedTextField minimumNodeDistance = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(3)));
   private final ESettingsDialogType dialogType;
   private final GraphSettings settings;

   public OrthogonalLayoutPanel(String var1, ESettingsDialogType var2) {
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

   public OrthogonalLayoutPanel(String var1, ESettingsDialogType var2, GraphSettings var3) {
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

   private int getMinimumNodeDistance(BinDiffConfigFile var1) {
      switch(OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getOrthogonalMinimumNodeDistance();
      case 2:
         return var1.getInitialFlowgraphSettings().getOrthogonalMinimumNodeDistance();
      default:
         return (int)this.settings.getLayoutSettings().getMinimumOrthogonalNodeDistance();
      }
   }

   private EOrthogonalLayoutStyle getOrthogonalLayoutStyle(BinDiffConfigFile var1) {
      switch(OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return EOrthogonalLayoutStyle.getEnum(var1.getInitialCallgraphSettings().getOrthogonalLayoutStyle());
      case 2:
         return EOrthogonalLayoutStyle.getEnum(var1.getInitialFlowgraphSettings().getOrthogonalLayoutStyle());
      default:
         return this.settings.getLayoutSettings().getOrthogonalLayoutStyle();
      }
   }

   private ELayoutOrientation getOrthogonalOrientation(BinDiffConfigFile var1) {
      switch(OrthogonalLayoutPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return ELayoutOrientation.getEnum(var1.getInitialCallgraphSettings().getOrthogonalOrientation());
      case 2:
         return ELayoutOrientation.getEnum(var1.getInitialFlowgraphSettings().getOrthogonalOrientation());
      default:
         return this.settings.getLayoutSettings().getOrthogonalLayoutOrientation();
      }
   }

   private void init(String var1) {
      this.setBorder(new LineBorder(Color.GRAY));
      this.layoutStyle.addItem("Normal");
      this.layoutStyle.addItem("Tree");
      this.orientation.addItem("Horizontal");
      this.orientation.addItem("Vertical");
      this.setCurrentValues();
      JPanel var2 = new JPanel(new GridLayout(3, 1, 5, 5));
      var2.setBorder(new TitledBorder(var1));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Layout Style", 275, this.layoutStyle, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Layout orientation", 275, this.orientation, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Minimum node distance", 275, this.minimumNodeDistance, 25));
      this.add(var2, "North");
   }

   public int getMinimumNodeDistance() {
      return Integer.parseInt(this.minimumNodeDistance.getText());
   }

   public EOrthogonalLayoutStyle getOrthogonalLayoutStyle() {
      return EOrthogonalLayoutStyle.getEnum(this.layoutStyle.getSelectedIndex());
   }

   public ELayoutOrientation getOrthogonalOrientation() {
      return ELayoutOrientation.getEnum(this.orientation.getSelectedIndex());
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      this.layoutStyle.setSelectedIndex(EOrthogonalLayoutStyle.getOrdinal(this.getOrthogonalLayoutStyle(var1)));
      this.orientation.setSelectedIndex(ELayoutOrientation.getOrdinal(this.getOrthogonalOrientation(var1)));
      this.minimumNodeDistance.setText(Integer.toString(this.getMinimumNodeDistance(var1)));
   }
}
