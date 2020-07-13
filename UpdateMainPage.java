 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieTicketBookingSystem;  

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 *
 * @author Mark
 */
public class UpdateMainPage {
    private MainPage mainPage;
    private AllMovies allMovies; 
    //private   Listener listener = new Listener();

    UpdateMainPage(AllMovies allMoviesl, MainPage mainPage) {
        this.mainPage = mainPage;
        this.allMovies = allMoviesl;
        this.mainPage.setMovieList(this.allMovies.getMovieDate());
        this.mainPage.setMovieListTime(this.allMovies.getMovieTime());
        this.mainPage.setMovieListAge(this.allMovies.getMovieRate());
        //1
        this.mainPage.DateListener(new DateListener());
        this.mainPage.TimeListener(new TimeListener());
        this.mainPage.RateListener(new RateListener());
        //2
        this.mainPage.PreviousButtonListener(new PreviousButtonListener());
        this.mainPage.NextButtonListener(new NextButtonListener());
        //3
        this.mainPage.CheckoutButtonListener(new CheckoutButtonListener());
        setUpDisplay(); 
    }
    
    private void setUpDisplay(){
        try{
            if(allMovies.hasMovie()){
                MovieStructure movieStructure = allMovies.getAllMovie();
                mainPage.setIndex(movieStructure.getMovieIndex());
                mainPage.settitle(movieStructure.getMovieTitle());
                mainPage.setActor(movieStructure.getMovieActor());
                mainPage.setRate(movieStructure.getMvieRate());
                mainPage.setStatus(movieStructure.getMovieStatus());  
            }else {
                mainPage.setIndex("Fail to get");
                mainPage.settitle("Fail to get");
                mainPage.setActor("Fail to get");
                mainPage.setRate("Fail to get");
                mainPage.setStatus("Fail to get");
            }
        } catch (Error ex){
                System.out.println(ex);
                mainPage.ErrorMessafe("No more movies can select");
        }
    }
    /////////////////////1
    class DateListener implements ItemListener{
        @Override   
        public void itemStateChanged(ItemEvent ItemEvent){
            if(ItemEvent.getStateChange() == ItemEvent.SELECTED){
                String selectDate = ItemEvent.getItem().toString();
                allMovies.selectDate(selectDate);
                setUpDisplay();
            }
        }
    }
 
    class TimeListener implements ItemListener{
    @Override   
        public void itemStateChanged(ItemEvent ItemEvent){
            if(ItemEvent.getStateChange() == ItemEvent.SELECTED){
                String selectTime = ItemEvent.getItem().toString();
                allMovies.selectTime(selectTime);
                setUpDisplay();
            }
        }
    }
    
    class RateListener implements ItemListener{ 
        @Override   
        public void itemStateChanged(ItemEvent ItemEvent){
            if(ItemEvent.getStateChange() == ItemEvent.SELECTED){
                String selectRate = ItemEvent.getItem().toString();
                allMovies.selectRate(selectRate);
                setUpDisplay();
            }
        }
    }
    //////////////////////2
    class PreviousButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ItemEvent){
            try{
                //get prevs one
                allMovies.prevContract();
            }catch(Exception ex){
                System.out.println(ex);
                mainPage.ErrorMessafe("No more movies can select");
            }
            setUpDisplay();
        }
    }
   
    class NextButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ItemEvent){
            try{
                //get next one
                allMovies.nextMovie();
            }catch(Exception ex){
                System.out.println(ex);
                mainPage.ErrorMessafe("No more movies can select");
            }
            setUpDisplay();
        }
    }
    /////////////3
    class CheckoutButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (!mainPage.getCountChildren().equals("0") && (mainPage.getmRateId().equals("Restrict"))){
                mainPage.ErrorMessafe("Children can not watch Restrict movie."); 
            }
            
            if(mainPage.getMovieStatus().equals("Sold Out")){
                mainPage.ErrorMessafe("All movie ticket already sold out");
            }
            
            if(mainPage.getMovieStatus().equals("Cancelled")){
                mainPage.ErrorMessafe("This movie is cancelled showing");
            }else {
                MovieStructure movieStructure = allMovies.getAllMovie();
                movieStructure.setCountChildren(mainPage.getCountChildren());
                movieStructure.setCountAdult(mainPage.getCountAdult());
                movieStructure.setCountSenior(mainPage.getCountSenior());
                CheckOutPage CheckOutPage = new CheckOutPage(movieStructure); 
                CheckOutPage.setVisible(true);
                setUpDisplay();
            }
        }
    }
}
