package org.example;

import java.io.*;

public class FileSegmentation {
    public static void main(String[] args) {
        String sourceFilePath = "D:\\JavaProjects\\xd-java-train\\src\\main\\java\\org\\example\\source.txt";  // 源文件路径
        int segmentSize = 100;  // 每个文件段的大小

        try {
            FileInputStream fis = new FileInputStream(sourceFilePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            int segmentCounter = 1;
            String line;
            int linesCount = 0;

            while ((line = br.readLine()) != null) {
                if (linesCount % segmentSize == 0) {
                    createNewSegmentFile(segmentCounter);
                    segmentCounter++;
                }

                writeLineToSegmentFile(segmentCounter - 1, line);
                linesCount++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewSegmentFile(int segmentCounter) throws IOException {
        String segmentFilePath = "segment_" + segmentCounter + ".txt";
        System.out.println(1);
        FileOutputStream fos = new FileOutputStream(segmentFilePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.close();
    }

    private static void writeLineToSegmentFile(int segmentCounter, String line) throws IOException {
        String segmentFilePath = "segment_" + segmentCounter + ".txt";
        FileWriter fw = new FileWriter(segmentFilePath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(line);
        bw.newLine();
        bw.close();
        System.out.println(2);
    }
}