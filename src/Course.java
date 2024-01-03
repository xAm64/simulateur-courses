import java.util.Scanner;
public class Course {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Exercice 1: simulateur d'arrivée de course hippique");
		System.out.println("Combien de chevaux sont au départ ? (minumum 12, maximum 20)");
		//récupère le nombre de chevaux
		String numberString = scn.nextLine();
		//controle si c'est conforme.
		if (ctrlWrite(numberString)) {
			int[] horses = generateHorses(Integer.parseInt(numberString));
		//non conforme.
		} else {
			System.out.println("Veuillez écrire le nombre de chevaux (entre 12 et 20)");
		}
	}
	private static boolean ctrlWrite(String x) {
		Scanner scanner = new Scanner(x);
		boolean out = false;
		if (scanner.hasNextInt()) {
			int number = Integer.parseInt(x);
			if (number >= 12 && number <= 20) {
				out = true;
			}
		}
		return out;
	}
	private static int[] generateHorses (int numberHorses) {
		int[] horses = new int[numberHorses];
		for (int i = 0; i<horses.length;i++) {
			horses[i] = i+1;
		}
		return horses;
	}
	private static String writeHorses(int[] horses, int numbers) {
		String out = "";
		for (int i=0;i<numbers;i++) {
			if (i <numbers -1) {
				out += Integer.toString(horses[i])+", ";
			} else {
				out += Integer.toString(horses[i])+".";
			}
		}
		return out;
	}
}
/*
Une course hippique rassemble 12 à 20 chevaux. Un tiercé s’intéresse au classement des 3 premiers,
un quarté des 4 premiers, et un quinté des 5 premiers.
Le programme demande en boucle à l’utilisateur (ou jusqu’à ce qu’il indique qu’il souhaite que le
programme se termine) le nombre de chevaux de la course et son type (tiercé, quarté, quinté). Il
affiche alors une arrivée tirée aléatoirement de la course.
----------
Générer un tableau de 12 à 20 éléments.
prendre 3 à 5 éléments selon la demande.
Les éléments ne peuvent pas se répéter.
*/

/*
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
 
public class Course {
 
	public static void main(String[] args) {
// proposer au joueur de jouer 
	Scanner Scanner = new Scanner (System.in);
	boolean play = true; 
	while(play) {
		System.out.println("Souhaitez-vous jouer ? Oui/Non");
		String response = Scanner.nextLine();
		if (response.equals("Oui") || response.equals("oui")) {
			Set <Integer>horse=horseRace();
			showResult(horse);
		}else{
			System.out.println("à bientôt");
			play = false;
		}
	}
	Scanner.close();
}
		// générer un nombre 
public static Set <Integer> horseRace() {
	Random random = new Random();
// le set est une collection qui permet de ne pas faire de doublon on s'assure que chaque numéro de cheval est unique
	Set < Integer> horse = new HashSet<>();//HashSet stocke des éléments et permet d'ajouter et de suprimer ce qui a déjà été suggéré par la méthode random
//selectionner 3 chevaux
	while (horse.size() <3) {
		int randomNumber =random.nextInt(20)+1;
		horse.add(randomNumber);
	}
	return horse;
}
public static void showResult(Set<Integer>horse) {
//iterator permet de parcourir les éléments du HashSet des horses et les affiches. Sans cela ça ne fonctionne pas
	Iterator<Integer>iterator = horse.iterator();
	while (iterator.hasNext()){
		int horseWin = iterator.next();
		System.out.println("les chevaux " + horseWin + "" + "ont gagné la course");
	}

}
}
*/