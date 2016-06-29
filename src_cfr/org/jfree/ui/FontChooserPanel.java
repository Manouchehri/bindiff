/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.Border;

public class FontChooserPanel
extends JPanel {
    public static final String[] SIZES = new String[]{"9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "28", "36", "48", "72"};
    private JList fontlist;
    private JList sizelist;
    private JCheckBox bold;
    private JCheckBox italic;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

    public FontChooserPanel(Font font) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] arrstring = graphicsEnvironment.getAvailableFontFamilyNames();
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Font")));
        this.fontlist = new JList<String>(arrstring);
        JScrollPane jScrollPane = new JScrollPane(this.fontlist);
        jScrollPane.setBorder(BorderFactory.createEtchedBorder());
        jPanel2.add(jScrollPane);
        this.add(jPanel2);
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Size")));
        this.sizelist = new JList<String>(SIZES);
        JScrollPane jScrollPane2 = new JScrollPane(this.sizelist);
        jScrollPane2.setBorder(BorderFactory.createEtchedBorder());
        jPanel3.add(jScrollPane2);
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2));
        this.bold = new JCheckBox(localizationResources.getString("Bold"));
        this.italic = new JCheckBox(localizationResources.getString("Italic"));
        jPanel4.add(this.bold);
        jPanel4.add(this.italic);
        jPanel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("Attributes")));
        jPanel.add((Component)jPanel3, "Center");
        jPanel.add((Component)jPanel4, "South");
        this.add((Component)jPanel, "East");
        this.setSelectedFont(font);
    }

    public Font getSelectedFont() {
        return new Font(this.getSelectedName(), this.getSelectedStyle(), this.getSelectedSize());
    }

    public String getSelectedName() {
        return (String)this.fontlist.getSelectedValue();
    }

    public int getSelectedStyle() {
        if (this.bold.isSelected() && this.italic.isSelected()) {
            return 3;
        }
        if (this.bold.isSelected()) {
            return 1;
        }
        if (!this.italic.isSelected()) return 0;
        return 2;
    }

    public int getSelectedSize() {
        String string = (String)this.sizelist.getSelectedValue();
        if (string == null) return 10;
        return Integer.parseInt(string);
    }

    public void setSelectedFont(Font font) {
        if (font == null) {
            throw new NullPointerException();
        }
        this.bold.setSelected(font.isBold());
        this.italic.setSelected(font.isItalic());
        String string = font.getName();
        ListModel listModel = this.fontlist.getModel();
        this.fontlist.clearSelection();
        for (int i2 = 0; i2 < listModel.getSize(); ++i2) {
            if (!string.equals(listModel.getElementAt(i2))) continue;
            this.fontlist.setSelectedIndex(i2);
            break;
        }
        String string2 = String.valueOf(font.getSize());
        listModel = this.sizelist.getModel();
        this.sizelist.clearSelection();
        int n2 = 0;
        while (n2 < listModel.getSize()) {
            if (string2.equals(listModel.getElementAt(n2))) {
                this.sizelist.setSelectedIndex(n2);
                return;
            }
            ++n2;
        }
    }
}

