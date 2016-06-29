package com.google.security.zynamics.bindiff.project;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.database.WorkspaceDatabase;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class WorkspaceLoader extends CEndlessHelperThread {
   private static int MAX_LOAD_WORKSPACE_ERRORS = 15;
   private final Workspace workspace;
   private final File workspaceFile;
   private String errors;

   public WorkspaceLoader(File var1, Workspace var2) {
      this.workspaceFile = (File)Preconditions.checkNotNull(var1);
      this.workspace = (Workspace)Preconditions.checkNotNull(var2);
      this.errors = "";
   }

   protected void runExpensiveCommand() {
      this.loadMetaData();
   }

   public String getErrorMessage() {
      return this.errors;
   }

   public boolean hasErrors() {
      return "".equals(this.getErrorMessage());
   }

   public void loadMetaData() {
      // $FF: Couldn't be decompiled
   }
}
