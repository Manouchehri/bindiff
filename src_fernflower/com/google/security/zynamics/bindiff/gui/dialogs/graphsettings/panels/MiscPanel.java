package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.MiscPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.sliders.DoubleLabeledSlider;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MiscPanel extends JPanel {
   private static final int LABEL_WIDTH = 275;
   private static final int ROW_HEIGHT = 25;
   private static final int NUMBER_OF_ROWS = 4;
   private final JComboBox viewSynchronization = new JComboBox();
   private final JComboBox gradientBackground = new JComboBox();
   private final JComboBox layoutAnimation = new JComboBox();
   private final DoubleLabeledSlider animationSpeed;
   private final ESettingsDialogType dialogType;
   private final GraphSettings settings;

   public MiscPanel(String var1, ESettingsDialogType var2) {
      super(new BorderLayout());
      this.animationSpeed = new DoubleLabeledSlider("  Slow  ", "  Fast  ", 1, 10, false, new LineBorder(Color.GRAY));
      Preconditions.checkNotNull(var1);
      if(var2 != null && var2 != ESettingsDialogType.NON_INITIAL) {
         this.dialogType = var2;
         this.settings = null;
         this.animationSpeed.setInverted(true);
         this.init(var1);
      } else {
         throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
      }
   }

   public MiscPanel(String var1, ESettingsDialogType var2, GraphSettings var3) {
      super(new BorderLayout());
      this.animationSpeed = new DoubleLabeledSlider("  Slow  ", "  Fast  ", 1, 10, false, new LineBorder(Color.GRAY));
      Preconditions.checkNotNull(var1);
      if(var2 != null && var2 == ESettingsDialogType.NON_INITIAL) {
         this.dialogType = var2;
         this.settings = var3;
         this.animationSpeed.setInverted(true);
         this.init(var1);
      } else {
         throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
      }
   }

   private int getAnimationSpeed(BinDiffConfigFile var1) {
      switch(MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getAnimationSpeed();
      case 2:
         return var1.getInitialFlowgraphSettings().getAnimationSpeed();
      default:
         return this.settings.getDisplaySettings().getAnimationSpeed();
      }
   }

   private boolean getGradientBackground(BinDiffConfigFile var1) {
      switch(MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getGradientBackground();
      case 2:
         return var1.getInitialFlowgraphSettings().getGradientBackground();
      default:
         return this.settings.getDisplaySettings().getGradientBackground();
      }
   }

   private boolean getLayoutAnimation(BinDiffConfigFile var1) {
      switch(MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getLayoutAnimation();
      case 2:
         return var1.getInitialFlowgraphSettings().getLayoutAnimation();
      default:
         return this.settings.getLayoutSettings().getAnimateLayout();
      }
   }

   private boolean getViewSynchronization(BinDiffConfigFile var1) {
      switch(MiscPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getViewSynchronization();
      case 2:
         return var1.getInitialFlowgraphSettings().getViewSynchronization();
      default:
         return this.settings.getGraphSyncMode() == EGraphSynchronization.SYNC;
      }
   }

   private void init(String var1) {
      this.setBorder(new LineBorder(Color.GRAY));
      this.viewSynchronization.addItem("On");
      this.viewSynchronization.addItem("Off");
      this.gradientBackground.addItem("On");
      this.gradientBackground.addItem("Off");
      this.layoutAnimation.addItem("On");
      this.layoutAnimation.addItem("Off");
      this.setCurrentValues();
      int var2 = this.dialogType != ESettingsDialogType.NON_INITIAL?4:3;
      JPanel var3 = new JPanel(new GridLayout(var2, 1, 5, 5));
      var3.setBorder(new TitledBorder(var1));
      if(this.dialogType != ESettingsDialogType.NON_INITIAL) {
         var3.add(GuiUtils.createHorizontalNamedComponentPanel("Views synchronization", 275, this.viewSynchronization, 25));
      }

      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Gradient background", 275, this.gradientBackground, 25));
      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Layout animation", 275, this.layoutAnimation, 25));
      var3.add(GuiUtils.createHorizontalNamedComponentPanel("Animation speed", 275, this.animationSpeed, 25));
      this.add(var3, "North");
   }

   public int getAnimationSpeed() {
      return this.animationSpeed.getValue();
   }

   public boolean getGradientBackground() {
      return this.gradientBackground.getSelectedIndex() == 0;
   }

   public boolean getLayoutAnimation() {
      return this.layoutAnimation.getSelectedIndex() == 0;
   }

   public boolean getViewSynchronization() {
      return this.viewSynchronization.getSelectedIndex() == 0;
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      this.viewSynchronization.setSelectedIndex(this.getViewSynchronization(var1)?0:1);
      this.gradientBackground.setSelectedIndex(this.getGradientBackground(var1)?0:1);
      this.layoutAnimation.setSelectedIndex(this.getLayoutAnimation(var1)?0:1);
      this.animationSpeed.setValue(this.getAnimationSpeed(var1));
   }
}
