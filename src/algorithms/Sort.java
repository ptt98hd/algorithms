package algorithms;

import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author thanh
 */
public class Sort {

//=	MAIN FUNCTION
//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public static void main(String[] args) {
		int[] arr = random(10, 0, 10);

		System.out.println("Before: ");
		print(arr);

//		selectionSort(arr);
//		bubbleSort(arr);
//		insertionSort(arr);
//		mergeSort(arr);
		quickSort(arr);

		System.out.println("After: ");
		Utils.print(arr);
	}

	public static int[] random(int size, int from, int to) {
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(from, to);
		}
		return arr;
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

//=	SELECTION SORT
//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			swap(arr, i, minIdx);
		}
	}

//=	BUBBLE SORT
//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			boolean swaped = false;

			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j + 1, j);
					swaped = true;
				}
			}

			if (!swaped) {
				break;
			}
		}
	}

	// HÀM ĐỔI CHỖ 2 PHẦN TỬ CỦA MẢNG
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

//=	INSERTION SORT
//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && key <= arr[j]) {
				arr[j + 1] = arr[j--];
			}

			arr[j + 1] = key;
		}
	}

//=	MERGE SORT
//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
//	public static void mergeSort(int[] arr) {
//		int left = 0;
//		int right = arr.length - 1;
//
//		split(arr, left, right);
//	}
//
//	private static void split(int[] arr, int left, int right) {
//		if (left >= right) {
//			return;
//		}
//
//		int middle = (left + right) / 2;
//
//		split(arr, left, middle);
//		split(arr, middle + 1, right);
//
//		merge(arr, left, middle, right);
//	}
//
//	private static void merge(int[] arr, int left, int middle, int right) {
//		int leftLength = middle - left + 1;
//		int rightLength = right - middle;
//
//		int[] leftArr = new int[leftLength];
//		int[] rightArr = new int[rightLength];
//
//		for (int i = 0; i < leftLength; i++) {
//			leftArr[i] = arr[left + i];
//		}
//		for (int i = 0; i < rightLength; i++) {
//			rightArr[i] = arr[middle + 1 + i];
//		}
//
//		int i = 0, j = 0;
//		int k = left;
//
//		while (i < leftLength && j < rightLength) {
//			if (leftArr[i] <= rightArr[j]) {
//				arr[k++] = leftArr[i++];
//			} else {
//				arr[k++] = rightArr[j++];
//			}
//		}
//
//		while (i < leftLength) {
//			arr[k++] = leftArr[i++];
//		}
//		while (j < rightLength) {
//			arr[k++] = rightArr[j++];
//		}
//	}
	public static void mergeSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		mergeSort(arr, left, right);
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int middle = (left + right) / 2;

		mergeSort(arr, left, middle);
		mergeSort(arr, middle + 1, right);

		merge(arr, left, middle, right);
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		int[] temp = new int[right - left + 1];

		int i = left, j = middle + 1;
		int k = 0;

		while (i <= middle && j <= right) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= middle) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (int l = 0; l < k; l++) {
			arr[left + l] = temp[l];
		}
	}

//=	QUICK SORT
//= == == == == == == == == == == == == == == == == == == == == == == == == == == == == ==
	public static void quickSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		quickSort(arr, left, right);
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (arr == null || arr.length == 0) {
			return;
		}
		if (left >= right) {
			return;
		}

		int middle = (left + right) / 2;
		int pivotIdx = getPivotIdx(arr, left, middle, right);
		int pivot = arr[pivotIdx];

		swap(arr, pivotIdx, right);

		int i = left, j = right - 1;

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (j >= 0 && arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(arr, i++, j--);
			}
		}

		swap(arr, i++, right);

		quickSort(arr, left, j);
		quickSort(arr, i, right);
	}

	private static int getPivotIdx(int[] arr, int left, int middle, int right) {
		int max = left, min = left;

		if (arr[middle] > arr[max]) {
			max = middle;
		} else if (arr[middle] < arr[min]) {
			min = middle;
		}

		if (arr[right] > arr[max]) {
			max = right;
		} else if (arr[right] < arr[min]) {
			min = right;
		}

		return left + middle + right - max - min;
	}
}
