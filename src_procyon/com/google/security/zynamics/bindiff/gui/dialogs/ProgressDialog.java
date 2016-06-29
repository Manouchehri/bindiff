package com.google.security.zynamics.bindiff.gui.dialogs;

import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.util.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;

public class ProgressDialog
{
    private static void initializeWindowIcons(final JDialog dialog) {
        final ArrayList<Image> iconImages = new ArrayList<Image>();
        iconImages.add(ImageUtils.getImageIcon("data/appicons/bindiff-16x16-rgba.png").getImage());
        iconImages.add(ImageUtils.getImageIcon("data/appicons/bindiff-32x32-rgba.png").getImage());
        iconImages.add(ImageUtils.getImageIcon("data/appicons/bindiff-48x48-rgba.png").getImage());
        dialog.setIconImages(iconImages);
    }
    
    public static CEndlessProgressDialog show(final Window window, final String s, final CEndlessHelperThread cEndlessHelperThread) {
        final CEndlessProgressDialog cEndlessProgressDialog = new CEndlessProgressDialog(window, "BinDiff", s, cEndlessHelperThread);
        initializeWindowIcons(cEndlessProgressDialog);
        cEndlessProgressDialog.setSize(400, cEndlessProgressDialog.getPreferredSize().height);
        cEndlessProgressDialog.setMinimumSize(new Dimension(400, cEndlessProgressDialog.getPreferredSize().height));
        cEndlessProgressDialog.setMaximumSize(new Dimension(Math.max(400, cEndlessProgressDialog.getPreferredSize().width), cEndlessProgressDialog.getPreferredSize().height));
        cEndlessProgressDialog.setDefaultCloseOperation(2);
        cEndlessHelperThread.start();
        cEndlessProgressDialog.setVisible(true);
        if (cEndlessHelperThread.getException() != null) {
            throw cEndlessHelperThread.getException();
        }
        return cEndlessProgressDialog;
    }
    
    public static CStandardProgressDialog show(final Window window, final String s, final CStandardHelperThread cStandardHelperThread) {
        final CStandardProgressDialog cStandardProgressDialog = new CStandardProgressDialog(window, "BinDiff", s, cStandardHelperThread);
        initializeWindowIcons(cStandardProgressDialog);
        cStandardProgressDialog.setSize(400, 122);
        cStandardProgressDialog.setMinimumSize(new Dimension(400, 122));
        cStandardHelperThread.start();
        cStandardProgressDialog.setVisible(true);
        return cStandardProgressDialog;
    }
}
