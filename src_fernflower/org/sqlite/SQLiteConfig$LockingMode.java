package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$LockingMode implements SQLiteConfig$PragmaValue {
   NORMAL,
   EXCLUSIVE;

   public String getValue() {
      return this.name();
   }
}
