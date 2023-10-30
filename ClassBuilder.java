import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ClassBuilder 
{

            //FIELDS
        private ArrayList<Class> optionList;
        //private ArrayList<ArrayList<Class>> classList;
        //private int index = 0;


            //CONSTRUCTOR
    public ClassBuilder() throws FileNotFoundException
    {
        //classList = new ArrayList<ArrayList<Class>>();
        optionList = new ArrayList<Class>();
       //ArrayList<Class> optionList = new ArrayList<Class>();
            File allClasses = new File("classNames.csv");
            Scanner classFileScanner = new Scanner(allClasses);
            while (classFileScanner.hasNext())
            {
                // if(!optionList.isEmpty())
                // {
                //     classList.add(optionList);
                //     optionList.clear();
                // }
                String uploadingClass = (classFileScanner.nextLine());
                File eachClass = new File(uploadingClass);
                Scanner eachClassScanner = new Scanner(eachClass);
                while (eachClassScanner.hasNext())
                {
                    Scanner individualTimes = new Scanner(eachClassScanner.nextLine());
                    individualTimes.useDelimiter(", ");
                    while (individualTimes.hasNext())
                    {
                        String className = individualTimes.next();
                        // System.out.println(className);
                        //System.out.println(individualTimes.next());
                        double startTime = individualTimes.nextDouble();
                        // System.out.println(startTime);
                        double endTime = individualTimes.nextDouble();
                        // System.out.println(endTime);
                        String location = individualTimes.next();
                        // System.out.println(location);
                        String teacher = individualTimes.next();
                        // System.out.println(teacher);
                        //System.out.println(individualTimes.next());

                        boolean mon;
                        boolean tue;
                        boolean wed;
                        boolean thu;
                        boolean fri;

                        if(individualTimes.next().equalsIgnoreCase("mon"))
                        {
                            mon = true; 
                            // System.out.println(mon);
                        }
                        else
                        {
                            mon = false;
                        }
                        if(individualTimes.next().equalsIgnoreCase("tue"))
                        {
                            tue = true;
                        }
                        else
                        {
                            tue = false;
                        // System.out.println(tue);
                        }
                        if(individualTimes.next().equalsIgnoreCase("wed"))
                        {
                            wed = true;
                        // System.out.println(wed);
                        }
                        else
                        {
                            wed = false;
                        }
                        if(individualTimes.next().equalsIgnoreCase("thu"))
                        {
                            thu = true;
                        }
                        else
                        {
                            thu = false;
                        //System.out.println(thu);
                        }
                        if(individualTimes.hasNext())
                        {
                            if(individualTimes.next().equalsIgnoreCase("fri"))
                            {
                                    fri = true;
                                //System.out.println(fri);
                            }
                            else
                            {
                                    fri = false;
                            }
                        }
                        else
                        {
                                fri = false;
                            //System.out.println(fri);
                        }
                        Class pendingClass = new Class(className, startTime, endTime, location, teacher, mon, tue, wed, thu, fri);
                        optionList.add(pendingClass);
                        
                        
                        
                        //System.out.println(individualTimes.next());
                    }
                    
                }
                eachClassScanner.close();
            }
            classFileScanner.close();
            // if(!optionList.isEmpty())
            //     {
            //         classList.add(optionList);
            //         optionList.clear();
            //     }
            System.out.println("Size of OptionList array: " + optionList.size());
            //System.out.println(classList.size());
    }


            //METHODS
    // public ArrayList<Class> getClasses(int index)
    // {
    //     return this.classList.get(index);
    // } 
    public void printSize()
    {
        System.out.println(optionList.size());
    }



                        //Check for duplicates

    private ArrayList<String> uniqueClasses()
    {
        ArrayList<Class> uniqueClasses = new ArrayList<Class>();
        for(Class searchClass : optionList)
        {
            String searchTerm = searchClass.getClassName();
            for(int i=0; i<optionList.size(); i++)            //loops once for every track in the trackList array
            {   
                Class pendingClass = optionList.get(i);
                String pendingClassName = pendingClass.getClassName();
                //System.out.println(pendingTitle);
                if(pendingClassName.contains(searchTerm))
                {
                    boolean duplicate = false;
                    for(int j = 0; j < uniqueClasses.size();j++)
                    {
                        if(pendingClass.getClassName().equals(uniqueClasses.get(j).getClassName()))   //this checks every track in searchResults to avoid duplicates
                        {                                               //(No longer relevent as I changed the search to erase previous 
                            duplicate = true;                           // searches, but is kept for future modification options))
                        }
                    }
                   if(!duplicate)
                    {
                        uniqueClasses.add(pendingClass);                //adds results to track after confirming unique track
                    }
                }
                
            }
        }
        ArrayList<String> uniqueClassName = new ArrayList<String>();
        for(Class printClass : uniqueClasses)
        {
            uniqueClassName.add(printClass.getClassName());
        }
        return uniqueClassName;
    }








    public void printSchedules()
    {
        ArrayList<String> uniqueClasses = uniqueClasses();
        int count = 1;
        //Compares schedules
        ArrayList<Class> successfulSchedule = new ArrayList<Class>();
        
        for(int i=0; i<optionList.size(); i++)
        {
            Class pendingClass = optionList.get(i);
            boolean continueFilter = true;
            for (Class classUploaded : successfulSchedule)
            {            

                if(pendingClass.getClassName().equals(classUploaded.getClassName()))
                {
                    continueFilter = false;               //@TODO fix the logic so it doesn't skip every math option
                    //System.out.println("continueFilter false: " + pendingClass.getClassName());
                }
                //if(continueFilter)
                //{
                    //System.out.println(pendingClass.getClassName() + " and " + classUploaded.getClassName() + "Aren't the same");
                //}
            }
            if(continueFilter)
            {
                boolean addFilter = true;
                for(Class classUploaded : successfulSchedule)
                {
                    if(!Class.compare(classUploaded, pendingClass))
                    {
                        addFilter = false;
                        //System.out.println("addFilter false: " + pendingClass.getClassName());
                    }
                }
                if (addFilter)
                {
                    successfulSchedule.add(pendingClass);
                }
            }


            System.out.println("Schdule Size: " + successfulSchedule.size());
            if((successfulSchedule.size() == uniqueClasses.size()))     //@TODO figure out why Math doesn't have additional options printed
            {
                System.out.println("Option " + count + "\n---------------");
                count += 1;
                for(Class printClass : successfulSchedule)
                {
                    System.out.println(printClass.toString());
                }
            }
        }



















                    
        




        








    }


    public void printSchedulesFailed()
    {
        
        ArrayList<Class> uniqueClasses = new ArrayList<Class>();
        //looks for unique classes
        for (Class pendingClass : optionList)
        {
            
            for(int i = 0; i<uniqueClasses.size(); i++)
            {
               
                boolean duplicate = false;
                if(pendingClass == uniqueClasses.get(i))
                {
                    duplicate = true;
                }
                if (!duplicate)
                {
                    uniqueClasses.add(pendingClass);
                }
                
                for (int j = 0; j < uniqueClasses.size(); j++)
                {
                }
            }
            //System.out.println("Number of unique Classes: " + uniqueClasses.get(0));
            
        }




    }


    
            

        
    











        
    


}
