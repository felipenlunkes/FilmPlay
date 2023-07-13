import javax.swing.JOptionPane;

public class SearchInterface {

    public String inputSearch() {
        String filmName=null;
        filmName=JOptionPane.showInputDialog("Insira um filme para pesquisar: ");

        return filmName;

    }
}
