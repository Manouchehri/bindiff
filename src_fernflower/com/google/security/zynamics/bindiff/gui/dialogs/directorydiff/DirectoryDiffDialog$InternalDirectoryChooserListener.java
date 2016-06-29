package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$1;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class DirectoryDiffDialog$InternalDirectoryChooserListener implements ActionListener {
   // $FF: synthetic field
   final DirectoryDiffDialog this$0;

   private DirectoryDiffDialog$InternalDirectoryChooserListener(DirectoryDiffDialog var1) {
      this.this$0 = var1;
   }

   private List findDiffPairs() {
      ArrayList var1 = new ArrayList();
      File var2 = new File(DirectoryDiffDialog.access$900(this.this$0).getText());
      File var3 = new File(DirectoryDiffDialog.access$1000(this.this$0).getText());
      ArrayList var4 = new ArrayList();
      var4.add("idb");
      var4.add("i64");
      if(var2.exists() && var3.exists()) {
         List var5 = CFileUtils.findFiles(var2, var4);
         ArrayList var6 = new ArrayList();
         Iterator var7 = var5.iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            String var9 = var8.substring(var2.getPath().length());
            var6.add(var9);
         }

         List var18 = CFileUtils.findFiles(var3, var4);
         HashSet var19 = new HashSet();
         Iterator var20 = var18.iterator();

         String var10;
         while(var20.hasNext()) {
            var10 = (String)var20.next();
            String var11 = var10.substring(var3.getPath().length());
            var19.add(var11);
         }

         var20 = var6.iterator();

         while(var20.hasNext()) {
            var10 = (String)var20.next();
            if(var19.contains(var10)) {
               File var21 = new File(var10);
               String var12 = var21.getName();
               String var13 = var21.getParent();
               String var14 = String.format("%s%s%s", new Object[]{var2, File.separator, var12});
               String var15 = String.format("%s%s%s", new Object[]{var3, File.separator, var12});
               String var16 = DiffDirectories.getDiffDestinationDirectoryName(var14, var15);
               DiffPairTableData var17 = new DiffPairTableData(var12, var13, var16);
               var1.add(var17);
            }
         }
      }

      return var1;
   }

   public void actionPerformed(ActionEvent var1) {
      Object var2 = new ArrayList();
      File var3;
      if(var1.getSource().equals(DirectoryDiffDialog.access$900(this.this$0).getButton())) {
         var3 = DirectoryDiffDialog.access$1100(this.this$0, this.this$0, ESide.PRIMARY);
         if(var3 != null && var3.exists()) {
            DirectoryDiffDialog.access$900(this.this$0).setText(var3.getPath());
         }

         if(!DirectoryDiffDialog.access$1000(this.this$0).getText().equals("")) {
            var2 = this.findDiffPairs();
         }
      } else if(var1.getSource().equals(DirectoryDiffDialog.access$1000(this.this$0).getButton())) {
         var3 = DirectoryDiffDialog.access$1100(this.this$0, this.this$0, ESide.SECONDARY);
         if(var3 != null && var3.exists()) {
            DirectoryDiffDialog.access$1000(this.this$0).setText(var3.getPath());
         }

         if(!DirectoryDiffDialog.access$900(this.this$0).getText().equals("")) {
            var2 = this.findDiffPairs();
         }
      }

      DirectoryDiffDialog.access$600(this.this$0).setTableData((List)var2);
   }

   // $FF: synthetic method
   DirectoryDiffDialog$InternalDirectoryChooserListener(DirectoryDiffDialog var1, DirectoryDiffDialog$1 var2) {
      this(var1);
   }
}
