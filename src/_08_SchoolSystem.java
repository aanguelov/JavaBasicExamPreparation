import java.util.*;

public class _08_SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLines = Integer.parseInt(scanner.nextLine());
        //String line = scanner.nextLine();
        Map<String, Map<String, List<Double>>> studentData = new TreeMap<>();
        for (int i = 0; i < inputLines; i++) {
            String line = scanner.nextLine();
            String[] lineArgs = line.split(" ");
            String name = lineArgs[0] + " " + lineArgs[1];
            String subject = lineArgs[2];
            double grade = Double.parseDouble(lineArgs[3]);
            if (!studentData.containsKey(name)) {
                studentData.put(name, new TreeMap<>());
                if (!studentData.get(name).containsKey(subject)) {
                    studentData.get(name).put(subject, new ArrayList<>());
                    studentData.get(name).get(subject).add(grade);
                } else {
                    studentData.get(name).get(subject).add(grade);
                }
            } else {
                if (!studentData.get(name).containsKey(subject)) {
                    studentData.get(name).put(subject, new ArrayList<>());
                    studentData.get(name).get(subject).add(grade);
                } else {
                    studentData.get(name).get(subject).add(grade);
                }
            }
        }

        for (Map.Entry<String, Map<String, List<Double>>> stringMapEntry : studentData.entrySet()) {
            System.out.print(stringMapEntry.getKey() + ": [");
            Map<String, List<Double>> currentStudentSubjects = stringMapEntry.getValue();
            for (Map.Entry<String, List<Double>> stringListEntry : currentStudentSubjects.entrySet()) {
                double totalGrade = 0;
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    totalGrade += stringListEntry.getValue().get(i);
                }
                double average = totalGrade/stringListEntry.getValue().size();
                String averageFormatted = String.format("%.2f", average);
                int endKey = currentStudentSubjects.keySet().toArray().length - 1;
                if (stringListEntry.getKey() != currentStudentSubjects.keySet().toArray()[endKey]) {
                    System.out.print(stringListEntry.getKey() + " - " + averageFormatted + ", ");
                } else {
                    System.out.println(stringListEntry.getKey() + " - " + averageFormatted + "]");
                }
            }
        }
    }
}
