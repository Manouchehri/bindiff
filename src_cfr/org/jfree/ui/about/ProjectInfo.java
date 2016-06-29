/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.Image;
import java.util.List;
import org.jfree.base.BootableProjectInfo;
import org.jfree.base.Library;
import org.jfree.ui.about.Contributor;

public class ProjectInfo
extends BootableProjectInfo {
    private Image logo;
    private String licenceText;
    private List contributors;

    public ProjectInfo() {
    }

    public ProjectInfo(String string, String string2, String string3, Image image, String string4, String string5, String string6) {
        super(string, string2, string3, string4, string5);
        this.logo = image;
        this.licenceText = string6;
    }

    public Image getLogo() {
        return this.logo;
    }

    public void setLogo(Image image) {
        this.logo = image;
    }

    public String getLicenceText() {
        return this.licenceText;
    }

    public void setLicenceText(String string) {
        this.licenceText = string;
    }

    public List getContributors() {
        return this.contributors;
    }

    public void setContributors(List list) {
        this.contributors = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getName());
        stringBuffer.append(" version ");
        stringBuffer.append(this.getVersion());
        stringBuffer.append(".\n");
        stringBuffer.append(this.getCopyright());
        stringBuffer.append(".\n");
        stringBuffer.append("\n");
        stringBuffer.append("For terms of use, see the licence below.\n");
        stringBuffer.append("\n");
        stringBuffer.append("FURTHER INFORMATION:");
        stringBuffer.append(this.getInfo());
        stringBuffer.append("\n");
        stringBuffer.append("CONTRIBUTORS:");
        if (this.contributors != null) {
            for (Contributor contributor : this.contributors) {
                stringBuffer.append(contributor.getName());
                stringBuffer.append(" (");
                stringBuffer.append(contributor.getEmail());
                stringBuffer.append(").");
            }
        } else {
            stringBuffer.append("None");
        }
        stringBuffer.append("\n");
        stringBuffer.append("OTHER LIBRARIES USED BY ");
        stringBuffer.append(this.getName());
        stringBuffer.append(":");
        Library[] arrlibrary = this.getLibraries();
        if (arrlibrary.length != 0) {
            for (int i2 = 0; i2 < arrlibrary.length; ++i2) {
                Library library = arrlibrary[i2];
                stringBuffer.append(library.getName());
                stringBuffer.append(" ");
                stringBuffer.append(library.getVersion());
                stringBuffer.append(" (");
                stringBuffer.append(library.getInfo());
                stringBuffer.append(").");
            }
        } else {
            stringBuffer.append("None");
        }
        stringBuffer.append("\n");
        stringBuffer.append(this.getName());
        stringBuffer.append(" LICENCE TERMS:");
        stringBuffer.append("\n");
        stringBuffer.append(this.getLicenceText());
        return stringBuffer.toString();
    }
}

