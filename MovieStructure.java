/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieTicketBookingSystem;
/**
 *
 * @author Mark
 */
class Main {
    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        //allMovies: read the file and get all movies put in arraylist
        AllMovies allMovies = new AllMovies(); 
        //will using allmovies to update main page
        UpdateMainPage updateMainPage = new UpdateMainPage(allMovies, mainPage); 
        //main page must be visible
        mainPage.setVisible(true);
    }
    
}

public class MovieStructure {
    //declear
    private final String Index;//
    private final String movieDate;//
    private final String movieTime;//
    
    private final String movieTitle;//
    private final String movieActors;//
    private final String movieRate;//
    private final String movieAvailableStatus;//
    
    private String numChild;//
    private String numSenior;//
    private String numAdult;//
    
    //must follow the order inside file
    public static final int index = 0;
    public static final int date = 1;
    public static final int time = 2;
    public static final int title = 3;
    public static final int actor = 4;
    public static final int rate = 5;
    public static final int status = 6;   
    public static final int total = 12;
    
    void MovieStructure(){
    
    }
    //constructor
    public MovieStructure(String Index, String movieDate, String movieTime, String movieTitle, String movieActors, String movieRate, String movieAvailableStatus){
        this.Index = Index;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.movieTitle = movieTitle;
        this.movieActors = movieActors;
        this.movieRate = movieRate;
        this.movieAvailableStatus = movieAvailableStatus;
    }
    
    //getter
    public String getMovieIndex(){       
        return Index;    
    }  
    
    public String getMovieDate(){       
        return movieDate;    
    }  
    
    public String getMovieTime(){      
        return movieTime;    
    }
    
    public String getMovieTitle(){      
        return movieTitle;    
    }
    
    public String getMovieActor(){      
        return movieActors;    
    }
    
    public String getMvieRate(){      
        return movieRate;    
    }
    
    public String getMovieStatus(){      
        return movieAvailableStatus;    
    }
    
    public String getNumChild(){     
        return numChild;    
    }
    
    public String getNumSenior(){      
        return numSenior;    
    }
    
    public String getNumAdult(){      
        return numAdult;    
    }
    
    public void setCountChildren(String numChild){         
        this.numChild = numChild;                    
    }
    
    public void setCountAdult(String numAdult){         
        this.numAdult = numAdult;                    
    }
    
    public void setCountSenior(String numSenior){         
        this.numSenior = numSenior;                    
    }
    
}

