package test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import sort.*;

import java.io.*;

public class Performance {

	private static Tester bubble = new Tester(new BubbleSort());
	private static Tester insertion = new Tester(new InsertionSort());
	private static Tester selection = new Tester(new SelectionSort());
	private static Tester shell = new Tester(new ShellSort());
	private static Tester quick = new Tester(new QuickSort());
	private static Tester merge = new Tester(new MergeSort());

	private static void testRandom(PrintStream out) throws IOException {
		out.println("Sorting algorithm: Bubble Sort");
		XYSeries bubbleSeries = new XYSeries("Bubble Sort");
		bubbleSeries.add(100, bubble.test(20, 100, out));
		bubbleSeries.add(500, bubble.test(20, 500, out));
		bubbleSeries.add(1000, bubble.test(20, 1000, out));
		bubbleSeries.add(2000, bubble.test(20, 2000, out));
		bubbleSeries.add(5000, bubble.test(20, 5000, out));
		bubbleSeries.add(10000, bubble.test(20, 10000, out));
		bubbleSeries.add(20000, bubble.test(20, 20000, out));
		bubbleSeries.add(75000, bubble.test(20, 75000, out));
		bubbleSeries.add(150000, bubble.test(20, 150000, out));

		out.println("Sorting algorithm: Insertion Sort");
		XYSeries insertionSeries = new XYSeries("Insertion Sort");
		insertionSeries.add(100, insertion.test(20, 100, out));
		insertionSeries.add(500, insertion.test(20, 500, out));
		insertionSeries.add(1000, insertion.test(20, 1000, out));
		insertionSeries.add(2000, insertion.test(20, 2000, out));
		insertionSeries.add(5000, insertion.test(20, 5000, out));
		insertionSeries.add(10000, insertion.test(20, 10000, out));
		insertionSeries.add(20000, insertion.test(20, 20000, out));
		insertionSeries.add(75000, insertion.test(20, 75000, out));
		insertionSeries.add(150000, insertion.test(20, 150000, out));

		out.println("Sorting algorithm: Selection Sort");
		XYSeries selectionSeries = new XYSeries("Selection Sort");
		selectionSeries.add(100, selection.test(20, 100, out));
		selectionSeries.add(500, selection.test(20, 500, out));
		selectionSeries.add(1000, selection.test(20, 1000, out));
		selectionSeries.add(2000, selection.test(20, 2000, out));
		selectionSeries.add(5000, selection.test(20, 5000, out));
		selectionSeries.add(10000, selection.test(20, 10000, out));
		selectionSeries.add(20000, selection.test(20, 20000, out));
		selectionSeries.add(75000, selection.test(20, 75000, out));
		selectionSeries.add(150000, selection.test(20, 150000, out));

		out.println("Sorting algorithm: Shell Sort");
		XYSeries shellSeries = new XYSeries("Shell Sort");
		shellSeries.add(100, shell.test(20, 100, out));
		shellSeries.add(500, shell.test(20, 500, out));
		shellSeries.add(1000, shell.test(20, 1000, out));
		shellSeries.add(2000, shell.test(20, 2000, out));
		shellSeries.add(5000, shell.test(20, 5000, out));
		shellSeries.add(10000, shell.test(20, 10000, out));
		shellSeries.add(20000, shell.test(20, 20000, out));
		shellSeries.add(75000, shell.test(20, 75000, out));
		shellSeries.add(150000, shell.test(20, 150000, out));

		out.println("Sorting algorithm: Quick Sort");
		XYSeries quickSeries = new XYSeries("Quick Sort");
		quickSeries.add(100, quick.test(20, 100, out));
		quickSeries.add(500, quick.test(20, 500, out));
		quickSeries.add(1000, quick.test(20, 1000, out));
		quickSeries.add(2000, quick.test(20, 2000, out));
		quickSeries.add(5000, quick.test(20, 5000, out));
		quickSeries.add(10000, quick.test(20, 10000, out));
		quickSeries.add(20000, quick.test(20, 20000, out));
		quickSeries.add(75000, quick.test(20, 75000, out));
		quickSeries.add(150000, quick.test(20, 150000, out));

		out.println("Sorting algorithm: Merge Sort");
		XYSeries mergeSeries = new XYSeries("Merge Sort");
		mergeSeries.add(100, merge.test(20, 100, out));
		mergeSeries.add(500, merge.test(20, 500, out));
		mergeSeries.add(1000, merge.test(20, 1000, out));
		mergeSeries.add(2000, merge.test(20, 2000, out));
		mergeSeries.add(5000, merge.test(20, 5000, out));
		mergeSeries.add(10000, merge.test(20, 10000, out));
		mergeSeries.add(20000, merge.test(20, 20000, out));
		mergeSeries.add(75000, merge.test(20, 75000, out));
		mergeSeries.add(150000, merge.test(20, 150000, out));

		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(bubbleSeries);
		data.addSeries(insertionSeries);
		data.addSeries(selectionSeries);
		data.addSeries(shellSeries);
		data.addSeries(quickSeries);
		data.addSeries(mergeSeries);

		JFreeChart chart = ChartFactory.createXYLineChart(
				"Performance of Sorting Random Arrays",
				"Array Size",
				"Average Time (ms)", data);
		File chartImage = new File("random-chart.png");
		ChartUtils.saveChartAsPNG(chartImage, chart, 1920, 1080);
	}

