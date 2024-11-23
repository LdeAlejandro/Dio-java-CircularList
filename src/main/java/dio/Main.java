package dio;

public class Main {

    public static void main(String[] args) {
        CircularList<String> minhaListaCircular = new CircularList<>();

        minhaListaCircular.add("c1");
        System.out.println(minhaListaCircular.get(0));
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c1");
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c2");
        minhaListaCircular.add("c3");
        System.out.println(minhaListaCircular);

        System.out.println(minhaListaCircular.get(0));
        System.out.println(minhaListaCircular.get(1));
        System.out.println(minhaListaCircular.get(2));
        System.out.println(minhaListaCircular.get(3));
        System.out.println(minhaListaCircular.get(4));

        System.out.println("remove test");
        System.out.println(minhaListaCircular);
        System.out.println(minhaListaCircular.get(1));
        minhaListaCircular.remove(1);
        System.out.println(minhaListaCircular);
        System.out.println(minhaListaCircular.get(1));


    }

}
