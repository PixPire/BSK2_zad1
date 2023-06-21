package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        String enterkey;
        Scanner scanner = new Scanner(System.in);

        //Pozyskanie seed'a - początkowego stanu, np 10001
        System.out.println("Podaj seed (początkowy stan rejestru): ");
        String seed = scanner.nextLine();


        //Pozyskanie wielomianu - które bity do XOR'a, np 10001
        System.out.println("Podaj wielomian: ");
        String wielomian = scanner.nextLine();




        int[] wielomianArray = Arrays.stream(wielomian.split("")).mapToInt(Integer::valueOf).toArray();
        int[] seedArray = Arrays.stream(seed.split("")).mapToInt(Integer::valueOf).toArray();

        List<Integer> XORPositions = new ArrayList<>();

        for (int i = 0; i < wielomianArray.length; i++) {
            if (wielomianArray[i] == 1) {
                XORPositions.add(i);
            }
        }

        do {
            System.out.println((seedArray[seedArray.length - 1]));
            int newBit = calculateXOR(XORPositions, seedArray);
            for (int j = seedArray.length - 1; j > 0; j--) {
                seedArray[j] = seedArray[j - 1];
            }
            seedArray[0] = newBit;
            enterkey = scanner.nextLine();
        } while (enterkey.equals(""));
        
    }

    public static int XOR(int a, int b) {
        return a^b;
    }

    public static int calculateXOR(List<Integer> bitList, int[] seed) {
        int resultBit;
        resultBit = seed[bitList.get(0)];
        for (int i = 1; i < bitList.size(); i++) {
            resultBit = XOR(resultBit, seed[bitList.get(i)]);
        }
        return resultBit;
    }

}
