package org.jfree.base.modules;

import org.jfree.base.modules.ModuleInfo;
import org.jfree.base.modules.SubSystem;

public interface Module extends ModuleInfo {
   ModuleInfo[] getRequiredModules();

   ModuleInfo[] getOptionalModules();

   void initialize(SubSystem var1);

   void configure(SubSystem var1);

   String getDescription();

   String getProducer();

   String getName();

   String getSubSystem();
}
