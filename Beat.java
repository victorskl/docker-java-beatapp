import java.text.NumberFormat;
import java.util.Map;

public class Beat {

  public static void main(String[] args) throws InterruptedException {

    Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutting down...")));

    // print system environments
    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
      System.out.format("%s=%s%n", envName, env.get(envName));
    }
    System.out.println();

    // print runtime memory info
    Runtime runtime = Runtime.getRuntime();
    final NumberFormat format = NumberFormat.getInstance();
    final long maxMemory = runtime.maxMemory();
    final long allocatedMemory = runtime.totalMemory();
    final long freeMemory = runtime.freeMemory();
    final long mb = 1024 * 1024;
    final String mega = " MB";
    System.out.println("========================== Memory Info ==========================");
    System.out.println("Free memory: " + format.format(freeMemory / mb) + mega);
    System.out.println("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
    System.out.println("Max memory: " + format.format(maxMemory / mb) + mega);
    System.out.println("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
    System.out.println("=================================================================\n");

    System.out.println("Server started...");

    while (true) {
      System.out.println("beat");
      Thread.sleep(5000);
    }
  }
}