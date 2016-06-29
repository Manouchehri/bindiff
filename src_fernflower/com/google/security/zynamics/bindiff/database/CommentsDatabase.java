package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.database.SqliteDatabase;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class CommentsDatabase extends SqliteDatabase {
   private static final String STATEMENT_CREATE_BASICBLOCK_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS bd_basicblockComments (pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, basicblockAddr BIGINT NOT NULL, comment long VARCHAR NOT NULL, primary key (pe_hash, functionAddr, basicblockAddr))";
   private static final String STATEMENT_CREATE_INSTRUCTION_COMMENT_TABLE = "CREATE TABLE IF NOT EXISTS bd_instructionComments(pe_hash VARCHAR(40) NOT NULL, functionAddr BIGINT NOT NULL, instructionAddr BIGINT NOT NULL, placement SMALLINT NOT NULL, comment long VARCHAR NOT NULL, PRIMARY KEY (pe_hash, functionAddr, instructionAddr, placement))";

   public CommentsDatabase(Workspace var1, boolean var2) {
      super(var1.getWorkspaceFile());
      if(var2) {
         this.createTables();
      }

   }

   private void createTables() {
      // $FF: Couldn't be decompiled
   }

   public Map readBasicblockComments(String var1, IAddress var2) {
      // $FF: Couldn't be decompiled
   }

   public Map readFunctionComments(String var1) {
      // $FF: Couldn't be decompiled
   }

   public Map readInstructionComments(String var1, IAddress var2) {
      // $FF: Couldn't be decompiled
   }

   public void writeBasicblockComment(String var1, IAddress var2, IAddress var3, String var4) {
      // $FF: Couldn't be decompiled
   }

   public void writeFunctionComment(String var1, IAddress var2, String var3) {
      // $FF: Couldn't be decompiled
   }

   public void writeInstructionComment(String var1, IAddress var2, IAddress var3, ECommentPlacement var4, String var5) {
      // $FF: Couldn't be decompiled
   }
}
