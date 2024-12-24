import java.util.*;

public class ass9_B {
    public static class Job{
        int id;
        int deadline;
        int profit;

        Job(int id , int deadline , int profit){
            this.id=id;
            this.deadline=deadline;
            this.profit=profit;
        }
    }

    public static void main(String[] args) {
        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs=new ArrayList<>();

        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        //Decreasing order
        Collections.sort(jobs , (obj1 , obj2) ->obj2.profit - obj1.profit);


        int time=0;
        int profit=0;
        ArrayList seq=new ArrayList<>();

        for(int i=0;i<jobsInfo.length;i++){

            Job curr=jobs.get(i);
            if(curr.deadline > time){
                seq.add(i);
                time++;
                profit+=curr.profit;
            }
        }

        System.out.println("Max Profit : "+profit);
        System.out.println("Maximum Jobs : "+seq.size());
        System.out.println("Path of jobs which we can do : ");
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i));
        }
    }
}
