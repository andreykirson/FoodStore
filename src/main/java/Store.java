public interface Store {

    boolean accept(Food f);
    void add(Food f);
    int size();
    Food get();
}
