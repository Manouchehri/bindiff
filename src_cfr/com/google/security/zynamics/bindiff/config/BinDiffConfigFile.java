/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.config.InitialCallGraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.config.InitialFlowGraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.common.config.ConfigHelper;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public final class BinDiffConfigFile {
    private static final BinDiffConfigFile instance = new BinDiffConfigFile();
    private final TypedPropertiesWrapper properties = new TypedPropertiesWrapper();
    private final GeneralSettingsConfigItem mainSettings = new GeneralSettingsConfigItem();
    private final ColorsConfigItem colorSettings = new ColorsConfigItem();
    private final GraphViewSettingsConfigItem initialCallGraphSettings = new InitialCallGraphViewSettingsConfigItem();
    private final GraphViewSettingsConfigItem initialFlowGraphSettings = new InitialFlowGraphViewSettingsConfigItem();

    private BinDiffConfigFile() {
    }

    public static BinDiffConfigFile getInstance() {
        return instance;
    }

    public static void delete() {
        try {
            if (new File(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml")).delete()) return;
            throw new IOException("Couldn't delete config file.");
        }
        catch (SecurityException var0) {
            String string;
            String string2 = String.valueOf(var0.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't delete config file: ".concat(string2);
                throw new IOException(string);
            }
            string = new String("Couldn't delete config file: ");
            throw new IOException(string);
        }
    }

    public GeneralSettingsConfigItem getMainSettings() {
        return this.mainSettings;
    }

    public ColorsConfigItem getColorSettings() {
        return this.colorSettings;
    }

    public GraphViewSettingsConfigItem getInitialCallgraphSettings() {
        return this.initialCallGraphSettings;
    }

    public GraphViewSettingsConfigItem getInitialFlowgraphSettings() {
        return this.initialFlowGraphSettings;
    }

    public void read() {
        File file = new File(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml"));
        if (!file.exists()) {
            file = new File(ConfigHelper.getMachineConfigFileName("BinDiff", "config.xml"));
        }
        try {
            this.properties.getProperties().loadFromXML(new FileInputStream(file));
        }
        catch (FileNotFoundException var2_2) {
        }
        catch (InvalidPropertiesFormatException var2_3) {
            String string;
            String string2 = String.valueOf(var2_3.getMessage());
            if (string2.length() != 0) {
                string = "Invalid properties format. Couldn't read configuration file: ".concat(string2);
                throw new IOException(string);
            }
            string = new String("Invalid properties format. Couldn't read configuration file: ");
            throw new IOException(string);
        }
        catch (IOException var2_4) {
            String string;
            String string3 = String.valueOf(var2_4.getMessage());
            if (string3.length() != 0) {
                string = "Couldn't read configuration file: ".concat(string3);
                throw new IOException(string);
            }
            string = new String("Couldn't read configuration file: ");
            throw new IOException(string);
        }
        this.mainSettings.load(this.properties);
        this.initialCallGraphSettings.loadWithKeyPrefix(this.properties, "CallGraphSettings.");
        this.initialFlowGraphSettings.loadWithKeyPrefix(this.properties, "FlowGraphSettings.");
        this.colorSettings.loadWithKeyPrefix(this.properties, "Colors.");
    }

    public void write() {
        Logger.logInfo("Saving configuration file...", new Object[0]);
        this.mainSettings.store(this.properties);
        this.initialCallGraphSettings.storeWithKeyPrefix(this.properties, "CallGraphSettings.");
        this.initialFlowGraphSettings.storeWithKeyPrefix(this.properties, "FlowGraphSettings.");
        this.colorSettings.storeWithKeyPrefix(this.properties, "Colors.");
        File file = new File(ConfigHelper.getConfigurationDirectory("zynamics", "BinDiff"));
        if (!file.exists()) {
            file.mkdirs();
        }
        this.properties.getProperties().storeToXML(new FileOutputStream(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml")), "BinDiff");
    }
}

