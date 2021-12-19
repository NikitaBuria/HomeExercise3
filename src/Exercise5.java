import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args)
    {
        String text;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a text");
        {
            text=scanner.nextLine();
        }
        char[] textConvertedToChars = new char[text.length()];
        for (int i = 0; i < textConvertedToChars.length; i++) {
            textConvertedToChars[i] = text.charAt(i);
        }
        countAppearances(textConvertedToChars);

    }

    public static void countAppearances(char[] textToCheck)
    {

        int counterForSecondHighestAppearance = 0;
        int counterForHighestAppearance = 0;
        int tempCounter = 0;
        char[] hasTheHighestAppearance = {'0'};
        char[] secondHighestAppearance = {'0'};
        for (int i = 0; i < textToCheck.length; i++) {
            if (textToCheck[i] != hasTheHighestAppearance[0]) {
                tempCounter = 0;
                for (int j = i; j < textToCheck.length; j++) {
                    if (textToCheck[i] == textToCheck[j]) {
                        tempCounter++;
                    }

                }
                if (tempCounter > counterForHighestAppearance) {
                    counterForHighestAppearance = tempCounter;
                    hasTheHighestAppearance[0] = textToCheck[i];
                }
                if (tempCounter > counterForSecondHighestAppearance && textToCheck[i] != hasTheHighestAppearance[0]) {
                    counterForSecondHighestAppearance = tempCounter;
                    secondHighestAppearance[0] = textToCheck[i];
                }
            }
        }
        for (int i = 0; i < textToCheck.length; i++)
        {
            if (textToCheck[i] == hasTheHighestAppearance[0]) {
                textToCheck[i] = secondHighestAppearance[0];
            }
        }
        for (int i=0;i<textToCheck.length;i++)
        {
            System.out.print(textToCheck[i]);

        }

    }
}


