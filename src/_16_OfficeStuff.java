import java.util.*;

public class _16_OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> companies = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = input.substring(1, input.length() - 1).split("\\s+-");
            String company = data[0];
            String product = data[2].trim();
            int amount = Integer.parseInt(data[1].trim());

            if (!companies.containsKey(company)) {
                companies.put(company, new LinkedHashMap<>());
                companies.get(company).put(product, amount);
            } else {
                Integer productAmount = companies.get(company).get(product);
                if (productAmount == null) {
                    productAmount = 0;
                }
                companies.get(company).put(product, productAmount + amount);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : companies.entrySet()) {
            System.out.print(stringMapEntry.getKey() + ": ");
            Map<String, Integer> innerMap = stringMapEntry.getValue();
            ArrayList<String> values = new ArrayList<>();
            for (Map.Entry<String, Integer> stringIntegerEntry : innerMap.entrySet()) {
                values.add(stringIntegerEntry.getKey() + "-" + stringIntegerEntry.getValue().toString());
            }
            System.out.println(String.join(", ", values));
        }
    }
}
