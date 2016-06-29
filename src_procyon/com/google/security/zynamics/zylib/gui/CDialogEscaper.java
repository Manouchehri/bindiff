package com.google.security.zynamics.zylib.gui;

import com.google.common.base.*;
import javax.swing.*;
import java.awt.event.*;

public class CDialogEscaper
{
    public CDialogEscaper(final JDialog dialog) {
        Preconditions.checkNotNull(dialog, (Object)"Error: dialog argument can not be null");
        dialog.getRootPane().registerKeyboardAction(new CDialogEscaper$1(this, dialog), "doEscape", KeyStroke.getKeyStroke(27, 0, false), 2);
    }
}
