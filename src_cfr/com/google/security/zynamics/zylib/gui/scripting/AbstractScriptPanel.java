/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel$1;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel$InternalLanguageBoxListener;
import com.google.security.zynamics.zylib.gui.scripting.IScriptPanel;
import com.google.security.zynamics.zylib.gui.scripting.LanguageBox;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsoleStdoutDocument;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.script.ScriptEngineManager;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;

public abstract class AbstractScriptPanel
extends JPanel
implements IScriptPanel {
    private static final long serialVersionUID = 8553550256320119608L;
    private final ScriptEngineManager manager = new ScriptEngineManager();
    private final JTextPane m_inputPane = new JTextPane();
    private final JTextPane m_OutputPane = new JTextPane();
    private String m_progressWindowTitle;
    private final ConsoleStdoutDocument m_PythonStdoutDocument = new ConsoleStdoutDocument();
    private final ArrayList bindings = new ArrayList();
    private final LanguageBox languageBox;

    public AbstractScriptPanel(LayoutManager layoutManager) {
        super(layoutManager);
        this.languageBox = new LanguageBox(this.getManager());
        this.languageBox.addActionListener(new AbstractScriptPanel$InternalLanguageBoxListener(this, null));
        this.m_inputPane.setEditable(true);
        this.m_inputPane.setBackground(new Color(0.97f, 0.97f, 1.0f));
        this.m_inputPane.setFont(new Font(GuiHelper.getMonospaceFont(), 0, 13));
        this.m_OutputPane.setDocument(this.m_PythonStdoutDocument);
        this.m_OutputPane.setEditable(false);
        this.m_OutputPane.setBackground(new Color(0.97f, 0.97f, 1.0f));
        JScrollPane jScrollPane = new JScrollPane(this.m_inputPane);
        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Command Line");
        jScrollPane.setBorder(titledBorder);
        jScrollPane.setPreferredSize(new Dimension(600, 200));
        JScrollPane jScrollPane2 = new JScrollPane(this.m_OutputPane);
        TitledBorder titledBorder2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Output");
        jScrollPane2.setBorder(titledBorder2);
        jScrollPane2.setPreferredSize(new Dimension(600, 200));
        this.add((Component)this.languageBox, "North");
        this.add(new JSplitPane(0, false, jScrollPane, jScrollPane2));
    }

    protected ArrayList getBindings() {
        return (ArrayList)this.bindings.clone();
    }

    protected JTextPane getInputPane() {
        return this.m_inputPane;
    }

    protected ScriptEngineManager getManager() {
        return this.manager;
    }

    protected ConsoleStdoutDocument getOutputDocument() {
        return this.m_PythonStdoutDocument;
    }

    protected JTextPane getOutputPane() {
        return this.m_OutputPane;
    }

    protected String getProgressWindowTitle() {
        return this.m_progressWindowTitle;
    }

    protected String getSelectedLanguage() {
        return this.languageBox.getSelectedLanguage();
    }

    protected abstract void initConsole();

    protected abstract void updateDocument();

    public void addBinding(String string, Object object) {
        this.bindings.add(new Pair(string, object));
    }

    public void setLanguage(String string) {
        this.languageBox.setSelectedLanguage(string);
    }

    @Override
    public void setOutput(String string) {
        this.m_OutputPane.setText(string);
    }

    public void setProgressWindowTitle(String string) {
        this.m_progressWindowTitle = string;
    }
}

