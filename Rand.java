import java.util.*;
import java.util.Scanner;
public class Rand{
public static void main(String args[])
{
int n=0,count,score=0,a=1,i=1;
Scanner s=new Scanner(System.in);
Random random=new Random();
System.out.println("Guess any number from 1 to 100");
System.out.println("Guess the number within 5 tries ");
do
{
int randomno=random.nextInt(100)+1;
count=0;
System.out.println("-----------ROUND - "+i+"-------------");
while(randomno!=n)
{
count++;
System.out.println("Guess the number ");
n=s.nextInt();
if(n>randomno)
{
System.out.println("Too High ");
}
else if(randomno==n)
{
System.out.println("Congratulations! \nYou've guessed the correct number ");
score++;
}
else if(n<randomno)
{
System.out.println("Too Low ");
}
if(count==5)
{
break;
}
}
System.out.println("The generated number from 1 to 100 is : "+randomno);
System.out.println("Do you want to play again (1-yes|0-no)");
a=s.nextInt();
i++;
}
while(a!=0);
System.out.println("No of attempts = "+ --i);
System.out.println("Score = "+score);
}
}	