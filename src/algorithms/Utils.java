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
public class Utils {
	public static void swap (int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int[] random (int size, int from, int to) {
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(from, to);
		}
		return arr;
	}
	
	public static void print (int [] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}
