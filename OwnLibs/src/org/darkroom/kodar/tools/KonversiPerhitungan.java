/*
 * @Junior Software, DarkPlace (c) 2014.
 * Jangan merubah dan melakukan editing terhadap pembuat (author)
 * pada file ini. Boleh digunakan sebagai Referensi dan free untuk share
 * 
 * indrakodar.kodar@gmail.com - (c) Friday, 09 January - 2015
 * Last Update : 5 Februari 2016
 */
package org.darkroom.kodar.tools;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author IndraKodar
 */
public class KonversiPerhitungan {

    protected final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static final double PHI = 3.14;

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String hexToWord(String hex) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {
            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);
            temp.append(decimal);
        }//System.out.println("Decimal : " + temp.toString());
        return sb.toString();
    }

    public static String wordToHex(String input) throws UnsupportedEncodingException {
        if (input == null) {
            throw new NullPointerException();
        }
        return asHex(input.getBytes("UTF-8"));
    }

    private static String asHex(byte[] buf) {
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i) {
            chars[2 * i] = hexArray[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = hexArray[buf[i] & 0x0F];
        }
        return new String(chars);
    }

    /**
     * Volume dimana satuannya adalah meter (meter),
     *
     * @param r dalam meter
     * @param p meter
     * @return Volume AS double
     */
    public static double getVolume(double r, double p) {
        double vol;
        double jari;
        jari = r / 100;
        vol = (PHI * (jari * jari)) * p;

        return vol;
    }
//
//    public static void main(String[] args) {
//        KonversiPerhitungan aK = new KonversiPerhitungan();
//        String test = "I Love Java";
//        System.out.println("Original Word : " + test);
//        System.out.println("To Hex  : " + aK.wordToHex(test).toUpperCase());
//        System.out.println("To Word : " + aK.hexToWord(aK.wordToHex(test)));
//    }

}
