/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import org.jfree.base.modules.ModuleInfo;

public class DefaultModuleInfo
implements ModuleInfo {
    private String moduleClass;
    private String majorVersion;
    private String minorVersion;
    private String patchLevel;

    public DefaultModuleInfo() {
    }

    public DefaultModuleInfo(String string, String string2, String string3, String string4) {
        if (string == null) {
            throw new NullPointerException("Module class must not be null.");
        }
        this.moduleClass = string;
        this.majorVersion = string2;
        this.minorVersion = string3;
        this.patchLevel = string4;
    }

    @Override
    public String getModuleClass() {
        return this.moduleClass;
    }

    public void setModuleClass(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.moduleClass = string;
    }

    @Override
    public String getMajorVersion() {
        return this.majorVersion;
    }

    public void setMajorVersion(String string) {
        this.majorVersion = string;
    }

    @Override
    public String getMinorVersion() {
        return this.minorVersion;
    }

    public void setMinorVersion(String string) {
        this.minorVersion = string;
    }

    @Override
    public String getPatchLevel() {
        return this.patchLevel;
    }

    public void setPatchLevel(String string) {
        this.patchLevel = string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DefaultModuleInfo)) {
            return false;
        }
        ModuleInfo moduleInfo = (ModuleInfo)object;
        if (this.moduleClass.equals(moduleInfo.getModuleClass())) return true;
        return false;
    }

    public int hashCode() {
        return this.moduleClass.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getClass().getName());
        stringBuffer.append("={ModuleClass=");
        stringBuffer.append(this.getModuleClass());
        if (this.getMajorVersion() != null) {
            stringBuffer.append("; Version=");
            stringBuffer.append(this.getMajorVersion());
            if (this.getMinorVersion() != null) {
                stringBuffer.append("-");
                stringBuffer.append(this.getMinorVersion());
                if (this.getPatchLevel() != null) {
                    stringBuffer.append("_");
                    stringBuffer.append(this.getPatchLevel());
                }
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

