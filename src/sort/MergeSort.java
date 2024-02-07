package sort;

public class MergeSort implements SortingAlgorithm {

	private int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];

		int index1 = 0, index2 = 0;
		for (int i = 0; i < c.length; i++) {
			if (index1 < a.length && index2 < b.length && a[index1] < b[index2]) {
				c[i] = a[index1];
				index1++;
			} else if (index2 < b.length){
				c[i] = b[index2];
				index2++;
			}
		}

		return c;
	}

	@Override
	public int[] sort(int[] input) {
		if (input.length == 1) return input;

		int[] l1 = new int[input.length / 2];
		for (int i = 0; i < l1.length; i++) {
			l1[i] = input[i];
		}
		int[] l2 = new int[input.length - l1.length];
		for (int i = 0; i < l2.length; i++) {
			l2[i] = input[i + l1.length];
		}

		l1 = sort(l1);
		l2 = sort(l2);
		return merge(l1, l2);
	}
}
