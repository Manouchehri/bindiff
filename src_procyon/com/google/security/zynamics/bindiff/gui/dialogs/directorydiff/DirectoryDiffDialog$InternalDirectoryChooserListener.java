package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import java.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

class DirectoryDiffDialog$InternalDirectoryChooserListener implements ActionListener
{
    final /* synthetic */ DirectoryDiffDialog this$0;
    
    private DirectoryDiffDialog$InternalDirectoryChooserListener(final DirectoryDiffDialog this$0) {
        this.this$0 = this$0;
    }
    
    private List findDiffPairs() {
        final ArrayList<DiffPairTableData> list = new ArrayList<DiffPairTableData>();
        final File file = new File(this.this$0.primaryDirChooser.getText());
        final File file2 = new File(this.this$0.secondaryDirChooser.getText());
        final ArrayList<String> list2 = new ArrayList<String>();
        list2.add("idb");
        list2.add("i64");
        if (file.exists() && file2.exists()) {
            final List files = CFileUtils.findFiles(file, list2);
            final ArrayList<String> list3 = new ArrayList<String>();
            final Iterator<String> iterator = files.iterator();
            while (iterator.hasNext()) {
                list3.add(iterator.next().substring(file.getPath().length()));
            }
            final List files2 = CFileUtils.findFiles(file2, list2);
            final HashSet<String> set = new HashSet<String>();
            final Iterator<String> iterator2 = files2.iterator();
            while (iterator2.hasNext()) {
                set.add(iterator2.next().substring(file2.getPath().length()));
            }
            for (final String s : list3) {
                if (set.contains(s)) {
                    final File file3 = new File(s);
                    final String name = file3.getName();
                    list.add(new DiffPairTableData(name, file3.getParent(), DiffDirectories.getDiffDestinationDirectoryName(String.format("%s%s%s", file, File.separator, name), String.format("%s%s%s", file2, File.separator, name))));
                }
            }
        }
        return list;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        List tableData = new ArrayList();
        if (actionEvent.getSource().equals(this.this$0.primaryDirChooser.getButton())) {
            final File access$1100 = this.this$0.chooseFile(this.this$0, ESide.PRIMARY);
            if (access$1100 != null && access$1100.exists()) {
                this.this$0.primaryDirChooser.setText(access$1100.getPath());
            }
            if (!this.this$0.secondaryDirChooser.getText().equals("")) {
                tableData = this.findDiffPairs();
            }
        }
        else if (actionEvent.getSource().equals(this.this$0.secondaryDirChooser.getButton())) {
            final File access$1101 = this.this$0.chooseFile(this.this$0, ESide.SECONDARY);
            if (access$1101 != null && access$1101.exists()) {
                this.this$0.secondaryDirChooser.setText(access$1101.getPath());
            }
            if (!this.this$0.primaryDirChooser.getText().equals("")) {
                tableData = this.findDiffPairs();
            }
        }
        this.this$0.diffsTable.setTableData(tableData);
    }
}
