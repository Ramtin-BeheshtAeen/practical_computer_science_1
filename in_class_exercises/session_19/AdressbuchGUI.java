import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Eine GUI für ein Adressbuch.
 * Es werden verschiedene Ansichten auf die Daten
 * des Adressbuchs angeboten:
 *
 *      Eine zum Durchsuchen des Adressbuchs.
 *
 *      Eine zum Eingeben neuer Kontaktdaten.
 *      Der Button 'Einfügen' fügt die Daten
 *      in das Adressbuch ein.
 *
 *      Eine, um alle Einträge des Adressbuchs
 *      anzuzeigen.
 *
 * @author David J. Barnes und Michael Kölling.
 * @version 31.07.2011
 */
class AdressbuchGUI extends JFrame
{
    private static final long serialVersionUID = 20080330L;

    // Bevorzugte Dimensionen für diesen Frame
    private static final int PREFERRED_WIDTH = 500;
    private static final int PREFERRED_HEIGHT = 500;
    private static final Dimension PREFERRED_SIZE =
            new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT);
    // Das Adressbuch, das angezeigt und manipuliert werden soll
    private final Adressbuch buch;

    /**
     * Erzeuge den Frame mit seinen Panels.
     * @param buch das Adressbuch, das manipuliert werden soll.
     */
    AdressbuchGUI(final Adressbuch buch)
    {
        this.buch = buch;
        setTitle("Adressbuch");
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ev)
            {
                setVisible(false);
            }
        });

        final Container contentPane = getContentPane();
        final JTabbedPane tabbedArea = new JTabbedPane();
        tabbedArea.add("Einträge durchsuchen", suchenPanelErstellen());
        tabbedArea.add("Neue Kontakte eintragen",  eingabePanelErstellen());
        tabbedArea.add("Einträge auflisten",   auflistenPanelErstellen());
        contentPane.add(tabbedArea);

        setSize(PREFERRED_SIZE);
    }

    /**
     * Das Fenster anzeigen, nachdem es geschlossen wurde.
     */
    void showWindow()
    {
        setVisible(true);
    }

    /**
     * @return die bevorzugte Größe für diesen Frame.
     */
    @Override
    public Dimension getPreferredSize()
    {
        return PREFERRED_SIZE;
    }

    /**
     * Stelle den Panel für die Dateneingabe zusammen.
     * @return den zusammengestellten Panel.
     */
    private Container eingabePanelErstellen()
    {
        // Aufbauen des Namensfeldes.
        final Box nameLabelBox = Box.createHorizontalBox();
        nameLabelBox.add(new JLabel("Name", JLabel.LEFT));
        nameLabelBox.add(Box.createGlue());
        final JTextField nameEingabe = new JTextField(50);
        final Box nameBereich = Box.createVerticalBox();
        nameBereich.add(nameLabelBox);
        nameBereich.add(nameEingabe);

        // Aufbauen des Telefonfeldes.
        final Box telefonLabelBox = Box.createHorizontalBox();
        telefonLabelBox.add(new JLabel("Telefon", JLabel.LEFT));
        telefonLabelBox.add(Box.createGlue());
        final JTextField telefonEingabe = new JTextField(50);
        final Box telefonBereich = Box.createVerticalBox();
        telefonBereich.add(telefonLabelBox);
        telefonBereich.add(telefonEingabe);

        // Aufbauen des Adressfeldes.
        final Box adresseLabelBox = Box.createHorizontalBox();
        adresseLabelBox.add(new JLabel("Address", JLabel.LEFT));
        adresseLabelBox.add(Box.createGlue());
        final Box adresseBereich = Box.createVerticalBox();
        final JTextArea addressEingabe = new JTextArea(10, 50);
        adresseBereich.add(adresseLabelBox);
        adresseBereich.add(addressEingabe);

        // Die Felder zur Eingabe in einem Panel anordnen.
        final Box einzeiligeEingaben = Box.createVerticalBox();
        einzeiligeEingaben.add(nameBereich);
        einzeiligeEingaben.add(telefonBereich);
        final JPanel eingabePanel = new JPanel();
        eingabePanel.setLayout(new BorderLayout());
        eingabePanel.add(einzeiligeEingaben, BorderLayout.NORTH);
        eingabePanel.add(adresseBereich, BorderLayout.CENTER);

        // Die Buttons anlegen.
        final JPanel buttonLeiste = new JPanel();
        final JButton einfügen = new JButton("Einfügen");
        final JButton löschen = new JButton("Löschen");

        // Die Aktion zum Einfügen anmelden.
        einfügen.addActionListener(ev -> buch.neuerKontakt(
                new Kontakt(nameEingabe.getText(),
                            telefonEingabe.getText(),
                            addressEingabe.getText())));

        // Die Aktion zum Löschen der Eingabefelder anmelden.
        löschen.addActionListener(ev ->
                {
                    nameEingabe.setText("");
                    telefonEingabe.setText("");
                    addressEingabe.setText("");
                });
        buttonLeiste.add(einfügen);
        buttonLeiste.add(löschen);

        // Den Eingabebereich über der Button-Leiste anordnen.
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(eingabePanel, BorderLayout.CENTER);
        panel.add(buttonLeiste, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Stelle den Panel für das Suchen von Einträgen
     * zusammen.
     * @return den zusammengestellten Panel.
     */
    private Container suchenPanelErstellen()
    {
        // Den Bereich für die Eingabe des Such-Strings anlegen.
        final Box suchenLabelBox = Box.createHorizontalBox();
        suchenLabelBox.add(new JLabel("Suchen", JLabel.LEFT));
        suchenLabelBox.add(Box.createGlue());
        final JTextField suchenEingabe = new JTextField(50);
        final Box suchenBereich = Box.createHorizontalBox();
        suchenBereich.add(suchenLabelBox);
        suchenBereich.add(suchenEingabe);

        // Den Bereich für das Anzeige der Ergebnisse anlegen.
        final JTextArea ergebnisliste = new JTextArea(10,50);
        ergebnisliste.setEditable(false);
        final JScrollPane scrollArea =
                new JScrollPane(ergebnisliste,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Jede Änderung am Suchbegriff führt unmittelbar zu
        // einer erneuten Suche im Adressbuch.
        suchenEingabe.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(final DocumentEvent ev)
            {
                erneutSuchen();
            }

            @Override
            public void insertUpdate(final DocumentEvent ev)
            {
                erneutSuchen();
            }

            @Override
            public void removeUpdate(final DocumentEvent ev)
            {
                erneutSuchen();
            }

            /**
             * Durchsuche das Adressbuch und präsentiere die Ergebnisse, es sei denn
             * der Suchbegriff ist leer. In diesem Fall wird die
             * Ergebnisliste geleert.
             */
            private void erneutSuchen()
            {
                final String suchbegriff = suchenEingabe.getText();
                final StringBuilder buffer = new StringBuilder();
                if (suchbegriff.length() > 0) {
                    final Kontakt[] ergebnisse = buch.suche(suchbegriff);
                    for (int i = 0; i < ergebnisse.length; ++i) {
                        buffer.append(ergebnisse[i].toString());
                        buffer.append('\n');
                        buffer.append('\n');
                    }
                }
                ergebnisliste.setText(buffer.toString());
            }
        });

        final JPanel listArea = new JPanel();
        listArea.setLayout(new BorderLayout());
        listArea.add(suchenBereich, BorderLayout.NORTH);
        listArea.add(scrollArea, BorderLayout.CENTER);

        return listArea;
    }

    /**
     * Stelle den Panel zum Auflisten der Einträge
     * zusammen.
     * @return den zusammengestellten Panel.
     */
    private Container auflistenPanelErstellen()
    {
        // Den Bereich definieren, in dem die Daten angezeigt werden.
        final JTextArea datenbereich = new JTextArea(10, 50);
        datenbereich.setEditable(false);
        final JScrollPane scrollBereich =
                new JScrollPane(datenbereich,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Die Buttons erstellen.
        final JPanel buttonLeiste = new JPanel();
        final JButton auflisten = new JButton("Auflisten");
        final JButton loeschen = new JButton("Löschen");

        // Die Aktion zum Auflisten anmelden.
        auflisten.addActionListener(ev ->
                datenbereich.setText(buch.alleKontaktdaten()));

        // Die Aktion zum Löschen des Datenbereichs anmelden.
        loeschen.addActionListener(ev -> datenbereich.setText(""));
        buttonLeiste.add(auflisten);
        buttonLeiste.add(loeschen);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollBereich, BorderLayout.CENTER);
        panel.add(buttonLeiste, BorderLayout.SOUTH);

        return panel;
    }
}
