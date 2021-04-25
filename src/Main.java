import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static GuestList devmindList;
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./src/Commands.txt");
		Scanner sc = new Scanner(file);
		devmindList = new GuestList(sc.nextInt());
		boolean isTrue = true;
		
		
		while(isTrue) {
			String command = sc.nextLine();
			switch (command) {
			case "add":
				add(sc);
				break;
			case "check":
				check(sc);
				break;
			case "remove":
				remove(sc);
				break;
			case "update":
				update(sc);
				break;
			case "guests":
				guestList();
				break;
			case "waitlist":
				waitList();
				break;
			case "available":
				available();
				break;
			case "guests_No":
				guests_No();
				break;
			case "waitlist_No":
				waitingList_No();
				break;
			case "subscribe_No":
				subscribe_No();
				break;
			case "search":
				search(sc);
				break;
			case "help":
				help();
				break;
			case "quit":
				isTrue = false;
				break;
			}
		}
		sc.close();
	}

	public static void add(Scanner sc) {
		System.out.println("Please enter the guest's details: ");
		devmindList.addNewPerson(sc.next(), sc.next(), sc.next(), sc.next());

	}
	
	public static void check(Scanner sc) {
		System.out.println("Please enter the guest's details: ");
		Guest guest = new Guest(sc.nextLine(), sc.nextLine(),sc.nextLine(),sc.nextLine());
		System.out.println(guest);
		System.out.println(devmindList.checkIfPersonIsRegistered(guest));
	}
	
	public static void remove(Scanner sc) {
		System.out.println("Please enter the guest's details: ");
		Guest guest = new Guest(sc.nextLine(), sc.nextLine(),sc.nextLine(),sc.nextLine());
		System.out.println(guest);
		devmindList.removePerson(guest);

	}
	
	public static void update(Scanner sc) {
		System.out.println("Please enter the guest's details: ");
		Guest guest = new Guest(sc.nextLine(), sc.nextLine(),sc.nextLine(),sc.nextLine());
		System.out.println(guest);
		System.out.println("Please enter the information you want updated: ");
		String oldInfo = sc.nextLine();
		System.out.println(oldInfo);
		String newInfo = sc.nextLine();
		System.out.println(newInfo);
		devmindList.updateGuest(guest, oldInfo, newInfo);
	}
	
	public static void guestList() {
		devmindList.displayListOfRegisteredGuests();
	}
	
	public static void waitList() {
		devmindList.displayWaitingList();
	}
	
	public static void available() {
		System.out.println(devmindList.availablePlaces());
	}
	
	public static void guests_No() {
		System.out.println(devmindList.guestsRegistered());
	}
	
	public static void waitingList_No() {
		System.out.println(devmindList.waitingListNumber());
	}
	
	public static void subscribe_No() {
		System.out.println(devmindList.totalNumberOfGuests());
	}
	
	public static void search(Scanner sc) {
		System.out.println("Please enter the details you want to search for: ");
		String searchLetters = sc.nextLine();
		System.out.println(devmindList.search(searchLetters));
	}
	
	public static void help() {
		System.out.println("This is the Command List:");
		System.out.println();
		System.out.println("add          - Adauga o noua persoana (inscriere)\r\n"
						 + "check        - Verifica daca o persoana este inscrisa la eveniment\r\n"
						 + "remove       - Sterge o persoana existenta din lista\r\n"
						 + "update       - Actualizeaza detaliile unei persoane\r\n"
						 + "guests       - Lista de persoane care participa la eveniment\r\n"
						 + "waitlist     - Persoanele din lista de asteptare\r\n"
						 + "available    - Numarul de locuri libere\r\n"
						 + "guests_no    - Numarul de persoane care participa la eveniment\r\n"
						 + "waitlist_no  - Numarul de persoane din lista de asteptare\r\n"
						 + "subscribe_no - Numarul total de persoane inscrise\r\n"
						 + "search       - Cauta toti invitatii conform sirului de caractere introdus\r\n"
						 + "quit         - Inchide aplicatia");
	}
}
