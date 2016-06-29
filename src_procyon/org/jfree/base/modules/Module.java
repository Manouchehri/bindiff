package org.jfree.base.modules;

public interface Module extends ModuleInfo
{
    ModuleInfo[] getRequiredModules();
    
    ModuleInfo[] getOptionalModules();
    
    void initialize(final SubSystem p0);
    
    void configure(final SubSystem p0);
    
    String getDescription();
    
    String getProducer();
    
    String getName();
    
    String getSubSystem();
}
