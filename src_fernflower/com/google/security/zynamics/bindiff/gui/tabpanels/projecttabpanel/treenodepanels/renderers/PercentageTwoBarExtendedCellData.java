package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Triple;
import java.awt.Toolkit;

public class PercentageTwoBarExtendedCellData {
   private final EPercentageBarSortType sortRelevance;
   private Triple data;

   public PercentageTwoBarExtendedCellData(int var1, int var2, int var3) {
      this(var1, var2, var3, EPercentageBarSortType.SORT_BY_CENTER_VALUE, false);
   }

   public PercentageTwoBarExtendedCellData(int var1, int var2, int var3, EPercentageBarSortType var4, boolean var5) {
      this.data = new Triple(Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3));
      this.sortRelevance = var4 == null?EPercentageBarSortType.SORT_BY_CENTER_VALUE:var4;
   }

   public double getInnerLeftBarPercent() {
      return (double)((Integer)this.data.second()).intValue() / (double)this.getTotalBarValue() * 100.0D;
   }

   public int getInnerLeftBarValue() {
      return ((Integer)this.data.second()).intValue();
   }

   public double getLeftBarPercent() {
      return (double)((Integer)this.data.first()).intValue() / (double)this.getTotalBarValue() * 100.0D;
   }

   public String getLeftBarString(boolean var1, boolean var2) {
      // $FF: Couldn't be decompiled
   }

   public int getLeftBarValue() {
      return ((Integer)this.data.first()).intValue();
   }

   public double getRightBarPercent() {
      return (double)((Integer)this.data.third()).intValue() / (double)this.getTotalBarValue() * 100.0D;
   }

   public String getRightBarString(boolean var1) {
      String var2 = "%d";
      var2 = String.format(var2, new Object[]{Integer.valueOf(this.getRightBarValue())});
      if(var1) {
         var2 = String.format("%s (%.1f%s)", new Object[]{var2, Double.valueOf(this.getRightBarPercent()), "%"});
      }

      return var2;
   }

   public int getRightBarValue() {
      return ((Integer)this.data.third()).intValue();
   }

   public double getSortByValue() {
      return this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE?(double)((Integer)this.data.first()).intValue():(this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE?(double)((Integer)this.data.third()).intValue():(this.sortRelevance == EPercentageBarSortType.SORT_BY_INNERRIGHT?(double)((Integer)this.data.second()).intValue():(double)this.getTotalBarValue()));
   }

   public int getTotalBarValue() {
      int var1 = ((Integer)this.data.first()).intValue() + ((Integer)this.data.third()).intValue();
      return var1 == 0?1:var1;
   }

   public void updateData(int var1, int var2, int var3) {
      this.data = new Triple(Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3));
   }
}
