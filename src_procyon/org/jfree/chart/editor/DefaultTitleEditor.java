package org.jfree.chart.editor;

import java.util.*;
import org.jfree.chart.title.*;
import javax.swing.border.*;
import org.jfree.layout.*;
import java.awt.event.*;
import org.jfree.ui.*;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;

class DefaultTitleEditor extends JPanel implements ActionListener
{
    private boolean showTitle;
    private JCheckBox showTitleCheckBox;
    private JTextField titleField;
    private Font titleFont;
    private JTextField fontfield;
    private JButton selectFontButton;
    private PaintSample titlePaint;
    private JButton selectPaintButton;
    protected static ResourceBundle localizationResources;
    
    public DefaultTitleEditor(final Title title) {
        final TextTitle textTitle = (TextTitle)((title != null) ? title : new TextTitle(DefaultTitleEditor.localizationResources.getString("Title")));
        this.showTitle = (title != null);
        this.titleFont = textTitle.getFont();
        this.titleField = new JTextField(textTitle.getText());
        this.titlePaint = new PaintSample(textTitle.getPaint());
        this.setLayout(new BorderLayout());
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), DefaultTitleEditor.localizationResources.getString("General")));
        final JPanel panel2 = new JPanel(new LCBLayout(4));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panel2.add(new JLabel(DefaultTitleEditor.localizationResources.getString("Show_Title")));
        (this.showTitleCheckBox = new JCheckBox()).setSelected(this.showTitle);
        this.showTitleCheckBox.setActionCommand("ShowTitle");
        this.showTitleCheckBox.addActionListener(this);
        panel2.add(new JPanel());
        panel2.add(this.showTitleCheckBox);
        panel2.add(new JLabel(DefaultTitleEditor.localizationResources.getString("Text")));
        panel2.add(this.titleField);
        panel2.add(new JPanel());
        final JLabel label = new JLabel(DefaultTitleEditor.localizationResources.getString("Font"));
        this.fontfield = new FontDisplayField(this.titleFont);
        (this.selectFontButton = new JButton(DefaultTitleEditor.localizationResources.getString("Select..."))).setActionCommand("SelectFont");
        this.selectFontButton.addActionListener(this);
        panel2.add(label);
        panel2.add(this.fontfield);
        panel2.add(this.selectFontButton);
        final JLabel label2 = new JLabel(DefaultTitleEditor.localizationResources.getString("Color"));
        (this.selectPaintButton = new JButton(DefaultTitleEditor.localizationResources.getString("Select..."))).setActionCommand("SelectPaint");
        this.selectPaintButton.addActionListener(this);
        panel2.add(label2);
        panel2.add(this.titlePaint);
        panel2.add(this.selectPaintButton);
        this.enableOrDisableControls();
        panel.add(panel2);
        this.add(panel, "North");
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
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("SelectFont")) {
            this.attemptFontSelection();
        }
        else if (actionCommand.equals("SelectPaint")) {
            this.attemptPaintSelection();
        }
        else if (actionCommand.equals("ShowTitle")) {
            this.attemptModifyShowTitle();
        }
    }
    
    public void attemptFontSelection() {
        final FontChooserPanel fontChooserPanel = new FontChooserPanel(this.titleFont);
        if (JOptionPane.showConfirmDialog(this, fontChooserPanel, DefaultTitleEditor.localizationResources.getString("Font_Selection"), 2, -1) == 0) {
            this.titleFont = fontChooserPanel.getSelectedFont();
            this.fontfield.setText(this.titleFont.getFontName() + " " + this.titleFont.getSize());
        }
    }
    
    public void attemptPaintSelection() {
        final Paint paint = this.titlePaint.getPaint();
        final Color showDialog = JColorChooser.showDialog(this, DefaultTitleEditor.localizationResources.getString("Title_Color"), (paint instanceof Color) ? ((Color)paint) : Color.blue);
        if (showDialog != null) {
            this.titlePaint.setPaint(showDialog);
        }
    }
    
    private void attemptModifyShowTitle() {
        this.showTitle = this.showTitleCheckBox.isSelected();
        this.enableOrDisableControls();
    }
    
    private void enableOrDisableControls() {
        final boolean enabled = this.showTitle;
        this.titleField.setEnabled(enabled);
        this.selectFontButton.setEnabled(enabled);
        this.selectPaintButton.setEnabled(enabled);
    }
    
    public void setTitleProperties(final JFreeChart freeChart) {
        if (this.showTitle) {
            TextTitle title = freeChart.getTitle();
            if (title == null) {
                title = new TextTitle();
                freeChart.setTitle(title);
            }
            title.setText(this.getTitleText());
            title.setFont(this.getTitleFont());
            title.setPaint(this.getTitlePaint());
        }
        else {
            freeChart.setTitle((TextTitle)null);
        }
    }
    
    static {
        DefaultTitleEditor.localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");
    }
}
