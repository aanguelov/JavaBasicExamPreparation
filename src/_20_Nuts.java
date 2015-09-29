import java.util.*;

public class _20_Nuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> companies = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String company = line[0];
            String nut = line[1];
            int amount = Integer.parseInt(line[2].substring(0, line[2].length() - 2));
            if (!companies.containsKey(company)) {
                companies.put(company, new LinkedHashMap<>());
                companies.get(company).put(nut, amount);
            } else {
                Integer nutAmount = companies.get(company).get(nut);
                if (nutAmount == null) {
                    nutAmount = 0;
                }
                companies.get(company).put(nut, nutAmount + amount);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : companies.entrySet()) {
            System.out.print(stringMapEntry.getKey() + ": ");
            Map<String, Integer> temp = stringMapEntry.getValue();
            ArrayList<String> nuts = new ArrayList<>();
            for (Map.Entry<String, Integer> stringIntegerEntry : temp.entrySet()) {
                nuts.add(stringIntegerEntry.getKey() + "-" + stringIntegerEntry.getValue().toString() + "kg");
            }
            System.out.println(String.join(", ", nuts));
        }
    }
}
