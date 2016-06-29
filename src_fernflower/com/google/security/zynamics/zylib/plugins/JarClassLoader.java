package com.google.security.zynamics.zylib.plugins;

import com.google.security.zynamics.zylib.plugins.JarResources;
import com.google.security.zynamics.zylib.plugins.MultiClassLoader;

@Deprecated
public class JarClassLoader extends MultiClassLoader {
   private final JarResources jarResources;

   public JarClassLoader(String var1) {
      this.jarResources = new JarResources(var1);
   }

   protected byte[] loadClassBytes(String var1) {
      var1 = this.formatClassName(var1);
      return this.jarResources.getResource(var1);
   }
}
