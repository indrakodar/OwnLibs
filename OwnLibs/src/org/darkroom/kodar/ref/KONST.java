/*
 * 
 * @Junior Software, DarkPlace (c) 2014
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 *  
 * indrakodar.kodar@gmail.com - (c)Thursday - 17 December 2015
 * Last Update : 5 Februari 2016
 * 
 */
package org.darkroom.kodar.ref;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * KONST merupakan kelas konstanta untuk data yang bersifat tetap dan juga
 * merupakan referensi. Dimana kategori Referensi dibagi menjadi beberapa Sub,
 * Diantaranya :
 *
 * @param 1. Variabel Owner
 * @param 2. Angka 0 - 9
 * @param 3. Konfigurasi Tanggal dan Jam
 *
 *
 * @author IndraArumanQadar
 */
public class KONST {

    //<editor-fold defaultstate="collapsed" desc="Variabel Owner">
    public static final String TITLE = "Own Library";
    public static final String VERSION = "1.0";
    public static final String TO_STRING = "IndraKodar@DarkPlaces";
    public static final String OWNER = "IndraKodar";
    public static final String OWNER_EMAIL = "indrakodar.kodar@gmail.com";
    public static final String OWNER_EMAIL_OFFICE = "indra.kodar@len.co.id";
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Angka 0 - 9 Integer">
    public static final int NOL = 0;
    public static final int SATU = 1;
    public static final int DUA = 2;
    public static final int TIGA = 3;
    public static final int EMPAT = 4;
    public static final int LIMA = 5;
    public static final int ENAM = 6;
    public static final int TUJUH = 7;
    public static final int DELAPAN = 8;
    public static final int SEMBILAN = 9;
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Konfigurasi Tanggal dan Jam">
    private static SimpleDateFormat aDateFormat;
    /**
     * Untuk locale Tanggal Bahasa Indonesia, Senin selasa dst
     */
    public static final String LOCALE_IN = "in";
    /**
     * Untuk locale Tanggal Bahasa Inggris, Monday Tuesday etc
     */
    public static final String LOCALE_EN = "en";

    /**
     * Variabel pattern untuk diisi pattern dari SimpleDateFormat
     */
    public static String PATTERN_CUSTOM = "";
    /**
     * @return Selasa, 14 Juli 1986 - 14:55:59
     */
    public static final String PATTERN_TGL_WAKTU = "EEEE, dd MMMM yyyy - HH:mm:ss";
    /**
     * @return 12:44:50
     */
    public static final String PATTERN_WAKTU = "HH:mm:ss";

    public static SimpleDateFormat getFormatTanggalLengkap(String Pattern, String locale) {
        aDateFormat = new SimpleDateFormat(Pattern, new Locale(locale));
        return aDateFormat;
    }
//</editor-fold>

    @Override
    public String toString() {
        return TO_STRING;
    }
}
