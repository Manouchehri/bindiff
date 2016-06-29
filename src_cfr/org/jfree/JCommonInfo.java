/*
 * Decompiled with CFR 0_115.
 */
package org.jfree;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.base.Library;
import org.jfree.ui.about.Contributor;
import org.jfree.ui.about.Licences;
import org.jfree.ui.about.ProjectInfo;

public class JCommonInfo
extends ProjectInfo {
    private static JCommonInfo singleton;
    static Class class$org$jfree$base$BaseBoot;

    public static synchronized JCommonInfo getInstance() {
        if (singleton != null) return singleton;
        singleton = new JCommonInfo();
        return singleton;
    }

    private JCommonInfo() {
        String string = "org.jfree.resources.JCommonResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.jfree.resources.JCommonResources");
        this.setName(resourceBundle.getString("project.name"));
        this.setVersion(resourceBundle.getString("project.version"));
        this.setInfo(resourceBundle.getString("project.info"));
        this.setCopyright(resourceBundle.getString("project.copyright"));
        this.setLicenceName("LGPL");
        this.setLicenceText(Licences.getInstance().getLGPL());
        this.setContributors(Arrays.asList(new Contributor("Anthony Boulestreau", "-"), new Contributor("Jeremy Bowman", "-"), new Contributor("J. David Eisenberg", "-"), new Contributor("Paul English", "-"), new Contributor("David Gilbert", "david.gilbert@object-refinery.com"), new Contributor("Hans-Jurgen Greiner", "-"), new Contributor("Arik Levin", "-"), new Contributor("Achilleus Mantzios", "-"), new Contributor("Thomas Meier", "-"), new Contributor("Aaron Metzger", "-"), new Contributor("Thomas Morgner", "-"), new Contributor("Krzysztof Paz", "-"), new Contributor("Nabuo Tamemasa", "-"), new Contributor("Mark Watson", "-"), new Contributor("Matthew Wright", "-"), new Contributor("Hari", "-"), new Contributor("Sam (oldman)", "-")));
        this.addOptionalLibrary(new Library("JUnit", "3.8", "IBM Public Licence", "http://www.junit.org/"));
        Class class_ = class$org$jfree$base$BaseBoot == null ? (JCommonInfo.class$org$jfree$base$BaseBoot = JCommonInfo.class$("org.jfree.base.BaseBoot")) : class$org$jfree$base$BaseBoot;
        this.setBootClass(class_.getName());
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

