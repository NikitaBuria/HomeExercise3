import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {
        String quadraticEquation = getValuesFromUser();
        if (checkIfEquationFitsTheRules(quadraticEquation))
        {
            calcEquation(quadraticEquation);
        }
    }

    public static String getValuesFromUser() {
        Scanner scanner = new Scanner(System.in);
        String quadraticEquation;
        System.out.println("Enter your quadratic equation");
        quadraticEquation = scanner.nextLine();
        return quadraticEquation;
    }

   public static void calcEquation(String quadraticEquation)
    {
        int zero=0;
        char[] charsArrayOfEquation =sortInToCharArray(quadraticEquation);
        int[] indexOfX=getIndexOfX(charsArrayOfEquation);
        char[] newChar=new char[quadraticEquation.length()];
       int a=convertCharArrayInToInt(newChar=getCharArr(0,indexOfX[0],charsArrayOfEquation));
       int b=convertCharArrayInToInt(newChar=getCharArr(indexOfX[0]+3,indexOfX[1],charsArrayOfEquation));
       int c=convertCharArrayInToInt(newChar=getCharArr(indexOfX[1]+1,getEqualMarkIndex(charsArrayOfEquation),charsArrayOfEquation));


    int denominator = (2 * a);
    int delta = (b * b - 4 * a * c);
    double Solution1 =  ((-1*b) - (Math.sqrt(delta)))/ (denominator);
    double Solution2 =  ((-1*b) + (Math.sqrt(delta))) / (denominator);

        if (denominator != zero && delta >= zero && Solution1 == Solution2) {
        System.out.println(" There is only one solution X,1 = " + Solution1);
    } else if (denominator != zero && delta >= zero && Solution1!=Solution2) {
        System.out.println(" There are two solutions for this X,1 = " + Solution1 + " And X,2 = " + Solution2);
    } else {
        System.out.println( " Only the gods knows the answer for this ");
    }
}
public static int convertCharArrayInToInt (char [] arr)
{
    int parameter;
    int i=0;
    char minus='-';
    char plus='+';
    char[] charArrayToConvertToIntArray =arr;
    int [] arrayOfIntsToConvertToInt=new int[charArrayToConvertToIntArray.length];
    if (arr[0]==minus||arr[0]==plus)
    {
        i++;
    }
    for (; i < arrayOfIntsToConvertToInt.length; i++)
    {
        arrayOfIntsToConvertToInt[i]=charArrayToConvertToIntArray[i]-'0';
    }
    int numberConverted = 0;
    for (int number : arrayOfIntsToConvertToInt )
    {
        numberConverted = 10*numberConverted + number;
    }

    if (arr[0]=='-')
    {
        parameter=numberConverted*-1;
    }
    else if (arr[0]=='+')
    {
        parameter=numberConverted;
    } else
    {
        parameter=numberConverted;
    }
    return parameter;
}
public static char[] sortInToCharArray(String equation)
{
    char[] charsArrayOfEquation = new char[equation.length()];
    for (int i=0;i<charsArrayOfEquation.length;i++)
    {
        charsArrayOfEquation[i]=equation.charAt(i);
    }
    return charsArrayOfEquation;
}


    public static boolean checkIfEquationFitsTheRules(String equation) // -1112x^2+133x+212=0 11x^23+41x+21=0
    {
        char[] charsArrayOfEquation =sortInToCharArray(equation);
        char[] formats = {'-', 'x', '^', '2', '+', '=','0'};
        boolean isOk = false;
        boolean minusAtStart = false;
        int[] indexOfX=getIndexOfX(charsArrayOfEquation);
       char[] newChar=getCharArr(0,indexOfX[0],charsArrayOfEquation);
      if (isNumber(newChar)) {
          newChar = getCharArr(indexOfX[0] + 1, indexOfX[0] + 4, charsArrayOfEquation);
         if  (isInFormat(newChar))
         {
             newChar=getCharArr(indexOfX[0]+3,indexOfX[1],charsArrayOfEquation);
             if (isNumber(newChar))
             {
                     newChar=getCharArr(indexOfX[1]+1,getEqualMarkIndex(charsArrayOfEquation),charsArrayOfEquation);
                     if (isNumber(newChar))
                     {
                         if (charsArrayOfEquation[charsArrayOfEquation.length-2]==formats[formats.length-2]&&charsArrayOfEquation[charsArrayOfEquation.length-1]==formats[formats.length-1])
                         {
                             isOk=true;
                         }else
                         {
                             System.out.println("the end of your equation does not equal to zero or you didn`t input an equal mark before the zero");
                             isOk=false;
                             return isOk;
                         }
                     }else
                     {
                         System.out.println("your c parameter is invalid");
                         isOk=false;
                         return isOk;
                     }

             }else
             {
                 System.out.println("your b parameter is invalid");
                 isOk=false;
                 return isOk;
             }
         }else
         {
             System.out.println("Your X^2 is not valid");
             isOk=false;
             return isOk;
         }
      }else
      {
          System.out.println("your a parameter is invalid ");
          isOk=false;
          return isOk;
      }
      return isOk;
    }

    public static int getEqualMarkIndex (char[] arr)
    {
        int equalMarkIndex=0;
        char equalMark='=';
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == equalMark)
            {
             equalMarkIndex=i;
             break;
            }
        }
        return equalMarkIndex;
    }
    
    public static boolean isInFormat(char[] arr) {
        boolean isInFormat=false;
        char[] formats = {'-', 'x', '^', '2', '+', '='};
        if (arr.length == 3)
        {
            if ((arr[0]==formats[2]&&arr[1]==formats[3])&&(arr[2]==formats[4]||arr[2]==formats[0]))
            {
                isInFormat=true;
            }
        }
        return isInFormat;
    }

    public static char[] getCharArr(int start,int stop,char[] arr)
    {
        char[] testArr=new char[stop-start];
        for (int i=start;i<stop;i++)
        {
            for (int j=0;j<testArr.length;j++)
            {
                testArr[j]=arr[i];
                i++;
            }
        }
        return testArr;
    }

    public static int[] getIndexOfX (char[] charsArrayOfEquation )
    {
        int[] arrOfXIndex=new int[2];

        char charX='x';
        int j=0;

            for (int i = 0; i < charsArrayOfEquation.length; i++)
            {
                if (j==2)
                {
                    break;
                }

                    if (charsArrayOfEquation[i] == charX) {
                        arrOfXIndex[j] = i;
                        j++;
                    }
            }
        return arrOfXIndex;
    }

    public static boolean isNumber(char[] arr)
    {
        int i=0;
        boolean isNumber=false;
        char minus='-';
        char plus='+';
        char[] numbers={'0','1','2','3','4','5','6','7','8','9',};
        if (arr[0]==minus||arr[0]==plus)
        {
            i++;
        }
            for (; i <arr.length; i++)
            {
                for (int j=0;j<numbers.length;j++)
                {
                    if (arr[i]==numbers[j])
                    {
                        isNumber=true;
                        break;
                    }
                    if (j==9)
                    {
                      return  isNumber=false;
                    }
                }
            }
        return isNumber;
    }
}