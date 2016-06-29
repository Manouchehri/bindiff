package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import com.google.common.collect.Lists;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.AddressRangeFieldPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.FilterComboboxPanel;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FilteringTabPanel extends JPanel {
   private static int FILTER_LABEL_WIDTH = 100;
   private static int FILTER_COMBOBOX_WIDTH = 150;
   private static int ROW_HEIGHT = 25;
   private static final String FILTER_ITEM_NONE = "None";
   private static final String FILTER_ITEM_PRIMARY = "Primary";
   private static final String FILTER_ITEM_SECONRARY = "Secondary";
   private static final String FILTER_ITEM_SELECTED = "Selected";
   private static final String FILTER_ITEM_UNSELECTED = "Unselected";
   private static final String FILTER_ITEM_VISIBLE = "Visible";
   private static final String FILTER_ITEM_INVISIBLE = "Invisible";
   private static final String FILTER_ITEM_MATCHED = "Matched";
   private static final String FILTER_ITEM_MATCHED_IDENTICAL = "Matched Identical";
   private static final String FILTER_ITEM_MATCHED_INSTRUCTION_CHANGES = "Matched with Changes";
   private static final String FILTER_ITEM_MATCHED_INSTRUCTION_ONLY_CHANGES = "Matched with Instruction Changes Only";
   private static final String FILTER_ITEM_MATCHED_STRUCTURAL_CHANGES = "Matched with structural Changes";
   private static final String FILTER_ITEM_UNMATCHED = "Unmatched";
   private FilterComboboxPanel matchStateCombo;
   private FilterComboboxPanel selectionCombo;
   private FilterComboboxPanel visibilityCombo;
   private FilterComboboxPanel sideCombo;
   private AddressRangeFieldPanel startRangeField;
   private AddressRangeFieldPanel endRangeField;
   private String initialSelection;
   private String initialVisibility;
   private String initialMatchState;
   private String initialSide;
   private IAddress initialStartRange;
   private IAddress initialEndRange;

   public FilteringTabPanel(boolean var1, boolean var2) {
      super(new BorderLayout());
      this.add(this.createPanel(var1, var2), "Center");
      this.setDefaults();
   }

   private JPanel createPanel(boolean var1, boolean var2) {
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new LineBorder(Color.GRAY));
      JPanel var4 = new JPanel(new GridLayout(var1?6:5, 1, 2, 2));
      var4.setBorder(new TitledBorder("Filter Options"));
      ArrayList var5 = Lists.newArrayList((Object[])(new String[]{"None", "Matched", "Unmatched"}));
      ArrayList var6 = Lists.newArrayList((Object[])(new String[]{"None", "Selected", "Unselected"}));
      ArrayList var7 = Lists.newArrayList((Object[])(new String[]{"None", "Visible", "Invisible"}));
      ArrayList var8 = Lists.newArrayList((Object[])(new String[]{"None", "Primary", "Secondary"}));
      if(var2) {
         var5.add(2, "Matched Identical");
         var5.add(3, "Matched with Instruction Changes Only");
         var5.add(4, "Matched with structural Changes");
      } else {
         var5.add(2, "Matched Identical");
         var5.add(3, "Matched with Changes");
      }

      this.matchStateCombo = new FilterComboboxPanel("Match State", var5, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.selectionCombo = new FilterComboboxPanel("Selection", var6, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.sideCombo = new FilterComboboxPanel("Side", var8, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.visibilityCombo = new FilterComboboxPanel("Visibility", var7, FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.startRangeField = new AddressRangeFieldPanel("Start Range", new CAddress("0000000000000000", 16), FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.endRangeField = new AddressRangeFieldPanel("End Range", new CAddress("FFFFFFFFFFFFFFFF", 16), FILTER_LABEL_WIDTH, FILTER_COMBOBOX_WIDTH, ROW_HEIGHT);
      var4.add(this.matchStateCombo);
      var4.add(this.selectionCombo);
      var4.add(this.visibilityCombo);
      if(var1) {
         var4.add(this.sideCombo);
      }

      var4.add(this.startRangeField);
      var4.add(this.endRangeField);
      var3.add(var4, "North");
      return var3;
   }

   public IAddress getEndAddress() {
      return this.endRangeField.getValue();
   }

   public EMatchStateFilter getMatchStateFilter() {
      return this.matchStateCombo.getValue().equals("Matched")?EMatchStateFilter.MATCHED:(this.matchStateCombo.getValue().equals("Unmatched")?EMatchStateFilter.UNMATCHED:(this.matchStateCombo.getValue().equals("Matched Identical")?EMatchStateFilter.MATCHED_IDENTICAL:(this.matchStateCombo.getValue().equals("Matched with Instruction Changes Only")?EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES:(this.matchStateCombo.getValue().equals("Matched with Changes")?EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES:(this.matchStateCombo.getValue().equals("Matched with structural Changes")?EMatchStateFilter.MATCHED_STRUTURAL_CHANGES:EMatchStateFilter.NONE)))));
   }

   public ESelectionFilter getSelectionFilter() {
      return this.selectionCombo.getValue().equals("Selected")?ESelectionFilter.SELECTED:(this.selectionCombo.getValue().equals("Unselected")?ESelectionFilter.UNSELECTED:ESelectionFilter.NONE);
   }

   public ESideFilter getSideFilter() {
      return this.sideCombo.getValue().equals("Primary")?ESideFilter.PRIMARY:(this.sideCombo.getValue().equals("Secondary")?ESideFilter.SECONDARY:ESideFilter.NONE);
   }

   public IAddress getStartAddress() {
      return this.startRangeField.getValue();
   }

   public EVisibilityFilter getVisibilityFilter() {
      return this.visibilityCombo.getValue().equals("Visible")?EVisibilityFilter.VISIBLE:(this.visibilityCombo.getValue().equals("Invisible")?EVisibilityFilter.INVISIBLE:EVisibilityFilter.NONE);
   }

   public void restoreInitialSettings() {
      this.selectionCombo.setValue(this.initialSelection);
      this.visibilityCombo.setValue(this.initialVisibility);
      this.matchStateCombo.setValue(this.initialMatchState);
      this.sideCombo.setValue(this.initialSide);
      this.startRangeField.setValue(this.initialStartRange);
      this.endRangeField.setValue(this.initialEndRange);
   }

   public void setDefaults() {
      this.selectionCombo.setValue("None");
      this.visibilityCombo.setValue("None");
      this.matchStateCombo.setValue("None");
      this.sideCombo.setValue("None");
      this.startRangeField.setDefault();
      this.endRangeField.setDefault();
   }

   public void storeInitialSettings() {
      this.initialSelection = this.selectionCombo.getValue();
      this.initialVisibility = this.visibilityCombo.getValue();
      this.initialMatchState = this.matchStateCombo.getValue();
      this.initialSide = this.sideCombo.getValue();
      this.initialStartRange = this.startRangeField.getValue();
      this.initialEndRange = this.endRangeField.getValue();
   }
}
