/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import org.jfree.base.BootableProjectInfo;
import org.jfree.base.config.HierarchicalConfiguration;
import org.jfree.base.config.PropertyFileConfiguration;
import org.jfree.base.config.SystemPropertyConfiguration;
import org.jfree.base.modules.PackageManager;
import org.jfree.base.modules.PackageManager$PackageConfiguration;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.Configuration;
import org.jfree.util.ExtendedConfiguration;
import org.jfree.util.ExtendedConfigurationWrapper;
import org.jfree.util.Log;
import org.jfree.util.ObjectUtilities;

public abstract class AbstractBoot
implements SubSystem {
    private ExtendedConfigurationWrapper extWrapper;
    private PackageManager packageManager;
    private Configuration globalConfig;
    private boolean bootInProgress;
    private boolean bootDone;

    protected AbstractBoot() {
    }

    @Override
    public synchronized PackageManager getPackageManager() {
        if (this.packageManager != null) return this.packageManager;
        this.packageManager = PackageManager.createInstance(this);
        return this.packageManager;
    }

    @Override
    public synchronized Configuration getGlobalConfig() {
        if (this.globalConfig != null) return this.globalConfig;
        this.globalConfig = this.loadConfiguration();
        return this.globalConfig;
    }

    public final synchronized boolean isBootInProgress() {
        return this.bootInProgress;
    }

    public final synchronized boolean isBootDone() {
        return this.bootDone;
    }

    protected abstract Configuration loadConfiguration();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void start() {
        Object object;
        Object object2 = this;
        synchronized (object2) {
            if (this.isBootDone()) {
                return;
            }
            while (this.isBootInProgress()) {
                try {
                    this.wait();
                }
                catch (InterruptedException var2_2) {}
            }
            if (this.isBootDone()) {
                return;
            }
            this.bootInProgress = true;
        }
        object2 = this.getProjectInfo();
        if (object2 != null) {
            object = object2.getDependencies();
            for (int i2 = 0; i2 < object.length; ++i2) {
                AbstractBoot abstractBoot = this.loadBooter(object[i2].getBootClass());
                if (abstractBoot == null) continue;
                AbstractBoot abstractBoot2 = abstractBoot;
                synchronized (abstractBoot2) {
                    abstractBoot.start();
                    while (!abstractBoot.isBootDone()) {
                        try {
                            abstractBoot.wait();
                        }
                        catch (InterruptedException var6_8) {}
                    }
                    continue;
                }
            }
        }
        this.performBoot();
        if (object2 != null) {
            Log.info(new StringBuffer().append(object2.getName()).append(" ").append(object2.getVersion()).append(" started.").toString());
        } else {
            Log.info(new StringBuffer().append(this.getClass()).append(" started.").toString());
        }
        object = this;
        synchronized (object) {
            this.bootInProgress = false;
            this.bootDone = true;
            this.notifyAll();
            return;
        }
    }

    protected abstract void performBoot();

    protected abstract BootableProjectInfo getProjectInfo();

    protected AbstractBoot loadBooter(String string) {
        if (string == null) {
            return null;
        }
        try {
            Class<?> class_ = ObjectUtilities.getClassLoader(this.getClass()).loadClass(string);
            Method method = class_.getMethod("getInstance", null);
            return (AbstractBoot)method.invoke(null, null);
        }
        catch (Exception var2_3) {
            Log.info(new StringBuffer().append("Unable to boot dependent class: ").append(string).toString());
            return null;
        }
    }

    protected Configuration createDefaultHierarchicalConfiguration(String string, String string2, boolean bl2) {
        Object object;
        HierarchicalConfiguration hierarchicalConfiguration = new HierarchicalConfiguration();
        if (string != null) {
            object = new PropertyFileConfiguration();
            object.load(string);
            hierarchicalConfiguration.insertConfiguration((HierarchicalConfiguration)object);
            hierarchicalConfiguration.insertConfiguration(this.getPackageManager().getPackageConfiguration());
        }
        if (string2 != null) {
            object = string2.startsWith("/") ? string2.substring(1) : string2;
            try {
                PropertyFileConfiguration propertyFileConfiguration;
                Enumeration<URL> enumeration = ObjectUtilities.getClassLoader(this.getClass()).getResources((String)object);
                ArrayList<PropertyFileConfiguration> arrayList = new ArrayList<PropertyFileConfiguration>();
                while (enumeration.hasMoreElements()) {
                    URL uRL = enumeration.nextElement();
                    try {
                        propertyFileConfiguration = new PropertyFileConfiguration();
                        InputStream inputStream = uRL.openStream();
                        propertyFileConfiguration.load(inputStream);
                        inputStream.close();
                        arrayList.add(propertyFileConfiguration);
                    }
                    catch (IOException var9_12) {
                        Log.warn(new StringBuffer().append("Failed to load the user configuration at ").append(uRL).toString(), var9_12);
                    }
                }
                for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
                    propertyFileConfiguration = (PropertyFileConfiguration)arrayList.get(i2);
                    hierarchicalConfiguration.insertConfiguration(propertyFileConfiguration);
                }
            }
            catch (IOException var6_7) {
                Log.warn("Failed to lookup the user configurations.", var6_7);
            }
        }
        object = new SystemPropertyConfiguration();
        hierarchicalConfiguration.insertConfiguration((HierarchicalConfiguration)object);
        return hierarchicalConfiguration;
    }

    @Override
    public synchronized ExtendedConfiguration getExtendedConfig() {
        if (this.extWrapper != null) return this.extWrapper;
        this.extWrapper = new ExtendedConfigurationWrapper(this.getGlobalConfig());
        return this.extWrapper;
    }
}

