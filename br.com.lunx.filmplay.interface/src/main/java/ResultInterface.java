import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ResultInterface extends JFrame implements ActionListener {

    JFrame mainWindow = new JFrame("FilmPlay");

    JTextField jtFilm = new JTextField(40);
    JTextField jtGenre = new JTextField(40);
    JTextField jtReleaseYear = new JTextField(40);
    JTextField jtReleaseTime = new JTextField(40);
    JTextField jtDirector = new JTextField(40);
    JTextField jtRuntime = new JTextField(40);
    JTextField jtPlot = new JTextField(40);

    JLabel jlFilm = new JLabel("Filme:");
    JLabel jlGenre = new JLabel("Gênero:");
    JLabel jlReleaseYear = new JLabel("Ano:");
    JLabel jlReleaseTime = new JLabel("Lançamento:");
    JLabel jlDirector = new JLabel("Diretor:");
    JLabel jlRuntime = new JLabel("Duração:");
    JLabel jlPlot = new JLabel("Resumo:");

    JButton jbNewSearch = new JButton("Nova busca");

    public void viewFilm(FilmEntity film) {

        jbNewSearch.addActionListener(this);

        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
        mainWindow.setSize(700, 600);

        jlFilm.setBounds(18, 18, 100, 30);
        jtFilm.setBounds(150, 18, 340, 30);
        jlGenre.setBounds(18, 78, 100, 30);
        jtGenre.setBounds(150, 78, 340, 30);
        jlReleaseYear.setBounds(18, 138, 100, 30);
        jtReleaseYear.setBounds(150, 138, 340, 30);
        jlReleaseTime.setBounds(18, 198, 100, 30);
        jtReleaseTime.setBounds(150, 198, 340, 30);
        jlDirector.setBounds(18, 258, 100, 30);
        jtDirector.setBounds(150, 258, 340, 30);
        jlRuntime.setBounds(18, 318, 100, 30);
        jtRuntime.setBounds(150, 318, 340, 30);
        jlPlot.setBounds(18, 378, 100, 30);
        jtPlot.setBounds(150, 378, 340, 90);

        jbNewSearch.setBounds(18, 550, 200, 30);

        jtFilm.setText(film.getFilmName());
        jtGenre.setText(film.getGenre());
        jtReleaseYear.setText(String.valueOf(film.getReleaseYear()));
        jtReleaseTime.setText(film.getReleasedTime());
        jtDirector.setText(film.getDirector());
        jtRuntime.setText(film.getRuntime());
        jtPlot.setText(film.getPlot());

        mainWindow.add(jlFilm);
        mainWindow.add(jtFilm);
        mainWindow.add(jlGenre);
        mainWindow.add(jtGenre);
        mainWindow.add(jlReleaseYear);
        mainWindow.add(jtReleaseYear);
        mainWindow.add(jlReleaseTime);
        mainWindow.add(jtReleaseTime);
        mainWindow.add(jlDirector);
        mainWindow.add(jtDirector);
        mainWindow.add(jlRuntime);
        mainWindow.add(jtRuntime);
        mainWindow.add(jlPlot);
        mainWindow.add(jtPlot);
        mainWindow.add(jbNewSearch);

    }

    public void start() throws IOException, InterruptedException {

        Engine engine = new Engine();

        SearchInterface searchInterface = new SearchInterface();

        String filmQuery = searchInterface.inputSearch();

        while (filmQuery.isBlank()) {

            filmQuery=searchInterface.inputSearch();

        }

        FilmEntity queryFilm = engine.searchEngine(filmQuery);

        viewFilm(queryFilm);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbNewSearch) {

            mainWindow.setVisible(false);

            try {

                start();

            } catch (IOException | InterruptedException ex) {

                throw new RuntimeException(ex);

            }

        }

    }

}
