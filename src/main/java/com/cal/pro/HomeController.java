package com.cal.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DB;
import util.UserPro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Murat Çelik Pegamis
 */
@Controller
public class HomeController {

    DB db = new DB();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("data", dataResult());
        return "home";
    }

    public List<UserPro> dataResult() {
        List<UserPro> ls = new ArrayList<UserPro>();

        try {
            String query = "SELECT * FROM `users`";
            PreparedStatement pre = db.connect(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String uname = rs.getString("uname");
                String usurname = rs.getString("usurname");
                String umail = rs.getString("umail");
                String upassword = rs.getString("upassword");

                UserPro us = new UserPro();
                us.setUid(uid);
                us.setUname(uname);
                us.setUsurname(usurname);
                us.setUmail(umail);
                us.setUpassword(upassword);

                ls.add(us);
            }
        } catch (Exception e) {
            System.err.println("Select error: " + e);
        }
        return ls;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String insert() {

        try {
            String query = "INSERT INTO `users`(`uid`, `uname`, `usurname`, `umail`, `upassword`) VALUES (NULL,?,?,?,?)";
            PreparedStatement pre = db.connect(query);
            pre.setString(1, "Murat");
            pre.setString(2, "Celik");
            pre.setString(3, "muratcelik11@gmail.com");
            pre.setString(4, "7777");
            pre.executeUpdate();
        } catch (Exception e) {
            System.err.println("insert error : " + e);
        }
        return "redirect:/";
    }
}
