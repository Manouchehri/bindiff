package com.google.security.zynamics.zylib.io;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class FilesizeSorter implements Serializable, Comparator {
   private static final long serialVersionUID = 7060651903531011219L;

   public int compare(File var1, File var2) {
      return (int)(var1.length() - var2.length());
   }
}
