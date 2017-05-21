/*
 * Copyright (C) 2017 patrick
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package screenstudio.panel.editor;

import java.awt.Color;
import screenstudio.gui.LabelText;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import screenstudio.sources.SourceText;
import screenstudio.targets.Source.View;

/**
 *
 * @author patrick
 */
public class TextEditor extends javax.swing.JDialog {

    private final TextViewer mTextViewer;
    private final SourceText mSource;
    private final LabelText mText;

    /**
     * Creates new form TextEditor
     *
     * @param width
     * @param height
     * @param text
     * @param parent
     * @param modal
     */
    public TextEditor(int width, int height, LabelText text, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(parent.getIconImage());
        mText = text;
        Rectangle r = new Rectangle(width, height);
        ArrayList<View> views = new ArrayList<>();
        View v = new View();
        v.Height = height;
        v.Width = width;
        views.add(v);
        mSource = new SourceText(views, text);
        mTextViewer = new TextViewer(mSource);
        mTextViewer.setOpaque(true);

        panViewer.add(mTextViewer, java.awt.BorderLayout.CENTER);
        panViewer.setPreferredSize(r.getSize());
        panViewer.setSize(r.getSize());
        mTextViewer.setSize(r.getSize());
        mTextViewer.setPreferredSize(r.getSize());

        pack();
        setControls();
        txtText.setText(text.getText());
        cboFonts.setSelectedItem(text.getFontName());
        slideFontSize.setValue(text.getFontSize());

        slideFGRed.setValue(new Color(text.getForegroundColor()).getRed());
        slideFGGreen.setValue(new Color(text.getForegroundColor()).getGreen());
        slideFGBlue.setValue(new Color(text.getForegroundColor()).getBlue());
        slideFGAlpha.setValue(new Color(text.getForegroundColor(), true).getAlpha());

        slideBGRed.setValue(new Color(text.getBackgroundColor()).getRed());
        slideBGGreen.setValue(new Color(text.getBackgroundColor()).getGreen());
        slideBGBlue.setValue(new Color(text.getBackgroundColor()).getBlue());
        slideBGAlpha.setValue(new Color(text.getBackgroundColor(), true).getAlpha());

        slideBGRedArea.setValue(new Color(text.getBackgroundAreaColor()).getRed());
        slideBGGreenArea.setValue(new Color(text.getBackgroundAreaColor()).getGreen());
        slideBGBlueArea.setValue(new Color(text.getBackgroundAreaColor()).getBlue());
        slideBGAlphaArea.setValue(new Color(text.getBackgroundAreaColor(), true).getAlpha());

    }

