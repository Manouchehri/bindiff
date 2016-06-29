package org.jfree.ui.about;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.*;

public class SystemPropertiesPanel extends JPanel
{
    private JTable table;
    private JPopupMenu copyPopupMenu;
    private JMenuItem copyMenuItem;
    private SystemPropertiesPanel$PopupListener copyPopupListener;
    
    public SystemPropertiesPanel() {
        final ResourceBundle bundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.setLayout(new BorderLayout());
        this.table = SystemProperties.createSystemPropertiesTable();
        this.add(new JScrollPane(this.table));
        this.copyPopupMenu = new JPopupMenu();
        final String string = bundle.getString("system-properties-panel.popup-menu.copy");
        (this.copyMenuItem = new JMenuItem(string)).setAccelerator((KeyStroke)bundle.getObject("system-properties-panel.popup-menu.copy.accelerator"));
        this.copyMenuItem.getAccessibleContext().setAccessibleDescription(string);
        this.copyMenuItem.addActionListener(new SystemPropertiesPanel$1(this));
        this.copyPopupMenu.add(this.copyMenuItem);
        this.copyPopupListener = new SystemPropertiesPanel$PopupListener(this);
        this.table.addMouseListener(this.copyPopupListener);
    }
    
    public void copySystemPropertiesToClipboard() {
        final StringBuffer sb = new StringBuffer();
        final ListSelectionModel selectionModel = this.table.getSelectionModel();
        final int minSelectionIndex = selectionModel.getMinSelectionIndex();
        final int maxSelectionIndex = selectionModel.getMaxSelectionIndex();
        if (minSelectionIndex != -1 && maxSelectionIndex != -1) {
            for (int i = minSelectionIndex; i <= maxSelectionIndex; ++i) {
                for (int j = 0; j < this.table.getColumnCount(); ++j) {
                    sb.append(this.table.getValueAt(i, j));
                    if (j != 2) {
                        sb.append("\t");
                    }
                }
                sb.append("\n");
            }
        }
        final StringSelection stringSelection = new StringSelection(sb.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
    }
    
    protected final JPopupMenu getCopyPopupMenu() {
        return this.copyPopupMenu;
    }
    
    protected final JTable getTable() {
        return this.table;
    }
}
