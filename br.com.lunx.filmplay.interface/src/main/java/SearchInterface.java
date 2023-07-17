import javax.swing.*;

public class SearchInterface {

    public String inputSearch() {

        String filmName=null;

        try {

            filmName=JOptionPane.showInputDialog("Insira um filme para pesquisar: ");

            if (filmName.isBlank()){

                String message = "Você deixou o campo de busca vazio!";

                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessage(message);
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog(null, "Aviso do FilmPlay");
                dialog.setVisible(true);

            }

        } catch (NullPointerException e) {

            System.out.println("\nFinalizando FilmPlay...");

            System.exit(0);

        }

        return filmName;

    }
}
