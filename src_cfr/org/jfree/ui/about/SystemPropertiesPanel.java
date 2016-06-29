/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.accessibility.AccessibleContext;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import org.jfree.ui.about.SystemProperties;
import org.jfree.ui.about.SystemPropertiesPanel$1;
import org.jfree.ui.about.SystemPropertiesPanel$PopupListener;

public class SystemPropertiesPanel
extends JPanel {
    private JTable table;
    private JPopupMenu copyPopupMenu;
    private JMenuItem copyMenuItem;
    private SystemPropertiesPanel$PopupListener copyPopupListener;

    public SystemPropertiesPanel() {
        String string = "org.jfree.ui.about.resources.AboutResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.setLayout(new BorderLayout());
        this.table = SystemProperties.createSystemPropertiesTable();
        this.add(new JScrollPane(this.table));
        this.copyPopupMenu = new JPopupMenu();
        String string2 = resourceBundle.getString("system-properties-panel.popup-menu.copy");
        KeyStroke keyStroke = (KeyStroke)resourceBundle.getObject("system-properties-panel.popup-menu.copy.accelerator");
        this.copyMenuItem = new JMenuItem(string2);
        this.copyMenuItem.setAccelerator(keyStroke);
        this.copyMenuItem.getAccessibleContext().setAccessibleDescription(string2);
        this.copyMenuItem.addActionListener(new SystemPropertiesPanel$1(this));
        this.copyPopupMenu.add(this.copyMenuItem);
        this.copyPopupListener = new SystemPropertiesPanel$PopupListener(this);
        this.table.addMouseListener(this.copyPopupListener);
    }

    public void copySystemPropertiesToClipboard() {
        StringBuffer stringBuffer = new StringBuffer();
        ListSelectionModel listSelectionModel = this.table.getSelectionModel();
        int n2 = listSelectionModel.getMinSelectionIndex();
        int n3 = listSelectionModel.getMaxSelectionIndex();
        if (n2 != -1 && n3 != -1) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                for (int i3 = 0; i3 < this.table.getColumnCount(); ++i3) {
                    stringBuffer.append(this.table.getValueAt(i2, i3));
                    if (i3 == 2) continue;
                    stringBuffer.append("\t");
                }
                stringBuffer.append("\n");
            }
        }
        StringSelection stringSelection = new StringSelection(stringBuffer.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }

    protected final JPopupMenu getCopyPopupMenu() {
        return this.copyPopupMenu;
    }

    protected final JTable getTable() {
        return this.table;
    }
}

