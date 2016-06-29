package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.IGraphSearchFieldListener;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.regex.PatternSyntaxException;
import javax.swing.AbstractAction;

final class GraphSearchField$CSearchAction extends AbstractAction {
   // $FF: synthetic field
   final GraphSearchField this$0;

   private GraphSearchField$CSearchAction(GraphSearchField var1) {
      this.this$0 = var1;
   }

   private void centerNextSearchHit(boolean var1, boolean var2) {
      String var3 = GraphSearchField.access$500(this.this$0).getText();
      if(GraphSeacherFunctions.getHasChanged(GraphSearchField.access$1100(this.this$0), var3)) {
         if(!var3.equals("")) {
            this.iterateObjectResults(var1, var2);
         } else {
            GraphSeacherFunctions.clearResults(GraphSearchField.access$1100(this.this$0));
            Iterator var4 = GraphSearchField.access$1200(this.this$0).iterator();

            while(var4.hasNext()) {
               IGraphSearchFieldListener var5 = (IGraphSearchFieldListener)var4.next();
               var5.cleaned();
            }
         }

         GraphSearchField.access$1100(this.this$0).updateViews();
      } else {
         this.iterateObjectResults(var1, var2);
      }

   }

   private void iterateObjectResults(boolean var1, boolean var2) {
      if(!GraphSeacherFunctions.isEmpty(GraphSearchField.access$1100(this.this$0))) {
         GraphSeacherFunctions.iterateObjectResults(GraphSearchField.access$1100(this.this$0), var1, var2);
         GraphSearchField.access$1100(this.this$0).updateViews();
      }

   }

   private void search(boolean var1) {
      String var2 = GraphSearchField.access$500(this.this$0).getText();
      if(GraphSeacherFunctions.getHasChanged(GraphSearchField.access$1100(this.this$0), var2)) {
         if(!"".equals(var2)) {
            GraphSearchField.access$1300(this.this$0).add(var2);
            GraphSearchField.access$500(this.this$0).setCaretPosition(GraphSearchField.access$500(this.this$0).getText().length());
         }

         try {
            Iterator var3 = GraphSearchField.access$1200(this.this$0).iterator();

            while(var3.hasNext()) {
               IGraphSearchFieldListener var4 = (IGraphSearchFieldListener)var3.next();
               var4.cleaned();
            }

            GraphSeacherFunctions.search(GraphSearchField.access$1100(this.this$0), var2);
            if(GraphSeacherFunctions.isEmpty(GraphSearchField.access$1100(this.this$0))) {
               GraphSearchField.access$1300(this.this$0).getEditor().getEditorComponent().setBackground(GraphSearchField.access$1400());
               GraphSearchField.access$1600(this.this$0).setIcon(GraphSearchField.access$1500());
            } else {
               GraphSearchField.access$1300(this.this$0).getEditor().getEditorComponent().setBackground(GraphSearchField.access$1700());
               GraphSearchField.access$1600(this.this$0).setIcon(GraphSearchField.access$1800());
            }

            GraphSeacherFunctions.highlightSubObjectResults(GraphSearchField.access$1100(this.this$0));
            GraphSeacherFunctions.jumpToFirstResultObject(GraphSearchField.access$1100(this.this$0).getFocusedGraph(), var1);
            this.this$0.notifySearchFieldListener();
            GraphSearchField.access$1100(this.this$0).updateViews();
         } catch (PatternSyntaxException var5) {
            CMessageBox.showInformation(GraphSearchField.access$1900(this.this$0).getMainWindow(), String.format("Invalid Regular Expression \'%s\'", new Object[]{var2}));
         }
      }

   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == GraphSearchField.access$500(this.this$0) && GraphSearchField.access$500(this.this$0).getText() != null) {
         if(GraphSearchField.access$500(this.this$0).getText().isEmpty()) {
            GraphSeacherFunctions.clearResults(GraphSearchField.access$1100(this.this$0));
            GraphSearchField.access$500(this.this$0).setBackground(GraphSearchField.access$1700());
            GraphSearchField.access$1600(this.this$0).setIcon(GraphSearchField.access$1500());
            Iterator var4 = GraphSearchField.access$1200(this.this$0).iterator();

            while(var4.hasNext()) {
               IGraphSearchFieldListener var5 = (IGraphSearchFieldListener)var4.next();
               var5.cleaned();
            }

            return;
         }

         boolean var2 = var1.getModifiers() == 2 || var1.getModifiers() == 3;
         boolean var3 = var1.getModifiers() == 1 || var1.getModifiers() == 3;
         if(GraphSeacherFunctions.getHasChanged(GraphSearchField.access$1100(this.this$0), GraphSearchField.access$500(this.this$0).getText())) {
            this.search(var3);
         } else {
            this.centerNextSearchHit(var2, var3);
         }
      }

   }

   // $FF: synthetic method
   GraphSearchField$CSearchAction(GraphSearchField var1, GraphSearchField$1 var2) {
      this(var1);
   }
}
