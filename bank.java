public class bank{
    public interface user{
    void display();
} 

public static class accountnumber implements user{

    @Override
    public void display() {
        
        System.out.println("ABCS1234");
    }}
    
public static class balance implements user{

    @Override
    public void display(){
        System.out.println("12345");
    }}

public static void main(String[] args){
        accountnumber ac= new accountnumber();
        user b= new balance();

        ac.display();;
        b.display();
    }

}