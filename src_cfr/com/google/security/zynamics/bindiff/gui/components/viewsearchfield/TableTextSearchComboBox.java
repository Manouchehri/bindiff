/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.viewsearchfield;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox$1;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.TableTextSearchComboBox$InternalKeyListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.JMemoryBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ComboBoxEditor;
import javax.swing.JTextField;

public class TableTextSearchComboBox
extends JMemoryBox {
    private static final Color BACKGROUND_COLOR_FAIL = Colors.GRAY224;
    private static final Color BACKGROUND_COLOR_SUCCESS = Color.WHITE;
    private static int SEARCH_STRING_HISTORY_MAX = 30;
    private final ListenerProvider listeners = new ListenerProvider();
    private final TableTextSearchComboBox$InternalKeyListener listener;
    private final AbstractTable table;
    private final List affectedColumnIndices;
    private boolean isRegEx;
    private boolean isCaseSensitive;
    private boolean primarySideSearch;
    private boolean secondarySideSearch;
    private boolean temporaryTableUse;

    public TableTextSearchComboBox(AbstractTable abstractTable, List list) {
        super(SEARCH_STRING_HISTORY_MAX);
        this.listener = new TableTextSearchComboBox$InternalKeyListener(this, null);
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.affectedColumnIndices = (List)Preconditions.checkNotNull(list);
        this.getEditor().getEditorComponent().addKeyListener(this.listener);
    }

    private String getText() {
        return ((JTextField)this.getEditor().getEditorComponent()).getText();
    }

    private void search(boolean bl2) {
        List list = this.search(this.getText());
        if (list.size() == 0) {
            this.getEditor().getEditorComponent().setBackground(BACKGROUND_COLOR_FAIL);
            return;
        }
        Iterator iterator = this.listeners.iterator();
        do {
            if (!iterator.hasNext()) {
                this.getEditor().getEditorComponent().setBackground(BACKGROUND_COLOR_SUCCESS);
                return;
            }
            IViewSearchFieldListener iViewSearchFieldListener = (IViewSearchFieldListener)iterator.next();
            iViewSearchFieldListener.searched(list, bl2);
        } while (true);
    }

    private List search(String string) {
        if (!"".equals(string)) {
            this.add(string);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (!this.temporaryTableUse) {
            this.reset();
        }
        int n2 = this.table.getRowCount();
        boolean bl2 = false;
        boolean bl3 = this.primarySideSearch;
        boolean bl4 = this.secondarySideSearch;
        if (!bl3 && !bl4) {
            bl3 = true;
            bl4 = true;
        }
        int n3 = 0;
        while (n3 < n2) {
            String string2 = "";
            for (Object object2 : this.affectedColumnIndices) {
                if (object2.second() == ESide.PRIMARY && bl3) {
                    String string3 = String.valueOf(string2);
                    String string4 = String.valueOf(this.table.getValueAt(n3, (Integer)object2.first()).toString());
                    string2 = string4.length() != 0 ? string3.concat(string4) : new String(string3);
                    continue;
                }
                if (object2.second() != ESide.SECONDARY || !bl4) continue;
                String string5 = String.valueOf(string2);
                String string6 = String.valueOf(this.table.getValueAt(n3, (Integer)object2.first()).toString());
                string2 = string6.length() != 0 ? string5.concat(string6) : new String(string5);
            }
            if (this.isRegEx) {
                Object object2;
                Pattern pattern = this.isCaseSensitive ? Pattern.compile(string) : Pattern.compile(string, 2);
                object2 = pattern.matcher(string2);
                bl2 = object2.find(0);
            } else if (this.isCaseSensitive) {
                bl2 = string2.indexOf(string) != -1;
            } else {
                boolean bl5 = bl2 = string2.toLowerCase().indexOf(string.toLowerCase()) != -1;
            }
            if (bl2) {
                arrayList.add(n3);
            }
            ++n3;
        }
        return arrayList;
    }

    public void addListener(IViewSearchFieldListener iViewSearchFieldListener) {
        this.listeners.addListener(iViewSearchFieldListener);
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

    public void removeListener(IViewSearchFieldListener iViewSearchFieldListener) {
        this.listeners.removeListener(iViewSearchFieldListener);
    }

    public void reset() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IViewSearchFieldListener iViewSearchFieldListener = (IViewSearchFieldListener)iterator.next();
            iViewSearchFieldListener.reset();
        }
    }

    public void setSearchOptions(boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.isRegEx = bl2;
        this.isCaseSensitive = bl3;
        this.primarySideSearch = bl4;
        this.secondarySideSearch = bl5;
        this.temporaryTableUse = bl6;
        this.search(this.getText());
    }

    public void updateResults() {
        if ("".equals(this.getText())) return;
        this.search(false);
    }

    static /* synthetic */ String access$100(TableTextSearchComboBox tableTextSearchComboBox) {
        return tableTextSearchComboBox.getText();
    }

    static /* synthetic */ ListenerProvider access$200(TableTextSearchComboBox tableTextSearchComboBox) {
        return tableTextSearchComboBox.listeners;
    }

    static /* synthetic */ Color access$300() {
        return BACKGROUND_COLOR_SUCCESS;
    }

    static /* synthetic */ void access$400(TableTextSearchComboBox tableTextSearchComboBox, boolean bl2) {
        tableTextSearchComboBox.search(bl2);
    }
}

