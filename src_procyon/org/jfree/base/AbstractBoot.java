package org.jfree.base;

import org.jfree.base.modules.*;
import java.net.*;
import org.jfree.base.config.*;
import java.util.*;
import java.io.*;
import org.jfree.util.*;

public abstract class AbstractBoot implements SubSystem
{
    private ExtendedConfigurationWrapper extWrapper;
    private PackageManager packageManager;
    private Configuration globalConfig;
    private boolean bootInProgress;
    private boolean bootDone;
    
    public synchronized PackageManager getPackageManager() {
        if (this.packageManager == null) {
            this.packageManager = PackageManager.createInstance(this);
        }
        return this.packageManager;
    }
    
    public synchronized Configuration getGlobalConfig() {
        if (this.globalConfig == null) {
            this.globalConfig = this.loadConfiguration();
        }
        return this.globalConfig;
    }
    
    public final synchronized boolean isBootInProgress() {
        return this.bootInProgress;
    }
    
    public final synchronized boolean isBootDone() {
        return this.bootDone;
    }
    
    protected abstract Configuration loadConfiguration();
    
    public final void start() {
        synchronized (this) {
            if (this.isBootDone()) {
                return;
            }
            while (this.isBootInProgress()) {
                try {
                    this.wait();
                }
                catch (InterruptedException ex) {}
            }
            if (this.isBootDone()) {
                return;
            }
            this.bootInProgress = true;
        }
        final BootableProjectInfo projectInfo = this.getProjectInfo();
        if (projectInfo != null) {
            final BootableProjectInfo[] dependencies = projectInfo.getDependencies();
            for (int i = 0; i < dependencies.length; ++i) {
                final AbstractBoot loadBooter = this.loadBooter(dependencies[i].getBootClass());
                if (loadBooter != null) {
                    synchronized (loadBooter) {
                        loadBooter.start();
                        while (!loadBooter.isBootDone()) {
                            try {
                                loadBooter.wait();
                            }
                            catch (InterruptedException ex2) {}
                        }
                    }
                }
            }
        }
        this.performBoot();
        if (projectInfo != null) {
            Log.info(projectInfo.getName() + " " + projectInfo.getVersion() + " started.");
        }
        else {
            Log.info(this.getClass() + " started.");
        }
        synchronized (this) {
            this.bootInProgress = false;
            this.bootDone = true;
            this.notifyAll();
        }
    }
    
    protected abstract void performBoot();
    
    protected abstract BootableProjectInfo getProjectInfo();
    
    protected AbstractBoot loadBooter(final String s) {
        if (s == null) {
            return null;
        }
        try {
            return (AbstractBoot)ObjectUtilities.getClassLoader(this.getClass()).loadClass(s).getMethod("getInstance", (Class<?>[])null).invoke(null, (Object[])null);
        }
        catch (Exception ex) {
            Log.info("Unable to boot dependent class: " + s);
            return null;
        }
    }
    
    protected Configuration createDefaultHierarchicalConfiguration(final String s, final String s2, final boolean b) {
        final HierarchicalConfiguration hierarchicalConfiguration = new HierarchicalConfiguration();
        if (s != null) {
            final PropertyFileConfiguration propertyFileConfiguration = new PropertyFileConfiguration();
            propertyFileConfiguration.load(s);
            hierarchicalConfiguration.insertConfiguration(propertyFileConfiguration);
            hierarchicalConfiguration.insertConfiguration(this.getPackageManager().getPackageConfiguration());
        }
        if (s2 != null) {
            String substring;
            if (s2.startsWith("/")) {
                substring = s2.substring(1);
            }
            else {
                substring = s2;
            }
            try {
                final Enumeration<URL> resources = ObjectUtilities.getClassLoader(this.getClass()).getResources(substring);
                final ArrayList list = new ArrayList<PropertyFileConfiguration>();
                while (resources.hasMoreElements()) {
                    final URL url = resources.nextElement();
                    try {
                        final PropertyFileConfiguration propertyFileConfiguration2 = new PropertyFileConfiguration();
                        final InputStream openStream = url.openStream();
                        propertyFileConfiguration2.load(openStream);
                        openStream.close();
                        list.add(propertyFileConfiguration2);
                    }
                    catch (IOException ex) {
                        Log.warn("Failed to load the user configuration at " + url, ex);
                    }
                }
                for (int i = list.size() - 1; i >= 0; --i) {
                    hierarchicalConfiguration.insertConfiguration(list.get(i));
                }
            }
            catch (IOException ex2) {
                Log.warn("Failed to lookup the user configurations.", ex2);
            }
        }
        hierarchicalConfiguration.insertConfiguration(new SystemPropertyConfiguration());
        return hierarchicalConfiguration;
    }
    
    public synchronized ExtendedConfiguration getExtendedConfig() {
        if (this.extWrapper == null) {
            this.extWrapper = new ExtendedConfigurationWrapper(this.getGlobalConfig());
        }
        return this.extWrapper;
    }
}
