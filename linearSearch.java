public class linearSearch {
    public static int LinearSearch(int numbers[] , int key){
        for (int i=0; i<numbers.length;i++){
            if(numbers[i]==key){
                System.out.print(key + "is found at index "+ i);
                return 0;
            }
        }
        System.out.print("Not Found");
        return 0;
    }
    public static void main(String[] args) {
        
        int numbers[] = {50,1,2,45,47,85,445,55};
        LinearSearch(numbers, 85);
    }
}
