import java.util.*;
import Num2.*;
import Num3.*;
import static Num5.MapUtil.swapKeysAndValues;

public class Main {
    public static void main(String[] args) {
        System.out.println("Num1:\n");
        // 1. Создаем массив из N случайных чисел от 0 до 100
        int N = 15;
        int[] array = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101); // 0-100
        }
        System.out.println("1. Исходный массив: " + Arrays.toString(array));

        // 2. На основе массива создаем список List
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("2. Список из массива: " + list);

        // 3. Отсортируем список по возрастанию
        Collections.sort(list);
        System.out.println("3. Отсортированный по возрастанию: " + list);

        // 4. Отсортируем список в обратном порядке
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("4. Отсортированный в обратном порядке: " + list);

        // 5. Перемешаем список
        Collections.shuffle(list);
        System.out.println("5. Перемешанный список: " + list);

        // 6. Выполним циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("6. После циклического сдвига на 1: " + list);

        // 7. Оставим в списке только уникальные элементы
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("7. Только уникальные элементы: " + uniqueList);

        // 8. Оставим в списке только дублирующиеся элементы
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        System.out.println("8. Дублирующиеся элементы: " + duplicates);

        // 9. Из списка получим массив
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("9. Полученный массив: " + Arrays.toString(newArray));

        // 10. Подсчитаем количество вхождений каждого числа
        System.out.println("10. Количество вхождений каждого числа:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }


        System.out.println("Num2:\n");
        PrimesGenerator generator = new PrimesGenerator(N);

        // Вывод в прямом порядке
        System.out.println("Первые " + N + " простых чисел в прямом порядке:");
        List<Integer> primes = new ArrayList<>();
        while (generator.hasNext()) {
            primes.add(generator.next());
        }
        System.out.println(primes);

        // Вывод в обратном порядке
        System.out.println("Первые " + N + " простых чисел в обратном порядке:");
        List<Integer> reversed = new ArrayList<>(primes);
        Collections.reverse(reversed);
        System.out.println(reversed);


        System.out.println("Num3:\n");
        List<Human> humans = Arrays.asList(
                new Human("Иван", "Петров", 25),
                new Human("Мария", "Иванова", 30),
                new Human("Алексей", "Сидоров", 22),
                new Human("Ольга", "Петрова", 25),
                new Human("Иван", "Петров", 25) // дубликат
        );

        System.out.println("Исходный список: " + humans);

        // HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("\nHashSet: " + hashSet);

        // LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet (использует Comparable)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet (с Comparable): " + treeSet);

        // TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("TreeSet (по фамилии): " + treeSetByLastName);

        // TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("TreeSet (по возрасту): " + treeSetByAge);


        System.out.println("Num4:\n");
        String text = "The quick brown fox jumps over the lazy dog. " +
                "The quick brown fox is very quick and the lazy dog is very lazy.";

        // Выделяем все различные слова (игнорируя регистр)
        String[] words = text.toLowerCase().split("[^a-zA-Z]+");

        // Подсчитываем частоту встречаемости
        Map<String, Integer> frequencyMap2 = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap2.put(word, frequencyMap2.getOrDefault(word, 0) + 1);
            }
        }

        // Выводим результат
        System.out.println("Различные слова и их частота:");
        for (Map.Entry<String, Integer> entry : frequencyMap2.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }

        // Альтернативный вывод с сортировкой по частоте
        System.out.println("\nСлова, отсортированные по частоте:");
        frequencyMap2.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println("'" + entry.getKey() + "': " + entry.getValue()));


        System.out.println("Num5:\n");
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "first");
        testMap.put(2, "first");
        testMap.put(3, "second");

        System.out.println("Исходная Map: " + testMap);

        Map<String, List<Integer>> result = swapKeysAndValues(testMap);
        System.out.println("После инвертирования: " + result);

        // Детальный вывод
        System.out.println("\nДетализация:");
        for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }
}