package uz.jamshid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");

        try {
            // reading input from user
            int number = scanner.nextInt();

            // setting up default values according to condition
            boolean isPrime = true;
            boolean isMersennePrime = false;

            for (int i = 2; i < number; i++) {
                // checks if number = 2^i ± 1
                if (number == Math.pow(2, i) + 1 || number == Math.pow(2, i) - 1) {
                    isMersennePrime = true;
                    break;
                }
            }

            for (int j = 2; j < Math.sqrt(number); j++) {
                // after number%i, if remainder is 0, it means it is not prime and isPrime will be false
                if (number % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (number < 0)
                System.out.println("Invalid number");
            else if (number == 0 || number == 1)
                System.out.println(number + " is not a prime");
            else if (isMersennePrime && isPrime) // even though most of this sequence number = 2^i ± 1 are prime, but some of them are not
                System.out.println(number + " is Mersenne prime number");
            else if (isPrime || number == 2)
                System.out.println(number + " is a regular prime number");
            else
                System.out.println(number + " is not a prime number");
        } catch (Exception exception) {
            System.out.println("Invalid number. Please enter number!");
        }

        /* By the way I have read about Mersenne prime numbers and some references saying like 2^n ± 1, n should be prime as well,
        in that case solution will be different */
    }
}
