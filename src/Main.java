// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Welcome stranger0!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
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