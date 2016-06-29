/*
 * Decompiled with CFR 0_115.
 */
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
import java.awt.LayoutManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

public class CFileChooser
extends JFileChooser {
    private static final long serialVersionUID = -5907483378595594768L;
    private final List m_fileFilters = new ArrayList();
    private final JCheckBox m_checkBox = new JCheckBox();
    private boolean m_askFileOverwrite = false;

    public CFileChooser() {
        this("");
    }

    public /* varargs */ CFileChooser(CFileChooser$FileExtension ... arrcFileChooser$FileExtension) {
        Preconditions.checkNotNull(arrcFileChooser$FileExtension, "File extensions can't be null.");
        CFileChooser$FileExtension[] arrcFileChooser$FileExtension2 = arrcFileChooser$FileExtension;
        int n2 = arrcFileChooser$FileExtension2.length;
        int n3 = 0;
        while (n3 < n2) {
            CFileChooser$FileExtension cFileChooser$FileExtension = arrcFileChooser$FileExtension2[n3];
            CFileChooser$CFileNameExtensionFilter cFileChooser$CFileNameExtensionFilter = new CFileChooser$CFileNameExtensionFilter(this, Arrays.asList(CFileChooser$FileExtension.access$000(cFileChooser$FileExtension)), CFileChooser$FileExtension.access$100(cFileChooser$FileExtension));
            this.m_fileFilters.add(cFileChooser$CFileNameExtensionFilter);
            this.addChoosableFileFilter(cFileChooser$CFileNameExtensionFilter);
            ++n3;
        }
    }

    public CFileChooser(List list, String string) {
        Preconditions.checkNotNull(list, "Error: File extensions can't be null.");
        Preconditions.checkNotNull(string, "Error: File descriptions can't be null.");
        this.addChoosableFileFilter(new CFileChooser$CFileNameExtensionFilter(this, list, string));
    }

    public CFileChooser(String string) {
        this(string, "");
    }

    public CFileChooser(String string, String string2) {
        Preconditions.checkNotNull(string, "Error: File extension can't be null.");
        Preconditions.checkNotNull(string2, "Error: File description can't be null.");
        if (string.isEmpty()) {
            return;
        }
        this.addChoosableFileFilter(new CFileChooser$1(this, string, string2));
    }

    private static int showNativeFileDialog(JFileChooser jFileChooser) {
        FileDialog fileDialog = new FileDialog((Frame)jFileChooser.getParent());
        fileDialog.setDirectory(jFileChooser.getCurrentDirectory().getPath());
        File file = jFileChooser.getSelectedFile();
        fileDialog.setFile(file == null ? "" : file.getPath());
        fileDialog.setFilenameFilter(new CFileChooser$2(jFileChooser));
        if (jFileChooser.getDialogType() == 1) {
            fileDialog.setMode(1);
        } else {
            fileDialog.setMode(0);
        }
        if (jFileChooser.getFileSelectionMode() == 1) {
            System.setProperty("apple.awt.fileDialogForDirectories", "true");
        }
        fileDialog.setVisible(true);
        System.setProperty("apple.awt.fileDialogForDirectories", "false");
        if (fileDialog.getFile() == null) {
            return 1;
        }
        String string = fileDialog.getDirectory();
        String string2 = String.valueOf(FileUtils.ensureTrailingSlash(string));
        String string3 = String.valueOf(fileDialog.getFile());
        jFileChooser.setSelectedFile(new File(string3.length() != 0 ? string2.concat(string3) : new String(string2)));
        return 0;
    }

    @Override
    public void approveSelection() {
        if (this.m_askFileOverwrite && this.getSelectedFile().exists() && CMessageBox.showYesNoQuestion(this, Constants.ASK_FILE_OVERWRITE) == 1) {
            return;
        }
        super.approveSelection();
    }

    public boolean getAskFileOverwrite() {
        return this.m_askFileOverwrite;
    }

    public boolean isSelectedCheckBox() {
        return this.m_checkBox.isSelected();
    }

    public void setAskFileOverwrite(boolean bl2) {
        this.m_askFileOverwrite = bl2;
    }

    /*
     * Unable to fully structure code
     */
    public void setCheckBox(String var1_1) {
        this.m_checkBox.setText(var1_1);
        this.m_checkBox.setBorder(new EmptyBorder(0, 0, 0, 0));
        var2_2 = this.getApproveButtonText();
        var3_3 = (JButton)GuiHelper.findComponentByPredicate(this, new CFileChooser$3(this, var2_2));
        var4_4 = null;
        if (var3_3 == null) ** GOTO lbl-1000
        var5_5 = var3_3.getParent();
        if (var5_5 instanceof JComponent) {
            var4_4 = (JComponent)var5_5;
        }
        if (var4_4 == null) lbl-1000: // 2 sources:
        {
            this.setAccessory(this.m_checkBox);
            return;
        }
        if (SystemHelpers.isRunningMacOSX()) {
            var4_4.add((Component)this.m_checkBox, 0);
            return;
        }
        var5_5 = new JPanel(var4_4.getLayout());
        var6_6 = var4_4.getComponents();
        var7_7 = var6_6.length;
        var8_8 = 0;
        do {
            if (var8_8 >= var7_7) {
                var4_4.setLayout(new BorderLayout(0, 0));
                var4_4.add((Component)this.m_checkBox, "Before");
                var4_4.add((Component)var5_5, "Center");
                return;
            }
            var9_9 = var6_6[var8_8];
            var5_5.add(var9_9);
            ++var8_8;
        } while (true);
    }

    public void setFileFilter(int n2) {
        this.setFileFilter((FileFilter)this.m_fileFilters.get(n2));
    }

    @Override
    public int showOpenDialog(Component component) {
        if (!SystemHelpers.isRunningMacOSX()) {
            return super.showOpenDialog(component);
        }
        this.setDialogType(0);
        return CFileChooser.showNativeFileDialog(this);
    }
}

