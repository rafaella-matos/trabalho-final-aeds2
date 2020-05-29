package mg.puc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    // write your code here
  }
  
  public static String readFile(String path) throws IOException {
    return Files.readString(Paths.get(path));
  }
}