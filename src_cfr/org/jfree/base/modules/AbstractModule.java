/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import org.jfree.base.modules.AbstractModule$ReaderHelper;
import org.jfree.base.modules.DefaultModuleInfo;
import org.jfree.base.modules.Module;
import org.jfree.base.modules.ModuleInfo;
import org.jfree.base.modules.ModuleInitializeException;
import org.jfree.base.modules.ModuleInitializer;
import org.jfree.base.modules.PackageManager;
import org.jfree.base.modules.PackageManager$PackageConfiguration;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.ObjectUtilities;

public abstract class AbstractModule
extends DefaultModuleInfo
implements Module {
    private ModuleInfo[] requiredModules;
    private ModuleInfo[] optionalModules;
    private String name;
    private String description;
    private String producer;
    private String subsystem;

    public AbstractModule() {
        this.setModuleClass(this.getClass().getName());
    }

    protected void loadModuleInfo() {
        InputStream inputStream = ObjectUtilities.getResourceRelativeAsStream("module.properties", this.getClass());
        if (inputStream == null) {
            throw new ModuleInitializeException("File 'module.properties' not found in module package.");
        }
        this.loadModuleInfo(inputStream);
    }

    protected void loadModuleInfo(InputStream inputStream) {
        try {
            if (inputStream == null) {
                throw new NullPointerException("Given InputStream is null.");
            }
            AbstractModule$ReaderHelper abstractModule$ReaderHelper = new AbstractModule$ReaderHelper(new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1")));
            ArrayList<DefaultModuleInfo> arrayList = new ArrayList<DefaultModuleInfo>();
            ArrayList<DefaultModuleInfo> arrayList2 = new ArrayList<DefaultModuleInfo>();
            do {
                if (!abstractModule$ReaderHelper.hasNext()) {
                    abstractModule$ReaderHelper.close();
                    this.optionalModules = arrayList.toArray(new ModuleInfo[arrayList.size()]);
                    this.requiredModules = arrayList2.toArray(new ModuleInfo[arrayList2.size()]);
                    return;
                }
                String string = abstractModule$ReaderHelper.next();
                if (string.startsWith("module-info:")) {
                    this.readModuleInfo(abstractModule$ReaderHelper);
                    continue;
                }
                if (string.startsWith("depends:")) {
                    arrayList2.add(this.readExternalModule(abstractModule$ReaderHelper));
                    continue;
                }
                if (!string.startsWith("optional:")) continue;
                arrayList.add(this.readExternalModule(abstractModule$ReaderHelper));
            } while (true);
        }
        catch (IOException var2_3) {
            throw new ModuleInitializeException("Failed to load properties", var2_3);
        }
    }

    private String readValue(AbstractModule$ReaderHelper abstractModule$ReaderHelper, String string) {
        StringBuffer stringBuffer = new StringBuffer(string.trim());
        boolean bl2 = true;
        while (this.isNextLineValueLine(abstractModule$ReaderHelper)) {
            string = abstractModule$ReaderHelper.next();
            String string2 = string.trim();
            if (string2.length() == 0 && !bl2) {
                stringBuffer.append("\n");
                bl2 = true;
                continue;
            }
            if (!bl2) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(this.parseValue(string2));
            bl2 = false;
        }
        return stringBuffer.toString();
    }

    private boolean isNextLineValueLine(AbstractModule$ReaderHelper abstractModule$ReaderHelper) {
        if (!abstractModule$ReaderHelper.hasNext()) {
            return false;
        }
        String string = abstractModule$ReaderHelper.next();
        if (string == null) {
            return false;
        }
        if (this.parseKey(string) != null) {
            abstractModule$ReaderHelper.pushBack(string);
            return false;
        }
        abstractModule$ReaderHelper.pushBack(string);
        return true;
    }

    private void readModuleInfo(AbstractModule$ReaderHelper abstractModule$ReaderHelper) {
        while (abstractModule$ReaderHelper.hasNext()) {
            String string = abstractModule$ReaderHelper.next();
            if (!Character.isWhitespace(string.charAt(0))) {
                abstractModule$ReaderHelper.pushBack(string);
                return;
            }
            String string2 = string.trim();
            String string3 = this.parseKey(string2);
            if (string3 == null) continue;
            String string4 = this.readValue(abstractModule$ReaderHelper, this.parseValue(string2.trim()));
            if (string3.equals("name")) {
                this.setName(string4);
                continue;
            }
            if (string3.equals("producer")) {
                this.setProducer(string4);
                continue;
            }
            if (string3.equals("description")) {
                this.setDescription(string4);
                continue;
            }
            if (string3.equals("subsystem")) {
                this.setSubSystem(string4);
                continue;
            }
            if (string3.equals("version.major")) {
                this.setMajorVersion(string4);
                continue;
            }
            if (string3.equals("version.minor")) {
                this.setMinorVersion(string4);
                continue;
            }
            if (!string3.equals("version.patchlevel")) continue;
            this.setPatchLevel(string4);
        }
    }

    private String parseKey(String string) {
        int n2 = string.indexOf(58);
        if (n2 != -1) return string.substring(0, n2);
        return null;
    }

    private String parseValue(String string) {
        int n2 = string.indexOf(58);
        if (n2 == -1) {
            return string;
        }
        if (n2 + 1 != string.length()) return string.substring(n2 + 1);
        return "";
    }

    private DefaultModuleInfo readExternalModule(AbstractModule$ReaderHelper abstractModule$ReaderHelper) {
        DefaultModuleInfo defaultModuleInfo = new DefaultModuleInfo();
        while (abstractModule$ReaderHelper.hasNext()) {
            String string = abstractModule$ReaderHelper.next();
            if (!Character.isWhitespace(string.charAt(0))) {
                abstractModule$ReaderHelper.pushBack(string);
                return defaultModuleInfo;
            }
            String string2 = string.trim();
            String string3 = this.parseKey(string2);
            if (string3 == null) continue;
            String string4 = this.readValue(abstractModule$ReaderHelper, this.parseValue(string2));
            if (string3.equals("module")) {
                defaultModuleInfo.setModuleClass(string4);
                continue;
            }
            if (string3.equals("version.major")) {
                defaultModuleInfo.setMajorVersion(string4);
                continue;
            }
            if (string3.equals("version.minor")) {
                defaultModuleInfo.setMinorVersion(string4);
                continue;
            }
            if (!string3.equals("version.patchlevel")) continue;
            defaultModuleInfo.setPatchLevel(string4);
        }
        return defaultModuleInfo;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setName(String string) {
        this.name = string;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    protected void setDescription(String string) {
        this.description = string;
    }

    @Override
    public String getProducer() {
        return this.producer;
    }

    protected void setProducer(String string) {
        this.producer = string;
    }

    @Override
    public ModuleInfo[] getRequiredModules() {
        ModuleInfo[] arrmoduleInfo = new ModuleInfo[this.requiredModules.length];
        System.arraycopy(this.requiredModules, 0, arrmoduleInfo, 0, this.requiredModules.length);
        return arrmoduleInfo;
    }

    @Override
    public ModuleInfo[] getOptionalModules() {
        ModuleInfo[] arrmoduleInfo = new ModuleInfo[this.optionalModules.length];
        System.arraycopy(this.optionalModules, 0, arrmoduleInfo, 0, this.optionalModules.length);
        return arrmoduleInfo;
    }

    protected void setRequiredModules(ModuleInfo[] arrmoduleInfo) {
        this.requiredModules = new ModuleInfo[arrmoduleInfo.length];
        System.arraycopy(arrmoduleInfo, 0, this.requiredModules, 0, arrmoduleInfo.length);
    }

    public void setOptionalModules(ModuleInfo[] arrmoduleInfo) {
        this.optionalModules = new ModuleInfo[arrmoduleInfo.length];
        System.arraycopy(arrmoduleInfo, 0, this.optionalModules, 0, arrmoduleInfo.length);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Module : ");
        stringBuffer.append(this.getName());
        stringBuffer.append("\n");
        stringBuffer.append("ModuleClass : ");
        stringBuffer.append(this.getModuleClass());
        stringBuffer.append("\n");
        stringBuffer.append("Version: ");
        stringBuffer.append(this.getMajorVersion());
        stringBuffer.append(".");
        stringBuffer.append(this.getMinorVersion());
        stringBuffer.append(".");
        stringBuffer.append(this.getPatchLevel());
        stringBuffer.append("\n");
        stringBuffer.append("Producer: ");
        stringBuffer.append(this.getProducer());
        stringBuffer.append("\n");
        stringBuffer.append("Description: ");
        stringBuffer.append(this.getDescription());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    protected static boolean isClassLoadable(String string) {
        try {
            Thread.currentThread().getContextClassLoader().loadClass(string);
            return true;
        }
        catch (Exception var1_1) {
            return false;
        }
    }

    @Override
    public void configure(SubSystem subSystem) {
        InputStream inputStream = ObjectUtilities.getResourceRelativeAsStream("configuration.properties", this.getClass());
        if (inputStream == null) {
            return;
        }
        subSystem.getPackageManager().getPackageConfiguration().load(inputStream);
    }

    protected void performExternalInitialize(String string) {
        try {
            Class class_ = Thread.currentThread().getContextClassLoader().loadClass(string);
            ModuleInitializer moduleInitializer = (ModuleInitializer)class_.newInstance();
            moduleInitializer.performInit();
            return;
        }
        catch (ModuleInitializeException var2_3) {
            throw var2_3;
        }
        catch (Exception var2_4) {
            throw new ModuleInitializeException("Failed to load specified initializer class.", var2_4);
        }
    }

    @Override
    public String getSubSystem() {
        if (this.subsystem != null) return this.subsystem;
        return this.getName();
    }

    protected void setSubSystem(String string) {
        this.subsystem = string;
    }
}

