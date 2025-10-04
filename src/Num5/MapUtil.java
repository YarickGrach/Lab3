package Num5;
import java.util.*;

public class MapUtil {
    public static <K, V> Map<V, List<K>> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, List<K>> swappedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Если значение уже есть в новой Map, добавляем ключ в список
            if (swappedMap.containsKey(value)) {
                swappedMap.get(value).add(key);
            } else {
                // Если значения еще нет, создаем новый список с одним ключом
                List<K> keyList = new ArrayList<>();
                keyList.add(key);
                swappedMap.put(value, keyList);
            }
        }

        return swappedMap;
    }
}
