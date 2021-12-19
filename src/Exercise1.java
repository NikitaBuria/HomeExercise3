

public class Exercise1
{
    public static void main(String[] args)
    {
        int [] arrWithNoChangingNumbers = {22,11,151,122,1022}; //arr with no changing nums
        int [] arrWithChangingNumbers = {21,12,22,156,123,1022,6}; // arr with changing nums
        System.out.println(checkSmallestChangingNum(arrWithChangingNumbers));
        System.out.println(checkSmallestChangingNum(arrWithNoChangingNumbers));
    }
    public static boolean isChangingNum(int num)
    {
        boolean isChangingNum = false;
        if (num > 0)
        {
            int testNumForArrOfDigitsLength = num;
            int LengthOfTheDigitsArray = 0;
            while (testNumForArrOfDigitsLength != 0)
            {
                LengthOfTheDigitsArray++;
                testNumForArrOfDigitsLength = testNumForArrOfDigitsLength / 10;
            }
            int[] digitsArr = new int[LengthOfTheDigitsArray];
            for (int i = 0; i <= digitsArr.length; i++)
            {
                if (num != 0)
                {
                    digitsArr[i] = num % 10;
                    num = num / 10;
                }
            }
            for (int i=0;i<digitsArr.length;i++)
            {
                boolean isEven=false;
                boolean isOdd=false;
                if (digitsArr[i]%2==0)
                {
                    isEven=true;
                } else isOdd=true;

                if (i+1!=digitsArr.length)
                {
                    if (isEven && digitsArr[i+1]%2==0)
                    {
                        return isChangingNum=false;
                    } else isChangingNum=true;
                    if (isOdd && digitsArr[i+1]%2==1)
                    {
                        return isChangingNum=false;
                    } else isChangingNum=true;
                } else  isChangingNum=true;
            }
        } return isChangingNum;
    }
    public static int checkSmallestChangingNum(int[] arrOfNumbers)
    {
        int counterForChangingNumbers=0;
        int numIfThereIsNoChangingNumbers=-1;
        int indexOfSmallestChangingNum=0;
        for (int i=0;i<arrOfNumbers.length;i++)
        {
            if ( isChangingNum(arrOfNumbers[i]))
                counterForChangingNumbers++;
            {
                for (int j=i+1;j < arrOfNumbers.length; j++)
                {
                    if ((isChangingNum(arrOfNumbers[j]) && arrOfNumbers[j] < arrOfNumbers[i]))
                    {
                        indexOfSmallestChangingNum=j;
                        break;
                    }
                }
            }
        }
        if (counterForChangingNumbers==0)
        {
            return numIfThereIsNoChangingNumbers=-1;
        } else return indexOfSmallestChangingNum;
    }
}

