package sort;

public class SelectionSort implements SortingAlgorithm {
	@Override
	public int[] sort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[minIndex]) minIndex = j;
			}
			swap(input, i, minIndex);
		}

		return input;
	}
}
