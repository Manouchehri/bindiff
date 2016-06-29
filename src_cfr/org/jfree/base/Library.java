/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base;

public class Library {
    private String name;
    private String version;
    private String licenceName;
    private String info;

    public Library(String string, String string2, String string3, String string4) {
        this.name = string;
        this.version = string2;
        this.licenceName = string3;
        this.info = string4;
    }

    protected Library() {
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getLicenceName() {
        return this.licenceName;
    }

    public String getInfo() {
        return this.info;
    }

    protected void setInfo(String string) {
        this.info = string;
    }

    protected void setLicenceName(String string) {
        this.licenceName = string;
    }

    protected void setName(String string) {
        this.name = string;
    }

    protected void setVersion(String string) {
        this.version = string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Library library = (Library)object;
        if (this.name != null) {
            if (this.name.equals(library.name)) return true;
            return false;
        }
        if (library.name == null) return true;
        return false;
    }

    public int hashCode() {
        if (this.name == null) return 0;
        int n2 = this.name.hashCode();
        return n2;
    }
}

