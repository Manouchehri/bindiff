package org.jfree.ui.about;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import org.jfree.base.*;

public class LibraryPanel extends JPanel
{
    private JTable table;
    private LibraryTableModel model;
    
    public LibraryPanel(final List list) {
        this.setLayout(new BorderLayout());
        this.model = new LibraryTableModel(list);
        this.table = new JTable(this.model);
        this.add(new JScrollPane(this.table));
    }
    
    public LibraryPanel(final ProjectInfo projectInfo) {
        this(getLibraries(projectInfo));
    }
    
    private static List getLibraries(final ProjectInfo projectInfo) {
        if (projectInfo == null) {
            return new ArrayList();
        }
        final ArrayList list = new ArrayList();
        collectLibraries(projectInfo, list);
        return list;
    }
    
    private static void collectLibraries(final ProjectInfo projectInfo, final List list) {
        final Library[] libraries = projectInfo.getLibraries();
        for (int i = 0; i < libraries.length; ++i) {
            final Library library = libraries[i];
            if (!list.contains(library)) {
                list.add(library);
                if (library instanceof ProjectInfo) {
                    collectLibraries((ProjectInfo)library, list);
                }
            }
        }
        final Library[] optionalLibraries = projectInfo.getOptionalLibraries();
        for (int j = 0; j < optionalLibraries.length; ++j) {
            final Library library2 = optionalLibraries[j];
            if (!list.contains(library2)) {
                list.add(library2);
                if (library2 instanceof ProjectInfo) {
                    collectLibraries((ProjectInfo)library2, list);
                }
            }
        }
    }
    
    public LibraryTableModel getModel() {
        return this.model;
    }
    
    protected JTable getTable() {
        return this.table;
    }
}
