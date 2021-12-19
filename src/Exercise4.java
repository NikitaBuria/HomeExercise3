import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
      System.out.println("What is the desired length of the array?");
        int arrLength=scanner.nextInt();
        int [] arr=new int [arrLength];
        System.out.println("What does the indexes contain?");
        for (int i=0;i<arrLength;i++)
        {
            arr[i]=scanner.nextInt();
        }

        int[] descendingOrderArr={8,6,4,2,1};
        reArrangeArrayToAscendingOrder(arr);
        System.out.println(checkIfArrIsWhole(arr));
        System.out.println(isDescendingArrWhole(descendingOrderArr));
    }

    public static boolean isDescendingArrWhole (int [] arr)
    {
        boolean isWhole =false;
        for (int i=0;i<arr.length;i++)
        {
            for (int j=i+1;j<arr.length; j++)
            {
                if (arr[i]==arr[j]+1)
                {
                    isWhole=true;
                    break;
                }else
                {
                    isWhole = false;
                    return isWhole;
                }
            }
        }
        return isWhole;
    }

    public static boolean checkIfArrIsWhole(int[] arr)
    {
        boolean isWhole=false;
        for (int i = 0; i < arr.length; i++)
        {
                if (isThereACopy(arr,arr[i])&&i!=arr.length-1)
                {
                    isWhole=false;
                    break;
                }
                if (isThereAFollowingNum(arr,arr[i])&&i!=arr.length-1)
                {
                    isWhole=true;
                }else if (i!=arr.length-1)
                {
                    isWhole=false;
                    break;
                }


        }
        return isWhole;
    }


    public static void reArrangeArrayToAscendingOrder(int[] arr)
    {
        int tempIndex;
        for (int i=0;i<arr.length;i++)
        {
            for (int j=i+1;j<arr.length;j++)
            {
                if (arr[i]>arr[j])
                {
                    tempIndex=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tempIndex;
                }
            }
        }
    }

    public static boolean isThereAFollowingNum(int[] arr,int num)
    {
        boolean followingNum=false;
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]==num+1)
            {
                followingNum=true;
                break;
            }else followingNum=false;
        }
        return followingNum;

    }

    public static boolean isThereACopy(int[] arr, int num)
    {
        boolean isCopy=false;
        for (int i=0;i<arr.length;i++)
        {
            if(arr[i]==num)
            {
                isCopy=true;
            } else isCopy=false;
        }
        return isCopy;
    }
}
