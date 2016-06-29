/*
 * Decompiled with CFR 0_115.
 */
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
import javax.swing.JButton;

class DirectoryDiffDialog$InternalDirectoryChooserListener
implements ActionListener {
    final /* synthetic */ DirectoryDiffDialog this$0;

    private DirectoryDiffDialog$InternalDirectoryChooserListener(DirectoryDiffDialog directoryDiffDialog) {
        this.this$0 = directoryDiffDialog;
    }

    private List findDiffPairs() {
        Object object;
        Iterator iterator;
        String string;
        Object object22;
        ArrayList<DiffPairTableData> arrayList = new ArrayList<DiffPairTableData>();
        File file = new File(DirectoryDiffDialog.access$900(this.this$0).getText());
        File file2 = new File(DirectoryDiffDialog.access$1000(this.this$0).getText());
        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("idb");
        arrayList2.add("i64");
        if (!file.exists()) return arrayList;
        if (!file2.exists()) return arrayList;
        List list = CFileUtils.findFiles(file, arrayList2);
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        for (Object object22 : list) {
            iterator = object22.substring(file.getPath().length());
            arrayList3.add(iterator);
        }
        List list2 = CFileUtils.findFiles(file2, arrayList2);
        object22 = new HashSet();
        iterator = list2.iterator();
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            object = string.substring(file2.getPath().length());
            object22.add(object);
        }
        iterator = arrayList3.iterator();
        while (iterator.hasNext()) {
            string = (String)iterator.next();
            if (!object22.contains(string)) continue;
            object = new File(string);
            String string2 = object.getName();
            String string3 = object.getParent();
            String string4 = String.format("%s%s%s", file, File.separator, string2);
            String string5 = String.format("%s%s%s", file2, File.separator, string2);
            String string6 = DiffDirectories.getDiffDestinationDirectoryName(string4, string5);
            DiffPairTableData diffPairTableData = new DiffPairTableData(string2, string3, string6);
            arrayList.add(diffPairTableData);
        }
        return arrayList;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        List list = new ArrayList();
        if (actionEvent.getSource().equals(DirectoryDiffDialog.access$900(this.this$0).getButton())) {
            File file = DirectoryDiffDialog.access$1100(this.this$0, this.this$0, ESide.PRIMARY);
            if (file != null && file.exists()) {
                DirectoryDiffDialog.access$900(this.this$0).setText(file.getPath());
            }
            if (!DirectoryDiffDialog.access$1000(this.this$0).getText().equals("")) {
                list = this.findDiffPairs();
            }
        } else if (actionEvent.getSource().equals(DirectoryDiffDialog.access$1000(this.this$0).getButton())) {
            File file = DirectoryDiffDialog.access$1100(this.this$0, this.this$0, ESide.SECONDARY);
            if (file != null && file.exists()) {
                DirectoryDiffDialog.access$1000(this.this$0).setText(file.getPath());
            }
            if (!DirectoryDiffDialog.access$900(this.this$0).getText().equals("")) {
                list = this.findDiffPairs();
            }
        }
        DirectoryDiffDialog.access$600(this.this$0).setTableData(list);
    }

    /* synthetic */ DirectoryDiffDialog$InternalDirectoryChooserListener(DirectoryDiffDialog directoryDiffDialog, DirectoryDiffDialog$1 directoryDiffDialog$1) {
        this(directoryDiffDialog);
    }
}

