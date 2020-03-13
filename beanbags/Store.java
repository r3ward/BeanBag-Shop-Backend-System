package beanbags;

import java.io.IOException;
import java.io.*;

/**
 * Store is a compiling, functioning implementor of the
 * BeanBagStore interface.
 * 
 * @authors - 690021991, 690046527
 * @version 1.2
 */

public class Store implements BeanBagStore {

    static ObjectArrayList currentStock = new ObjectArrayList();
    static ObjectArrayList soldStock = new ObjectArrayList();
    static ObjectArrayList reserveStock = new ObjectArrayList();
    public static int reservationNumber = 0;

// Exception checking created in an object oriented manor if they are used more than twice.
    private boolean checkId(String id) {
        if (id.matches("-?[0-9a-fA-F]+") && (id.length() == 8)) {
            return true;
        } else {
            return false;  
        }
    }

		//check if reservation number exists
    private boolean reservationNumberCheck(int reservationNumber) {

        for (int i = 0; i < reserveStock.size(); i++) {
            BeanBag item = (BeanBag) reserveStock.get(i);
            int reservationNumberCheck = item.getReservation();
            if (reservationNumber == reservationNumberCheck) {
                return true;
            }
        }
        return false;
    }
		//check if number is worth more than 0
		private boolean illegalNumberOfBeanBagsAddedCheck(int num) {

			if (num < 1) {
          return false;
        }

			else {
				return true;
			}

		}

		//clear 
		public void clearFunction(ObjectArrayList elementStock) {
        while (elementStock.size() != 0) {
            // will always remove the first position object until empty.
            BeanBag item = (BeanBag) elementStock.get(0);
            elementStock.remove(0);
            item = null;}        
		}

		    /**
        Method adds bean bags to the store with the arguments as bean bag details .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
    
        @param num number of bean bags added
        @param manufacturer bean bag manufacturer
        @param name bean bag name
        @param id ID of bean bag
        @param year year of manufacture
        @param month month of manufacture

        @throws IllegalNumberOfBeanBagsAddedException if the number to be added
        is less than 1

        @throws BeanBagMismatchException if the id already exists (as a current in
        stock bean bag , or one that has been previously
        stocked in the store , but the other stored
        elements ( manufacturer , name and free text ) do
        not match the pre - existing version
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        
        @throws InvalidMonthException if the month is not in the range 1 to 12
         */

		@Override
    public void addBeanBags(int num, String manufacturer, String name, String id, short year, byte month)
    throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException, IllegalIDException,
    InvalidMonthException {

        // check for exceptions.

        if (illegalNumberOfBeanBagsAddedCheck(num) == false) {
            throw new IllegalNumberOfBeanBagsAddedException("Beanbags quantity must be greater than 1.");
        }
        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
        }
        if (month < 1 || month > 12) {
            throw new InvalidMonthException("The month is not in the range 1 to 12");
        }

        // check if bean bag is currently already in list.
        boolean beanbagExist = false;
        for (int i = 0; i < currentStock.size(); i++) {
            // for every item in stock
            BeanBag item = (BeanBag) currentStock.get(i);
            if (id == item.getId()) { 
                // same id = same manufacturer, name, free text
                if (manufacturer == item.getManufacturer() && name == item.getName()) {
                    // check if current ID exists in the stock.
                    beanbagExist = true;
                    // increase item
                        item.setNum(item.getNum()+1);
                } else {
                    throw new BeanBagMismatchException("The id already exists (as a current in stock bean bag , or one that has been previously stocked in the store , but the other stored elements ( manufacturer , name and free text ) do not match the pre - existing version.");
                }
            }
        }

