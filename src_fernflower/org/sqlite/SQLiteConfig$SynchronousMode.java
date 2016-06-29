package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$SynchronousMode implements SQLiteConfig$PragmaValue {
   OFF,
   NORMAL,
   FULL;

   public String getValue() {
      return this.name();
   }
}
