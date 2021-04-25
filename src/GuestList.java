import java.util.ArrayList;

public class GuestList{
	private final int placesAvailable;
	private ArrayList<Guest> guestList;
	
	public GuestList(int placesAvailable) {
		this.placesAvailable = placesAvailable;
		this.guestList = new ArrayList<Guest>(placesAvailable);
		
	}
	
	public int addNewPerson(String firstName, String lastName, String email, String phoneNumber) {
		Guest guest = new Guest(firstName, lastName, email, phoneNumber);
		if(checkIfPersonIsRegistered(guest)) {
				System.out.println("You are already registered to this event");
				return -1;
			}
		this.guestList.add(guest);
		
		if(this.guestList.indexOf(guest) > placesAvailable) {
			System.out.println("You have successfully registered on our waiting list and your number is " + 
								(guestList.indexOf(guest) - this.placesAvailable) + ". We will notify you immediately if a place becomes available.");
			return this.guestList.indexOf(guest);
		}else {
		
			System.out.println(guest + " Congratulations! You have successfully registered for this event.");
			return 0;
		}
	}
	
	public boolean checkIfPersonIsRegistered(Guest guest) {
		for(int i = 0; i < this.guestList.size(); i++) {
			if(guest.equals(this.guestList.get(i))) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean removePerson(Guest guest) {
		if(checkIfPersonIsRegistered(guest)) {
			this.guestList.remove(guest);
			System.out.println("You have been removed from the Devmind event's list.");
			
			if(this.guestList.indexOf(guest) < 30 && this.guestList.size() >= this.placesAvailable) {
				System.out.println(this.guestList.get(this.placesAvailable).getFirstName() + " you are now registered for this event!");
			}
			
			return true;
		}
		
		return false;
	}
	

	public void updateGuest(Guest guest,String oldInfo, String newInfo) {
		if(checkIfPersonIsRegistered(guest)) {
			if(oldInfo.equals(guest.getFirstName())) {
				guest.setFirstName(newInfo);
			}
			if(oldInfo.equals(guest.getLastName())) {
				guest.setLastName(newInfo);
			}
			if(oldInfo.equals(guest.getEmail())) {
				guest.setEmail(newInfo);
			}
			if(oldInfo.equals(guest.getPhoneNumber())) {
				guest.setPhoneNumber(newInfo);
			}
			System.out.println("The guest's details are: " + guest.toString());
		}
		else {
			System.out.println("This person is not registered to this event.");
		}

	}
	

	public void displayListOfRegisteredGuests() {
		if(this.guestList.size() >= this.placesAvailable) {
			for(int i = 0; i < this.placesAvailable; i++) {
				System.out.println(this.guestList.get(i).toString());
			}
			
		} else {
			for(int i = 0; i < this.guestList.size(); i++) {
				System.out.println(this.guestList.get(i).toString());
			}
		}
		
	}
	
	public void displayWaitingList() {
		if(this.guestList.size() > this.placesAvailable) {
			for(int i = this.placesAvailable; i < this.guestList.size(); i++) {
				System.out.println(this.guestList.get(i).toString());
			}
		} else {
			System.out.println("There is no entry on the waiting list.");
		}
	}
	
	
	public int availablePlaces() {
		if(this.guestList.size() > this.placesAvailable) {
			return 0;
		}
		System.out.println(this.placesAvailable - this.guestList.size());
		return this.placesAvailable - this.guestList.size();
	}
	
	public int guestsRegistered() {
		if(this.guestList.size() > this.placesAvailable) {
			return this.placesAvailable;
		}
		
		return this.guestList.size();
	}
	
	public int waitingListNumber() {
		if(this.guestList.size() > this.placesAvailable) {
			return this.guestList.size() - this.placesAvailable;
		}
		
		return 0;
	}
	
	public int totalNumberOfGuests() {
		return this.guestList.size();
	}
	
	public ArrayList<String> search(String myString) {
		ArrayList<String> findPerson = new ArrayList<String>();
		String stringToCompare = myString.toLowerCase();
		
		for(Guest guest: guestList) {
			String firstName = guest.getFirstName().toLowerCase();
			String lastName = guest.getLastName().toLowerCase();
			String email = guest.getEmail().toLowerCase();
			String phone = guest.getPhoneNumber().toLowerCase();

			
			if(firstName.contains(stringToCompare)) {
				findPerson.add(guest.getFirstName());
			}
			
			if(lastName.contains(stringToCompare)) {
				findPerson.add(guest.getLastName());
			
			}
			
			if(email.contains(stringToCompare)) {
				findPerson.add(guest.getEmail());
			}
			
			if(phone.contains(stringToCompare)) {
				findPerson.add(guest.getPhoneNumber());
			}
		}
		
		return findPerson;
		
	}
	
}
