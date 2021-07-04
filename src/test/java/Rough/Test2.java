package Rough;

public class Test2 {


    
    public static void main(String args[]) {
        

        int head=200;
        int legs=540;

        for(int i=1;i<=head;i++){

                int sum =(4*i)+(2*(head-i));
                if(sum==legs && (i+(head-i))==head){
                    System.out.println("Rabbits: "+i);
                    System.out.println("Pigeons: "+(head-i));
                    break;
                }
        }
    }

}
