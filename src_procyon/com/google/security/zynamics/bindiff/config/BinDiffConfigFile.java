package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.*;
import java.util.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;

public final class BinDiffConfigFile
{
    private static final BinDiffConfigFile instance;
    private final TypedPropertiesWrapper properties;
    private final GeneralSettingsConfigItem mainSettings;
    private final ColorsConfigItem colorSettings;
    private final GraphViewSettingsConfigItem initialCallGraphSettings;
    private final GraphViewSettingsConfigItem initialFlowGraphSettings;
    
    private BinDiffConfigFile() {
        this.properties = new TypedPropertiesWrapper();
        this.mainSettings = new GeneralSettingsConfigItem();
        this.colorSettings = new ColorsConfigItem();
        this.initialCallGraphSettings = new InitialCallGraphViewSettingsConfigItem();
        this.initialFlowGraphSettings = new InitialFlowGraphViewSettingsConfigItem();
    }
    
    public static BinDiffConfigFile getInstance() {
        return BinDiffConfigFile.instance;
    }
    
    public static void delete() {
        try {
            if (!new File(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml")).delete()) {
                throw new IOException("Couldn't delete config file.");
            }
        }
        catch (SecurityException ex) {
            final String s = "Couldn't delete config file: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
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
        catch (FileNotFoundException ex3) {}
        catch (InvalidPropertiesFormatException ex) {
            final String s = "Invalid properties format. Couldn't read configuration file: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        catch (IOException ex2) {
            final String s2 = "Couldn't read configuration file: ";
            final String value2 = String.valueOf(ex2.getMessage());
            throw new IOException((value2.length() != 0) ? s2.concat(value2) : new String(s2));
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
        final File file = new File(ConfigHelper.getConfigurationDirectory("zynamics", "BinDiff"));
        if (!file.exists()) {
            file.mkdirs();
        }
        this.properties.getProperties().storeToXML(new FileOutputStream(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml")), "BinDiff");
    }
    
    static {
        instance = new BinDiffConfigFile();
    }
}
