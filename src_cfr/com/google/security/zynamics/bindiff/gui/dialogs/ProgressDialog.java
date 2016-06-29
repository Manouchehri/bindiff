/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressModel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

public class ProgressDialog {
    private ProgressDialog() {
    }

    private static void initializeWindowIcons(JDialog jDialog) {
        ArrayList<Image> arrayList = new ArrayList<Image>();
        arrayList.add(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
        arrayList.add(ImageUtils.getImageIcon("data/appicons/bindiff-32x32-rgba.png").getImage());
        arrayList.add(ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage());
        jDialog.setIconImages(arrayList);
    }

    public static CEndlessProgressDialog show(Window window, String string, CEndlessHelperThread cEndlessHelperThread) {
        CEndlessProgressDialog cEndlessProgressDialog = new CEndlessProgressDialog(window, "BinDiff", string, cEndlessHelperThread);
        ProgressDialog.initializeWindowIcons(cEndlessProgressDialog);
        cEndlessProgressDialog.setSize(400, cEndlessProgressDialog.getPreferredSize().height);
        cEndlessProgressDialog.setMinimumSize(new Dimension(400, cEndlessProgressDialog.getPreferredSize().height));
        cEndlessProgressDialog.setMaximumSize(new Dimension(Math.max(400, cEndlessProgressDialog.getPreferredSize().width), cEndlessProgressDialog.getPreferredSize().height));
        cEndlessProgressDialog.setDefaultCloseOperation(2);
        cEndlessHelperThread.start();
        cEndlessProgressDialog.setVisible(true);
        if (cEndlessHelperThread.getException() == null) return cEndlessProgressDialog;
        throw cEndlessHelperThread.getException();
    }

    public static CStandardProgressDialog show(Window window, String string, CStandardHelperThread cStandardHelperThread) {
        CStandardProgressDialog cStandardProgressDialog = new CStandardProgressDialog(window, "BinDiff", string, cStandardHelperThread);
        ProgressDialog.initializeWindowIcons(cStandardProgressDialog);
        cStandardProgressDialog.setSize(400, 122);
        cStandardProgressDialog.setMinimumSize(new Dimension(400, 122));
        cStandardHelperThread.start();
        cStandardProgressDialog.setVisible(true);
        return cStandardProgressDialog;
    }
}

