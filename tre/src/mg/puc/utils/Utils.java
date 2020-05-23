package mg.puc.utils;

public class Utils {
  public static void trimAll(String[] strings) {
    for (int i = 0; i < strings.length; i++) {
      strings[i] = strings[i].trim();
    }
  }
}
