package searching;

import java.util.Scanner;

import sorting.MergeSort;

public class BinarySeach {

	public static void main(String[] args) {
		int[] numbers = { 38, 27, 43, 3, 9, 82, 10 };
		MergeSort ms = new MergeSort();
		ms.mergeSort(numbers, 0, numbers.length - 1);
		BinarySeach bs = new BinarySeach();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number to search :");
		int n = sc.nextInt();
		sc.close();		
		boolean found = bs.binarySearch(numbers, 0, numbers.length - 1, n);
		System.out.println("Number found :" + found);
	}

	public boolean binarySearch(int[] numbers, int low, int high, int n) {
		int mid = (low + high) / 2;
		int middleElement = numbers[mid];
		if (n == middleElement)
			return true;
		if (low >= high)
			return false;

		if (n <= middleElement) {
			return binarySearch(numbers, low, mid, n);
		} else {
			return binarySearch(numbers, mid + 1, high, n);
		}
	}
}
