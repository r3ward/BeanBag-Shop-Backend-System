class Main {
    public static void main(String[] args) {
        try {

            beanbags.Store so = new beanbags.Store();
            so.addBeanBags(1200, "Nike", "Specialé", "23412134", (short) 20, (byte) 1, "hello cunts");
            so.addBeanBags(1200, "Nike", "Specialé", "23412174", (short) 20, (byte) 1, "hello cunts");
            so.addBeanBags(1200, "Nike", "Specialé", "23416174", (short) 20, (byte) 1, "hello cunts");
            so.addBeanBags(1200, "Nike", "Specialé", "23432114", (short) 20, (byte) 1, "hello cunts");
            so.addBeanBags(1200, "Nike", "Specialé", "23432114", (short) 20, (byte) 1, "hello cunts");
            so.addBeanBags(1200, "Nike", "Specialé", "24432114", (short) 20, (byte) 1, "hello cunts");
            so.addBeanBags(1200, "Nike", "Specialé", "63432114", (short) 20, (byte) 1, "hello cunts");
						so.setBeanBagPrice("23432114", 13);
            int reservId = so.reserveBeanBags(2, "23432114");
						so.setBeanBagPrice("23432114", 8);
						so.sellBeanBags(reservId);


            
            so.sellBeanBags(3, "23412174");
            // int precost = so.getTotalPriceOfSoldBeanBags();
            // int presales = so.getNumberOfSoldBeanBags();
            // System.out.println(precost);
            // System.out.println(presales);
            // so.replace("23412174", "23437114");
            // String poo = so.getBeanBagDetails("23437114");

            int precosty = so.getNumberOfDifferentBeanBagsInStock();
            System.out.println("INITIAL : " + precosty);
            so.saveStoreContents("output.ser");
            so.empty();
            int precost = so.getNumberOfDifferentBeanBagsInStock();
            System.out.println("EMPTY : " + precost);
            so.loadStoreContents("output.ser");
            // String poo = so.getBeanBagDetails("23437114");
            // System.out.println(poo);
            int precosti = so.getNumberOfDifferentBeanBagsInStock();
            System.out.println("FINAL : " + precosti);
            // so.setBeanBagPrice("63432114", 134);
            // so.sellBeanBags(22, "23432114");
            so.addBeanBags(1200, "Nike", "Specialé", "24432114", (short) 20, (byte) 1, "hello cunts");
            
            //int reservNum = so.reserveBeanBags(1, "33333422");
            // int reservNumy = so.reserveBeanBags(1, "33333422");
            // int reservNumyb = so.reserveBeanBags(1, "33333422");
        
            //so.sellBeanBags(reservNumy);
            // so.sellBeanBags(2, "33333422");
            // int value = so.getTotalPriceOfSoldBeanBags();
            // int test = so.getNumberOfSoldBeanBags();
            // beanbags.so.addBeanBags(1200, "Jordan's", "Specialé", "134", (short) 20, (byte) 1);
            // beanbags.so.addBeanBags(1200, "Adidas", "Boost", "124", (short) 20, (byte) 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}