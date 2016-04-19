/*
 * @Junior Software, DarkPlace (c) 2014
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 *  
 * indrakodar.kodar@gmail.com - (c) 16-04-2014
 * Last Update : 5 Februari 2016
 */
package org.darkroom.kodar.komponen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.darkroom.kodar.ref.KONST;

/**
 *
 * @author Indra
 */
public class ThreadJam implements Runnable {

    private final Object lock = new Object();
    private Calendar cal;
    private Thread tWaktu;
    private final JLabel labelTanggal;
    private final SimpleDateFormat aFormatJam;

    /**
     * Menampilkan jam pada komponen JLable. Kelas merupakan Thread otomatis
     * running ketika instansiasi objek.
     *
     * @param labelTanggal Komponen JLable yang akan menampung JAM
     * @param formatJam Format untuk jam / tanggal menggunakan SDF
     * @see KONST#PATTERN_TGL_WAKTU
     * @see KONST#LOCALE_IN
     * @see KONST#LOCALE_EN
     */
    public ThreadJam(JLabel labelTanggal, SimpleDateFormat formatJam) {
        this.labelTanggal = labelTanggal;
        aFormatJam = formatJam;
        tWaktu = null;

        startThread();
    }

    private void startThread() {
        tWaktu = new Thread(this, "ThreadWaktu");
        tWaktu.setDaemon(true);
        tWaktu.start();
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (true) {
                    Thread.sleep(1000);
                    if (labelTanggal != null) {
                        cal = Calendar.getInstance();
                        labelTanggal.setText(aFormatJam.format(cal.getTime()));
                    }
                }
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return KONST.TO_STRING;
    }
}
