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
        ArrayList<Class> optionList = new ArrayList<Class>();
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
                        System.out.println(className);
                        //System.out.println(individualTimes.next());
                        double startTime = individualTimes.nextDouble();
                        System.out.println(startTime);
                        double endTime = individualTimes.nextDouble();
                        System.out.println(endTime);
                        String location = individualTimes.next();
                        System.out.println(location);
                        String teacher = individualTimes.next();
                        System.out.println(teacher);
                        //System.out.println(individualTimes.next());

                        boolean mon;
                        boolean tue;
                        boolean wed;
                        boolean thu;
                        boolean fri;

                        if(individualTimes.next().equalsIgnoreCase("mon"))
                        {
                            mon = true; 
                            System.out.println(mon);
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
                        System.out.println(tue);
                        }
                        if(individualTimes.next().equalsIgnoreCase("wed"))
                        {
                            wed = true;
                        System.out.println(wed);
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
                        System.out.println(thu);
                        }
                        if(individualTimes.hasNext())
                        {
                            if(individualTimes.next().equalsIgnoreCase("fri"))
                            {
                                    fri = true;
                                System.out.println(fri);
                            }
                            else
                            {
                                    fri = false;
                            }
                        }
                        else
                        {
                                fri = false;
                            System.out.println(fri);
                        }
                        Class pendingClass = new Class(className, startTime, endTime, location, teacher, mon, tue, wed, thu, fri);
                        optionList.add(pendingClass);
                        
    
                        
                        //System.out.println(individualTimes.next());
                    }
                    
                }
            }
            // if(!optionList.isEmpty())
            //     {
            //         classList.add(optionList);
            //         optionList.clear();
            //     }
            System.out.println(optionList.size());
            //System.out.println(classList.size());
    }


            //METHODS
    // public ArrayList<Class> getClasses(int index)
    // {
    //     return this.classList.get(index);
    // } 

    public void printSchedules()        //Rewrite this....
    {
        ArrayList<Class> class1;
        ArrayList<Class> class2;
        ArrayList<Class> class3;
        ArrayList<Class> class4;
        ArrayList<Class> class5;
        ArrayList<Class> class6;
        ArrayList<Class> class7;
        int i = classList.size();
        if(!classList.isEmpty())
        {
            class1 = (classList.get(0));
            classList.remove(0);
        }
        if(!classList.isEmpty())
        {
            class2 = (classList.get(0));
            classList.remove(0);
        }

        if(!classList.isEmpty())
        {
            class3 = (classList.get(0));
            classList.remove(0);
        }

        if(!classList.isEmpty())
        {
            class4 = (classList.get(0));
            classList.remove(0);
        }

        if(!classList.isEmpty())
        {
            class5 = (classList.get(0));
            classList.remove(0);
        }

        if(!classList.isEmpty())
        {
            class6 = (classList.get(0));
            classList.remove(0);
        }

        if(!classList.isEmpty())
        {
            class7 = (classList.get(0));
            classList.remove(0);
        }
        for (; i< classList.size(); i++)
        {
            


        }
            //ArrayList<Class> pendingClass = classList.get(1);
            // for(int j = 0; j < pendingClass.size(); j++)
            // {




            // } 

        
    











        
    }


}
