package sort;

public class InsertionSort implements SortingAlgorithm {
	@Override
	public int[] sort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0 && input[j] < input[j - 1]; j--) {
				swap(input, j, j - 1);
			}
		}

		return input;
	}
}
