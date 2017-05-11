package com.edu.tju.rico.MapUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**        
 * Title: Map的 增强实现   
 * Description: 
 * 
 * 1. 根据Value对Map进行排序，并将每条Map.Entry按序输出，这种排序是不稳定的，其取决于Map的具体实现：
 * 	     若使用HashMap实现，由于HashMap是无序的，所以是不稳定的；
 * 	     若使用LinkedHashMap实现，由于LinkedHashMap是保留插入顺序的，所以是稳定的。
 * 	     所谓排序稳定是指，相同两项在排序后仍保持最初的顺序，不会颠倒。
 * 
 * @author rico       
 * @created 2017年5月11日 上午9:01:53    
 */
public class MapUtil {
	
	/**     
	 * @description 根据Value对Map进行排序，并将每条Map.Entry按序输出
	 * @author rico       
	 * @created 2017年5月11日 上午9:14:10     
	 * @param map 待排序的Map
	 * @param valueComparator Value的排序规则
	 */
	public static <K,V> void rankMapByValue(Map<K, V> map, final Comparator<V> valueComparator) {
		List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(
				map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<K,V>>() {
			@Override
			public int compare(Map.Entry<K,V> o1,
					Map.Entry<K,V> o2) {
				return valueComparator.compare(o1.getValue(), o2.getValue());
			}
		});

		for (Map.Entry<K,V> entry : list) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		
		// 使用HashMap实现
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("A", 1);
		hashMap.put("B", 2);
		hashMap.put("C", 3);
		hashMap.put("D", 2);
		hashMap.put("E", 1);
		hashMap.put("F", 0);
		
		System.out.println("对HashMap实现的Map排序并打印：\n");
		rankMapByValue(hashMap, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
		
		System.out.println("\n--------我是分割线--------\n");
		
		// 使用LinkedHashMap实现
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("A", 1);
		linkedHashMap.put("B", 2);
		linkedHashMap.put("C", 3);
		linkedHashMap.put("D", 2);
		linkedHashMap.put("E", 1);
		linkedHashMap.put("F", 0);
		
		System.out.println("LinkedHashMap实现的Map排序并打印：\n");
		rankMapByValue(linkedHashMap,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
	}
}
