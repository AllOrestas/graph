package lt.kvk.i9.domas_astrauskas.utiliti;

import lt.kvk.i9.domas_astrauskas.sarasas.List;
import lt.kvk.i9.domas_astrauskas.data.objet.Node;

import java.io.*;

import static java.lang.String.valueOf;

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
     * Data insertion from data file to list
     *
     * @param file data file to be read
     * @param list list to bee added
     */
    public void readData(File file, List list) {
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                temp = line.split(delimiter);
                list.insertItem(temp[0], Double.valueOf(temp[1]), temp[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Duomenų įterpimas
     * Įterpimas į pradinį duomenų failą
     */
    public void writeData( File inputFile, Node node) {
        try {
            // temp file write, used to temporary keep data
            bw = new BufferedWriter(new FileWriter(inputFile));

            // writes everything from list to tempFile
            for (Node local = node; local != null; local = local.link) {
                String line = local.getData().getName() + delimiter +
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