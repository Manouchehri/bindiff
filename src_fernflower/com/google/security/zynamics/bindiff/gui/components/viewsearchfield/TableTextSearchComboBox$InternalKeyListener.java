package com.google.security.zynamics.bindiff.gui.components.viewsearchfield;

import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox$1;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

class TableTextSearchComboBox$InternalKeyListener extends KeyAdapter {
   // $FF: synthetic field
   final TableTextSearchComboBox this$0;

   private TableTextSearchComboBox$InternalKeyListener(TableTextSearchComboBox var1) {
      this.this$0 = var1;
   }

   public void keyTyped(KeyEvent var1) {
      if(var1.getKeyChar() == 10) {
         if("".equals(TableTextSearchComboBox.access$100(this.this$0))) {
            Iterator var2 = TableTextSearchComboBox.access$200(this.this$0).iterator();

            while(var2.hasNext()) {
               IViewSearchFieldListener var3 = (IViewSearchFieldListener)var2.next();
               var3.reset();
            }

            this.this$0.getEditor().getEditorComponent().setBackground(TableTextSearchComboBox.access$300());
         } else {
            TableTextSearchComboBox.access$400(this.this$0, var1.getModifiersEx() == 128);
         }
      }

   }

   // $FF: synthetic method
   TableTextSearchComboBox$InternalKeyListener(TableTextSearchComboBox var1, TableTextSearchComboBox$1 var2) {
      this(var1);
   }
}
