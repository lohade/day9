import java.util.*;
import java.util.stream.Collectors;


public class Address {
      public ArrayList<PersonInfo>contactlist=new ArrayList<>();
      public static Scanner scanner=new Scanner(System.in);
      public static HashMap<String,ArrayList<PersonInfo>> hashMap=new HashMap<>();
      public static HashMap<String,PersonInfo> cityHashmap=new HashMap<>();
      static Address address=new Address();

      public boolean addContact(PersonInfo details){
          List<PersonInfo> checkByName=searchByName(details.getName());
          for (PersonInfo name:checkByName)
              if (name.equals(details))
                  return false;
          contactlist.add(details);
          return true;
      }

      public List<PersonInfo> searchByName(String name){
          return contactlist.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
      }

      public static void viewByCity(Map<String,PersonInfo> cityHashmap){
          cityHashmap.entrySet().stream().forEach(n -> System.out.println(n.getKey() + "=" +n.getValue().toString()));
      }




     public void  addPerson(){
        PersonInfo personInfo=new PersonInfo();
        System.out.println("Enter name:");
        String name = scanner.next();
        personInfo.setName(name);

        System.out.println("enter surname:");
        String surname= scanner.next();
        personInfo.setSurname(surname);

        System.out.println("Enter email:");
        String email = scanner.next();
        personInfo.setEmail(email);

        System.out.println("Enter address:");
        String address = scanner.next();
        personInfo.setAddress(address);

        System.out.println("Enter phone no:");
        String phone = scanner.next();
        personInfo.setPhone(phone);

            System.out.println("enter zip:");
        String zip= scanner.next();
        personInfo.setZip(zip);

        System.out.println("Enter state:");
        String state = scanner.next();
        personInfo.setState(state);

        System.out.println("Enter city:");
        String city = scanner.next();
        personInfo.setCity(city);

        //return new PersonInfo(name,surname,email,address,phone,zip,state,city);

        contactlist.add(personInfo);
        //System.out.println(list);
     }

     @Override
    public String toString(){
          if(contactlist.isEmpty())
              return "no contact available";
          String show=new String();
          for(int i=0;i<contactlist.size();i++) {
              show += " " + contactlist.get(i);
          }
          return show;



    }


    public  void edit()
    {
        System.out.println("enter email to edit information:");
        String email=scanner.next();
         for (int i=0;i< contactlist.size();i++) {
            if(contactlist.get(i).getEmail().equals(email))
            {
                System.out.println("enter operation to edit:");
                System.out.println("\n1:edit first name:\n2:edit surname:\n3:edit email:\n4:edit address:\n5:edit city:\n6:edit state:\n7:edit zip:\n8:edit phone:\n");
                int edit_option = scanner.nextInt();
                switch (edit_option) {
                    case 1:

                        System.out.println("Enter the firstname to edit::");
                        String edit_name = scanner.next();
                        contactlist.get(i).setName(edit_name);
                        break;

                    case 2:

                        System.out.println("Enter the surname to edit:");
                        String edit_surname = scanner.next();
                        contactlist.get(i).setSurname(edit_surname);
                        break;

                    case 3:
                        System.out.println("enter email to edit:");
                        String edit_email=scanner.next();
                        contactlist.get(i).setEmail(edit_email);
                        break;

                    case 4:
                        System.out.println("enter address to edit:");
                        String edit_address=scanner.next();
                        contactlist.get(i).setAddress(edit_address);
                        break;
                    case 5:
                        System.out.println("enter city to edit:");
                        String edit_city=scanner.next();
                        contactlist.get(i).setEmail(edit_city);
                        break;
                    case 6:
                        System.out.println("enter state to edit:");
                        String edit_state=scanner.next();
                        contactlist.get(i).setState(edit_state);
                        break;
                    case 7:
                        System.out.println("enter zip to edit:");
                        String edit_zip=scanner.next();
                        contactlist.get(i).setZip(edit_zip);
                        break;
                    case 8:
                        System.out.println("enter phone to edit:");
                        String edit_phone=scanner.next();
                        contactlist.get(i).setPhone(edit_phone);
                        break;
                }
            }
            else
                System.out.println("enter valid mail:");
        }
    }

