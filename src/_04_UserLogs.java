import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Map<String, Integer>> usersByIpAddresses = new TreeMap<>();
        while (!command.equals("end")) {
            String[] commandArgs = command.split("\\s+");
            String ip = commandArgs[0].split("=")[1];
            String user = commandArgs[2].split("=")[1];
            if (!usersByIpAddresses.containsKey(user)) {
                usersByIpAddresses.put(user, new LinkedHashMap<>());
                Integer ipCount = usersByIpAddresses.get(user).get(ip);
                if (ipCount == null) {
                    ipCount = 0;
                }
                usersByIpAddresses.get(user).put(ip, ipCount + 1);
            } else {
                Integer ipCount = usersByIpAddresses.get(user).get(ip);
                if (ipCount == null) {
                    ipCount = 0;
                }
                usersByIpAddresses.get(user).put(ip, ipCount + 1);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : usersByIpAddresses.entrySet()) {
            System.out.println(stringMapEntry.getKey() + ":");
            Map<String, Integer> currentAddresses = stringMapEntry.getValue();
            for (Map.Entry<String, Integer> stringIntegerEntry : currentAddresses.entrySet()) {
                char endChar = ',';
                int endKey = currentAddresses.keySet().toArray().length - 1;
                if (stringIntegerEntry.getKey() == currentAddresses.keySet().toArray()[endKey]) {
                    endChar = '.';
                }
                System.out.print(stringIntegerEntry.getKey() + " => " + stringIntegerEntry.getValue() + endChar + " ");
            }
            System.out.println();
        }
    }
}
