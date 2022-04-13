public class Main {
    public static void main(String args[]){
        MageRepository mr = new MageRepository();
        MageController mc = new MageController(mr);
        System.out.println(mc.save("Julia","99"));
        System.out.println(mc.delete("Julia"));
        System.out.println(mc.delete("sdf"));
        System.out.println(mc.save("Julia","50"));
        System.out.println(mc.find("Julia"));
    }
}
