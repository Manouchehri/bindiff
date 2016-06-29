/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$CloseTabAction;
import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$CopyAction;
import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$CutAction;
import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$ExecuteAction;
import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$ExecuteAgainAction;
import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$NewConsoleTabAction;
import com.google.security.zynamics.zylib.gui.scripting.ScriptingMenuBar$PasteAction;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public abstract class ScriptingMenuBar
extends JMenuBar {
    private static final int CTRL_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    private final ScriptingMenuBar$CutAction cutAction;
    private final ScriptingMenuBar$CopyAction copyAction;
    private final ScriptingMenuBar$PasteAction pasteAction;
    private final ScriptingMenuBar$ExecuteAgainAction executeAgainAction;
    private File lastExecutedFile;

    protected ScriptingMenuBar() {
        this.cutAction = new ScriptingMenuBar$CutAction(this);
        this.copyAction = new ScriptingMenuBar$CopyAction(this);
        this.pasteAction = new ScriptingMenuBar$PasteAction(this);
        this.executeAgainAction = new ScriptingMenuBar$ExecuteAgainAction(this);
        this.lastExecutedFile = null;
        JMenu jMenu = new JMenu(Constants.MENU_FILE);
        jMenu.addSeparator();
        jMenu.add(new ScriptingMenuBar$ExecuteAction(this));
        jMenu.add(this.executeAgainAction);
        jMenu.addSeparator();
        jMenu.add(new ScriptingMenuBar$NewConsoleTabAction(this));
        jMenu.add(new ScriptingMenuBar$CloseTabAction(this));
        this.add(jMenu);
        JMenu jMenu2 = new JMenu(Constants.MENU_EDIT);
        jMenu2.addSeparator();
        jMenu2.add(this.cutAction);
        jMenu2.add(this.copyAction);
        jMenu2.add(this.pasteAction);
        this.add(jMenu2);
    }

    protected abstract void closeTabMenuClicked();

    protected abstract void copyMenuClicked();

    protected abstract void cutMenuClicked();

    protected abstract void executeAgainMenuClicked();

    protected abstract void executeMenuClicked();

    protected File getLastExecutedScriptFile() {
        return this.lastExecutedFile;
    }

    protected abstract void newConsoleTabMenuClicked();

    protected abstract void pasteMenuClicked();

    protected void setLastExecutedScriptFile(File file) {
        this.lastExecutedFile = file;
        this.executeAgainAction.setFile(file);
    }

    public void updateGui(boolean bl2) {
        this.cutAction.setEnabled(bl2);
        this.copyAction.setEnabled(bl2);
        this.pasteAction.setEnabled(bl2);
    }

    static /* synthetic */ int access$000() {
        return CTRL_MASK;
    }
}

