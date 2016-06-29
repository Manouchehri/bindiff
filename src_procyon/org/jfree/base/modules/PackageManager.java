package org.jfree.base.modules;

import org.jfree.base.*;
import org.jfree.base.log.*;
import org.jfree.util.*;
import java.util.*;
import java.io.*;

public final class PackageManager
{
    private static final int RETURN_MODULE_LOADED = 0;
    private static final int RETURN_MODULE_UNKNOWN = 1;
    private static final int RETURN_MODULE_ERROR = 2;
    private final PackageManager$PackageConfiguration packageConfiguration;
    private final ArrayList modules;
    private final ArrayList initSections;
    private AbstractBoot booter;
    private static HashMap instances;
    
    public static PackageManager createInstance(final AbstractBoot abstractBoot) {
        if (PackageManager.instances == null) {
            PackageManager.instances = new HashMap();
            final PackageManager packageManager = new PackageManager(abstractBoot);
            PackageManager.instances.put(abstractBoot, packageManager);
            return packageManager;
        }
        PackageManager packageManager2 = PackageManager.instances.get(abstractBoot);
        if (packageManager2 == null) {
            packageManager2 = new PackageManager(abstractBoot);
            PackageManager.instances.put(abstractBoot, packageManager2);
        }
        return packageManager2;
    }
    
    private PackageManager(final AbstractBoot booter) {
        if (booter == null) {
            throw new NullPointerException();
        }
        this.booter = booter;
        this.packageConfiguration = new PackageManager$PackageConfiguration();
        this.modules = new ArrayList();
        this.initSections = new ArrayList();
    }
    
    public boolean isModuleAvailable(final ModuleInfo moduleInfo) {
        final PackageState[] array = this.modules.toArray(new PackageState[this.modules.size()]);
        for (int i = 0; i < array.length; ++i) {
            final PackageState packageState = array[i];
            if (packageState.getModule().getModuleClass().equals(moduleInfo.getModuleClass())) {
                return packageState.getState() == 2;
            }
        }
        return false;
    }
    
    public void load(final String s) {
        if (this.initSections.contains(s)) {
            return;
        }
        this.initSections.add(s);
        final Configuration globalConfig = this.booter.getGlobalConfig();
        final Iterator propertyKeys = globalConfig.findPropertyKeys(s);
        int n = 0;
        while (propertyKeys.hasNext()) {
            final String s2 = propertyKeys.next();
            if (s2.endsWith(".Module")) {
                final String configProperty = globalConfig.getConfigProperty(s2);
                if (configProperty == null || configProperty.length() <= 0) {
                    continue;
                }
                this.addModule(configProperty);
                ++n;
            }
        }
        Log.debug("Loaded a total of " + n + " modules under prefix: " + s);
    }
    
    public synchronized void initializeModules() {
        PackageSorter.sort(this.modules);
        for (int i = 0; i < this.modules.size(); ++i) {
            final PackageState packageState = this.modules.get(i);
            if (packageState.configure(this.booter)) {
                Log.debug(new Log$SimpleMessage("Conf: ", new PadMessage(packageState.getModule().getModuleClass(), 70), " [", packageState.getModule().getSubSystem(), "]"));
            }
        }
        for (int j = 0; j < this.modules.size(); ++j) {
            final PackageState packageState2 = this.modules.get(j);
            if (packageState2.initialize(this.booter)) {
                Log.debug(new Log$SimpleMessage("Init: ", new PadMessage(packageState2.getModule().getModuleClass(), 70), " [", packageState2.getModule().getSubSystem(), "]"));
            }
        }
    }
    
    public synchronized void addModule(final String s) {
        final ArrayList<Module> list = new ArrayList<Module>();
        if (this.loadModule(new DefaultModuleInfo(s, null, null, null), new ArrayList(), list, false)) {
            for (int i = 0; i < list.size(); ++i) {
                this.modules.add(new PackageState(list.get(i)));
            }
        }
    }
    
    private int containsModule(final ArrayList list, final ModuleInfo moduleInfo) {
        if (list != null) {
            final ModuleInfo[] array = list.toArray(new ModuleInfo[list.size()]);
            for (int i = 0; i < array.length; ++i) {
                if (array[i].getModuleClass().equals(moduleInfo.getModuleClass())) {
                    return 0;
                }
            }
        }
        final PackageState[] array2 = this.modules.toArray(new PackageState[this.modules.size()]);
        int j = 0;
        while (j < array2.length) {
            if (array2[j].getModule().getModuleClass().equals(moduleInfo.getModuleClass())) {
                if (array2[j].getState() == -2) {
                    return 2;
                }
                return 0;
            }
            else {
                ++j;
            }
        }
        return 1;
    }
    
    private void dropFailedModule(final PackageState packageState) {
        if (!this.modules.contains(packageState)) {
            this.modules.add(packageState);
        }
    }
    
