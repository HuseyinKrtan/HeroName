package hero;

public class HeroService {

    //herosRepository sınıfının methodlarını kullanabılmek icin obje olusturalım
   private HerosRepository repo = new HerosRepository();

   //5-Hero icin tablo olusturma
    public  void createHeroTable(){
        repo.createTable();
    }


    //8-hero'yu kayıt etme
    public void saveHeroes(){
        System.out.println("Hero'nun adını giriniz..");
        String name=Depo.input.next().trim();
        System.out.println("Hero'nun can degerını gırınız..");
        int healt=Depo.input.nextInt();
        System.out.println("Hero'nun mana degerini giriniz..");
        int mana = Depo.input.nextInt();
        Depo.input.nextLine();
        Heros newheroes=new Heros(name,healt,mana);
        repo.save(newheroes);


    }

    //10-tüm heroları listeleme
    public void getAllHeroes() {
        repo.getAll();

    }

    //12-Hero guncelleme
    public void updateHero() {
        repo.getAll();
        System.out.println("Güncellemek istediginiz Hero'nun adını giriniz...");
        String name=Depo.input.next();
        repo.isEqual(name);
    }


    public void deleteHero() {
        repo.getAll();
        System.out.println("Silmek istediginiz Hero'nun ismini giriniz...");
        String name=Depo.input.next();
        repo.deleteName(name);
    }
}
