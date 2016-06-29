package com.google.security.zynamics.common.config;

import java.awt.Color;
import java.util.Properties;

public class TypedPropertiesWrapper {
   private final Properties properties;
   private String keyPrefix;

   public TypedPropertiesWrapper() {
      this(new Properties());
   }

   public TypedPropertiesWrapper(Properties var1) {
      this.properties = var1;
      this.keyPrefix = "";
   }

   public Properties getProperties() {
      return this.properties;
   }

   public void setKeyPrefix(String var1) {
      this.keyPrefix = var1;
   }

   public String getKeyPrefix() {
      return this.keyPrefix;
   }

   public boolean getBoolean(String var1, boolean var2) {
      // $FF: Couldn't be decompiled
   }

   public void setBoolean(String var1, boolean var2) {
      // $FF: Couldn't be decompiled
   }

   public Color getColor(String var1, Color var2) {
      // $FF: Couldn't be decompiled
   }

   public void setColor(String var1, Color var2) {
      // $FF: Couldn't be decompiled
   }

   public int getInteger(String var1, int var2) {
      // $FF: Couldn't be decompiled
   }

   public void setInteger(String var1, int var2) {
      // $FF: Couldn't be decompiled
   }

   public long getLong(String var1, long var2) {
      // $FF: Couldn't be decompiled
   }

   public void setLong(String var1, long var2) {
      // $FF: Couldn't be decompiled
   }

   public String getString(String var1, String var2) {
      // $FF: Couldn't be decompiled
   }

   public void setString(String var1, String var2) {
      // $FF: Couldn't be decompiled
   }
}
