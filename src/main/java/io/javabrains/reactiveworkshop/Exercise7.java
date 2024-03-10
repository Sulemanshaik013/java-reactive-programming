package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

		// Print all values from intNumbersFlux that's greater than 5
		ReactiveSources.intNumbersFlux().filter(value -> value > 5).subscribe(System.out::println);

		// Print 10 times each value from intNumbersFlux that's greater than 5
		ReactiveSources.intNumbersFlux().filter(value -> value > 5).map(value -> value * 10)
				.subscribe(System.out::println);

		// Print 10 times each value from intNumbersFlux for the first 3 numbers emitted
		// that's greater than 5
		ReactiveSources.intNumbersFlux().filter(value -> value > 5).map(value -> value * 10).take(3)
				.subscribe(System.out::println);

		// Print each value from intNumbersFlux that's greater than 20. Print -1 if no
		// elements are found
		ReactiveSources.intNumbersFlux().filter(value -> value > 20).defaultIfEmpty(-1).subscribe(System.out::println);

		// Switch ints from intNumbersFlux to the right user from userFlux
		ReactiveSources.intNumbersFlux()
				.flatMap(value -> ReactiveSources.userFlux().filter(user -> user.getId() == value).take(1))
				.subscribe(System.out::println);

		// Print only distinct numbers from intNumbersFluxWithRepeat
		ReactiveSources.intNumbersFluxWithRepeat().distinct().subscribe(System.out::println);

		// Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
		ReactiveSources.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(System.out::println);

		System.out.println("Press a key to end");
		System.in.read();
	}

}
