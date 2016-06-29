/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import org.jfree.ui.about.AboutPanel;
import org.jfree.ui.about.ContributorsPanel;
import org.jfree.ui.about.LibraryPanel;
import org.jfree.ui.about.ProjectInfo;
import org.jfree.ui.about.SystemPropertiesPanel;

public class AboutFrame
extends JFrame {
    public static final Dimension PREFERRED_SIZE = new Dimension(560, 360);
    public static final Border STANDARD_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    private ResourceBundle resources;
    private String application;
    private String version;
    private String copyright;
    private String info;
    private Image logo;
    private List contributors;
    private String licence;

    public AboutFrame(String string, ProjectInfo projectInfo) {
        this(string, projectInfo.getName(), new StringBuffer().append("Version ").append(projectInfo.getVersion()).toString(), projectInfo.getInfo(), projectInfo.getLogo(), projectInfo.getCopyright(), projectInfo.getLicenceText(), projectInfo.getContributors(), projectInfo);
    }

    public AboutFrame(String string, String string2, String string3, String string4, Image image, String string5, String string6, List list, ProjectInfo projectInfo) {
        super(string);
        this.application = string2;
        this.version = string3;
        this.copyright = string5;
        this.info = string4;
        this.logo = image;
        this.contributors = list;
        this.licence = string6;
        String string7 = "org.jfree.ui.about.resources.AboutResources";
        this.resources = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(STANDARD_BORDER);
        JTabbedPane jTabbedPane = this.createTabs(projectInfo);
        jPanel.add(jTabbedPane);
        this.setContentPane(jPanel);
        this.pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    private JTabbedPane createTabs(ProjectInfo projectInfo) {
        JTabbedPane jTabbedPane = new JTabbedPane();
        JPanel jPanel = this.createAboutPanel(projectInfo);
        jPanel.setBorder(STANDARD_BORDER);
        String string = this.resources.getString("about-frame.tab.about");
        jTabbedPane.add(string, jPanel);
        SystemPropertiesPanel systemPropertiesPanel = new SystemPropertiesPanel();
        systemPropertiesPanel.setBorder(STANDARD_BORDER);
        String string2 = this.resources.getString("about-frame.tab.system");
        jTabbedPane.add(string2, systemPropertiesPanel);
        return jTabbedPane;
    }

    private JPanel createAboutPanel(ProjectInfo projectInfo) {
        JComponent jComponent;
        String string;
        JPanel jPanel = new JPanel(new BorderLayout());
        AboutPanel aboutPanel = new AboutPanel(this.application, this.version, this.copyright, this.info, this.logo);
        boolean bl2 = false;
        JTabbedPane jTabbedPane = new JTabbedPane();
        if (this.contributors != null) {
            jComponent = new ContributorsPanel(this.contributors);
            jComponent.setBorder(STANDARD_BORDER);
            string = this.resources.getString("about-frame.tab.contributors");
            jTabbedPane.add(string, jComponent);
            bl2 = true;
        }
        if (this.licence != null) {
            jComponent = this.createLicencePanel();
            jComponent.setBorder(STANDARD_BORDER);
            string = this.resources.getString("about-frame.tab.licence");
            jTabbedPane.add(string, jComponent);
            bl2 = true;
        }
        if (projectInfo != null) {
            jComponent = new LibraryPanel(projectInfo);
            jComponent.setBorder(STANDARD_BORDER);
            string = this.resources.getString("about-frame.tab.libraries");
            jTabbedPane.add(string, jComponent);
            bl2 = true;
        }
        jPanel.add((Component)aboutPanel, "North");
        if (!bl2) return jPanel;
        jPanel.add(jTabbedPane);
        return jPanel;
    }

    private JPanel createLicencePanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JTextArea jTextArea = new JTextArea(this.licence);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setCaretPosition(0);
        jTextArea.setEditable(false);
        jPanel.add(new JScrollPane(jTextArea));
        return jPanel;
    }
}

