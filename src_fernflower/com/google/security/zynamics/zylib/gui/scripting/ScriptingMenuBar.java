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
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public abstract class ScriptingMenuBar extends JMenuBar {
   private static final int CTRL_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
   private final ScriptingMenuBar$CutAction cutAction = new ScriptingMenuBar$CutAction(this);
   private final ScriptingMenuBar$CopyAction copyAction = new ScriptingMenuBar$CopyAction(this);
   private final ScriptingMenuBar$PasteAction pasteAction = new ScriptingMenuBar$PasteAction(this);
   private final ScriptingMenuBar$ExecuteAgainAction executeAgainAction = new ScriptingMenuBar$ExecuteAgainAction(this);
   private File lastExecutedFile = null;

   protected ScriptingMenuBar() {
      JMenu var1 = new JMenu(Constants.MENU_FILE);
      var1.addSeparator();
      var1.add(new ScriptingMenuBar$ExecuteAction(this));
      var1.add(this.executeAgainAction);
      var1.addSeparator();
      var1.add(new ScriptingMenuBar$NewConsoleTabAction(this));
      var1.add(new ScriptingMenuBar$CloseTabAction(this));
      this.add(var1);
      JMenu var2 = new JMenu(Constants.MENU_EDIT);
      var2.addSeparator();
      var2.add(this.cutAction);
      var2.add(this.copyAction);
      var2.add(this.pasteAction);
      this.add(var2);
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

   protected void setLastExecutedScriptFile(File var1) {
      this.lastExecutedFile = var1;
      this.executeAgainAction.setFile(var1);
   }

   public void updateGui(boolean var1) {
      this.cutAction.setEnabled(var1);
      this.copyAction.setEnabled(var1);
      this.pasteAction.setEnabled(var1);
   }

   // $FF: synthetic method
   static int access$000() {
      return CTRL_MASK;
   }
}
