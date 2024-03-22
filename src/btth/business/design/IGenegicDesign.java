package btth.business.design;

public interface IGenegicDesign<T,E> {
    void showAll();
    void addNew();
    void edit();
    void showId();
    void delete();
    T inputData(boolean isAdd);
}
