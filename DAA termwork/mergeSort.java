import java.util.Scanner;

public class mergeSort {
	public static int[] insertArray() {
		Scanner s = new Scanner(System.in);
		System.out.println("enter size of array: ");
		int n = s.nextInt();
		System.out.println("enter the element in array: ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		return arr;
	}
	
	public static void mergSort(int []arr) {
		if(arr.length <= 1) {
			return;
		}
		int mid = arr.length/2;
		int part1[] = new int[mid];
		int part2[] = new int[arr.length-mid];
		for(int i =0; i<mid;i++) {
			part1[i] = arr[i];
		}
		int k =0;
		for(int i = mid;i<arr.length; i++) {
			part2[k]  = arr[i];
			k++;
		}
		
		mergSort(part1);
		mergSort(part2);
		merge(part1, part2, arr);
		
	}
	
	public static void merge(int []input1,int []input2,int arr[]) {
		int n = input1.length;
		int m = input2.length;		
		int i=0,k=0,j=0;
		while(i < n && j < m) {
			if(input1[i] > input2[j]) {
				arr[k] = input2[j];
				j++;
				k++;
			}
			else {
				arr[k] = input1[i];
				i++;
				k++;
			}
		}
		while(i < n) {
			arr[k] = input1[i];
			k++;
			i++;
		}
		while(j< m) {
			arr[k] = input2[j];
			k++;
			j++;
		}
		
	}

	public static void main(String[] args) {
		
		int arr[] = insertArray();
		mergSort(arr);
		for(int h =0; h < arr.length;h++) {
			System.out.print(arr[h]+" ");
		}
	}

}
