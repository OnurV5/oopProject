import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 *  Kullanıcı girişiyle ilgili her şeyi içinde tutar.
 */
public class User{
    static int ID = 0;
    int filesize = 100000;
    Scanner input = new Scanner(System.in);
    static int UserID = 0;

    /**
     * @default: 100
     * @return Anlık dosya/dizi boyutu
     */
    public int getFilesize(){
        return filesize;
    }

    /**
     *
     * @return En son kullanıcının ID si
     */
    public int getID(){
        return ID;
    }

    /**
     * ID ile belirli bir kullancıyı aramak için kullanılır
     * @param IDgiven Kullanıcı ID si
     * @return Kullanıcının bilgilerini içeren bir dizi döndürür
     */
    public String[] getUser(int IDgiven){
        String[] userinfo = new String[8];
        if(IDgiven > ID){
            System.out.println("Given ID is too big. Error: " + IDgiven);
            return null;
        }else{
            for(int i = 0; i < ID; i++){
                if(Objects.equals(users[i][0], String.valueOf(IDgiven))){
                    userinfo = users[i];
                    return userinfo;
                }
            }
            System.out.println("Searched user not found. Error: " + IDgiven);
            return null;
        }
    }

    /**
     * Kullanıcı adı veya email ile belirli bir kullanıcıyı aramak için kullanılır
     * @param info Kullanıcı adı veya email
     * @return Kullanıcının bilgilerini döndüren bir dizi döndürür
     */
    public String[] getUser(String info){
        String[] userinfo = new String[8];
        for(int i = 0; i < ID; i++){
            if(Objects.equals(users[i][1], info) || Objects.equals(users[i][4], info) || Objects.equals(users[i][5], info)){
                userinfo = users[i];
                return userinfo;
            }
        }
        System.out.println("Searched user not found. Error: " + info);
        return null;
    }


    /** @[ID][0] Kullanıcının "ID bilgisini" tutar
     *  @[ID][1] Kullanıcının "Kullanıcı adını" tutar
     *  @[ID][2] Kullanıcının "şifresini" tutar
     *  @[ID][3] Kullanıcının "adını" tutar
     *  @[ID][4] Kullanıcının "mailini" tutar
     *  @[ID][5] Kullanıcının "telefon numarasını" tutar
     *  @[ID][6] Kullanıcının "adresini" tutar
     *  @[ID][7] Kullanıcının "cinsiyetini" tutar
     */
    String[][] users = new String[filesize][8];


//    public User(String username,String name, String password, String email,
//                 String phone, String address, String gender) throws IOException {
//        this.username = username;
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//        this.address = address;
//        this.gender = gender;
//    }

    /**
     * Constructer
     */
    public User() {}

