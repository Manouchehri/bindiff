package org.jfree.ui.about;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SystemPropertiesFrame extends JFrame implements ActionListener
{
    private static final String COPY_COMMAND = "COPY";
    private static final String CLOSE_COMMAND = "CLOSE";
    private SystemPropertiesPanel panel;
    
    public SystemPropertiesFrame(final boolean b) {
        final ResourceBundle bundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.setTitle(bundle.getString("system-frame.title"));
        this.setDefaultCloseOperation(2);
        if (b) {
            this.setJMenuBar(this.createMenuBar(bundle));
        }
        final JPanel contentPane = new JPanel(new BorderLayout());
        (this.panel = new SystemPropertiesPanel()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.add(this.panel, "Center");
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        final String string = bundle.getString("system-frame.button.close");
        final Character c = (Character)bundle.getObject("system-frame.button.close.mnemonic");
        final JButton button = new JButton(string);
        button.setMnemonic(c);
        button.setActionCommand("CLOSE");
        button.addActionListener(this);
        panel.add(button, "East");
        contentPane.add(panel, "South");
        this.setContentPane(contentPane);
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("CLOSE")) {
            this.dispose();
        }
        else if (actionCommand.equals("COPY")) {
            this.panel.copySystemPropertiesToClipboard();
        }
    }
    
    private JMenuBar createMenuBar(final ResourceBundle resourceBundle) {
        final JMenuBar menuBar = new JMenuBar();
        final String string = resourceBundle.getString("system-frame.menu.file");
        final Character c = (Character)resourceBundle.getObject("system-frame.menu.file.mnemonic");
        final JMenu menu = new JMenu(string, true);
        menu.setMnemonic(c);
        final JMenuItem menuItem = new JMenuItem(resourceBundle.getString("system-frame.menu.file.close"), (char)resourceBundle.getObject("system-frame.menu.file.close.mnemonic"));
        menuItem.setActionCommand("CLOSE");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        final String string2 = resourceBundle.getString("system-frame.menu.edit");
        final Character c2 = (Character)resourceBundle.getObject("system-frame.menu.edit.mnemonic");
        final JMenu menu2 = new JMenu(string2);
        menu2.setMnemonic(c2);
        final JMenuItem menuItem2 = new JMenuItem(resourceBundle.getString("system-frame.menu.edit.copy"), (char)resourceBundle.getObject("system-frame.menu.edit.copy.mnemonic"));
        menuItem2.setActionCommand("COPY");
        menuItem2.addActionListener(this);
        menu2.add(menuItem2);
        menuBar.add(menu);
        menuBar.add(menu2);
        return menuBar;
    }
}
