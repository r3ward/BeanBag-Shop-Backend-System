public class beanbags //may need to start with a capital letter??????
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
  int num;
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

  public beanBag(beanbags beanBagObject)
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

  // continue creating to access other attributres of the object.
  // also create functions to modify the attributes.



}
