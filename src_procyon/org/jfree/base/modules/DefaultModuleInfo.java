package org.jfree.base.modules;

public class DefaultModuleInfo implements ModuleInfo
{
    private String moduleClass;
    private String majorVersion;
    private String minorVersion;
    private String patchLevel;
    
    public DefaultModuleInfo() {
    }
    
    public DefaultModuleInfo(final String moduleClass, final String majorVersion, final String minorVersion, final String patchLevel) {
        if (moduleClass == null) {
            throw new NullPointerException("Module class must not be null.");
        }
        this.moduleClass = moduleClass;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.patchLevel = patchLevel;
    }
    
    public String getModuleClass() {
        return this.moduleClass;
    }
    
    public void setModuleClass(final String moduleClass) {
        if (moduleClass == null) {
            throw new NullPointerException();
        }
        this.moduleClass = moduleClass;
    }
    
    public String getMajorVersion() {
        return this.majorVersion;
    }
    
    public void setMajorVersion(final String majorVersion) {
        this.majorVersion = majorVersion;
    }
    
    public String getMinorVersion() {
        return this.minorVersion;
    }
    
    public void setMinorVersion(final String minorVersion) {
        this.minorVersion = minorVersion;
    }
    
    public String getPatchLevel() {
        return this.patchLevel;
    }
    
    public void setPatchLevel(final String patchLevel) {
        this.patchLevel = patchLevel;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof DefaultModuleInfo && this.moduleClass.equals(((ModuleInfo)o).getModuleClass()));
    }
    
    public int hashCode() {
        return this.moduleClass.hashCode();
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName());
        sb.append("={ModuleClass=");
        sb.append(this.getModuleClass());
        if (this.getMajorVersion() != null) {
            sb.append("; Version=");
            sb.append(this.getMajorVersion());
            if (this.getMinorVersion() != null) {
                sb.append("-");
                sb.append(this.getMinorVersion());
                if (this.getPatchLevel() != null) {
                    sb.append("_");
                    sb.append(this.getPatchLevel());
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
