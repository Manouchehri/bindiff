package org.jfree.util;

public interface LogTarget {
   int ERROR = 0;
   int WARN = 1;
   int INFO = 2;
   int DEBUG = 3;
   String[] LEVELS = new String[]{"ERROR: ", "WARN:  ", "INFO:  ", "DEBUG: "};

   void log(int var1, Object var2);

   void log(int var1, Object var2, Exception var3);
}
