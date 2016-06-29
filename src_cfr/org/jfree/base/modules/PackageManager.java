/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.jfree.base.AbstractBoot;
import org.jfree.base.log.PadMessage;
import org.jfree.base.modules.DefaultModuleInfo;
import org.jfree.base.modules.Module;
import org.jfree.base.modules.ModuleInfo;
import org.jfree.base.modules.PackageManager$PackageConfiguration;
import org.jfree.base.modules.PackageSorter;
import org.jfree.base.modules.PackageState;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.Configuration;
import org.jfree.util.Log;
import org.jfree.util.Log$SimpleMessage;
import org.jfree.util.ObjectUtilities;

public final class PackageManager {
    private static final int RETURN_MODULE_LOADED = 0;
    private static final int RETURN_MODULE_UNKNOWN = 1;
    private static final int RETURN_MODULE_ERROR = 2;
    private final PackageManager$PackageConfiguration packageConfiguration;
    private final ArrayList modules;
    private final ArrayList initSections;
    private AbstractBoot booter;
    private static HashMap instances;

    public static PackageManager createInstance(AbstractBoot abstractBoot) {
        if (instances == null) {
            instances = new HashMap();
            PackageManager packageManager = new PackageManager(abstractBoot);
            instances.put(abstractBoot, packageManager);
            return packageManager;
        }
        PackageManager packageManager = (PackageManager)instances.get(abstractBoot);
        if (packageManager != null) return packageManager;
        packageManager = new PackageManager(abstractBoot);
        instances.put(abstractBoot, packageManager);
        return packageManager;
    }

    private PackageManager(AbstractBoot abstractBoot) {
        if (abstractBoot == null) {
            throw new NullPointerException();
        }
        this.booter = abstractBoot;
        this.packageConfiguration = new PackageManager$PackageConfiguration();
        this.modules = new ArrayList();
        this.initSections = new ArrayList();
    }

