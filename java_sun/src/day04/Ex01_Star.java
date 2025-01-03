package day04;

import java.util.Scanner;

public class Ex01_Star {

	public static void main(String[] args) {
		/*      *  i=1, 공=4, *=1
		 *     **  i=2, 공=3, *=2
		 *    ***  i=3, 공=2, *=3
		 *   ****  i=4, 공=1, *=4
		 *  *****  i=5, 공=0, *=5
		 * */
		for (int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/*      *     i=1, 공=4, *=1
		 *     ***    i=2, 공=3, *=3
		 *    *****   i=3, 공=2, *=5
		 *   *******  i=4, 공=1, *=7
		 *  ********* i=5, 공=0, *=9
		 * */
		for (int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=(2*i-1) ;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/*      *       i=1, 공1=4, *1=1, 공2=1 *2=0
		 *     ** *     i=2, 공1=3, *1=2, 공2=1 *2=1
		 *    *** **    i=3, 공1=2, *1=3, 공2=1 *2=2
		 *   **** ***   i=4, 공1=1, *1=4, 공2=1 *2=3
		 *  ***** ****  i=5, 공1=0, *1=5, 공2=1 *2=4
		 * */
		
		for (int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) { // 공1
				System.out.print(" ");
			}
			for (int k=1; k<=i; k++) { //*1
				System.out.print("*"); 
			}
			System.out.print(" "); //공2
			for (int k=1; k<=i-1; k++) { //*2
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/*      *     i=1, 공=4, *=1
		 *     ***    i=2, 공=3, *=3
		 *    *****   i=3, 공=2, *=5
		 *   *******  i=4, 공=1, *=7
		 *  ********* i=5, 공=0, *=9
		 *   *******  i=4, 공=1, *=7
		 *    *****   i=3, 공=2, *=5
		 *     ***    i=2, 공=3, *=3
		 *      *     i=1, 공=4, *=1
		 * */
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("몇 단계로 하실? : ");
		int num = scan.nextInt();
		
		for (int i=1; i<=num; i++) {
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=(2*i-1) ;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i=num-1; i>=1; i--) {
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=(2*i-1) ;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
