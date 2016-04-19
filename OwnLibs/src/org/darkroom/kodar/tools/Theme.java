/*
 * 
 * @Junior Software, DarkPlace (c) 2014
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 *  
 * indrakodar.kodar@gmail.com - (c)Tuesday - 29 March 2016
 * Last Update : 
 * 
 */
package org.darkroom.kodar.tools;

import java.awt.Frame;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.darkroom.kodar.ref.KONST;
import org.pushingpixels.substance.api.skin.SubstanceCremeCoffeeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel;

/**
 *
 * @author IndraArumanQadar
 */
public class Theme extends SwingWorker<Boolean, Void> {

    private final Object lock = new Object();
    private final int thema;

    /**
     * Konstruktor untuk inisialisasi Thema untuk Aplikasi, Dimana pilihan thema
     * ada 6 pilihan. Kelas merupakan Extend dari SwingWorker, maka setelah
     * Instansiasi objek harus di eksekusi dengan 'aObject.execute()'
     *
     * @param thema Nilai integer untuk menentukan pilihan Thema, dimana nilai
     * dari 0 - 5
     * @see " 0=Thema Default dari Thema System Window, 1=Pagadoft Soft Bright,
     * 2=Cream Coffe Yellow, 3=Nebula Forest, 4=Tiny Bright Forest, 5=Default
     * Thema Classic Java"
     */
    public Theme(int thema) {
        this.thema = thema;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        synchronized (lock) {
            SwingUtilities.invokeLater(() -> {
                try {
                    switch (thema) {
                        case 0: //System Windows
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            break;
                        case 1: //Soft Bright
                            UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
                            break;
                        case 2: //Cream Coffe
                            UIManager.setLookAndFeel(new SubstanceCremeCoffeeLookAndFeel());
                            break;
                        case 3: //Nebula Forest
                            UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
                            break;
                        case 4: //TinnyBright Forest
                            UIManager.setLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel");
                            break;
                        case 5: //Default Clasic Java (Metal)
                            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                            break;
                    }
                    for (Frame frame : JFrame.getFrames()) {
                        updateThema(frame);
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
            });

        }
        return true;
    }

    private void updateThema(Window window) {
        for (Window anakWin : window.getOwnedWindows()) {
            updateThema(anakWin);
        }
        SwingUtilities.updateComponentTreeUI(window);
        //Jika SoftBright
        if (thema == 1) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }

    @Override
    public String toString() {
        return KONST.TO_STRING;
    }

}
