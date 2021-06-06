package Rough;



public class Test1 {
    int a,b=9;
    public static void main(String args[]) {


    String input = "I#Lo$ve%In&di*a";
    String output = "a#id$nI%ev&oL*I";


    char[] str = input.toCharArray();

    int j = input.length()-1;
    int i = 0;

    while(i<j)
    {
        char temp=str[i];
        if(temp=='#'||temp=='$'||temp=='%'||temp=='&'||temp=='*') {

            i++;
            j--;
            continue;
        }
        str[i] = str[j];
        str[j] = temp;
        i++;
        j--;
    }
        System.out.println(new String(str));

    }

    public int sum(){
        return a+b;
    }
    private int add(){
        return a+b;
    }
    public int result(){
       return new Test1().add();
    }
}

