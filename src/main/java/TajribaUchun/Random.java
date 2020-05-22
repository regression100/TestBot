package TajribaUchun;

public class Random {
    static int var=96;
    public static void main(String[] args) {

        int a=0,b=0,c=0,d=0;
        int x,y;
        String matematika="",tarix="",onaTili="";
        for (int i = 1; i <=30 ; i++) {
            x = (int) (Math.random() * 4) +1;
            System.out.println( i+") "+(char) (var+x));
            matematika+=(char) (var+((int)(Math.random()*4)+1));
            tarix+=(char) (var+((int)(Math.random()*4)+1));
            onaTili+=(char) (var+((int)(Math.random()*4)+1));

            switch (x){
                case 1:
                    a++;
                    break;
                case 2:
                    b++;
                    break;
                case 3:
                    c++;
                    break;
                case 4:
                    d++;
                    break;
            }
        }
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("c = "+c);
        System.out.println("d = "+d);

        char A='a';
        char B='b';
        char C='c';
        char D='d';
//        System.out.println((int) A);
//        System.out.println((int) B);
//        System.out.println((int) C);
//        System.out.println((int) D);
        char t=97;
        System.out.println(t);
        System.out.println(matematika);
        System.out.println(tarix);
        System.out.println(onaTili);


    }
}
