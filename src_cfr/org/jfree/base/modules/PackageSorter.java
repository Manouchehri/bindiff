/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jfree.base.modules.Module;
import org.jfree.base.modules.ModuleInfo;
import org.jfree.base.modules.PackageSorter$SortModule;
import org.jfree.base.modules.PackageState;
import org.jfree.util.Log;
import org.jfree.util.Log$SimpleMessage;

public final class PackageSorter {
    private PackageSorter() {
    }

    public static void sort(List list) {
        PackageSorter$SortModule packageSorter$SortModule;
        int n2;
        int n3;
        HashMap<String, PackageSorter$SortModule> hashMap = new HashMap<String, PackageSorter$SortModule>();
        ArrayList<PackageState> arrayList = new ArrayList<PackageState>();
        ArrayList<PackageSorter$SortModule> arrayList2 = new ArrayList<PackageSorter$SortModule>();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            PackageState packageState = (PackageState)list.get(i2);
            if (packageState.getState() == -2) {
                arrayList.add(packageState);
                continue;
            }
            packageSorter$SortModule = new PackageSorter$SortModule(packageState);
            arrayList2.add(packageSorter$SortModule);
            hashMap.put(packageState.getModule().getModuleClass(), packageSorter$SortModule);
        }
        Object[] arrobject = arrayList2.toArray(new PackageSorter$SortModule[arrayList2.size()]);
        for (n2 = 0; n2 < arrobject.length; ++n2) {
            packageSorter$SortModule = arrobject[n2];
            packageSorter$SortModule.setDependSubsystems(PackageSorter.collectSubsystemModules(packageSorter$SortModule.getState().getModule(), hashMap));
        }
        n2 = 1;
        if (n2 != 0) {
            n2 = 0;
            for (int i3 = 0; i3 < arrobject.length; ++i3) {
                Object object = arrobject[i3];
                int n4 = PackageSorter.searchModulePosition((PackageSorter$SortModule)object, hashMap);
                if (n4 == object.getPosition()) continue;
                object.setPosition(n4);
                n2 = 1;
            }
        }
        Arrays.sort(arrobject);
        list.clear();
        for (n3 = 0; n3 < arrobject.length; ++n3) {
            list.add(arrobject[n3].getState());
        }
        n3 = 0;
        while (n3 < arrayList.size()) {
            list.add(arrayList.get(n3));
            ++n3;
        }
    }

    private static int searchModulePosition(PackageSorter$SortModule packageSorter$SortModule, HashMap hashMap) {
        Object object;
        int n2;
        PackageSorter$SortModule packageSorter$SortModule2;
        Module module = packageSorter$SortModule.getState().getModule();
        int n3 = 0;
        ModuleInfo[] arrmoduleInfo = module.getOptionalModules();
        for (n2 = 0; n2 < arrmoduleInfo.length; ++n2) {
            object = arrmoduleInfo[n2].getModuleClass();
            packageSorter$SortModule2 = (PackageSorter$SortModule)hashMap.get(object);
            if (packageSorter$SortModule2 == null || packageSorter$SortModule2.getPosition() < n3) continue;
            n3 = packageSorter$SortModule2.getPosition() + 1;
        }
        arrmoduleInfo = module.getRequiredModules();
        for (n2 = 0; n2 < arrmoduleInfo.length; ++n2) {
            object = arrmoduleInfo[n2].getModuleClass();
            packageSorter$SortModule2 = (PackageSorter$SortModule)hashMap.get(object);
            if (packageSorter$SortModule2.getPosition() < n3) continue;
            n3 = packageSorter$SortModule2.getPosition() + 1;
        }
        String string = module.getSubSystem();
        object = hashMap.values().iterator();
        while (object.hasNext()) {
            Module module2;
            packageSorter$SortModule2 = (PackageSorter$SortModule)object.next();
            if (packageSorter$SortModule2.getState().getModule() == module || string.equals((module2 = packageSorter$SortModule2.getState().getModule()).getSubSystem()) || !packageSorter$SortModule.getDependSubsystems().contains(module2.getSubSystem()) || PackageSorter.isBaseModule(module2, module) || packageSorter$SortModule2.getPosition() < n3) continue;
            n3 = packageSorter$SortModule2.getPosition() + 1;
        }
        return n3;
    }

    private static boolean isBaseModule(Module module, ModuleInfo moduleInfo) {
        int n2;
        ModuleInfo[] arrmoduleInfo = module.getRequiredModules();
        for (n2 = 0; n2 < arrmoduleInfo.length; ++n2) {
            if (!arrmoduleInfo[n2].getModuleClass().equals(moduleInfo.getModuleClass())) continue;
            return true;
        }
        arrmoduleInfo = module.getOptionalModules();
        n2 = 0;
        while (n2 < arrmoduleInfo.length) {
            if (arrmoduleInfo[n2].getModuleClass().equals(moduleInfo.getModuleClass())) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private static ArrayList collectSubsystemModules(Module module, HashMap hashMap) {
        int n2;
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        ModuleInfo[] arrmoduleInfo = module.getRequiredModules();
        for (n2 = 0; n2 < arrmoduleInfo.length; ++n2) {
            object = (PackageSorter$SortModule)hashMap.get(arrmoduleInfo[n2].getModuleClass());
            if (object == null) {
                Log.warn(new Log$SimpleMessage("A dependent module was not found in the list of known modules.", arrmoduleInfo[n2].getModuleClass()));
                continue;
            }
            arrayList.add(object.getState().getModule().getSubSystem());
        }
        arrmoduleInfo = module.getOptionalModules();
        n2 = 0;
        while (n2 < arrmoduleInfo.length) {
            object = (Module)hashMap.get(arrmoduleInfo[n2].getModuleClass());
            if (object == null) {
                Log.warn("A dependent module was not found in the list of known modules.");
            } else {
                arrayList.add(object.getSubSystem());
            }
            ++n2;
        }
        return arrayList;
    }
}

