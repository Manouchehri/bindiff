/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.jfree.ui.about.ContributorsTableModel;

public class ContributorsPanel
extends JPanel {
    private JTable table;
    private TableModel model;

    public ContributorsPanel(List list) {
        this.setLayout(new BorderLayout());
        this.model = new ContributorsTableModel(list);
        this.table = new JTable(this.model);
        this.add(new JScrollPane(this.table));
    }
}

