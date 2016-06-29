/*
 * Decompiled with CFR 0_115.
 */
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
import java.awt.LayoutManager;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

public class ConsolePane
extends AbstractScriptPanel {
    private static final long serialVersionUID = 3114171042368746418L;
    private final KeyListener m_KeyListener;
    private int m_HistoryPosition;
    private final ArrayList m_LineHistory;
    private String m_SavedTypedLine;
    private final ConsolePane$TabCompletionManager m_tabCompletion;
    private static final boolean m_IsMultilineInput = false;
    private int m_LastAutoCompleteChunkLength;
    private String m_CurrentPrompt;
    private String consoleName;
    private String currentLanguage;
    private IScriptConsole console;
    private ArrayList realBindings;
    private ScriptEngine engine;
    private String buffered;
    private final TreeSet candidates;
    private String m_libraryPath;

    public ConsolePane() {
        super(new BorderLayout());
        this.m_KeyListener = new ConsolePane$InterpreterKeyListener(this, null);
        this.m_HistoryPosition = 0;
        this.m_LineHistory = new ArrayList();
        this.m_SavedTypedLine = "";
        this.m_tabCompletion = new ConsolePane$TabCompletionManager(this, null);
        this.m_LastAutoCompleteChunkLength = 0;
        this.buffered = "";
        this.updateDocument();
        this.candidates = new TreeSet(this.getDocument().getTabCompletionWords());
        this.getInputPane().addKeyListener(this.m_KeyListener);
        this.getDocument().setInputKeyListener(this.m_KeyListener);
        this.getOutputPane().setFont(new Font(GuiHelper.getMonospaceFont(), 0, 12));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    private void executeInitializer() {
        if (this.m_libraryPath == null) {
            return;
        }
        List<String> list = this.engine.getFactory().getExtensions();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            String string2 = this.m_libraryPath;
            String string3 = String.valueOf(File.separator);
            String string4 = new StringBuilder(5 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string).length()).append(string2).append(string3).append("init.").append(string).toString();
            if (!FileUtils.exists(string4)) continue;
            try {
                this.engine.eval(FileUtils.readTextfile(string4));
                this.getOutputPane().setText(this.console.getOutput());
            }
            catch (ScriptException var5_6) {
                this.getOutputPane().setText(var5_6.getLocalizedMessage());
            }
            catch (IOException var5_7) {
                this.getOutputPane().setText(var5_7.getLocalizedMessage());
                continue;
            }
        }
    }

    private int getCurrentInputLine() {
        return this.getDocument().getLineStartOffset(this.getInputPane().getCaretPosition());
    }

    private String getCurrentLine() {
        int n2 = this.getInputPane().getCaretPosition();
        String string = null;
        int n3 = this.m_CurrentPrompt.length();
        if (n3 >= (string = this.getDocument().getCurrentLine(n2).trim()).length()) return "";
        return string.substring(n3, string.length());
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

    private void interpreterNewLine(boolean bl2) {
        int n2;
        int n3 = this.getInputPane().getCaretPosition();
        if (n3 == 0) {
            n2 = 0;
        } else {
            this.getDocument().insertChar(n3, "\n");
            n2 = n3 + 1;
        }
        this.m_CurrentPrompt = bl2 ? "... " : ">>> ";
        this.getDocument().insertPrompt(n2, this.m_CurrentPrompt);
        this.getInputPane().setCaretPosition(n2 + this.m_CurrentPrompt.length());
    }

    private void setCurrentLine(String string) {
        this.goToLastLine();
        this.getDocument().setCurrentLine(this.getInputPane().getCaretPosition(), this.m_CurrentPrompt.length(), string);
    }

    @Override
    protected void initConsole() {
        this.currentLanguage = this.getSelectedLanguage();
        this.console = new ConsoleWriter(new StringWriter());
        this.buffered = InitStringFactory.getInitString(this.currentLanguage, this.consoleName, this.m_libraryPath);
        this.realBindings = this.getBindings();
        if (this.consoleName != null) {
            this.realBindings.add(new Pair(this.consoleName, this.console));
        }
        if (this.currentLanguage == null) {
            return;
        }
        this.engine = this.getManager().getEngineByName(this.currentLanguage);
        Preconditions.checkNotNull(this.engine, "Error: Unknown scripting language");
        this.engine.getContext().setWriter(this.console.getWriter());
        Iterator iterator = this.realBindings.iterator();
        do {
            if (!iterator.hasNext()) {
                this.executeInitializer();
                return;
            }
            Pair pair = (Pair)iterator.next();
            this.engine.put((String)pair.first(), pair.second());
        } while (true);
    }

    @Override
    protected void updateDocument() {
        this.getInputPane().setDocument(new ConsoleCodeDocument());
        this.interpreterNewLine(false);
    }

    public void setConsoleName(String string) {
        this.consoleName = string;
        this.initConsole();
        this.updateDocument();
    }

    public void setLibraryPath(String string) {
        this.m_libraryPath = string;
        this.initConsole();
        this.updateDocument();
    }

    static /* synthetic */ String access$300(ConsolePane consolePane) {
        return consolePane.getProgressWindowTitle();
    }

    static /* synthetic */ IScriptConsole access$400(ConsolePane consolePane) {
        return consolePane.console;
    }

    static /* synthetic */ JTextPane access$500(ConsolePane consolePane) {
        return consolePane.getOutputPane();
    }

    static /* synthetic */ JTextPane access$600(ConsolePane consolePane) {
        return consolePane.getInputPane();
    }

    static /* synthetic */ JTextPane access$700(ConsolePane consolePane) {
        return consolePane.getInputPane();
    }

    static /* synthetic */ JTextPane access$800(ConsolePane consolePane) {
        return consolePane.getInputPane();
    }

    static /* synthetic */ ConsoleCodeDocument access$900(ConsolePane consolePane) {
        return consolePane.getDocument();
    }

    static /* synthetic */ String access$1000(ConsolePane consolePane) {
        return consolePane.m_CurrentPrompt;
    }

    static /* synthetic */ int access$1100(ConsolePane consolePane) {
        return consolePane.m_HistoryPosition;
    }

    static /* synthetic */ ArrayList access$1200(ConsolePane consolePane) {
        return consolePane.m_LineHistory;
    }

    static /* synthetic */ int access$1104(ConsolePane consolePane) {
        return ++consolePane.m_HistoryPosition;
    }

    static /* synthetic */ void access$1300(ConsolePane consolePane, String string) {
        consolePane.setCurrentLine(string);
    }

    static /* synthetic */ int access$1108(ConsolePane consolePane) {
        return consolePane.m_HistoryPosition++;
    }

    static /* synthetic */ String access$1400(ConsolePane consolePane) {
        return consolePane.m_SavedTypedLine;
    }

    static /* synthetic */ void access$1500(ConsolePane consolePane) {
        consolePane.goToLastLine();
    }

    static /* synthetic */ String access$1600(ConsolePane consolePane) {
        return consolePane.getCurrentLine();
    }

    static /* synthetic */ String access$1700(ConsolePane consolePane) {
        return consolePane.buffered;
    }

    static /* synthetic */ String access$1702(ConsolePane consolePane, String string) {
        consolePane.buffered = string;
        return consolePane.buffered;
    }

    static /* synthetic */ String access$1402(ConsolePane consolePane, String string) {
        consolePane.m_SavedTypedLine = string;
        return consolePane.m_SavedTypedLine;
    }

    static /* synthetic */ String access$1800(ConsolePane consolePane) {
        return consolePane.currentLanguage;
    }

    static /* synthetic */ String access$1900(ConsolePane consolePane) {
        return consolePane.consoleName;
    }

    static /* synthetic */ String access$2000(ConsolePane consolePane) {
        return consolePane.m_libraryPath;
    }

    static /* synthetic */ ConsoleStdoutDocument access$2100(ConsolePane consolePane) {
        return consolePane.getOutputDocument();
    }

    static /* synthetic */ int access$1102(ConsolePane consolePane, int n2) {
        consolePane.m_HistoryPosition = n2;
        return consolePane.m_HistoryPosition;
    }

    static /* synthetic */ void access$2200(ConsolePane consolePane, boolean bl2) {
        consolePane.interpreterNewLine(bl2);
    }

    static /* synthetic */ ConsoleStdoutDocument access$2300(ConsolePane consolePane) {
        return consolePane.getOutputDocument();
    }

    static /* synthetic */ JTextPane access$2400(ConsolePane consolePane) {
        return consolePane.getInputPane();
    }

    static /* synthetic */ JTextPane access$2500(ConsolePane consolePane) {
        return consolePane.getInputPane();
    }

    static /* synthetic */ int access$2600(ConsolePane consolePane) {
        return consolePane.m_LastAutoCompleteChunkLength;
    }

    static /* synthetic */ ConsolePane$TabCompletionManager access$2700(ConsolePane consolePane) {
        return consolePane.m_tabCompletion;
    }

    static /* synthetic */ int access$2602(ConsolePane consolePane, int n2) {
        consolePane.m_LastAutoCompleteChunkLength = n2;
        return consolePane.m_LastAutoCompleteChunkLength;
    }

    static /* synthetic */ int access$1106(ConsolePane consolePane) {
        return --consolePane.m_HistoryPosition;
    }

    static /* synthetic */ int access$2800(ConsolePane consolePane) {
        return consolePane.getLastInputLine();
    }

    static /* synthetic */ int access$2900(ConsolePane consolePane) {
        return consolePane.getCurrentInputLine();
    }

    static /* synthetic */ ScriptEngine access$3000(ConsolePane consolePane) {
        return consolePane.engine;
    }

    static /* synthetic */ JTextPane access$3100(ConsolePane consolePane) {
        return consolePane.getOutputPane();
    }

    static /* synthetic */ TreeSet access$3400(ConsolePane consolePane) {
        return consolePane.candidates;
    }
}

