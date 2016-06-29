package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.panels.*;
import com.google.security.zynamics.zylib.date.*;
import java.awt.*;
import java.util.*;

public final class CExpiryDialog extends JDialog
{
    private static final long serialVersionUID = -1435517664620963264L;
    private static final String COMPANY_NAME = "Google Inc.";
    private final JCheckBox m_checkBox;
    
    public CExpiryDialog(final JFrame frame, final String s, final Image iconImage, final Image image, final String s2, final CLicenseFile cLicenseFile, final int n, final boolean b) {
        super(frame, s);
        new CDialogEscaper(this);
        this.setModal(true);
        this.setIconImage(iconImage);
        this.m_checkBox = new JCheckBox("Do not show this message again", false);
        this.createDialog(image, s2, cLicenseFile, n, b);
        this.pack();
        this.setResizable(false);
        GuiHelper.centerChildToParent(frame, this, true);
    }
    
    private JPanel createButtonPanel(final boolean b) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JButton defaultButton = new JButton(new CExpiryDialog$InternalButtonListener(this));
        this.getRootPane().setDefaultButton(defaultButton);
        defaultButton.setSize(defaultButton.getPreferredSize());
        if (b) {
            panel.add(this.m_checkBox, "West");
            panel.add(defaultButton, "East");
        }
        else {
            final JPanel panel2 = new JPanel();
            panel2.add(defaultButton);
            panel.add(panel2, "Center");
        }
        return panel;
    }
    
    private void createDialog(final Image image, final String s, final CLicenseFile cLicenseFile, final int n, final boolean b) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder(""));
        final JPanel headPanel = this.createHeadPanel(image, s);
        final JPanel tablePanel = this.createTablePanel(cLicenseFile);
        final JPanel supportStatePanel = this.createSupportStatePanel(cLicenseFile, n);
        panel2.add(headPanel, "North");
        panel2.add(tablePanel, "Center");
        panel2.add(supportStatePanel, "South");
        final JPanel buttonPanel = this.createButtonPanel(b);
        panel.add(panel2, "Center");
        panel.add(buttonPanel, "South");
        this.add(panel, "Center");
    }
    
    private JPanel createHeadPanel(final Image image, final String s) {
        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.GRAY));
        final int stringWidth = this.getFontMetrics(this.getFont()).stringWidth(new StringBuilder(6 + String.valueOf(s).length()).append("   ").append(s).append("   ").toString());
        final int stringWidth2 = this.getFontMetrics(this.getFont()).stringWidth("   Google Inc.   ");
        final JLabel label = new JLabel(new StringBuilder(6 + String.valueOf(s).length()).append("   ").append(s).append("   ").toString(), 4);
        label.setBackground(Color.WHITE);
        final JLabel label2 = new JLabel("   Google Inc.   ", 2);
        label2.setBackground(Color.WHITE);
        final Font font = label.getFont();
        final Font font2 = new Font(font.getName(), 1, font.getSize());
        label.setFont(font2);
        label2.setFont(font2);
        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        if (stringWidth2 > stringWidth) {
            gridBagConstraints.ipadx = stringWidth2 - stringWidth;
        }
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel2.add(label, "Center");
        panel.add(panel2, gridBagConstraints);
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.weighty = 0.0;
        panel.add(new CImagePanel(image), gridBagConstraints);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        if (stringWidth > stringWidth2) {
            gridBagConstraints.ipadx = stringWidth - stringWidth2;
        }
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.WHITE);
        panel3.add(label2, "Center");
        panel.add(panel3, gridBagConstraints);
        return panel;
    }
    
    private JPanel createSupportStatePanel(final CLicenseFile cLicenseFile, final int n) {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 0, 0, 0));
        String string;
        String s;
        if (DateHelpers.getCurrentDate().getTime() > DateHelpers.getDate(cLicenseFile.getValue("SupportExpiryDate"), "YYYY-MM-DD").getTime()) {
            string = "Your support and update plan has expired.";
            s = "To renew, purchase another license from our web site.";
        }
        else {
            final long n2 = CLicenseFileHelpers.calculateRemainingDays(cLicenseFile);
            if (n2 <= n) {
                string = new StringBuilder(66).append("Your support and update plan expires in ").append(n2).append(" days.").toString();
                s = "To renew, purchase another license from our web site.";
            }
            else {
                string = "Your support and update plan is up to date.";
                s = "Please check our web site for updates.";
            }
        }
        final JLabel label = new JLabel(string, 0);
        final JLabel label2 = new JLabel(s, 0);
        label.setBackground(new Color(250, 250, 250));
        label2.setBackground(new Color(250, 250, 250));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel2.setBackground(new Color(245, 245, 245));
        final JPanel panel3 = new JPanel(new GridLayout(2, 1, 0, 0));
        panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel3.setBackground(new Color(245, 245, 245));
        panel3.add(label, "Center");
        panel3.add(label2, "Center");
        panel.add(panel3, "Center");
        return panel;
    }
    
    private JPanel createTablePanel(final CLicenseFile cLicenseFile) {
        final String value = cLicenseFile.getValue("CustomerName");
        final String value2 = cLicenseFile.getValue("CustomerCompany");
        final String value3 = cLicenseFile.getValue("PurchaseDate");
        final String value4 = cLicenseFile.getValue("SupportExpiryDate");
        final JPanel panel = new JPanel(new GridLayout(5, 2, 20, 5));
        panel.setBorder(new EmptyBorder(10, 0, 0, 0));
        panel.add(new JLabel("Licensed to:", 4));
        panel.add(new JLabel(value, 2));
        panel.add(new JLabel("Organization:", 4));
        panel.add(new JLabel((value2 != null) ? value2 : "-", 2));
        final Date date = DateHelpers.getDate(value3, "YYYY-MM-DD");
        final Date date2 = DateHelpers.getDate(value4, "YYYY-MM-DD");
        panel.add(new JLabel("Purchase date:", 4));
        panel.add(new JLabel(DateHelpers.formatDate(date), 2));
        panel.add(new JLabel("Support period expires:", 4));
        panel.add(new JLabel(DateHelpers.formatDate(date2), 2));
        return panel;
    }
    
    public boolean getCheckboxSelection() {
        return this.m_checkBox.isSelected();
    }
}
