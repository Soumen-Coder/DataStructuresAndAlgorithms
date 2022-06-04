package Tricky;

public class CreatingObjectInSameClass {
    public static void main(String[] args) {
        C c = new C();

        System.out.println(c);
    }
}

class C{

    C(){
        System.out.println("I am the C constructor");
    }

    C c = new C();
}
