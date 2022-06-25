package com.mmustafa;

import java.util.Scanner;

public class Alphabet {
	static String alphabetNew = "defgauğıvijçklümnocöprsyhbştz";
	
	public static void main(String[] args) {
		Alphabet alphabet = new Alphabet();
		try {
			alphabet.getData();
		} catch (Exception e) {
			System.err.println("Lutfen Sayi Giriniz :/");
			main(args);
		}
		
	}
	
	public void getData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lutfen Girilecek Eleman Sayisini belirtiniz : ");
		int arraySize = Math.abs(scanner.nextInt());
		String[] array = new String[arraySize];
		for (int i = 0; i < array.length; i++) {
			System.out.println((i + 1) + ". Kelimeyi Giriniz :");
			array[i] = scanner.next().toLowerCase();
		}
		System.out.println("****************************\n");
		System.out.print("Girilen Kelimeler: " + "[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println(array[array.length - 1] + "]\n");
		if (sortControl(array)) {
			System.out.println("Girilen Kelimeler Sirasi  {" + alphabetNew + "}  Siralamasi Gore Dogrudur");
		} else {
			System.out.println("Girilen Kelimeler Sirasi  {" + alphabetNew + "}  Siralamasi Gore Yanlistir");
		}
		scanner.close();
	}
	
	public boolean sortControl(String[] array) {
		
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].toString() == array[i + 1].toString()) {
				continue;
			} else if (stringControl(array[i], array[i + 1]) == 2) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}
	
	public int stringControl(String first, String second) {
		
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) == second.charAt(i)) {
				try {
					second.charAt(i + 1);
				} catch (Exception e) {
					return 2;
				}
				continue;
			} else {
				for (int j = 0; j < alphabetNew.length(); j++) {
					if (alphabetNew.charAt(j) == first.charAt(i)) {
						return 1;
					} else if (alphabetNew.charAt(j) == second.charAt(i)) {
						return 2;
					} else {
						continue;
					}
				}
			}
		}
		return 0;
	}
}
