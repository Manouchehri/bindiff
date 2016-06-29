package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Pair;

public class PercentageTwoBarCellData {
   private final Pair data;
   private final EPercentageBarSortType sortRelevance;
   private final boolean inverted;

   public PercentageTwoBarCellData(int var1, int var2) {
      this(var1, var2, EPercentageBarSortType.SORT_BY_CENTER_VALUE, false);
   }

   public PercentageTwoBarCellData(int var1, int var2, EPercentageBarSortType var3, boolean var4) {
      this.data = new Pair(Integer.valueOf(var1), Integer.valueOf(var2));
      this.sortRelevance = var3 == null?EPercentageBarSortType.SORT_BY_CENTER_VALUE:var3;
      this.inverted = var4;
   }

   public double getLeftBarPercent() {
      return this.inverted?(double)(((Integer)this.data.second()).intValue() / this.getTotalBarValue()) * 100.0D:(double)(((Integer)this.data.first()).intValue() / this.getTotalBarValue()) * 100.0D;
   }

   public String getLeftBarString(boolean var1) {
      String var2 = "%d";
      var2 = String.format(var2, new Object[]{Integer.valueOf(this.inverted?this.getRightBarValue():this.getLeftBarValue())});
      if(var1) {
         var2 = String.valueOf(var2).concat("%s(%.1f)");
         var2 = String.format(var2, new Object[]{Double.valueOf(this.inverted?this.getRightBarPercent():this.getLeftBarPercent())});
      }

      return var2;
   }

   public int getLeftBarValue() {
      return this.inverted?((Integer)this.data.second()).intValue():((Integer)this.data.first()).intValue();
   }

   public double getRightBarPercent() {
      return this.inverted?(double)(((Integer)this.data.first()).intValue() / this.getTotalBarValue()) * 100.0D:(double)(((Integer)this.data.second()).intValue() / this.getTotalBarValue()) * 100.0D;
   }

   public String getRightBarString(boolean var1) {
      String var2 = "%d";
      var2 = String.format(var2, new Object[]{Integer.valueOf(this.inverted?this.getLeftBarValue():this.getRightBarValue())});
      if(var1) {
         var2 = String.valueOf(var2).concat("%s(%.1f)");
         var2 = String.format(var2, new Object[]{Double.valueOf(this.inverted?this.getLeftBarPercent():this.getRightBarPercent())});
      }

      return var2;
   }

   public int getRightBarValue() {
      return this.inverted?((Integer)this.data.first()).intValue():((Integer)this.data.second()).intValue();
   }

   public double getSortByValue() {
      return this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE?(double)((Integer)this.data.first()).intValue():(this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE?(double)((Integer)this.data.second()).intValue():(double)this.getTotalBarValue());
   }

   public int getTotalBarValue() {
      return ((Integer)this.data.first()).intValue() + ((Integer)this.data.second()).intValue();
   }
}
