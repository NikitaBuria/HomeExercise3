import java.util.Random;
import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args)
    {
        int [] randomCode=getRandomCode(6,1);

        int[] triesAndDifficulty=getDesiredDifficulty();
        guessCode(randomCode,triesAndDifficulty[1],triesAndDifficulty[0]);
    }

    public static int[] getDesiredDifficulty ()
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int easy=20;
        int medium=15;
        int hard=10;
        int surprise=random.nextInt(25)+5;
        int [] triesAndDifficulty=new int[2];
        System.out.println("welcome to the guess game!, you will have to guess a code sequence from 1-6,if you guess the code right and at the right sequence you will get a banana!,lets see how you do");
        System.out.println("Select the desired difficulty 1 for easy and 20 tries,2 for medium and 15 tries,3 for hard and 10 tries , or 4 for a random set from 5-25");
        triesAndDifficulty[0]=scanner.nextInt();
        while (triesAndDifficulty[0]<1 || triesAndDifficulty[0]>4)
        {
            System.out.println("You have entered an invalid difficulty try again.");
            System.out.println("Select the desired difficulty 1 for easy and 20 tries,2 for medium and 15 tries,3 for hard and 10 tries , or 4 for a random set from 5-25");
            triesAndDifficulty[0]=scanner.nextInt();
        }
        if (triesAndDifficulty[0]==4)
        {
            System.out.println("You have selected the surprise difficulty, We won`t tell you how many tries you have, and you wont know how much tries have left after every round, good luck !");
        }
        if ( triesAndDifficulty[0]==1) {
            triesAndDifficulty[1]=easy;
            return triesAndDifficulty;
        }else if (triesAndDifficulty[0]==2)
        {
            triesAndDifficulty[1]=medium;
            return triesAndDifficulty;
        } if (triesAndDifficulty[0]==3)
    {
        triesAndDifficulty[1]=hard;
        return triesAndDifficulty;
    } else if (triesAndDifficulty[0]==4)
    {
         triesAndDifficulty[1]=surprise;
         return triesAndDifficulty;
    }
      return  triesAndDifficulty;
    }
    public static boolean  win (int correctTries)
    {
        boolean won=false;
        if(correctTries==4)
        {
            won=true;
        }else won=false;
        return won;
    }


    public static void guessCode (int [] randomCode,int playerTries,int playerDifficulty)
    {
        int correctTries=0;
        if (playerDifficulty==4)
        {
            System.out.println("And here we go");
        } else
        {
            System.out.println("You have : "+playerTries+" tries left good luck!");
        }

        playerTries--;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Try to guess the 4 numbers in the code, enter 4 numbers to guess");

        int [] playerGuesses=new int[randomCode.length];
        int [] correctGuesses=new int [randomCode.length];
        int playerCorrectGuesses=0;
        for (int i=0;i<playerGuesses.length;i++)
        {
            playerGuesses[i]=scanner.nextInt();
        }

        for (int i=0;i<playerGuesses.length;i++)
        {
            for (int j=i+1;j<playerGuesses.length;j++)
            {
                if (playerGuesses[i]==playerGuesses[j])
                {
                    playerTries=playerTries-2;
                    System.out.println("You have entered the number: "+playerGuesses[i] + " more then one time so i took 2 tries from you , Be care full next time.");
                    break;
                }
            }
        }

        for (int i=0;i<playerGuesses.length;i++)
        {
            if (randomCode[i] == playerGuesses[i])
            {
                correctGuesses[i]=randomCode[i];
                System.out.println("This number that u typed: "+ (i+1) +" is the correct number and at the right sequence, the number is: "+ randomCode[i]);
            }
        }
        for (int i=0;i<playerGuesses.length;i++)
        {
            if (playerGuesses[i]==randomCode[i])
            {
                correctTries++;

            }
        }
        if (correctTries==4)
        {
            System.out.println("WOW YOU ARE A WIZARD! how did u get that right? you have won! the code is ");
            printArray(playerGuesses);
            return;
        }
        if(win(correctTries))
        {
            return;
        }
        for (int i=0;i<playerGuesses.length;i++)
        {
            for (int j=0;j<randomCode.length;j++)
            {
                if (playerGuesses[i]==randomCode[j]&&i!=j)
                {
                    playerCorrectGuesses++;
                    break;
                }
            }
        }
        System.out.println("you have: " + playerCorrectGuesses + " partial correct guesses, you have entered a correct number but not at the right spot,Try again.");

        if (playerTries<=0)
        {
            System.out.println("You have failed,no banana for you ! , better luck next time! the code that u wanted to guess is:" );
            printArray(randomCode);
            return;
        }
        if (playerTries>0) {
            guessCode(randomCode,playerTries,playerDifficulty);
        }
    }

    public static void printArray (int [] playerGuesses)
    {

        for (int i=0;i<playerGuesses.length;i++)
        {
            System.out.print(playerGuesses[i]+" ");
        }

    }

    public static int[] getRandomCode (int max,int min)
    {

        int[] randomCode=new int[4];


    for (int i=0;i<randomCode.length;i++)
        {
            randomCode[i]=getRandomNumber();
            for (int j=0;j<randomCode.length;j++)
            {

                if (randomCode[i]==randomCode[j]&&j!=i)
                {
                    randomCode[j]=getRandomNumber();
                }
            }

        }

        return randomCode;
        }

        public static int getRandomNumber ()
        {
            Random random=new Random();
            int randomNumberFromOneToSix=random.nextInt(6)+1;
            return randomNumberFromOneToSix;
        }

    }