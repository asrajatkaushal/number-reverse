import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public List<String> readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = bufferedReader.readLine();
        while (line != null) {
            lines.add(line);
            line = bufferedReader.readLine();
        }
        return lines;
    }

    public String reverse(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            String[] numbers = line.split(",");
            for (int i = numbers.length - 1; i >= 0; i--) {
                sb.append(numbers[i]);
                if (i > 0) {
                    sb.append(",");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Reverse r = new Reverse();
        String fileName = "sample.txt";
        List<String> lines = r.readFile(fileName);
        System.out.print(r.reverse(lines));
    }
}
