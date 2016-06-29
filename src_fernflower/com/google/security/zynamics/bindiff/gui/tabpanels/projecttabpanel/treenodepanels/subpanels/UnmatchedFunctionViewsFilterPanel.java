package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UnmatchedFunctionViewsFilterPanel extends JPanel {
   private static final ImageIcon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
   private static final ImageIcon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
   private static final ImageIcon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
   private final UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister clearButtonListener = new UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(this, (UnmatchedFunctionViewsFilterPanel$1)null);
   private final UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener optionsButtonListener = new UnmatchedFunctionViewsFilterPanel$InternalOptionButtonListener(this, (UnmatchedFunctionViewsFilterPanel$1)null);
   private final UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener searchResultListener = new UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(this, (UnmatchedFunctionViewsFilterPanel$1)null);
   private final TableTextSearchComboBox searchCombobox;
   private final JButton optionsButton;
   private final JButton clearButton;
   private final UnmatchedFunctionViewsTable unmatchedFunctionsViewTable;
   private final ESide side;

   public UnmatchedFunctionViewsFilterPanel(UnmatchedFunctionViewsTable var1, ESide var2) {
      super(new BorderLayout());
      this.optionsButton = new JButton(ICON_OPTIONS);
      this.clearButton = new JButton(ICON_CLEAR_GRAY);
      this.unmatchedFunctionsViewTable = (UnmatchedFunctionViewsTable)Preconditions.checkNotNull(var1);
      this.side = (ESide)Preconditions.checkNotNull(var2);
      this.searchCombobox = new TableTextSearchComboBox(var1, getColumnIndices(var2));
      this.searchCombobox.addListener(this.searchResultListener);
      this.clearButton.addActionListener(this.clearButtonListener);
      this.optionsButton.addActionListener(this.optionsButtonListener);
      this.clearButton.setToolTipText("Clear Search Results");
      this.optionsButton.setToolTipText("Search Settings");
      this.add(this.createPanel(), "West");
   }

   private static List getColumnIndices(ESide var0) {
      ArrayList var1 = new ArrayList();
      var1.add(new Pair(Integer.valueOf(0), var0));
      var1.add(new Pair(Integer.valueOf(1), var0));
      var1.add(new Pair(Integer.valueOf(2), var0));
      return var1;
   }

   private JPanel createPanel() {
      this.searchCombobox.setBackground(Color.WHITE);
      this.searchCombobox.setMinimumSize(new Dimension(30, 0));
      this.searchCombobox.setMaximumSize(new Dimension(400, 0));
      Dimension var1 = new Dimension(400, this.searchCombobox.getPreferredSize().height - 4);
      this.searchCombobox.setPreferredSize(var1);
      this.searchCombobox.setSize(var1);
      this.clearButton.setBackground(Color.WHITE);
      this.clearButton.setFocusable(false);
      this.clearButton.setPreferredSize(new Dimension(32, 23));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.add(this.searchCombobox, "Center");
      JPanel var3 = new JPanel(new BorderLayout());
      var3.add(this.clearButton, "Center");
      this.optionsButton.setPreferredSize(new Dimension(32, 23));
      this.optionsButton.setBackground(Color.WHITE);
      this.optionsButton.setFocusable(false);
      this.clearButton.setPreferredSize(new Dimension(32, 23));
      this.clearButton.setBackground(Color.WHITE);
      this.clearButton.setFocusable(false);
      JPanel var4 = new JPanel(new GridLayout(1, 2, 1, 1));
      var4.setBorder(new EmptyBorder(0, 1, 0, 5));
      var4.add(this.clearButton);
      var4.add(this.optionsButton);
      var3.add(var4, "Center");
      var2.add(var3, "East");
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setMaximumSize(new Dimension(467, 23));
      var5.setMinimumSize(new Dimension(467, 23));
      var5.setSize(new Dimension(467, 23));
      var5.add(var2, "West");
      JPanel var6 = new JPanel(new BorderLayout());
      var6.setBorder(new EmptyBorder(0, 0, 5, 0));
      var6.add(var5, "West");
      return var6;
   }

   public void dispose() {
      this.searchCombobox.removeListener(this.searchResultListener);
      this.clearButton.removeActionListener(this.clearButtonListener);
   }

   public TableTextSearchComboBox getSearchCombobox() {
      return this.searchCombobox;
   }

   // $FF: synthetic method
   static TableTextSearchComboBox access$300(UnmatchedFunctionViewsFilterPanel var0) {
      return var0.searchCombobox;
   }

   // $FF: synthetic method
   static ImageIcon access$400() {
      return ICON_CLEAR_GRAY;
   }

   // $FF: synthetic method
   static JButton access$500(UnmatchedFunctionViewsFilterPanel var0) {
      return var0.clearButton;
   }

   // $FF: synthetic method
   static ESide access$600(UnmatchedFunctionViewsFilterPanel var0) {
      return var0.side;
   }

   // $FF: synthetic method
   static UnmatchedFunctionViewsTable access$700(UnmatchedFunctionViewsFilterPanel var0) {
      return var0.unmatchedFunctionsViewTable;
   }

   // $FF: synthetic method
   static ImageIcon access$800() {
      return ICON_CLEAR;
   }
}
