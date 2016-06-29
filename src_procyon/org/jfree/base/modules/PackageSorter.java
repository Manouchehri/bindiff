package org.jfree.base.modules;

import java.util.*;
import org.jfree.util.*;

public final class PackageSorter
{
    public static void sort(final List list) {
        final HashMap<String, PackageSorter$SortModule> hashMap = new HashMap<String, PackageSorter$SortModule>();
        final ArrayList list2 = new ArrayList<PackageState>();
        final ArrayList list3 = new ArrayList<PackageSorter$SortModule>();
        for (int i = 0; i < list.size(); ++i) {
            final PackageState packageState = list.get(i);
            if (packageState.getState() == -2) {
                list2.add(packageState);
            }
            else {
                final PackageSorter$SortModule packageSorter$SortModule = new PackageSorter$SortModule(packageState);
                list3.add(packageSorter$SortModule);
                hashMap.put(packageState.getModule().getModuleClass(), packageSorter$SortModule);
            }
        }
        final PackageSorter$SortModule[] array = list3.toArray(new PackageSorter$SortModule[list3.size()]);
        for (int j = 0; j < array.length; ++j) {
            final PackageSorter$SortModule packageSorter$SortModule2 = array[j];
            packageSorter$SortModule2.setDependSubsystems(collectSubsystemModules(packageSorter$SortModule2.getState().getModule(), hashMap));
        }
        int k = 1;
        while (k != 0) {
            k = 0;
            for (int l = 0; l < array.length; ++l) {
                final PackageSorter$SortModule packageSorter$SortModule3 = array[l];
                final int searchModulePosition = searchModulePosition(packageSorter$SortModule3, hashMap);
                if (searchModulePosition != packageSorter$SortModule3.getPosition()) {
                    packageSorter$SortModule3.setPosition(searchModulePosition);
                    k = 1;
                }
            }
        }
        Arrays.sort(array);
        list.clear();
        for (int n = 0; n < array.length; ++n) {
            list.add(array[n].getState());
        }
        for (int n2 = 0; n2 < list2.size(); ++n2) {
            list.add(list2.get(n2));
        }
    }
    
    private static int searchModulePosition(final PackageSorter$SortModule packageSorter$SortModule, final HashMap hashMap) {
        final Module module = packageSorter$SortModule.getState().getModule();
        int n = 0;
        final ModuleInfo[] optionalModules = module.getOptionalModules();
        for (int i = 0; i < optionalModules.length; ++i) {
            final PackageSorter$SortModule packageSorter$SortModule2 = hashMap.get(optionalModules[i].getModuleClass());
            if (packageSorter$SortModule2 != null) {
                if (packageSorter$SortModule2.getPosition() >= n) {
                    n = packageSorter$SortModule2.getPosition() + 1;
                }
            }
        }
        final ModuleInfo[] requiredModules = module.getRequiredModules();
        for (int j = 0; j < requiredModules.length; ++j) {
            final PackageSorter$SortModule packageSorter$SortModule3 = hashMap.get(requiredModules[j].getModuleClass());
            if (packageSorter$SortModule3.getPosition() >= n) {
                n = packageSorter$SortModule3.getPosition() + 1;
            }
        }
        final String subSystem = module.getSubSystem();
        for (final PackageSorter$SortModule packageSorter$SortModule4 : hashMap.values()) {
            if (packageSorter$SortModule4.getState().getModule() == module) {
                continue;
            }
            final Module module2 = packageSorter$SortModule4.getState().getModule();
            if (subSystem.equals(module2.getSubSystem())) {
                continue;
            }
            if (!packageSorter$SortModule.getDependSubsystems().contains(module2.getSubSystem()) || isBaseModule(module2, module) || packageSorter$SortModule4.getPosition() < n) {
                continue;
            }
            n = packageSorter$SortModule4.getPosition() + 1;
        }
        return n;
    }
    
    private static boolean isBaseModule(final Module module, final ModuleInfo moduleInfo) {
        final ModuleInfo[] requiredModules = module.getRequiredModules();
        for (int i = 0; i < requiredModules.length; ++i) {
            if (requiredModules[i].getModuleClass().equals(moduleInfo.getModuleClass())) {
                return true;
            }
        }
        final ModuleInfo[] optionalModules = module.getOptionalModules();
        for (int j = 0; j < optionalModules.length; ++j) {
            if (optionalModules[j].getModuleClass().equals(moduleInfo.getModuleClass())) {
                return true;
            }
        }
        return false;
    }
    
    private static ArrayList collectSubsystemModules(final Module module, final HashMap hashMap) {
        final ArrayList<String> list = new ArrayList<String>();
        final ModuleInfo[] requiredModules = module.getRequiredModules();
        for (int i = 0; i < requiredModules.length; ++i) {
            final PackageSorter$SortModule packageSorter$SortModule = hashMap.get(requiredModules[i].getModuleClass());
            if (packageSorter$SortModule == null) {
                Log.warn(new Log$SimpleMessage("A dependent module was not found in the list of known modules.", requiredModules[i].getModuleClass()));
            }
            else {
                list.add(packageSorter$SortModule.getState().getModule().getSubSystem());
            }
        }
        final ModuleInfo[] optionalModules = module.getOptionalModules();
        for (int j = 0; j < optionalModules.length; ++j) {
            final Module module2 = (Module)hashMap.get(optionalModules[j].getModuleClass());
            if (module2 == null) {
                Log.warn("A dependent module was not found in the list of known modules.");
            }
            else {
                list.add(module2.getSubSystem());
            }
        }
        return list;
    }
}