    public boolean isModuleAvailable(ModuleInfo moduleInfo) {
        PackageState[] arrpackageState = this.modules.toArray(new PackageState[this.modules.size()]);
        int n2 = 0;
        while (n2 < arrpackageState.length) {
            PackageState packageState = arrpackageState[n2];
            if (packageState.getModule().getModuleClass().equals(moduleInfo.getModuleClass())) {
                if (packageState.getState() != 2) return false;
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void load(String string) {
        if (this.initSections.contains(string)) {
            return;
        }
        this.initSections.add(string);
        Configuration configuration = this.booter.getGlobalConfig();
        Iterator iterator = configuration.findPropertyKeys(string);
        int n2 = 0;
        do {
            String string2;
            if (!iterator.hasNext()) {
                Log.debug(new StringBuffer().append("Loaded a total of ").append(n2).append(" modules under prefix: ").append(string).toString());
                return;
            }
            String string3 = (String)iterator.next();
            if (!string3.endsWith(".Module") || (string2 = configuration.getConfigProperty(string3)) == null || string2.length() <= 0) continue;
            this.addModule(string2);
            ++n2;
        } while (true);
    }

    public synchronized void initializeModules() {
        PackageState packageState;
        int n2;
        PackageSorter.sort(this.modules);
        for (n2 = 0; n2 < this.modules.size(); ++n2) {
            packageState = (PackageState)this.modules.get(n2);
            if (!packageState.configure(this.booter)) continue;
            Log.debug(new Log$SimpleMessage("Conf: ", new PadMessage(packageState.getModule().getModuleClass(), 70), " [", packageState.getModule().getSubSystem(), "]"));
        }
        n2 = 0;
        while (n2 < this.modules.size()) {
            packageState = (PackageState)this.modules.get(n2);
            if (packageState.initialize(this.booter)) {
                Log.debug(new Log$SimpleMessage("Init: ", new PadMessage(packageState.getModule().getModuleClass(), 70), " [", packageState.getModule().getSubSystem(), "]"));
            }
            ++n2;
        }
    }

    public synchronized void addModule(String string) {
        DefaultModuleInfo defaultModuleInfo = new DefaultModuleInfo(string, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (!this.loadModule(defaultModuleInfo, new ArrayList(), arrayList, false)) return;
        int n2 = 0;
        while (n2 < arrayList.size()) {
            Module module = (Module)arrayList.get(n2);
            this.modules.add(new PackageState(module));
            ++n2;
        }
    }

    private int containsModule(ArrayList arrayList, ModuleInfo moduleInfo) {
        ModuleInfo[] arrmoduleInfo;
        int n2;
        if (arrayList != null) {
            arrmoduleInfo = arrayList.toArray(new ModuleInfo[arrayList.size()]);
            for (n2 = 0; n2 < arrmoduleInfo.length; ++n2) {
                if (!arrmoduleInfo[n2].getModuleClass().equals(moduleInfo.getModuleClass())) continue;
                return 0;
            }
        }
        arrmoduleInfo = this.modules.toArray(new PackageState[this.modules.size()]);
        n2 = 0;
        while (n2 < arrmoduleInfo.length) {
            if (arrmoduleInfo[n2].getModule().getModuleClass().equals(moduleInfo.getModuleClass())) {
                if (arrmoduleInfo[n2].getState() != -2) return 0;
                return 2;
            }
            ++n2;
        }
        return 1;
    }

    private void dropFailedModule(PackageState packageState) {
        if (this.modules.contains(packageState)) return;
        this.modules.add(packageState);
    }

    private boolean loadModule(ModuleInfo moduleInfo, ArrayList arrayList, ArrayList arrayList2, boolean bl2) {
        try {
            Class class_ = ObjectUtilities.getClassLoader(this.getClass()).loadClass(moduleInfo.getModuleClass());
            Module module = (Module)class_.newInstance();
            if (!this.acceptVersion(moduleInfo, module)) {
                Log.warn(new StringBuffer().append("Module ").append(module.getName()).append(": required version: ").append(moduleInfo).append(", but found Version: \n").append(module).toString());
                PackageState packageState = new PackageState(module, -2);
                this.dropFailedModule(packageState);
                return false;
            }
            int n2 = this.containsModule(arrayList2, module);
            if (n2 == 2) {
                Log.debug(new StringBuffer().append("Indicated failure for module: ").append(module.getModuleClass()).toString());
                PackageState packageState = new PackageState(module, -2);
                this.dropFailedModule(packageState);
                return false;
            }
            if (n2 != 1) return true;
            if (arrayList.contains(module)) {
                Log.error(new Log$SimpleMessage("Circular module reference: This module definition is invalid: ", module.getClass()));
                PackageState packageState = new PackageState(module, -2);
                this.dropFailedModule(packageState);
                return false;
            }
            arrayList.add(module);
            ModuleInfo[] arrmoduleInfo = module.getRequiredModules();
            for (int i2 = 0; i2 < arrmoduleInfo.length; ++i2) {
                if (this.loadModule(arrmoduleInfo[i2], arrayList, arrayList2, true)) continue;
                Log.debug(new StringBuffer().append("Indicated failure for module: ").append(module.getModuleClass()).toString());
                PackageState packageState = new PackageState(module, -2);
                this.dropFailedModule(packageState);
                return false;
            }
            ModuleInfo[] arrmoduleInfo2 = module.getOptionalModules();
            for (int i3 = 0; i3 < arrmoduleInfo2.length; ++i3) {
                if (this.loadModule(arrmoduleInfo2[i3], arrayList, arrayList2, true)) continue;
                Log.debug(new Log$SimpleMessage("Optional module: ", arrmoduleInfo2[i3].getModuleClass(), " was not loaded."));
            }
            if (this.containsModule(arrayList2, module) == 1) {
                arrayList2.add(module);
            }
            arrayList.remove(module);
            return true;
        }
        catch (ClassNotFoundException var5_6) {
            if (bl2) {
                Log.warn(new Log$SimpleMessage("Unresolved dependency for package: ", moduleInfo.getModuleClass()));
            }
            Log.debug(new Log$SimpleMessage("ClassNotFound: ", var5_6.getMessage()));
            return false;
        }
        catch (Exception var5_7) {
            Log.warn(new Log$SimpleMessage("Exception while loading module: ", moduleInfo), var5_7);
            return false;
        }
    }

    private boolean acceptVersion(ModuleInfo moduleInfo, Module module) {
        int n2;
        if (moduleInfo.getMajorVersion() == null) {
            return true;
        }
        if (module.getMajorVersion() == null) {
            Log.warn(new StringBuffer().append("Module ").append(module.getName()).append(" does not define a major version.").toString());
        } else {
            n2 = this.acceptVersion(moduleInfo.getMajorVersion(), module.getMajorVersion());
            if (n2 > 0) {
                return false;
            }
            if (n2 < 0) {
                return true;
            }
        }
        if (moduleInfo.getMinorVersion() == null) {
            return true;
        }
        if (module.getMinorVersion() == null) {
            Log.warn(new StringBuffer().append("Module ").append(module.getName()).append(" does not define a minor version.").toString());
        } else {
            n2 = this.acceptVersion(moduleInfo.getMinorVersion(), module.getMinorVersion());
            if (n2 > 0) {
                return false;
            }
            if (n2 < 0) {
                return true;
            }
        }
        if (moduleInfo.getPatchLevel() == null) {
            return true;
        }
        if (module.getPatchLevel() == null) {
            Log.debug(new StringBuffer().append("Module ").append(module.getName()).append(" does not define a patch level.").toString());
            return true;
        }
        if (this.acceptVersion(moduleInfo.getPatchLevel(), module.getPatchLevel()) <= 0) return true;
        Log.debug(new StringBuffer().append("Did not accept patchlevel: ").append(moduleInfo.getPatchLevel()).append(" - ").append(module.getPatchLevel()).toString());
        return false;
    }

    private int acceptVersion(String string, String string2) {
        char[] arrc;
        char[] arrc2;
        int n2 = Math.max(string.length(), string2.length());
        if (string.length() > string2.length()) {
            arrc2 = string.toCharArray();
            arrc = new char[n2];
            int n3 = string.length() - string2.length();
            Arrays.fill(arrc, 0, n3, ' ');
            System.arraycopy(arrc, n3, string2.toCharArray(), 0, string2.length());
            return new String(arrc2).compareTo(new String(arrc));
        }
        if (string.length() < string2.length()) {
            arrc = string2.toCharArray();
            arrc2 = new char[n2];
            char[] arrc3 = new char[n2];
            int n4 = string2.length() - string.length();
            Arrays.fill(arrc3, 0, n4, ' ');
            System.arraycopy(arrc3, n4, string.toCharArray(), 0, string.length());
            return new String(arrc2).compareTo(new String(arrc));
        }
        arrc = string2.toCharArray();
        arrc2 = string.toCharArray();
        return new String(arrc2).compareTo(new String(arrc));
    }

    public PackageManager$PackageConfiguration getPackageConfiguration() {
        return this.packageConfiguration;
    }

    public Module[] getAllModules() {
        Module[] arrmodule = new Module[this.modules.size()];
        int n2 = 0;
        while (n2 < this.modules.size()) {
            PackageState packageState = (PackageState)this.modules.get(n2);
            arrmodule[n2] = packageState.getModule();
            ++n2;
        }
        return arrmodule;
    }

    public Module[] getActiveModules() {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        int n2 = 0;
        while (n2 < this.modules.size()) {
            PackageState packageState = (PackageState)this.modules.get(n2);
            if (packageState.getState() == 2) {
                arrayList.add(packageState.getModule());
            }
            ++n2;
        }
        return arrayList.toArray(new Module[arrayList.size()]);
    }

    public void printUsedModules(PrintStream printStream) {
        int n2;
        Module[] arrmodule = this.getAllModules();
        ArrayList<Module> arrayList = new ArrayList<Module>();
        ArrayList<Module> arrayList2 = new ArrayList<Module>();
        for (n2 = 0; n2 < arrmodule.length; ++n2) {
            if (this.isModuleAvailable(arrmodule[n2])) {
                arrayList.add(arrmodule[n2]);
                continue;
            }
            arrayList2.add(arrmodule[n2]);
        }
        printStream.print("Active modules: ");
        printStream.println(arrayList.size());
        printStream.println("----------------------------------------------------------");
        n2 = 0;
        while (n2 < arrayList.size()) {
            Module module = (Module)arrayList.get(n2);
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
            ++n2;
        }
    }
}

