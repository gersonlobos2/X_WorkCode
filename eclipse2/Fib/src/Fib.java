public class Fib implements Runnable
{
private int x;
public  int answer;

public Fib(int x) {
    this.x += x;
}


public void run() {
    //if( x < 2 )
      //  answer = 1;
   // else {
        try {
            Fib f1= new Fib(x-1);
            Fib f2= new Fib(x-2);
            Thread threadf1=new Thread(f1);
            Thread threadf2=new Thread(f2);
            threadf1.start();
            threadf2.start();
            threadf1.join();
            threadf2.join();

            answer = f1.answer + f2.answer;

        }
        catch(InterruptedException ex) { }
    //}
}

public static void main(String[] args)

{
    try {

                for (int i=0;i<15;i++){
                Fib f= new Fib(i);
                Thread threadf= new Thread(f);
                threadf.start();
                threadf.join();

                System.out.println("Ergebnis:"+f.answer);

            }
        }

    catch(Exception e) {
        System.out.println("usage: java Fib NUMBER");
    }
  }
}