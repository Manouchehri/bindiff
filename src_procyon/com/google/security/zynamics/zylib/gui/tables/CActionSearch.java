package com.google.security.zynamics.zylib.gui.tables;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;

public class CActionSearch extends AbstractAction
{
    private static final long serialVersionUID = -2773135367074178821L;
    private final CTableSearcher m_tableSearcher;
    
    public CActionSearch(final CTableSearcher cTableSearcher) {
        super("Search");
        this.m_tableSearcher = (CTableSearcher)Preconditions.checkNotNull(cTableSearcher, (Object)"Internal Error: Table Searcher can't be null");
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.m_tableSearcher.search();
    }
}
