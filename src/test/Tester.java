package test;

import sort.SortingAlgorithm;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

public class Tester {

	private SortingAlgorithm sorter;
	private Random rand;

	// A constructor for the Tester that takes as parameter the sorting algorithm to be tested
	public Tester(SortingAlgorithm sa) {
		sorter = sa;
		rand = new Random();
	}

	// Should create an array of integers of the given size. Fill it with random
	// numbers and run the sorting algorithm’s sorty method. It should record and
	// return the time it takes to sort the array.
	public double singleTest(int size) {
		int[] input = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = rand.nextInt();
		}

		long start = System.nanoTime();
		int[] sorted = sorter.sort(input);
		long end = System.nanoTime();

		return (end - start) / 1000000D;
	}

	// Should run the singleTest method as many times as the number of iterations
	// provided and print to the console the average time the algorithm takes
	// to sort an array of the given size.
	public double test(int iterations, int size, PrintStream out) {
		double avgTime = 0;
		for (int i = 0; i < iterations; i++) {
			avgTime += singleTest(size);
		}
		avgTime /= iterations;
		out.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
		return avgTime;
	}

	private int[] generateKSorted(int[] input, int k) {
		for (int i = k; i < input.length; i++) {
			int temp = input[i];
			int j;
			for (j = i; j >= k && temp < input[j - k]; j -= k) {
				input[j] = input[j - k];
			}
			input[j] = temp;
		}

		return input;
	}

	public double singleKTest(int size, int k) {
		int[] input = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = rand.nextInt();
		}
		generateKSorted(input, k);

		long start = System.nanoTime();
		int[] sorted = sorter.sort(input);
		long end = System.nanoTime();

		return (end - start) / 1000000D;
	}

	public double kTest(int iterations, int size, int k, PrintStream out) {
		double avgTime = 0;
		for (int i = 0; i < iterations; i++) {
			avgTime += singleKTest(size, k);
		}
		avgTime /= iterations;
		out.println("Sorted " + size + " elements in " + avgTime + " ms (avg)");
		return avgTime;
	}

}
