package com.google.security.zynamics.zylib.gui.tables;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.tables.CTableSearcher;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CActionSearch extends AbstractAction {
   private static final long serialVersionUID = -2773135367074178821L;
   private final CTableSearcher m_tableSearcher;

   public CActionSearch(CTableSearcher var1) {
      super("Search");
      this.m_tableSearcher = (CTableSearcher)Preconditions.checkNotNull(var1, "Internal Error: Table Searcher can\'t be null");
   }

   public void actionPerformed(ActionEvent var1) {
      this.m_tableSearcher.search();
   }
}
