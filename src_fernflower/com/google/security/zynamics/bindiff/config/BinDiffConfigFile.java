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
import java.util.InvalidPropertiesFormatException;

public final class BinDiffConfigFile {
   private static final BinDiffConfigFile instance = new BinDiffConfigFile();
   private final TypedPropertiesWrapper properties = new TypedPropertiesWrapper();
   private final GeneralSettingsConfigItem mainSettings = new GeneralSettingsConfigItem();
   private final ColorsConfigItem colorSettings = new ColorsConfigItem();
   private final GraphViewSettingsConfigItem initialCallGraphSettings = new InitialCallGraphViewSettingsConfigItem();
   private final GraphViewSettingsConfigItem initialFlowGraphSettings = new InitialFlowGraphViewSettingsConfigItem();

   public static BinDiffConfigFile getInstance() {
      return instance;
   }

   public static void delete() {
      // $FF: Couldn't be decompiled
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
      // $FF: Couldn't be decompiled
   }

   public void write() {
      Logger.logInfo("Saving configuration file...", new Object[0]);
      this.mainSettings.store(this.properties);
      this.initialCallGraphSettings.storeWithKeyPrefix(this.properties, "CallGraphSettings.");
      this.initialFlowGraphSettings.storeWithKeyPrefix(this.properties, "FlowGraphSettings.");
      this.colorSettings.storeWithKeyPrefix(this.properties, "Colors.");
      File var1 = new File(ConfigHelper.getConfigurationDirectory("zynamics", "BinDiff"));
      if(!var1.exists()) {
         var1.mkdirs();
      }

      this.properties.getProperties().storeToXML(new FileOutputStream(ConfigHelper.getConfigFileName("zynamics", "BinDiff", "config.xml")), "BinDiff");
   }
}
