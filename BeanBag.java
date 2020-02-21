package inheritance;

public class BeanBag //may need to start with a capital letter??????
{
  public static void main(String[] args){
    String manufacturer, name, text, id;
    int num;
    int year;
    int month;
      // Following statement would create an object testBag
    BeanBag testBag = new BeanBag(1200, "Nike", "Specialé", "1234", 20, 01);
    manufacturer = testBag.getManufacturer();
    name = testBag.getName();
    id = testBag.getId();
    num = testBag.getNum();
    year = testBag.getYear();
    month = testBag.getMonth();

    System.out.println(manufacturer);
    System.out.println(name);
    System.out.println(id);
    System.out.println(Integer.toString(num));
    System.out.println(Integer.toString(year));
    System.out.println(Integer.toString(month));

  }
  // Attributes for a bean bag:
  // -the manufacturer
  // -the bean bag name
  // -the price
  // -an ID number (an eight character string holding a positive hexadecimal number)
  // -the year of manufacture
  // -the month of manufacture
  // -optional free text component

  String manufacturer, name, text, id;
  int num;
  int year;
  int month;

  public BeanBag(int initialNum, String initialManufacturer, String initialName,
  String initialId, int initialYear, int initialMonth){

    num = initialNum;
    manufacturer = initialManufacturer;
    name = initialName;
    id = initialId;
    year = initialYear;
    month = initialMonth;
  }
  /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     *
     * @param beanBagObject The object being copied.
     */

  public BeanBag(BeanBag beanBagObject)
    {
        if (beanBagObject != null)
        {
            manufacturer = beanBagObject.manufacturer;
            num = beanBagObject.num;
            name = beanBagObject.name;
            id = beanBagObject.id;
            year = beanBagObject.year;
            month = beanBagObject.month;
        }
    }

  public String getManufacturer(){
    return manufacturer;
  }

  // continue creating to access other attributres of the object.
  // also create functions to modify the attributes.

  public int getNum(){
    return num;
  }

  public String getName(){
    return name;
  }

  public String getId(){
    return id;
  }

  public int getYear(){
    return year;
  }

  public int getMonth(){
    return month;
  }

  public void setPrice(int newNum) // MAY NOT BE NEEDED
    {
        num = newNum;
    }

  public BeanBag copy()
    {
        return new BeanBag(this);
    }


}
