package lt.kvk.i9.pavarde_vardas.util;


import lt.kvk.i9.pavarde_vardas.core.Vertex;

import java.io.*;

/**
 * Created by Pikis on 12/1/2016.
 */
public class ReadData {

    BufferedReader br = null;
    BufferedWriter bw = null;
    String line = "";
    String delimiter = ",";

    String[] temp = null; // holds lt.kvk.i9.pavarde_vardas.data road from selected line

    // constructor
    public ReadData() {

    }


    /**
     * Duomenų įterpimas
     * Įterpimas į pradinį duomenų failą
     */
    public void writeData(String inputFile, Vertex vertex[]) {
        try {
            // temp file write, used to temporary keep lt.kvk.i9.pavarde_vardas.data
            bw = new BufferedWriter(new FileWriter(inputFile));

            // writes everything from list to tempFile
            for (int i = 0; i < vertex.length; i++) {
                if (vertex[i] != null) {
                    line = vertex[i].getData().getName() + delimiter +
                            vertex[i].getData().getValue() + delimiter +
                            vertex[i].getData().getDate();

                    bw.write(line);
                    bw.newLine();
                }
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