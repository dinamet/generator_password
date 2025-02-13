import java.util.Scanner;

public class Parity {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int n=input.nextInt();
        int m=0, p=1;
        while(n>0){
            int d=n%10;

            if (d%2==0) {d++;}
            else {d--;}

            n=n/10;
            m=d*p+m;
            p=p*10;

        }
        System.out.print(m);
    }
}
