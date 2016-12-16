package util;


import core.Vertex;

import java.io.*;

/**
 * Created by Pikis on 12/1/2016.
 */
public class ReadData {

    BufferedReader br = null;
    BufferedWriter bw = null;
    String line = "";
    String delimiter = ",";

    String[] temp = null; // holds data road from selected line

    // constructor
    public ReadData() {

    }


    /**
     * Duomenų įterpimas
     * Įterpimas į pradinį duomenų failą
     */
    public void writeData( File inputFile, Vertex vertex) {
        try {
            // temp file write, used to temporary keep data
            bw = new BufferedWriter(new FileWriter(inputFile));

            // writes everything from list to tempFile
            for (Vertex local = vertex; local != null; local = local) {
                line = local.getData().getName() + delimiter +
                        local.getData().getValue() + delimiter +
                        local.getData().getDate();

                bw.write(line);
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // used to close br and bw
            closeBrAndBw(bw);
        }

    }

    // close buffered reader and buffered writer
    private void closeBrAndBw(BufferedWriter bw) {
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}