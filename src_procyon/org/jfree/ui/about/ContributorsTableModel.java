package org.jfree.ui.about;

import javax.swing.table.*;
import java.util.*;

public class ContributorsTableModel extends AbstractTableModel
{
    private List contributors;
    private String nameColumnLabel;
    private String contactColumnLabel;
    
    public ContributorsTableModel(final List contributors) {
        this.contributors = contributors;
        final ResourceBundle bundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.nameColumnLabel = bundle.getString("contributors-table.column.name");
        this.contactColumnLabel = bundle.getString("contributors-table.column.contact");
    }
    
    public int getRowCount() {
        return this.contributors.size();
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    public String getColumnName(final int n) {
        String s = null;
        switch (n) {
            case 0: {
                s = this.nameColumnLabel;
                break;
            }
            case 1: {
                s = this.contactColumnLabel;
                break;
            }
        }
        return s;
    }
    
    public Object getValueAt(final int n, final int n2) {
        Object o = null;
        final Contributor contributor = this.contributors.get(n);
        if (n2 == 0) {
            o = contributor.getName();
        }
        else if (n2 == 1) {
            o = contributor.getEmail();
        }
        return o;
    }
}
