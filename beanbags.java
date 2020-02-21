public class BeanBags //may need to start with a capital letter??????
{
  // Attributes for a bean bag:
  // -the manufacturer
  // -the bean bag name
  // -the price
  // -an ID number (an eight character string holding a positive hexadecimal number)
  // -the year of manufacture
  // -the month of manufacture
  // -optional free text component

  String manufacturer, name, text, id;
  int num;    // price
  short year;
  byte month;

  public beanBag(int initialNum, String initialManufacturer, String initialName,
  String initialId, short initialYear, byte initialMonth){
    
    num = initialNum
    manufacturer = initialManufacturer
    name = initialName
    id = initialId
    year = initialYear
    month = initialMonth
  }
  /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     *
     * @param beanBagObject The object being copied.
     */

  public beanBag(BeanBags beanBagObject)
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
    return manufacturer
  }

  public int getNum():{
    return num
  }

  public String getName(){
    return name
  }

  public String getId(){
    return id
  }

  public short getYear(){
    return year
  }

  public byte getMonth(){
    return month
  }

  public void setPrice(int newNum) // MAY NOT BE NEEDED
    {
        num = newNum;
    }
}
