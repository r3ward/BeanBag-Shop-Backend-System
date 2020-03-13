package beanbags;

import java.io.Serializable;

public class BeanBag implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String manufacturer, name, text, id;
  public int num, price, reservationNumber;
  public short year;
  public byte month;
  
  public BeanBag(int initialNum, String initialManufacturer, String initialName,
  String initialId, short initialYear, byte initialMonth, String initialText){
  
    num = initialNum;
    manufacturer = initialManufacturer;
    name = initialName;
    id = initialId;
    year = initialYear;
    month = initialMonth;
    text = initialText;
    price = 0;
    reservationNumber = 0;
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
            price = beanBagObject.price;
            reservationNumber = beanBagObject.reservationNumber;
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

  public String getText(){
    return text;
  }

  // public boolean getReservationStatus(){
  //   return reserved;
  // }

  public void setPrice(int newPrice) // MAY NOT BE NEEDED
  {
    this.price = newPrice;
  }

  public void setNum(int newNum){
    this.num = newNum;
  }

  public int getPrice(){
    return price;
  }

  public void setReservation(int newReservation){
      this.reservationNumber = newReservation;
  }

  public void setId(String newId){
      this.id = newId;
  }

  public int getReservation(){
    return reservationNumber;
  }

  public BeanBag copy(){
    return new BeanBag(this);
  }
 
}