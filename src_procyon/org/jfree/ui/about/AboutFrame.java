package org.jfree.ui.about;

import javax.swing.border.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class AboutFrame extends JFrame
{
    public static final Dimension PREFERRED_SIZE;
    public static final Border STANDARD_BORDER;
    private ResourceBundle resources;
    private String application;
    private String version;
    private String copyright;
    private String info;
    private Image logo;
    private List contributors;
    private String licence;
    
    public AboutFrame(final String s, final ProjectInfo projectInfo) {
        this(s, projectInfo.getName(), "Version " + projectInfo.getVersion(), projectInfo.getInfo(), projectInfo.getLogo(), projectInfo.getCopyright(), projectInfo.getLicenceText(), projectInfo.getContributors(), projectInfo);
    }
    
    public AboutFrame(final String s, final String application, final String version, final String info, final Image logo, final String copyright, final String licence, final List contributors, final ProjectInfo projectInfo) {
        super(s);
        this.application = application;
        this.version = version;
        this.copyright = copyright;
        this.info = info;
        this.logo = logo;
        this.contributors = contributors;
        this.licence = licence;
        this.resources = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        final JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(AboutFrame.STANDARD_BORDER);
        contentPane.add(this.createTabs(projectInfo));
        this.setContentPane(contentPane);
        this.pack();
    }
    
    public Dimension getPreferredSize() {
        return AboutFrame.PREFERRED_SIZE;
    }
    
    private JTabbedPane createTabs(final ProjectInfo projectInfo) {
        final JTabbedPane tabbedPane = new JTabbedPane();
        final JPanel aboutPanel = this.createAboutPanel(projectInfo);
        aboutPanel.setBorder(AboutFrame.STANDARD_BORDER);
        tabbedPane.add(this.resources.getString("about-frame.tab.about"), aboutPanel);
        final SystemPropertiesPanel systemPropertiesPanel = new SystemPropertiesPanel();
        systemPropertiesPanel.setBorder(AboutFrame.STANDARD_BORDER);
        tabbedPane.add(this.resources.getString("about-frame.tab.system"), systemPropertiesPanel);
        return tabbedPane;
    }
    
    private JPanel createAboutPanel(final ProjectInfo projectInfo) {
        final JPanel panel = new JPanel(new BorderLayout());
        final AboutPanel aboutPanel = new AboutPanel(this.application, this.version, this.copyright, this.info, this.logo);
        boolean b = false;
        final JTabbedPane tabbedPane = new JTabbedPane();
        if (this.contributors != null) {
            final ContributorsPanel contributorsPanel = new ContributorsPanel(this.contributors);
            contributorsPanel.setBorder(AboutFrame.STANDARD_BORDER);
            tabbedPane.add(this.resources.getString("about-frame.tab.contributors"), contributorsPanel);
            b = true;
        }
        if (this.licence != null) {
            final JPanel licencePanel = this.createLicencePanel();
            licencePanel.setBorder(AboutFrame.STANDARD_BORDER);
            tabbedPane.add(this.resources.getString("about-frame.tab.licence"), licencePanel);
            b = true;
        }
        if (projectInfo != null) {
            final LibraryPanel libraryPanel = new LibraryPanel(projectInfo);
            libraryPanel.setBorder(AboutFrame.STANDARD_BORDER);
            tabbedPane.add(this.resources.getString("about-frame.tab.libraries"), libraryPanel);
            b = true;
        }
        panel.add(aboutPanel, "North");
        if (b) {
            panel.add(tabbedPane);
        }
        return panel;
    }
    
    private JPanel createLicencePanel() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea(this.licence);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea));
        return panel;
    }
    
    static {
        PREFERRED_SIZE = new Dimension(560, 360);
        STANDARD_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    }
}
