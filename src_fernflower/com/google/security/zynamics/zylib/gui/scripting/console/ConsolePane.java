package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel;
import com.google.security.zynamics.zylib.gui.scripting.ConsoleWriter;
import com.google.security.zynamics.zylib.gui.scripting.IScriptConsole;
import com.google.security.zynamics.zylib.gui.scripting.InitStringFactory;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsoleCodeDocument;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$InterpreterKeyListener;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$TabCompletionManager;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsoleStdoutDocument;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class ConsolePane extends AbstractScriptPanel {
   private static final long serialVersionUID = 3114171042368746418L;
   private final KeyListener m_KeyListener = new ConsolePane$InterpreterKeyListener(this, (ConsolePane$1)null);
   private int m_HistoryPosition = 0;
   private final ArrayList m_LineHistory = new ArrayList();
   private String m_SavedTypedLine = "";
   private final ConsolePane$TabCompletionManager m_tabCompletion = new ConsolePane$TabCompletionManager(this, (ConsolePane$1)null);
   private static final boolean m_IsMultilineInput = false;
   private int m_LastAutoCompleteChunkLength = 0;
   private String m_CurrentPrompt;
   private String consoleName;
   private String currentLanguage;
   private IScriptConsole console;
   private ArrayList realBindings;
   private ScriptEngine engine;
   private String buffered = "";
   private final TreeSet candidates;
   private String m_libraryPath;

   public ConsolePane() {
      super(new BorderLayout());
      this.updateDocument();
      this.candidates = new TreeSet(this.getDocument().getTabCompletionWords());
      this.getInputPane().addKeyListener(this.m_KeyListener);
      this.getDocument().setInputKeyListener(this.m_KeyListener);
      this.getOutputPane().setFont(new Font(GuiHelper.getMonospaceFont(), 0, 12));
      this.setBorder(new EmptyBorder(5, 5, 5, 5));
   }

   private void executeInitializer() {
      if(this.m_libraryPath != null) {
         List var1 = this.engine.getFactory().getExtensions();
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            String var5 = this.m_libraryPath;
            String var6 = String.valueOf(File.separator);
            String var4 = (new StringBuilder(5 + String.valueOf(var5).length() + String.valueOf(var6).length() + String.valueOf(var3).length())).append(var5).append(var6).append("init.").append(var3).toString();
            if(FileUtils.exists(var4)) {
               try {
                  this.engine.eval(FileUtils.readTextfile(var4));
                  this.getOutputPane().setText(this.console.getOutput());
               } catch (ScriptException var7) {
                  this.getOutputPane().setText(var7.getLocalizedMessage());
               } catch (IOException var8) {
                  this.getOutputPane().setText(var8.getLocalizedMessage());
               }
            }
         }

      }
   }

   private int getCurrentInputLine() {
      return this.getDocument().getLineStartOffset(this.getInputPane().getCaretPosition());
   }

   private String getCurrentLine() {
      int var1 = this.getInputPane().getCaretPosition();
      String var2 = null;
      int var3 = this.m_CurrentPrompt.length();
      var2 = this.getDocument().getCurrentLine(var1).trim();
      if(var3 < var2.length()) {
         var2 = var2.substring(var3, var2.length());
      } else {
         var2 = "";
      }

      return var2;
   }

   private ConsoleCodeDocument getDocument() {
      return (ConsoleCodeDocument)this.getInputPane().getDocument();
   }

   private int getLastInputLine() {
      return this.getDocument().getLineStartOffset(this.getInputPane().getText().length());
   }

   private void goToLastLine() {
      this.getInputPane().setCaretPosition(this.getInputPane().getText().length());
   }

   private void interpreterNewLine(boolean var1) {
      int var2 = this.getInputPane().getCaretPosition();
      int var3;
      if(var2 == 0) {
         var3 = 0;
      } else {
         this.getDocument().insertChar(var2, "\n");
         var3 = var2 + 1;
      }

      this.m_CurrentPrompt = var1?"... ":">>> ";
      this.getDocument().insertPrompt(var3, this.m_CurrentPrompt);
      this.getInputPane().setCaretPosition(var3 + this.m_CurrentPrompt.length());
   }

   private void setCurrentLine(String var1) {
      this.goToLastLine();
      this.getDocument().setCurrentLine(this.getInputPane().getCaretPosition(), this.m_CurrentPrompt.length(), var1);
   }

   protected void initConsole() {
      this.currentLanguage = this.getSelectedLanguage();
      this.console = new ConsoleWriter(new StringWriter());
      this.buffered = InitStringFactory.getInitString(this.currentLanguage, this.consoleName, this.m_libraryPath);
      this.realBindings = this.getBindings();
      if(this.consoleName != null) {
         this.realBindings.add(new Pair(this.consoleName, this.console));
      }

      if(this.currentLanguage != null) {
         this.engine = this.getManager().getEngineByName(this.currentLanguage);
         Preconditions.checkNotNull(this.engine, "Error: Unknown scripting language");
         this.engine.getContext().setWriter(this.console.getWriter());
         Iterator var1 = this.realBindings.iterator();

         while(var1.hasNext()) {
            Pair var2 = (Pair)var1.next();
            this.engine.put((String)var2.first(), var2.second());
         }

         this.executeInitializer();
      }
   }

   protected void updateDocument() {
      this.getInputPane().setDocument(new ConsoleCodeDocument());
      this.interpreterNewLine(false);
   }

   public void setConsoleName(String var1) {
      this.consoleName = var1;
      this.initConsole();
      this.updateDocument();
   }

   public void setLibraryPath(String var1) {
      this.m_libraryPath = var1;
      this.initConsole();
      this.updateDocument();
   }

   // $FF: synthetic method
   static String access$300(ConsolePane var0) {
      return var0.getProgressWindowTitle();
   }

   // $FF: synthetic method
   static IScriptConsole access$400(ConsolePane var0) {
      return var0.console;
   }

   // $FF: synthetic method
   static JTextPane access$500(ConsolePane var0) {
      return var0.getOutputPane();
   }

   // $FF: synthetic method
   static JTextPane access$600(ConsolePane var0) {
      return var0.getInputPane();
   }

   // $FF: synthetic method
   static JTextPane access$700(ConsolePane var0) {
      return var0.getInputPane();
   }

   // $FF: synthetic method
   static JTextPane access$800(ConsolePane var0) {
      return var0.getInputPane();
   }

   // $FF: synthetic method
   static ConsoleCodeDocument access$900(ConsolePane var0) {
      return var0.getDocument();
   }

   // $FF: synthetic method
   static String access$1000(ConsolePane var0) {
      return var0.m_CurrentPrompt;
   }

   // $FF: synthetic method
   static int access$1100(ConsolePane var0) {
      return var0.m_HistoryPosition;
   }

   // $FF: synthetic method
   static ArrayList access$1200(ConsolePane var0) {
      return var0.m_LineHistory;
   }

   // $FF: synthetic method
   static int access$1104(ConsolePane var0) {
      return ++var0.m_HistoryPosition;
   }

   // $FF: synthetic method
   static void access$1300(ConsolePane var0, String var1) {
      var0.setCurrentLine(var1);
   }

   // $FF: synthetic method
   static int access$1108(ConsolePane var0) {
      return var0.m_HistoryPosition++;
   }

   // $FF: synthetic method
   static String access$1400(ConsolePane var0) {
      return var0.m_SavedTypedLine;
   }

   // $FF: synthetic method
   static void access$1500(ConsolePane var0) {
      var0.goToLastLine();
   }

   // $FF: synthetic method
   static String access$1600(ConsolePane var0) {
      return var0.getCurrentLine();
   }

   // $FF: synthetic method
   static String access$1700(ConsolePane var0) {
      return var0.buffered;
   }

   // $FF: synthetic method
   static String access$1702(ConsolePane var0, String var1) {
      return var0.buffered = var1;
   }

   // $FF: synthetic method
   static String access$1402(ConsolePane var0, String var1) {
      return var0.m_SavedTypedLine = var1;
   }

   // $FF: synthetic method
   static String access$1800(ConsolePane var0) {
      return var0.currentLanguage;
   }

   // $FF: synthetic method
   static String access$1900(ConsolePane var0) {
      return var0.consoleName;
   }

   // $FF: synthetic method
   static String access$2000(ConsolePane var0) {
      return var0.m_libraryPath;
   }

   // $FF: synthetic method
   static ConsoleStdoutDocument access$2100(ConsolePane var0) {
      return var0.getOutputDocument();
   }

   // $FF: synthetic method
   static int access$1102(ConsolePane var0, int var1) {
      return var0.m_HistoryPosition = var1;
   }

   // $FF: synthetic method
   static void access$2200(ConsolePane var0, boolean var1) {
      var0.interpreterNewLine(var1);
   }

   // $FF: synthetic method
   static ConsoleStdoutDocument access$2300(ConsolePane var0) {
      return var0.getOutputDocument();
   }

   // $FF: synthetic method
   static JTextPane access$2400(ConsolePane var0) {
      return var0.getInputPane();
   }

   // $FF: synthetic method
   static JTextPane access$2500(ConsolePane var0) {
      return var0.getInputPane();
   }

   // $FF: synthetic method
   static int access$2600(ConsolePane var0) {
      return var0.m_LastAutoCompleteChunkLength;
   }

   // $FF: synthetic method
   static ConsolePane$TabCompletionManager access$2700(ConsolePane var0) {
      return var0.m_tabCompletion;
   }

   // $FF: synthetic method
   static int access$2602(ConsolePane var0, int var1) {
      return var0.m_LastAutoCompleteChunkLength = var1;
   }

   // $FF: synthetic method
   static int access$1106(ConsolePane var0) {
      return --var0.m_HistoryPosition;
   }

   // $FF: synthetic method
   static int access$2800(ConsolePane var0) {
      return var0.getLastInputLine();
   }

   // $FF: synthetic method
   static int access$2900(ConsolePane var0) {
      return var0.getCurrentInputLine();
   }

   // $FF: synthetic method
   static ScriptEngine access$3000(ConsolePane var0) {
      return var0.engine;
   }

   // $FF: synthetic method
   static JTextPane access$3100(ConsolePane var0) {
      return var0.getOutputPane();
   }

   // $FF: synthetic method
   static TreeSet access$3400(ConsolePane var0) {
      return var0.candidates;
   }
}
