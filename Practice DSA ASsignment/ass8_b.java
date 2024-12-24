import java.util.*;
public class ass8_b {
    public static class Students{
        int credits;
        String name;

        Students(String name , int credits){
            this.name=name;
            this.credits=credits;
        }
    }

    public static int partitaion(Students student[] , int low , int high){
        int pivoteEle = student[high].credits;

        int i=low-1;
        for(int j=low ;j<high ; j++){

            if(student[j].credits >= pivoteEle){
                i++;
                //swap arr[i] with arr[j]
                Students temp=student[i];
                student[i]=student[j];
                student[j]=temp;

            }
        }

        //swap arr[i+1] with pivoteEle

        Students temp=student[i+1];
        student[i+1]=student[high];
        student[high]=temp;
        
        return i+1;

    }
    public static void quickSort (Students student[] , int low , int high){
        if(low < high){

            int pi= partitaion (student , low , high);

            quickSort(student, low, pi-1);
            quickSort(student, pi+1, high);
        }
    }

    public static void display(Students student[]){
        System.out.println("Top 3 Students:");
        for(int i=0;i<Math.min(3,student.length);i++){
            System.out.println(student[i].name+" ");
        }
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the number of students : ");
        int n=sc.nextInt();
        sc.nextLine(); 

        Students student[] =new Students[n];

        for(int i=0;i<n;i++){
            System.out.print("Enter the name of student "+(i+1)+" :");
            String name=sc.nextLine();

            System.out.print("Enter the credits for "+ name +" :");
            int credits=sc.nextInt();
            sc.nextLine();

            student[i]=new Students(name, credits);
        }
        quickSort(student, 0, n-1);
        display(student);
    }
}