    private void setControls() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        cboFonts.setModel(model);
        String[] tags = {"@CURRENTDATE", "@CURRENTIME", "@STARTTIME", "@RECORDINGTIME", "@UPDATE 60 SEC@", "@UPDATE 5 MIN@", "@ONCHANGEONLY", "@ONELINER", "@SCROLLVERTICAL", "@SCROLLHORIZONTAL", "", "file:///path/to/file.txt"};
        for (String t : tags) {
            if (t.length() > 0) {
                JMenuItem m = new JMenuItem(t);
                m.setActionCommand(t);
                m.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        txtText.insert(e.getActionCommand(), txtText.getCaretPosition());
                    }
                });
                mnuTags.add(m);
            } else
                mnuTags.add(new JSeparator());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitter = new javax.swing.JSplitPane();
        panEditor = new javax.swing.JPanel();
        textScroller = new javax.swing.JScrollPane();
        txtText = new javax.swing.JTextArea();
        cboFonts = new javax.swing.JComboBox<>();
        slideFontSize = new javax.swing.JSlider();
        tabsColor = new javax.swing.JTabbedPane();
        panFGGroup = new javax.swing.JPanel();
        slideFGRed = new javax.swing.JSlider();
        slideFGGreen = new javax.swing.JSlider();
        slideFGBlue = new javax.swing.JSlider();
        slideFGAlpha = new javax.swing.JSlider();
        panBGGroup = new javax.swing.JPanel();
        slideBGRed = new javax.swing.JSlider();
        slideBGGreen = new javax.swing.JSlider();
        slideBGBlue = new javax.swing.JSlider();
        slideBGAlpha = new javax.swing.JSlider();
        panBGGroupArea = new javax.swing.JPanel();
        slideBGRedArea = new javax.swing.JSlider();
        slideBGGreenArea = new javax.swing.JSlider();
        slideBGBlueArea = new javax.swing.JSlider();
        slideBGAlphaArea = new javax.swing.JSlider();
        scrollViewer = new javax.swing.JScrollPane();
        panViewer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuTags = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ScreenStudio Editor");
        setAlwaysOnTop(true);

        splitter.setDividerLocation(300);

        txtText.setColumns(20);
        txtText.setRows(5);
        txtText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTextKeyPressed(evt);
            }
        });
        textScroller.setViewportView(txtText);

        cboFonts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFonts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFontsActionPerformed(evt);
            }
        });

        slideFontSize.setMajorTickSpacing(32);
        slideFontSize.setMaximum(256);
        slideFontSize.setMinimum(8);
        slideFontSize.setMinorTickSpacing(8);
        slideFontSize.setPaintLabels(true);
        slideFontSize.setPaintTicks(true);
        slideFontSize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideFontSizeMouseDragged(evt);
            }
        });
        slideFontSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideFontSizeMouseDragged(evt);
            }
        });

        panFGGroup.setLayout(new javax.swing.BoxLayout(panFGGroup, javax.swing.BoxLayout.PAGE_AXIS));

        slideFGRed.setMaximum(255);
        slideFGRed.setBorder(javax.swing.BorderFactory.createTitledBorder("Red"));
        slideFGRed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        slideFGRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        panFGGroup.add(slideFGRed);

        slideFGGreen.setMaximum(255);
        slideFGGreen.setBorder(javax.swing.BorderFactory.createTitledBorder("Green"));
        slideFGGreen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        slideFGGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        panFGGroup.add(slideFGGreen);

        slideFGBlue.setMaximum(255);
        slideFGBlue.setBorder(javax.swing.BorderFactory.createTitledBorder("Blue"));
        slideFGBlue.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        slideFGBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        panFGGroup.add(slideFGBlue);

        slideFGAlpha.setMaximum(255);
        slideFGAlpha.setValue(255);
        slideFGAlpha.setBorder(javax.swing.BorderFactory.createTitledBorder("Alpha"));
        slideFGAlpha.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        slideFGAlpha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideTextForegroundColor(evt);
            }
        });
        panFGGroup.add(slideFGAlpha);

        tabsColor.addTab("Foreground", panFGGroup);

        panBGGroup.setLayout(new javax.swing.BoxLayout(panBGGroup, javax.swing.BoxLayout.Y_AXIS));

        slideBGRed.setMaximum(255);
        slideBGRed.setBorder(javax.swing.BorderFactory.createTitledBorder("Red"));
        slideBGRed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        slideBGRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        panBGGroup.add(slideBGRed);

        slideBGGreen.setMaximum(255);
        slideBGGreen.setBorder(javax.swing.BorderFactory.createTitledBorder("Green"));
        slideBGGreen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        slideBGGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        panBGGroup.add(slideBGGreen);

        slideBGBlue.setMaximum(255);
        slideBGBlue.setBorder(javax.swing.BorderFactory.createTitledBorder("Blue"));
        slideBGBlue.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        slideBGBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        panBGGroup.add(slideBGBlue);

        slideBGAlpha.setMaximum(255);
        slideBGAlpha.setValue(255);
        slideBGAlpha.setBorder(javax.swing.BorderFactory.createTitledBorder("Alpha"));
        slideBGAlpha.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        slideBGAlpha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGColor(evt);
            }
        });
        panBGGroup.add(slideBGAlpha);

        tabsColor.addTab("Shadow", panBGGroup);

        panBGGroupArea.setLayout(new javax.swing.BoxLayout(panBGGroupArea, javax.swing.BoxLayout.Y_AXIS));

        slideBGRedArea.setMaximum(255);
        slideBGRedArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Red"));
        slideBGRedArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        slideBGRedArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        panBGGroupArea.add(slideBGRedArea);

        slideBGGreenArea.setMaximum(255);
        slideBGGreenArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Green"));
        slideBGGreenArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        slideBGGreenArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        panBGGroupArea.add(slideBGGreenArea);

        slideBGBlueArea.setMaximum(255);
        slideBGBlueArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Blue"));
        slideBGBlueArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        slideBGBlueArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        panBGGroupArea.add(slideBGBlueArea);

        slideBGAlphaArea.setMaximum(255);
        slideBGAlphaArea.setValue(255);
        slideBGAlphaArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Alpha"));
        slideBGAlphaArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        slideBGAlphaArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slideBGAreaColor(evt);
            }
        });
        panBGGroupArea.add(slideBGAlphaArea);

        tabsColor.addTab("Background", panBGGroupArea);

        javax.swing.GroupLayout panEditorLayout = new javax.swing.GroupLayout(panEditor);
        panEditor.setLayout(panEditorLayout);
        panEditorLayout.setHorizontalGroup(
            panEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(cboFonts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slideFontSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabsColor))
                .addContainerGap())
        );
        panEditorLayout.setVerticalGroup(
            panEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboFonts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slideFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabsColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        splitter.setLeftComponent(panEditor);

        panViewer.setBackground(new java.awt.Color(0, 0, 0));
        panViewer.setLayout(new java.awt.BorderLayout());
        scrollViewer.setViewportView(panViewer);

        splitter.setRightComponent(scrollViewer);

        getContentPane().add(splitter, java.awt.BorderLayout.CENTER);

        mnuTags.setText("Tags");
        jMenuBar1.add(mnuTags);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextKeyPressed
        mTextViewer.setText(txtText.getText() + evt.getKeyChar());
        mText.setText((txtText.getText() + evt.getKeyChar()).trim());
    }//GEN-LAST:event_txtTextKeyPressed

    private void cboFontsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFontsActionPerformed
        if (mSource != null) {
            mSource.setFont(new Font(cboFonts.getSelectedItem().toString(), Font.PLAIN, slideFontSize.getValue()));
            mText.setFontName(cboFonts.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cboFontsActionPerformed

    private void slideFontSizeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideFontSizeMouseDragged
        if (mSource != null) {
            mSource.setFont(new Font(cboFonts.getSelectedItem().toString(), Font.PLAIN, slideFontSize.getValue()));
            mText.setFontSize(slideFontSize.getValue());
        }
    }//GEN-LAST:event_slideFontSizeMouseDragged

    private void slideTextForegroundColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideTextForegroundColor
        setTextForeground();
    }//GEN-LAST:event_slideTextForegroundColor

    private void slideBGColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideBGColor
        setTextBackground();
    }//GEN-LAST:event_slideBGColor

    private void slideBGAreaColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slideBGAreaColor
        setTextBackgroundArea();

    }//GEN-LAST:event_slideBGAreaColor

    private void setTextForeground() {
        if (mSource != null) {
            int c = (slideFGAlpha.getValue() << 24) + (slideFGRed.getValue() << 16) + (slideFGGreen.getValue() << 8) + slideFGBlue.getValue();
            mSource.setForeground(c);
            mText.setForegroundColor(c);
        }
    }

    private void setTextBackground() {
        if (mSource != null) {
            int c = (slideBGAlpha.getValue() << 24) + (slideBGRed.getValue() << 16) + (slideBGGreen.getValue() << 8) + slideBGBlue.getValue();
            mSource.setBackground(c);
            mText.setBackgroundColor(c);
        }
    }

    private void setTextBackgroundArea() {
        if (mSource != null) {
            int c = (slideBGAlphaArea.getValue() << 24) + (slideBGRedArea.getValue() << 16) + (slideBGGreenArea.getValue() << 8) + slideBGBlueArea.getValue();
            mSource.setBackgroundArea(c);
            mText.setBackgroundAreaColor(c);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboFonts;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuTags;
    private javax.swing.JPanel panBGGroup;
    private javax.swing.JPanel panBGGroupArea;
    private javax.swing.JPanel panEditor;
    private javax.swing.JPanel panFGGroup;
    private javax.swing.JPanel panViewer;
    private javax.swing.JScrollPane scrollViewer;
    private javax.swing.JSlider slideBGAlpha;
    private javax.swing.JSlider slideBGAlphaArea;
    private javax.swing.JSlider slideBGBlue;
    private javax.swing.JSlider slideBGBlueArea;
    private javax.swing.JSlider slideBGGreen;
    private javax.swing.JSlider slideBGGreenArea;
    private javax.swing.JSlider slideBGRed;
    private javax.swing.JSlider slideBGRedArea;
    private javax.swing.JSlider slideFGAlpha;
    private javax.swing.JSlider slideFGBlue;
    private javax.swing.JSlider slideFGGreen;
    private javax.swing.JSlider slideFGRed;
    private javax.swing.JSlider slideFontSize;
    private javax.swing.JSplitPane splitter;
    private javax.swing.JTabbedPane tabsColor;
    private javax.swing.JScrollPane textScroller;
    private javax.swing.JTextArea txtText;
    // End of variables declaration//GEN-END:variables
}
