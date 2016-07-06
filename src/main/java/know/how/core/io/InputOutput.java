package know.how.core.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class InputOutput {

    public static void main (String[] args) throws IOException {
        Writer writer = new FileWriter("fileWriter.txt");
        Reader reader = new FileReader("fileReader.txt");

        InputStream in = new FileInputStream("fileInputStream.txt");
        OutputStream out = new FileOutputStream("fileOutputStream.txt");
    }

}
