package org.jfree.base.modules;

import org.jfree.util.*;

public interface SubSystem
{
    Configuration getGlobalConfig();
    
    ExtendedConfiguration getExtendedConfig();
    
    PackageManager getPackageManager();
}
