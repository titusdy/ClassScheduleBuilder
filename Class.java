import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class
 */
public class Class {

    //FIELDS
    private String className;
    private String teacher;
    private String location;
    private double startTime;
    private double endTime;
    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;



    //CONSTRUCTORS
    // public Class() throws FileNotFoundException
    // {
    //     File allClasses = new File("classNames.csv");
    //     Scanner classFileScanner = new Scanner(allClasses);
    //     while (classFileScanner.hasNext())
    //     {
    //         String uploadingClass = (classFileScanner.nextLine());
    //         File eachClass = new File(uploadingClass);
    //         Scanner eachClassScanner = new Scanner(eachClass);
    //         while (eachClassScanner.hasNext())
    //         {
    //             Scanner individualTimes = new Scanner(eachClassScanner.nextLine());
    //             individualTimes.useDelimiter(",");
    //             while (individualTimes.hasNext())
    //             {
    //                 this.className = individualTimes.next();
    //                 this.startTime = individualTimes.nextDouble();
    //                 this.endTime = individualTimes.nextDouble();
    //                 this.location = individualTimes.next();
    //                 this.teacher = individualTimes.next();
    //                 if(individualTimes.next()==null)
    //                 this.mon = false;
    //                 else
    //                 this.mon = true;
    //                 if(individualTimes.next()==null)
    //                 this.tue = false;
    //                 else
    //                 this.tue = true;
    //                 if(individualTimes.next()==null)
    //                 this.wed = false;
    //                 else
    //                 this.wed = true;
    //                 if(individualTimes.next()==null)
    //                 this.thu = false;
    //                 else
    //                 this.thu = true;
    //                 if(individualTimes.next()==null)
    //                 this.fri = false;
    //                 else
    //                 this.fri = true;
                    




    //                 //System.out.println(individualTimes.next());
    //             }
        //     }
            
        // }





    //}
    public Class(String className, double startTime, double endTime, String location, String teacher, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri)
    {
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.teacher = teacher;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
    }



    //METHODS
    public double getStartTime()
    {
        return this.startTime;
    }

    public double getEndTime()
    {
        return this.endTime;
    }

    public String getTeacher()
    {
        return this.teacher;
    }
    
    public String getLocation()
    {
        return this.location;
    }

    public String getClassName()
    {
        return this.className;
    }
    
    public boolean onMon()
   {
       return this.mon;
   }

    public boolean onTue()
    {
        return this.tue;
    }
    
     public boolean onWed()
    {
        return this.wed;
    }

     public boolean onThu()
    {
        return this.thu;
    }

     public boolean onFri()
    {
        return this.fri;
    }


    public boolean compareTime(Class class2)
    {
        boolean works = true;
        if (startTime > class2.getStartTime() && startTime < class2.getEndTime())
        {
            works = false;
        }
        else if (endTime > class2.getStartTime() && startTime < class2.getEndTime())
        {
            works = false;
        }
        else if (startTime < class2.getStartTime() && endTime > class2.getEndTime())
        {
            works = false;
        }

        return works;
    }

    public static boolean compare(Class class1, Class class2)
    {
        boolean works = true;
        if(class1.onMon() && class2.onMon())
        {
            works = class1.compareTime(class2);
        }
        if(class1.onTue() && class2.onTue())
        {
            works = class1.compareTime(class2);
        }
        if(class1.onWed() && class2.onWed())
        {
            works = class1.compareTime(class2);
        }
        if(class1.onThu() && class2.onThu())
        {
            works = class1.compareTime(class2);
        }
        if(class1.onFri() && class2.onFri())
        {
            works = class1.compareTime(class2);
        }

        return works;
    }

}