package recurrsion;

public class TowerOfHanoi {
    public static int count=1;

    public static void main(String[] args) {
        int n=3; // 3 disks
        //int s=1, h=2, d=3; //source, helper, destination given numbers
        char s='A', h='B', d='C';

        int countOfSteps = solve(s,h,d,n,count);
        System.out.println("Count Of Steps = "+countOfSteps);
    }

    public static int solve(char source, char helper, char dest, int noOfDisks, int countOfSteps){
        if(noOfDisks == 1){
            System.out.println("Moving disk "+noOfDisks+" From source "+source+" To destination "+dest);
            return count;
        }

        solve(source, dest, helper, noOfDisks-1, count++);
        System.out.println("Moving disk "+noOfDisks+" From source "+source+" To destination "+dest);

        solve(helper, source, dest, noOfDisks-1, count++);
        return count;
    }

}
