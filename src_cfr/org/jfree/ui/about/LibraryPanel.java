/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.jfree.base.Library;
import org.jfree.ui.about.LibraryTableModel;
import org.jfree.ui.about.ProjectInfo;

public class LibraryPanel
extends JPanel {
    private JTable table;
    private LibraryTableModel model;

    public LibraryPanel(List list) {
        this.setLayout(new BorderLayout());
        this.model = new LibraryTableModel(list);
        this.table = new JTable(this.model);
        this.add(new JScrollPane(this.table));
    }

    public LibraryPanel(ProjectInfo projectInfo) {
        this(LibraryPanel.getLibraries(projectInfo));
    }

    private static List getLibraries(ProjectInfo projectInfo) {
        if (projectInfo == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        LibraryPanel.collectLibraries(projectInfo, arrayList);
        return arrayList;
    }

    private static void collectLibraries(ProjectInfo projectInfo, List list) {
        Library library;
        int n2;
        Library[] arrlibrary = projectInfo.getLibraries();
        for (n2 = 0; n2 < arrlibrary.length; ++n2) {
            library = arrlibrary[n2];
            if (list.contains(library)) continue;
            list.add(library);
            if (!(library instanceof ProjectInfo)) continue;
            LibraryPanel.collectLibraries((ProjectInfo)library, list);
        }
        arrlibrary = projectInfo.getOptionalLibraries();
        n2 = 0;
        while (n2 < arrlibrary.length) {
            library = arrlibrary[n2];
            if (!list.contains(library)) {
                list.add(library);
                if (library instanceof ProjectInfo) {
                    LibraryPanel.collectLibraries((ProjectInfo)library, list);
                }
            }
            ++n2;
        }
    }

    public LibraryTableModel getModel() {
        return this.model;
    }

    protected JTable getTable() {
        return this.table;
    }
}

