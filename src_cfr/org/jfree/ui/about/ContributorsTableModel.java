/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;
import org.jfree.ui.about.Contributor;

public class ContributorsTableModel
extends AbstractTableModel {
    private List contributors;
    private String nameColumnLabel;
    private String contactColumnLabel;

    public ContributorsTableModel(List list) {
        this.contributors = list;
        String string = "org.jfree.ui.about.resources.AboutResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.nameColumnLabel = resourceBundle.getString("contributors-table.column.name");
        this.contactColumnLabel = resourceBundle.getString("contributors-table.column.contact");
    }

    @Override
    public int getRowCount() {
        return this.contributors.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int n2) {
        String string = null;
        switch (n2) {
            case 0: {
                return this.nameColumnLabel;
            }
            case 1: {
                string = this.contactColumnLabel;
            }
        }
        return string;
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        String string = null;
        Contributor contributor = (Contributor)this.contributors.get(n2);
        if (n3 == 0) {
            return contributor.getName();
        }
        if (n3 != 1) return string;
        return contributor.getEmail();
    }
}

