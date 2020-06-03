package mg.puc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    System.out.println("// write your code here");
  }

  public static String readFile(String path) throws IOException {
    return Files.readString(Paths.get(path));
  }

  public static void writeFile(String path, String conteudo) throws IOException {
    Files.writeString(Paths.get(path), conteudo);
  }
}