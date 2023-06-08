import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    new Window(600, 800);
                });

    }
}


//Níže jsou k dispozici dva soubory s daty, které si uložíte do kořenové složky projektu. Soubor people.txt obsahuje data o zákaznících a soubor tshirts.txt data o jimi objednaných třičkách. V prvním řádku souboru jsou vždy uvedeny názvy sloupců s daty.
//
//Vytvořte aplikaci, která propojí odpovídající záznamy podle hodnoty people.ID == tshirts.CUSTOMER_ID a zobrazí je v tabulce na obrazovce. Sloupce s ID v názvu nezobrazujte, naopak přidejte pro každý záznam/řádek sloupec s celkovou cenou pro zákazníka (tj. počet ks * cena).
//
//Pro zjednodušení můžete předpokládat, že každý zákazník má právě jednu objednávku triček. Pozor, pořadí řádků v obou souborech si nemusí odpovídat. Zvolte vhodnou objektovou reprezentaci.
//
//Soubory jsou zde:
//people.txt
//tshirts.txt