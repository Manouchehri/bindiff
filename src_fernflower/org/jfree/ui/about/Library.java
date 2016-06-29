package org.jfree.ui.about;

import org.jfree.ui.about.ProjectInfo;

public class Library extends org.jfree.base.Library {
   public Library(String var1, String var2, String var3, String var4) {
      super(var1, var2, var3, var4);
   }

   public Library(ProjectInfo var1) {
      this(var1.getName(), var1.getVersion(), var1.getLicenceName(), var1.getInfo());
   }
}
