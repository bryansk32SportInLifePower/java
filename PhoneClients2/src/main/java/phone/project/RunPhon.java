package phone.project;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.*;

public class RunPhon {
    Scanner sc = new Scanner(System.in);
    Phone phone = new Phone();

    private void mainMenu() {
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить клиента");
        System.out.println("2. Добавить номер клиенту");
        System.out.println("3. Найти клиента по имени");
        System.out.println("4. Найти номер ");
        System.out.println("5. Удалить клиента");
        System.out.println("6. Удалить номер");
        System.out.println("7. Выйти из программы");
    }

    private String getUsersAnswers(final String question) {
        System.out.println(question);
        String ansver;
        try {
            ansver = sc.nextLine();
        } catch (NoSuchElementException e) {
            ansver = "";
            System.out.println(e.getMessage());
        }
        return ansver;
    }

    public RunPhon() {
        runEx();
    }

    private void runEx() {
        int userChoiche = 666;
        while (userChoiche != 7) {
            mainMenu();
            try {
                userChoiche = sc.nextInt();
                sc.nextLine();
                switch (userChoiche) {
                    case 1:
                        addNewClientExec();
                        break;
                    case 2:
                        addNewNumberToClientExec();
                        break;
                    case 3:
                        findClientExec();
                        break;
                    case 4:
                        findNumberExec();
                        break;
                    case 5:
                        deleteClientExec();
                        break;
                    case 6:
                        deleteNumberExec();
                        break;
                }
            } catch (InputMismatchException | PrimerException exc) {
                System.out.println(exc.getMessage());
                userChoiche = 0;
            }
        }
    }

    private void deleteNumberExec() {
        Client client = findClient();

        if (client == null) {
            System.out.println("Клиент с таким именем не найден.");
        } else {
            String num = getUsersAnswers("Введите номер телефона");

            Numbers numbers = client.getNumber(num);
            if (numbers == null) {
                System.out.println("Такой номер  не найден.");
            } else {
                client.deleteNumber(num);
                System.out.println("Номер удален.");
            }
        }
    }



    private void deleteClientExec() {
        Client client=findClient();
        if (client==null){
            System.out.println("Client not found");
        }else {
            phone.deleteClient(client);
            System.out.println("Client remove");
        }
    }

    private void findNumberExec() {
        String nuberForClient=getUsersAnswers("Vvedite nomer");
        for (Client client:phone.getClients()){
            for (Numbers numbers:client.getNumbers()){
                if (numbers.getName().equalsIgnoreCase(nuberForClient)){
                    System.out.println("Client "+client.getId()+" "+numbers.toString()+ numbers.getName());
                }
            }
        }

    }
    private Numbers aaNewNumbers(){
        String numbe=getUsersAnswers("Vvedite nomer");
        Numbers numbers=new Numbers(numbe);
        return numbers;
}
    private void addNewNumberToClientExec() throws PrimerException {
Client client=findClient();
if (client==null){
    System.out.println("Клиент с таким именем есть");
}else {
    Numbers numb=aaNewNumbers();
    client.addNumber(numb);
    System.out.println("Номер добавлен");
}
    }

    private Client findClient() {
        String clientName=getUsersAnswers("Введите имя клиента");
        return phone.getClient(clientName);
    }

    private void addNewClientExec () {
        String id;
        Client client;
        do{
            id=getUsersAnswers("Vvedite imz");
        }while (id.equals(""));
        client=new Client(id);
        phone.addClient(client);
        System.out.println("Client add");
    }
    private void findClientExec() {
        Client client=findClient();
        if (client==null){
            System.out.println("Кдиент не найден");
        }else {
            System.out.println("Клиент найден "+client.getId());
            for (Numbers numbers:client.getNumbers()) {
                System.out.println(numbers.toString()+ " - "+numbers.getName());
            }
            System.out.println("Поиск окончен");
        }
    }
    public static void main(String[] args) {
        new RunPhon();
    }
}