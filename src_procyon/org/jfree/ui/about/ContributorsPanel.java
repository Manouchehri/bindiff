package org.jfree.ui.about;

import javax.swing.table.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ContributorsPanel extends JPanel
{
    private JTable table;
    private TableModel model;
    
    public ContributorsPanel(final List list) {
        this.setLayout(new BorderLayout());
        this.model = new ContributorsTableModel(list);
        this.table = new JTable(this.model);
        this.add(new JScrollPane(this.table));
    }
}
