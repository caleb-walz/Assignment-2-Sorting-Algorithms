package sort;

public class ShellSort implements SortingAlgorithm {

	// using Ciura's gap values: https://en.wikipedia.org/wiki/Shellsort#Gap_sequences
	// I extended the sequence by a few using the formula h_k = 2.25h_(k-1)
	private final int[] gapValues = { 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 8858, 19930, 44842 };

	@Override
	public int[] sort(int[] input) {
		for (int g = gapValues.length - 1; g >= 0; g--) {
			// skip gap values that are larger than the input length / 2
			if (gapValues[g] > input.length / 2) continue;

			int gap = gapValues[g];
			for (int i = gap; i < input.length; i++) {
				int temp = input[i];
				int j;
				for (j = i; j >= gap && temp < input[j - gap]; j -= gap) {
					input[j] = input[j - gap];
				}
				input[j] = temp;
			}
		}

		return input;
	}
}
