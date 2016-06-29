package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabpanels;

import com.google.common.collect.Lists;
import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.tabcomponents.SortingComboboxPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SortingTabPanel extends JPanel {
   private static int SORTING_LABEL_WIDTH = 100;
   private static int SORTING_COMBOBOX_WIDTH = 150;
   private static int ROW_HEIGHT = 25;
   private SortingComboboxPanel firstSortCombo;
   private SortingComboboxPanel secondSortCombo;
   private SortingComboboxPanel thirdSortCombo;
   private SortingComboboxPanel fourthSortCombo;
   private SortingComboboxPanel fifthSortCombo;
   private final boolean isCallgraphView;
   private final boolean isCombinedView;
   private ESortOrder initialFirstOrder;
   private ESortOrder initialSecondOrder;
   private ESortOrder initialThirdOrder;
   private ESortOrder initialFourthOrder;
   private ESortOrder initialFifthOrder;
   private ESortByCriterium initialFirstCriterium;
   private ESortByCriterium initialSecondCriterium;
   private ESortByCriterium initialThirdCriterium;
   private ESortByCriterium initialFourthCriterium;
   private ESortByCriterium initialFifthCriterium;

   public SortingTabPanel(boolean var1, boolean var2) {
      super(new BorderLayout());
      this.add(this.createPanel(var1, var2), "Center");
      this.isCallgraphView = var2;
      this.isCombinedView = var1;
      this.setDefaults();
   }

   private JPanel createPanel(boolean var1, boolean var2) {
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new LineBorder(Color.GRAY));
      JPanel var4 = new JPanel(new GridLayout(var1?6:5, 1, 2, 2));
      var4.setBorder(new TitledBorder("Sort Options"));
      ArrayList var5 = Lists.newArrayList((Object[])(new String[]{ESortByCriterium.NONE.toString(), ESortByCriterium.ADDRESS.toString(), ESortByCriterium.MATCHSTATE.toString(), ESortByCriterium.SELECTION.toString(), ESortByCriterium.VISIBILITY.toString()}));
      if(var1) {
         var5.add(ESortByCriterium.SIDE.toString());
      }

      if(var2) {
         var5.add(2, ESortByCriterium.FUNCTIONTYPE.toString());
         if(!var1) {
            var5.add(3, ESortByCriterium.FUNCTIONNAME.toString());
         }
      }

      this.firstSortCombo = new SortingComboboxPanel("First", var5, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.secondSortCombo = new SortingComboboxPanel("Second", var5, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.thirdSortCombo = new SortingComboboxPanel("Third", var5, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.fourthSortCombo = new SortingComboboxPanel("Fourth", var5, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
      this.fifthSortCombo = new SortingComboboxPanel("Fifth", var5, SORTING_LABEL_WIDTH, SORTING_COMBOBOX_WIDTH, ROW_HEIGHT);
      var4.add(this.firstSortCombo);
      var4.add(this.secondSortCombo);
      var4.add(this.thirdSortCombo);
      var4.add(this.fourthSortCombo);
      var4.add(this.fifthSortCombo);
      var3.add(var4, "North");
      return var3;
   }

   public ESortByCriterium getSortByCriterium(int var1) {
      switch(var1) {
      case 0:
         return ESortByCriterium.toSortCriterium(this.firstSortCombo.getValue());
      case 1:
         return ESortByCriterium.toSortCriterium(this.secondSortCombo.getValue());
      case 2:
         return ESortByCriterium.toSortCriterium(this.thirdSortCombo.getValue());
      case 3:
         return ESortByCriterium.toSortCriterium(this.fourthSortCombo.getValue());
      case 4:
         return ESortByCriterium.toSortCriterium(this.fifthSortCombo.getValue());
      default:
         return ESortByCriterium.NONE;
      }
   }

   public ESortOrder getSortOrder(int var1) {
      switch(var1) {
      case 0:
         return this.firstSortCombo.getSortOrder();
      case 1:
         return this.secondSortCombo.getSortOrder();
      case 2:
         return this.thirdSortCombo.getSortOrder();
      case 3:
         return this.fourthSortCombo.getSortOrder();
      case 4:
         return this.fifthSortCombo.getSortOrder();
      default:
         return ESortOrder.ASCENDING;
      }
   }

   public void restoreInitialSettings() {
      this.firstSortCombo.setSelectItem(this.initialFirstCriterium.toString(), this.initialFirstOrder);
      this.secondSortCombo.setSelectItem(this.initialSecondCriterium.toString(), this.initialSecondOrder);
      this.thirdSortCombo.setSelectItem(this.initialThirdCriterium.toString(), this.initialThirdOrder);
      this.fourthSortCombo.setSelectItem(this.initialFourthCriterium.toString(), this.initialFourthOrder);
      this.fifthSortCombo.setSelectItem(this.initialFifthCriterium.toString(), this.initialFifthOrder);
   }

   public void setDefaults() {
      if(!this.isCallgraphView) {
         this.secondSortCombo.setSelectItem(ESortByCriterium.MATCHSTATE.toString(), ESortOrder.ASCENDING);
         if(!this.isCombinedView) {
            this.fourthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
            this.fifthSortCombo.setSelectItem(ESortByCriterium.NONE.toString(), ESortOrder.ASCENDING);
         } else {
            this.fourthSortCombo.setSelectItem(ESortByCriterium.SIDE.toString(), ESortOrder.ASCENDING);
            this.fifthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
         }
      } else {
         this.secondSortCombo.setSelectItem(ESortByCriterium.FUNCTIONTYPE.toString(), ESortOrder.ASCENDING);
         this.thirdSortCombo.setSelectItem(ESortByCriterium.MATCHSTATE.toString(), ESortOrder.ASCENDING);
         this.fifthSortCombo.setSelectItem(ESortByCriterium.ADDRESS.toString(), ESortOrder.ASCENDING);
      }

   }

   public void storeInitialSettings() {
      this.initialFirstOrder = this.firstSortCombo.getSortOrder();
      this.initialSecondOrder = this.secondSortCombo.getSortOrder();
      this.initialThirdOrder = this.thirdSortCombo.getSortOrder();
      this.initialFourthOrder = this.fourthSortCombo.getSortOrder();
      this.initialFifthOrder = this.fifthSortCombo.getSortOrder();
      this.initialFirstCriterium = this.getSortByCriterium(0);
      this.initialSecondCriterium = this.getSortByCriterium(1);
      this.initialThirdCriterium = this.getSortByCriterium(2);
      this.initialFourthCriterium = this.getSortByCriterium(3);
      this.initialFifthCriterium = this.getSortByCriterium(4);
   }
}