    public void remove()
    {
        System.out.println("enter email to be remove from address book:");
        String email=scanner.next();
        for(int i=0;i<contactlist.size();i++)
        {
            PersonInfo personInfo= contactlist.get(i);
            if(email.equals(personInfo.getEmail()))
            {
                contactlist.remove(personInfo);
                System.out.println(contactlist);
            }
            else{
                System.out.println("enter valid email ");
            }
        }
    }

    public void  duplicate(String email){

         for(int j=0;j<contactlist.size();j++) {
             String email_contact = contactlist.get(j).getEmail();
             if (email.equals(email_contact)) {
                 System.out.println("email is already available");
             }
             else{
                 System.out.println("enter details");
                 break;
             }
         }
     }

     public void search() {
         System.out.println("enter name to search:");
         String name1= scanner.next();
         contactlist.forEach(book ->searchByName(name1).forEach(System.out::println));
      }

      public void view(){
          System.out.println("enter city to view:");
          String city1= scanner.next();
          contactlist.forEach(book ->viewByCity(cityHashmap));
          System.out.println(contactlist);
      }
      public void count(){
          Map<String,Long> countCity=contactlist.stream()
                  .collect(Collectors.groupingBy(c -> c.getCity(),Collectors.counting()));
         System.out.println(countCity + "\n");

         Map<String,Long> countstate=contactlist.stream()
                 .collect(Collectors.groupingBy(s ->s.getState(),Collectors.counting()));
          System.out.println(countstate + "\n");


     }

    public void askUser() {
         boolean view=true;
         do{
            System.out.println("enter choice for operation:");
            System.out.println("1:create address book:\n2:Edit address book:\n3:display all:\n4:Search city in particular book:\n5:find number of records from particular city:\n6:Count person in city and state\n7:exit");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("enter name of book:");
                    String name_book = scanner.next();

                    if (hashMap.containsKey(name_book)) {
                        System.out.println("name is already exist");
                        break;
                    }
                    ArrayList<PersonInfo> new_book = new ArrayList<>();
                    contactlist = new_book;
                    while (true) {
                        System.out.println("Enter choice to do operation like:");
                        System.out.println("1:adding details:\n2:Display whole address:\n3:for edit the details:\n4:to remove data:\n5:duplicate entry:\n6:exit");
                        int option = scanner.nextInt();

                        if (option == 6) {
                            System.out.println("exit ");
                            break;
                        }
                        switch (option) {
                            case 1:
                                address.addPerson();
                                break;

                            case 2:
                                address.toString();
                                break;

                            case 3:
                                address.edit();
                                break;

                            case 4:
                                address.remove();
                                break;

                            case 5:
                                System.out.println("enter mail to duplicate:");
                                String new_mail = scanner.next();
                                address.duplicate(new_mail);
                                break;


                            default:
                                System.out.println("choose valid option");
                                break;

                        }
                        hashMap.put(name_book, contactlist);
                        System.out.println(hashMap);
                    }
                    break;

                case 2:
                    System.out.println("enter address book name for edit:");
                    String edit_book=scanner.next();

                    if(hashMap.containsKey(edit_book)){
                        ArrayList<PersonInfo> old_book=new ArrayList<>();
                        contactlist=old_book;
                        contactlist= hashMap.get(edit_book);
                        boolean status1=true;

                            do {
                                System.out.println("Enter choice to do operation like:");
                                System.out.println("1:adding details:\n2:Display whole address:\n3:for edit the details:\n4:Search particular city in particular book:\n5:Exit");
                                int option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        address.addPerson();
                                        break;

                                    case 2:
                                        address.toString();
                                        break;

                                    case 3:
                                        address.edit();
                                        break;

                                    case 4:
                                        address.remove();
                                        break;

                                    case 5:
                                        status1 = false;
                                        break;

                                }
                                hashMap.put(edit_book,contactlist);
                                System.out.println(hashMap);
                            } while (status1);
                    }
                    else
                        System.out.println("enter valid name book");
                    break;

                case 3:
                    System.out.println(hashMap);
                    break;

                case 4:
                    search();
                    break;

                case 5:
                    address.view();
                    break;

                case 6:
                    System.out.println("find city");
                    String city1=scanner.next();
                    address.count();
                    break;

                case 7:
                    view=false;
                    scanner.close();
                    System.out.println("exit address book:");
                    break;


            }
        }while(view);
    }

    public static void main(String[] args) {
         System.out.println("Welcome to Address book System");
         address.askUser();
    }
}