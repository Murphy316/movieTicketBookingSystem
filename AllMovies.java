/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieTicketBookingSystem;    

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.SortedSet;
import java.util.TreeSet;
//import index from MovieStructure
//import static movieTicketBookingSystem.MovieStructure.index;
//import static movieTicketBookingSystem.MovieStructure.date;
//import static movieTicketBookingSystem.MovieStructure.time;
//import static movieTicketBookingSystem.MovieStructure.title;
//import static movieTicketBookingSystem.MovieStructure.actor;
//import static movieTicketBookingSystem.MovieStructure.rate;
//import static movieTicketBookingSystem.MovieStructure.status;
import static movieTicketBookingSystem.MovieStructure.total;
/**
 *
 * @author Mark
 */
public class AllMovies {
    private static final String fileName="C:\\Users\\Mark\\Desktop\\ICS125PLA Submit\\submit\\pla\\src\\movieTicketBookingSystem\\MovieList.txt";
    private ArrayList<MovieStructure> movieStructure = new ArrayList<MovieStructure>(); 
    private ArrayList<MovieStructure> allMovieData;
    private int totalMovie = 0;   
    private SortedSet<String> movieDate = new TreeSet<>(); 
    private SortedSet<String> movieTime = new TreeSet<>();
    private SortedSet<String> movieRate = new TreeSet<>();
     
    public String[] getMovieDate(){
        String[] a;
        a = movieDate.toArray(new String[movieDate.size()]);
        return a;
    }
    
    public String[] getMovieTime(){
        String[] a;
        a = movieTime.toArray(new String[movieTime.size()]);
        return a;
    }
    
    public String[] getMovieRate(){
        String[] a;
        a = movieRate.toArray(new String[movieRate.size()]);
        return a;
    } 
    
    public void selectDate(String avoidSelect){
        movieStructure = new ArrayList<>(allMovieData);
        //map function
        movieStructure.removeIf(s -> !s.getMovieDate().contains(avoidSelect));
        totalMovie = 0;
    }
     public void selectTime(String avoidSelect){
        movieStructure = new ArrayList<>(allMovieData);
        //map function
        movieStructure.removeIf(s -> !s.getMovieTime().contains(avoidSelect));
        totalMovie = 0;
    }
   public void selectRate(String avoidSelect){
        movieStructure = new ArrayList<>(allMovieData);
        //map function
        movieStructure.removeIf(s -> !s.getMvieRate().contains(avoidSelect));
        totalMovie = 0;
    }
    
    public AllMovies(){
        try(
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
                String[] next;
                String movieList;

                String index;
                String date;
                String time;
                String title;
                String actor;
                String rate;
                String status;
                //should loop 12 times
                while((movieList = bufferedReader.readLine()) != null){
                    next = movieList.split(",", total );
                    index = next[MovieStructure.index ]; 
                    date = next[MovieStructure.date  ]; 
                    time = next[MovieStructure.time  ]; 
                    title = next[MovieStructure.title  ]; 
                    actor = next[MovieStructure.actor  ]; 
                    rate = next[MovieStructure.rate  ]; 
                    status = next[MovieStructure.status  ]; 
                    //all data here
                    MovieStructure dataMovie = new MovieStructure(index, date, time, title, actor, rate, status);
                    movieStructure.add(dataMovie);
                    movieDate.add(date);
                    movieTime.add(time);
                    movieRate.add(rate);
                }
                allMovieData = new ArrayList<>(movieStructure);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
    
    public boolean hasMovie(){        
        return movieStructure.size() > 0;
    }
    
    public MovieStructure getAllMovie(){
        return movieStructure.get(totalMovie);
    }
    
    public int getAllMovieSize(){
        return movieStructure.size();
    }   
  
    public int getCurrentMovieNum(){
        return totalMovie;
    }
    
    public void nextMovie(){
        if (movieStructure.get(totalMovie + 1) != null){
            totalMovie++;
        }        
    }
    
    public void prevContract(){
        if (movieStructure.get(totalMovie - 1) != null){
            totalMovie--;
        }   
    }
    
  
}
