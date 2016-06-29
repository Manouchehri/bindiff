package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.components.SliderPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ProximityBrowsingPanel$1;
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

public class ProximityBrowsingPanel extends JPanel {
   private static final int LABEL_WIDTH = 275;
   private static final int ROW_HEIGHT = 25;
   private static final int NUMBER_OF_ROWS = 5;
   private static final int SLIDER_MIN = 0;
   private static final int SLIDER_MAX = 10;
   private static final int SLIDER_LABEL_WIDTH = 25;
   private final JComboBox proximityBrowsing = new JComboBox();
   private final SliderPanel proximityBrowsingParentDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
   private final SliderPanel proximityBrowsingChildDepth = new SliderPanel(0, 0, 10, true, true, false, true, 25, 25);
   private final JFormattedTextField autoProximityBrowsingActivionThreshold = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(5)));
   private final JFormattedTextField visibilityWarningThreshold = new JFormattedTextField(new DefaultFormatterFactory(new CDecFormatter(5)));
   private final ESettingsDialogType dialogType;
   private final GraphSettings settings;

   public ProximityBrowsingPanel(String var1, ESettingsDialogType var2) {
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

   public ProximityBrowsingPanel(String var1, ESettingsDialogType var2, GraphSettings var3) {
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

   private int getAutoProximityBrowsingActivationThreshold(BinDiffConfigFile var1) {
      switch(ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getAutoProximityBrowsingActivationThreshold();
      case 2:
         return var1.getInitialFlowgraphSettings().getAutoProximityBrowsingActivationThreshold();
      default:
         return this.settings.getProximitySettings().getAutoProximityBrowsingActivationThreshold();
      }
   }

   private boolean getProximityBrowsing(BinDiffConfigFile var1) {
      switch(ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getProximityBrowsing();
      case 2:
         return var1.getInitialFlowgraphSettings().getProximityBrowsing();
      default:
         return this.settings.getProximitySettings().getProximityBrowsing();
      }
   }

   private int getProximityBrowsingChildDepth(BinDiffConfigFile var1) {
      switch(ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getProximityBrowsingChildDepth();
      case 2:
         return var1.getInitialFlowgraphSettings().getProximityBrowsingChildDepth();
      default:
         return this.settings.getProximitySettings().getProximityBrowsingChildren();
      }
   }

   private int getProximityBrowsingParentDepth(BinDiffConfigFile var1) {
      switch(ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getProximityBrowsingParentDepth();
      case 2:
         return var1.getInitialFlowgraphSettings().getProximityBrowsingParentDepth();
      default:
         return this.settings.getProximitySettings().getProximityBrowsingParents();
      }
   }

   private int getVisibilityWarningThreshold(BinDiffConfigFile var1) {
      switch(ProximityBrowsingPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getVisibilityWarningThreshold();
      case 2:
         return var1.getInitialFlowgraphSettings().getVisibilityWarningThreshold();
      default:
         return this.settings.getLayoutSettings().getVisibilityWarningThreshold();
      }
   }

   private void init(String var1) {
      this.setBorder(new LineBorder(Color.GRAY));
      this.proximityBrowsing.addItem("On");
      this.proximityBrowsing.addItem("Off");
      this.setCurrentValues();
      int var2 = this.dialogType != ESettingsDialogType.NON_INITIAL?5:3;
      JPanel var3 = new JPanel(new GridLayout(var2, 1, 5, 5));
      var3.setBorder(new TitledBorder(var1));
      if(this.dialogType != ESettingsDialogType.NON_INITIAL) {
         var3.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic proximity browsing", 275, this.proximityBrowsing, 25));
      }

      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Proximity browsing parent depth", 275, this.proximityBrowsingParentDepth, 25));
      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Proximity browsing child depth", 275, this.proximityBrowsingChildDepth, 25));
      if(this.dialogType != ESettingsDialogType.NON_INITIAL) {
         var3.add(GuiUtils.createHorizontalNamedComponentPanel("Automatic proximity browsing activation threshold", 275, this.autoProximityBrowsingActivionThreshold, 25));
      }

      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Visibility Warning threshold", 275, this.visibilityWarningThreshold, 25));
      this.add(var3, "North");
   }

   public void dispose() {
      this.proximityBrowsingParentDepth.dispose();
      this.proximityBrowsingChildDepth.dispose();
   }

   public int getAutoProximityBrowsingActivationThreshold() {
      return Integer.parseInt(this.autoProximityBrowsingActivionThreshold.getText());
   }

   public boolean getProximityBrowsing() {
      return this.proximityBrowsing.getSelectedIndex() == 0;
   }

   public int getProximityBrowsingChildDepth() {
      return this.proximityBrowsingChildDepth.getValue();
   }

   public int getProximityBrowsingParentDepth() {
      return this.proximityBrowsingParentDepth.getValue();
   }

   public int getVisibilityWarningThreshold() {
      return Integer.parseInt(this.visibilityWarningThreshold.getText());
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      this.proximityBrowsing.setSelectedIndex(this.getProximityBrowsing(var1)?0:1);
      this.proximityBrowsingParentDepth.setValue(this.getProximityBrowsingParentDepth(var1));
      this.proximityBrowsingChildDepth.setValue(this.getProximityBrowsingChildDepth(var1));
      this.autoProximityBrowsingActivionThreshold.setText(Integer.toString(this.getAutoProximityBrowsingActivationThreshold(var1)));
      this.visibilityWarningThreshold.setText(Integer.toString(this.getVisibilityWarningThreshold(var1)));
   }
}
