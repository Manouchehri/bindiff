/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.layout.LCBLayout;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.FontDisplayField;
import org.jfree.ui.PaintSample;

class DefaultTitleEditor
extends JPanel
implements ActionListener {
    private boolean showTitle;
    private JCheckBox showTitleCheckBox;
    private JTextField titleField;
    private Font titleFont;
    private JTextField fontfield;
    private JButton selectFontButton;
    private PaintSample titlePaint;
    private JButton selectPaintButton;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

    public DefaultTitleEditor(Title title) {
        TextTitle textTitle = title != null ? (TextTitle)title : new TextTitle(localizationResources.getString("Title"));
        this.showTitle = title != null;
        this.titleFont = textTitle.getFont();
        this.titleField = new JTextField(textTitle.getText());
        this.titlePaint = new PaintSample(textTitle.getPaint());
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), localizationResources.getString("General")));
        JPanel jPanel2 = new JPanel(new LCBLayout(4));
        jPanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jPanel2.add(new JLabel(localizationResources.getString("Show_Title")));
        this.showTitleCheckBox = new JCheckBox();
        this.showTitleCheckBox.setSelected(this.showTitle);
        this.showTitleCheckBox.setActionCommand("ShowTitle");
        this.showTitleCheckBox.addActionListener(this);
        jPanel2.add(new JPanel());
        jPanel2.add(this.showTitleCheckBox);
        JLabel jLabel = new JLabel(localizationResources.getString("Text"));
        jPanel2.add(jLabel);
        jPanel2.add(this.titleField);
        jPanel2.add(new JPanel());
        JLabel jLabel2 = new JLabel(localizationResources.getString("Font"));
        this.fontfield = new FontDisplayField(this.titleFont);
        this.selectFontButton = new JButton(localizationResources.getString("Select..."));
        this.selectFontButton.setActionCommand("SelectFont");
        this.selectFontButton.addActionListener(this);
        jPanel2.add(jLabel2);
        jPanel2.add(this.fontfield);
        jPanel2.add(this.selectFontButton);
        JLabel jLabel3 = new JLabel(localizationResources.getString("Color"));
        this.selectPaintButton = new JButton(localizationResources.getString("Select..."));
        this.selectPaintButton.setActionCommand("SelectPaint");
        this.selectPaintButton.addActionListener(this);
        jPanel2.add(jLabel3);
        jPanel2.add(this.titlePaint);
        jPanel2.add(this.selectPaintButton);
        this.enableOrDisableControls();
        jPanel.add(jPanel2);
        this.add((Component)jPanel, "North");
    }

    public String getTitleText() {
        return this.titleField.getText();
    }

    public Font getTitleFont() {
        return this.titleFont;
    }

    public Paint getTitlePaint() {
        return this.titlePaint.getPaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("SelectFont")) {
            this.attemptFontSelection();
            return;
        }
        if (string.equals("SelectPaint")) {
            this.attemptPaintSelection();
            return;
        }
        if (!string.equals("ShowTitle")) return;
        this.attemptModifyShowTitle();
    }

    public void attemptFontSelection() {
        FontChooserPanel fontChooserPanel = new FontChooserPanel(this.titleFont);
        int n2 = JOptionPane.showConfirmDialog(this, fontChooserPanel, localizationResources.getString("Font_Selection"), 2, -1);
        if (n2 != 0) return;
        this.titleFont = fontChooserPanel.getSelectedFont();
        this.fontfield.setText(new StringBuffer().append(this.titleFont.getFontName()).append(" ").append(this.titleFont.getSize()).toString());
    }

    public void attemptPaintSelection() {
        Paint paint = this.titlePaint.getPaint();
        Color color = paint instanceof Color ? (Color)paint : Color.blue;
        Color color2 = JColorChooser.showDialog(this, localizationResources.getString("Title_Color"), color);
        if (color2 == null) return;
        this.titlePaint.setPaint(color2);
    }

    private void attemptModifyShowTitle() {
        this.showTitle = this.showTitleCheckBox.isSelected();
        this.enableOrDisableControls();
    }

    private void enableOrDisableControls() {
        boolean bl2 = this.showTitle;
        this.titleField.setEnabled(bl2);
        this.selectFontButton.setEnabled(bl2);
        this.selectPaintButton.setEnabled(bl2);
    }

    public void setTitleProperties(JFreeChart jFreeChart) {
        if (!this.showTitle) {
            jFreeChart.setTitle((TextTitle)null);
            return;
        }
        TextTitle textTitle = jFreeChart.getTitle();
        if (textTitle == null) {
            textTitle = new TextTitle();
            jFreeChart.setTitle(textTitle);
        }
        textTitle.setText(this.getTitleText());
        textTitle.setFont(this.getTitleFont());
        textTitle.setPaint(this.getTitlePaint());
    }
}

