package sorting;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] numbers = { 38, 27, 43, 3, 9, 82, 10 };
		System.out.println("-----------Input Array---------------");
		printArray(numbers);
		ms.mergeSort(numbers, 0, numbers.length - 1);
		System.out.println("-----------Sorted Array--------------");
		printArray(numbers);
	}

	public static void printArray(int[] numbers) {
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void mergeSort(int[] numbers, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(numbers, low, mid);
		mergeSort(numbers, mid + 1, high);
		merge(numbers, low, mid, high);
	}

	public void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[(high - low) + 1];
		int counter = 0;
		int i = low, j = mid + 1;

		while (true) {
			if (i > mid || j > high)
				break;
			if (arr[i] <= arr[j]) {
				temp[counter++] = arr[i++];
			} else {
				temp[counter++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[counter++] = arr[i++];
		}

		while (j <= high) {
			temp[counter++] = arr[j++];
		}
		System.arraycopy(temp, 0, arr, low, temp.length);
	}
}
