/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class NotifiedMethodInvocationReportCoverage {

    private final String path = "src/main/java/org/mockito/internal/handler/NotifiedMethodInvocationReportCoverage.txt";

    public NotifiedMethodInvocationReportCoverage(){

        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                String zeros = "00000000000000";
                writer.write(zeros + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void branchUsed(int index){
        RandomAccessFile writer;
        try {
            writer = new RandomAccessFile(new File(path), "rw");
            writer.seek(index);
            writer.write('1');
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
