import java.util.Scanner;
public class VigenereCipher {
    public static void main(String[] args) {
          Scanner k = new Scanner(System.in);
          System.out.println("Please enter a key.");
          String key = k.nextLine();
          Scanner pT = new Scanner(System.in);
          System.out.println("Please enter a plainText.");
          String plainText = pT.nextLine();
          String enc = encrypt(plainText.toUpperCase(), key.toUpperCase());
          System.out.println("---------------------------------------------");
          System.out.println(enc);
          System.out.println(decrypt(enc, key.toUpperCase()));
    }

    static String encrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    static String decrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
}
