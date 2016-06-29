package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CFileChooser$1;
import com.google.security.zynamics.zylib.gui.CFileChooser$2;
import com.google.security.zynamics.zylib.gui.CFileChooser$3;
import com.google.security.zynamics.zylib.gui.CFileChooser$CFileNameExtensionFilter;
import com.google.security.zynamics.zylib.gui.CFileChooser$FileExtension;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.resources.Constants;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

public class CFileChooser extends JFileChooser {
   private static final long serialVersionUID = -5907483378595594768L;
   private final List m_fileFilters;
   private final JCheckBox m_checkBox;
   private boolean m_askFileOverwrite;

   public CFileChooser() {
      this("");
   }

   public CFileChooser(CFileChooser$FileExtension... var1) {
      this.m_fileFilters = new ArrayList();
      this.m_checkBox = new JCheckBox();
      this.m_askFileOverwrite = false;
      Preconditions.checkNotNull(var1, "File extensions can\'t be null.");
      CFileChooser$FileExtension[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         CFileChooser$FileExtension var5 = var2[var4];
         CFileChooser$CFileNameExtensionFilter var6 = new CFileChooser$CFileNameExtensionFilter(this, Arrays.asList(CFileChooser$FileExtension.access$000(var5)), CFileChooser$FileExtension.access$100(var5));
         this.m_fileFilters.add(var6);
         this.addChoosableFileFilter(var6);
      }

   }

   public CFileChooser(List var1, String var2) {
      this.m_fileFilters = new ArrayList();
      this.m_checkBox = new JCheckBox();
      this.m_askFileOverwrite = false;
      Preconditions.checkNotNull(var1, "Error: File extensions can\'t be null.");
      Preconditions.checkNotNull(var2, "Error: File descriptions can\'t be null.");
      this.addChoosableFileFilter(new CFileChooser$CFileNameExtensionFilter(this, var1, var2));
   }

   public CFileChooser(String var1) {
      this(var1, "");
   }

   public CFileChooser(String var1, String var2) {
      this.m_fileFilters = new ArrayList();
      this.m_checkBox = new JCheckBox();
      this.m_askFileOverwrite = false;
      Preconditions.checkNotNull(var1, "Error: File extension can\'t be null.");
      Preconditions.checkNotNull(var2, "Error: File description can\'t be null.");
      if(!var1.isEmpty()) {
         this.addChoosableFileFilter(new CFileChooser$1(this, var1, var2));
      }
   }

   private static int showNativeFileDialog(JFileChooser var0) {
      // $FF: Couldn't be decompiled
   }

   public void approveSelection() {
      if(!this.m_askFileOverwrite || !this.getSelectedFile().exists() || CMessageBox.showYesNoQuestion(this, Constants.ASK_FILE_OVERWRITE) != 1) {
         super.approveSelection();
      }
   }

   public boolean getAskFileOverwrite() {
      return this.m_askFileOverwrite;
   }

   public boolean isSelectedCheckBox() {
      return this.m_checkBox.isSelected();
   }

   public void setAskFileOverwrite(boolean var1) {
      this.m_askFileOverwrite = var1;
   }

   public void setCheckBox(String var1) {
      this.m_checkBox.setText(var1);
      this.m_checkBox.setBorder(new EmptyBorder(0, 0, 0, 0));
      String var2 = this.getApproveButtonText();
      JButton var3 = (JButton)GuiHelper.findComponentByPredicate(this, new CFileChooser$3(this, var2));
      JComponent var4 = null;
      if(var3 != null) {
         Container var5 = var3.getParent();
         if(var5 instanceof JComponent) {
            var4 = (JComponent)var5;
         }
      }

      if(var4 == null) {
         this.setAccessory(this.m_checkBox);
      } else if(SystemHelpers.isRunningMacOSX()) {
         var4.add(this.m_checkBox, 0);
      } else {
         JPanel var10 = new JPanel(var4.getLayout());
         Component[] var6 = var4.getComponents();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Component var9 = var6[var8];
            var10.add(var9);
         }

         var4.setLayout(new BorderLayout(0, 0));
         var4.add(this.m_checkBox, "Before");
         var4.add(var10, "Center");
      }
   }

   public void setFileFilter(int var1) {
      this.setFileFilter((FileFilter)this.m_fileFilters.get(var1));
   }

   public int showOpenDialog(Component var1) {
      if(!SystemHelpers.isRunningMacOSX()) {
         return super.showOpenDialog(var1);
      } else {
         this.setDialogType(0);
         return showNativeFileDialog(this);
      }
   }
}
