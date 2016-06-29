package org.jfree.base.modules;

import java.util.ArrayList;
import java.util.Arrays;
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
   public static void sort(List var0) {
      HashMap var1 = new HashMap();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      PackageSorter$SortModule var6;
      for(int var4 = 0; var4 < var0.size(); ++var4) {
         PackageState var5 = (PackageState)var0.get(var4);
         if(var5.getState() == -2) {
            var2.add(var5);
         } else {
            var6 = new PackageSorter$SortModule(var5);
            var3.add(var6);
            var1.put(var5.getModule().getModuleClass(), var6);
         }
      }

      PackageSorter$SortModule[] var9 = (PackageSorter$SortModule[])((PackageSorter$SortModule[])var3.toArray(new PackageSorter$SortModule[var3.size()]));

      for(int var10 = 0; var10 < var9.length; ++var10) {
         var6 = var9[var10];
         var6.setDependSubsystems(collectSubsystemModules(var6.getState().getModule(), var1));
      }

      boolean var11 = true;

      int var12;
      while(var11) {
         var11 = false;

         for(var12 = 0; var12 < var9.length; ++var12) {
            PackageSorter$SortModule var7 = var9[var12];
            int var8 = searchModulePosition(var7, var1);
            if(var8 != var7.getPosition()) {
               var7.setPosition(var8);
               var11 = true;
            }
         }
      }

      Arrays.sort(var9);
      var0.clear();

      for(var12 = 0; var12 < var9.length; ++var12) {
         var0.add(var9[var12].getState());
      }

      for(var12 = 0; var12 < var2.size(); ++var12) {
         var0.add(var2.get(var12));
      }

   }

   private static int searchModulePosition(PackageSorter$SortModule var0, HashMap var1) {
      Module var2 = var0.getState().getModule();
      int var3 = 0;
      ModuleInfo[] var4 = var2.getOptionalModules();

      int var5;
      String var6;
      PackageSorter$SortModule var7;
      for(var5 = 0; var5 < var4.length; ++var5) {
         var6 = var4[var5].getModuleClass();
         var7 = (PackageSorter$SortModule)var1.get(var6);
         if(var7 != null && var7.getPosition() >= var3) {
            var3 = var7.getPosition() + 1;
         }
      }

      var4 = var2.getRequiredModules();

      for(var5 = 0; var5 < var4.length; ++var5) {
         var6 = var4[var5].getModuleClass();
         var7 = (PackageSorter$SortModule)var1.get(var6);
         if(var7.getPosition() >= var3) {
            var3 = var7.getPosition() + 1;
         }
      }

      String var9 = var2.getSubSystem();
      Iterator var10 = var1.values().iterator();

      while(var10.hasNext()) {
         var7 = (PackageSorter$SortModule)var10.next();
         if(var7.getState().getModule() != var2) {
            Module var8 = var7.getState().getModule();
            if(!var9.equals(var8.getSubSystem()) && var0.getDependSubsystems().contains(var8.getSubSystem()) && !isBaseModule(var8, var2) && var7.getPosition() >= var3) {
               var3 = var7.getPosition() + 1;
            }
         }
      }

      return var3;
   }

   private static boolean isBaseModule(Module var0, ModuleInfo var1) {
      ModuleInfo[] var2 = var0.getRequiredModules();

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if(var2[var3].getModuleClass().equals(var1.getModuleClass())) {
            return true;
         }
      }

      var2 = var0.getOptionalModules();

      for(var3 = 0; var3 < var2.length; ++var3) {
         if(var2[var3].getModuleClass().equals(var1.getModuleClass())) {
            return true;
         }
      }

      return false;
   }

   private static ArrayList collectSubsystemModules(Module var0, HashMap var1) {
      ArrayList var2 = new ArrayList();
      ModuleInfo[] var3 = var0.getRequiredModules();

      int var4;
      for(var4 = 0; var4 < var3.length; ++var4) {
         PackageSorter$SortModule var5 = (PackageSorter$SortModule)var1.get(var3[var4].getModuleClass());
         if(var5 == null) {
            Log.warn(new Log$SimpleMessage("A dependent module was not found in the list of known modules.", var3[var4].getModuleClass()));
         } else {
            var2.add(var5.getState().getModule().getSubSystem());
         }
      }

      var3 = var0.getOptionalModules();

      for(var4 = 0; var4 < var3.length; ++var4) {
         Module var6 = (Module)var1.get(var3[var4].getModuleClass());
         if(var6 == null) {
            Log.warn("A dependent module was not found in the list of known modules.");
         } else {
            var2.add(var6.getSubSystem());
         }
      }

      return var2;
   }
}
