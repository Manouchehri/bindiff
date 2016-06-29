package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;

public class ViewPopupHelper {
   public static boolean isEnabled(AbstractTable var0, int var1, boolean var2) {
      WorkspaceTabPanelFunctions var3 = var0.getController();
      TabPanelManager var4 = var3.getMainWindow().getController().getTabPanelManager();
      Diff var5 = var0.getDiff();
      boolean var6 = var5 == null;
      if(!var0.getSelectionModel().isSelectedIndex(var1)) {
         Pair var13 = AbstractTable.getViewAddressPair(var0, var1);
         ViewTabPanel var14 = var4.getTabPanel((IAddress)var13.first(), (IAddress)var13.second(), var5);
         return var2 == (var14 == null);
      } else {
         int[] var7 = var0.getSelectedRows();
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            int var10 = var7[var9];
            if(var6) {
               var5 = AbstractTable.getRowDiff(var0, var10);
               if(!var5.isLoaded()) {
                  if(var2) {
                     return true;
                  }
                  continue;
               }
            }

            Pair var11 = AbstractTable.getViewAddressPair(var0, var10);
            ViewTabPanel var12 = var4.getTabPanel((IAddress)var11.first(), (IAddress)var11.second(), var5);
            if(var2 && var12 == null) {
               return true;
            }

            if(!var2 && var12 != null) {
               return true;
            }
         }

         return false;
      }
   }
}
