/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DateComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class FunctionDiffViewsContainerTableModel
extends AbstractFunctionDiffViewsTableModel {
    public static final int PRIMARY_IMAGE_NAME = 0;
    public static final int PRIMARY_IMAGE_HASH = 1;
    public static final int SECONDARY_IMAGE_NAME = 2;
    public static final int SECONDARY_IMAGE_HASH = 3;
    public static final int VIEW_NAME = 4;
    public static final int CREATION_DATE = 5;
    private static final String[] COLUMNS = new String[]{"Primary Image Name", "Primary Image Hash", "Secondary Image Name", "Secondary Image Hash", "View Name", "Creation Date"};
    private final List sorters = new ArrayList();

    public FunctionDiffViewsContainerTableModel(List list) {
        super(list);
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int n2) {
        return COLUMNS[n2];
    }

    @Override
    public List getSorters() {
        this.sorters.add(new Pair(0, new LexicalComparator()));
        this.sorters.add(new Pair(1, new LexicalComparator()));
        this.sorters.add(new Pair(2, new LexicalComparator()));
        this.sorters.add(new Pair(3, new LexicalComparator()));
        this.sorters.add(new Pair(4, new LexicalComparator()));
        this.sorters.add(new Pair(5, new DateComparator()));
        return this.sorters;
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        Diff diff = (Diff)this.functionDiffViewList.get(n2);
        DiffMetaData diffMetaData = diff.getMetaData();
        String string = CFileUtils.forceFilenameEndsNotWithExtension(diff.getMatchesDatabase().getName(), "BinDiff");
        Date date = diffMetaData.getDate().getTime();
        switch (n3) {
            case 0: {
                return diffMetaData.getImageName(ESide.PRIMARY);
            }
            case 1: {
                return diffMetaData.getImageHash(ESide.PRIMARY);
            }
            case 2: {
                return diffMetaData.getImageName(ESide.SECONDARY);
            }
            case 3: {
                return diffMetaData.getImageHash(ESide.SECONDARY);
            }
            case 4: {
                return string;
            }
            case 5: {
                return date;
            }
        }
        return null;
    }
}

