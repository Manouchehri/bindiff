package com.google.security.zynamics.zylib.gui.scripting;

import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel$1;
import com.google.security.zynamics.zylib.gui.scripting.AbstractScriptPanel$InternalLanguageBoxListener;
import com.google.security.zynamics.zylib.gui.scripting.IScriptPanel;
import com.google.security.zynamics.zylib.gui.scripting.LanguageBox;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsoleStdoutDocument;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.script.ScriptEngineManager;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public abstract class AbstractScriptPanel extends JPanel implements IScriptPanel {
   private static final long serialVersionUID = 8553550256320119608L;
   private final ScriptEngineManager manager = new ScriptEngineManager();
   private final JTextPane m_inputPane = new JTextPane();
   private final JTextPane m_OutputPane = new JTextPane();
   private String m_progressWindowTitle;
   private final ConsoleStdoutDocument m_PythonStdoutDocument = new ConsoleStdoutDocument();
   private final ArrayList bindings = new ArrayList();
   private final LanguageBox languageBox = new LanguageBox(this.getManager());

   public AbstractScriptPanel(LayoutManager var1) {
      super(var1);
      this.languageBox.addActionListener(new AbstractScriptPanel$InternalLanguageBoxListener(this, (AbstractScriptPanel$1)null));
      this.m_inputPane.setEditable(true);
      this.m_inputPane.setBackground(new Color(0.97F, 0.97F, 1.0F));
      this.m_inputPane.setFont(new Font(GuiHelper.getMonospaceFont(), 0, 13));
      this.m_OutputPane.setDocument(this.m_PythonStdoutDocument);
      this.m_OutputPane.setEditable(false);
      this.m_OutputPane.setBackground(new Color(0.97F, 0.97F, 1.0F));
      JScrollPane var2 = new JScrollPane(this.m_inputPane);
      TitledBorder var3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Command Line");
      var2.setBorder(var3);
      var2.setPreferredSize(new Dimension(600, 200));
      JScrollPane var4 = new JScrollPane(this.m_OutputPane);
      TitledBorder var5 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true), "Output");
      var4.setBorder(var5);
      var4.setPreferredSize(new Dimension(600, 200));
      this.add(this.languageBox, "North");
      this.add(new JSplitPane(0, false, var2, var4));
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

   public void addBinding(String var1, Object var2) {
      this.bindings.add(new Pair(var1, var2));
   }

   public void setLanguage(String var1) {
      this.languageBox.setSelectedLanguage(var1);
   }

   public void setOutput(String var1) {
      this.m_OutputPane.setText(var1);
   }

   public void setProgressWindowTitle(String var1) {
      this.m_progressWindowTitle = var1;
   }
}
