/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base;

import java.util.ArrayList;
import java.util.List;
import org.jfree.base.BasicProjectInfo$OptionalLibraryHolder;
import org.jfree.base.Library;

public class BasicProjectInfo
extends Library {
    private String copyright;
    private List libraries = new ArrayList();
    private List optionalLibraries = new ArrayList();

    public BasicProjectInfo() {
    }

    public BasicProjectInfo(String string, String string2, String string3, String string4) {
        this();
        this.setName(string);
        this.setVersion(string2);
        this.setLicenceName(string3);
        this.setInfo(string4);
    }

    public BasicProjectInfo(String string, String string2, String string3, String string4, String string5) {
        this(string, string2, string5, string3);
        this.setCopyright(string4);
    }

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String string) {
        this.copyright = string;
    }

    @Override
    public void setInfo(String string) {
        super.setInfo(string);
    }

    @Override
    public void setLicenceName(String string) {
        super.setLicenceName(string);
    }

    @Override
    public void setName(String string) {
        super.setName(string);
    }

    @Override
    public void setVersion(String string) {
        super.setVersion(string);
    }

    public Library[] getLibraries() {
        return this.libraries.toArray(new Library[this.libraries.size()]);
    }

    public void addLibrary(Library library) {
        if (library == null) {
            throw new NullPointerException();
        }
        this.libraries.add(library);
    }

    public Library[] getOptionalLibraries() {
        ArrayList<Library> arrayList = new ArrayList<Library>();
        int n2 = 0;
        while (n2 < this.optionalLibraries.size()) {
            BasicProjectInfo$OptionalLibraryHolder basicProjectInfo$OptionalLibraryHolder = (BasicProjectInfo$OptionalLibraryHolder)this.optionalLibraries.get(n2);
            Library library = basicProjectInfo$OptionalLibraryHolder.getLibrary();
            if (library != null) {
                arrayList.add(library);
            }
            ++n2;
        }
        return arrayList.toArray(new Library[arrayList.size()]);
    }

    public void addOptionalLibrary(String string) {
        if (string == null) {
            throw new NullPointerException("Library classname must be given.");
        }
        this.optionalLibraries.add(new BasicProjectInfo$OptionalLibraryHolder(string));
    }

    public void addOptionalLibrary(Library library) {
        if (library == null) {
            throw new NullPointerException("Library must be given.");
        }
        this.optionalLibraries.add(new BasicProjectInfo$OptionalLibraryHolder(library));
    }
}

