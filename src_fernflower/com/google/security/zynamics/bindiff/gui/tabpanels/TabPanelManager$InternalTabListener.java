package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import java.util.Iterator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class TabPanelManager$InternalTabListener implements ChangeListener {
   // $FF: synthetic field
   final TabPanelManager this$0;

   private TabPanelManager$InternalTabListener(TabPanelManager var1) {
      this.this$0 = var1;
   }

   public void stateChanged(ChangeEvent var1) {
      TabPanel var2 = (TabPanel)TabPanelManager.access$500(this.this$0).getSelectedComponent();
      TabPanelManager.access$300(this.this$0).updateTitle(TabPanelManager.access$600(this.this$0), var2);
      TabPanelManager.access$300(this.this$0).setJMenuBar(var2.getMenuBar());
      Iterator var3 = TabPanelManager.access$700(this.this$0).iterator();

      while(true) {
         while(true) {
            TabPanel var4;
            do {
               if(!var3.hasNext()) {
                  return;
               }

               var4 = (TabPanel)var3.next();
            } while(!(var4 instanceof ViewTabPanel));

            ViewToolbarPanel var5;
            SearchResultsDialog var6;
            if(var2 == var4) {
               var5 = ((ViewTabPanel)var4).getToolbar();
               var6 = var5.getSearchResultsDialog();
               var6.setVisible(var6.getReshowDialog());
            } else {
               var5 = ((ViewTabPanel)var4).getToolbar();
               var6 = var5.getSearchResultsDialog();
               boolean var7 = var6.isVisible() || var6.getReshowDialog();
               var6.setVisible(false);
               var6.setReshowDialog(var7);
            }
         }
      }
   }

   // $FF: synthetic method
   TabPanelManager$InternalTabListener(TabPanelManager var1, TabPanelManager$1 var2) {
      this(var1);
   }
}
