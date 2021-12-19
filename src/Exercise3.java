import java.util.Scanner;

public class Exercise3
{
    public static void main(String[] args)
    {
        int [] maxPrimeFactorsArr=new int[0];
        int num =getNumFromUser();
        int [] allPrimeFactorsOfNum=factorsArr(maxPrimeFactorsArr,num);
        printArray(allPrimeFactorsOfNum);
    }

    public static int getNumFromUser()
    {
        int num;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number,that you want to check all of his prime factors");
        num=scanner.nextInt();
            while (num<0)
            {
                System.out.println("This number is not positive,try again.");
                num=scanner.nextInt();
            }
            return num;
    }

   public static int[] factorsArr(int[] maxPrimeFactorsArr,int num)
    {
        if (isPrime(num))
        {
            maxPrimeFactorsArr=arrayInitializer(maxPrimeFactorsArr,num);
         return maxPrimeFactorsArr;
        } else
        {
            for (int i=2;i<=num;i++)
            {
                if (num%i==0)
                {
                    if (isPrime(i))
                    {
                        maxPrimeFactorsArr=arrayInitializer(maxPrimeFactorsArr,i);
                        break;
                    }
                }
            }
        }
        if (num!=1)
        {
            if (isEven(num)&&!isPrime(num))
            {
                num=num/2;
            }else if (isOdd(num)&&!isPrime(num))
            {
             for (int i=3;i<num;i=i+2)
             {
                 if (num%i==0)
                 {
                     num=num/i;
                     break;
                 }
             }
            }
            maxPrimeFactorsArr=factorsArr(maxPrimeFactorsArr,num);
        }
            return maxPrimeFactorsArr;
    }

    public static boolean isPrime(int num)
    {
        boolean isPrime=false;
        int dividesWithoutRemainder=0;
        if (isEven(num)&&num!=2)
        {
            isPrime = false;
            return isPrime;
        }
        if (isOdd(num) || num==2)
        {
            for (int i=1;i<=num;i++)
            {
                if (num%i==0)
                {
                    dividesWithoutRemainder++;
                }
                if (dividesWithoutRemainder>2 || dividesWithoutRemainder==1)
                {
                    isPrime = false;
                }
                if (dividesWithoutRemainder==2)
                {
                    isPrime=true;
                }
            }
        }
        return isPrime;
    }

    public static int[] arrayInitializer (int[] arr,int num)
    {
        int[] newArr=new int[arr.length+1];
        for (int i=0;i<newArr.length;i++)
        {
            if (i!=newArr.length-1) {
                newArr[i] = arr[i];
            } else {
                newArr[i]=num;
            }
        }
        return newArr;
    }

    public static boolean isOdd (int num)
    {
        boolean odd=false;

            if (!isEven(num))
            {
               odd=true;
            }
         return odd;
    }

    public static boolean isEven (int num)
    {
        boolean even=false;
            if (num%2==0)
            {
                even=true;
            }
        return even;
        }

    public static void printArray(int [] arr)
    {
        System.out.println("This is all of the prime factors for this number");
        for (int i=0;i<arr.length;i++)
        {

            System.out.print(arr[i]+ ", ");
        }
    }
}