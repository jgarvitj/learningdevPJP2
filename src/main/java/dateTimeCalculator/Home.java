/**
 * 
 */
package dateTimeCalculator;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import inputOutput.History;
import model.AboutTodayModel;
import model.CalculateModel;
import model.LanguageModel;

/**
 * @author Garvit Jain
 *
 */

@RestController
public class Home {

	@GetMapping(path = "/home")
	public String init() {
		return "Date Calculator";
	}

	@GetMapping(path = "/calculate")
	public String showCalculate(Model model) {
		return "show Calculator form";
	}

	@PostMapping(path = "/calculate")
	public String selectChoice(@ModelAttribute("CalculateModel") CalculateModel calculateModel) {
		return "d";
	}

	@GetMapping(path = "/aboutToday")
	public String showAboutToday(Model model) {
		return "Show About Today";
	}

	@PostMapping(path = "/aboutToday")
	public String selectChoice(@ModelAttribute("AboutTodayModel") AboutTodayModel abouttodayModel) {
		return "d";
	}

	@GetMapping(path = "/language")
	public String showLanguage(Model model) {
		model.addAttribute("Language", "en-US");
		return "SelectLanguage";
	}

	@PostMapping(path = "/language")
	public String selectLanguage(@ModelAttribute("LanguageModel") LanguageModel languageModel) {
		return "en-US";
	}

	@GetMapping(path = "/history")
	public String getSessionHistory() {
		return History.getSessionHistory();
	}

}
