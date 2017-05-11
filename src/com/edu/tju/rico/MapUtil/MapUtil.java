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
 * 若使用HashMap实现，由于HashMap是无序的，所以是不稳定的；
 * 若使用LinkedHashMap实现，由于LinkedHashMap是保留插入顺序的，所以是稳定的。
 * 所谓排序稳定是指，相同两项在排序后仍保持最初的顺序，不会颠倒。
 * 
 * 2. 根据Key对Map进行排序，并将每条Map.Entry按序输出，这种排序是稳定的，和Map的具体实现无关。
 * 因为Key不同于Value，是唯一的。
 * 
 * 3. 使Map保持插入顺序，并将每条Map.Entry按序输出，这时我们应该选用LinkedHashMap来实现Map。
 * 因为LinkedHashMap本身就是保留插入顺序的。
 * 
 * @author rico
 * @created 2017年5月11日 上午9:01:53
 */
public class MapUtil {

	/**
	 * @description 根据Value对Map进行排序，并将每条Map.Entry按序输出
	 * @author rico
	 * @created 2017年5月11日 上午9:14:10
	 * @param map
	 *            待排序的Map
	 * @param valueComparator
	 *            Value的排序规则
	 */
	public static <K, V> void rankMapByValue(Map<K, V> map,
			final Comparator<V> valueComparator) {
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(
				map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return valueComparator.compare(o1.getValue(), o2.getValue());
			}
		});

		for (Map.Entry<K, V> entry : list) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}

	/**
	 * @description 根据Key对Map进行排序，并将每条Map.Entry按序输出
	 * @author rico
	 * @created 2017年5月11日 上午9:14:10
	 * @param map
	 *            待排序的Map
	 * @param valueComparator
	 *            Key的排序规则
	 */
	public static <K, V> void rankMapByKey(Map<K, V> map,
			final Comparator<K> keyComparator) {
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(
				map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return keyComparator.compare(o1.getKey(), o2.getKey());
			}
		});

		for (Map.Entry<K, V> entry : list) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}

	public static void main(String[] args) {

		// 使用HashMap实现
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("D", 1);
		hashMap.put("C", 2);
		hashMap.put("A", 3);
		hashMap.put("B", 2);
		hashMap.put("F", 1);
		hashMap.put("E", 0);

		System.out.println("对HashMap实现的Map进行Value排序并打印：");
		rankMapByValue(hashMap, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});

		System.out.println();

		// 使用LinkedHashMap实现
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("D", 1);
		linkedHashMap.put("C", 2);
		linkedHashMap.put("A", 3);
		linkedHashMap.put("B", 2);
		linkedHashMap.put("F", 1);
		linkedHashMap.put("E", 0);

		System.out.println("对LinkedHashMap实现的Map进行Value排序并打印：");
		rankMapByValue(linkedHashMap, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});

		System.out.println("\n--------我是分割线--------\n");

		System.out.println("对Map进行Key排序并打印：");
		rankMapByKey(hashMap, String.CASE_INSENSITIVE_ORDER); // String的一个排序算子

		System.out.println("\n--------我是分割线--------\n");
		
		System.out.println("HashMap是不保持插入顺序的，是无序的：");
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}

		System.out.println("\n--------我是分割线--------\n");

		System.out.println("LinkedHashMap是保持插入顺序的：");
		for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}
}
