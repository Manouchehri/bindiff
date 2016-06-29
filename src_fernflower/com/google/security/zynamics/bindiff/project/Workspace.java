package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.WorkspaceDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Workspace {
   private File workspaceFile = null;
   private final List diffs = new ArrayList();
   private String name;
   private boolean isLoaded = false;
   private final ListenerProvider listeners = new ListenerProvider();
   private MainWindow parentWindow;

   private void createCommentDatabase() {
      try {
         CommentsDatabase var1 = new CommentsDatabase(this, true);
         Object var2 = null;
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var4) {
                  ((Throwable)var2).addSuppressed(var4);
               }
            } else {
               var1.close();
            }
         }
      } catch (SQLException var5) {
         Logger.logException(var5, var5.getMessage());
         CMessageBox.showError(this.parentWindow, var5.getMessage());
      }

   }

   public void addDiff(Diff var1) {
      if(!this.diffs.contains(var1)) {
         Diff var2 = null;
         Iterator var3 = this.diffs.iterator();

         while(var3.hasNext()) {
            Diff var4 = (Diff)var3.next();
            if(var4.getMatchesDatabase().equals(var1.getMatchesDatabase())) {
               var2 = var4;
            }
         }

         if(var2 != null) {
            this.diffs.remove(var2);
         }

         this.diffs.add(var1);
         if(this.isLoaded) {
            var3 = this.listeners.iterator();

            while(var3.hasNext()) {
               IWorkspaceListener var5 = (IWorkspaceListener)var3.next();
               var5.addedDiff(var1);
            }

            this.saveWorkspace();
         }

      }
   }

   public String addDiff(File var1, DiffMetaData var2, boolean var3) {
      StringBuffer var4 = new StringBuffer("");
      File var5 = null;
      File var6 = null;
      String var7;
      if(var2 == null || !var1.exists()) {
         var7 = String.valueOf(var1.getPath());
         var4.append((new StringBuilder(4 + String.valueOf(var7).length())).append(" - ").append(var7).append("\n").toString());
      }

      if(var2 != null) {
         var5 = DiffDirectories.getBinExportFile(var1, var2, ESide.PRIMARY);
         if(!var5.exists() || var5.isDirectory()) {
            var7 = String.valueOf(var5.getPath());
            var4.append((new StringBuilder(4 + String.valueOf(var7).length())).append(" - ").append(var7).append("\n").toString());
         }

         var6 = DiffDirectories.getBinExportFile(var1, var2, ESide.SECONDARY);
         if(!var6.exists() || var6.isDirectory()) {
            var7 = String.valueOf(var6.getPath());
            var4.append((new StringBuilder(4 + String.valueOf(var7).length())).append(" - ").append(var7).append("\n").toString());
         }
      }

      Diff var10 = new Diff(var2, var1, var5, var6, var3);
      if(var10 != null) {
         try {
            this.addDiff(var10);
         } catch (SQLException var9) {
            Logger.logException(var9, var9.getMessage());
            CMessageBox.showError(this.parentWindow, var9.getMessage());
         }
      }

      return var4.toString();
   }

   public void addListener(IWorkspaceListener var1) {
      this.listeners.addListener(var1);
   }

   public void closeWorkspace() {
      if(this.isLoaded()) {
         Logger.logInfo("Closing workspace \'%s\'...", new Object[]{this.workspaceFile.getPath()});
         this.diffs.clear();
         this.workspaceFile = null;
         this.name = "";
         this.isLoaded = false;
         Iterator var1 = this.listeners.iterator();

         while(var1.hasNext()) {
            IWorkspaceListener var2 = (IWorkspaceListener)var1.next();
            var2.closedWorkspace();
         }

         Logger.logInfo("Workspace closed.", new Object[0]);
      }
   }

   public boolean containsDiff(String var1) {
      Iterator var2 = this.diffs.iterator();

      Diff var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (Diff)var2.next();
      } while(!var3.getMatchesDatabase().getPath().equals(var1));

      return true;
   }

   public List getDiffList() {
      return this.diffs;
   }

   public List getDiffList(boolean var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.diffs.iterator();

      while(var3.hasNext()) {
         Diff var4 = (Diff)var3.next();
         if(var4.isFunctionDiff() == var1) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public ListenerProvider getListeners() {
      return this.listeners;
   }

   public MainWindow getWindow() {
      return this.parentWindow;
   }

   public File getWorkspaceDir() {
      return this.workspaceFile.getParentFile();
   }

   public String getWorkspaceDirPath() {
      return this.workspaceFile.getParent();
   }

   public File getWorkspaceFile() {
      return this.workspaceFile;
   }

   public String getWorkspaceFileName() {
      return this.name;
   }

   public String getWorkspaceFilePath() {
      return this.workspaceFile.getPath();
   }

   public boolean isLoaded() {
      return this.isLoaded;
   }

   public void newWorkspace(File var1) {
      if(this.isLoaded) {
         throw new IOException("Couldn\'t create new workspace. Existing workspace has to be closed first.");
      } else {
         this.workspaceFile = var1;
         this.name = var1.getName();
         this.isLoaded = true;
         this.saveWorkspace();
         this.createCommentDatabase();
         Iterator var2 = this.listeners.iterator();

         while(var2.hasNext()) {
            IWorkspaceListener var3 = (IWorkspaceListener)var2.next();
            var3.loadedWorkspace(this);
         }

         Logger.logInfo("Created a new Workspace.", new Object[0]);
      }
   }

   public void removeDiff(Diff var1) {
      this.diffs.remove(var1);
   }

   public void removeListener(IWorkspaceListener var1) {
      this.listeners.removeListener(var1);
   }

   public void saveWorkspace() {
      if(this.workspaceFile == null) {
         throw new SQLException("Couldn\'t save workspace. No workspace is loaded.");
      } else {
         WorkspaceDatabase var1 = new WorkspaceDatabase(this.workspaceFile);
         Throwable var2 = null;

         try {
            var1.saveWorkspace(this);
         } catch (Throwable var11) {
            var2 = var11;
            throw var11;
         } finally {
            if(var1 != null) {
               if(var2 != null) {
                  try {
                     var1.close();
                  } catch (Throwable var10) {
                     var2.addSuppressed(var10);
                  }
               } else {
                  var1.close();
               }
            }

         }

      }
   }

   public void setLoaded(boolean var1) {
      this.isLoaded = var1;
   }

   public void setParentWindow(MainWindow var1) {
      this.parentWindow = var1;
   }

   public void setWorkspaceFile(File var1) {
      this.workspaceFile = var1;
      this.name = var1.getName();
   }
}
