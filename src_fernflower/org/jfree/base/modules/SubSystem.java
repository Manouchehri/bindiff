package org.jfree.base.modules;

import org.jfree.base.modules.PackageManager;
import org.jfree.util.Configuration;
import org.jfree.util.ExtendedConfiguration;

public interface SubSystem {
   Configuration getGlobalConfig();

   ExtendedConfiguration getExtendedConfig();

   PackageManager getPackageManager();
}
