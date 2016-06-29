package org.jfree;

import org.jfree.JCommonInfo;
import org.jfree.ui.about.ProjectInfo;

public final class JCommon {
   public static final ProjectInfo INFO = JCommonInfo.getInstance();

   public static void main(String[] var0) {
      System.out.println(INFO.toString());
   }
}
