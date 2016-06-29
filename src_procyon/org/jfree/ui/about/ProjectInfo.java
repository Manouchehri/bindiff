package org.jfree.ui.about;

import java.awt.*;
import java.util.*;
import org.jfree.base.*;

public class ProjectInfo extends BootableProjectInfo
{
    private Image logo;
    private String licenceText;
    private List contributors;
    
    public ProjectInfo() {
    }
    
    public ProjectInfo(final String s, final String s2, final String s3, final Image logo, final String s4, final String s5, final String licenceText) {
        super(s, s2, s3, s4, s5);
        this.logo = logo;
        this.licenceText = licenceText;
    }
    
    public Image getLogo() {
        return this.logo;
    }
    
    public void setLogo(final Image logo) {
        this.logo = logo;
    }
    
    public String getLicenceText() {
        return this.licenceText;
    }
    
    public void setLicenceText(final String licenceText) {
        this.licenceText = licenceText;
    }
    
    public List getContributors() {
        return this.contributors;
    }
    
    public void setContributors(final List contributors) {
        this.contributors = contributors;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.getName());
        sb.append(" version ");
        sb.append(this.getVersion());
        sb.append(".\n");
        sb.append(this.getCopyright());
        sb.append(".\n");
        sb.append("\n");
        sb.append("For terms of use, see the licence below.\n");
        sb.append("\n");
        sb.append("FURTHER INFORMATION:");
        sb.append(this.getInfo());
        sb.append("\n");
        sb.append("CONTRIBUTORS:");
        if (this.contributors != null) {
            for (final Contributor contributor : this.contributors) {
                sb.append(contributor.getName());
                sb.append(" (");
                sb.append(contributor.getEmail());
                sb.append(").");
            }
        }
        else {
            sb.append("None");
        }
        sb.append("\n");
        sb.append("OTHER LIBRARIES USED BY ");
        sb.append(this.getName());
        sb.append(":");
        final Library[] libraries = this.getLibraries();
        if (libraries.length != 0) {
            for (int i = 0; i < libraries.length; ++i) {
                final Library library = libraries[i];
                sb.append(library.getName());
                sb.append(" ");
                sb.append(library.getVersion());
                sb.append(" (");
                sb.append(library.getInfo());
                sb.append(").");
            }
        }
        else {
            sb.append("None");
        }
        sb.append("\n");
        sb.append(this.getName());
        sb.append(" LICENCE TERMS:");
        sb.append("\n");
        sb.append(this.getLicenceText());
        return sb.toString();
    }
}
