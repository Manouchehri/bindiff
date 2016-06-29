package org.jfree.base.modules;

import org.jfree.util.*;
import java.util.*;
import java.io.*;

public abstract class AbstractModule extends DefaultModuleInfo implements Module
{
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
        final InputStream resourceRelativeAsStream = ObjectUtilities.getResourceRelativeAsStream("module.properties", this.getClass());
        if (resourceRelativeAsStream == null) {
            throw new ModuleInitializeException("File 'module.properties' not found in module package.");
        }
        this.loadModuleInfo(resourceRelativeAsStream);
    }
    
    protected void loadModuleInfo(final InputStream inputStream) {
        try {
            if (inputStream == null) {
                throw new NullPointerException("Given InputStream is null.");
            }
            final AbstractModule$ReaderHelper abstractModule$ReaderHelper = new AbstractModule$ReaderHelper(new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1")));
            final ArrayList list = new ArrayList<DefaultModuleInfo>();
            final ArrayList list2 = new ArrayList<DefaultModuleInfo>();
            while (abstractModule$ReaderHelper.hasNext()) {
                final String next = abstractModule$ReaderHelper.next();
                if (next.startsWith("module-info:")) {
                    this.readModuleInfo(abstractModule$ReaderHelper);
                }
                else if (next.startsWith("depends:")) {
                    list2.add(this.readExternalModule(abstractModule$ReaderHelper));
                }
                else {
                    if (!next.startsWith("optional:")) {
                        continue;
                    }
                    list.add(this.readExternalModule(abstractModule$ReaderHelper));
                }
            }
            abstractModule$ReaderHelper.close();
            this.optionalModules = list.toArray(new ModuleInfo[list.size()]);
            this.requiredModules = list2.toArray(new ModuleInfo[list2.size()]);
        }
        catch (IOException ex) {
            throw new ModuleInitializeException("Failed to load properties", ex);
        }
    }
    
    private String readValue(final AbstractModule$ReaderHelper abstractModule$ReaderHelper, String next) {
        final StringBuffer sb = new StringBuffer(next.trim());
        int n = 1;
        while (this.isNextLineValueLine(abstractModule$ReaderHelper)) {
            next = abstractModule$ReaderHelper.next();
            final String trim = next.trim();
            if (trim.length() == 0 && n == 0) {
                sb.append("\n");
                n = 1;
            }
            else {
                if (n == 0) {
                    sb.append(" ");
                }
                sb.append(this.parseValue(trim));
                n = 0;
            }
        }
        return sb.toString();
    }
    
    private boolean isNextLineValueLine(final AbstractModule$ReaderHelper abstractModule$ReaderHelper) {
        if (!abstractModule$ReaderHelper.hasNext()) {
            return false;
        }
        final String next = abstractModule$ReaderHelper.next();
        if (next == null) {
            return false;
        }
        if (this.parseKey(next) != null) {
            abstractModule$ReaderHelper.pushBack(next);
            return false;
        }
        abstractModule$ReaderHelper.pushBack(next);
        return true;
    }
    
    private void readModuleInfo(final AbstractModule$ReaderHelper abstractModule$ReaderHelper) {
        while (abstractModule$ReaderHelper.hasNext()) {
            final String next = abstractModule$ReaderHelper.next();
            if (!Character.isWhitespace(next.charAt(0))) {
                abstractModule$ReaderHelper.pushBack(next);
                return;
            }
            final String trim = next.trim();
            final String key = this.parseKey(trim);
            if (key == null) {
                continue;
            }
            final String value = this.readValue(abstractModule$ReaderHelper, this.parseValue(trim.trim()));
            if (key.equals("name")) {
                this.setName(value);
            }
            else if (key.equals("producer")) {
                this.setProducer(value);
            }
            else if (key.equals("description")) {
                this.setDescription(value);
            }
            else if (key.equals("subsystem")) {
                this.setSubSystem(value);
            }
            else if (key.equals("version.major")) {
                this.setMajorVersion(value);
            }
            else if (key.equals("version.minor")) {
                this.setMinorVersion(value);
            }
            else {
                if (!key.equals("version.patchlevel")) {
                    continue;
                }
                this.setPatchLevel(value);
            }
        }
    }
    
    private String parseKey(final String s) {
        final int index = s.indexOf(58);
        if (index == -1) {
            return null;
        }
        return s.substring(0, index);
    }
    
    private String parseValue(final String s) {
        final int index = s.indexOf(58);
        if (index == -1) {
            return s;
        }
        if (index + 1 == s.length()) {
            return "";
        }
        return s.substring(index + 1);
    }
    
    private DefaultModuleInfo readExternalModule(final AbstractModule$ReaderHelper abstractModule$ReaderHelper) {
        final DefaultModuleInfo defaultModuleInfo = new DefaultModuleInfo();
        while (abstractModule$ReaderHelper.hasNext()) {
            final String next = abstractModule$ReaderHelper.next();
            if (!Character.isWhitespace(next.charAt(0))) {
                abstractModule$ReaderHelper.pushBack(next);
                return defaultModuleInfo;
            }
            final String trim = next.trim();
            final String key = this.parseKey(trim);
            if (key == null) {
                continue;
            }
            final String value = this.readValue(abstractModule$ReaderHelper, this.parseValue(trim));
            if (key.equals("module")) {
                defaultModuleInfo.setModuleClass(value);
            }
            else if (key.equals("version.major")) {
                defaultModuleInfo.setMajorVersion(value);
            }
            else if (key.equals("version.minor")) {
                defaultModuleInfo.setMinorVersion(value);
            }
            else {
                if (!key.equals("version.patchlevel")) {
                    continue;
                }
                defaultModuleInfo.setPatchLevel(value);
            }
        }
        return defaultModuleInfo;
    }
    
    public String getName() {
        return this.name;
    }
    
    protected void setName(final String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    protected void setDescription(final String description) {
        this.description = description;
    }
    
    public String getProducer() {
        return this.producer;
    }
    
    protected void setProducer(final String producer) {
        this.producer = producer;
    }
    
    public ModuleInfo[] getRequiredModules() {
        final ModuleInfo[] array = new ModuleInfo[this.requiredModules.length];
        System.arraycopy(this.requiredModules, 0, array, 0, this.requiredModules.length);
        return array;
    }
    
    public ModuleInfo[] getOptionalModules() {
        final ModuleInfo[] array = new ModuleInfo[this.optionalModules.length];
        System.arraycopy(this.optionalModules, 0, array, 0, this.optionalModules.length);
        return array;
    }
    
    protected void setRequiredModules(final ModuleInfo[] array) {
        System.arraycopy(array, 0, this.requiredModules = new ModuleInfo[array.length], 0, array.length);
    }
    
    public void setOptionalModules(final ModuleInfo[] array) {
        System.arraycopy(array, 0, this.optionalModules = new ModuleInfo[array.length], 0, array.length);
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Module : ");
        sb.append(this.getName());
        sb.append("\n");
        sb.append("ModuleClass : ");
        sb.append(this.getModuleClass());
        sb.append("\n");
        sb.append("Version: ");
        sb.append(this.getMajorVersion());
        sb.append(".");
        sb.append(this.getMinorVersion());
        sb.append(".");
        sb.append(this.getPatchLevel());
        sb.append("\n");
        sb.append("Producer: ");
        sb.append(this.getProducer());
        sb.append("\n");
        sb.append("Description: ");
        sb.append(this.getDescription());
        sb.append("\n");
        return sb.toString();
    }
    
    protected static boolean isClassLoadable(final String s) {
        try {
            Thread.currentThread().getContextClassLoader().loadClass(s);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public void configure(final SubSystem subSystem) {
        final InputStream resourceRelativeAsStream = ObjectUtilities.getResourceRelativeAsStream("configuration.properties", this.getClass());
        if (resourceRelativeAsStream == null) {
            return;
        }
        subSystem.getPackageManager().getPackageConfiguration().load(resourceRelativeAsStream);
    }
    
    protected void performExternalInitialize(final String s) {
        try {
            ((ModuleInitializer)Thread.currentThread().getContextClassLoader().loadClass(s).newInstance()).performInit();
        }
        catch (ModuleInitializeException ex) {
            throw ex;
        }
        catch (Exception ex2) {
            throw new ModuleInitializeException("Failed to load specified initializer class.", ex2);
        }
    }
    
    public String getSubSystem() {
        if (this.subsystem == null) {
            return this.getName();
        }
        return this.subsystem;
    }
    
    protected void setSubSystem(final String subsystem) {
        this.subsystem = subsystem;
    }
}
