package com.study.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String[] args) {
		// filterStream();
		// limitStream();
		// mapStream();
		// matchStream();
		// findStrem();
		// foldStream();
		example();

	}

	public static void foldStream() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		System.out.println(numbers.stream().reduce(0, (a, b) -> a + b));

	}

	public static void findStrem() {

	}

	public static void example() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		List<Transaction> tr2011 = transactions.stream().filter(y -> y.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		tr2011.stream().forEach(System.out::println);

	}

	public static void matchStream() {
		if (menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}

		System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));

		System.out.println(menu.stream().noneMatch(d -> d.getCalories() >= 1000));

	}

	public static void mapStream() {
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		wordLengths.forEach(System.out::println);
	}

	public static void streamSimple() {

		List<String> res = menu.stream().filter(m -> {
			System.out.println("filtering:" + m.getName());
			return m.getCalories() > 300;
		}).map(m -> {
			System.out.println("mapping:" + m.getName());
			return m.getName();
		}).limit(3).collect(Collectors.toList());
		System.out.println(res);
	}

	/**
	 * 过滤流
	 */
	public static void filterStream() {
		List<Integer> arrays = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		arrays.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
		// output 2 2 4
		arrays.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
		// output 2 4

	}

	/**
	 * 截断流
	 */
	public static void limitStream() {
		List<Integer> arrays = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		arrays.stream().limit(3).forEach(System.out::println);

	}
}
