public class OOPs {
    public static void main(String args[]){
        Pen p1=new Pen();
        p1.SetColor("Blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);
        p1.color="yellow";
        System.out.println(p1.color);

        BankAccount myAcc=new BankAccount();
        myAcc.username="Shivraj";
        myAcc.SetPassword("abcd");

    }
}

class BankAccount
    {
        public String username;
        private String password;
        public void SetPassword(String pwd){
            password=pwd;
        }

    }

class Pen{
    String color;
    int tip;

    void SetColor(String newColor){
        color=newColor;
    }

    void setTip(int newTip){
        tip=newTip;
    }
    }


