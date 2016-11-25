package Utils;

import java.util.*;

public class MapUtils {

    private static LinkedHashMap<String, Integer> sortMap(Map<String, Integer> map){
        List<String> mapKeys = new ArrayList<>(map.keySet());
        List<Integer> mapValues = new ArrayList<>(map.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Integer value : mapValues) {
            Iterator<String> key = mapKeys.iterator();
            while (key.hasNext()) {
                String keyStr = key.next();
                if (Objects.equals(map.get(keyStr), value)) {
                    key.remove();
                    sortedMap.put(keyStr, value);
                    break;
                }
            }
        }
        return sortedMap;
    }

    public static int getMaxValueFromMap(Map<String, Integer> map){
        int maxValue = 0;
        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if(max == null || entry.getValue().compareTo(max.getValue()) > 0)
                max = entry;
        }
        if(max != null)
            maxValue = max.getValue();

        return maxValue;
    }

    public static HashMap<String, Integer> getMaxValueOccurences(Map<String, Integer> map, int maxValue){
        for(String o : map.keySet()){
            if(map.get(o) == maxValue)
                map.put(o, map.get(o));
        }
        return MapUtils.sortMap(map);
    }
}
