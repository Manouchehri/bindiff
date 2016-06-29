package org.jfree.base;

import java.util.*;

public class BootableProjectInfo extends BasicProjectInfo
{
    private String bootClass;
    private boolean autoBoot;
    
    public BootableProjectInfo() {
        this.autoBoot = true;
    }
    
    public BootableProjectInfo(final String name, final String version, final String licenceName, final String info) {
        this();
        this.setName(name);
        this.setVersion(version);
        this.setLicenceName(licenceName);
        this.setInfo(info);
    }
    
    public BootableProjectInfo(final String name, final String version, final String info, final String copyright, final String licenceName) {
        this();
        this.setName(name);
        this.setVersion(version);
        this.setLicenceName(licenceName);
        this.setInfo(info);
        this.setCopyright(copyright);
    }
    
    public BootableProjectInfo[] getDependencies() {
        final ArrayList list = new ArrayList<Library>();
        final Library[] libraries = this.getLibraries();
        for (int i = 0; i < libraries.length; ++i) {
            final Library library = libraries[i];
            if (library instanceof BootableProjectInfo) {
                list.add(library);
            }
        }
        final Library[] optionalLibraries = this.getOptionalLibraries();
        for (int j = 0; j < optionalLibraries.length; ++j) {
            final Library library2 = optionalLibraries[j];
            if (library2 instanceof BootableProjectInfo) {
                list.add(library2);
            }
        }
        return list.toArray(new BootableProjectInfo[list.size()]);
    }
    
    public void addDependency(final BootableProjectInfo bootableProjectInfo) {
        if (bootableProjectInfo == null) {
            throw new NullPointerException();
        }
        this.addLibrary(bootableProjectInfo);
    }
    
    public String getBootClass() {
        return this.bootClass;
    }
    
    public void setBootClass(final String bootClass) {
        this.bootClass = bootClass;
    }
    
    public boolean isAutoBoot() {
        return this.autoBoot;
    }
    
    public void setAutoBoot(final boolean autoBoot) {
        this.autoBoot = autoBoot;
    }
}
