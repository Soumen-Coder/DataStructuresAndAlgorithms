package recurrsion;

public class RemoveWord {
    public static void main(String[] args) {
        String result = removeApp("", "bcAppAppleacdFr");
        System.out.println(result);
    }

    public static String removeApp(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return "";
        }

        char ch = up.charAt(0);

        if(up.startsWith("App") && !up.startsWith("Apple")){
           return removeApp(p, up.substring(3));
        }else{
           return removeApp(p+ch, up.substring(1));
        }
    }
}
