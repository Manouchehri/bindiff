package com.google.security.zynamics.zylib.io;

import java.io.File;

public interface IDirectoryTraversalCallback {
   void entering(File var1);

   void leaving(File var1);

   void nextFile(File var1);
}
