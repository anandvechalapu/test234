·       Ability to open the calendar and select the dates.
·       Calendar should be closed after selecting the dates.
·       Date, month and year should be displayed as per selection done by the user.

@SpringBootApplication
public class SelectingDatesApplication {
 
   public static void main(String[] args) {
      SpringApplication.run(SelectingDatesApplication.class, args);
   }
}

@Controller
public class DateController {
 
   @Autowired
   private DateService dateService;
   
   @GetMapping("/selectDates")
   public String selectDates(Model model) {
      // Getting calendar data
      Calendar calendar = dateService.getCalendarData();
      model.addAttribute("calendar", calendar);
      return "selectDates";
   }
   
   @PostMapping("/selectDates")
   public String selectDates(@RequestParam("date") String date, Model model) {
      // Getting calendar data
      Calendar calendar = dateService.getCalendarData();
      model.addAttribute("calendar", calendar);
      
      // Getting date from selection
      Date selectedDate = dateService.getDateFromSelection(date);
      model.addAttribute("selectedDate", selectedDate);
      return "selectDates";
   }
}

@Service
public class DateService {
 
   @Autowired
   private DateRepository dateRepository;
   
   public Calendar getCalendarData() {
      return dateRepository.getCalendarData();
   }
   
   public Date getDateFromSelection(String date) {
      return dateRepository.getDateFromSelection(date);
   }
}

@Repository
public class DateRepository {
 
   public Calendar getCalendarData() {
      // Code to get calendar data
   }
   
   public Date getDateFromSelection(String date) {
      // Code to get date from selection
   }
}