/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.ui.about.SystemPropertiesPanel;

public class SystemPropertiesFrame
extends JFrame
implements ActionListener {
    private static final String COPY_COMMAND = "COPY";
    private static final String CLOSE_COMMAND = "CLOSE";
    private SystemPropertiesPanel panel;

    public SystemPropertiesFrame(boolean bl2) {
        String string = "org.jfree.ui.about.resources.AboutResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        String string2 = resourceBundle.getString("system-frame.title");
        this.setTitle(string2);
        this.setDefaultCloseOperation(2);
        if (bl2) {
            this.setJMenuBar(this.createMenuBar(resourceBundle));
        }
        JPanel jPanel = new JPanel(new BorderLayout());
        this.panel = new SystemPropertiesPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel.add((Component)this.panel, "Center");
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        String string3 = resourceBundle.getString("system-frame.button.close");
        Character c2 = (Character)resourceBundle.getObject("system-frame.button.close.mnemonic");
        JButton jButton = new JButton(string3);
        jButton.setMnemonic(c2.charValue());
        jButton.setActionCommand("CLOSE");
        jButton.addActionListener(this);
        jPanel2.add((Component)jButton, "East");
        jPanel.add((Component)jPanel2, "South");
        this.setContentPane(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("CLOSE")) {
            this.dispose();
            return;
        }
        if (!string.equals("COPY")) return;
        this.panel.copySystemPropertiesToClipboard();
    }

    private JMenuBar createMenuBar(ResourceBundle resourceBundle) {
        JMenuBar jMenuBar = new JMenuBar();
        String string = resourceBundle.getString("system-frame.menu.file");
        Character c2 = (Character)resourceBundle.getObject("system-frame.menu.file.mnemonic");
        JMenu jMenu = new JMenu(string, true);
        jMenu.setMnemonic(c2.charValue());
        string = resourceBundle.getString("system-frame.menu.file.close");
        c2 = (Character)resourceBundle.getObject("system-frame.menu.file.close.mnemonic");
        JMenuItem jMenuItem = new JMenuItem(string, c2.charValue());
        jMenuItem.setActionCommand("CLOSE");
        jMenuItem.addActionListener(this);
        jMenu.add(jMenuItem);
        string = resourceBundle.getString("system-frame.menu.edit");
        c2 = (Character)resourceBundle.getObject("system-frame.menu.edit.mnemonic");
        JMenu jMenu2 = new JMenu(string);
        jMenu2.setMnemonic(c2.charValue());
        string = resourceBundle.getString("system-frame.menu.edit.copy");
        c2 = (Character)resourceBundle.getObject("system-frame.menu.edit.copy.mnemonic");
        JMenuItem jMenuItem2 = new JMenuItem(string, c2.charValue());
        jMenuItem2.setActionCommand("COPY");
        jMenuItem2.addActionListener(this);
        jMenu2.add(jMenuItem2);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu2);
        return jMenuBar;
    }
}

