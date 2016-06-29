/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base;

import java.util.ArrayList;
import org.jfree.base.BasicProjectInfo;
import org.jfree.base.Library;

public class BootableProjectInfo
extends BasicProjectInfo {
    private String bootClass;
    private boolean autoBoot = true;

    public BootableProjectInfo() {
    }

    public BootableProjectInfo(String string, String string2, String string3, String string4) {
        this();
        this.setName(string);
        this.setVersion(string2);
        this.setLicenceName(string3);
        this.setInfo(string4);
    }

    public BootableProjectInfo(String string, String string2, String string3, String string4, String string5) {
        this();
        this.setName(string);
        this.setVersion(string2);
        this.setLicenceName(string5);
        this.setInfo(string3);
        this.setCopyright(string4);
    }

    public BootableProjectInfo[] getDependencies() {
        ArrayList<Library> arrayList = new ArrayList<Library>();
        Library[] arrlibrary = this.getLibraries();
        for (int i2 = 0; i2 < arrlibrary.length; ++i2) {
            Library library = arrlibrary[i2];
            if (!(library instanceof BootableProjectInfo)) continue;
            arrayList.add(library);
        }
        Library[] arrlibrary2 = this.getOptionalLibraries();
        int n2 = 0;
        while (n2 < arrlibrary2.length) {
            Library library = arrlibrary2[n2];
            if (library instanceof BootableProjectInfo) {
                arrayList.add(library);
            }
            ++n2;
        }
        return arrayList.toArray(new BootableProjectInfo[arrayList.size()]);
    }

    public void addDependency(BootableProjectInfo bootableProjectInfo) {
        if (bootableProjectInfo == null) {
            throw new NullPointerException();
        }
        this.addLibrary(bootableProjectInfo);
    }

    public String getBootClass() {
        return this.bootClass;
    }

    public void setBootClass(String string) {
        this.bootClass = string;
    }

    public boolean isAutoBoot() {
        return this.autoBoot;
    }

    public void setAutoBoot(boolean bl2) {
        this.autoBoot = bl2;
    }
}

