# O-O-Pair-Programming
You are to develop a class that implements this interface, and also develop with the necessary additional supporting classes in the Java package called beanbags. The operational correctness of the back-end system will be tested through this provided interface on submission.

This implementor class must be a public class called Store. If it is not, then the front-end system will be unable to compile with your back-end solution, and the operational component of your mark will be 0. You will need to also write any other package members you deem appropriate to support this class and its functionality. All classes developed must reside in the beanbags package.

You should find the ObjectArrayList class useful when maintaining lists of objects in your solution, especially given the package import restrictions of the assignment detailed later. Note that as the ObjectArrayList stores object references declared as the Object type, you will need to employ casting when using its contents.

Specs -

Attributes for a bean bag:
-the manufacturer
-the bean bag name
-the price
-an ID number (an eight character string holding a positive hexadecimal number)
-the year of manufacture
-the month of manufacture
-optional free text component

Reservation System:
-permit reservations to be made
-Reservations can- not be made on bean bags that are currently not in stock

IDs:
-Two bean bags with the same ID must match on name, manufacturer and free text component — and this needs be checked by the system against existing stock to flag up any data entry errors (which can lead to disappointed customers later).

Stock
-the stock of the store includes all products currently on the premises (those
available for immediate sale and those reserved).

Pricing:
If a bean bag is reserved, and prior to it being sold the price is changed, the lowest price the bean bag reaches should be used on selling (i.e. the buyer should be advantaged, not disadvantaged, by any price changes when stock is reserved).
