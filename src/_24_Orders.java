import java.util.*;

public class _24_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer>> products = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String customer = inputLine[0];
            int amount = Integer.parseInt(inputLine[1]);
            String product = inputLine[2];

            if (!products.containsKey(product)) {
                products.put(product, new TreeMap<>());
                products.get(product).put(customer, amount);
            } else {
                Integer productAmount = products.get(product).get(customer);
                if (productAmount == null) {
                    productAmount = 0;
                }
                products.get(product).put(customer, productAmount + amount);
            }
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : products.entrySet()) {
            System.out.print(stringMapEntry.getKey() + ": ");
            Map<String, Integer> customers = stringMapEntry.getValue();
            ArrayList<String> temp = new ArrayList<>();
            for (Map.Entry<String, Integer> stringIntegerEntry : customers.entrySet()) {
                temp.add(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue().toString());
            }
            System.out.println(String.join(", ", temp));
        }
    }
}
