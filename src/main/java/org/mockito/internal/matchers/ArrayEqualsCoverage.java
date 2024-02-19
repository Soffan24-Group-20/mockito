package org.mockito.internal.matchers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArrayEqualsCoverage {
    private final String path = "src/main/java/org/mockito/internal/matchers/ArrayEqualsCoverage.txt";

    public ArrayEqualsCoverage() {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                String zeros = "0".repeat(39);
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
