package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalClearButtonLister;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalOptionButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$InternalSearchResultListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MatchedFunctionViewsFilterPanel extends JPanel {
   private static final ImageIcon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
   private static final ImageIcon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
   private static final ImageIcon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
   private final ListenerProvider checkBoxFilterListeners = new ListenerProvider();
   private final MatchedFunctionViewsFilterPanel$InternalSearchResultListener searchResultListener;
   private final MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener filterCheckboxListener;
   private final MatchedFunctionViewsFilterPanel$InternalClearButtonLister clearButtonListener = new MatchedFunctionViewsFilterPanel$InternalClearButtonLister(this, (MatchedFunctionViewsFilterPanel$1)null);
   private final MatchedFunctionViewsFilterPanel$InternalOptionButtonListener optionsButtonListener;
   private final JButton optionsButton;
   private final JButton clearButton;
   private final JCheckBox showStructuralChangedFunctions;
   private final JCheckBox showInstructionChangedOnlyFunctions;
   private final JCheckBox showIdenticalFunctions;
   private final TableTextSearchComboBox searchCombobox;
   private final MatchedFunctionViewsTable matchedFunctionsViewTable;

   public MatchedFunctionViewsFilterPanel(MatchedFunctionViewsTable var1) {
      super(new BorderLayout());
      this.optionsButton = new JButton(ICON_OPTIONS);
      this.clearButton = new JButton(ICON_CLEAR_GRAY);
      this.showStructuralChangedFunctions = new JCheckBox("Show structural changes", true);
      this.showInstructionChangedOnlyFunctions = new JCheckBox("Show only instructions changed", true);
      this.showIdenticalFunctions = new JCheckBox("Show identical", true);
      Preconditions.checkNotNull(var1);
      this.searchResultListener = new MatchedFunctionViewsFilterPanel$InternalSearchResultListener(this, (MatchedFunctionViewsFilterPanel$1)null);
      this.filterCheckboxListener = new MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(this, (MatchedFunctionViewsFilterPanel$1)null);
      this.optionsButtonListener = new MatchedFunctionViewsFilterPanel$InternalOptionButtonListener(this, (MatchedFunctionViewsFilterPanel$1)null);
      this.matchedFunctionsViewTable = var1;
      this.searchCombobox = new TableTextSearchComboBox(var1, getColumnIndices());
      this.searchCombobox.addListener(this.searchResultListener);
      this.clearButton.addActionListener(this.clearButtonListener);
      this.optionsButton.addActionListener(this.optionsButtonListener);
      this.clearButton.setToolTipText("Clear Search Results");
      this.optionsButton.setToolTipText("Search Settings");
      this.showStructuralChangedFunctions.addItemListener(this.filterCheckboxListener);
      this.showInstructionChangedOnlyFunctions.addItemListener(this.filterCheckboxListener);
      this.showIdenticalFunctions.addItemListener(this.filterCheckboxListener);
      this.searchCombobox.setSearchOptions(false, false, true, true, false);
      this.add(this.createPanel(), "Center");
   }

   private static List getColumnIndices() {
      ArrayList var0 = new ArrayList();
      var0.add(new Pair(Integer.valueOf(3), ESide.PRIMARY));
      var0.add(new Pair(Integer.valueOf(4), ESide.PRIMARY));
      var0.add(new Pair(Integer.valueOf(5), ESide.PRIMARY));
      var0.add(new Pair(Integer.valueOf(6), ESide.SECONDARY));
      var0.add(new Pair(Integer.valueOf(7), ESide.SECONDARY));
      var0.add(new Pair(Integer.valueOf(8), ESide.SECONDARY));
      return var0;
   }

   private JPanel createChangesFilterPanel() {
      this.showStructuralChangedFunctions.setMinimumSize(new Dimension(0, 0));
      this.showInstructionChangedOnlyFunctions.setMinimumSize(new Dimension(0, 0));
      this.showIdenticalFunctions.setMinimumSize(new Dimension(0, 0));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.showStructuralChangedFunctions, "West");
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.showInstructionChangedOnlyFunctions, "West");
      var1.add(var2, "Center");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.add(this.showIdenticalFunctions, "West");
      var2.add(var3, "Center");
      return var1;
   }

   private JPanel createPanel() {
      this.searchCombobox.setBackground(Color.WHITE);
      this.searchCombobox.setMinimumSize(new Dimension(30, 0));
      Dimension var1 = new Dimension(this.searchCombobox.getPreferredSize().width, this.searchCombobox.getPreferredSize().height - 4);
      this.searchCombobox.setPreferredSize(var1);
      this.searchCombobox.setSize(var1);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.searchCombobox, "Center");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.add(this.createTextFilterPanel(), "West");
      JPanel var4 = new JPanel(new BorderLayout());
      var4.add(this.createChangesFilterPanel(), "West");
      var4.setBorder(new EmptyBorder(0, 5, 0, 1));
      var2.add(var3, "East");
      var3.add(var4, "Center");
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new EmptyBorder(0, 0, 5, 0));
      var5.add(var2);
      return var5;
   }

   private JPanel createTextFilterPanel() {
      JPanel var1 = new JPanel(new BorderLayout());
      Dimension var2 = this.searchCombobox.getPreferredSize();
      this.optionsButton.setPreferredSize(new Dimension(32, var2.height));
      this.optionsButton.setBackground(Color.WHITE);
      this.optionsButton.setFocusable(false);
      this.clearButton.setPreferredSize(new Dimension(32, var2.height));
      this.clearButton.setBackground(Color.WHITE);
      this.clearButton.setFocusable(false);
      JPanel var3 = new JPanel(new GridLayout(1, 2, 1, 1));
      var3.setBorder(new EmptyBorder(0, 1, 0, 0));
      var3.add(this.clearButton);
      var3.add(this.optionsButton);
      var1.add(var3, "Center");
      return var1;
   }

   public void addListener(IViewsFilterCheckboxListener var1) {
      this.checkBoxFilterListeners.addListener(var1);
   }

   public void dispose() {
      this.searchCombobox.removeListener(this.searchResultListener);
      this.clearButton.removeActionListener(this.clearButtonListener);
      this.optionsButton.removeActionListener(this.optionsButtonListener);
      this.showStructuralChangedFunctions.removeItemListener(this.filterCheckboxListener);
      this.showInstructionChangedOnlyFunctions.removeItemListener(this.filterCheckboxListener);
      this.showIdenticalFunctions.removeItemListener(this.filterCheckboxListener);
   }

   public void removeListener(IViewsFilterCheckboxListener var1) {
      this.checkBoxFilterListeners.removeListener(var1);
   }

   // $FF: synthetic method
   static TableTextSearchComboBox access$400(MatchedFunctionViewsFilterPanel var0) {
      return var0.searchCombobox;
   }

   // $FF: synthetic method
   static ImageIcon access$500() {
      return ICON_CLEAR_GRAY;
   }

   // $FF: synthetic method
   static JButton access$600(MatchedFunctionViewsFilterPanel var0) {
      return var0.clearButton;
   }

   // $FF: synthetic method
   static JCheckBox access$700(MatchedFunctionViewsFilterPanel var0) {
      return var0.showStructuralChangedFunctions;
   }

   // $FF: synthetic method
   static JCheckBox access$800(MatchedFunctionViewsFilterPanel var0) {
      return var0.showInstructionChangedOnlyFunctions;
   }

   // $FF: synthetic method
   static JCheckBox access$900(MatchedFunctionViewsFilterPanel var0) {
      return var0.showIdenticalFunctions;
   }

   // $FF: synthetic method
   static ListenerProvider access$1000(MatchedFunctionViewsFilterPanel var0) {
      return var0.checkBoxFilterListeners;
   }

   // $FF: synthetic method
   static MatchedFunctionViewsTable access$1100(MatchedFunctionViewsFilterPanel var0) {
      return var0.matchedFunctionsViewTable;
   }

   // $FF: synthetic method
   static ImageIcon access$1200() {
      return ICON_CLEAR;
   }
}