    /**
     *
     * @return Tüm kullanıcıların içinde bulunduğu bir dizi döndürür
     */
    public String[][] getUserarray() throws IOException {
        Files("Read");
        String[][] temp = new String[ID][8];
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                temp[i][j] = users[i][j];
            }
        }
        return temp;
    }

    /** Dosyaya yazma veya dosyadan diziye atma işlemlerini yapar
     * @param operation Okuma işlemi için "Read", yazma işlemi için "Write", ID hesaplamak için de "IDcalc"
     *  */
    private void Files(String operation) throws IOException {
        File userinfo = new File("UserInfo");

        if (userinfo.createNewFile()) {

        }
        BufferedReader reader1 = new BufferedReader(new FileReader(userinfo));
        reader1.mark(10000);
        if(Objects.equals(operation, "Read")){
            Files("IDcalc");
            for(int i = 0; i<ID; i++){
                String line = reader1.readLine();
                for(int j = 0; j<8; j++){
                    String[] linearray = line.split("/");
                    users[i][j] = linearray[j];
                }
            }
            reader1.reset();
        }else if(Objects.equals(operation, "Write")){
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(userinfo,true));
            writer1.write(ID + "/" + users[ID][1] + "/" + users[ID][2] + "/"
                    + users[ID][3] + "/" + users[ID][4] + "/"
                    + users[ID][5] + "/" + users[ID][6] + "/" + users[ID][7]);
            writer1.newLine();
            writer1.flush();
            writer1.close();
        }else if(Objects.equals(operation, "IDcalc")){
            BufferedReader reader = new BufferedReader(new FileReader(userinfo));
            String linetemp = reader.readLine();;
            int linecount = 0;
            while (linetemp != null){
                linetemp = reader.readLine();
                linecount++;
            }
            reader.close();
            ID = linecount;
            //System.out.println("ID calculated: " + ID); //for control purposes
        }
    }

    /** @param loginname Kullancının verdiği kullanıcı adına geçen veri
     *  @param password Kullancının verdiği şifre yerine geçen veri
     *  @return Kullanıcının girişinin onaylanıp onaylanmadığını gösterir
     *  */
    private boolean Login(String loginname, String password) throws IOException {
        Files("Read");
        for(int i = 0; i<ID; i++){
            if((users[i][1].equals(loginname) || users[i][3].equals(loginname)
                    || users[i][4].equals(loginname) || users[i][5].equals(loginname))&& users[i][2].equals(password)){
                UserID = Integer.parseInt(users[i][0]);
                return true;
            }
        }
        return false;
    }

    /** Kullanıcın programın başında ilk göreceği ekran. Herhangi bir kaydı
     * olup olmadığını sorar; varsa giriş ekranına yoksa kayıt ekranına gönderir.
     * @return Giriş yapan veya kaydolan kullanıcının ID sini döndürür.
     *  */
    public int loginorregister() throws IOException {
        Files("IDcalc");
        //System.out.println(ID); //for control purposes
        Files("Read");
        System.out.println("Do you want to log in or register? L or R");
        char answer = input.next().toUpperCase().charAt(0);
        if(answer == 'L'){
            return loginscreen();
        }else{
            register();
            return -1;
        }
    }

    /** Giriş yapma ekranını başlatır
     *  */
    private int loginscreen() throws IOException {
        System.out.println("Please enter your username, your email, your name or your phone number: ");
        String nickname = input.nextLine();
        nickname = input.nextLine();
        System.out.println("Please enter your password: ");
        String passcode = input.nextLine();
        return loginattempt(nickname,passcode);
    }

    /** Kullanıcının giriş denemesine göre onaylar ya da kayıt olmaya yönlendirir
     * @param loginname Kullancının verdiği kullanıcı adına geçen veri
     *  @param password Kullancının verdiği şifre yerine geçen veri
     *  */
    private int loginattempt(String loginname, String password) throws IOException {
        Files("Read");
        if(!Login(loginname, password)){
            System.out.println("Your login information is wrong or your account did not exist. Do you want to register? Y or N");
            char answer = input.next().toUpperCase().charAt(0);
            if(answer == 'Y'){
                register();
            }else
                loginorregister();
            return -1;
        }else{
            System.out.println("Your login is successful!");
            return UserID;
        }
    }

    /** Kullanıcıya kayıt formu gönderir
     *  */
    private void register() throws IOException {
        System.out.println("Please enter your new username: ");
        String username2 = input.nextLine();
        username2 = input.nextLine();
        boolean found0 = false;
        for(int i = 0; i < ID; i++){
            if(users[i][1].equals(username2)){
                System.out.println("This user name is already in use. Please enter another user name: ");
                username2 = input.nextLine();
                found0 = true;
                i = -1;
            }
        }
        if (!found0) {
            System.out.println("The username is available.");
        }

        System.out.println("Please enter your password: ");
        String password2 = input.nextLine();
        System.out.println("Please enter your name and surname: ");
        String name2 = input.nextLine();
        System.out.println("Please enter your email: ");
        String mail2 = input.nextLine();
        boolean found1 = false;
        for(int i = 0; i < ID; i++){
            if(users[i][4].equals(mail2)){
                System.out.println("This email is already in use. Please enter another email: ");
                mail2 = input.nextLine();
                found1 = true;
                i = -1;
            }
        }
        if (!found1) {
            System.out.println("The email is available.");
        }


        System.out.println("Please enter your phone number: ");
        String phone2 = input.nextLine();
        boolean found2 = false;
        for(int i = 0; i < ID; i++){
            if(users[i][5].equals(phone2)){
                System.out.println("This phone number is already in use. Please enter another phone number: ");
                phone2 = input.nextLine();
                found2 = true;
                i = -1;
            }
        }
        if (!found2) {
            System.out.println("The phone number is available.");
        }

        System.out.println("Please enter your address: ");
        String address2 = input.nextLine();
        System.out.println("Please enter your gender(if you do not want to enter your gender please write 0): ");
        String gender2 = input.nextLine();
        users[ID][0] = String.valueOf(ID);
        users[ID][1] = username2;
        users[ID][2] = password2;
        users[ID][3] = name2;
        users[ID][4] = mail2;
        users[ID][5] = phone2;
        users[ID][6] = address2;
        users[ID][7] = gender2;
        //System.out.println(users[ID][0]+" "+users[ID][1]+" "+users[ID][2]+" "+users[ID][3]); //for control purposes
//        for(int i = 0; i<ID + 1; i++){
//            for(int j = 0; j<8; j++){
//                System.out.print(users[i][j] + " ");                  //for control purposes
//            }
//            System.out.println();
//        }
        Files("Write");
        Files("Read");
        ID += 1;
        //System.out.println(users[ID][0]+" "+users[ID][1]+" "+users[ID][2]+" "+users[ID][3]); //for control purposes
        loginorregister();
    }
}