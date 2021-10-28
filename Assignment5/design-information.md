Assignment 5

-The User class has name and id attribute and has createList, editList,deleteList and search List method. A user can create a list, remove item or quantity of the list, delete the list, and search item in the List. 

-The ListOfItem has GrocerryList as an attribute and addItem(item), editItem(item), deleteItem(item), checkOffItem(item), clearCheckOffMarks(). An item can be added to the list, edit the quantity of the item, delete the item, check off items in a list, clear all the check-off marks in a list at once, and The relationship between the user and the ListOfItem is "has a". The user has a ListOfItem.

-TypeofList class type as an attribute and addListType as a method. The addListType take the type of such as weekly, monthly etc and the item and added to the listofItem. ListOfItem "has a" type of List.

-ItemType has type as an attribute and creatNewItem and getItem as method. The getItem will add the item to the list and also show similar item to the user. If the item does not exist, the createNewItem will take the type and item and add to the database. The relationship between the ItemType and ListOfItem is "is entirely made of".

-The Item has Name, quantity, itemType and isChecked as attribute and quantity() and locationOfItem(). The quantity() method will return the stock quantity of a specific item and actual position of the item so that users can shop for a specific type of products at once. The item 'has' a itemType.

After adding item, quantity of the items are updated automatically


