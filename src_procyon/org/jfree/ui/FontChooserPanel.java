package org.jfree.ui;

import java.util.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;

public class FontChooserPanel extends JPanel
{
    public static final String[] SIZES;
    private JList fontlist;
    private JList sizelist;
    private JCheckBox bold;
    private JCheckBox italic;
    protected static ResourceBundle localizationResources;
    
    public FontChooserPanel(final Font selectedFont) {
        final String[] availableFontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), FontChooserPanel.localizationResources.getString("Font")));
        this.fontlist = new JList(availableFontFamilyNames);
        final JScrollPane scrollPane = new JScrollPane(this.fontlist);
        scrollPane.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(scrollPane);
        this.add(panel2);
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), FontChooserPanel.localizationResources.getString("Size")));
        this.sizelist = new JList((E[])FontChooserPanel.SIZES);
        final JScrollPane scrollPane2 = new JScrollPane(this.sizelist);
        scrollPane2.setBorder(BorderFactory.createEtchedBorder());
        panel3.add(scrollPane2);
        final JPanel panel4 = new JPanel(new GridLayout(1, 2));
        this.bold = new JCheckBox(FontChooserPanel.localizationResources.getString("Bold"));
        this.italic = new JCheckBox(FontChooserPanel.localizationResources.getString("Italic"));
        panel4.add(this.bold);
        panel4.add(this.italic);
        panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), FontChooserPanel.localizationResources.getString("Attributes")));
        panel.add(panel3, "Center");
        panel.add(panel4, "South");
        this.add(panel, "East");
        this.setSelectedFont(selectedFont);
    }
    
    public Font getSelectedFont() {
        return new Font(this.getSelectedName(), this.getSelectedStyle(), this.getSelectedSize());
    }
    
    public String getSelectedName() {
        return this.fontlist.getSelectedValue();
    }
    
    public int getSelectedStyle() {
        if (this.bold.isSelected() && this.italic.isSelected()) {
            return 3;
        }
        if (this.bold.isSelected()) {
            return 1;
        }
        if (this.italic.isSelected()) {
            return 2;
        }
        return 0;
    }
    
    public int getSelectedSize() {
        final String s = this.sizelist.getSelectedValue();
        if (s != null) {
            return Integer.parseInt(s);
        }
        return 10;
    }
    
    public void setSelectedFont(final Font font) {
        if (font == null) {
            throw new NullPointerException();
        }
        this.bold.setSelected(font.isBold());
        this.italic.setSelected(font.isItalic());
        final String name = font.getName();
        final ListModel model = this.fontlist.getModel();
        this.fontlist.clearSelection();
        for (int i = 0; i < model.getSize(); ++i) {
            if (name.equals(model.getElementAt(i))) {
                this.fontlist.setSelectedIndex(i);
                break;
            }
        }
        final String value = String.valueOf(font.getSize());
        final ListModel model2 = this.sizelist.getModel();
        this.sizelist.clearSelection();
        for (int j = 0; j < model2.getSize(); ++j) {
            if (value.equals(model2.getElementAt(j))) {
                this.sizelist.setSelectedIndex(j);
                break;
            }
        }
    }
    
    static {
        SIZES = new String[] { "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "28", "36", "48", "72" };
        FontChooserPanel.localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");
    }
}
