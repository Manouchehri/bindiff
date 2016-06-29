package org.sqlite;

import org.sqlite.DB$ProgressObserver;

class Stmt$BackupObserver implements DB$ProgressObserver {
   public void progress(int var1, int var2) {
      System.out.println(String.format("remaining:%d, page count:%d", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)}));
   }
}
