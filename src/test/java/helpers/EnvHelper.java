package helpers;

public class EnvHelper {
    public static boolean isRemote = System.getProperty("env").equals("remote");
}