	private static void testKSorted(PrintStream out) throws IOException {
		out.println("Sorting algorithm: Bubble Sort");
		XYSeries bubbleSeries = new XYSeries("Bubble Sort");
		bubbleSeries.add(100, bubble.kTest(20, 100, 10, out));
		bubbleSeries.add(500, bubble.kTest(20, 500, 10, out));
		bubbleSeries.add(1000, bubble.kTest(20, 1000, 10, out));
		bubbleSeries.add(2000, bubble.kTest(20, 2000, 10, out));
		bubbleSeries.add(5000, bubble.kTest(20, 5000, 10, out));
		bubbleSeries.add(10000, bubble.kTest(20, 10000, 10, out));
		bubbleSeries.add(20000, bubble.kTest(20, 20000, 10, out));
		bubbleSeries.add(75000, bubble.kTest(20, 75000, 10, out));
		bubbleSeries.add(150000, bubble.kTest(20, 150000, 10, out));

		out.println("Sorting algorithm: Insertion Sort");
		XYSeries insertionSeries = new XYSeries("Insertion Sort");
		insertionSeries.add(100, insertion.kTest(20, 100, 10, out));
		insertionSeries.add(500, insertion.kTest(20, 500, 10, out));
		insertionSeries.add(1000, insertion.kTest(20, 1000, 10, out));
		insertionSeries.add(2000, insertion.kTest(20, 2000, 10, out));
		insertionSeries.add(5000, insertion.kTest(20, 5000, 10, out));
		insertionSeries.add(10000, insertion.kTest(20, 10000, 10, out));
		insertionSeries.add(20000, insertion.kTest(20, 20000, 10, out));
		insertionSeries.add(75000, insertion.kTest(20, 75000, 10, out));
		insertionSeries.add(150000, insertion.kTest(20, 150000, 10, out));

		out.println("Sorting algorithm: Selection Sort");
		XYSeries selectionSeries = new XYSeries("Selection Sort");
		selectionSeries.add(100, selection.kTest(20, 100, 10, out));
		selectionSeries.add(500, selection.kTest(20, 500, 10, out));
		selectionSeries.add(1000, selection.kTest(20, 1000, 10, out));
		selectionSeries.add(2000, selection.kTest(20, 2000, 10, out));
		selectionSeries.add(5000, selection.kTest(20, 5000, 10, out));
		selectionSeries.add(10000, selection.kTest(20, 10000, 10, out));
		selectionSeries.add(20000, selection.kTest(20, 20000, 10, out));
		selectionSeries.add(75000, selection.kTest(20, 75000, 10, out));
		selectionSeries.add(150000, selection.kTest(20, 150000, 10, out));

		out.println("Sorting algorithm: Shell Sort");
		XYSeries shellSeries = new XYSeries("Shell Sort");
		shellSeries.add(100, shell.kTest(20, 100, 10, out));
		shellSeries.add(500, shell.kTest(20, 500, 10, out));
		shellSeries.add(1000, shell.kTest(20, 1000, 10, out));
		shellSeries.add(2000, shell.kTest(20, 2000, 10, out));
		shellSeries.add(5000, shell.kTest(20, 5000, 10, out));
		shellSeries.add(10000, shell.kTest(20, 10000, 10, out));
		shellSeries.add(20000, shell.kTest(20, 20000, 10, out));
		shellSeries.add(75000, shell.kTest(20, 75000, 10, out));
		shellSeries.add(150000, shell.kTest(20, 150000, 10, out));

		out.println("Sorting algorithm: Quick Sort");
		XYSeries quickSeries = new XYSeries("Quick Sort");
		quickSeries.add(100, quick.kTest(20, 100, 10, out));
		quickSeries.add(500, quick.kTest(20, 500, 10, out));
		quickSeries.add(1000, quick.kTest(20, 1000, 10, out));
		quickSeries.add(2000, quick.kTest(20, 2000, 10, out));
		quickSeries.add(5000, quick.kTest(20, 5000, 10, out));
		quickSeries.add(10000, quick.kTest(20, 10000, 10, out));
		quickSeries.add(20000, quick.kTest(20, 20000, 10, out));
		quickSeries.add(75000, quick.kTest(20, 75000, 10, out));
		quickSeries.add(150000, quick.kTest(20, 150000, 10, out));

		out.println("Sorting algorithm: Merge Sort");
		XYSeries mergeSeries = new XYSeries("Merge Sort");
		mergeSeries.add(100, merge.kTest(20, 100, 10, out));
		mergeSeries.add(500, merge.kTest(20, 500, 10, out));
		mergeSeries.add(1000, merge.kTest(20, 1000, 10, out));
		mergeSeries.add(2000, merge.kTest(20, 2000, 10, out));
		mergeSeries.add(5000, merge.kTest(20, 5000, 10, out));
		mergeSeries.add(10000, merge.kTest(20, 10000, 10, out));
		mergeSeries.add(20000, merge.kTest(20, 20000, 10, out));
		mergeSeries.add(75000, merge.kTest(20, 75000, 10, out));
		mergeSeries.add(150000, merge.kTest(20, 150000, 10, out));

		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(bubbleSeries);
		data.addSeries(insertionSeries);
		data.addSeries(selectionSeries);
		data.addSeries(shellSeries);
		data.addSeries(quickSeries);
		data.addSeries(mergeSeries);

		JFreeChart chart = ChartFactory.createXYLineChart(
				"Performance of Sorting 10-Sorted Arrays",
				"Array Size",
				"Average Time (ms)", data);
		File chartImage = new File("k-sorted-chart.png");
		ChartUtils.saveChartAsPNG(chartImage, chart, 1920, 1080);
	}

	public static void main(String[] args) throws IOException {
		try (PrintStream out = new PrintStream(new FileOutputStream("random-output.txt"))) {
			testRandom(out);
		}
		try (PrintStream out = new PrintStream(new FileOutputStream("k-sorted-output.txt"))) {
			testKSorted(out);
		}
	}

}
