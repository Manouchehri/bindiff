/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;
import org.jfree.base.Library;

public class LibraryTableModel
extends AbstractTableModel {
    private Library[] libraries;
    private String nameColumnLabel;
    private String versionColumnLabel;
    private String licenceColumnLabel;
    private String infoColumnLabel;

    public LibraryTableModel(List list) {
        this.libraries = list.toArray(new Library[list.size()]);
        String string = "org.jfree.ui.about.resources.AboutResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.nameColumnLabel = resourceBundle.getString("libraries-table.column.name");
        this.versionColumnLabel = resourceBundle.getString("libraries-table.column.version");
        this.licenceColumnLabel = resourceBundle.getString("libraries-table.column.licence");
        this.infoColumnLabel = resourceBundle.getString("libraries-table.column.info");
    }

    @Override
    public int getRowCount() {
        return this.libraries.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int n2) {
        String string = null;
        switch (n2) {
            case 0: {
                return this.nameColumnLabel;
            }
            case 1: {
                return this.versionColumnLabel;
            }
            case 2: {
                return this.licenceColumnLabel;
            }
            case 3: {
                string = this.infoColumnLabel;
            }
        }
        return string;
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        String string = null;
        Library library = this.libraries[n2];
        if (n3 == 0) {
            return library.getName();
        }
        if (n3 == 1) {
            return library.getVersion();
        }
        if (n3 == 2) {
            return library.getLicenceName();
        }
        if (n3 != 3) return string;
        return library.getInfo();
    }

    public Library[] getLibraries() {
        return (Library[])this.libraries.clone();
    }
}

