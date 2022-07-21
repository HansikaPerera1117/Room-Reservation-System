package db;

import model.*;

import java.sql.Array;
import java.util.ArrayList;

public class Database {
    public static ArrayList<SingleRoom> singleRoomTable = new ArrayList<SingleRoom>();
    public static ArrayList<DoubleRoom> doubleRoomTable = new ArrayList<DoubleRoom>();
    public static ArrayList<TripleRoom> tripleRoomTable = new ArrayList<TripleRoom>();
    public static ArrayList<QuadRoom> quadRoomTable = new ArrayList<QuadRoom>();
    public static ArrayList<LocalMealPlan> localMealPlanTable = new ArrayList<LocalMealPlan>();
    public static ArrayList<ChineseMealPlan> chineseMealPlanTable = new ArrayList<ChineseMealPlan>();
    public static ArrayList<FrenchMealPlan> frenchMealPlanTable = new ArrayList<FrenchMealPlan>();
    public static ArrayList<Maintenance> maintenanceTable = new ArrayList<Maintenance>();
    public static ArrayList<Booking> bookingTable = new ArrayList<Booking>();
    public static ArrayList<MonthlyReport> monthlyReportsTable = new ArrayList<MonthlyReport>();
    public static ArrayList<AnnuallyReport> annuallyReportsTable = new ArrayList<AnnuallyReport>();


    static {

        singleRoomTable.add(
                new SingleRoom("Room 01","Single bed, Bedside cupboard, Wardrobe, Dressing table, Table","","")
        );
        singleRoomTable.add(
                new SingleRoom("Room 02","Single bed, Bedside cupboard, Wardrobe, Dressing table, Table","","")
        );
        singleRoomTable.add(
                new SingleRoom("Room 03","Single bed, Bedside cupboard, Wardrobe, Dressing table, Table","","")
        );
        singleRoomTable.add(
                new SingleRoom("Room 04","Single bed, Bedside cupboard, Wardrobe, Dressing table, Table","","")
        );

        doubleRoomTable.add(
                new DoubleRoom("Room 05","Double bed, Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        doubleRoomTable.add(
                new DoubleRoom("Room 06","Double bed, Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        doubleRoomTable.add(
                new DoubleRoom("Room 07","Double bed, Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        doubleRoomTable.add(
                new DoubleRoom("Room 08","Double bed, Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        doubleRoomTable.add(
                new DoubleRoom("Room 09","Double bed, Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        tripleRoomTable.add(
                new TripleRoom("Room 10","Triple bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        tripleRoomTable.add(
                new TripleRoom("Room 11","Triple bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        tripleRoomTable.add(
                new TripleRoom("Room 13","Triple bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        tripleRoomTable.add(
                new TripleRoom("Room 14","Triple bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        tripleRoomTable.add(
                new TripleRoom("Room 15","Triple bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table","","")
        );
        quadRoomTable.add(
                new QuadRoom("Room 16","Quad bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table, Sofa set","","")
        );
        quadRoomTable.add(
                new QuadRoom("Room 17","Quad bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table, Sofa set","","")
        );
        quadRoomTable.add(
                new QuadRoom("Room 18","Quad bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table, Sofa set","","")
        );
        quadRoomTable.add(
                new QuadRoom("Room 19","Quad bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table, Sofa set","","")
        );
        quadRoomTable.add(
                new QuadRoom("Room 20","Quad bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table, Sofa set","","")
        );
        quadRoomTable.add(
                new QuadRoom("Room 21","Quad bed, Two Bedside cupboard, Wardrobe, towel rack, Dressing table, Table, Sofa set","","")
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 1","Milk Rice",150.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 2","Hoppers",100.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 3","String Hoppers",100.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 4","Pittu",75.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 5","Coconut Roti",50.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 6","Fish ambul thiyal",350.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 7","Chicken curry",550.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 8","Polos",240.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 9","Wambatu moju",150.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 10","Sinhala Achcharu",150.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 11","Cashew curry",680.00)
        );
        localMealPlanTable.add(
                new LocalMealPlan("No 12","Coconut sambola",30.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 1","Dim Sums",560.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 2","Quick Noodles",230.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 3","Szechwan Chilli Chicken",840.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 4","Spring Rolls",435.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 5","Stir Fried Tofu with Rice",350.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 6","Chicken with Chestnuts",745.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 7","Honey Chilli Potato",280.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 8","Peri Peri Chicken Satay",1050.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 9","Veg Hakka Noodles",460.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 10","Cantonese Chicken Soup",645.00)
        );
        chineseMealPlanTable.add(
                new ChineseMealPlan("No 11","Mushroom Manchurian",560.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 1","Steak frites",450.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 2","Chicken confit",780.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 3","French onion soup",645.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 4","Bouillabaisse",940.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 5","Salmon en papillote",870.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 6","Croque monsieur",865.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 7","Boeuf bourguignon",1150.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 8","Frangipane tart",975.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 9","Hazelnut dacquoise",1250.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 10","Lamb shank navarin",790.00)
        );
        frenchMealPlanTable.add(
                new FrenchMealPlan("No 11","Cassoulet",990.00)
        );
        maintenanceTable.add(
                new Maintenance("Room 03","Maintenance in bathroom")
        );
        maintenanceTable.add(
                new Maintenance("Room 06","Paint the room")
        );
        maintenanceTable.add(
                new Maintenance("Room 11","Maintenance in A/C")
        );
        maintenanceTable.add(
                new Maintenance("Room 15","Clean the room")
        );
        maintenanceTable.add(
                new Maintenance("Room 17","Maintenance in bed")
        );
        bookingTable.add(
                new Booking("Jayawardhana","12345678957V","Panadura","0711236547","jayawardhana@gmail.com","Room No 08","Local meals","3 days")
        );
        bookingTable.add(
                new Booking("Karunarathna","45678912304V","Colombo","0754698772","karunarathna123@gmail.com","Room No 12","French meals","1 night")
        );
        bookingTable.add(
                new Booking("Rathnayaka","78912304536V","Gall","0773648552","rathnayaka189@gmail.com","Room No 05","Local meals","2 weeks")
        );
        bookingTable.add(
                new Booking("Gunapala","42536987102V","Panadura","0703482006","gunapala1347@gmail.com","Room No 09","Chinese meal","5 days")
        );
        monthlyReportsTable.add(
                new MonthlyReport("Year 2022 January","Food Income",12150.00)
        );
        monthlyReportsTable.add(
                new MonthlyReport("January","Room Income",54060.00)
        );
        monthlyReportsTable.add(
                new MonthlyReport("Total of January"," ",66210.00 )
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2018","Food Income","56548154.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2018","Room Income","78984562.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("Total of year 2018","","135,532,716.00 ")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2019","Food Income","69456546.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2019","Room Income","85478120.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("Total of year 2019","","154,934,666.00 ")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2020","Food Income","42985750.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2020","Room Income","82690706.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("Total of year 2020","","125,676,456.00 ")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2021","Food Income","103456875.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("2021","Room Income","98654750.00")
        );
        annuallyReportsTable.add(
                new AnnuallyReport("Total of year 2021","","202,111,625.00 ")
        );

    }

}