    private boolean loadModule(final ModuleInfo moduleInfo, final ArrayList list, final ArrayList list2, final boolean b) {
        try {
            final Module module = (Module)ObjectUtilities.getClassLoader(this.getClass()).loadClass(moduleInfo.getModuleClass()).newInstance();
            if (!this.acceptVersion(moduleInfo, module)) {
                Log.warn("Module " + module.getName() + ": required version: " + moduleInfo + ", but found Version: \n" + module);
                this.dropFailedModule(new PackageState(module, -2));
                return false;
            }
            final int containsModule = this.containsModule(list2, module);
            if (containsModule == 2) {
                Log.debug("Indicated failure for module: " + module.getModuleClass());
                this.dropFailedModule(new PackageState(module, -2));
                return false;
            }
            if (containsModule == 1) {
                if (list.contains(module)) {
                    Log.error(new Log$SimpleMessage("Circular module reference: This module definition is invalid: ", module.getClass()));
                    this.dropFailedModule(new PackageState(module, -2));
                    return false;
                }
                list.add(module);
                final ModuleInfo[] requiredModules = module.getRequiredModules();
                for (int i = 0; i < requiredModules.length; ++i) {
                    if (!this.loadModule(requiredModules[i], list, list2, true)) {
                        Log.debug("Indicated failure for module: " + module.getModuleClass());
                        this.dropFailedModule(new PackageState(module, -2));
                        return false;
                    }
                }
                final ModuleInfo[] optionalModules = module.getOptionalModules();
                for (int j = 0; j < optionalModules.length; ++j) {
                    if (!this.loadModule(optionalModules[j], list, list2, true)) {
                        Log.debug(new Log$SimpleMessage("Optional module: ", optionalModules[j].getModuleClass(), " was not loaded."));
                    }
                }
                if (this.containsModule(list2, module) == 1) {
                    list2.add(module);
                }
                list.remove(module);
            }
            return true;
        }
        catch (ClassNotFoundException ex) {
            if (b) {
                Log.warn(new Log$SimpleMessage("Unresolved dependency for package: ", moduleInfo.getModuleClass()));
            }
            Log.debug(new Log$SimpleMessage("ClassNotFound: ", ex.getMessage()));
            return false;
        }
        catch (Exception ex2) {
            Log.warn(new Log$SimpleMessage("Exception while loading module: ", moduleInfo), ex2);
            return false;
        }
    }
    
    private boolean acceptVersion(final ModuleInfo moduleInfo, final Module module) {
        if (moduleInfo.getMajorVersion() == null) {
            return true;
        }
        if (module.getMajorVersion() == null) {
            Log.warn("Module " + module.getName() + " does not define a major version.");
        }
        else {
            final int acceptVersion = this.acceptVersion(moduleInfo.getMajorVersion(), module.getMajorVersion());
            if (acceptVersion > 0) {
                return false;
            }
            if (acceptVersion < 0) {
                return true;
            }
        }
        if (moduleInfo.getMinorVersion() == null) {
            return true;
        }
        if (module.getMinorVersion() == null) {
            Log.warn("Module " + module.getName() + " does not define a minor version.");
        }
        else {
            final int acceptVersion2 = this.acceptVersion(moduleInfo.getMinorVersion(), module.getMinorVersion());
            if (acceptVersion2 > 0) {
                return false;
            }
            if (acceptVersion2 < 0) {
                return true;
            }
        }
        if (moduleInfo.getPatchLevel() == null) {
            return true;
        }
        if (module.getPatchLevel() == null) {
            Log.debug("Module " + module.getName() + " does not define a patch level.");
        }
        else if (this.acceptVersion(moduleInfo.getPatchLevel(), module.getPatchLevel()) > 0) {
            Log.debug("Did not accept patchlevel: " + moduleInfo.getPatchLevel() + " - " + module.getPatchLevel());
            return false;
        }
        return true;
    }
    
    private int acceptVersion(final String s, final String s2) {
        final int max = Math.max(s.length(), s2.length());
        char[] array;
        char[] array2;
        if (s.length() > s2.length()) {
            array = s.toCharArray();
            array2 = new char[max];
            final int n = s.length() - s2.length();
            Arrays.fill(array2, 0, n, ' ');
            System.arraycopy(array2, n, s2.toCharArray(), 0, s2.length());
        }
        else if (s.length() < s2.length()) {
            array2 = s2.toCharArray();
            array = new char[max];
            final char[] array3 = new char[max];
            final int n2 = s2.length() - s.length();
            Arrays.fill(array3, 0, n2, ' ');
            System.arraycopy(array3, n2, s.toCharArray(), 0, s.length());
        }
        else {
            array2 = s2.toCharArray();
            array = s.toCharArray();
        }
        return new String(array).compareTo(new String(array2));
    }
    
    public PackageManager$PackageConfiguration getPackageConfiguration() {
        return this.packageConfiguration;
    }
    
    public Module[] getAllModules() {
        final Module[] array = new Module[this.modules.size()];
        for (int i = 0; i < this.modules.size(); ++i) {
            array[i] = ((PackageState)this.modules.get(i)).getModule();
        }
        return array;
    }
    
    public Module[] getActiveModules() {
        final ArrayList list = new ArrayList<Module>();
        for (int i = 0; i < this.modules.size(); ++i) {
            final PackageState packageState = this.modules.get(i);
            if (packageState.getState() == 2) {
                list.add(packageState.getModule());
            }
        }
        return list.toArray(new Module[list.size()]);
    }
    
    public void printUsedModules(final PrintStream printStream) {
        final Module[] allModules = this.getAllModules();
        final ArrayList list = new ArrayList<Module>();
        final ArrayList<Module> list2 = new ArrayList<Module>();
        for (int i = 0; i < allModules.length; ++i) {
            if (this.isModuleAvailable(allModules[i])) {
                list.add(allModules[i]);
            }
            else {
                list2.add(allModules[i]);
            }
        }
        printStream.print("Active modules: ");
        printStream.println(list.size());
        printStream.println("----------------------------------------------------------");
        for (int j = 0; j < list.size(); ++j) {
            final Module module = list.get(j);
            printStream.print(new PadMessage(module.getModuleClass(), 70));
            printStream.print(" [");
            printStream.print(module.getSubSystem());
            printStream.println("]");
            printStream.print("  Version: ");
            printStream.print(module.getMajorVersion());
            printStream.print("-");
            printStream.print(module.getMinorVersion());
            printStream.print("-");
            printStream.print(module.getPatchLevel());
            printStream.print(" Producer: ");
            printStream.println(module.getProducer());
            printStream.print("  Description: ");
            printStream.println(module.getDescription());
        }
    }
}
