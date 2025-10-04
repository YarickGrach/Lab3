package Num1;
import java.util.*;
public class CollectionTasks {
    public static void Task() {
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
        }
}
