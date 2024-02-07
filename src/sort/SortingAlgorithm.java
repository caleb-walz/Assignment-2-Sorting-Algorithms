package sort;

public interface SortingAlgorithm {

	public int[] sort(int[] input);

	default void swap(int[] input, int i, int j) {
		int temp = input[j];
		input[j] = input[i];
		input[i] = temp;
	}

}
