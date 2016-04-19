/*
 * 
 * @Junior Software, DarkPlace (c) 2014
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 *  
 * indrakodar.kodar@gmail.com - (c)Thursday - 24 March 2016
 * Last Update : 
 * 
 */
package org.darkroom.kodar.ref;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author IndraArumanQadar
 */
public class Default {

    public boolean keluarProgram() {
        String tanya;
        tanya = "Keluar Aplikasi ?";
        int konfirmasi = JOptionPane.showConfirmDialog(null, tanya, "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            return true;
        } else {
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }

    /**
     * Set ikon pada Jframe utama untuk menggantikan ikono default java, yang
     * biasanya berdimensi 32 x 32
     *
     * @param frame Frame yang akan diganti Ikonnya
     * @param pathImage ex : "/Len/lpr/co/id/files/IconServer.png"
     */
    public void setIkonProgram(JFrame frame, String pathImage) {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathImage)));
    }
}
