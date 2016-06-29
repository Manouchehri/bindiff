package com.google.security.zynamics.bindiff.gui.components.viewsearchfield;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox$1;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox$InternalKeyListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBox;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextField;

public class TableTextSearchComboBox extends JMemoryBox {
   private static final Color BACKGROUND_COLOR_FAIL;
   private static final Color BACKGROUND_COLOR_SUCCESS;
   private static int SEARCH_STRING_HISTORY_MAX;
   private final ListenerProvider listeners = new ListenerProvider();
   private final TableTextSearchComboBox$InternalKeyListener listener = new TableTextSearchComboBox$InternalKeyListener(this, (TableTextSearchComboBox$1)null);
   private final AbstractTable table;
   private final List affectedColumnIndices;
   private boolean isRegEx;
   private boolean isCaseSensitive;
   private boolean primarySideSearch;
   private boolean secondarySideSearch;
   private boolean temporaryTableUse;

   public TableTextSearchComboBox(AbstractTable var1, List var2) {
      super(SEARCH_STRING_HISTORY_MAX);
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
      this.affectedColumnIndices = (List)Preconditions.checkNotNull(var2);
      this.getEditor().getEditorComponent().addKeyListener(this.listener);
   }

   private String getText() {
      return ((JTextField)this.getEditor().getEditorComponent()).getText();
   }

   private void search(boolean var1) {
      List var2 = this.search(this.getText());
      if(var2.size() == 0) {
         this.getEditor().getEditorComponent().setBackground(BACKGROUND_COLOR_FAIL);
      } else {
         Iterator var3 = this.listeners.iterator();

         while(var3.hasNext()) {
            IViewSearchFieldListener var4 = (IViewSearchFieldListener)var3.next();
            var4.searched(var2, var1);
         }

         this.getEditor().getEditorComponent().setBackground(BACKGROUND_COLOR_SUCCESS);
      }

   }

   private List search(String var1) {
      // $FF: Couldn't be decompiled
   }

   public void addListener(IViewSearchFieldListener var1) {
      this.listeners.addListener(var1);
   }

   public boolean isCaseSensitive() {
      return this.isCaseSensitive;
   }

   public boolean isPrimarySideSearch() {
      return this.primarySideSearch;
   }

   public boolean isRegEx() {
      return this.isRegEx;
   }

   public boolean isSecondarySideSearch() {
      return this.secondarySideSearch;
   }

   public boolean isTemporaryTableUse() {
      return this.temporaryTableUse;
   }

   public void removeListener(IViewSearchFieldListener var1) {
      this.listeners.removeListener(var1);
   }

   public void reset() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         IViewSearchFieldListener var2 = (IViewSearchFieldListener)var1.next();
         var2.reset();
      }

   }

   public void setSearchOptions(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.isRegEx = var1;
      this.isCaseSensitive = var2;
      this.primarySideSearch = var3;
      this.secondarySideSearch = var4;
      this.temporaryTableUse = var5;
      this.search(this.getText());
   }

   public void updateResults() {
      if(!"".equals(this.getText())) {
         this.search(false);
      }

   }

   // $FF: synthetic method
   static String access$100(TableTextSearchComboBox var0) {
      return var0.getText();
   }

   // $FF: synthetic method
   static ListenerProvider access$200(TableTextSearchComboBox var0) {
      return var0.listeners;
   }

   // $FF: synthetic method
   static Color access$300() {
      return BACKGROUND_COLOR_SUCCESS;
   }

   // $FF: synthetic method
   static void access$400(TableTextSearchComboBox var0, boolean var1) {
      var0.search(var1);
   }

   static {
      BACKGROUND_COLOR_FAIL = Colors.GRAY224;
      BACKGROUND_COLOR_SUCCESS = Color.WHITE;
      SEARCH_STRING_HISTORY_MAX = 30;
   }
}
