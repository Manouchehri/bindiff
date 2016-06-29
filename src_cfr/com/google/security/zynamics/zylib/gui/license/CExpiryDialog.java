/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.license.CExpiryDialog$InternalButtonListener;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile;
import com.google.security.zynamics.zylib.gui.license.CLicenseFileHelpers;
import com.google.security.zynamics.zylib.gui.panels.CImagePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.Date;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public final class CExpiryDialog
extends JDialog {
    private static final long serialVersionUID = -1435517664620963264L;
    private static final String COMPANY_NAME = "Google Inc.";
    private final JCheckBox m_checkBox;

    public CExpiryDialog(JFrame jFrame, String string, Image image, Image image2, String string2, CLicenseFile cLicenseFile, int n2, boolean bl2) {
        super((Frame)jFrame, string);
        new CDialogEscaper(this);
        this.setModal(true);
        this.setIconImage(image);
        this.m_checkBox = new JCheckBox("Do not show this message again", false);
        this.createDialog(image2, string2, cLicenseFile, n2, bl2);
        this.pack();
        this.setResizable(false);
        GuiHelper.centerChildToParent(jFrame, this, true);
    }

    private JPanel createButtonPanel(boolean bl2) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JButton jButton = new JButton(new CExpiryDialog$InternalButtonListener(this));
        this.getRootPane().setDefaultButton(jButton);
        jButton.setSize(jButton.getPreferredSize());
        if (bl2) {
            jPanel.add((Component)this.m_checkBox, "West");
            jPanel.add((Component)jButton, "East");
            return jPanel;
        }
        JPanel jPanel2 = new JPanel();
        jPanel2.add(jButton);
        jPanel.add((Component)jPanel2, "Center");
        return jPanel;
    }

    private void createDialog(Image image, String string, CLicenseFile cLicenseFile, int n2, boolean bl2) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new TitledBorder(""));
        JPanel jPanel3 = this.createHeadPanel(image, string);
        JPanel jPanel4 = this.createTablePanel(cLicenseFile);
        JPanel jPanel5 = this.createSupportStatePanel(cLicenseFile, n2);
        jPanel2.add((Component)jPanel3, "North");
        jPanel2.add((Component)jPanel4, "Center");
        jPanel2.add((Component)jPanel5, "South");
        JPanel jPanel6 = this.createButtonPanel(bl2);
        jPanel.add((Component)jPanel2, "Center");
        jPanel.add((Component)jPanel6, "South");
        this.add((Component)jPanel, "Center");
    }

    private JPanel createHeadPanel(Image image, String string) {
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.setBackground(Color.WHITE);
        jPanel.setBorder(new LineBorder(Color.GRAY));
        int n2 = this.getFontMetrics(this.getFont()).stringWidth(new StringBuilder(6 + String.valueOf(string).length()).append("   ").append(string).append("   ").toString());
        int n3 = this.getFontMetrics(this.getFont()).stringWidth("   Google Inc.   ");
        JLabel jLabel = new JLabel(new StringBuilder(6 + String.valueOf(string).length()).append("   ").append(string).append("   ").toString(), 4);
        jLabel.setBackground(Color.WHITE);
        JLabel jLabel2 = new JLabel("   Google Inc.   ", 2);
        jLabel2.setBackground(Color.WHITE);
        Font font = jLabel.getFont();
        Font font2 = new Font(font.getName(), 1, font.getSize());
        jLabel.setFont(font2);
        jLabel2.setFont(font2);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        if (n3 > n2) {
            gridBagConstraints.ipadx = n3 - n2;
        }
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBackground(Color.WHITE);
        jPanel2.add((Component)jLabel, "Center");
        jPanel.add((Component)jPanel2, gridBagConstraints);
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.weighty = 0.0;
        CImagePanel cImagePanel = new CImagePanel(image);
        jPanel.add((Component)cImagePanel, gridBagConstraints);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        if (n2 > n3) {
            gridBagConstraints.ipadx = n2 - n3;
        }
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBackground(Color.WHITE);
        jPanel3.add((Component)jLabel2, "Center");
        jPanel.add((Component)jPanel3, gridBagConstraints);
        return jPanel;
    }

    private JPanel createSupportStatePanel(CLicenseFile cLicenseFile, int n2) {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        String string = "";
        String string2 = "";
        String string3 = cLicenseFile.getValue("SupportExpiryDate");
        Date date = DateHelpers.getCurrentDate();
        Date date2 = DateHelpers.getDate(string3, "YYYY-MM-DD");
        if (date.getTime() > date2.getTime()) {
            string = "Your support and update plan has expired.";
            string2 = "To renew, purchase another license from our web site.";
        } else {
            long l2 = CLicenseFileHelpers.calculateRemainingDays(cLicenseFile);
            if (l2 <= (long)n2) {
                string = new StringBuilder(66).append("Your support and update plan expires in ").append(l2).append(" days.").toString();
                string2 = "To renew, purchase another license from our web site.";
            } else {
                string = "Your support and update plan is up to date.";
                string2 = "Please check our web site for updates.";
            }
        }
        JLabel jLabel = new JLabel(string, 0);
        JLabel jLabel2 = new JLabel(string2, 0);
        jLabel.setBackground(new Color(250, 250, 250));
        jLabel2.setBackground(new Color(250, 250, 250));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel2.setBackground(new Color(245, 245, 245));
        JPanel jPanel3 = new JPanel(new GridLayout(2, 1, 0, 0));
        jPanel3.setBorder(new EmptyBorder(5, 5, 5, 5));
        jPanel3.setBackground(new Color(245, 245, 245));
        jPanel3.add((Component)jLabel, "Center");
        jPanel3.add((Component)jLabel2, "Center");
        jPanel.add((Component)jPanel3, "Center");
        return jPanel;
    }

    private JPanel createTablePanel(CLicenseFile cLicenseFile) {
        String string = cLicenseFile.getValue("CustomerName");
        String string2 = cLicenseFile.getValue("CustomerCompany");
        String string3 = cLicenseFile.getValue("PurchaseDate");
        String string4 = cLicenseFile.getValue("SupportExpiryDate");
        JPanel jPanel = new JPanel(new GridLayout(5, 2, 20, 5));
        jPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        jPanel.add(new JLabel("Licensed to:", 4));
        jPanel.add(new JLabel(string, 2));
        jPanel.add(new JLabel("Organization:", 4));
        jPanel.add(new JLabel(string2 != null ? string2 : "-", 2));
        Date date = DateHelpers.getDate(string3, "YYYY-MM-DD");
        Date date2 = DateHelpers.getDate(string4, "YYYY-MM-DD");
        jPanel.add(new JLabel("Purchase date:", 4));
        jPanel.add(new JLabel(DateHelpers.formatDate(date), 2));
        jPanel.add(new JLabel("Support period expires:", 4));
        jPanel.add(new JLabel(DateHelpers.formatDate(date2), 2));
        return jPanel;
    }

    public boolean getCheckboxSelection() {
        return this.m_checkBox.isSelected();
    }
}

