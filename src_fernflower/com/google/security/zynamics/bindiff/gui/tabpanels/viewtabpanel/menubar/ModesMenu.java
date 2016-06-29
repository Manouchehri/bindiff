package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SwitchToCombinedViewModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.SwitchToNormalViewModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleAutomaticLayoutAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleGraphSynchronizationAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleProximityBrowsingAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.ToggleProximityFreezeModeAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu$InternalSettingsListener;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

public class ModesMenu extends JMenu {
   private JRadioButtonMenuItem normalViewMode;
   private JRadioButtonMenuItem combinedViewMode;
   private JCheckBoxMenuItem synchronizeGraphs;
   private JCheckBoxMenuItem automaticLayout;
   private JCheckBoxMenuItem proximityBrowsing;
   private JCheckBoxMenuItem proximityFreezeMode;
   private ModesMenu$InternalSettingsListener settingsListener = new ModesMenu$InternalSettingsListener(this, (ModesMenu$1)null);
   private ViewTabPanelFunctions controller;

   public ModesMenu(ViewTabPanelFunctions var1) {
      super("Mode");
      this.setMnemonic('M');
      int var2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.normalViewMode = GuiUtils.buildRadioButtonMenuItem("Normal View Mode", 'N', 49, var2, new SwitchToNormalViewModeAction(var1));
      this.combinedViewMode = GuiUtils.buildRadioButtonMenuItem("Combined View Mode", 'C', 50, var2, new SwitchToCombinedViewModeAction(var1));
      this.synchronizeGraphs = GuiUtils.buildCheckBoxMenuItem("Synchronize Graphs", 'S', 119, 0, new ToggleGraphSynchronizationAction(var1));
      this.automaticLayout = GuiUtils.buildCheckBoxMenuItem("Automatic Layout", 'A', 116, 0, new ToggleAutomaticLayoutAction(var1));
      this.proximityBrowsing = GuiUtils.buildCheckBoxMenuItem("Proximity Browsing", 'P', 117, 0, new ToggleProximityBrowsingAction(var1));
      this.proximityFreezeMode = GuiUtils.buildCheckBoxMenuItem("Proximity Freeze-Mode", 'F', 118, 0, new ToggleProximityFreezeModeAction(var1));
      ButtonGroup var3 = new ButtonGroup();
      this.normalViewMode.setSelected(true);
      var3.add(this.normalViewMode);
      var3.add(this.combinedViewMode);
      this.add(this.normalViewMode);
      this.add(this.combinedViewMode);
      this.add(new JSeparator());
      this.add(this.automaticLayout);
      this.add(this.proximityBrowsing);
      this.add(this.proximityFreezeMode);
      this.add(new JSeparator());
      this.add(this.synchronizeGraphs);
      GraphSettings var4 = var1.getGraphSettings();
      this.initStates(var4);
      var4.addListener(this.settingsListener);
   }

   private void initStates(GraphSettings var1) {
      switch(ModesMenu$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[var1.getDiffViewMode().ordinal()]) {
      case 1:
         this.normalViewMode.setSelected(true);
         break;
      case 2:
         this.combinedViewMode.setSelected(true);
      }

      this.automaticLayout.setSelected(var1.getLayoutSettings().getAutomaticLayouting());
      this.proximityBrowsing.setSelected(var1.getProximitySettings().getProximityBrowsing());
      this.proximityFreezeMode.setSelected(var1.getProximitySettings().getProximityBrowsingFrozen());
      this.synchronizeGraphs.setSelected(var1.getGraphSyncMode() == EGraphSynchronization.SYNC);
   }

   public void dispose() {
      this.controller.getGraphSettings().removeListener(this.settingsListener);
      this.settingsListener = null;
      this.controller = null;
      this.normalViewMode = null;
      this.combinedViewMode = null;
      this.synchronizeGraphs = null;
      this.automaticLayout = null;
      this.proximityBrowsing = null;
      this.proximityFreezeMode = null;
   }

   // $FF: synthetic method
   static JCheckBoxMenuItem access$100(ModesMenu var0) {
      return var0.automaticLayout;
   }

   // $FF: synthetic method
   static JRadioButtonMenuItem access$200(ModesMenu var0) {
      return var0.normalViewMode;
   }

   // $FF: synthetic method
   static JRadioButtonMenuItem access$300(ModesMenu var0) {
      return var0.combinedViewMode;
   }

   // $FF: synthetic method
   static JCheckBoxMenuItem access$400(ModesMenu var0) {
      return var0.synchronizeGraphs;
   }

   // $FF: synthetic method
   static JCheckBoxMenuItem access$500(ModesMenu var0) {
      return var0.proximityBrowsing;
   }

   // $FF: synthetic method
   static JCheckBoxMenuItem access$600(ModesMenu var0) {
      return var0.proximityFreezeMode;
   }
}
