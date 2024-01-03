import java.awt.DisplayMode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Course {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Exercice 1: simulateur d'arrivée de course hippique");
		String replay = "oui";
		do {
			System.out.println("Combien de chevaux participent ? (entre 12 et 20)");
			String numberHorsesString = scn.nextLine();
			System.out.println("Sur combien de chevaux parier (entre 3 et 5)");
			String numberHorsesParieString = scn.nextLine();
			if (ctrlWrite(numberHorsesString) && ctrlPari(numberHorsesParieString)) {
				Set <Integer>horse=horseRace(Integer.parseInt(numberHorsesParieString));
				showResult(horse);
			} else {
				System.out.println("Erreur détecté, veuillez recommencer");
			}
			System.out.println("Une autre tentative ?");
			replay = scn.nextLine();
		} while (replay.equals("oui"));
		System.out.println("Au revoir");
	}
	
	public static Set <Integer> horseRace(int numberHorses) {
		Random random = new Random();
		Set <Integer> horse = new HashSet<>();
		while (horse.size() <numberHorses) {
			int randomNumber =random.nextInt(20)+1;
			horse.add(randomNumber);
		}
		return horse;
	}
	
	public static void showResult(Set<Integer>horse) {
			Iterator<Integer>iterator = horse.iterator();
			while (iterator.hasNext()){
				int horseWin = iterator.next();
				System.out.println("les chevaux " + horseWin + "" + "ont gagné la course");
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
	private static boolean ctrlPari(String x) {
		Scanner scanner = new Scanner(x);
		boolean out = false;
		if (scanner.hasNextInt()) {
			int number = Integer.parseInt(x);
			if (number >= 3 && number <= 5) {
				out = true;
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