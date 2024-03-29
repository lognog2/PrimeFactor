import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        //initialize scanner
        Scanner in = new Scanner(System.in);

        //ask for int
        System.out.print("Enter any int: ");
        int num = in.nextInt();

        //numbers smaller than 2 do not have a prime factorization
        if (num < 2)
        {
            System.out.print(num + " does not have a prime factorization.");
        }
        else
        {
            //array to store primes, the longest possible
            //factorization length is the number's square root
            int[] primes = new int[(int)Math.sqrt(num)];

            //while loop iterator
            int n = 0;

            //starting with 2, checks each number for if it's prime
            //and is divisible by the given number. if it is,
            //adds prime to primes array and given number is divided
            //by it. process repeats until given number is 1
            while (num >= 2)
            {
                for (int i = 2; i <= num; i++)
                {
                    if (num % i == 0 && isPrime(i))
                    {
                        num /= i;
                        primes[n] = i;
                        //breakdown visualization
                        if (!isPrime(num))
                        {
                            printArray(primes);
                            System.out.println(num);
                        }
                        break;
                    }
                } //end for loop
                n++;
            } //end while loop
            printArray(primes);
        } //end else bracket
    } // end main

    public static boolean isPrime(int x)
    {
        for (int i = 2; i <= x/2; i++)
        {
            if (x % i == 0) return false;
        }
        return true;
    } //end isPrime

    public static void printArray(int[] arr)
    {
        for (int j : arr)
            if (j != 0) System.out.print(j + " ");
    }

} // end class
