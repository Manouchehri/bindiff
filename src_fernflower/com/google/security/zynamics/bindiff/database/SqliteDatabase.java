package com.google.security.zynamics.bindiff.database;

import com.google.common.base.Preconditions;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class SqliteDatabase implements AutoCloseable {
   protected final Connection connection;

   public SqliteDatabase(File var1) {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      this.connection.close();
   }
}
