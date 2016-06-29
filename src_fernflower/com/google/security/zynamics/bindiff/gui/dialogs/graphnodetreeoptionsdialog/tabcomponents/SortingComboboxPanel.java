package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class SortingComboboxPanel extends JPanel {
   private final JComboBox combobox;
   private final JLabel label;
   private final JRadioButton ascSorting;
   private final JRadioButton descSorting;
   private final int height;

   public SortingComboboxPanel(String var1, List var2, int var3, int var4, int var5) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.label = new JLabel(var1);
      String[] var6 = new String[var2.size()];
      var2.toArray(var6);
      this.combobox = new JComboBox(var6);
      this.label.setPreferredSize(new Dimension(var3, var5));
      this.combobox.setPreferredSize(new Dimension(var4, var5));
      this.ascSorting = new JRadioButton("▲");
      this.descSorting = new JRadioButton("▼");
      this.ascSorting.setPreferredSize(new Dimension(this.ascSorting.getPreferredSize().width, var5));
      this.descSorting.setPreferredSize(new Dimension(this.descSorting.getPreferredSize().width, var5));
      this.ascSorting.setToolTipText("Ascending");
      this.descSorting.setToolTipText("Descending");
      this.ascSorting.setSelected(true);
      this.height = var5;
      this.init();
   }

   private JPanel createSortSequencePane() {
      this.ascSorting.setForeground(Color.GRAY);
      this.descSorting.setForeground(Color.GRAY);
      this.ascSorting.setFocusable(false);
      this.descSorting.setFocusable(false);
      JPanel var1 = new JPanel(new GridLayout(1, 2));
      var1.setBorder(new TitledBorder(""));
      ButtonGroup var2 = new ButtonGroup();
      var2.add(this.ascSorting);
      var2.add(this.descSorting);
      var1.add(this.ascSorting);
      var1.add(this.descSorting);
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(0, 1, 0, 0));
      var3.add(var1, "Center");
      return var3;
   }

   public ESortOrder getSortOrder() {
      return this.ascSorting.isSelected()?ESortOrder.ASCENDING:ESortOrder.DESCENDING;
   }

   public String getValue() {
      return this.combobox.getSelectedItem().toString();
   }

   public void init() {
      this.setBorder(new EmptyBorder(2, 2, 2, 2));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.add(this.label, "West");
      var1.add(this.combobox, "Center");
      var1.add(this.createSortSequencePane(), "East");
      var1.setPreferredSize(new Dimension(var1.getPreferredSize().width, this.height));
      this.add(var1, "Center");
   }

   public void setSelectItem(String var1, ESortOrder var2) {
      this.ascSorting.setSelected(var2 == ESortOrder.ASCENDING);
      this.combobox.setSelectedItem(var1);
   }
}
