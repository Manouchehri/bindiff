package com.google.security.zynamics.bindiff.gui.components.viewsearchfield;

import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.common.base.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.regex.*;
import com.google.security.zynamics.bindiff.resources.*;

public class TableTextSearchComboBox extends JMemoryBox
{
    private static final Color BACKGROUND_COLOR_FAIL;
    private static final Color BACKGROUND_COLOR_SUCCESS;
    private static int SEARCH_STRING_HISTORY_MAX;
    private final ListenerProvider listeners;
    private final TableTextSearchComboBox$InternalKeyListener listener;
    private final AbstractTable table;
    private final List affectedColumnIndices;
    private boolean isRegEx;
    private boolean isCaseSensitive;
    private boolean primarySideSearch;
    private boolean secondarySideSearch;
    private boolean temporaryTableUse;
    
    public TableTextSearchComboBox(final AbstractTable abstractTable, final List list) {
        super(TableTextSearchComboBox.SEARCH_STRING_HISTORY_MAX);
        this.listeners = new ListenerProvider();
        this.listener = new TableTextSearchComboBox$InternalKeyListener(this, null);
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.affectedColumnIndices = (List)Preconditions.checkNotNull(list);
        this.getEditor().getEditorComponent().addKeyListener(this.listener);
    }
    
    private String getText() {
        return ((JTextField)this.getEditor().getEditorComponent()).getText();
    }
    
    private void search(final boolean b) {
        final List search = this.search(this.getText());
        if (search.size() == 0) {
            this.getEditor().getEditorComponent().setBackground(TableTextSearchComboBox.BACKGROUND_COLOR_FAIL);
        }
        else {
            final Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().searched(search, b);
            }
            this.getEditor().getEditorComponent().setBackground(TableTextSearchComboBox.BACKGROUND_COLOR_SUCCESS);
        }
    }
    
    private List search(final String s) {
        if (!"".equals(s)) {
            this.add(s);
        }
        final ArrayList<Integer> list = new ArrayList<Integer>();
        if (!this.temporaryTableUse) {
            this.reset();
        }
        final int rowCount = this.table.getRowCount();
        int primarySideSearch = this.primarySideSearch ? 1 : 0;
        int secondarySideSearch = this.secondarySideSearch ? 1 : 0;
        if (primarySideSearch == 0 && secondarySideSearch == 0) {
            primarySideSearch = 1;
            secondarySideSearch = 1;
        }
        for (int i = 0; i < rowCount; ++i) {
            String s2 = "";
            for (final Pair pair : this.affectedColumnIndices) {
                if (pair.second() == ESide.PRIMARY && primarySideSearch != 0) {
                    final String value = String.valueOf(s2);
                    final String value2 = String.valueOf(this.table.getValueAt(i, (int)pair.first()).toString());
                    s2 = ((value2.length() != 0) ? value.concat(value2) : new String(value));
                }
                else {
                    if (pair.second() != ESide.SECONDARY || secondarySideSearch == 0) {
                        continue;
                    }
                    final String value3 = String.valueOf(s2);
                    final String value4 = String.valueOf(this.table.getValueAt(i, (int)pair.first()).toString());
                    s2 = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
                }
            }
            boolean find;
            if (this.isRegEx) {
                Pattern pattern;
                if (this.isCaseSensitive) {
                    pattern = Pattern.compile(s);
                }
                else {
                    pattern = Pattern.compile(s, 2);
                }
                find = pattern.matcher(s2).find(0);
            }
            else if (this.isCaseSensitive) {
                find = (s2.indexOf(s) != -1);
            }
            else {
                find = (s2.toLowerCase().indexOf(s.toLowerCase()) != -1);
            }
            if (find) {
                list.add(i);
            }
        }
        return list;
    }
    
    public void addListener(final IViewSearchFieldListener viewSearchFieldListener) {
        this.listeners.addListener(viewSearchFieldListener);
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
    
    public void removeListener(final IViewSearchFieldListener viewSearchFieldListener) {
        this.listeners.removeListener(viewSearchFieldListener);
    }
    
    public void reset() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().reset();
        }
    }
    
    public void setSearchOptions(final boolean isRegEx, final boolean isCaseSensitive, final boolean primarySideSearch, final boolean secondarySideSearch, final boolean temporaryTableUse) {
        this.isRegEx = isRegEx;
        this.isCaseSensitive = isCaseSensitive;
        this.primarySideSearch = primarySideSearch;
        this.secondarySideSearch = secondarySideSearch;
        this.temporaryTableUse = temporaryTableUse;
        this.search(this.getText());
    }
    
    public void updateResults() {
        if (!"".equals(this.getText())) {
            this.search(false);
        }
    }
    
    static {
        BACKGROUND_COLOR_FAIL = Colors.GRAY224;
        BACKGROUND_COLOR_SUCCESS = Color.WHITE;
        TableTextSearchComboBox.SEARCH_STRING_HISTORY_MAX = 30;
    }
}
