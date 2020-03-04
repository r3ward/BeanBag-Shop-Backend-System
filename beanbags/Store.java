// FILE CREATED TO FILL OUT BADSTORE.JAVA METHODS.
// BADSTORE.JAVA IS UNTOUCHED.

package beanbags;
import java.io.IOException;


/**
 * BadStore is a minimally compiling, but non-functioning implementor of the
 * BeanBagStore interface.
 * 
 * @author Jonathan Fieldsend 
 * @version 1.1
 */
public class Store implements BeanBagStore
{
    public static void main(String[] args) {
        //BeanBag testBag = new BeanBag(1200, "Nike", "Specialé", "1234", (short)20, (byte)01);
        //beanbags.ObjectArrayList.add(testBag);
        addBeanBags(1200, "Nike", "Specialé", "1234", (short)20, (byte)01);
    }
    // remember to remove static - should be 'public void addbeanbags(...)'
    public static void addBeanBags(int num, String manufacturer, String name, 
    String id, short year, byte month)
    throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException,
    IllegalIDException, InvalidMonthException {

        try{
            BeanBag testBag = new BeanBag(num, manufacturer, name, id, year, month);
            // BeanBag testBag = new BeanBag(1200, "Nike", "Specialé", "1234", (short)20, (byte)01);
            beanbags.ObjectArrayList.add(testBag);
        }catch(IllegalNumberOfBeanBagsAddedException e)
        {
            // throw new IllegalNumberOfBeanBagsAddedException
            System.out.println(e.getMessage());
        }catch(BeanBagMismatchException e)
        {
            System.out.println(e.getMessage());
        }catch(IllegalIDException e)
        {
            System.out.println(e.getMessage());
        }catch(InvalidMonthException e)
        {
            System.out.println(e.getMessage());
        }

        // manufacturer = testBag.getManufacturer();
        // name = testBag.getName();
        // id = testBag.getId();
        // num = testBag.getNum();
        // year = testBag.getYear();
        // month = testBag.getMonth();

        // System.out.println(manufacturer);
        // System.out.println(name);
        // System.out.println(id);
        // System.out.println(Integer.toString(num));
        // System.out.println(Integer.toString(year));
        // System.out.println(Integer.toString(month));


        // create object and add it to ObjectArrayList.java
    }

    public void addBeanBags(int num, String manufacturer, String name, 
    String id, short year, byte month, String information)
    throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException,
    IllegalIDException, InvalidMonthException { 
        
        // create object and add it to ObjectArrayList.java BUT include additional information.

    }

    public void setBeanBagPrice(String id, int priceInPence) 
    throws InvalidPriceException, BeanBagIDNotRecognisedException, IllegalIDException { 

        // modify the price of an existing bean bag.
        // change num value for the bean bag.

    }

    public void sellBeanBags(int num, String id) throws BeanBagNotInStockException,
    InsufficientStockException, IllegalNumberOfBeanBagsSoldException,
    PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException { 

        // remove bean bag from ObjectArrayList.java

    }

    public int reserveBeanBags(int num, String id) throws BeanBagNotInStockException,
    InsufficientStockException, IllegalNumberOfBeanBagsReservedException,
    PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException { return 0; }

    public void unreserveBeanBags(int reservationNumber)
    throws ReservationNumberNotRecognisedException { 

        // change boolean reserve value to false for that reservation number.

    }

    public void sellBeanBags(int reservationNumber)
    throws ReservationNumberNotRecognisedException {

        // modify reservation to FALSE as now it has been sold.
        // move out of object array list
        // find out what reservation number is.

     }

    public int beanBagsInStock() { 
        // count how many bean bags in object array list.
        return 0; 
    }

    public int reservedBeanBagsInStock() { 
        // count how many bean bags in object array list taht contain boolean reserved as True.
        return 0;
     }

    public int beanBagsInStock(String id) throws BeanBagIDNotRecognisedException,
    IllegalIDException { 
        // count how many bean bags in stock have a matching id.
        return 0;
     }

    public void saveStoreContents(String filename) throws IOException { 

        // save contents to a txt file.

    }

    public void loadStoreContents(String filename) throws IOException,
    ClassNotFoundException {

        // load contents from txt file and restore the contents, use reader.java

     }

    public int getNumberOfDifferentBeanBagsInStock() { 
        // count how many unique id values in the object array list.
        return 0;
     }

    public int getNumberOfSoldBeanBags() { 
        // potentially use an array to count all of the beanbags that have been removed from the object array list.
        return 0; 
    }

    public int getNumberOfSoldBeanBags(String id) throws
    BeanBagIDNotRecognisedException, IllegalIDException { 
        
        return 0;
     }

    public int getTotalPriceOfSoldBeanBags() { 
        

        return 0;
     }

    public int getTotalPriceOfSoldBeanBags(String id) throws
    BeanBagIDNotRecognisedException, IllegalIDException { return 0; }

    public int getTotalPriceOfReservedBeanBags() { return 0; }

    public String getBeanBagDetails(String id) throws
    BeanBagIDNotRecognisedException, IllegalIDException { 
        
        // return the values of bean bag with the id
        return "";
     }

    public void empty() { }
     
    public void resetSaleAndCostTracking() { }
     
    public void replace(String oldId, String replacementId) 
    throws BeanBagIDNotRecognisedException, IllegalIDException { 

        //find old bean bag with id and set to new bean bag.
    }
}
