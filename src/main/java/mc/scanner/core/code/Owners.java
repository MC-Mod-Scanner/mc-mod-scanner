package mc.scanner.core.code;

import java.util.List;

public class Owners {
    public static List<String> Class            = List.of("java/lang/Class");
    public static List<String> HTTP             = List.of("java/net/HttpURLConnection");
    public static List<String> NetworkInterface = List.of("java/net/NetworkInterface");
    public static List<String> Process          = List.of("java/lang/Process", "java/lang/ProcessBuilder");
    public static List<String> Proxy            = List.of("java/net/ProxySelector");
    public static List<String> Runtime          = List.of("java/lang/Runtime");
    public static List<String> System           = List.of("java/lang/System");
    public static List<String> TCP              = List.of("java/net/Socket", "java/net/ServerSocket", "java/net/SocketException");
    public static List<String> UDP              = List.of("java/net/DatagramPacket", "java/net/DatagramSocket");
    public static List<String> URL              = List.of("java/net/URL", "java/net/URLConnection");
    public static List<String> URI              = List.of("java/net/URI", "java/net/URISyntaxException");
}
