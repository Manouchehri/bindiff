package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewToolbarPanel$InternalSearchButtonsListener implements ActionListener {
   // $FF: synthetic field
   final ViewToolbarPanel this$0;

   public ViewToolbarPanel$InternalSearchButtonsListener(ViewToolbarPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(ViewToolbarPanel.access$3300(this.this$0))) {
         GraphSeacherFunctions.clearResults(ViewToolbarPanel.access$3400(this.this$0).getGraphs());
         ViewToolbarPanel.access$3500(this.this$0).notifySearchFieldListener();
      } else if(var1.getSource().equals(ViewToolbarPanel.access$3600(this.this$0))) {
         ViewToolbarPanel.access$3700(this.this$0).setVisible(true);
      }

   }
}
