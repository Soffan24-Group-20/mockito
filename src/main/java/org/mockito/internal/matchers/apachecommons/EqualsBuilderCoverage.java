/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.matchers.apachecommons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EqualsBuilderCoverage {
    private final String path = "src/main/java/org/mockito/internal/matchers/apachecommons/EqualsBuilderCoverage.txt";

    public EqualsBuilderCoverage() {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                String zeros = "000000000000000000";
                writer.write(zeros + "\n");
                writer.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void branchUsed(int index) {
        RandomAccessFile writer;
        try {
            writer = new RandomAccessFile(new File(path), "rw");
            writer.seek(index);
            writer.write('1');
            writer.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
