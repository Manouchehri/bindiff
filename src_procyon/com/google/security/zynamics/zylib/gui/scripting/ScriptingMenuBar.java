package com.google.security.zynamics.zylib.gui.scripting;

import java.io.*;
import com.google.security.zynamics.zylib.resources.*;
import javax.swing.*;
import java.awt.*;

public abstract class ScriptingMenuBar extends JMenuBar
{
    private static final int CTRL_MASK;
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
        final JMenu menu = new JMenu(Constants.MENU_FILE);
        menu.addSeparator();
        menu.add(new ScriptingMenuBar$ExecuteAction(this));
        menu.add(this.executeAgainAction);
        menu.addSeparator();
        menu.add(new ScriptingMenuBar$NewConsoleTabAction(this));
        menu.add(new ScriptingMenuBar$CloseTabAction(this));
        this.add(menu);
        final JMenu menu2 = new JMenu(Constants.MENU_EDIT);
        menu2.addSeparator();
        menu2.add(this.cutAction);
        menu2.add(this.copyAction);
        menu2.add(this.pasteAction);
        this.add(menu2);
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
    
    protected void setLastExecutedScriptFile(final File file) {
        this.lastExecutedFile = file;
        this.executeAgainAction.setFile(file);
    }
    
    public void updateGui(final boolean enabled) {
        this.cutAction.setEnabled(enabled);
        this.copyAction.setEnabled(enabled);
        this.pasteAction.setEnabled(enabled);
    }
    
    static {
        CTRL_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    }
}
