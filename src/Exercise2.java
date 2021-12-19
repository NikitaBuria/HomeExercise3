import java.util.Enumeration;
import java.util.Scanner;

public class Exercise2
{

public static void main (String[] args)
{
    int[] arr1 = {222, 5, 33, 60, 156, 6};
    int[] arr2 = {12, 51, 42, 60, 50};
    int[] arrOfIndexes=kinshipLevel(arr1, arr2);
    printArr(arrOfIndexes);
}
public static void printArr(int [] arr)
{
    System.out.println("This is all the Indexes in the first array that  have the highest kinship level to the second arr");
    for (int i = 0; i < arr.length; i++)
    {
            if (i == 0) {
                System.out.print(arr[i]+", ");
            } else if (arr[i] != 0)
            {
                System.out.print(arr[i]+", ");
            }
    }
}

    public static int[] kinshipLevel(int [] arr1,int [] arr2)
    {
        int [] valuesArr=new int[0];
        int kinshipLevel=0;
        int sumOfDigitsInArr1;
        int sumOfDigitsInArr2;
        for (int i=0;i<arr1.length;i++)
        {
            kinshipLevel=0;
                sumOfDigitsInArr1 = getNumValue(arr1[i]);
                    for (int j = 0; j < arr2.length; j++)
                    {
                        sumOfDigitsInArr2 = getNumValue(arr2[j]);
                        if (sumOfDigitsInArr1 == sumOfDigitsInArr2)
                        {
                            kinshipLevel++;
                        }
                    }
                    valuesArr=arrInit(valuesArr,kinshipLevel);
        }
       int highestKinshipLevel=getHighestKinshipLevel(valuesArr);
        int[] arrOfIndexes=checkAllIndexWithTheSameKinship(valuesArr,highestKinshipLevel);


        return arrOfIndexes;
    }

    public static int[] checkAllIndexWithTheSameKinship (int[] arr,int num)
    {
        int[] newArr=new int[arr.length];

        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]==num)
            {
                newArr[i]=i;
            }
        }
        return newArr;
    }


    public static int getHighestKinshipLevel(int[] arr)
    {
        int num=0;
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr.length;j++)
            {
                if (arr[i]>arr[j])
                {
                    num=arr[i];
                }
            }
        }
        return num;
    }

    public static int[] arrInit(int[] arr,int num)
    {
        int [] newArr=new int[arr.length+1];
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

    public static int getArrLength(int num)
    {
        int testNumForArrOfDigitsLength = num;
        int arrLength= 0;
        while (testNumForArrOfDigitsLength != 0)
        {
            arrLength++;
            testNumForArrOfDigitsLength = testNumForArrOfDigitsLength / 10;
        }
        return arrLength;
    }

    public static int getNumValue(int num)
    {
        int sumOfNumbers=0;
        int[] digitsArr = new int[getArrLength(num)];
        for (int i = 0; i <= digitsArr.length; i++)
        {
            if (num!=0)
            {
                digitsArr[i] = num % 10;
                num = num / 10;
            }
        }
        for (int i=0;i<digitsArr.length;i++)
        {
            sumOfNumbers=sumOfNumbers+digitsArr[i];
        }
        return sumOfNumbers;
    }
}
