package be.kdg.prog4.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    public String addUser(@RequestParam String newusername, @RequestParam String newpassword, Model model) {
        System.out.println("controller: addUser()");
        favoriteService.addUser("root", "rootpasswd", newusername, newpassword);
        return "root";
    }
}
