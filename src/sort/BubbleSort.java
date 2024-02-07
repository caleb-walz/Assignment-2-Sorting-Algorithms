package sort;

public class BubbleSort implements SortingAlgorithm {
	@Override
	public int[] sort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = 0; j < input.length - 1 - i; j++) {
				if (input[j + 1] < input[j]) swap(input, j, j + 1);
			}
		}

		return input;
	}
}
