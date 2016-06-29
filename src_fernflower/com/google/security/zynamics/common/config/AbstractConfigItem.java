package com.google.security.zynamics.common.config;

import com.google.security.zynamics.common.config.TypedPropertiesWrapper;

public abstract class AbstractConfigItem {
   public abstract void load(TypedPropertiesWrapper var1);

   public void loadWithKeyPrefix(TypedPropertiesWrapper var1, String var2) {
      String var3 = var1.getKeyPrefix();
      var1.setKeyPrefix(var2);
      this.load(var1);
      var1.setKeyPrefix(var3);
   }

   public abstract void store(TypedPropertiesWrapper var1);

   public void storeWithKeyPrefix(TypedPropertiesWrapper var1, String var2) {
      String var3 = var1.getKeyPrefix();
      var1.setKeyPrefix(var2);
      this.store(var1);
      var1.setKeyPrefix(var3);
   }
}
