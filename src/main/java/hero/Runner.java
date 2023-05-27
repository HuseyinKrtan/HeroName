package hero;/*
 Proje:Heroes Management System
     -1-hero ekleme sıstemi.
     -2-Kullanıcı
              C -hero kayıt
              R hero veya heroları görüntüleme
              U -heroname ile hero güncelleme
              D -heroname ile hero silme
       işlemlerini yapabilmeli.
     -3-hero:name,healt,mana özelliklerine sahiptir.
 */

public class Runner {
    public static void main(String[] args) {
        start();





    }

    private static void start() {

        //6-hero service de tablo olusturma
        HeroService service=new HeroService();
        service.createHeroTable();
        int select;
        //7-sadece menuyu sout'larla yazdık methodları teker teker olusturacagız
       do {


        System.out.println("===============================================================");
        System.out.println("======================== WELCOME ==============================");
        System.out.println("===============================================================");
        System.out.println("Hero kayıt sistemine hosgeldiniz...");
        System.out.println("1-->Yeni Hero kayıt.... ");
        System.out.println("2-->Heroları guruntuleme......");
        System.out.println("3-->Hero name ile Hero guncelleme.....");
        System.out.println("4-->Hero name ile Hero silme.... ");
        System.out.println("0-->CIKIS....");
        select=Depo.input.nextInt();

        switch (select){

            case 1: ;
                service.saveHeroes();
                break;
            case 2:
                service.getAllHeroes();
                break;
            case 3:
                service.updateHero();
                break;
            case 4:
                service.deleteHero();
                break;
            case 0:
                System.out.println("İyi günler dileriz");
                System.exit(0);
            default:
                System.out.println("Hatali giriş");
                break;

        }
       }while (select!=0);


    }


}
