package sort;

public class QuickSort implements SortingAlgorithm {

	private int medianOfThree(int[] input, int start, int end) {
		int first = input[start];
		int center = input[start + (end - start) / 2];
		int last = input[end];
		int[] three = { first, center, last };

		if (last < first) swap(three, 0, 2);
		if (center < first) swap(three, 0, 1);
		if (last < center) swap(three, 1, 2);

		return three[1];
	}

	private int partition(int[] input, int start, int end) {
		int pivot = medianOfThree(input, start, end);

		boolean done = false;
		while (!done) {
			while (input[start] < pivot) start++;
			while (pivot < input[end]) end--;

			if (start >= end) {
				done = true;
			} else {
				swap(input, start, end);
				start++;
				end--;
			}
		}

		return end;
	}

	private void quicksort(int[] input, int start, int end) {
		if (end <= start) {
			return;
		}

		int high = partition(input, start, end);
		quicksort(input, start, high);
		quicksort(input, high + 1, end);
	}

	@Override
	public int[] sort(int[] input) {
		quicksort(input, 0, input.length - 1);
		return input;
	}
}
