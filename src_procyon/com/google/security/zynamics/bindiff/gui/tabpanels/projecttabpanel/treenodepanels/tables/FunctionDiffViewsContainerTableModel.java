package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;

public class FunctionDiffViewsContainerTableModel extends AbstractFunctionDiffViewsTableModel
{
    public static final int PRIMARY_IMAGE_NAME = 0;
    public static final int PRIMARY_IMAGE_HASH = 1;
    public static final int SECONDARY_IMAGE_NAME = 2;
    public static final int SECONDARY_IMAGE_HASH = 3;
    public static final int VIEW_NAME = 4;
    public static final int CREATION_DATE = 5;
    private static final String[] COLUMNS;
    private final List sorters;
    
    public FunctionDiffViewsContainerTableModel(final List list) {
        super(list);
        this.sorters = new ArrayList();
    }
    
    @Override
    public int getColumnCount() {
        return FunctionDiffViewsContainerTableModel.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return FunctionDiffViewsContainerTableModel.COLUMNS[n];
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
    public Object getValueAt(final int n, final int n2) {
        final Diff diff = this.functionDiffViewList.get(n);
        final DiffMetaData metaData = diff.getMetaData();
        final String forceFilenameEndsNotWithExtension = CFileUtils.forceFilenameEndsNotWithExtension(diff.getMatchesDatabase().getName(), "BinDiff");
        final Date time = metaData.getDate().getTime();
        switch (n2) {
            case 0: {
                return metaData.getImageName(ESide.PRIMARY);
            }
            case 1: {
                return metaData.getImageHash(ESide.PRIMARY);
            }
            case 2: {
                return metaData.getImageName(ESide.SECONDARY);
            }
            case 3: {
                return metaData.getImageHash(ESide.SECONDARY);
            }
            case 4: {
                return forceFilenameEndsNotWithExtension;
            }
            case 5: {
                return time;
            }
            default: {
                return null;
            }
        }
    }
    
    static {
        COLUMNS = new String[] { "Primary Image Name", "Primary Image Hash", "Secondary Image Name", "Secondary Image Hash", "View Name", "Creation Date" };
    }
}
