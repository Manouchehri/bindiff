package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.enums.EMouseAction;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ControlsPanel$1;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import com.google.security.zynamics.zylib.gui.sliders.DoubleLabeledSlider;
import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ControlsPanel extends JPanel {
   private static final int LABEL_WIDTH = 275;
   private static final int ROW_HEIGHT = 25;
   private static final int NUMBER_OF_ROWS = 4;
   private final JComboBox showScrollbars = new JComboBox();
   private final JComboBox mouseWheelBehaviour = new JComboBox();
   private final DoubleLabeledSlider zoomSensitivity;
   private final DoubleLabeledSlider scrollSensitivity;
   private final ESettingsDialogType dialogType;
   private final GraphSettings settings;

   public ControlsPanel(String var1, ESettingsDialogType var2) {
      super(new BorderLayout());
      this.zoomSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
      this.scrollSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
      Preconditions.checkNotNull(var1);
      if(var2 != null && var2 != ESettingsDialogType.NON_INITIAL) {
         this.dialogType = var2;
         this.settings = null;
         this.zoomSensitivity.setInverted(true);
         this.scrollSensitivity.setInverted(true);
         this.init(var1);
      } else {
         throw new IllegalArgumentException("Dialog type cannot be null or non-initial.");
      }
   }

   public ControlsPanel(String var1, ESettingsDialogType var2, GraphSettings var3) {
      super(new BorderLayout());
      this.zoomSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
      this.scrollSensitivity = new DoubleLabeledSlider("  Low  ", "  High  ", 1, 10, false, new LineBorder(Color.GRAY));
      Preconditions.checkNotNull(var1);
      if(var2 != null && var2 == ESettingsDialogType.NON_INITIAL) {
         this.dialogType = var2;
         this.settings = var3;
         this.zoomSensitivity.setInverted(true);
         this.scrollSensitivity.setInverted(true);
         this.init(var1);
      } else {
         throw new IllegalArgumentException("Dialog type cannot be null or not non-initial.");
      }
   }

   private EMouseAction getMouseWheelBehaviour(BinDiffConfigFile var1) {
      switch(ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return EMouseAction.getEnum(var1.getInitialCallgraphSettings().getMouseWheelAction());
      case 2:
         return EMouseAction.getEnum(var1.getInitialFlowgraphSettings().getMouseWheelAction());
      default:
         return this.settings.getMouseSettings().getMouseWheelAction() == MouseWheelAction.ZOOM?EMouseAction.ZOOM:EMouseAction.SCROLL;
      }
   }

   private int getScrollSensitivity(BinDiffConfigFile var1) {
      switch(ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getScrollSensitivity();
      case 2:
         return var1.getInitialFlowgraphSettings().getScrollSensitivity();
      default:
         return this.settings.getMouseSettings().getScrollSensitivity();
      }
   }

   private boolean getShowScrollbars(BinDiffConfigFile var1) {
      switch(ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getShowScrollbars();
      case 2:
         return var1.getInitialFlowgraphSettings().getShowScrollbars();
      default:
         return this.settings.getShowScrollbars();
      }
   }

   private int getZoomSensitivity(BinDiffConfigFile var1) {
      switch(ControlsPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$gui$dialogs$graphsettings$ESettingsDialogType[this.dialogType.ordinal()]) {
      case 1:
         return var1.getInitialCallgraphSettings().getZoomSensitivity();
      case 2:
         return var1.getInitialFlowgraphSettings().getZoomSensitivity();
      default:
         return this.settings.getMouseSettings().getZoomSensitivity();
      }
   }

   private void init(String var1) {
      this.setBorder(new LineBorder(Color.GRAY));
      this.showScrollbars.addItem("Always");
      this.showScrollbars.addItem("Never");
      this.mouseWheelBehaviour.addItem("Zoom");
      this.mouseWheelBehaviour.addItem("Scroll");
      this.setCurrentValues();
      JPanel var2 = new JPanel(new GridLayout(4, 1, 5, 5));
      var2.setBorder(new TitledBorder(var1));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Show scrollbars", 275, this.showScrollbars, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Mousewheel action", 275, this.mouseWheelBehaviour, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Zoom sensitivity", 275, this.zoomSensitivity, 25));
      var2.add(GuiUtils.createHorizontalNamedComponentPanel("Scroll sensitivity", 275, this.scrollSensitivity, 25));
      this.add(var2, "North");
   }

   public EMouseAction getMouseWheelBehaviour() {
      return EMouseAction.getEnum(this.mouseWheelBehaviour.getSelectedIndex());
   }

   public int getScrollSensitivity() {
      return this.scrollSensitivity.getValue();
   }

   public boolean getShowScrollbars() {
      return this.showScrollbars.getSelectedIndex() == 0;
   }

   public int getZoomSensitivity() {
      return this.zoomSensitivity.getValue();
   }

   public void setCurrentValues() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      this.showScrollbars.setSelectedIndex(this.getShowScrollbars(var1)?0:1);
      this.mouseWheelBehaviour.setSelectedIndex(EMouseAction.getOrdinal(this.getMouseWheelBehaviour(var1)));
      this.zoomSensitivity.setValue(this.getZoomSensitivity(var1));
      this.scrollSensitivity.setValue(this.getScrollSensitivity(var1));
   }
}