        if (beanbagExist == false) {
            // if the bean bag does not exist, it is created.
            BeanBag testBag = new BeanBag(num, manufacturer, name, id, year, month, null);
            currentStock.add(testBag);
        }

    }


        /**
        Method adds bean bags to the store with the arguments as bean bag details .
        <p>
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param num number of bean bags added
        @param manufacturer bean bag manufacturer
        @param name bean bag name
        @param id ID of bean bag
        @param year year of manufacture
        @param month month of manufacture
        @param information free text detailing bean bag information
        
        @throws IllegalNumberOfBeanBagsAddedException if the number to be added
        is less than 1
        
        @throws BeanBagMismatchException if the id already exists (as a current in
        stock bean bag , or one that has been previously
        stocked in the store , but the other stored
        elements ( manufacturer , name and free text ) do
        not match the pre - existing version
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        
        @throws InvalidMonthException if the month is not in the range 1 to 12
        
        */
		@Override
    public void addBeanBags(int num, String manufacturer, String name, String id, short year, byte month,
            String information) throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException, IllegalIDException,
        		InvalidMonthException {

            // create object and add it to stock but includes additional information.
            // check for any exceptions.
            if (illegalNumberOfBeanBagsAddedCheck(num) == false) {
            throw new IllegalNumberOfBeanBagsAddedException("The number to be added is less than 1.");
        		}
            if (checkId(id) == false) {
                throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
            }
            if (month < 1 || month > 12) {
                throw new InvalidMonthException("The month is not in the range 1 to 12.");
            }

            // check if bean bag is currently already in list
            boolean beanbagExist = false;
            for (int i = 0; i < currentStock.size(); i++) {
                // for every item in stock
                BeanBag item = (BeanBag) currentStock.get(i);
                if (id == item.getId()) { 
                    // same id = same manufacturer, name, free text
                    if (manufacturer == item.getManufacturer() && name == item.getName() && information == item.getText()) { 
                        //check if current beanBag exists in the stock
                        beanbagExist = true;
                        // increase item
                        item.setNum(item.getNum()+1);
                    } else {
                        throw new BeanBagMismatchException("The ID does not match information entered.");
                    }
                }
            }
            if (beanbagExist == false) {
                // if the bean bag does not exist, it is created.
                BeanBag testBag = new BeanBag(num, manufacturer, name, id, year, month, information);
                currentStock.add(testBag);
            }
        }

		 /**
        Method to set the price of bean bags with matching ID in stock .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param id ID of bean bags
        @param priceInPence bean bag price in pence
        @throws InvalidPriceException if the priceInPence < 1
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        */
		
		@Override
    public void setBeanBagPrice(String id, int priceInPence)
    throws InvalidPriceException, BeanBagIDNotRecognisedException, IllegalIDException {
        boolean beanbagFound = false;
				// check if inputed id is valid.
        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
        }
				// check if input price is possitive
        if (priceInPence < 1) {
            throw new InvalidPriceException("Price cannot be less than 1!");
        }

        // modify the price of an existing bean bag.
        for (int i = 0; i < currentStock.size(); i++) {
            BeanBag item = (BeanBag) currentStock.get(i);
            if (id == item.getId()) {
                item.setPrice(priceInPence);
                beanbagFound = true;
            }
        }
		// is ran if the ID is valid but couldnt not be found in current store.
		// the value for reserved items is changed if the value becomes lower
		if (beanbagFound == false) {
            throw new BeanBagIDNotRecognisedException("The ID does not match any bean bag.");
        }
    }
		
		/**
        Method sells bean bags with the corresponding ID from the store and removes
        the sold bean bags from the stock .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param num number of bean bags to be sold
        @param id ID of bean bags to be sold
        
        @throws BeanBagNotInStockException if the bean bag has previously been in
        stock , but is now out of stock
        
        @throws InsufficientStockException if the bean bag is in stock , but not
        enough are available (i.e. in stock and not reserved )
        to meet sale demand
        
        @throws IllegalNumberOfBeanBagsSoldException if an attempt is being made to
        sell fewer than 1 bean bag
        
        @throws PriceNotSetException if the bag is in stock , and there is sufficient
        stock to meet demand , but the price has yet to be set
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        */

		@Override
    public void sellBeanBags(int num, String id) throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsSoldException, PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {

        boolean beanbagFound = false;
        boolean notInStock = false;

        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
        }
				// check if beanbag quantity is valid.
        if (num < 1) {
            throw new IllegalNumberOfBeanBagsSoldException("You cannot sell less than one item.");
        }
				//if inputs are valid
        else {
            for (int i = 0; i < currentStock.size(); i++) {
                // for every item in stock
                BeanBag item = (BeanBag) currentStock.get(i);
                if (id == item.getId()) {
                    beanbagFound = true;
										// checks if price is set on beanbag
                    if (item.getPrice() == 0) {
                    throw new PriceNotSetException("Price has not been set.");
                    }
										// checks  if requested beanbags is more than in stock
                    else if (item.getNum() < num) {
                        throw new InsufficientStockException("BeanBag has insufficient stock.");
                    // if beanbag object has quantity of 0
                    } else if (item.getNum() == 0){
                        throw new BeanBagNotInStockException("Selected beanbag not in stock.");
                    }
                    else if (item.getNum() >= num){
                        int newNum = item.getNum() - num;
                        item.setNum(newNum);
                        BeanBag dupItem = item.copy();
                        dupItem.setNum(num);
                        soldStock.add(dupItem);
                    }
                }
            }
        }
				// throws error if inputs were valid but not found.
        if (beanbagFound == false) {
            throw new BeanBagIDNotRecognisedException("The ID does not match any bean bag.");
        }
    }

			/**
        Method reserves bean bags with the corresponding ID in the store and returns
        the reservation number needed to later access the reservation
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .

        @param num number of bean bags to be reserved
        @param id ID of bean bags to be reserved
        @return unique reservation number , i.e. one not currently live
        in the system
        
        @throws BeanBagNotInStockException if the bean bag has previously been in
        stock , but is now out of stock
        
        @throws InsufficientStockException if the bean bag is in stock , but not
        enough are available to meet the reservation demand
        
        @throws IllegalNumberOfBeanBagsReservedException if the number of bean bags
        requested to reserve is fewer than 1
        
        @throws PriceNotSetException if the bag is in stock , and there is sufficient
        stock to meet demand , but the price has yet to be set
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
      */

		@Override
    public int reserveBeanBags(int num, String id)
    throws BeanBagNotInStockException, InsufficientStockException,IllegalNumberOfBeanBagsReservedException,
    PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {
				// Flag to check if bean bag is found
        boolean beanbagFound = false;
				// 
        int reservationID = 0;

        if (num < 1) {
            throw new IllegalNumberOfBeanBagsReservedException("Can only reserve greater than 0 bean bags");
        }
        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
        }
        // intitally checks for exceptions then loops again to reserve bean bag safetly.
        for (int i = 0; i < currentStock.size(); i++) {
            // for every item in stock
            BeanBag item = (BeanBag) currentStock.get(i);
            if (id == item.getId()) {

                if (item.getNum() == 0) {
                    throw new BeanBagNotInStockException("The bean bag has previously been in stock, but is now out of stock.");
                } else if (item.getNum() < num) {
                    throw new InsufficientStockException("The bean bag is in stock, but not enough are available to meet the reservation demand.");
                } else if (item.getPrice() == 0) {
                    throw new PriceNotSetException("Price has not yet been set.");
                } else {
                    beanbagFound = true;
                }
            }
        }

        if (beanbagFound == false) {
            throw new BeanBagIDNotRecognisedException("The ID is legal , but does not match any bag in (or previously in) stock");
        } else {
            for (int i = 0; i < currentStock.size(); i++) {
                BeanBag dupItem;
                BeanBag item = (BeanBag) currentStock.get(i);
                if (id == item.getId()) {
                    // find difference in quantity, update current stock quantity.
                    int newNum = item.getNum() - num;
                    item.setNum(newNum);
                    // duplicate item, modify quantity, add to reserve stock.
                    dupItem = item.copy();
                    dupItem.setNum(num);
                    reserveStock.add(dupItem);
                    reservationNumber++;
                    reservationID = reservationNumber;
                    dupItem.setReservation(reservationID);
                    return reservationID;
                }
            }
        }
        if (reservationID != 0) {
            return reservationID;
        } else {
            throw new BeanBagIDNotRecognisedException("The ID is legal, but does not match any bag in (or previously in) stock");
        }
    }

		 	/**
        Method removes an existing reservation from the system due to a reservation
        cancellation ( rather than sale ). The stock should therefore remain unchanged .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown.
        
        @param reservationNumber reservation number
        
        @throws ReservationNumberNotRecognisedException if the reservation number
        does not match a current reservation in the system
        */

		@Override
    public void unreserveBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {

        int beanBagNum = 0;
        String beanBagID = null;

        if (reservationNumberCheck(reservationNumber) == false) {
            throw new ReservationNumberNotRecognisedException("Reservation number does not match a current reservation in the system");
        } else {
            for (int i = 0; i < reserveStock.size(); i++) {
                BeanBag item = (BeanBag) reserveStock.get(i);
                if (reservationNumber == item.getReservation()) {
                    // records quantity and ID of reserved beanbag before removing.
                    beanBagNum = item.getNum();
                    beanBagID = item.getId();
                    reserveStock.remove(item);
                }
            }
            for (int i = 0; i < currentStock.size(); i++) {
                BeanBag item = (BeanBag) currentStock.get(i);
                if (beanBagID == item.getId()) {
                    // adds stock back onto main stock amount.
                    int newNum = item.getNum() + beanBagNum;
                    item.setNum(newNum);
                }
            }
        }
    }

		 /**
        Method sells beanbags with the corresponding reservation number from
        the store and removes these sold beanbags from the stock .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param reservationNumber unique reservation number used to find
        beanbag (s) to be sold
        
        @throws ReservationNumberNotRecognisedException if the reservation number
        does not match a current reservation in the system
        */

    public void sellBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {

        if (reservationNumberCheck(reservationNumber) == false) {
            throw new ReservationNumberNotRecognisedException(
                "Reservation number does not match a current reservation in the system");
        } else {
            for (int i = 0; i < reserveStock.size(); i++) {
                // for every item in stock
                BeanBag item = (BeanBag) reserveStock.get(i);
                if (reservationNumber == item.getReservation()) {
                    int reservePrice = item.getPrice();
                    String checkId = item.getId();
                    for (int j = 0; j < currentStock.size(); j++) {
                        BeanBag currentItem = (BeanBag) currentStock.get(j);
                        if (checkId == currentItem.getId()){
                            int currentPrice = currentItem.getPrice();
                            if (currentPrice < reservePrice){
                                item.setPrice(currentPrice);
																System.out.println(currentPrice);
								break;
																
                            }
                        }
                    }
                    soldStock.add(item);				
                    reserveStock.remove(item);
                }
            }
        }

    }

    /**
        Access method for the number of BeanBags stocked by this BeanBagStore
        ( total of reserved and unreserved stock ).
        
        @return number of bean bags in this store
        */

		@Override
    public int beanBagsInStock() {
        // checks in both stocks for amount of beanbags.
        int itemsInStock = 0; //counter
        for (int i = 0; i < currentStock.size(); i++) {
            BeanBag item = (BeanBag) currentStock.get(i);
            itemsInStock = item.getNum() + itemsInStock;
        }

        for (int i = 0; i < reserveStock.size(); i++) {
            BeanBag item = (BeanBag) reserveStock.get(i);
            itemsInStock = item.getNum() + itemsInStock;
        }
        return itemsInStock;

    }

    /**
        Access method for the number of reserved bean bags stocked by this
        BeanBagStore .
        
        @return number of reserved bean bags in this store
        */

		@Override
    public int reservedBeanBagsInStock() {
        // counter to add all quantities for all bean bags in stock
        int itemsInStock = 0;
        for (int i = 0; i < reserveStock.size(); i++) {
            BeanBag item = (BeanBag) reserveStock.get(i);
            itemsInStock = item.getNum() + itemsInStock;
        }
        return itemsInStock;
    }

    /**
        Method returns number of bean bags with matching ID in stock ( total
        researved and unreserved ).
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param id ID of bean bags
        @return number of bean bags matching ID in stock
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        */

		@Override
    public int beanBagsInStock(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {
        
        // check for beanbags with that id in both reserve stock and main stock
        // get num for each beanbag matching the id
        int quantityCounter = 0; //counter
        boolean beanBagFound = false;

        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
        }
        // checks in reserve stock.
        for (int i = 0; i < reserveStock.size(); i++) {
            BeanBag item = (BeanBag) reserveStock.get(i);
            if (id == item.getId()) {
                quantityCounter = item.getNum() + quantityCounter;
                beanBagFound = true;
            }
        }
        // checks in current stock.
        for (int i = 0; i < currentStock.size(); i++) {
            BeanBag item = (BeanBag) currentStock.get(i);
            if (id == item.getId()) {
                quantityCounter = item.getNum() + quantityCounter;
                beanBagFound = true;
            }
        }

        if (beanBagFound == false) {
            throw new BeanBagIDNotRecognisedException("The ID is legal , but does not match any bag in (or previously in) stock.");
        }

        // returns total quantity.
        return quantityCounter;

    }

    /**
        Method saves this BeanBagStore ’s contents into a serialised file ,
        with the filename given in the argument .
        
        @param filename location of the file to be saved
        
        @throws IOException if there is a problem experienced when trying to save
        the store contents to the file
        */

		@Override
    public void saveStoreContents(String filename) throws IOException {
			try {
                    // intialise file.
                    FileOutputStream f = new FileOutputStream(new File(filename));
                    // create object stream.
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    // write object array lists to file.
                    o.writeObject(currentStock);
                    o.writeObject(reserveStock);
                    o.writeObject(soldStock);
                    // terminate connection.
                    o.close();
                    f.close();        

			} catch (Exception ex) {
					ex.printStackTrace();
                    System.out.println("A problem was experienced when trying to save the store contents to the file.");
			}

    }

    /**
        Method should load and replace this BeanBagStore ’s contents with the
        serialised contents stored in the file given in the argument .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param filename location of the file to be loaded
        
        @throws IOException if there is a problem experienced when trying to load
        the store contents from the file
        
        @throws ClassNotFoundException if required class files cannot be found when
        loading
        */

		@Override
    public void loadStoreContents(String filename) throws IOException, ClassNotFoundException {

            try {

                // open file and create object stream.
                FileInputStream fi = new FileInputStream(new File(filename));
                ObjectInputStream oi = new ObjectInputStream(fi);

                // read objects.
                currentStock = (ObjectArrayList) oi.readObject();
                reserveStock = (ObjectArrayList) oi.readObject();
                soldStock = (ObjectArrayList) oi.readObject();

                oi.close();
                fi.close();

        } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("A problem was experienced when trying to save the store contents to the file.");
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Required class files cannot be found when loading.");
        } 
	}


    /**
        Access method for the number of different bean bags currently stocked by this
        BeanBagStore .
        
        @return number of different specific bean bags currently in
        this store (i.e. how many different IDs represented
        by bean bags currently in stock , including reserved )
        */

        // create an array of IDs that have already been found and if they don't match then add to array, else ignore.
        // return length of array

		@Override
    public int getNumberOfDifferentBeanBagsInStock() {

        // create an array to store all unique IDs of a max length of currentStock.size.
        // in the case that all bean bags are unique, this array will still be large enough.
        String[] stockArray = new String[currentStock.size()];
        int uniqueCounter = 0;

        for (int i = 0; i < currentStock.size(); i++) {
            // if IDs match, they are not added. Else, they will be unique and will be therefore added.
            boolean match = false;
            BeanBag item = (BeanBag) currentStock.get(i);
            String id = item.getId();
            for (int c = 0; c < stockArray.length; c++) {
                if (id == stockArray[c]) {
                    // if matching, not added.
                    match = true;
                }
            }
            // if no match, ID added.
            if (match == false) {
                stockArray[i] = id;
            }
        }
        // check for how many unique IDs have been entered into the list.
        for (int i = 0; i < stockArray.length; i++) {
            if (stockArray[i] != null) {
                uniqueCounter++;
            }
        }

        return uniqueCounter;
    }

    /**
        Method to return number of bean bags sold by this BeanBagStore .
        
        @return number of bean bags sold by the store
        */

		@Override
    public int getNumberOfSoldBeanBags() {

        int soldBeanBags = 0; //counter
        // loop through sold stock, add quantity to counter.
        for (int i = 0; i < soldStock.size(); i++) {
            BeanBag item = (BeanBag) soldStock.get(i);
            int sold = item.getNum();
            soldBeanBags = soldBeanBags + sold;
        }

        return soldBeanBags;
    }

    /**
        Method to return number of bean bags sold by this BeanBagStore with
        matching ID.
        <p>
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param id ID of bean bags
        @return number bean bags sold by the store with matching ID
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        */

		@Override
    public int getNumberOfSoldBeanBags(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        int soldCounter = 0;
        boolean beanBagFound = false;

        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number");
        }
        // loop through sold stock, add quantity to counter.
        for (int i = 0; i < soldStock.size(); i++) {
            BeanBag item = (BeanBag) soldStock.get(i);
            // if id matches item id.
            if (id == item.getId()) {
                soldCounter = item.getNum() + soldCounter;
                beanBagFound = true;
            }
        }

        if (beanBagFound == false) {
            throw new BeanBagIDNotRecognisedException("the ID is legal, but does not match any bag in (or previously in) stock");
        }

        return soldCounter;

    }

    /**
        Method to return total price of bean bags sold by this BeanBagStore
        (in pence ) , i.e. income that has been generated by these sales ).
        
        @return total cost of bean bags sold (in pence )
        */

		@Override
    public int getTotalPriceOfSoldBeanBags() {

        int priceCounter = 0;

        for (int i = 0; i < soldStock.size(); i++) {
            BeanBag item = (BeanBag) soldStock.get(i);
            // multiply quantity by price for each.
            int price = item.getNum() * item.getPrice();
            priceCounter = priceCounter + price;
        }
				
        return priceCounter;
    }

    /**
        Method to return total price of bean bags sold by this BeanBagStore
        (in pence ) with matching ID (i.e. income that has been generated
        by these sales ).
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param id ID of bean bags
        @return total cost of bean bags sold (in pence ) with
        matching ID
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        */

		@Override
    public int getTotalPriceOfSoldBeanBags(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        int priceCounter = 0;
        boolean beanBagFound = false;

        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number");
        }

        for (int i = 0; i < soldStock.size(); i++) {
            BeanBag item = (BeanBag) soldStock.get(i);
            if (id == item.getId()) {
                // multiply quantity by price for each.
                int price = item.getNum() * item.getPrice();
                priceCounter = priceCounter + price;
                beanBagFound = true;
            }
        }

        if (beanBagFound == false) {
            throw new BeanBagIDNotRecognisedException("the ID is legal, but does not match any bag in (or previously in) stock");
        }

        return priceCounter;

    }

    /**
        Method to return the total price of reserved bean bags in this BeanBagStore
        (i.e. income that would be generated if all the reserved stock is sold
        to those holding the reservations ).
        
        @return total price of reserved bean bags
        */

		@Override
    public int getTotalPriceOfReservedBeanBags() {

        int reservedTotal = 0; //counter

        for (int i = 0; i < reserveStock.size(); i++) {
            // multiply quantity by price for each.
            BeanBag item = (BeanBag) reserveStock.get(i);
            int price = item.getNum() * item.getPrice();
            reservedTotal = reservedTotal + price;
        }

        return reservedTotal;

    }

    /**
        Method to return the free text details of a bean bag in stock . If there
        are no String details for a bean bag , there will be an empty String
        instance returned .
        
        The state of this BeanBagStore must be be unchanged if any exceptions are
        thrown .
        
        @param id ID of bean bag
        @return any free text details relating to the bean bag
        
        @throws BeanBagIDNotRecognisedException if the ID is legal , but does not
        match any bag in (or previously in) stock
        
        @throws IllegalIDException if the ID is not a positive eight character
        hexadecimal number
        */

		@Override
    public String getBeanBagDetails(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        boolean beanBagFound = false;
        String itemText = null;

        if (checkId(id) == false) {
            throw new IllegalIDException("ID is not a positive eight character hexadecimal number.");
        }
        // will only ever need to search in current stock as all reserve items will have the same text.
        for (int i = 0; i < currentStock.size(); i++) {
            BeanBag item = (BeanBag) currentStock.get(i);
            if (id == item.getId()) {
                beanBagFound = true;
                itemText = item.getText();
                if (itemText != null) {
                    return itemText;
                } else {
                    // if no text exists, an empty string will be returned.
                    itemText = "";
                    return itemText;
                }
            }
        }

        if (beanBagFound == false) {
            throw new BeanBagIDNotRecognisedException("ID entered does not match any bag in (or previously in) stock");
        }

        return itemText;
    }

    /**
        Method empties this BeanBagStore of its contents and resets
        all internal counters .
        */
			@Override
    public void empty() {

			reservationNumber = 0;
			// Uses the clear method to empty the stock lists.
			clearFunction(reserveStock);
			clearFunction(soldStock);
			clearFunction(currentStock);
        }
    
    /**
    Method resets the tracking of number and costs of all bean bags sold.
    The stock levels of this BeanBagStore and reservations should
    be unaffected.
    */

		@Override
    public void resetSaleAndCostTracking() {
        for (int i = 0; i < soldStock.size(); i++) {
            BeanBag item = (BeanBag) soldStock.get(i);
            // reset number and price of each sold bean bag.
            item.setNum(0);
            item.setPrice(0);
        }
    }
		
    /**
    Method replaces the ID of current stock matching the first argument with the
    ID held in the second argument . To be used if there was e.g. a data entry
    error on the ID initially entered . After the method has completed all stock
    which had the old ID should now have the replacement ID ( including
    reservations ) , and all trace of the old ID should be purged from the system
    (e.g. tracking of previous sales that had the old ID should reflect the
    replacement ID ).
    
    If the replacement ID already exists in the system , this method will return
    an { @link IllegalIDException }.
    
    @param oldId old ID of bean bags
    @param replacementId replacement ID of bean bags
    
    @throws BeanBagIDNotRecognisedException if the oldId does not match any
    bag in (or previously in) stock
    
    @throws IllegalIDException if either argument is not a positive eight
    character hexadecimal number , or if the
    replacementID is already in use in the store as
    an ID
    */

		@Override
    public void replace(String oldId, String replacementId) throws BeanBagIDNotRecognisedException, IllegalIDException {
        
        boolean beanBagFound = false;
        // checks for both IDs
        if (checkId(oldId) == false) {
            throw new IllegalIDException("Old ID is not a positive eight character hexadecimal number.");
        }

        if (checkId(replacementId) == false) {
            throw new IllegalIDException("Replacement ID is not a positive eight character hexadecimal number.");
        }
        // replaces ID in each stock type.
        for (int i = 0; i < currentStock.size(); i++) {
            BeanBag item = (BeanBag) currentStock.get(i);
            if (replacementId == item.getId()) {
                throw new IllegalIDException("ID is already being used!");
            } else if (oldId == item.getId()) {
                // set new ID
                item.setId(replacementId);
                beanBagFound = true;
            }
        }

        for (int i = 0; i < reserveStock.size(); i++) {
            BeanBag item = (BeanBag) reserveStock.get(i);
            if (replacementId == item.getId()) {
                throw new IllegalIDException("ID is already being used!");
            } else if (oldId == item.getId()) {
                // set new ID
                item.setId(replacementId);
                beanBagFound = true;
            }
        }

        for (int i = 0; i < soldStock.size(); i++) {
            BeanBag item = (BeanBag) soldStock.get(i);
            if (replacementId == item.getId()) {
                throw new IllegalIDException("ID is already being used!");
            } else if (oldId == item.getId()) {
                // set new ID
                item.setId(replacementId);
                beanBagFound = true;
            }
        }

        if (beanBagFound == false) {
            throw new BeanBagIDNotRecognisedException("Old ID entered does not match any bag in (or previously in) stock");
        }

    }

}